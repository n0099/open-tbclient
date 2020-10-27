package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class w extends b<bw> implements com.baidu.tieba.a.e {
    private bw agx;
    private String ahu;
    private final View fKv;
    private HeadImageView hLh;
    private ConstrainImageGroup hSj;
    private TextView hTY;
    private TextView hTZ;
    private TextView hUa;
    private u hUb;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hLh = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hLh.setIsRound(true);
        this.hLh.setDefaultResource(R.drawable.pic_head_topic);
        this.hTY = (TextView) view.findViewById(R.id.card_topic_name);
        this.hUa = (TextView) view.findViewById(R.id.card_thread_title);
        this.hTZ = (TextView) view.findViewById(R.id.card_reply_time);
        this.hSj = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.fKv = view.findViewById(R.id.card_divider_line);
        this.hSj.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.y(1.0d);
        this.hSj.setImageProcessor(fVar);
        this.hSj.setSinglePicUseStyleV10(true);
        this.hSj.setFromCDN(true);
        this.hSj.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hLh.invalidate();
        ap.setViewTextColor(this.hTY, R.color.cp_cont_b);
        ap.setViewTextColor(this.hTZ, R.color.cp_cont_d);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fKv, R.color.cp_bg_line_c);
        this.hSj.onChangeSkinType();
        this.hLh.setDefaultBgResource(i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_hot_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        if (bwVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.agx = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bwVar.bka() != null) {
            this.hTY.setText(bwVar.bka().getName_show());
        }
        this.hTZ.setText(at.getFormatTime(bwVar.bjT() * 1000));
        String str = bwVar.blF() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bwVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.hUa.setText(spannableStringBuilder);
        ArrayList<MediaData> bkj = bwVar.bkj();
        if (com.baidu.tbadk.core.k.bhh().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bkj) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bkj.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bkj, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList) > 0) {
                this.hSj.setVisibility(0);
                this.hSj.setImageMediaList(arrayList);
            } else {
                this.hSj.setVisibility(8);
            }
        } else {
            this.hSj.setVisibility(8);
        }
        n.a(this.hUa, this.agx.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agx != null) {
            if (cls() != null) {
                cls().a(view, (View) this.agx, (Object) this.hUb);
            }
            if (view == getView()) {
                n.II(this.agx.getTid());
                n.a(this.hUa, this.agx.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
                clR();
            }
        }
    }

    private void clR() {
        if (this.agx != null && this.agx.bka() != null && this.agx.bka().getName_show() != null) {
            long fid = this.agx.getFid();
            if (this.agx.eAJ != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.agx.eAJ.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.ks(true) && !com.baidu.tbadk.plugins.b.bAn()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.agx.bka().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.agx.blI(), this.agx.blJ(), com.baidu.adp.lib.f.b.toLong(this.agx.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.boR().b(this.mPageContext, new String[]{this.agx.blK()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hSj != null) {
            this.hSj.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hSj != null) {
            this.hSj.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }
}

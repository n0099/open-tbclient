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
    private final View fQl;
    private HeadImageView hRe;
    private ConstrainImageGroup hYg;
    private TextView hZV;
    private TextView hZW;
    private TextView hZX;
    private u hZY;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hRe = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hRe.setIsRound(true);
        this.hRe.setDefaultResource(R.drawable.pic_head_topic);
        this.hZV = (TextView) view.findViewById(R.id.card_topic_name);
        this.hZX = (TextView) view.findViewById(R.id.card_thread_title);
        this.hZW = (TextView) view.findViewById(R.id.card_reply_time);
        this.hYg = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.fQl = view.findViewById(R.id.card_divider_line);
        this.hYg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.y(1.0d);
        this.hYg.setImageProcessor(fVar);
        this.hYg.setSinglePicUseStyleV10(true);
        this.hYg.setFromCDN(true);
        this.hYg.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hRe.invalidate();
        ap.setViewTextColor(this.hZV, R.color.cp_cont_b);
        ap.setViewTextColor(this.hZW, R.color.cp_cont_d);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fQl, R.color.cp_bg_line_c);
        this.hYg.onChangeSkinType();
        this.hRe.setDefaultBgResource(i);
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
        if (bwVar.bmA() != null) {
            this.hZV.setText(bwVar.bmA().getName_show());
        }
        this.hZW.setText(at.getFormatTime(bwVar.bmt() * 1000));
        String str = bwVar.bof() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bwVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.hZX.setText(spannableStringBuilder);
        ArrayList<MediaData> bmJ = bwVar.bmJ();
        if (com.baidu.tbadk.core.k.bjH().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bmJ) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bmJ.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bmJ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList) > 0) {
                this.hYg.setVisibility(0);
                this.hYg.setImageMediaList(arrayList);
            } else {
                this.hYg.setVisibility(8);
            }
        } else {
            this.hYg.setVisibility(8);
        }
        n.a(this.hZX, this.agx.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agx != null) {
            if (cnT() != null) {
                cnT().a(view, (View) this.agx, (Object) this.hZY);
            }
            if (view == getView()) {
                n.IZ(this.agx.getTid());
                n.a(this.hZX, this.agx.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
                cos();
            }
        }
    }

    private void cos() {
        if (this.agx != null && this.agx.bmA() != null && this.agx.bmA().getName_show() != null) {
            long fid = this.agx.getFid();
            if (this.agx.eGy != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.agx.eGy.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.kB(true) && !com.baidu.tbadk.plugins.b.bCM()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.agx.bmA().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.agx.boi(), this.agx.boj(), com.baidu.adp.lib.f.b.toLong(this.agx.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.brr().b(this.mPageContext, new String[]{this.agx.bok()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYg != null) {
            this.hYg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYg != null) {
            this.hYg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }
}

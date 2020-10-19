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
public class v extends b<bw> implements com.baidu.tieba.a.e {
    private bw agw;
    private String aht;
    private final View fCa;
    private ConstrainImageGroup hFM;
    private TextView hHB;
    private TextView hHC;
    private TextView hHD;
    private t hHE;
    private HeadImageView hyL;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hyL = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hyL.setIsRound(true);
        this.hyL.setDefaultResource(R.drawable.pic_head_topic);
        this.hHB = (TextView) view.findViewById(R.id.card_topic_name);
        this.hHD = (TextView) view.findViewById(R.id.card_thread_title);
        this.hHC = (TextView) view.findViewById(R.id.card_reply_time);
        this.hFM = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.fCa = view.findViewById(R.id.card_divider_line);
        this.hFM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.x(1.0d);
        this.hFM.setImageProcessor(fVar);
        this.hFM.setSinglePicUseStyleV10(true);
        this.hFM.setFromCDN(true);
        this.hFM.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hyL.invalidate();
        ap.setViewTextColor(this.hHB, R.color.cp_cont_b);
        ap.setViewTextColor(this.hHC, R.color.cp_cont_d);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fCa, R.color.cp_bg_line_c);
        this.hFM.onChangeSkinType();
        this.hyL.setDefaultBgResource(i);
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
        this.agw = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bwVar.bih() != null) {
            this.hHB.setText(bwVar.bih().getName_show());
        }
        this.hHC.setText(at.getFormatTime(bwVar.bia() * 1000));
        String str = bwVar.bjM() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bwVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.hHD.setText(spannableStringBuilder);
        ArrayList<MediaData> biq = bwVar.biq();
        if (com.baidu.tbadk.core.k.bfo().isShowImages() && com.baidu.tbadk.core.util.y.getCount(biq) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < biq.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(biq, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList) > 0) {
                this.hFM.setVisibility(0);
                this.hFM.setImageMediaList(arrayList);
            } else {
                this.hFM.setVisibility(8);
            }
        } else {
            this.hFM.setVisibility(8);
        }
        m.a(this.hHD, this.agw.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agw != null) {
            if (cil() != null) {
                cil().a(view, (View) this.agw, (Object) this.hHE);
            }
            if (view == getView()) {
                m.Ij(this.agw.getTid());
                m.a(this.hHD, this.agw.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
                ciK();
            }
        }
    }

    private void ciK() {
        if (this.agw != null && this.agw.bih() != null && this.agw.bih().getName_show() != null) {
            long fid = this.agw.getFid();
            if (this.agw.esj != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.agw.esj.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.kf(true) && !com.baidu.tbadk.plugins.b.byu()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.agw.bih().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.agw.bjP(), this.agw.bjQ(), com.baidu.adp.lib.f.b.toLong(this.agw.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.bmY().b(this.mPageContext, new String[]{this.agw.bjR()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hFM != null) {
            this.hFM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hFM != null) {
            this.hFM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }
}

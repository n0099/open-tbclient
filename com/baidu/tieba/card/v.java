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
/* loaded from: classes15.dex */
public class v extends b<bw> implements com.baidu.tieba.a.e {
    private bw afL;
    private String agJ;
    private final View fmI;
    private HeadImageView hcR;
    private ConstrainImageGroup hjP;
    private TextView hlE;
    private TextView hlF;
    private TextView hlG;
    private t hlH;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View view = getView();
        view.setOnClickListener(this);
        this.mPageContext = tbPageContext;
        this.hcR = (HeadImageView) view.findViewById(R.id.topic_icon);
        this.hcR.setIsRound(true);
        this.hcR.setDefaultResource(R.drawable.pic_head_topic);
        this.hlE = (TextView) view.findViewById(R.id.card_topic_name);
        this.hlG = (TextView) view.findViewById(R.id.card_thread_title);
        this.hlF = (TextView) view.findViewById(R.id.card_reply_time);
        this.hjP = (ConstrainImageGroup) view.findViewById(R.id.card_img_layout);
        this.fmI = view.findViewById(R.id.card_divider_line);
        this.hjP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.u(1.0d);
        this.hjP.setImageProcessor(fVar);
        this.hjP.setSinglePicUseStyleV10(true);
        this.hjP.setFromCDN(true);
        this.hjP.setClickable(false);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hcR.invalidate();
        ap.setViewTextColor(this.hlE, R.color.cp_cont_b);
        ap.setViewTextColor(this.hlF, R.color.cp_cont_d);
        ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
        ap.setBackgroundColor(this.fmI, R.color.cp_bg_line_c);
        this.hjP.onChangeSkinType();
        this.hcR.setDefaultBgResource(i);
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
        this.afL = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this);
        }
        if (bwVar.beE() != null) {
            this.hlE.setText(bwVar.beE().getName_show());
        }
        this.hlF.setText(at.getFormatTime(bwVar.bex() * 1000));
        String str = bwVar.bgj() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) bwVar.B(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), 0, str.length(), 33);
        this.hlG.setText(spannableStringBuilder);
        ArrayList<MediaData> beN = bwVar.beN();
        if (com.baidu.tbadk.core.k.bbM().isShowImages() && com.baidu.tbadk.core.util.y.getCount(beN) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < beN.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(beN, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList) > 0) {
                this.hjP.setVisibility(0);
                this.hjP.setImageMediaList(arrayList);
            } else {
                this.hjP.setVisibility(8);
            }
        } else {
            this.hjP.setVisibility(8);
        }
        m.a(this.hlG, this.afL.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afL != null) {
            if (cbA() != null) {
                cbA().a(view, (View) this.afL, (Object) this.hlH);
            }
            if (view == getView()) {
                m.GZ(this.afL.getTid());
                m.a(this.hlG, this.afL.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
                cbZ();
            }
        }
    }

    private void cbZ() {
        if (this.afL != null && this.afL.beE() != null && this.afL.beE().getName_show() != null) {
            long fid = this.afL.getFid();
            if (this.afL.edT != null) {
                fid = com.baidu.adp.lib.f.b.toLong(this.afL.edT.id, 0L);
            }
            if (com.baidu.tbadk.plugins.b.jG(true) && !com.baidu.tbadk.plugins.b.buG()) {
                HotTopicActivityConfig createNormalConfig = new HotTopicActivityConfig(getContext()).createNormalConfig("", this.afL.beE().getName_show() + "", "3");
                createNormalConfig.setExtra(fid, this.afL.bgm(), this.afL.bgn(), com.baidu.adp.lib.f.b.toLong(this.afL.getTid(), 0L));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                return;
            }
            be.bju().b(this.mPageContext, new String[]{this.afL.bgo()});
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hjP != null) {
            this.hjP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hjP != null) {
            this.hjP.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agJ = str;
    }
}

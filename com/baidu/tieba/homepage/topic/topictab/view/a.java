package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private TextView bFL;
    private TbImageView eEH;
    private LinearLayout fOI;
    private TextView fPT;
    private TextView fPU;
    private View fPV;
    private TopicPkView fPW;
    private ThreadGodReplyLayout fPX;
    private View fPY;
    private com.baidu.tieba.homepage.topic.topictab.b.a fPZ;
    private CellTopicLinearLayout fPs;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fPs = (CellTopicLinearLayout) view.findViewById(d.g.cell_topic_root);
        this.fPT = (TextView) view.findViewById(d.g.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(d.g.cell_topic_title);
        this.fPU = (TextView) view.findViewById(d.g.cell_topic_partake);
        this.bFL = (TextView) view.findViewById(d.g.cell_topic_des);
        this.fOI = (LinearLayout) view.findViewById(d.g.cell_topic_img_layout);
        this.eEH = (TbImageView) view.findViewById(d.g.cell_topic_img);
        this.fPV = view.findViewById(d.g.cell_topic_img_placeholder);
        this.fPW = (TopicPkView) view.findViewById(d.g.cell_topic_pk);
        this.fPX = (ThreadGodReplyLayout) view.findViewById(d.g.cell_topic_god_reply);
        this.fPY = view.findViewById(d.g.cell_topic_bottom_placeholder);
        ViewGroup.LayoutParams layoutParams = this.eEH.getLayoutParams();
        layoutParams.height = ((l.aO(getContext()) - l.h(getContext(), d.e.tbds88)) * 9) / 16;
        this.eEH.setLayoutParams(layoutParams);
        this.eEH.setRadius(l.h(this.mContext, d.e.tbds22));
        this.eEH.setConrers(15);
        this.fPs.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fPW.onChangeSkinType();
        this.fPX.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.fPT, d.C0277d.cp_cont_m);
            al.j(this.mTitleView, d.C0277d.cp_cont_b);
            al.j(this.fPU, d.C0277d.cp_cont_d);
            al.j(this.bFL, d.C0277d.cp_cont_f);
            this.eEH.setIsNight(this.mSkinType == 1);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.cell_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topictab.b.a aVar) {
        if (aVar != null) {
            this.fPZ = aVar;
            this.fPT.setText(String.valueOf(aVar.index));
            if (aVar.index == 1) {
                al.k(this.fPT, d.f.topic_rank_one_bg);
            } else if (aVar.index == 2) {
                al.k(this.fPT, d.f.topic_rank_two_bg);
            } else if (aVar.index == 3) {
                al.k(this.fPT, d.f.topic_rank_three_bg);
            } else {
                al.k(this.fPT, d.f.topic_rank_other_bg);
            }
            String str = aVar.bAp;
            if (str.length() > 14) {
                str = str.substring(0, 13) + "...";
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(d.j.daily_topic_name), str));
            if (aVar.bAq == 0) {
                this.fPU.setText("NEW");
            } else {
                this.fPU.setText(String.format(this.mTbPageContext.getString(d.j.topic_partake_default), ap.as(aVar.bAq)));
            }
            this.bFL.setText(aVar.bAr);
            if (StringUtils.isNull(aVar.fOf)) {
                this.fOI.setVisibility(8);
                this.fPW.setUserColor(d.C0277d.cp_cont_d);
            } else {
                this.fOI.setVisibility(0);
                this.eEH.startLoad(aVar.fOf, 10, false);
                this.fPW.setUserColor(d.C0277d.cp_btn_a);
            }
            if (aVar.fPD == null) {
                this.fPV.setVisibility(8);
                this.fPW.setVisibility(8);
            } else {
                this.fPV.setVisibility(0);
                this.fPW.setVisibility(0);
                this.fPW.setData(aVar.fPD);
            }
            if (aVar.fPE == null) {
                this.fPX.setVisibility(8);
                return;
            }
            this.fPX.setVisibility(0);
            this.fPX.setData(aVar.fPE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13351").k("topic_id", this.fPZ.topicId).T("obj_locate", this.fPZ.index));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.fPZ.topicId)));
    }
}

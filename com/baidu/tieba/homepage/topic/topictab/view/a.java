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
    private TextView bFH;
    private TbImageView eFa;
    private LinearLayout fOV;
    private CellTopicLinearLayout fPF;
    private TextView fQg;
    private TextView fQh;
    private View fQi;
    private TopicPkView fQj;
    private ThreadGodReplyLayout fQk;
    private View fQl;
    private com.baidu.tieba.homepage.topic.topictab.b.a fQm;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fPF = (CellTopicLinearLayout) view.findViewById(d.g.cell_topic_root);
        this.fQg = (TextView) view.findViewById(d.g.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(d.g.cell_topic_title);
        this.fQh = (TextView) view.findViewById(d.g.cell_topic_partake);
        this.bFH = (TextView) view.findViewById(d.g.cell_topic_des);
        this.fOV = (LinearLayout) view.findViewById(d.g.cell_topic_img_layout);
        this.eFa = (TbImageView) view.findViewById(d.g.cell_topic_img);
        this.fQi = view.findViewById(d.g.cell_topic_img_placeholder);
        this.fQj = (TopicPkView) view.findViewById(d.g.cell_topic_pk);
        this.fQk = (ThreadGodReplyLayout) view.findViewById(d.g.cell_topic_god_reply);
        this.fQl = view.findViewById(d.g.cell_topic_bottom_placeholder);
        ViewGroup.LayoutParams layoutParams = this.eFa.getLayoutParams();
        layoutParams.height = ((l.aO(getContext()) - l.h(getContext(), d.e.tbds88)) * 9) / 16;
        this.eFa.setLayoutParams(layoutParams);
        this.eFa.setRadius(l.h(this.mContext, d.e.tbds22));
        this.eFa.setConrers(15);
        this.fPF.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fQj.onChangeSkinType();
        this.fQk.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.fQg, d.C0236d.cp_cont_m);
            al.j(this.mTitleView, d.C0236d.cp_cont_b);
            al.j(this.fQh, d.C0236d.cp_cont_d);
            al.j(this.bFH, d.C0236d.cp_cont_f);
            this.eFa.setIsNight(this.mSkinType == 1);
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
            this.fQm = aVar;
            this.fQg.setText(String.valueOf(aVar.index));
            if (aVar.index == 1) {
                al.k(this.fQg, d.f.topic_rank_one_bg);
            } else if (aVar.index == 2) {
                al.k(this.fQg, d.f.topic_rank_two_bg);
            } else if (aVar.index == 3) {
                al.k(this.fQg, d.f.topic_rank_three_bg);
            } else {
                al.k(this.fQg, d.f.topic_rank_other_bg);
            }
            String str = aVar.bAk;
            if (str.length() > 14) {
                str = str.substring(0, 13) + "...";
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(d.j.daily_topic_name), str));
            if (aVar.bAl == 0) {
                this.fQh.setText("NEW");
            } else {
                this.fQh.setText(String.format(this.mTbPageContext.getString(d.j.topic_partake_default), ap.as(aVar.bAl)));
            }
            this.bFH.setText(aVar.bAm);
            if (StringUtils.isNull(aVar.fOs)) {
                this.fOV.setVisibility(8);
                this.fQj.setUserColor(d.C0236d.cp_cont_d);
            } else {
                this.fOV.setVisibility(0);
                this.eFa.startLoad(aVar.fOs, 10, false);
                this.fQj.setUserColor(d.C0236d.cp_btn_a);
            }
            if (aVar.fPQ == null) {
                this.fQi.setVisibility(8);
                this.fQj.setVisibility(8);
            } else {
                this.fQi.setVisibility(0);
                this.fQj.setVisibility(0);
                this.fQj.setData(aVar.fPQ);
            }
            if (aVar.fPR == null) {
                this.fQk.setVisibility(8);
                return;
            }
            this.fQk.setVisibility(0);
            this.fQk.setData(aVar.fPR);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13351").k("topic_id", this.fQm.topicId).T("obj_locate", this.fQm.index));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.fQm.topicId)));
    }
}

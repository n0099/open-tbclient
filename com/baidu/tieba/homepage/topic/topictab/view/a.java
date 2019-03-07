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
    private CellTopicLinearLayout fPE;
    private TextView fQf;
    private TextView fQg;
    private View fQh;
    private TopicPkView fQi;
    private ThreadGodReplyLayout fQj;
    private View fQk;
    private com.baidu.tieba.homepage.topic.topictab.b.a fQl;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fPE = (CellTopicLinearLayout) view.findViewById(d.g.cell_topic_root);
        this.fQf = (TextView) view.findViewById(d.g.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(d.g.cell_topic_title);
        this.fQg = (TextView) view.findViewById(d.g.cell_topic_partake);
        this.bFH = (TextView) view.findViewById(d.g.cell_topic_des);
        this.fOV = (LinearLayout) view.findViewById(d.g.cell_topic_img_layout);
        this.eFa = (TbImageView) view.findViewById(d.g.cell_topic_img);
        this.fQh = view.findViewById(d.g.cell_topic_img_placeholder);
        this.fQi = (TopicPkView) view.findViewById(d.g.cell_topic_pk);
        this.fQj = (ThreadGodReplyLayout) view.findViewById(d.g.cell_topic_god_reply);
        this.fQk = view.findViewById(d.g.cell_topic_bottom_placeholder);
        ViewGroup.LayoutParams layoutParams = this.eFa.getLayoutParams();
        layoutParams.height = ((l.aO(getContext()) - l.h(getContext(), d.e.tbds88)) * 9) / 16;
        this.eFa.setLayoutParams(layoutParams);
        this.eFa.setRadius(l.h(this.mContext, d.e.tbds22));
        this.eFa.setConrers(15);
        this.fPE.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fQi.onChangeSkinType();
        this.fQj.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.fQf, d.C0236d.cp_cont_m);
            al.j(this.mTitleView, d.C0236d.cp_cont_b);
            al.j(this.fQg, d.C0236d.cp_cont_d);
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
            this.fQl = aVar;
            this.fQf.setText(String.valueOf(aVar.index));
            if (aVar.index == 1) {
                al.k(this.fQf, d.f.topic_rank_one_bg);
            } else if (aVar.index == 2) {
                al.k(this.fQf, d.f.topic_rank_two_bg);
            } else if (aVar.index == 3) {
                al.k(this.fQf, d.f.topic_rank_three_bg);
            } else {
                al.k(this.fQf, d.f.topic_rank_other_bg);
            }
            String str = aVar.bAk;
            if (str.length() > 14) {
                str = str.substring(0, 13) + "...";
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(d.j.daily_topic_name), str));
            if (aVar.bAl == 0) {
                this.fQg.setText("NEW");
            } else {
                this.fQg.setText(String.format(this.mTbPageContext.getString(d.j.topic_partake_default), ap.as(aVar.bAl)));
            }
            this.bFH.setText(aVar.bAm);
            if (StringUtils.isNull(aVar.fOs)) {
                this.fOV.setVisibility(8);
                this.fQi.setUserColor(d.C0236d.cp_cont_d);
            } else {
                this.fOV.setVisibility(0);
                this.eFa.startLoad(aVar.fOs, 10, false);
                this.fQi.setUserColor(d.C0236d.cp_btn_a);
            }
            if (aVar.fPP == null) {
                this.fQh.setVisibility(8);
                this.fQi.setVisibility(8);
            } else {
                this.fQh.setVisibility(0);
                this.fQi.setVisibility(0);
                this.fQi.setData(aVar.fPP);
            }
            if (aVar.fPQ == null) {
                this.fQj.setVisibility(8);
                return;
            }
            this.fQj.setVisibility(0);
            this.fQj.setData(aVar.fPQ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13351").k("topic_id", this.fQl.topicId).T("obj_locate", this.fQl.index));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.fQl.topicId)));
    }
}

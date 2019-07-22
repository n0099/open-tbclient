package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private TextView bOo;
    private TbImageView eZE;
    private RelativeLayout ezU;
    private CellTopicLinearLayout gmP;
    private LinearLayout.LayoutParams gnA;
    private com.baidu.tieba.homepage.topic.topictab.b.a gnB;
    private TextView gnr;
    private TextView gns;
    private RelativeLayout gnt;
    private View gnu;
    private TopicPkView gnv;
    private ThreadGodReplyLayout gnw;
    private View gnx;
    private TextView gny;
    private View gnz;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gmP = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.ezU = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.gnr = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.gns = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.bOo = (TextView) view.findViewById(R.id.cell_topic_des);
        this.gnt = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.eZE = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.gnu = view.findViewById(R.id.cell_topic_img_placeholder);
        this.gnv = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.gnw = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.gnx = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.gny = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.gnz = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.eZE.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.eZE.setLayoutParams(layoutParams);
        this.eZE.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.eZE.setConrers(15);
        this.gnA = (LinearLayout.LayoutParams) this.ezU.getLayoutParams();
        this.gmP.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gnv.onChangeSkinType();
        this.gnw.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.j(this.gnr, R.color.cp_cont_m);
            am.j(this.mTitleView, R.color.cp_cont_b);
            am.j(this.gns, R.color.cp_cont_d);
            if (this.gnB != null && this.gnB.from == 1) {
                am.j(this.bOo, R.color.cp_cont_b);
            } else {
                am.j(this.bOo, R.color.cp_cont_f);
            }
            this.eZE.setIsNight(this.mSkinType == 1);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.cell_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topictab.b.a aVar) {
        if (aVar != null) {
            this.gnB = aVar;
            if (aVar.from == 0) {
                this.gny.setVisibility(8);
                this.gnr.setVisibility(0);
                this.gns.setVisibility(0);
                this.gnr.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.k(this.gnr, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.k(this.gnr, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.k(this.gnr, R.drawable.topic_rank_three_bg);
                } else {
                    am.k(this.gnr, R.drawable.topic_rank_other_bg);
                }
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_index);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds16), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.bOo.setText(aVar.bIF);
                if (aVar.bIE == 0) {
                    this.gns.setText("NEW");
                } else {
                    this.gns.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.aH(aVar.bIE)));
                }
                if (aVar.gnc == null) {
                    this.gnw.setVisibility(8);
                } else {
                    this.gnw.setVisibility(0);
                    this.gnw.setData(aVar.gnc);
                }
            } else {
                this.gny.setVisibility(0);
                this.gnr.setVisibility(8);
                this.gns.setVisibility(8);
                this.gnw.setVisibility(8);
                this.gnA.setMargins(0, l.g(getContext(), R.dimen.tbds44), 0, 0);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_icon);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds30), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.mTitleView.setTextSize(0, l.g(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.bIF)) {
                    this.bOo.setVisibility(8);
                } else {
                    this.bOo.setVisibility(0);
                    this.bOo.setText(aVar.bIF);
                }
                am.f(this.bOo, R.color.cp_cont_b, 1);
            }
            String str = aVar.bID;
            if (str.length() > 14) {
                str = str.substring(0, 13) + "...";
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.glF)) {
                this.gnt.setVisibility(8);
                this.gnv.setUserColor(R.color.cp_cont_d);
            } else {
                this.gnt.setVisibility(0);
                this.eZE.startLoad(aVar.glF, 10, false);
                this.gnv.setUserColor(R.color.cp_btn_a);
            }
            if (aVar.gnb == null) {
                this.gnu.setVisibility(8);
                this.gnv.setVisibility(8);
                this.gnz.setVisibility(8);
                return;
            }
            this.gnu.setVisibility(0);
            this.gnv.setVisibility(0);
            this.gnv.setData(aVar.gnb);
            this.gnz.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13351").l("topic_id", this.gnB.topicId).P("obj_locate", this.gnB.index));
        if (this.gnB != null && this.gnB.from == 1) {
            TiebaStatic.log(new an("c13449"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.gnB.topicId)));
    }

    public CellTopicLinearLayout bxz() {
        return this.gmP;
    }
}

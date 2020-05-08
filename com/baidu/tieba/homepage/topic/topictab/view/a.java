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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int adz = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TbImageView gEN;
    private RelativeLayout gmP;
    private CellTopicLinearLayout hSO;
    private com.baidu.tieba.homepage.topic.topictab.b.a hTA;
    private TextView hTq;
    private TextView hTr;
    private RelativeLayout hTs;
    private View hTt;
    private TopicPkView hTu;
    private ThreadGodReplyLayout hTv;
    private View hTw;
    private TextView hTx;
    private View hTy;
    private LinearLayout.LayoutParams hTz;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hSO = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.gmP = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.hTq = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.hTr = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.hTs = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.gEN = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.hTt = view.findViewById(R.id.cell_topic_img_placeholder);
        this.hTu = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.hTv = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.hTw = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.hTx = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.hTy = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.gEN.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.gEN.setLayoutParams(layoutParams);
        this.gEN.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.gEN.setConrers(15);
        this.gEN.setPlaceHolder(3);
        this.hTz = (LinearLayout.LayoutParams) this.gmP.getLayoutParams();
        this.hSO.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hTu.onChangeSkinType();
        this.hTv.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hTq, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hTr, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.gEN.setIsNight(this.mSkinType == 1);
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
            this.hTA = aVar;
            if (aVar.from == 0) {
                this.hTx.setVisibility(8);
                this.hTq.setVisibility(0);
                this.hTr.setVisibility(0);
                this.hTq.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.hTq, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.hTq, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.hTq, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.hTq, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                au.a(this.mDescView, aVar.dqb, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, adz, true);
                if (aVar.dqa == 0) {
                    this.hTr.setText("NEW");
                } else {
                    this.hTr.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.dqa)));
                }
                if (aVar.hTb == null) {
                    this.hTv.setVisibility(8);
                } else {
                    this.hTv.setVisibility(0);
                    this.hTv.setData(aVar.hTb);
                }
            } else {
                this.hTx.setVisibility(0);
                this.hTq.setVisibility(8);
                this.hTr.setVisibility(8);
                this.hTv.setVisibility(8);
                this.hTz.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.dqb)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.dqb);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.dpZ;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.hRF)) {
                this.hTs.setVisibility(8);
                this.hTu.setUserColor(R.color.cp_cont_d);
            } else {
                this.hTs.setVisibility(0);
                this.gEN.setPlaceHolder(3);
                this.gEN.startLoad(aVar.hRF, 10, false);
                this.hTu.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.hTa == null) {
                this.hTt.setVisibility(8);
                this.hTu.setVisibility(8);
                this.hTy.setVisibility(8);
                return;
            }
            this.hTt.setVisibility(0);
            this.hTu.setVisibility(0);
            this.hTu.setData(aVar.hTa);
            this.hTy.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hTA != null && this.hTA.from != 1) {
            TiebaStatic.log(new an("c13351").t("topic_id", this.hTA.topicId).af("obj_locate", this.hTA.index));
        }
        if (this.hTA != null && this.hTA.from == 1) {
            TiebaStatic.log(new an("c13449").t("topic_id", this.hTA.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.hTA.topicId)));
    }

    public CellTopicLinearLayout cau() {
        return this.hSO;
    }
}

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
    private static final int Ky = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout fHg;
    private TbImageView fXg;
    private TextView hhM;
    private TextView hhN;
    private RelativeLayout hhO;
    private View hhP;
    private TopicPkView hhQ;
    private ThreadGodReplyLayout hhR;
    private View hhS;
    private TextView hhT;
    private View hhU;
    private LinearLayout.LayoutParams hhV;
    private com.baidu.tieba.homepage.topic.topictab.b.a hhW;
    private CellTopicLinearLayout hhk;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hhk = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.fHg = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.hhM = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.hhN = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.hhO = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.fXg = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.hhP = view.findViewById(R.id.cell_topic_img_placeholder);
        this.hhQ = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.hhR = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.hhS = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.hhT = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.hhU = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.fXg.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fXg.setLayoutParams(layoutParams);
        this.fXg.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.fXg.setConrers(15);
        this.fXg.setPlaceHolder(3);
        this.hhV = (LinearLayout.LayoutParams) this.fHg.getLayoutParams();
        this.hhk.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hhQ.onChangeSkinType();
        this.hhR.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hhM, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hhN, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.fXg.setIsNight(this.mSkinType == 1);
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
            this.hhW = aVar;
            if (aVar.from == 0) {
                this.hhT.setVisibility(8);
                this.hhM.setVisibility(0);
                this.hhN.setVisibility(0);
                this.hhM.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.hhM, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.hhM, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.hhM, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.hhM, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                au.a(this.mDescView, aVar.cQC, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, Ky, true);
                if (aVar.cQB == 0) {
                    this.hhN.setText("NEW");
                } else {
                    this.hhN.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.cQB)));
                }
                if (aVar.hhx == null) {
                    this.hhR.setVisibility(8);
                } else {
                    this.hhR.setVisibility(0);
                    this.hhR.setData(aVar.hhx);
                }
            } else {
                this.hhT.setVisibility(0);
                this.hhM.setVisibility(8);
                this.hhN.setVisibility(8);
                this.hhR.setVisibility(8);
                this.hhV.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.cQC)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.cQC);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.cQA;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.hgb)) {
                this.hhO.setVisibility(8);
                this.hhQ.setUserColor(R.color.cp_cont_d);
            } else {
                this.hhO.setVisibility(0);
                this.fXg.setPlaceHolder(3);
                this.fXg.startLoad(aVar.hgb, 10, false);
                this.hhQ.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.hhw == null) {
                this.hhP.setVisibility(8);
                this.hhQ.setVisibility(8);
                this.hhU.setVisibility(8);
                return;
            }
            this.hhP.setVisibility(0);
            this.hhQ.setVisibility(0);
            this.hhQ.setData(aVar.hhw);
            this.hhU.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hhW != null && this.hhW.from != 1) {
            TiebaStatic.log(new an("c13351").s("topic_id", this.hhW.topicId).X("obj_locate", this.hhW.index));
        }
        if (this.hhW != null && this.hhW.from == 1) {
            TiebaStatic.log(new an("c13449").s("topic_id", this.hhW.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.hhW.topicId)));
    }

    public CellTopicLinearLayout bPB() {
        return this.hhk;
    }
}

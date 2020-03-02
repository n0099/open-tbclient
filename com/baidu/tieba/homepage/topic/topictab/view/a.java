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
    private RelativeLayout fHi;
    private TbImageView fXi;
    private TextView hhO;
    private TextView hhP;
    private RelativeLayout hhQ;
    private View hhR;
    private TopicPkView hhS;
    private ThreadGodReplyLayout hhT;
    private View hhU;
    private TextView hhV;
    private View hhW;
    private LinearLayout.LayoutParams hhX;
    private com.baidu.tieba.homepage.topic.topictab.b.a hhY;
    private CellTopicLinearLayout hhm;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hhm = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.fHi = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.hhO = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.hhP = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.hhQ = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.fXi = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.hhR = view.findViewById(R.id.cell_topic_img_placeholder);
        this.hhS = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.hhT = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.hhU = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.hhV = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.hhW = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.fXi.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fXi.setLayoutParams(layoutParams);
        this.fXi.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.fXi.setConrers(15);
        this.fXi.setPlaceHolder(3);
        this.hhX = (LinearLayout.LayoutParams) this.fHi.getLayoutParams();
        this.hhm.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hhS.onChangeSkinType();
        this.hhT.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hhO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hhP, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.fXi.setIsNight(this.mSkinType == 1);
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
            this.hhY = aVar;
            if (aVar.from == 0) {
                this.hhV.setVisibility(8);
                this.hhO.setVisibility(0);
                this.hhP.setVisibility(0);
                this.hhO.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.hhO, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.hhO, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.hhO, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.hhO, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                au.a(this.mDescView, aVar.cQD, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, Ky, true);
                if (aVar.cQC == 0) {
                    this.hhP.setText("NEW");
                } else {
                    this.hhP.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.cQC)));
                }
                if (aVar.hhz == null) {
                    this.hhT.setVisibility(8);
                } else {
                    this.hhT.setVisibility(0);
                    this.hhT.setData(aVar.hhz);
                }
            } else {
                this.hhV.setVisibility(0);
                this.hhO.setVisibility(8);
                this.hhP.setVisibility(8);
                this.hhT.setVisibility(8);
                this.hhX.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.cQD)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.cQD);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.cQB;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.hgd)) {
                this.hhQ.setVisibility(8);
                this.hhS.setUserColor(R.color.cp_cont_d);
            } else {
                this.hhQ.setVisibility(0);
                this.fXi.setPlaceHolder(3);
                this.fXi.startLoad(aVar.hgd, 10, false);
                this.hhS.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.hhy == null) {
                this.hhR.setVisibility(8);
                this.hhS.setVisibility(8);
                this.hhW.setVisibility(8);
                return;
            }
            this.hhR.setVisibility(0);
            this.hhS.setVisibility(0);
            this.hhS.setData(aVar.hhy);
            this.hhW.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hhY != null && this.hhY.from != 1) {
            TiebaStatic.log(new an("c13351").s("topic_id", this.hhY.topicId).X("obj_locate", this.hhY.index));
        }
        if (this.hhY != null && this.hhY.from == 1) {
            TiebaStatic.log(new an("c13449").s("topic_id", this.hhY.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.hhY.topicId)));
    }

    public CellTopicLinearLayout bPD() {
        return this.hhm;
    }
}

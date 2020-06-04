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
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int adT = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout gBU;
    private TbImageView gTG;
    private TextView iiN;
    private TextView iiO;
    private RelativeLayout iiP;
    private View iiQ;
    private TopicPkView iiR;
    private ThreadGodReplyLayout iiS;
    private View iiT;
    private TextView iiU;
    private View iiV;
    private LinearLayout.LayoutParams iiW;
    private com.baidu.tieba.homepage.topic.topictab.b.a iiX;
    private CellTopicLinearLayout iil;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.iil = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.gBU = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.iiN = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.iiO = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.iiP = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.gTG = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.iiQ = view.findViewById(R.id.cell_topic_img_placeholder);
        this.iiR = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.iiS = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.iiT = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.iiU = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.iiV = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.gTG.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.gTG.setLayoutParams(layoutParams);
        this.gTG.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.gTG.setConrers(15);
        this.gTG.setPlaceHolder(3);
        this.iiW = (LinearLayout.LayoutParams) this.gBU.getLayoutParams();
        this.iil.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.iiR.onChangeSkinType();
        this.iiS.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.iiN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.iiO, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.gTG.setIsNight(this.mSkinType == 1);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.cell_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topictab.b.a aVar) {
        if (aVar != null) {
            this.iiX = aVar;
            if (aVar.from == 0) {
                this.iiU.setVisibility(8);
                this.iiN.setVisibility(0);
                this.iiO.setVisibility(0);
                this.iiN.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.iiN, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.iiN, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.iiN, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.iiN, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                au.a(this.mDescView, aVar.dDY, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, adT, true);
                if (aVar.dDX == 0) {
                    this.iiO.setText("NEW");
                } else {
                    this.iiO.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.dDX)));
                }
                if (aVar.iiy == null) {
                    this.iiS.setVisibility(8);
                } else {
                    this.iiS.setVisibility(0);
                    this.iiS.setData(aVar.iiy);
                }
            } else {
                this.iiU.setVisibility(0);
                this.iiN.setVisibility(8);
                this.iiO.setVisibility(8);
                this.iiS.setVisibility(8);
                this.iiW.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.dDY)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.dDY);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.dDW;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.ihc)) {
                this.iiP.setVisibility(8);
                this.iiR.setUserColor(R.color.cp_cont_d);
            } else {
                this.iiP.setVisibility(0);
                this.gTG.setPlaceHolder(3);
                this.gTG.startLoad(aVar.ihc, 10, false);
                this.iiR.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.iix == null) {
                this.iiQ.setVisibility(8);
                this.iiR.setVisibility(8);
                this.iiV.setVisibility(8);
                return;
            }
            this.iiQ.setVisibility(0);
            this.iiR.setVisibility(0);
            this.iiR.setData(aVar.iix);
            this.iiV.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iiX != null && this.iiX.from != 1) {
            TiebaStatic.log(new an("c13351").s("topic_id", this.iiX.topicId).ag("obj_locate", this.iiX.index));
        }
        if (this.iiX != null && this.iiX.from == 1) {
            TiebaStatic.log(new an("c13449").s("topic_id", this.iiX.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.iiX.topicId)));
    }

    public CellTopicLinearLayout chd() {
        return this.iil;
    }
}

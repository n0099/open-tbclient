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
    private RelativeLayout fId;
    private TbImageView fYd;
    private CellTopicLinearLayout hiZ;
    private TextView hjB;
    private TextView hjC;
    private RelativeLayout hjD;
    private View hjE;
    private TopicPkView hjF;
    private ThreadGodReplyLayout hjG;
    private View hjH;
    private TextView hjI;
    private View hjJ;
    private LinearLayout.LayoutParams hjK;
    private com.baidu.tieba.homepage.topic.topictab.b.a hjL;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hiZ = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.fId = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.hjB = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.hjC = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.hjD = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.fYd = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.hjE = view.findViewById(R.id.cell_topic_img_placeholder);
        this.hjF = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.hjG = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.hjH = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.hjI = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.hjJ = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.fYd.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fYd.setLayoutParams(layoutParams);
        this.fYd.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.fYd.setConrers(15);
        this.fYd.setPlaceHolder(3);
        this.hjK = (LinearLayout.LayoutParams) this.fId.getLayoutParams();
        this.hiZ.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hjF.onChangeSkinType();
        this.hjG.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hjB, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hjC, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.fYd.setIsNight(this.mSkinType == 1);
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
            this.hjL = aVar;
            if (aVar.from == 0) {
                this.hjI.setVisibility(8);
                this.hjB.setVisibility(0);
                this.hjC.setVisibility(0);
                this.hjB.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.hjB, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.hjB, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.hjB, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.hjB, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                au.a(this.mDescView, aVar.cQR, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, Ky, true);
                if (aVar.cQQ == 0) {
                    this.hjC.setText("NEW");
                } else {
                    this.hjC.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.cQQ)));
                }
                if (aVar.hjm == null) {
                    this.hjG.setVisibility(8);
                } else {
                    this.hjG.setVisibility(0);
                    this.hjG.setData(aVar.hjm);
                }
            } else {
                this.hjI.setVisibility(0);
                this.hjB.setVisibility(8);
                this.hjC.setVisibility(8);
                this.hjG.setVisibility(8);
                this.hjK.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.cQR)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.cQR);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.cQP;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.hhP)) {
                this.hjD.setVisibility(8);
                this.hjF.setUserColor(R.color.cp_cont_d);
            } else {
                this.hjD.setVisibility(0);
                this.fYd.setPlaceHolder(3);
                this.fYd.startLoad(aVar.hhP, 10, false);
                this.hjF.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.hjl == null) {
                this.hjE.setVisibility(8);
                this.hjF.setVisibility(8);
                this.hjJ.setVisibility(8);
                return;
            }
            this.hjE.setVisibility(0);
            this.hjF.setVisibility(0);
            this.hjF.setData(aVar.hjl);
            this.hjJ.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hjL != null && this.hjL.from != 1) {
            TiebaStatic.log(new an("c13351").s("topic_id", this.hjL.topicId).X("obj_locate", this.hjL.index));
        }
        if (this.hjL != null && this.hjL.from == 1) {
            TiebaStatic.log(new an("c13449").s("topic_id", this.hjL.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.hjL.topicId)));
    }

    public CellTopicLinearLayout bPW() {
        return this.hiZ;
    }
}

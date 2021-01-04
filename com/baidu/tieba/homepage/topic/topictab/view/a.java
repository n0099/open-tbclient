package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int ahY = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private TbImageView iLn;
    private final View kmD;
    private TextView kmE;
    private TextView kmF;
    private RelativeLayout kmG;
    private View kmH;
    private TopicPkView kmI;
    private ThreadGodReplyLayout kmJ;
    private TextView kmK;
    private View kmL;
    private RelativeLayout kmM;
    private com.baidu.tieba.homepage.topic.topictab.b.a kmN;
    private CellTopicLinearLayout kme;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;
    private final int padding;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.padding = l.getDimens(getContext(), R.dimen.M_W_X005);
        View view = getView();
        this.kme = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.kmM = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.kmE = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.kmF = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.kmG = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.iLn = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.kmH = view.findViewById(R.id.cell_topic_img_placeholder);
        this.kmI = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.kmJ = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.kmK = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.kmL = view.findViewById(R.id.cell_topic_img_mask);
        this.kmD = view.findViewById(R.id.cell_topic_bottom_placeholder);
        di(this.kmM);
        di(this.mDescView);
        di(this.kmJ);
        di(this.kmD);
        di(this.iLn);
        di(this.kmL);
        int dimens = l.getDimens(getContext(), R.dimen.tbds11);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kmI.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = dimens;
        this.kmI.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iLn.getLayoutParams();
        layoutParams2.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iLn.setLayoutParams(layoutParams2);
        this.iLn.setRadiusById(R.string.J_X05);
        this.iLn.setConrers(15);
        this.iLn.setDrawCorner(true);
        this.iLn.setPlaceHolder(3);
    }

    private void di(View view) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = this.padding;
            marginLayoutParams.rightMargin = this.padding;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.kmI.onChangeSkinType();
        this.kmJ.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setViewTextColor(this.kmE, R.color.CAM_X0101);
            ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ao.setViewTextColor(this.kmF, R.color.CAM_X0109);
            ao.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            this.iLn.setIsNight(this.mSkinType == 1);
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
            this.kmN = aVar;
            if (aVar.from == 0) {
                this.kmK.setVisibility(8);
                this.kmE.setVisibility(0);
                this.kmF.setVisibility(0);
                this.kmE.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ao.setBackgroundResource(this.kmE, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ao.setBackgroundResource(this.kmE, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ao.setBackgroundResource(this.kmE, R.drawable.topic_rank_three_bg);
                } else {
                    ao.setBackgroundResource(this.kmE, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                ay.a(this.mDescView, aVar.eRU, R.string.check_detail, R.dimen.tbds17, 2, ahY, true);
                if (aVar.eRT == 0) {
                    this.kmF.setText("NEW");
                } else {
                    this.kmF.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), at.numberUniformFormat(aVar.eRT)));
                }
                if (aVar.kmq == null) {
                    this.kmJ.setVisibility(8);
                } else {
                    this.kmJ.setVisibility(0);
                    this.kmJ.setData(aVar.kmq);
                }
            } else {
                this.kmK.setVisibility(0);
                this.kmE.setVisibility(8);
                this.kmF.setVisibility(8);
                this.kmJ.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                c.bv(this.mTitleView).pC(R.color.CAM_X0105).pE(R.string.F_X01);
                if (StringUtils.isNull(aVar.eRU)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    ay.a(this.mDescView, aVar.eRU, R.string.check_detail, R.dimen.tbds17, 2, ahY, true, false);
                }
                ao.setViewTextColor(this.mDescView, R.color.CAM_X0105, 1);
            }
            String str = aVar.eRS;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.kkV)) {
                this.kmG.setVisibility(8);
                this.kmI.setUserColor(R.color.CAM_X0109);
            } else {
                this.kmG.setVisibility(0);
                this.iLn.setPlaceHolder(3);
                this.iLn.startLoad(aVar.kkV, 10, false);
                this.kmI.setUserColor(R.color.CAM_X0101);
            }
            if (aVar.kmp == null) {
                this.kmH.setVisibility(8);
                this.kmI.setVisibility(8);
                this.kmL.setVisibility(8);
                return;
            }
            this.kmH.setVisibility(0);
            this.kmI.setVisibility(0);
            this.kmI.setData(aVar.kmp);
            this.kmL.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kmN != null) {
            if (this.kmN.from != 1) {
                TiebaStatic.log(new aq("c13351").w("topic_id", this.kmN.topicId).an("obj_locate", this.kmN.index));
            }
            if (this.kmN.from == 1) {
                TiebaStatic.log(new aq("c13449").w("topic_id", this.kmN.topicId));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.kmN.topicId)));
        }
    }

    public CellTopicLinearLayout cUk() {
        return this.kme;
    }
}

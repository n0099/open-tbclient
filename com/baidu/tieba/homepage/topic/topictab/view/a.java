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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int aeo = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout gUq;
    private TbImageView hlZ;
    private TextView iFW;
    private TextView iFX;
    private RelativeLayout iFY;
    private View iFZ;
    private CellTopicLinearLayout iFw;
    private TopicPkView iGa;
    private ThreadGodReplyLayout iGb;
    private View iGc;
    private TextView iGd;
    private View iGe;
    private LinearLayout.LayoutParams iGf;
    private com.baidu.tieba.homepage.topic.topictab.b.a iGg;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.iFw = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.gUq = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.iFW = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.iFX = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.iFY = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.hlZ = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.iFZ = view.findViewById(R.id.cell_topic_img_placeholder);
        this.iGa = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.iGb = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.iGc = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.iGd = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.iGe = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.hlZ.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hlZ.setLayoutParams(layoutParams);
        this.hlZ.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.hlZ.setConrers(15);
        this.hlZ.setPlaceHolder(3);
        this.iGf = (LinearLayout.LayoutParams) this.gUq.getLayoutParams();
        this.iFw.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.iGa.onChangeSkinType();
        this.iGb.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setViewTextColor(this.iFW, R.color.cp_cont_a);
            ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ao.setViewTextColor(this.iFX, R.color.cp_cont_d);
            ao.setViewTextColor(this.mDescView, R.color.cp_cont_b);
            this.hlZ.setIsNight(this.mSkinType == 1);
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
            this.iGg = aVar;
            if (aVar.from == 0) {
                this.iGd.setVisibility(8);
                this.iFW.setVisibility(0);
                this.iFX.setVisibility(0);
                this.iFW.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ao.setBackgroundResource(this.iFW, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ao.setBackgroundResource(this.iFW, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ao.setBackgroundResource(this.iFW, R.drawable.topic_rank_three_bg);
                } else {
                    ao.setBackgroundResource(this.iFW, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                ax.a(this.mDescView, aVar.dQK, R.string.check_detail, R.dimen.tbds17, 2, aeo, true);
                if (aVar.dQJ == 0) {
                    this.iFX.setText("NEW");
                } else {
                    this.iFX.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), as.numberUniformFormat(aVar.dQJ)));
                }
                if (aVar.iFI == null) {
                    this.iGb.setVisibility(8);
                } else {
                    this.iGb.setVisibility(0);
                    this.iGb.setData(aVar.iFI);
                }
            } else {
                this.iGd.setVisibility(0);
                this.iFW.setVisibility(8);
                this.iFX.setVisibility(8);
                this.iGb.setVisibility(8);
                this.iGf.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.dQK)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.dQK);
                }
                ao.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.dQI;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.iEn)) {
                this.iFY.setVisibility(8);
                this.iGa.setUserColor(R.color.cp_cont_d);
            } else {
                this.iFY.setVisibility(0);
                this.hlZ.setPlaceHolder(3);
                this.hlZ.startLoad(aVar.iEn, 10, false);
                this.iGa.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.iFH == null) {
                this.iFZ.setVisibility(8);
                this.iGa.setVisibility(8);
                this.iGe.setVisibility(8);
                return;
            }
            this.iFZ.setVisibility(0);
            this.iGa.setVisibility(0);
            this.iGa.setData(aVar.iFH);
            this.iGe.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iGg != null && this.iGg.from != 1) {
            TiebaStatic.log(new ap("c13351").t("topic_id", this.iGg.topicId).ah("obj_locate", this.iGg.index));
        }
        if (this.iGg != null && this.iGg.from == 1) {
            TiebaStatic.log(new ap("c13449").t("topic_id", this.iGg.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.iGg.topicId)));
    }

    public CellTopicLinearLayout coq() {
        return this.iFw;
    }
}

package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int agp;
    private TbImageView iog;
    private final View jLN;
    private TextView jLO;
    private TextView jLP;
    private RelativeLayout jLQ;
    private View jLR;
    private TopicPkView jLS;
    private ThreadGodReplyLayout jLT;
    private TextView jLU;
    private View jLV;
    private RelativeLayout jLW;
    private com.baidu.tieba.homepage.topic.topictab.b.a jLX;
    private CellTopicLinearLayout jLo;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;
    private final int padding;

    static {
        agp = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (d.bhw() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        int dimens;
        int dimens2;
        this.mSkinType = 3;
        if (d.bhw()) {
            dimens = l.getDimens(getContext(), R.dimen.M_W_X007);
        } else {
            dimens = l.getDimens(getContext(), R.dimen.M_W_X005);
        }
        this.padding = dimens;
        View view = getView();
        this.jLo = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.jLW = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.jLO = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.jLP = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.jLQ = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.iog = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.jLR = view.findViewById(R.id.cell_topic_img_placeholder);
        this.jLS = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.jLT = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.jLU = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.jLV = view.findViewById(R.id.cell_topic_img_mask);
        this.jLN = view.findViewById(R.id.cell_topic_bottom_placeholder);
        cR(this.jLW);
        cR(this.mDescView);
        cR(this.jLT);
        cR(this.jLN);
        cR(this.iog);
        cR(this.jLV);
        if (d.bhw()) {
            dimens2 = l.getDimens(getContext(), R.dimen.tbds16);
        } else {
            dimens2 = l.getDimens(getContext(), R.dimen.tbds11);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jLS.getLayoutParams();
        layoutParams.leftMargin = dimens2;
        layoutParams.rightMargin = dimens2;
        this.jLS.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iog.getLayoutParams();
        layoutParams2.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iog.setLayoutParams(layoutParams2);
        this.iog.setRadiusById(R.string.J_X05);
        this.iog.setConrers(15);
        this.iog.setDrawCorner(true);
        this.iog.setPlaceHolder(3);
    }

    private void cR(View view) {
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.leftMargin = this.padding;
            layoutParams.rightMargin = this.padding;
            view.setLayoutParams(layoutParams);
        } else if (view.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.leftMargin = this.padding;
            layoutParams2.rightMargin = this.padding;
            view.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.jLS.onChangeSkinType();
        this.jLT.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jLO, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ap.setViewTextColor(this.jLP, R.color.CAM_X0109);
            ap.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            this.iog.setIsNight(this.mSkinType == 1);
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
            this.jLX = aVar;
            if (aVar.from == 0) {
                this.jLU.setVisibility(8);
                this.jLO.setVisibility(0);
                this.jLP.setVisibility(0);
                this.jLO.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.jLO, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.jLO, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.jLO, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.jLO, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                az.a(this.mDescView, aVar.eBc, R.string.check_detail, R.dimen.tbds17, 2, agp, true);
                if (aVar.eBb == 0) {
                    this.jLP.setText("NEW");
                } else {
                    this.jLP.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), au.numberUniformFormat(aVar.eBb)));
                }
                if (aVar.jLA == null) {
                    this.jLT.setVisibility(8);
                } else {
                    this.jLT.setVisibility(0);
                    this.jLT.setData(aVar.jLA);
                }
            } else {
                this.jLU.setVisibility(0);
                this.jLO.setVisibility(8);
                this.jLP.setVisibility(8);
                this.jLT.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                c.bj(this.mTitleView).oT(R.color.CAM_X0105).oV(R.string.F_X01);
                if (StringUtils.isNull(aVar.eBc)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    az.a(this.mDescView, aVar.eBc, R.string.check_detail, R.dimen.tbds17, 2, agp, true, false);
                }
                ap.setViewTextColor(this.mDescView, R.color.CAM_X0105, 1);
            }
            String str = aVar.eBa;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.jKe)) {
                this.jLQ.setVisibility(8);
                this.jLS.setUserColor(R.color.CAM_X0109);
            } else {
                this.jLQ.setVisibility(0);
                this.iog.setPlaceHolder(3);
                this.iog.startLoad(aVar.jKe, 10, false);
                this.jLS.setUserColor(R.color.CAM_X0101);
            }
            if (aVar.jLz == null) {
                this.jLR.setVisibility(8);
                this.jLS.setVisibility(8);
                this.jLV.setVisibility(8);
                return;
            }
            this.jLR.setVisibility(0);
            this.jLS.setVisibility(0);
            this.jLS.setData(aVar.jLz);
            this.jLV.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jLX != null) {
            if (this.jLX.from != 1) {
                TiebaStatic.log(new ar("c13351").w("topic_id", this.jLX.topicId).ak("obj_locate", this.jLX.index));
            }
            if (this.jLX.from == 1) {
                TiebaStatic.log(new ar("c13449").w("topic_id", this.jLX.topicId));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.jLX.topicId)));
        }
    }

    public CellTopicLinearLayout cLP() {
        return this.jLo;
    }
}

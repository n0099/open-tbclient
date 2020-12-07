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
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int ahn;
    private TbImageView iyY;
    private CellTopicLinearLayout jYR;
    private com.baidu.tieba.homepage.topic.topictab.b.a jZA;
    private final View jZq;
    private TextView jZr;
    private TextView jZs;
    private RelativeLayout jZt;
    private View jZu;
    private TopicPkView jZv;
    private ThreadGodReplyLayout jZw;
    private TextView jZx;
    private View jZy;
    private RelativeLayout jZz;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;
    private final int padding;

    static {
        ahn = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (d.bkA() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        int dimens;
        int dimens2;
        this.mSkinType = 3;
        if (d.bkA()) {
            dimens = l.getDimens(getContext(), R.dimen.M_W_X007);
        } else {
            dimens = l.getDimens(getContext(), R.dimen.M_W_X005);
        }
        this.padding = dimens;
        View view = getView();
        this.jYR = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.jZz = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.jZr = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.jZs = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.jZt = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.iyY = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.jZu = view.findViewById(R.id.cell_topic_img_placeholder);
        this.jZv = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.jZw = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.jZx = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.jZy = view.findViewById(R.id.cell_topic_img_mask);
        this.jZq = view.findViewById(R.id.cell_topic_bottom_placeholder);
        cY(this.jZz);
        cY(this.mDescView);
        cY(this.jZw);
        cY(this.jZq);
        cY(this.iyY);
        cY(this.jZy);
        if (d.bkA()) {
            dimens2 = l.getDimens(getContext(), R.dimen.tbds16);
        } else {
            dimens2 = l.getDimens(getContext(), R.dimen.tbds11);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jZv.getLayoutParams();
        layoutParams.leftMargin = dimens2;
        layoutParams.rightMargin = dimens2;
        this.jZv.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iyY.getLayoutParams();
        layoutParams2.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iyY.setLayoutParams(layoutParams2);
        this.iyY.setRadiusById(R.string.J_X05);
        this.iyY.setConrers(15);
        this.iyY.setDrawCorner(true);
        this.iyY.setPlaceHolder(3);
    }

    private void cY(View view) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = this.padding;
            marginLayoutParams.rightMargin = this.padding;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.jZv.onChangeSkinType();
        this.jZw.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jZr, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ap.setViewTextColor(this.jZs, R.color.CAM_X0109);
            ap.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            this.iyY.setIsNight(this.mSkinType == 1);
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
            this.jZA = aVar;
            if (aVar.from == 0) {
                this.jZx.setVisibility(8);
                this.jZr.setVisibility(0);
                this.jZs.setVisibility(0);
                this.jZr.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.jZr, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.jZr, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.jZr, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.jZr, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                az.a(this.mDescView, aVar.eIc, R.string.check_detail, R.dimen.tbds17, 2, ahn, true);
                if (aVar.eIb == 0) {
                    this.jZs.setText("NEW");
                } else {
                    this.jZs.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), au.numberUniformFormat(aVar.eIb)));
                }
                if (aVar.jZd == null) {
                    this.jZw.setVisibility(8);
                } else {
                    this.jZw.setVisibility(0);
                    this.jZw.setData(aVar.jZd);
                }
            } else {
                this.jZx.setVisibility(0);
                this.jZr.setVisibility(8);
                this.jZs.setVisibility(8);
                this.jZw.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                c.bm(this.mTitleView).ps(R.color.CAM_X0105).pu(R.string.F_X01);
                if (StringUtils.isNull(aVar.eIc)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    az.a(this.mDescView, aVar.eIc, R.string.check_detail, R.dimen.tbds17, 2, ahn, true, false);
                }
                ap.setViewTextColor(this.mDescView, R.color.CAM_X0105, 1);
            }
            String str = aVar.eIa;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.jXH)) {
                this.jZt.setVisibility(8);
                this.jZv.setUserColor(R.color.CAM_X0109);
            } else {
                this.jZt.setVisibility(0);
                this.iyY.setPlaceHolder(3);
                this.iyY.startLoad(aVar.jXH, 10, false);
                this.jZv.setUserColor(R.color.CAM_X0101);
            }
            if (aVar.jZc == null) {
                this.jZu.setVisibility(8);
                this.jZv.setVisibility(8);
                this.jZy.setVisibility(8);
                return;
            }
            this.jZu.setVisibility(0);
            this.jZv.setVisibility(0);
            this.jZv.setData(aVar.jZc);
            this.jZy.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jZA != null) {
            if (this.jZA.from != 1) {
                TiebaStatic.log(new ar("c13351").w("topic_id", this.jZA.topicId).al("obj_locate", this.jZA.index));
            }
            if (this.jZA.from == 1) {
                TiebaStatic.log(new ar("c13449").w("topic_id", this.jZA.topicId));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.jZA.topicId)));
        }
    }

    public CellTopicLinearLayout cRd() {
        return this.jYR;
    }
}

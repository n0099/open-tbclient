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
    private TbImageView iza;
    private CellTopicLinearLayout jYT;
    private View jZA;
    private RelativeLayout jZB;
    private com.baidu.tieba.homepage.topic.topictab.b.a jZC;
    private final View jZs;
    private TextView jZt;
    private TextView jZu;
    private RelativeLayout jZv;
    private View jZw;
    private TopicPkView jZx;
    private ThreadGodReplyLayout jZy;
    private TextView jZz;
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
        this.jYT = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.jZB = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.jZt = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.jZu = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.jZv = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.iza = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.jZw = view.findViewById(R.id.cell_topic_img_placeholder);
        this.jZx = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.jZy = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.jZz = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.jZA = view.findViewById(R.id.cell_topic_img_mask);
        this.jZs = view.findViewById(R.id.cell_topic_bottom_placeholder);
        cY(this.jZB);
        cY(this.mDescView);
        cY(this.jZy);
        cY(this.jZs);
        cY(this.iza);
        cY(this.jZA);
        if (d.bkA()) {
            dimens2 = l.getDimens(getContext(), R.dimen.tbds16);
        } else {
            dimens2 = l.getDimens(getContext(), R.dimen.tbds11);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jZx.getLayoutParams();
        layoutParams.leftMargin = dimens2;
        layoutParams.rightMargin = dimens2;
        this.jZx.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iza.getLayoutParams();
        layoutParams2.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iza.setLayoutParams(layoutParams2);
        this.iza.setRadiusById(R.string.J_X05);
        this.iza.setConrers(15);
        this.iza.setDrawCorner(true);
        this.iza.setPlaceHolder(3);
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
        this.jZx.onChangeSkinType();
        this.jZy.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jZt, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ap.setViewTextColor(this.jZu, R.color.CAM_X0109);
            ap.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            this.iza.setIsNight(this.mSkinType == 1);
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
            this.jZC = aVar;
            if (aVar.from == 0) {
                this.jZz.setVisibility(8);
                this.jZt.setVisibility(0);
                this.jZu.setVisibility(0);
                this.jZt.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.jZt, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.jZt, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.jZt, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.jZt, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                az.a(this.mDescView, aVar.eIc, R.string.check_detail, R.dimen.tbds17, 2, ahn, true);
                if (aVar.eIb == 0) {
                    this.jZu.setText("NEW");
                } else {
                    this.jZu.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), au.numberUniformFormat(aVar.eIb)));
                }
                if (aVar.jZf == null) {
                    this.jZy.setVisibility(8);
                } else {
                    this.jZy.setVisibility(0);
                    this.jZy.setData(aVar.jZf);
                }
            } else {
                this.jZz.setVisibility(0);
                this.jZt.setVisibility(8);
                this.jZu.setVisibility(8);
                this.jZy.setVisibility(8);
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
            if (StringUtils.isNull(aVar.jXJ)) {
                this.jZv.setVisibility(8);
                this.jZx.setUserColor(R.color.CAM_X0109);
            } else {
                this.jZv.setVisibility(0);
                this.iza.setPlaceHolder(3);
                this.iza.startLoad(aVar.jXJ, 10, false);
                this.jZx.setUserColor(R.color.CAM_X0101);
            }
            if (aVar.jZe == null) {
                this.jZw.setVisibility(8);
                this.jZx.setVisibility(8);
                this.jZA.setVisibility(8);
                return;
            }
            this.jZw.setVisibility(0);
            this.jZx.setVisibility(0);
            this.jZx.setData(aVar.jZe);
            this.jZA.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jZC != null) {
            if (this.jZC.from != 1) {
                TiebaStatic.log(new ar("c13351").w("topic_id", this.jZC.topicId).al("obj_locate", this.jZC.index));
            }
            if (this.jZC.from == 1) {
                TiebaStatic.log(new ar("c13449").w("topic_id", this.jZC.topicId));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.jZC.topicId)));
        }
    }

    public CellTopicLinearLayout cRe() {
        return this.jYT;
    }
}

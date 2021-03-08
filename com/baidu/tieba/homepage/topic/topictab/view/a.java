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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int aip = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private TbImageView iOm;
    private CellTopicLinearLayout krW;
    private TopicPkView ksA;
    private ThreadGodReplyLayout ksB;
    private TextView ksC;
    private View ksD;
    private RelativeLayout ksE;
    private com.baidu.tieba.homepage.topic.topictab.b.a ksF;
    private final View ksv;
    private TextView ksw;
    private TextView ksx;
    private RelativeLayout ksy;
    private View ksz;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;
    private final int padding;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.padding = l.getDimens(getContext(), R.dimen.M_W_X005);
        View view = getView();
        this.krW = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.ksE = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.ksw = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.ksx = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.ksy = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.iOm = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.ksz = view.findViewById(R.id.cell_topic_img_placeholder);
        this.ksA = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.ksB = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.ksC = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.ksD = view.findViewById(R.id.cell_topic_img_mask);
        this.ksv = view.findViewById(R.id.cell_topic_bottom_placeholder);
        dg(this.ksE);
        dg(this.mDescView);
        dg(this.ksB);
        dg(this.ksv);
        dg(this.iOm);
        dg(this.ksD);
        int dimens = l.getDimens(getContext(), R.dimen.tbds11);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ksA.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = dimens;
        this.ksA.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iOm.getLayoutParams();
        layoutParams2.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iOm.setLayoutParams(layoutParams2);
        this.iOm.setRadiusById(R.string.J_X05);
        this.iOm.setConrers(15);
        this.iOm.setDrawCorner(true);
        this.iOm.setPlaceHolder(3);
    }

    private void dg(View view) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = this.padding;
            marginLayoutParams.rightMargin = this.padding;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ksA.onChangeSkinType();
        this.ksB.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.ksw, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ap.setViewTextColor(this.ksx, R.color.CAM_X0109);
            ap.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            this.iOm.setIsNight(this.mSkinType == 1);
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
            this.ksF = aVar;
            if (aVar.from == 0) {
                this.ksC.setVisibility(8);
                this.ksw.setVisibility(0);
                this.ksx.setVisibility(0);
                this.ksw.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.ksw, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.ksw, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.ksw, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.ksw, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                az.a(this.mDescView, aVar.eQW, R.string.check_detail, R.dimen.tbds17, 2, aip, true);
                if (aVar.eQV == 0) {
                    this.ksx.setText("NEW");
                } else {
                    this.ksx.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), au.numberUniformFormat(aVar.eQV)));
                }
                if (aVar.ksi == null) {
                    this.ksB.setVisibility(8);
                } else {
                    this.ksB.setVisibility(0);
                    this.ksB.setData(aVar.ksi);
                }
            } else {
                this.ksC.setVisibility(0);
                this.ksw.setVisibility(8);
                this.ksx.setVisibility(8);
                this.ksB.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                c.br(this.mTitleView).nZ(R.color.CAM_X0105).ob(R.string.F_X01);
                if (StringUtils.isNull(aVar.eQW)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    az.a(this.mDescView, aVar.eQW, R.string.check_detail, R.dimen.tbds17, 2, aip, true, false);
                }
                ap.setViewTextColor(this.mDescView, R.color.CAM_X0105, 1);
            }
            String str = aVar.eQU;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.kqN)) {
                this.ksy.setVisibility(8);
                this.ksA.setUserColor(R.color.CAM_X0109);
            } else {
                this.ksy.setVisibility(0);
                this.iOm.setPlaceHolder(3);
                this.iOm.startLoad(aVar.kqN, 10, false);
                this.ksA.setUserColor(R.color.CAM_X0101);
            }
            if (aVar.ksh == null) {
                this.ksz.setVisibility(8);
                this.ksA.setVisibility(8);
                this.ksD.setVisibility(8);
                return;
            }
            this.ksz.setVisibility(0);
            this.ksA.setVisibility(0);
            this.ksA.setData(aVar.ksh);
            this.ksD.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ksF != null) {
            if (this.ksF.from != 1) {
                TiebaStatic.log(new ar("c13351").v("topic_id", this.ksF.topicId).aq("obj_locate", this.ksF.index));
            }
            if (this.ksF.from == 1) {
                TiebaStatic.log(new ar("c13449").v("topic_id", this.ksF.topicId));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.ksF.topicId)));
        }
    }

    public CellTopicLinearLayout cSG() {
        return this.krW;
    }
}

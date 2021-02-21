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
    private static final int agW = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private TbImageView iMD;
    private CellTopicLinearLayout kpU;
    private TextView kqA;
    private View kqB;
    private RelativeLayout kqC;
    private com.baidu.tieba.homepage.topic.topictab.b.a kqD;
    private final View kqt;
    private TextView kqu;
    private TextView kqv;
    private RelativeLayout kqw;
    private View kqx;
    private TopicPkView kqy;
    private ThreadGodReplyLayout kqz;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;
    private final int padding;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.padding = l.getDimens(getContext(), R.dimen.M_W_X005);
        View view = getView();
        this.kpU = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.kqC = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.kqu = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.kqv = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.kqw = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.iMD = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.kqx = view.findViewById(R.id.cell_topic_img_placeholder);
        this.kqy = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.kqz = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.kqA = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.kqB = view.findViewById(R.id.cell_topic_img_mask);
        this.kqt = view.findViewById(R.id.cell_topic_bottom_placeholder);
        dg(this.kqC);
        dg(this.mDescView);
        dg(this.kqz);
        dg(this.kqt);
        dg(this.iMD);
        dg(this.kqB);
        int dimens = l.getDimens(getContext(), R.dimen.tbds11);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kqy.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = dimens;
        this.kqy.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iMD.getLayoutParams();
        layoutParams2.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iMD.setLayoutParams(layoutParams2);
        this.iMD.setRadiusById(R.string.J_X05);
        this.iMD.setConrers(15);
        this.iMD.setDrawCorner(true);
        this.iMD.setPlaceHolder(3);
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
        this.kqy.onChangeSkinType();
        this.kqz.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.kqu, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ap.setViewTextColor(this.kqv, R.color.CAM_X0109);
            ap.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            this.iMD.setIsNight(this.mSkinType == 1);
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
            this.kqD = aVar;
            if (aVar.from == 0) {
                this.kqA.setVisibility(8);
                this.kqu.setVisibility(0);
                this.kqv.setVisibility(0);
                this.kqu.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.kqu, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.kqu, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.kqu, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.kqu, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                az.a(this.mDescView, aVar.ePv, R.string.check_detail, R.dimen.tbds17, 2, agW, true);
                if (aVar.ePu == 0) {
                    this.kqv.setText("NEW");
                } else {
                    this.kqv.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), au.numberUniformFormat(aVar.ePu)));
                }
                if (aVar.kqg == null) {
                    this.kqz.setVisibility(8);
                } else {
                    this.kqz.setVisibility(0);
                    this.kqz.setData(aVar.kqg);
                }
            } else {
                this.kqA.setVisibility(0);
                this.kqu.setVisibility(8);
                this.kqv.setVisibility(8);
                this.kqz.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                c.br(this.mTitleView).nY(R.color.CAM_X0105).oa(R.string.F_X01);
                if (StringUtils.isNull(aVar.ePv)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    az.a(this.mDescView, aVar.ePv, R.string.check_detail, R.dimen.tbds17, 2, agW, true, false);
                }
                ap.setViewTextColor(this.mDescView, R.color.CAM_X0105, 1);
            }
            String str = aVar.ePt;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.koL)) {
                this.kqw.setVisibility(8);
                this.kqy.setUserColor(R.color.CAM_X0109);
            } else {
                this.kqw.setVisibility(0);
                this.iMD.setPlaceHolder(3);
                this.iMD.startLoad(aVar.koL, 10, false);
                this.kqy.setUserColor(R.color.CAM_X0101);
            }
            if (aVar.kqf == null) {
                this.kqx.setVisibility(8);
                this.kqy.setVisibility(8);
                this.kqB.setVisibility(8);
                return;
            }
            this.kqx.setVisibility(0);
            this.kqy.setVisibility(0);
            this.kqy.setData(aVar.kqf);
            this.kqB.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kqD != null) {
            if (this.kqD.from != 1) {
                TiebaStatic.log(new ar("c13351").v("topic_id", this.kqD.topicId).ap("obj_locate", this.kqD.index));
            }
            if (this.kqD.from == 1) {
                TiebaStatic.log(new ar("c13449").v("topic_id", this.kqD.topicId));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.kqD.topicId)));
        }
    }

    public CellTopicLinearLayout cSz() {
        return this.kpU;
    }
}

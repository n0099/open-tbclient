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
    private static final int ahh = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private TbImageView iGG;
    private final View khX;
    private TextView khY;
    private TextView khZ;
    private CellTopicLinearLayout khy;
    private RelativeLayout kia;
    private View kib;
    private TopicPkView kic;
    private ThreadGodReplyLayout kie;
    private TextView kif;
    private View kig;
    private RelativeLayout kih;
    private com.baidu.tieba.homepage.topic.topictab.b.a kii;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;
    private final int padding;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.padding = l.getDimens(getContext(), R.dimen.M_W_X005);
        View view = getView();
        this.khy = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.kih = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.khY = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.khZ = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.kia = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.iGG = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.kib = view.findViewById(R.id.cell_topic_img_placeholder);
        this.kic = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.kie = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.kif = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.kig = view.findViewById(R.id.cell_topic_img_mask);
        this.khX = view.findViewById(R.id.cell_topic_bottom_placeholder);
        di(this.kih);
        di(this.mDescView);
        di(this.kie);
        di(this.khX);
        di(this.iGG);
        di(this.kig);
        int dimens = l.getDimens(getContext(), R.dimen.tbds11);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kic.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = dimens;
        this.kic.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iGG.getLayoutParams();
        layoutParams2.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iGG.setLayoutParams(layoutParams2);
        this.iGG.setRadiusById(R.string.J_X05);
        this.iGG.setConrers(15);
        this.iGG.setDrawCorner(true);
        this.iGG.setPlaceHolder(3);
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
        this.kic.onChangeSkinType();
        this.kie.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setViewTextColor(this.khY, R.color.CAM_X0101);
            ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ao.setViewTextColor(this.khZ, R.color.CAM_X0109);
            ao.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            this.iGG.setIsNight(this.mSkinType == 1);
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
            this.kii = aVar;
            if (aVar.from == 0) {
                this.kif.setVisibility(8);
                this.khY.setVisibility(0);
                this.khZ.setVisibility(0);
                this.khY.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ao.setBackgroundResource(this.khY, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ao.setBackgroundResource(this.khY, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ao.setBackgroundResource(this.khY, R.drawable.topic_rank_three_bg);
                } else {
                    ao.setBackgroundResource(this.khY, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                ay.a(this.mDescView, aVar.eNj, R.string.check_detail, R.dimen.tbds17, 2, ahh, true);
                if (aVar.eNi == 0) {
                    this.khZ.setText("NEW");
                } else {
                    this.khZ.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), at.numberUniformFormat(aVar.eNi)));
                }
                if (aVar.khK == null) {
                    this.kie.setVisibility(8);
                } else {
                    this.kie.setVisibility(0);
                    this.kie.setData(aVar.khK);
                }
            } else {
                this.kif.setVisibility(0);
                this.khY.setVisibility(8);
                this.khZ.setVisibility(8);
                this.kie.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                c.bv(this.mTitleView).nV(R.color.CAM_X0105).nX(R.string.F_X01);
                if (StringUtils.isNull(aVar.eNj)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    ay.a(this.mDescView, aVar.eNj, R.string.check_detail, R.dimen.tbds17, 2, ahh, true, false);
                }
                ao.setViewTextColor(this.mDescView, R.color.CAM_X0105, 1);
            }
            String str = aVar.eNh;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.kgp)) {
                this.kia.setVisibility(8);
                this.kic.setUserColor(R.color.CAM_X0109);
            } else {
                this.kia.setVisibility(0);
                this.iGG.setPlaceHolder(3);
                this.iGG.startLoad(aVar.kgp, 10, false);
                this.kic.setUserColor(R.color.CAM_X0101);
            }
            if (aVar.khJ == null) {
                this.kib.setVisibility(8);
                this.kic.setVisibility(8);
                this.kig.setVisibility(8);
                return;
            }
            this.kib.setVisibility(0);
            this.kic.setVisibility(0);
            this.kic.setData(aVar.khJ);
            this.kig.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kii != null) {
            if (this.kii.from != 1) {
                TiebaStatic.log(new aq("c13351").w("topic_id", this.kii.topicId).an("obj_locate", this.kii.index));
            }
            if (this.kii.from == 1) {
                TiebaStatic.log(new aq("c13449").w("topic_id", this.kii.topicId));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.kii.topicId)));
        }
    }

    public CellTopicLinearLayout cQt() {
        return this.khy;
    }
}

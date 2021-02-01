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
    private TbImageView iMp;
    private CellTopicLinearLayout kpG;
    private final View kqf;
    private TextView kqg;
    private TextView kqh;
    private RelativeLayout kqi;
    private View kqj;
    private TopicPkView kqk;
    private ThreadGodReplyLayout kql;
    private TextView kqm;
    private View kqn;
    private RelativeLayout kqo;
    private com.baidu.tieba.homepage.topic.topictab.b.a kqp;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;
    private final int padding;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.padding = l.getDimens(getContext(), R.dimen.M_W_X005);
        View view = getView();
        this.kpG = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.kqo = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.kqg = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.kqh = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.kqi = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.iMp = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.kqj = view.findViewById(R.id.cell_topic_img_placeholder);
        this.kqk = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.kql = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.kqm = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.kqn = view.findViewById(R.id.cell_topic_img_mask);
        this.kqf = view.findViewById(R.id.cell_topic_bottom_placeholder);
        dg(this.kqo);
        dg(this.mDescView);
        dg(this.kql);
        dg(this.kqf);
        dg(this.iMp);
        dg(this.kqn);
        int dimens = l.getDimens(getContext(), R.dimen.tbds11);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kqk.getLayoutParams();
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = dimens;
        this.kqk.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iMp.getLayoutParams();
        layoutParams2.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iMp.setLayoutParams(layoutParams2);
        this.iMp.setRadiusById(R.string.J_X05);
        this.iMp.setConrers(15);
        this.iMp.setDrawCorner(true);
        this.iMp.setPlaceHolder(3);
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
        this.kqk.onChangeSkinType();
        this.kql.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.kqg, R.color.CAM_X0101);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            ap.setViewTextColor(this.kqh, R.color.CAM_X0109);
            ap.setViewTextColor(this.mDescView, R.color.CAM_X0105);
            this.iMp.setIsNight(this.mSkinType == 1);
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
            this.kqp = aVar;
            if (aVar.from == 0) {
                this.kqm.setVisibility(8);
                this.kqg.setVisibility(0);
                this.kqh.setVisibility(0);
                this.kqg.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.kqg, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.kqg, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.kqg, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.kqg, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                az.a(this.mDescView, aVar.ePv, R.string.check_detail, R.dimen.tbds17, 2, agW, true);
                if (aVar.ePu == 0) {
                    this.kqh.setText("NEW");
                } else {
                    this.kqh.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), au.numberUniformFormat(aVar.ePu)));
                }
                if (aVar.kpS == null) {
                    this.kql.setVisibility(8);
                } else {
                    this.kql.setVisibility(0);
                    this.kql.setData(aVar.kpS);
                }
            } else {
                this.kqm.setVisibility(0);
                this.kqg.setVisibility(8);
                this.kqh.setVisibility(8);
                this.kql.setVisibility(8);
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
            if (StringUtils.isNull(aVar.kox)) {
                this.kqi.setVisibility(8);
                this.kqk.setUserColor(R.color.CAM_X0109);
            } else {
                this.kqi.setVisibility(0);
                this.iMp.setPlaceHolder(3);
                this.iMp.startLoad(aVar.kox, 10, false);
                this.kqk.setUserColor(R.color.CAM_X0101);
            }
            if (aVar.kpR == null) {
                this.kqj.setVisibility(8);
                this.kqk.setVisibility(8);
                this.kqn.setVisibility(8);
                return;
            }
            this.kqj.setVisibility(0);
            this.kqk.setVisibility(0);
            this.kqk.setData(aVar.kpR);
            this.kqn.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kqp != null) {
            if (this.kqp.from != 1) {
                TiebaStatic.log(new ar("c13351").v("topic_id", this.kqp.topicId).ap("obj_locate", this.kqp.index));
            }
            if (this.kqp.from == 1) {
                TiebaStatic.log(new ar("c13449").v("topic_id", this.kqp.topicId));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.kqp.topicId)));
        }
    }

    public CellTopicLinearLayout cSs() {
        return this.kpG;
    }
}

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int afz = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout hhm;
    private TbImageView hyW;
    private CellTopicLinearLayout iUA;
    private TextView iVa;
    private TextView iVb;
    private RelativeLayout iVc;
    private View iVd;
    private TopicPkView iVe;
    private ThreadGodReplyLayout iVf;
    private View iVg;
    private TextView iVh;
    private View iVi;
    private LinearLayout.LayoutParams iVj;
    private com.baidu.tieba.homepage.topic.topictab.b.a iVk;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.iUA = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.hhm = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.iVa = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.iVb = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.iVc = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.hyW = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.iVd = view.findViewById(R.id.cell_topic_img_placeholder);
        this.iVe = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.iVf = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.iVg = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.iVh = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.iVi = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.hyW.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hyW.setLayoutParams(layoutParams);
        this.hyW.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.hyW.setConrers(15);
        this.hyW.setPlaceHolder(3);
        this.iVj = (LinearLayout.LayoutParams) this.hhm.getLayoutParams();
        this.iUA.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.iVe.onChangeSkinType();
        this.iVf.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iVa, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ap.setViewTextColor(this.iVb, R.color.cp_cont_d);
            ap.setViewTextColor(this.mDescView, R.color.cp_cont_b);
            this.hyW.setIsNight(this.mSkinType == 1);
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
            this.iVk = aVar;
            if (aVar.from == 0) {
                this.iVh.setVisibility(8);
                this.iVa.setVisibility(0);
                this.iVb.setVisibility(0);
                this.iVa.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.iVa, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.iVa, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.iVa, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.iVa, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                ay.a(this.mDescView, aVar.eah, R.string.check_detail, R.dimen.tbds17, 2, afz, true);
                if (aVar.eag == 0) {
                    this.iVb.setText("NEW");
                } else {
                    this.iVb.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), at.numberUniformFormat(aVar.eag)));
                }
                if (aVar.iUM == null) {
                    this.iVf.setVisibility(8);
                } else {
                    this.iVf.setVisibility(0);
                    this.iVf.setData(aVar.iUM);
                }
            } else {
                this.iVh.setVisibility(0);
                this.iVa.setVisibility(8);
                this.iVb.setVisibility(8);
                this.iVf.setVisibility(8);
                this.iVj.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.eah)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.eah);
                }
                ap.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.eaf;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.iTr)) {
                this.iVc.setVisibility(8);
                this.iVe.setUserColor(R.color.cp_cont_d);
            } else {
                this.iVc.setVisibility(0);
                this.hyW.setPlaceHolder(3);
                this.hyW.startLoad(aVar.iTr, 10, false);
                this.iVe.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.iUL == null) {
                this.iVd.setVisibility(8);
                this.iVe.setVisibility(8);
                this.iVi.setVisibility(8);
                return;
            }
            this.iVd.setVisibility(0);
            this.iVe.setVisibility(0);
            this.iVe.setData(aVar.iUL);
            this.iVi.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iVk != null && this.iVk.from != 1) {
            TiebaStatic.log(new aq("c13351").u("topic_id", this.iVk.topicId).ai("obj_locate", this.iVk.index));
        }
        if (this.iVk != null && this.iVk.from == 1) {
            TiebaStatic.log(new aq("c13449").u("topic_id", this.iVk.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.iVk.topicId)));
    }

    public CellTopicLinearLayout czk() {
        return this.iUA;
    }
}

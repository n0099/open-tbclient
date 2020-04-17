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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int adw = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TbImageView gEH;
    private RelativeLayout gmJ;
    private CellTopicLinearLayout hSI;
    private TextView hTk;
    private TextView hTl;
    private RelativeLayout hTm;
    private View hTn;
    private TopicPkView hTo;
    private ThreadGodReplyLayout hTp;
    private View hTq;
    private TextView hTr;
    private View hTs;
    private LinearLayout.LayoutParams hTt;
    private com.baidu.tieba.homepage.topic.topictab.b.a hTu;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hSI = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.gmJ = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.hTk = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.hTl = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.hTm = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.gEH = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.hTn = view.findViewById(R.id.cell_topic_img_placeholder);
        this.hTo = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.hTp = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.hTq = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.hTr = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.hTs = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.gEH.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.gEH.setLayoutParams(layoutParams);
        this.gEH.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.gEH.setConrers(15);
        this.gEH.setPlaceHolder(3);
        this.hTt = (LinearLayout.LayoutParams) this.gmJ.getLayoutParams();
        this.hSI.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hTo.onChangeSkinType();
        this.hTp.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hTk, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hTl, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.gEH.setIsNight(this.mSkinType == 1);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.cell_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topictab.b.a aVar) {
        if (aVar != null) {
            this.hTu = aVar;
            if (aVar.from == 0) {
                this.hTr.setVisibility(8);
                this.hTk.setVisibility(0);
                this.hTl.setVisibility(0);
                this.hTk.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.hTk, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.hTk, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.hTk, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.hTk, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                au.a(this.mDescView, aVar.dpX, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, adw, true);
                if (aVar.dpW == 0) {
                    this.hTl.setText("NEW");
                } else {
                    this.hTl.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.dpW)));
                }
                if (aVar.hSV == null) {
                    this.hTp.setVisibility(8);
                } else {
                    this.hTp.setVisibility(0);
                    this.hTp.setData(aVar.hSV);
                }
            } else {
                this.hTr.setVisibility(0);
                this.hTk.setVisibility(8);
                this.hTl.setVisibility(8);
                this.hTp.setVisibility(8);
                this.hTt.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.dpX)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.dpX);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.dpV;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.hRz)) {
                this.hTm.setVisibility(8);
                this.hTo.setUserColor(R.color.cp_cont_d);
            } else {
                this.hTm.setVisibility(0);
                this.gEH.setPlaceHolder(3);
                this.gEH.startLoad(aVar.hRz, 10, false);
                this.hTo.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.hSU == null) {
                this.hTn.setVisibility(8);
                this.hTo.setVisibility(8);
                this.hTs.setVisibility(8);
                return;
            }
            this.hTn.setVisibility(0);
            this.hTo.setVisibility(0);
            this.hTo.setData(aVar.hSU);
            this.hTs.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hTu != null && this.hTu.from != 1) {
            TiebaStatic.log(new an("c13351").t("topic_id", this.hTu.topicId).af("obj_locate", this.hTu.index));
        }
        if (this.hTu != null && this.hTu.from == 1) {
            TiebaStatic.log(new an("c13449").t("topic_id", this.hTu.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.hTu.topicId)));
    }

    public CellTopicLinearLayout caw() {
        return this.hSI;
    }
}

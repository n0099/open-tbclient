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
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int JX = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout fBy;
    private TbImageView fRV;
    private CellTopicLinearLayout hbH;
    private TextView hcj;
    private TextView hck;
    private RelativeLayout hcl;
    private View hcm;
    private TopicPkView hcn;
    private ThreadGodReplyLayout hco;
    private View hcp;
    private TextView hcq;
    private View hcr;
    private LinearLayout.LayoutParams hcs;
    private com.baidu.tieba.homepage.topic.topictab.b.a hct;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hbH = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.fBy = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.hcj = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.hck = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.hcl = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.fRV = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.hcm = view.findViewById(R.id.cell_topic_img_placeholder);
        this.hcn = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.hco = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.hcp = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.hcq = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.hcr = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.fRV.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fRV.setLayoutParams(layoutParams);
        this.fRV.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.fRV.setConrers(15);
        this.fRV.setPlaceHolder(3);
        this.hcs = (LinearLayout.LayoutParams) this.fBy.getLayoutParams();
        this.hbH.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hcn.onChangeSkinType();
        this.hco.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hcj, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hck, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.fRV.setIsNight(this.mSkinType == 1);
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
            this.hct = aVar;
            if (aVar.from == 0) {
                this.hcq.setVisibility(8);
                this.hcj.setVisibility(0);
                this.hck.setVisibility(0);
                this.hcj.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.hcj, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.hcj, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.hcj, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.hcj, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                au.a(this.mDescView, aVar.cMp, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, JX, true);
                if (aVar.cMo == 0) {
                    this.hck.setText("NEW");
                } else {
                    this.hck.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.cMo)));
                }
                if (aVar.hbU == null) {
                    this.hco.setVisibility(8);
                } else {
                    this.hco.setVisibility(0);
                    this.hco.setData(aVar.hbU);
                }
            } else {
                this.hcq.setVisibility(0);
                this.hcj.setVisibility(8);
                this.hck.setVisibility(8);
                this.hco.setVisibility(8);
                this.hcs.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.cMp)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.cMp);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.cMn;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.hax)) {
                this.hcl.setVisibility(8);
                this.hcn.setUserColor(R.color.cp_cont_d);
            } else {
                this.hcl.setVisibility(0);
                this.fRV.setPlaceHolder(3);
                this.fRV.startLoad(aVar.hax, 10, false);
                this.hcn.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.hbT == null) {
                this.hcm.setVisibility(8);
                this.hcn.setVisibility(8);
                this.hcr.setVisibility(8);
                return;
            }
            this.hcm.setVisibility(0);
            this.hcn.setVisibility(0);
            this.hcn.setData(aVar.hbT);
            this.hcr.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13351").s("topic_id", this.hct.topicId).Z("obj_locate", this.hct.index));
        if (this.hct != null && this.hct.from == 1) {
            TiebaStatic.log(new an("c13449"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.hct.topicId)));
    }

    public CellTopicLinearLayout bMR() {
        return this.hbH;
    }
}

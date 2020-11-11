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
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int agk = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout hVD;
    private TbImageView inr;
    private CellTopicLinearLayout jKD;
    private TextView jLd;
    private TextView jLe;
    private RelativeLayout jLf;
    private View jLg;
    private TopicPkView jLh;
    private ThreadGodReplyLayout jLi;
    private View jLj;
    private TextView jLk;
    private View jLl;
    private LinearLayout.LayoutParams jLm;
    private com.baidu.tieba.homepage.topic.topictab.b.a jLn;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jKD = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.hVD = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.jLd = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.jLe = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.jLf = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.inr = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.jLg = view.findViewById(R.id.cell_topic_img_placeholder);
        this.jLh = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.jLi = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.jLj = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.jLk = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.jLl = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.inr.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.inr.setLayoutParams(layoutParams);
        this.inr.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.inr.setConrers(15);
        this.inr.setPlaceHolder(3);
        this.jLm = (LinearLayout.LayoutParams) this.hVD.getLayoutParams();
        this.jKD.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.jLh.onChangeSkinType();
        this.jLi.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jLd, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ap.setViewTextColor(this.jLe, R.color.cp_cont_d);
            ap.setViewTextColor(this.mDescView, R.color.cp_cont_b);
            this.inr.setIsNight(this.mSkinType == 1);
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
            this.jLn = aVar;
            if (aVar.from == 0) {
                this.jLk.setVisibility(8);
                this.jLd.setVisibility(0);
                this.jLe.setVisibility(0);
                this.jLd.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.jLd, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.jLd, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.jLd, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.jLd, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                ay.a(this.mDescView, aVar.eCL, R.string.check_detail, R.dimen.tbds17, 2, agk, true);
                if (aVar.eCK == 0) {
                    this.jLe.setText("NEW");
                } else {
                    this.jLe.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), at.numberUniformFormat(aVar.eCK)));
                }
                if (aVar.jKP == null) {
                    this.jLi.setVisibility(8);
                } else {
                    this.jLi.setVisibility(0);
                    this.jLi.setData(aVar.jKP);
                }
            } else {
                this.jLk.setVisibility(0);
                this.jLd.setVisibility(8);
                this.jLe.setVisibility(8);
                this.jLi.setVisibility(8);
                this.jLm.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.eCL)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.eCL);
                }
                ap.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.eCJ;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.jJt)) {
                this.jLf.setVisibility(8);
                this.jLh.setUserColor(R.color.cp_cont_d);
            } else {
                this.jLf.setVisibility(0);
                this.inr.setPlaceHolder(3);
                this.inr.startLoad(aVar.jJt, 10, false);
                this.jLh.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.jKO == null) {
                this.jLg.setVisibility(8);
                this.jLh.setVisibility(8);
                this.jLl.setVisibility(8);
                return;
            }
            this.jLg.setVisibility(0);
            this.jLh.setVisibility(0);
            this.jLh.setData(aVar.jKO);
            this.jLl.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jLn != null && this.jLn.from != 1) {
            TiebaStatic.log(new aq("c13351").w("topic_id", this.jLn.topicId).al("obj_locate", this.jLn.index));
        }
        if (this.jLn != null && this.jLn.from == 1) {
            TiebaStatic.log(new aq("c13449").w("topic_id", this.jLn.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.jLn.topicId)));
    }

    public CellTopicLinearLayout cMi() {
        return this.jKD;
    }
}

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
    private static final int afx = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout hhi;
    private TbImageView hyQ;
    private TextView iUU;
    private TextView iUV;
    private RelativeLayout iUW;
    private View iUX;
    private TopicPkView iUY;
    private ThreadGodReplyLayout iUZ;
    private CellTopicLinearLayout iUu;
    private View iVa;
    private TextView iVb;
    private View iVc;
    private LinearLayout.LayoutParams iVd;
    private com.baidu.tieba.homepage.topic.topictab.b.a iVe;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.iUu = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.hhi = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.iUU = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.iUV = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.iUW = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.hyQ = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.iUX = view.findViewById(R.id.cell_topic_img_placeholder);
        this.iUY = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.iUZ = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.iVa = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.iVb = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.iVc = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.hyQ.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hyQ.setLayoutParams(layoutParams);
        this.hyQ.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.hyQ.setConrers(15);
        this.hyQ.setPlaceHolder(3);
        this.iVd = (LinearLayout.LayoutParams) this.hhi.getLayoutParams();
        this.iUu.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.iUY.onChangeSkinType();
        this.iUZ.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iUU, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ap.setViewTextColor(this.iUV, R.color.cp_cont_d);
            ap.setViewTextColor(this.mDescView, R.color.cp_cont_b);
            this.hyQ.setIsNight(this.mSkinType == 1);
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
            this.iVe = aVar;
            if (aVar.from == 0) {
                this.iVb.setVisibility(8);
                this.iUU.setVisibility(0);
                this.iUV.setVisibility(0);
                this.iUU.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.iUU, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.iUU, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.iUU, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.iUU, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                ay.a(this.mDescView, aVar.ead, R.string.check_detail, R.dimen.tbds17, 2, afx, true);
                if (aVar.eac == 0) {
                    this.iUV.setText("NEW");
                } else {
                    this.iUV.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), at.numberUniformFormat(aVar.eac)));
                }
                if (aVar.iUG == null) {
                    this.iUZ.setVisibility(8);
                } else {
                    this.iUZ.setVisibility(0);
                    this.iUZ.setData(aVar.iUG);
                }
            } else {
                this.iVb.setVisibility(0);
                this.iUU.setVisibility(8);
                this.iUV.setVisibility(8);
                this.iUZ.setVisibility(8);
                this.iVd.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.ead)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.ead);
                }
                ap.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.eab;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.iTl)) {
                this.iUW.setVisibility(8);
                this.iUY.setUserColor(R.color.cp_cont_d);
            } else {
                this.iUW.setVisibility(0);
                this.hyQ.setPlaceHolder(3);
                this.hyQ.startLoad(aVar.iTl, 10, false);
                this.iUY.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.iUF == null) {
                this.iUX.setVisibility(8);
                this.iUY.setVisibility(8);
                this.iVc.setVisibility(8);
                return;
            }
            this.iUX.setVisibility(0);
            this.iUY.setVisibility(0);
            this.iUY.setData(aVar.iUF);
            this.iVc.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iVe != null && this.iVe.from != 1) {
            TiebaStatic.log(new aq("c13351").u("topic_id", this.iVe.topicId).ai("obj_locate", this.iVe.index));
        }
        if (this.iVe != null && this.iVe.from == 1) {
            TiebaStatic.log(new aq("c13449").u("topic_id", this.iVe.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.iVe.topicId)));
    }

    public CellTopicLinearLayout czj() {
        return this.iUu;
    }
}

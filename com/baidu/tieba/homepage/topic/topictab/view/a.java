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
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int afR = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TbImageView hFY;
    private RelativeLayout hoq;
    private TextView jdG;
    private TextView jdH;
    private RelativeLayout jdI;
    private View jdJ;
    private TopicPkView jdK;
    private ThreadGodReplyLayout jdL;
    private View jdM;
    private TextView jdN;
    private View jdO;
    private LinearLayout.LayoutParams jdP;
    private com.baidu.tieba.homepage.topic.topictab.b.a jdQ;
    private CellTopicLinearLayout jdg;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jdg = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.hoq = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.jdG = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.jdH = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.jdI = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.hFY = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.jdJ = view.findViewById(R.id.cell_topic_img_placeholder);
        this.jdK = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.jdL = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.jdM = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.jdN = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.jdO = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.hFY.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hFY.setLayoutParams(layoutParams);
        this.hFY.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.hFY.setConrers(15);
        this.hFY.setPlaceHolder(3);
        this.jdP = (LinearLayout.LayoutParams) this.hoq.getLayoutParams();
        this.jdg.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.jdK.onChangeSkinType();
        this.jdL.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jdG, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ap.setViewTextColor(this.jdH, R.color.cp_cont_d);
            ap.setViewTextColor(this.mDescView, R.color.cp_cont_b);
            this.hFY.setIsNight(this.mSkinType == 1);
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
            this.jdQ = aVar;
            if (aVar.from == 0) {
                this.jdN.setVisibility(8);
                this.jdG.setVisibility(0);
                this.jdH.setVisibility(0);
                this.jdG.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.jdG, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.jdG, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.jdG, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.jdG, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                ay.a(this.mDescView, aVar.ecr, R.string.check_detail, R.dimen.tbds17, 2, afR, true);
                if (aVar.ecq == 0) {
                    this.jdH.setText("NEW");
                } else {
                    this.jdH.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), at.numberUniformFormat(aVar.ecq)));
                }
                if (aVar.jds == null) {
                    this.jdL.setVisibility(8);
                } else {
                    this.jdL.setVisibility(0);
                    this.jdL.setData(aVar.jds);
                }
            } else {
                this.jdN.setVisibility(0);
                this.jdG.setVisibility(8);
                this.jdH.setVisibility(8);
                this.jdL.setVisibility(8);
                this.jdP.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.ecr)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.ecr);
                }
                ap.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.ecp;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.jbX)) {
                this.jdI.setVisibility(8);
                this.jdK.setUserColor(R.color.cp_cont_d);
            } else {
                this.jdI.setVisibility(0);
                this.hFY.setPlaceHolder(3);
                this.hFY.startLoad(aVar.jbX, 10, false);
                this.jdK.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.jdr == null) {
                this.jdJ.setVisibility(8);
                this.jdK.setVisibility(8);
                this.jdO.setVisibility(8);
                return;
            }
            this.jdJ.setVisibility(0);
            this.jdK.setVisibility(0);
            this.jdK.setData(aVar.jdr);
            this.jdO.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jdQ != null && this.jdQ.from != 1) {
            TiebaStatic.log(new aq("c13351").u("topic_id", this.jdQ.topicId).ai("obj_locate", this.jdQ.index));
        }
        if (this.jdQ != null && this.jdQ.from == 1) {
            TiebaStatic.log(new aq("c13449").u("topic_id", this.jdQ.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.jdQ.topicId)));
    }

    public CellTopicLinearLayout cCR() {
        return this.jdg;
    }
}

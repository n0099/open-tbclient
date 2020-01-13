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
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int Kc = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout fEJ;
    private TbImageView fVf;
    private TextView hfM;
    private TextView hfN;
    private RelativeLayout hfO;
    private View hfP;
    private TopicPkView hfQ;
    private ThreadGodReplyLayout hfR;
    private View hfS;
    private TextView hfT;
    private View hfU;
    private LinearLayout.LayoutParams hfV;
    private com.baidu.tieba.homepage.topic.topictab.b.a hfW;
    private CellTopicLinearLayout hfk;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hfk = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.fEJ = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.hfM = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.hfN = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.hfO = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.fVf = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.hfP = view.findViewById(R.id.cell_topic_img_placeholder);
        this.hfQ = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.hfR = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.hfS = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.hfT = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.hfU = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.fVf.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fVf.setLayoutParams(layoutParams);
        this.fVf.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.fVf.setConrers(15);
        this.fVf.setPlaceHolder(3);
        this.hfV = (LinearLayout.LayoutParams) this.fEJ.getLayoutParams();
        this.hfk.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hfQ.onChangeSkinType();
        this.hfR.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hfM, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hfN, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.fVf.setIsNight(this.mSkinType == 1);
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
            this.hfW = aVar;
            if (aVar.from == 0) {
                this.hfT.setVisibility(8);
                this.hfM.setVisibility(0);
                this.hfN.setVisibility(0);
                this.hfM.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.hfM, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.hfM, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.hfM, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.hfM, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                au.a(this.mDescView, aVar.cMz, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, Kc, true);
                if (aVar.cMy == 0) {
                    this.hfN.setText("NEW");
                } else {
                    this.hfN.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.cMy)));
                }
                if (aVar.hfx == null) {
                    this.hfR.setVisibility(8);
                } else {
                    this.hfR.setVisibility(0);
                    this.hfR.setData(aVar.hfx);
                }
            } else {
                this.hfT.setVisibility(0);
                this.hfM.setVisibility(8);
                this.hfN.setVisibility(8);
                this.hfR.setVisibility(8);
                this.hfV.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.cMz)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.cMz);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.cMx;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.hea)) {
                this.hfO.setVisibility(8);
                this.hfQ.setUserColor(R.color.cp_cont_d);
            } else {
                this.hfO.setVisibility(0);
                this.fVf.setPlaceHolder(3);
                this.fVf.startLoad(aVar.hea, 10, false);
                this.hfQ.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.hfw == null) {
                this.hfP.setVisibility(8);
                this.hfQ.setVisibility(8);
                this.hfU.setVisibility(8);
                return;
            }
            this.hfP.setVisibility(0);
            this.hfQ.setVisibility(0);
            this.hfQ.setData(aVar.hfw);
            this.hfU.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hfW != null && this.hfW.from != 1) {
            TiebaStatic.log(new an("c13351").s("topic_id", this.hfW.topicId).Z("obj_locate", this.hfW.index));
        }
        if (this.hfW != null && this.hfW.from == 1) {
            TiebaStatic.log(new an("c13449").s("topic_id", this.hfW.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.hfW.topicId)));
    }

    public CellTopicLinearLayout bNZ() {
        return this.hfk;
    }
}

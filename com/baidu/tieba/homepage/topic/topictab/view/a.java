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
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private RelativeLayout eKs;
    private TbImageView fej;
    private CellTopicLinearLayout goX;
    private TextView gpA;
    private RelativeLayout gpB;
    private View gpC;
    private TopicPkView gpD;
    private ThreadGodReplyLayout gpE;
    private View gpF;
    private TextView gpG;
    private View gpH;
    private LinearLayout.LayoutParams gpI;
    private com.baidu.tieba.homepage.topic.topictab.b.a gpJ;
    private TextView gpz;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.goX = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.eKs = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.gpz = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.gpA = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.gpB = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.fej = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.gpC = view.findViewById(R.id.cell_topic_img_placeholder);
        this.gpD = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.gpE = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.gpF = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.gpG = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.gpH = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.fej.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fej.setLayoutParams(layoutParams);
        this.fej.setRadius(l.getDimens(this.mContext, R.dimen.tbds22));
        this.fej.setConrers(15);
        this.gpI = (LinearLayout.LayoutParams) this.eKs.getLayoutParams();
        this.goX.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gpD.onChangeSkinType();
        this.gpE.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.gpz, (int) R.color.cp_cont_m);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gpA, (int) R.color.cp_cont_d);
            if (this.gpJ != null && this.gpJ.from == 1) {
                am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            } else {
                am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_f);
            }
            this.fej.setIsNight(this.mSkinType == 1);
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
            this.gpJ = aVar;
            if (aVar.from == 0) {
                this.gpG.setVisibility(8);
                this.gpz.setVisibility(0);
                this.gpA.setVisibility(0);
                this.gpz.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.gpz, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.gpz, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.gpz, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.gpz, R.drawable.topic_rank_other_bg);
                }
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_index);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16), 0);
                this.mDescView.setText(aVar.caP);
                if (aVar.caO == 0) {
                    this.gpA.setText("NEW");
                } else {
                    this.gpA.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.caO)));
                }
                if (aVar.gpk == null) {
                    this.gpE.setVisibility(8);
                } else {
                    this.gpE.setVisibility(0);
                    this.gpE.setData(aVar.gpk);
                }
            } else {
                this.gpG.setVisibility(0);
                this.gpz.setVisibility(8);
                this.gpA.setVisibility(8);
                this.gpE.setVisibility(8);
                this.gpI.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_icon);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds30), 0, l.getDimens(getContext(), R.dimen.tbds16), 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.caP)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.caP);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.caN;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.gnN)) {
                this.gpB.setVisibility(8);
                this.gpD.setUserColor(R.color.cp_cont_d);
            } else {
                this.gpB.setVisibility(0);
                this.fej.startLoad(aVar.gnN, 10, false);
                this.gpD.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.gpj == null) {
                this.gpC.setVisibility(8);
                this.gpD.setVisibility(8);
                this.gpH.setVisibility(8);
                return;
            }
            this.gpC.setVisibility(0);
            this.gpD.setVisibility(0);
            this.gpD.setData(aVar.gpj);
            this.gpH.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13351").p("topic_id", this.gpJ.topicId).O("obj_locate", this.gpJ.index));
        if (this.gpJ != null && this.gpJ.from == 1) {
            TiebaStatic.log(new an("c13449"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.gpJ.topicId)));
    }

    public CellTopicLinearLayout bvF() {
        return this.goX;
    }
}

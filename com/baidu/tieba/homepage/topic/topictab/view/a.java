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
    private RelativeLayout eJB;
    private TbImageView fds;
    private TextView goI;
    private TextView goJ;
    private RelativeLayout goK;
    private View goL;
    private TopicPkView goM;
    private ThreadGodReplyLayout goN;
    private View goO;
    private TextView goP;
    private View goQ;
    private LinearLayout.LayoutParams goR;
    private com.baidu.tieba.homepage.topic.topictab.b.a goS;
    private CellTopicLinearLayout gog;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gog = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.eJB = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.goI = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.goJ = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.goK = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.fds = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.goL = view.findViewById(R.id.cell_topic_img_placeholder);
        this.goM = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.goN = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.goO = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.goP = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.goQ = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.fds.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fds.setLayoutParams(layoutParams);
        this.fds.setRadius(l.getDimens(this.mContext, R.dimen.tbds22));
        this.fds.setConrers(15);
        this.goR = (LinearLayout.LayoutParams) this.eJB.getLayoutParams();
        this.gog.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.goM.onChangeSkinType();
        this.goN.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.goI, (int) R.color.cp_cont_m);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.goJ, (int) R.color.cp_cont_d);
            if (this.goS != null && this.goS.from == 1) {
                am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            } else {
                am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_f);
            }
            this.fds.setIsNight(this.mSkinType == 1);
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
            this.goS = aVar;
            if (aVar.from == 0) {
                this.goP.setVisibility(8);
                this.goI.setVisibility(0);
                this.goJ.setVisibility(0);
                this.goI.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.goI, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.goI, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.goI, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.goI, R.drawable.topic_rank_other_bg);
                }
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_index);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds16), 0, l.getDimens(getContext(), R.dimen.tbds16), 0);
                this.mDescView.setText(aVar.bZY);
                if (aVar.bZX == 0) {
                    this.goJ.setText("NEW");
                } else {
                    this.goJ.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.bZX)));
                }
                if (aVar.got == null) {
                    this.goN.setVisibility(8);
                } else {
                    this.goN.setVisibility(0);
                    this.goN.setData(aVar.got);
                }
            } else {
                this.goP.setVisibility(0);
                this.goI.setVisibility(8);
                this.goJ.setVisibility(8);
                this.goN.setVisibility(8);
                this.goR.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_icon);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds30), 0, l.getDimens(getContext(), R.dimen.tbds16), 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.bZY)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.bZY);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.bZW;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.gmW)) {
                this.goK.setVisibility(8);
                this.goM.setUserColor(R.color.cp_cont_d);
            } else {
                this.goK.setVisibility(0);
                this.fds.startLoad(aVar.gmW, 10, false);
                this.goM.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.gos == null) {
                this.goL.setVisibility(8);
                this.goM.setVisibility(8);
                this.goQ.setVisibility(8);
                return;
            }
            this.goL.setVisibility(0);
            this.goM.setVisibility(0);
            this.goM.setData(aVar.gos);
            this.goQ.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13351").p("topic_id", this.goS.topicId).O("obj_locate", this.goS.index));
        if (this.goS != null && this.goS.from == 1) {
            TiebaStatic.log(new an("c13449"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.goS.topicId)));
    }

    public CellTopicLinearLayout bvD() {
        return this.gog;
    }
}

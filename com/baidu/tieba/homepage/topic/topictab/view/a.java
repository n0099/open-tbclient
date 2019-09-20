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
    private TextView bOU;
    private RelativeLayout eBK;
    private TbImageView fby;
    private CellTopicLinearLayout gpy;
    private TextView gqa;
    private TextView gqb;
    private RelativeLayout gqc;
    private View gqd;
    private TopicPkView gqe;
    private ThreadGodReplyLayout gqf;
    private View gqg;
    private TextView gqh;
    private View gqi;
    private LinearLayout.LayoutParams gqj;
    private com.baidu.tieba.homepage.topic.topictab.b.a gqk;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gpy = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.eBK = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.gqa = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.gqb = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.bOU = (TextView) view.findViewById(R.id.cell_topic_des);
        this.gqc = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.fby = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.gqd = view.findViewById(R.id.cell_topic_img_placeholder);
        this.gqe = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.gqf = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.gqg = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.gqh = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.gqi = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.fby.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fby.setLayoutParams(layoutParams);
        this.fby.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.fby.setConrers(15);
        this.gqj = (LinearLayout.LayoutParams) this.eBK.getLayoutParams();
        this.gpy.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gqe.onChangeSkinType();
        this.gqf.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.j(this.gqa, R.color.cp_cont_m);
            am.j(this.mTitleView, R.color.cp_cont_b);
            am.j(this.gqb, R.color.cp_cont_d);
            if (this.gqk != null && this.gqk.from == 1) {
                am.j(this.bOU, R.color.cp_cont_b);
            } else {
                am.j(this.bOU, R.color.cp_cont_f);
            }
            this.fby.setIsNight(this.mSkinType == 1);
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
            this.gqk = aVar;
            if (aVar.from == 0) {
                this.gqh.setVisibility(8);
                this.gqa.setVisibility(0);
                this.gqb.setVisibility(0);
                this.gqa.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.k(this.gqa, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.k(this.gqa, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.k(this.gqa, R.drawable.topic_rank_three_bg);
                } else {
                    am.k(this.gqa, R.drawable.topic_rank_other_bg);
                }
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_index);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds16), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.bOU.setText(aVar.bJi);
                if (aVar.bJh == 0) {
                    this.gqb.setText("NEW");
                } else {
                    this.gqb.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.aH(aVar.bJh)));
                }
                if (aVar.gpL == null) {
                    this.gqf.setVisibility(8);
                } else {
                    this.gqf.setVisibility(0);
                    this.gqf.setData(aVar.gpL);
                }
            } else {
                this.gqh.setVisibility(0);
                this.gqa.setVisibility(8);
                this.gqb.setVisibility(8);
                this.gqf.setVisibility(8);
                this.gqj.setMargins(0, l.g(getContext(), R.dimen.tbds44), 0, 0);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_icon);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds30), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.mTitleView.setTextSize(0, l.g(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.bJi)) {
                    this.bOU.setVisibility(8);
                } else {
                    this.bOU.setVisibility(0);
                    this.bOU.setText(aVar.bJi);
                }
                am.f(this.bOU, R.color.cp_cont_b, 1);
            }
            String str = aVar.bJg;
            if (str.length() > 14) {
                str = str.substring(0, 13) + "...";
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.goo)) {
                this.gqc.setVisibility(8);
                this.gqe.setUserColor(R.color.cp_cont_d);
            } else {
                this.gqc.setVisibility(0);
                this.fby.startLoad(aVar.goo, 10, false);
                this.gqe.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.gpK == null) {
                this.gqd.setVisibility(8);
                this.gqe.setVisibility(8);
                this.gqi.setVisibility(8);
                return;
            }
            this.gqd.setVisibility(0);
            this.gqe.setVisibility(0);
            this.gqe.setData(aVar.gpK);
            this.gqi.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13351").n("topic_id", this.gqk.topicId).P("obj_locate", this.gqk.index));
        if (this.gqk != null && this.gqk.from == 1) {
            TiebaStatic.log(new an("c13449"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.gqk.topicId)));
    }

    public CellTopicLinearLayout byB() {
        return this.gpy;
    }
}

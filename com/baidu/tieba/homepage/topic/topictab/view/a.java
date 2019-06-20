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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private TextView bNn;
    private TbImageView eUD;
    private RelativeLayout euV;
    private CellTopicLinearLayout ggC;
    private TextView ghe;
    private TextView ghf;
    private RelativeLayout ghg;
    private View ghh;
    private TopicPkView ghi;
    private ThreadGodReplyLayout ghj;
    private View ghk;
    private TextView ghl;
    private View ghm;
    private LinearLayout.LayoutParams ghn;
    private com.baidu.tieba.homepage.topic.topictab.b.a gho;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ggC = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.euV = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.ghe = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.ghf = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.bNn = (TextView) view.findViewById(R.id.cell_topic_des);
        this.ghg = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.eUD = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.ghh = view.findViewById(R.id.cell_topic_img_placeholder);
        this.ghi = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.ghj = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.ghk = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.ghl = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.ghm = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.eUD.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.eUD.setLayoutParams(layoutParams);
        this.eUD.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.eUD.setConrers(15);
        this.ghn = (LinearLayout.LayoutParams) this.euV.getLayoutParams();
        this.ggC.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ghi.onChangeSkinType();
        this.ghj.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.ghe, R.color.cp_cont_m);
            al.j(this.mTitleView, R.color.cp_cont_b);
            al.j(this.ghf, R.color.cp_cont_d);
            if (this.gho != null && this.gho.from == 1) {
                al.j(this.bNn, R.color.cp_cont_b);
            } else {
                al.j(this.bNn, R.color.cp_cont_f);
            }
            this.eUD.setIsNight(this.mSkinType == 1);
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
            this.gho = aVar;
            if (aVar.from == 0) {
                this.ghl.setVisibility(8);
                this.ghe.setVisibility(0);
                this.ghf.setVisibility(0);
                this.ghe.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    al.k(this.ghe, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    al.k(this.ghe, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    al.k(this.ghe, R.drawable.topic_rank_three_bg);
                } else {
                    al.k(this.ghe, R.drawable.topic_rank_other_bg);
                }
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_index);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds16), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.bNn.setText(aVar.bHF);
                if (aVar.bHE == 0) {
                    this.ghf.setText("NEW");
                } else {
                    this.ghf.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), ap.aG(aVar.bHE)));
                }
                if (aVar.ggP == null) {
                    this.ghj.setVisibility(8);
                } else {
                    this.ghj.setVisibility(0);
                    this.ghj.setData(aVar.ggP);
                }
            } else {
                this.ghl.setVisibility(0);
                this.ghe.setVisibility(8);
                this.ghf.setVisibility(8);
                this.ghj.setVisibility(8);
                this.ghn.setMargins(0, l.g(getContext(), R.dimen.tbds44), 0, 0);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_icon);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds30), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.mTitleView.setTextSize(0, l.g(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.bHF)) {
                    this.bNn.setVisibility(8);
                } else {
                    this.bNn.setVisibility(0);
                    this.bNn.setText(aVar.bHF);
                }
                al.f(this.bNn, R.color.cp_cont_b, 1);
            }
            String str = aVar.bHD;
            if (str.length() > 14) {
                str = str.substring(0, 13) + "...";
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.gfr)) {
                this.ghg.setVisibility(8);
                this.ghi.setUserColor(R.color.cp_cont_d);
            } else {
                this.ghg.setVisibility(0);
                this.eUD.startLoad(aVar.gfr, 10, false);
                this.ghi.setUserColor(R.color.cp_btn_a);
            }
            if (aVar.ggO == null) {
                this.ghh.setVisibility(8);
                this.ghi.setVisibility(8);
                this.ghm.setVisibility(8);
                return;
            }
            this.ghh.setVisibility(0);
            this.ghi.setVisibility(0);
            this.ghi.setData(aVar.ggO);
            this.ghm.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13351").l("topic_id", this.gho.topicId).P("obj_locate", this.gho.index));
        if (this.gho != null && this.gho.from == 1) {
            TiebaStatic.log(new am("c13449"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.gho.topicId)));
    }

    public CellTopicLinearLayout buU() {
        return this.ggC;
    }
}

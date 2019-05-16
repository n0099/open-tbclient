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
    private TextView bNm;
    private TbImageView eUC;
    private RelativeLayout euU;
    private CellTopicLinearLayout ggz;
    private TextView ghb;
    private TextView ghc;
    private RelativeLayout ghd;
    private View ghe;
    private TopicPkView ghf;
    private ThreadGodReplyLayout ghg;
    private View ghh;
    private TextView ghi;
    private View ghj;
    private LinearLayout.LayoutParams ghk;
    private com.baidu.tieba.homepage.topic.topictab.b.a ghl;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ggz = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.euU = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.ghb = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.ghc = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.bNm = (TextView) view.findViewById(R.id.cell_topic_des);
        this.ghd = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.eUC = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.ghe = view.findViewById(R.id.cell_topic_img_placeholder);
        this.ghf = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.ghg = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.ghh = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.ghi = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.ghj = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.eUC.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.eUC.setLayoutParams(layoutParams);
        this.eUC.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.eUC.setConrers(15);
        this.ghk = (LinearLayout.LayoutParams) this.euU.getLayoutParams();
        this.ggz.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ghf.onChangeSkinType();
        this.ghg.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.ghb, R.color.cp_cont_m);
            al.j(this.mTitleView, R.color.cp_cont_b);
            al.j(this.ghc, R.color.cp_cont_d);
            if (this.ghl != null && this.ghl.from == 1) {
                al.j(this.bNm, R.color.cp_cont_b);
            } else {
                al.j(this.bNm, R.color.cp_cont_f);
            }
            this.eUC.setIsNight(this.mSkinType == 1);
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
            this.ghl = aVar;
            if (aVar.from == 0) {
                this.ghi.setVisibility(8);
                this.ghb.setVisibility(0);
                this.ghc.setVisibility(0);
                this.ghb.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    al.k(this.ghb, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    al.k(this.ghb, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    al.k(this.ghb, R.drawable.topic_rank_three_bg);
                } else {
                    al.k(this.ghb, R.drawable.topic_rank_other_bg);
                }
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_index);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds16), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.bNm.setText(aVar.bHE);
                if (aVar.bHD == 0) {
                    this.ghc.setText("NEW");
                } else {
                    this.ghc.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), ap.aG(aVar.bHD)));
                }
                if (aVar.ggM == null) {
                    this.ghg.setVisibility(8);
                } else {
                    this.ghg.setVisibility(0);
                    this.ghg.setData(aVar.ggM);
                }
            } else {
                this.ghi.setVisibility(0);
                this.ghb.setVisibility(8);
                this.ghc.setVisibility(8);
                this.ghg.setVisibility(8);
                this.ghk.setMargins(0, l.g(getContext(), R.dimen.tbds44), 0, 0);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_icon);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds30), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.mTitleView.setTextSize(0, l.g(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.bHE)) {
                    this.bNm.setVisibility(8);
                } else {
                    this.bNm.setVisibility(0);
                    this.bNm.setText(aVar.bHE);
                }
                al.f(this.bNm, R.color.cp_cont_b, 1);
            }
            String str = aVar.bHC;
            if (str.length() > 14) {
                str = str.substring(0, 13) + "...";
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.gfo)) {
                this.ghd.setVisibility(8);
                this.ghf.setUserColor(R.color.cp_cont_d);
            } else {
                this.ghd.setVisibility(0);
                this.eUC.startLoad(aVar.gfo, 10, false);
                this.ghf.setUserColor(R.color.cp_btn_a);
            }
            if (aVar.ggL == null) {
                this.ghe.setVisibility(8);
                this.ghf.setVisibility(8);
                this.ghj.setVisibility(8);
                return;
            }
            this.ghe.setVisibility(0);
            this.ghf.setVisibility(0);
            this.ghf.setData(aVar.ggL);
            this.ghj.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13351").l("topic_id", this.ghl.topicId).P("obj_locate", this.ghl.index));
        if (this.ghl != null && this.ghl.from == 1) {
            TiebaStatic.log(new am("c13449"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.ghl.topicId)));
    }

    public CellTopicLinearLayout buQ() {
        return this.ggz;
    }
}

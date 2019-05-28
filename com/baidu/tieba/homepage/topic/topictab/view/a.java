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
    private TbImageView eUD;
    private RelativeLayout euV;
    private CellTopicLinearLayout ggA;
    private TextView ghc;
    private TextView ghd;
    private RelativeLayout ghe;
    private View ghf;
    private TopicPkView ghg;
    private ThreadGodReplyLayout ghh;
    private View ghi;
    private TextView ghj;
    private View ghk;
    private LinearLayout.LayoutParams ghl;
    private com.baidu.tieba.homepage.topic.topictab.b.a ghm;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ggA = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.euV = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.ghc = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.ghd = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.bNm = (TextView) view.findViewById(R.id.cell_topic_des);
        this.ghe = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.eUD = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.ghf = view.findViewById(R.id.cell_topic_img_placeholder);
        this.ghg = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.ghh = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.ghi = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.ghj = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.ghk = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.eUD.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.eUD.setLayoutParams(layoutParams);
        this.eUD.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.eUD.setConrers(15);
        this.ghl = (LinearLayout.LayoutParams) this.euV.getLayoutParams();
        this.ggA.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.ghg.onChangeSkinType();
        this.ghh.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.ghc, R.color.cp_cont_m);
            al.j(this.mTitleView, R.color.cp_cont_b);
            al.j(this.ghd, R.color.cp_cont_d);
            if (this.ghm != null && this.ghm.from == 1) {
                al.j(this.bNm, R.color.cp_cont_b);
            } else {
                al.j(this.bNm, R.color.cp_cont_f);
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
            this.ghm = aVar;
            if (aVar.from == 0) {
                this.ghj.setVisibility(8);
                this.ghc.setVisibility(0);
                this.ghd.setVisibility(0);
                this.ghc.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    al.k(this.ghc, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    al.k(this.ghc, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    al.k(this.ghc, R.drawable.topic_rank_three_bg);
                } else {
                    al.k(this.ghc, R.drawable.topic_rank_other_bg);
                }
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_index);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds16), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.bNm.setText(aVar.bHE);
                if (aVar.bHD == 0) {
                    this.ghd.setText("NEW");
                } else {
                    this.ghd.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), ap.aG(aVar.bHD)));
                }
                if (aVar.ggN == null) {
                    this.ghh.setVisibility(8);
                } else {
                    this.ghh.setVisibility(0);
                    this.ghh.setData(aVar.ggN);
                }
            } else {
                this.ghj.setVisibility(0);
                this.ghc.setVisibility(8);
                this.ghd.setVisibility(8);
                this.ghh.setVisibility(8);
                this.ghl.setMargins(0, l.g(getContext(), R.dimen.tbds44), 0, 0);
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
            if (StringUtils.isNull(aVar.gfp)) {
                this.ghe.setVisibility(8);
                this.ghg.setUserColor(R.color.cp_cont_d);
            } else {
                this.ghe.setVisibility(0);
                this.eUD.startLoad(aVar.gfp, 10, false);
                this.ghg.setUserColor(R.color.cp_btn_a);
            }
            if (aVar.ggM == null) {
                this.ghf.setVisibility(8);
                this.ghg.setVisibility(8);
                this.ghk.setVisibility(8);
                return;
            }
            this.ghf.setVisibility(0);
            this.ghg.setVisibility(0);
            this.ghg.setData(aVar.ggM);
            this.ghk.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13351").l("topic_id", this.ghm.topicId).P("obj_locate", this.ghm.index));
        if (this.ghm != null && this.ghm.from == 1) {
            TiebaStatic.log(new am("c13449"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.ghm.topicId)));
    }

    public CellTopicLinearLayout buT() {
        return this.ggA;
    }
}

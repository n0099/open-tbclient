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
    private TextView bOt;
    private RelativeLayout eAb;
    private TbImageView eZS;
    private CellTopicLinearLayout gnH;
    private TextView goj;
    private TextView gok;
    private RelativeLayout gol;
    private View gom;
    private TopicPkView gon;
    private ThreadGodReplyLayout goo;
    private View gop;
    private TextView goq;
    private View gor;
    private LinearLayout.LayoutParams gos;
    private com.baidu.tieba.homepage.topic.topictab.b.a got;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gnH = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.eAb = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.goj = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.gok = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.bOt = (TextView) view.findViewById(R.id.cell_topic_des);
        this.gol = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.eZS = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.gom = view.findViewById(R.id.cell_topic_img_placeholder);
        this.gon = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.goo = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.gop = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.goq = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.gor = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.eZS.getLayoutParams();
        layoutParams.height = ((l.af(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.eZS.setLayoutParams(layoutParams);
        this.eZS.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.eZS.setConrers(15);
        this.gos = (LinearLayout.LayoutParams) this.eAb.getLayoutParams();
        this.gnH.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gon.onChangeSkinType();
        this.goo.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.j(this.goj, R.color.cp_cont_m);
            am.j(this.mTitleView, R.color.cp_cont_b);
            am.j(this.gok, R.color.cp_cont_d);
            if (this.got != null && this.got.from == 1) {
                am.j(this.bOt, R.color.cp_cont_b);
            } else {
                am.j(this.bOt, R.color.cp_cont_f);
            }
            this.eZS.setIsNight(this.mSkinType == 1);
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
            this.got = aVar;
            if (aVar.from == 0) {
                this.goq.setVisibility(8);
                this.goj.setVisibility(0);
                this.gok.setVisibility(0);
                this.goj.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.k(this.goj, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.k(this.goj, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.k(this.goj, R.drawable.topic_rank_three_bg);
                } else {
                    am.k(this.goj, R.drawable.topic_rank_other_bg);
                }
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_index);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds16), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.bOt.setText(aVar.bIK);
                if (aVar.bIJ == 0) {
                    this.gok.setText("NEW");
                } else {
                    this.gok.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.aH(aVar.bIJ)));
                }
                if (aVar.gnU == null) {
                    this.goo.setVisibility(8);
                } else {
                    this.goo.setVisibility(0);
                    this.goo.setData(aVar.gnU);
                }
            } else {
                this.goq.setVisibility(0);
                this.goj.setVisibility(8);
                this.gok.setVisibility(8);
                this.goo.setVisibility(8);
                this.gos.setMargins(0, l.g(getContext(), R.dimen.tbds44), 0, 0);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).addRule(1, R.id.cell_topic_icon);
                ((RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams()).setMargins(l.g(getContext(), R.dimen.tbds30), 0, l.g(getContext(), R.dimen.tbds16), 0);
                this.mTitleView.setTextSize(0, l.g(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.bIK)) {
                    this.bOt.setVisibility(8);
                } else {
                    this.bOt.setVisibility(0);
                    this.bOt.setText(aVar.bIK);
                }
                am.f(this.bOt, R.color.cp_cont_b, 1);
            }
            String str = aVar.bII;
            if (str.length() > 14) {
                str = str.substring(0, 13) + "...";
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.gmx)) {
                this.gol.setVisibility(8);
                this.gon.setUserColor(R.color.cp_cont_d);
            } else {
                this.gol.setVisibility(0);
                this.eZS.startLoad(aVar.gmx, 10, false);
                this.gon.setUserColor(R.color.cp_btn_a);
            }
            if (aVar.gnT == null) {
                this.gom.setVisibility(8);
                this.gon.setVisibility(8);
                this.gor.setVisibility(8);
                return;
            }
            this.gom.setVisibility(0);
            this.gon.setVisibility(0);
            this.gon.setData(aVar.gnT);
            this.gor.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13351").l("topic_id", this.got.topicId).P("obj_locate", this.got.index));
        if (this.got != null && this.got.from == 1) {
            TiebaStatic.log(new an("c13449"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.got.topicId)));
    }

    public CellTopicLinearLayout bxN() {
        return this.gnH;
    }
}

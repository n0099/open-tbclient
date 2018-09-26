package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class q extends a<com.baidu.tieba.card.data.n> {
    private TextView adB;
    private TextView cFa;
    private LinearLayout cFb;
    private LinearLayout cFc;
    private LinearLayout cFd;
    private LinearLayout cFe;
    private TextView cFf;
    private TextView cFg;
    private TextView cFh;
    private TextView cFi;
    private View cFj;
    private View cFk;
    private View cFl;
    private View cFm;
    private com.baidu.tieba.card.data.n cFn;
    private String cFo;
    private String cFp;
    private View cqY;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.home_card_hot_topic_root_view);
        this.adB = (TextView) view.findViewById(e.g.home_card_topic_title);
        this.cFa = (TextView) view.findViewById(e.g.home_card_topic_more);
        this.cFb = (LinearLayout) view.findViewById(e.g.home_card_topic_group_one);
        this.cFc = (LinearLayout) view.findViewById(e.g.home_card_topic_group_two);
        this.cFd = (LinearLayout) view.findViewById(e.g.home_card_topic_group_three);
        this.cFe = (LinearLayout) view.findViewById(e.g.home_card_topic_group_four);
        this.cFf = (TextView) view.findViewById(e.g.home_card_topic_one);
        this.cFg = (TextView) view.findViewById(e.g.home_card_topic_two);
        this.cFh = (TextView) view.findViewById(e.g.home_card_topic_three);
        this.cFi = (TextView) view.findViewById(e.g.home_card_topic_four);
        this.cFj = view.findViewById(e.g.home_top_div);
        this.cFk = view.findViewById(e.g.home_top_topic_div_one);
        this.cFl = view.findViewById(e.g.home_top_topic_div_two);
        this.cFm = view.findViewById(e.g.home_card_top_divider_line);
        this.cqY = view.findViewById(e.g.home_card_bottom_divider_line);
        this.cFb.setOnClickListener(this);
        this.cFc.setOnClickListener(this);
        this.cFd.setOnClickListener(this);
        this.cFe.setOnClickListener(this);
        this.cFa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.cFo = str;
        this.cFp = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int l = com.baidu.adp.lib.g.b.l((String) view.getTag(), -1);
        if (this.cFn != null && com.baidu.tbadk.core.util.v.d(this.cFn.cIo, l) != null) {
            TiebaStatic.log(new am(this.cFp).al("obj_locate", String.valueOf(this.cFn.bzJ)).al("obj_name", this.cFn.cIo.get(l).ajD));
            if (l >= 0 && !com.baidu.tbadk.plugins.b.e(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.cFn.cIo.get(l).ajC), this.cFn.cIo.get(l).ajD, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.adB, e.d.cp_cont_d, 1);
            al.c(this.cFa, e.d.cp_cont_d, 1);
            al.c(this.cFf, e.d.cp_cont_b, 1);
            al.c(this.cFg, e.d.cp_cont_b, 1);
            al.c(this.cFh, e.d.cp_cont_b, 1);
            al.c(this.cFi, e.d.cp_cont_b, 1);
            al.i(this.cFj, e.d.cp_bg_line_b);
            al.i(this.cFk, e.d.cp_bg_line_b);
            al.i(this.cFl, e.d.cp_bg_line_b);
            al.i(this.cFm, e.d.cp_bg_line_c);
            al.i(this.cqY, e.d.cp_bg_line_c);
            al.i(this.cFb, e.f.card_topic_click_selector);
            al.i(this.cFc, e.f.card_topic_click_selector);
            al.i(this.cFd, e.f.card_topic_click_selector);
            al.i(this.cFe, e.f.card_topic_click_selector);
            k(this.cFf, 0);
            k(this.cFg, 1);
            k(this.cFh, 2);
            k(this.cFi, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.cIn) || com.baidu.tbadk.core.util.v.y(nVar.cIo) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cFn = nVar;
        this.cFm.setVisibility(this.cFn.cIl ? 0 : 8);
        showBottomLine(this.cFn.cIm);
        this.adB.setText(this.cFn.cIn.trim());
        j(this.cFf, 0);
        j(this.cFg, 1);
        j(this.cFh, 2);
        j(this.cFi, 3);
        k(this.cFf, 0);
        k(this.cFg, 1);
        k(this.cFh, 2);
        k(this.cFi, 3);
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.cFn.cIo.get(i);
        if (!StringUtils.isNull(mVar.ajD)) {
            textView.setText(mVar.ajD.trim());
        }
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.cFn != null && com.baidu.tbadk.core.util.v.y(this.cFn.cIo) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.d(this.cFn.cIo, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.cqY.setVisibility(0);
        } else {
            this.cqY.setVisibility(8);
        }
    }

    public void jr(int i) {
        ViewGroup.LayoutParams layoutParams = this.cFm.getLayoutParams();
        layoutParams.height = i;
        this.cFm.setLayoutParams(layoutParams);
    }
}

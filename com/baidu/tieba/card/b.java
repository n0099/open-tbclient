package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout bra;
    protected TextView brb;
    public TextView brc;
    public TextView brd;
    private View bre;
    private View brf;
    private View brg;
    public ImageView brh;
    public LinearLayout bri;
    public View brj;
    public View brk;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bra = null;
        this.brb = null;
        this.brc = null;
        this.brd = null;
        this.bre = null;
        this.brf = null;
        this.brg = null;
        this.bri = null;
        P(getView());
    }

    private void P(View view) {
        this.bra = (RelativeLayout) view.findViewById(w.h.item_layout_group_title);
        this.brb = (TextView) view.findViewById(w.h.item_group_title);
        this.brc = (TextView) view.findViewById(w.h.item_right_tv);
        this.brd = (TextView) view.findViewById(w.h.item_bottom_more_tv);
        this.bre = view.findViewById(w.h.divider_line_top);
        this.brf = view.findViewById(w.h.divider_line_middle);
        this.brg = view.findViewById(w.h.divider_line_bottom);
        this.bri = (LinearLayout) view.findViewById(w.h.card_container);
        this.brj = view.findViewById(w.h.divider_card);
        this.brk = view.findViewById(w.h.divider_card_top);
        this.brh = (ImageView) view.findViewById(w.h.item_right_arrow);
    }

    private void SE() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.aq.c(this.brb, w.e.cp_cont_d, 1);
            this.brh.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.brb, w.e.cp_cont_f, 1);
            com.baidu.tbadk.core.util.aq.c(this.brh, w.g.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.aq.c(this.brc, w.e.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.aq.c(this.brd, w.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.aq.k(this.bre, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.brf, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.brg, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.brj, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.brk, w.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SE();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.brb.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.brc.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.brk.setVisibility(0);
        } else {
            this.brk.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.brj.setVisibility(0);
        } else {
            this.brj.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.brd.setVisibility(0);
            this.brg.setVisibility(0);
            this.brf.setVisibility(0);
            this.brd.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.brd.setTag(str);
                this.brd.setOnClickListener(this);
                return;
            }
            return;
        }
        this.brd.setVisibility(8);
        this.brg.setVisibility(8);
        this.brf.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.brd == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bb.wn().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return w.j.card_group;
    }

    public void gH(int i) {
        if (this.bre != null && this.bre.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bre.getLayoutParams();
            layoutParams.height = i;
            this.bre.setLayoutParams(layoutParams);
        }
        if (this.brf != null && this.brf.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.brf.getLayoutParams();
            layoutParams2.height = i;
            this.brf.setLayoutParams(layoutParams2);
        }
        if (this.brg != null && this.brg.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.brg.getLayoutParams();
            layoutParams3.height = i;
            this.brg.setLayoutParams(layoutParams3);
        }
    }

    public void cN(boolean z) {
        if (this.brj != null) {
            this.brj.setVisibility(z ? 0 : 8);
        }
    }
}

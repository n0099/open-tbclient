package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.a.a> extends a<T> {
    protected RelativeLayout aRo;
    protected TextView aRp;
    public TextView aRq;
    public TextView aRr;
    private View aRs;
    private View aRt;
    private View aRu;
    public ImageView aRv;
    public LinearLayout aRw;
    public View aRx;
    public View aRy;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aRo = null;
        this.aRp = null;
        this.aRq = null;
        this.aRr = null;
        this.aRs = null;
        this.aRt = null;
        this.aRu = null;
        this.aRw = null;
        Q(getView());
    }

    private void Q(View view) {
        this.aRo = (RelativeLayout) view.findViewById(u.g.item_layout_group_title);
        this.aRp = (TextView) view.findViewById(u.g.item_group_title);
        this.aRq = (TextView) view.findViewById(u.g.item_right_tv);
        this.aRr = (TextView) view.findViewById(u.g.item_bottom_more_tv);
        this.aRs = view.findViewById(u.g.divider_line_top);
        this.aRt = view.findViewById(u.g.divider_line_middle);
        this.aRu = view.findViewById(u.g.divider_line_bottom);
        this.aRw = (LinearLayout) view.findViewById(u.g.card_container);
        this.aRx = view.findViewById(u.g.divider_card);
        this.aRy = view.findViewById(u.g.divider_card_top);
        this.aRv = (ImageView) view.findViewById(u.g.item_right_arrow);
    }

    private void KP() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.av.c(this.aRp, u.d.cp_cont_d, 1);
            this.aRv.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.av.c(this.aRp, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(this.aRv, u.f.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.av.c(this.aRq, u.d.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.av.c(this.aRr, u.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.av.l(getView(), u.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.av.l(this.aRs, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aRt, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aRu, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aRx, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aRy, u.d.cp_bg_line_c);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            KP();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.aRp.setText(t.aUO);
        if (t.aUP > 0) {
            this.aRq.setBackgroundResource(t.aUP);
        }
        if (t.aUS) {
            this.aRy.setVisibility(0);
        } else {
            this.aRy.setVisibility(8);
        }
        if (!StringUtils.isNull(t.aUQ)) {
            this.aRr.setVisibility(0);
            this.aRu.setVisibility(0);
            this.aRt.setVisibility(0);
            this.aRr.setText(t.aUQ);
            String str = t.aUR;
            if (!StringUtils.isNull(str)) {
                this.aRr.setTag(str);
                this.aRr.setOnClickListener(this);
                return;
            }
            return;
        }
        this.aRr.setVisibility(8);
        this.aRu.setVisibility(8);
        this.aRt.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aRr == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bi.us().c(KN(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return u.h.card_group;
    }

    public void fE(int i) {
        if (this.aRs != null && this.aRs.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aRs.getLayoutParams();
            layoutParams.height = i;
            this.aRs.setLayoutParams(layoutParams);
        }
        if (this.aRt != null && this.aRt.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.aRt.getLayoutParams();
            layoutParams2.height = i;
            this.aRt.setLayoutParams(layoutParams2);
        }
        if (this.aRu != null && this.aRu.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.aRu.getLayoutParams();
            layoutParams3.height = i;
            this.aRu.setLayoutParams(layoutParams3);
        }
    }

    public void ci(boolean z) {
        if (this.aRx != null) {
            this.aRx.setVisibility(z ? 0 : 8);
        }
    }
}

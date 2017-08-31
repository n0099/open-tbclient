package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout bJf;
    protected TextView bJg;
    public TextView bJh;
    public TextView bJi;
    private View bJj;
    private View bJk;
    private View bJl;
    public ImageView bJm;
    public LinearLayout bJn;
    public View bJo;
    public View bJp;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJf = null;
        this.bJg = null;
        this.bJh = null;
        this.bJi = null;
        this.bJj = null;
        this.bJk = null;
        this.bJl = null;
        this.bJn = null;
        X(getView());
    }

    private void X(View view) {
        this.bJf = (RelativeLayout) view.findViewById(d.h.item_layout_group_title);
        this.bJg = (TextView) view.findViewById(d.h.item_group_title);
        this.bJh = (TextView) view.findViewById(d.h.item_right_tv);
        this.bJi = (TextView) view.findViewById(d.h.item_bottom_more_tv);
        this.bJj = view.findViewById(d.h.divider_line_top);
        this.bJk = view.findViewById(d.h.divider_line_middle);
        this.bJl = view.findViewById(d.h.divider_line_bottom);
        this.bJn = (LinearLayout) view.findViewById(d.h.card_container);
        this.bJo = view.findViewById(d.h.divider_card);
        this.bJp = view.findViewById(d.h.divider_card_top);
        this.bJm = (ImageView) view.findViewById(d.h.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void XB() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.c(this.bJg, d.e.cp_cont_d, 1);
            this.bJm.setVisibility(8);
        } else {
            aj.c(this.bJg, d.e.cp_cont_f, 1);
            aj.c(this.bJm, d.g.icon_arrow_tab);
        }
        aj.c(this.bJh, d.e.cp_link_tip_c, 1);
        aj.c(this.bJi, d.e.cp_cont_d, 1);
        aj.k(getView(), d.e.cp_bg_line_d);
        aj.k(this.bJj, d.e.cp_bg_line_c);
        aj.k(this.bJk, d.e.cp_bg_line_c);
        aj.k(this.bJl, d.e.cp_bg_line_c);
        aj.k(this.bJo, d.e.cp_bg_line_c);
        aj.k(this.bJp, d.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            XB();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bJg.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bJh.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bJp.setVisibility(0);
        } else {
            this.bJp.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bJo.setVisibility(0);
        } else {
            this.bJo.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bJi.setVisibility(0);
            this.bJl.setVisibility(0);
            this.bJk.setVisibility(0);
            this.bJi.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bJi.setTag(str);
                this.bJi.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bJi.setVisibility(8);
        this.bJl.setVisibility(8);
        this.bJk.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bJi == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                au.wd().c(Xz(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.j.card_group;
    }

    public void hE(int i) {
        if (this.bJj != null && this.bJj.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bJj.getLayoutParams();
            layoutParams.height = i;
            this.bJj.setLayoutParams(layoutParams);
        }
        if (this.bJk != null && this.bJk.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bJk.getLayoutParams();
            layoutParams2.height = i;
            this.bJk.setLayoutParams(layoutParams2);
        }
        if (this.bJl != null && this.bJl.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bJl.getLayoutParams();
            layoutParams3.height = i;
            this.bJl.setLayoutParams(layoutParams3);
        }
    }

    public void dG(boolean z) {
        if (this.bJo != null) {
            this.bJo.setVisibility(z ? 0 : 8);
        }
    }
}

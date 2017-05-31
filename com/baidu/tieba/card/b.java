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
    public View bzA;
    public View bzB;
    protected RelativeLayout bzr;
    protected TextView bzs;
    public TextView bzt;
    public TextView bzu;
    private View bzv;
    private View bzw;
    private View bzx;
    public ImageView bzy;
    public LinearLayout bzz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bzr = null;
        this.bzs = null;
        this.bzt = null;
        this.bzu = null;
        this.bzv = null;
        this.bzw = null;
        this.bzx = null;
        this.bzz = null;
        N(getView());
    }

    private void N(View view) {
        this.bzr = (RelativeLayout) view.findViewById(w.h.item_layout_group_title);
        this.bzs = (TextView) view.findViewById(w.h.item_group_title);
        this.bzt = (TextView) view.findViewById(w.h.item_right_tv);
        this.bzu = (TextView) view.findViewById(w.h.item_bottom_more_tv);
        this.bzv = view.findViewById(w.h.divider_line_top);
        this.bzw = view.findViewById(w.h.divider_line_middle);
        this.bzx = view.findViewById(w.h.divider_line_bottom);
        this.bzz = (LinearLayout) view.findViewById(w.h.card_container);
        this.bzA = view.findViewById(w.h.divider_card);
        this.bzB = view.findViewById(w.h.divider_card_top);
        this.bzy = (ImageView) view.findViewById(w.h.item_right_arrow);
    }

    private void Ue() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.aq.c(this.bzs, w.e.cp_cont_d, 1);
            this.bzy.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.bzs, w.e.cp_cont_f, 1);
            com.baidu.tbadk.core.util.aq.c(this.bzy, w.g.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.aq.c(this.bzt, w.e.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.aq.c(this.bzu, w.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.aq.k(this.bzv, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.bzw, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.bzx, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.bzA, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.bzB, w.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Ue();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bzs.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bzt.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bzB.setVisibility(0);
        } else {
            this.bzB.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bzA.setVisibility(0);
        } else {
            this.bzA.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bzu.setVisibility(0);
            this.bzx.setVisibility(0);
            this.bzw.setVisibility(0);
            this.bzu.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bzu.setTag(str);
                this.bzu.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bzu.setVisibility(8);
        this.bzx.setVisibility(8);
        this.bzw.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bzu == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bb.vy().c(Uc(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return w.j.card_group;
    }

    public void hi(int i) {
        if (this.bzv != null && this.bzv.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bzv.getLayoutParams();
            layoutParams.height = i;
            this.bzv.setLayoutParams(layoutParams);
        }
        if (this.bzw != null && this.bzw.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bzw.getLayoutParams();
            layoutParams2.height = i;
            this.bzw.setLayoutParams(layoutParams2);
        }
        if (this.bzx != null && this.bzx.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bzx.getLayoutParams();
            layoutParams3.height = i;
            this.bzx.setLayoutParams(layoutParams3);
        }
    }

    public void dq(boolean z) {
        if (this.bzA != null) {
            this.bzA.setVisibility(z ? 0 : 8);
        }
    }
}

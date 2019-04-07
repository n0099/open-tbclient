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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout efg;
    protected TextView efh;
    public TextView efi;
    public TextView efj;
    private View efk;
    private View efl;
    private View efm;
    public ImageView efn;
    public LinearLayout efo;
    public View efp;
    public View efq;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.efg = null;
        this.efh = null;
        this.efi = null;
        this.efj = null;
        this.efk = null;
        this.efl = null;
        this.efm = null;
        this.efo = null;
        O(getView());
    }

    private void O(View view) {
        this.efg = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.efh = (TextView) view.findViewById(d.g.item_group_title);
        this.efi = (TextView) view.findViewById(d.g.item_right_tv);
        this.efj = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.efk = view.findViewById(d.g.divider_line_top);
        this.efl = view.findViewById(d.g.divider_line_middle);
        this.efm = view.findViewById(d.g.divider_line_bottom);
        this.efo = (LinearLayout) view.findViewById(d.g.card_container);
        this.efp = view.findViewById(d.g.divider_card);
        this.efq = view.findViewById(d.g.divider_card_top);
        this.efn = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aQg() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.d(this.efh, d.C0277d.cp_cont_d, 1);
            this.efn.setVisibility(8);
        } else {
            al.d(this.efh, d.C0277d.cp_cont_f, 1);
            al.c(this.efn, d.f.icon_arrow_tab);
        }
        al.d(this.efi, d.C0277d.cp_link_tip_c, 1);
        al.d(this.efj, d.C0277d.cp_cont_d, 1);
        al.l(getView(), d.C0277d.cp_bg_line_d);
        al.l(this.efk, d.C0277d.cp_bg_line_c);
        al.l(this.efl, d.C0277d.cp_bg_line_c);
        al.l(this.efm, d.C0277d.cp_bg_line_c);
        al.l(this.efp, d.C0277d.cp_bg_line_c);
        al.l(this.efq, d.C0277d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aQg();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.efh.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.efi.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.efq.setVisibility(0);
        } else {
            this.efq.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.efp.setVisibility(0);
        } else {
            this.efp.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.efj.setVisibility(0);
            this.efm.setVisibility(0);
            this.efl.setVisibility(0);
            this.efj.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.efj.setTag(str);
                this.efj.setOnClickListener(this);
                return;
            }
            return;
        }
        this.efj.setVisibility(8);
        this.efm.setVisibility(8);
        this.efl.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.efj == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.adA().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void og(int i) {
        if (this.efk != null && this.efk.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.efk.getLayoutParams();
            layoutParams.height = i;
            this.efk.setLayoutParams(layoutParams);
        }
        if (this.efl != null && this.efl.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.efl.getLayoutParams();
            layoutParams2.height = i;
            this.efl.setLayoutParams(layoutParams2);
        }
        if (this.efm != null && this.efm.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.efm.getLayoutParams();
            layoutParams3.height = i;
            this.efm.setLayoutParams(layoutParams3);
        }
    }

    public void hJ(boolean z) {
        if (this.efp != null) {
            this.efp.setVisibility(z ? 0 : 8);
        }
    }
}

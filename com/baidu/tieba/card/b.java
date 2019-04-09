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
    protected RelativeLayout efh;
    protected TextView efi;
    public TextView efj;
    public TextView efk;
    private View efl;
    private View efm;
    private View efn;
    public ImageView efo;
    public LinearLayout efp;
    public View efq;
    public View efr;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.efh = null;
        this.efi = null;
        this.efj = null;
        this.efk = null;
        this.efl = null;
        this.efm = null;
        this.efn = null;
        this.efp = null;
        O(getView());
    }

    private void O(View view) {
        this.efh = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.efi = (TextView) view.findViewById(d.g.item_group_title);
        this.efj = (TextView) view.findViewById(d.g.item_right_tv);
        this.efk = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.efl = view.findViewById(d.g.divider_line_top);
        this.efm = view.findViewById(d.g.divider_line_middle);
        this.efn = view.findViewById(d.g.divider_line_bottom);
        this.efp = (LinearLayout) view.findViewById(d.g.card_container);
        this.efq = view.findViewById(d.g.divider_card);
        this.efr = view.findViewById(d.g.divider_card_top);
        this.efo = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aQg() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.d(this.efi, d.C0277d.cp_cont_d, 1);
            this.efo.setVisibility(8);
        } else {
            al.d(this.efi, d.C0277d.cp_cont_f, 1);
            al.c(this.efo, d.f.icon_arrow_tab);
        }
        al.d(this.efj, d.C0277d.cp_link_tip_c, 1);
        al.d(this.efk, d.C0277d.cp_cont_d, 1);
        al.l(getView(), d.C0277d.cp_bg_line_d);
        al.l(this.efl, d.C0277d.cp_bg_line_c);
        al.l(this.efm, d.C0277d.cp_bg_line_c);
        al.l(this.efn, d.C0277d.cp_bg_line_c);
        al.l(this.efq, d.C0277d.cp_bg_line_c);
        al.l(this.efr, d.C0277d.cp_bg_line_c);
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
        this.efi.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.efj.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.efr.setVisibility(0);
        } else {
            this.efr.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.efq.setVisibility(0);
        } else {
            this.efq.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.efk.setVisibility(0);
            this.efn.setVisibility(0);
            this.efm.setVisibility(0);
            this.efk.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.efk.setTag(str);
                this.efk.setOnClickListener(this);
                return;
            }
            return;
        }
        this.efk.setVisibility(8);
        this.efn.setVisibility(8);
        this.efm.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.efk == view && view != null && (view.getTag() instanceof String)) {
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
        if (this.efl != null && this.efl.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.efl.getLayoutParams();
            layoutParams.height = i;
            this.efl.setLayoutParams(layoutParams);
        }
        if (this.efm != null && this.efm.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.efm.getLayoutParams();
            layoutParams2.height = i;
            this.efm.setLayoutParams(layoutParams2);
        }
        if (this.efn != null && this.efn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.efn.getLayoutParams();
            layoutParams3.height = i;
            this.efn.setLayoutParams(layoutParams3);
        }
    }

    public void hJ(boolean z) {
        if (this.efq != null) {
            this.efq.setVisibility(z ? 0 : 8);
        }
    }
}

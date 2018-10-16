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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    public LinearLayout cKA;
    public View cKB;
    public View cKC;
    protected RelativeLayout cKs;
    protected TextView cKt;
    public TextView cKu;
    public TextView cKv;
    private View cKw;
    private View cKx;
    private View cKy;
    public ImageView cKz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cKs = null;
        this.cKt = null;
        this.cKu = null;
        this.cKv = null;
        this.cKw = null;
        this.cKx = null;
        this.cKy = null;
        this.cKA = null;
        initView(getView());
    }

    private void initView(View view) {
        this.cKs = (RelativeLayout) view.findViewById(e.g.item_layout_group_title);
        this.cKt = (TextView) view.findViewById(e.g.item_group_title);
        this.cKu = (TextView) view.findViewById(e.g.item_right_tv);
        this.cKv = (TextView) view.findViewById(e.g.item_bottom_more_tv);
        this.cKw = view.findViewById(e.g.divider_line_top);
        this.cKx = view.findViewById(e.g.divider_line_middle);
        this.cKy = view.findViewById(e.g.divider_line_bottom);
        this.cKA = (LinearLayout) view.findViewById(e.g.card_container);
        this.cKB = view.findViewById(e.g.divider_card);
        this.cKC = view.findViewById(e.g.divider_card_top);
        this.cKz = (ImageView) view.findViewById(e.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void anP() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.c(this.cKt, e.d.cp_cont_d, 1);
            this.cKz.setVisibility(8);
        } else {
            al.c(this.cKt, e.d.cp_cont_f, 1);
            al.c(this.cKz, e.f.icon_arrow_tab);
        }
        al.c(this.cKu, e.d.cp_link_tip_c, 1);
        al.c(this.cKv, e.d.cp_cont_d, 1);
        al.j(getView(), e.d.cp_bg_line_d);
        al.j(this.cKw, e.d.cp_bg_line_c);
        al.j(this.cKx, e.d.cp_bg_line_c);
        al.j(this.cKy, e.d.cp_bg_line_c);
        al.j(this.cKB, e.d.cp_bg_line_c);
        al.j(this.cKC, e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            anP();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cKt.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cKu.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cKC.setVisibility(0);
        } else {
            this.cKC.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cKB.setVisibility(0);
        } else {
            this.cKB.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cKv.setVisibility(0);
            this.cKy.setVisibility(0);
            this.cKx.setVisibility(0);
            this.cKv.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cKv.setTag(str);
                this.cKv.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cKv.setVisibility(8);
        this.cKy.setVisibility(8);
        this.cKx.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cKv == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ay.CU().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return e.h.card_group;
    }

    public void jM(int i) {
        if (this.cKw != null && this.cKw.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cKw.getLayoutParams();
            layoutParams.height = i;
            this.cKw.setLayoutParams(layoutParams);
        }
        if (this.cKx != null && this.cKx.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cKx.getLayoutParams();
            layoutParams2.height = i;
            this.cKx.setLayoutParams(layoutParams2);
        }
        if (this.cKy != null && this.cKy.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cKy.getLayoutParams();
            layoutParams3.height = i;
            this.cKy.setLayoutParams(layoutParams3);
        }
    }

    public void fa(boolean z) {
        if (this.cKB != null) {
            this.cKB.setVisibility(z ? 0 : 8);
        }
    }
}

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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout bFB;
    protected TextView bFC;
    public TextView bFD;
    public TextView bFE;
    private View bFF;
    private View bFG;
    private View bFH;
    public ImageView bFI;
    public LinearLayout bFJ;
    public View bFK;
    public View bFL;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bFB = null;
        this.bFC = null;
        this.bFD = null;
        this.bFE = null;
        this.bFF = null;
        this.bFG = null;
        this.bFH = null;
        this.bFJ = null;
        O(getView());
    }

    private void O(View view) {
        this.bFB = (RelativeLayout) view.findViewById(d.h.item_layout_group_title);
        this.bFC = (TextView) view.findViewById(d.h.item_group_title);
        this.bFD = (TextView) view.findViewById(d.h.item_right_tv);
        this.bFE = (TextView) view.findViewById(d.h.item_bottom_more_tv);
        this.bFF = view.findViewById(d.h.divider_line_top);
        this.bFG = view.findViewById(d.h.divider_line_middle);
        this.bFH = view.findViewById(d.h.divider_line_bottom);
        this.bFJ = (LinearLayout) view.findViewById(d.h.card_container);
        this.bFK = view.findViewById(d.h.divider_card);
        this.bFL = view.findViewById(d.h.divider_card_top);
        this.bFI = (ImageView) view.findViewById(d.h.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void Wf() {
        if (getFrom() != null && getFrom().equals("home")) {
            ai.c(this.bFC, d.e.cp_cont_d, 1);
            this.bFI.setVisibility(8);
        } else {
            ai.c(this.bFC, d.e.cp_cont_f, 1);
            ai.c(this.bFI, d.g.icon_arrow_tab);
        }
        ai.c(this.bFD, d.e.cp_link_tip_c, 1);
        ai.c(this.bFE, d.e.cp_cont_d, 1);
        ai.k(getView(), d.e.cp_bg_line_d);
        ai.k(this.bFF, d.e.cp_bg_line_c);
        ai.k(this.bFG, d.e.cp_bg_line_c);
        ai.k(this.bFH, d.e.cp_bg_line_c);
        ai.k(this.bFK, d.e.cp_bg_line_c);
        ai.k(this.bFL, d.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Wf();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bFC.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bFD.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bFL.setVisibility(0);
        } else {
            this.bFL.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bFK.setVisibility(0);
        } else {
            this.bFK.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bFE.setVisibility(0);
            this.bFH.setVisibility(0);
            this.bFG.setVisibility(0);
            this.bFE.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bFE.setTag(str);
                this.bFE.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bFE.setVisibility(8);
        this.bFH.setVisibility(8);
        this.bFG.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bFE == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                at.wf().c(Wd(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.j.card_group;
    }

    public void hs(int i) {
        if (this.bFF != null && this.bFF.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bFF.getLayoutParams();
            layoutParams.height = i;
            this.bFF.setLayoutParams(layoutParams);
        }
        if (this.bFG != null && this.bFG.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bFG.getLayoutParams();
            layoutParams2.height = i;
            this.bFG.setLayoutParams(layoutParams2);
        }
        if (this.bFH != null && this.bFH.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bFH.getLayoutParams();
            layoutParams3.height = i;
            this.bFH.setLayoutParams(layoutParams3);
        }
    }

    public void dC(boolean z) {
        if (this.bFK != null) {
            this.bFK.setVisibility(z ? 0 : 8);
        }
    }
}

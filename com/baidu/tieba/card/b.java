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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout cwh;
    protected TextView cwi;
    public TextView cwj;
    public TextView cwk;
    private View cwl;
    private View cwm;
    private View cwn;
    public ImageView cwo;
    public LinearLayout cwp;
    public View cwq;
    public View cwr;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cwh = null;
        this.cwi = null;
        this.cwj = null;
        this.cwk = null;
        this.cwl = null;
        this.cwm = null;
        this.cwn = null;
        this.cwp = null;
        Y(getView());
    }

    private void Y(View view) {
        this.cwh = (RelativeLayout) view.findViewById(f.g.item_layout_group_title);
        this.cwi = (TextView) view.findViewById(f.g.item_group_title);
        this.cwj = (TextView) view.findViewById(f.g.item_right_tv);
        this.cwk = (TextView) view.findViewById(f.g.item_bottom_more_tv);
        this.cwl = view.findViewById(f.g.divider_line_top);
        this.cwm = view.findViewById(f.g.divider_line_middle);
        this.cwn = view.findViewById(f.g.divider_line_bottom);
        this.cwp = (LinearLayout) view.findViewById(f.g.card_container);
        this.cwq = view.findViewById(f.g.divider_card);
        this.cwr = view.findViewById(f.g.divider_card_top);
        this.cwo = (ImageView) view.findViewById(f.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aiD() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.c(this.cwi, f.d.cp_cont_d, 1);
            this.cwo.setVisibility(8);
        } else {
            am.c(this.cwi, f.d.cp_cont_f, 1);
            am.c(this.cwo, f.C0146f.icon_arrow_tab);
        }
        am.c(this.cwj, f.d.cp_link_tip_c, 1);
        am.c(this.cwk, f.d.cp_cont_d, 1);
        am.j(getView(), f.d.cp_bg_line_d);
        am.j(this.cwl, f.d.cp_bg_line_c);
        am.j(this.cwm, f.d.cp_bg_line_c);
        am.j(this.cwn, f.d.cp_bg_line_c);
        am.j(this.cwq, f.d.cp_bg_line_c);
        am.j(this.cwr, f.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aiD();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cwi.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cwj.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cwr.setVisibility(0);
        } else {
            this.cwr.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cwq.setVisibility(0);
        } else {
            this.cwq.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cwk.setVisibility(0);
            this.cwn.setVisibility(0);
            this.cwm.setVisibility(0);
            this.cwk.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cwk.setTag(str);
                this.cwk.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cwk.setVisibility(8);
        this.cwn.setVisibility(8);
        this.cwm.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cwk == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                az.zI().c(aiB(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return f.h.card_group;
    }

    public void iO(int i) {
        if (this.cwl != null && this.cwl.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cwl.getLayoutParams();
            layoutParams.height = i;
            this.cwl.setLayoutParams(layoutParams);
        }
        if (this.cwm != null && this.cwm.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cwm.getLayoutParams();
            layoutParams2.height = i;
            this.cwm.setLayoutParams(layoutParams2);
        }
        if (this.cwn != null && this.cwn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cwn.getLayoutParams();
            layoutParams3.height = i;
            this.cwn.setLayoutParams(layoutParams3);
        }
    }

    public void er(boolean z) {
        if (this.cwq != null) {
            this.cwq.setVisibility(z ? 0 : 8);
        }
    }
}

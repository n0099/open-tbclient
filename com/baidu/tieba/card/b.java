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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.a.a> extends a<T> {
    protected RelativeLayout aRp;
    protected TextView aRq;
    public TextView aRr;
    public TextView aRs;
    private View aRt;
    private View aRu;
    private View aRv;
    public ImageView aRw;
    public LinearLayout aRx;
    public View aRy;
    public View aRz;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aRp = null;
        this.aRq = null;
        this.aRr = null;
        this.aRs = null;
        this.aRt = null;
        this.aRu = null;
        this.aRv = null;
        this.aRx = null;
        w(getView());
    }

    private void w(View view) {
        this.aRp = (RelativeLayout) view.findViewById(t.g.item_layout_group_title);
        this.aRq = (TextView) view.findViewById(t.g.item_group_title);
        this.aRr = (TextView) view.findViewById(t.g.item_right_tv);
        this.aRs = (TextView) view.findViewById(t.g.item_bottom_more_tv);
        this.aRt = view.findViewById(t.g.divider_line_top);
        this.aRu = view.findViewById(t.g.divider_line_middle);
        this.aRv = view.findViewById(t.g.divider_line_bottom);
        this.aRx = (LinearLayout) view.findViewById(t.g.card_container);
        this.aRy = view.findViewById(t.g.divider_card);
        this.aRz = view.findViewById(t.g.divider_card_top);
        this.aRw = (ImageView) view.findViewById(t.g.item_right_arrow);
    }

    private void Lf() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.at.b(this.aRq, t.d.cp_cont_d, 1);
            this.aRw.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.at.b(this.aRq, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(this.aRw, t.f.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.at.b(this.aRr, t.d.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.at.b(this.aRs, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.l(getView(), t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.l(this.aRt, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.aRu, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.aRv, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.aRy, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.aRz, t.d.cp_bg_line_c);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Lf();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.aRq.setText(t.aVn);
        if (t.aVo > 0) {
            this.aRr.setBackgroundResource(t.aVo);
        }
        if (t.aVr) {
            this.aRz.setVisibility(0);
        } else {
            this.aRz.setVisibility(8);
        }
        if (!StringUtils.isNull(t.aVp)) {
            this.aRs.setVisibility(0);
            this.aRv.setVisibility(0);
            this.aRu.setVisibility(0);
            this.aRs.setText(t.aVp);
            String str = t.aVq;
            if (!StringUtils.isNull(str)) {
                this.aRs.setTag(str);
                this.aRs.setOnClickListener(this);
                return;
            }
            return;
        }
        this.aRs.setVisibility(8);
        this.aRv.setVisibility(8);
        this.aRu.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aRs == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bg.wM().c(Lb(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int Le() {
        return t.h.card_group;
    }

    public void fJ(int i) {
        if (this.aRt != null && this.aRt.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aRt.getLayoutParams();
            layoutParams.height = i;
            this.aRt.setLayoutParams(layoutParams);
        }
        if (this.aRu != null && this.aRu.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.aRu.getLayoutParams();
            layoutParams2.height = i;
            this.aRu.setLayoutParams(layoutParams2);
        }
        if (this.aRv != null && this.aRv.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.aRv.getLayoutParams();
            layoutParams3.height = i;
            this.aRv.setLayoutParams(layoutParams3);
        }
    }

    public void bY(boolean z) {
        if (this.aRy != null) {
            this.aRy.setVisibility(z ? 0 : 8);
        }
    }
}

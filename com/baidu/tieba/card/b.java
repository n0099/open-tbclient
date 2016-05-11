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
    protected RelativeLayout aNR;
    protected TextView aNS;
    public TextView aNT;
    public TextView aNU;
    private View aNV;
    private View aNW;
    private View aNX;
    public ImageView aNY;
    public LinearLayout aNZ;
    public View aOa;
    public View aOb;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aNR = null;
        this.aNS = null;
        this.aNT = null;
        this.aNU = null;
        this.aNV = null;
        this.aNW = null;
        this.aNX = null;
        this.aNZ = null;
        w(getView());
    }

    private void w(View view) {
        this.aNR = (RelativeLayout) view.findViewById(t.g.item_layout_group_title);
        this.aNS = (TextView) view.findViewById(t.g.item_group_title);
        this.aNT = (TextView) view.findViewById(t.g.item_right_tv);
        this.aNU = (TextView) view.findViewById(t.g.item_bottom_more_tv);
        this.aNV = view.findViewById(t.g.divider_line_top);
        this.aNW = view.findViewById(t.g.divider_line_middle);
        this.aNX = view.findViewById(t.g.divider_line_bottom);
        this.aNZ = (LinearLayout) view.findViewById(t.g.card_container);
        this.aOa = view.findViewById(t.g.divider_card);
        this.aOb = view.findViewById(t.g.divider_card_top);
        this.aNY = (ImageView) view.findViewById(t.g.item_right_arrow);
    }

    private void JO() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.at.c(this.aNS, t.d.cp_cont_d, 1);
            this.aNY.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.at.c(this.aNS, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(this.aNY, t.f.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.at.c(this.aNT, t.d.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.at.c(this.aNU, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.l(getView(), t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.l(this.aNV, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.aNW, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.aNX, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.aOa, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.at.l(this.aOb, t.d.cp_bg_line_c);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            JO();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.aNS.setText(t.aRs);
        if (t.aRt > 0) {
            this.aNT.setBackgroundResource(t.aRt);
        }
        if (t.aRw) {
            this.aOb.setVisibility(0);
        } else {
            this.aOb.setVisibility(8);
        }
        if (!StringUtils.isNull(t.aRu)) {
            this.aNU.setVisibility(0);
            this.aNX.setVisibility(0);
            this.aNW.setVisibility(0);
            this.aNU.setText(t.aRu);
            String str = t.aRv;
            if (!StringUtils.isNull(str)) {
                this.aNU.setTag(str);
                this.aNU.setOnClickListener(this);
                return;
            }
            return;
        }
        this.aNU.setVisibility(8);
        this.aNX.setVisibility(8);
        this.aNW.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aNU == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bg.us().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int JN() {
        return t.h.card_group;
    }

    public void ft(int i) {
        if (this.aNV != null && this.aNV.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aNV.getLayoutParams();
            layoutParams.height = i;
            this.aNV.setLayoutParams(layoutParams);
        }
        if (this.aNW != null && this.aNW.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.aNW.getLayoutParams();
            layoutParams2.height = i;
            this.aNW.setLayoutParams(layoutParams2);
        }
        if (this.aNX != null && this.aNX.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.aNX.getLayoutParams();
            layoutParams3.height = i;
            this.aNX.setLayoutParams(layoutParams3);
        }
    }

    public void cf(boolean z) {
        if (this.aOa != null) {
            this.aOa.setVisibility(z ? 0 : 8);
        }
    }
}

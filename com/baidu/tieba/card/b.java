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
    protected RelativeLayout aSi;
    protected TextView aSj;
    public TextView aSk;
    public TextView aSl;
    private View aSm;
    private View aSn;
    private View aSo;
    public ImageView aSp;
    public LinearLayout aSq;
    public View aSr;
    public View aSs;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aSi = null;
        this.aSj = null;
        this.aSk = null;
        this.aSl = null;
        this.aSm = null;
        this.aSn = null;
        this.aSo = null;
        this.aSq = null;
        Q(getView());
    }

    private void Q(View view) {
        this.aSi = (RelativeLayout) view.findViewById(u.g.item_layout_group_title);
        this.aSj = (TextView) view.findViewById(u.g.item_group_title);
        this.aSk = (TextView) view.findViewById(u.g.item_right_tv);
        this.aSl = (TextView) view.findViewById(u.g.item_bottom_more_tv);
        this.aSm = view.findViewById(u.g.divider_line_top);
        this.aSn = view.findViewById(u.g.divider_line_middle);
        this.aSo = view.findViewById(u.g.divider_line_bottom);
        this.aSq = (LinearLayout) view.findViewById(u.g.card_container);
        this.aSr = view.findViewById(u.g.divider_card);
        this.aSs = view.findViewById(u.g.divider_card_top);
        this.aSp = (ImageView) view.findViewById(u.g.item_right_arrow);
    }

    private void KO() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.av.c(this.aSj, u.d.cp_cont_d, 1);
            this.aSp.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.av.c(this.aSj, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(this.aSp, u.f.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.av.c(this.aSk, u.d.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.av.c(this.aSl, u.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.av.l(getView(), u.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.av.l(this.aSm, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aSn, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aSo, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aSr, u.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.av.l(this.aSs, u.d.cp_bg_line_c);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            KO();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.aSj.setText(t.aVL);
        if (t.aVM > 0) {
            this.aSk.setBackgroundResource(t.aVM);
        }
        if (t.aVP) {
            this.aSs.setVisibility(0);
        } else {
            this.aSs.setVisibility(8);
        }
        if (!StringUtils.isNull(t.aVN)) {
            this.aSl.setVisibility(0);
            this.aSo.setVisibility(0);
            this.aSn.setVisibility(0);
            this.aSl.setText(t.aVN);
            String str = t.aVO;
            if (!StringUtils.isNull(str)) {
                this.aSl.setTag(str);
                this.aSl.setOnClickListener(this);
                return;
            }
            return;
        }
        this.aSl.setVisibility(8);
        this.aSo.setVisibility(8);
        this.aSn.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aSl == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bi.us().c(KM(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return u.h.card_group;
    }

    public void fD(int i) {
        if (this.aSm != null && this.aSm.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aSm.getLayoutParams();
            layoutParams.height = i;
            this.aSm.setLayoutParams(layoutParams);
        }
        if (this.aSn != null && this.aSn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.aSn.getLayoutParams();
            layoutParams2.height = i;
            this.aSn.setLayoutParams(layoutParams2);
        }
        if (this.aSo != null && this.aSo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.aSo.getLayoutParams();
            layoutParams3.height = i;
            this.aSo.setLayoutParams(layoutParams3);
        }
    }

    public void ck(boolean z) {
        if (this.aSr != null) {
            this.aSr.setVisibility(z ? 0 : 8);
        }
    }
}

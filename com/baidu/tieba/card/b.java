package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.card.a.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.a.a> extends a<T> {
    protected RelativeLayout aOA;
    protected TextView aOB;
    public TextView aOC;
    public TextView aOD;
    private View aOE;
    private View aOF;
    private View aOG;
    public ImageView aOH;
    public LinearLayout aOI;
    public View aOJ;
    public View aOK;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aOA = null;
        this.aOB = null;
        this.aOC = null;
        this.aOD = null;
        this.aOE = null;
        this.aOF = null;
        this.aOG = null;
        this.aOI = null;
        w(getView());
    }

    private void w(View view) {
        this.aOA = (RelativeLayout) view.findViewById(t.g.item_layout_group_title);
        this.aOB = (TextView) view.findViewById(t.g.item_group_title);
        this.aOC = (TextView) view.findViewById(t.g.item_right_tv);
        this.aOD = (TextView) view.findViewById(t.g.item_bottom_more_tv);
        this.aOE = view.findViewById(t.g.divider_line_top);
        this.aOF = view.findViewById(t.g.divider_line_middle);
        this.aOG = view.findViewById(t.g.divider_line_bottom);
        this.aOI = (LinearLayout) view.findViewById(t.g.card_container);
        this.aOJ = view.findViewById(t.g.divider_card);
        this.aOK = view.findViewById(t.g.divider_card_top);
        this.aOH = (ImageView) view.findViewById(t.g.item_right_arrow);
    }

    private void JN() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.ar.b(this.aOB, t.d.cp_cont_d, 1);
            this.aOH.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.ar.b(this.aOB, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.ar.c(this.aOH, t.f.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.ar.b(this.aOC, t.d.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.ar.b(this.aOD, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ar.l(getView(), t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.ar.l(this.aOE, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(this.aOF, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(this.aOG, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(this.aOJ, t.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(this.aOK, t.d.cp_bg_line_c);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            JN();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.aOB.setText(t.aRF);
        if (t.aRG > 0) {
            this.aOC.setBackgroundResource(t.aRG);
        }
        if (t.aRJ) {
            this.aOK.setVisibility(0);
        } else {
            this.aOK.setVisibility(8);
        }
        if (!StringUtils.isNull(t.aRH)) {
            this.aOD.setVisibility(0);
            this.aOG.setVisibility(0);
            this.aOF.setVisibility(0);
            this.aOD.setText(t.aRH);
            String str = t.aRI;
            if (!StringUtils.isNull(str)) {
                this.aOD.setTag(str);
                this.aOD.setOnClickListener(this);
                return;
            }
            return;
        }
        this.aOD.setVisibility(8);
        this.aOG.setVisibility(8);
        this.aOF.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aOD == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                be.wt().c(JK(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int JM() {
        return t.h.card_group;
    }

    public void fw(int i) {
        if (this.aOE != null && this.aOE.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aOE.getLayoutParams();
            layoutParams.height = i;
            this.aOE.setLayoutParams(layoutParams);
        }
        if (this.aOF != null && this.aOF.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.aOF.getLayoutParams();
            layoutParams2.height = i;
            this.aOF.setLayoutParams(layoutParams2);
        }
        if (this.aOG != null && this.aOG.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.aOG.getLayoutParams();
            layoutParams3.height = i;
            this.aOG.setLayoutParams(layoutParams3);
        }
    }

    public void bP(boolean z) {
        if (this.aOJ != null) {
            this.aOJ.setVisibility(z ? 0 : 8);
        }
    }
}

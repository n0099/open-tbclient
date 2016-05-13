package com.baidu.tbadk.f;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends a {
    private TextView amg;
    private TextView auA;
    private final int auB;
    private ImageView auy;
    private String[] auz;
    private int currentIndex;
    private Runnable zT;

    /* JADX INFO: Access modifiers changed from: private */
    public int CW() {
        this.currentIndex++;
        if (this.currentIndex >= this.auB) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(t.e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(t.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.zT = new g(this);
        this.auy = (ImageView) this.auw.findViewById(t.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.auy.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.auy.setLayoutParams(marginLayoutParams);
            }
        }
        this.amg = (TextView) this.auw.findViewById(t.g.loading_anim_ellipsis);
        this.auA = (TextView) this.auw.findViewById(t.g.loading_text);
        this.auz = context.getResources().getStringArray(t.b.loading_anim_text_array);
        this.auB = this.auz.length;
    }

    private void CX() {
        if (this.auy != null && (this.auy.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.auy.getBackground()).start();
        }
    }

    private void CY() {
        if (this.auy != null && (this.auy.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.auy.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.f.a
    protected void CU() {
        at.k(this.auy, t.f.loading_animation);
        CX();
        this.amg.setText(this.auz[0]);
        TbadkCoreApplication.m11getInst().handler.removeCallbacks(this.zT);
        TbadkCoreApplication.m11getInst().handler.postDelayed(this.zT, 200L);
        this.auw.setClickable(true);
    }

    @Override // com.baidu.tbadk.f.a
    protected void CV() {
        CY();
        TbadkCoreApplication.m11getInst().handler.removeCallbacks(this.zT);
        this.auy.setBackgroundResource(0);
    }

    public void sg() {
        at.k(this.auy, t.f.loading_animation);
        CX();
        at.c(this.amg, t.d.cp_cont_c, 1);
        at.c(this.auA, t.d.cp_cont_c, 1);
        at.l(this.auw, t.d.cp_bg_line_d);
    }

    public View CZ() {
        return this.auw;
    }
}

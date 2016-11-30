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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable CI;
    private TextView ark;
    private ImageView azF;
    private String[] azG;
    private TextView azH;
    private final int azI;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int EC() {
        this.currentIndex++;
        if (this.currentIndex >= this.azI) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(r.e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(r.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.CI = new g(this);
        this.azF = (ImageView) this.azD.findViewById(r.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.azF.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.azF.setLayoutParams(marginLayoutParams);
            }
        }
        this.ark = (TextView) this.azD.findViewById(r.g.loading_anim_ellipsis);
        this.azH = (TextView) this.azD.findViewById(r.g.loading_text);
        this.azG = context.getResources().getStringArray(r.b.loading_anim_text_array);
        this.azI = this.azG.length;
    }

    private void ED() {
        if (this.azF != null && (this.azF.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.azF.getBackground()).start();
        }
    }

    private void EE() {
        if (this.azF != null && (this.azF.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.azF.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void EA() {
        at.k(this.azF, r.f.loading_animation);
        ED();
        at.c(this.ark, r.d.cp_cont_c, 1);
        at.c(this.azH, r.d.cp_cont_c, 1);
        at.l(this.azD, r.d.cp_bg_line_d);
        this.ark.setText(this.azG[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.CI);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.CI, 200L);
        this.azD.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void EB() {
        EE();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.CI);
        this.azF.setBackgroundResource(0);
    }

    public void tB() {
        if (Ez()) {
            at.k(this.azF, r.f.loading_animation);
            ED();
            at.c(this.ark, r.d.cp_cont_c, 1);
            at.c(this.azH, r.d.cp_cont_c, 1);
            at.l(this.azD, r.d.cp_bg_line_d);
        }
    }

    public View EF() {
        return this.azD;
    }

    public void setTextColor(int i) {
        this.ark.setTextColor(i);
        this.azH.setTextColor(i);
    }

    public void dg(int i) {
        if (this.azD != null) {
            this.azD.setBackgroundColor(i);
        }
    }
}

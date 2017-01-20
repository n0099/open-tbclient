package com.baidu.tbadk.f;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable BU;
    private TextView apT;
    private ImageView axX;
    private String[] axY;
    private TextView axZ;
    private final int aya;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ef() {
        this.currentIndex++;
        if (this.currentIndex >= this.aya) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(r.f.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(r.j.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.BU = new g(this);
        this.axX = (ImageView) this.axV.findViewById(r.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.axX.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.axX.setLayoutParams(marginLayoutParams);
            }
        }
        this.apT = (TextView) this.axV.findViewById(r.h.loading_anim_ellipsis);
        this.axZ = (TextView) this.axV.findViewById(r.h.loading_text);
        this.axY = context.getResources().getStringArray(r.b.loading_anim_text_array);
        this.aya = this.axY.length;
    }

    private void Eg() {
        if (this.axX != null && (this.axX.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.axX.getBackground()).start();
        }
    }

    private void Eh() {
        if (this.axX != null && (this.axX.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.axX.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ed() {
        ap.j(this.axX, r.g.loading_animation);
        Eg();
        ap.c(this.apT, r.e.cp_cont_c, 1);
        ap.c(this.axZ, r.e.cp_cont_c, 1);
        ap.k(this.axV, r.e.cp_bg_line_d);
        this.apT.setText(this.axY[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.BU);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.BU, 200L);
        this.axV.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ee() {
        Eh();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.BU);
        this.axX.setBackgroundResource(0);
    }

    public void tg() {
        if (Ec()) {
            ap.j(this.axX, r.g.loading_animation);
            Eg();
            ap.c(this.apT, r.e.cp_cont_c, 1);
            ap.c(this.axZ, r.e.cp_cont_c, 1);
            ap.k(this.axV, r.e.cp_bg_line_d);
        }
    }

    public View Ei() {
        return this.axV;
    }
}

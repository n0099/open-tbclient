package com.baidu.tbadk.i;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable IJ;
    private ImageView aDH;
    private String[] aDI;
    private TextView aDJ;
    private final int aDK;
    private TextView avD;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int EW() {
        this.currentIndex++;
        if (this.currentIndex >= this.aDK) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(w.f.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(w.j.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.IJ = new g(this);
        this.aDH = (ImageView) this.aDF.findViewById(w.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aDH.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aDH.setLayoutParams(marginLayoutParams);
            }
        }
        this.avD = (TextView) this.aDF.findViewById(w.h.loading_anim_ellipsis);
        this.aDJ = (TextView) this.aDF.findViewById(w.h.loading_text);
        this.aDI = context.getResources().getStringArray(w.b.loading_anim_text_array);
        this.aDK = this.aDI.length;
    }

    private void EX() {
        if (this.aDH != null && (this.aDH.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aDH.getBackground()).start();
        }
    }

    private void EY() {
        if (this.aDH != null && (this.aDH.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aDH.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void EU() {
        aq.j(this.aDH, w.g.loading_animation);
        EX();
        aq.c(this.avD, w.e.cp_cont_c, 1);
        aq.c(this.aDJ, w.e.cp_cont_c, 1);
        aq.k(this.aDF, w.e.cp_bg_line_d);
        this.avD.setText(this.aDI[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.IJ);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.IJ, 200L);
        this.aDF.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void EV() {
        EY();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.IJ);
        this.aDH.setBackgroundResource(0);
    }

    public void onChangeSkinType() {
        if (ET()) {
            aq.j(this.aDH, w.g.loading_animation);
            EX();
            aq.c(this.avD, w.e.cp_cont_c, 1);
            aq.c(this.aDJ, w.e.cp_cont_c, 1);
            aq.k(this.aDF, w.e.cp_bg_line_d);
        }
    }

    public View EZ() {
        return this.aDF;
    }

    public void setTopMargin(int i) {
        if (this.aDH != null) {
            ViewGroup.LayoutParams layoutParams = this.aDH.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aDH.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

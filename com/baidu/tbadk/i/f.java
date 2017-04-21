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
    private Runnable IL;
    private ImageView aDJ;
    private String[] aDK;
    private TextView aDL;
    private final int aDM;
    private TextView avF;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int EW() {
        this.currentIndex++;
        if (this.currentIndex >= this.aDM) {
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
        this.IL = new g(this);
        this.aDJ = (ImageView) this.aDH.findViewById(w.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aDJ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aDJ.setLayoutParams(marginLayoutParams);
            }
        }
        this.avF = (TextView) this.aDH.findViewById(w.h.loading_anim_ellipsis);
        this.aDL = (TextView) this.aDH.findViewById(w.h.loading_text);
        this.aDK = context.getResources().getStringArray(w.b.loading_anim_text_array);
        this.aDM = this.aDK.length;
    }

    private void EX() {
        if (this.aDJ != null && (this.aDJ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aDJ.getBackground()).start();
        }
    }

    private void EY() {
        if (this.aDJ != null && (this.aDJ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aDJ.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void EU() {
        aq.j(this.aDJ, w.g.loading_animation);
        EX();
        aq.c(this.avF, w.e.cp_cont_c, 1);
        aq.c(this.aDL, w.e.cp_cont_c, 1);
        aq.k(this.aDH, w.e.cp_bg_line_d);
        this.avF.setText(this.aDK[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.IL);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.IL, 200L);
        this.aDH.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void EV() {
        EY();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.IL);
        this.aDJ.setBackgroundResource(0);
    }

    public void onChangeSkinType() {
        if (ET()) {
            aq.j(this.aDJ, w.g.loading_animation);
            EX();
            aq.c(this.avF, w.e.cp_cont_c, 1);
            aq.c(this.aDL, w.e.cp_cont_c, 1);
            aq.k(this.aDH, w.e.cp_bg_line_d);
        }
    }

    public View EZ() {
        return this.aDH;
    }

    public void setTopMargin(int i) {
        if (this.aDJ != null) {
            ViewGroup.LayoutParams layoutParams = this.aDJ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aDJ.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

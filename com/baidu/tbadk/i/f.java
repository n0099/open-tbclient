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
    private ImageView aDI;
    private String[] aDJ;
    private TextView aDK;
    private final int aDL;
    private Runnable aDM;
    private TextView avJ;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ea() {
        this.currentIndex++;
        if (this.currentIndex >= this.aDL) {
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
        this.aDM = new g(this);
        this.aDI = (ImageView) this.aDG.findViewById(w.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aDI.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aDI.setLayoutParams(marginLayoutParams);
            }
        }
        this.avJ = (TextView) this.aDG.findViewById(w.h.loading_anim_ellipsis);
        this.aDK = (TextView) this.aDG.findViewById(w.h.loading_text);
        this.aDJ = context.getResources().getStringArray(w.b.loading_anim_text_array);
        this.aDL = this.aDJ.length;
    }

    private void Eb() {
        if (this.aDI != null && (this.aDI.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aDI.getBackground()).start();
        }
    }

    private void Ec() {
        if (this.aDI != null && (this.aDI.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aDI.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void DY() {
        aq.j(this.aDI, w.g.loading_animation);
        Eb();
        aq.c(this.avJ, w.e.cp_cont_c, 1);
        aq.c(this.aDK, w.e.cp_cont_c, 1);
        aq.k(this.aDG, w.e.cp_bg_line_d);
        this.avJ.setText(this.aDJ[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.aDM);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.aDM, 200L);
        this.aDG.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void DZ() {
        release();
    }

    public void release() {
        Ec();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.aDM);
        this.aDI.setBackgroundResource(0);
    }

    public void onChangeSkinType() {
        if (DX()) {
            aq.j(this.aDI, w.g.loading_animation);
            Eb();
            aq.c(this.avJ, w.e.cp_cont_c, 1);
            aq.c(this.aDK, w.e.cp_cont_c, 1);
            aq.k(this.aDG, w.e.cp_bg_line_d);
        }
    }

    public View Ed() {
        return this.aDG;
    }

    public void setTopMargin(int i) {
        if (this.aDI != null) {
            ViewGroup.LayoutParams layoutParams = this.aDI.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aDI.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

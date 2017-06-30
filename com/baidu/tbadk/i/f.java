package com.baidu.tbadk.i;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f extends a {
    private ImageView aEJ;
    private String[] aEK;
    private TextView aEL;
    private final int aEM;
    private Runnable aEN;
    private TextView aww;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Er() {
        this.currentIndex++;
        if (this.currentIndex >= this.aEM) {
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
        this.aEN = new g(this);
        this.aEJ = (ImageView) this.aEH.findViewById(w.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aEJ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aEJ.setLayoutParams(marginLayoutParams);
            }
        }
        this.aww = (TextView) this.aEH.findViewById(w.h.loading_anim_ellipsis);
        this.aEL = (TextView) this.aEH.findViewById(w.h.loading_text);
        this.aEK = context.getResources().getStringArray(w.b.loading_anim_text_array);
        this.aEM = this.aEK.length;
    }

    private void Es() {
        if (this.aEJ != null && (this.aEJ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aEJ.getBackground()).start();
        }
    }

    private void Et() {
        if (this.aEJ != null && (this.aEJ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aEJ.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void Ep() {
        as.j(this.aEJ, w.g.loading_animation);
        Es();
        as.c(this.aww, w.e.cp_cont_c, 1);
        as.c(this.aEL, w.e.cp_cont_c, 1);
        as.k(this.aEH, w.e.cp_bg_line_d);
        this.aww.setText(this.aEK[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.aEN);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.aEN, 200L);
        this.aEH.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void Eq() {
        release();
    }

    public void release() {
        Et();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.aEN);
        this.aEJ.setBackgroundResource(0);
    }

    public void onChangeSkinType() {
        if (Eo()) {
            as.j(this.aEJ, w.g.loading_animation);
            Es();
            as.c(this.aww, w.e.cp_cont_c, 1);
            as.c(this.aEL, w.e.cp_cont_c, 1);
            as.k(this.aEH, w.e.cp_bg_line_d);
        }
    }

    public View Eu() {
        return this.aEH;
    }

    public void setTopMargin(int i) {
        if (this.aEJ != null) {
            ViewGroup.LayoutParams layoutParams = this.aEJ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aEJ.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

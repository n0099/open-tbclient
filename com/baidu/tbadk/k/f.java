package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends a {
    private ImageView aHh;
    private String[] aHi;
    private TextView aHj;
    private final int aHk;
    private TextView ayF;
    private int currentIndex;
    private Runnable runnable;

    /* JADX INFO: Access modifiers changed from: private */
    public int EN() {
        this.currentIndex++;
        if (this.currentIndex >= this.aHk) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(d.f.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(d.j.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.runnable = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.ayF.setText(f.this.aHi[f.this.EN()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.runnable, 200L);
            }
        };
        this.aHh = (ImageView) this.aHf.findViewById(d.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aHh.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHh.setLayoutParams(marginLayoutParams);
            }
        }
        this.ayF = (TextView) this.aHf.findViewById(d.h.loading_anim_ellipsis);
        this.aHj = (TextView) this.aHf.findViewById(d.h.loading_text);
        this.aHi = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aHk = this.aHi.length;
    }

    private void EO() {
        if (this.aHh != null && (this.aHh.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHh.getBackground()).start();
        }
    }

    private void EP() {
        if (this.aHh != null && (this.aHh.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHh.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EL() {
        ai.j(this.aHh, d.g.loading_animation);
        EO();
        ai.c(this.ayF, d.e.cp_cont_c, 1);
        ai.c(this.aHj, d.e.cp_cont_c, 1);
        ai.k(this.aHf, d.e.cp_bg_line_d);
        this.ayF.setText(this.aHi[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        TbadkCoreApplication.getInst().handler.postDelayed(this.runnable, 200L);
        this.aHf.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EM() {
        release();
    }

    public void release() {
        EP();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        this.aHh.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (EK()) {
            ai.j(this.aHh, d.g.loading_animation);
            EO();
            ai.c(this.ayF, d.e.cp_cont_c, 1);
            ai.c(this.aHj, d.e.cp_cont_c, 1);
            ai.k(this.aHf, d.e.cp_bg_line_d);
        }
    }

    public View EQ() {
        return this.aHf;
    }

    public void setTopMargin(int i) {
        if (this.aHh != null) {
            ViewGroup.LayoutParams layoutParams = this.aHh.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHh.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

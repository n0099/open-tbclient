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
    private ImageView aHi;
    private String[] aHj;
    private TextView aHk;
    private final int aHl;
    private TextView ayG;
    private int currentIndex;
    private Runnable runnable;

    /* JADX INFO: Access modifiers changed from: private */
    public int EN() {
        this.currentIndex++;
        if (this.currentIndex >= this.aHl) {
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
                f.this.ayG.setText(f.this.aHj[f.this.EN()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.runnable, 200L);
            }
        };
        this.aHi = (ImageView) this.aHg.findViewById(d.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aHi.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHi.setLayoutParams(marginLayoutParams);
            }
        }
        this.ayG = (TextView) this.aHg.findViewById(d.h.loading_anim_ellipsis);
        this.aHk = (TextView) this.aHg.findViewById(d.h.loading_text);
        this.aHj = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aHl = this.aHj.length;
    }

    private void EO() {
        if (this.aHi != null && (this.aHi.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHi.getBackground()).start();
        }
    }

    private void EP() {
        if (this.aHi != null && (this.aHi.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHi.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EL() {
        ai.j(this.aHi, d.g.loading_animation);
        EO();
        ai.c(this.ayG, d.e.cp_cont_c, 1);
        ai.c(this.aHk, d.e.cp_cont_c, 1);
        ai.k(this.aHg, d.e.cp_bg_line_d);
        this.ayG.setText(this.aHj[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        TbadkCoreApplication.getInst().handler.postDelayed(this.runnable, 200L);
        this.aHg.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EM() {
        release();
    }

    public void release() {
        EP();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        this.aHi.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (EK()) {
            ai.j(this.aHi, d.g.loading_animation);
            EO();
            ai.c(this.ayG, d.e.cp_cont_c, 1);
            ai.c(this.aHk, d.e.cp_cont_c, 1);
            ai.k(this.aHg, d.e.cp_bg_line_d);
        }
    }

    public View EQ() {
        return this.aHg;
    }

    public void setTopMargin(int i) {
        if (this.aHi != null) {
            ViewGroup.LayoutParams layoutParams = this.aHi.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHi.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

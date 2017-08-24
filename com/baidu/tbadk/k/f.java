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
    private ImageView aHj;
    private String[] aHk;
    private TextView aHl;
    private final int aHm;
    private TextView ayH;
    private int currentIndex;
    private Runnable runnable;

    /* JADX INFO: Access modifiers changed from: private */
    public int EN() {
        this.currentIndex++;
        if (this.currentIndex >= this.aHm) {
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
                f.this.ayH.setText(f.this.aHk[f.this.EN()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.runnable, 200L);
            }
        };
        this.aHj = (ImageView) this.aHh.findViewById(d.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aHj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHj.setLayoutParams(marginLayoutParams);
            }
        }
        this.ayH = (TextView) this.aHh.findViewById(d.h.loading_anim_ellipsis);
        this.aHl = (TextView) this.aHh.findViewById(d.h.loading_text);
        this.aHk = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aHm = this.aHk.length;
    }

    private void EO() {
        if (this.aHj != null && (this.aHj.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHj.getBackground()).start();
        }
    }

    private void EP() {
        if (this.aHj != null && (this.aHj.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHj.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EL() {
        ai.j(this.aHj, d.g.loading_animation);
        EO();
        ai.c(this.ayH, d.e.cp_cont_c, 1);
        ai.c(this.aHl, d.e.cp_cont_c, 1);
        ai.k(this.aHh, d.e.cp_bg_line_d);
        this.ayH.setText(this.aHk[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        TbadkCoreApplication.getInst().handler.postDelayed(this.runnable, 200L);
        this.aHh.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EM() {
        release();
    }

    public void release() {
        EP();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        this.aHj.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (EK()) {
            ai.j(this.aHj, d.g.loading_animation);
            EO();
            ai.c(this.ayH, d.e.cp_cont_c, 1);
            ai.c(this.aHl, d.e.cp_cont_c, 1);
            ai.k(this.aHh, d.e.cp_bg_line_d);
        }
    }

    public View EQ() {
        return this.aHh;
    }

    public void setTopMargin(int i) {
        if (this.aHj != null) {
            ViewGroup.LayoutParams layoutParams = this.aHj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHj.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

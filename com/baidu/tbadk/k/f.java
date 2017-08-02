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
    private ImageView aFR;
    private String[] aFS;
    private TextView aFT;
    private final int aFU;
    private Runnable aFV;
    private TextView axo;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int EF() {
        this.currentIndex++;
        if (this.currentIndex >= this.aFU) {
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
        this.aFV = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.axo.setText(f.this.aFS[f.this.EF()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aFV, 200L);
            }
        };
        this.aFR = (ImageView) this.aFP.findViewById(d.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aFR.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aFR.setLayoutParams(marginLayoutParams);
            }
        }
        this.axo = (TextView) this.aFP.findViewById(d.h.loading_anim_ellipsis);
        this.aFT = (TextView) this.aFP.findViewById(d.h.loading_text);
        this.aFS = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aFU = this.aFS.length;
    }

    private void EG() {
        if (this.aFR != null && (this.aFR.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aFR.getBackground()).start();
        }
    }

    private void EH() {
        if (this.aFR != null && (this.aFR.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aFR.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void ED() {
        ai.j(this.aFR, d.g.loading_animation);
        EG();
        ai.c(this.axo, d.e.cp_cont_c, 1);
        ai.c(this.aFT, d.e.cp_cont_c, 1);
        ai.k(this.aFP, d.e.cp_bg_line_d);
        this.axo.setText(this.aFS[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aFV);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aFV, 200L);
        this.aFP.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EE() {
        release();
    }

    public void release() {
        EH();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aFV);
        this.aFR.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (EC()) {
            ai.j(this.aFR, d.g.loading_animation);
            EG();
            ai.c(this.axo, d.e.cp_cont_c, 1);
            ai.c(this.aFT, d.e.cp_cont_c, 1);
            ai.k(this.aFP, d.e.cp_bg_line_d);
        }
    }

    public View EI() {
        return this.aFP;
    }

    public void setTopMargin(int i) {
        if (this.aFR != null) {
            ViewGroup.LayoutParams layoutParams = this.aFR.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aFR.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

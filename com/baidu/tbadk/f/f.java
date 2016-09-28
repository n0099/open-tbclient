package com.baidu.tbadk.f;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable CI;
    private TextView aqq;
    private ImageView ayN;
    private String[] ayO;
    private TextView ayP;
    private final int ayQ;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ex() {
        this.currentIndex++;
        if (this.currentIndex >= this.ayQ) {
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
        this.ayN = (ImageView) this.ayL.findViewById(r.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.ayN.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.ayN.setLayoutParams(marginLayoutParams);
            }
        }
        this.aqq = (TextView) this.ayL.findViewById(r.g.loading_anim_ellipsis);
        this.ayP = (TextView) this.ayL.findViewById(r.g.loading_text);
        this.ayO = context.getResources().getStringArray(r.b.loading_anim_text_array);
        this.ayQ = this.ayO.length;
    }

    private void Ey() {
        if (this.ayN != null && (this.ayN.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.ayN.getBackground()).start();
        }
    }

    private void Ez() {
        if (this.ayN != null && (this.ayN.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.ayN.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ev() {
        av.k(this.ayN, r.f.loading_animation);
        Ey();
        av.c(this.aqq, r.d.cp_cont_c, 1);
        av.c(this.ayP, r.d.cp_cont_c, 1);
        av.l(this.ayL, r.d.cp_bg_line_d);
        this.aqq.setText(this.ayO[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.CI);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.CI, 200L);
        this.ayL.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ew() {
        Ez();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.CI);
        this.ayN.setBackgroundResource(0);
    }

    public void tx() {
        if (Eu()) {
            av.k(this.ayN, r.f.loading_animation);
            Ey();
            av.c(this.aqq, r.d.cp_cont_c, 1);
            av.c(this.ayP, r.d.cp_cont_c, 1);
            av.l(this.ayL, r.d.cp_bg_line_d);
        }
    }

    public View EA() {
        return this.ayL;
    }

    public void setTextColor(int i) {
        this.aqq.setTextColor(i);
        this.ayP.setTextColor(i);
    }

    public void df(int i) {
        if (this.ayL != null) {
            this.ayL.setBackgroundColor(i);
        }
    }
}

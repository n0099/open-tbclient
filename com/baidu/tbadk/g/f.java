package com.baidu.tbadk.g;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable CI;
    private TextView aqI;
    private ImageView azk;
    private String[] azl;
    private TextView azm;
    private final int azn;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ex() {
        this.currentIndex++;
        if (this.currentIndex >= this.azn) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(t.e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(t.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.CI = new g(this);
        this.azk = (ImageView) this.azi.findViewById(t.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.azk.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.azk.setLayoutParams(marginLayoutParams);
            }
        }
        this.aqI = (TextView) this.azi.findViewById(t.g.loading_anim_ellipsis);
        this.azm = (TextView) this.azi.findViewById(t.g.loading_text);
        this.azl = context.getResources().getStringArray(t.b.loading_anim_text_array);
        this.azn = this.azl.length;
    }

    private void Ey() {
        if (this.azk != null && (this.azk.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.azk.getBackground()).start();
        }
    }

    private void Ez() {
        if (this.azk != null && (this.azk.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.azk.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Ev() {
        av.k(this.azk, t.f.loading_animation);
        Ey();
        av.c(this.aqI, t.d.cp_cont_c, 1);
        av.c(this.azm, t.d.cp_cont_c, 1);
        av.l(this.azi, t.d.cp_bg_line_d);
        this.aqI.setText(this.azl[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.CI);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.CI, 200L);
        this.azi.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Ew() {
        Ez();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.CI);
        this.azk.setBackgroundResource(0);
    }

    public void ti() {
        if (Eu()) {
            av.k(this.azk, t.f.loading_animation);
            Ey();
            av.c(this.aqI, t.d.cp_cont_c, 1);
            av.c(this.azm, t.d.cp_cont_c, 1);
            av.l(this.azi, t.d.cp_bg_line_d);
        }
    }

    public View EA() {
        return this.azi;
    }

    public void setTextColor(int i) {
        this.aqI.setTextColor(i);
        this.azm.setTextColor(i);
    }

    public void df(int i) {
        if (this.azi != null) {
            this.azi.setBackgroundColor(i);
        }
    }
}

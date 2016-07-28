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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable Au;
    private TextView anB;
    private ImageView awd;
    private String[] awe;
    private TextView awf;
    private final int awg;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Dd() {
        this.currentIndex++;
        if (this.currentIndex >= this.awg) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(u.e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(u.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.Au = new g(this);
        this.awd = (ImageView) this.awb.findViewById(u.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.awd.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.awd.setLayoutParams(marginLayoutParams);
            }
        }
        this.anB = (TextView) this.awb.findViewById(u.g.loading_anim_ellipsis);
        this.awf = (TextView) this.awb.findViewById(u.g.loading_text);
        this.awe = context.getResources().getStringArray(u.b.loading_anim_text_array);
        this.awg = this.awe.length;
    }

    private void De() {
        if (this.awd != null && (this.awd.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.awd.getBackground()).start();
        }
    }

    private void Df() {
        if (this.awd != null && (this.awd.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.awd.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Db() {
        av.k(this.awd, u.f.loading_animation);
        De();
        av.c(this.anB, u.d.cp_cont_c, 1);
        av.c(this.awf, u.d.cp_cont_c, 1);
        av.l(this.awb, u.d.cp_bg_line_d);
        this.anB.setText(this.awe[0]);
        TbadkCoreApplication.m10getInst().handler.removeCallbacks(this.Au);
        TbadkCoreApplication.m10getInst().handler.postDelayed(this.Au, 200L);
        this.awb.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Dc() {
        Df();
        TbadkCoreApplication.m10getInst().handler.removeCallbacks(this.Au);
        this.awd.setBackgroundResource(0);
    }

    public void sd() {
        if (Da()) {
            av.k(this.awd, u.f.loading_animation);
            De();
            av.c(this.anB, u.d.cp_cont_c, 1);
            av.c(this.awf, u.d.cp_cont_c, 1);
            av.l(this.awb, u.d.cp_bg_line_d);
        }
    }

    public View Dg() {
        return this.awb;
    }

    public void setTextColor(int i) {
        this.anB.setTextColor(i);
        this.awf.setTextColor(i);
    }

    public void cR(int i) {
        if (this.awb != null) {
            this.awb.setBackgroundColor(i);
        }
    }
}

package com.baidu.tbadk.f;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable JD;
    private TextView aqs;
    private final int ayA;
    private ImageView ayx;
    private String[] ayy;
    private TextView ayz;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Fd() {
        this.currentIndex++;
        if (this.currentIndex >= this.ayA) {
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
        this.JD = new g(this);
        this.ayx = (ImageView) this.ayv.findViewById(t.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.ayx.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.ayx.setLayoutParams(marginLayoutParams);
            }
        }
        this.aqs = (TextView) this.ayv.findViewById(t.g.loading_anim_ellipsis);
        this.ayz = (TextView) this.ayv.findViewById(t.g.loading_text);
        this.ayy = context.getResources().getStringArray(t.b.loading_anim_text_array);
        this.ayA = this.ayy.length;
    }

    private void Fe() {
        if (this.ayx != null && (this.ayx.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.ayx.getBackground()).start();
        }
    }

    private void Ff() {
        if (this.ayx != null && (this.ayx.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.ayx.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.f.a
    protected void Fb() {
        at.k(this.ayx, t.f.loading_animation);
        Fe();
        this.aqs.setText(this.ayy[0]);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.JD);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.JD, 200L);
        this.ayv.setClickable(true);
    }

    @Override // com.baidu.tbadk.f.a
    protected void Fc() {
        Ff();
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.JD);
        this.ayx.setBackgroundResource(0);
    }

    public void uA() {
        at.k(this.ayx, t.f.loading_animation);
        Fe();
        at.b(this.aqs, t.d.cp_cont_c, 1);
        at.b(this.ayz, t.d.cp_cont_c, 1);
        at.l(this.ayv, t.d.cp_bg_line_d);
    }

    public View Fg() {
        return this.ayv;
    }
}

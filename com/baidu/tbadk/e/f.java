package com.baidu.tbadk.e;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable Ix;
    private TextView alP;
    private ImageView auC;
    private String[] auD;
    private TextView auE;
    private final int auF;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ct() {
        this.currentIndex++;
        if (this.currentIndex >= this.auF) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(i.d.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(i.g.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.Ix = new g(this);
        this.auC = (ImageView) this.auA.findViewById(i.f.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.auC.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.auC.setLayoutParams(marginLayoutParams);
            }
        }
        this.alP = (TextView) this.auA.findViewById(i.f.loading_anim_ellipsis);
        this.auE = (TextView) this.auA.findViewById(i.f.loading_text);
        this.auD = context.getResources().getStringArray(i.b.loading_anim_text_array);
        this.auF = this.auD.length;
    }

    private void Cu() {
        if (this.auC != null && (this.auC.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.auC.getBackground()).start();
        }
    }

    private void Cv() {
        if (this.auC != null && (this.auC.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.auC.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.e.a
    protected void Cr() {
        am.i(this.auC, i.e.loading_animation);
        Cu();
        this.alP.setText(this.auD[0]);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Ix);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.Ix, 200L);
    }

    @Override // com.baidu.tbadk.e.a
    protected void Cs() {
        Cv();
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Ix);
        this.auC.setBackgroundResource(0);
    }

    public void tc() {
        am.i(this.auC, i.e.loading_animation);
        Cu();
        am.b(this.alP, i.c.cp_cont_c, 1);
        am.b(this.auE, i.c.cp_cont_c, 1);
        am.j(this.auA, i.c.cp_bg_line_d);
    }
}

package com.baidu.tbadk.e;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable Iy;
    private TextView alQ;
    private ImageView auD;
    private String[] auE;
    private TextView auF;
    private final int auG;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Cq() {
        this.currentIndex++;
        if (this.currentIndex >= this.auG) {
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
        this.Iy = new g(this);
        this.auD = (ImageView) this.auB.findViewById(i.f.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.auD.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.auD.setLayoutParams(marginLayoutParams);
            }
        }
        this.alQ = (TextView) this.auB.findViewById(i.f.loading_anim_ellipsis);
        this.auF = (TextView) this.auB.findViewById(i.f.loading_text);
        this.auE = context.getResources().getStringArray(i.b.loading_anim_text_array);
        this.auG = this.auE.length;
    }

    private void Cr() {
        if (this.auD != null && (this.auD.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.auD.getBackground()).start();
        }
    }

    private void Cs() {
        if (this.auD != null && (this.auD.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.auD.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.e.a
    protected void Co() {
        an.i(this.auD, i.e.loading_animation);
        Cr();
        this.alQ.setText(this.auE[0]);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Iy);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.Iy, 200L);
    }

    @Override // com.baidu.tbadk.e.a
    protected void Cp() {
        Cs();
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Iy);
        this.auD.setBackgroundResource(0);
    }

    public void sZ() {
        an.i(this.auD, i.e.loading_animation);
        Cr();
        an.b(this.alQ, i.c.cp_cont_c, 1);
        an.b(this.auF, i.c.cp_cont_c, 1);
        an.j(this.auB, i.c.cp_bg_line_d);
    }
}

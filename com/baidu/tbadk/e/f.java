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
    private Runnable Iz;
    private TextView alV;
    private ImageView atr;
    private String[] ats;
    private TextView att;
    private final int atu;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Cj() {
        this.currentIndex++;
        if (this.currentIndex >= this.atu) {
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
        this.Iz = new g(this);
        this.atr = (ImageView) this.atp.findViewById(i.f.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.atr.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.atr.setLayoutParams(marginLayoutParams);
            }
        }
        this.alV = (TextView) this.atp.findViewById(i.f.loading_anim_ellipsis);
        this.att = (TextView) this.atp.findViewById(i.f.loading_text);
        this.ats = context.getResources().getStringArray(i.b.loading_anim_text_array);
        this.atu = this.ats.length;
    }

    private void Ck() {
        if (this.atr != null && (this.atr.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.atr.getBackground()).start();
        }
    }

    private void Cl() {
        if (this.atr != null && (this.atr.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.atr.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.e.a
    protected void Ch() {
        an.i(this.atr, i.e.loading_animation);
        Ck();
        this.alV.setText(this.ats[0]);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Iz);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.Iz, 200L);
    }

    @Override // com.baidu.tbadk.e.a
    protected void Ci() {
        Cl();
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Iz);
        this.atr.setBackgroundResource(0);
    }

    public void tc() {
        an.i(this.atr, i.e.loading_animation);
        Ck();
        an.b(this.alV, i.c.cp_cont_c, 1);
        an.b(this.att, i.c.cp_cont_c, 1);
        an.j(this.atp, i.c.cp_bg_line_d);
    }
}

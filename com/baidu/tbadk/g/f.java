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
    private TextView amM;
    private ImageView avo;
    private String[] avp;
    private TextView avq;
    private final int avr;
    private int currentIndex;
    private Runnable zS;

    /* JADX INFO: Access modifiers changed from: private */
    public int De() {
        this.currentIndex++;
        if (this.currentIndex >= this.avr) {
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
        this.zS = new g(this);
        this.avo = (ImageView) this.avm.findViewById(u.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.avo.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.avo.setLayoutParams(marginLayoutParams);
            }
        }
        this.amM = (TextView) this.avm.findViewById(u.g.loading_anim_ellipsis);
        this.avq = (TextView) this.avm.findViewById(u.g.loading_text);
        this.avp = context.getResources().getStringArray(u.b.loading_anim_text_array);
        this.avr = this.avp.length;
    }

    private void Df() {
        if (this.avo != null && (this.avo.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.avo.getBackground()).start();
        }
    }

    private void Dg() {
        if (this.avo != null && (this.avo.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.avo.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Dc() {
        av.k(this.avo, u.f.loading_animation);
        Df();
        av.c(this.amM, u.d.cp_cont_c, 1);
        av.c(this.avq, u.d.cp_cont_c, 1);
        av.l(this.avm, u.d.cp_bg_line_d);
        this.amM.setText(this.avp[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.zS);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.zS, 200L);
        this.avm.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Dd() {
        Dg();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.zS);
        this.avo.setBackgroundResource(0);
    }

    public void se() {
        if (Db()) {
            av.k(this.avo, u.f.loading_animation);
            Df();
            av.c(this.amM, u.d.cp_cont_c, 1);
            av.c(this.avq, u.d.cp_cont_c, 1);
            av.l(this.avm, u.d.cp_bg_line_d);
        }
    }

    public View Dh() {
        return this.avm;
    }

    public void setTextColor(int i) {
        this.amM.setTextColor(i);
        this.avq.setTextColor(i);
    }

    public void cR(int i) {
        if (this.avm != null) {
            this.avm.setBackgroundColor(i);
        }
    }
}

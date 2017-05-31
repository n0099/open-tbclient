package com.baidu.tbadk.i;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f extends a {
    private ImageView aDv;
    private String[] aDw;
    private TextView aDx;
    private final int aDy;
    private Runnable aDz;
    private TextView avt;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int DU() {
        this.currentIndex++;
        if (this.currentIndex >= this.aDy) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(w.f.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(w.j.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.aDz = new g(this);
        this.aDv = (ImageView) this.aDt.findViewById(w.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aDv.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aDv.setLayoutParams(marginLayoutParams);
            }
        }
        this.avt = (TextView) this.aDt.findViewById(w.h.loading_anim_ellipsis);
        this.aDx = (TextView) this.aDt.findViewById(w.h.loading_text);
        this.aDw = context.getResources().getStringArray(w.b.loading_anim_text_array);
        this.aDy = this.aDw.length;
    }

    private void DV() {
        if (this.aDv != null && (this.aDv.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aDv.getBackground()).start();
        }
    }

    private void DW() {
        if (this.aDv != null && (this.aDv.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aDv.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void DS() {
        aq.j(this.aDv, w.g.loading_animation);
        DV();
        aq.c(this.avt, w.e.cp_cont_c, 1);
        aq.c(this.aDx, w.e.cp_cont_c, 1);
        aq.k(this.aDt, w.e.cp_bg_line_d);
        this.avt.setText(this.aDw[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.aDz);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.aDz, 200L);
        this.aDt.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void DT() {
        release();
    }

    public void release() {
        DW();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.aDz);
        this.aDv.setBackgroundResource(0);
    }

    public void onChangeSkinType() {
        if (DR()) {
            aq.j(this.aDv, w.g.loading_animation);
            DV();
            aq.c(this.avt, w.e.cp_cont_c, 1);
            aq.c(this.aDx, w.e.cp_cont_c, 1);
            aq.k(this.aDt, w.e.cp_bg_line_d);
        }
    }

    public View DX() {
        return this.aDt;
    }

    public void setTopMargin(int i) {
        if (this.aDv != null) {
            ViewGroup.LayoutParams layoutParams = this.aDv.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aDv.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

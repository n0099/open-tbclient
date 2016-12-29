package com.baidu.tbadk.f;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable CJ;
    private TextView aqN;
    private ImageView azc;
    private String[] azd;
    private TextView aze;
    private final int azf;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ek() {
        this.currentIndex++;
        if (this.currentIndex >= this.azf) {
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
        this.CJ = new g(this);
        this.azc = (ImageView) this.aza.findViewById(r.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.azc.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.azc.setLayoutParams(marginLayoutParams);
            }
        }
        this.aqN = (TextView) this.aza.findViewById(r.g.loading_anim_ellipsis);
        this.aze = (TextView) this.aza.findViewById(r.g.loading_text);
        this.azd = context.getResources().getStringArray(r.b.loading_anim_text_array);
        this.azf = this.azd.length;
    }

    private void El() {
        if (this.azc != null && (this.azc.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.azc.getBackground()).start();
        }
    }

    private void Em() {
        if (this.azc != null && (this.azc.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.azc.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ei() {
        ar.k(this.azc, r.f.loading_animation);
        El();
        ar.c(this.aqN, r.d.cp_cont_c, 1);
        ar.c(this.aze, r.d.cp_cont_c, 1);
        ar.l(this.aza, r.d.cp_bg_line_d);
        this.aqN.setText(this.azd[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.CJ);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.CJ, 200L);
        this.aza.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ej() {
        Em();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.CJ);
        this.azc.setBackgroundResource(0);
    }

    public void tm() {
        if (Eh()) {
            ar.k(this.azc, r.f.loading_animation);
            El();
            ar.c(this.aqN, r.d.cp_cont_c, 1);
            ar.c(this.aze, r.d.cp_cont_c, 1);
            ar.l(this.aza, r.d.cp_bg_line_d);
        }
    }

    public View En() {
        return this.aza;
    }

    public void setTextColor(int i) {
        this.aqN.setTextColor(i);
        this.aze.setTextColor(i);
    }

    public void di(int i) {
        if (this.aza != null) {
            this.aza.setBackgroundColor(i);
        }
    }
}

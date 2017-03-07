package com.baidu.tbadk.f;

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
    private Runnable Jj;
    private ImageView aDr;
    private String[] aDs;
    private TextView aDt;
    private final int aDu;
    private TextView avn;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ey() {
        this.currentIndex++;
        if (this.currentIndex >= this.aDu) {
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
        this.Jj = new g(this);
        this.aDr = (ImageView) this.aDp.findViewById(w.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aDr.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aDr.setLayoutParams(marginLayoutParams);
            }
        }
        this.avn = (TextView) this.aDp.findViewById(w.h.loading_anim_ellipsis);
        this.aDt = (TextView) this.aDp.findViewById(w.h.loading_text);
        this.aDs = context.getResources().getStringArray(w.b.loading_anim_text_array);
        this.aDu = this.aDs.length;
    }

    private void Ez() {
        if (this.aDr != null && (this.aDr.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aDr.getBackground()).start();
        }
    }

    private void EA() {
        if (this.aDr != null && (this.aDr.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aDr.getBackground()).stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ew() {
        aq.j(this.aDr, w.g.loading_animation);
        Ez();
        aq.c(this.avn, w.e.cp_cont_c, 1);
        aq.c(this.aDt, w.e.cp_cont_c, 1);
        aq.k(this.aDp, w.e.cp_bg_line_d);
        this.avn.setText(this.aDs[0]);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.Jj);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.Jj, 200L);
        this.aDp.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ex() {
        EA();
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.Jj);
        this.aDr.setBackgroundResource(0);
    }

    public void tD() {
        if (Ev()) {
            aq.j(this.aDr, w.g.loading_animation);
            Ez();
            aq.c(this.avn, w.e.cp_cont_c, 1);
            aq.c(this.aDt, w.e.cp_cont_c, 1);
            aq.k(this.aDp, w.e.cp_bg_line_d);
        }
    }

    public View EB() {
        return this.aDp;
    }

    public void setTopMargin(int i) {
        if (this.aDr != null) {
            ViewGroup.LayoutParams layoutParams = this.aDr.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aDr.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

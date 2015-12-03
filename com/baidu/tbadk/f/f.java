package com.baidu.tbadk.f;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable IR;
    private TextView anI;
    private ImageView avv;
    private String[] avw;
    private TextView avx;
    private final int avy;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Dk() {
        this.currentIndex++;
        if (this.currentIndex >= this.avy) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(n.d.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(n.g.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.IR = new g(this);
        this.avv = (ImageView) this.avt.findViewById(n.f.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.avv.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.avv.setLayoutParams(marginLayoutParams);
            }
        }
        this.anI = (TextView) this.avt.findViewById(n.f.loading_anim_ellipsis);
        this.avx = (TextView) this.avt.findViewById(n.f.loading_text);
        this.avw = context.getResources().getStringArray(n.b.loading_anim_text_array);
        this.avy = this.avw.length;
    }

    private void Dl() {
        if (this.avv != null && (this.avv.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.avv.getBackground()).start();
        }
    }

    private void Dm() {
        if (this.avv != null && (this.avv.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.avv.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.f.a
    protected void Di() {
        as.i(this.avv, n.e.loading_animation);
        Dl();
        this.anI.setText(this.avw[0]);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.IR);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.IR, 200L);
        this.avt.setClickable(true);
    }

    @Override // com.baidu.tbadk.f.a
    protected void Dj() {
        Dm();
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.IR);
        this.avv.setBackgroundResource(0);
    }

    public void tH() {
        as.i(this.avv, n.e.loading_animation);
        Dl();
        as.b(this.anI, n.c.cp_cont_c, 1);
        as.b(this.avx, n.c.cp_cont_c, 1);
        as.j(this.avt, n.c.cp_bg_line_d);
    }
}

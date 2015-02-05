package com.baidu.tbadk.d;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class f extends a {
    private String[] LA;
    private TextView Vv;
    private ImageView abZ;
    private TextView aca;
    private final int acb;
    private int currentIndex;
    private Runnable ya;

    /* JADX INFO: Access modifiers changed from: private */
    public int wl() {
        this.currentIndex++;
        if (this.currentIndex >= this.acb) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(u.ds484));
    }

    public f(Context context, int i) {
        super(com.baidu.adp.lib.g.b.ei().inflate(context, x.loading_view_layout, null));
        this.currentIndex = 0;
        this.ya = new g(this);
        this.abZ = (ImageView) this.abX.findViewById(w.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.abZ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.abZ.setLayoutParams(marginLayoutParams);
            }
        }
        this.Vv = (TextView) this.abX.findViewById(w.loading_anim_ellipsis);
        this.aca = (TextView) this.abX.findViewById(w.loading_text);
        this.abZ.setBackgroundResource(v.loading_animation);
        this.LA = context.getResources().getStringArray(r.loading_anim_text_array);
        this.acb = this.LA.length;
    }

    private void wm() {
        if (this.abZ != null && (this.abZ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.abZ.getBackground()).start();
        }
    }

    private void wn() {
        if (this.abZ != null && (this.abZ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.abZ.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.d.a
    protected void wj() {
        wm();
        this.Vv.setText(this.LA[0]);
        this.Vv.postDelayed(this.ya, 200L);
    }

    @Override // com.baidu.tbadk.d.a
    protected void wk() {
        wn();
        this.Vv.removeCallbacks(this.ya);
    }

    public void wo() {
        bc.b(this.Vv, t.cp_cont_c, 1);
        bc.b(this.aca, t.cp_cont_c, 1);
        bc.j(this.abX, t.cp_bg_line_d);
        wn();
        bc.i(this.abZ, v.loading_animation);
        wm();
    }
}

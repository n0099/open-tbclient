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
    private String[] LE;
    private TextView Vy;
    private ImageView acc;
    private TextView acd;
    private final int ace;
    private int currentIndex;
    private Runnable yd;

    /* JADX INFO: Access modifiers changed from: private */
    public int wr() {
        this.currentIndex++;
        if (this.currentIndex >= this.ace) {
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
        this.yd = new g(this);
        this.acc = (ImageView) this.aca.findViewById(w.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.acc.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.acc.setLayoutParams(marginLayoutParams);
            }
        }
        this.Vy = (TextView) this.aca.findViewById(w.loading_anim_ellipsis);
        this.acd = (TextView) this.aca.findViewById(w.loading_text);
        this.acc.setBackgroundResource(v.loading_animation);
        this.LE = context.getResources().getStringArray(r.loading_anim_text_array);
        this.ace = this.LE.length;
    }

    private void ws() {
        if (this.acc != null && (this.acc.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.acc.getBackground()).start();
        }
    }

    private void wt() {
        if (this.acc != null && (this.acc.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.acc.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.d.a
    protected void wp() {
        ws();
        this.Vy.setText(this.LE[0]);
        this.Vy.postDelayed(this.yd, 200L);
    }

    @Override // com.baidu.tbadk.d.a
    protected void wq() {
        wt();
        this.Vy.removeCallbacks(this.yd);
    }

    public void wu() {
        bc.b(this.Vy, t.cp_cont_c, 1);
        bc.b(this.acd, t.cp_cont_c, 1);
        bc.j(this.aca, t.cp_bg_line_d);
        wt();
        bc.i(this.acc, v.loading_animation);
        ws();
    }
}

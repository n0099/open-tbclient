package com.baidu.tbadk.d;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class f extends a {
    private String[] Lj;
    private TextView UT;
    private ImageView abF;
    private TextView abG;
    private final int abH;
    private int currentIndex;
    private Runnable yd;

    /* JADX INFO: Access modifiers changed from: private */
    public int vZ() {
        this.currentIndex++;
        if (this.currentIndex >= this.abH) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(u.ds484));
    }

    public f(Context context, int i) {
        super(com.baidu.adp.lib.g.b.ek().inflate(context, x.loading_view_layout, null));
        this.currentIndex = 0;
        this.yd = new g(this);
        this.abF = (ImageView) this.abD.findViewById(w.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.abF.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.abF.setLayoutParams(marginLayoutParams);
            }
        }
        this.UT = (TextView) this.abD.findViewById(w.loading_anim_ellipsis);
        this.abG = (TextView) this.abD.findViewById(w.loading_text);
        this.abF.setBackgroundResource(v.loading_animation);
        this.Lj = context.getResources().getStringArray(r.loading_anim_text_array);
        this.abH = this.Lj.length;
    }

    private void wa() {
        if (this.abF != null && (this.abF.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.abF.getBackground()).start();
        }
    }

    private void wb() {
        if (this.abF != null && (this.abF.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.abF.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.d.a
    protected void vX() {
        wa();
        this.UT.setText(this.Lj[0]);
        this.UT.postDelayed(this.yd, 200L);
    }

    @Override // com.baidu.tbadk.d.a
    protected void vY() {
        wb();
        this.UT.removeCallbacks(this.yd);
    }

    public void wc() {
        ax.b(this.UT, t.cp_cont_c, 1);
        ax.b(this.abG, t.cp_cont_c, 1);
        ax.j(this.abD, t.cp_bg_line_d);
        wb();
        ax.i(this.abF, v.loading_animation);
        wa();
    }
}

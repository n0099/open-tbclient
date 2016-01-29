package com.baidu.tbadk.f;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable Jx;
    private TextView aqb;
    private ImageView axQ;
    private String[] axR;
    private TextView axS;
    private final int axT;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Er() {
        this.currentIndex++;
        if (this.currentIndex >= this.axT) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(t.e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(t.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.Jx = new g(this);
        this.axQ = (ImageView) this.axO.findViewById(t.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.axQ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.axQ.setLayoutParams(marginLayoutParams);
            }
        }
        this.aqb = (TextView) this.axO.findViewById(t.g.loading_anim_ellipsis);
        this.axS = (TextView) this.axO.findViewById(t.g.loading_text);
        this.axR = context.getResources().getStringArray(t.b.loading_anim_text_array);
        this.axT = this.axR.length;
    }

    private void Es() {
        if (this.axQ != null && (this.axQ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.axQ.getBackground()).start();
        }
    }

    private void Et() {
        if (this.axQ != null && (this.axQ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.axQ.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.f.a
    protected void Ep() {
        ar.k(this.axQ, t.f.loading_animation);
        Es();
        this.aqb.setText(this.axR[0]);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Jx);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.Jx, 200L);
        this.axO.setClickable(true);
    }

    @Override // com.baidu.tbadk.f.a
    protected void Eq() {
        Et();
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Jx);
        this.axQ.setBackgroundResource(0);
    }

    public void uv() {
        ar.k(this.axQ, t.f.loading_animation);
        Es();
        ar.b(this.aqb, t.d.cp_cont_c, 1);
        ar.b(this.axS, t.d.cp_cont_c, 1);
        ar.l(this.axO, t.d.cp_bg_line_d);
    }
}

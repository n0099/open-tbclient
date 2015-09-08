package com.baidu.tbadk.e;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable Ix;
    private String[] acW;
    private TextView any;
    private ImageView awe;
    private TextView awf;
    private final int awg;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int CH() {
        this.currentIndex++;
        if (this.currentIndex >= this.awg) {
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
        this.Ix = new g(this);
        this.awe = (ImageView) this.awc.findViewById(i.f.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.awe.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.awe.setLayoutParams(marginLayoutParams);
            }
        }
        this.any = (TextView) this.awc.findViewById(i.f.loading_anim_ellipsis);
        this.awf = (TextView) this.awc.findViewById(i.f.loading_text);
        this.acW = context.getResources().getStringArray(i.b.loading_anim_text_array);
        this.awg = this.acW.length;
    }

    private void CI() {
        if (this.awe != null && (this.awe.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.awe.getBackground()).start();
        }
    }

    private void CJ() {
        if (this.awe != null && (this.awe.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.awe.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.e.a
    protected void CF() {
        al.h(this.awe, i.e.loading_animation);
        CI();
        this.any.setText(this.acW[0]);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Ix);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.Ix, 200L);
    }

    @Override // com.baidu.tbadk.e.a
    protected void CG() {
        CJ();
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Ix);
        this.awe.setBackgroundResource(0);
    }

    public void tf() {
        al.h(this.awe, i.e.loading_animation);
        CI();
        al.b(this.any, i.c.cp_cont_c, 1);
        al.b(this.awf, i.c.cp_cont_c, 1);
        al.i(this.awc, i.c.cp_bg_line_d);
    }
}

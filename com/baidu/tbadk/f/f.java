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
    private Runnable Ji;
    private TextView api;
    private ImageView awZ;
    private String[] axa;
    private TextView axb;
    private final int axc;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int CZ() {
        this.currentIndex++;
        if (this.currentIndex >= this.axc) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(n.e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(n.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.Ji = new g(this);
        this.awZ = (ImageView) this.awX.findViewById(n.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.awZ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.awZ.setLayoutParams(marginLayoutParams);
            }
        }
        this.api = (TextView) this.awX.findViewById(n.g.loading_anim_ellipsis);
        this.axb = (TextView) this.awX.findViewById(n.g.loading_text);
        this.axa = context.getResources().getStringArray(n.b.loading_anim_text_array);
        this.axc = this.axa.length;
    }

    private void Da() {
        if (this.awZ != null && (this.awZ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.awZ.getBackground()).start();
        }
    }

    private void Db() {
        if (this.awZ != null && (this.awZ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.awZ.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.f.a
    protected void CX() {
        as.i(this.awZ, n.f.loading_animation);
        Da();
        this.api.setText(this.axa[0]);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Ji);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.Ji, 200L);
        this.awX.setClickable(true);
    }

    @Override // com.baidu.tbadk.f.a
    protected void CY() {
        Db();
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Ji);
        this.awZ.setBackgroundResource(0);
    }

    public void tr() {
        as.i(this.awZ, n.f.loading_animation);
        Da();
        as.b(this.api, n.d.cp_cont_c, 1);
        as.b(this.axb, n.d.cp_cont_c, 1);
        as.j(this.awX, n.d.cp_bg_line_d);
    }
}

package com.baidu.tbadk.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends a {
    private ImageView aFZ;
    private String[] aGa;
    private TextView aGb;
    private final int aGc;
    private Runnable aGd;
    private TextView awZ;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Eq() {
        this.currentIndex++;
        if (this.currentIndex >= this.aGc) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(d.f.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(d.j.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.aGd = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.awZ.setText(f.this.aGa[f.this.Eq()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aGd, 200L);
            }
        };
        this.aFZ = (ImageView) this.aFX.findViewById(d.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aFZ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aFZ.setLayoutParams(marginLayoutParams);
            }
        }
        this.awZ = (TextView) this.aFX.findViewById(d.h.loading_anim_ellipsis);
        this.aGb = (TextView) this.aFX.findViewById(d.h.loading_text);
        this.aGa = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aGc = this.aGa.length;
    }

    private void Er() {
        if (this.aFZ != null && (this.aFZ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aFZ.getBackground()).start();
        }
    }

    private void Es() {
        if (this.aFZ != null && (this.aFZ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aFZ.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Eo() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.d(this.aFZ, d.g.loading_animation, this.mSkinType);
        Er();
        aj.b(this.awZ, d.e.cp_cont_c, 1, this.mSkinType);
        aj.b(this.aGb, d.e.cp_cont_c, 1, this.mSkinType);
        aj.e(this.aFX, d.e.cp_bg_line_d, this.mSkinType);
        this.awZ.setText(this.aGa[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aGd);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aGd, 200L);
        this.aFX.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Ep() {
        release();
    }

    public void release() {
        Es();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aGd);
        this.aFZ.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (En()) {
            aj.d(this.aFZ, d.g.loading_animation, this.mSkinType);
            Er();
            aj.b(this.awZ, d.e.cp_cont_c, 1, this.mSkinType);
            aj.b(this.aGb, d.e.cp_cont_c, 1, this.mSkinType);
            aj.e(this.aFX, d.e.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Et() {
        return this.aFX;
    }

    @Override // com.baidu.tbadk.j.a
    public void O(View view) {
        if (this.aFZ != null && this.aFZ.getAnimation() != null) {
            this.aFZ.getAnimation().cancel();
            this.aFZ.clearAnimation();
        }
        super.O(view);
    }

    public void setTopMargin(int i) {
        if (this.aFZ != null) {
            ViewGroup.LayoutParams layoutParams = this.aFZ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aFZ.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

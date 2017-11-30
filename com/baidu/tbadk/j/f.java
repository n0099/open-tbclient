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
    private ImageView aHg;
    private String[] aHh;
    private TextView aHi;
    private final int aHj;
    private Runnable aHk;
    private TextView axT;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int EQ() {
        this.currentIndex++;
        if (this.currentIndex >= this.aHj) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(d.e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(d.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.aHk = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.axT.setText(f.this.aHh[f.this.EQ()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aHk, 200L);
            }
        };
        this.aHg = (ImageView) this.aHe.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aHg.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHg.setLayoutParams(marginLayoutParams);
            }
        }
        this.axT = (TextView) this.aHe.findViewById(d.g.loading_anim_ellipsis);
        this.aHi = (TextView) this.aHe.findViewById(d.g.loading_text);
        this.aHh = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aHj = this.aHh.length;
    }

    private void ER() {
        if (this.aHg != null && (this.aHg.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHg.getBackground()).start();
        }
    }

    private void ES() {
        if (this.aHg != null && (this.aHg.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHg.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EO() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.d(this.aHg, d.f.loading_animation, this.mSkinType);
        ER();
        aj.b(this.axT, d.C0082d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.aHi, d.C0082d.cp_cont_c, 1, this.mSkinType);
        aj.e(this.aHe, d.C0082d.cp_bg_line_d, this.mSkinType);
        this.axT.setText(this.aHh[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aHk);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aHk, 200L);
        this.aHe.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EP() {
        release();
    }

    public void release() {
        ES();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aHk);
        this.aHg.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (EN()) {
            aj.d(this.aHg, d.f.loading_animation, this.mSkinType);
            ER();
            aj.b(this.axT, d.C0082d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.aHi, d.C0082d.cp_cont_c, 1, this.mSkinType);
            aj.e(this.aHe, d.C0082d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View ET() {
        return this.aHe;
    }

    @Override // com.baidu.tbadk.j.a
    public void O(View view) {
        if (this.aHg != null && this.aHg.getAnimation() != null) {
            this.aHg.getAnimation().cancel();
            this.aHg.clearAnimation();
        }
        super.O(view);
    }

    public void setTopMargin(int i) {
        if (this.aHg != null) {
            ViewGroup.LayoutParams layoutParams = this.aHg.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHg.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

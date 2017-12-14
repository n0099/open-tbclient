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
    private ImageView aHk;
    private String[] aHl;
    private TextView aHm;
    private final int aHn;
    private Runnable aHo;
    private TextView axY;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int ER() {
        this.currentIndex++;
        if (this.currentIndex >= this.aHn) {
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
        this.aHo = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.axY.setText(f.this.aHl[f.this.ER()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aHo, 200L);
            }
        };
        this.aHk = (ImageView) this.aHi.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aHk.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHk.setLayoutParams(marginLayoutParams);
            }
        }
        this.axY = (TextView) this.aHi.findViewById(d.g.loading_anim_ellipsis);
        this.aHm = (TextView) this.aHi.findViewById(d.g.loading_text);
        this.aHl = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aHn = this.aHl.length;
    }

    private void ES() {
        if (this.aHk != null && (this.aHk.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHk.getBackground()).start();
        }
    }

    private void ET() {
        if (this.aHk != null && (this.aHk.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHk.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EP() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.d(this.aHk, d.f.loading_animation, this.mSkinType);
        ES();
        aj.b(this.axY, d.C0096d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.aHm, d.C0096d.cp_cont_c, 1, this.mSkinType);
        aj.e(this.aHi, d.C0096d.cp_bg_line_d, this.mSkinType);
        this.axY.setText(this.aHl[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aHo);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aHo, 200L);
        this.aHi.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EQ() {
        release();
    }

    public void release() {
        ET();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aHo);
        this.aHk.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (EO()) {
            aj.d(this.aHk, d.f.loading_animation, this.mSkinType);
            ES();
            aj.b(this.axY, d.C0096d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.aHm, d.C0096d.cp_cont_c, 1, this.mSkinType);
            aj.e(this.aHi, d.C0096d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View EU() {
        return this.aHi;
    }

    @Override // com.baidu.tbadk.j.a
    public void P(View view) {
        if (this.aHk != null && this.aHk.getAnimation() != null) {
            this.aHk.getAnimation().cancel();
            this.aHk.clearAnimation();
        }
        super.P(view);
    }

    public void setTopMargin(int i) {
        if (this.aHk != null) {
            ViewGroup.LayoutParams layoutParams = this.aHk.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHk.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

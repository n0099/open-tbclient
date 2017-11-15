package com.baidu.tbadk.k;

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
    private ImageView aGE;
    private String[] aGF;
    private TextView aGG;
    private final int aGH;
    private Runnable aGI;
    private TextView axs;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int EJ() {
        this.currentIndex++;
        if (this.currentIndex >= this.aGH) {
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
        this.aGI = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.axs.setText(f.this.aGF[f.this.EJ()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aGI, 200L);
            }
        };
        this.aGE = (ImageView) this.aGC.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aGE.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aGE.setLayoutParams(marginLayoutParams);
            }
        }
        this.axs = (TextView) this.aGC.findViewById(d.g.loading_anim_ellipsis);
        this.aGG = (TextView) this.aGC.findViewById(d.g.loading_text);
        this.aGF = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aGH = this.aGF.length;
    }

    private void EK() {
        if (this.aGE != null && (this.aGE.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aGE.getBackground()).start();
        }
    }

    private void EL() {
        if (this.aGE != null && (this.aGE.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aGE.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EH() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.d(this.aGE, d.f.loading_animation, this.mSkinType);
        EK();
        aj.b(this.axs, d.C0080d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.aGG, d.C0080d.cp_cont_c, 1, this.mSkinType);
        aj.e(this.aGC, d.C0080d.cp_bg_line_d, this.mSkinType);
        this.axs.setText(this.aGF[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aGI);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aGI, 200L);
        this.aGC.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EI() {
        release();
    }

    public void release() {
        EL();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aGI);
        this.aGE.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (EG()) {
            aj.d(this.aGE, d.f.loading_animation, this.mSkinType);
            EK();
            aj.b(this.axs, d.C0080d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.aGG, d.C0080d.cp_cont_c, 1, this.mSkinType);
            aj.e(this.aGC, d.C0080d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View EM() {
        return this.aGC;
    }

    @Override // com.baidu.tbadk.k.a
    public void O(View view) {
        if (this.aGE != null && this.aGE.getAnimation() != null) {
            this.aGE.getAnimation().cancel();
            this.aGE.clearAnimation();
        }
        super.O(view);
    }

    public void setTopMargin(int i) {
        if (this.aGE != null) {
            ViewGroup.LayoutParams layoutParams = this.aGE.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aGE.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

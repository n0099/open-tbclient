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
    private TextView boL;
    private ImageView bxC;
    private String[] bxD;
    private TextView bxE;
    private final int bxF;
    private Runnable bxG;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int MM() {
        this.currentIndex++;
        if (this.currentIndex >= this.bxF) {
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
        this.bxG = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.MJ()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.bxG);
                    return;
                }
                f.this.boL.setText(f.this.bxD[f.this.MM()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.bxG, 200L);
            }
        };
        this.bxC = (ImageView) this.bxA.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bxC.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bxC.setLayoutParams(marginLayoutParams);
            }
        }
        this.boL = (TextView) this.bxA.findViewById(d.g.loading_anim_ellipsis);
        this.bxE = (TextView) this.bxA.findViewById(d.g.loading_text);
        this.bxD = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.bxF = this.bxD.length;
    }

    private void MN() {
        if (this.bxC != null && (this.bxC.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bxC.getBackground()).start();
        }
    }

    private void MO() {
        if (this.bxC != null && (this.bxC.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bxC.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MK() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.f(this.bxC, d.f.loading_animation, this.mSkinType);
        MN();
        aj.b(this.boL, d.C0140d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.bxE, d.C0140d.cp_cont_c, 1, this.mSkinType);
        aj.g(this.bxA, d.C0140d.cp_bg_line_d, this.mSkinType);
        this.boL.setText(this.bxD[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxG);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bxG, 200L);
        this.bxA.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void ML() {
        release();
    }

    public void release() {
        MO();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxG);
        this.bxC.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (MJ()) {
            aj.f(this.bxC, d.f.loading_animation, this.mSkinType);
            MN();
            aj.b(this.boL, d.C0140d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.bxE, d.C0140d.cp_cont_c, 1, this.mSkinType);
            aj.g(this.bxA, d.C0140d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View MP() {
        return this.bxA;
    }

    @Override // com.baidu.tbadk.j.a
    public void bk(View view) {
        if (this.bxC != null && this.bxC.getAnimation() != null) {
            this.bxC.getAnimation().cancel();
            this.bxC.clearAnimation();
        }
        super.bk(view);
    }

    public void setTopMargin(int i) {
        if (this.bxC != null) {
            ViewGroup.LayoutParams layoutParams = this.bxC.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bxC.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

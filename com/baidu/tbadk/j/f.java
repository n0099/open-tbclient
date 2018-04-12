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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends a {
    private ImageView aHP;
    private String[] aHQ;
    private TextView aHR;
    private final int aHS;
    private Runnable aHT;
    private TextView aza;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Fp() {
        this.currentIndex++;
        if (this.currentIndex >= this.aHS) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(d.e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(d.i.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.aHT = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.Fm()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.aHT);
                    return;
                }
                f.this.aza.setText(f.this.aHQ[f.this.Fp()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aHT, 200L);
            }
        };
        this.aHP = (ImageView) this.aHN.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aHP.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHP.setLayoutParams(marginLayoutParams);
            }
        }
        this.aza = (TextView) this.aHN.findViewById(d.g.loading_anim_ellipsis);
        this.aHR = (TextView) this.aHN.findViewById(d.g.loading_text);
        this.aHQ = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aHS = this.aHQ.length;
    }

    private void Fq() {
        if (this.aHP != null && (this.aHP.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHP.getBackground()).start();
        }
    }

    private void Fr() {
        if (this.aHP != null && (this.aHP.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHP.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fn() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        ak.d(this.aHP, d.f.loading_animation, this.mSkinType);
        Fq();
        ak.b(this.aza, d.C0126d.cp_cont_c, 1, this.mSkinType);
        ak.b(this.aHR, d.C0126d.cp_cont_c, 1, this.mSkinType);
        ak.e(this.aHN, d.C0126d.cp_bg_line_d, this.mSkinType);
        this.aza.setText(this.aHQ[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aHT);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aHT, 200L);
        this.aHN.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fo() {
        release();
    }

    public void release() {
        Fr();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aHT);
        this.aHP.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Fm()) {
            ak.d(this.aHP, d.f.loading_animation, this.mSkinType);
            Fq();
            ak.b(this.aza, d.C0126d.cp_cont_c, 1, this.mSkinType);
            ak.b(this.aHR, d.C0126d.cp_cont_c, 1, this.mSkinType);
            ak.e(this.aHN, d.C0126d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Fs() {
        return this.aHN;
    }

    @Override // com.baidu.tbadk.j.a
    public void P(View view2) {
        if (this.aHP != null && this.aHP.getAnimation() != null) {
            this.aHP.getAnimation().cancel();
            this.aHP.clearAnimation();
        }
        super.P(view2);
    }

    public void setTopMargin(int i) {
        if (this.aHP != null) {
            ViewGroup.LayoutParams layoutParams = this.aHP.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHP.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

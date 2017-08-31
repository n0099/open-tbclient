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
    private ImageView aGB;
    private String[] aGC;
    private TextView aGD;
    private final int aGE;
    private Runnable aGF;
    private TextView axS;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int EL() {
        this.currentIndex++;
        if (this.currentIndex >= this.aGE) {
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
        this.aGF = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.axS.setText(f.this.aGC[f.this.EL()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aGF, 200L);
            }
        };
        this.aGB = (ImageView) this.aGz.findViewById(d.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aGB.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aGB.setLayoutParams(marginLayoutParams);
            }
        }
        this.axS = (TextView) this.aGz.findViewById(d.h.loading_anim_ellipsis);
        this.aGD = (TextView) this.aGz.findViewById(d.h.loading_text);
        this.aGC = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aGE = this.aGC.length;
    }

    private void EM() {
        if (this.aGB != null && (this.aGB.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aGB.getBackground()).start();
        }
    }

    private void EN() {
        if (this.aGB != null && (this.aGB.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aGB.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EJ() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.d(this.aGB, d.g.loading_animation, this.mSkinType);
        EM();
        aj.b(this.axS, d.e.cp_cont_c, 1, this.mSkinType);
        aj.b(this.aGD, d.e.cp_cont_c, 1, this.mSkinType);
        aj.e(this.aGz, d.e.cp_bg_line_d, this.mSkinType);
        this.axS.setText(this.aGC[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aGF);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aGF, 200L);
        this.aGz.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EK() {
        release();
    }

    public void release() {
        EN();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aGF);
        this.aGB.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (EI()) {
            aj.d(this.aGB, d.g.loading_animation, this.mSkinType);
            EM();
            aj.b(this.axS, d.e.cp_cont_c, 1, this.mSkinType);
            aj.b(this.aGD, d.e.cp_cont_c, 1, this.mSkinType);
            aj.e(this.aGz, d.e.cp_bg_line_d, this.mSkinType);
        }
    }

    public View EO() {
        return this.aGz;
    }

    public void setTopMargin(int i) {
        if (this.aGB != null) {
            ViewGroup.LayoutParams layoutParams = this.aGB.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aGB.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

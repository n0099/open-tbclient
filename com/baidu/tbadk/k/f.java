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
    private TextView aGA;
    private final int aGB;
    private Runnable aGC;
    private ImageView aGy;
    private String[] aGz;
    private TextView axP;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int EL() {
        this.currentIndex++;
        if (this.currentIndex >= this.aGB) {
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
        this.aGC = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.axP.setText(f.this.aGz[f.this.EL()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aGC, 200L);
            }
        };
        this.aGy = (ImageView) this.aGw.findViewById(d.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aGy.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aGy.setLayoutParams(marginLayoutParams);
            }
        }
        this.axP = (TextView) this.aGw.findViewById(d.h.loading_anim_ellipsis);
        this.aGA = (TextView) this.aGw.findViewById(d.h.loading_text);
        this.aGz = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aGB = this.aGz.length;
    }

    private void EM() {
        if (this.aGy != null && (this.aGy.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aGy.getBackground()).start();
        }
    }

    private void EN() {
        if (this.aGy != null && (this.aGy.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aGy.getBackground()).stop();
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
        aj.d(this.aGy, d.g.loading_animation, this.mSkinType);
        EM();
        aj.b(this.axP, d.e.cp_cont_c, 1, this.mSkinType);
        aj.b(this.aGA, d.e.cp_cont_c, 1, this.mSkinType);
        aj.e(this.aGw, d.e.cp_bg_line_d, this.mSkinType);
        this.axP.setText(this.aGz[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aGC);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aGC, 200L);
        this.aGw.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EK() {
        release();
    }

    public void release() {
        EN();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aGC);
        this.aGy.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (EI()) {
            aj.d(this.aGy, d.g.loading_animation, this.mSkinType);
            EM();
            aj.b(this.axP, d.e.cp_cont_c, 1, this.mSkinType);
            aj.b(this.aGA, d.e.cp_cont_c, 1, this.mSkinType);
            aj.e(this.aGw, d.e.cp_bg_line_d, this.mSkinType);
        }
    }

    public View EO() {
        return this.aGw;
    }

    public void setTopMargin(int i) {
        if (this.aGy != null) {
            ViewGroup.LayoutParams layoutParams = this.aGy.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aGy.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

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
    private ImageView aFM;
    private String[] aFN;
    private TextView aFO;
    private final int aFP;
    private Runnable aFQ;
    private TextView awN;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ek() {
        this.currentIndex++;
        if (this.currentIndex >= this.aFP) {
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
        this.aFQ = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.awN.setText(f.this.aFN[f.this.Ek()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aFQ, 200L);
            }
        };
        this.aFM = (ImageView) this.aFK.findViewById(d.h.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aFM.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aFM.setLayoutParams(marginLayoutParams);
            }
        }
        this.awN = (TextView) this.aFK.findViewById(d.h.loading_anim_ellipsis);
        this.aFO = (TextView) this.aFK.findViewById(d.h.loading_text);
        this.aFN = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aFP = this.aFN.length;
    }

    private void El() {
        if (this.aFM != null && (this.aFM.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aFM.getBackground()).start();
        }
    }

    private void Em() {
        if (this.aFM != null && (this.aFM.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aFM.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Ei() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.d(this.aFM, d.g.loading_animation, this.mSkinType);
        El();
        aj.b(this.awN, d.e.cp_cont_c, 1, this.mSkinType);
        aj.b(this.aFO, d.e.cp_cont_c, 1, this.mSkinType);
        aj.e(this.aFK, d.e.cp_bg_line_d, this.mSkinType);
        this.awN.setText(this.aFN[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aFQ);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aFQ, 200L);
        this.aFK.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Ej() {
        release();
    }

    public void release() {
        Em();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aFQ);
        this.aFM.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Eh()) {
            aj.d(this.aFM, d.g.loading_animation, this.mSkinType);
            El();
            aj.b(this.awN, d.e.cp_cont_c, 1, this.mSkinType);
            aj.b(this.aFO, d.e.cp_cont_c, 1, this.mSkinType);
            aj.e(this.aFK, d.e.cp_bg_line_d, this.mSkinType);
        }
    }

    public View En() {
        return this.aFK;
    }

    @Override // com.baidu.tbadk.j.a
    public void O(View view) {
        if (this.aFM != null && this.aFM.getAnimation() != null) {
            this.aFM.getAnimation().cancel();
            this.aFM.clearAnimation();
        }
        super.O(view);
    }

    public void setTopMargin(int i) {
        if (this.aFM != null) {
            ViewGroup.LayoutParams layoutParams = this.aFM.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aFM.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

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
    private ImageView aHQ;
    private String[] aHR;
    private TextView aHS;
    private final int aHT;
    private Runnable aHU;
    private TextView azb;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Fn() {
        this.currentIndex++;
        if (this.currentIndex >= this.aHT) {
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
        this.aHU = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.Fk()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.aHU);
                    return;
                }
                f.this.azb.setText(f.this.aHR[f.this.Fn()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aHU, 200L);
            }
        };
        this.aHQ = (ImageView) this.aHO.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aHQ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHQ.setLayoutParams(marginLayoutParams);
            }
        }
        this.azb = (TextView) this.aHO.findViewById(d.g.loading_anim_ellipsis);
        this.aHS = (TextView) this.aHO.findViewById(d.g.loading_text);
        this.aHR = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aHT = this.aHR.length;
    }

    private void Fo() {
        if (this.aHQ != null && (this.aHQ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHQ.getBackground()).start();
        }
    }

    private void Fp() {
        if (this.aHQ != null && (this.aHQ.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHQ.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fl() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        ak.d(this.aHQ, d.f.loading_animation, this.mSkinType);
        Fo();
        ak.b(this.azb, d.C0126d.cp_cont_c, 1, this.mSkinType);
        ak.b(this.aHS, d.C0126d.cp_cont_c, 1, this.mSkinType);
        ak.e(this.aHO, d.C0126d.cp_bg_line_d, this.mSkinType);
        this.azb.setText(this.aHR[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aHU);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aHU, 200L);
        this.aHO.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fm() {
        release();
    }

    public void release() {
        Fp();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aHU);
        this.aHQ.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Fk()) {
            ak.d(this.aHQ, d.f.loading_animation, this.mSkinType);
            Fo();
            ak.b(this.azb, d.C0126d.cp_cont_c, 1, this.mSkinType);
            ak.b(this.aHS, d.C0126d.cp_cont_c, 1, this.mSkinType);
            ak.e(this.aHO, d.C0126d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Fq() {
        return this.aHO;
    }

    @Override // com.baidu.tbadk.j.a
    public void P(View view2) {
        if (this.aHQ != null && this.aHQ.getAnimation() != null) {
            this.aHQ.getAnimation().cancel();
            this.aHQ.clearAnimation();
        }
        super.P(view2);
    }

    public void setTopMargin(int i) {
        if (this.aHQ != null) {
            ViewGroup.LayoutParams layoutParams = this.aHQ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHQ.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

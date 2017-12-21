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
    private ImageView aHn;
    private String[] aHo;
    private TextView aHp;
    private final int aHq;
    private Runnable aHr;
    private TextView ayb;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int ER() {
        this.currentIndex++;
        if (this.currentIndex >= this.aHq) {
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
        this.aHr = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.ayb.setText(f.this.aHo[f.this.ER()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aHr, 200L);
            }
        };
        this.aHn = (ImageView) this.aHl.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aHn.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHn.setLayoutParams(marginLayoutParams);
            }
        }
        this.ayb = (TextView) this.aHl.findViewById(d.g.loading_anim_ellipsis);
        this.aHp = (TextView) this.aHl.findViewById(d.g.loading_text);
        this.aHo = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aHq = this.aHo.length;
    }

    private void ES() {
        if (this.aHn != null && (this.aHn.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHn.getBackground()).start();
        }
    }

    private void ET() {
        if (this.aHn != null && (this.aHn.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aHn.getBackground()).stop();
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
        aj.d(this.aHn, d.f.loading_animation, this.mSkinType);
        ES();
        aj.b(this.ayb, d.C0095d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.aHp, d.C0095d.cp_cont_c, 1, this.mSkinType);
        aj.e(this.aHl, d.C0095d.cp_bg_line_d, this.mSkinType);
        this.ayb.setText(this.aHo[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aHr);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aHr, 200L);
        this.aHl.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EQ() {
        release();
    }

    public void release() {
        ET();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aHr);
        this.aHn.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (EO()) {
            aj.d(this.aHn, d.f.loading_animation, this.mSkinType);
            ES();
            aj.b(this.ayb, d.C0095d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.aHp, d.C0095d.cp_cont_c, 1, this.mSkinType);
            aj.e(this.aHl, d.C0095d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View EU() {
        return this.aHl;
    }

    @Override // com.baidu.tbadk.j.a
    public void P(View view) {
        if (this.aHn != null && this.aHn.getAnimation() != null) {
            this.aHn.getAnimation().cancel();
            this.aHn.clearAnimation();
        }
        super.P(view);
    }

    public void setTopMargin(int i) {
        if (this.aHn != null) {
            ViewGroup.LayoutParams layoutParams = this.aHn.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aHn.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

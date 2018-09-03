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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class f extends a {
    private TextView aIr;
    private ImageView aRg;
    private String[] aRh;
    private TextView aRi;
    private final int aRj;
    private Runnable aRk;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Jf() {
        this.currentIndex++;
        if (this.currentIndex >= this.aRj) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(f.e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(f.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.aRk = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.Jc()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.aRk);
                    return;
                }
                f.this.aIr.setText(f.this.aRh[f.this.Jf()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aRk, 200L);
            }
        };
        this.aRg = (ImageView) this.aRe.findViewById(f.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aRg.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aRg.setLayoutParams(marginLayoutParams);
            }
        }
        this.aIr = (TextView) this.aRe.findViewById(f.g.loading_anim_ellipsis);
        this.aRi = (TextView) this.aRe.findViewById(f.g.loading_text);
        this.aRh = context.getResources().getStringArray(f.b.loading_anim_text_array);
        this.aRj = this.aRh.length;
    }

    private void Jg() {
        if (this.aRg != null && (this.aRg.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aRg.getBackground()).start();
        }
    }

    private void Jh() {
        if (this.aRg != null && (this.aRg.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aRg.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Jd() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        am.d(this.aRg, f.C0146f.loading_animation, this.mSkinType);
        Jg();
        am.b(this.aIr, f.d.cp_cont_c, 1, this.mSkinType);
        am.b(this.aRi, f.d.cp_cont_c, 1, this.mSkinType);
        am.e(this.aRe, f.d.cp_bg_line_d, this.mSkinType);
        this.aIr.setText(this.aRh[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aRk);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aRk, 200L);
        this.aRe.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Je() {
        release();
    }

    public void release() {
        Jh();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aRk);
        this.aRg.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Jc()) {
            am.d(this.aRg, f.C0146f.loading_animation, this.mSkinType);
            Jg();
            am.b(this.aIr, f.d.cp_cont_c, 1, this.mSkinType);
            am.b(this.aRi, f.d.cp_cont_c, 1, this.mSkinType);
            am.e(this.aRe, f.d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Ji() {
        return this.aRe;
    }

    @Override // com.baidu.tbadk.k.a
    public void Q(View view) {
        if (this.aRg != null && this.aRg.getAnimation() != null) {
            this.aRg.getAnimation().cancel();
            this.aRg.clearAnimation();
        }
        super.Q(view);
    }

    public void setTopMargin(int i) {
        if (this.aRg != null) {
            ViewGroup.LayoutParams layoutParams = this.aRg.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aRg.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

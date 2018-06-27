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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends a {
    private TextView aIt;
    private ImageView aRj;
    private String[] aRk;
    private TextView aRl;
    private final int aRm;
    private Runnable aRn;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Jk() {
        this.currentIndex++;
        if (this.currentIndex >= this.aRm) {
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
        this.aRn = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.Jh()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.aRn);
                    return;
                }
                f.this.aIt.setText(f.this.aRk[f.this.Jk()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aRn, 200L);
            }
        };
        this.aRj = (ImageView) this.aRh.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aRj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aRj.setLayoutParams(marginLayoutParams);
            }
        }
        this.aIt = (TextView) this.aRh.findViewById(d.g.loading_anim_ellipsis);
        this.aRl = (TextView) this.aRh.findViewById(d.g.loading_text);
        this.aRk = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aRm = this.aRk.length;
    }

    private void Jl() {
        if (this.aRj != null && (this.aRj.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aRj.getBackground()).start();
        }
    }

    private void Jm() {
        if (this.aRj != null && (this.aRj.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aRj.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Ji() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        am.d(this.aRj, d.f.loading_animation, this.mSkinType);
        Jl();
        am.b(this.aIt, d.C0142d.cp_cont_c, 1, this.mSkinType);
        am.b(this.aRl, d.C0142d.cp_cont_c, 1, this.mSkinType);
        am.e(this.aRh, d.C0142d.cp_bg_line_d, this.mSkinType);
        this.aIt.setText(this.aRk[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aRn);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aRn, 200L);
        this.aRh.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Jj() {
        release();
    }

    public void release() {
        Jm();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aRn);
        this.aRj.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Jh()) {
            am.d(this.aRj, d.f.loading_animation, this.mSkinType);
            Jl();
            am.b(this.aIt, d.C0142d.cp_cont_c, 1, this.mSkinType);
            am.b(this.aRl, d.C0142d.cp_cont_c, 1, this.mSkinType);
            am.e(this.aRh, d.C0142d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Jn() {
        return this.aRh;
    }

    @Override // com.baidu.tbadk.j.a
    public void Q(View view) {
        if (this.aRj != null && this.aRj.getAnimation() != null) {
            this.aRj.getAnimation().cancel();
            this.aRj.clearAnimation();
        }
        super.Q(view);
    }

    public void setTopMargin(int i) {
        if (this.aRj != null) {
            ViewGroup.LayoutParams layoutParams = this.aRj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aRj.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

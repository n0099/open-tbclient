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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class f extends a {
    private TextView aLH;
    private TextView aUA;
    private final int aUB;
    private Runnable aUC;
    private ImageView aUy;
    private String[] aUz;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Kv() {
        this.currentIndex++;
        if (this.currentIndex >= this.aUB) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(e.C0141e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(e.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.aUC = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.Ks()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.aUC);
                    return;
                }
                f.this.aLH.setText(f.this.aUz[f.this.Kv()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aUC, 200L);
            }
        };
        this.aUy = (ImageView) this.aUw.findViewById(e.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aUy.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aUy.setLayoutParams(marginLayoutParams);
            }
        }
        this.aLH = (TextView) this.aUw.findViewById(e.g.loading_anim_ellipsis);
        this.aUA = (TextView) this.aUw.findViewById(e.g.loading_text);
        this.aUz = context.getResources().getStringArray(e.b.loading_anim_text_array);
        this.aUB = this.aUz.length;
    }

    private void Kw() {
        if (this.aUy != null && (this.aUy.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aUy.getBackground()).start();
        }
    }

    private void Kx() {
        if (this.aUy != null && (this.aUy.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aUy.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Kt() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        al.d(this.aUy, e.f.loading_animation, this.mSkinType);
        Kw();
        al.b(this.aLH, e.d.cp_cont_c, 1, this.mSkinType);
        al.b(this.aUA, e.d.cp_cont_c, 1, this.mSkinType);
        al.e(this.aUw, e.d.cp_bg_line_d, this.mSkinType);
        this.aLH.setText(this.aUz[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aUC);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aUC, 200L);
        this.aUw.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Ku() {
        release();
    }

    public void release() {
        Kx();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aUC);
        this.aUy.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Ks()) {
            al.d(this.aUy, e.f.loading_animation, this.mSkinType);
            Kw();
            al.b(this.aLH, e.d.cp_cont_c, 1, this.mSkinType);
            al.b(this.aUA, e.d.cp_cont_c, 1, this.mSkinType);
            al.e(this.aUw, e.d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Ky() {
        return this.aUw;
    }

    @Override // com.baidu.tbadk.k.a
    public void ad(View view) {
        if (this.aUy != null && this.aUy.getAnimation() != null) {
            this.aUy.getAnimation().cancel();
            this.aUy.clearAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aUC);
        super.ad(view);
    }

    public void setTopMargin(int i) {
        if (this.aUy != null) {
            ViewGroup.LayoutParams layoutParams = this.aUy.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aUy.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

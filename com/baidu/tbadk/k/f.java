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
    private Runnable aGA;
    private ImageView aGw;
    private String[] aGx;
    private TextView aGy;
    private final int aGz;
    private TextView axk;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ex() {
        this.currentIndex++;
        if (this.currentIndex >= this.aGz) {
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
        this.aGA = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.axk.setText(f.this.aGx[f.this.Ex()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aGA, 200L);
            }
        };
        this.aGw = (ImageView) this.aGu.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aGw.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aGw.setLayoutParams(marginLayoutParams);
            }
        }
        this.axk = (TextView) this.aGu.findViewById(d.g.loading_anim_ellipsis);
        this.aGy = (TextView) this.aGu.findViewById(d.g.loading_text);
        this.aGx = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aGz = this.aGx.length;
    }

    private void Ey() {
        if (this.aGw != null && (this.aGw.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aGw.getBackground()).start();
        }
    }

    private void Ez() {
        if (this.aGw != null && (this.aGw.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aGw.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Ev() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.d(this.aGw, d.f.loading_animation, this.mSkinType);
        Ey();
        aj.b(this.axk, d.C0080d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.aGy, d.C0080d.cp_cont_c, 1, this.mSkinType);
        aj.e(this.aGu, d.C0080d.cp_bg_line_d, this.mSkinType);
        this.axk.setText(this.aGx[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aGA);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aGA, 200L);
        this.aGu.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Ew() {
        release();
    }

    public void release() {
        Ez();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aGA);
        this.aGw.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Eu()) {
            aj.d(this.aGw, d.f.loading_animation, this.mSkinType);
            Ey();
            aj.b(this.axk, d.C0080d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.aGy, d.C0080d.cp_cont_c, 1, this.mSkinType);
            aj.e(this.aGu, d.C0080d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View EA() {
        return this.aGu;
    }

    @Override // com.baidu.tbadk.k.a
    public void O(View view) {
        if (this.aGw != null && this.aGw.getAnimation() != null) {
            this.aGw.getAnimation().cancel();
            this.aGw.clearAnimation();
        }
        super.O(view);
    }

    public void setTopMargin(int i) {
        if (this.aGw != null) {
            ViewGroup.LayoutParams layoutParams = this.aGw.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aGw.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

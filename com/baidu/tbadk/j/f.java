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
    private TextView bmp;
    private ImageView bvj;
    private String[] bvk;
    private TextView bvl;
    private final int bvm;
    private Runnable bvn;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Me() {
        this.currentIndex++;
        if (this.currentIndex >= this.bvm) {
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
        this.bvn = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.Mb()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.bvn);
                    return;
                }
                f.this.bmp.setText(f.this.bvk[f.this.Me()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.bvn, 200L);
            }
        };
        this.bvj = (ImageView) this.bvh.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bvj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bvj.setLayoutParams(marginLayoutParams);
            }
        }
        this.bmp = (TextView) this.bvh.findViewById(d.g.loading_anim_ellipsis);
        this.bvl = (TextView) this.bvh.findViewById(d.g.loading_text);
        this.bvk = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.bvm = this.bvk.length;
    }

    private void Mf() {
        if (this.bvj != null && (this.bvj.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bvj.getBackground()).start();
        }
    }

    private void Mg() {
        if (this.bvj != null && (this.bvj.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bvj.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mc() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.f(this.bvj, d.f.loading_animation, this.mSkinType);
        Mf();
        aj.b(this.bmp, d.C0107d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.bvl, d.C0107d.cp_cont_c, 1, this.mSkinType);
        aj.g(this.bvh, d.C0107d.cp_bg_line_d, this.mSkinType);
        this.bmp.setText(this.bvk[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bvn);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bvn, 200L);
        this.bvh.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Md() {
        release();
    }

    public void release() {
        Mg();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bvn);
        this.bvj.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Mb()) {
            aj.f(this.bvj, d.f.loading_animation, this.mSkinType);
            Mf();
            aj.b(this.bmp, d.C0107d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.bvl, d.C0107d.cp_cont_c, 1, this.mSkinType);
            aj.g(this.bvh, d.C0107d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Mh() {
        return this.bvh;
    }

    @Override // com.baidu.tbadk.j.a
    public void bk(View view) {
        if (this.bvj != null && this.bvj.getAnimation() != null) {
            this.bvj.getAnimation().cancel();
            this.bvj.clearAnimation();
        }
        super.bk(view);
    }

    public void setTopMargin(int i) {
        if (this.bvj != null) {
            ViewGroup.LayoutParams layoutParams = this.bvj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bvj.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

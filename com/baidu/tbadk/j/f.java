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
    private TextView bmx;
    private ImageView bvs;
    private String[] bvt;
    private TextView bvu;
    private final int bvv;
    private Runnable bvw;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Mg() {
        this.currentIndex++;
        if (this.currentIndex >= this.bvv) {
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
        this.bvw = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.Md()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.bvw);
                    return;
                }
                f.this.bmx.setText(f.this.bvt[f.this.Mg()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.bvw, 200L);
            }
        };
        this.bvs = (ImageView) this.bvq.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bvs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bvs.setLayoutParams(marginLayoutParams);
            }
        }
        this.bmx = (TextView) this.bvq.findViewById(d.g.loading_anim_ellipsis);
        this.bvu = (TextView) this.bvq.findViewById(d.g.loading_text);
        this.bvt = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.bvv = this.bvt.length;
    }

    private void Mh() {
        if (this.bvs != null && (this.bvs.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bvs.getBackground()).start();
        }
    }

    private void Mi() {
        if (this.bvs != null && (this.bvs.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bvs.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Me() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.f(this.bvs, d.f.loading_animation, this.mSkinType);
        Mh();
        aj.b(this.bmx, d.C0108d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.bvu, d.C0108d.cp_cont_c, 1, this.mSkinType);
        aj.g(this.bvq, d.C0108d.cp_bg_line_d, this.mSkinType);
        this.bmx.setText(this.bvt[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bvw);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bvw, 200L);
        this.bvq.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mf() {
        release();
    }

    public void release() {
        Mi();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bvw);
        this.bvs.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Md()) {
            aj.f(this.bvs, d.f.loading_animation, this.mSkinType);
            Mh();
            aj.b(this.bmx, d.C0108d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.bvu, d.C0108d.cp_cont_c, 1, this.mSkinType);
            aj.g(this.bvq, d.C0108d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Mj() {
        return this.bvq;
    }

    @Override // com.baidu.tbadk.j.a
    public void bk(View view) {
        if (this.bvs != null && this.bvs.getAnimation() != null) {
            this.bvs.getAnimation().cancel();
            this.bvs.clearAnimation();
        }
        super.bk(view);
    }

    public void setTopMargin(int i) {
        if (this.bvs != null) {
            ViewGroup.LayoutParams layoutParams = this.bvs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bvs.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

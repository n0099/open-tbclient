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
    private TextView boB;
    private ImageView bxs;
    private String[] bxt;
    private TextView bxu;
    private final int bxv;
    private Runnable bxw;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int MM() {
        this.currentIndex++;
        if (this.currentIndex >= this.bxv) {
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
        this.bxw = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.MJ()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.bxw);
                    return;
                }
                f.this.boB.setText(f.this.bxt[f.this.MM()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.bxw, 200L);
            }
        };
        this.bxs = (ImageView) this.bxq.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bxs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bxs.setLayoutParams(marginLayoutParams);
            }
        }
        this.boB = (TextView) this.bxq.findViewById(d.g.loading_anim_ellipsis);
        this.bxu = (TextView) this.bxq.findViewById(d.g.loading_text);
        this.bxt = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.bxv = this.bxt.length;
    }

    private void MN() {
        if (this.bxs != null && (this.bxs.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bxs.getBackground()).start();
        }
    }

    private void MO() {
        if (this.bxs != null && (this.bxs.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bxs.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MK() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.f(this.bxs, d.f.loading_animation, this.mSkinType);
        MN();
        aj.b(this.boB, d.C0141d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.bxu, d.C0141d.cp_cont_c, 1, this.mSkinType);
        aj.g(this.bxq, d.C0141d.cp_bg_line_d, this.mSkinType);
        this.boB.setText(this.bxt[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxw);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bxw, 200L);
        this.bxq.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void ML() {
        release();
    }

    public void release() {
        MO();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxw);
        this.bxs.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (MJ()) {
            aj.f(this.bxs, d.f.loading_animation, this.mSkinType);
            MN();
            aj.b(this.boB, d.C0141d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.bxu, d.C0141d.cp_cont_c, 1, this.mSkinType);
            aj.g(this.bxq, d.C0141d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View MP() {
        return this.bxq;
    }

    @Override // com.baidu.tbadk.j.a
    public void bk(View view) {
        if (this.bxs != null && this.bxs.getAnimation() != null) {
            this.bxs.getAnimation().cancel();
            this.bxs.clearAnimation();
        }
        super.bk(view);
    }

    public void setTopMargin(int i) {
        if (this.bxs != null) {
            ViewGroup.LayoutParams layoutParams = this.bxs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bxs.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

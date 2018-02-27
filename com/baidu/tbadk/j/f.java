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
    private TextView boy;
    private ImageView bxp;
    private String[] bxq;
    private TextView bxr;
    private final int bxs;
    private Runnable bxt;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int ML() {
        this.currentIndex++;
        if (this.currentIndex >= this.bxs) {
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
        this.bxt = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.MI()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.bxt);
                    return;
                }
                f.this.boy.setText(f.this.bxq[f.this.ML()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.bxt, 200L);
            }
        };
        this.bxp = (ImageView) this.bxn.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bxp.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bxp.setLayoutParams(marginLayoutParams);
            }
        }
        this.boy = (TextView) this.bxn.findViewById(d.g.loading_anim_ellipsis);
        this.bxr = (TextView) this.bxn.findViewById(d.g.loading_text);
        this.bxq = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.bxs = this.bxq.length;
    }

    private void MM() {
        if (this.bxp != null && (this.bxp.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bxp.getBackground()).start();
        }
    }

    private void MN() {
        if (this.bxp != null && (this.bxp.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bxp.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MJ() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.f(this.bxp, d.f.loading_animation, this.mSkinType);
        MM();
        aj.b(this.boy, d.C0141d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.bxr, d.C0141d.cp_cont_c, 1, this.mSkinType);
        aj.g(this.bxn, d.C0141d.cp_bg_line_d, this.mSkinType);
        this.boy.setText(this.bxq[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxt);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bxt, 200L);
        this.bxn.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MK() {
        release();
    }

    public void release() {
        MN();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bxt);
        this.bxp.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (MI()) {
            aj.f(this.bxp, d.f.loading_animation, this.mSkinType);
            MM();
            aj.b(this.boy, d.C0141d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.bxr, d.C0141d.cp_cont_c, 1, this.mSkinType);
            aj.g(this.bxn, d.C0141d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View MO() {
        return this.bxn;
    }

    @Override // com.baidu.tbadk.j.a
    public void bk(View view) {
        if (this.bxp != null && this.bxp.getAnimation() != null) {
            this.bxp.getAnimation().cancel();
            this.bxp.clearAnimation();
        }
        super.bk(view);
    }

    public void setTopMargin(int i) {
        if (this.bxp != null) {
            ViewGroup.LayoutParams layoutParams = this.bxp.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bxp.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

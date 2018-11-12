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
    private TextView aQZ;
    private ImageView aZK;
    private String[] aZL;
    private TextView aZM;
    private final int aZN;
    private Runnable aZO;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int MC() {
        this.currentIndex++;
        if (this.currentIndex >= this.aZN) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(e.C0200e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(e.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.aZO = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.aZO);
                    return;
                }
                f.this.aQZ.setText(f.this.aZL[f.this.MC()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aZO, 200L);
            }
        };
        this.aZK = (ImageView) this.attachedView.findViewById(e.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aZK.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aZK.setLayoutParams(marginLayoutParams);
            }
        }
        this.aQZ = (TextView) this.attachedView.findViewById(e.g.loading_anim_ellipsis);
        this.aZM = (TextView) this.attachedView.findViewById(e.g.loading_text);
        this.aZL = context.getResources().getStringArray(e.b.loading_anim_text_array);
        this.aZN = this.aZL.length;
    }

    private void MD() {
        if (this.aZK != null && (this.aZK.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aZK.getBackground()).start();
        }
    }

    private void ME() {
        if (this.aZK != null && (this.aZK.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aZK.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewAttached() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        al.d(this.aZK, e.f.loading_animation, this.mSkinType);
        MD();
        al.b(this.aQZ, e.d.cp_cont_c, 1, this.mSkinType);
        al.b(this.aZM, e.d.cp_cont_c, 1, this.mSkinType);
        al.e(this.attachedView, e.d.cp_bg_line_d, this.mSkinType);
        this.aQZ.setText(this.aZL[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aZO);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aZO, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        ME();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aZO);
        this.aZK.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            al.d(this.aZK, e.f.loading_animation, this.mSkinType);
            MD();
            al.b(this.aQZ, e.d.cp_cont_c, 1, this.mSkinType);
            al.b(this.aZM, e.d.cp_cont_c, 1, this.mSkinType);
            al.e(this.attachedView, e.d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View MF() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.k.a
    public void dettachView(View view) {
        if (this.aZK != null && this.aZK.getAnimation() != null) {
            this.aZK.getAnimation().cancel();
            this.aZK.clearAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aZO);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.aZK != null) {
            ViewGroup.LayoutParams layoutParams = this.aZK.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aZK.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

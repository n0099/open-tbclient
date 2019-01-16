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
    private TextView ajh;
    private ImageView bdV;
    private String[] bdW;
    private TextView bdX;
    private final int bdY;
    private Runnable bdZ;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int NY() {
        this.currentIndex++;
        if (this.currentIndex >= this.bdY) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(e.C0210e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(e.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.bdZ = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.bdZ);
                    return;
                }
                f.this.ajh.setText(f.this.bdW[f.this.NY()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.bdZ, 200L);
            }
        };
        this.bdV = (ImageView) this.attachedView.findViewById(e.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bdV.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bdV.setLayoutParams(marginLayoutParams);
            }
        }
        this.ajh = (TextView) this.attachedView.findViewById(e.g.loading_anim_ellipsis);
        this.bdX = (TextView) this.attachedView.findViewById(e.g.loading_text);
        this.bdW = context.getResources().getStringArray(e.b.loading_anim_text_array);
        this.bdY = this.bdW.length;
    }

    private void NZ() {
        if (this.bdV != null && (this.bdV.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bdV.getBackground()).start();
        }
    }

    private void Oa() {
        if (this.bdV != null && (this.bdV.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bdV.getBackground()).stop();
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
        al.d(this.bdV, e.f.loading_animation, this.mSkinType);
        NZ();
        al.b(this.ajh, e.d.cp_cont_c, 1, this.mSkinType);
        al.b(this.bdX, e.d.cp_cont_c, 1, this.mSkinType);
        al.e(this.attachedView, e.d.cp_bg_line_d, this.mSkinType);
        this.ajh.setText(this.bdW[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bdZ);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bdZ, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        Oa();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bdZ);
        this.bdV.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            al.d(this.bdV, e.f.loading_animation, this.mSkinType);
            NZ();
            al.b(this.ajh, e.d.cp_cont_c, 1, this.mSkinType);
            al.b(this.bdX, e.d.cp_cont_c, 1, this.mSkinType);
            al.e(this.attachedView, e.d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Ob() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.k.a
    public void dettachView(View view) {
        if (this.bdV != null && this.bdV.getAnimation() != null) {
            this.bdV.getAnimation().cancel();
            this.bdV.clearAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bdZ);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.bdV != null) {
            ViewGroup.LayoutParams layoutParams = this.bdV.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bdV.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

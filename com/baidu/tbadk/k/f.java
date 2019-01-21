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
    private ImageView bdW;
    private String[] bdX;
    private TextView bdY;
    private final int bdZ;
    private Runnable bea;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int NY() {
        this.currentIndex++;
        if (this.currentIndex >= this.bdZ) {
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
        this.bea = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.bea);
                    return;
                }
                f.this.ajh.setText(f.this.bdX[f.this.NY()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.bea, 200L);
            }
        };
        this.bdW = (ImageView) this.attachedView.findViewById(e.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bdW.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bdW.setLayoutParams(marginLayoutParams);
            }
        }
        this.ajh = (TextView) this.attachedView.findViewById(e.g.loading_anim_ellipsis);
        this.bdY = (TextView) this.attachedView.findViewById(e.g.loading_text);
        this.bdX = context.getResources().getStringArray(e.b.loading_anim_text_array);
        this.bdZ = this.bdX.length;
    }

    private void NZ() {
        if (this.bdW != null && (this.bdW.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bdW.getBackground()).start();
        }
    }

    private void Oa() {
        if (this.bdW != null && (this.bdW.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bdW.getBackground()).stop();
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
        al.d(this.bdW, e.f.loading_animation, this.mSkinType);
        NZ();
        al.b(this.ajh, e.d.cp_cont_c, 1, this.mSkinType);
        al.b(this.bdY, e.d.cp_cont_c, 1, this.mSkinType);
        al.e(this.attachedView, e.d.cp_bg_line_d, this.mSkinType);
        this.ajh.setText(this.bdX[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bea);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bea, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        Oa();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bea);
        this.bdW.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            al.d(this.bdW, e.f.loading_animation, this.mSkinType);
            NZ();
            al.b(this.ajh, e.d.cp_cont_c, 1, this.mSkinType);
            al.b(this.bdY, e.d.cp_cont_c, 1, this.mSkinType);
            al.e(this.attachedView, e.d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Ob() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.k.a
    public void dettachView(View view) {
        if (this.bdW != null && this.bdW.getAnimation() != null) {
            this.bdW.getAnimation().cancel();
            this.bdW.clearAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bea);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.bdW != null) {
            ViewGroup.LayoutParams layoutParams = this.bdW.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bdW.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

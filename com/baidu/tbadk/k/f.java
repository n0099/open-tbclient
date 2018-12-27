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
    private TextView aiY;
    private ImageView bdl;
    private String[] bdm;
    private TextView bdn;
    private final int bdo;
    private Runnable bdp;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int NH() {
        this.currentIndex++;
        if (this.currentIndex >= this.bdo) {
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
        this.bdp = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.bdp);
                    return;
                }
                f.this.aiY.setText(f.this.bdm[f.this.NH()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.bdp, 200L);
            }
        };
        this.bdl = (ImageView) this.attachedView.findViewById(e.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bdl.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bdl.setLayoutParams(marginLayoutParams);
            }
        }
        this.aiY = (TextView) this.attachedView.findViewById(e.g.loading_anim_ellipsis);
        this.bdn = (TextView) this.attachedView.findViewById(e.g.loading_text);
        this.bdm = context.getResources().getStringArray(e.b.loading_anim_text_array);
        this.bdo = this.bdm.length;
    }

    private void NI() {
        if (this.bdl != null && (this.bdl.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bdl.getBackground()).start();
        }
    }

    private void NJ() {
        if (this.bdl != null && (this.bdl.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bdl.getBackground()).stop();
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
        al.d(this.bdl, e.f.loading_animation, this.mSkinType);
        NI();
        al.b(this.aiY, e.d.cp_cont_c, 1, this.mSkinType);
        al.b(this.bdn, e.d.cp_cont_c, 1, this.mSkinType);
        al.e(this.attachedView, e.d.cp_bg_line_d, this.mSkinType);
        this.aiY.setText(this.bdm[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bdp);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bdp, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        NJ();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bdp);
        this.bdl.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            al.d(this.bdl, e.f.loading_animation, this.mSkinType);
            NI();
            al.b(this.aiY, e.d.cp_cont_c, 1, this.mSkinType);
            al.b(this.bdn, e.d.cp_cont_c, 1, this.mSkinType);
            al.e(this.attachedView, e.d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View NK() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.k.a
    public void dettachView(View view) {
        if (this.bdl != null && this.bdl.getAnimation() != null) {
            this.bdl.getAnimation().cancel();
            this.bdl.clearAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bdp);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.bdl != null) {
            ViewGroup.LayoutParams layoutParams = this.bdl.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bdl.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

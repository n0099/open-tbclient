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
    private ImageView bdi;
    private String[] bdj;
    private TextView bdk;
    private final int bdl;
    private Runnable bdm;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int NG() {
        this.currentIndex++;
        if (this.currentIndex >= this.bdl) {
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
        this.bdm = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.bdm);
                    return;
                }
                f.this.aiY.setText(f.this.bdj[f.this.NG()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.bdm, 200L);
            }
        };
        this.bdi = (ImageView) this.attachedView.findViewById(e.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bdi.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bdi.setLayoutParams(marginLayoutParams);
            }
        }
        this.aiY = (TextView) this.attachedView.findViewById(e.g.loading_anim_ellipsis);
        this.bdk = (TextView) this.attachedView.findViewById(e.g.loading_text);
        this.bdj = context.getResources().getStringArray(e.b.loading_anim_text_array);
        this.bdl = this.bdj.length;
    }

    private void NH() {
        if (this.bdi != null && (this.bdi.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bdi.getBackground()).start();
        }
    }

    private void NI() {
        if (this.bdi != null && (this.bdi.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bdi.getBackground()).stop();
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
        al.d(this.bdi, e.f.loading_animation, this.mSkinType);
        NH();
        al.b(this.aiY, e.d.cp_cont_c, 1, this.mSkinType);
        al.b(this.bdk, e.d.cp_cont_c, 1, this.mSkinType);
        al.e(this.attachedView, e.d.cp_bg_line_d, this.mSkinType);
        this.aiY.setText(this.bdj[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bdm);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bdm, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        NI();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bdm);
        this.bdi.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            al.d(this.bdi, e.f.loading_animation, this.mSkinType);
            NH();
            al.b(this.aiY, e.d.cp_cont_c, 1, this.mSkinType);
            al.b(this.bdk, e.d.cp_cont_c, 1, this.mSkinType);
            al.e(this.attachedView, e.d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View NJ() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.k.a
    public void dettachView(View view) {
        if (this.bdi != null && this.bdi.getAnimation() != null) {
            this.bdi.getAnimation().cancel();
            this.bdi.clearAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bdm);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.bdi != null) {
            ViewGroup.LayoutParams layoutParams = this.bdi.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bdi.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

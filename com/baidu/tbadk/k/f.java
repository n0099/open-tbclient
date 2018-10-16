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
    private TextView aQj;
    private ImageView aYX;
    private String[] aYY;
    private TextView aYZ;
    private final int aZa;
    private Runnable aZb;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Mt() {
        this.currentIndex++;
        if (this.currentIndex >= this.aZa) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(e.C0175e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(e.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.aZb = new Runnable() { // from class: com.baidu.tbadk.k.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.Mq()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.aZb);
                    return;
                }
                f.this.aQj.setText(f.this.aYY[f.this.Mt()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aZb, 200L);
            }
        };
        this.aYX = (ImageView) this.aYV.findViewById(e.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aYX.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aYX.setLayoutParams(marginLayoutParams);
            }
        }
        this.aQj = (TextView) this.aYV.findViewById(e.g.loading_anim_ellipsis);
        this.aYZ = (TextView) this.aYV.findViewById(e.g.loading_text);
        this.aYY = context.getResources().getStringArray(e.b.loading_anim_text_array);
        this.aZa = this.aYY.length;
    }

    private void Mu() {
        if (this.aYX != null && (this.aYX.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aYX.getBackground()).start();
        }
    }

    private void Mv() {
        if (this.aYX != null && (this.aYX.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aYX.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Mr() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        al.d(this.aYX, e.f.loading_animation, this.mSkinType);
        Mu();
        al.b(this.aQj, e.d.cp_cont_c, 1, this.mSkinType);
        al.b(this.aYZ, e.d.cp_cont_c, 1, this.mSkinType);
        al.e(this.aYV, e.d.cp_bg_line_d, this.mSkinType);
        this.aQj.setText(this.aYY[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aZb);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aZb, 200L);
        this.aYV.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Ms() {
        release();
    }

    public void release() {
        Mv();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aZb);
        this.aYX.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Mq()) {
            al.d(this.aYX, e.f.loading_animation, this.mSkinType);
            Mu();
            al.b(this.aQj, e.d.cp_cont_c, 1, this.mSkinType);
            al.b(this.aYZ, e.d.cp_cont_c, 1, this.mSkinType);
            al.e(this.aYV, e.d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Mw() {
        return this.aYV;
    }

    @Override // com.baidu.tbadk.k.a
    public void ad(View view) {
        if (this.aYX != null && this.aYX.getAnimation() != null) {
            this.aYX.getAnimation().cancel();
            this.aYX.clearAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aZb);
        super.ad(view);
    }

    public void setTopMargin(int i) {
        if (this.aYX != null) {
            ViewGroup.LayoutParams layoutParams = this.aYX.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aYX.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

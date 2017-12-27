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
    private TextView bmg;
    private ImageView bva;
    private String[] bvb;
    private TextView bvc;
    private final int bvd;
    private Runnable bve;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int Mq() {
        this.currentIndex++;
        if (this.currentIndex >= this.bvd) {
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
        this.bve = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.Mn()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.bve);
                    return;
                }
                f.this.bmg.setText(f.this.bvb[f.this.Mq()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.bve, 200L);
            }
        };
        this.bva = (ImageView) this.buY.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.bva.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bva.setLayoutParams(marginLayoutParams);
            }
        }
        this.bmg = (TextView) this.buY.findViewById(d.g.loading_anim_ellipsis);
        this.bvc = (TextView) this.buY.findViewById(d.g.loading_text);
        this.bvb = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.bvd = this.bvb.length;
    }

    private void Mr() {
        if (this.bva != null && (this.bva.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bva.getBackground()).start();
        }
    }

    private void Ms() {
        if (this.bva != null && (this.bva.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.bva.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mo() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        aj.f(this.bva, d.f.loading_animation, this.mSkinType);
        Mr();
        aj.b(this.bmg, d.C0108d.cp_cont_c, 1, this.mSkinType);
        aj.b(this.bvc, d.C0108d.cp_cont_c, 1, this.mSkinType);
        aj.g(this.buY, d.C0108d.cp_bg_line_d, this.mSkinType);
        this.bmg.setText(this.bvb[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bve);
        TbadkCoreApplication.getInst().handler.postDelayed(this.bve, 200L);
        this.buY.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mp() {
        release();
    }

    public void release() {
        Ms();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.bve);
        this.bva.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (Mn()) {
            aj.f(this.bva, d.f.loading_animation, this.mSkinType);
            Mr();
            aj.b(this.bmg, d.C0108d.cp_cont_c, 1, this.mSkinType);
            aj.b(this.bvc, d.C0108d.cp_cont_c, 1, this.mSkinType);
            aj.g(this.buY, d.C0108d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View Mt() {
        return this.buY;
    }

    @Override // com.baidu.tbadk.j.a
    public void bi(View view) {
        if (this.bva != null && this.bva.getAnimation() != null) {
            this.bva.getAnimation().cancel();
            this.bva.clearAnimation();
        }
        super.bi(view);
    }

    public void setTopMargin(int i) {
        if (this.bva != null) {
            ViewGroup.LayoutParams layoutParams = this.bva.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.bva.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

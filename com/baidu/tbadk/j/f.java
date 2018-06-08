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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends a {
    private TextView aHw;
    private ImageView aQn;
    private String[] aQo;
    private TextView aQp;
    private final int aQq;
    private Runnable aQr;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int IS() {
        this.currentIndex++;
        if (this.currentIndex >= this.aQq) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(d.e.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(d.i.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.aQr = new Runnable() { // from class: com.baidu.tbadk.j.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (!f.this.IP()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(f.this.aQr);
                    return;
                }
                f.this.aHw.setText(f.this.aQo[f.this.IS()]);
                TbadkCoreApplication.getInst().handler.postDelayed(f.this.aQr, 200L);
            }
        };
        this.aQn = (ImageView) this.aQl.findViewById(d.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.aQn.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aQn.setLayoutParams(marginLayoutParams);
            }
        }
        this.aHw = (TextView) this.aQl.findViewById(d.g.loading_anim_ellipsis);
        this.aQp = (TextView) this.aQl.findViewById(d.g.loading_text);
        this.aQo = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.aQq = this.aQo.length;
    }

    private void IT() {
        if (this.aQn != null && (this.aQn.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aQn.getBackground()).start();
        }
    }

    private void IU() {
        if (this.aQn != null && (this.aQn.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.aQn.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void IQ() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        al.d(this.aQn, d.f.loading_animation, this.mSkinType);
        IT();
        al.b(this.aHw, d.C0141d.cp_cont_c, 1, this.mSkinType);
        al.b(this.aQp, d.C0141d.cp_cont_c, 1, this.mSkinType);
        al.e(this.aQl, d.C0141d.cp_bg_line_d, this.mSkinType);
        this.aHw.setText(this.aQo[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aQr);
        TbadkCoreApplication.getInst().handler.postDelayed(this.aQr, 200L);
        this.aQl.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void IR() {
        release();
    }

    public void release() {
        IU();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.aQr);
        this.aQn.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (IP()) {
            al.d(this.aQn, d.f.loading_animation, this.mSkinType);
            IT();
            al.b(this.aHw, d.C0141d.cp_cont_c, 1, this.mSkinType);
            al.b(this.aQp, d.C0141d.cp_cont_c, 1, this.mSkinType);
            al.e(this.aQl, d.C0141d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View IV() {
        return this.aQl;
    }

    @Override // com.baidu.tbadk.j.a
    public void P(View view) {
        if (this.aQn != null && this.aQn.getAnimation() != null) {
            this.aQn.getAnimation().cancel();
            this.aQn.clearAnimation();
        }
        super.P(view);
    }

    public void setTopMargin(int i) {
        if (this.aQn != null) {
            ViewGroup.LayoutParams layoutParams = this.aQn.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.aQn.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

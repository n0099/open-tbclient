package com.baidu.tbadk.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends a {
    private TextView ahI;
    private ContinuousAnimationView cnE;
    private String[] cnF;
    private TextView cnG;
    private final int cnH;
    private Runnable cnI;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int anD() {
        this.currentIndex++;
        if (this.currentIndex >= this.cnH) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public g(Context context) {
        this(context, context.getResources().getDimensionPixelSize(d.e.ds484));
    }

    public g(Context context, int i) {
        super(LayoutInflater.from(context).inflate(d.h.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.cnI = new Runnable() { // from class: com.baidu.tbadk.m.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (!g.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.cnI);
                    return;
                }
                g.this.ahI.setText(g.this.cnF[g.this.anD()]);
                TbadkCoreApplication.getInst().handler.postDelayed(g.this.cnI, 200L);
            }
        };
        this.cnE = (ContinuousAnimationView) this.attachedView.findViewById(d.g.common_loading_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.cnE.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cnE.setLayoutParams(marginLayoutParams);
            }
        }
        this.ahI = (TextView) this.attachedView.findViewById(d.g.loading_anim_ellipsis);
        this.cnG = (TextView) this.attachedView.findViewById(d.g.loading_text);
        this.cnF = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.cnH = this.cnF.length;
    }

    private void anE() {
        if (this.cnE != null) {
            this.cnE.cu();
        }
    }

    private void anF() {
        if (this.cnE != null) {
            this.cnE.cw();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewAttached() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        anE();
        al.c(this.ahI, d.C0277d.cp_cont_c, 1, this.mSkinType);
        al.c(this.cnG, d.C0277d.cp_cont_c, 1, this.mSkinType);
        al.f(this.attachedView, d.C0277d.cp_bg_line_d, this.mSkinType);
        this.ahI.setText(this.cnF[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cnI);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cnI, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        anF();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cnI);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            anE();
            al.c(this.ahI, d.C0277d.cp_cont_c, 1, this.mSkinType);
            al.c(this.cnG, d.C0277d.cp_cont_c, 1, this.mSkinType);
            al.f(this.attachedView, d.C0277d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View anC() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.m.a
    public void dettachView(View view) {
        if (this.cnE != null) {
            this.cnE.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cnI);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.cnE != null) {
            ViewGroup.LayoutParams layoutParams = this.cnE.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cnE.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

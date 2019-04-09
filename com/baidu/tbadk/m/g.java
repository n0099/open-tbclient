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
    private TextView ahO;
    private ContinuousAnimationView cnH;
    private String[] cnI;
    private TextView cnJ;
    private final int cnK;
    private Runnable cnL;
    private int currentIndex;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int anA() {
        this.currentIndex++;
        if (this.currentIndex >= this.cnK) {
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
        this.cnL = new Runnable() { // from class: com.baidu.tbadk.m.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (!g.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.cnL);
                    return;
                }
                g.this.ahO.setText(g.this.cnI[g.this.anA()]);
                TbadkCoreApplication.getInst().handler.postDelayed(g.this.cnL, 200L);
            }
        };
        this.cnH = (ContinuousAnimationView) this.attachedView.findViewById(d.g.common_loading_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.cnH.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cnH.setLayoutParams(marginLayoutParams);
            }
        }
        this.ahO = (TextView) this.attachedView.findViewById(d.g.loading_anim_ellipsis);
        this.cnJ = (TextView) this.attachedView.findViewById(d.g.loading_text);
        this.cnI = context.getResources().getStringArray(d.b.loading_anim_text_array);
        this.cnK = this.cnI.length;
    }

    private void anB() {
        if (this.cnH != null) {
            this.cnH.cu();
        }
    }

    private void anC() {
        if (this.cnH != null) {
            this.cnH.cw();
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
        anB();
        al.c(this.ahO, d.C0277d.cp_cont_c, 1, this.mSkinType);
        al.c(this.cnJ, d.C0277d.cp_cont_c, 1, this.mSkinType);
        al.f(this.attachedView, d.C0277d.cp_bg_line_d, this.mSkinType);
        this.ahO.setText(this.cnI[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cnL);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cnL, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        anC();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cnL);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            anB();
            al.c(this.ahO, d.C0277d.cp_cont_c, 1, this.mSkinType);
            al.c(this.cnJ, d.C0277d.cp_cont_c, 1, this.mSkinType);
            al.f(this.attachedView, d.C0277d.cp_bg_line_d, this.mSkinType);
        }
    }

    public View anz() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.m.a
    public void dettachView(View view) {
        if (this.cnH != null) {
            this.cnH.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cnL);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.cnH != null) {
            ViewGroup.LayoutParams layoutParams = this.cnH.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cnH.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

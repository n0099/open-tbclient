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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g extends a {
    private TextView aif;
    private int currentIndex;
    private ContinuousAnimationView cvO;
    private String[] cvP;
    private TextView cvQ;
    private final int cvR;
    private Runnable cvS;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public int asD() {
        this.currentIndex++;
        if (this.currentIndex >= this.cvR) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public g(Context context) {
        this(context, context.getResources().getDimensionPixelSize(R.dimen.ds484));
    }

    public g(Context context, int i) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.cvS = new Runnable() { // from class: com.baidu.tbadk.m.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (!g.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.cvS);
                    return;
                }
                g.this.aif.setText(g.this.cvP[g.this.asD()]);
                TbadkCoreApplication.getInst().handler.postDelayed(g.this.cvS, 200L);
            }
        };
        this.cvO = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.cvO.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cvO.setLayoutParams(marginLayoutParams);
            }
        }
        this.aif = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.cvQ = (TextView) this.attachedView.findViewById(R.id.loading_text);
        this.cvP = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.cvR = this.cvP.length;
    }

    private void asE() {
        if (this.cvO != null) {
            this.cvO.bo();
        }
    }

    private void asF() {
        if (this.cvO != null) {
            this.cvO.bq();
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
        asE();
        al.c(this.aif, R.color.cp_cont_c, 1, this.mSkinType);
        al.c(this.cvQ, R.color.cp_cont_c, 1, this.mSkinType);
        al.h(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
        this.aif.setText(this.cvP[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cvS);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cvS, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        asF();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cvS);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            asE();
            al.c(this.aif, R.color.cp_cont_c, 1, this.mSkinType);
            al.c(this.cvQ, R.color.cp_cont_c, 1, this.mSkinType);
            al.h(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
        }
    }

    public View asC() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.m.a
    public void dettachView(View view) {
        if (this.cvO != null) {
            this.cvO.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cvS);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.cvO != null) {
            ViewGroup.LayoutParams layoutParams = this.cvO.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cvO.setLayoutParams(marginLayoutParams);
            }
        }
    }
}

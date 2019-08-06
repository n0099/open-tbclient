package com.baidu.tbadk.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g extends a {
    private int currentIndex;
    private ContinuousAnimationView cxl;
    private String[] cxm;
    private TextView cxn;
    private final int cxo;
    private Runnable cxp;
    private int mSkinType;
    private TextView textView;

    /* JADX INFO: Access modifiers changed from: private */
    public int atM() {
        this.currentIndex++;
        if (this.currentIndex >= this.cxo) {
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
        this.cxp = new Runnable() { // from class: com.baidu.tbadk.m.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (!g.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.cxp);
                    return;
                }
                g.this.textView.setText(g.this.cxm[g.this.atM()]);
                TbadkCoreApplication.getInst().handler.postDelayed(g.this.cxp, 200L);
            }
        };
        this.cxl = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.cxl.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cxl.setLayoutParams(marginLayoutParams);
            }
        }
        this.textView = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.cxn = (TextView) this.attachedView.findViewById(R.id.loading_text);
        this.cxm = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.cxo = this.cxm.length;
    }

    private void atN() {
        if (this.cxl != null) {
            this.cxl.br();
        }
    }

    private void atO() {
        if (this.cxl != null) {
            this.cxl.bt();
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
        atN();
        am.d(this.textView, R.color.cp_cont_c, 1, this.mSkinType);
        am.d(this.cxn, R.color.cp_cont_c, 1, this.mSkinType);
        am.h(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
        this.textView.setText(this.cxm[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cxp);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cxp, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        atO();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cxp);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            atN();
            am.d(this.textView, R.color.cp_cont_c, 1, this.mSkinType);
            am.d(this.cxn, R.color.cp_cont_c, 1, this.mSkinType);
            am.h(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
        }
    }

    public View atL() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.m.a
    public void dettachView(View view) {
        if (this.cxl != null) {
            this.cxl.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cxp);
        super.dettachView(view);
    }

    public void iS(int i) {
        if (this.attachedView != null) {
            this.attachedView.setBackgroundColor(i);
        }
    }

    public void setTopMargin(int i) {
        if (this.cxl != null) {
            ViewGroup.LayoutParams layoutParams = this.cxl.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cxl.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public TextView atP() {
        return this.cxn;
    }
}

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
    private ContinuousAnimationView cxe;
    private String[] cxf;
    private TextView cxg;
    private final int cxh;
    private Runnable cxi;
    private int mSkinType;
    private TextView textView;

    /* JADX INFO: Access modifiers changed from: private */
    public int atK() {
        this.currentIndex++;
        if (this.currentIndex >= this.cxh) {
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
        this.cxi = new Runnable() { // from class: com.baidu.tbadk.m.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (!g.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.cxi);
                    return;
                }
                g.this.textView.setText(g.this.cxf[g.this.atK()]);
                TbadkCoreApplication.getInst().handler.postDelayed(g.this.cxi, 200L);
            }
        };
        this.cxe = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.cxe.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cxe.setLayoutParams(marginLayoutParams);
            }
        }
        this.textView = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.cxg = (TextView) this.attachedView.findViewById(R.id.loading_text);
        this.cxf = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.cxh = this.cxf.length;
    }

    private void atL() {
        if (this.cxe != null) {
            this.cxe.br();
        }
    }

    private void atM() {
        if (this.cxe != null) {
            this.cxe.bt();
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
        atL();
        am.d(this.textView, R.color.cp_cont_c, 1, this.mSkinType);
        am.d(this.cxg, R.color.cp_cont_c, 1, this.mSkinType);
        am.h(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
        this.textView.setText(this.cxf[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cxi);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cxi, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        atM();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cxi);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            atL();
            am.d(this.textView, R.color.cp_cont_c, 1, this.mSkinType);
            am.d(this.cxg, R.color.cp_cont_c, 1, this.mSkinType);
            am.h(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
        }
    }

    public View atJ() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.m.a
    public void dettachView(View view) {
        if (this.cxe != null) {
            this.cxe.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cxi);
        super.dettachView(view);
    }

    public void iS(int i) {
        if (this.attachedView != null) {
            this.attachedView.setBackgroundColor(i);
        }
    }

    public void setTopMargin(int i) {
        if (this.cxe != null) {
            ViewGroup.LayoutParams layoutParams = this.cxe.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cxe.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public TextView atN() {
        return this.cxg;
    }
}

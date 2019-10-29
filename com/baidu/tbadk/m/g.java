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
    private final int arrayLength;
    private ContinuousAnimationView cJU;
    private int currentIndex;
    private TextView loadingTextView;
    private int mSkinType;
    private Runnable runnable;
    private String[] textArray;
    private TextView textView;

    /* JADX INFO: Access modifiers changed from: private */
    public int getNextIndex() {
        this.currentIndex++;
        if (this.currentIndex >= this.arrayLength) {
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
        this.runnable = new Runnable() { // from class: com.baidu.tbadk.m.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (!g.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(g.this.runnable);
                    return;
                }
                g.this.textView.setText(g.this.textArray[g.this.getNextIndex()]);
                TbadkCoreApplication.getInst().handler.postDelayed(g.this.runnable, 200L);
            }
        };
        this.cJU = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.cJU.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cJU.setLayoutParams(marginLayoutParams);
            }
        }
        this.textView = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.loadingTextView = (TextView) this.attachedView.findViewById(R.id.loading_text);
        this.textArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.arrayLength = this.textArray.length;
    }

    private void startLoadingAnimation() {
        if (this.cJU != null) {
            this.cJU.playAnimation();
        }
    }

    private void stopLoadingAnimation() {
        if (this.cJU != null) {
            this.cJU.pauseAnimation();
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
        startLoadingAnimation();
        am.setViewTextColor(this.textView, R.color.cp_cont_c, 1, this.mSkinType);
        am.setViewTextColor(this.loadingTextView, R.color.cp_cont_c, 1, this.mSkinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
        this.textView.setText(this.textArray[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        TbadkCoreApplication.getInst().handler.postDelayed(this.runnable, 200L);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        release();
    }

    public void release() {
        stopLoadingAnimation();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            startLoadingAnimation();
            am.setViewTextColor(this.textView, R.color.cp_cont_c, 1, this.mSkinType);
            am.setViewTextColor(this.loadingTextView, R.color.cp_cont_c, 1, this.mSkinType);
            am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.m.a
    public void dettachView(View view) {
        if (this.cJU != null) {
            this.cJU.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.cJU != null) {
            ViewGroup.LayoutParams layoutParams = this.cJU.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.cJU.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public TextView getLoadingTextView() {
        return this.loadingTextView;
    }
}

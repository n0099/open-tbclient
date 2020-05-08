package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g extends a {
    private final int arrayLength;
    private int currentIndex;
    private ContinuousAnimationView ebt;
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
        this(context, 0);
    }

    public g(Context context, int i) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.runnable = new Runnable() { // from class: com.baidu.tbadk.k.g.1
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
        this.ebt = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.ebt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.ebt.setLayoutParams(marginLayoutParams);
            }
        }
        am.a(this.ebt, R.raw.lottie_full_screen_refresh);
        this.ebt.setSpeed(1.2f);
        this.textView = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.loadingTextView = (TextView) this.attachedView.findViewById(R.id.loading_text);
        this.textArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.arrayLength = this.textArray.length;
    }

    private void startLoadingAnimation() {
        if (this.ebt != null) {
            this.ebt.playAnimation();
        }
    }

    private void stopLoadingAnimation() {
        if (this.ebt != null) {
            this.ebt.pauseAnimation();
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
        am.a(this.ebt, R.raw.lottie_full_screen_refresh);
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
    @Override // com.baidu.tbadk.k.a
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

    @Override // com.baidu.tbadk.k.a
    public void dettachView(View view) {
        if (this.ebt != null) {
            this.ebt.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.ebt != null) {
            ViewGroup.LayoutParams layoutParams = this.ebt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.ebt.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void aZ(int i) {
        if (this.ebt != null) {
            ViewGroup.LayoutParams layoutParams = this.ebt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i;
                this.ebt.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void aYn() {
        if (this.ebt != null) {
            ((RelativeLayout.LayoutParams) this.ebt.getLayoutParams()).addRule(15, 0);
        }
    }

    public TextView getLoadingTextView() {
        return this.loadingTextView;
    }
}

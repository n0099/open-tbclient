package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g extends a {
    private final int arrayLength;
    private int currentIndex;
    private ContinuousAnimationView ePs;
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
        this.ePs = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.ePs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.ePs.setLayoutParams(marginLayoutParams);
            }
        }
        ap.a(this.ePs, R.raw.lottie_full_screen_refresh);
        this.ePs.setSpeed(1.2f);
        this.textView = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.loadingTextView = (TextView) this.attachedView.findViewById(R.id.loading_text);
        this.textArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.arrayLength = this.textArray.length;
    }

    private void startLoadingAnimation() {
        if (this.ePs != null) {
            this.ePs.playAnimation();
        }
    }

    private void stopLoadingAnimation() {
        if (this.ePs != null) {
            this.ePs.pauseAnimation();
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
        ap.a(this.ePs, R.raw.lottie_full_screen_refresh);
        startLoadingAnimation();
        ap.setViewTextColor(this.textView, R.color.cp_cont_c, 1, this.mSkinType);
        ap.setViewTextColor(this.loadingTextView, R.color.cp_cont_c, 1, this.mSkinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
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
            ap.setViewTextColor(this.textView, R.color.cp_cont_c, 1, this.mSkinType);
            ap.setViewTextColor(this.loadingTextView, R.color.cp_cont_c, 1, this.mSkinType);
            ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d, this.mSkinType);
            startLoadingAnimation();
        }
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.textView, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.loadingTextView, R.color.cp_cont_c, 1, i);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d, i);
        ap.a(this.ePs, R.raw.lottie_full_screen_refresh);
        if (isViewAttached()) {
            startLoadingAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        TbadkCoreApplication.getInst().handler.postDelayed(this.runnable, 200L);
        this.mSkinType = i;
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    @Override // com.baidu.tbadk.k.a
    public void dettachView(View view) {
        if (this.ePs != null) {
            this.ePs.cancelAnimation();
        }
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        super.dettachView(view);
    }

    public void setTopMargin(int i) {
        if (this.ePs != null) {
            ViewGroup.LayoutParams layoutParams = this.ePs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.ePs.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void bn(int i) {
        if (this.ePs != null) {
            ViewGroup.LayoutParams layoutParams = this.ePs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i;
                this.ePs.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void bta() {
        if (this.ePs != null) {
            ((RelativeLayout.LayoutParams) this.ePs.getLayoutParams()).addRule(15, 0);
        }
    }

    public TextView getLoadingTextView() {
        return this.loadingTextView;
    }
}

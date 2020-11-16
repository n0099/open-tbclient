package com.baidu.tieba.homepage.gamevideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class GameVideoGridView extends BdGridView {
    private Animation jBM;
    private GridLayoutAnimationController jBN;
    private int mMaxHeight;

    public GameVideoGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxHeight = -1;
        init();
    }

    public GameVideoGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxHeight = -1;
        init();
    }

    public GameVideoGridView(Context context) {
        super(context);
        this.mMaxHeight = -1;
        init();
    }

    private void init() {
        if (this.jBM == null) {
            this.jBM = AnimationUtils.loadAnimation(getContext(), R.anim.game_choose_slide_in_top);
        }
        if (this.jBN == null) {
            this.jBN = new GridLayoutAnimationController(this.jBM);
            this.jBN.setColumnDelay(0.4f);
            this.jBN.setRowDelay(0.2f);
            this.jBN.setDirection(0);
            this.jBN.setDirectionPriority(0);
        }
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mMaxHeight <= View.MeasureSpec.getSize(i2) && this.mMaxHeight > -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void cJP() {
        if (this.jBN != null) {
            setLayoutAnimation(this.jBN);
            this.jBN.start();
            startLayoutAnimation();
        }
    }

    public void onDestroy() {
        if (this.jBM != null) {
            this.jBM.cancel();
        }
    }
}

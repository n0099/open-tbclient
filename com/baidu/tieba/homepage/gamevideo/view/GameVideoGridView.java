package com.baidu.tieba.homepage.gamevideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class GameVideoGridView extends BdGridView {
    private Animation hbo;
    private GridLayoutAnimationController hbp;
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
        if (this.hbo == null) {
            this.hbo = AnimationUtils.loadAnimation(getContext(), R.anim.game_choose_slide_in_top);
        }
        if (this.hbp == null) {
            this.hbp = new GridLayoutAnimationController(this.hbo);
            this.hbp.setColumnDelay(0.4f);
            this.hbp.setRowDelay(0.2f);
            this.hbp.setDirection(0);
            this.hbp.setDirectionPriority(0);
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

    public void bOk() {
        if (this.hbp != null) {
            setLayoutAnimation(this.hbp);
            this.hbp.start();
            startLayoutAnimation();
        }
    }

    public void onDestroy() {
        if (this.hbo != null) {
            this.hbo.cancel();
        }
    }
}

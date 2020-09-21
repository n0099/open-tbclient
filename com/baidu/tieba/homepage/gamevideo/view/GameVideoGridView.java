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
    private Animation iTy;
    private GridLayoutAnimationController iTz;
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
        if (this.iTy == null) {
            this.iTy = AnimationUtils.loadAnimation(getContext(), R.anim.game_choose_slide_in_top);
        }
        if (this.iTz == null) {
            this.iTz = new GridLayoutAnimationController(this.iTy);
            this.iTz.setColumnDelay(0.4f);
            this.iTz.setRowDelay(0.2f);
            this.iTz.setDirection(0);
            this.iTz.setDirectionPriority(0);
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

    public void cAV() {
        if (this.iTz != null) {
            setLayoutAnimation(this.iTz);
            this.iTz.start();
            startLayoutAnimation();
        }
    }

    public void onDestroy() {
        if (this.iTy != null) {
            this.iTy.cancel();
        }
    }
}

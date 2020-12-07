package com.baidu.tieba.homepage.gamevideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class GameVideoGridView extends BdGridView {
    private Animation jPo;
    private GridLayoutAnimationController jPp;
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
        if (this.jPo == null) {
            this.jPo = AnimationUtils.loadAnimation(getContext(), R.anim.game_choose_slide_in_top);
        }
        if (this.jPp == null) {
            this.jPp = new GridLayoutAnimationController(this.jPo);
            this.jPp.setColumnDelay(0.4f);
            this.jPp.setRowDelay(0.2f);
            this.jPp.setDirection(0);
            this.jPp.setDirectionPriority(0);
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

    public void cPe() {
        if (this.jPp != null) {
            setLayoutAnimation(this.jPp);
            this.jPp.start();
            startLayoutAnimation();
        }
    }

    public void onDestroy() {
        if (this.jPo != null) {
            this.jPo.cancel();
        }
    }
}

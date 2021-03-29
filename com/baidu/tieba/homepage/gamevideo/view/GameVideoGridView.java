package com.baidu.tieba.homepage.gamevideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class GameVideoGridView extends BdGridView {

    /* renamed from: e  reason: collision with root package name */
    public int f17153e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f17154f;

    /* renamed from: g  reason: collision with root package name */
    public GridLayoutAnimationController f17155g;

    public GameVideoGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17153e = -1;
        c();
    }

    public final void c() {
        if (this.f17154f == null) {
            this.f17154f = AnimationUtils.loadAnimation(getContext(), R.anim.game_choose_slide_in_top);
        }
        if (this.f17155g == null) {
            GridLayoutAnimationController gridLayoutAnimationController = new GridLayoutAnimationController(this.f17154f);
            this.f17155g = gridLayoutAnimationController;
            gridLayoutAnimationController.setColumnDelay(0.4f);
            this.f17155g.setRowDelay(0.2f);
            this.f17155g.setDirection(0);
            this.f17155g.setDirectionPriority(0);
        }
    }

    public void d() {
        Animation animation = this.f17154f;
        if (animation != null) {
            animation.cancel();
        }
    }

    public void e() {
        GridLayoutAnimationController gridLayoutAnimationController = this.f17155g;
        if (gridLayoutAnimationController != null) {
            setLayoutAnimation(gridLayoutAnimationController);
            this.f17155g.start();
            startLayoutAnimation();
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f17153e;
        if (i3 <= size && i3 > -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setMaxHeight(int i) {
        this.f17153e = i;
    }

    public GameVideoGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17153e = -1;
        c();
    }

    public GameVideoGridView(Context context) {
        super(context);
        this.f17153e = -1;
        c();
    }
}

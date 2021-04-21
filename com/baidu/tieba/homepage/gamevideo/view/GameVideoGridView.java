package com.baidu.tieba.homepage.gamevideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class GameVideoGridView extends BdGridView {

    /* renamed from: e  reason: collision with root package name */
    public int f16834e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f16835f;

    /* renamed from: g  reason: collision with root package name */
    public GridLayoutAnimationController f16836g;

    public GameVideoGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16834e = -1;
        c();
    }

    public final void c() {
        if (this.f16835f == null) {
            this.f16835f = AnimationUtils.loadAnimation(getContext(), R.anim.game_choose_slide_in_top);
        }
        if (this.f16836g == null) {
            GridLayoutAnimationController gridLayoutAnimationController = new GridLayoutAnimationController(this.f16835f);
            this.f16836g = gridLayoutAnimationController;
            gridLayoutAnimationController.setColumnDelay(0.4f);
            this.f16836g.setRowDelay(0.2f);
            this.f16836g.setDirection(0);
            this.f16836g.setDirectionPriority(0);
        }
    }

    public void d() {
        Animation animation = this.f16835f;
        if (animation != null) {
            animation.cancel();
        }
    }

    public void e() {
        GridLayoutAnimationController gridLayoutAnimationController = this.f16836g;
        if (gridLayoutAnimationController != null) {
            setLayoutAnimation(gridLayoutAnimationController);
            this.f16836g.start();
            startLayoutAnimation();
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f16834e;
        if (i3 <= size && i3 > -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setMaxHeight(int i) {
        this.f16834e = i;
    }

    public GameVideoGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16834e = -1;
        c();
    }

    public GameVideoGridView(Context context) {
        super(context);
        this.f16834e = -1;
        c();
    }
}

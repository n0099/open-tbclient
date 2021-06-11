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
    public int f16384e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f16385f;

    /* renamed from: g  reason: collision with root package name */
    public GridLayoutAnimationController f16386g;

    public GameVideoGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16384e = -1;
        c();
    }

    public final void c() {
        if (this.f16385f == null) {
            this.f16385f = AnimationUtils.loadAnimation(getContext(), R.anim.game_choose_slide_in_top);
        }
        if (this.f16386g == null) {
            GridLayoutAnimationController gridLayoutAnimationController = new GridLayoutAnimationController(this.f16385f);
            this.f16386g = gridLayoutAnimationController;
            gridLayoutAnimationController.setColumnDelay(0.4f);
            this.f16386g.setRowDelay(0.2f);
            this.f16386g.setDirection(0);
            this.f16386g.setDirectionPriority(0);
        }
    }

    public void d() {
        Animation animation = this.f16385f;
        if (animation != null) {
            animation.cancel();
        }
    }

    public void e() {
        GridLayoutAnimationController gridLayoutAnimationController = this.f16386g;
        if (gridLayoutAnimationController != null) {
            setLayoutAnimation(gridLayoutAnimationController);
            this.f16386g.start();
            startLayoutAnimation();
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        int i4 = this.f16384e;
        if (i4 <= size && i4 > -1) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    public void setMaxHeight(int i2) {
        this.f16384e = i2;
    }

    public GameVideoGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16384e = -1;
        c();
    }

    public GameVideoGridView(Context context) {
        super(context);
        this.f16384e = -1;
        c();
    }
}

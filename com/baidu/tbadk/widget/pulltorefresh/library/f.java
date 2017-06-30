package com.baidu.tbadk.widget.pulltorefresh.library;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f extends PullToRefreshBase<HorizontalScrollView> {
    public f(Context context) {
        super(context);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public f(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public f(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.HORIZONTAL;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase
    /* renamed from: d */
    public HorizontalScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        HorizontalScrollView horizontalScrollView;
        if (Build.VERSION.SDK_INT >= 9) {
            horizontalScrollView = new a(context, attributeSet);
        } else {
            horizontalScrollView = new HorizontalScrollView(context, attributeSet);
        }
        horizontalScrollView.setId(w.h.scrollview);
        return horizontalScrollView;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullStart() {
        return ((HorizontalScrollView) this.aNg).getScrollX() == 0;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullEnd() {
        View childAt = ((HorizontalScrollView) this.aNg).getChildAt(0);
        return childAt != null && ((HorizontalScrollView) this.aNg).getScrollX() >= childAt.getWidth() - getWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a extends HorizontalScrollView {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            c.a(f.this, i, i3, i2, i4, HM(), z);
            return overScrollBy;
        }

        private int HM() {
            if (getChildCount() > 0) {
                return Math.max(0, getChildAt(0).getWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight()));
            }
            return 0;
        }
    }
}

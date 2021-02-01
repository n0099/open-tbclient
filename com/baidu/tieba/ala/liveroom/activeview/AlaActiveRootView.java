package com.baidu.tieba.ala.liveroom.activeview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public class AlaActiveRootView extends PendantChildView implements com.baidu.live.i.b {
    private final int pos;

    public AlaActiveRootView(int i, Context context) {
        super(context);
        this.pos = i;
        init();
    }

    public View getLastChild() {
        if (getChildCount() < 1) {
            return null;
        }
        return getChildAt(getChildCount() - 1);
    }

    public void onStart() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof e) {
                    ((e) childAt).onStart();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onStop() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof e) {
                    ((e) childAt).onStop();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void release() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof e) {
                    ((e) childAt).release();
                }
                i = i2 + 1;
            } else {
                removeAllViews();
                return;
            }
        }
    }

    private void init() {
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        setId(a.f.ala_liveroom_active_view);
        setMinimumWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds104));
    }

    @Override // com.baidu.live.i.b
    public void setViewTouchable(boolean z) {
    }

    @Override // com.baidu.live.i.b
    public View getOverlayView() {
        return this;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getVerticalPosition() {
        return this.pos == 1 ? PendantParentView.Position.LEFT : PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getVerticalPkPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getVerticalBBChattingPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getHorizontalPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getHorizontalFullPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public int getPriority() {
        if (this.pos == 1 || this.pos == 2) {
            View lastChild = getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                return 30;
            }
            if (lastChild instanceof ActiveWebBannerItemView) {
                return 25;
            }
        }
        return -1;
    }
}

package com.baidu.tieba.ala.live.pkpanel.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes4.dex */
public class AlaDragContainerView extends FrameLayout {
    private float bpE;
    private float bpF;
    private int dOW;
    private int hbg;
    private int hbh;
    private boolean hbi;
    private final int hbj;
    private int hbk;
    private int hbl;
    private int hbm;
    private int hbn;
    private int height;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hbi = false;
        this.mContext = context;
        this.hbj = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (O(motionEvent).booleanValue()) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        this.hbg = this.width / 2;
        this.hbh = this.height / 2;
        this.screenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.dOW = ScreenHelper.getScreenHeight(this.mContext);
    }

    @Nullable
    private Boolean O(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.hbi = false;
                    this.bpE = motionEvent.getX();
                    this.bpF = motionEvent.getY();
                    break;
                case 2:
                    float x = motionEvent.getX() - this.bpE;
                    float y = motionEvent.getY() - this.bpF;
                    if (Math.abs(x) > this.hbj || Math.abs(y) > this.hbj) {
                        this.hbi = true;
                        int left = (int) (x + getLeft());
                        int i = this.width + left;
                        int top = (int) (y + getTop());
                        int i2 = this.height + top;
                        if (left < (-this.hbg)) {
                            left = -this.hbg;
                            i = this.width + left;
                        } else if (i > this.screenWidth + this.hbg) {
                            i = this.screenWidth + this.hbg;
                            left = i - this.width;
                        }
                        if (top < (-this.hbh)) {
                            top = -this.hbh;
                            i2 = this.height + top;
                        } else if (i2 > this.dOW + this.hbh) {
                            i2 = this.dOW + this.hbh;
                            top = i2 - this.height;
                        }
                        this.hbk = left;
                        this.hbl = top;
                        this.hbm = i;
                        this.hbn = i2;
                        layout(left, top, i, i2);
                        break;
                    }
                    break;
            }
        }
        return Boolean.valueOf(this.hbi);
    }

    public void bYW() {
        layout(this.hbk, this.hbl, this.hbm, this.hbn);
    }
}

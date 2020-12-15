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
    private int hbi;
    private int hbj;
    private boolean hbk;
    private final int hbl;
    private int hbm;
    private int hbn;
    private int hbo;
    private int hbp;
    private int height;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hbk = false;
        this.mContext = context;
        this.hbl = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
        this.hbi = this.width / 2;
        this.hbj = this.height / 2;
        this.screenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.dOW = ScreenHelper.getScreenHeight(this.mContext);
    }

    @Nullable
    private Boolean O(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.hbk = false;
                    this.bpE = motionEvent.getX();
                    this.bpF = motionEvent.getY();
                    break;
                case 2:
                    float x = motionEvent.getX() - this.bpE;
                    float y = motionEvent.getY() - this.bpF;
                    if (Math.abs(x) > this.hbl || Math.abs(y) > this.hbl) {
                        this.hbk = true;
                        int left = (int) (x + getLeft());
                        int i = this.width + left;
                        int top = (int) (y + getTop());
                        int i2 = this.height + top;
                        if (left < (-this.hbi)) {
                            left = -this.hbi;
                            i = this.width + left;
                        } else if (i > this.screenWidth + this.hbi) {
                            i = this.screenWidth + this.hbi;
                            left = i - this.width;
                        }
                        if (top < (-this.hbj)) {
                            top = -this.hbj;
                            i2 = this.height + top;
                        } else if (i2 > this.dOW + this.hbj) {
                            i2 = this.dOW + this.hbj;
                            top = i2 - this.height;
                        }
                        this.hbm = left;
                        this.hbn = top;
                        this.hbo = i;
                        this.hbp = i2;
                        layout(left, top, i, i2);
                        break;
                    }
                    break;
            }
        }
        return Boolean.valueOf(this.hbk);
    }

    public void bYX() {
        layout(this.hbm, this.hbn, this.hbo, this.hbp);
    }
}

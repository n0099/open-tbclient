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
    private float bmg;
    private float bmh;
    private int dJG;
    private int gSm;
    private int gSn;
    private boolean gSo;
    private final int gSp;
    private int gSq;
    private int gSr;
    private int gSs;
    private int gSt;
    private int height;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gSo = false;
        this.mContext = context;
        this.gSp = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
        this.gSm = this.width / 2;
        this.gSn = this.height / 2;
        this.screenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.dJG = ScreenHelper.getScreenHeight(this.mContext);
    }

    @Nullable
    private Boolean O(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.gSo = false;
                    this.bmg = motionEvent.getX();
                    this.bmh = motionEvent.getY();
                    break;
                case 2:
                    float x = motionEvent.getX() - this.bmg;
                    float y = motionEvent.getY() - this.bmh;
                    if (Math.abs(x) > this.gSp || Math.abs(y) > this.gSp) {
                        this.gSo = true;
                        int left = (int) (x + getLeft());
                        int i = this.width + left;
                        int top = (int) (y + getTop());
                        int i2 = this.height + top;
                        if (left < (-this.gSm)) {
                            left = -this.gSm;
                            i = this.width + left;
                        } else if (i > this.screenWidth + this.gSm) {
                            i = this.screenWidth + this.gSm;
                            left = i - this.width;
                        }
                        if (top < (-this.gSn)) {
                            top = -this.gSn;
                            i2 = this.height + top;
                        } else if (i2 > this.dJG + this.gSn) {
                            i2 = this.dJG + this.gSn;
                            top = i2 - this.height;
                        }
                        this.gSq = left;
                        this.gSr = top;
                        this.gSs = i;
                        this.gSt = i2;
                        layout(left, top, i, i2);
                        break;
                    }
                    break;
            }
        }
        return Boolean.valueOf(this.gSo);
    }

    public void bVT() {
        layout(this.gSq, this.gSr, this.gSs, this.gSt);
    }
}

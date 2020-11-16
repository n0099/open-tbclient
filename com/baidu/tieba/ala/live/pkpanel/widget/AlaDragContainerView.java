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
    private float bkv;
    private float bkw;
    private int dHY;
    private int gRT;
    private int gRU;
    private boolean gRV;
    private final int gRW;
    private int gRX;
    private int gRY;
    private int gRZ;
    private int gSa;
    private int height;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gRV = false;
        this.mContext = context;
        this.gRW = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
        this.gRT = this.width / 2;
        this.gRU = this.height / 2;
        this.screenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.dHY = ScreenHelper.getScreenHeight(this.mContext);
    }

    @Nullable
    private Boolean O(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.gRV = false;
                    this.bkv = motionEvent.getX();
                    this.bkw = motionEvent.getY();
                    break;
                case 2:
                    float x = motionEvent.getX() - this.bkv;
                    float y = motionEvent.getY() - this.bkw;
                    if (Math.abs(x) > this.gRW || Math.abs(y) > this.gRW) {
                        this.gRV = true;
                        int left = (int) (x + getLeft());
                        int i = this.width + left;
                        int top = (int) (y + getTop());
                        int i2 = this.height + top;
                        if (left < (-this.gRT)) {
                            left = -this.gRT;
                            i = this.width + left;
                        } else if (i > this.screenWidth + this.gRT) {
                            i = this.screenWidth + this.gRT;
                            left = i - this.width;
                        }
                        if (top < (-this.gRU)) {
                            top = -this.gRU;
                            i2 = this.height + top;
                        } else if (i2 > this.dHY + this.gRU) {
                            i2 = this.dHY + this.gRU;
                            top = i2 - this.height;
                        }
                        this.gRX = left;
                        this.gRY = top;
                        this.gRZ = i;
                        this.gSa = i2;
                        layout(left, top, i, i2);
                        break;
                    }
                    break;
            }
        }
        return Boolean.valueOf(this.gRV);
    }

    public void bVm() {
        layout(this.gRX, this.gRY, this.gRZ, this.gSa);
    }
}

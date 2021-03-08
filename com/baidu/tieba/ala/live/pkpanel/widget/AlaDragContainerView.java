package com.baidu.tieba.ala.live.pkpanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes10.dex */
public class AlaDragContainerView extends FrameLayout {
    private float brB;
    private float brC;
    private int dWJ;
    private int height;
    private int hoA;
    private boolean hoB;
    private final int hoC;
    private int hoD;
    private int hoE;
    private int hoF;
    private int hoG;
    private int hoz;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hoB = false;
        this.mContext = context;
        this.hoC = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
        this.hoz = this.width / 2;
        this.hoA = this.height / 2;
        this.screenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.dWJ = ScreenHelper.getScreenHeight(this.mContext);
    }

    @Nullable
    private Boolean O(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.hoB = false;
                    this.brB = motionEvent.getX();
                    this.brC = motionEvent.getY();
                    break;
                case 2:
                    float x = motionEvent.getX() - this.brB;
                    float y = motionEvent.getY() - this.brC;
                    if (Math.abs(x) > this.hoC || Math.abs(y) > this.hoC) {
                        this.hoB = true;
                        int left = (int) (x + getLeft());
                        int i = this.width + left;
                        int top = (int) (y + getTop());
                        int i2 = this.height + top;
                        if (left < (-this.hoz)) {
                            left = -this.hoz;
                            i = this.width + left;
                        } else if (i > this.screenWidth + this.hoz) {
                            i = this.screenWidth + this.hoz;
                            left = i - this.width;
                        }
                        if (top < (-this.hoA)) {
                            top = -this.hoA;
                            i2 = this.height + top;
                        } else if (i2 > this.dWJ + this.hoA) {
                            i2 = this.dWJ + this.hoA;
                            top = i2 - this.height;
                        }
                        this.hoD = left;
                        this.hoE = top;
                        this.hoF = i;
                        this.hoG = i2;
                        layout(left, top, i, i2);
                        break;
                    }
                    break;
            }
        }
        return Boolean.valueOf(this.hoB);
    }

    public void bYY() {
        layout(this.hoD, this.hoE, this.hoF, this.hoG);
    }
}

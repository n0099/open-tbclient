package com.baidu.tieba.ala.live.pkpanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes11.dex */
public class AlaDragContainerView extends FrameLayout {
    private float bqb;
    private float bqc;
    private int dVi;
    private int height;
    private int hmP;
    private int hmQ;
    private boolean hmR;
    private final int hmS;
    private int hmT;
    private int hmU;
    private int hmV;
    private int hmW;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hmR = false;
        this.mContext = context;
        this.hmS = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
        this.hmP = this.width / 2;
        this.hmQ = this.height / 2;
        this.screenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.dVi = ScreenHelper.getScreenHeight(this.mContext);
    }

    @Nullable
    private Boolean O(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.hmR = false;
                    this.bqb = motionEvent.getX();
                    this.bqc = motionEvent.getY();
                    break;
                case 2:
                    float x = motionEvent.getX() - this.bqb;
                    float y = motionEvent.getY() - this.bqc;
                    if (Math.abs(x) > this.hmS || Math.abs(y) > this.hmS) {
                        this.hmR = true;
                        int left = (int) (x + getLeft());
                        int i = this.width + left;
                        int top = (int) (y + getTop());
                        int i2 = this.height + top;
                        if (left < (-this.hmP)) {
                            left = -this.hmP;
                            i = this.width + left;
                        } else if (i > this.screenWidth + this.hmP) {
                            i = this.screenWidth + this.hmP;
                            left = i - this.width;
                        }
                        if (top < (-this.hmQ)) {
                            top = -this.hmQ;
                            i2 = this.height + top;
                        } else if (i2 > this.dVi + this.hmQ) {
                            i2 = this.dVi + this.hmQ;
                            top = i2 - this.height;
                        }
                        this.hmT = left;
                        this.hmU = top;
                        this.hmV = i;
                        this.hmW = i2;
                        layout(left, top, i, i2);
                        break;
                    }
                    break;
            }
        }
        return Boolean.valueOf(this.hmR);
    }

    public void bYS() {
        layout(this.hmT, this.hmU, this.hmV, this.hmW);
    }
}

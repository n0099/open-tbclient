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
    private int hmB;
    private int hmC;
    private boolean hmD;
    private final int hmE;
    private int hmF;
    private int hmG;
    private int hmH;
    private int hmI;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hmD = false;
        this.mContext = context;
        this.hmE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
        this.hmB = this.width / 2;
        this.hmC = this.height / 2;
        this.screenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.dVi = ScreenHelper.getScreenHeight(this.mContext);
    }

    @Nullable
    private Boolean O(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.hmD = false;
                    this.bqb = motionEvent.getX();
                    this.bqc = motionEvent.getY();
                    break;
                case 2:
                    float x = motionEvent.getX() - this.bqb;
                    float y = motionEvent.getY() - this.bqc;
                    if (Math.abs(x) > this.hmE || Math.abs(y) > this.hmE) {
                        this.hmD = true;
                        int left = (int) (x + getLeft());
                        int i = this.width + left;
                        int top = (int) (y + getTop());
                        int i2 = this.height + top;
                        if (left < (-this.hmB)) {
                            left = -this.hmB;
                            i = this.width + left;
                        } else if (i > this.screenWidth + this.hmB) {
                            i = this.screenWidth + this.hmB;
                            left = i - this.width;
                        }
                        if (top < (-this.hmC)) {
                            top = -this.hmC;
                            i2 = this.height + top;
                        } else if (i2 > this.dVi + this.hmC) {
                            i2 = this.dVi + this.hmC;
                            top = i2 - this.height;
                        }
                        this.hmF = left;
                        this.hmG = top;
                        this.hmH = i;
                        this.hmI = i2;
                        layout(left, top, i, i2);
                        break;
                    }
                    break;
            }
        }
        return Boolean.valueOf(this.hmD);
    }

    public void bYL() {
        layout(this.hmF, this.hmG, this.hmH, this.hmI);
    }
}

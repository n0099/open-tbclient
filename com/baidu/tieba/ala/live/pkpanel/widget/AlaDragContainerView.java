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
    private float brm;
    private float brn;
    private int dXO;
    private int height;
    private int hmU;
    private int hmV;
    private boolean hmW;
    private final int hmX;
    private int hmY;
    private int hmZ;
    private int hna;
    private int hnb;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hmW = false;
        this.mContext = context;
        this.hmX = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
        this.hmU = this.width / 2;
        this.hmV = this.height / 2;
        this.screenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.dXO = ScreenHelper.getScreenHeight(this.mContext);
    }

    @Nullable
    private Boolean O(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.hmW = false;
                    this.brm = motionEvent.getX();
                    this.brn = motionEvent.getY();
                    break;
                case 2:
                    float x = motionEvent.getX() - this.brm;
                    float y = motionEvent.getY() - this.brn;
                    if (Math.abs(x) > this.hmX || Math.abs(y) > this.hmX) {
                        this.hmW = true;
                        int left = (int) (x + getLeft());
                        int i = this.width + left;
                        int top = (int) (y + getTop());
                        int i2 = this.height + top;
                        if (left < (-this.hmU)) {
                            left = -this.hmU;
                            i = this.width + left;
                        } else if (i > this.screenWidth + this.hmU) {
                            i = this.screenWidth + this.hmU;
                            left = i - this.width;
                        }
                        if (top < (-this.hmV)) {
                            top = -this.hmV;
                            i2 = this.height + top;
                        } else if (i2 > this.dXO + this.hmV) {
                            i2 = this.dXO + this.hmV;
                            top = i2 - this.height;
                        }
                        this.hmY = left;
                        this.hmZ = top;
                        this.hna = i;
                        this.hnb = i2;
                        layout(left, top, i, i2);
                        break;
                    }
                    break;
            }
        }
        return Boolean.valueOf(this.hmW);
    }

    public void cbE() {
        layout(this.hmY, this.hmZ, this.hna, this.hnb);
    }
}

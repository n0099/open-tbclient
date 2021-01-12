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
    private float bmA;
    private float bmB;
    private int dTc;
    private int height;
    private int hio;
    private int hip;
    private boolean hiq;
    private final int hir;
    private int his;
    private int hit;
    private int hiu;
    private int hiv;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hiq = false;
        this.mContext = context;
        this.hir = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
        this.hio = this.width / 2;
        this.hip = this.height / 2;
        this.screenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.dTc = ScreenHelper.getScreenHeight(this.mContext);
    }

    @Nullable
    private Boolean O(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.hiq = false;
                    this.bmA = motionEvent.getX();
                    this.bmB = motionEvent.getY();
                    break;
                case 2:
                    float x = motionEvent.getX() - this.bmA;
                    float y = motionEvent.getY() - this.bmB;
                    if (Math.abs(x) > this.hir || Math.abs(y) > this.hir) {
                        this.hiq = true;
                        int left = (int) (x + getLeft());
                        int i = this.width + left;
                        int top = (int) (y + getTop());
                        int i2 = this.height + top;
                        if (left < (-this.hio)) {
                            left = -this.hio;
                            i = this.width + left;
                        } else if (i > this.screenWidth + this.hio) {
                            i = this.screenWidth + this.hio;
                            left = i - this.width;
                        }
                        if (top < (-this.hip)) {
                            top = -this.hip;
                            i2 = this.height + top;
                        } else if (i2 > this.dTc + this.hip) {
                            i2 = this.dTc + this.hip;
                            top = i2 - this.height;
                        }
                        this.his = left;
                        this.hit = top;
                        this.hiu = i;
                        this.hiv = i2;
                        layout(left, top, i, i2);
                        break;
                    }
                    break;
            }
        }
        return Boolean.valueOf(this.hiq);
    }

    public void bXN() {
        layout(this.his, this.hit, this.hiu, this.hiv);
    }
}

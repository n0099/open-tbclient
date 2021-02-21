package com.baidu.tieba.ala.view;

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
    private int iin;
    private int iio;
    private int iip;
    private int iiq;
    private boolean iir;
    private boolean isHost;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hmR = false;
        this.iin = 0;
        this.iio = 0;
        this.isHost = false;
        this.mContext = context;
        this.hmS = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.iip = ScreenHelper.getRealScreenWidth(this.mContext);
        this.iiq = ScreenHelper.getRealScreenHeight(this.mContext);
    }

    public void setMargins(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        this.isHost = z;
        this.iir = z2;
        if (z2) {
            this.iip = i4;
            this.iio = -(ScreenHelper.getRealScreenWidth(this.mContext) - i4);
            this.iiq = i3;
            this.iin = -(ScreenHelper.getRealScreenHeight(this.mContext) - i3);
        } else {
            this.iio = -i2;
            this.iip = ScreenHelper.getRealScreenWidth(this.mContext) + i4;
            this.iin = -i;
            this.iiq = ScreenHelper.getRealScreenHeight(this.mContext) + i3;
        }
        if (!z) {
            this.iin -= 100;
            this.iiq -= 100;
        }
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Boolean O(MotionEvent motionEvent) {
        float x;
        float y;
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.hmR = false;
                    this.bqb = motionEvent.getX();
                    this.bqc = motionEvent.getY();
                    x = motionEvent.getX() - this.bqb;
                    y = motionEvent.getY() - this.bqc;
                    if (Math.abs(x) <= this.hmS || Math.abs(y) > this.hmS) {
                        this.hmR = true;
                        int translationX = (int) (x + getTranslationX());
                        int translationY = (int) (y + getTranslationY());
                        int i = this.width + translationX;
                        int i2 = this.height + translationY;
                        if (!this.iir) {
                            if (translationX < this.iio + this.width) {
                                translationX = this.iio + this.width;
                            } else if (translationX > this.iip) {
                                translationX = this.iip;
                            }
                            if (translationY < this.iin + this.height) {
                                translationY = this.iin + this.height;
                            } else if (translationY > this.iiq) {
                                translationY = this.iiq;
                            }
                        } else {
                            if (translationX < this.iio) {
                                translationX = this.iio;
                            } else if (translationX > this.iip - this.width) {
                                translationX = this.iip - this.width;
                            }
                            if (translationY < this.iin) {
                                translationY = this.iin;
                            } else if (translationY > this.iiq - this.height) {
                                translationY = this.iiq - this.height;
                            }
                        }
                        setTranslationX(translationX);
                        setTranslationY(translationY);
                        break;
                    }
                    break;
                case 2:
                    x = motionEvent.getX() - this.bqb;
                    y = motionEvent.getY() - this.bqc;
                    if (Math.abs(x) <= this.hmS) {
                        break;
                    }
                    this.hmR = true;
                    int translationX2 = (int) (x + getTranslationX());
                    int translationY2 = (int) (y + getTranslationY());
                    int i3 = this.width + translationX2;
                    int i22 = this.height + translationY2;
                    if (!this.iir) {
                    }
                    setTranslationX(translationX2);
                    setTranslationY(translationY2);
                    break;
            }
        }
        return Boolean.valueOf(this.hmR);
    }

    public boolean getIsDragged() {
        return this.hmR;
    }
}

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
    private int hmB;
    private int hmC;
    private boolean hmD;
    private final int hmE;
    private int ihZ;
    private int iia;
    private int iib;
    private int iic;
    private boolean iid;
    private boolean isHost;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hmD = false;
        this.ihZ = 0;
        this.iia = 0;
        this.isHost = false;
        this.mContext = context;
        this.hmE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.iib = ScreenHelper.getRealScreenWidth(this.mContext);
        this.iic = ScreenHelper.getRealScreenHeight(this.mContext);
    }

    public void setMargins(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        this.isHost = z;
        this.iid = z2;
        if (z2) {
            this.iib = i4;
            this.iia = -(ScreenHelper.getRealScreenWidth(this.mContext) - i4);
            this.iic = i3;
            this.ihZ = -(ScreenHelper.getRealScreenHeight(this.mContext) - i3);
        } else {
            this.iia = -i2;
            this.iib = ScreenHelper.getRealScreenWidth(this.mContext) + i4;
            this.ihZ = -i;
            this.iic = ScreenHelper.getRealScreenHeight(this.mContext) + i3;
        }
        if (!z) {
            this.ihZ -= 100;
            this.iic -= 100;
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
        this.hmB = this.width / 2;
        this.hmC = this.height / 2;
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
                    this.hmD = false;
                    this.bqb = motionEvent.getX();
                    this.bqc = motionEvent.getY();
                    x = motionEvent.getX() - this.bqb;
                    y = motionEvent.getY() - this.bqc;
                    if (Math.abs(x) <= this.hmE || Math.abs(y) > this.hmE) {
                        this.hmD = true;
                        int translationX = (int) (x + getTranslationX());
                        int translationY = (int) (y + getTranslationY());
                        int i = this.width + translationX;
                        int i2 = this.height + translationY;
                        if (!this.iid) {
                            if (translationX < this.iia + this.width) {
                                translationX = this.iia + this.width;
                            } else if (translationX > this.iib) {
                                translationX = this.iib;
                            }
                            if (translationY < this.ihZ + this.height) {
                                translationY = this.ihZ + this.height;
                            } else if (translationY > this.iic) {
                                translationY = this.iic;
                            }
                        } else {
                            if (translationX < this.iia) {
                                translationX = this.iia;
                            } else if (translationX > this.iib - this.width) {
                                translationX = this.iib - this.width;
                            }
                            if (translationY < this.ihZ) {
                                translationY = this.ihZ;
                            } else if (translationY > this.iic - this.height) {
                                translationY = this.iic - this.height;
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
                    if (Math.abs(x) <= this.hmE) {
                        break;
                    }
                    this.hmD = true;
                    int translationX2 = (int) (x + getTranslationX());
                    int translationY2 = (int) (y + getTranslationY());
                    int i3 = this.width + translationX2;
                    int i22 = this.height + translationY2;
                    if (!this.iid) {
                    }
                    setTranslationX(translationX2);
                    setTranslationY(translationY2);
                    break;
            }
        }
        return Boolean.valueOf(this.hmD);
    }

    public boolean getIsDragged() {
        return this.hmD;
    }
}

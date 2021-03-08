package com.baidu.tieba.ala.view;

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
    private int hoz;
    private int ijW;
    private int ijX;
    private int ijY;
    private int ijZ;
    private boolean ika;
    private boolean isHost;
    private Context mContext;
    private int screenWidth;
    private int width;

    public AlaDragContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hoB = false;
        this.ijW = 0;
        this.ijX = 0;
        this.isHost = false;
        this.mContext = context;
        this.hoC = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ijY = ScreenHelper.getRealScreenWidth(this.mContext);
        this.ijZ = ScreenHelper.getRealScreenHeight(this.mContext);
    }

    public void setMargins(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        this.isHost = z;
        this.ika = z2;
        if (z2) {
            this.ijY = i4;
            this.ijX = -(ScreenHelper.getRealScreenWidth(this.mContext) - i4);
            this.ijZ = i3;
            this.ijW = -(ScreenHelper.getRealScreenHeight(this.mContext) - i3);
        } else {
            this.ijX = -i2;
            this.ijY = ScreenHelper.getRealScreenWidth(this.mContext) + i4;
            this.ijW = -i;
            this.ijZ = ScreenHelper.getRealScreenHeight(this.mContext) + i3;
        }
        if (!z) {
            this.ijW -= 100;
            this.ijZ -= 100;
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
        this.hoz = this.width / 2;
        this.hoA = this.height / 2;
        this.screenWidth = ScreenHelper.getScreenWidth(this.mContext);
        this.dWJ = ScreenHelper.getScreenHeight(this.mContext);
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
                    this.hoB = false;
                    this.brB = motionEvent.getX();
                    this.brC = motionEvent.getY();
                    x = motionEvent.getX() - this.brB;
                    y = motionEvent.getY() - this.brC;
                    if (Math.abs(x) <= this.hoC || Math.abs(y) > this.hoC) {
                        this.hoB = true;
                        int translationX = (int) (x + getTranslationX());
                        int translationY = (int) (y + getTranslationY());
                        int i = this.width + translationX;
                        int i2 = this.height + translationY;
                        if (!this.ika) {
                            if (translationX < this.ijX + this.width) {
                                translationX = this.ijX + this.width;
                            } else if (translationX > this.ijY) {
                                translationX = this.ijY;
                            }
                            if (translationY < this.ijW + this.height) {
                                translationY = this.ijW + this.height;
                            } else if (translationY > this.ijZ) {
                                translationY = this.ijZ;
                            }
                        } else {
                            if (translationX < this.ijX) {
                                translationX = this.ijX;
                            } else if (translationX > this.ijY - this.width) {
                                translationX = this.ijY - this.width;
                            }
                            if (translationY < this.ijW) {
                                translationY = this.ijW;
                            } else if (translationY > this.ijZ - this.height) {
                                translationY = this.ijZ - this.height;
                            }
                        }
                        setTranslationX(translationX);
                        setTranslationY(translationY);
                        break;
                    }
                    break;
                case 2:
                    x = motionEvent.getX() - this.brB;
                    y = motionEvent.getY() - this.brC;
                    if (Math.abs(x) <= this.hoC) {
                        break;
                    }
                    this.hoB = true;
                    int translationX2 = (int) (x + getTranslationX());
                    int translationY2 = (int) (y + getTranslationY());
                    int i3 = this.width + translationX2;
                    int i22 = this.height + translationY2;
                    if (!this.ika) {
                    }
                    setTranslationX(translationX2);
                    setTranslationY(translationY2);
                    break;
            }
        }
        return Boolean.valueOf(this.hoB);
    }

    public boolean getIsDragged() {
        return this.hoB;
    }
}

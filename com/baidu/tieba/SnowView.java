package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;
/* loaded from: classes.dex */
public class SnowView extends View {
    private boolean alr;
    private Bitmap[] als;
    private ae[] alt;
    private Handler mHandler;
    private Paint mPaint;
    private int mScreenHeight;
    private int mScreenWidth;
    private Random mz;

    public SnowView(Context context) {
        this(context, null);
    }

    public SnowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SnowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void H(int i, int i2) {
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
        AC();
    }

    public void AA() {
        this.alr = true;
        invalidate();
    }

    public void AB() {
        this.alr = false;
    }

    private void init() {
        this.mHandler = new Handler();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mz = new Random();
        this.alt = new ae[18];
        for (int i = 0; i < this.alt.length; i++) {
            this.alt[i] = new ae(this, null);
        }
        this.als = new Bitmap[3];
        Resources resources = getContext().getResources();
        this.als[0] = ((BitmapDrawable) resources.getDrawable(v.pic_startpage_snow_middle)).getBitmap();
        this.als[1] = ((BitmapDrawable) resources.getDrawable(v.pic_startpage_snow_big)).getBitmap();
        this.als[2] = ((BitmapDrawable) resources.getDrawable(v.pic_startpage_snow_small)).getBitmap();
    }

    private void AC() {
        if (this.alt != null && this.mz != null) {
            for (int i = 0; i < this.alt.length; i++) {
                this.alt[i].x = this.mz.nextInt(this.mScreenWidth);
                switch (i % 3) {
                    case 0:
                        this.alt[i].speed = 4;
                        this.alt[i].y = this.mz.nextInt((this.mScreenHeight * 3) / 5);
                        break;
                    case 1:
                        this.alt[i].speed = 3;
                        this.alt[i].y = this.mz.nextInt((this.mScreenHeight * 4) / 5);
                        break;
                    case 2:
                        this.alt[i].speed = 5;
                        this.alt[i].y = this.mz.nextInt((this.mScreenHeight * 2) / 5);
                        break;
                    default:
                        this.alt[i].speed = 4;
                        this.alt[i].y = this.mz.nextInt((this.mScreenHeight * 3) / 5);
                        break;
                }
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.alt != null && this.als != null && this.mScreenHeight != 0 && this.mScreenWidth != 0) {
            for (int i = 0; i < this.alt.length; i++) {
                if (this.alt[i].y >= this.mScreenHeight) {
                    this.alt[i].y = this.mz.nextInt((this.mScreenHeight * 2) / 3);
                }
                this.alt[i].y += this.alt[i].speed;
                canvas.drawBitmap(this.als[i % 3], this.alt[i].x, this.alt[i].y, this.mPaint);
            }
            if (this.alr) {
                this.mHandler.postDelayed(new ad(this), 20L);
            }
        }
    }
}

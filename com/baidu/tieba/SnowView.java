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
    private boolean alu;
    private Bitmap[] alv;
    private ae[] alw;
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
        AI();
    }

    public void AG() {
        this.alu = true;
        invalidate();
    }

    public void AH() {
        this.alu = false;
    }

    private void init() {
        this.mHandler = new Handler();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mz = new Random();
        this.alw = new ae[18];
        for (int i = 0; i < this.alw.length; i++) {
            this.alw[i] = new ae(this, null);
        }
        this.alv = new Bitmap[3];
        Resources resources = getContext().getResources();
        this.alv[0] = ((BitmapDrawable) resources.getDrawable(v.pic_startpage_snow_middle)).getBitmap();
        this.alv[1] = ((BitmapDrawable) resources.getDrawable(v.pic_startpage_snow_big)).getBitmap();
        this.alv[2] = ((BitmapDrawable) resources.getDrawable(v.pic_startpage_snow_small)).getBitmap();
    }

    private void AI() {
        if (this.alw != null && this.mz != null) {
            for (int i = 0; i < this.alw.length; i++) {
                this.alw[i].x = this.mz.nextInt(this.mScreenWidth);
                switch (i % 3) {
                    case 0:
                        this.alw[i].speed = 4;
                        this.alw[i].y = this.mz.nextInt((this.mScreenHeight * 3) / 5);
                        break;
                    case 1:
                        this.alw[i].speed = 3;
                        this.alw[i].y = this.mz.nextInt((this.mScreenHeight * 4) / 5);
                        break;
                    case 2:
                        this.alw[i].speed = 5;
                        this.alw[i].y = this.mz.nextInt((this.mScreenHeight * 2) / 5);
                        break;
                    default:
                        this.alw[i].speed = 4;
                        this.alw[i].y = this.mz.nextInt((this.mScreenHeight * 3) / 5);
                        break;
                }
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.alw != null && this.alv != null && this.mScreenHeight != 0 && this.mScreenWidth != 0) {
            for (int i = 0; i < this.alw.length; i++) {
                if (this.alw[i].y >= this.mScreenHeight) {
                    this.alw[i].y = this.mz.nextInt((this.mScreenHeight * 2) / 3);
                }
                this.alw[i].y += this.alw[i].speed;
                canvas.drawBitmap(this.alv[i % 3], this.alw[i].x, this.alw[i].y, this.mPaint);
            }
            if (this.alu) {
                this.mHandler.postDelayed(new ad(this), 20L);
            }
        }
    }
}

package com.baidu.tieba.game.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends View {
    private int aKA;
    private int aKB;
    private int aKC;
    private int aKD;
    private RectF aKE;
    private RectF aKF;
    private int aKG;
    private Bitmap aKH;
    private Bitmap aKI;
    private Rect aKJ;
    private Rect aKK;
    private boolean aKL;
    private int aKy;
    private int aKz;
    private Paint gs;
    private int mHeight;
    private Scroller mScroller;
    private int mStatus;
    private int mWidth;

    public e(Context context) {
        super(context);
        init(context);
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    private void init(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context instanceof Activity) {
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } else if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gs = new Paint();
        this.gs.setStyle(Paint.Style.STROKE);
        this.gs.setColor(aw.getColor(s.cp_link_tip_a));
        this.gs.setAntiAlias(true);
        this.aKC = m.c(context, t.ds24);
        if (displayMetrics.widthPixels == 540) {
            this.aKD = m.c(context, t.ds2);
        } else {
            this.aKD = 3;
        }
        this.aKG = m.c(context, t.ds4);
        this.aKH = aw.bA(u.icon_game_download_pause);
        this.aKI = aw.bA(u.icon_game_download_play);
        this.aKJ = new Rect();
        this.aKK = new Rect();
        this.aKE = new RectF();
        this.aKF = new RectF();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.aKA = this.mWidth / 2;
        this.aKB = this.mHeight / 2;
        this.aKJ.set(this.aKA - (this.aKH.getWidth() / 2), this.aKB - (this.aKH.getHeight() / 2), this.aKA + (this.aKH.getWidth() / 2), this.aKB + (this.aKH.getHeight() / 2));
        this.aKK.set(this.aKA - (this.aKI.getWidth() / 2), this.aKB - (this.aKI.getHeight() / 2), this.aKA + (this.aKI.getWidth() / 2), this.aKB + (this.aKI.getHeight() / 2));
        this.aKE.set((this.aKA - this.aKC) + this.aKD, (this.aKB - this.aKC) + this.aKD, (this.aKA + this.aKC) - this.aKD, (this.aKB + this.aKC) - this.aKD);
        this.aKF.set(this.aKA - this.aKC, this.aKB - this.aKC, this.aKA + this.aKC, this.aKB + this.aKC);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (this.mStatus) {
            case 2:
                c(canvas);
                return;
            case 3:
                e(canvas);
                return;
            case 4:
                d(canvas);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.aKL) {
            if (this.mScroller.computeScrollOffset()) {
                this.aKz = this.mScroller.getCurrX();
                invalidate();
                return;
            }
            Iu();
        }
    }

    public void w(float f) {
        this.aKy = (int) (360.0f * f);
    }

    public void Iu() {
        this.mScroller.startScroll(0, 0, 360, 0, 1000);
        invalidate();
        this.aKL = true;
    }

    public void Iv() {
        this.aKL = false;
        if (this.mScroller.computeScrollOffset()) {
            this.mScroller.abortAnimation();
        }
    }

    private void c(Canvas canvas) {
        this.gs.setStrokeWidth(this.aKD);
        canvas.drawCircle(this.aKA, this.aKB, this.aKC, this.gs);
        this.gs.setStrokeWidth(this.aKG);
        canvas.drawArc(this.aKE, 270.0f, this.aKy, false, this.gs);
        canvas.drawBitmap(this.aKH, (Rect) null, this.aKJ, this.gs);
    }

    private void d(Canvas canvas) {
        this.gs.setStrokeWidth(this.aKD);
        canvas.drawCircle(this.aKA, this.aKB, this.aKC, this.gs);
        this.gs.setStrokeWidth(this.aKG);
        canvas.drawArc(this.aKE, 270.0f, this.aKy, false, this.gs);
        canvas.drawBitmap(this.aKI, (Rect) null, this.aKK, this.gs);
    }

    private void e(Canvas canvas) {
        canvas.save();
        canvas.rotate(this.aKz, this.aKA, this.aKB);
        this.gs.setStrokeWidth(this.aKD);
        canvas.drawArc(this.aKF, 210.0f, 330.0f, false, this.gs);
        canvas.restore();
    }
}

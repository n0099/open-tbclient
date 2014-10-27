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
    private int aKk;
    private int aKl;
    private int aKm;
    private int aKn;
    private int aKo;
    private int aKp;
    private RectF aKq;
    private RectF aKr;
    private int aKs;
    private Bitmap aKt;
    private Bitmap aKu;
    private Rect aKv;
    private Rect aKw;
    private boolean aKx;
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
        this.aKo = m.c(context, t.ds24);
        if (displayMetrics.widthPixels == 540) {
            this.aKp = m.c(context, t.ds2);
        } else {
            this.aKp = 3;
        }
        this.aKs = m.c(context, t.ds4);
        this.aKt = aw.bA(u.icon_game_download_pause);
        this.aKu = aw.bA(u.icon_game_download_play);
        this.aKv = new Rect();
        this.aKw = new Rect();
        this.aKq = new RectF();
        this.aKr = new RectF();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.aKm = this.mWidth / 2;
        this.aKn = this.mHeight / 2;
        this.aKv.set(this.aKm - (this.aKt.getWidth() / 2), this.aKn - (this.aKt.getHeight() / 2), this.aKm + (this.aKt.getWidth() / 2), this.aKn + (this.aKt.getHeight() / 2));
        this.aKw.set(this.aKm - (this.aKu.getWidth() / 2), this.aKn - (this.aKu.getHeight() / 2), this.aKm + (this.aKu.getWidth() / 2), this.aKn + (this.aKu.getHeight() / 2));
        this.aKq.set((this.aKm - this.aKo) + this.aKp, (this.aKn - this.aKo) + this.aKp, (this.aKm + this.aKo) - this.aKp, (this.aKn + this.aKo) - this.aKp);
        this.aKr.set(this.aKm - this.aKo, this.aKn - this.aKo, this.aKm + this.aKo, this.aKn + this.aKo);
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
        if (this.aKx) {
            if (this.mScroller.computeScrollOffset()) {
                this.aKl = this.mScroller.getCurrX();
                invalidate();
                return;
            }
            Iq();
        }
    }

    public void w(float f) {
        this.aKk = (int) (360.0f * f);
    }

    public void Iq() {
        this.mScroller.startScroll(0, 0, 360, 0, 1000);
        invalidate();
        this.aKx = true;
    }

    public void Ir() {
        this.aKx = false;
        if (this.mScroller.computeScrollOffset()) {
            this.mScroller.abortAnimation();
        }
    }

    private void c(Canvas canvas) {
        this.gs.setStrokeWidth(this.aKp);
        canvas.drawCircle(this.aKm, this.aKn, this.aKo, this.gs);
        this.gs.setStrokeWidth(this.aKs);
        canvas.drawArc(this.aKq, 270.0f, this.aKk, false, this.gs);
        canvas.drawBitmap(this.aKt, (Rect) null, this.aKv, this.gs);
    }

    private void d(Canvas canvas) {
        this.gs.setStrokeWidth(this.aKp);
        canvas.drawCircle(this.aKm, this.aKn, this.aKo, this.gs);
        this.gs.setStrokeWidth(this.aKs);
        canvas.drawArc(this.aKq, 270.0f, this.aKk, false, this.gs);
        canvas.drawBitmap(this.aKu, (Rect) null, this.aKw, this.gs);
    }

    private void e(Canvas canvas) {
        canvas.save();
        canvas.rotate(this.aKl, this.aKm, this.aKn);
        this.gs.setStrokeWidth(this.aKp);
        canvas.drawArc(this.aKr, 210.0f, 330.0f, false, this.gs);
        canvas.restore();
    }
}

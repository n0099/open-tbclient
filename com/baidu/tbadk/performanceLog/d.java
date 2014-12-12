package com.baidu.tbadk.performanceLog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends ImageView {
    final /* synthetic */ a afB;
    private int afC;
    private final Paint mPaint;
    private long mStartTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, Context context) {
        super(context);
        this.afB = aVar;
        this.mStartTime = -1L;
        this.afC = 0;
        this.mPaint = new Paint();
        this.mPaint.setColor(0);
        this.mPaint.setAlpha(0);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextSize(1.0f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar;
        c cVar2;
        if (this.mStartTime == -1) {
            this.mStartTime = SystemClock.elapsedRealtime();
            this.afC = 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        super.draw(canvas);
        if (elapsedRealtime - this.mStartTime > 1000) {
            this.mStartTime = elapsedRealtime;
            cVar = this.afB.afA;
            if (cVar != null) {
                cVar2 = this.afB.afA;
                cVar2.dO(this.afC);
            } else {
                com.baidu.adp.a.a.d.o(this.afC);
            }
            this.afC = 0;
        }
        this.afC++;
    }
}

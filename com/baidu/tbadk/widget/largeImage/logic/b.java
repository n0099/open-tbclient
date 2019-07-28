package com.baidu.tbadk.widget.largeImage.logic;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.largeImage.a.a;
import com.baidu.tbadk.widget.largeImage.b.c;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.List;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.largeImage.logic.a {
    private static final String TAG = b.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    private final View cIB;
    private ScaleGestureDetector cIC;
    private BitmapRegionDecoder cID;
    private com.baidu.tbadk.widget.largeImage.a.b cIE;
    private com.baidu.tbadk.widget.largeImage.b.a cIF;
    private float cIG;
    private float cIH;
    private Bitmap cII;
    private int cIJ;
    private a cIK;
    private com.baidu.tbadk.widget.largeImage.b.c cIL;
    private com.baidu.tbadk.widget.largeImage.logic.a cIO;
    private ValueAnimator cIP;
    private View.OnLongClickListener coR;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float cDF = 2.0f;
    private float cDE = 1.0f;
    private final Matrix cIM = new Matrix();
    Bitmap cIN = null;
    private boolean cIQ = true;
    private boolean cIR = false;
    BdAsyncTask<String, String, String> cIS = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.cIE != null && b.this.cID != null) {
                int[] agq = b.this.cIF.agq();
                int i = 1;
                while (Math.max(agq[0] / b.this.cIE.getRealWidth(), agq[1] / b.this.cIE.axU()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, agq[0], agq[1]);
                try {
                    b.this.cIN = b.this.cID.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.cIN = b.this.cID.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.cIN = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.atw().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.cIN, false));
                b.this.a(b.this.cIN, b.this.cIE, pow);
                b.this.cIE.r(b.this.cIN);
                b.this.ayh();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.cIO != null) {
                b.this.cIO.aqM();
            }
            b.this.ayf();
            b.this.cIB.invalidate();
        }
    };

    public b(View view) {
        this.cIJ = 1;
        this.cIB = view;
        this.mContext = this.cIB.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0264b());
        this.cIC = new ScaleGestureDetector(this.mContext, new c());
        this.cIK = new a(this.mContext);
        this.cIJ = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.cIJ == 2 && ayb()) {
            switch (action) {
                case 0:
                    if (!this.cIK.isFinished()) {
                        this.cIR = true;
                    } else {
                        this.cIR = false;
                    }
                case 1:
                case 3:
                    awO();
                    break;
            }
            this.cIK.forceFinished(true);
            this.cIC.onTouchEvent(motionEvent);
            if (this.cIC.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean axY() {
        return Math.floor((double) (this.cDE * 10000.0f)) == Math.floor((double) (this.cIH * 10000.0f));
    }

    public void awO() {
        if (this.cIH / this.cDE < 1.0f) {
            a(this.cDE, 0.0f, 0.0f, 400);
        }
    }

    public boolean axZ() {
        if (this.cIJ == 1) {
            return false;
        }
        if (this.cIK.computeScrollOffset()) {
            int currX = this.cIK.getCurrX();
            int currY = this.cIK.getCurrY();
            float ayi = (currX - this.cIK.ayi()) * 2.0f;
            float ayj = (currY - this.cIK.ayj()) * 2.0f;
            int ah = l.ah(TbadkCoreApplication.getInst());
            if (ayj >= 0.0f && Math.abs(ayj) <= 20.0f && currX < ah) {
                v(0.0f, -20.0f);
                this.cIB.invalidate();
                return true;
            }
            this.cIK.lk(currX);
            this.cIK.ll(currY);
            v(-ayi, -ayj);
            this.cIB.invalidate();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2) {
        if (this.cIE != null) {
            float[] w = w(f, f2);
            float f3 = w[0];
            float f4 = w[1];
            this.cIM.postTranslate(-f3, -f4);
            this.cIE.u((f3 * 1.0f) / this.cIH, (f4 * 1.0f) / this.cIH);
            ayf();
            this.cIB.invalidate();
        }
    }

    private float[] w(float f, float f2) {
        float[] fArr = new float[2];
        Rect axT = this.cIE.axT();
        int[] agq = this.cIF.agq();
        if (axT.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (axT.bottom + f2 > agq[1]) {
            f2 = (agq[1] - axT.bottom) * this.cIH;
        }
        if (axT.bottom - axT.top > agq[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.cIQ = f2 == 0.0f;
        return fArr;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.cIF == null) {
            this.cII = bitmap;
            this.cIF = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.cID = this.cIF.I(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.cID = this.cIF.I(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.cIJ = 2;
            aya();
        }
    }

    public void aya() {
        if (this.cIJ == 2 && this.cIF != null && this.cIS.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.cIE == null && this.cIB.getMeasuredWidth() > 0 && this.cIB.getMeasuredHeight() > 0 && this.cIF.agq()[0] > 0 && this.cIF.agq()[1] > 0) {
            this.cIE = new com.baidu.tbadk.widget.largeImage.a.b(this.cIB.getMeasuredWidth(), this.cIB.getMeasuredHeight(), this.cIF.agq());
            this.cIS.setPriority(3);
            this.cIS.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.coR = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !ayb()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.cIB.getWidth() - this.cIB.getPaddingLeft()) - this.cIB.getPaddingRight();
            int height2 = (this.cIB.getHeight() - this.cIB.getPaddingTop()) - this.cIB.getPaddingBottom();
            if (width * height2 > width2 * height) {
                f = height2 / height;
            } else {
                f = width2 / width;
            }
            matrix.setScale(f, f);
            matrix.postTranslate(0.0f, 0.0f);
            canvas.drawBitmap(bitmap, matrix, null);
            return true;
        }
        return B(canvas);
    }

    private boolean ayb() {
        return (this.cIE == null || this.cIE.axX() == null || this.cIE.axX().getBitmap() == null || this.cIE.axX().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(Canvas canvas) {
        if (this.cIJ != 1 || this.cII == null) {
            if (this.cIE != null) {
                this.cIE.axT();
                if (ayb()) {
                    canvas.drawBitmap(this.cIE.axX().getBitmap(), this.cIM, null);
                }
                a(this.cIE, false);
                aye();
                canvas.save();
                float axP = (1.0f * this.cIE.axP()) / this.cIE.axW();
                canvas.scale(axP, axP);
                List<com.baidu.tbadk.widget.largeImage.a.a> axV = this.cIE.axV();
                if (axV != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : axV) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.axL(), aVar.axM(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float ayc() {
        return this.cDE;
    }

    public float getMinScaleValue() {
        if (this.cDE < 1.0f) {
            return this.cDE;
        }
        return 1.0f;
    }

    public float ayd() {
        return 2.0f * this.cDE;
    }

    public void release() {
        if (this.cIP != null) {
            this.cIP.cancel();
        }
        if (this.cIS != null) {
            this.cIS.cancel();
        }
        if (this.cIL != null) {
            this.cIL.onDestory();
        }
        if (this.cIE != null && this.cIE.axV() != null) {
            this.cIE.axV().clear();
        }
        if (this.cIN != null) {
            this.cIN.recycle();
            this.cIN = null;
        }
        if (this.cID != null) {
            this.cID.recycle();
        }
    }

    private void aye() {
        List<com.baidu.tbadk.widget.largeImage.a.a> axV = this.cIE.axV();
        if (axV != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : axV) {
                a(aVar, this.cIE);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.cIO = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.axN().atc() == 0 && aVar.axN().atd() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.axT());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int axP = aVar.axN().axP();
        aVar.o((i - rect.left) / axP, (i3 - rect.top) / axP, (i2 - rect.left) / axP, (i4 - rect.top) / axP);
        aVar.n((i - rect2.left) / axP, (i3 - rect2.top) / axP, (i2 - rect2.left) / axP, (i4 - rect2.top) / axP);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.axR(), bVar.axP(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.cIL == null) {
            this.cIL = new com.baidu.tbadk.widget.largeImage.b.c(this.cIE, this.cID);
        }
        int i3 = pointArr[0].y;
        int i4 = pointArr[0].x;
        int i5 = pointArr[1].y;
        int i6 = pointArr[1].x;
        if (z) {
            i2 = i3;
            z2 = true;
            list = null;
        } else {
            List<com.baidu.tbadk.widget.largeImage.a.a> axV = this.cIE.axV();
            axV.clear();
            i2 = i3;
            z2 = true;
            list = axV;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                com.baidu.tbadk.widget.largeImage.a.a y = y(i2, i7, i);
                if (y == null) {
                    if (z) {
                        x(i2, i7, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(y);
                }
            }
            i2++;
        }
        if (z2) {
            this.cIL.ayl();
        }
    }

    public void ayf() {
        if (this.cIJ != 1) {
            a(this.cIE, true);
        }
    }

    private void x(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.cIL.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a y(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0263a c0263a = new a.C0263a(i, i2, i3);
        if (this.cIL.aym() != null && (aVar = this.cIL.aym().get(c0263a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.cIL.aym().remove(c0263a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void aqM() {
        this.cIB.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0264b extends GestureDetector.SimpleOnGestureListener {
        private C0264b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.v((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.cIR = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.cIH == b.this.cDF ? b.this.cDE : b.this.cDF, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect axT = b.this.cIE.axT();
            Rect axQ = b.this.cIE.axQ();
            float f3 = axT.right - axQ.right;
            float f4 = axT.left - axQ.left;
            float f5 = axT.bottom - axQ.bottom;
            float f6 = axT.top - axQ.top;
            b.this.cIK.forceFinished(true);
            b.this.cIK.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.cIB.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.cIR = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.cIR || b.this.coR == null) {
                b.this.cIR = false;
            } else {
                b.this.coR.onLongClick(b.this.cIB);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.cIR || b.this.mClickListener == null) {
                b.this.cIR = false;
            } else {
                b.this.mClickListener.onClick(b.this.cIB);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.cIP != null) {
            this.cIP.cancel();
        }
        this.cIP = ValueAnimator.ofFloat(this.cIH, f);
        this.cIP.setDuration(i);
        this.cIP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.cIH, f2, f3);
                }
            }
        });
        this.cIP.start();
    }

    /* loaded from: classes.dex */
    private class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            b.this.c(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }
    }

    public void c(float f, float f2, float f3) {
        if (this.cIH * f < this.cIG) {
            f = this.cIG / this.cIH;
        }
        if (this.cIH * f > this.cDF) {
            f = this.cDF / this.cIH;
        }
        Rect axT = this.cIE.axT();
        float f4 = ((axT.left + axT.right) * 1.0f) / 2.0f;
        float f5 = ((axT.bottom + axT.top) * 1.0f) / 2.0f;
        if (this.cIE != null) {
            this.cIM.postScale(f, f, this.cIE.getRealWidth() / 2, this.cIE.axU() / 2);
            this.cIE.b(1.0f / f, f4, f5);
            this.cIH *= f;
            this.cIE.ar(1.0f / this.cIH);
            float[] ayg = ayg();
            this.cIM.postTranslate(-ayg[0], -ayg[1]);
            this.cIE.u((ayg[0] * 1.0f) / this.cIH, (ayg[1] * 1.0f) / this.cIH);
            ayf();
            this.cIB.invalidate();
        }
    }

    public boolean awN() {
        Rect axT;
        return (this.cIE == null || (axT = this.cIE.axT()) == null || axT.top > 10) ? false : true;
    }

    private float[] ayg() {
        Rect axT = this.cIE.axT();
        int[] agq = this.cIF.agq();
        float[] fArr = {(agq[0] / 2) - (((axT.left + axT.right) * 1.0f) / 2.0f)};
        if (axT.top < 0) {
            fArr[1] = 0 - axT.top;
        }
        if (axT.bottom > agq[1]) {
            fArr[1] = agq[1] - axT.bottom;
        }
        if (axT.bottom - axT.top > agq[1]) {
            fArr[1] = (agq[1] / 2) - (((axT.bottom + axT.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.cIH;
        fArr[1] = fArr[1] * this.cIH;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayh() {
        if (this.cIE != null) {
            this.cIE.as(1.0f / this.cDE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.axU() * 1.0f) / bitmap.getHeight());
        this.cIM.postScale(max, max);
        this.cIG = max * (1.0f / i);
        this.cDE = this.cIG;
        this.cIH = this.cDE;
        this.cDF = 2.0f * this.cIH;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.cID.getWidth();
        if (realWidth > 1.0f) {
            this.cIG /= realWidth;
        }
        bVar.ar(1.0f / this.cIH);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int cIW;
        int cIX;

        public a(Context context) {
            super(context);
            this.cIW = 0;
            this.cIX = 0;
        }

        public void lk(int i) {
            this.cIW = i;
        }

        public void ll(int i) {
            this.cIX = i;
        }

        public int ayi() {
            return this.cIW;
        }

        public int ayj() {
            return this.cIX;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.cIW = 0;
            this.cIX = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

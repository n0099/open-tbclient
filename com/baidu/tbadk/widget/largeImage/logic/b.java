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
    private final View cHh;
    private ScaleGestureDetector cHi;
    private BitmapRegionDecoder cHj;
    private com.baidu.tbadk.widget.largeImage.a.b cHk;
    private com.baidu.tbadk.widget.largeImage.b.a cHl;
    private float cHm;
    private float cHn;
    private Bitmap cHo;
    private int cHp;
    private a cHq;
    private com.baidu.tbadk.widget.largeImage.b.c cHr;
    private com.baidu.tbadk.widget.largeImage.logic.a cHu;
    private ValueAnimator cHv;
    private View.OnLongClickListener cnF;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float cCo = 2.0f;
    private float cCn = 1.0f;
    private final Matrix cHs = new Matrix();
    Bitmap cHt = null;
    private boolean cHw = true;
    private boolean cHx = false;
    BdAsyncTask<String, String, String> cHy = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.cHk != null && b.this.cHj != null) {
                int[] afo = b.this.cHl.afo();
                int i = 1;
                while (Math.max(afo[0] / b.this.cHk.getRealWidth(), afo[1] / b.this.cHk.awI()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, afo[0], afo[1]);
                try {
                    b.this.cHt = b.this.cHj.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.cHt = b.this.cHj.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.cHt = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.asp().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.cHt, false));
                b.this.a(b.this.cHt, b.this.cHk, pow);
                b.this.cHk.r(b.this.cHt);
                b.this.awV();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.cHu != null) {
                b.this.cHu.apH();
            }
            b.this.awT();
            b.this.cHh.invalidate();
        }
    };

    public b(View view) {
        this.cHp = 1;
        this.cHh = view;
        this.mContext = this.cHh.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0262b());
        this.cHi = new ScaleGestureDetector(this.mContext, new c());
        this.cHq = new a(this.mContext);
        this.cHp = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.cHp == 2 && awP()) {
            switch (action) {
                case 0:
                    if (!this.cHq.isFinished()) {
                        this.cHx = true;
                    } else {
                        this.cHx = false;
                    }
                case 1:
                case 3:
                    avF();
                    break;
            }
            this.cHq.forceFinished(true);
            this.cHi.onTouchEvent(motionEvent);
            if (this.cHi.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean awM() {
        return Math.floor((double) (this.cCn * 10000.0f)) == Math.floor((double) (this.cHn * 10000.0f));
    }

    public void avF() {
        if (this.cHn / this.cCn < 1.0f) {
            a(this.cCn, 0.0f, 0.0f, 400);
        }
    }

    public boolean awN() {
        if (this.cHp == 1) {
            return false;
        }
        if (this.cHq.computeScrollOffset()) {
            int currX = this.cHq.getCurrX();
            int currY = this.cHq.getCurrY();
            float awW = (currX - this.cHq.awW()) * 2.0f;
            float awX = (currY - this.cHq.awX()) * 2.0f;
            int ah = l.ah(TbadkCoreApplication.getInst());
            if (awX >= 0.0f && Math.abs(awX) <= 20.0f && currX < ah) {
                moveTo(0.0f, -20.0f);
                this.cHh.invalidate();
                return true;
            }
            this.cHq.le(currX);
            this.cHq.lf(currY);
            moveTo(-awW, -awX);
            this.cHh.invalidate();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.cHk != null) {
            float[] v = v(f, f2);
            float f3 = v[0];
            float f4 = v[1];
            this.cHs.postTranslate(-f3, -f4);
            this.cHk.u((f3 * 1.0f) / this.cHn, (f4 * 1.0f) / this.cHn);
            awT();
            this.cHh.invalidate();
        }
    }

    private float[] v(float f, float f2) {
        float[] fArr = new float[2];
        Rect awH = this.cHk.awH();
        int[] afo = this.cHl.afo();
        if (awH.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (awH.bottom + f2 > afo[1]) {
            f2 = (afo[1] - awH.bottom) * this.cHn;
        }
        if (awH.bottom - awH.top > afo[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.cHw = f2 == 0.0f;
        return fArr;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.cHl == null) {
            this.cHo = bitmap;
            this.cHl = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.cHj = this.cHl.H(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.cHj = this.cHl.H(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.cHp = 2;
            awO();
        }
    }

    public void awO() {
        if (this.cHp == 2 && this.cHl != null && this.cHy.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.cHk == null && this.cHh.getMeasuredWidth() > 0 && this.cHh.getMeasuredHeight() > 0 && this.cHl.afo()[0] > 0 && this.cHl.afo()[1] > 0) {
            this.cHk = new com.baidu.tbadk.widget.largeImage.a.b(this.cHh.getMeasuredWidth(), this.cHh.getMeasuredHeight(), this.cHl.afo());
            this.cHy.setPriority(3);
            this.cHy.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnF = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !awP()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.cHh.getWidth() - this.cHh.getPaddingLeft()) - this.cHh.getPaddingRight();
            int height2 = (this.cHh.getHeight() - this.cHh.getPaddingTop()) - this.cHh.getPaddingBottom();
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

    private boolean awP() {
        return (this.cHk == null || this.cHk.awL() == null || this.cHk.awL().getBitmap() == null || this.cHk.awL().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(Canvas canvas) {
        if (this.cHp != 1 || this.cHo == null) {
            if (this.cHk != null) {
                this.cHk.awH();
                if (awP()) {
                    canvas.drawBitmap(this.cHk.awL().getBitmap(), this.cHs, null);
                }
                a(this.cHk, false);
                awS();
                canvas.save();
                float awD = (1.0f * this.cHk.awD()) / this.cHk.awK();
                canvas.scale(awD, awD);
                List<com.baidu.tbadk.widget.largeImage.a.a> awJ = this.cHk.awJ();
                if (awJ != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : awJ) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.awz(), aVar.awA(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float awQ() {
        return this.cCn;
    }

    public float getMinScaleValue() {
        if (this.cCn < 1.0f) {
            return this.cCn;
        }
        return 1.0f;
    }

    public float awR() {
        return 2.0f * this.cCn;
    }

    public void release() {
        if (this.cHv != null) {
            this.cHv.cancel();
        }
        if (this.cHy != null) {
            this.cHy.cancel();
        }
        if (this.cHr != null) {
            this.cHr.onDestory();
        }
        if (this.cHk != null && this.cHk.awJ() != null) {
            this.cHk.awJ().clear();
        }
        if (this.cHt != null) {
            this.cHt.recycle();
            this.cHt = null;
        }
        if (this.cHj != null) {
            this.cHj.recycle();
        }
    }

    private void awS() {
        List<com.baidu.tbadk.widget.largeImage.a.a> awJ = this.cHk.awJ();
        if (awJ != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : awJ) {
                a(aVar, this.cHk);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.cHu = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.awB().arW() == 0 && aVar.awB().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.awH());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int awD = aVar.awB().awD();
        aVar.n((i - rect.left) / awD, (i3 - rect.top) / awD, (i2 - rect.left) / awD, (i4 - rect.top) / awD);
        aVar.m((i - rect2.left) / awD, (i3 - rect2.top) / awD, (i2 - rect2.left) / awD, (i4 - rect2.top) / awD);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.awF(), bVar.awD(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.cHr == null) {
            this.cHr = new com.baidu.tbadk.widget.largeImage.b.c(this.cHk, this.cHj);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> awJ = this.cHk.awJ();
            awJ.clear();
            i2 = i3;
            z2 = true;
            list = awJ;
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
            this.cHr.awZ();
        }
    }

    public void awT() {
        if (this.cHp != 1) {
            a(this.cHk, true);
        }
    }

    private void x(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.cHr.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a y(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0261a c0261a = new a.C0261a(i, i2, i3);
        if (this.cHr.axa() != null && (aVar = this.cHr.axa().get(c0261a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.cHr.axa().remove(c0261a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void apH() {
        this.cHh.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0262b extends GestureDetector.SimpleOnGestureListener {
        private C0262b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.cHx = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.cHn == b.this.cCo ? b.this.cCn : b.this.cCo, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect awH = b.this.cHk.awH();
            Rect awE = b.this.cHk.awE();
            float f3 = awH.right - awE.right;
            float f4 = awH.left - awE.left;
            float f5 = awH.bottom - awE.bottom;
            float f6 = awH.top - awE.top;
            b.this.cHq.forceFinished(true);
            b.this.cHq.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.cHh.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.cHx = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.cHx || b.this.cnF == null) {
                b.this.cHx = false;
            } else {
                b.this.cnF.onLongClick(b.this.cHh);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.cHx || b.this.mClickListener == null) {
                b.this.cHx = false;
            } else {
                b.this.mClickListener.onClick(b.this.cHh);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.cHv != null) {
            this.cHv.cancel();
        }
        this.cHv = ValueAnimator.ofFloat(this.cHn, f);
        this.cHv.setDuration(i);
        this.cHv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.cHn, f2, f3);
                }
            }
        });
        this.cHv.start();
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
        if (this.cHn * f < this.cHm) {
            f = this.cHm / this.cHn;
        }
        if (this.cHn * f > this.cCo) {
            f = this.cCo / this.cHn;
        }
        Rect awH = this.cHk.awH();
        float f4 = ((awH.left + awH.right) * 1.0f) / 2.0f;
        float f5 = ((awH.bottom + awH.top) * 1.0f) / 2.0f;
        if (this.cHk != null) {
            this.cHs.postScale(f, f, this.cHk.getRealWidth() / 2, this.cHk.awI() / 2);
            this.cHk.b(1.0f / f, f4, f5);
            this.cHn *= f;
            this.cHk.ar(1.0f / this.cHn);
            float[] awU = awU();
            this.cHs.postTranslate(-awU[0], -awU[1]);
            this.cHk.u((awU[0] * 1.0f) / this.cHn, (awU[1] * 1.0f) / this.cHn);
            awT();
            this.cHh.invalidate();
        }
    }

    public boolean avE() {
        Rect awH;
        return (this.cHk == null || (awH = this.cHk.awH()) == null || awH.top > 10) ? false : true;
    }

    private float[] awU() {
        Rect awH = this.cHk.awH();
        int[] afo = this.cHl.afo();
        float[] fArr = {(afo[0] / 2) - (((awH.left + awH.right) * 1.0f) / 2.0f)};
        if (awH.top < 0) {
            fArr[1] = 0 - awH.top;
        }
        if (awH.bottom > afo[1]) {
            fArr[1] = afo[1] - awH.bottom;
        }
        if (awH.bottom - awH.top > afo[1]) {
            fArr[1] = (afo[1] / 2) - (((awH.bottom + awH.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.cHn;
        fArr[1] = fArr[1] * this.cHn;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awV() {
        if (this.cHk != null) {
            this.cHk.as(1.0f / this.cCn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.awI() * 1.0f) / bitmap.getHeight());
        this.cHs.postScale(max, max);
        this.cHm = max * (1.0f / i);
        this.cCn = this.cHm;
        this.cHn = this.cCn;
        this.cCo = 2.0f * this.cHn;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.cHj.getWidth();
        if (realWidth > 1.0f) {
            this.cHm /= realWidth;
        }
        bVar.ar(1.0f / this.cHn);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int cHC;
        int cHD;

        public a(Context context) {
            super(context);
            this.cHC = 0;
            this.cHD = 0;
        }

        public void le(int i) {
            this.cHC = i;
        }

        public void lf(int i) {
            this.cHD = i;
        }

        public int awW() {
            return this.cHC;
        }

        public int awX() {
            return this.cHD;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.cHC = 0;
            this.cHD = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

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
    private final View cHg;
    private ScaleGestureDetector cHh;
    private BitmapRegionDecoder cHi;
    private com.baidu.tbadk.widget.largeImage.a.b cHj;
    private com.baidu.tbadk.widget.largeImage.b.a cHk;
    private float cHl;
    private float cHm;
    private Bitmap cHn;
    private int cHo;
    private a cHp;
    private com.baidu.tbadk.widget.largeImage.b.c cHq;
    private com.baidu.tbadk.widget.largeImage.logic.a cHt;
    private ValueAnimator cHu;
    private View.OnLongClickListener cnE;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float cCn = 2.0f;
    private float cCm = 1.0f;
    private final Matrix cHr = new Matrix();
    Bitmap cHs = null;
    private boolean cHv = true;
    private boolean cHw = false;
    BdAsyncTask<String, String, String> cHx = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.cHj != null && b.this.cHi != null) {
                int[] afo = b.this.cHk.afo();
                int i = 1;
                while (Math.max(afo[0] / b.this.cHj.getRealWidth(), afo[1] / b.this.cHj.awI()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, afo[0], afo[1]);
                try {
                    b.this.cHs = b.this.cHi.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.cHs = b.this.cHi.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.cHs = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.asp().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.cHs, false));
                b.this.a(b.this.cHs, b.this.cHj, pow);
                b.this.cHj.r(b.this.cHs);
                b.this.awV();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.cHt != null) {
                b.this.cHt.apH();
            }
            b.this.awT();
            b.this.cHg.invalidate();
        }
    };

    public b(View view) {
        this.cHo = 1;
        this.cHg = view;
        this.mContext = this.cHg.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0262b());
        this.cHh = new ScaleGestureDetector(this.mContext, new c());
        this.cHp = new a(this.mContext);
        this.cHo = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.cHo == 2 && awP()) {
            switch (action) {
                case 0:
                    if (!this.cHp.isFinished()) {
                        this.cHw = true;
                    } else {
                        this.cHw = false;
                    }
                case 1:
                case 3:
                    avF();
                    break;
            }
            this.cHp.forceFinished(true);
            this.cHh.onTouchEvent(motionEvent);
            if (this.cHh.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean awM() {
        return Math.floor((double) (this.cCm * 10000.0f)) == Math.floor((double) (this.cHm * 10000.0f));
    }

    public void avF() {
        if (this.cHm / this.cCm < 1.0f) {
            a(this.cCm, 0.0f, 0.0f, 400);
        }
    }

    public boolean awN() {
        if (this.cHo == 1) {
            return false;
        }
        if (this.cHp.computeScrollOffset()) {
            int currX = this.cHp.getCurrX();
            int currY = this.cHp.getCurrY();
            float awW = (currX - this.cHp.awW()) * 2.0f;
            float awX = (currY - this.cHp.awX()) * 2.0f;
            int ah = l.ah(TbadkCoreApplication.getInst());
            if (awX >= 0.0f && Math.abs(awX) <= 20.0f && currX < ah) {
                moveTo(0.0f, -20.0f);
                this.cHg.invalidate();
                return true;
            }
            this.cHp.le(currX);
            this.cHp.lf(currY);
            moveTo(-awW, -awX);
            this.cHg.invalidate();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.cHj != null) {
            float[] v = v(f, f2);
            float f3 = v[0];
            float f4 = v[1];
            this.cHr.postTranslate(-f3, -f4);
            this.cHj.u((f3 * 1.0f) / this.cHm, (f4 * 1.0f) / this.cHm);
            awT();
            this.cHg.invalidate();
        }
    }

    private float[] v(float f, float f2) {
        float[] fArr = new float[2];
        Rect awH = this.cHj.awH();
        int[] afo = this.cHk.afo();
        if (awH.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (awH.bottom + f2 > afo[1]) {
            f2 = (afo[1] - awH.bottom) * this.cHm;
        }
        if (awH.bottom - awH.top > afo[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.cHv = f2 == 0.0f;
        return fArr;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.cHk == null) {
            this.cHn = bitmap;
            this.cHk = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.cHi = this.cHk.H(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.cHi = this.cHk.H(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.cHo = 2;
            awO();
        }
    }

    public void awO() {
        if (this.cHo == 2 && this.cHk != null && this.cHx.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.cHj == null && this.cHg.getMeasuredWidth() > 0 && this.cHg.getMeasuredHeight() > 0 && this.cHk.afo()[0] > 0 && this.cHk.afo()[1] > 0) {
            this.cHj = new com.baidu.tbadk.widget.largeImage.a.b(this.cHg.getMeasuredWidth(), this.cHg.getMeasuredHeight(), this.cHk.afo());
            this.cHx.setPriority(3);
            this.cHx.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnE = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !awP()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.cHg.getWidth() - this.cHg.getPaddingLeft()) - this.cHg.getPaddingRight();
            int height2 = (this.cHg.getHeight() - this.cHg.getPaddingTop()) - this.cHg.getPaddingBottom();
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
        return (this.cHj == null || this.cHj.awL() == null || this.cHj.awL().getBitmap() == null || this.cHj.awL().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(Canvas canvas) {
        if (this.cHo != 1 || this.cHn == null) {
            if (this.cHj != null) {
                this.cHj.awH();
                if (awP()) {
                    canvas.drawBitmap(this.cHj.awL().getBitmap(), this.cHr, null);
                }
                a(this.cHj, false);
                awS();
                canvas.save();
                float awD = (1.0f * this.cHj.awD()) / this.cHj.awK();
                canvas.scale(awD, awD);
                List<com.baidu.tbadk.widget.largeImage.a.a> awJ = this.cHj.awJ();
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
        return this.cCm;
    }

    public float getMinScaleValue() {
        if (this.cCm < 1.0f) {
            return this.cCm;
        }
        return 1.0f;
    }

    public float awR() {
        return 2.0f * this.cCm;
    }

    public void release() {
        if (this.cHu != null) {
            this.cHu.cancel();
        }
        if (this.cHx != null) {
            this.cHx.cancel();
        }
        if (this.cHq != null) {
            this.cHq.onDestory();
        }
        if (this.cHj != null && this.cHj.awJ() != null) {
            this.cHj.awJ().clear();
        }
        if (this.cHs != null) {
            this.cHs.recycle();
            this.cHs = null;
        }
        if (this.cHi != null) {
            this.cHi.recycle();
        }
    }

    private void awS() {
        List<com.baidu.tbadk.widget.largeImage.a.a> awJ = this.cHj.awJ();
        if (awJ != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : awJ) {
                a(aVar, this.cHj);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.cHt = aVar;
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
        if (this.cHq == null) {
            this.cHq = new com.baidu.tbadk.widget.largeImage.b.c(this.cHj, this.cHi);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> awJ = this.cHj.awJ();
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
            this.cHq.awZ();
        }
    }

    public void awT() {
        if (this.cHo != 1) {
            a(this.cHj, true);
        }
    }

    private void x(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.cHq.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a y(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0261a c0261a = new a.C0261a(i, i2, i3);
        if (this.cHq.axa() != null && (aVar = this.cHq.axa().get(c0261a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.cHq.axa().remove(c0261a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void apH() {
        this.cHg.postInvalidate();
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
                b.this.cHw = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.cHm == b.this.cCn ? b.this.cCm : b.this.cCn, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect awH = b.this.cHj.awH();
            Rect awE = b.this.cHj.awE();
            float f3 = awH.right - awE.right;
            float f4 = awH.left - awE.left;
            float f5 = awH.bottom - awE.bottom;
            float f6 = awH.top - awE.top;
            b.this.cHp.forceFinished(true);
            b.this.cHp.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.cHg.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.cHw = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.cHw || b.this.cnE == null) {
                b.this.cHw = false;
            } else {
                b.this.cnE.onLongClick(b.this.cHg);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.cHw || b.this.mClickListener == null) {
                b.this.cHw = false;
            } else {
                b.this.mClickListener.onClick(b.this.cHg);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.cHu != null) {
            this.cHu.cancel();
        }
        this.cHu = ValueAnimator.ofFloat(this.cHm, f);
        this.cHu.setDuration(i);
        this.cHu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.cHm, f2, f3);
                }
            }
        });
        this.cHu.start();
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
        if (this.cHm * f < this.cHl) {
            f = this.cHl / this.cHm;
        }
        if (this.cHm * f > this.cCn) {
            f = this.cCn / this.cHm;
        }
        Rect awH = this.cHj.awH();
        float f4 = ((awH.left + awH.right) * 1.0f) / 2.0f;
        float f5 = ((awH.bottom + awH.top) * 1.0f) / 2.0f;
        if (this.cHj != null) {
            this.cHr.postScale(f, f, this.cHj.getRealWidth() / 2, this.cHj.awI() / 2);
            this.cHj.b(1.0f / f, f4, f5);
            this.cHm *= f;
            this.cHj.ar(1.0f / this.cHm);
            float[] awU = awU();
            this.cHr.postTranslate(-awU[0], -awU[1]);
            this.cHj.u((awU[0] * 1.0f) / this.cHm, (awU[1] * 1.0f) / this.cHm);
            awT();
            this.cHg.invalidate();
        }
    }

    public boolean avE() {
        Rect awH;
        return (this.cHj == null || (awH = this.cHj.awH()) == null || awH.top > 10) ? false : true;
    }

    private float[] awU() {
        Rect awH = this.cHj.awH();
        int[] afo = this.cHk.afo();
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
        fArr[0] = fArr[0] * this.cHm;
        fArr[1] = fArr[1] * this.cHm;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awV() {
        if (this.cHj != null) {
            this.cHj.as(1.0f / this.cCm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.awI() * 1.0f) / bitmap.getHeight());
        this.cHr.postScale(max, max);
        this.cHl = max * (1.0f / i);
        this.cCm = this.cHl;
        this.cHm = this.cCm;
        this.cCn = 2.0f * this.cHm;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.cHi.getWidth();
        if (realWidth > 1.0f) {
            this.cHl /= realWidth;
        }
        bVar.ar(1.0f / this.cHm);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int cHB;
        int cHC;

        public a(Context context) {
            super(context);
            this.cHB = 0;
            this.cHC = 0;
        }

        public void le(int i) {
            this.cHB = i;
        }

        public void lf(int i) {
            this.cHC = i;
        }

        public int awW() {
            return this.cHB;
        }

        public int awX() {
            return this.cHC;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.cHB = 0;
            this.cHC = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

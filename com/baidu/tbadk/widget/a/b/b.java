package com.baidu.tbadk.widget.a.b;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.a.a.a;
import com.baidu.tbadk.widget.a.c.c;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.a.b.a {
    private static final String TAG = b.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    private final View bGa;
    private ScaleGestureDetector bGb;
    private BitmapRegionDecoder bGc;
    private com.baidu.tbadk.widget.a.a.b bGd;
    private com.baidu.tbadk.widget.a.c.a bGe;
    private float bGf;
    private float bGg;
    private int bGh;
    private a bGi;
    private com.baidu.tbadk.widget.a.c.c bGj;
    private com.baidu.tbadk.widget.a.b.a bGm;
    private ValueAnimator bGn;
    private View.OnLongClickListener bnm;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float bBJ = 2.0f;
    private float bBI = 1.0f;
    private final Matrix bGk = new Matrix();
    Bitmap bGl = null;
    private boolean bGo = true;
    private boolean bGp = false;
    BdAsyncTask<String, String, String> bGq = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.bGd != null && b.this.bGc != null) {
                int[] Qf = b.this.bGe.Qf();
                int i = 1;
                while (Math.max(Qf[0] / b.this.bGd.getRealWidth(), Qf[1] / b.this.bGd.PP()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, Qf[0], Qf[1]);
                try {
                    b.this.bGl = b.this.bGc.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bGl = b.this.bGc.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bGl = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.LR().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.bGl, false));
                b.this.a(b.this.bGl, b.this.bGd, pow);
                b.this.bGd.l(b.this.bGl);
                b.this.Qc();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bGm != null) {
                b.this.bGm.Ji();
            }
            b.this.Qa();
            b.this.bGa.invalidate();
        }
    };

    public b(View view) {
        this.bGh = 1;
        this.bGa = view;
        this.mContext = this.bGa.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0094b());
        this.bGb = new ScaleGestureDetector(this.mContext, new c());
        this.bGi = new a(this.mContext);
        this.bGh = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bGh == 2 && PW()) {
            switch (action) {
                case 0:
                    if (!this.bGi.isFinished()) {
                        this.bGp = true;
                    } else {
                        this.bGp = false;
                    }
                case 1:
                case 3:
                    OR();
                    break;
            }
            this.bGi.forceFinished(true);
            this.bGb.onTouchEvent(motionEvent);
            if (this.bGb.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean PT() {
        return Math.floor((double) (this.bBI * 10000.0f)) == Math.floor((double) (this.bGg * 10000.0f));
    }

    public void OR() {
        if (this.bGg / this.bBI < 1.0f) {
            a(this.bBI, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean PU() {
        if (this.bGh == 1) {
            return false;
        }
        if (this.bGi.computeScrollOffset()) {
            int currX = this.bGi.getCurrX();
            this.bGi.iE(currX);
            int currY = this.bGi.getCurrY();
            this.bGi.iF(currY);
            moveTo(-((currX - this.bGi.Qd()) * 2.0f), -((currY - this.bGi.Qe()) * 2.0f));
            this.bGa.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bGe == null) {
            this.mOriginalBitmap = bitmap;
            this.bGe = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.bGc = this.bGe.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bGc = this.bGe.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bGh = 2;
            PV();
        }
    }

    public void PV() {
        if (this.bGh == 2 && this.bGe != null && this.bGq.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bGd == null && this.bGa.getMeasuredWidth() > 0 && this.bGa.getMeasuredHeight() > 0 && this.bGe.Qf()[0] > 0 && this.bGe.Qf()[1] > 0) {
            this.bGd = new com.baidu.tbadk.widget.a.a.b(this.bGa.getMeasuredWidth(), this.bGa.getMeasuredHeight(), this.bGe.Qf());
            this.bGq.setPriority(3);
            this.bGq.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bnm = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !PW()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bGa.getWidth() - this.bGa.getPaddingLeft()) - this.bGa.getPaddingRight();
            int height2 = (this.bGa.getHeight() - this.bGa.getPaddingTop()) - this.bGa.getPaddingBottom();
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
        return k(canvas);
    }

    private boolean PW() {
        return (this.bGd == null || this.bGd.PS() == null || this.bGd.PS().getBitmap() == null || this.bGd.PS().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean k(Canvas canvas) {
        if (this.bGh != 1 || this.mOriginalBitmap == null) {
            if (this.bGd != null) {
                this.bGd.PO();
                if (PW()) {
                    canvas.drawBitmap(this.bGd.PS().getBitmap(), this.bGk, null);
                }
                a(this.bGd, false);
                PZ();
                canvas.save();
                float PK = (1.0f * this.bGd.PK()) / this.bGd.PR();
                canvas.scale(PK, PK);
                List<com.baidu.tbadk.widget.a.a.a> PQ = this.bGd.PQ();
                if (PQ != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : PQ) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.PG(), aVar.PH(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float PX() {
        return this.bBI;
    }

    public float getMinScaleValue() {
        if (this.bBI < 1.0f) {
            return this.bBI;
        }
        return 1.0f;
    }

    public float PY() {
        return 2.0f * this.bBI;
    }

    public void release() {
        if (this.bGn != null) {
            this.bGn.cancel();
        }
        if (this.bGq != null) {
            this.bGq.cancel();
        }
        if (this.bGj != null) {
            this.bGj.onDestory();
        }
        if (this.bGd != null && this.bGd.PQ() != null) {
            this.bGd.PQ().clear();
        }
        if (this.bGl != null) {
            this.bGl.recycle();
            this.bGl = null;
        }
        if (this.bGc != null) {
            this.bGc.recycle();
        }
    }

    private void PZ() {
        List<com.baidu.tbadk.widget.a.a.a> PQ = this.bGd.PQ();
        if (PQ != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : PQ) {
                a(aVar, this.bGd);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.bGm = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.PI().Ly() == 0 && aVar.PI().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.PO());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int PK = aVar.PI().PK();
        aVar.s((i - rect.left) / PK, (i3 - rect.top) / PK, (i2 - rect.left) / PK, (i4 - rect.top) / PK);
        aVar.r((i - rect2.left) / PK, (i3 - rect2.top) / PK, (i2 - rect2.left) / PK, (i4 - rect2.top) / PK);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.PM(), bVar.PK(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.bGj == null) {
            this.bGj = new com.baidu.tbadk.widget.a.c.c(this.bGd, this.bGc);
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
            List<com.baidu.tbadk.widget.a.a.a> PQ = this.bGd.PQ();
            PQ.clear();
            i2 = i3;
            z2 = true;
            list = PQ;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                com.baidu.tbadk.widget.a.a.a C = C(i2, i7, i);
                if (C == null) {
                    if (z) {
                        B(i2, i7, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(C);
                }
            }
            i2++;
        }
        if (z2) {
            this.bGj.Qh();
        }
    }

    public void Qa() {
        if (this.bGh != 1) {
            a(this.bGd, true);
        }
    }

    private void B(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bGj.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a C(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0093a c0093a = new a.C0093a(i, i2, i3);
        if (this.bGj.Qi() != null && (aVar = this.bGj.Qi().get(c0093a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bGj.Qi().remove(c0093a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void Ji() {
        this.bGa.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0094b extends GestureDetector.SimpleOnGestureListener {
        private C0094b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bGp = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bGg == b.this.bBJ ? b.this.bBI : b.this.bBJ, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect PO = b.this.bGd.PO();
            Rect PL = b.this.bGd.PL();
            float f3 = PO.right - PL.right;
            float f4 = PO.left - PL.left;
            float f5 = PO.bottom - PL.bottom;
            float f6 = PO.top - PL.top;
            b.this.bGi.forceFinished(true);
            b.this.bGi.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bGa.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bGp = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bGp || b.this.bnm == null) {
                b.this.bGp = false;
            } else {
                b.this.bnm.onLongClick(b.this.bGa);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bGp || b.this.mClickListener == null) {
                b.this.bGp = false;
            } else {
                b.this.mClickListener.onClick(b.this.bGa);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bGn != null) {
            this.bGn.cancel();
        }
        this.bGn = ValueAnimator.ofFloat(this.bGg, f);
        this.bGn.setDuration(i);
        this.bGn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.f(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bGg, f2, f3);
                }
            }
        });
        this.bGn.start();
    }

    /* loaded from: classes.dex */
    private class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            b.this.f(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }
    }

    public void f(float f, float f2, float f3) {
        if (this.bGg * f < this.bGf) {
            f = this.bGf / this.bGg;
        }
        if (this.bGg * f > this.bBJ) {
            f = this.bBJ / this.bGg;
        }
        Rect PO = this.bGd.PO();
        float f4 = ((PO.left + PO.right) * 1.0f) / 2.0f;
        float f5 = ((PO.bottom + PO.top) * 1.0f) / 2.0f;
        if (this.bGd != null) {
            this.bGk.postScale(f, f, this.bGd.getRealWidth() / 2, this.bGd.PP() / 2);
            this.bGd.e(1.0f / f, f4, f5);
            this.bGg *= f;
            this.bGd.W(1.0f / this.bGg);
            float[] Qb = Qb();
            this.bGk.postTranslate(-Qb[0], -Qb[1]);
            this.bGd.o((Qb[0] * 1.0f) / this.bGg, (Qb[1] * 1.0f) / this.bGg);
            Qa();
            this.bGa.invalidate();
        }
    }

    public boolean OQ() {
        Rect PO;
        return (this.bGd == null || (PO = this.bGd.PO()) == null || PO.top > 10) ? false : true;
    }

    private float[] Qb() {
        Rect PO = this.bGd.PO();
        int[] Qf = this.bGe.Qf();
        float[] fArr = {(Qf[0] / 2) - (((PO.left + PO.right) * 1.0f) / 2.0f)};
        if (PO.top < 0) {
            fArr[1] = 0 - PO.top;
        }
        if (PO.bottom > Qf[1]) {
            fArr[1] = Qf[1] - PO.bottom;
        }
        if (PO.bottom - PO.top > Qf[1]) {
            fArr[1] = (Qf[1] / 2) - (((PO.bottom + PO.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bGg;
        fArr[1] = fArr[1] * this.bGg;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bGd != null) {
            float[] p = p(f, f2);
            this.bGk.postTranslate(-p[0], -p[1]);
            this.bGd.o((p[0] * 1.0f) / this.bGg, (p[1] * 1.0f) / this.bGg);
            Qa();
            this.bGa.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect PO = this.bGd.PO();
        int[] Qf = this.bGe.Qf();
        if (PO.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (PO.bottom + f2 > Qf[1]) {
            f2 = (Qf[1] - PO.bottom) * this.bGg;
        }
        if (PO.bottom - PO.top > Qf[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bGo = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qc() {
        if (this.bGd != null) {
            this.bGd.X(1.0f / this.bBI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.PP() * 1.0f) / bitmap.getHeight());
        this.bGk.postScale(max, max);
        this.bGf = max * (1.0f / i);
        this.bBI = this.bGf;
        this.bGg = this.bBI;
        this.bBJ = 2.0f * this.bGg;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bGc.getWidth();
        if (realWidth > 1.0f) {
            this.bGf /= realWidth;
        }
        bVar.W(1.0f / this.bGg);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bGu;
        int bGv;

        public a(Context context) {
            super(context);
            this.bGu = 0;
            this.bGv = 0;
        }

        public void iE(int i) {
            this.bGu = i;
        }

        public void iF(int i) {
            this.bGv = i;
        }

        public int Qd() {
            return this.bGu;
        }

        public int Qe() {
            return this.bGv;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bGu = 0;
            this.bGv = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

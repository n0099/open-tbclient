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
    private final View bFK;
    private ScaleGestureDetector bFL;
    private BitmapRegionDecoder bFM;
    private com.baidu.tbadk.widget.a.a.b bFN;
    private com.baidu.tbadk.widget.a.c.a bFO;
    private float bFP;
    private float bFQ;
    private int bFR;
    private a bFS;
    private com.baidu.tbadk.widget.a.c.c bFT;
    private com.baidu.tbadk.widget.a.b.a bFW;
    private ValueAnimator bFX;
    private View.OnLongClickListener bmU;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float bBs = 2.0f;
    private float bBr = 1.0f;
    private final Matrix bFU = new Matrix();
    Bitmap bFV = null;
    private boolean bFY = true;
    private boolean bFZ = false;
    BdAsyncTask<String, String, String> bGa = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.bFN != null && b.this.bFM != null) {
                int[] Qp = b.this.bFO.Qp();
                int i = 1;
                while (Math.max(Qp[0] / b.this.bFN.getRealWidth(), Qp[1] / b.this.bFN.PZ()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, Qp[0], Qp[1]);
                try {
                    b.this.bFV = b.this.bFM.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bFV = b.this.bFM.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bFV = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Mb().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.bFV, false));
                b.this.a(b.this.bFV, b.this.bFN, pow);
                b.this.bFN.l(b.this.bFV);
                b.this.Qm();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bFW != null) {
                b.this.bFW.Jr();
            }
            b.this.Qk();
            b.this.bFK.invalidate();
        }
    };

    public b(View view) {
        this.bFR = 1;
        this.bFK = view;
        this.mContext = this.bFK.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0094b());
        this.bFL = new ScaleGestureDetector(this.mContext, new c());
        this.bFS = new a(this.mContext);
        this.bFR = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bFR == 2 && Qg()) {
            switch (action) {
                case 0:
                    if (!this.bFS.isFinished()) {
                        this.bFZ = true;
                    } else {
                        this.bFZ = false;
                    }
                case 1:
                case 3:
                    Pb();
                    break;
            }
            this.bFS.forceFinished(true);
            this.bFL.onTouchEvent(motionEvent);
            if (this.bFL.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Qd() {
        return Math.floor((double) (this.bBr * 10000.0f)) == Math.floor((double) (this.bFQ * 10000.0f));
    }

    public void Pb() {
        if (this.bFQ / this.bBr < 1.0f) {
            a(this.bBr, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean Qe() {
        if (this.bFR == 1) {
            return false;
        }
        if (this.bFS.computeScrollOffset()) {
            int currX = this.bFS.getCurrX();
            this.bFS.iI(currX);
            int currY = this.bFS.getCurrY();
            this.bFS.iJ(currY);
            moveTo(-((currX - this.bFS.Qn()) * 2.0f), -((currY - this.bFS.Qo()) * 2.0f));
            this.bFK.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bFO == null) {
            this.mOriginalBitmap = bitmap;
            this.bFO = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.bFM = this.bFO.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bFM = this.bFO.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bFR = 2;
            Qf();
        }
    }

    public void Qf() {
        if (this.bFR == 2 && this.bFO != null && this.bGa.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bFN == null && this.bFK.getMeasuredWidth() > 0 && this.bFK.getMeasuredHeight() > 0 && this.bFO.Qp()[0] > 0 && this.bFO.Qp()[1] > 0) {
            this.bFN = new com.baidu.tbadk.widget.a.a.b(this.bFK.getMeasuredWidth(), this.bFK.getMeasuredHeight(), this.bFO.Qp());
            this.bGa.setPriority(3);
            this.bGa.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmU = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !Qg()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bFK.getWidth() - this.bFK.getPaddingLeft()) - this.bFK.getPaddingRight();
            int height2 = (this.bFK.getHeight() - this.bFK.getPaddingTop()) - this.bFK.getPaddingBottom();
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

    private boolean Qg() {
        return (this.bFN == null || this.bFN.Qc() == null || this.bFN.Qc().getBitmap() == null || this.bFN.Qc().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean k(Canvas canvas) {
        if (this.bFR != 1 || this.mOriginalBitmap == null) {
            if (this.bFN != null) {
                this.bFN.PY();
                if (Qg()) {
                    canvas.drawBitmap(this.bFN.Qc().getBitmap(), this.bFU, null);
                }
                a(this.bFN, false);
                Qj();
                canvas.save();
                float PU = (1.0f * this.bFN.PU()) / this.bFN.Qb();
                canvas.scale(PU, PU);
                List<com.baidu.tbadk.widget.a.a.a> Qa = this.bFN.Qa();
                if (Qa != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : Qa) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.PQ(), aVar.PR(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float Qh() {
        return this.bBr;
    }

    public float getMinScaleValue() {
        if (this.bBr < 1.0f) {
            return this.bBr;
        }
        return 1.0f;
    }

    public float Qi() {
        return 2.0f * this.bBr;
    }

    public void release() {
        if (this.bFX != null) {
            this.bFX.cancel();
        }
        if (this.bGa != null) {
            this.bGa.cancel();
        }
        if (this.bFT != null) {
            this.bFT.onDestory();
        }
        if (this.bFN != null && this.bFN.Qa() != null) {
            this.bFN.Qa().clear();
        }
        if (this.bFV != null) {
            this.bFV.recycle();
            this.bFV = null;
        }
        if (this.bFM != null) {
            this.bFM.recycle();
        }
    }

    private void Qj() {
        List<com.baidu.tbadk.widget.a.a.a> Qa = this.bFN.Qa();
        if (Qa != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : Qa) {
                a(aVar, this.bFN);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.bFW = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.PS().LI() == 0 && aVar.PS().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.PY());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int PU = aVar.PS().PU();
        aVar.s((i - rect.left) / PU, (i3 - rect.top) / PU, (i2 - rect.left) / PU, (i4 - rect.top) / PU);
        aVar.r((i - rect2.left) / PU, (i3 - rect2.top) / PU, (i2 - rect2.left) / PU, (i4 - rect2.top) / PU);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.PW(), bVar.PU(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.bFT == null) {
            this.bFT = new com.baidu.tbadk.widget.a.c.c(this.bFN, this.bFM);
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
            List<com.baidu.tbadk.widget.a.a.a> Qa = this.bFN.Qa();
            Qa.clear();
            i2 = i3;
            z2 = true;
            list = Qa;
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
            this.bFT.Qr();
        }
    }

    public void Qk() {
        if (this.bFR != 1) {
            a(this.bFN, true);
        }
    }

    private void B(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bFT.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a C(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0093a c0093a = new a.C0093a(i, i2, i3);
        if (this.bFT.Qs() != null && (aVar = this.bFT.Qs().get(c0093a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bFT.Qs().remove(c0093a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void Jr() {
        this.bFK.postInvalidate();
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
                b.this.bFZ = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bFQ == b.this.bBs ? b.this.bBr : b.this.bBs, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect PY = b.this.bFN.PY();
            Rect PV = b.this.bFN.PV();
            float f3 = PY.right - PV.right;
            float f4 = PY.left - PV.left;
            float f5 = PY.bottom - PV.bottom;
            float f6 = PY.top - PV.top;
            b.this.bFS.forceFinished(true);
            b.this.bFS.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bFK.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bFZ = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bFZ || b.this.bmU == null) {
                b.this.bFZ = false;
            } else {
                b.this.bmU.onLongClick(b.this.bFK);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bFZ || b.this.mClickListener == null) {
                b.this.bFZ = false;
            } else {
                b.this.mClickListener.onClick(b.this.bFK);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bFX != null) {
            this.bFX.cancel();
        }
        this.bFX = ValueAnimator.ofFloat(this.bFQ, f);
        this.bFX.setDuration(i);
        this.bFX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.f(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bFQ, f2, f3);
                }
            }
        });
        this.bFX.start();
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
        if (this.bFQ * f < this.bFP) {
            f = this.bFP / this.bFQ;
        }
        if (this.bFQ * f > this.bBs) {
            f = this.bBs / this.bFQ;
        }
        Rect PY = this.bFN.PY();
        float f4 = ((PY.left + PY.right) * 1.0f) / 2.0f;
        float f5 = ((PY.bottom + PY.top) * 1.0f) / 2.0f;
        if (this.bFN != null) {
            this.bFU.postScale(f, f, this.bFN.getRealWidth() / 2, this.bFN.PZ() / 2);
            this.bFN.e(1.0f / f, f4, f5);
            this.bFQ *= f;
            this.bFN.W(1.0f / this.bFQ);
            float[] Ql = Ql();
            this.bFU.postTranslate(-Ql[0], -Ql[1]);
            this.bFN.o((Ql[0] * 1.0f) / this.bFQ, (Ql[1] * 1.0f) / this.bFQ);
            Qk();
            this.bFK.invalidate();
        }
    }

    public boolean Pa() {
        Rect PY;
        return (this.bFN == null || (PY = this.bFN.PY()) == null || PY.top > 10) ? false : true;
    }

    private float[] Ql() {
        Rect PY = this.bFN.PY();
        int[] Qp = this.bFO.Qp();
        float[] fArr = {(Qp[0] / 2) - (((PY.left + PY.right) * 1.0f) / 2.0f)};
        if (PY.top < 0) {
            fArr[1] = 0 - PY.top;
        }
        if (PY.bottom > Qp[1]) {
            fArr[1] = Qp[1] - PY.bottom;
        }
        if (PY.bottom - PY.top > Qp[1]) {
            fArr[1] = (Qp[1] / 2) - (((PY.bottom + PY.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bFQ;
        fArr[1] = fArr[1] * this.bFQ;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bFN != null) {
            float[] p = p(f, f2);
            this.bFU.postTranslate(-p[0], -p[1]);
            this.bFN.o((p[0] * 1.0f) / this.bFQ, (p[1] * 1.0f) / this.bFQ);
            Qk();
            this.bFK.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect PY = this.bFN.PY();
        int[] Qp = this.bFO.Qp();
        if (PY.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (PY.bottom + f2 > Qp[1]) {
            f2 = (Qp[1] - PY.bottom) * this.bFQ;
        }
        if (PY.bottom - PY.top > Qp[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bFY = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qm() {
        if (this.bFN != null) {
            this.bFN.X(1.0f / this.bBr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.PZ() * 1.0f) / bitmap.getHeight());
        this.bFU.postScale(max, max);
        this.bFP = max * (1.0f / i);
        this.bBr = this.bFP;
        this.bFQ = this.bBr;
        this.bBs = 2.0f * this.bFQ;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bFM.getWidth();
        if (realWidth > 1.0f) {
            this.bFP /= realWidth;
        }
        bVar.W(1.0f / this.bFQ);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bGe;
        int bGf;

        public a(Context context) {
            super(context);
            this.bGe = 0;
            this.bGf = 0;
        }

        public void iI(int i) {
            this.bGe = i;
        }

        public void iJ(int i) {
            this.bGf = i;
        }

        public int Qn() {
            return this.bGe;
        }

        public int Qo() {
            return this.bGf;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bGe = 0;
            this.bGf = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

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
    private final View bHU;
    private ScaleGestureDetector bHV;
    private BitmapRegionDecoder bHW;
    private com.baidu.tbadk.widget.a.a.b bHX;
    private com.baidu.tbadk.widget.a.c.a bHY;
    private float bHZ;
    private float bIa;
    private int bIb;
    private a bIc;
    private com.baidu.tbadk.widget.a.c.c bId;
    private com.baidu.tbadk.widget.a.b.a bIg;
    private ValueAnimator bIh;
    private View.OnLongClickListener bpq;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float bDD = 2.0f;
    private float bDC = 1.0f;
    private final Matrix bIe = new Matrix();
    Bitmap bIf = null;
    private boolean bIi = true;
    private boolean bIj = false;
    BdAsyncTask<String, String, String> bIk = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.bHX != null && b.this.bHW != null) {
                int[] QK = b.this.bHY.QK();
                int i = 1;
                while (Math.max(QK[0] / b.this.bHX.getRealWidth(), QK[1] / b.this.bHX.Qu()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, QK[0], QK[1]);
                try {
                    b.this.bIf = b.this.bHW.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bIf = b.this.bHW.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bIf = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Mx().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.bIf, false));
                b.this.a(b.this.bIf, b.this.bHX, pow);
                b.this.bHX.n(b.this.bIf);
                b.this.QH();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bIg != null) {
                b.this.bIg.JP();
            }
            b.this.QF();
            b.this.bHU.invalidate();
        }
    };

    public b(View view) {
        this.bIb = 1;
        this.bHU = view;
        this.mContext = this.bHU.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0118b());
        this.bHV = new ScaleGestureDetector(this.mContext, new c());
        this.bIc = new a(this.mContext);
        this.bIb = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bIb == 2 && QB()) {
            switch (action) {
                case 0:
                    if (!this.bIc.isFinished()) {
                        this.bIj = true;
                    } else {
                        this.bIj = false;
                    }
                case 1:
                case 3:
                    Pw();
                    break;
            }
            this.bIc.forceFinished(true);
            this.bHV.onTouchEvent(motionEvent);
            if (this.bHV.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Qy() {
        return Math.floor((double) (this.bDC * 10000.0f)) == Math.floor((double) (this.bIa * 10000.0f));
    }

    public void Pw() {
        if (this.bIa / this.bDC < 1.0f) {
            a(this.bDC, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean Qz() {
        if (this.bIb == 1) {
            return false;
        }
        if (this.bIc.computeScrollOffset()) {
            int currX = this.bIc.getCurrX();
            this.bIc.iB(currX);
            int currY = this.bIc.getCurrY();
            this.bIc.iC(currY);
            moveTo(-((currX - this.bIc.QI()) * 2.0f), -((currY - this.bIc.QJ()) * 2.0f));
            this.bHU.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bHY == null) {
            this.mOriginalBitmap = bitmap;
            this.bHY = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.bHW = this.bHY.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bHW = this.bHY.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bIb = 2;
            QA();
        }
    }

    public void QA() {
        if (this.bIb == 2 && this.bHY != null && this.bIk.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bHX == null && this.bHU.getMeasuredWidth() > 0 && this.bHU.getMeasuredHeight() > 0 && this.bHY.QK()[0] > 0 && this.bHY.QK()[1] > 0) {
            this.bHX = new com.baidu.tbadk.widget.a.a.b(this.bHU.getMeasuredWidth(), this.bHU.getMeasuredHeight(), this.bHY.QK());
            this.bIk.setPriority(3);
            this.bIk.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bpq = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !QB()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bHU.getWidth() - this.bHU.getPaddingLeft()) - this.bHU.getPaddingRight();
            int height2 = (this.bHU.getHeight() - this.bHU.getPaddingTop()) - this.bHU.getPaddingBottom();
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

    private boolean QB() {
        return (this.bHX == null || this.bHX.Qx() == null || this.bHX.Qx().getBitmap() == null || this.bHX.Qx().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean k(Canvas canvas) {
        if (this.bIb != 1 || this.mOriginalBitmap == null) {
            if (this.bHX != null) {
                this.bHX.Qt();
                if (QB()) {
                    canvas.drawBitmap(this.bHX.Qx().getBitmap(), this.bIe, null);
                }
                a(this.bHX, false);
                QE();
                canvas.save();
                float Qp = (1.0f * this.bHX.Qp()) / this.bHX.Qw();
                canvas.scale(Qp, Qp);
                List<com.baidu.tbadk.widget.a.a.a> Qv = this.bHX.Qv();
                if (Qv != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : Qv) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.Ql(), aVar.Qm(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float QC() {
        return this.bDC;
    }

    public float getMinScaleValue() {
        if (this.bDC < 1.0f) {
            return this.bDC;
        }
        return 1.0f;
    }

    public float QD() {
        return 2.0f * this.bDC;
    }

    public void release() {
        if (this.bIh != null) {
            this.bIh.cancel();
        }
        if (this.bIk != null) {
            this.bIk.cancel();
        }
        if (this.bId != null) {
            this.bId.onDestory();
        }
        if (this.bHX != null && this.bHX.Qv() != null) {
            this.bHX.Qv().clear();
        }
        if (this.bIf != null) {
            this.bIf.recycle();
            this.bIf = null;
        }
        if (this.bHW != null) {
            this.bHW.recycle();
        }
    }

    private void QE() {
        List<com.baidu.tbadk.widget.a.a.a> Qv = this.bHX.Qv();
        if (Qv != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : Qv) {
                a(aVar, this.bHX);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.bIg = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.Qn().Me() == 0 && aVar.Qn().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.Qt());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int Qp = aVar.Qn().Qp();
        aVar.s((i - rect.left) / Qp, (i3 - rect.top) / Qp, (i2 - rect.left) / Qp, (i4 - rect.top) / Qp);
        aVar.r((i - rect2.left) / Qp, (i3 - rect2.top) / Qp, (i2 - rect2.left) / Qp, (i4 - rect2.top) / Qp);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.Qr(), bVar.Qp(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.bId == null) {
            this.bId = new com.baidu.tbadk.widget.a.c.c(this.bHX, this.bHW);
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
            List<com.baidu.tbadk.widget.a.a.a> Qv = this.bHX.Qv();
            Qv.clear();
            i2 = i3;
            z2 = true;
            list = Qv;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                com.baidu.tbadk.widget.a.a.a D = D(i2, i7, i);
                if (D == null) {
                    if (z) {
                        C(i2, i7, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(D);
                }
            }
            i2++;
        }
        if (z2) {
            this.bId.QM();
        }
    }

    public void QF() {
        if (this.bIb != 1) {
            a(this.bHX, true);
        }
    }

    private void C(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bId.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a D(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0117a c0117a = new a.C0117a(i, i2, i3);
        if (this.bId.QN() != null && (aVar = this.bId.QN().get(c0117a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bId.QN().remove(c0117a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void JP() {
        this.bHU.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0118b extends GestureDetector.SimpleOnGestureListener {
        private C0118b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bIj = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bIa == b.this.bDD ? b.this.bDC : b.this.bDD, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Qt = b.this.bHX.Qt();
            Rect Qq = b.this.bHX.Qq();
            float f3 = Qt.right - Qq.right;
            float f4 = Qt.left - Qq.left;
            float f5 = Qt.bottom - Qq.bottom;
            float f6 = Qt.top - Qq.top;
            b.this.bIc.forceFinished(true);
            b.this.bIc.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bHU.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bIj = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bIj || b.this.bpq == null) {
                b.this.bIj = false;
            } else {
                b.this.bpq.onLongClick(b.this.bHU);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bIj || b.this.mClickListener == null) {
                b.this.bIj = false;
            } else {
                b.this.mClickListener.onClick(b.this.bHU);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bIh != null) {
            this.bIh.cancel();
        }
        this.bIh = ValueAnimator.ofFloat(this.bIa, f);
        this.bIh.setDuration(i);
        this.bIh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.g(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bIa, f2, f3);
                }
            }
        });
        this.bIh.start();
    }

    /* loaded from: classes.dex */
    private class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            b.this.g(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }
    }

    public void g(float f, float f2, float f3) {
        if (this.bIa * f < this.bHZ) {
            f = this.bHZ / this.bIa;
        }
        if (this.bIa * f > this.bDD) {
            f = this.bDD / this.bIa;
        }
        Rect Qt = this.bHX.Qt();
        float f4 = ((Qt.left + Qt.right) * 1.0f) / 2.0f;
        float f5 = ((Qt.bottom + Qt.top) * 1.0f) / 2.0f;
        if (this.bHX != null) {
            this.bIe.postScale(f, f, this.bHX.getRealWidth() / 2, this.bHX.Qu() / 2);
            this.bHX.f(1.0f / f, f4, f5);
            this.bIa *= f;
            this.bHX.ac(1.0f / this.bIa);
            float[] QG = QG();
            this.bIe.postTranslate(-QG[0], -QG[1]);
            this.bHX.o((QG[0] * 1.0f) / this.bIa, (QG[1] * 1.0f) / this.bIa);
            QF();
            this.bHU.invalidate();
        }
    }

    public boolean Pv() {
        Rect Qt;
        return (this.bHX == null || (Qt = this.bHX.Qt()) == null || Qt.top > 10) ? false : true;
    }

    private float[] QG() {
        Rect Qt = this.bHX.Qt();
        int[] QK = this.bHY.QK();
        float[] fArr = {(QK[0] / 2) - (((Qt.left + Qt.right) * 1.0f) / 2.0f)};
        if (Qt.top < 0) {
            fArr[1] = 0 - Qt.top;
        }
        if (Qt.bottom > QK[1]) {
            fArr[1] = QK[1] - Qt.bottom;
        }
        if (Qt.bottom - Qt.top > QK[1]) {
            fArr[1] = (QK[1] / 2) - (((Qt.bottom + Qt.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bIa;
        fArr[1] = fArr[1] * this.bIa;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bHX != null) {
            float[] p = p(f, f2);
            this.bIe.postTranslate(-p[0], -p[1]);
            this.bHX.o((p[0] * 1.0f) / this.bIa, (p[1] * 1.0f) / this.bIa);
            QF();
            this.bHU.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect Qt = this.bHX.Qt();
        int[] QK = this.bHY.QK();
        if (Qt.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Qt.bottom + f2 > QK[1]) {
            f2 = (QK[1] - Qt.bottom) * this.bIa;
        }
        if (Qt.bottom - Qt.top > QK[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bIi = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QH() {
        if (this.bHX != null) {
            this.bHX.ad(1.0f / this.bDC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.Qu() * 1.0f) / bitmap.getHeight());
        this.bIe.postScale(max, max);
        this.bHZ = max * (1.0f / i);
        this.bDC = this.bHZ;
        this.bIa = this.bDC;
        this.bDD = 2.0f * this.bIa;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bHW.getWidth();
        if (realWidth > 1.0f) {
            this.bHZ /= realWidth;
        }
        bVar.ac(1.0f / this.bIa);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bIo;
        int bIp;

        public a(Context context) {
            super(context);
            this.bIo = 0;
            this.bIp = 0;
        }

        public void iB(int i) {
            this.bIo = i;
        }

        public void iC(int i) {
            this.bIp = i;
        }

        public int QI() {
            return this.bIo;
        }

        public int QJ() {
            return this.bIp;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bIo = 0;
            this.bIp = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

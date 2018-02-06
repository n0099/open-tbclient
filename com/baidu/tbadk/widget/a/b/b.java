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
    private final View bIe;
    private ScaleGestureDetector bIf;
    private BitmapRegionDecoder bIg;
    private com.baidu.tbadk.widget.a.a.b bIh;
    private com.baidu.tbadk.widget.a.c.a bIi;
    private float bIj;
    private float bIk;
    private int bIl;
    private a bIm;
    private com.baidu.tbadk.widget.a.c.c bIn;
    private com.baidu.tbadk.widget.a.b.a bIq;
    private ValueAnimator bIr;
    private View.OnLongClickListener bpA;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float bDN = 2.0f;
    private float bDM = 1.0f;
    private final Matrix bIo = new Matrix();
    Bitmap bIp = null;
    private boolean bIs = true;
    private boolean bIt = false;
    BdAsyncTask<String, String, String> bIu = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.bIh != null && b.this.bIg != null) {
                int[] QK = b.this.bIi.QK();
                int i = 1;
                while (Math.max(QK[0] / b.this.bIh.getRealWidth(), QK[1] / b.this.bIh.Qu()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, QK[0], QK[1]);
                try {
                    b.this.bIp = b.this.bIg.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bIp = b.this.bIg.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bIp = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Mx().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.bIp, false));
                b.this.a(b.this.bIp, b.this.bIh, pow);
                b.this.bIh.n(b.this.bIp);
                b.this.QH();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bIq != null) {
                b.this.bIq.JP();
            }
            b.this.QF();
            b.this.bIe.invalidate();
        }
    };

    public b(View view) {
        this.bIl = 1;
        this.bIe = view;
        this.mContext = this.bIe.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0117b());
        this.bIf = new ScaleGestureDetector(this.mContext, new c());
        this.bIm = new a(this.mContext);
        this.bIl = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bIl == 2 && QB()) {
            switch (action) {
                case 0:
                    if (!this.bIm.isFinished()) {
                        this.bIt = true;
                    } else {
                        this.bIt = false;
                    }
                case 1:
                case 3:
                    Pw();
                    break;
            }
            this.bIm.forceFinished(true);
            this.bIf.onTouchEvent(motionEvent);
            if (this.bIf.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Qy() {
        return Math.floor((double) (this.bDM * 10000.0f)) == Math.floor((double) (this.bIk * 10000.0f));
    }

    public void Pw() {
        if (this.bIk / this.bDM < 1.0f) {
            a(this.bDM, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean Qz() {
        if (this.bIl == 1) {
            return false;
        }
        if (this.bIm.computeScrollOffset()) {
            int currX = this.bIm.getCurrX();
            this.bIm.iB(currX);
            int currY = this.bIm.getCurrY();
            this.bIm.iC(currY);
            moveTo(-((currX - this.bIm.QI()) * 2.0f), -((currY - this.bIm.QJ()) * 2.0f));
            this.bIe.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bIi == null) {
            this.mOriginalBitmap = bitmap;
            this.bIi = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.bIg = this.bIi.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bIg = this.bIi.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bIl = 2;
            QA();
        }
    }

    public void QA() {
        if (this.bIl == 2 && this.bIi != null && this.bIu.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bIh == null && this.bIe.getMeasuredWidth() > 0 && this.bIe.getMeasuredHeight() > 0 && this.bIi.QK()[0] > 0 && this.bIi.QK()[1] > 0) {
            this.bIh = new com.baidu.tbadk.widget.a.a.b(this.bIe.getMeasuredWidth(), this.bIe.getMeasuredHeight(), this.bIi.QK());
            this.bIu.setPriority(3);
            this.bIu.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bpA = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !QB()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bIe.getWidth() - this.bIe.getPaddingLeft()) - this.bIe.getPaddingRight();
            int height2 = (this.bIe.getHeight() - this.bIe.getPaddingTop()) - this.bIe.getPaddingBottom();
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
        return (this.bIh == null || this.bIh.Qx() == null || this.bIh.Qx().getBitmap() == null || this.bIh.Qx().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean k(Canvas canvas) {
        if (this.bIl != 1 || this.mOriginalBitmap == null) {
            if (this.bIh != null) {
                this.bIh.Qt();
                if (QB()) {
                    canvas.drawBitmap(this.bIh.Qx().getBitmap(), this.bIo, null);
                }
                a(this.bIh, false);
                QE();
                canvas.save();
                float Qp = (1.0f * this.bIh.Qp()) / this.bIh.Qw();
                canvas.scale(Qp, Qp);
                List<com.baidu.tbadk.widget.a.a.a> Qv = this.bIh.Qv();
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
        return this.bDM;
    }

    public float getMinScaleValue() {
        if (this.bDM < 1.0f) {
            return this.bDM;
        }
        return 1.0f;
    }

    public float QD() {
        return 2.0f * this.bDM;
    }

    public void release() {
        if (this.bIr != null) {
            this.bIr.cancel();
        }
        if (this.bIu != null) {
            this.bIu.cancel();
        }
        if (this.bIn != null) {
            this.bIn.onDestory();
        }
        if (this.bIh != null && this.bIh.Qv() != null) {
            this.bIh.Qv().clear();
        }
        if (this.bIp != null) {
            this.bIp.recycle();
            this.bIp = null;
        }
        if (this.bIg != null) {
            this.bIg.recycle();
        }
    }

    private void QE() {
        List<com.baidu.tbadk.widget.a.a.a> Qv = this.bIh.Qv();
        if (Qv != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : Qv) {
                a(aVar, this.bIh);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.bIq = aVar;
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
        if (this.bIn == null) {
            this.bIn = new com.baidu.tbadk.widget.a.c.c(this.bIh, this.bIg);
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
            List<com.baidu.tbadk.widget.a.a.a> Qv = this.bIh.Qv();
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
            this.bIn.QM();
        }
    }

    public void QF() {
        if (this.bIl != 1) {
            a(this.bIh, true);
        }
    }

    private void C(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bIn.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a D(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0116a c0116a = new a.C0116a(i, i2, i3);
        if (this.bIn.QN() != null && (aVar = this.bIn.QN().get(c0116a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bIn.QN().remove(c0116a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void JP() {
        this.bIe.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0117b extends GestureDetector.SimpleOnGestureListener {
        private C0117b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bIt = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bIk == b.this.bDN ? b.this.bDM : b.this.bDN, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Qt = b.this.bIh.Qt();
            Rect Qq = b.this.bIh.Qq();
            float f3 = Qt.right - Qq.right;
            float f4 = Qt.left - Qq.left;
            float f5 = Qt.bottom - Qq.bottom;
            float f6 = Qt.top - Qq.top;
            b.this.bIm.forceFinished(true);
            b.this.bIm.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bIe.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bIt = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bIt || b.this.bpA == null) {
                b.this.bIt = false;
            } else {
                b.this.bpA.onLongClick(b.this.bIe);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bIt || b.this.mClickListener == null) {
                b.this.bIt = false;
            } else {
                b.this.mClickListener.onClick(b.this.bIe);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bIr != null) {
            this.bIr.cancel();
        }
        this.bIr = ValueAnimator.ofFloat(this.bIk, f);
        this.bIr.setDuration(i);
        this.bIr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.g(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bIk, f2, f3);
                }
            }
        });
        this.bIr.start();
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
        if (this.bIk * f < this.bIj) {
            f = this.bIj / this.bIk;
        }
        if (this.bIk * f > this.bDN) {
            f = this.bDN / this.bIk;
        }
        Rect Qt = this.bIh.Qt();
        float f4 = ((Qt.left + Qt.right) * 1.0f) / 2.0f;
        float f5 = ((Qt.bottom + Qt.top) * 1.0f) / 2.0f;
        if (this.bIh != null) {
            this.bIo.postScale(f, f, this.bIh.getRealWidth() / 2, this.bIh.Qu() / 2);
            this.bIh.f(1.0f / f, f4, f5);
            this.bIk *= f;
            this.bIh.ac(1.0f / this.bIk);
            float[] QG = QG();
            this.bIo.postTranslate(-QG[0], -QG[1]);
            this.bIh.o((QG[0] * 1.0f) / this.bIk, (QG[1] * 1.0f) / this.bIk);
            QF();
            this.bIe.invalidate();
        }
    }

    public boolean Pv() {
        Rect Qt;
        return (this.bIh == null || (Qt = this.bIh.Qt()) == null || Qt.top > 10) ? false : true;
    }

    private float[] QG() {
        Rect Qt = this.bIh.Qt();
        int[] QK = this.bIi.QK();
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
        fArr[0] = fArr[0] * this.bIk;
        fArr[1] = fArr[1] * this.bIk;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bIh != null) {
            float[] p = p(f, f2);
            this.bIo.postTranslate(-p[0], -p[1]);
            this.bIh.o((p[0] * 1.0f) / this.bIk, (p[1] * 1.0f) / this.bIk);
            QF();
            this.bIe.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect Qt = this.bIh.Qt();
        int[] QK = this.bIi.QK();
        if (Qt.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Qt.bottom + f2 > QK[1]) {
            f2 = (QK[1] - Qt.bottom) * this.bIk;
        }
        if (Qt.bottom - Qt.top > QK[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bIs = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QH() {
        if (this.bIh != null) {
            this.bIh.ad(1.0f / this.bDM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.Qu() * 1.0f) / bitmap.getHeight());
        this.bIo.postScale(max, max);
        this.bIj = max * (1.0f / i);
        this.bDM = this.bIj;
        this.bIk = this.bDM;
        this.bDN = 2.0f * this.bIk;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bIg.getWidth();
        if (realWidth > 1.0f) {
            this.bIj /= realWidth;
        }
        bVar.ac(1.0f / this.bIk);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bIy;
        int bIz;

        public a(Context context) {
            super(context);
            this.bIy = 0;
            this.bIz = 0;
        }

        public void iB(int i) {
            this.bIy = i;
        }

        public void iC(int i) {
            this.bIz = i;
        }

        public int QI() {
            return this.bIy;
        }

        public int QJ() {
            return this.bIz;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bIy = 0;
            this.bIz = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

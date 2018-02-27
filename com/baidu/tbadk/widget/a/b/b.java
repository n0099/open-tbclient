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
    private final View bHR;
    private ScaleGestureDetector bHS;
    private BitmapRegionDecoder bHT;
    private com.baidu.tbadk.widget.a.a.b bHU;
    private com.baidu.tbadk.widget.a.c.a bHV;
    private float bHW;
    private float bHX;
    private int bHY;
    private a bHZ;
    private com.baidu.tbadk.widget.a.c.c bIa;
    private com.baidu.tbadk.widget.a.b.a bId;
    private ValueAnimator bIe;
    private View.OnLongClickListener bpn;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float bDA = 2.0f;
    private float bDz = 1.0f;
    private final Matrix bIb = new Matrix();
    Bitmap bIc = null;
    private boolean bIf = true;
    private boolean bIg = false;
    BdAsyncTask<String, String, String> bIh = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.bHU != null && b.this.bHT != null) {
                int[] QJ = b.this.bHV.QJ();
                int i = 1;
                while (Math.max(QJ[0] / b.this.bHU.getRealWidth(), QJ[1] / b.this.bHU.Qt()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, QJ[0], QJ[1]);
                try {
                    b.this.bIc = b.this.bHT.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bIc = b.this.bHT.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bIc = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Mw().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.bIc, false));
                b.this.a(b.this.bIc, b.this.bHU, pow);
                b.this.bHU.n(b.this.bIc);
                b.this.QG();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bId != null) {
                b.this.bId.JO();
            }
            b.this.QE();
            b.this.bHR.invalidate();
        }
    };

    public b(View view) {
        this.bHY = 1;
        this.bHR = view;
        this.mContext = this.bHR.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0118b());
        this.bHS = new ScaleGestureDetector(this.mContext, new c());
        this.bHZ = new a(this.mContext);
        this.bHY = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bHY == 2 && QA()) {
            switch (action) {
                case 0:
                    if (!this.bHZ.isFinished()) {
                        this.bIg = true;
                    } else {
                        this.bIg = false;
                    }
                case 1:
                case 3:
                    Pv();
                    break;
            }
            this.bHZ.forceFinished(true);
            this.bHS.onTouchEvent(motionEvent);
            if (this.bHS.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Qx() {
        return Math.floor((double) (this.bDz * 10000.0f)) == Math.floor((double) (this.bHX * 10000.0f));
    }

    public void Pv() {
        if (this.bHX / this.bDz < 1.0f) {
            a(this.bDz, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean Qy() {
        if (this.bHY == 1) {
            return false;
        }
        if (this.bHZ.computeScrollOffset()) {
            int currX = this.bHZ.getCurrX();
            this.bHZ.iB(currX);
            int currY = this.bHZ.getCurrY();
            this.bHZ.iC(currY);
            moveTo(-((currX - this.bHZ.QH()) * 2.0f), -((currY - this.bHZ.QI()) * 2.0f));
            this.bHR.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bHV == null) {
            this.mOriginalBitmap = bitmap;
            this.bHV = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.bHT = this.bHV.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bHT = this.bHV.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bHY = 2;
            Qz();
        }
    }

    public void Qz() {
        if (this.bHY == 2 && this.bHV != null && this.bIh.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bHU == null && this.bHR.getMeasuredWidth() > 0 && this.bHR.getMeasuredHeight() > 0 && this.bHV.QJ()[0] > 0 && this.bHV.QJ()[1] > 0) {
            this.bHU = new com.baidu.tbadk.widget.a.a.b(this.bHR.getMeasuredWidth(), this.bHR.getMeasuredHeight(), this.bHV.QJ());
            this.bIh.setPriority(3);
            this.bIh.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bpn = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !QA()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bHR.getWidth() - this.bHR.getPaddingLeft()) - this.bHR.getPaddingRight();
            int height2 = (this.bHR.getHeight() - this.bHR.getPaddingTop()) - this.bHR.getPaddingBottom();
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

    private boolean QA() {
        return (this.bHU == null || this.bHU.Qw() == null || this.bHU.Qw().getBitmap() == null || this.bHU.Qw().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean k(Canvas canvas) {
        if (this.bHY != 1 || this.mOriginalBitmap == null) {
            if (this.bHU != null) {
                this.bHU.Qs();
                if (QA()) {
                    canvas.drawBitmap(this.bHU.Qw().getBitmap(), this.bIb, null);
                }
                a(this.bHU, false);
                QD();
                canvas.save();
                float Qo = (1.0f * this.bHU.Qo()) / this.bHU.Qv();
                canvas.scale(Qo, Qo);
                List<com.baidu.tbadk.widget.a.a.a> Qu = this.bHU.Qu();
                if (Qu != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : Qu) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.Qk(), aVar.Ql(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float QB() {
        return this.bDz;
    }

    public float getMinScaleValue() {
        if (this.bDz < 1.0f) {
            return this.bDz;
        }
        return 1.0f;
    }

    public float QC() {
        return 2.0f * this.bDz;
    }

    public void release() {
        if (this.bIe != null) {
            this.bIe.cancel();
        }
        if (this.bIh != null) {
            this.bIh.cancel();
        }
        if (this.bIa != null) {
            this.bIa.onDestory();
        }
        if (this.bHU != null && this.bHU.Qu() != null) {
            this.bHU.Qu().clear();
        }
        if (this.bIc != null) {
            this.bIc.recycle();
            this.bIc = null;
        }
        if (this.bHT != null) {
            this.bHT.recycle();
        }
    }

    private void QD() {
        List<com.baidu.tbadk.widget.a.a.a> Qu = this.bHU.Qu();
        if (Qu != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : Qu) {
                a(aVar, this.bHU);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.bId = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.Qm().Md() == 0 && aVar.Qm().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.Qs());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int Qo = aVar.Qm().Qo();
        aVar.s((i - rect.left) / Qo, (i3 - rect.top) / Qo, (i2 - rect.left) / Qo, (i4 - rect.top) / Qo);
        aVar.r((i - rect2.left) / Qo, (i3 - rect2.top) / Qo, (i2 - rect2.left) / Qo, (i4 - rect2.top) / Qo);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.Qq(), bVar.Qo(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.bIa == null) {
            this.bIa = new com.baidu.tbadk.widget.a.c.c(this.bHU, this.bHT);
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
            List<com.baidu.tbadk.widget.a.a.a> Qu = this.bHU.Qu();
            Qu.clear();
            i2 = i3;
            z2 = true;
            list = Qu;
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
            this.bIa.QL();
        }
    }

    public void QE() {
        if (this.bHY != 1) {
            a(this.bHU, true);
        }
    }

    private void C(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bIa.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a D(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0117a c0117a = new a.C0117a(i, i2, i3);
        if (this.bIa.QM() != null && (aVar = this.bIa.QM().get(c0117a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bIa.QM().remove(c0117a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void JO() {
        this.bHR.postInvalidate();
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
                b.this.bIg = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bHX == b.this.bDA ? b.this.bDz : b.this.bDA, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Qs = b.this.bHU.Qs();
            Rect Qp = b.this.bHU.Qp();
            float f3 = Qs.right - Qp.right;
            float f4 = Qs.left - Qp.left;
            float f5 = Qs.bottom - Qp.bottom;
            float f6 = Qs.top - Qp.top;
            b.this.bHZ.forceFinished(true);
            b.this.bHZ.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bHR.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bIg = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bIg || b.this.bpn == null) {
                b.this.bIg = false;
            } else {
                b.this.bpn.onLongClick(b.this.bHR);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bIg || b.this.mClickListener == null) {
                b.this.bIg = false;
            } else {
                b.this.mClickListener.onClick(b.this.bHR);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bIe != null) {
            this.bIe.cancel();
        }
        this.bIe = ValueAnimator.ofFloat(this.bHX, f);
        this.bIe.setDuration(i);
        this.bIe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.g(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bHX, f2, f3);
                }
            }
        });
        this.bIe.start();
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
        if (this.bHX * f < this.bHW) {
            f = this.bHW / this.bHX;
        }
        if (this.bHX * f > this.bDA) {
            f = this.bDA / this.bHX;
        }
        Rect Qs = this.bHU.Qs();
        float f4 = ((Qs.left + Qs.right) * 1.0f) / 2.0f;
        float f5 = ((Qs.bottom + Qs.top) * 1.0f) / 2.0f;
        if (this.bHU != null) {
            this.bIb.postScale(f, f, this.bHU.getRealWidth() / 2, this.bHU.Qt() / 2);
            this.bHU.f(1.0f / f, f4, f5);
            this.bHX *= f;
            this.bHU.ac(1.0f / this.bHX);
            float[] QF = QF();
            this.bIb.postTranslate(-QF[0], -QF[1]);
            this.bHU.o((QF[0] * 1.0f) / this.bHX, (QF[1] * 1.0f) / this.bHX);
            QE();
            this.bHR.invalidate();
        }
    }

    public boolean Pu() {
        Rect Qs;
        return (this.bHU == null || (Qs = this.bHU.Qs()) == null || Qs.top > 10) ? false : true;
    }

    private float[] QF() {
        Rect Qs = this.bHU.Qs();
        int[] QJ = this.bHV.QJ();
        float[] fArr = {(QJ[0] / 2) - (((Qs.left + Qs.right) * 1.0f) / 2.0f)};
        if (Qs.top < 0) {
            fArr[1] = 0 - Qs.top;
        }
        if (Qs.bottom > QJ[1]) {
            fArr[1] = QJ[1] - Qs.bottom;
        }
        if (Qs.bottom - Qs.top > QJ[1]) {
            fArr[1] = (QJ[1] / 2) - (((Qs.bottom + Qs.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bHX;
        fArr[1] = fArr[1] * this.bHX;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bHU != null) {
            float[] p = p(f, f2);
            this.bIb.postTranslate(-p[0], -p[1]);
            this.bHU.o((p[0] * 1.0f) / this.bHX, (p[1] * 1.0f) / this.bHX);
            QE();
            this.bHR.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect Qs = this.bHU.Qs();
        int[] QJ = this.bHV.QJ();
        if (Qs.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Qs.bottom + f2 > QJ[1]) {
            f2 = (QJ[1] - Qs.bottom) * this.bHX;
        }
        if (Qs.bottom - Qs.top > QJ[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bIf = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QG() {
        if (this.bHU != null) {
            this.bHU.ad(1.0f / this.bDz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.Qt() * 1.0f) / bitmap.getHeight());
        this.bIb.postScale(max, max);
        this.bHW = max * (1.0f / i);
        this.bDz = this.bHW;
        this.bHX = this.bDz;
        this.bDA = 2.0f * this.bHX;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bHT.getWidth();
        if (realWidth > 1.0f) {
            this.bHW /= realWidth;
        }
        bVar.ac(1.0f / this.bHX);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bIl;
        int bIm;

        public a(Context context) {
            super(context);
            this.bIl = 0;
            this.bIm = 0;
        }

        public void iB(int i) {
            this.bIl = i;
        }

        public void iC(int i) {
            this.bIm = i;
        }

        public int QH() {
            return this.bIl;
        }

        public int QI() {
            return this.bIm;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bIl = 0;
            this.bIm = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

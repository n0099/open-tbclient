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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.largeImage.a.a;
import com.baidu.tbadk.widget.largeImage.b.c;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.List;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.largeImage.logic.a {
    private static final String TAG = b.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    private View.OnLongClickListener aRe;
    private float bjA;
    private float bjB;
    private Bitmap bjC;
    private int bjD;
    private a bjE;
    private com.baidu.tbadk.widget.largeImage.b.c bjF;
    private com.baidu.tbadk.widget.largeImage.logic.a bjI;
    private ValueAnimator bjJ;
    private final View bjv;
    private ScaleGestureDetector bjw;
    private BitmapRegionDecoder bjx;
    private com.baidu.tbadk.widget.largeImage.a.b bjy;
    private com.baidu.tbadk.widget.largeImage.b.a bjz;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float beQ = 2.0f;
    private float beP = 1.0f;
    private final Matrix bjG = new Matrix();
    Bitmap bjH = null;
    private boolean bjK = true;
    private boolean bjL = false;
    BdAsyncTask<String, String, String> bjM = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.bjy != null && b.this.bjx != null) {
                int[] Qm = b.this.bjz.Qm();
                int i = 1;
                while (Math.max(Qm[0] / b.this.bjy.getRealWidth(), Qm[1] / b.this.bjy.PW()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, Qm[0], Qm[1]);
                try {
                    b.this.bjH = b.this.bjx.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bjH = b.this.bjx.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bjH = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Me().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.bjH, false));
                b.this.a(b.this.bjH, b.this.bjy, pow);
                b.this.bjy.k(b.this.bjH);
                b.this.Qj();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bjI != null) {
                b.this.bjI.JB();
            }
            b.this.Qh();
            b.this.bjv.invalidate();
        }
    };

    public b(View view) {
        this.bjD = 1;
        this.bjv = view;
        this.mContext = this.bjv.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0145b());
        this.bjw = new ScaleGestureDetector(this.mContext, new c());
        this.bjE = new a(this.mContext);
        this.bjD = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bjD == 2 && Qd()) {
            switch (action) {
                case 0:
                    if (!this.bjE.isFinished()) {
                        this.bjL = true;
                    } else {
                        this.bjL = false;
                    }
                case 1:
                case 3:
                    Pa();
                    break;
            }
            this.bjE.forceFinished(true);
            this.bjw.onTouchEvent(motionEvent);
            if (this.bjw.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Qa() {
        return Math.floor((double) (this.beP * 10000.0f)) == Math.floor((double) (this.bjB * 10000.0f));
    }

    public void Pa() {
        if (this.bjB / this.beP < 1.0f) {
            a(this.beP, 0.0f, 0.0f, 400);
        }
    }

    public boolean Qb() {
        if (this.bjD == 1) {
            return false;
        }
        if (this.bjE.computeScrollOffset()) {
            int currX = this.bjE.getCurrX();
            this.bjE.fZ(currX);
            int currY = this.bjE.getCurrY();
            this.bjE.ga(currY);
            moveTo(-((currX - this.bjE.Qk()) * 2.0f), -((currY - this.bjE.Ql()) * 2.0f));
            this.bjv.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bjz == null) {
            this.bjC = bitmap;
            this.bjz = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.bjx = this.bjz.H(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bjx = this.bjz.H(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bjD = 2;
            Qc();
        }
    }

    public void Qc() {
        if (this.bjD == 2 && this.bjz != null && this.bjM.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bjy == null && this.bjv.getMeasuredWidth() > 0 && this.bjv.getMeasuredHeight() > 0 && this.bjz.Qm()[0] > 0 && this.bjz.Qm()[1] > 0) {
            this.bjy = new com.baidu.tbadk.widget.largeImage.a.b(this.bjv.getMeasuredWidth(), this.bjv.getMeasuredHeight(), this.bjz.Qm());
            this.bjM.setPriority(3);
            this.bjM.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aRe = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !Qd()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bjv.getWidth() - this.bjv.getPaddingLeft()) - this.bjv.getPaddingRight();
            int height2 = (this.bjv.getHeight() - this.bjv.getPaddingTop()) - this.bjv.getPaddingBottom();
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
        return j(canvas);
    }

    private boolean Qd() {
        return (this.bjy == null || this.bjy.PZ() == null || this.bjy.PZ().getBitmap() == null || this.bjy.PZ().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(Canvas canvas) {
        if (this.bjD != 1 || this.bjC == null) {
            if (this.bjy != null) {
                this.bjy.PV();
                if (Qd()) {
                    canvas.drawBitmap(this.bjy.PZ().getBitmap(), this.bjG, null);
                }
                a(this.bjy, false);
                Qg();
                canvas.save();
                float PR = (1.0f * this.bjy.PR()) / this.bjy.PY();
                canvas.scale(PR, PR);
                List<com.baidu.tbadk.widget.largeImage.a.a> PX = this.bjy.PX();
                if (PX != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : PX) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.PN(), aVar.PO(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float Qe() {
        return this.beP;
    }

    public float getMinScaleValue() {
        if (this.beP < 1.0f) {
            return this.beP;
        }
        return 1.0f;
    }

    public float Qf() {
        return 2.0f * this.beP;
    }

    public void release() {
        if (this.bjJ != null) {
            this.bjJ.cancel();
        }
        if (this.bjM != null) {
            this.bjM.cancel();
        }
        if (this.bjF != null) {
            this.bjF.onDestory();
        }
        if (this.bjy != null && this.bjy.PX() != null) {
            this.bjy.PX().clear();
        }
        if (this.bjH != null) {
            this.bjH.recycle();
            this.bjH = null;
        }
        if (this.bjx != null) {
            this.bjx.recycle();
        }
    }

    private void Qg() {
        List<com.baidu.tbadk.widget.largeImage.a.a> PX = this.bjy.PX();
        if (PX != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : PX) {
                a(aVar, this.bjy);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.bjI = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.PP().LK() == 0 && aVar.PP().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.PV());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int PR = aVar.PP().PR();
        aVar.j((i - rect.left) / PR, (i3 - rect.top) / PR, (i2 - rect.left) / PR, (i4 - rect.top) / PR);
        aVar.i((i - rect2.left) / PR, (i3 - rect2.top) / PR, (i2 - rect2.left) / PR, (i4 - rect2.top) / PR);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.PT(), bVar.PR(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.bjF == null) {
            this.bjF = new com.baidu.tbadk.widget.largeImage.b.c(this.bjy, this.bjx);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> PX = this.bjy.PX();
            PX.clear();
            i2 = i3;
            z2 = true;
            list = PX;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                com.baidu.tbadk.widget.largeImage.a.a u = u(i2, i7, i);
                if (u == null) {
                    if (z) {
                        t(i2, i7, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(u);
                }
            }
            i2++;
        }
        if (z2) {
            this.bjF.Qo();
        }
    }

    public void Qh() {
        if (this.bjD != 1) {
            a(this.bjy, true);
        }
    }

    private void t(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bjF.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a u(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0144a c0144a = new a.C0144a(i, i2, i3);
        if (this.bjF.Qp() != null && (aVar = this.bjF.Qp().get(c0144a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bjF.Qp().remove(c0144a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void JB() {
        this.bjv.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0145b extends GestureDetector.SimpleOnGestureListener {
        private C0145b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bjL = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bjB == b.this.beQ ? b.this.beP : b.this.beQ, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect PV = b.this.bjy.PV();
            Rect PS = b.this.bjy.PS();
            float f3 = PV.right - PS.right;
            float f4 = PV.left - PS.left;
            float f5 = PV.bottom - PS.bottom;
            float f6 = PV.top - PS.top;
            b.this.bjE.forceFinished(true);
            b.this.bjE.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bjv.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bjL = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bjL || b.this.aRe == null) {
                b.this.bjL = false;
            } else {
                b.this.aRe.onLongClick(b.this.bjv);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bjL || b.this.mClickListener == null) {
                b.this.bjL = false;
            } else {
                b.this.mClickListener.onClick(b.this.bjv);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bjJ != null) {
            this.bjJ.cancel();
        }
        this.bjJ = ValueAnimator.ofFloat(this.bjB, f);
        this.bjJ.setDuration(i);
        this.bjJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bjB, f2, f3);
                }
            }
        });
        this.bjJ.start();
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
        if (this.bjB * f < this.bjA) {
            f = this.bjA / this.bjB;
        }
        if (this.bjB * f > this.beQ) {
            f = this.beQ / this.bjB;
        }
        Rect PV = this.bjy.PV();
        float f4 = ((PV.left + PV.right) * 1.0f) / 2.0f;
        float f5 = ((PV.bottom + PV.top) * 1.0f) / 2.0f;
        if (this.bjy != null) {
            this.bjG.postScale(f, f, this.bjy.getRealWidth() / 2, this.bjy.PW() / 2);
            this.bjy.b(1.0f / f, f4, f5);
            this.bjB *= f;
            this.bjy.ac(1.0f / this.bjB);
            float[] Qi = Qi();
            this.bjG.postTranslate(-Qi[0], -Qi[1]);
            this.bjy.o((Qi[0] * 1.0f) / this.bjB, (Qi[1] * 1.0f) / this.bjB);
            Qh();
            this.bjv.invalidate();
        }
    }

    public boolean OZ() {
        Rect PV;
        return (this.bjy == null || (PV = this.bjy.PV()) == null || PV.top > 10) ? false : true;
    }

    private float[] Qi() {
        Rect PV = this.bjy.PV();
        int[] Qm = this.bjz.Qm();
        float[] fArr = {(Qm[0] / 2) - (((PV.left + PV.right) * 1.0f) / 2.0f)};
        if (PV.top < 0) {
            fArr[1] = 0 - PV.top;
        }
        if (PV.bottom > Qm[1]) {
            fArr[1] = Qm[1] - PV.bottom;
        }
        if (PV.bottom - PV.top > Qm[1]) {
            fArr[1] = (Qm[1] / 2) - (((PV.bottom + PV.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bjB;
        fArr[1] = fArr[1] * this.bjB;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bjy != null) {
            float[] p = p(f, f2);
            this.bjG.postTranslate(-p[0], -p[1]);
            this.bjy.o((p[0] * 1.0f) / this.bjB, (p[1] * 1.0f) / this.bjB);
            Qh();
            this.bjv.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect PV = this.bjy.PV();
        int[] Qm = this.bjz.Qm();
        if (PV.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (PV.bottom + f2 > Qm[1]) {
            f2 = (Qm[1] - PV.bottom) * this.bjB;
        }
        if (PV.bottom - PV.top > Qm[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bjK = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj() {
        if (this.bjy != null) {
            this.bjy.ad(1.0f / this.beP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.PW() * 1.0f) / bitmap.getHeight());
        this.bjG.postScale(max, max);
        this.bjA = max * (1.0f / i);
        this.beP = this.bjA;
        this.bjB = this.beP;
        this.beQ = 2.0f * this.bjB;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bjx.getWidth();
        if (realWidth > 1.0f) {
            this.bjA /= realWidth;
        }
        bVar.ac(1.0f / this.bjB);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bjQ;
        int bjR;

        public a(Context context) {
            super(context);
            this.bjQ = 0;
            this.bjR = 0;
        }

        public void fZ(int i) {
            this.bjQ = i;
        }

        public void ga(int i) {
            this.bjR = i;
        }

        public int Qk() {
            return this.bjQ;
        }

        public int Ql() {
            return this.bjR;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bjQ = 0;
            this.bjR = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

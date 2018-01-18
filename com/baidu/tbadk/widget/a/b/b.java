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
    private final View bFS;
    private ScaleGestureDetector bFT;
    private BitmapRegionDecoder bFU;
    private com.baidu.tbadk.widget.a.a.b bFV;
    private com.baidu.tbadk.widget.a.c.a bFW;
    private float bFX;
    private float bFY;
    private int bFZ;
    private a bGa;
    private com.baidu.tbadk.widget.a.c.c bGb;
    private com.baidu.tbadk.widget.a.b.a bGe;
    private ValueAnimator bGf;
    private View.OnLongClickListener bnd;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float bBB = 2.0f;
    private float bBA = 1.0f;
    private final Matrix bGc = new Matrix();
    Bitmap bGd = null;
    private boolean bGg = true;
    private boolean bGh = false;
    BdAsyncTask<String, String, String> bGi = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.bFV != null && b.this.bFU != null) {
                int[] Qd = b.this.bFW.Qd();
                int i = 1;
                while (Math.max(Qd[0] / b.this.bFV.getRealWidth(), Qd[1] / b.this.bFV.PN()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, Qd[0], Qd[1]);
                try {
                    b.this.bGd = b.this.bFU.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bGd = b.this.bFU.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bGd = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.LP().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.bGd, false));
                b.this.a(b.this.bGd, b.this.bFV, pow);
                b.this.bFV.l(b.this.bGd);
                b.this.Qa();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bGe != null) {
                b.this.bGe.Jg();
            }
            b.this.PY();
            b.this.bFS.invalidate();
        }
    };

    public b(View view) {
        this.bFZ = 1;
        this.bFS = view;
        this.mContext = this.bFS.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0093b());
        this.bFT = new ScaleGestureDetector(this.mContext, new c());
        this.bGa = new a(this.mContext);
        this.bFZ = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bFZ == 2 && PU()) {
            switch (action) {
                case 0:
                    if (!this.bGa.isFinished()) {
                        this.bGh = true;
                    } else {
                        this.bGh = false;
                    }
                case 1:
                case 3:
                    OP();
                    break;
            }
            this.bGa.forceFinished(true);
            this.bFT.onTouchEvent(motionEvent);
            if (this.bFT.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean PR() {
        return Math.floor((double) (this.bBA * 10000.0f)) == Math.floor((double) (this.bFY * 10000.0f));
    }

    public void OP() {
        if (this.bFY / this.bBA < 1.0f) {
            a(this.bBA, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean PS() {
        if (this.bFZ == 1) {
            return false;
        }
        if (this.bGa.computeScrollOffset()) {
            int currX = this.bGa.getCurrX();
            this.bGa.iE(currX);
            int currY = this.bGa.getCurrY();
            this.bGa.iF(currY);
            moveTo(-((currX - this.bGa.Qb()) * 2.0f), -((currY - this.bGa.Qc()) * 2.0f));
            this.bFS.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bFW == null) {
            this.mOriginalBitmap = bitmap;
            this.bFW = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.bFU = this.bFW.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bFU = this.bFW.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bFZ = 2;
            PT();
        }
    }

    public void PT() {
        if (this.bFZ == 2 && this.bFW != null && this.bGi.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bFV == null && this.bFS.getMeasuredWidth() > 0 && this.bFS.getMeasuredHeight() > 0 && this.bFW.Qd()[0] > 0 && this.bFW.Qd()[1] > 0) {
            this.bFV = new com.baidu.tbadk.widget.a.a.b(this.bFS.getMeasuredWidth(), this.bFS.getMeasuredHeight(), this.bFW.Qd());
            this.bGi.setPriority(3);
            this.bGi.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bnd = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !PU()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bFS.getWidth() - this.bFS.getPaddingLeft()) - this.bFS.getPaddingRight();
            int height2 = (this.bFS.getHeight() - this.bFS.getPaddingTop()) - this.bFS.getPaddingBottom();
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

    private boolean PU() {
        return (this.bFV == null || this.bFV.PQ() == null || this.bFV.PQ().getBitmap() == null || this.bFV.PQ().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean k(Canvas canvas) {
        if (this.bFZ != 1 || this.mOriginalBitmap == null) {
            if (this.bFV != null) {
                this.bFV.PM();
                if (PU()) {
                    canvas.drawBitmap(this.bFV.PQ().getBitmap(), this.bGc, null);
                }
                a(this.bFV, false);
                PX();
                canvas.save();
                float PI = (1.0f * this.bFV.PI()) / this.bFV.PP();
                canvas.scale(PI, PI);
                List<com.baidu.tbadk.widget.a.a.a> PO = this.bFV.PO();
                if (PO != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : PO) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.PE(), aVar.PF(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float PV() {
        return this.bBA;
    }

    public float getMinScaleValue() {
        if (this.bBA < 1.0f) {
            return this.bBA;
        }
        return 1.0f;
    }

    public float PW() {
        return 2.0f * this.bBA;
    }

    public void release() {
        if (this.bGf != null) {
            this.bGf.cancel();
        }
        if (this.bGi != null) {
            this.bGi.cancel();
        }
        if (this.bGb != null) {
            this.bGb.onDestory();
        }
        if (this.bFV != null && this.bFV.PO() != null) {
            this.bFV.PO().clear();
        }
        if (this.bGd != null) {
            this.bGd.recycle();
            this.bGd = null;
        }
        if (this.bFU != null) {
            this.bFU.recycle();
        }
    }

    private void PX() {
        List<com.baidu.tbadk.widget.a.a.a> PO = this.bFV.PO();
        if (PO != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : PO) {
                a(aVar, this.bFV);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.bGe = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.PG().Lw() == 0 && aVar.PG().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.PM());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int PI = aVar.PG().PI();
        aVar.s((i - rect.left) / PI, (i3 - rect.top) / PI, (i2 - rect.left) / PI, (i4 - rect.top) / PI);
        aVar.r((i - rect2.left) / PI, (i3 - rect2.top) / PI, (i2 - rect2.left) / PI, (i4 - rect2.top) / PI);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.PK(), bVar.PI(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.bGb == null) {
            this.bGb = new com.baidu.tbadk.widget.a.c.c(this.bFV, this.bFU);
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
            List<com.baidu.tbadk.widget.a.a.a> PO = this.bFV.PO();
            PO.clear();
            i2 = i3;
            z2 = true;
            list = PO;
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
            this.bGb.Qf();
        }
    }

    public void PY() {
        if (this.bFZ != 1) {
            a(this.bFV, true);
        }
    }

    private void B(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bGb.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a C(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0092a c0092a = new a.C0092a(i, i2, i3);
        if (this.bGb.Qg() != null && (aVar = this.bGb.Qg().get(c0092a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bGb.Qg().remove(c0092a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void Jg() {
        this.bFS.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0093b extends GestureDetector.SimpleOnGestureListener {
        private C0093b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bGh = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bFY == b.this.bBB ? b.this.bBA : b.this.bBB, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect PM = b.this.bFV.PM();
            Rect PJ = b.this.bFV.PJ();
            float f3 = PM.right - PJ.right;
            float f4 = PM.left - PJ.left;
            float f5 = PM.bottom - PJ.bottom;
            float f6 = PM.top - PJ.top;
            b.this.bGa.forceFinished(true);
            b.this.bGa.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bFS.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bGh = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bGh || b.this.bnd == null) {
                b.this.bGh = false;
            } else {
                b.this.bnd.onLongClick(b.this.bFS);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bGh || b.this.mClickListener == null) {
                b.this.bGh = false;
            } else {
                b.this.mClickListener.onClick(b.this.bFS);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bGf != null) {
            this.bGf.cancel();
        }
        this.bGf = ValueAnimator.ofFloat(this.bFY, f);
        this.bGf.setDuration(i);
        this.bGf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.f(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bFY, f2, f3);
                }
            }
        });
        this.bGf.start();
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
        if (this.bFY * f < this.bFX) {
            f = this.bFX / this.bFY;
        }
        if (this.bFY * f > this.bBB) {
            f = this.bBB / this.bFY;
        }
        Rect PM = this.bFV.PM();
        float f4 = ((PM.left + PM.right) * 1.0f) / 2.0f;
        float f5 = ((PM.bottom + PM.top) * 1.0f) / 2.0f;
        if (this.bFV != null) {
            this.bGc.postScale(f, f, this.bFV.getRealWidth() / 2, this.bFV.PN() / 2);
            this.bFV.e(1.0f / f, f4, f5);
            this.bFY *= f;
            this.bFV.W(1.0f / this.bFY);
            float[] PZ = PZ();
            this.bGc.postTranslate(-PZ[0], -PZ[1]);
            this.bFV.o((PZ[0] * 1.0f) / this.bFY, (PZ[1] * 1.0f) / this.bFY);
            PY();
            this.bFS.invalidate();
        }
    }

    public boolean OO() {
        Rect PM;
        return (this.bFV == null || (PM = this.bFV.PM()) == null || PM.top > 10) ? false : true;
    }

    private float[] PZ() {
        Rect PM = this.bFV.PM();
        int[] Qd = this.bFW.Qd();
        float[] fArr = {(Qd[0] / 2) - (((PM.left + PM.right) * 1.0f) / 2.0f)};
        if (PM.top < 0) {
            fArr[1] = 0 - PM.top;
        }
        if (PM.bottom > Qd[1]) {
            fArr[1] = Qd[1] - PM.bottom;
        }
        if (PM.bottom - PM.top > Qd[1]) {
            fArr[1] = (Qd[1] / 2) - (((PM.bottom + PM.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bFY;
        fArr[1] = fArr[1] * this.bFY;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bFV != null) {
            float[] p = p(f, f2);
            this.bGc.postTranslate(-p[0], -p[1]);
            this.bFV.o((p[0] * 1.0f) / this.bFY, (p[1] * 1.0f) / this.bFY);
            PY();
            this.bFS.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect PM = this.bFV.PM();
        int[] Qd = this.bFW.Qd();
        if (PM.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (PM.bottom + f2 > Qd[1]) {
            f2 = (Qd[1] - PM.bottom) * this.bFY;
        }
        if (PM.bottom - PM.top > Qd[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bGg = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qa() {
        if (this.bFV != null) {
            this.bFV.X(1.0f / this.bBA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.PN() * 1.0f) / bitmap.getHeight());
        this.bGc.postScale(max, max);
        this.bFX = max * (1.0f / i);
        this.bBA = this.bFX;
        this.bFY = this.bBA;
        this.bBB = 2.0f * this.bFY;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bFU.getWidth();
        if (realWidth > 1.0f) {
            this.bFX /= realWidth;
        }
        bVar.W(1.0f / this.bFY);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bGm;
        int bGn;

        public a(Context context) {
            super(context);
            this.bGm = 0;
            this.bGn = 0;
        }

        public void iE(int i) {
            this.bGm = i;
        }

        public void iF(int i) {
            this.bGn = i;
        }

        public int Qb() {
            return this.bGm;
        }

        public int Qc() {
            return this.bGn;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bGm = 0;
            this.bGn = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

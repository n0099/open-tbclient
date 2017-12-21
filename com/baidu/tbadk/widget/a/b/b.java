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
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.a.b.a {
    private static final String TAG = b.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    private final View aRX;
    private ScaleGestureDetector aRY;
    private BitmapRegionDecoder aRZ;
    private com.baidu.tbadk.widget.a.a.b aSa;
    private com.baidu.tbadk.widget.a.c.a aSb;
    private float aSc;
    private float aSd;
    private int aSe;
    private a aSf;
    private com.baidu.tbadk.widget.a.c.c aSg;
    private com.baidu.tbadk.widget.a.b.a aSj;
    private ValueAnimator aSk;
    private View.OnLongClickListener ayP;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aNF = 2.0f;
    private float aNE = 1.0f;
    private final Matrix aSh = new Matrix();
    Bitmap aSi = null;
    private boolean aSl = true;
    private boolean aSm = false;
    BdAsyncTask<String, String, String> aSn = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.aSa != null && b.this.aRZ != null) {
                int[] IR = b.this.aSb.IR();
                int i = 1;
                while (Math.max(IR[0] / b.this.aSa.IA(), IR[1] / b.this.aSa.IB()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, IR[0], IR[1]);
                try {
                    b.this.aSi = b.this.aRZ.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.aSi = b.this.aRZ.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.aSi = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.EA().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.aSi, false));
                b.this.a(b.this.aSi, b.this.aSa, pow);
                b.this.aSa.i(b.this.aSi);
                b.this.IO();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.aSj != null) {
                b.this.aSj.BP();
            }
            b.this.IM();
            b.this.aRX.invalidate();
        }
    };

    public b(View view) {
        this.aSe = 1;
        this.aRX = view;
        this.mContext = this.aRX.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0080b());
        this.aRY = new ScaleGestureDetector(this.mContext, new c());
        this.aSf = new a(this.mContext);
        this.aSe = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.aSe == 2 && II()) {
            switch (action) {
                case 0:
                    if (!this.aSf.isFinished()) {
                        this.aSm = true;
                    } else {
                        this.aSm = false;
                    }
                case 1:
                case 3:
                    HC();
                    break;
            }
            this.aSf.forceFinished(true);
            this.aRY.onTouchEvent(motionEvent);
            if (this.aRY.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean IF() {
        return Math.floor((double) (this.aNE * 10000.0f)) == Math.floor((double) (this.aSd * 10000.0f));
    }

    public void HC() {
        if (this.aSd / this.aNE < 1.0f) {
            a(this.aNE, 0.0f, 0.0f, 400);
        }
    }

    public boolean IG() {
        if (this.aSe == 1) {
            return false;
        }
        if (this.aSf.computeScrollOffset()) {
            int currX = this.aSf.getCurrX();
            this.aSf.fJ(currX);
            int currY = this.aSf.getCurrY();
            this.aSf.fK(currY);
            moveTo(-((currX - this.aSf.IP()) * 2.0f), -((currY - this.aSf.IQ()) * 2.0f));
            this.aRX.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.aSb == null) {
            this.mOriginalBitmap = bitmap;
            this.aSb = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.aRZ = this.aSb.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.aRZ = this.aSb.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.aSe = 2;
            IH();
        }
    }

    public void IH() {
        if (this.aSe == 2 && this.aSb != null && this.aSn.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.aSa == null && this.aRX.getMeasuredWidth() > 0 && this.aRX.getMeasuredHeight() > 0 && this.aSb.IR()[0] > 0 && this.aSb.IR()[1] > 0) {
            this.aSa = new com.baidu.tbadk.widget.a.a.b(this.aRX.getMeasuredWidth(), this.aRX.getMeasuredHeight(), this.aSb.IR());
            this.aSn.setPriority(3);
            this.aSn.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayP = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !II()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.aRX.getWidth() - this.aRX.getPaddingLeft()) - this.aRX.getPaddingRight();
            int height2 = (this.aRX.getHeight() - this.aRX.getPaddingTop()) - this.aRX.getPaddingBottom();
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
        return g(canvas);
    }

    private boolean II() {
        return (this.aSa == null || this.aSa.IE() == null || this.aSa.IE().getBitmap() == null || this.aSa.IE().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean g(Canvas canvas) {
        if (this.aSe != 1 || this.mOriginalBitmap == null) {
            if (this.aSa != null) {
                this.aSa.Iz();
                if (II()) {
                    canvas.drawBitmap(this.aSa.IE().getBitmap(), this.aSh, null);
                }
                a(this.aSa, false);
                IL();
                canvas.save();
                float Iv = (1.0f * this.aSa.Iv()) / this.aSa.ID();
                canvas.scale(Iv, Iv);
                List<com.baidu.tbadk.widget.a.a.a> IC = this.aSa.IC();
                if (IC != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : IC) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.Ir(), aVar.Is(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float IJ() {
        return this.aNE;
    }

    public float getMinScaleValue() {
        if (this.aNE < 1.0f) {
            return this.aNE;
        }
        return 1.0f;
    }

    public float IK() {
        return 2.0f * this.aNE;
    }

    public void release() {
        if (this.aSk != null) {
            this.aSk.cancel();
        }
        if (this.aSn != null) {
            this.aSn.cancel();
        }
        if (this.aSg != null) {
            this.aSg.onDestory();
        }
        if (this.aSa != null && this.aSa.IC() != null) {
            this.aSa.IC().clear();
        }
        if (this.aSi != null) {
            this.aSi.recycle();
            this.aSi = null;
        }
        if (this.aRZ != null) {
            this.aRZ.recycle();
        }
    }

    private void IL() {
        List<com.baidu.tbadk.widget.a.a.a> IC = this.aSa.IC();
        if (IC != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : IC) {
                a(aVar, this.aSa);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.aSj = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.It().Eh() == 0 && aVar.It().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.Iz());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int Iv = aVar.It().Iv();
        aVar.k((i - rect.left) / Iv, (i3 - rect.top) / Iv, (i2 - rect.left) / Iv, (i4 - rect.top) / Iv);
        aVar.j((i - rect2.left) / Iv, (i3 - rect2.top) / Iv, (i2 - rect2.left) / Iv, (i4 - rect2.top) / Iv);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.Ix(), bVar.Iv(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.aSg == null) {
            this.aSg = new com.baidu.tbadk.widget.a.c.c(this.aSa, this.aRZ);
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
            List<com.baidu.tbadk.widget.a.a.a> IC = this.aSa.IC();
            IC.clear();
            i2 = i3;
            z2 = true;
            list = IC;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                com.baidu.tbadk.widget.a.a.a t = t(i2, i7, i);
                if (t == null) {
                    if (z) {
                        s(i2, i7, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(t);
                }
            }
            i2++;
        }
        if (z2) {
            this.aSg.IT();
        }
    }

    public void IM() {
        if (this.aSe != 1) {
            a(this.aSa, true);
        }
    }

    private void s(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.aSg.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a t(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0079a c0079a = new a.C0079a(i, i2, i3);
        if (this.aSg.IU() != null && (aVar = this.aSg.IU().get(c0079a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.aSg.IU().remove(c0079a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void BP() {
        this.aRX.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0080b extends GestureDetector.SimpleOnGestureListener {
        private C0080b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aSm = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.aSd == b.this.aNF ? b.this.aNE : b.this.aNF, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Iz = b.this.aSa.Iz();
            Rect Iw = b.this.aSa.Iw();
            float f3 = Iz.right - Iw.right;
            float f4 = Iz.left - Iw.left;
            float f5 = Iz.bottom - Iw.bottom;
            float f6 = Iz.top - Iw.top;
            b.this.aSf.forceFinished(true);
            b.this.aSf.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.aRX.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aSm = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.aSm || b.this.ayP == null) {
                b.this.aSm = false;
            } else {
                b.this.ayP.onLongClick(b.this.aRX);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.aSm || b.this.mClickListener == null) {
                b.this.aSm = false;
            } else {
                b.this.mClickListener.onClick(b.this.aRX);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.aSk != null) {
            this.aSk.cancel();
        }
        this.aSk = ValueAnimator.ofFloat(this.aSd, f);
        this.aSk.setDuration(i);
        this.aSk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.aSd, f2, f3);
                }
            }
        });
        this.aSk.start();
    }

    /* loaded from: classes.dex */
    private class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            b.this.b(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }
    }

    public void b(float f, float f2, float f3) {
        if (this.aSd * f < this.aSc) {
            f = this.aSc / this.aSd;
        }
        if (this.aSd * f > this.aNF) {
            f = this.aNF / this.aSd;
        }
        Rect Iz = this.aSa.Iz();
        float f4 = ((Iz.left + Iz.right) * 1.0f) / 2.0f;
        float f5 = ((Iz.bottom + Iz.top) * 1.0f) / 2.0f;
        if (this.aSa != null) {
            this.aSh.postScale(f, f, this.aSa.IA() / 2, this.aSa.IB() / 2);
            this.aSa.a(1.0f / f, f4, f5);
            this.aSd *= f;
            this.aSa.G(1.0f / this.aSd);
            float[] IN = IN();
            this.aSh.postTranslate(-IN[0], -IN[1]);
            this.aSa.g((IN[0] * 1.0f) / this.aSd, (IN[1] * 1.0f) / this.aSd);
            IM();
            this.aRX.invalidate();
        }
    }

    public boolean HB() {
        Rect Iz;
        return (this.aSa == null || (Iz = this.aSa.Iz()) == null || Iz.top > 10) ? false : true;
    }

    private float[] IN() {
        Rect Iz = this.aSa.Iz();
        int[] IR = this.aSb.IR();
        float[] fArr = {(IR[0] / 2) - (((Iz.left + Iz.right) * 1.0f) / 2.0f)};
        if (Iz.top < 0) {
            fArr[1] = 0 - Iz.top;
        }
        if (Iz.bottom > IR[1]) {
            fArr[1] = IR[1] - Iz.bottom;
        }
        if (Iz.bottom - Iz.top > IR[1]) {
            fArr[1] = (IR[1] / 2) - (((Iz.bottom + Iz.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.aSd;
        fArr[1] = fArr[1] * this.aSd;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.aSa != null) {
            float[] h = h(f, f2);
            this.aSh.postTranslate(-h[0], -h[1]);
            this.aSa.g((h[0] * 1.0f) / this.aSd, (h[1] * 1.0f) / this.aSd);
            IM();
            this.aRX.invalidate();
        }
    }

    private float[] h(float f, float f2) {
        float[] fArr = new float[2];
        Rect Iz = this.aSa.Iz();
        int[] IR = this.aSb.IR();
        if (Iz.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Iz.bottom + f2 > IR[1]) {
            f2 = (IR[1] - Iz.bottom) * this.aSd;
        }
        if (Iz.bottom - Iz.top > IR[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.aSl = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IO() {
        if (this.aSa != null) {
            this.aSa.H(1.0f / this.aNE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.IA() * 1.0f) / bitmap.getWidth(), (bVar.IB() * 1.0f) / bitmap.getHeight());
        this.aSh.postScale(max, max);
        this.aSc = max * (1.0f / i);
        this.aNE = this.aSc;
        this.aSd = this.aNE;
        this.aNF = 2.0f * this.aSd;
        float IA = (bVar.IA() * 1.0f) / this.aRZ.getWidth();
        if (IA > 1.0f) {
            this.aSc /= IA;
        }
        bVar.G(1.0f / this.aSd);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int aSr;
        int aSs;

        public a(Context context) {
            super(context);
            this.aSr = 0;
            this.aSs = 0;
        }

        public void fJ(int i) {
            this.aSr = i;
        }

        public void fK(int i) {
            this.aSs = i;
        }

        public int IP() {
            return this.aSr;
        }

        public int IQ() {
            return this.aSs;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.aSr = 0;
            this.aSs = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

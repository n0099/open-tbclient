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
    private final View aRU;
    private ScaleGestureDetector aRV;
    private BitmapRegionDecoder aRW;
    private com.baidu.tbadk.widget.a.a.b aRX;
    private com.baidu.tbadk.widget.a.c.a aRY;
    private float aRZ;
    private float aSa;
    private int aSb;
    private a aSc;
    private com.baidu.tbadk.widget.a.c.c aSd;
    private com.baidu.tbadk.widget.a.b.a aSg;
    private ValueAnimator aSh;
    private View.OnLongClickListener ayM;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aNC = 2.0f;
    private float aNB = 1.0f;
    private final Matrix aSe = new Matrix();
    Bitmap aSf = null;
    private boolean aSi = true;
    private boolean aSj = false;
    BdAsyncTask<String, String, String> aSk = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.aRX != null && b.this.aRW != null) {
                int[] IR = b.this.aRY.IR();
                int i = 1;
                while (Math.max(IR[0] / b.this.aRX.IA(), IR[1] / b.this.aRX.IB()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, IR[0], IR[1]);
                try {
                    b.this.aSf = b.this.aRW.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.aSf = b.this.aRW.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.aSf = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.EA().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.aSf, false));
                b.this.a(b.this.aSf, b.this.aRX, pow);
                b.this.aRX.i(b.this.aSf);
                b.this.IO();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.aSg != null) {
                b.this.aSg.BP();
            }
            b.this.IM();
            b.this.aRU.invalidate();
        }
    };

    public b(View view) {
        this.aSb = 1;
        this.aRU = view;
        this.mContext = this.aRU.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0081b());
        this.aRV = new ScaleGestureDetector(this.mContext, new c());
        this.aSc = new a(this.mContext);
        this.aSb = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.aSb == 2 && II()) {
            switch (action) {
                case 0:
                    if (!this.aSc.isFinished()) {
                        this.aSj = true;
                    } else {
                        this.aSj = false;
                    }
                case 1:
                case 3:
                    HC();
                    break;
            }
            this.aSc.forceFinished(true);
            this.aRV.onTouchEvent(motionEvent);
            if (this.aRV.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean IF() {
        return Math.floor((double) (this.aNB * 10000.0f)) == Math.floor((double) (this.aSa * 10000.0f));
    }

    public void HC() {
        if (this.aSa / this.aNB < 1.0f) {
            a(this.aNB, 0.0f, 0.0f, 400);
        }
    }

    public boolean IG() {
        if (this.aSb == 1) {
            return false;
        }
        if (this.aSc.computeScrollOffset()) {
            int currX = this.aSc.getCurrX();
            this.aSc.fJ(currX);
            int currY = this.aSc.getCurrY();
            this.aSc.fK(currY);
            moveTo(-((currX - this.aSc.IP()) * 2.0f), -((currY - this.aSc.IQ()) * 2.0f));
            this.aRU.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.aRY == null) {
            this.mOriginalBitmap = bitmap;
            this.aRY = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.aRW = this.aRY.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.aRW = this.aRY.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.aSb = 2;
            IH();
        }
    }

    public void IH() {
        if (this.aSb == 2 && this.aRY != null && this.aSk.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.aRX == null && this.aRU.getMeasuredWidth() > 0 && this.aRU.getMeasuredHeight() > 0 && this.aRY.IR()[0] > 0 && this.aRY.IR()[1] > 0) {
            this.aRX = new com.baidu.tbadk.widget.a.a.b(this.aRU.getMeasuredWidth(), this.aRU.getMeasuredHeight(), this.aRY.IR());
            this.aSk.setPriority(3);
            this.aSk.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayM = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !II()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.aRU.getWidth() - this.aRU.getPaddingLeft()) - this.aRU.getPaddingRight();
            int height2 = (this.aRU.getHeight() - this.aRU.getPaddingTop()) - this.aRU.getPaddingBottom();
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
        return (this.aRX == null || this.aRX.IE() == null || this.aRX.IE().getBitmap() == null || this.aRX.IE().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean g(Canvas canvas) {
        if (this.aSb != 1 || this.mOriginalBitmap == null) {
            if (this.aRX != null) {
                this.aRX.Iz();
                if (II()) {
                    canvas.drawBitmap(this.aRX.IE().getBitmap(), this.aSe, null);
                }
                a(this.aRX, false);
                IL();
                canvas.save();
                float Iv = (1.0f * this.aRX.Iv()) / this.aRX.ID();
                canvas.scale(Iv, Iv);
                List<com.baidu.tbadk.widget.a.a.a> IC = this.aRX.IC();
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
        return this.aNB;
    }

    public float getMinScaleValue() {
        if (this.aNB < 1.0f) {
            return this.aNB;
        }
        return 1.0f;
    }

    public float IK() {
        return 2.0f * this.aNB;
    }

    public void release() {
        if (this.aSh != null) {
            this.aSh.cancel();
        }
        if (this.aSk != null) {
            this.aSk.cancel();
        }
        if (this.aSd != null) {
            this.aSd.onDestory();
        }
        if (this.aRX != null && this.aRX.IC() != null) {
            this.aRX.IC().clear();
        }
        if (this.aSf != null) {
            this.aSf.recycle();
            this.aSf = null;
        }
        if (this.aRW != null) {
            this.aRW.recycle();
        }
    }

    private void IL() {
        List<com.baidu.tbadk.widget.a.a.a> IC = this.aRX.IC();
        if (IC != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : IC) {
                a(aVar, this.aRX);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.aSg = aVar;
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
        if (this.aSd == null) {
            this.aSd = new com.baidu.tbadk.widget.a.c.c(this.aRX, this.aRW);
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
            List<com.baidu.tbadk.widget.a.a.a> IC = this.aRX.IC();
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
            this.aSd.IT();
        }
    }

    public void IM() {
        if (this.aSb != 1) {
            a(this.aRX, true);
        }
    }

    private void s(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.aSd.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a t(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0080a c0080a = new a.C0080a(i, i2, i3);
        if (this.aSd.IU() != null && (aVar = this.aSd.IU().get(c0080a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.aSd.IU().remove(c0080a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void BP() {
        this.aRU.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0081b extends GestureDetector.SimpleOnGestureListener {
        private C0081b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aSj = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.aSa == b.this.aNC ? b.this.aNB : b.this.aNC, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Iz = b.this.aRX.Iz();
            Rect Iw = b.this.aRX.Iw();
            float f3 = Iz.right - Iw.right;
            float f4 = Iz.left - Iw.left;
            float f5 = Iz.bottom - Iw.bottom;
            float f6 = Iz.top - Iw.top;
            b.this.aSc.forceFinished(true);
            b.this.aSc.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.aRU.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aSj = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.aSj || b.this.ayM == null) {
                b.this.aSj = false;
            } else {
                b.this.ayM.onLongClick(b.this.aRU);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.aSj || b.this.mClickListener == null) {
                b.this.aSj = false;
            } else {
                b.this.mClickListener.onClick(b.this.aRU);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.aSh != null) {
            this.aSh.cancel();
        }
        this.aSh = ValueAnimator.ofFloat(this.aSa, f);
        this.aSh.setDuration(i);
        this.aSh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.aSa, f2, f3);
                }
            }
        });
        this.aSh.start();
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
        if (this.aSa * f < this.aRZ) {
            f = this.aRZ / this.aSa;
        }
        if (this.aSa * f > this.aNC) {
            f = this.aNC / this.aSa;
        }
        Rect Iz = this.aRX.Iz();
        float f4 = ((Iz.left + Iz.right) * 1.0f) / 2.0f;
        float f5 = ((Iz.bottom + Iz.top) * 1.0f) / 2.0f;
        if (this.aRX != null) {
            this.aSe.postScale(f, f, this.aRX.IA() / 2, this.aRX.IB() / 2);
            this.aRX.a(1.0f / f, f4, f5);
            this.aSa *= f;
            this.aRX.G(1.0f / this.aSa);
            float[] IN = IN();
            this.aSe.postTranslate(-IN[0], -IN[1]);
            this.aRX.g((IN[0] * 1.0f) / this.aSa, (IN[1] * 1.0f) / this.aSa);
            IM();
            this.aRU.invalidate();
        }
    }

    public boolean HB() {
        Rect Iz;
        return (this.aRX == null || (Iz = this.aRX.Iz()) == null || Iz.top > 10) ? false : true;
    }

    private float[] IN() {
        Rect Iz = this.aRX.Iz();
        int[] IR = this.aRY.IR();
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
        fArr[0] = fArr[0] * this.aSa;
        fArr[1] = fArr[1] * this.aSa;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.aRX != null) {
            float[] h = h(f, f2);
            this.aSe.postTranslate(-h[0], -h[1]);
            this.aRX.g((h[0] * 1.0f) / this.aSa, (h[1] * 1.0f) / this.aSa);
            IM();
            this.aRU.invalidate();
        }
    }

    private float[] h(float f, float f2) {
        float[] fArr = new float[2];
        Rect Iz = this.aRX.Iz();
        int[] IR = this.aRY.IR();
        if (Iz.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Iz.bottom + f2 > IR[1]) {
            f2 = (IR[1] - Iz.bottom) * this.aSa;
        }
        if (Iz.bottom - Iz.top > IR[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.aSi = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IO() {
        if (this.aRX != null) {
            this.aRX.H(1.0f / this.aNB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.IA() * 1.0f) / bitmap.getWidth(), (bVar.IB() * 1.0f) / bitmap.getHeight());
        this.aSe.postScale(max, max);
        this.aRZ = max * (1.0f / i);
        this.aNB = this.aRZ;
        this.aSa = this.aNB;
        this.aNC = 2.0f * this.aSa;
        float IA = (bVar.IA() * 1.0f) / this.aRW.getWidth();
        if (IA > 1.0f) {
            this.aRZ /= IA;
        }
        bVar.G(1.0f / this.aSa);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int aSo;
        int aSp;

        public a(Context context) {
            super(context);
            this.aSo = 0;
            this.aSp = 0;
        }

        public void fJ(int i) {
            this.aSo = i;
        }

        public void fK(int i) {
            this.aSp = i;
        }

        public int IP() {
            return this.aSo;
        }

        public int IQ() {
            return this.aSp;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.aSo = 0;
            this.aSp = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

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
    private final View aRR;
    private ScaleGestureDetector aRS;
    private BitmapRegionDecoder aRT;
    private com.baidu.tbadk.widget.a.a.b aRU;
    private com.baidu.tbadk.widget.a.c.a aRV;
    private float aRW;
    private float aRX;
    private int aRY;
    private a aRZ;
    private com.baidu.tbadk.widget.a.c.c aSa;
    private com.baidu.tbadk.widget.a.b.a aSd;
    private ValueAnimator aSe;
    private View.OnLongClickListener ayH;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aNz = 2.0f;
    private float aNy = 1.0f;
    private final Matrix aSb = new Matrix();
    Bitmap aSc = null;
    private boolean aSf = true;
    private boolean aSg = false;
    BdAsyncTask<String, String, String> aSh = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.aRU != null && b.this.aRT != null) {
                int[] IQ = b.this.aRV.IQ();
                int i = 1;
                while (Math.max(IQ[0] / b.this.aRU.Iz(), IQ[1] / b.this.aRU.IA()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, IQ[0], IQ[1]);
                try {
                    b.this.aSc = b.this.aRT.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.aSc = b.this.aRT.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.aSc = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Ez().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.aSc, false));
                b.this.a(b.this.aSc, b.this.aRU, pow);
                b.this.aRU.i(b.this.aSc);
                b.this.IN();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.aSd != null) {
                b.this.aSd.BO();
            }
            b.this.IL();
            b.this.aRR.invalidate();
        }
    };

    public b(View view) {
        this.aRY = 1;
        this.aRR = view;
        this.mContext = this.aRR.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0067b());
        this.aRS = new ScaleGestureDetector(this.mContext, new c());
        this.aRZ = new a(this.mContext);
        this.aRY = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.aRY == 2 && IH()) {
            switch (action) {
                case 0:
                    if (!this.aRZ.isFinished()) {
                        this.aSg = true;
                    } else {
                        this.aSg = false;
                    }
                case 1:
                case 3:
                    HB();
                    break;
            }
            this.aRZ.forceFinished(true);
            this.aRS.onTouchEvent(motionEvent);
            if (this.aRS.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean IE() {
        return Math.floor((double) (this.aNy * 10000.0f)) == Math.floor((double) (this.aRX * 10000.0f));
    }

    public void HB() {
        if (this.aRX / this.aNy < 1.0f) {
            a(this.aNy, 0.0f, 0.0f, 400);
        }
    }

    public boolean IF() {
        if (this.aRY == 1) {
            return false;
        }
        if (this.aRZ.computeScrollOffset()) {
            int currX = this.aRZ.getCurrX();
            this.aRZ.fJ(currX);
            int currY = this.aRZ.getCurrY();
            this.aRZ.fK(currY);
            moveTo(-((currX - this.aRZ.IO()) * 2.0f), -((currY - this.aRZ.IP()) * 2.0f));
            this.aRR.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.aRV == null) {
            this.mOriginalBitmap = bitmap;
            this.aRV = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.aRT = this.aRV.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.aRT = this.aRV.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.aRY = 2;
            IG();
        }
    }

    public void IG() {
        if (this.aRY == 2 && this.aRV != null && this.aSh.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.aRU == null && this.aRR.getMeasuredWidth() > 0 && this.aRR.getMeasuredHeight() > 0 && this.aRV.IQ()[0] > 0 && this.aRV.IQ()[1] > 0) {
            this.aRU = new com.baidu.tbadk.widget.a.a.b(this.aRR.getMeasuredWidth(), this.aRR.getMeasuredHeight(), this.aRV.IQ());
            this.aSh.setPriority(3);
            this.aSh.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayH = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !IH()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.aRR.getWidth() - this.aRR.getPaddingLeft()) - this.aRR.getPaddingRight();
            int height2 = (this.aRR.getHeight() - this.aRR.getPaddingTop()) - this.aRR.getPaddingBottom();
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

    private boolean IH() {
        return (this.aRU == null || this.aRU.ID() == null || this.aRU.ID().getBitmap() == null || this.aRU.ID().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean g(Canvas canvas) {
        if (this.aRY != 1 || this.mOriginalBitmap == null) {
            if (this.aRU != null) {
                this.aRU.Iy();
                if (IH()) {
                    canvas.drawBitmap(this.aRU.ID().getBitmap(), this.aSb, null);
                }
                a(this.aRU, false);
                IK();
                canvas.save();
                float Iu = (1.0f * this.aRU.Iu()) / this.aRU.IC();
                canvas.scale(Iu, Iu);
                List<com.baidu.tbadk.widget.a.a.a> IB = this.aRU.IB();
                if (IB != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : IB) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.Iq(), aVar.Ir(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float II() {
        return this.aNy;
    }

    public float getMinScaleValue() {
        if (this.aNy < 1.0f) {
            return this.aNy;
        }
        return 1.0f;
    }

    public float IJ() {
        return 2.0f * this.aNy;
    }

    public void release() {
        if (this.aSe != null) {
            this.aSe.cancel();
        }
        if (this.aSh != null) {
            this.aSh.cancel();
        }
        if (this.aSa != null) {
            this.aSa.onDestory();
        }
        if (this.aRU != null && this.aRU.IB() != null) {
            this.aRU.IB().clear();
        }
        if (this.aSc != null) {
            this.aSc.recycle();
            this.aSc = null;
        }
        if (this.aRT != null) {
            this.aRT.recycle();
        }
    }

    private void IK() {
        List<com.baidu.tbadk.widget.a.a.a> IB = this.aRU.IB();
        if (IB != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : IB) {
                a(aVar, this.aRU);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.aSd = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.Is().Eg() == 0 && aVar.Is().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.Iy());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int Iu = aVar.Is().Iu();
        aVar.k((i - rect.left) / Iu, (i3 - rect.top) / Iu, (i2 - rect.left) / Iu, (i4 - rect.top) / Iu);
        aVar.j((i - rect2.left) / Iu, (i3 - rect2.top) / Iu, (i2 - rect2.left) / Iu, (i4 - rect2.top) / Iu);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.Iw(), bVar.Iu(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.aSa == null) {
            this.aSa = new com.baidu.tbadk.widget.a.c.c(this.aRU, this.aRT);
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
            List<com.baidu.tbadk.widget.a.a.a> IB = this.aRU.IB();
            IB.clear();
            i2 = i3;
            z2 = true;
            list = IB;
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
            this.aSa.IS();
        }
    }

    public void IL() {
        if (this.aRY != 1) {
            a(this.aRU, true);
        }
    }

    private void s(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.aSa.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a t(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0066a c0066a = new a.C0066a(i, i2, i3);
        if (this.aSa.IT() != null && (aVar = this.aSa.IT().get(c0066a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.aSa.IT().remove(c0066a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void BO() {
        this.aRR.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0067b extends GestureDetector.SimpleOnGestureListener {
        private C0067b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aSg = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.aRX == b.this.aNz ? b.this.aNy : b.this.aNz, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Iy = b.this.aRU.Iy();
            Rect Iv = b.this.aRU.Iv();
            float f3 = Iy.right - Iv.right;
            float f4 = Iy.left - Iv.left;
            float f5 = Iy.bottom - Iv.bottom;
            float f6 = Iy.top - Iv.top;
            b.this.aRZ.forceFinished(true);
            b.this.aRZ.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.aRR.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aSg = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.aSg || b.this.ayH == null) {
                b.this.aSg = false;
            } else {
                b.this.ayH.onLongClick(b.this.aRR);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.aSg || b.this.mClickListener == null) {
                b.this.aSg = false;
            } else {
                b.this.mClickListener.onClick(b.this.aRR);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.aSe != null) {
            this.aSe.cancel();
        }
        this.aSe = ValueAnimator.ofFloat(this.aRX, f);
        this.aSe.setDuration(i);
        this.aSe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.aRX, f2, f3);
                }
            }
        });
        this.aSe.start();
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
        if (this.aRX * f < this.aRW) {
            f = this.aRW / this.aRX;
        }
        if (this.aRX * f > this.aNz) {
            f = this.aNz / this.aRX;
        }
        Rect Iy = this.aRU.Iy();
        float f4 = ((Iy.left + Iy.right) * 1.0f) / 2.0f;
        float f5 = ((Iy.bottom + Iy.top) * 1.0f) / 2.0f;
        if (this.aRU != null) {
            this.aSb.postScale(f, f, this.aRU.Iz() / 2, this.aRU.IA() / 2);
            this.aRU.a(1.0f / f, f4, f5);
            this.aRX *= f;
            this.aRU.G(1.0f / this.aRX);
            float[] IM = IM();
            this.aSb.postTranslate(-IM[0], -IM[1]);
            this.aRU.g((IM[0] * 1.0f) / this.aRX, (IM[1] * 1.0f) / this.aRX);
            IL();
            this.aRR.invalidate();
        }
    }

    public boolean HA() {
        Rect Iy;
        return (this.aRU == null || (Iy = this.aRU.Iy()) == null || Iy.top > 10) ? false : true;
    }

    private float[] IM() {
        Rect Iy = this.aRU.Iy();
        int[] IQ = this.aRV.IQ();
        float[] fArr = {(IQ[0] / 2) - (((Iy.left + Iy.right) * 1.0f) / 2.0f)};
        if (Iy.top < 0) {
            fArr[1] = 0 - Iy.top;
        }
        if (Iy.bottom > IQ[1]) {
            fArr[1] = IQ[1] - Iy.bottom;
        }
        if (Iy.bottom - Iy.top > IQ[1]) {
            fArr[1] = (IQ[1] / 2) - (((Iy.bottom + Iy.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.aRX;
        fArr[1] = fArr[1] * this.aRX;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.aRU != null) {
            float[] h = h(f, f2);
            this.aSb.postTranslate(-h[0], -h[1]);
            this.aRU.g((h[0] * 1.0f) / this.aRX, (h[1] * 1.0f) / this.aRX);
            IL();
            this.aRR.invalidate();
        }
    }

    private float[] h(float f, float f2) {
        float[] fArr = new float[2];
        Rect Iy = this.aRU.Iy();
        int[] IQ = this.aRV.IQ();
        if (Iy.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Iy.bottom + f2 > IQ[1]) {
            f2 = (IQ[1] - Iy.bottom) * this.aRX;
        }
        if (Iy.bottom - Iy.top > IQ[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.aSf = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN() {
        if (this.aRU != null) {
            this.aRU.H(1.0f / this.aNy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.Iz() * 1.0f) / bitmap.getWidth(), (bVar.IA() * 1.0f) / bitmap.getHeight());
        this.aSb.postScale(max, max);
        this.aRW = max * (1.0f / i);
        this.aNy = this.aRW;
        this.aRX = this.aNy;
        this.aNz = 2.0f * this.aRX;
        float Iz = (bVar.Iz() * 1.0f) / this.aRT.getWidth();
        if (Iz > 1.0f) {
            this.aRW /= Iz;
        }
        bVar.G(1.0f / this.aRX);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int aSl;
        int aSm;

        public a(Context context) {
            super(context);
            this.aSl = 0;
            this.aSm = 0;
        }

        public void fJ(int i) {
            this.aSl = i;
        }

        public void fK(int i) {
            this.aSm = i;
        }

        public int IO() {
            return this.aSl;
        }

        public int IP() {
            return this.aSm;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.aSl = 0;
            this.aSm = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

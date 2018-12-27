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
    private View.OnLongClickListener aVu;
    private final View bnH;
    private ScaleGestureDetector bnI;
    private BitmapRegionDecoder bnJ;
    private com.baidu.tbadk.widget.largeImage.a.b bnK;
    private com.baidu.tbadk.widget.largeImage.b.a bnL;
    private float bnM;
    private float bnN;
    private Bitmap bnO;
    private int bnP;
    private a bnQ;
    private com.baidu.tbadk.widget.largeImage.b.c bnR;
    private com.baidu.tbadk.widget.largeImage.logic.a bnU;
    private ValueAnimator bnV;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float bjg = 2.0f;
    private float bjf = 1.0f;
    private final Matrix bnS = new Matrix();
    Bitmap bnT = null;
    private boolean bnW = true;
    private boolean bnX = false;
    BdAsyncTask<String, String, String> bnY = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.bnK != null && b.this.bnJ != null) {
                int[] RD = b.this.bnL.RD();
                int i = 1;
                while (Math.max(RD[0] / b.this.bnK.getRealWidth(), RD[1] / b.this.bnK.Rn()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, RD[0], RD[1]);
                try {
                    b.this.bnT = b.this.bnJ.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bnT = b.this.bnJ.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bnT = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Nv().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.bnT, false));
                b.this.a(b.this.bnT, b.this.bnK, pow);
                b.this.bnK.k(b.this.bnT);
                b.this.RA();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bnU != null) {
                b.this.bnU.KS();
            }
            b.this.Ry();
            b.this.bnH.invalidate();
        }
    };

    public b(View view) {
        this.bnP = 1;
        this.bnH = view;
        this.mContext = this.bnH.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0179b());
        this.bnI = new ScaleGestureDetector(this.mContext, new c());
        this.bnQ = new a(this.mContext);
        this.bnP = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bnP == 2 && Ru()) {
            switch (action) {
                case 0:
                    if (!this.bnQ.isFinished()) {
                        this.bnX = true;
                    } else {
                        this.bnX = false;
                    }
                case 1:
                case 3:
                    Qr();
                    break;
            }
            this.bnQ.forceFinished(true);
            this.bnI.onTouchEvent(motionEvent);
            if (this.bnI.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Rr() {
        return Math.floor((double) (this.bjf * 10000.0f)) == Math.floor((double) (this.bnN * 10000.0f));
    }

    public void Qr() {
        if (this.bnN / this.bjf < 1.0f) {
            a(this.bjf, 0.0f, 0.0f, 400);
        }
    }

    public boolean Rs() {
        if (this.bnP == 1) {
            return false;
        }
        if (this.bnQ.computeScrollOffset()) {
            int currX = this.bnQ.getCurrX();
            this.bnQ.gC(currX);
            int currY = this.bnQ.getCurrY();
            this.bnQ.gD(currY);
            moveTo(-((currX - this.bnQ.RB()) * 2.0f), -((currY - this.bnQ.RC()) * 2.0f));
            this.bnH.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bnL == null) {
            this.bnO = bitmap;
            this.bnL = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.bnJ = this.bnL.G(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bnJ = this.bnL.G(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bnP = 2;
            Rt();
        }
    }

    public void Rt() {
        if (this.bnP == 2 && this.bnL != null && this.bnY.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bnK == null && this.bnH.getMeasuredWidth() > 0 && this.bnH.getMeasuredHeight() > 0 && this.bnL.RD()[0] > 0 && this.bnL.RD()[1] > 0) {
            this.bnK = new com.baidu.tbadk.widget.largeImage.a.b(this.bnH.getMeasuredWidth(), this.bnH.getMeasuredHeight(), this.bnL.RD());
            this.bnY.setPriority(3);
            this.bnY.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aVu = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !Ru()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bnH.getWidth() - this.bnH.getPaddingLeft()) - this.bnH.getPaddingRight();
            int height2 = (this.bnH.getHeight() - this.bnH.getPaddingTop()) - this.bnH.getPaddingBottom();
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

    private boolean Ru() {
        return (this.bnK == null || this.bnK.Rq() == null || this.bnK.Rq().getBitmap() == null || this.bnK.Rq().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(Canvas canvas) {
        if (this.bnP != 1 || this.bnO == null) {
            if (this.bnK != null) {
                this.bnK.Rm();
                if (Ru()) {
                    canvas.drawBitmap(this.bnK.Rq().getBitmap(), this.bnS, null);
                }
                a(this.bnK, false);
                Rx();
                canvas.save();
                float Ri = (1.0f * this.bnK.Ri()) / this.bnK.Rp();
                canvas.scale(Ri, Ri);
                List<com.baidu.tbadk.widget.largeImage.a.a> Ro = this.bnK.Ro();
                if (Ro != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : Ro) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.Re(), aVar.Rf(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float Rv() {
        return this.bjf;
    }

    public float getMinScaleValue() {
        if (this.bjf < 1.0f) {
            return this.bjf;
        }
        return 1.0f;
    }

    public float Rw() {
        return 2.0f * this.bjf;
    }

    public void release() {
        if (this.bnV != null) {
            this.bnV.cancel();
        }
        if (this.bnY != null) {
            this.bnY.cancel();
        }
        if (this.bnR != null) {
            this.bnR.onDestory();
        }
        if (this.bnK != null && this.bnK.Ro() != null) {
            this.bnK.Ro().clear();
        }
        if (this.bnT != null) {
            this.bnT.recycle();
            this.bnT = null;
        }
        if (this.bnJ != null) {
            this.bnJ.recycle();
        }
    }

    private void Rx() {
        List<com.baidu.tbadk.widget.largeImage.a.a> Ro = this.bnK.Ro();
        if (Ro != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : Ro) {
                a(aVar, this.bnK);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.bnU = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.Rg().Nb() == 0 && aVar.Rg().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.Rm());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int Ri = aVar.Rg().Ri();
        aVar.j((i - rect.left) / Ri, (i3 - rect.top) / Ri, (i2 - rect.left) / Ri, (i4 - rect.top) / Ri);
        aVar.i((i - rect2.left) / Ri, (i3 - rect2.top) / Ri, (i2 - rect2.left) / Ri, (i4 - rect2.top) / Ri);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.Rk(), bVar.Ri(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.bnR == null) {
            this.bnR = new com.baidu.tbadk.widget.largeImage.b.c(this.bnK, this.bnJ);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> Ro = this.bnK.Ro();
            Ro.clear();
            i2 = i3;
            z2 = true;
            list = Ro;
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
            this.bnR.RF();
        }
    }

    public void Ry() {
        if (this.bnP != 1) {
            a(this.bnK, true);
        }
    }

    private void t(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bnR.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a u(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0178a c0178a = new a.C0178a(i, i2, i3);
        if (this.bnR.RG() != null && (aVar = this.bnR.RG().get(c0178a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bnR.RG().remove(c0178a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void KS() {
        this.bnH.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0179b extends GestureDetector.SimpleOnGestureListener {
        private C0179b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bnX = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bnN == b.this.bjg ? b.this.bjf : b.this.bjg, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Rm = b.this.bnK.Rm();
            Rect Rj = b.this.bnK.Rj();
            float f3 = Rm.right - Rj.right;
            float f4 = Rm.left - Rj.left;
            float f5 = Rm.bottom - Rj.bottom;
            float f6 = Rm.top - Rj.top;
            b.this.bnQ.forceFinished(true);
            b.this.bnQ.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bnH.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bnX = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bnX || b.this.aVu == null) {
                b.this.bnX = false;
            } else {
                b.this.aVu.onLongClick(b.this.bnH);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bnX || b.this.mClickListener == null) {
                b.this.bnX = false;
            } else {
                b.this.mClickListener.onClick(b.this.bnH);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bnV != null) {
            this.bnV.cancel();
        }
        this.bnV = ValueAnimator.ofFloat(this.bnN, f);
        this.bnV.setDuration(i);
        this.bnV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bnN, f2, f3);
                }
            }
        });
        this.bnV.start();
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
        if (this.bnN * f < this.bnM) {
            f = this.bnM / this.bnN;
        }
        if (this.bnN * f > this.bjg) {
            f = this.bjg / this.bnN;
        }
        Rect Rm = this.bnK.Rm();
        float f4 = ((Rm.left + Rm.right) * 1.0f) / 2.0f;
        float f5 = ((Rm.bottom + Rm.top) * 1.0f) / 2.0f;
        if (this.bnK != null) {
            this.bnS.postScale(f, f, this.bnK.getRealWidth() / 2, this.bnK.Rn() / 2);
            this.bnK.b(1.0f / f, f4, f5);
            this.bnN *= f;
            this.bnK.ac(1.0f / this.bnN);
            float[] Rz = Rz();
            this.bnS.postTranslate(-Rz[0], -Rz[1]);
            this.bnK.r((Rz[0] * 1.0f) / this.bnN, (Rz[1] * 1.0f) / this.bnN);
            Ry();
            this.bnH.invalidate();
        }
    }

    public boolean Qq() {
        Rect Rm;
        return (this.bnK == null || (Rm = this.bnK.Rm()) == null || Rm.top > 10) ? false : true;
    }

    private float[] Rz() {
        Rect Rm = this.bnK.Rm();
        int[] RD = this.bnL.RD();
        float[] fArr = {(RD[0] / 2) - (((Rm.left + Rm.right) * 1.0f) / 2.0f)};
        if (Rm.top < 0) {
            fArr[1] = 0 - Rm.top;
        }
        if (Rm.bottom > RD[1]) {
            fArr[1] = RD[1] - Rm.bottom;
        }
        if (Rm.bottom - Rm.top > RD[1]) {
            fArr[1] = (RD[1] / 2) - (((Rm.bottom + Rm.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bnN;
        fArr[1] = fArr[1] * this.bnN;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bnK != null) {
            float[] s = s(f, f2);
            this.bnS.postTranslate(-s[0], -s[1]);
            this.bnK.r((s[0] * 1.0f) / this.bnN, (s[1] * 1.0f) / this.bnN);
            Ry();
            this.bnH.invalidate();
        }
    }

    private float[] s(float f, float f2) {
        float[] fArr = new float[2];
        Rect Rm = this.bnK.Rm();
        int[] RD = this.bnL.RD();
        if (Rm.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Rm.bottom + f2 > RD[1]) {
            f2 = (RD[1] - Rm.bottom) * this.bnN;
        }
        if (Rm.bottom - Rm.top > RD[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bnW = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RA() {
        if (this.bnK != null) {
            this.bnK.ad(1.0f / this.bjf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.Rn() * 1.0f) / bitmap.getHeight());
        this.bnS.postScale(max, max);
        this.bnM = max * (1.0f / i);
        this.bjf = this.bnM;
        this.bnN = this.bjf;
        this.bjg = 2.0f * this.bnN;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bnJ.getWidth();
        if (realWidth > 1.0f) {
            this.bnM /= realWidth;
        }
        bVar.ac(1.0f / this.bnN);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int boc;
        int bod;

        public a(Context context) {
            super(context);
            this.boc = 0;
            this.bod = 0;
        }

        public void gC(int i) {
            this.boc = i;
        }

        public void gD(int i) {
            this.bod = i;
        }

        public int RB() {
            return this.boc;
        }

        public int RC() {
            return this.bod;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.boc = 0;
            this.bod = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

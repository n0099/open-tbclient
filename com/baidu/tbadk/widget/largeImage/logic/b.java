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
    private View.OnLongClickListener aVr;
    private final View bnE;
    private ScaleGestureDetector bnF;
    private BitmapRegionDecoder bnG;
    private com.baidu.tbadk.widget.largeImage.a.b bnH;
    private com.baidu.tbadk.widget.largeImage.b.a bnI;
    private float bnJ;
    private float bnK;
    private Bitmap bnL;
    private int bnM;
    private a bnN;
    private com.baidu.tbadk.widget.largeImage.b.c bnO;
    private com.baidu.tbadk.widget.largeImage.logic.a bnR;
    private ValueAnimator bnS;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float bjd = 2.0f;
    private float bjc = 1.0f;
    private final Matrix bnP = new Matrix();
    Bitmap bnQ = null;
    private boolean bnT = true;
    private boolean bnU = false;
    BdAsyncTask<String, String, String> bnV = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.bnH != null && b.this.bnG != null) {
                int[] RB = b.this.bnI.RB();
                int i = 1;
                while (Math.max(RB[0] / b.this.bnH.getRealWidth(), RB[1] / b.this.bnH.Rl()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, RB[0], RB[1]);
                try {
                    b.this.bnQ = b.this.bnG.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bnQ = b.this.bnG.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bnQ = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Nu().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.bnQ, false));
                b.this.a(b.this.bnQ, b.this.bnH, pow);
                b.this.bnH.k(b.this.bnQ);
                b.this.Ry();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bnR != null) {
                b.this.bnR.KR();
            }
            b.this.Rw();
            b.this.bnE.invalidate();
        }
    };

    public b(View view) {
        this.bnM = 1;
        this.bnE = view;
        this.mContext = this.bnE.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0179b());
        this.bnF = new ScaleGestureDetector(this.mContext, new c());
        this.bnN = new a(this.mContext);
        this.bnM = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bnM == 2 && Rs()) {
            switch (action) {
                case 0:
                    if (!this.bnN.isFinished()) {
                        this.bnU = true;
                    } else {
                        this.bnU = false;
                    }
                case 1:
                case 3:
                    Qp();
                    break;
            }
            this.bnN.forceFinished(true);
            this.bnF.onTouchEvent(motionEvent);
            if (this.bnF.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Rp() {
        return Math.floor((double) (this.bjc * 10000.0f)) == Math.floor((double) (this.bnK * 10000.0f));
    }

    public void Qp() {
        if (this.bnK / this.bjc < 1.0f) {
            a(this.bjc, 0.0f, 0.0f, 400);
        }
    }

    public boolean Rq() {
        if (this.bnM == 1) {
            return false;
        }
        if (this.bnN.computeScrollOffset()) {
            int currX = this.bnN.getCurrX();
            this.bnN.gB(currX);
            int currY = this.bnN.getCurrY();
            this.bnN.gC(currY);
            moveTo(-((currX - this.bnN.Rz()) * 2.0f), -((currY - this.bnN.RA()) * 2.0f));
            this.bnE.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bnI == null) {
            this.bnL = bitmap;
            this.bnI = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.bnG = this.bnI.G(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bnG = this.bnI.G(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bnM = 2;
            Rr();
        }
    }

    public void Rr() {
        if (this.bnM == 2 && this.bnI != null && this.bnV.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bnH == null && this.bnE.getMeasuredWidth() > 0 && this.bnE.getMeasuredHeight() > 0 && this.bnI.RB()[0] > 0 && this.bnI.RB()[1] > 0) {
            this.bnH = new com.baidu.tbadk.widget.largeImage.a.b(this.bnE.getMeasuredWidth(), this.bnE.getMeasuredHeight(), this.bnI.RB());
            this.bnV.setPriority(3);
            this.bnV.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aVr = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !Rs()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bnE.getWidth() - this.bnE.getPaddingLeft()) - this.bnE.getPaddingRight();
            int height2 = (this.bnE.getHeight() - this.bnE.getPaddingTop()) - this.bnE.getPaddingBottom();
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

    private boolean Rs() {
        return (this.bnH == null || this.bnH.Ro() == null || this.bnH.Ro().getBitmap() == null || this.bnH.Ro().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(Canvas canvas) {
        if (this.bnM != 1 || this.bnL == null) {
            if (this.bnH != null) {
                this.bnH.Rk();
                if (Rs()) {
                    canvas.drawBitmap(this.bnH.Ro().getBitmap(), this.bnP, null);
                }
                a(this.bnH, false);
                Rv();
                canvas.save();
                float Rg = (1.0f * this.bnH.Rg()) / this.bnH.Rn();
                canvas.scale(Rg, Rg);
                List<com.baidu.tbadk.widget.largeImage.a.a> Rm = this.bnH.Rm();
                if (Rm != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : Rm) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.Rc(), aVar.Rd(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float Rt() {
        return this.bjc;
    }

    public float getMinScaleValue() {
        if (this.bjc < 1.0f) {
            return this.bjc;
        }
        return 1.0f;
    }

    public float Ru() {
        return 2.0f * this.bjc;
    }

    public void release() {
        if (this.bnS != null) {
            this.bnS.cancel();
        }
        if (this.bnV != null) {
            this.bnV.cancel();
        }
        if (this.bnO != null) {
            this.bnO.onDestory();
        }
        if (this.bnH != null && this.bnH.Rm() != null) {
            this.bnH.Rm().clear();
        }
        if (this.bnQ != null) {
            this.bnQ.recycle();
            this.bnQ = null;
        }
        if (this.bnG != null) {
            this.bnG.recycle();
        }
    }

    private void Rv() {
        List<com.baidu.tbadk.widget.largeImage.a.a> Rm = this.bnH.Rm();
        if (Rm != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : Rm) {
                a(aVar, this.bnH);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.bnR = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.Re().Na() == 0 && aVar.Re().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.Rk());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int Rg = aVar.Re().Rg();
        aVar.j((i - rect.left) / Rg, (i3 - rect.top) / Rg, (i2 - rect.left) / Rg, (i4 - rect.top) / Rg);
        aVar.i((i - rect2.left) / Rg, (i3 - rect2.top) / Rg, (i2 - rect2.left) / Rg, (i4 - rect2.top) / Rg);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.Ri(), bVar.Rg(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.bnO == null) {
            this.bnO = new com.baidu.tbadk.widget.largeImage.b.c(this.bnH, this.bnG);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> Rm = this.bnH.Rm();
            Rm.clear();
            i2 = i3;
            z2 = true;
            list = Rm;
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
            this.bnO.RD();
        }
    }

    public void Rw() {
        if (this.bnM != 1) {
            a(this.bnH, true);
        }
    }

    private void t(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bnO.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a u(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0178a c0178a = new a.C0178a(i, i2, i3);
        if (this.bnO.RE() != null && (aVar = this.bnO.RE().get(c0178a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bnO.RE().remove(c0178a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void KR() {
        this.bnE.postInvalidate();
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
                b.this.bnU = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bnK == b.this.bjd ? b.this.bjc : b.this.bjd, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Rk = b.this.bnH.Rk();
            Rect Rh = b.this.bnH.Rh();
            float f3 = Rk.right - Rh.right;
            float f4 = Rk.left - Rh.left;
            float f5 = Rk.bottom - Rh.bottom;
            float f6 = Rk.top - Rh.top;
            b.this.bnN.forceFinished(true);
            b.this.bnN.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bnE.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bnU = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bnU || b.this.aVr == null) {
                b.this.bnU = false;
            } else {
                b.this.aVr.onLongClick(b.this.bnE);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bnU || b.this.mClickListener == null) {
                b.this.bnU = false;
            } else {
                b.this.mClickListener.onClick(b.this.bnE);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bnS != null) {
            this.bnS.cancel();
        }
        this.bnS = ValueAnimator.ofFloat(this.bnK, f);
        this.bnS.setDuration(i);
        this.bnS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bnK, f2, f3);
                }
            }
        });
        this.bnS.start();
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
        if (this.bnK * f < this.bnJ) {
            f = this.bnJ / this.bnK;
        }
        if (this.bnK * f > this.bjd) {
            f = this.bjd / this.bnK;
        }
        Rect Rk = this.bnH.Rk();
        float f4 = ((Rk.left + Rk.right) * 1.0f) / 2.0f;
        float f5 = ((Rk.bottom + Rk.top) * 1.0f) / 2.0f;
        if (this.bnH != null) {
            this.bnP.postScale(f, f, this.bnH.getRealWidth() / 2, this.bnH.Rl() / 2);
            this.bnH.b(1.0f / f, f4, f5);
            this.bnK *= f;
            this.bnH.ac(1.0f / this.bnK);
            float[] Rx = Rx();
            this.bnP.postTranslate(-Rx[0], -Rx[1]);
            this.bnH.r((Rx[0] * 1.0f) / this.bnK, (Rx[1] * 1.0f) / this.bnK);
            Rw();
            this.bnE.invalidate();
        }
    }

    public boolean Qo() {
        Rect Rk;
        return (this.bnH == null || (Rk = this.bnH.Rk()) == null || Rk.top > 10) ? false : true;
    }

    private float[] Rx() {
        Rect Rk = this.bnH.Rk();
        int[] RB = this.bnI.RB();
        float[] fArr = {(RB[0] / 2) - (((Rk.left + Rk.right) * 1.0f) / 2.0f)};
        if (Rk.top < 0) {
            fArr[1] = 0 - Rk.top;
        }
        if (Rk.bottom > RB[1]) {
            fArr[1] = RB[1] - Rk.bottom;
        }
        if (Rk.bottom - Rk.top > RB[1]) {
            fArr[1] = (RB[1] / 2) - (((Rk.bottom + Rk.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bnK;
        fArr[1] = fArr[1] * this.bnK;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bnH != null) {
            float[] s = s(f, f2);
            this.bnP.postTranslate(-s[0], -s[1]);
            this.bnH.r((s[0] * 1.0f) / this.bnK, (s[1] * 1.0f) / this.bnK);
            Rw();
            this.bnE.invalidate();
        }
    }

    private float[] s(float f, float f2) {
        float[] fArr = new float[2];
        Rect Rk = this.bnH.Rk();
        int[] RB = this.bnI.RB();
        if (Rk.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Rk.bottom + f2 > RB[1]) {
            f2 = (RB[1] - Rk.bottom) * this.bnK;
        }
        if (Rk.bottom - Rk.top > RB[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bnT = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ry() {
        if (this.bnH != null) {
            this.bnH.ad(1.0f / this.bjc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.Rl() * 1.0f) / bitmap.getHeight());
        this.bnP.postScale(max, max);
        this.bnJ = max * (1.0f / i);
        this.bjc = this.bnJ;
        this.bnK = this.bjc;
        this.bjd = 2.0f * this.bnK;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bnG.getWidth();
        if (realWidth > 1.0f) {
            this.bnJ /= realWidth;
        }
        bVar.ac(1.0f / this.bnK);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bnZ;
        int boa;

        public a(Context context) {
            super(context);
            this.bnZ = 0;
            this.boa = 0;
        }

        public void gB(int i) {
            this.bnZ = i;
        }

        public void gC(int i) {
            this.boa = i;
        }

        public int Rz() {
            return this.bnZ;
        }

        public int RA() {
            return this.boa;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bnZ = 0;
            this.boa = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

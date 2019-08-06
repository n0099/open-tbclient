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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.largeImage.a.a;
import com.baidu.tbadk.widget.largeImage.b.c;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.List;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.largeImage.logic.a {
    private static final String TAG = b.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    private final View cII;
    private ScaleGestureDetector cIJ;
    private BitmapRegionDecoder cIK;
    private com.baidu.tbadk.widget.largeImage.a.b cIL;
    private com.baidu.tbadk.widget.largeImage.b.a cIM;
    private float cIN;
    private float cIO;
    private Bitmap cIP;
    private int cIQ;
    private a cIR;
    private com.baidu.tbadk.widget.largeImage.b.c cIS;
    private com.baidu.tbadk.widget.largeImage.logic.a cIV;
    private ValueAnimator cIW;
    private View.OnLongClickListener coY;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float cDM = 2.0f;
    private float cDL = 1.0f;
    private final Matrix cIT = new Matrix();
    Bitmap cIU = null;
    private boolean cIX = true;
    private boolean cIY = false;
    BdAsyncTask<String, String, String> cIZ = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.cIL != null && b.this.cIK != null) {
                int[] agr = b.this.cIM.agr();
                int i = 1;
                while (Math.max(agr[0] / b.this.cIL.getRealWidth(), agr[1] / b.this.cIL.axW()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, agr[0], agr[1]);
                try {
                    b.this.cIU = b.this.cIK.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.cIU = b.this.cIK.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.cIU = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.aty().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.cIU, false));
                b.this.a(b.this.cIU, b.this.cIL, pow);
                b.this.cIL.r(b.this.cIU);
                b.this.ayj();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.cIV != null) {
                b.this.cIV.aqO();
            }
            b.this.ayh();
            b.this.cII.invalidate();
        }
    };

    public b(View view) {
        this.cIQ = 1;
        this.cII = view;
        this.mContext = this.cII.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0264b());
        this.cIJ = new ScaleGestureDetector(this.mContext, new c());
        this.cIR = new a(this.mContext);
        this.cIQ = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.cIQ == 2 && ayd()) {
            switch (action) {
                case 0:
                    if (!this.cIR.isFinished()) {
                        this.cIY = true;
                    } else {
                        this.cIY = false;
                    }
                case 1:
                case 3:
                    awQ();
                    break;
            }
            this.cIR.forceFinished(true);
            this.cIJ.onTouchEvent(motionEvent);
            if (this.cIJ.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean aya() {
        return Math.floor((double) (this.cDL * 10000.0f)) == Math.floor((double) (this.cIO * 10000.0f));
    }

    public void awQ() {
        if (this.cIO / this.cDL < 1.0f) {
            a(this.cDL, 0.0f, 0.0f, 400);
        }
    }

    public boolean ayb() {
        if (this.cIQ == 1) {
            return false;
        }
        if (this.cIR.computeScrollOffset()) {
            int currX = this.cIR.getCurrX();
            int currY = this.cIR.getCurrY();
            float ayk = (currX - this.cIR.ayk()) * 2.0f;
            float ayl = (currY - this.cIR.ayl()) * 2.0f;
            int ah = l.ah(TbadkCoreApplication.getInst());
            if (ayl >= 0.0f && Math.abs(ayl) <= 20.0f && currX < ah) {
                v(0.0f, -20.0f);
                this.cII.invalidate();
                return true;
            }
            this.cIR.ll(currX);
            this.cIR.lm(currY);
            v(-ayk, -ayl);
            this.cII.invalidate();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2) {
        if (this.cIL != null) {
            float[] w = w(f, f2);
            float f3 = w[0];
            float f4 = w[1];
            this.cIT.postTranslate(-f3, -f4);
            this.cIL.u((f3 * 1.0f) / this.cIO, (f4 * 1.0f) / this.cIO);
            ayh();
            this.cII.invalidate();
        }
    }

    private float[] w(float f, float f2) {
        float[] fArr = new float[2];
        Rect axV = this.cIL.axV();
        int[] agr = this.cIM.agr();
        if (axV.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (axV.bottom + f2 > agr[1]) {
            f2 = (agr[1] - axV.bottom) * this.cIO;
        }
        if (axV.bottom - axV.top > agr[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.cIX = f2 == 0.0f;
        return fArr;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.cIM == null) {
            this.cIP = bitmap;
            this.cIM = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.cIK = this.cIM.I(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.cIK = this.cIM.I(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.cIQ = 2;
            ayc();
        }
    }

    public void ayc() {
        if (this.cIQ == 2 && this.cIM != null && this.cIZ.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.cIL == null && this.cII.getMeasuredWidth() > 0 && this.cII.getMeasuredHeight() > 0 && this.cIM.agr()[0] > 0 && this.cIM.agr()[1] > 0) {
            this.cIL = new com.baidu.tbadk.widget.largeImage.a.b(this.cII.getMeasuredWidth(), this.cII.getMeasuredHeight(), this.cIM.agr());
            this.cIZ.setPriority(3);
            this.cIZ.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.coY = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !ayd()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.cII.getWidth() - this.cII.getPaddingLeft()) - this.cII.getPaddingRight();
            int height2 = (this.cII.getHeight() - this.cII.getPaddingTop()) - this.cII.getPaddingBottom();
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
        return B(canvas);
    }

    private boolean ayd() {
        return (this.cIL == null || this.cIL.axZ() == null || this.cIL.axZ().getBitmap() == null || this.cIL.axZ().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(Canvas canvas) {
        if (this.cIQ != 1 || this.cIP == null) {
            if (this.cIL != null) {
                this.cIL.axV();
                if (ayd()) {
                    canvas.drawBitmap(this.cIL.axZ().getBitmap(), this.cIT, null);
                }
                a(this.cIL, false);
                ayg();
                canvas.save();
                float axR = (1.0f * this.cIL.axR()) / this.cIL.axY();
                canvas.scale(axR, axR);
                List<com.baidu.tbadk.widget.largeImage.a.a> axX = this.cIL.axX();
                if (axX != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : axX) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.axN(), aVar.axO(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float aye() {
        return this.cDL;
    }

    public float getMinScaleValue() {
        if (this.cDL < 1.0f) {
            return this.cDL;
        }
        return 1.0f;
    }

    public float ayf() {
        return 2.0f * this.cDL;
    }

    public void release() {
        if (this.cIW != null) {
            this.cIW.cancel();
        }
        if (this.cIZ != null) {
            this.cIZ.cancel();
        }
        if (this.cIS != null) {
            this.cIS.onDestory();
        }
        if (this.cIL != null && this.cIL.axX() != null) {
            this.cIL.axX().clear();
        }
        if (this.cIU != null) {
            this.cIU.recycle();
            this.cIU = null;
        }
        if (this.cIK != null) {
            this.cIK.recycle();
        }
    }

    private void ayg() {
        List<com.baidu.tbadk.widget.largeImage.a.a> axX = this.cIL.axX();
        if (axX != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : axX) {
                a(aVar, this.cIL);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.cIV = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.axP().ate() == 0 && aVar.axP().atf() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.axV());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int axR = aVar.axP().axR();
        aVar.o((i - rect.left) / axR, (i3 - rect.top) / axR, (i2 - rect.left) / axR, (i4 - rect.top) / axR);
        aVar.n((i - rect2.left) / axR, (i3 - rect2.top) / axR, (i2 - rect2.left) / axR, (i4 - rect2.top) / axR);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.axT(), bVar.axR(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.cIS == null) {
            this.cIS = new com.baidu.tbadk.widget.largeImage.b.c(this.cIL, this.cIK);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> axX = this.cIL.axX();
            axX.clear();
            i2 = i3;
            z2 = true;
            list = axX;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                com.baidu.tbadk.widget.largeImage.a.a y = y(i2, i7, i);
                if (y == null) {
                    if (z) {
                        x(i2, i7, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(y);
                }
            }
            i2++;
        }
        if (z2) {
            this.cIS.ayn();
        }
    }

    public void ayh() {
        if (this.cIQ != 1) {
            a(this.cIL, true);
        }
    }

    private void x(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.cIS.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a y(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0263a c0263a = new a.C0263a(i, i2, i3);
        if (this.cIS.ayo() != null && (aVar = this.cIS.ayo().get(c0263a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.cIS.ayo().remove(c0263a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void aqO() {
        this.cII.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0264b extends GestureDetector.SimpleOnGestureListener {
        private C0264b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.v((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.cIY = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.cIO == b.this.cDM ? b.this.cDL : b.this.cDM, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect axV = b.this.cIL.axV();
            Rect axS = b.this.cIL.axS();
            float f3 = axV.right - axS.right;
            float f4 = axV.left - axS.left;
            float f5 = axV.bottom - axS.bottom;
            float f6 = axV.top - axS.top;
            b.this.cIR.forceFinished(true);
            b.this.cIR.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.cII.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.cIY = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.cIY || b.this.coY == null) {
                b.this.cIY = false;
            } else {
                b.this.coY.onLongClick(b.this.cII);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.cIY || b.this.mClickListener == null) {
                b.this.cIY = false;
            } else {
                b.this.mClickListener.onClick(b.this.cII);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.cIW != null) {
            this.cIW.cancel();
        }
        this.cIW = ValueAnimator.ofFloat(this.cIO, f);
        this.cIW.setDuration(i);
        this.cIW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.cIO, f2, f3);
                }
            }
        });
        this.cIW.start();
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
        if (this.cIO * f < this.cIN) {
            f = this.cIN / this.cIO;
        }
        if (this.cIO * f > this.cDM) {
            f = this.cDM / this.cIO;
        }
        Rect axV = this.cIL.axV();
        float f4 = ((axV.left + axV.right) * 1.0f) / 2.0f;
        float f5 = ((axV.bottom + axV.top) * 1.0f) / 2.0f;
        if (this.cIL != null) {
            this.cIT.postScale(f, f, this.cIL.getRealWidth() / 2, this.cIL.axW() / 2);
            this.cIL.b(1.0f / f, f4, f5);
            this.cIO *= f;
            this.cIL.ar(1.0f / this.cIO);
            float[] ayi = ayi();
            this.cIT.postTranslate(-ayi[0], -ayi[1]);
            this.cIL.u((ayi[0] * 1.0f) / this.cIO, (ayi[1] * 1.0f) / this.cIO);
            ayh();
            this.cII.invalidate();
        }
    }

    public boolean awP() {
        Rect axV;
        return (this.cIL == null || (axV = this.cIL.axV()) == null || axV.top > 10) ? false : true;
    }

    private float[] ayi() {
        Rect axV = this.cIL.axV();
        int[] agr = this.cIM.agr();
        float[] fArr = {(agr[0] / 2) - (((axV.left + axV.right) * 1.0f) / 2.0f)};
        if (axV.top < 0) {
            fArr[1] = 0 - axV.top;
        }
        if (axV.bottom > agr[1]) {
            fArr[1] = agr[1] - axV.bottom;
        }
        if (axV.bottom - axV.top > agr[1]) {
            fArr[1] = (agr[1] / 2) - (((axV.bottom + axV.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.cIO;
        fArr[1] = fArr[1] * this.cIO;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayj() {
        if (this.cIL != null) {
            this.cIL.as(1.0f / this.cDL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.axW() * 1.0f) / bitmap.getHeight());
        this.cIT.postScale(max, max);
        this.cIN = max * (1.0f / i);
        this.cDL = this.cIN;
        this.cIO = this.cDL;
        this.cDM = 2.0f * this.cIO;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.cIK.getWidth();
        if (realWidth > 1.0f) {
            this.cIN /= realWidth;
        }
        bVar.ar(1.0f / this.cIO);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int cJd;
        int cJe;

        public a(Context context) {
            super(context);
            this.cJd = 0;
            this.cJe = 0;
        }

        public void ll(int i) {
            this.cJd = i;
        }

        public void lm(int i) {
            this.cJe = i;
        }

        public int ayk() {
            return this.cJd;
        }

        public int ayl() {
            return this.cJe;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.cJd = 0;
            this.cJe = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

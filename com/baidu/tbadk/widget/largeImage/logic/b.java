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
    private View.OnLongClickListener cfu;
    private final View cyU;
    private ScaleGestureDetector cyV;
    private BitmapRegionDecoder cyW;
    private com.baidu.tbadk.widget.largeImage.a.b cyX;
    private com.baidu.tbadk.widget.largeImage.b.a cyY;
    private float cyZ;
    private float cza;
    private Bitmap czb;
    private int czc;
    private a czd;
    private com.baidu.tbadk.widget.largeImage.b.c cze;
    private com.baidu.tbadk.widget.largeImage.logic.a czh;
    private ValueAnimator czi;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float cua = 2.0f;
    private float ctZ = 1.0f;
    private final Matrix czf = new Matrix();
    Bitmap czg = null;
    private boolean czj = true;
    private boolean czk = false;
    BdAsyncTask<String, String, String> czl = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.cyX != null && b.this.cyW != null) {
                int[] arU = b.this.cyY.arU();
                int i = 1;
                while (Math.max(arU[0] / b.this.cyX.getRealWidth(), arU[1] / b.this.cyX.arE()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, arU[0], arU[1]);
                try {
                    b.this.czg = b.this.cyW.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.czg = b.this.cyW.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.czg = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.anp().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.czg, false));
                b.this.a(b.this.czg, b.this.cyX, pow);
                b.this.cyX.r(b.this.czg);
                b.this.arR();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.czh != null) {
                b.this.czh.akH();
            }
            b.this.arP();
            b.this.cyU.invalidate();
        }
    };

    public b(View view) {
        this.czc = 1;
        this.cyU = view;
        this.mContext = this.cyU.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0247b());
        this.cyV = new ScaleGestureDetector(this.mContext, new c());
        this.czd = new a(this.mContext);
        this.czc = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.czc == 2 && arL()) {
            switch (action) {
                case 0:
                    if (!this.czd.isFinished()) {
                        this.czk = true;
                    } else {
                        this.czk = false;
                    }
                case 1:
                case 3:
                    aqB();
                    break;
            }
            this.czd.forceFinished(true);
            this.cyV.onTouchEvent(motionEvent);
            if (this.cyV.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean arI() {
        return Math.floor((double) (this.ctZ * 10000.0f)) == Math.floor((double) (this.cza * 10000.0f));
    }

    public void aqB() {
        if (this.cza / this.ctZ < 1.0f) {
            a(this.ctZ, 0.0f, 0.0f, 400);
        }
    }

    public boolean arJ() {
        if (this.czc == 1) {
            return false;
        }
        if (this.czd.computeScrollOffset()) {
            int currX = this.czd.getCurrX();
            int currY = this.czd.getCurrY();
            float arS = (currX - this.czd.arS()) * 2.0f;
            float arT = (currY - this.czd.arT()) * 2.0f;
            int aQ = l.aQ(TbadkCoreApplication.getInst());
            if (arT >= 0.0f && Math.abs(arT) <= 20.0f && currX < aQ) {
                moveTo(0.0f, -20.0f);
                this.cyU.invalidate();
                return true;
            }
            this.czd.kq(currX);
            this.czd.kr(currY);
            moveTo(-arS, -arT);
            this.cyU.invalidate();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.cyX != null) {
            float[] v = v(f, f2);
            float f3 = v[0];
            float f4 = v[1];
            this.czf.postTranslate(-f3, -f4);
            this.cyX.u((f3 * 1.0f) / this.cza, (f4 * 1.0f) / this.cza);
            arP();
            this.cyU.invalidate();
        }
    }

    private float[] v(float f, float f2) {
        float[] fArr = new float[2];
        Rect arD = this.cyX.arD();
        int[] arU = this.cyY.arU();
        if (arD.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (arD.bottom + f2 > arU[1]) {
            f2 = (arU[1] - arD.bottom) * this.cza;
        }
        if (arD.bottom - arD.top > arU[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.czj = f2 == 0.0f;
        return fArr;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.cyY == null) {
            this.czb = bitmap;
            this.cyY = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.cyW = this.cyY.N(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.cyW = this.cyY.N(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.czc = 2;
            arK();
        }
    }

    public void arK() {
        if (this.czc == 2 && this.cyY != null && this.czl.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.cyX == null && this.cyU.getMeasuredWidth() > 0 && this.cyU.getMeasuredHeight() > 0 && this.cyY.arU()[0] > 0 && this.cyY.arU()[1] > 0) {
            this.cyX = new com.baidu.tbadk.widget.largeImage.a.b(this.cyU.getMeasuredWidth(), this.cyU.getMeasuredHeight(), this.cyY.arU());
            this.czl.setPriority(3);
            this.czl.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfu = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !arL()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.cyU.getWidth() - this.cyU.getPaddingLeft()) - this.cyU.getPaddingRight();
            int height2 = (this.cyU.getHeight() - this.cyU.getPaddingTop()) - this.cyU.getPaddingBottom();
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

    private boolean arL() {
        return (this.cyX == null || this.cyX.arH() == null || this.cyX.arH().getBitmap() == null || this.cyX.arH().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(Canvas canvas) {
        if (this.czc != 1 || this.czb == null) {
            if (this.cyX != null) {
                this.cyX.arD();
                if (arL()) {
                    canvas.drawBitmap(this.cyX.arH().getBitmap(), this.czf, null);
                }
                a(this.cyX, false);
                arO();
                canvas.save();
                float arz = (1.0f * this.cyX.arz()) / this.cyX.arG();
                canvas.scale(arz, arz);
                List<com.baidu.tbadk.widget.largeImage.a.a> arF = this.cyX.arF();
                if (arF != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : arF) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.arv(), aVar.arw(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float arM() {
        return this.ctZ;
    }

    public float getMinScaleValue() {
        if (this.ctZ < 1.0f) {
            return this.ctZ;
        }
        return 1.0f;
    }

    public float arN() {
        return 2.0f * this.ctZ;
    }

    public void release() {
        if (this.czi != null) {
            this.czi.cancel();
        }
        if (this.czl != null) {
            this.czl.cancel();
        }
        if (this.cze != null) {
            this.cze.onDestory();
        }
        if (this.cyX != null && this.cyX.arF() != null) {
            this.cyX.arF().clear();
        }
        if (this.czg != null) {
            this.czg.recycle();
            this.czg = null;
        }
        if (this.cyW != null) {
            this.cyW.recycle();
        }
    }

    private void arO() {
        List<com.baidu.tbadk.widget.largeImage.a.a> arF = this.cyX.arF();
        if (arF != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : arF) {
                a(aVar, this.cyX);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.czh = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.arx().amW() == 0 && aVar.arx().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.arD());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int arz = aVar.arx().arz();
        aVar.n((i - rect.left) / arz, (i3 - rect.top) / arz, (i2 - rect.left) / arz, (i4 - rect.top) / arz);
        aVar.m((i - rect2.left) / arz, (i3 - rect2.top) / arz, (i2 - rect2.left) / arz, (i4 - rect2.top) / arz);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.arB(), bVar.arz(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.cze == null) {
            this.cze = new com.baidu.tbadk.widget.largeImage.b.c(this.cyX, this.cyW);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> arF = this.cyX.arF();
            arF.clear();
            i2 = i3;
            z2 = true;
            list = arF;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                com.baidu.tbadk.widget.largeImage.a.a x = x(i2, i7, i);
                if (x == null) {
                    if (z) {
                        w(i2, i7, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(x);
                }
            }
            i2++;
        }
        if (z2) {
            this.cze.arW();
        }
    }

    public void arP() {
        if (this.czc != 1) {
            a(this.cyX, true);
        }
    }

    private void w(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.cze.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a x(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0246a c0246a = new a.C0246a(i, i2, i3);
        if (this.cze.arX() != null && (aVar = this.cze.arX().get(c0246a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.cze.arX().remove(c0246a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void akH() {
        this.cyU.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0247b extends GestureDetector.SimpleOnGestureListener {
        private C0247b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.czk = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.cza == b.this.cua ? b.this.ctZ : b.this.cua, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect arD = b.this.cyX.arD();
            Rect arA = b.this.cyX.arA();
            float f3 = arD.right - arA.right;
            float f4 = arD.left - arA.left;
            float f5 = arD.bottom - arA.bottom;
            float f6 = arD.top - arA.top;
            b.this.czd.forceFinished(true);
            b.this.czd.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.cyU.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.czk = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.czk || b.this.cfu == null) {
                b.this.czk = false;
            } else {
                b.this.cfu.onLongClick(b.this.cyU);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.czk || b.this.mClickListener == null) {
                b.this.czk = false;
            } else {
                b.this.mClickListener.onClick(b.this.cyU);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.czi != null) {
            this.czi.cancel();
        }
        this.czi = ValueAnimator.ofFloat(this.cza, f);
        this.czi.setDuration(i);
        this.czi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.cza, f2, f3);
                }
            }
        });
        this.czi.start();
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
        if (this.cza * f < this.cyZ) {
            f = this.cyZ / this.cza;
        }
        if (this.cza * f > this.cua) {
            f = this.cua / this.cza;
        }
        Rect arD = this.cyX.arD();
        float f4 = ((arD.left + arD.right) * 1.0f) / 2.0f;
        float f5 = ((arD.bottom + arD.top) * 1.0f) / 2.0f;
        if (this.cyX != null) {
            this.czf.postScale(f, f, this.cyX.getRealWidth() / 2, this.cyX.arE() / 2);
            this.cyX.b(1.0f / f, f4, f5);
            this.cza *= f;
            this.cyX.ap(1.0f / this.cza);
            float[] arQ = arQ();
            this.czf.postTranslate(-arQ[0], -arQ[1]);
            this.cyX.u((arQ[0] * 1.0f) / this.cza, (arQ[1] * 1.0f) / this.cza);
            arP();
            this.cyU.invalidate();
        }
    }

    public boolean aqA() {
        Rect arD;
        return (this.cyX == null || (arD = this.cyX.arD()) == null || arD.top > 10) ? false : true;
    }

    private float[] arQ() {
        Rect arD = this.cyX.arD();
        int[] arU = this.cyY.arU();
        float[] fArr = {(arU[0] / 2) - (((arD.left + arD.right) * 1.0f) / 2.0f)};
        if (arD.top < 0) {
            fArr[1] = 0 - arD.top;
        }
        if (arD.bottom > arU[1]) {
            fArr[1] = arU[1] - arD.bottom;
        }
        if (arD.bottom - arD.top > arU[1]) {
            fArr[1] = (arU[1] / 2) - (((arD.bottom + arD.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.cza;
        fArr[1] = fArr[1] * this.cza;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arR() {
        if (this.cyX != null) {
            this.cyX.aq(1.0f / this.ctZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.arE() * 1.0f) / bitmap.getHeight());
        this.czf.postScale(max, max);
        this.cyZ = max * (1.0f / i);
        this.ctZ = this.cyZ;
        this.cza = this.ctZ;
        this.cua = 2.0f * this.cza;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.cyW.getWidth();
        if (realWidth > 1.0f) {
            this.cyZ /= realWidth;
        }
        bVar.ap(1.0f / this.cza);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int czp;
        int czq;

        public a(Context context) {
            super(context);
            this.czp = 0;
            this.czq = 0;
        }

        public void kq(int i) {
            this.czp = i;
        }

        public void kr(int i) {
            this.czq = i;
        }

        public int arS() {
            return this.czp;
        }

        public int arT() {
            return this.czq;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.czp = 0;
            this.czq = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

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
    private View.OnLongClickListener cfx;
    private final View cyX;
    private ScaleGestureDetector cyY;
    private BitmapRegionDecoder cyZ;
    private com.baidu.tbadk.widget.largeImage.a.b cza;
    private com.baidu.tbadk.widget.largeImage.b.a czb;
    private float czc;
    private float czd;
    private Bitmap cze;
    private int czf;
    private a czg;
    private com.baidu.tbadk.widget.largeImage.b.c czh;
    private com.baidu.tbadk.widget.largeImage.logic.a czk;
    private ValueAnimator czl;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float cud = 2.0f;
    private float cuc = 1.0f;
    private final Matrix czi = new Matrix();
    Bitmap czj = null;
    private boolean czm = true;
    private boolean czn = false;
    BdAsyncTask<String, String, String> czo = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.cza != null && b.this.cyZ != null) {
                int[] arR = b.this.czb.arR();
                int i = 1;
                while (Math.max(arR[0] / b.this.cza.getRealWidth(), arR[1] / b.this.cza.arB()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, arR[0], arR[1]);
                try {
                    b.this.czj = b.this.cyZ.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.czj = b.this.cyZ.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.czj = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.anm().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.czj, false));
                b.this.a(b.this.czj, b.this.cza, pow);
                b.this.cza.r(b.this.czj);
                b.this.arO();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.czk != null) {
                b.this.czk.akE();
            }
            b.this.arM();
            b.this.cyX.invalidate();
        }
    };

    public b(View view) {
        this.czf = 1;
        this.cyX = view;
        this.mContext = this.cyX.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0247b());
        this.cyY = new ScaleGestureDetector(this.mContext, new c());
        this.czg = new a(this.mContext);
        this.czf = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.czf == 2 && arI()) {
            switch (action) {
                case 0:
                    if (!this.czg.isFinished()) {
                        this.czn = true;
                    } else {
                        this.czn = false;
                    }
                case 1:
                case 3:
                    aqy();
                    break;
            }
            this.czg.forceFinished(true);
            this.cyY.onTouchEvent(motionEvent);
            if (this.cyY.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean arF() {
        return Math.floor((double) (this.cuc * 10000.0f)) == Math.floor((double) (this.czd * 10000.0f));
    }

    public void aqy() {
        if (this.czd / this.cuc < 1.0f) {
            a(this.cuc, 0.0f, 0.0f, 400);
        }
    }

    public boolean arG() {
        if (this.czf == 1) {
            return false;
        }
        if (this.czg.computeScrollOffset()) {
            int currX = this.czg.getCurrX();
            int currY = this.czg.getCurrY();
            float arP = (currX - this.czg.arP()) * 2.0f;
            float arQ = (currY - this.czg.arQ()) * 2.0f;
            int aQ = l.aQ(TbadkCoreApplication.getInst());
            if (arQ >= 0.0f && Math.abs(arQ) <= 20.0f && currX < aQ) {
                moveTo(0.0f, -20.0f);
                this.cyX.invalidate();
                return true;
            }
            this.czg.kp(currX);
            this.czg.kq(currY);
            moveTo(-arP, -arQ);
            this.cyX.invalidate();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.cza != null) {
            float[] v = v(f, f2);
            float f3 = v[0];
            float f4 = v[1];
            this.czi.postTranslate(-f3, -f4);
            this.cza.u((f3 * 1.0f) / this.czd, (f4 * 1.0f) / this.czd);
            arM();
            this.cyX.invalidate();
        }
    }

    private float[] v(float f, float f2) {
        float[] fArr = new float[2];
        Rect arA = this.cza.arA();
        int[] arR = this.czb.arR();
        if (arA.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (arA.bottom + f2 > arR[1]) {
            f2 = (arR[1] - arA.bottom) * this.czd;
        }
        if (arA.bottom - arA.top > arR[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.czm = f2 == 0.0f;
        return fArr;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.czb == null) {
            this.cze = bitmap;
            this.czb = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.cyZ = this.czb.N(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.cyZ = this.czb.N(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.czf = 2;
            arH();
        }
    }

    public void arH() {
        if (this.czf == 2 && this.czb != null && this.czo.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.cza == null && this.cyX.getMeasuredWidth() > 0 && this.cyX.getMeasuredHeight() > 0 && this.czb.arR()[0] > 0 && this.czb.arR()[1] > 0) {
            this.cza = new com.baidu.tbadk.widget.largeImage.a.b(this.cyX.getMeasuredWidth(), this.cyX.getMeasuredHeight(), this.czb.arR());
            this.czo.setPriority(3);
            this.czo.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfx = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !arI()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.cyX.getWidth() - this.cyX.getPaddingLeft()) - this.cyX.getPaddingRight();
            int height2 = (this.cyX.getHeight() - this.cyX.getPaddingTop()) - this.cyX.getPaddingBottom();
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

    private boolean arI() {
        return (this.cza == null || this.cza.arE() == null || this.cza.arE().getBitmap() == null || this.cza.arE().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(Canvas canvas) {
        if (this.czf != 1 || this.cze == null) {
            if (this.cza != null) {
                this.cza.arA();
                if (arI()) {
                    canvas.drawBitmap(this.cza.arE().getBitmap(), this.czi, null);
                }
                a(this.cza, false);
                arL();
                canvas.save();
                float arw = (1.0f * this.cza.arw()) / this.cza.arD();
                canvas.scale(arw, arw);
                List<com.baidu.tbadk.widget.largeImage.a.a> arC = this.cza.arC();
                if (arC != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : arC) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.ars(), aVar.art(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float arJ() {
        return this.cuc;
    }

    public float getMinScaleValue() {
        if (this.cuc < 1.0f) {
            return this.cuc;
        }
        return 1.0f;
    }

    public float arK() {
        return 2.0f * this.cuc;
    }

    public void release() {
        if (this.czl != null) {
            this.czl.cancel();
        }
        if (this.czo != null) {
            this.czo.cancel();
        }
        if (this.czh != null) {
            this.czh.onDestory();
        }
        if (this.cza != null && this.cza.arC() != null) {
            this.cza.arC().clear();
        }
        if (this.czj != null) {
            this.czj.recycle();
            this.czj = null;
        }
        if (this.cyZ != null) {
            this.cyZ.recycle();
        }
    }

    private void arL() {
        List<com.baidu.tbadk.widget.largeImage.a.a> arC = this.cza.arC();
        if (arC != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : arC) {
                a(aVar, this.cza);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.czk = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.aru().amT() == 0 && aVar.aru().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.arA());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int arw = aVar.aru().arw();
        aVar.n((i - rect.left) / arw, (i3 - rect.top) / arw, (i2 - rect.left) / arw, (i4 - rect.top) / arw);
        aVar.m((i - rect2.left) / arw, (i3 - rect2.top) / arw, (i2 - rect2.left) / arw, (i4 - rect2.top) / arw);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.ary(), bVar.arw(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.czh == null) {
            this.czh = new com.baidu.tbadk.widget.largeImage.b.c(this.cza, this.cyZ);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> arC = this.cza.arC();
            arC.clear();
            i2 = i3;
            z2 = true;
            list = arC;
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
            this.czh.arT();
        }
    }

    public void arM() {
        if (this.czf != 1) {
            a(this.cza, true);
        }
    }

    private void w(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.czh.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a x(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0246a c0246a = new a.C0246a(i, i2, i3);
        if (this.czh.arU() != null && (aVar = this.czh.arU().get(c0246a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.czh.arU().remove(c0246a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void akE() {
        this.cyX.postInvalidate();
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
                b.this.czn = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.czd == b.this.cud ? b.this.cuc : b.this.cud, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect arA = b.this.cza.arA();
            Rect arx = b.this.cza.arx();
            float f3 = arA.right - arx.right;
            float f4 = arA.left - arx.left;
            float f5 = arA.bottom - arx.bottom;
            float f6 = arA.top - arx.top;
            b.this.czg.forceFinished(true);
            b.this.czg.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.cyX.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.czn = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.czn || b.this.cfx == null) {
                b.this.czn = false;
            } else {
                b.this.cfx.onLongClick(b.this.cyX);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.czn || b.this.mClickListener == null) {
                b.this.czn = false;
            } else {
                b.this.mClickListener.onClick(b.this.cyX);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.czl != null) {
            this.czl.cancel();
        }
        this.czl = ValueAnimator.ofFloat(this.czd, f);
        this.czl.setDuration(i);
        this.czl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.czd, f2, f3);
                }
            }
        });
        this.czl.start();
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
        if (this.czd * f < this.czc) {
            f = this.czc / this.czd;
        }
        if (this.czd * f > this.cud) {
            f = this.cud / this.czd;
        }
        Rect arA = this.cza.arA();
        float f4 = ((arA.left + arA.right) * 1.0f) / 2.0f;
        float f5 = ((arA.bottom + arA.top) * 1.0f) / 2.0f;
        if (this.cza != null) {
            this.czi.postScale(f, f, this.cza.getRealWidth() / 2, this.cza.arB() / 2);
            this.cza.b(1.0f / f, f4, f5);
            this.czd *= f;
            this.cza.ap(1.0f / this.czd);
            float[] arN = arN();
            this.czi.postTranslate(-arN[0], -arN[1]);
            this.cza.u((arN[0] * 1.0f) / this.czd, (arN[1] * 1.0f) / this.czd);
            arM();
            this.cyX.invalidate();
        }
    }

    public boolean aqx() {
        Rect arA;
        return (this.cza == null || (arA = this.cza.arA()) == null || arA.top > 10) ? false : true;
    }

    private float[] arN() {
        Rect arA = this.cza.arA();
        int[] arR = this.czb.arR();
        float[] fArr = {(arR[0] / 2) - (((arA.left + arA.right) * 1.0f) / 2.0f)};
        if (arA.top < 0) {
            fArr[1] = 0 - arA.top;
        }
        if (arA.bottom > arR[1]) {
            fArr[1] = arR[1] - arA.bottom;
        }
        if (arA.bottom - arA.top > arR[1]) {
            fArr[1] = (arR[1] / 2) - (((arA.bottom + arA.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.czd;
        fArr[1] = fArr[1] * this.czd;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arO() {
        if (this.cza != null) {
            this.cza.aq(1.0f / this.cuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.arB() * 1.0f) / bitmap.getHeight());
        this.czi.postScale(max, max);
        this.czc = max * (1.0f / i);
        this.cuc = this.czc;
        this.czd = this.cuc;
        this.cud = 2.0f * this.czd;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.cyZ.getWidth();
        if (realWidth > 1.0f) {
            this.czc /= realWidth;
        }
        bVar.ap(1.0f / this.czd);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int czs;
        int czt;

        public a(Context context) {
            super(context);
            this.czs = 0;
            this.czt = 0;
        }

        public void kp(int i) {
            this.czs = i;
        }

        public void kq(int i) {
            this.czt = i;
        }

        public int arP() {
            return this.czs;
        }

        public int arQ() {
            return this.czt;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.czs = 0;
            this.czt = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

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
    private View.OnLongClickListener cfw;
    private final View cyW;
    private ScaleGestureDetector cyX;
    private BitmapRegionDecoder cyY;
    private com.baidu.tbadk.widget.largeImage.a.b cyZ;
    private com.baidu.tbadk.widget.largeImage.b.a cza;
    private float czb;
    private float czc;
    private Bitmap czd;
    private int cze;
    private a czf;
    private com.baidu.tbadk.widget.largeImage.b.c czg;
    private com.baidu.tbadk.widget.largeImage.logic.a czj;
    private ValueAnimator czk;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float cuc = 2.0f;
    private float cub = 1.0f;
    private final Matrix czh = new Matrix();
    Bitmap czi = null;
    private boolean czl = true;
    private boolean czm = false;
    BdAsyncTask<String, String, String> czn = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.cyZ != null && b.this.cyY != null) {
                int[] arR = b.this.cza.arR();
                int i = 1;
                while (Math.max(arR[0] / b.this.cyZ.getRealWidth(), arR[1] / b.this.cyZ.arB()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, arR[0], arR[1]);
                try {
                    b.this.czi = b.this.cyY.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.czi = b.this.cyY.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.czi = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.anm().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.czi, false));
                b.this.a(b.this.czi, b.this.cyZ, pow);
                b.this.cyZ.r(b.this.czi);
                b.this.arO();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.czj != null) {
                b.this.czj.akE();
            }
            b.this.arM();
            b.this.cyW.invalidate();
        }
    };

    public b(View view) {
        this.cze = 1;
        this.cyW = view;
        this.mContext = this.cyW.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0247b());
        this.cyX = new ScaleGestureDetector(this.mContext, new c());
        this.czf = new a(this.mContext);
        this.cze = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.cze == 2 && arI()) {
            switch (action) {
                case 0:
                    if (!this.czf.isFinished()) {
                        this.czm = true;
                    } else {
                        this.czm = false;
                    }
                case 1:
                case 3:
                    aqy();
                    break;
            }
            this.czf.forceFinished(true);
            this.cyX.onTouchEvent(motionEvent);
            if (this.cyX.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean arF() {
        return Math.floor((double) (this.cub * 10000.0f)) == Math.floor((double) (this.czc * 10000.0f));
    }

    public void aqy() {
        if (this.czc / this.cub < 1.0f) {
            a(this.cub, 0.0f, 0.0f, 400);
        }
    }

    public boolean arG() {
        if (this.cze == 1) {
            return false;
        }
        if (this.czf.computeScrollOffset()) {
            int currX = this.czf.getCurrX();
            int currY = this.czf.getCurrY();
            float arP = (currX - this.czf.arP()) * 2.0f;
            float arQ = (currY - this.czf.arQ()) * 2.0f;
            int aQ = l.aQ(TbadkCoreApplication.getInst());
            if (arQ >= 0.0f && Math.abs(arQ) <= 20.0f && currX < aQ) {
                moveTo(0.0f, -20.0f);
                this.cyW.invalidate();
                return true;
            }
            this.czf.kp(currX);
            this.czf.kq(currY);
            moveTo(-arP, -arQ);
            this.cyW.invalidate();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.cyZ != null) {
            float[] v = v(f, f2);
            float f3 = v[0];
            float f4 = v[1];
            this.czh.postTranslate(-f3, -f4);
            this.cyZ.u((f3 * 1.0f) / this.czc, (f4 * 1.0f) / this.czc);
            arM();
            this.cyW.invalidate();
        }
    }

    private float[] v(float f, float f2) {
        float[] fArr = new float[2];
        Rect arA = this.cyZ.arA();
        int[] arR = this.cza.arR();
        if (arA.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (arA.bottom + f2 > arR[1]) {
            f2 = (arR[1] - arA.bottom) * this.czc;
        }
        if (arA.bottom - arA.top > arR[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.czl = f2 == 0.0f;
        return fArr;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.cza == null) {
            this.czd = bitmap;
            this.cza = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.cyY = this.cza.N(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.cyY = this.cza.N(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.cze = 2;
            arH();
        }
    }

    public void arH() {
        if (this.cze == 2 && this.cza != null && this.czn.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.cyZ == null && this.cyW.getMeasuredWidth() > 0 && this.cyW.getMeasuredHeight() > 0 && this.cza.arR()[0] > 0 && this.cza.arR()[1] > 0) {
            this.cyZ = new com.baidu.tbadk.widget.largeImage.a.b(this.cyW.getMeasuredWidth(), this.cyW.getMeasuredHeight(), this.cza.arR());
            this.czn.setPriority(3);
            this.czn.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfw = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !arI()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.cyW.getWidth() - this.cyW.getPaddingLeft()) - this.cyW.getPaddingRight();
            int height2 = (this.cyW.getHeight() - this.cyW.getPaddingTop()) - this.cyW.getPaddingBottom();
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
        return (this.cyZ == null || this.cyZ.arE() == null || this.cyZ.arE().getBitmap() == null || this.cyZ.arE().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(Canvas canvas) {
        if (this.cze != 1 || this.czd == null) {
            if (this.cyZ != null) {
                this.cyZ.arA();
                if (arI()) {
                    canvas.drawBitmap(this.cyZ.arE().getBitmap(), this.czh, null);
                }
                a(this.cyZ, false);
                arL();
                canvas.save();
                float arw = (1.0f * this.cyZ.arw()) / this.cyZ.arD();
                canvas.scale(arw, arw);
                List<com.baidu.tbadk.widget.largeImage.a.a> arC = this.cyZ.arC();
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
        return this.cub;
    }

    public float getMinScaleValue() {
        if (this.cub < 1.0f) {
            return this.cub;
        }
        return 1.0f;
    }

    public float arK() {
        return 2.0f * this.cub;
    }

    public void release() {
        if (this.czk != null) {
            this.czk.cancel();
        }
        if (this.czn != null) {
            this.czn.cancel();
        }
        if (this.czg != null) {
            this.czg.onDestory();
        }
        if (this.cyZ != null && this.cyZ.arC() != null) {
            this.cyZ.arC().clear();
        }
        if (this.czi != null) {
            this.czi.recycle();
            this.czi = null;
        }
        if (this.cyY != null) {
            this.cyY.recycle();
        }
    }

    private void arL() {
        List<com.baidu.tbadk.widget.largeImage.a.a> arC = this.cyZ.arC();
        if (arC != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : arC) {
                a(aVar, this.cyZ);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.czj = aVar;
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
        if (this.czg == null) {
            this.czg = new com.baidu.tbadk.widget.largeImage.b.c(this.cyZ, this.cyY);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> arC = this.cyZ.arC();
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
            this.czg.arT();
        }
    }

    public void arM() {
        if (this.cze != 1) {
            a(this.cyZ, true);
        }
    }

    private void w(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.czg.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a x(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0246a c0246a = new a.C0246a(i, i2, i3);
        if (this.czg.arU() != null && (aVar = this.czg.arU().get(c0246a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.czg.arU().remove(c0246a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void akE() {
        this.cyW.postInvalidate();
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
                b.this.czm = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.czc == b.this.cuc ? b.this.cub : b.this.cuc, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect arA = b.this.cyZ.arA();
            Rect arx = b.this.cyZ.arx();
            float f3 = arA.right - arx.right;
            float f4 = arA.left - arx.left;
            float f5 = arA.bottom - arx.bottom;
            float f6 = arA.top - arx.top;
            b.this.czf.forceFinished(true);
            b.this.czf.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.cyW.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.czm = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.czm || b.this.cfw == null) {
                b.this.czm = false;
            } else {
                b.this.cfw.onLongClick(b.this.cyW);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.czm || b.this.mClickListener == null) {
                b.this.czm = false;
            } else {
                b.this.mClickListener.onClick(b.this.cyW);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.czk != null) {
            this.czk.cancel();
        }
        this.czk = ValueAnimator.ofFloat(this.czc, f);
        this.czk.setDuration(i);
        this.czk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.czc, f2, f3);
                }
            }
        });
        this.czk.start();
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
        if (this.czc * f < this.czb) {
            f = this.czb / this.czc;
        }
        if (this.czc * f > this.cuc) {
            f = this.cuc / this.czc;
        }
        Rect arA = this.cyZ.arA();
        float f4 = ((arA.left + arA.right) * 1.0f) / 2.0f;
        float f5 = ((arA.bottom + arA.top) * 1.0f) / 2.0f;
        if (this.cyZ != null) {
            this.czh.postScale(f, f, this.cyZ.getRealWidth() / 2, this.cyZ.arB() / 2);
            this.cyZ.b(1.0f / f, f4, f5);
            this.czc *= f;
            this.cyZ.ap(1.0f / this.czc);
            float[] arN = arN();
            this.czh.postTranslate(-arN[0], -arN[1]);
            this.cyZ.u((arN[0] * 1.0f) / this.czc, (arN[1] * 1.0f) / this.czc);
            arM();
            this.cyW.invalidate();
        }
    }

    public boolean aqx() {
        Rect arA;
        return (this.cyZ == null || (arA = this.cyZ.arA()) == null || arA.top > 10) ? false : true;
    }

    private float[] arN() {
        Rect arA = this.cyZ.arA();
        int[] arR = this.cza.arR();
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
        fArr[0] = fArr[0] * this.czc;
        fArr[1] = fArr[1] * this.czc;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arO() {
        if (this.cyZ != null) {
            this.cyZ.aq(1.0f / this.cub);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.arB() * 1.0f) / bitmap.getHeight());
        this.czh.postScale(max, max);
        this.czb = max * (1.0f / i);
        this.cub = this.czb;
        this.czc = this.cub;
        this.cuc = 2.0f * this.czc;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.cyY.getWidth();
        if (realWidth > 1.0f) {
            this.czb /= realWidth;
        }
        bVar.ap(1.0f / this.czc);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int czr;
        int czs;

        public a(Context context) {
            super(context);
            this.czr = 0;
            this.czs = 0;
        }

        public void kp(int i) {
            this.czr = i;
        }

        public void kq(int i) {
            this.czs = i;
        }

        public int arP() {
            return this.czr;
        }

        public int arQ() {
            return this.czs;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.czr = 0;
            this.czs = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

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
    private View.OnLongClickListener aWc;
    private float boA;
    private float boB;
    private Bitmap boC;
    private int boD;
    private a boE;
    private com.baidu.tbadk.widget.largeImage.b.c boF;
    private com.baidu.tbadk.widget.largeImage.logic.a boI;
    private ValueAnimator boJ;
    private final View bov;
    private ScaleGestureDetector bow;
    private BitmapRegionDecoder box;
    private com.baidu.tbadk.widget.largeImage.a.b boy;
    private com.baidu.tbadk.widget.largeImage.b.a boz;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float bjT = 2.0f;
    private float bjS = 1.0f;
    private final Matrix boG = new Matrix();
    Bitmap boH = null;
    private boolean boK = true;
    private boolean boL = false;
    BdAsyncTask<String, String, String> boM = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.boy != null && b.this.box != null) {
                int[] RZ = b.this.boz.RZ();
                int i = 1;
                while (Math.max(RZ[0] / b.this.boy.getRealWidth(), RZ[1] / b.this.boy.RJ()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, RZ[0], RZ[1]);
                try {
                    b.this.boH = b.this.box.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.boH = b.this.box.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.boH = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.NM().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.boH, false));
                b.this.a(b.this.boH, b.this.boy, pow);
                b.this.boy.k(b.this.boH);
                b.this.RW();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.boI != null) {
                b.this.boI.Lh();
            }
            b.this.RU();
            b.this.bov.invalidate();
        }
    };

    public b(View view) {
        this.boD = 1;
        this.bov = view;
        this.mContext = this.bov.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0179b());
        this.bow = new ScaleGestureDetector(this.mContext, new c());
        this.boE = new a(this.mContext);
        this.boD = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.boD == 2 && RQ()) {
            switch (action) {
                case 0:
                    if (!this.boE.isFinished()) {
                        this.boL = true;
                    } else {
                        this.boL = false;
                    }
                case 1:
                case 3:
                    QM();
                    break;
            }
            this.boE.forceFinished(true);
            this.bow.onTouchEvent(motionEvent);
            if (this.bow.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean RN() {
        return Math.floor((double) (this.bjS * 10000.0f)) == Math.floor((double) (this.boB * 10000.0f));
    }

    public void QM() {
        if (this.boB / this.bjS < 1.0f) {
            a(this.bjS, 0.0f, 0.0f, 400);
        }
    }

    public boolean RO() {
        if (this.boD == 1) {
            return false;
        }
        if (this.boE.computeScrollOffset()) {
            int currX = this.boE.getCurrX();
            this.boE.gC(currX);
            int currY = this.boE.getCurrY();
            this.boE.gD(currY);
            moveTo(-((currX - this.boE.RX()) * 2.0f), -((currY - this.boE.RY()) * 2.0f));
            this.bov.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.boz == null) {
            this.boC = bitmap;
            this.boz = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.box = this.boz.G(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.box = this.boz.G(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.boD = 2;
            RP();
        }
    }

    public void RP() {
        if (this.boD == 2 && this.boz != null && this.boM.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.boy == null && this.bov.getMeasuredWidth() > 0 && this.bov.getMeasuredHeight() > 0 && this.boz.RZ()[0] > 0 && this.boz.RZ()[1] > 0) {
            this.boy = new com.baidu.tbadk.widget.largeImage.a.b(this.bov.getMeasuredWidth(), this.bov.getMeasuredHeight(), this.boz.RZ());
            this.boM.setPriority(3);
            this.boM.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aWc = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !RQ()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bov.getWidth() - this.bov.getPaddingLeft()) - this.bov.getPaddingRight();
            int height2 = (this.bov.getHeight() - this.bov.getPaddingTop()) - this.bov.getPaddingBottom();
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

    private boolean RQ() {
        return (this.boy == null || this.boy.RM() == null || this.boy.RM().getBitmap() == null || this.boy.RM().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(Canvas canvas) {
        if (this.boD != 1 || this.boC == null) {
            if (this.boy != null) {
                this.boy.RI();
                if (RQ()) {
                    canvas.drawBitmap(this.boy.RM().getBitmap(), this.boG, null);
                }
                a(this.boy, false);
                RT();
                canvas.save();
                float RE = (1.0f * this.boy.RE()) / this.boy.RL();
                canvas.scale(RE, RE);
                List<com.baidu.tbadk.widget.largeImage.a.a> RK = this.boy.RK();
                if (RK != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : RK) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.RA(), aVar.RB(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float RR() {
        return this.bjS;
    }

    public float getMinScaleValue() {
        if (this.bjS < 1.0f) {
            return this.bjS;
        }
        return 1.0f;
    }

    public float RS() {
        return 2.0f * this.bjS;
    }

    public void release() {
        if (this.boJ != null) {
            this.boJ.cancel();
        }
        if (this.boM != null) {
            this.boM.cancel();
        }
        if (this.boF != null) {
            this.boF.onDestory();
        }
        if (this.boy != null && this.boy.RK() != null) {
            this.boy.RK().clear();
        }
        if (this.boH != null) {
            this.boH.recycle();
            this.boH = null;
        }
        if (this.box != null) {
            this.box.recycle();
        }
    }

    private void RT() {
        List<com.baidu.tbadk.widget.largeImage.a.a> RK = this.boy.RK();
        if (RK != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : RK) {
                a(aVar, this.boy);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.boI = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.RC().Ns() == 0 && aVar.RC().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.RI());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int RE = aVar.RC().RE();
        aVar.j((i - rect.left) / RE, (i3 - rect.top) / RE, (i2 - rect.left) / RE, (i4 - rect.top) / RE);
        aVar.i((i - rect2.left) / RE, (i3 - rect2.top) / RE, (i2 - rect2.left) / RE, (i4 - rect2.top) / RE);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.RG(), bVar.RE(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.boF == null) {
            this.boF = new com.baidu.tbadk.widget.largeImage.b.c(this.boy, this.box);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> RK = this.boy.RK();
            RK.clear();
            i2 = i3;
            z2 = true;
            list = RK;
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
            this.boF.Sb();
        }
    }

    public void RU() {
        if (this.boD != 1) {
            a(this.boy, true);
        }
    }

    private void t(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.boF.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a u(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0178a c0178a = new a.C0178a(i, i2, i3);
        if (this.boF.Sc() != null && (aVar = this.boF.Sc().get(c0178a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.boF.Sc().remove(c0178a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void Lh() {
        this.bov.postInvalidate();
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
                b.this.boL = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.boB == b.this.bjT ? b.this.bjS : b.this.bjT, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect RI = b.this.boy.RI();
            Rect RF = b.this.boy.RF();
            float f3 = RI.right - RF.right;
            float f4 = RI.left - RF.left;
            float f5 = RI.bottom - RF.bottom;
            float f6 = RI.top - RF.top;
            b.this.boE.forceFinished(true);
            b.this.boE.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bov.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.boL = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.boL || b.this.aWc == null) {
                b.this.boL = false;
            } else {
                b.this.aWc.onLongClick(b.this.bov);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.boL || b.this.mClickListener == null) {
                b.this.boL = false;
            } else {
                b.this.mClickListener.onClick(b.this.bov);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.boJ != null) {
            this.boJ.cancel();
        }
        this.boJ = ValueAnimator.ofFloat(this.boB, f);
        this.boJ.setDuration(i);
        this.boJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.boB, f2, f3);
                }
            }
        });
        this.boJ.start();
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
        if (this.boB * f < this.boA) {
            f = this.boA / this.boB;
        }
        if (this.boB * f > this.bjT) {
            f = this.bjT / this.boB;
        }
        Rect RI = this.boy.RI();
        float f4 = ((RI.left + RI.right) * 1.0f) / 2.0f;
        float f5 = ((RI.bottom + RI.top) * 1.0f) / 2.0f;
        if (this.boy != null) {
            this.boG.postScale(f, f, this.boy.getRealWidth() / 2, this.boy.RJ() / 2);
            this.boy.b(1.0f / f, f4, f5);
            this.boB *= f;
            this.boy.ac(1.0f / this.boB);
            float[] RV = RV();
            this.boG.postTranslate(-RV[0], -RV[1]);
            this.boy.r((RV[0] * 1.0f) / this.boB, (RV[1] * 1.0f) / this.boB);
            RU();
            this.bov.invalidate();
        }
    }

    public boolean QL() {
        Rect RI;
        return (this.boy == null || (RI = this.boy.RI()) == null || RI.top > 10) ? false : true;
    }

    private float[] RV() {
        Rect RI = this.boy.RI();
        int[] RZ = this.boz.RZ();
        float[] fArr = {(RZ[0] / 2) - (((RI.left + RI.right) * 1.0f) / 2.0f)};
        if (RI.top < 0) {
            fArr[1] = 0 - RI.top;
        }
        if (RI.bottom > RZ[1]) {
            fArr[1] = RZ[1] - RI.bottom;
        }
        if (RI.bottom - RI.top > RZ[1]) {
            fArr[1] = (RZ[1] / 2) - (((RI.bottom + RI.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.boB;
        fArr[1] = fArr[1] * this.boB;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.boy != null) {
            float[] s = s(f, f2);
            this.boG.postTranslate(-s[0], -s[1]);
            this.boy.r((s[0] * 1.0f) / this.boB, (s[1] * 1.0f) / this.boB);
            RU();
            this.bov.invalidate();
        }
    }

    private float[] s(float f, float f2) {
        float[] fArr = new float[2];
        Rect RI = this.boy.RI();
        int[] RZ = this.boz.RZ();
        if (RI.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (RI.bottom + f2 > RZ[1]) {
            f2 = (RZ[1] - RI.bottom) * this.boB;
        }
        if (RI.bottom - RI.top > RZ[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.boK = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RW() {
        if (this.boy != null) {
            this.boy.ad(1.0f / this.bjS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.RJ() * 1.0f) / bitmap.getHeight());
        this.boG.postScale(max, max);
        this.boA = max * (1.0f / i);
        this.bjS = this.boA;
        this.boB = this.bjS;
        this.bjT = 2.0f * this.boB;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.box.getWidth();
        if (realWidth > 1.0f) {
            this.boA /= realWidth;
        }
        bVar.ac(1.0f / this.boB);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int boQ;
        int boR;

        public a(Context context) {
            super(context);
            this.boQ = 0;
            this.boR = 0;
        }

        public void gC(int i) {
            this.boQ = i;
        }

        public void gD(int i) {
            this.boR = i;
        }

        public int RX() {
            return this.boQ;
        }

        public int RY() {
            return this.boR;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.boQ = 0;
            this.boR = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

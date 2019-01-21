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
    private View.OnLongClickListener aWd;
    private com.baidu.tbadk.widget.largeImage.b.a boA;
    private float boB;
    private float boC;
    private Bitmap boD;
    private int boE;
    private a boF;
    private com.baidu.tbadk.widget.largeImage.b.c boG;
    private com.baidu.tbadk.widget.largeImage.logic.a boJ;
    private ValueAnimator boK;
    private final View bow;
    private ScaleGestureDetector box;
    private BitmapRegionDecoder boy;
    private com.baidu.tbadk.widget.largeImage.a.b boz;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float bjU = 2.0f;
    private float bjT = 1.0f;
    private final Matrix boH = new Matrix();
    Bitmap boI = null;
    private boolean boL = true;
    private boolean boM = false;
    BdAsyncTask<String, String, String> boN = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.boz != null && b.this.boy != null) {
                int[] RZ = b.this.boA.RZ();
                int i = 1;
                while (Math.max(RZ[0] / b.this.boz.getRealWidth(), RZ[1] / b.this.boz.RJ()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, RZ[0], RZ[1]);
                try {
                    b.this.boI = b.this.boy.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.boI = b.this.boy.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.boI = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.NM().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.boI, false));
                b.this.a(b.this.boI, b.this.boz, pow);
                b.this.boz.k(b.this.boI);
                b.this.RW();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.boJ != null) {
                b.this.boJ.Lh();
            }
            b.this.RU();
            b.this.bow.invalidate();
        }
    };

    public b(View view) {
        this.boE = 1;
        this.bow = view;
        this.mContext = this.bow.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0179b());
        this.box = new ScaleGestureDetector(this.mContext, new c());
        this.boF = new a(this.mContext);
        this.boE = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.boE == 2 && RQ()) {
            switch (action) {
                case 0:
                    if (!this.boF.isFinished()) {
                        this.boM = true;
                    } else {
                        this.boM = false;
                    }
                case 1:
                case 3:
                    QM();
                    break;
            }
            this.boF.forceFinished(true);
            this.box.onTouchEvent(motionEvent);
            if (this.box.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean RN() {
        return Math.floor((double) (this.bjT * 10000.0f)) == Math.floor((double) (this.boC * 10000.0f));
    }

    public void QM() {
        if (this.boC / this.bjT < 1.0f) {
            a(this.bjT, 0.0f, 0.0f, 400);
        }
    }

    public boolean RO() {
        if (this.boE == 1) {
            return false;
        }
        if (this.boF.computeScrollOffset()) {
            int currX = this.boF.getCurrX();
            this.boF.gC(currX);
            int currY = this.boF.getCurrY();
            this.boF.gD(currY);
            moveTo(-((currX - this.boF.RX()) * 2.0f), -((currY - this.boF.RY()) * 2.0f));
            this.bow.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.boA == null) {
            this.boD = bitmap;
            this.boA = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.boy = this.boA.G(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.boy = this.boA.G(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.boE = 2;
            RP();
        }
    }

    public void RP() {
        if (this.boE == 2 && this.boA != null && this.boN.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.boz == null && this.bow.getMeasuredWidth() > 0 && this.bow.getMeasuredHeight() > 0 && this.boA.RZ()[0] > 0 && this.boA.RZ()[1] > 0) {
            this.boz = new com.baidu.tbadk.widget.largeImage.a.b(this.bow.getMeasuredWidth(), this.bow.getMeasuredHeight(), this.boA.RZ());
            this.boN.setPriority(3);
            this.boN.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aWd = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !RQ()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bow.getWidth() - this.bow.getPaddingLeft()) - this.bow.getPaddingRight();
            int height2 = (this.bow.getHeight() - this.bow.getPaddingTop()) - this.bow.getPaddingBottom();
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
        return (this.boz == null || this.boz.RM() == null || this.boz.RM().getBitmap() == null || this.boz.RM().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(Canvas canvas) {
        if (this.boE != 1 || this.boD == null) {
            if (this.boz != null) {
                this.boz.RI();
                if (RQ()) {
                    canvas.drawBitmap(this.boz.RM().getBitmap(), this.boH, null);
                }
                a(this.boz, false);
                RT();
                canvas.save();
                float RE = (1.0f * this.boz.RE()) / this.boz.RL();
                canvas.scale(RE, RE);
                List<com.baidu.tbadk.widget.largeImage.a.a> RK = this.boz.RK();
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
        return this.bjT;
    }

    public float getMinScaleValue() {
        if (this.bjT < 1.0f) {
            return this.bjT;
        }
        return 1.0f;
    }

    public float RS() {
        return 2.0f * this.bjT;
    }

    public void release() {
        if (this.boK != null) {
            this.boK.cancel();
        }
        if (this.boN != null) {
            this.boN.cancel();
        }
        if (this.boG != null) {
            this.boG.onDestory();
        }
        if (this.boz != null && this.boz.RK() != null) {
            this.boz.RK().clear();
        }
        if (this.boI != null) {
            this.boI.recycle();
            this.boI = null;
        }
        if (this.boy != null) {
            this.boy.recycle();
        }
    }

    private void RT() {
        List<com.baidu.tbadk.widget.largeImage.a.a> RK = this.boz.RK();
        if (RK != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : RK) {
                a(aVar, this.boz);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.boJ = aVar;
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
        if (this.boG == null) {
            this.boG = new com.baidu.tbadk.widget.largeImage.b.c(this.boz, this.boy);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> RK = this.boz.RK();
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
            this.boG.Sb();
        }
    }

    public void RU() {
        if (this.boE != 1) {
            a(this.boz, true);
        }
    }

    private void t(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.boG.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a u(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0178a c0178a = new a.C0178a(i, i2, i3);
        if (this.boG.Sc() != null && (aVar = this.boG.Sc().get(c0178a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.boG.Sc().remove(c0178a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void Lh() {
        this.bow.postInvalidate();
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
                b.this.boM = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.boC == b.this.bjU ? b.this.bjT : b.this.bjU, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect RI = b.this.boz.RI();
            Rect RF = b.this.boz.RF();
            float f3 = RI.right - RF.right;
            float f4 = RI.left - RF.left;
            float f5 = RI.bottom - RF.bottom;
            float f6 = RI.top - RF.top;
            b.this.boF.forceFinished(true);
            b.this.boF.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bow.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.boM = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.boM || b.this.aWd == null) {
                b.this.boM = false;
            } else {
                b.this.aWd.onLongClick(b.this.bow);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.boM || b.this.mClickListener == null) {
                b.this.boM = false;
            } else {
                b.this.mClickListener.onClick(b.this.bow);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.boK != null) {
            this.boK.cancel();
        }
        this.boK = ValueAnimator.ofFloat(this.boC, f);
        this.boK.setDuration(i);
        this.boK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.boC, f2, f3);
                }
            }
        });
        this.boK.start();
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
        if (this.boC * f < this.boB) {
            f = this.boB / this.boC;
        }
        if (this.boC * f > this.bjU) {
            f = this.bjU / this.boC;
        }
        Rect RI = this.boz.RI();
        float f4 = ((RI.left + RI.right) * 1.0f) / 2.0f;
        float f5 = ((RI.bottom + RI.top) * 1.0f) / 2.0f;
        if (this.boz != null) {
            this.boH.postScale(f, f, this.boz.getRealWidth() / 2, this.boz.RJ() / 2);
            this.boz.b(1.0f / f, f4, f5);
            this.boC *= f;
            this.boz.ac(1.0f / this.boC);
            float[] RV = RV();
            this.boH.postTranslate(-RV[0], -RV[1]);
            this.boz.r((RV[0] * 1.0f) / this.boC, (RV[1] * 1.0f) / this.boC);
            RU();
            this.bow.invalidate();
        }
    }

    public boolean QL() {
        Rect RI;
        return (this.boz == null || (RI = this.boz.RI()) == null || RI.top > 10) ? false : true;
    }

    private float[] RV() {
        Rect RI = this.boz.RI();
        int[] RZ = this.boA.RZ();
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
        fArr[0] = fArr[0] * this.boC;
        fArr[1] = fArr[1] * this.boC;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.boz != null) {
            float[] s = s(f, f2);
            this.boH.postTranslate(-s[0], -s[1]);
            this.boz.r((s[0] * 1.0f) / this.boC, (s[1] * 1.0f) / this.boC);
            RU();
            this.bow.invalidate();
        }
    }

    private float[] s(float f, float f2) {
        float[] fArr = new float[2];
        Rect RI = this.boz.RI();
        int[] RZ = this.boA.RZ();
        if (RI.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (RI.bottom + f2 > RZ[1]) {
            f2 = (RZ[1] - RI.bottom) * this.boC;
        }
        if (RI.bottom - RI.top > RZ[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.boL = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RW() {
        if (this.boz != null) {
            this.boz.ad(1.0f / this.bjT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.RJ() * 1.0f) / bitmap.getHeight());
        this.boH.postScale(max, max);
        this.boB = max * (1.0f / i);
        this.bjT = this.boB;
        this.boC = this.bjT;
        this.bjU = 2.0f * this.boC;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.boy.getWidth();
        if (realWidth > 1.0f) {
            this.boB /= realWidth;
        }
        bVar.ac(1.0f / this.boC);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int boR;
        int boS;

        public a(Context context) {
            super(context);
            this.boR = 0;
            this.boS = 0;
        }

        public void gC(int i) {
            this.boR = i;
        }

        public void gD(int i) {
            this.boS = i;
        }

        public int RX() {
            return this.boR;
        }

        public int RY() {
            return this.boS;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.boR = 0;
            this.boS = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

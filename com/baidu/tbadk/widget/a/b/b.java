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
    private final View aOF;
    private ScaleGestureDetector aOG;
    private BitmapRegionDecoder aOH;
    private com.baidu.tbadk.widget.a.a.b aOI;
    private com.baidu.tbadk.widget.a.c.a aOJ;
    private float aOK;
    private float aOL;
    private int aON;
    private a aOO;
    private com.baidu.tbadk.widget.a.c.c aOP;
    private View.OnClickListener aOR;
    private com.baidu.tbadk.widget.a.b.a aOT;
    private ValueAnimator aOU;
    private View.OnLongClickListener axo;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aMc = 2.0f;
    private float aMb = 1.0f;
    private float aOM = 1.0f;
    private final Matrix aOQ = new Matrix();
    Bitmap aOS = null;
    private boolean aOV = false;
    BdAsyncTask<String, String, String> aOW = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.aOI != null && b.this.aOH != null) {
                int[] HY = b.this.aOJ.HY();
                int i = 1;
                while (Math.max(HY[0] / b.this.aOI.HJ(), HY[1] / b.this.aOI.HK()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, HY[0], HY[1]);
                try {
                    b.this.aOS = b.this.aOH.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.aOS = b.this.aOH.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.aOS = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.DT().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.aOS, false));
                b.this.a(b.this.aOS, b.this.aOI, pow);
                b.this.aOI.i(b.this.aOS);
                b.this.HV();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.aOT != null) {
                b.this.aOT.Be();
            }
            b.this.HT();
            b.this.aOF.invalidate();
        }
    };

    public b(View view) {
        this.aON = 1;
        this.aOF = view;
        this.mContext = this.aOF.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0067b());
        this.aOG = new ScaleGestureDetector(this.mContext, new c());
        this.aOO = new a(this.mContext);
        this.aON = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.aON != 2 || this.aOI == null) {
            return false;
        }
        switch (action) {
            case 0:
                if (!this.aOO.isFinished()) {
                    this.aOV = true;
                } else {
                    this.aOV = false;
                }
            case 1:
            case 3:
                GW();
                break;
        }
        this.aOO.forceFinished(true);
        this.aOG.onTouchEvent(motionEvent);
        if (this.aOG.isInProgress()) {
            return true;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    public void GW() {
        if (this.aOL / this.aMb < 1.0f) {
            a(this.aMb, 0.0f, 0.0f, 400);
        }
    }

    public boolean HO() {
        if (this.aON == 1) {
            return false;
        }
        if (this.aOO.computeScrollOffset()) {
            int currX = this.aOO.getCurrX();
            this.aOO.fC(currX);
            int currY = this.aOO.getCurrY();
            this.aOO.fD(currY);
            moveTo(-((currX - this.aOO.HW()) * 2.0f), -((currY - this.aOO.HX()) * 2.0f));
            this.aOF.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.aOJ == null) {
            this.mOriginalBitmap = bitmap;
            this.aOJ = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.aOH = this.aOJ.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.aOH = this.aOJ.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.aON = 2;
            HP();
        }
    }

    public void HP() {
        if (this.aON == 2 && this.aOJ != null && this.aOW.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.aOI == null && this.aOF.getMeasuredWidth() > 0 && this.aOF.getMeasuredHeight() > 0 && this.aOJ.HY()[0] > 0 && this.aOJ.HY()[1] > 0) {
            this.aOI = new com.baidu.tbadk.widget.a.a.b(this.aOF.getMeasuredWidth(), this.aOF.getMeasuredHeight(), this.aOJ.HY());
            this.aOM = (1.0f * this.aOF.getMeasuredWidth()) / this.aOH.getWidth();
            this.aOW.setPriority(3);
            this.aOW.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aOR = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axo = onLongClickListener;
    }

    public boolean h(Canvas canvas) {
        if (this.aON != 1 || this.mOriginalBitmap == null) {
            if (this.aOI != null) {
                this.aOI.HI();
                if (this.aOI.HN() != null && this.aOI.HN().getBitmap() != null && !this.aOI.HN().getBitmap().isRecycled()) {
                    canvas.drawBitmap(this.aOI.HN().getBitmap(), this.aOQ, null);
                }
                a(this.aOI, false);
                HS();
                canvas.save();
                float HE = (1.0f * this.aOI.HE()) / this.aOI.HM();
                canvas.scale(HE, HE);
                List<com.baidu.tbadk.widget.a.a.a> HL = this.aOI.HL();
                if (HL != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : HL) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.HA(), aVar.HB(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float HQ() {
        return this.aMb;
    }

    public float getMinScaleValue() {
        if (this.aMb < 1.0f) {
            return this.aMb;
        }
        return 1.0f;
    }

    public float HR() {
        return 2.0f * this.aMb;
    }

    public void release() {
        if (this.aOU != null) {
            this.aOU.cancel();
        }
        if (this.aOW != null) {
            this.aOW.cancel();
        }
        if (this.aOP != null) {
            this.aOP.onDestory();
        }
        if (this.aOI != null && this.aOI.HL() != null) {
            this.aOI.HL().clear();
        }
        if (this.aOS != null) {
            this.aOS.recycle();
            this.aOS = null;
        }
        if (this.aOH != null) {
            this.aOH.recycle();
        }
    }

    private void HS() {
        List<com.baidu.tbadk.widget.a.a.a> HL = this.aOI.HL();
        if (HL != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : HL) {
                a(aVar, this.aOI);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.aOT = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.HC().Dx() == 0 && aVar.HC().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.HI());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int HE = aVar.HC().HE();
        aVar.k((i - rect.left) / HE, (i3 - rect.top) / HE, (i2 - rect.left) / HE, (i4 - rect.top) / HE);
        aVar.j((i - rect2.left) / HE, (i3 - rect2.top) / HE, (i2 - rect2.left) / HE, (i4 - rect2.top) / HE);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.HG(), bVar.HE(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.aOP == null) {
            this.aOP = new com.baidu.tbadk.widget.a.c.c(this.aOI, this.aOH);
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
            List<com.baidu.tbadk.widget.a.a.a> HL = this.aOI.HL();
            HL.clear();
            i2 = i3;
            z2 = true;
            list = HL;
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
            this.aOP.Ia();
        }
    }

    public void HT() {
        if (this.aON != 1) {
            a(this.aOI, true);
        }
    }

    private void s(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.aOP.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a t(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0066a c0066a = new a.C0066a(i, i2, i3);
        if (this.aOP.Ib() != null && (aVar = this.aOP.Ib().get(c0066a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.aOP.Ib().remove(c0066a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void Be() {
        this.aOF.postInvalidate();
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
                b.this.aOV = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.aOL == b.this.aMc ? b.this.aMb : b.this.aMc, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect HI = b.this.aOI.HI();
            Rect HF = b.this.aOI.HF();
            float f3 = HI.right - HF.right;
            float f4 = HI.left - HF.left;
            float f5 = HI.bottom - HF.bottom;
            float f6 = HI.top - HF.top;
            b.this.aOO.forceFinished(true);
            b.this.aOO.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.aOF.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aOV = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.aOV || b.this.axo == null) {
                b.this.aOV = false;
            } else {
                b.this.axo.onLongClick(b.this.aOF);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.aOV || b.this.aOR == null) {
                b.this.aOV = false;
            } else {
                b.this.aOR.onClick(b.this.aOF);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.aOU != null) {
            this.aOU.cancel();
        }
        this.aOU = ValueAnimator.ofFloat(this.aOL, f);
        this.aOU.setDuration(i);
        this.aOU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.aOL, f2, f3);
                }
            }
        });
        this.aOU.start();
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
        if (this.aOL * f < this.aOK) {
            f = this.aOK / this.aOL;
        }
        if (this.aOL * f > this.aMc) {
            f = this.aMc / this.aOL;
        }
        Rect HI = this.aOI.HI();
        float f4 = ((HI.left + HI.right) * 1.0f) / 2.0f;
        float f5 = ((HI.bottom + HI.top) * 1.0f) / 2.0f;
        if (this.aOI != null) {
            this.aOQ.postScale(f, f, this.aOI.HJ() / 2, this.aOI.HK() / 2);
            this.aOI.a(1.0f / f, f4, f5);
            this.aOL *= f;
            this.aOI.G(1.0f / this.aOL);
            float[] HU = HU();
            this.aOQ.postTranslate(-HU[0], -HU[1]);
            this.aOI.e((HU[0] * 1.0f) / this.aOL, (HU[1] * 1.0f) / this.aOL);
            HT();
            this.aOF.invalidate();
        }
    }

    private float[] HU() {
        Rect HI = this.aOI.HI();
        int[] HY = this.aOJ.HY();
        float[] fArr = {(HY[0] / 2) - (((HI.left + HI.right) * 1.0f) / 2.0f)};
        if (HI.top < 0) {
            fArr[1] = 0 - HI.top;
        }
        if (HI.bottom > HY[1]) {
            fArr[1] = HY[1] - HI.bottom;
        }
        if (HI.bottom - HI.top > HY[1]) {
            fArr[1] = (HY[1] / 2) - (((HI.bottom + HI.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.aOL;
        fArr[1] = fArr[1] * this.aOL;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.aOI != null) {
            float[] f3 = f(f, f2);
            this.aOQ.postTranslate(-f3[0], -f3[1]);
            this.aOI.e((f3[0] * 1.0f) / this.aOL, (f3[1] * 1.0f) / this.aOL);
            HT();
            this.aOF.invalidate();
        }
    }

    private float[] f(float f, float f2) {
        float[] fArr = new float[2];
        Rect HI = this.aOI.HI();
        int[] HY = this.aOJ.HY();
        if (HI.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (HI.bottom + f2 > HY[1]) {
            f2 = (HY[1] - HI.bottom) * this.aOL;
        }
        if (HI.bottom - HI.top > HY[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HV() {
        if (this.aOI != null) {
            this.aOI.H(1.0f / this.aMb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.HJ() * 1.0f) / bitmap.getWidth(), (bVar.HK() * 1.0f) / bitmap.getHeight());
        this.aOQ.postScale(max, max);
        this.aOK = max * (1.0f / i);
        this.aMb = this.aOK;
        this.aOL = this.aMb;
        this.aMc = 2.0f * this.aOL;
        float HJ = (bVar.HJ() * 1.0f) / this.aOH.getWidth();
        if (HJ > 1.0f) {
            this.aOM = HJ;
            this.aOK /= HJ;
        }
        bVar.G(1.0f / this.aOL);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int aPa;
        int aPb;

        public a(Context context) {
            super(context);
            this.aPa = 0;
            this.aPb = 0;
        }

        public void fC(int i) {
            this.aPa = i;
        }

        public void fD(int i) {
            this.aPb = i;
        }

        public int HW() {
            return this.aPa;
        }

        public int HX() {
            return this.aPb;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.aPa = 0;
            this.aPb = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

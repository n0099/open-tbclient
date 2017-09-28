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
    private final View aOS;
    private ScaleGestureDetector aOT;
    private BitmapRegionDecoder aOU;
    private com.baidu.tbadk.widget.a.a.b aOV;
    private com.baidu.tbadk.widget.a.c.a aOW;
    private float aOX;
    private float aOY;
    private int aPa;
    private a aPb;
    private com.baidu.tbadk.widget.a.c.c aPc;
    private View.OnClickListener aPe;
    private com.baidu.tbadk.widget.a.b.a aPg;
    private ValueAnimator aPh;
    private View.OnLongClickListener axA;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aMp = 2.0f;
    private float aMo = 1.0f;
    private float aOZ = 1.0f;
    private final Matrix aPd = new Matrix();
    Bitmap aPf = null;
    private boolean aPi = false;
    BdAsyncTask<String, String, String> aPj = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.aOV != null && b.this.aOU != null) {
                int[] Ie = b.this.aOW.Ie();
                int i = 1;
                while (Math.max(Ie[0] / b.this.aOV.HP(), Ie[1] / b.this.aOV.HQ()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, Ie[0], Ie[1]);
                try {
                    b.this.aPf = b.this.aOU.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.aPf = b.this.aOU.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.aPf = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.DZ().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.aPf, false));
                b.this.a(b.this.aPf, b.this.aOV, pow);
                b.this.aOV.i(b.this.aPf);
                b.this.Ib();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.aPg != null) {
                b.this.aPg.Bk();
            }
            b.this.HZ();
            b.this.aOS.invalidate();
        }
    };

    public b(View view) {
        this.aPa = 1;
        this.aOS = view;
        this.mContext = this.aOS.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0067b());
        this.aOT = new ScaleGestureDetector(this.mContext, new c());
        this.aPb = new a(this.mContext);
        this.aPa = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.aPa != 2 || this.aOV == null) {
            return false;
        }
        switch (action) {
            case 0:
                if (!this.aPb.isFinished()) {
                    this.aPi = true;
                } else {
                    this.aPi = false;
                }
            case 1:
            case 3:
                Hc();
                break;
        }
        this.aPb.forceFinished(true);
        this.aOT.onTouchEvent(motionEvent);
        if (this.aOT.isInProgress()) {
            return true;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    public void Hc() {
        if (this.aOY / this.aMo < 1.0f) {
            a(this.aMo, 0.0f, 0.0f, 400);
        }
    }

    public boolean HU() {
        if (this.aPa == 1) {
            return false;
        }
        if (this.aPb.computeScrollOffset()) {
            int currX = this.aPb.getCurrX();
            this.aPb.fD(currX);
            int currY = this.aPb.getCurrY();
            this.aPb.fE(currY);
            moveTo(-((currX - this.aPb.Ic()) * 2.0f), -((currY - this.aPb.Id()) * 2.0f));
            this.aOS.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.aOW == null) {
            this.mOriginalBitmap = bitmap;
            this.aOW = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.aOU = this.aOW.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.aOU = this.aOW.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.aPa = 2;
            HV();
        }
    }

    public void HV() {
        if (this.aPa == 2 && this.aOW != null && this.aPj.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING && this.aOV == null && this.aOS.getMeasuredWidth() > 0 && this.aOS.getMeasuredHeight() > 0 && this.aOW.Ie()[0] > 0 && this.aOW.Ie()[1] > 0) {
            this.aOV = new com.baidu.tbadk.widget.a.a.b(this.aOS.getMeasuredWidth(), this.aOS.getMeasuredHeight(), this.aOW.Ie());
            this.aOZ = (1.0f * this.aOS.getMeasuredWidth()) / this.aOU.getWidth();
            this.aPj.setPriority(3);
            this.aPj.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aPe = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axA = onLongClickListener;
    }

    public boolean h(Canvas canvas) {
        if (this.aPa != 1 || this.mOriginalBitmap == null) {
            if (this.aOV != null) {
                this.aOV.HO();
                if (this.aOV.HT() != null) {
                    canvas.drawBitmap(this.aOV.HT().getBitmap(), this.aPd, null);
                }
                a(this.aOV, false);
                HY();
                canvas.save();
                float HK = (1.0f * this.aOV.HK()) / this.aOV.HS();
                canvas.scale(HK, HK);
                List<com.baidu.tbadk.widget.a.a.a> HR = this.aOV.HR();
                if (HR != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : HR) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.HG(), aVar.HH(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float HW() {
        return this.aMo;
    }

    public float getMinScaleValue() {
        if (this.aMo < 1.0f) {
            return this.aMo;
        }
        return 1.0f;
    }

    public float HX() {
        return 2.0f * this.aMo;
    }

    public void release() {
        if (this.aPh != null) {
            this.aPh.cancel();
        }
        if (this.aPj != null) {
            this.aPj.cancel();
        }
        if (this.aPc != null) {
            this.aPc.onDestory();
        }
        if (this.aOV != null && this.aOV.HR() != null) {
            this.aOV.HR().clear();
        }
        if (this.aPf != null) {
            this.aPf.recycle();
            this.aPf = null;
        }
        if (this.aOU != null) {
            this.aOU.recycle();
        }
    }

    private void HY() {
        List<com.baidu.tbadk.widget.a.a.a> HR = this.aOV.HR();
        if (HR != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : HR) {
                a(aVar, this.aOV);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.aPg = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.HI().DD() == 0 && aVar.HI().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.HO());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int HK = aVar.HI().HK();
        aVar.k((i - rect.left) / HK, (i3 - rect.top) / HK, (i2 - rect.left) / HK, (i4 - rect.top) / HK);
        aVar.j((i - rect2.left) / HK, (i3 - rect2.top) / HK, (i2 - rect2.left) / HK, (i4 - rect2.top) / HK);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.HM(), bVar.HK(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.aPc == null) {
            this.aPc = new com.baidu.tbadk.widget.a.c.c(this.aOV, this.aOU);
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
            List<com.baidu.tbadk.widget.a.a.a> HR = this.aOV.HR();
            HR.clear();
            i2 = i3;
            z2 = true;
            list = HR;
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
            this.aPc.Ig();
        }
    }

    public void HZ() {
        if (this.aPa != 1) {
            a(this.aOV, true);
        }
    }

    private void s(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.aPc.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a t(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0066a c0066a = new a.C0066a(i, i2, i3);
        if (this.aPc.Ih() != null && (aVar = this.aPc.Ih().get(c0066a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.aPc.Ih().remove(c0066a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void Bk() {
        this.aOS.postInvalidate();
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
                b.this.aPi = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.aOY == b.this.aMp ? b.this.aMo : b.this.aMp, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect HO = b.this.aOV.HO();
            Rect HL = b.this.aOV.HL();
            float f3 = HO.right - HL.right;
            float f4 = HO.left - HL.left;
            float f5 = HO.bottom - HL.bottom;
            float f6 = HO.top - HL.top;
            b.this.aPb.forceFinished(true);
            b.this.aPb.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.aOS.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aPi = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.aPi || b.this.axA == null) {
                b.this.aPi = false;
            } else {
                b.this.axA.onLongClick(b.this.aOS);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.aPi || b.this.aPe == null) {
                b.this.aPi = false;
            } else {
                b.this.aPe.onClick(b.this.aOS);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.aPh != null) {
            this.aPh.cancel();
        }
        this.aPh = ValueAnimator.ofFloat(this.aOY, f);
        this.aPh.setDuration(i);
        this.aPh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.aOY, f2, f3);
                }
            }
        });
        this.aPh.start();
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
        if (this.aOY * f < this.aOX) {
            f = this.aOX / this.aOY;
        }
        if (this.aOY * f > this.aMp) {
            f = this.aMp / this.aOY;
        }
        Rect HO = this.aOV.HO();
        float f4 = ((HO.left + HO.right) * 1.0f) / 2.0f;
        float f5 = ((HO.bottom + HO.top) * 1.0f) / 2.0f;
        if (this.aOV != null) {
            this.aPd.postScale(f, f, this.aOV.HP() / 2, this.aOV.HQ() / 2);
            this.aOV.a(1.0f / f, f4, f5);
            this.aOY *= f;
            this.aOV.G(1.0f / this.aOY);
            float[] Ia = Ia();
            this.aPd.postTranslate(-Ia[0], -Ia[1]);
            this.aOV.e((Ia[0] * 1.0f) / this.aOY, (Ia[1] * 1.0f) / this.aOY);
            HZ();
            this.aOS.invalidate();
        }
    }

    private float[] Ia() {
        Rect HO = this.aOV.HO();
        int[] Ie = this.aOW.Ie();
        float[] fArr = {(Ie[0] / 2) - (((HO.left + HO.right) * 1.0f) / 2.0f)};
        if (HO.top < 0) {
            fArr[1] = 0 - HO.top;
        }
        if (HO.bottom > Ie[1]) {
            fArr[1] = Ie[1] - HO.bottom;
        }
        if (HO.bottom - HO.top > Ie[1]) {
            fArr[1] = (Ie[1] / 2) - (((HO.bottom + HO.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.aOY;
        fArr[1] = fArr[1] * this.aOY;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.aOV != null) {
            float[] f3 = f(f, f2);
            this.aPd.postTranslate(-f3[0], -f3[1]);
            this.aOV.e((f3[0] * 1.0f) / this.aOY, (f3[1] * 1.0f) / this.aOY);
            HZ();
            this.aOS.invalidate();
        }
    }

    private float[] f(float f, float f2) {
        float[] fArr = new float[2];
        Rect HO = this.aOV.HO();
        int[] Ie = this.aOW.Ie();
        if (HO.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (HO.bottom + f2 > Ie[1]) {
            f2 = (Ie[1] - HO.bottom) * this.aOY;
        }
        if (HO.bottom - HO.top > Ie[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib() {
        if (this.aOV != null) {
            this.aOV.H(1.0f / this.aMo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.HP() * 1.0f) / bitmap.getWidth(), (bVar.HQ() * 1.0f) / bitmap.getHeight());
        this.aPd.postScale(max, max);
        this.aOX = max * (1.0f / i);
        this.aMo = this.aOX;
        this.aOY = this.aMo;
        this.aMp = 2.0f * this.aOY;
        float HP = (bVar.HP() * 1.0f) / this.aOU.getWidth();
        if (HP > 1.0f) {
            this.aOZ = HP;
            this.aOX /= HP;
        }
        bVar.G(1.0f / this.aOY);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int aPn;
        int aPo;

        public a(Context context) {
            super(context);
            this.aPn = 0;
            this.aPo = 0;
        }

        public void fD(int i) {
            this.aPn = i;
        }

        public void fE(int i) {
            this.aPo = i;
        }

        public int Ic() {
            return this.aPn;
        }

        public int Id() {
            return this.aPo;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.aPn = 0;
            this.aPo = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

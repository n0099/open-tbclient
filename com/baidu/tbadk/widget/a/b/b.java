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
    private final View aOM;
    private ScaleGestureDetector aON;
    private BitmapRegionDecoder aOO;
    private com.baidu.tbadk.widget.a.a.b aOP;
    private com.baidu.tbadk.widget.a.c.a aOQ;
    private float aOR;
    private float aOS;
    private int aOT;
    private a aOU;
    private com.baidu.tbadk.widget.a.c.c aOV;
    private com.baidu.tbadk.widget.a.b.a aOY;
    private ValueAnimator aOZ;
    private View.OnLongClickListener axY;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aMQ = 2.0f;
    private float aMP = 1.0f;
    private final Matrix aOW = new Matrix();
    Bitmap aOX = null;
    private boolean aPa = true;
    private boolean aPb = false;
    BdAsyncTask<String, String, String> aPc = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.aOP != null && b.this.aOO != null) {
                int[] Ii = b.this.aOQ.Ii();
                int i = 1;
                while (Math.max(Ii[0] / b.this.aOP.HR(), Ii[1] / b.this.aOP.HS()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, Ii[0], Ii[1]);
                try {
                    b.this.aOX = b.this.aOO.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.aOX = b.this.aOO.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.aOX = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Eg().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.aOX, false));
                b.this.a(b.this.aOX, b.this.aOP, pow);
                b.this.aOP.i(b.this.aOX);
                b.this.If();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.aOY != null) {
                b.this.aOY.Bs();
            }
            b.this.Id();
            b.this.aOM.invalidate();
        }
    };

    public b(View view) {
        this.aOT = 1;
        this.aOM = view;
        this.mContext = this.aOM.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0067b());
        this.aON = new ScaleGestureDetector(this.mContext, new c());
        this.aOU = new a(this.mContext);
        this.aOT = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.aOT == 2 && HZ()) {
            switch (action) {
                case 0:
                    if (!this.aOU.isFinished()) {
                        this.aPb = true;
                    } else {
                        this.aPb = false;
                    }
                case 1:
                case 3:
                    Hj();
                    break;
            }
            this.aOU.forceFinished(true);
            this.aON.onTouchEvent(motionEvent);
            if (this.aON.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean HW() {
        return Math.floor((double) (this.aMP * 10000.0f)) == Math.floor((double) (this.aOS * 10000.0f));
    }

    public void Hj() {
        if (this.aOS / this.aMP < 1.0f) {
            a(this.aMP, 0.0f, 0.0f, 400);
        }
    }

    public boolean HX() {
        if (this.aOT == 1) {
            return false;
        }
        if (this.aOU.computeScrollOffset()) {
            int currX = this.aOU.getCurrX();
            this.aOU.fD(currX);
            int currY = this.aOU.getCurrY();
            this.aOU.fE(currY);
            moveTo(-((currX - this.aOU.Ig()) * 2.0f), -((currY - this.aOU.Ih()) * 2.0f));
            this.aOM.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.aOQ == null) {
            this.mOriginalBitmap = bitmap;
            this.aOQ = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.aOO = this.aOQ.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.aOO = this.aOQ.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.aOT = 2;
            HY();
        }
    }

    public void HY() {
        if (this.aOT == 2 && this.aOQ != null && this.aPc.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.aOP == null && this.aOM.getMeasuredWidth() > 0 && this.aOM.getMeasuredHeight() > 0 && this.aOQ.Ii()[0] > 0 && this.aOQ.Ii()[1] > 0) {
            this.aOP = new com.baidu.tbadk.widget.a.a.b(this.aOM.getMeasuredWidth(), this.aOM.getMeasuredHeight(), this.aOQ.Ii());
            this.aPc.setPriority(3);
            this.aPc.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axY = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !HZ()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.aOM.getWidth() - this.aOM.getPaddingLeft()) - this.aOM.getPaddingRight();
            int height2 = (this.aOM.getHeight() - this.aOM.getPaddingTop()) - this.aOM.getPaddingBottom();
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
        return g(canvas);
    }

    private boolean HZ() {
        return (this.aOP == null || this.aOP.HV() == null || this.aOP.HV().getBitmap() == null || this.aOP.HV().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean g(Canvas canvas) {
        if (this.aOT != 1 || this.mOriginalBitmap == null) {
            if (this.aOP != null) {
                this.aOP.HQ();
                if (HZ()) {
                    canvas.drawBitmap(this.aOP.HV().getBitmap(), this.aOW, null);
                }
                a(this.aOP, false);
                Ic();
                canvas.save();
                float HM = (1.0f * this.aOP.HM()) / this.aOP.HU();
                canvas.scale(HM, HM);
                List<com.baidu.tbadk.widget.a.a.a> HT = this.aOP.HT();
                if (HT != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : HT) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.HI(), aVar.HJ(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float Ia() {
        return this.aMP;
    }

    public float getMinScaleValue() {
        if (this.aMP < 1.0f) {
            return this.aMP;
        }
        return 1.0f;
    }

    public float Ib() {
        return 2.0f * this.aMP;
    }

    public void release() {
        if (this.aOZ != null) {
            this.aOZ.cancel();
        }
        if (this.aPc != null) {
            this.aPc.cancel();
        }
        if (this.aOV != null) {
            this.aOV.onDestory();
        }
        if (this.aOP != null && this.aOP.HT() != null) {
            this.aOP.HT().clear();
        }
        if (this.aOX != null) {
            this.aOX.recycle();
            this.aOX = null;
        }
        if (this.aOO != null) {
            this.aOO.recycle();
        }
    }

    private void Ic() {
        List<com.baidu.tbadk.widget.a.a.a> HT = this.aOP.HT();
        if (HT != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : HT) {
                a(aVar, this.aOP);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.aOY = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.HK().DM() == 0 && aVar.HK().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.HQ());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int HM = aVar.HK().HM();
        aVar.k((i - rect.left) / HM, (i3 - rect.top) / HM, (i2 - rect.left) / HM, (i4 - rect.top) / HM);
        aVar.j((i - rect2.left) / HM, (i3 - rect2.top) / HM, (i2 - rect2.left) / HM, (i4 - rect2.top) / HM);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.HO(), bVar.HM(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.aOV == null) {
            this.aOV = new com.baidu.tbadk.widget.a.c.c(this.aOP, this.aOO);
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
            List<com.baidu.tbadk.widget.a.a.a> HT = this.aOP.HT();
            HT.clear();
            i2 = i3;
            z2 = true;
            list = HT;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                com.baidu.tbadk.widget.a.a.a s = s(i2, i7, i);
                if (s == null) {
                    if (z) {
                        r(i2, i7, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(s);
                }
            }
            i2++;
        }
        if (z2) {
            this.aOV.Ik();
        }
    }

    public void Id() {
        if (this.aOT != 1) {
            a(this.aOP, true);
        }
    }

    private void r(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.aOV.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a s(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0066a c0066a = new a.C0066a(i, i2, i3);
        if (this.aOV.Il() != null && (aVar = this.aOV.Il().get(c0066a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.aOV.Il().remove(c0066a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void Bs() {
        this.aOM.postInvalidate();
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
                b.this.aPb = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.aOS == b.this.aMQ ? b.this.aMP : b.this.aMQ, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect HQ = b.this.aOP.HQ();
            Rect HN = b.this.aOP.HN();
            float f3 = HQ.right - HN.right;
            float f4 = HQ.left - HN.left;
            float f5 = HQ.bottom - HN.bottom;
            float f6 = HQ.top - HN.top;
            b.this.aOU.forceFinished(true);
            b.this.aOU.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.aOM.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aPb = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.aPb || b.this.axY == null) {
                b.this.aPb = false;
            } else {
                b.this.axY.onLongClick(b.this.aOM);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.aPb || b.this.mClickListener == null) {
                b.this.aPb = false;
            } else {
                b.this.mClickListener.onClick(b.this.aOM);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.aOZ != null) {
            this.aOZ.cancel();
        }
        this.aOZ = ValueAnimator.ofFloat(this.aOS, f);
        this.aOZ.setDuration(i);
        this.aOZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.aOS, f2, f3);
                }
            }
        });
        this.aOZ.start();
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
        if (this.aOS * f < this.aOR) {
            f = this.aOR / this.aOS;
        }
        if (this.aOS * f > this.aMQ) {
            f = this.aMQ / this.aOS;
        }
        Rect HQ = this.aOP.HQ();
        float f4 = ((HQ.left + HQ.right) * 1.0f) / 2.0f;
        float f5 = ((HQ.bottom + HQ.top) * 1.0f) / 2.0f;
        if (this.aOP != null) {
            this.aOW.postScale(f, f, this.aOP.HR() / 2, this.aOP.HS() / 2);
            this.aOP.a(1.0f / f, f4, f5);
            this.aOS *= f;
            this.aOP.F(1.0f / this.aOS);
            float[] Ie = Ie();
            this.aOW.postTranslate(-Ie[0], -Ie[1]);
            this.aOP.f((Ie[0] * 1.0f) / this.aOS, (Ie[1] * 1.0f) / this.aOS);
            Id();
            this.aOM.invalidate();
        }
    }

    public boolean Hi() {
        Rect HQ;
        return (this.aOP == null || (HQ = this.aOP.HQ()) == null || HQ.top > 10) ? false : true;
    }

    private float[] Ie() {
        Rect HQ = this.aOP.HQ();
        int[] Ii = this.aOQ.Ii();
        float[] fArr = {(Ii[0] / 2) - (((HQ.left + HQ.right) * 1.0f) / 2.0f)};
        if (HQ.top < 0) {
            fArr[1] = 0 - HQ.top;
        }
        if (HQ.bottom > Ii[1]) {
            fArr[1] = Ii[1] - HQ.bottom;
        }
        if (HQ.bottom - HQ.top > Ii[1]) {
            fArr[1] = (Ii[1] / 2) - (((HQ.bottom + HQ.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.aOS;
        fArr[1] = fArr[1] * this.aOS;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.aOP != null) {
            float[] g = g(f, f2);
            this.aOW.postTranslate(-g[0], -g[1]);
            this.aOP.f((g[0] * 1.0f) / this.aOS, (g[1] * 1.0f) / this.aOS);
            Id();
            this.aOM.invalidate();
        }
    }

    private float[] g(float f, float f2) {
        float[] fArr = new float[2];
        Rect HQ = this.aOP.HQ();
        int[] Ii = this.aOQ.Ii();
        if (HQ.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (HQ.bottom + f2 > Ii[1]) {
            f2 = (Ii[1] - HQ.bottom) * this.aOS;
        }
        if (HQ.bottom - HQ.top > Ii[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.aPa = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If() {
        if (this.aOP != null) {
            this.aOP.G(1.0f / this.aMP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.HR() * 1.0f) / bitmap.getWidth(), (bVar.HS() * 1.0f) / bitmap.getHeight());
        this.aOW.postScale(max, max);
        this.aOR = max * (1.0f / i);
        this.aMP = this.aOR;
        this.aOS = this.aMP;
        this.aMQ = 2.0f * this.aOS;
        float HR = (bVar.HR() * 1.0f) / this.aOO.getWidth();
        if (HR > 1.0f) {
            this.aOR /= HR;
        }
        bVar.F(1.0f / this.aOS);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int aPg;
        int aPh;

        public a(Context context) {
            super(context);
            this.aPg = 0;
            this.aPh = 0;
        }

        public void fD(int i) {
            this.aPg = i;
        }

        public void fE(int i) {
            this.aPh = i;
        }

        public int Ig() {
            return this.aPg;
        }

        public int Ih() {
            return this.aPh;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.aPg = 0;
            this.aPh = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

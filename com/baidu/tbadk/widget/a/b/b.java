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
    private final View aOU;
    private ScaleGestureDetector aOV;
    private BitmapRegionDecoder aOW;
    private com.baidu.tbadk.widget.a.a.b aOX;
    private com.baidu.tbadk.widget.a.c.a aOY;
    private float aOZ;
    private float aPa;
    private int aPb;
    private a aPc;
    private com.baidu.tbadk.widget.a.c.c aPd;
    private com.baidu.tbadk.widget.a.b.a aPg;
    private ValueAnimator aPh;
    private View.OnLongClickListener ayg;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aMY = 2.0f;
    private float aMX = 1.0f;
    private final Matrix aPe = new Matrix();
    Bitmap aPf = null;
    private boolean aPi = true;
    private boolean aPj = false;
    BdAsyncTask<String, String, String> aPk = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.a.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.aOX != null && b.this.aOW != null) {
                int[] It = b.this.aOY.It();
                int i = 1;
                while (Math.max(It[0] / b.this.aOX.Ic(), It[1] / b.this.aOX.Id()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, It[0], It[1]);
                try {
                    b.this.aPf = b.this.aOW.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.aPf = b.this.aOW.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.aPf = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Es().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.a.a(b.this.aPf, false));
                b.this.a(b.this.aPf, b.this.aOX, pow);
                b.this.aOX.i(b.this.aPf);
                b.this.Iq();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.aPg != null) {
                b.this.aPg.BE();
            }
            b.this.Io();
            b.this.aOU.invalidate();
        }
    };

    public b(View view) {
        this.aPb = 1;
        this.aOU = view;
        this.mContext = this.aOU.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0067b());
        this.aOV = new ScaleGestureDetector(this.mContext, new c());
        this.aPc = new a(this.mContext);
        this.aPb = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.aPb == 2 && Ik()) {
            switch (action) {
                case 0:
                    if (!this.aPc.isFinished()) {
                        this.aPj = true;
                    } else {
                        this.aPj = false;
                    }
                case 1:
                case 3:
                    Hu();
                    break;
            }
            this.aPc.forceFinished(true);
            this.aOV.onTouchEvent(motionEvent);
            if (this.aOV.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Ih() {
        return Math.floor((double) (this.aMX * 10000.0f)) == Math.floor((double) (this.aPa * 10000.0f));
    }

    public void Hu() {
        if (this.aPa / this.aMX < 1.0f) {
            a(this.aMX, 0.0f, 0.0f, 400);
        }
    }

    public boolean Ii() {
        if (this.aPb == 1) {
            return false;
        }
        if (this.aPc.computeScrollOffset()) {
            int currX = this.aPc.getCurrX();
            this.aPc.fC(currX);
            int currY = this.aPc.getCurrY();
            this.aPc.fD(currY);
            moveTo(-((currX - this.aPc.Ir()) * 2.0f), -((currY - this.aPc.Is()) * 2.0f));
            this.aOU.invalidate();
            return true;
        }
        return true;
    }

    public void b(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.aOY == null) {
            this.mOriginalBitmap = bitmap;
            this.aOY = new com.baidu.tbadk.widget.a.c.a(this.mContext);
            try {
                this.aOW = this.aOY.y(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.aOW = this.aOY.y(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.aPb = 2;
            Ij();
        }
    }

    public void Ij() {
        if (this.aPb == 2 && this.aOY != null && this.aPk.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.aOX == null && this.aOU.getMeasuredWidth() > 0 && this.aOU.getMeasuredHeight() > 0 && this.aOY.It()[0] > 0 && this.aOY.It()[1] > 0) {
            this.aOX = new com.baidu.tbadk.widget.a.a.b(this.aOU.getMeasuredWidth(), this.aOU.getMeasuredHeight(), this.aOY.It());
            this.aPk.setPriority(3);
            this.aPk.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayg = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !Ik()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.aOU.getWidth() - this.aOU.getPaddingLeft()) - this.aOU.getPaddingRight();
            int height2 = (this.aOU.getHeight() - this.aOU.getPaddingTop()) - this.aOU.getPaddingBottom();
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

    private boolean Ik() {
        return (this.aOX == null || this.aOX.Ig() == null || this.aOX.Ig().getBitmap() == null || this.aOX.Ig().getBitmap().isRecycled()) ? false : true;
    }

    protected boolean g(Canvas canvas) {
        if (this.aPb != 1 || this.mOriginalBitmap == null) {
            if (this.aOX != null) {
                this.aOX.Ib();
                if (Ik()) {
                    canvas.drawBitmap(this.aOX.Ig().getBitmap(), this.aPe, null);
                }
                a(this.aOX, false);
                In();
                canvas.save();
                float HX = (1.0f * this.aOX.HX()) / this.aOX.If();
                canvas.scale(HX, HX);
                List<com.baidu.tbadk.widget.a.a.a> Ie = this.aOX.Ie();
                if (Ie != null) {
                    for (com.baidu.tbadk.widget.a.a.a aVar : Ie) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.HT(), aVar.HU(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float Il() {
        return this.aMX;
    }

    public float getMinScaleValue() {
        if (this.aMX < 1.0f) {
            return this.aMX;
        }
        return 1.0f;
    }

    public float Im() {
        return 2.0f * this.aMX;
    }

    public void release() {
        if (this.aPh != null) {
            this.aPh.cancel();
        }
        if (this.aPk != null) {
            this.aPk.cancel();
        }
        if (this.aPd != null) {
            this.aPd.onDestory();
        }
        if (this.aOX != null && this.aOX.Ie() != null) {
            this.aOX.Ie().clear();
        }
        if (this.aPf != null) {
            this.aPf.recycle();
            this.aPf = null;
        }
        if (this.aOW != null) {
            this.aOW.recycle();
        }
    }

    private void In() {
        List<com.baidu.tbadk.widget.a.a.a> Ie = this.aOX.Ie();
        if (Ie != null) {
            for (com.baidu.tbadk.widget.a.a.a aVar : Ie) {
                a(aVar, this.aOX);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.a.b.a aVar) {
        this.aPg = aVar;
    }

    public void a(com.baidu.tbadk.widget.a.a.a aVar, com.baidu.tbadk.widget.a.a.b bVar) {
        if (aVar.HV().DY() == 0 && aVar.HV().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.Ib());
    }

    private void a(com.baidu.tbadk.widget.a.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int HX = aVar.HV().HX();
        aVar.k((i - rect.left) / HX, (i3 - rect.top) / HX, (i2 - rect.left) / HX, (i4 - rect.top) / HX);
        aVar.j((i - rect2.left) / HX, (i3 - rect2.top) / HX, (i2 - rect2.left) / HX, (i4 - rect2.top) / HX);
    }

    private void a(com.baidu.tbadk.widget.a.a.b bVar, boolean z) {
        a(bVar.HZ(), bVar.HX(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.a.a.a> list;
        if (this.aPd == null) {
            this.aPd = new com.baidu.tbadk.widget.a.c.c(this.aOX, this.aOW);
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
            List<com.baidu.tbadk.widget.a.a.a> Ie = this.aOX.Ie();
            Ie.clear();
            i2 = i3;
            z2 = true;
            list = Ie;
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
            this.aPd.Iv();
        }
    }

    public void Io() {
        if (this.aPb != 1) {
            a(this.aOX, true);
        }
    }

    private void r(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.aPd.a(aVar);
    }

    private com.baidu.tbadk.widget.a.a.a s(int i, int i2, int i3) {
        com.baidu.tbadk.widget.a.a.a aVar;
        a.C0066a c0066a = new a.C0066a(i, i2, i3);
        if (this.aPd.Iw() != null && (aVar = this.aPd.Iw().get(c0066a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.aPd.Iw().remove(c0066a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.a.b.a
    public void BE() {
        this.aOU.postInvalidate();
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
                b.this.aPj = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.aPa == b.this.aMY ? b.this.aMX : b.this.aMY, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Ib = b.this.aOX.Ib();
            Rect HY = b.this.aOX.HY();
            float f3 = Ib.right - HY.right;
            float f4 = Ib.left - HY.left;
            float f5 = Ib.bottom - HY.bottom;
            float f6 = Ib.top - HY.top;
            b.this.aPc.forceFinished(true);
            b.this.aPc.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.aOU.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aPj = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.aPj || b.this.ayg == null) {
                b.this.aPj = false;
            } else {
                b.this.ayg.onLongClick(b.this.aOU);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.aPj || b.this.mClickListener == null) {
                b.this.aPj = false;
            } else {
                b.this.mClickListener.onClick(b.this.aOU);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.aPh != null) {
            this.aPh.cancel();
        }
        this.aPh = ValueAnimator.ofFloat(this.aPa, f);
        this.aPh.setDuration(i);
        this.aPh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.b.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.aPa, f2, f3);
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
        if (this.aPa * f < this.aOZ) {
            f = this.aOZ / this.aPa;
        }
        if (this.aPa * f > this.aMY) {
            f = this.aMY / this.aPa;
        }
        Rect Ib = this.aOX.Ib();
        float f4 = ((Ib.left + Ib.right) * 1.0f) / 2.0f;
        float f5 = ((Ib.bottom + Ib.top) * 1.0f) / 2.0f;
        if (this.aOX != null) {
            this.aPe.postScale(f, f, this.aOX.Ic() / 2, this.aOX.Id() / 2);
            this.aOX.a(1.0f / f, f4, f5);
            this.aPa *= f;
            this.aOX.F(1.0f / this.aPa);
            float[] Ip = Ip();
            this.aPe.postTranslate(-Ip[0], -Ip[1]);
            this.aOX.f((Ip[0] * 1.0f) / this.aPa, (Ip[1] * 1.0f) / this.aPa);
            Io();
            this.aOU.invalidate();
        }
    }

    public boolean Ht() {
        Rect Ib;
        return (this.aOX == null || (Ib = this.aOX.Ib()) == null || Ib.top > 10) ? false : true;
    }

    private float[] Ip() {
        Rect Ib = this.aOX.Ib();
        int[] It = this.aOY.It();
        float[] fArr = {(It[0] / 2) - (((Ib.left + Ib.right) * 1.0f) / 2.0f)};
        if (Ib.top < 0) {
            fArr[1] = 0 - Ib.top;
        }
        if (Ib.bottom > It[1]) {
            fArr[1] = It[1] - Ib.bottom;
        }
        if (Ib.bottom - Ib.top > It[1]) {
            fArr[1] = (It[1] / 2) - (((Ib.bottom + Ib.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.aPa;
        fArr[1] = fArr[1] * this.aPa;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.aOX != null) {
            float[] g = g(f, f2);
            this.aPe.postTranslate(-g[0], -g[1]);
            this.aOX.f((g[0] * 1.0f) / this.aPa, (g[1] * 1.0f) / this.aPa);
            Io();
            this.aOU.invalidate();
        }
    }

    private float[] g(float f, float f2) {
        float[] fArr = new float[2];
        Rect Ib = this.aOX.Ib();
        int[] It = this.aOY.It();
        if (Ib.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Ib.bottom + f2 > It[1]) {
            f2 = (It[1] - Ib.bottom) * this.aPa;
        }
        if (Ib.bottom - Ib.top > It[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.aPi = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iq() {
        if (this.aOX != null) {
            this.aOX.G(1.0f / this.aMX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.a.a.b bVar, int i) {
        float max = Math.max((bVar.Ic() * 1.0f) / bitmap.getWidth(), (bVar.Id() * 1.0f) / bitmap.getHeight());
        this.aPe.postScale(max, max);
        this.aOZ = max * (1.0f / i);
        this.aMX = this.aOZ;
        this.aPa = this.aMX;
        this.aMY = 2.0f * this.aPa;
        float Ic = (bVar.Ic() * 1.0f) / this.aOW.getWidth();
        if (Ic > 1.0f) {
            this.aOZ /= Ic;
        }
        bVar.F(1.0f / this.aPa);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int aPo;
        int aPp;

        public a(Context context) {
            super(context);
            this.aPo = 0;
            this.aPp = 0;
        }

        public void fC(int i) {
            this.aPo = i;
        }

        public void fD(int i) {
            this.aPp = i;
        }

        public int Ir() {
            return this.aPo;
        }

        public int Is() {
            return this.aPp;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.aPo = 0;
            this.aPp = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

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
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.largeImage.logic.a {
    private static final String TAG = b.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    private final View aSN;
    private ScaleGestureDetector aSO;
    private BitmapRegionDecoder aSP;
    private com.baidu.tbadk.widget.largeImage.a.b aSQ;
    private com.baidu.tbadk.widget.largeImage.b.a aSR;
    private float aSS;
    private float aST;
    private int aSU;
    private a aSV;
    private com.baidu.tbadk.widget.largeImage.b.c aSW;
    private com.baidu.tbadk.widget.largeImage.logic.a aSZ;
    private ValueAnimator aTa;
    private View.OnLongClickListener azQ;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aOb = 2.0f;
    private float aOa = 1.0f;
    private final Matrix aSX = new Matrix();
    Bitmap aSY = null;
    private boolean aTb = true;
    private boolean aTc = false;
    BdAsyncTask<String, String, String> aTd = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.aSQ != null && b.this.aSP != null) {
                int[] Jk = b.this.aSR.Jk();
                int i = 1;
                while (Math.max(Jk[0] / b.this.aSQ.getRealWidth(), Jk[1] / b.this.aSQ.IU()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, Jk[0], Jk[1]);
                try {
                    b.this.aSY = b.this.aSP.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.aSY = b.this.aSP.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.aSY = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.EY().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.aSY, false));
                b.this.a(b.this.aSY, b.this.aSQ, pow);
                b.this.aSQ.k(b.this.aSY);
                b.this.Jh();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.aSZ != null) {
                b.this.aSZ.Ct();
            }
            b.this.Jf();
            b.this.aSN.invalidate();
        }
    };

    public b(View view2) {
        this.aSU = 1;
        this.aSN = view2;
        this.mContext = this.aSN.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0107b());
        this.aSO = new ScaleGestureDetector(this.mContext, new c());
        this.aSV = new a(this.mContext);
        this.aSU = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.aSU == 2 && Jb()) {
            switch (action) {
                case 0:
                    if (!this.aSV.isFinished()) {
                        this.aTc = true;
                    } else {
                        this.aTc = false;
                    }
                case 1:
                case 3:
                    HW();
                    break;
            }
            this.aSV.forceFinished(true);
            this.aSO.onTouchEvent(motionEvent);
            if (this.aSO.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean IY() {
        return Math.floor((double) (this.aOa * 10000.0f)) == Math.floor((double) (this.aST * 10000.0f));
    }

    public void HW() {
        if (this.aST / this.aOa < 1.0f) {
            a(this.aOa, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean IZ() {
        if (this.aSU == 1) {
            return false;
        }
        if (this.aSV.computeScrollOffset()) {
            int currX = this.aSV.getCurrX();
            this.aSV.fC(currX);
            int currY = this.aSV.getCurrY();
            this.aSV.fD(currY);
            moveTo(-((currX - this.aSV.Ji()) * 2.0f), -((currY - this.aSV.Jj()) * 2.0f));
            this.aSN.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.aSR == null) {
            this.mOriginalBitmap = bitmap;
            this.aSR = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.aSP = this.aSR.z(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.aSP = this.aSR.z(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.aSU = 2;
            Ja();
        }
    }

    public void Ja() {
        if (this.aSU == 2 && this.aSR != null && this.aTd.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.aSQ == null && this.aSN.getMeasuredWidth() > 0 && this.aSN.getMeasuredHeight() > 0 && this.aSR.Jk()[0] > 0 && this.aSR.Jk()[1] > 0) {
            this.aSQ = new com.baidu.tbadk.widget.largeImage.a.b(this.aSN.getMeasuredWidth(), this.aSN.getMeasuredHeight(), this.aSR.Jk());
            this.aTd.setPriority(3);
            this.aTd.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.azQ = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !Jb()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.aSN.getWidth() - this.aSN.getPaddingLeft()) - this.aSN.getPaddingRight();
            int height2 = (this.aSN.getHeight() - this.aSN.getPaddingTop()) - this.aSN.getPaddingBottom();
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
        return h(canvas);
    }

    private boolean Jb() {
        return (this.aSQ == null || this.aSQ.IX() == null || this.aSQ.IX().getBitmap() == null || this.aSQ.IX().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(Canvas canvas) {
        if (this.aSU != 1 || this.mOriginalBitmap == null) {
            if (this.aSQ != null) {
                this.aSQ.IT();
                if (Jb()) {
                    canvas.drawBitmap(this.aSQ.IX().getBitmap(), this.aSX, null);
                }
                a(this.aSQ, false);
                Je();
                canvas.save();
                float IP = (1.0f * this.aSQ.IP()) / this.aSQ.IW();
                canvas.scale(IP, IP);
                List<com.baidu.tbadk.widget.largeImage.a.a> IV = this.aSQ.IV();
                if (IV != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : IV) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.IL(), aVar.IM(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float Jc() {
        return this.aOa;
    }

    public float getMinScaleValue() {
        if (this.aOa < 1.0f) {
            return this.aOa;
        }
        return 1.0f;
    }

    public float Jd() {
        return 2.0f * this.aOa;
    }

    public void release() {
        if (this.aTa != null) {
            this.aTa.cancel();
        }
        if (this.aTd != null) {
            this.aTd.cancel();
        }
        if (this.aSW != null) {
            this.aSW.onDestory();
        }
        if (this.aSQ != null && this.aSQ.IV() != null) {
            this.aSQ.IV().clear();
        }
        if (this.aSY != null) {
            this.aSY.recycle();
            this.aSY = null;
        }
        if (this.aSP != null) {
            this.aSP.recycle();
        }
    }

    private void Je() {
        List<com.baidu.tbadk.widget.largeImage.a.a> IV = this.aSQ.IV();
        if (IV != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : IV) {
                a(aVar, this.aSQ);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.aSZ = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.IN().EF() == 0 && aVar.IN().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.IT());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int IP = aVar.IN().IP();
        aVar.j((i - rect.left) / IP, (i3 - rect.top) / IP, (i2 - rect.left) / IP, (i4 - rect.top) / IP);
        aVar.i((i - rect2.left) / IP, (i3 - rect2.top) / IP, (i2 - rect2.left) / IP, (i4 - rect2.top) / IP);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.IR(), bVar.IP(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.aSW == null) {
            this.aSW = new com.baidu.tbadk.widget.largeImage.b.c(this.aSQ, this.aSP);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> IV = this.aSQ.IV();
            IV.clear();
            i2 = i3;
            z2 = true;
            list = IV;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                com.baidu.tbadk.widget.largeImage.a.a s = s(i2, i7, i);
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
            this.aSW.Jm();
        }
    }

    public void Jf() {
        if (this.aSU != 1) {
            a(this.aSQ, true);
        }
    }

    private void r(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.aSW.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a s(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0106a c0106a = new a.C0106a(i, i2, i3);
        if (this.aSW.Jn() != null && (aVar = this.aSW.Jn().get(c0106a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.aSW.Jn().remove(c0106a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void Ct() {
        this.aSN.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0107b extends GestureDetector.SimpleOnGestureListener {
        private C0107b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aTc = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.aST == b.this.aOb ? b.this.aOa : b.this.aOb, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect IT = b.this.aSQ.IT();
            Rect IQ = b.this.aSQ.IQ();
            float f3 = IT.right - IQ.right;
            float f4 = IT.left - IQ.left;
            float f5 = IT.bottom - IQ.bottom;
            float f6 = IT.top - IQ.top;
            b.this.aSV.forceFinished(true);
            b.this.aSV.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.aSN.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aTc = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.aTc || b.this.azQ == null) {
                b.this.aTc = false;
            } else {
                b.this.azQ.onLongClick(b.this.aSN);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.aTc || b.this.mClickListener == null) {
                b.this.aTc = false;
            } else {
                b.this.mClickListener.onClick(b.this.aSN);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.aTa != null) {
            this.aTa.cancel();
        }
        this.aTa = ValueAnimator.ofFloat(this.aST, f);
        this.aTa.setDuration(i);
        this.aTa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.aST, f2, f3);
                }
            }
        });
        this.aTa.start();
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
        if (this.aST * f < this.aSS) {
            f = this.aSS / this.aST;
        }
        if (this.aST * f > this.aOb) {
            f = this.aOb / this.aST;
        }
        Rect IT = this.aSQ.IT();
        float f4 = ((IT.left + IT.right) * 1.0f) / 2.0f;
        float f5 = ((IT.bottom + IT.top) * 1.0f) / 2.0f;
        if (this.aSQ != null) {
            this.aSX.postScale(f, f, this.aSQ.getRealWidth() / 2, this.aSQ.IU() / 2);
            this.aSQ.b(1.0f / f, f4, f5);
            this.aST *= f;
            this.aSQ.Q(1.0f / this.aST);
            float[] Jg = Jg();
            this.aSX.postTranslate(-Jg[0], -Jg[1]);
            this.aSQ.h((Jg[0] * 1.0f) / this.aST, (Jg[1] * 1.0f) / this.aST);
            Jf();
            this.aSN.invalidate();
        }
    }

    public boolean HV() {
        Rect IT;
        return (this.aSQ == null || (IT = this.aSQ.IT()) == null || IT.top > 10) ? false : true;
    }

    private float[] Jg() {
        Rect IT = this.aSQ.IT();
        int[] Jk = this.aSR.Jk();
        float[] fArr = {(Jk[0] / 2) - (((IT.left + IT.right) * 1.0f) / 2.0f)};
        if (IT.top < 0) {
            fArr[1] = 0 - IT.top;
        }
        if (IT.bottom > Jk[1]) {
            fArr[1] = Jk[1] - IT.bottom;
        }
        if (IT.bottom - IT.top > Jk[1]) {
            fArr[1] = (Jk[1] / 2) - (((IT.bottom + IT.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.aST;
        fArr[1] = fArr[1] * this.aST;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.aSQ != null) {
            float[] i = i(f, f2);
            this.aSX.postTranslate(-i[0], -i[1]);
            this.aSQ.h((i[0] * 1.0f) / this.aST, (i[1] * 1.0f) / this.aST);
            Jf();
            this.aSN.invalidate();
        }
    }

    private float[] i(float f, float f2) {
        float[] fArr = new float[2];
        Rect IT = this.aSQ.IT();
        int[] Jk = this.aSR.Jk();
        if (IT.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (IT.bottom + f2 > Jk[1]) {
            f2 = (Jk[1] - IT.bottom) * this.aST;
        }
        if (IT.bottom - IT.top > Jk[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.aTb = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        if (this.aSQ != null) {
            this.aSQ.R(1.0f / this.aOa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.IU() * 1.0f) / bitmap.getHeight());
        this.aSX.postScale(max, max);
        this.aSS = max * (1.0f / i);
        this.aOa = this.aSS;
        this.aST = this.aOa;
        this.aOb = 2.0f * this.aST;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.aSP.getWidth();
        if (realWidth > 1.0f) {
            this.aSS /= realWidth;
        }
        bVar.Q(1.0f / this.aST);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int aTh;
        int aTi;

        public a(Context context) {
            super(context);
            this.aTh = 0;
            this.aTi = 0;
        }

        public void fC(int i) {
            this.aTh = i;
        }

        public void fD(int i) {
            this.aTi = i;
        }

        public int Ji() {
            return this.aTh;
        }

        public int Jj() {
            return this.aTi;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.aTh = 0;
            this.aTi = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

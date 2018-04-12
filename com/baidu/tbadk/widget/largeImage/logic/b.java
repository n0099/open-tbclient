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
    private final View aSM;
    private ScaleGestureDetector aSN;
    private BitmapRegionDecoder aSO;
    private com.baidu.tbadk.widget.largeImage.a.b aSP;
    private com.baidu.tbadk.widget.largeImage.b.a aSQ;
    private float aSR;
    private float aSS;
    private int aST;
    private a aSU;
    private com.baidu.tbadk.widget.largeImage.b.c aSV;
    private com.baidu.tbadk.widget.largeImage.logic.a aSY;
    private ValueAnimator aSZ;
    private View.OnLongClickListener azP;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aOa = 2.0f;
    private float aNZ = 1.0f;
    private final Matrix aSW = new Matrix();
    Bitmap aSX = null;
    private boolean aTa = true;
    private boolean aTb = false;
    BdAsyncTask<String, String, String> aTc = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.aSP != null && b.this.aSO != null) {
                int[] Jm = b.this.aSQ.Jm();
                int i = 1;
                while (Math.max(Jm[0] / b.this.aSP.getRealWidth(), Jm[1] / b.this.aSP.IW()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, Jm[0], Jm[1]);
                try {
                    b.this.aSX = b.this.aSO.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.aSX = b.this.aSO.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.aSX = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Fa().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.aSX, false));
                b.this.a(b.this.aSX, b.this.aSP, pow);
                b.this.aSP.k(b.this.aSX);
                b.this.Jj();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.aSY != null) {
                b.this.aSY.Cv();
            }
            b.this.Jh();
            b.this.aSM.invalidate();
        }
    };

    public b(View view2) {
        this.aST = 1;
        this.aSM = view2;
        this.mContext = this.aSM.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0107b());
        this.aSN = new ScaleGestureDetector(this.mContext, new c());
        this.aSU = new a(this.mContext);
        this.aST = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.aST == 2 && Jd()) {
            switch (action) {
                case 0:
                    if (!this.aSU.isFinished()) {
                        this.aTb = true;
                    } else {
                        this.aTb = false;
                    }
                case 1:
                case 3:
                    HY();
                    break;
            }
            this.aSU.forceFinished(true);
            this.aSN.onTouchEvent(motionEvent);
            if (this.aSN.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Ja() {
        return Math.floor((double) (this.aNZ * 10000.0f)) == Math.floor((double) (this.aSS * 10000.0f));
    }

    public void HY() {
        if (this.aSS / this.aNZ < 1.0f) {
            a(this.aNZ, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean Jb() {
        if (this.aST == 1) {
            return false;
        }
        if (this.aSU.computeScrollOffset()) {
            int currX = this.aSU.getCurrX();
            this.aSU.fC(currX);
            int currY = this.aSU.getCurrY();
            this.aSU.fD(currY);
            moveTo(-((currX - this.aSU.Jk()) * 2.0f), -((currY - this.aSU.Jl()) * 2.0f));
            this.aSM.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.aSQ == null) {
            this.mOriginalBitmap = bitmap;
            this.aSQ = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.aSO = this.aSQ.z(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.aSO = this.aSQ.z(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.aST = 2;
            Jc();
        }
    }

    public void Jc() {
        if (this.aST == 2 && this.aSQ != null && this.aTc.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.aSP == null && this.aSM.getMeasuredWidth() > 0 && this.aSM.getMeasuredHeight() > 0 && this.aSQ.Jm()[0] > 0 && this.aSQ.Jm()[1] > 0) {
            this.aSP = new com.baidu.tbadk.widget.largeImage.a.b(this.aSM.getMeasuredWidth(), this.aSM.getMeasuredHeight(), this.aSQ.Jm());
            this.aTc.setPriority(3);
            this.aTc.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.azP = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !Jd()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.aSM.getWidth() - this.aSM.getPaddingLeft()) - this.aSM.getPaddingRight();
            int height2 = (this.aSM.getHeight() - this.aSM.getPaddingTop()) - this.aSM.getPaddingBottom();
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

    private boolean Jd() {
        return (this.aSP == null || this.aSP.IZ() == null || this.aSP.IZ().getBitmap() == null || this.aSP.IZ().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(Canvas canvas) {
        if (this.aST != 1 || this.mOriginalBitmap == null) {
            if (this.aSP != null) {
                this.aSP.IV();
                if (Jd()) {
                    canvas.drawBitmap(this.aSP.IZ().getBitmap(), this.aSW, null);
                }
                a(this.aSP, false);
                Jg();
                canvas.save();
                float IR = (1.0f * this.aSP.IR()) / this.aSP.IY();
                canvas.scale(IR, IR);
                List<com.baidu.tbadk.widget.largeImage.a.a> IX = this.aSP.IX();
                if (IX != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : IX) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.IN(), aVar.IO(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float Je() {
        return this.aNZ;
    }

    public float getMinScaleValue() {
        if (this.aNZ < 1.0f) {
            return this.aNZ;
        }
        return 1.0f;
    }

    public float Jf() {
        return 2.0f * this.aNZ;
    }

    public void release() {
        if (this.aSZ != null) {
            this.aSZ.cancel();
        }
        if (this.aTc != null) {
            this.aTc.cancel();
        }
        if (this.aSV != null) {
            this.aSV.onDestory();
        }
        if (this.aSP != null && this.aSP.IX() != null) {
            this.aSP.IX().clear();
        }
        if (this.aSX != null) {
            this.aSX.recycle();
            this.aSX = null;
        }
        if (this.aSO != null) {
            this.aSO.recycle();
        }
    }

    private void Jg() {
        List<com.baidu.tbadk.widget.largeImage.a.a> IX = this.aSP.IX();
        if (IX != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : IX) {
                a(aVar, this.aSP);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.aSY = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.IP().EH() == 0 && aVar.IP().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.IV());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int IR = aVar.IP().IR();
        aVar.j((i - rect.left) / IR, (i3 - rect.top) / IR, (i2 - rect.left) / IR, (i4 - rect.top) / IR);
        aVar.i((i - rect2.left) / IR, (i3 - rect2.top) / IR, (i2 - rect2.left) / IR, (i4 - rect2.top) / IR);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.IT(), bVar.IR(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.aSV == null) {
            this.aSV = new com.baidu.tbadk.widget.largeImage.b.c(this.aSP, this.aSO);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> IX = this.aSP.IX();
            IX.clear();
            i2 = i3;
            z2 = true;
            list = IX;
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
            this.aSV.Jo();
        }
    }

    public void Jh() {
        if (this.aST != 1) {
            a(this.aSP, true);
        }
    }

    private void r(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.aSV.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a s(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0106a c0106a = new a.C0106a(i, i2, i3);
        if (this.aSV.Jp() != null && (aVar = this.aSV.Jp().get(c0106a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.aSV.Jp().remove(c0106a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void Cv() {
        this.aSM.postInvalidate();
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
                b.this.aTb = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.aSS == b.this.aOa ? b.this.aNZ : b.this.aOa, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect IV = b.this.aSP.IV();
            Rect IS = b.this.aSP.IS();
            float f3 = IV.right - IS.right;
            float f4 = IV.left - IS.left;
            float f5 = IV.bottom - IS.bottom;
            float f6 = IV.top - IS.top;
            b.this.aSU.forceFinished(true);
            b.this.aSU.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.aSM.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.aTb = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.aTb || b.this.azP == null) {
                b.this.aTb = false;
            } else {
                b.this.azP.onLongClick(b.this.aSM);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.aTb || b.this.mClickListener == null) {
                b.this.aTb = false;
            } else {
                b.this.mClickListener.onClick(b.this.aSM);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.aSZ != null) {
            this.aSZ.cancel();
        }
        this.aSZ = ValueAnimator.ofFloat(this.aSS, f);
        this.aSZ.setDuration(i);
        this.aSZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.aSS, f2, f3);
                }
            }
        });
        this.aSZ.start();
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
        if (this.aSS * f < this.aSR) {
            f = this.aSR / this.aSS;
        }
        if (this.aSS * f > this.aOa) {
            f = this.aOa / this.aSS;
        }
        Rect IV = this.aSP.IV();
        float f4 = ((IV.left + IV.right) * 1.0f) / 2.0f;
        float f5 = ((IV.bottom + IV.top) * 1.0f) / 2.0f;
        if (this.aSP != null) {
            this.aSW.postScale(f, f, this.aSP.getRealWidth() / 2, this.aSP.IW() / 2);
            this.aSP.b(1.0f / f, f4, f5);
            this.aSS *= f;
            this.aSP.Q(1.0f / this.aSS);
            float[] Ji = Ji();
            this.aSW.postTranslate(-Ji[0], -Ji[1]);
            this.aSP.h((Ji[0] * 1.0f) / this.aSS, (Ji[1] * 1.0f) / this.aSS);
            Jh();
            this.aSM.invalidate();
        }
    }

    public boolean HX() {
        Rect IV;
        return (this.aSP == null || (IV = this.aSP.IV()) == null || IV.top > 10) ? false : true;
    }

    private float[] Ji() {
        Rect IV = this.aSP.IV();
        int[] Jm = this.aSQ.Jm();
        float[] fArr = {(Jm[0] / 2) - (((IV.left + IV.right) * 1.0f) / 2.0f)};
        if (IV.top < 0) {
            fArr[1] = 0 - IV.top;
        }
        if (IV.bottom > Jm[1]) {
            fArr[1] = Jm[1] - IV.bottom;
        }
        if (IV.bottom - IV.top > Jm[1]) {
            fArr[1] = (Jm[1] / 2) - (((IV.bottom + IV.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.aSS;
        fArr[1] = fArr[1] * this.aSS;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.aSP != null) {
            float[] i = i(f, f2);
            this.aSW.postTranslate(-i[0], -i[1]);
            this.aSP.h((i[0] * 1.0f) / this.aSS, (i[1] * 1.0f) / this.aSS);
            Jh();
            this.aSM.invalidate();
        }
    }

    private float[] i(float f, float f2) {
        float[] fArr = new float[2];
        Rect IV = this.aSP.IV();
        int[] Jm = this.aSQ.Jm();
        if (IV.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (IV.bottom + f2 > Jm[1]) {
            f2 = (Jm[1] - IV.bottom) * this.aSS;
        }
        if (IV.bottom - IV.top > Jm[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.aTa = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jj() {
        if (this.aSP != null) {
            this.aSP.R(1.0f / this.aNZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.IW() * 1.0f) / bitmap.getHeight());
        this.aSW.postScale(max, max);
        this.aSR = max * (1.0f / i);
        this.aNZ = this.aSR;
        this.aSS = this.aNZ;
        this.aOa = 2.0f * this.aSS;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.aSO.getWidth();
        if (realWidth > 1.0f) {
            this.aSR /= realWidth;
        }
        bVar.Q(1.0f / this.aSS);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int aTg;
        int aTh;

        public a(Context context) {
            super(context);
            this.aTg = 0;
            this.aTh = 0;
        }

        public void fC(int i) {
            this.aTg = i;
        }

        public void fD(int i) {
            this.aTh = i;
        }

        public int Jk() {
            return this.aTg;
        }

        public int Jl() {
            return this.aTh;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.aTg = 0;
            this.aTh = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

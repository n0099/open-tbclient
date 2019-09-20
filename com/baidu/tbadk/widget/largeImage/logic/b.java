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
    private BitmapRegionDecoder cJA;
    private com.baidu.tbadk.widget.largeImage.a.b cJB;
    private com.baidu.tbadk.widget.largeImage.b.a cJC;
    private float cJD;
    private float cJE;
    private Bitmap cJF;
    private int cJG;
    private a cJH;
    private com.baidu.tbadk.widget.largeImage.b.c cJI;
    private com.baidu.tbadk.widget.largeImage.logic.a cJL;
    private ValueAnimator cJM;
    private final View cJz;
    private View.OnLongClickListener cpT;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private ScaleGestureDetector mScaleGestureDetector;
    private float cED = 2.0f;
    private float cEC = 1.0f;
    private final Matrix cJJ = new Matrix();
    Bitmap cJK = null;
    private boolean cJN = true;
    private boolean cJO = false;
    BdAsyncTask<String, String, String> cJP = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.cJB != null && b.this.cJA != null) {
                int[] agv = b.this.cJC.agv();
                int i = 1;
                while (Math.max(agv[0] / b.this.cJB.getRealWidth(), agv[1] / b.this.cJB.ayi()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, agv[0], agv[1]);
                try {
                    b.this.cJK = b.this.cJA.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.cJK = b.this.cJA.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.cJK = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.atK().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.cJK, false));
                b.this.a(b.this.cJK, b.this.cJB, pow);
                b.this.cJB.r(b.this.cJK);
                b.this.ayv();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.cJL != null) {
                b.this.cJL.ara();
            }
            b.this.ayt();
            b.this.cJz.invalidate();
        }
    };

    public b(View view) {
        this.cJG = 1;
        this.cJz = view;
        this.mContext = this.cJz.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0273b());
        this.mScaleGestureDetector = new ScaleGestureDetector(this.mContext, new c());
        this.cJH = new a(this.mContext);
        this.cJG = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.cJG == 2 && ayp()) {
            switch (action) {
                case 0:
                    if (!this.cJH.isFinished()) {
                        this.cJO = true;
                    } else {
                        this.cJO = false;
                    }
                case 1:
                case 3:
                    axc();
                    break;
            }
            this.cJH.forceFinished(true);
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
            if (this.mScaleGestureDetector.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean aym() {
        return Math.floor((double) (this.cEC * 10000.0f)) == Math.floor((double) (this.cJE * 10000.0f));
    }

    public void axc() {
        if (this.cJE / this.cEC < 1.0f) {
            a(this.cEC, 0.0f, 0.0f, 400);
        }
    }

    public boolean ayn() {
        if (this.cJG == 1) {
            return false;
        }
        if (this.cJH.computeScrollOffset()) {
            int currX = this.cJH.getCurrX();
            int currY = this.cJH.getCurrY();
            float ayw = (currX - this.cJH.ayw()) * 2.0f;
            float ayx = (currY - this.cJH.ayx()) * 2.0f;
            int ah = l.ah(TbadkCoreApplication.getInst());
            if (ayx >= 0.0f && Math.abs(ayx) <= 20.0f && currX < ah) {
                v(0.0f, -20.0f);
                this.cJz.invalidate();
                return true;
            }
            this.cJH.lp(currX);
            this.cJH.lq(currY);
            v(-ayw, -ayx);
            this.cJz.invalidate();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f, float f2) {
        if (this.cJB != null) {
            float[] w = w(f, f2);
            float f3 = w[0];
            float f4 = w[1];
            this.cJJ.postTranslate(-f3, -f4);
            this.cJB.u((f3 * 1.0f) / this.cJE, (f4 * 1.0f) / this.cJE);
            ayt();
            this.cJz.invalidate();
        }
    }

    private float[] w(float f, float f2) {
        float[] fArr = new float[2];
        Rect ayh = this.cJB.ayh();
        int[] agv = this.cJC.agv();
        if (ayh.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (ayh.bottom + f2 > agv[1]) {
            f2 = (agv[1] - ayh.bottom) * this.cJE;
        }
        if (ayh.bottom - ayh.top > agv[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.cJN = f2 == 0.0f;
        return fArr;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.cJC == null) {
            this.cJF = bitmap;
            this.cJC = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.cJA = this.cJC.I(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.cJA = this.cJC.I(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.cJG = 2;
            ayo();
        }
    }

    public void ayo() {
        if (this.cJG == 2 && this.cJC != null && this.cJP.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.cJB == null && this.cJz.getMeasuredWidth() > 0 && this.cJz.getMeasuredHeight() > 0 && this.cJC.agv()[0] > 0 && this.cJC.agv()[1] > 0) {
            this.cJB = new com.baidu.tbadk.widget.largeImage.a.b(this.cJz.getMeasuredWidth(), this.cJz.getMeasuredHeight(), this.cJC.agv());
            this.cJP.setPriority(3);
            this.cJP.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cpT = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !ayp()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.cJz.getWidth() - this.cJz.getPaddingLeft()) - this.cJz.getPaddingRight();
            int height2 = (this.cJz.getHeight() - this.cJz.getPaddingTop()) - this.cJz.getPaddingBottom();
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

    private boolean ayp() {
        return (this.cJB == null || this.cJB.ayl() == null || this.cJB.ayl().getBitmap() == null || this.cJB.ayl().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(Canvas canvas) {
        if (this.cJG != 1 || this.cJF == null) {
            if (this.cJB != null) {
                this.cJB.ayh();
                if (ayp()) {
                    canvas.drawBitmap(this.cJB.ayl().getBitmap(), this.cJJ, null);
                }
                a(this.cJB, false);
                ays();
                canvas.save();
                float ayd = (1.0f * this.cJB.ayd()) / this.cJB.ayk();
                canvas.scale(ayd, ayd);
                List<com.baidu.tbadk.widget.largeImage.a.a> ayj = this.cJB.ayj();
                if (ayj != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : ayj) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.axZ(), aVar.aya(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float ayq() {
        return this.cEC;
    }

    public float getMinScaleValue() {
        if (this.cEC < 1.0f) {
            return this.cEC;
        }
        return 1.0f;
    }

    public float ayr() {
        return 2.0f * this.cEC;
    }

    public void release() {
        if (this.cJM != null) {
            this.cJM.cancel();
        }
        if (this.cJP != null) {
            this.cJP.cancel();
        }
        if (this.cJI != null) {
            this.cJI.onDestory();
        }
        if (this.cJB != null && this.cJB.ayj() != null) {
            this.cJB.ayj().clear();
        }
        if (this.cJK != null) {
            this.cJK.recycle();
            this.cJK = null;
        }
        if (this.cJA != null) {
            this.cJA.recycle();
        }
    }

    private void ays() {
        List<com.baidu.tbadk.widget.largeImage.a.a> ayj = this.cJB.ayj();
        if (ayj != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : ayj) {
                a(aVar, this.cJB);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.cJL = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.ayb().atq() == 0 && aVar.ayb().atr() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.ayh());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int ayd = aVar.ayb().ayd();
        aVar.r((i - rect.left) / ayd, (i3 - rect.top) / ayd, (i2 - rect.left) / ayd, (i4 - rect.top) / ayd);
        aVar.q((i - rect2.left) / ayd, (i3 - rect2.top) / ayd, (i2 - rect2.left) / ayd, (i4 - rect2.top) / ayd);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.ayf(), bVar.ayd(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.cJI == null) {
            this.cJI = new com.baidu.tbadk.widget.largeImage.b.c(this.cJB, this.cJA);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> ayj = this.cJB.ayj();
            ayj.clear();
            i2 = i3;
            z2 = true;
            list = ayj;
        }
        while (i2 < i5) {
            for (int i7 = i4; i7 < i6; i7++) {
                com.baidu.tbadk.widget.largeImage.a.a z3 = z(i2, i7, i);
                if (z3 == null) {
                    if (z) {
                        y(i2, i7, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(z3);
                }
            }
            i2++;
        }
        if (z2) {
            this.cJI.ayz();
        }
    }

    public void ayt() {
        if (this.cJG != 1) {
            a(this.cJB, true);
        }
    }

    private void y(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.cJI.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a z(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0272a c0272a = new a.C0272a(i, i2, i3);
        if (this.cJI.ayA() != null && (aVar = this.cJI.ayA().get(c0272a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.cJI.ayA().remove(c0272a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void ara() {
        this.cJz.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0273b extends GestureDetector.SimpleOnGestureListener {
        private C0273b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.v((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.cJO = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.cJE == b.this.cED ? b.this.cEC : b.this.cED, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect ayh = b.this.cJB.ayh();
            Rect aye = b.this.cJB.aye();
            float f3 = ayh.right - aye.right;
            float f4 = ayh.left - aye.left;
            float f5 = ayh.bottom - aye.bottom;
            float f6 = ayh.top - aye.top;
            b.this.cJH.forceFinished(true);
            b.this.cJH.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.cJz.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.cJO = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.cJO || b.this.cpT == null) {
                b.this.cJO = false;
            } else {
                b.this.cpT.onLongClick(b.this.cJz);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.cJO || b.this.mClickListener == null) {
                b.this.cJO = false;
            } else {
                b.this.mClickListener.onClick(b.this.cJz);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.cJM != null) {
            this.cJM.cancel();
        }
        this.cJM = ValueAnimator.ofFloat(this.cJE, f);
        this.cJM.setDuration(i);
        this.cJM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.cJE, f2, f3);
                }
            }
        });
        this.cJM.start();
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
        if (this.cJE * f < this.cJD) {
            f = this.cJD / this.cJE;
        }
        if (this.cJE * f > this.cED) {
            f = this.cED / this.cJE;
        }
        Rect ayh = this.cJB.ayh();
        float f4 = ((ayh.left + ayh.right) * 1.0f) / 2.0f;
        float f5 = ((ayh.bottom + ayh.top) * 1.0f) / 2.0f;
        if (this.cJB != null) {
            this.cJJ.postScale(f, f, this.cJB.getRealWidth() / 2, this.cJB.ayi() / 2);
            this.cJB.b(1.0f / f, f4, f5);
            this.cJE *= f;
            this.cJB.ar(1.0f / this.cJE);
            float[] ayu = ayu();
            this.cJJ.postTranslate(-ayu[0], -ayu[1]);
            this.cJB.u((ayu[0] * 1.0f) / this.cJE, (ayu[1] * 1.0f) / this.cJE);
            ayt();
            this.cJz.invalidate();
        }
    }

    public boolean axb() {
        Rect ayh;
        return (this.cJB == null || (ayh = this.cJB.ayh()) == null || ayh.top > 10) ? false : true;
    }

    private float[] ayu() {
        Rect ayh = this.cJB.ayh();
        int[] agv = this.cJC.agv();
        float[] fArr = {(agv[0] / 2) - (((ayh.left + ayh.right) * 1.0f) / 2.0f)};
        if (ayh.top < 0) {
            fArr[1] = 0 - ayh.top;
        }
        if (ayh.bottom > agv[1]) {
            fArr[1] = agv[1] - ayh.bottom;
        }
        if (ayh.bottom - ayh.top > agv[1]) {
            fArr[1] = (agv[1] / 2) - (((ayh.bottom + ayh.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.cJE;
        fArr[1] = fArr[1] * this.cJE;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayv() {
        if (this.cJB != null) {
            this.cJB.as(1.0f / this.cEC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.ayi() * 1.0f) / bitmap.getHeight());
        this.cJJ.postScale(max, max);
        this.cJD = max * (1.0f / i);
        this.cEC = this.cJD;
        this.cJE = this.cEC;
        this.cED = 2.0f * this.cJE;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.cJA.getWidth();
        if (realWidth > 1.0f) {
            this.cJD /= realWidth;
        }
        bVar.ar(1.0f / this.cJE);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int cJT;
        int cJU;

        public a(Context context) {
            super(context);
            this.cJT = 0;
            this.cJU = 0;
        }

        public void lp(int i) {
            this.cJT = i;
        }

        public void lq(int i) {
            this.cJU = i;
        }

        public int ayw() {
            return this.cJT;
        }

        public int ayx() {
            return this.cJU;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.cJT = 0;
            this.cJU = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

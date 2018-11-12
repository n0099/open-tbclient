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
    private View.OnLongClickListener aRU;
    private final View bkg;
    private ScaleGestureDetector bkh;
    private BitmapRegionDecoder bki;
    private com.baidu.tbadk.widget.largeImage.a.b bkj;
    private com.baidu.tbadk.widget.largeImage.b.a bkk;
    private float bkl;
    private float bkm;
    private Bitmap bkn;
    private int bko;
    private a bkp;
    private com.baidu.tbadk.widget.largeImage.b.c bkq;
    private com.baidu.tbadk.widget.largeImage.logic.a bkt;
    private ValueAnimator bku;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float bfD = 2.0f;
    private float bfC = 1.0f;
    private final Matrix bkr = new Matrix();
    Bitmap bks = null;
    private boolean bkv = true;
    private boolean bkw = false;
    BdAsyncTask<String, String, String> bkx = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.bkj != null && b.this.bki != null) {
                int[] Qv = b.this.bkk.Qv();
                int i = 1;
                while (Math.max(Qv[0] / b.this.bkj.getRealWidth(), Qv[1] / b.this.bkj.Qf()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, Qv[0], Qv[1]);
                try {
                    b.this.bks = b.this.bki.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bks = b.this.bki.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bks = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Mq().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.bks, false));
                b.this.a(b.this.bks, b.this.bkj, pow);
                b.this.bkj.k(b.this.bks);
                b.this.Qs();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bkt != null) {
                b.this.bkt.JN();
            }
            b.this.Qq();
            b.this.bkg.invalidate();
        }
    };

    public b(View view) {
        this.bko = 1;
        this.bkg = view;
        this.mContext = this.bkg.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0169b());
        this.bkh = new ScaleGestureDetector(this.mContext, new c());
        this.bkp = new a(this.mContext);
        this.bko = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bko == 2 && Qm()) {
            switch (action) {
                case 0:
                    if (!this.bkp.isFinished()) {
                        this.bkw = true;
                    } else {
                        this.bkw = false;
                    }
                case 1:
                case 3:
                    Pj();
                    break;
            }
            this.bkp.forceFinished(true);
            this.bkh.onTouchEvent(motionEvent);
            if (this.bkh.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Qj() {
        return Math.floor((double) (this.bfC * 10000.0f)) == Math.floor((double) (this.bkm * 10000.0f));
    }

    public void Pj() {
        if (this.bkm / this.bfC < 1.0f) {
            a(this.bfC, 0.0f, 0.0f, 400);
        }
    }

    public boolean Qk() {
        if (this.bko == 1) {
            return false;
        }
        if (this.bkp.computeScrollOffset()) {
            int currX = this.bkp.getCurrX();
            this.bkp.gn(currX);
            int currY = this.bkp.getCurrY();
            this.bkp.go(currY);
            moveTo(-((currX - this.bkp.Qt()) * 2.0f), -((currY - this.bkp.Qu()) * 2.0f));
            this.bkg.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bkk == null) {
            this.bkn = bitmap;
            this.bkk = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.bki = this.bkk.G(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bki = this.bkk.G(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bko = 2;
            Ql();
        }
    }

    public void Ql() {
        if (this.bko == 2 && this.bkk != null && this.bkx.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bkj == null && this.bkg.getMeasuredWidth() > 0 && this.bkg.getMeasuredHeight() > 0 && this.bkk.Qv()[0] > 0 && this.bkk.Qv()[1] > 0) {
            this.bkj = new com.baidu.tbadk.widget.largeImage.a.b(this.bkg.getMeasuredWidth(), this.bkg.getMeasuredHeight(), this.bkk.Qv());
            this.bkx.setPriority(3);
            this.bkx.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aRU = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !Qm()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bkg.getWidth() - this.bkg.getPaddingLeft()) - this.bkg.getPaddingRight();
            int height2 = (this.bkg.getHeight() - this.bkg.getPaddingTop()) - this.bkg.getPaddingBottom();
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

    private boolean Qm() {
        return (this.bkj == null || this.bkj.Qi() == null || this.bkj.Qi().getBitmap() == null || this.bkj.Qi().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(Canvas canvas) {
        if (this.bko != 1 || this.bkn == null) {
            if (this.bkj != null) {
                this.bkj.Qe();
                if (Qm()) {
                    canvas.drawBitmap(this.bkj.Qi().getBitmap(), this.bkr, null);
                }
                a(this.bkj, false);
                Qp();
                canvas.save();
                float Qa = (1.0f * this.bkj.Qa()) / this.bkj.Qh();
                canvas.scale(Qa, Qa);
                List<com.baidu.tbadk.widget.largeImage.a.a> Qg = this.bkj.Qg();
                if (Qg != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : Qg) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.PW(), aVar.PX(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float Qn() {
        return this.bfC;
    }

    public float getMinScaleValue() {
        if (this.bfC < 1.0f) {
            return this.bfC;
        }
        return 1.0f;
    }

    public float Qo() {
        return 2.0f * this.bfC;
    }

    public void release() {
        if (this.bku != null) {
            this.bku.cancel();
        }
        if (this.bkx != null) {
            this.bkx.cancel();
        }
        if (this.bkq != null) {
            this.bkq.onDestory();
        }
        if (this.bkj != null && this.bkj.Qg() != null) {
            this.bkj.Qg().clear();
        }
        if (this.bks != null) {
            this.bks.recycle();
            this.bks = null;
        }
        if (this.bki != null) {
            this.bki.recycle();
        }
    }

    private void Qp() {
        List<com.baidu.tbadk.widget.largeImage.a.a> Qg = this.bkj.Qg();
        if (Qg != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : Qg) {
                a(aVar, this.bkj);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.bkt = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.PY().LW() == 0 && aVar.PY().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.Qe());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int Qa = aVar.PY().Qa();
        aVar.j((i - rect.left) / Qa, (i3 - rect.top) / Qa, (i2 - rect.left) / Qa, (i4 - rect.top) / Qa);
        aVar.i((i - rect2.left) / Qa, (i3 - rect2.top) / Qa, (i2 - rect2.left) / Qa, (i4 - rect2.top) / Qa);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.Qc(), bVar.Qa(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.bkq == null) {
            this.bkq = new com.baidu.tbadk.widget.largeImage.b.c(this.bkj, this.bki);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> Qg = this.bkj.Qg();
            Qg.clear();
            i2 = i3;
            z2 = true;
            list = Qg;
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
            this.bkq.Qx();
        }
    }

    public void Qq() {
        if (this.bko != 1) {
            a(this.bkj, true);
        }
    }

    private void t(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bkq.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a u(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0168a c0168a = new a.C0168a(i, i2, i3);
        if (this.bkq.Qy() != null && (aVar = this.bkq.Qy().get(c0168a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bkq.Qy().remove(c0168a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void JN() {
        this.bkg.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0169b extends GestureDetector.SimpleOnGestureListener {
        private C0169b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bkw = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bkm == b.this.bfD ? b.this.bfC : b.this.bfD, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Qe = b.this.bkj.Qe();
            Rect Qb = b.this.bkj.Qb();
            float f3 = Qe.right - Qb.right;
            float f4 = Qe.left - Qb.left;
            float f5 = Qe.bottom - Qb.bottom;
            float f6 = Qe.top - Qb.top;
            b.this.bkp.forceFinished(true);
            b.this.bkp.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bkg.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bkw = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bkw || b.this.aRU == null) {
                b.this.bkw = false;
            } else {
                b.this.aRU.onLongClick(b.this.bkg);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bkw || b.this.mClickListener == null) {
                b.this.bkw = false;
            } else {
                b.this.mClickListener.onClick(b.this.bkg);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bku != null) {
            this.bku.cancel();
        }
        this.bku = ValueAnimator.ofFloat(this.bkm, f);
        this.bku.setDuration(i);
        this.bku.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bkm, f2, f3);
                }
            }
        });
        this.bku.start();
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
        if (this.bkm * f < this.bkl) {
            f = this.bkl / this.bkm;
        }
        if (this.bkm * f > this.bfD) {
            f = this.bfD / this.bkm;
        }
        Rect Qe = this.bkj.Qe();
        float f4 = ((Qe.left + Qe.right) * 1.0f) / 2.0f;
        float f5 = ((Qe.bottom + Qe.top) * 1.0f) / 2.0f;
        if (this.bkj != null) {
            this.bkr.postScale(f, f, this.bkj.getRealWidth() / 2, this.bkj.Qf() / 2);
            this.bkj.b(1.0f / f, f4, f5);
            this.bkm *= f;
            this.bkj.ac(1.0f / this.bkm);
            float[] Qr = Qr();
            this.bkr.postTranslate(-Qr[0], -Qr[1]);
            this.bkj.r((Qr[0] * 1.0f) / this.bkm, (Qr[1] * 1.0f) / this.bkm);
            Qq();
            this.bkg.invalidate();
        }
    }

    public boolean Pi() {
        Rect Qe;
        return (this.bkj == null || (Qe = this.bkj.Qe()) == null || Qe.top > 10) ? false : true;
    }

    private float[] Qr() {
        Rect Qe = this.bkj.Qe();
        int[] Qv = this.bkk.Qv();
        float[] fArr = {(Qv[0] / 2) - (((Qe.left + Qe.right) * 1.0f) / 2.0f)};
        if (Qe.top < 0) {
            fArr[1] = 0 - Qe.top;
        }
        if (Qe.bottom > Qv[1]) {
            fArr[1] = Qv[1] - Qe.bottom;
        }
        if (Qe.bottom - Qe.top > Qv[1]) {
            fArr[1] = (Qv[1] / 2) - (((Qe.bottom + Qe.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bkm;
        fArr[1] = fArr[1] * this.bkm;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bkj != null) {
            float[] s = s(f, f2);
            this.bkr.postTranslate(-s[0], -s[1]);
            this.bkj.r((s[0] * 1.0f) / this.bkm, (s[1] * 1.0f) / this.bkm);
            Qq();
            this.bkg.invalidate();
        }
    }

    private float[] s(float f, float f2) {
        float[] fArr = new float[2];
        Rect Qe = this.bkj.Qe();
        int[] Qv = this.bkk.Qv();
        if (Qe.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Qe.bottom + f2 > Qv[1]) {
            f2 = (Qv[1] - Qe.bottom) * this.bkm;
        }
        if (Qe.bottom - Qe.top > Qv[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bkv = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qs() {
        if (this.bkj != null) {
            this.bkj.ad(1.0f / this.bfC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.Qf() * 1.0f) / bitmap.getHeight());
        this.bkr.postScale(max, max);
        this.bkl = max * (1.0f / i);
        this.bfC = this.bkl;
        this.bkm = this.bfC;
        this.bfD = 2.0f * this.bkm;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bki.getWidth();
        if (realWidth > 1.0f) {
            this.bkl /= realWidth;
        }
        bVar.ac(1.0f / this.bkm);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bkB;
        int bkC;

        public a(Context context) {
            super(context);
            this.bkB = 0;
            this.bkC = 0;
        }

        public void gn(int i) {
            this.bkB = i;
        }

        public void go(int i) {
            this.bkC = i;
        }

        public int Qt() {
            return this.bkB;
        }

        public int Qu() {
            return this.bkC;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bkB = 0;
            this.bkC = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

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
    private View.OnLongClickListener aMC;
    private final View bff;
    private ScaleGestureDetector bfg;
    private BitmapRegionDecoder bfh;
    private com.baidu.tbadk.widget.largeImage.a.b bfi;
    private com.baidu.tbadk.widget.largeImage.b.a bfj;
    private float bfk;
    private float bfl;
    private Bitmap bfm;
    private int bfn;
    private a bfo;
    private com.baidu.tbadk.widget.largeImage.b.c bfp;
    private com.baidu.tbadk.widget.largeImage.logic.a bfs;
    private ValueAnimator bft;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float bao = 2.0f;
    private float ban = 1.0f;
    private final Matrix bfq = new Matrix();
    Bitmap bfr = null;
    private boolean bfu = true;
    private boolean bfv = false;
    BdAsyncTask<String, String, String> bfw = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.bfi != null && b.this.bfh != null) {
                int[] Oq = b.this.bfj.Oq();
                int i = 1;
                while (Math.max(Oq[0] / b.this.bfi.getRealWidth(), Oq[1] / b.this.bfi.Oa()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, Oq[0], Oq[1]);
                try {
                    b.this.bfr = b.this.bfh.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bfr = b.this.bfh.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bfr = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.Kg().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.bfr, false));
                b.this.a(b.this.bfr, b.this.bfi, pow);
                b.this.bfi.k(b.this.bfr);
                b.this.On();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bfs != null) {
                b.this.bfs.HA();
            }
            b.this.Ol();
            b.this.bff.invalidate();
        }
    };

    public b(View view) {
        this.bfn = 1;
        this.bff = view;
        this.mContext = this.bff.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0121b());
        this.bfg = new ScaleGestureDetector(this.mContext, new c());
        this.bfo = new a(this.mContext);
        this.bfn = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bfn == 2 && Oh()) {
            switch (action) {
                case 0:
                    if (!this.bfo.isFinished()) {
                        this.bfv = true;
                    } else {
                        this.bfv = false;
                    }
                case 1:
                case 3:
                    Nc();
                    break;
            }
            this.bfo.forceFinished(true);
            this.bfg.onTouchEvent(motionEvent);
            if (this.bfg.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Oe() {
        return Math.floor((double) (this.ban * 10000.0f)) == Math.floor((double) (this.bfl * 10000.0f));
    }

    public void Nc() {
        if (this.bfl / this.ban < 1.0f) {
            a(this.ban, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean Of() {
        if (this.bfn == 1) {
            return false;
        }
        if (this.bfo.computeScrollOffset()) {
            int currX = this.bfo.getCurrX();
            this.bfo.fQ(currX);
            int currY = this.bfo.getCurrY();
            this.bfo.fR(currY);
            moveTo(-((currX - this.bfo.Oo()) * 2.0f), -((currY - this.bfo.Op()) * 2.0f));
            this.bff.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bfj == null) {
            this.bfm = bitmap;
            this.bfj = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.bfh = this.bfj.H(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bfh = this.bfj.H(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bfn = 2;
            Og();
        }
    }

    public void Og() {
        if (this.bfn == 2 && this.bfj != null && this.bfw.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bfi == null && this.bff.getMeasuredWidth() > 0 && this.bff.getMeasuredHeight() > 0 && this.bfj.Oq()[0] > 0 && this.bfj.Oq()[1] > 0) {
            this.bfi = new com.baidu.tbadk.widget.largeImage.a.b(this.bff.getMeasuredWidth(), this.bff.getMeasuredHeight(), this.bfj.Oq());
            this.bfw.setPriority(3);
            this.bfw.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aMC = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !Oh()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bff.getWidth() - this.bff.getPaddingLeft()) - this.bff.getPaddingRight();
            int height2 = (this.bff.getHeight() - this.bff.getPaddingTop()) - this.bff.getPaddingBottom();
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

    private boolean Oh() {
        return (this.bfi == null || this.bfi.Od() == null || this.bfi.Od().getBitmap() == null || this.bfi.Od().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(Canvas canvas) {
        if (this.bfn != 1 || this.bfm == null) {
            if (this.bfi != null) {
                this.bfi.NZ();
                if (Oh()) {
                    canvas.drawBitmap(this.bfi.Od().getBitmap(), this.bfq, null);
                }
                a(this.bfi, false);
                Ok();
                canvas.save();
                float NV = (1.0f * this.bfi.NV()) / this.bfi.Oc();
                canvas.scale(NV, NV);
                List<com.baidu.tbadk.widget.largeImage.a.a> Ob = this.bfi.Ob();
                if (Ob != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : Ob) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.NR(), aVar.NS(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float Oi() {
        return this.ban;
    }

    public float getMinScaleValue() {
        if (this.ban < 1.0f) {
            return this.ban;
        }
        return 1.0f;
    }

    public float Oj() {
        return 2.0f * this.ban;
    }

    public void release() {
        if (this.bft != null) {
            this.bft.cancel();
        }
        if (this.bfw != null) {
            this.bfw.cancel();
        }
        if (this.bfp != null) {
            this.bfp.onDestory();
        }
        if (this.bfi != null && this.bfi.Ob() != null) {
            this.bfi.Ob().clear();
        }
        if (this.bfr != null) {
            this.bfr.recycle();
            this.bfr = null;
        }
        if (this.bfh != null) {
            this.bfh.recycle();
        }
    }

    private void Ok() {
        List<com.baidu.tbadk.widget.largeImage.a.a> Ob = this.bfi.Ob();
        if (Ob != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : Ob) {
                a(aVar, this.bfi);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.bfs = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.NT().JM() == 0 && aVar.NT().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.NZ());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int NV = aVar.NT().NV();
        aVar.j((i - rect.left) / NV, (i3 - rect.top) / NV, (i2 - rect.left) / NV, (i4 - rect.top) / NV);
        aVar.i((i - rect2.left) / NV, (i3 - rect2.top) / NV, (i2 - rect2.left) / NV, (i4 - rect2.top) / NV);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.NX(), bVar.NV(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.bfp == null) {
            this.bfp = new com.baidu.tbadk.widget.largeImage.b.c(this.bfi, this.bfh);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> Ob = this.bfi.Ob();
            Ob.clear();
            i2 = i3;
            z2 = true;
            list = Ob;
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
            this.bfp.Os();
        }
    }

    public void Ol() {
        if (this.bfn != 1) {
            a(this.bfi, true);
        }
    }

    private void t(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bfp.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a u(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0120a c0120a = new a.C0120a(i, i2, i3);
        if (this.bfp.Ot() != null && (aVar = this.bfp.Ot().get(c0120a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bfp.Ot().remove(c0120a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void HA() {
        this.bff.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0121b extends GestureDetector.SimpleOnGestureListener {
        private C0121b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bfv = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bfl == b.this.bao ? b.this.ban : b.this.bao, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect NZ = b.this.bfi.NZ();
            Rect NW = b.this.bfi.NW();
            float f3 = NZ.right - NW.right;
            float f4 = NZ.left - NW.left;
            float f5 = NZ.bottom - NW.bottom;
            float f6 = NZ.top - NW.top;
            b.this.bfo.forceFinished(true);
            b.this.bfo.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bff.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bfv = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bfv || b.this.aMC == null) {
                b.this.bfv = false;
            } else {
                b.this.aMC.onLongClick(b.this.bff);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bfv || b.this.mClickListener == null) {
                b.this.bfv = false;
            } else {
                b.this.mClickListener.onClick(b.this.bff);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bft != null) {
            this.bft.cancel();
        }
        this.bft = ValueAnimator.ofFloat(this.bfl, f);
        this.bft.setDuration(i);
        this.bft.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bfl, f2, f3);
                }
            }
        });
        this.bft.start();
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
        if (this.bfl * f < this.bfk) {
            f = this.bfk / this.bfl;
        }
        if (this.bfl * f > this.bao) {
            f = this.bao / this.bfl;
        }
        Rect NZ = this.bfi.NZ();
        float f4 = ((NZ.left + NZ.right) * 1.0f) / 2.0f;
        float f5 = ((NZ.bottom + NZ.top) * 1.0f) / 2.0f;
        if (this.bfi != null) {
            this.bfq.postScale(f, f, this.bfi.getRealWidth() / 2, this.bfi.Oa() / 2);
            this.bfi.b(1.0f / f, f4, f5);
            this.bfl *= f;
            this.bfi.ab(1.0f / this.bfl);
            float[] Om = Om();
            this.bfq.postTranslate(-Om[0], -Om[1]);
            this.bfi.o((Om[0] * 1.0f) / this.bfl, (Om[1] * 1.0f) / this.bfl);
            Ol();
            this.bff.invalidate();
        }
    }

    public boolean Nb() {
        Rect NZ;
        return (this.bfi == null || (NZ = this.bfi.NZ()) == null || NZ.top > 10) ? false : true;
    }

    private float[] Om() {
        Rect NZ = this.bfi.NZ();
        int[] Oq = this.bfj.Oq();
        float[] fArr = {(Oq[0] / 2) - (((NZ.left + NZ.right) * 1.0f) / 2.0f)};
        if (NZ.top < 0) {
            fArr[1] = 0 - NZ.top;
        }
        if (NZ.bottom > Oq[1]) {
            fArr[1] = Oq[1] - NZ.bottom;
        }
        if (NZ.bottom - NZ.top > Oq[1]) {
            fArr[1] = (Oq[1] / 2) - (((NZ.bottom + NZ.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bfl;
        fArr[1] = fArr[1] * this.bfl;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bfi != null) {
            float[] p = p(f, f2);
            this.bfq.postTranslate(-p[0], -p[1]);
            this.bfi.o((p[0] * 1.0f) / this.bfl, (p[1] * 1.0f) / this.bfl);
            Ol();
            this.bff.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect NZ = this.bfi.NZ();
        int[] Oq = this.bfj.Oq();
        if (NZ.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (NZ.bottom + f2 > Oq[1]) {
            f2 = (Oq[1] - NZ.bottom) * this.bfl;
        }
        if (NZ.bottom - NZ.top > Oq[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bfu = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void On() {
        if (this.bfi != null) {
            this.bfi.ac(1.0f / this.ban);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.Oa() * 1.0f) / bitmap.getHeight());
        this.bfq.postScale(max, max);
        this.bfk = max * (1.0f / i);
        this.ban = this.bfk;
        this.bfl = this.ban;
        this.bao = 2.0f * this.bfl;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bfh.getWidth();
        if (realWidth > 1.0f) {
            this.bfk /= realWidth;
        }
        bVar.ab(1.0f / this.bfl);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bfA;
        int bfB;

        public a(Context context) {
            super(context);
            this.bfA = 0;
            this.bfB = 0;
        }

        public void fQ(int i) {
            this.bfA = i;
        }

        public void fR(int i) {
            this.bfB = i;
        }

        public int Oo() {
            return this.bfA;
        }

        public int Op() {
            return this.bfB;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bfA = 0;
            this.bfB = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

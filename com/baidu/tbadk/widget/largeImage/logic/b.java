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
    private View.OnLongClickListener aJi;
    private final View bbD;
    private ScaleGestureDetector bbE;
    private BitmapRegionDecoder bbF;
    private com.baidu.tbadk.widget.largeImage.a.b bbG;
    private com.baidu.tbadk.widget.largeImage.b.a bbH;
    private float bbI;
    private float bbJ;
    private int bbK;
    private a bbL;
    private com.baidu.tbadk.widget.largeImage.b.c bbM;
    private com.baidu.tbadk.widget.largeImage.logic.a bbP;
    private ValueAnimator bbQ;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aWT = 2.0f;
    private float aWS = 1.0f;
    private final Matrix bbN = new Matrix();
    Bitmap bbO = null;
    private boolean bbR = true;
    private boolean bbS = false;
    BdAsyncTask<String, String, String> bbT = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.bbG != null && b.this.bbF != null) {
                int[] MY = b.this.bbH.MY();
                int i = 1;
                while (Math.max(MY[0] / b.this.bbG.getRealWidth(), MY[1] / b.this.bbG.MI()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, MY[0], MY[1]);
                try {
                    b.this.bbO = b.this.bbF.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bbO = b.this.bbF.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bbO = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.IV().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.bbO, false));
                b.this.a(b.this.bbO, b.this.bbG, pow);
                b.this.bbG.j(b.this.bbO);
                b.this.MV();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bbP != null) {
                b.this.bbP.Go();
            }
            b.this.MT();
            b.this.bbD.invalidate();
        }
    };

    public b(View view) {
        this.bbK = 1;
        this.bbD = view;
        this.mContext = this.bbD.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0124b());
        this.bbE = new ScaleGestureDetector(this.mContext, new c());
        this.bbL = new a(this.mContext);
        this.bbK = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bbK == 2 && MP()) {
            switch (action) {
                case 0:
                    if (!this.bbL.isFinished()) {
                        this.bbS = true;
                    } else {
                        this.bbS = false;
                    }
                case 1:
                case 3:
                    LK();
                    break;
            }
            this.bbL.forceFinished(true);
            this.bbE.onTouchEvent(motionEvent);
            if (this.bbE.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean MM() {
        return Math.floor((double) (this.aWS * 10000.0f)) == Math.floor((double) (this.bbJ * 10000.0f));
    }

    public void LK() {
        if (this.bbJ / this.aWS < 1.0f) {
            a(this.aWS, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean MN() {
        if (this.bbK == 1) {
            return false;
        }
        if (this.bbL.computeScrollOffset()) {
            int currX = this.bbL.getCurrX();
            this.bbL.fE(currX);
            int currY = this.bbL.getCurrY();
            this.bbL.fF(currY);
            moveTo(-((currX - this.bbL.MW()) * 2.0f), -((currY - this.bbL.MX()) * 2.0f));
            this.bbD.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bbH == null) {
            this.mOriginalBitmap = bitmap;
            this.bbH = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.bbF = this.bbH.B(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bbF = this.bbH.B(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bbK = 2;
            MO();
        }
    }

    public void MO() {
        if (this.bbK == 2 && this.bbH != null && this.bbT.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bbG == null && this.bbD.getMeasuredWidth() > 0 && this.bbD.getMeasuredHeight() > 0 && this.bbH.MY()[0] > 0 && this.bbH.MY()[1] > 0) {
            this.bbG = new com.baidu.tbadk.widget.largeImage.a.b(this.bbD.getMeasuredWidth(), this.bbD.getMeasuredHeight(), this.bbH.MY());
            this.bbT.setPriority(3);
            this.bbT.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aJi = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !MP()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bbD.getWidth() - this.bbD.getPaddingLeft()) - this.bbD.getPaddingRight();
            int height2 = (this.bbD.getHeight() - this.bbD.getPaddingTop()) - this.bbD.getPaddingBottom();
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
        return l(canvas);
    }

    private boolean MP() {
        return (this.bbG == null || this.bbG.ML() == null || this.bbG.ML().getBitmap() == null || this.bbG.ML().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l(Canvas canvas) {
        if (this.bbK != 1 || this.mOriginalBitmap == null) {
            if (this.bbG != null) {
                this.bbG.MH();
                if (MP()) {
                    canvas.drawBitmap(this.bbG.ML().getBitmap(), this.bbN, null);
                }
                a(this.bbG, false);
                MS();
                canvas.save();
                float MD = (1.0f * this.bbG.MD()) / this.bbG.MK();
                canvas.scale(MD, MD);
                List<com.baidu.tbadk.widget.largeImage.a.a> MJ = this.bbG.MJ();
                if (MJ != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : MJ) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.Mz(), aVar.MA(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float MQ() {
        return this.aWS;
    }

    public float getMinScaleValue() {
        if (this.aWS < 1.0f) {
            return this.aWS;
        }
        return 1.0f;
    }

    public float MR() {
        return 2.0f * this.aWS;
    }

    public void release() {
        if (this.bbQ != null) {
            this.bbQ.cancel();
        }
        if (this.bbT != null) {
            this.bbT.cancel();
        }
        if (this.bbM != null) {
            this.bbM.onDestory();
        }
        if (this.bbG != null && this.bbG.MJ() != null) {
            this.bbG.MJ().clear();
        }
        if (this.bbO != null) {
            this.bbO.recycle();
            this.bbO = null;
        }
        if (this.bbF != null) {
            this.bbF.recycle();
        }
    }

    private void MS() {
        List<com.baidu.tbadk.widget.largeImage.a.a> MJ = this.bbG.MJ();
        if (MJ != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : MJ) {
                a(aVar, this.bbG);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.bbP = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.MB().IB() == 0 && aVar.MB().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.MH());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int MD = aVar.MB().MD();
        aVar.j((i - rect.left) / MD, (i3 - rect.top) / MD, (i2 - rect.left) / MD, (i4 - rect.top) / MD);
        aVar.i((i - rect2.left) / MD, (i3 - rect2.top) / MD, (i2 - rect2.left) / MD, (i4 - rect2.top) / MD);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.MF(), bVar.MD(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.bbM == null) {
            this.bbM = new com.baidu.tbadk.widget.largeImage.b.c(this.bbG, this.bbF);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> MJ = this.bbG.MJ();
            MJ.clear();
            i2 = i3;
            z2 = true;
            list = MJ;
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
            this.bbM.Na();
        }
    }

    public void MT() {
        if (this.bbK != 1) {
            a(this.bbG, true);
        }
    }

    private void r(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bbM.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a s(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0123a c0123a = new a.C0123a(i, i2, i3);
        if (this.bbM.Nb() != null && (aVar = this.bbM.Nb().get(c0123a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bbM.Nb().remove(c0123a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void Go() {
        this.bbD.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0124b extends GestureDetector.SimpleOnGestureListener {
        private C0124b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bbS = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bbJ == b.this.aWT ? b.this.aWS : b.this.aWT, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect MH = b.this.bbG.MH();
            Rect ME = b.this.bbG.ME();
            float f3 = MH.right - ME.right;
            float f4 = MH.left - ME.left;
            float f5 = MH.bottom - ME.bottom;
            float f6 = MH.top - ME.top;
            b.this.bbL.forceFinished(true);
            b.this.bbL.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bbD.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bbS = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bbS || b.this.aJi == null) {
                b.this.bbS = false;
            } else {
                b.this.aJi.onLongClick(b.this.bbD);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bbS || b.this.mClickListener == null) {
                b.this.bbS = false;
            } else {
                b.this.mClickListener.onClick(b.this.bbD);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bbQ != null) {
            this.bbQ.cancel();
        }
        this.bbQ = ValueAnimator.ofFloat(this.bbJ, f);
        this.bbQ.setDuration(i);
        this.bbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bbJ, f2, f3);
                }
            }
        });
        this.bbQ.start();
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
        if (this.bbJ * f < this.bbI) {
            f = this.bbI / this.bbJ;
        }
        if (this.bbJ * f > this.aWT) {
            f = this.aWT / this.bbJ;
        }
        Rect MH = this.bbG.MH();
        float f4 = ((MH.left + MH.right) * 1.0f) / 2.0f;
        float f5 = ((MH.bottom + MH.top) * 1.0f) / 2.0f;
        if (this.bbG != null) {
            this.bbN.postScale(f, f, this.bbG.getRealWidth() / 2, this.bbG.MI() / 2);
            this.bbG.b(1.0f / f, f4, f5);
            this.bbJ *= f;
            this.bbG.aa(1.0f / this.bbJ);
            float[] MU = MU();
            this.bbN.postTranslate(-MU[0], -MU[1]);
            this.bbG.o((MU[0] * 1.0f) / this.bbJ, (MU[1] * 1.0f) / this.bbJ);
            MT();
            this.bbD.invalidate();
        }
    }

    public boolean LJ() {
        Rect MH;
        return (this.bbG == null || (MH = this.bbG.MH()) == null || MH.top > 10) ? false : true;
    }

    private float[] MU() {
        Rect MH = this.bbG.MH();
        int[] MY = this.bbH.MY();
        float[] fArr = {(MY[0] / 2) - (((MH.left + MH.right) * 1.0f) / 2.0f)};
        if (MH.top < 0) {
            fArr[1] = 0 - MH.top;
        }
        if (MH.bottom > MY[1]) {
            fArr[1] = MY[1] - MH.bottom;
        }
        if (MH.bottom - MH.top > MY[1]) {
            fArr[1] = (MY[1] / 2) - (((MH.bottom + MH.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.bbJ;
        fArr[1] = fArr[1] * this.bbJ;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bbG != null) {
            float[] p = p(f, f2);
            this.bbN.postTranslate(-p[0], -p[1]);
            this.bbG.o((p[0] * 1.0f) / this.bbJ, (p[1] * 1.0f) / this.bbJ);
            MT();
            this.bbD.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect MH = this.bbG.MH();
        int[] MY = this.bbH.MY();
        if (MH.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (MH.bottom + f2 > MY[1]) {
            f2 = (MY[1] - MH.bottom) * this.bbJ;
        }
        if (MH.bottom - MH.top > MY[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bbR = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MV() {
        if (this.bbG != null) {
            this.bbG.ab(1.0f / this.aWS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.MI() * 1.0f) / bitmap.getHeight());
        this.bbN.postScale(max, max);
        this.bbI = max * (1.0f / i);
        this.aWS = this.bbI;
        this.bbJ = this.aWS;
        this.aWT = 2.0f * this.bbJ;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bbF.getWidth();
        if (realWidth > 1.0f) {
            this.bbI /= realWidth;
        }
        bVar.aa(1.0f / this.bbJ);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bbX;
        int bbY;

        public a(Context context) {
            super(context);
            this.bbX = 0;
            this.bbY = 0;
        }

        public void fE(int i) {
            this.bbX = i;
        }

        public void fF(int i) {
            this.bbY = i;
        }

        public int MW() {
            return this.bbX;
        }

        public int MX() {
            return this.bbY;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bbX = 0;
            this.bbY = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

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
    private View.OnLongClickListener aJm;
    private final View bbL;
    private ScaleGestureDetector bbM;
    private BitmapRegionDecoder bbN;
    private com.baidu.tbadk.widget.largeImage.a.b bbO;
    private com.baidu.tbadk.widget.largeImage.b.a bbP;
    private float bbQ;
    private float bbR;
    private Bitmap bbS;
    private int bbT;
    private a bbU;
    private com.baidu.tbadk.widget.largeImage.b.c bbV;
    private com.baidu.tbadk.widget.largeImage.logic.a bbY;
    private ValueAnimator bbZ;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private float aWW = 2.0f;
    private float aWV = 1.0f;
    private final Matrix bbW = new Matrix();
    Bitmap bbX = null;
    private boolean bca = true;
    private boolean bcb = false;
    BdAsyncTask<String, String, String> bcc = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.bbO != null && b.this.bbN != null) {
                int[] MY = b.this.bbP.MY();
                int i = 1;
                while (Math.max(MY[0] / b.this.bbO.getRealWidth(), MY[1] / b.this.bbO.MI()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, MY[0], MY[1]);
                try {
                    b.this.bbX = b.this.bbN.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.bbX = b.this.bbN.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.bbX = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.IQ().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.bbX, false));
                b.this.a(b.this.bbX, b.this.bbO, pow);
                b.this.bbO.j(b.this.bbX);
                b.this.MV();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.bbY != null) {
                b.this.bbY.Gk();
            }
            b.this.MT();
            b.this.bbL.invalidate();
        }
    };

    public b(View view) {
        this.bbT = 1;
        this.bbL = view;
        this.mContext = this.bbL.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0121b());
        this.bbM = new ScaleGestureDetector(this.mContext, new c());
        this.bbU = new a(this.mContext);
        this.bbT = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.bbT == 2 && MP()) {
            switch (action) {
                case 0:
                    if (!this.bbU.isFinished()) {
                        this.bcb = true;
                    } else {
                        this.bcb = false;
                    }
                case 1:
                case 3:
                    LK();
                    break;
            }
            this.bbU.forceFinished(true);
            this.bbM.onTouchEvent(motionEvent);
            if (this.bbM.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean MM() {
        return Math.floor((double) (this.aWV * 10000.0f)) == Math.floor((double) (this.bbR * 10000.0f));
    }

    public void LK() {
        if (this.bbR / this.aWV < 1.0f) {
            a(this.aWV, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean MN() {
        if (this.bbT == 1) {
            return false;
        }
        if (this.bbU.computeScrollOffset()) {
            int currX = this.bbU.getCurrX();
            this.bbU.fE(currX);
            int currY = this.bbU.getCurrY();
            this.bbU.fF(currY);
            moveTo(-((currX - this.bbU.MW()) * 2.0f), -((currY - this.bbU.MX()) * 2.0f));
            this.bbL.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.bbP == null) {
            this.bbS = bitmap;
            this.bbP = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.bbN = this.bbP.z(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.bbN = this.bbP.z(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.bbT = 2;
            MO();
        }
    }

    public void MO() {
        if (this.bbT == 2 && this.bbP != null && this.bcc.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.bbO == null && this.bbL.getMeasuredWidth() > 0 && this.bbL.getMeasuredHeight() > 0 && this.bbP.MY()[0] > 0 && this.bbP.MY()[1] > 0) {
            this.bbO = new com.baidu.tbadk.widget.largeImage.a.b(this.bbL.getMeasuredWidth(), this.bbL.getMeasuredHeight(), this.bbP.MY());
            this.bcc.setPriority(3);
            this.bcc.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aJm = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !MP()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.bbL.getWidth() - this.bbL.getPaddingLeft()) - this.bbL.getPaddingRight();
            int height2 = (this.bbL.getHeight() - this.bbL.getPaddingTop()) - this.bbL.getPaddingBottom();
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

    private boolean MP() {
        return (this.bbO == null || this.bbO.ML() == null || this.bbO.ML().getBitmap() == null || this.bbO.ML().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(Canvas canvas) {
        if (this.bbT != 1 || this.bbS == null) {
            if (this.bbO != null) {
                this.bbO.MH();
                if (MP()) {
                    canvas.drawBitmap(this.bbO.ML().getBitmap(), this.bbW, null);
                }
                a(this.bbO, false);
                MS();
                canvas.save();
                float MD = (1.0f * this.bbO.MD()) / this.bbO.MK();
                canvas.scale(MD, MD);
                List<com.baidu.tbadk.widget.largeImage.a.a> MJ = this.bbO.MJ();
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
        return this.aWV;
    }

    public float getMinScaleValue() {
        if (this.aWV < 1.0f) {
            return this.aWV;
        }
        return 1.0f;
    }

    public float MR() {
        return 2.0f * this.aWV;
    }

    public void release() {
        if (this.bbZ != null) {
            this.bbZ.cancel();
        }
        if (this.bcc != null) {
            this.bcc.cancel();
        }
        if (this.bbV != null) {
            this.bbV.onDestory();
        }
        if (this.bbO != null && this.bbO.MJ() != null) {
            this.bbO.MJ().clear();
        }
        if (this.bbX != null) {
            this.bbX.recycle();
            this.bbX = null;
        }
        if (this.bbN != null) {
            this.bbN.recycle();
        }
    }

    private void MS() {
        List<com.baidu.tbadk.widget.largeImage.a.a> MJ = this.bbO.MJ();
        if (MJ != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : MJ) {
                a(aVar, this.bbO);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.bbY = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.MB().Iw() == 0 && aVar.MB().getRow() == 1) {
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
        aVar.i((i - rect.left) / MD, (i3 - rect.top) / MD, (i2 - rect.left) / MD, (i4 - rect.top) / MD);
        aVar.h((i - rect2.left) / MD, (i3 - rect2.top) / MD, (i2 - rect2.left) / MD, (i4 - rect2.top) / MD);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.MF(), bVar.MD(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.bbV == null) {
            this.bbV = new com.baidu.tbadk.widget.largeImage.b.c(this.bbO, this.bbN);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> MJ = this.bbO.MJ();
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
            this.bbV.Na();
        }
    }

    public void MT() {
        if (this.bbT != 1) {
            a(this.bbO, true);
        }
    }

    private void r(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.bbV.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a s(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0120a c0120a = new a.C0120a(i, i2, i3);
        if (this.bbV.Nb() != null && (aVar = this.bbV.Nb().get(c0120a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.bbV.Nb().remove(c0120a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void Gk() {
        this.bbL.postInvalidate();
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
                b.this.bcb = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.bbR == b.this.aWW ? b.this.aWV : b.this.aWW, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect MH = b.this.bbO.MH();
            Rect ME = b.this.bbO.ME();
            float f3 = MH.right - ME.right;
            float f4 = MH.left - ME.left;
            float f5 = MH.bottom - ME.bottom;
            float f6 = MH.top - ME.top;
            b.this.bbU.forceFinished(true);
            b.this.bbU.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.bbL.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.bcb = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.bcb || b.this.aJm == null) {
                b.this.bcb = false;
            } else {
                b.this.aJm.onLongClick(b.this.bbL);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.bcb || b.this.mClickListener == null) {
                b.this.bcb = false;
            } else {
                b.this.mClickListener.onClick(b.this.bbL);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.bbZ != null) {
            this.bbZ.cancel();
        }
        this.bbZ = ValueAnimator.ofFloat(this.bbR, f);
        this.bbZ.setDuration(i);
        this.bbZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.bbR, f2, f3);
                }
            }
        });
        this.bbZ.start();
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
        if (this.bbR * f < this.bbQ) {
            f = this.bbQ / this.bbR;
        }
        if (this.bbR * f > this.aWW) {
            f = this.aWW / this.bbR;
        }
        Rect MH = this.bbO.MH();
        float f4 = ((MH.left + MH.right) * 1.0f) / 2.0f;
        float f5 = ((MH.bottom + MH.top) * 1.0f) / 2.0f;
        if (this.bbO != null) {
            this.bbW.postScale(f, f, this.bbO.getRealWidth() / 2, this.bbO.MI() / 2);
            this.bbO.b(1.0f / f, f4, f5);
            this.bbR *= f;
            this.bbO.ab(1.0f / this.bbR);
            float[] MU = MU();
            this.bbW.postTranslate(-MU[0], -MU[1]);
            this.bbO.o((MU[0] * 1.0f) / this.bbR, (MU[1] * 1.0f) / this.bbR);
            MT();
            this.bbL.invalidate();
        }
    }

    public boolean LJ() {
        Rect MH;
        return (this.bbO == null || (MH = this.bbO.MH()) == null || MH.top > 10) ? false : true;
    }

    private float[] MU() {
        Rect MH = this.bbO.MH();
        int[] MY = this.bbP.MY();
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
        fArr[0] = fArr[0] * this.bbR;
        fArr[1] = fArr[1] * this.bbR;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.bbO != null) {
            float[] p = p(f, f2);
            this.bbW.postTranslate(-p[0], -p[1]);
            this.bbO.o((p[0] * 1.0f) / this.bbR, (p[1] * 1.0f) / this.bbR);
            MT();
            this.bbL.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect MH = this.bbO.MH();
        int[] MY = this.bbP.MY();
        if (MH.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (MH.bottom + f2 > MY[1]) {
            f2 = (MY[1] - MH.bottom) * this.bbR;
        }
        if (MH.bottom - MH.top > MY[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.bca = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MV() {
        if (this.bbO != null) {
            this.bbO.ac(1.0f / this.aWV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.MI() * 1.0f) / bitmap.getHeight());
        this.bbW.postScale(max, max);
        this.bbQ = max * (1.0f / i);
        this.aWV = this.bbQ;
        this.bbR = this.aWV;
        this.aWW = 2.0f * this.bbR;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.bbN.getWidth();
        if (realWidth > 1.0f) {
            this.bbQ /= realWidth;
        }
        bVar.ab(1.0f / this.bbR);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bcg;
        int bch;

        public a(Context context) {
            super(context);
            this.bcg = 0;
            this.bch = 0;
        }

        public void fE(int i) {
            this.bcg = i;
        }

        public void fF(int i) {
            this.bch = i;
        }

        public int MW() {
            return this.bcg;
        }

        public int MX() {
            return this.bch;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bcg = 0;
            this.bch = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

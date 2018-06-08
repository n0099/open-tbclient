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
    private View.OnLongClickListener aIl;
    private final View baI;
    private ScaleGestureDetector baJ;
    private BitmapRegionDecoder baK;
    private com.baidu.tbadk.widget.largeImage.a.b baL;
    private com.baidu.tbadk.widget.largeImage.b.a baM;
    private float baN;
    private float baO;
    private int baP;
    private a baQ;
    private com.baidu.tbadk.widget.largeImage.b.c baR;
    private com.baidu.tbadk.widget.largeImage.logic.a baU;
    private ValueAnimator baV;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private GestureDetector mGestureDetector;
    private Bitmap mOriginalBitmap;
    private float aVY = 2.0f;
    private float aVX = 1.0f;
    private final Matrix baS = new Matrix();
    Bitmap baT = null;
    private boolean baW = true;
    private boolean baX = false;
    BdAsyncTask<String, String, String> baY = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (b.this.baL != null && b.this.baK != null) {
                int[] MG = b.this.baM.MG();
                int i = 1;
                while (Math.max(MG[0] / b.this.baL.getRealWidth(), MG[1] / b.this.baL.Mq()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, MG[0], MG[1]);
                try {
                    b.this.baT = b.this.baK.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.baT = b.this.baK.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.baT = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.ID().c("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.baT, false));
                b.this.a(b.this.baT, b.this.baL, pow);
                b.this.baL.j(b.this.baT);
                b.this.MD();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.baU != null) {
                b.this.baU.FW();
            }
            b.this.MB();
            b.this.baI.invalidate();
        }
    };

    public b(View view) {
        this.baP = 1;
        this.baI = view;
        this.mContext = this.baI.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0123b());
        this.baJ = new ScaleGestureDetector(this.mContext, new c());
        this.baQ = new a(this.mContext);
        this.baP = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.baP == 2 && Mx()) {
            switch (action) {
                case 0:
                    if (!this.baQ.isFinished()) {
                        this.baX = true;
                    } else {
                        this.baX = false;
                    }
                case 1:
                case 3:
                    Ls();
                    break;
            }
            this.baQ.forceFinished(true);
            this.baJ.onTouchEvent(motionEvent);
            if (this.baJ.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean Mu() {
        return Math.floor((double) (this.aVX * 10000.0f)) == Math.floor((double) (this.baO * 10000.0f));
    }

    public void Ls() {
        if (this.baO / this.aVX < 1.0f) {
            a(this.aVX, 0.0f, 0.0f, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public boolean Mv() {
        if (this.baP == 1) {
            return false;
        }
        if (this.baQ.computeScrollOffset()) {
            int currX = this.baQ.getCurrX();
            this.baQ.fD(currX);
            int currY = this.baQ.getCurrY();
            this.baQ.fE(currY);
            moveTo(-((currX - this.baQ.ME()) * 2.0f), -((currY - this.baQ.MF()) * 2.0f));
            this.baI.invalidate();
            return true;
        }
        return true;
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.baM == null) {
            this.mOriginalBitmap = bitmap;
            this.baM = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.baK = this.baM.A(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.baK = this.baM.A(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.baP = 2;
            Mw();
        }
    }

    public void Mw() {
        if (this.baP == 2 && this.baM != null && this.baY.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.baL == null && this.baI.getMeasuredWidth() > 0 && this.baI.getMeasuredHeight() > 0 && this.baM.MG()[0] > 0 && this.baM.MG()[1] > 0) {
            this.baL = new com.baidu.tbadk.widget.largeImage.a.b(this.baI.getMeasuredWidth(), this.baI.getMeasuredHeight(), this.baM.MG());
            this.baY.setPriority(3);
            this.baY.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aIl = onLongClickListener;
    }

    public boolean b(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !Mx()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.baI.getWidth() - this.baI.getPaddingLeft()) - this.baI.getPaddingRight();
            int height2 = (this.baI.getHeight() - this.baI.getPaddingTop()) - this.baI.getPaddingBottom();
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

    private boolean Mx() {
        return (this.baL == null || this.baL.Mt() == null || this.baL.Mt().getBitmap() == null || this.baL.Mt().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(Canvas canvas) {
        if (this.baP != 1 || this.mOriginalBitmap == null) {
            if (this.baL != null) {
                this.baL.Mp();
                if (Mx()) {
                    canvas.drawBitmap(this.baL.Mt().getBitmap(), this.baS, null);
                }
                a(this.baL, false);
                MA();
                canvas.save();
                float Ml = (1.0f * this.baL.Ml()) / this.baL.Ms();
                canvas.scale(Ml, Ml);
                List<com.baidu.tbadk.widget.largeImage.a.a> Mr = this.baL.Mr();
                if (Mr != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : Mr) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.Mh(), aVar.Mi(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float My() {
        return this.aVX;
    }

    public float getMinScaleValue() {
        if (this.aVX < 1.0f) {
            return this.aVX;
        }
        return 1.0f;
    }

    public float Mz() {
        return 2.0f * this.aVX;
    }

    public void release() {
        if (this.baV != null) {
            this.baV.cancel();
        }
        if (this.baY != null) {
            this.baY.cancel();
        }
        if (this.baR != null) {
            this.baR.onDestory();
        }
        if (this.baL != null && this.baL.Mr() != null) {
            this.baL.Mr().clear();
        }
        if (this.baT != null) {
            this.baT.recycle();
            this.baT = null;
        }
        if (this.baK != null) {
            this.baK.recycle();
        }
    }

    private void MA() {
        List<com.baidu.tbadk.widget.largeImage.a.a> Mr = this.baL.Mr();
        if (Mr != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : Mr) {
                a(aVar, this.baL);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.baU = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.Mj().Ij() == 0 && aVar.Mj().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.Mp());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int Ml = aVar.Mj().Ml();
        aVar.j((i - rect.left) / Ml, (i3 - rect.top) / Ml, (i2 - rect.left) / Ml, (i4 - rect.top) / Ml);
        aVar.i((i - rect2.left) / Ml, (i3 - rect2.top) / Ml, (i2 - rect2.left) / Ml, (i4 - rect2.top) / Ml);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        a(bVar.Mn(), bVar.Ml(), z);
    }

    private void a(Point[] pointArr, int i, boolean z) {
        int i2;
        boolean z2;
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        if (this.baR == null) {
            this.baR = new com.baidu.tbadk.widget.largeImage.b.c(this.baL, this.baK);
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
            List<com.baidu.tbadk.widget.largeImage.a.a> Mr = this.baL.Mr();
            Mr.clear();
            i2 = i3;
            z2 = true;
            list = Mr;
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
            this.baR.MI();
        }
    }

    public void MB() {
        if (this.baP != 1) {
            a(this.baL, true);
        }
    }

    private void r(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.baR.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a s(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0122a c0122a = new a.C0122a(i, i2, i3);
        if (this.baR.MJ() != null && (aVar = this.baR.MJ().get(c0122a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.baR.MJ().remove(c0122a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void FW() {
        this.baI.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0123b extends GestureDetector.SimpleOnGestureListener {
        private C0123b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.baX = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.a(b.this.baO == b.this.aVY ? b.this.aVX : b.this.aVY, motionEvent.getX(), motionEvent.getY(), (int) HttpStatus.SC_BAD_REQUEST);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect Mp = b.this.baL.Mp();
            Rect Mm = b.this.baL.Mm();
            float f3 = Mp.right - Mm.right;
            float f4 = Mp.left - Mm.left;
            float f5 = Mp.bottom - Mm.bottom;
            float f6 = Mp.top - Mm.top;
            b.this.baQ.forceFinished(true);
            b.this.baQ.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.baI.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.baX = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.baX || b.this.aIl == null) {
                b.this.baX = false;
            } else {
                b.this.aIl.onLongClick(b.this.baI);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.baX || b.this.mClickListener == null) {
                b.this.baX = false;
            } else {
                b.this.mClickListener.onClick(b.this.baI);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, final float f2, final float f3, int i) {
        if (this.baV != null) {
            this.baV.cancel();
        }
        this.baV = ValueAnimator.ofFloat(this.baO, f);
        this.baV.setDuration(i);
        this.baV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.baO, f2, f3);
                }
            }
        });
        this.baV.start();
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
        if (this.baO * f < this.baN) {
            f = this.baN / this.baO;
        }
        if (this.baO * f > this.aVY) {
            f = this.aVY / this.baO;
        }
        Rect Mp = this.baL.Mp();
        float f4 = ((Mp.left + Mp.right) * 1.0f) / 2.0f;
        float f5 = ((Mp.bottom + Mp.top) * 1.0f) / 2.0f;
        if (this.baL != null) {
            this.baS.postScale(f, f, this.baL.getRealWidth() / 2, this.baL.Mq() / 2);
            this.baL.b(1.0f / f, f4, f5);
            this.baO *= f;
            this.baL.aa(1.0f / this.baO);
            float[] MC = MC();
            this.baS.postTranslate(-MC[0], -MC[1]);
            this.baL.o((MC[0] * 1.0f) / this.baO, (MC[1] * 1.0f) / this.baO);
            MB();
            this.baI.invalidate();
        }
    }

    public boolean Lr() {
        Rect Mp;
        return (this.baL == null || (Mp = this.baL.Mp()) == null || Mp.top > 10) ? false : true;
    }

    private float[] MC() {
        Rect Mp = this.baL.Mp();
        int[] MG = this.baM.MG();
        float[] fArr = {(MG[0] / 2) - (((Mp.left + Mp.right) * 1.0f) / 2.0f)};
        if (Mp.top < 0) {
            fArr[1] = 0 - Mp.top;
        }
        if (Mp.bottom > MG[1]) {
            fArr[1] = MG[1] - Mp.bottom;
        }
        if (Mp.bottom - Mp.top > MG[1]) {
            fArr[1] = (MG[1] / 2) - (((Mp.bottom + Mp.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.baO;
        fArr[1] = fArr[1] * this.baO;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTo(float f, float f2) {
        if (this.baL != null) {
            float[] p = p(f, f2);
            this.baS.postTranslate(-p[0], -p[1]);
            this.baL.o((p[0] * 1.0f) / this.baO, (p[1] * 1.0f) / this.baO);
            MB();
            this.baI.invalidate();
        }
    }

    private float[] p(float f, float f2) {
        float[] fArr = new float[2];
        Rect Mp = this.baL.Mp();
        int[] MG = this.baM.MG();
        if (Mp.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Mp.bottom + f2 > MG[1]) {
            f2 = (MG[1] - Mp.bottom) * this.baO;
        }
        if (Mp.bottom - Mp.top > MG[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.baW = f2 == 0.0f;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MD() {
        if (this.baL != null) {
            this.baL.ab(1.0f / this.aVX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.Mq() * 1.0f) / bitmap.getHeight());
        this.baS.postScale(max, max);
        this.baN = max * (1.0f / i);
        this.aVX = this.baN;
        this.baO = this.aVX;
        this.aVY = 2.0f * this.baO;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.baK.getWidth();
        if (realWidth > 1.0f) {
            this.baN /= realWidth;
        }
        bVar.aa(1.0f / this.baO);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int bbc;
        int bbd;

        public a(Context context) {
            super(context);
            this.bbc = 0;
            this.bbd = 0;
        }

        public void fD(int i) {
            this.bbc = i;
        }

        public void fE(int i) {
            this.bbd = i;
        }

        public int ME() {
            return this.bbc;
        }

        public int MF() {
            return this.bbd;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.bbc = 0;
            this.bbd = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

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
    private a fVA;
    private com.baidu.tbadk.widget.largeImage.b.c fVB;
    private com.baidu.tbadk.widget.largeImage.logic.a fVC;
    private com.baidu.tbadk.widget.largeImage.a.b fVy;
    private com.baidu.tbadk.widget.largeImage.b.a fVz;
    private BitmapRegionDecoder mBitmapRegionDecoder;
    private View.OnClickListener mClickListener;
    private final Context mContext;
    private int mCurrentLoadType;
    private float mCurrentScaled;
    private GestureDetector mGestureDetector;
    private final View mImageView;
    private View.OnLongClickListener mLongClickListener;
    private float mMinScale;
    private Bitmap mOriginalBitmap;
    private ScaleGestureDetector mScaleGestureDetector;
    private ValueAnimator scaleAnimator;
    private float mMaxScale = 2.0f;
    private float mInitScale = 1.0f;
    private final Matrix mDisplayMatrix = new Matrix();
    Bitmap mThumbnailBitmap = null;
    private boolean mIsTop = true;
    private boolean ain = false;
    private boolean mIsYScrollInLastAction = false;
    BdAsyncTask<String, String, String> fVD = new BdAsyncTask<String, String, String>() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (b.this.fVy != null && b.this.mBitmapRegionDecoder != null) {
                int[] imageWidthAndHeight = b.this.fVz.getImageWidthAndHeight();
                int i = 1;
                while (Math.max(imageWidthAndHeight[0] / b.this.fVy.getRealWidth(), imageWidthAndHeight[1] / b.this.fVy.getRealHeight()) > Math.pow(2.0d, i)) {
                    i++;
                }
                int pow = (int) Math.pow(2.0d, i);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = pow;
                Rect rect = new Rect(0, 0, imageWidthAndHeight[0], imageWidthAndHeight[1]);
                try {
                    b.this.mThumbnailBitmap = b.this.mBitmapRegionDecoder.decodeRegion(rect, options);
                } catch (Throwable th) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    try {
                        b.this.mThumbnailBitmap = b.this.mBitmapRegionDecoder.decodeRegion(rect, options);
                    } catch (Throwable th2) {
                        b.this.mThumbnailBitmap = null;
                    }
                }
                com.baidu.tbadk.imageManager.c.bGp().b("long_img_mThumb" + System.currentTimeMillis(), new com.baidu.adp.widget.ImageView.a(b.this.mThumbnailBitmap, false));
                b.this.a(b.this.mThumbnailBitmap, b.this.fVy, pow);
                b.this.fVy.setThumbnail(b.this.mThumbnailBitmap);
                b.this.initViewPointWindow();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (b.this.fVC != null) {
                b.this.fVC.onLoadFinished();
            }
            b.this.findNeedLoadBitmapBlockAndSumitTask();
            b.this.mImageView.invalidate();
        }
    };

    public b(View view) {
        this.mCurrentLoadType = 1;
        this.mImageView = view;
        this.mContext = this.mImageView.getContext();
        this.mGestureDetector = new GestureDetector(this.mContext, new C0607b());
        this.mScaleGestureDetector = new ScaleGestureDetector(this.mContext, new c());
        this.fVA = new a(this.mContext);
        this.mCurrentLoadType = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (this.mCurrentLoadType == 2 && isBigThumbnailBlockOK()) {
            switch (action) {
                case 0:
                    if (!this.fVA.isFinished()) {
                        this.mIsYScrollInLastAction = true;
                    } else {
                        this.mIsYScrollInLastAction = false;
                    }
                case 1:
                case 3:
                    actionUp();
                    break;
            }
            this.fVA.forceFinished(true);
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
            if (this.mScaleGestureDetector.isInProgress()) {
                return true;
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean isViewTop() {
        return this.mIsTop;
    }

    public boolean bJv() {
        return this.ain;
    }

    public boolean isNormalScale() {
        return Math.floor((double) (this.mInitScale * 10000.0f)) == Math.floor((double) (this.mCurrentScaled * 10000.0f));
    }

    public void actionUp() {
        if (this.mCurrentScaled / this.mInitScale < 1.0f) {
            smoothScale(this.mInitScale, 0.0f, 0.0f, 400);
        }
    }

    public boolean computeScroll() {
        if (this.mCurrentLoadType == 1) {
            return false;
        }
        if (this.fVA.computeScrollOffset()) {
            int currX = this.fVA.getCurrX();
            int currY = this.fVA.getCurrY();
            float oldValueX = (currX - this.fVA.getOldValueX()) * 2.0f;
            float oldValueY = (currY - this.fVA.getOldValueY()) * 2.0f;
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            if (oldValueY >= 0.0f && Math.abs(oldValueY) <= 20.0f && currX < equipmentHeight) {
                moveTo(0.0f, -20.0f);
                this.mImageView.invalidate();
                return true;
            }
            this.fVA.setOldValueX(currX);
            this.fVA.setOldValueY(currY);
            moveTo(-oldValueX, -oldValueY);
            this.mImageView.invalidate();
            return true;
        }
        return true;
    }

    public void moveTo(float f, float f2) {
        if (this.fVy != null) {
            float[] realMove = getRealMove(f, f2);
            float f3 = realMove[0];
            float f4 = realMove[1];
            this.mDisplayMatrix.postTranslate(-f3, -f4);
            this.fVy.moveWindow((f3 * 1.0f) / this.mCurrentScaled, (f4 * 1.0f) / this.mCurrentScaled);
            findNeedLoadBitmapBlockAndSumitTask();
            this.mImageView.invalidate();
        }
    }

    private float[] getRealMove(float f, float f2) {
        float[] fArr = new float[2];
        Rect windowInOriginalBitmap = this.fVy.getWindowInOriginalBitmap();
        int[] imageWidthAndHeight = this.fVz.getImageWidthAndHeight();
        if (windowInOriginalBitmap.top + f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (windowInOriginalBitmap.bottom + f2 > imageWidthAndHeight[1]) {
            f2 = (imageWidthAndHeight[1] - windowInOriginalBitmap.bottom) * this.mCurrentScaled;
        }
        if (windowInOriginalBitmap.bottom - windowInOriginalBitmap.top > imageWidthAndHeight[1]) {
            f2 = 0.0f;
        }
        fArr[0] = 0.0f;
        fArr[1] = f2;
        this.mIsTop = f2 == 0.0f;
        this.ain = windowInOriginalBitmap.bottom == imageWidthAndHeight[1];
        if (this.ain) {
            this.mIsTop = false;
        }
        return fArr;
    }

    public void setImageDatas(Bitmap bitmap, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && this.fVz == null) {
            this.mOriginalBitmap = bitmap;
            this.fVz = new com.baidu.tbadk.widget.largeImage.b.a(this.mContext);
            try {
                this.mBitmapRegionDecoder = this.fVz.createDecoder(bArr);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                try {
                    this.mBitmapRegionDecoder = this.fVz.createDecoder(bArr);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.mCurrentLoadType = 2;
            startLoad();
        }
    }

    public void startLoad() {
        if (this.mCurrentLoadType == 2 && this.fVz != null && this.fVD.getStatus() == BdAsyncTask.BdAsyncTaskStatus.PENDING && this.fVy == null && this.mImageView.getMeasuredWidth() > 0 && this.mImageView.getMeasuredHeight() > 0 && this.fVz.getImageWidthAndHeight()[0] > 0 && this.fVz.getImageWidthAndHeight()[1] > 0) {
            this.fVy = new com.baidu.tbadk.widget.largeImage.a.b(this.mImageView.getMeasuredWidth(), this.mImageView.getMeasuredHeight(), this.fVz.getImageWidthAndHeight());
            this.fVD.setPriority(3);
            this.fVD.execute(new String[0]);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public boolean onDraw(Canvas canvas, Bitmap bitmap) {
        float f;
        if (bitmap != null && !bitmap.isRecycled() && !isBigThumbnailBlockOK()) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = (this.mImageView.getWidth() - this.mImageView.getPaddingLeft()) - this.mImageView.getPaddingRight();
            int height2 = (this.mImageView.getHeight() - this.mImageView.getPaddingTop()) - this.mImageView.getPaddingBottom();
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
        return onDraw(canvas);
    }

    private boolean isBigThumbnailBlockOK() {
        return (this.fVy == null || this.fVy.bKw() == null || this.fVy.bKw().getBitmap() == null || this.fVy.bKw().getBitmap().isRecycled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onDraw(Canvas canvas) {
        if (this.mCurrentLoadType != 1 || this.mOriginalBitmap == null) {
            if (this.fVy != null) {
                this.fVy.getWindowInOriginalBitmap();
                if (isBigThumbnailBlockOK()) {
                    canvas.drawBitmap(this.fVy.bKw().getBitmap(), this.mDisplayMatrix, null);
                }
                a(this.fVy, false);
                updateAllBitmapBlock();
                canvas.save();
                float sampleScale = (1.0f * this.fVy.getSampleScale()) / this.fVy.getScaleLevel();
                canvas.scale(sampleScale, sampleScale);
                List<com.baidu.tbadk.widget.largeImage.a.a> blockBitmapList = this.fVy.getBlockBitmapList();
                if (blockBitmapList != null) {
                    for (com.baidu.tbadk.widget.largeImage.a.a aVar : blockBitmapList) {
                        canvas.drawBitmap(aVar.getBitmap(), aVar.getSrc(), aVar.getDst(), (Paint) null);
                    }
                }
                canvas.restore();
            }
            return true;
        }
        return false;
    }

    public float reInitScaleValue() {
        return this.mInitScale;
    }

    public float getMinScaleValue() {
        if (this.mInitScale < 1.0f) {
            return this.mInitScale;
        }
        return 1.0f;
    }

    public float getMaxScaleValue() {
        return 2.0f * this.mInitScale;
    }

    public void release() {
        if (this.scaleAnimator != null) {
            this.scaleAnimator.cancel();
        }
        if (this.fVD != null) {
            this.fVD.cancel();
        }
        if (this.fVB != null) {
            this.fVB.onDestory();
        }
        if (this.fVy != null && this.fVy.getBlockBitmapList() != null) {
            this.fVy.getBlockBitmapList().clear();
        }
        if (this.mThumbnailBitmap != null) {
            this.mThumbnailBitmap.recycle();
            this.mThumbnailBitmap = null;
        }
        if (this.mBitmapRegionDecoder != null) {
            this.mBitmapRegionDecoder.recycle();
        }
    }

    private void updateAllBitmapBlock() {
        List<com.baidu.tbadk.widget.largeImage.a.a> blockBitmapList = this.fVy.getBlockBitmapList();
        if (blockBitmapList != null) {
            for (com.baidu.tbadk.widget.largeImage.a.a aVar : blockBitmapList) {
                a(aVar, this.fVy);
            }
        }
    }

    public void a(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        this.fVC = aVar;
    }

    public void a(com.baidu.tbadk.widget.largeImage.a.a aVar, com.baidu.tbadk.widget.largeImage.a.b bVar) {
        if (aVar.bKu().getColumn() == 0 && aVar.bKu().getRow() == 1) {
            System.currentTimeMillis();
        }
        a(aVar, bVar.a(aVar), bVar.getWindowInOriginalBitmap());
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.a aVar, Rect rect, Rect rect2) {
        int i = rect.left > rect2.left ? rect.left : rect2.left;
        int i2 = rect.right < rect2.right ? rect.right : rect2.right;
        int i3 = rect.top > rect2.top ? rect.top : rect2.top;
        int i4 = rect.bottom < rect2.bottom ? rect.bottom : rect2.bottom;
        int sampleScale = aVar.bKu().getSampleScale();
        aVar.setSrcRect((i - rect.left) / sampleScale, (i3 - rect.top) / sampleScale, (i2 - rect.left) / sampleScale, (i4 - rect.top) / sampleScale);
        aVar.setDstRect((i - rect2.left) / sampleScale, (i3 - rect2.top) / sampleScale, (i2 - rect2.left) / sampleScale, (i4 - rect2.top) / sampleScale);
    }

    private void a(com.baidu.tbadk.widget.largeImage.a.b bVar, boolean z) {
        getAllAvailableBlock(bVar.getStartAndEndPosition(), bVar.getSampleScale(), z);
    }

    private void getAllAvailableBlock(Point[] pointArr, int i, boolean z) {
        List<com.baidu.tbadk.widget.largeImage.a.a> list;
        boolean z2 = true;
        if (this.fVB == null) {
            this.fVB = new com.baidu.tbadk.widget.largeImage.b.c(this.fVy, this.mBitmapRegionDecoder);
        }
        int i2 = pointArr[0].x;
        int i3 = pointArr[1].y;
        int i4 = pointArr[1].x;
        if (z) {
            list = null;
        } else {
            List<com.baidu.tbadk.widget.largeImage.a.a> blockBitmapList = this.fVy.getBlockBitmapList();
            blockBitmapList.clear();
            list = blockBitmapList;
        }
        for (int i5 = pointArr[0].y; i5 < i3; i5++) {
            for (int i6 = i2; i6 < i4; i6++) {
                com.baidu.tbadk.widget.largeImage.a.a E = E(i5, i6, i);
                if (E == null) {
                    if (z) {
                        startTask(i5, i6, i);
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                } else if (!z) {
                    list.add(E);
                }
            }
        }
        if (z2) {
            this.fVB.clearAllTask();
        }
    }

    public void findNeedLoadBitmapBlockAndSumitTask() {
        if (this.mCurrentLoadType != 1) {
            a(this.fVy, true);
        }
    }

    private void startTask(int i, int i2, int i3) {
        c.a aVar = new c.a(i, i2, i3);
        aVar.b(this);
        this.fVB.a(aVar);
    }

    private com.baidu.tbadk.widget.largeImage.a.a E(int i, int i2, int i3) {
        com.baidu.tbadk.widget.largeImage.a.a aVar;
        a.C0606a c0606a = new a.C0606a(i, i2, i3);
        if (this.fVB.bKy() != null && (aVar = this.fVB.bKy().get(c0606a)) != null) {
            if (aVar.getBitmap() == null || aVar.getBitmap().isRecycled()) {
                this.fVB.bKy().remove(c0606a);
                return null;
            }
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.largeImage.logic.a
    public void onLoadFinished() {
        this.mImageView.postInvalidate();
    }

    /* renamed from: com.baidu.tbadk.widget.largeImage.logic.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0607b extends GestureDetector.SimpleOnGestureListener {
        private C0607b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.this.moveTo((int) f, (int) f2);
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.mIsYScrollInLastAction = true;
            }
            if (b.this.mImageView != null && b.this.mCurrentScaled != b.this.mInitScale) {
                b.this.mImageView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.this.smoothScale(b.this.mCurrentScaled == b.this.mMaxScale ? b.this.mInitScale : b.this.mMaxScale, motionEvent.getX(), motionEvent.getY(), 400);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Rect windowInOriginalBitmap = b.this.fVy.getWindowInOriginalBitmap();
            Rect originalBitmapRect = b.this.fVy.getOriginalBitmapRect();
            float f3 = windowInOriginalBitmap.right - originalBitmapRect.right;
            float f4 = windowInOriginalBitmap.left - originalBitmapRect.left;
            float f5 = windowInOriginalBitmap.bottom - originalBitmapRect.bottom;
            float f6 = windowInOriginalBitmap.top - originalBitmapRect.top;
            b.this.fVA.forceFinished(true);
            b.this.fVA.fling((int) 0.0f, (int) 0.0f, (int) f, (int) f2, (int) f3, (int) f4, (int) f5, (int) f6);
            b.this.mImageView.invalidate();
            if (Math.abs(f2) > b.TOUCH_SLOP) {
                b.this.mIsYScrollInLastAction = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (b.this.mIsYScrollInLastAction || b.this.mLongClickListener == null) {
                b.this.mIsYScrollInLastAction = false;
            } else {
                b.this.mLongClickListener.onLongClick(b.this.mImageView);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (b.this.mIsYScrollInLastAction || b.this.mClickListener == null) {
                b.this.mIsYScrollInLastAction = false;
            } else {
                b.this.mClickListener.onClick(b.this.mImageView);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScale(float f, final float f2, final float f3, int i) {
        if (this.scaleAnimator != null) {
            this.scaleAnimator.cancel();
        }
        this.scaleAnimator = ValueAnimator.ofFloat(this.mCurrentScaled, f);
        this.scaleAnimator.setDuration(i);
        this.scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.largeImage.logic.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    b.this.onScale(((Float) valueAnimator.getAnimatedValue()).floatValue() / b.this.mCurrentScaled, f2, f3);
                }
            }
        });
        this.scaleAnimator.start();
    }

    /* loaded from: classes.dex */
    private class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            b.this.onScale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }
    }

    public void onScale(float f, float f2, float f3) {
        if (this.mCurrentScaled * f < this.mMinScale) {
            f = this.mMinScale / this.mCurrentScaled;
        }
        if (this.mCurrentScaled * f > this.mMaxScale) {
            f = this.mMaxScale / this.mCurrentScaled;
        }
        Rect windowInOriginalBitmap = this.fVy.getWindowInOriginalBitmap();
        float f4 = ((windowInOriginalBitmap.left + windowInOriginalBitmap.right) * 1.0f) / 2.0f;
        float f5 = ((windowInOriginalBitmap.bottom + windowInOriginalBitmap.top) * 1.0f) / 2.0f;
        if (this.fVy != null) {
            this.mDisplayMatrix.postScale(f, f, this.fVy.getRealWidth() / 2, this.fVy.getRealHeight() / 2);
            this.fVy.postScaleWindow(1.0f / f, f4, f5);
            this.mCurrentScaled *= f;
            this.fVy.setScaleLevel(1.0f / this.mCurrentScaled);
            float[] checkPosition = checkPosition();
            this.mDisplayMatrix.postTranslate(-checkPosition[0], -checkPosition[1]);
            this.fVy.moveWindow((checkPosition[0] * 1.0f) / this.mCurrentScaled, (checkPosition[1] * 1.0f) / this.mCurrentScaled);
            findNeedLoadBitmapBlockAndSumitTask();
            this.mImageView.invalidate();
        }
    }

    public boolean isAtViewTop() {
        Rect windowInOriginalBitmap;
        return (this.fVy == null || (windowInOriginalBitmap = this.fVy.getWindowInOriginalBitmap()) == null || windowInOriginalBitmap.top > 10) ? false : true;
    }

    private float[] checkPosition() {
        Rect windowInOriginalBitmap = this.fVy.getWindowInOriginalBitmap();
        int[] imageWidthAndHeight = this.fVz.getImageWidthAndHeight();
        float[] fArr = {(imageWidthAndHeight[0] / 2) - (((windowInOriginalBitmap.left + windowInOriginalBitmap.right) * 1.0f) / 2.0f)};
        if (windowInOriginalBitmap.top < 0) {
            fArr[1] = 0 - windowInOriginalBitmap.top;
        }
        if (windowInOriginalBitmap.bottom > imageWidthAndHeight[1]) {
            fArr[1] = imageWidthAndHeight[1] - windowInOriginalBitmap.bottom;
        }
        if (windowInOriginalBitmap.bottom - windowInOriginalBitmap.top > imageWidthAndHeight[1]) {
            fArr[1] = (imageWidthAndHeight[1] / 2) - (((windowInOriginalBitmap.bottom + windowInOriginalBitmap.top) * 1.0f) / 2.0f);
        }
        fArr[0] = fArr[0] * this.mCurrentScaled;
        fArr[1] = fArr[1] * this.mCurrentScaled;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPointWindow() {
        if (this.fVy != null) {
            this.fVy.postScaleWindow(1.0f / this.mInitScale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, com.baidu.tbadk.widget.largeImage.a.b bVar, int i) {
        float max = Math.max((bVar.getRealWidth() * 1.0f) / bitmap.getWidth(), (bVar.getRealHeight() * 1.0f) / bitmap.getHeight());
        this.mDisplayMatrix.postScale(max, max);
        this.mMinScale = max * (1.0f / i);
        this.mInitScale = this.mMinScale;
        this.mCurrentScaled = this.mInitScale;
        this.mMaxScale = 2.0f * this.mCurrentScaled;
        float realWidth = (bVar.getRealWidth() * 1.0f) / this.mBitmapRegionDecoder.getWidth();
        if (realWidth > 1.0f) {
            this.mMinScale /= realWidth;
        }
        bVar.setScaleLevel(1.0f / this.mCurrentScaled);
    }

    /* loaded from: classes.dex */
    private class a extends Scroller {
        int mOldValueX;
        int mOldValueY;

        public a(Context context) {
            super(context);
            this.mOldValueX = 0;
            this.mOldValueY = 0;
        }

        public void setOldValueX(int i) {
            this.mOldValueX = i;
        }

        public void setOldValueY(int i) {
            this.mOldValueY = i;
        }

        public int getOldValueX() {
            return this.mOldValueX;
        }

        public int getOldValueY() {
            return this.mOldValueY;
        }

        @Override // android.widget.Scroller
        public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mOldValueX = 0;
            this.mOldValueY = 0;
            super.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }
}

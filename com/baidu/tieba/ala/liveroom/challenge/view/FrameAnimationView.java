package com.baidu.tieba.ala.liveroom.challenge.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
/* loaded from: classes2.dex */
public class FrameAnimationView<T> extends ImageView implements d {
    private BdUniqueId anM;
    private T[] eTL;
    private Bitmap eTM;
    private Rect eTN;
    private long eTO;
    private long eTP;
    private boolean eTQ;
    private b eTR;
    private com.baidu.tieba.ala.liveroom.challenge.a.b eTS;
    private Runnable eTT;
    private int index;
    private boolean isPlaying;
    private int mFrameCount;
    private Handler mHandler;
    private Rect srcRect;

    /* loaded from: classes2.dex */
    public interface b {
        void onAnimEnd();

        void onAnimStart();
    }

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.srcRect = new Rect();
        this.eTN = new Rect();
        this.eTO = 0L;
        this.eTT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.biQ();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.eTN = new Rect();
        this.eTO = 0L;
        this.eTT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.biQ();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.eTN = new Rect();
        this.eTO = 0L;
        this.eTT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.biQ();
            }
        };
    }

    public void a(T[] tArr, int i, boolean z, com.baidu.tieba.ala.liveroom.challenge.a.b bVar) {
        this.eTL = tArr;
        if (this.eTL != null) {
            this.mFrameCount = this.eTL.length;
        }
        this.eTP = i;
        this.eTQ = z;
        this.eTS = bVar;
        this.mHandler = new Handler();
    }

    public void startAnim() {
        if (this.mFrameCount > 0) {
            this.index = 0;
            this.eTO = 0L;
            a aVar = new a(this);
            aVar.setTag(this.anM);
            aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
            aVar.execute(this.eTL[this.index]);
            this.isPlaying = true;
        }
    }

    private void biP() {
        a aVar = new a(this);
        aVar.setTag(this.anM);
        aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
        aVar.execute(this.eTL[this.index]);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.d
    public void q(Bitmap bitmap) {
        if (this.eTO <= 0) {
            this.eTO = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.eTM != null) {
                this.eTM.recycle();
            }
            this.eTM = bitmap;
            this.srcRect.set(0, 0, this.eTM.getWidth(), this.eTM.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        if (this.index == 0 && this.eTR != null) {
            this.eTR.onAnimStart();
        }
        this.index++;
        if (this.eTL == null || this.index >= this.eTL.length) {
            stopAnim();
        } else {
            biQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biQ() {
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.eTO) * this.mFrameCount) / this.eTP);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.eTL.length) {
                stopAnim();
                return;
            } else {
                biP();
                return;
            }
        }
        this.mHandler.postDelayed(this.eTT, 10L);
    }

    public void stopAnim() {
        if (this.eTQ) {
            startAnim();
            return;
        }
        this.isPlaying = false;
        if (this.eTR != null) {
            this.eTR.onAnimEnd();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eTM != null) {
            this.eTN.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.eTM, this.srcRect, this.eTN, (Paint) null);
        }
    }

    public void release() {
        if (this.eTM != null) {
            this.eTM.recycle();
            this.eTM = null;
        }
        this.eTL = null;
        this.eTO = 0L;
        this.mFrameCount = 0;
        this.eTR = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        BdAsyncTask.removeAllTask(this.anM, "FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.anM = bdUniqueId;
    }

    public void setOnFrameAnimationCallback(b bVar) {
        this.eTR = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<T, Bitmap, Bitmap> {
        private d eTV;

        private a(d dVar) {
            this.eTV = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(T... tArr) {
            if (tArr == null || tArr[0] == null) {
                return null;
            }
            return FrameAnimationView.this.eTS.ao(tArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.eTV != null) {
                this.eTV.q(bitmap);
            }
        }
    }
}

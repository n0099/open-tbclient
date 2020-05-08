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
/* loaded from: classes3.dex */
public class FrameAnimationView<T> extends ImageView implements d {
    private BdUniqueId aQK;
    private T[] fEq;
    private Bitmap fEr;
    private Rect fEs;
    private long fEt;
    private long fEu;
    private boolean fEv;
    private b fEw;
    private com.baidu.tieba.ala.liveroom.challenge.a.a fEx;
    private Runnable fEy;
    private int index;
    private boolean isPlaying;
    private int mFrameCount;
    private Handler mHandler;
    private Rect srcRect;

    /* loaded from: classes3.dex */
    public interface b {
        void onAnimEnd();

        void onAnimStart();
    }

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.srcRect = new Rect();
        this.fEs = new Rect();
        this.fEt = 0L;
        this.fEy = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.buQ();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.fEs = new Rect();
        this.fEt = 0L;
        this.fEy = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.buQ();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.fEs = new Rect();
        this.fEt = 0L;
        this.fEy = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.buQ();
            }
        };
    }

    public void startAnim() {
        if (this.mFrameCount > 0) {
            this.index = 0;
            this.fEt = 0L;
            a aVar = new a(this);
            aVar.setTag(this.aQK);
            aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
            aVar.execute(this.fEq[this.index]);
            this.isPlaying = true;
        }
    }

    private void buP() {
        a aVar = new a(this);
        aVar.setTag(this.aQK);
        aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
        aVar.execute(this.fEq[this.index]);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.d
    public void s(Bitmap bitmap) {
        if (this.fEt <= 0) {
            this.fEt = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.fEr != null) {
                this.fEr.recycle();
            }
            this.fEr = bitmap;
            this.srcRect.set(0, 0, this.fEr.getWidth(), this.fEr.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        if (this.index == 0 && this.fEw != null) {
            this.fEw.onAnimStart();
        }
        this.index++;
        if (this.fEq == null || this.index >= this.fEq.length) {
            stopAnim();
        } else {
            buQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buQ() {
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.fEt) * this.mFrameCount) / this.fEu);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.fEq.length) {
                stopAnim();
                return;
            } else {
                buP();
                return;
            }
        }
        this.mHandler.postDelayed(this.fEy, 10L);
    }

    public void stopAnim() {
        if (this.fEv) {
            startAnim();
            return;
        }
        this.isPlaying = false;
        if (this.fEw != null) {
            this.fEw.onAnimEnd();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fEr != null) {
            this.fEs.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.fEr, this.srcRect, this.fEs, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aQK = bdUniqueId;
    }

    public void setOnFrameAnimationCallback(b bVar) {
        this.fEw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<T, Bitmap, Bitmap> {
        private d fEA;

        private a(d dVar) {
            this.fEA = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(T... tArr) {
            if (tArr == null || tArr[0] == null) {
                return null;
            }
            return FrameAnimationView.this.fEx.at(tArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.fEA != null) {
                this.fEA.s(bitmap);
            }
        }
    }
}

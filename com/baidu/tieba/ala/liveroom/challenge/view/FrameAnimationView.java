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
    private BdUniqueId arR;
    private T[] eZl;
    private Bitmap eZm;
    private Rect eZn;
    private long eZo;
    private long eZp;
    private boolean eZq;
    private b eZr;
    private com.baidu.tieba.ala.liveroom.challenge.a.a eZs;
    private Runnable eZt;
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
        this.eZn = new Rect();
        this.eZo = 0L;
        this.eZt = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blr();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.eZn = new Rect();
        this.eZo = 0L;
        this.eZt = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blr();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.eZn = new Rect();
        this.eZo = 0L;
        this.eZt = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blr();
            }
        };
    }

    public void startAnim() {
        if (this.mFrameCount > 0) {
            this.index = 0;
            this.eZo = 0L;
            a aVar = new a(this);
            aVar.setTag(this.arR);
            aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
            aVar.execute(this.eZl[this.index]);
            this.isPlaying = true;
        }
    }

    private void blq() {
        a aVar = new a(this);
        aVar.setTag(this.arR);
        aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
        aVar.execute(this.eZl[this.index]);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.d
    public void q(Bitmap bitmap) {
        if (this.eZo <= 0) {
            this.eZo = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.eZm != null) {
                this.eZm.recycle();
            }
            this.eZm = bitmap;
            this.srcRect.set(0, 0, this.eZm.getWidth(), this.eZm.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        if (this.index == 0 && this.eZr != null) {
            this.eZr.onAnimStart();
        }
        this.index++;
        if (this.eZl == null || this.index >= this.eZl.length) {
            stopAnim();
        } else {
            blr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blr() {
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.eZo) * this.mFrameCount) / this.eZp);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.eZl.length) {
                stopAnim();
                return;
            } else {
                blq();
                return;
            }
        }
        this.mHandler.postDelayed(this.eZt, 10L);
    }

    public void stopAnim() {
        if (this.eZq) {
            startAnim();
            return;
        }
        this.isPlaying = false;
        if (this.eZr != null) {
            this.eZr.onAnimEnd();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eZm != null) {
            this.eZn.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.eZm, this.srcRect, this.eZn, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.arR = bdUniqueId;
    }

    public void setOnFrameAnimationCallback(b bVar) {
        this.eZr = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<T, Bitmap, Bitmap> {
        private d eZv;

        private a(d dVar) {
            this.eZv = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(T... tArr) {
            if (tArr == null || tArr[0] == null) {
                return null;
            }
            return FrameAnimationView.this.eZs.aq(tArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.eZv != null) {
                this.eZv.q(bitmap);
            }
        }
    }
}

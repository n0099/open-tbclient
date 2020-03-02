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
    private T[] eZm;
    private Bitmap eZn;
    private Rect eZo;
    private long eZp;
    private long eZq;
    private boolean eZr;
    private b eZs;
    private com.baidu.tieba.ala.liveroom.challenge.a.a eZt;
    private Runnable eZu;
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
        this.eZo = new Rect();
        this.eZp = 0L;
        this.eZu = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blt();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.eZo = new Rect();
        this.eZp = 0L;
        this.eZu = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blt();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.eZo = new Rect();
        this.eZp = 0L;
        this.eZu = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blt();
            }
        };
    }

    public void startAnim() {
        if (this.mFrameCount > 0) {
            this.index = 0;
            this.eZp = 0L;
            a aVar = new a(this);
            aVar.setTag(this.arR);
            aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
            aVar.execute(this.eZm[this.index]);
            this.isPlaying = true;
        }
    }

    private void bls() {
        a aVar = new a(this);
        aVar.setTag(this.arR);
        aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
        aVar.execute(this.eZm[this.index]);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.d
    public void q(Bitmap bitmap) {
        if (this.eZp <= 0) {
            this.eZp = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.eZn != null) {
                this.eZn.recycle();
            }
            this.eZn = bitmap;
            this.srcRect.set(0, 0, this.eZn.getWidth(), this.eZn.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        if (this.index == 0 && this.eZs != null) {
            this.eZs.onAnimStart();
        }
        this.index++;
        if (this.eZm == null || this.index >= this.eZm.length) {
            stopAnim();
        } else {
            blt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blt() {
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.eZp) * this.mFrameCount) / this.eZq);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.eZm.length) {
                stopAnim();
                return;
            } else {
                bls();
                return;
            }
        }
        this.mHandler.postDelayed(this.eZu, 10L);
    }

    public void stopAnim() {
        if (this.eZr) {
            startAnim();
            return;
        }
        this.isPlaying = false;
        if (this.eZs != null) {
            this.eZs.onAnimEnd();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eZn != null) {
            this.eZo.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.eZn, this.srcRect, this.eZo, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.arR = bdUniqueId;
    }

    public void setOnFrameAnimationCallback(b bVar) {
        this.eZs = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<T, Bitmap, Bitmap> {
        private d eZw;

        private a(d dVar) {
            this.eZw = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(T... tArr) {
            if (tArr == null || tArr[0] == null) {
                return null;
            }
            return FrameAnimationView.this.eZt.aq(tArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.eZw != null) {
                this.eZw.q(bitmap);
            }
        }
    }
}

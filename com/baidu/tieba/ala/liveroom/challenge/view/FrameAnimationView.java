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
    private BdUniqueId aoz;
    private b eVA;
    private com.baidu.tieba.ala.liveroom.challenge.a.a eVB;
    private Runnable eVC;
    private T[] eVu;
    private Bitmap eVv;
    private Rect eVw;
    private long eVx;
    private long eVy;
    private boolean eVz;
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
        this.eVw = new Rect();
        this.eVx = 0L;
        this.eVC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.bjC();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.eVw = new Rect();
        this.eVx = 0L;
        this.eVC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.bjC();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.eVw = new Rect();
        this.eVx = 0L;
        this.eVC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.bjC();
            }
        };
    }

    public void startAnim() {
        if (this.mFrameCount > 0) {
            this.index = 0;
            this.eVx = 0L;
            a aVar = new a(this);
            aVar.setTag(this.aoz);
            aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
            aVar.execute(this.eVu[this.index]);
            this.isPlaying = true;
        }
    }

    private void bjB() {
        a aVar = new a(this);
        aVar.setTag(this.aoz);
        aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
        aVar.execute(this.eVu[this.index]);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.d
    public void q(Bitmap bitmap) {
        if (this.eVx <= 0) {
            this.eVx = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.eVv != null) {
                this.eVv.recycle();
            }
            this.eVv = bitmap;
            this.srcRect.set(0, 0, this.eVv.getWidth(), this.eVv.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        if (this.index == 0 && this.eVA != null) {
            this.eVA.onAnimStart();
        }
        this.index++;
        if (this.eVu == null || this.index >= this.eVu.length) {
            stopAnim();
        } else {
            bjC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjC() {
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.eVx) * this.mFrameCount) / this.eVy);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.eVu.length) {
                stopAnim();
                return;
            } else {
                bjB();
                return;
            }
        }
        this.mHandler.postDelayed(this.eVC, 10L);
    }

    public void stopAnim() {
        if (this.eVz) {
            startAnim();
            return;
        }
        this.isPlaying = false;
        if (this.eVA != null) {
            this.eVA.onAnimEnd();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eVv != null) {
            this.eVw.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.eVv, this.srcRect, this.eVw, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aoz = bdUniqueId;
    }

    public void setOnFrameAnimationCallback(b bVar) {
        this.eVA = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<T, Bitmap, Bitmap> {
        private d eVE;

        private a(d dVar) {
            this.eVE = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(T... tArr) {
            if (tArr == null || tArr[0] == null) {
                return null;
            }
            return FrameAnimationView.this.eVB.ao(tArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.eVE != null) {
                this.eVE.q(bitmap);
            }
        }
    }
}

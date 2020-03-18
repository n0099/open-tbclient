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
    private BdUniqueId asc;
    private T[] eZX;
    private Bitmap eZY;
    private Rect eZZ;
    private long faa;
    private long fab;
    private boolean fac;
    private b fad;
    private com.baidu.tieba.ala.liveroom.challenge.a.a fae;
    private Runnable faf;
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
        this.eZZ = new Rect();
        this.faa = 0L;
        this.faf = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blz();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.eZZ = new Rect();
        this.faa = 0L;
        this.faf = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blz();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.eZZ = new Rect();
        this.faa = 0L;
        this.faf = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blz();
            }
        };
    }

    public void startAnim() {
        if (this.mFrameCount > 0) {
            this.index = 0;
            this.faa = 0L;
            a aVar = new a(this);
            aVar.setTag(this.asc);
            aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
            aVar.execute(this.eZX[this.index]);
            this.isPlaying = true;
        }
    }

    private void bly() {
        a aVar = new a(this);
        aVar.setTag(this.asc);
        aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
        aVar.execute(this.eZX[this.index]);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.d
    public void q(Bitmap bitmap) {
        if (this.faa <= 0) {
            this.faa = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.eZY != null) {
                this.eZY.recycle();
            }
            this.eZY = bitmap;
            this.srcRect.set(0, 0, this.eZY.getWidth(), this.eZY.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        if (this.index == 0 && this.fad != null) {
            this.fad.onAnimStart();
        }
        this.index++;
        if (this.eZX == null || this.index >= this.eZX.length) {
            stopAnim();
        } else {
            blz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blz() {
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.faa) * this.mFrameCount) / this.fab);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.eZX.length) {
                stopAnim();
                return;
            } else {
                bly();
                return;
            }
        }
        this.mHandler.postDelayed(this.faf, 10L);
    }

    public void stopAnim() {
        if (this.fac) {
            startAnim();
            return;
        }
        this.isPlaying = false;
        if (this.fad != null) {
            this.fad.onAnimEnd();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eZY != null) {
            this.eZZ.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.eZY, this.srcRect, this.eZZ, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.asc = bdUniqueId;
    }

    public void setOnFrameAnimationCallback(b bVar) {
        this.fad = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<T, Bitmap, Bitmap> {
        private d fah;

        private a(d dVar) {
            this.fah = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(T... tArr) {
            if (tArr == null || tArr[0] == null) {
                return null;
            }
            return FrameAnimationView.this.fae.aq(tArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.fah != null) {
                this.fah.q(bitmap);
            }
        }
    }
}

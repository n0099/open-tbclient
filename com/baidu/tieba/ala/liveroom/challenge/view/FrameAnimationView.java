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
    private BdUniqueId arS;
    private Bitmap eZA;
    private Rect eZB;
    private long eZC;
    private long eZD;
    private boolean eZE;
    private b eZF;
    private com.baidu.tieba.ala.liveroom.challenge.a.a eZG;
    private Runnable eZH;
    private T[] eZz;
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
        this.eZB = new Rect();
        this.eZC = 0L;
        this.eZH = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blu();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.eZB = new Rect();
        this.eZC = 0L;
        this.eZH = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blu();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.eZB = new Rect();
        this.eZC = 0L;
        this.eZH = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.blu();
            }
        };
    }

    public void startAnim() {
        if (this.mFrameCount > 0) {
            this.index = 0;
            this.eZC = 0L;
            a aVar = new a(this);
            aVar.setTag(this.arS);
            aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
            aVar.execute(this.eZz[this.index]);
            this.isPlaying = true;
        }
    }

    private void blt() {
        a aVar = new a(this);
        aVar.setTag(this.arS);
        aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
        aVar.execute(this.eZz[this.index]);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.d
    public void q(Bitmap bitmap) {
        if (this.eZC <= 0) {
            this.eZC = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.eZA != null) {
                this.eZA.recycle();
            }
            this.eZA = bitmap;
            this.srcRect.set(0, 0, this.eZA.getWidth(), this.eZA.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        if (this.index == 0 && this.eZF != null) {
            this.eZF.onAnimStart();
        }
        this.index++;
        if (this.eZz == null || this.index >= this.eZz.length) {
            stopAnim();
        } else {
            blu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blu() {
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.eZC) * this.mFrameCount) / this.eZD);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.eZz.length) {
                stopAnim();
                return;
            } else {
                blt();
                return;
            }
        }
        this.mHandler.postDelayed(this.eZH, 10L);
    }

    public void stopAnim() {
        if (this.eZE) {
            startAnim();
            return;
        }
        this.isPlaying = false;
        if (this.eZF != null) {
            this.eZF.onAnimEnd();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eZA != null) {
            this.eZB.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.eZA, this.srcRect, this.eZB, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.arS = bdUniqueId;
    }

    public void setOnFrameAnimationCallback(b bVar) {
        this.eZF = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<T, Bitmap, Bitmap> {
        private d eZJ;

        private a(d dVar) {
            this.eZJ = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(T... tArr) {
            if (tArr == null || tArr[0] == null) {
                return null;
            }
            return FrameAnimationView.this.eZG.aq(tArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.eZJ != null) {
                this.eZJ.q(bitmap);
            }
        }
    }
}

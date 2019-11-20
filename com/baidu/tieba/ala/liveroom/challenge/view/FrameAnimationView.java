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
/* loaded from: classes6.dex */
public class FrameAnimationView<T> extends ImageView implements d {
    private BdUniqueId afK;
    private boolean aiJ;
    private T[] edR;
    private Bitmap edS;
    private Rect edT;
    private long edU;
    private long edV;
    private boolean edW;
    private b edX;
    private com.baidu.tieba.ala.liveroom.challenge.a.b edY;
    private Runnable edZ;
    private int index;
    private int mFrameCount;
    private Handler mHandler;
    private Rect srcRect;

    /* loaded from: classes6.dex */
    public interface b {
        void aQZ();

        void aRa();
    }

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.srcRect = new Rect();
        this.edT = new Rect();
        this.edU = 0L;
        this.edZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.aRp();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.edT = new Rect();
        this.edU = 0L;
        this.edZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.aRp();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.edT = new Rect();
        this.edU = 0L;
        this.edZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.aRp();
            }
        };
    }

    public void a(T[] tArr, int i, boolean z, com.baidu.tieba.ala.liveroom.challenge.a.b bVar) {
        this.edR = tArr;
        if (this.edR != null) {
            this.mFrameCount = this.edR.length;
        }
        this.edV = i;
        this.edW = z;
        this.edY = bVar;
        this.mHandler = new Handler();
    }

    public void startAnim() {
        if (this.mFrameCount > 0) {
            this.index = 0;
            this.edU = 0L;
            a aVar = new a(this);
            aVar.setTag(this.afK);
            aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
            aVar.execute(this.edR[this.index]);
            this.aiJ = true;
        }
    }

    private void aRo() {
        a aVar = new a(this);
        aVar.setTag(this.afK);
        aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
        aVar.execute(this.edR[this.index]);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.d
    public void q(Bitmap bitmap) {
        if (this.edU <= 0) {
            this.edU = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.edS != null) {
                this.edS.recycle();
            }
            this.edS = bitmap;
            this.srcRect.set(0, 0, this.edS.getWidth(), this.edS.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        if (this.index == 0 && this.edX != null) {
            this.edX.aQZ();
        }
        this.index++;
        if (this.edR == null || this.index >= this.edR.length) {
            stopAnim();
        } else {
            aRp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRp() {
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.edU) * this.mFrameCount) / this.edV);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.edR.length) {
                stopAnim();
                return;
            } else {
                aRo();
                return;
            }
        }
        this.mHandler.postDelayed(this.edZ, 10L);
    }

    public void stopAnim() {
        if (this.edW) {
            startAnim();
            return;
        }
        this.aiJ = false;
        if (this.edX != null) {
            this.edX.aRa();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.edS != null) {
            this.edT.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.edS, this.srcRect, this.edT, (Paint) null);
        }
    }

    public void release() {
        if (this.edS != null) {
            this.edS.recycle();
            this.edS = null;
        }
        this.edR = null;
        this.edU = 0L;
        this.mFrameCount = 0;
        this.edX = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        BdAsyncTask.removeAllTask(this.afK, "FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.afK = bdUniqueId;
    }

    public void setOnFrameAnimationCallback(b bVar) {
        this.edX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<T, Bitmap, Bitmap> {
        private d eeb;

        private a(d dVar) {
            this.eeb = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(T... tArr) {
            if (tArr == null || tArr[0] == null) {
                return null;
            }
            return FrameAnimationView.this.edY.ai(tArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.eeb != null) {
                this.eeb.q(bitmap);
            }
        }
    }
}

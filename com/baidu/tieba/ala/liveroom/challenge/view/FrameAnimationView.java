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
    private BdUniqueId aQF;
    private T[] fEl;
    private Bitmap fEm;
    private Rect fEn;
    private long fEo;
    private long fEp;
    private boolean fEq;
    private b fEr;
    private com.baidu.tieba.ala.liveroom.challenge.a.a fEs;
    private Runnable fEt;
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
        this.fEn = new Rect();
        this.fEo = 0L;
        this.fEt = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.buS();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.fEn = new Rect();
        this.fEo = 0L;
        this.fEt = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.buS();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.fEn = new Rect();
        this.fEo = 0L;
        this.fEt = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.buS();
            }
        };
    }

    public void startAnim() {
        if (this.mFrameCount > 0) {
            this.index = 0;
            this.fEo = 0L;
            a aVar = new a(this);
            aVar.setTag(this.aQF);
            aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
            aVar.execute(this.fEl[this.index]);
            this.isPlaying = true;
        }
    }

    private void buR() {
        a aVar = new a(this);
        aVar.setTag(this.aQF);
        aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
        aVar.execute(this.fEl[this.index]);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.d
    public void s(Bitmap bitmap) {
        if (this.fEo <= 0) {
            this.fEo = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.fEm != null) {
                this.fEm.recycle();
            }
            this.fEm = bitmap;
            this.srcRect.set(0, 0, this.fEm.getWidth(), this.fEm.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        if (this.index == 0 && this.fEr != null) {
            this.fEr.onAnimStart();
        }
        this.index++;
        if (this.fEl == null || this.index >= this.fEl.length) {
            stopAnim();
        } else {
            buS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buS() {
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.fEo) * this.mFrameCount) / this.fEp);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.fEl.length) {
                stopAnim();
                return;
            } else {
                buR();
                return;
            }
        }
        this.mHandler.postDelayed(this.fEt, 10L);
    }

    public void stopAnim() {
        if (this.fEq) {
            startAnim();
            return;
        }
        this.isPlaying = false;
        if (this.fEr != null) {
            this.fEr.onAnimEnd();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fEm != null) {
            this.fEn.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.fEm, this.srcRect, this.fEn, (Paint) null);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aQF = bdUniqueId;
    }

    public void setOnFrameAnimationCallback(b bVar) {
        this.fEr = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<T, Bitmap, Bitmap> {
        private d fEv;

        private a(d dVar) {
            this.fEv = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(T... tArr) {
            if (tArr == null || tArr[0] == null) {
                return null;
            }
            return FrameAnimationView.this.fEs.as(tArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.fEv != null) {
                this.fEv.s(bitmap);
            }
        }
    }
}

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
    private BdUniqueId agc;
    private boolean ajb;
    private T[] eeI;
    private Bitmap eeJ;
    private Rect eeK;
    private long eeL;
    private long eeM;
    private boolean eeN;
    private b eeO;
    private com.baidu.tieba.ala.liveroom.challenge.a.b eeP;
    private Runnable eeQ;
    private int index;
    private int mFrameCount;
    private Handler mHandler;
    private Rect srcRect;

    /* loaded from: classes6.dex */
    public interface b {
        void aRb();

        void aRc();
    }

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.srcRect = new Rect();
        this.eeK = new Rect();
        this.eeL = 0L;
        this.eeQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.aRr();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.eeK = new Rect();
        this.eeL = 0L;
        this.eeQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.aRr();
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.eeK = new Rect();
        this.eeL = 0L;
        this.eeQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationView.this.aRr();
            }
        };
    }

    public void a(T[] tArr, int i, boolean z, com.baidu.tieba.ala.liveroom.challenge.a.b bVar) {
        this.eeI = tArr;
        if (this.eeI != null) {
            this.mFrameCount = this.eeI.length;
        }
        this.eeM = i;
        this.eeN = z;
        this.eeP = bVar;
        this.mHandler = new Handler();
    }

    public void startAnim() {
        if (this.mFrameCount > 0) {
            this.index = 0;
            this.eeL = 0L;
            a aVar = new a(this);
            aVar.setTag(this.agc);
            aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
            aVar.execute(this.eeI[this.index]);
            this.ajb = true;
        }
    }

    private void aRq() {
        a aVar = new a(this);
        aVar.setTag(this.agc);
        aVar.setKey("FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
        aVar.execute(this.eeI[this.index]);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.d
    public void q(Bitmap bitmap) {
        if (this.eeL <= 0) {
            this.eeL = System.currentTimeMillis();
        }
        if (bitmap != null) {
            if (this.eeJ != null) {
                this.eeJ.recycle();
            }
            this.eeJ = bitmap;
            this.srcRect.set(0, 0, this.eeJ.getWidth(), this.eeJ.getHeight());
            invalidate();
        } else {
            invalidate();
        }
        if (this.index == 0 && this.eeO != null) {
            this.eeO.aRb();
        }
        this.index++;
        if (this.eeI == null || this.index >= this.eeI.length) {
            stopAnim();
        } else {
            aRr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRr() {
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.eeL) * this.mFrameCount) / this.eeM);
        if (currentTimeMillis > this.index) {
            this.index = currentTimeMillis;
            if (this.index >= this.eeI.length) {
                stopAnim();
                return;
            } else {
                aRq();
                return;
            }
        }
        this.mHandler.postDelayed(this.eeQ, 10L);
    }

    public void stopAnim() {
        if (this.eeN) {
            startAnim();
            return;
        }
        this.ajb = false;
        if (this.eeO != null) {
            this.eeO.aRc();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eeJ != null) {
            this.eeK.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.eeJ, this.srcRect, this.eeK, (Paint) null);
        }
    }

    public void release() {
        if (this.eeJ != null) {
            this.eeJ.recycle();
            this.eeJ = null;
        }
        this.eeI = null;
        this.eeL = 0L;
        this.mFrameCount = 0;
        this.eeO = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        BdAsyncTask.removeAllTask(this.agc, "FRAMEANIMATIONVIEW_ASYNCTASK_KEY");
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.agc = bdUniqueId;
    }

    public void setOnFrameAnimationCallback(b bVar) {
        this.eeO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<T, Bitmap, Bitmap> {
        private d eeS;

        private a(d dVar) {
            this.eeS = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(T... tArr) {
            if (tArr == null || tArr[0] == null) {
                return null;
            }
            return FrameAnimationView.this.eeP.ai(tArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (this.eeS != null) {
                this.eeS.q(bitmap);
            }
        }
    }
}

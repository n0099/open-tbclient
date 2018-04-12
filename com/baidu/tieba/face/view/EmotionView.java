package com.baidu.tieba.face.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float bTq;
    private EmotionPreview cKA;
    private FrameLayout cKB;
    private long cKC;
    private boolean cKD;
    private boolean cKE;
    private float cKF;
    private int cKG;
    private a cKH;
    private EmotionImageData cKz;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean alC();

        void alF();

        void alG();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cKG = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKG = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKG = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.e(getContext(), d.e.ds240);
        this.mPreviewHeight = l.e(getContext(), d.e.ds260);
        this.cKF = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cKz;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cKz = emotionImageData;
            setTag(this.cKz.getThumbUrl());
            if (this.cKG == 20) {
                b(this.cKz);
            } else {
                startLoad(this.cKz.getThumbUrl(), this.cKG, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cKz = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.fp().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                if (aVar != null) {
                    EmotionView.this.mIsGif = aVar.isGif();
                    View findViewWithTag = EmotionView.this.findViewWithTag(str);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                        TbImageView tbImageView = (TbImageView) findViewWithTag;
                        aVar.a(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
            }
        }, 0, 0, null, null, emotionImageData.getThumbUrl(), false, null);
        com.baidu.adp.widget.ImageView.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.ImageView.a)) ? null : (com.baidu.adp.widget.ImageView.a) a2;
        if (aVar != null) {
            aVar.a(this);
            setTag(null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void alB() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cKD = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bTq = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bTq;
                        EmotionView.this.cKC = System.currentTimeMillis();
                        if (EmotionView.this.alC()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cKC), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cKD = false;
                        if (EmotionView.this.cKE) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cKD = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cKH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alC() {
        return this.cKH == null || this.cKH.alC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cKH == null || this.cKH.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cKJ;

        public b(long j) {
            this.cKJ = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cKD && this.cKJ == EmotionView.this.cKC && EmotionView.this.alD()) {
                EmotionView.this.alE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alD() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.cKF && Math.abs(this.mCurrentY - this.bTq) < this.cKF;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alE() {
        if (!this.cKE && alC() && this.cKz != null && !TextUtils.isEmpty(this.cKz.getPicUrl())) {
            if (this.cKH != null) {
                this.cKH.alF();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cKA == null) {
                this.cKA = new EmotionPreview(getContext());
            }
            this.cKA.a(this.cKz.getPicUrl(), this.cKz.getThumbUrl(), this.mIsGif, this.cKG);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.af(getContext())) {
                layoutParams.leftMargin = l.af(getContext()) - this.mPreviewWidth;
            }
            if (this.cKB == null) {
                this.cKB = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cKA.getParent() != null && this.cKA.getParent() == this.cKB) {
                this.cKB.removeView(this.cKA);
            }
            this.cKB.addView(this.cKA, layoutParams);
            this.cKE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cKA != null && this.cKE) {
            if (this.cKH != null) {
                this.cKH.alG();
            }
            if (this.cKA.getParent() != null && this.cKA.getParent() == this.cKB) {
                this.cKB.removeView(this.cKA);
            }
            this.cKE = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cKG = i;
    }

    public int getLoadProcType() {
        return this.cKG;
    }
}

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
    private float bTm;
    private boolean cKA;
    private boolean cKB;
    private float cKC;
    private int cKD;
    private a cKE;
    private EmotionImageData cKw;
    private EmotionPreview cKx;
    private FrameLayout cKy;
    private long cKz;
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
        this.cKD = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKD = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKD = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.e(getContext(), d.e.ds240);
        this.mPreviewHeight = l.e(getContext(), d.e.ds260);
        this.cKC = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cKw;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cKw = emotionImageData;
            setTag(this.cKw.getThumbUrl());
            if (this.cKD == 20) {
                b(this.cKw);
            } else {
                startLoad(this.cKw.getThumbUrl(), this.cKD, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cKw = null;
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
                        EmotionView.this.cKA = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bTm = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bTm;
                        EmotionView.this.cKz = System.currentTimeMillis();
                        if (EmotionView.this.alC()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cKz), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cKA = false;
                        if (EmotionView.this.cKB) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cKA = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cKE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alC() {
        return this.cKE == null || this.cKE.alC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cKE == null || this.cKE.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cKG;

        public b(long j) {
            this.cKG = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cKA && this.cKG == EmotionView.this.cKz && EmotionView.this.alD()) {
                EmotionView.this.alE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alD() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.cKC && Math.abs(this.mCurrentY - this.bTm) < this.cKC;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alE() {
        if (!this.cKB && alC() && this.cKw != null && !TextUtils.isEmpty(this.cKw.getPicUrl())) {
            if (this.cKE != null) {
                this.cKE.alF();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cKx == null) {
                this.cKx = new EmotionPreview(getContext());
            }
            this.cKx.a(this.cKw.getPicUrl(), this.cKw.getThumbUrl(), this.mIsGif, this.cKD);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.af(getContext())) {
                layoutParams.leftMargin = l.af(getContext()) - this.mPreviewWidth;
            }
            if (this.cKy == null) {
                this.cKy = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cKx.getParent() != null && this.cKx.getParent() == this.cKy) {
                this.cKy.removeView(this.cKx);
            }
            this.cKy.addView(this.cKx, layoutParams);
            this.cKB = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cKx != null && this.cKB) {
            if (this.cKE != null) {
                this.cKE.alG();
            }
            if (this.cKx.getParent() != null && this.cKx.getParent() == this.cKy) {
                this.cKy.removeView(this.cKx);
            }
            this.cKB = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cKD = i;
    }

    public int getLoadProcType() {
        return this.cKD;
    }
}

package com.baidu.tieba.face.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float Hh;
    private View.OnClickListener aYY;
    private float buu;
    private EmotionImageData cbC;
    private com.baidu.tieba.face.view.a cbD;
    private FrameLayout cbE;
    private long cbF;
    private boolean cbG;
    private boolean cbH;
    private boolean cbI;
    private float cbJ;
    private int cbK;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    public EmotionView(Context context) {
        super(context);
        this.cbI = true;
        this.cbK = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbI = true;
        this.cbK = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cbI = true;
        this.cbK = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = k.g(getContext(), d.f.ds240);
        this.mPreviewHeight = k.g(getContext(), d.f.ds260);
        this.cbJ = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cbC = emotionImageData;
            setTag(this.cbC.getThumbUrl());
            if (this.cbK == 20) {
                b(this.cbC);
            } else {
                c(this.cbC.getThumbUrl(), this.cbK, false);
            }
        }
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.fU().a(emotionImageData.getThumbUrl(), 20, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                if (aVar != null) {
                    EmotionView.this.tK = aVar.isGif();
                    View findViewWithTag = EmotionView.this.findViewWithTag(str);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                        TbImageView tbImageView = (TbImageView) findViewWithTag;
                        aVar.e(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
            }
        }, 0, 0, null, null, emotionImageData.getThumbUrl(), false, null);
        com.baidu.adp.widget.a.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a2;
        if (aVar != null) {
            aVar.e(this);
            setTag(null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.aYY = onClickListener;
    }

    public void acP() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (EmotionView.this.cbI) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            EmotionView.this.cbG = true;
                            EmotionView.this.Hh = motionEvent.getRawX();
                            EmotionView.this.buu = motionEvent.getRawY();
                            EmotionView.this.mCurrentX = EmotionView.this.Hh;
                            EmotionView.this.mCurrentY = EmotionView.this.buu;
                            EmotionView.this.cbF = System.currentTimeMillis();
                            EmotionView.this.postDelayed(new a(EmotionView.this.cbF), 500L);
                            return true;
                        case 1:
                            EmotionView.this.cbG = false;
                            if (EmotionView.this.cbH) {
                                EmotionView.this.stopPreview();
                                return true;
                            } else if (EmotionView.this.aYY != null) {
                                EmotionView.this.aYY.onClick(EmotionView.this);
                                return true;
                            } else {
                                return true;
                            }
                        case 2:
                        default:
                            return true;
                        case 3:
                            EmotionView.this.cbG = false;
                            EmotionView.this.stopPreview();
                            return true;
                    }
                }
                return false;
            }
        });
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        private long cbM;

        public a(long j) {
            this.cbM = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cbG && this.cbM == EmotionView.this.cbF && EmotionView.this.acQ()) {
                EmotionView.this.acR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acQ() {
        return Math.abs(this.mCurrentX - this.Hh) < this.cbJ && Math.abs(this.mCurrentY - this.buu) < this.cbJ;
    }

    public void h(float f, float f2) {
        this.mCurrentX = f;
        this.mCurrentY = f2;
    }

    public boolean getIsGif() {
        return this.tK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acR() {
        if (!this.cbH && this.cbI && this.cbC != null && !TextUtils.isEmpty(this.cbC.getPicUrl())) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cbD == null) {
                this.cbD = new com.baidu.tieba.face.view.a(getContext());
            }
            this.cbD.a(this.cbC.getPicUrl(), this.cbC.getThumbUrl(), this.tK, this.cbK);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > k.ag(getContext())) {
                layoutParams.leftMargin = k.ag(getContext()) - this.mPreviewWidth;
            }
            if (this.cbE == null) {
                this.cbE = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cbD.getParent() != null && this.cbD.getParent() == this.cbE) {
                this.cbE.removeView(this.cbD);
            }
            this.cbE.addView(this.cbD, layoutParams);
            this.cbH = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cbD != null) {
            if (this.cbD.getParent() != null && this.cbD.getParent() == this.cbE) {
                this.cbE.removeView(this.cbD);
            }
            this.cbH = false;
        }
    }

    public void setCanShowPreview(boolean z) {
        this.cbI = z;
        if (!this.cbI) {
            stopPreview();
        }
    }

    public void setLoadProcType(int i) {
        this.cbK = i;
    }

    public int getLoadProcType() {
        return this.cbK;
    }
}

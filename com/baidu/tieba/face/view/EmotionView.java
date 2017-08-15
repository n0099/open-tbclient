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
    private View.OnClickListener aYX;
    private float but;
    private EmotionImageData cbB;
    private com.baidu.tieba.face.view.a cbC;
    private FrameLayout cbD;
    private long cbE;
    private boolean cbF;
    private boolean cbG;
    private boolean cbH;
    private float cbI;
    private int cbJ;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    public EmotionView(Context context) {
        super(context);
        this.cbH = true;
        this.cbJ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbH = true;
        this.cbJ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cbH = true;
        this.cbJ = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = k.g(getContext(), d.f.ds240);
        this.mPreviewHeight = k.g(getContext(), d.f.ds260);
        this.cbI = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cbB = emotionImageData;
            setTag(this.cbB.getThumbUrl());
            if (this.cbJ == 20) {
                b(this.cbB);
            } else {
                c(this.cbB.getThumbUrl(), this.cbJ, false);
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
        this.aYX = onClickListener;
    }

    public void acT() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (EmotionView.this.cbH) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            EmotionView.this.cbF = true;
                            EmotionView.this.Hh = motionEvent.getRawX();
                            EmotionView.this.but = motionEvent.getRawY();
                            EmotionView.this.mCurrentX = EmotionView.this.Hh;
                            EmotionView.this.mCurrentY = EmotionView.this.but;
                            EmotionView.this.cbE = System.currentTimeMillis();
                            EmotionView.this.postDelayed(new a(EmotionView.this.cbE), 500L);
                            return true;
                        case 1:
                            EmotionView.this.cbF = false;
                            if (EmotionView.this.cbG) {
                                EmotionView.this.stopPreview();
                                return true;
                            } else if (EmotionView.this.aYX != null) {
                                EmotionView.this.aYX.onClick(EmotionView.this);
                                return true;
                            } else {
                                return true;
                            }
                        case 2:
                        default:
                            return true;
                        case 3:
                            EmotionView.this.cbF = false;
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
        private long cbL;

        public a(long j) {
            this.cbL = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cbF && this.cbL == EmotionView.this.cbE && EmotionView.this.acU()) {
                EmotionView.this.acV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acU() {
        return Math.abs(this.mCurrentX - this.Hh) < this.cbI && Math.abs(this.mCurrentY - this.but) < this.cbI;
    }

    public void h(float f, float f2) {
        this.mCurrentX = f;
        this.mCurrentY = f2;
    }

    public boolean getIsGif() {
        return this.tK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acV() {
        if (!this.cbG && this.cbH && this.cbB != null && !TextUtils.isEmpty(this.cbB.getPicUrl())) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cbC == null) {
                this.cbC = new com.baidu.tieba.face.view.a(getContext());
            }
            this.cbC.a(this.cbB.getPicUrl(), this.cbB.getThumbUrl(), this.tK, this.cbJ);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > k.ag(getContext())) {
                layoutParams.leftMargin = k.ag(getContext()) - this.mPreviewWidth;
            }
            if (this.cbD == null) {
                this.cbD = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cbC.getParent() != null && this.cbC.getParent() == this.cbD) {
                this.cbD.removeView(this.cbC);
            }
            this.cbD.addView(this.cbC, layoutParams);
            this.cbG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cbC != null) {
            if (this.cbC.getParent() != null && this.cbC.getParent() == this.cbD) {
                this.cbD.removeView(this.cbC);
            }
            this.cbG = false;
        }
    }

    public void setCanShowPreview(boolean z) {
        this.cbH = z;
        if (!this.cbH) {
            stopPreview();
        }
    }

    public void setLoadProcType(int i) {
        this.cbJ = i;
    }

    public int getLoadProcType() {
        return this.cbJ;
    }
}

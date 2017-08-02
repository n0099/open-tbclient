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
    private float FG;
    private View.OnClickListener aXL;
    private EmotionImageData bZJ;
    private com.baidu.tieba.face.view.a bZK;
    private FrameLayout bZL;
    private long bZM;
    private boolean bZN;
    private boolean bZO;
    private boolean bZP;
    private float bZQ;
    private int bZR;
    private float bsT;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    public EmotionView(Context context) {
        super(context);
        this.bZP = true;
        this.bZR = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZP = true;
        this.bZR = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZP = true;
        this.bZR = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = k.g(getContext(), d.f.ds240);
        this.mPreviewHeight = k.g(getContext(), d.f.ds260);
        this.bZQ = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.bZJ = emotionImageData;
            setTag(this.bZJ.getThumbUrl());
            if (this.bZR == 20) {
                b(this.bZJ);
            } else {
                c(this.bZJ.getThumbUrl(), this.bZR, false);
            }
        }
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.fJ().a(emotionImageData.getThumbUrl(), 20, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                if (aVar != null) {
                    EmotionView.this.sa = aVar.isGif();
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
        this.aXL = onClickListener;
    }

    public void act() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (EmotionView.this.bZP) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            EmotionView.this.bZN = true;
                            EmotionView.this.FG = motionEvent.getRawX();
                            EmotionView.this.bsT = motionEvent.getRawY();
                            EmotionView.this.mCurrentX = EmotionView.this.FG;
                            EmotionView.this.mCurrentY = EmotionView.this.bsT;
                            EmotionView.this.bZM = System.currentTimeMillis();
                            EmotionView.this.postDelayed(new a(EmotionView.this.bZM), 500L);
                            return true;
                        case 1:
                            EmotionView.this.bZN = false;
                            if (EmotionView.this.bZO) {
                                EmotionView.this.stopPreview();
                                return true;
                            } else if (EmotionView.this.aXL != null) {
                                EmotionView.this.aXL.onClick(EmotionView.this);
                                return true;
                            } else {
                                return true;
                            }
                        case 2:
                        default:
                            return true;
                        case 3:
                            EmotionView.this.bZN = false;
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
        private long bZT;

        public a(long j) {
            this.bZT = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.bZN && this.bZT == EmotionView.this.bZM && EmotionView.this.acu()) {
                EmotionView.this.acv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acu() {
        return Math.abs(this.mCurrentX - this.FG) < this.bZQ && Math.abs(this.mCurrentY - this.bsT) < this.bZQ;
    }

    public void h(float f, float f2) {
        this.mCurrentX = f;
        this.mCurrentY = f2;
    }

    public boolean getIsGif() {
        return this.sa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acv() {
        if (!this.bZO && this.bZP && this.bZJ != null && !TextUtils.isEmpty(this.bZJ.getPicUrl())) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.bZK == null) {
                this.bZK = new com.baidu.tieba.face.view.a(getContext());
            }
            this.bZK.a(this.bZJ.getPicUrl(), this.bZJ.getThumbUrl(), this.sa, this.bZR);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > k.af(getContext())) {
                layoutParams.leftMargin = k.af(getContext()) - this.mPreviewWidth;
            }
            if (this.bZL == null) {
                this.bZL = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.bZK.getParent() != null && this.bZK.getParent() == this.bZL) {
                this.bZL.removeView(this.bZK);
            }
            this.bZL.addView(this.bZK, layoutParams);
            this.bZO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.bZK != null) {
            if (this.bZK.getParent() != null && this.bZK.getParent() == this.bZL) {
                this.bZL.removeView(this.bZK);
            }
            this.bZO = false;
        }
    }

    public void setCanShowPreview(boolean z) {
        this.bZP = z;
        if (!this.bZP) {
            stopPreview();
        }
    }

    public void setLoadProcType(int i) {
        this.bZR = i;
    }

    public int getLoadProcType() {
        return this.bZR;
    }
}

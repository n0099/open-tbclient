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
    private float Hf;
    private View.OnClickListener aYW;
    private float bue;
    private EmotionImageData caP;
    private com.baidu.tieba.face.view.a caQ;
    private FrameLayout caR;
    private long caS;
    private boolean caT;
    private boolean caU;
    private boolean caV;
    private float caW;
    private int caX;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    public EmotionView(Context context) {
        super(context);
        this.caV = true;
        this.caX = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.caV = true;
        this.caX = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.caV = true;
        this.caX = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = k.g(getContext(), d.f.ds240);
        this.mPreviewHeight = k.g(getContext(), d.f.ds260);
        this.caW = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.caP = emotionImageData;
            setTag(this.caP.getThumbUrl());
            if (this.caX == 20) {
                b(this.caP);
            } else {
                c(this.caP.getThumbUrl(), this.caX, false);
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
                    EmotionView.this.tI = aVar.isGif();
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
        this.aYW = onClickListener;
    }

    public void acy() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (EmotionView.this.caV) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            EmotionView.this.caT = true;
                            EmotionView.this.Hf = motionEvent.getRawX();
                            EmotionView.this.bue = motionEvent.getRawY();
                            EmotionView.this.mCurrentX = EmotionView.this.Hf;
                            EmotionView.this.mCurrentY = EmotionView.this.bue;
                            EmotionView.this.caS = System.currentTimeMillis();
                            EmotionView.this.postDelayed(new a(EmotionView.this.caS), 500L);
                            return true;
                        case 1:
                            EmotionView.this.caT = false;
                            if (EmotionView.this.caU) {
                                EmotionView.this.stopPreview();
                                return true;
                            } else if (EmotionView.this.aYW != null) {
                                EmotionView.this.aYW.onClick(EmotionView.this);
                                return true;
                            } else {
                                return true;
                            }
                        case 2:
                        default:
                            return true;
                        case 3:
                            EmotionView.this.caT = false;
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
        private long caZ;

        public a(long j) {
            this.caZ = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.caT && this.caZ == EmotionView.this.caS && EmotionView.this.acz()) {
                EmotionView.this.acA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acz() {
        return Math.abs(this.mCurrentX - this.Hf) < this.caW && Math.abs(this.mCurrentY - this.bue) < this.caW;
    }

    public void h(float f, float f2) {
        this.mCurrentX = f;
        this.mCurrentY = f2;
    }

    public boolean getIsGif() {
        return this.tI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acA() {
        if (!this.caU && this.caV && this.caP != null && !TextUtils.isEmpty(this.caP.getPicUrl())) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.caQ == null) {
                this.caQ = new com.baidu.tieba.face.view.a(getContext());
            }
            this.caQ.a(this.caP.getPicUrl(), this.caP.getThumbUrl(), this.tI, this.caX);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > k.ag(getContext())) {
                layoutParams.leftMargin = k.ag(getContext()) - this.mPreviewWidth;
            }
            if (this.caR == null) {
                this.caR = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.caQ.getParent() != null && this.caQ.getParent() == this.caR) {
                this.caR.removeView(this.caQ);
            }
            this.caR.addView(this.caQ, layoutParams);
            this.caU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.caQ != null) {
            if (this.caQ.getParent() != null && this.caQ.getParent() == this.caR) {
                this.caR.removeView(this.caQ);
            }
            this.caU = false;
        }
    }

    public void setCanShowPreview(boolean z) {
        this.caV = z;
        if (!this.caV) {
            stopPreview();
        }
    }

    public void setLoadProcType(int i) {
        this.caX = i;
    }

    public int getLoadProcType() {
        return this.caX;
    }
}

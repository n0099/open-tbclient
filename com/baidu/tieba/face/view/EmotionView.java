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
    private float Fb;
    private View.OnClickListener aYK;
    private float bvg;
    private float ceA;
    private int ceB;
    private EmotionImageData cet;
    private com.baidu.tieba.face.view.a ceu;
    private FrameLayout cev;
    private long cew;
    private boolean cex;
    private boolean cey;
    private boolean cez;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    public EmotionView(Context context) {
        super(context);
        this.cez = true;
        this.ceB = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cez = true;
        this.ceB = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cez = true;
        this.ceB = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = k.g(getContext(), d.f.ds240);
        this.mPreviewHeight = k.g(getContext(), d.f.ds260);
        this.ceA = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cet = emotionImageData;
            setTag(this.cet.getThumbUrl());
            if (this.ceB == 20) {
                b(this.cet);
            } else {
                c(this.cet.getThumbUrl(), this.ceB, false);
            }
        }
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.fK().a(emotionImageData.getThumbUrl(), 20, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                if (aVar != null) {
                    EmotionView.this.rw = aVar.isGif();
                    View findViewWithTag = EmotionView.this.findViewWithTag(str);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                        TbImageView tbImageView = (TbImageView) findViewWithTag;
                        aVar.a(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
            }
        }, 0, 0, null, null, emotionImageData.getThumbUrl(), false, null);
        com.baidu.adp.widget.a.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a2;
        if (aVar != null) {
            aVar.a(this);
            setTag(null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.aYK = onClickListener;
    }

    public void adN() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (EmotionView.this.cez) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            EmotionView.this.cex = true;
                            EmotionView.this.Fb = motionEvent.getRawX();
                            EmotionView.this.bvg = motionEvent.getRawY();
                            EmotionView.this.mCurrentX = EmotionView.this.Fb;
                            EmotionView.this.mCurrentY = EmotionView.this.bvg;
                            EmotionView.this.cew = System.currentTimeMillis();
                            EmotionView.this.postDelayed(new a(EmotionView.this.cew), 500L);
                            return true;
                        case 1:
                            EmotionView.this.cex = false;
                            if (EmotionView.this.cey) {
                                EmotionView.this.stopPreview();
                                return true;
                            } else if (EmotionView.this.aYK != null) {
                                EmotionView.this.aYK.onClick(EmotionView.this);
                                return true;
                            } else {
                                return true;
                            }
                        case 2:
                        default:
                            return true;
                        case 3:
                            EmotionView.this.cex = false;
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
        private long ceD;

        public a(long j) {
            this.ceD = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cex && this.ceD == EmotionView.this.cew && EmotionView.this.adO()) {
                EmotionView.this.adP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adO() {
        return Math.abs(this.mCurrentX - this.Fb) < this.ceA && Math.abs(this.mCurrentY - this.bvg) < this.ceA;
    }

    public void g(float f, float f2) {
        this.mCurrentX = f;
        this.mCurrentY = f2;
    }

    public boolean getIsGif() {
        return this.rw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adP() {
        if (!this.cey && this.cez && this.cet != null && !TextUtils.isEmpty(this.cet.getPicUrl())) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.ceu == null) {
                this.ceu = new com.baidu.tieba.face.view.a(getContext());
            }
            this.ceu.a(this.cet.getPicUrl(), this.cet.getThumbUrl(), this.rw, this.ceB);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > k.ad(getContext())) {
                layoutParams.leftMargin = k.ad(getContext()) - this.mPreviewWidth;
            }
            if (this.cev == null) {
                this.cev = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.ceu.getParent() != null && this.ceu.getParent() == this.cev) {
                this.cev.removeView(this.ceu);
            }
            this.cev.addView(this.ceu, layoutParams);
            this.cey = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.ceu != null) {
            if (this.ceu.getParent() != null && this.ceu.getParent() == this.cev) {
                this.cev.removeView(this.ceu);
            }
            this.cey = false;
        }
    }

    public void setCanShowPreview(boolean z) {
        this.cez = z;
        if (!this.cez) {
            stopPreview();
        }
    }

    public void setLoadProcType(int i) {
        this.ceB = i;
    }

    public int getLoadProcType() {
        return this.ceB;
    }
}

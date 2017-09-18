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
    private View.OnClickListener aYH;
    private float bvU;
    private EmotionImageData cfl;
    private com.baidu.tieba.face.view.a cfm;
    private FrameLayout cfn;
    private long cfo;
    private boolean cfp;
    private boolean cfq;
    private boolean cfr;
    private float cfs;
    private int cft;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    public EmotionView(Context context) {
        super(context);
        this.cfr = true;
        this.cft = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cfr = true;
        this.cft = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cfr = true;
        this.cft = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = k.f(getContext(), d.f.ds240);
        this.mPreviewHeight = k.f(getContext(), d.f.ds260);
        this.cfs = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cfl = emotionImageData;
            setTag(this.cfl.getThumbUrl());
            if (this.cft == 20) {
                b(this.cfl);
            } else {
                c(this.cfl.getThumbUrl(), this.cft, false);
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
        this.aYH = onClickListener;
    }

    public void adY() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (EmotionView.this.cfr) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            EmotionView.this.cfp = true;
                            EmotionView.this.Fb = motionEvent.getRawX();
                            EmotionView.this.bvU = motionEvent.getRawY();
                            EmotionView.this.mCurrentX = EmotionView.this.Fb;
                            EmotionView.this.mCurrentY = EmotionView.this.bvU;
                            EmotionView.this.cfo = System.currentTimeMillis();
                            EmotionView.this.postDelayed(new a(EmotionView.this.cfo), 500L);
                            return true;
                        case 1:
                            EmotionView.this.cfp = false;
                            if (EmotionView.this.cfq) {
                                EmotionView.this.stopPreview();
                                return true;
                            } else if (EmotionView.this.aYH != null) {
                                EmotionView.this.aYH.onClick(EmotionView.this);
                                return true;
                            } else {
                                return true;
                            }
                        case 2:
                        default:
                            return true;
                        case 3:
                            EmotionView.this.cfp = false;
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
        private long cfv;

        public a(long j) {
            this.cfv = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cfp && this.cfv == EmotionView.this.cfo && EmotionView.this.adZ()) {
                EmotionView.this.aea();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adZ() {
        return Math.abs(this.mCurrentX - this.Fb) < this.cfs && Math.abs(this.mCurrentY - this.bvU) < this.cfs;
    }

    public void g(float f, float f2) {
        this.mCurrentX = f;
        this.mCurrentY = f2;
    }

    public boolean getIsGif() {
        return this.rw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aea() {
        if (!this.cfq && this.cfr && this.cfl != null && !TextUtils.isEmpty(this.cfl.getPicUrl())) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cfm == null) {
                this.cfm = new com.baidu.tieba.face.view.a(getContext());
            }
            this.cfm.a(this.cfl.getPicUrl(), this.cfl.getThumbUrl(), this.rw, this.cft);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > k.ae(getContext())) {
                layoutParams.leftMargin = k.ae(getContext()) - this.mPreviewWidth;
            }
            if (this.cfn == null) {
                this.cfn = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cfm.getParent() != null && this.cfm.getParent() == this.cfn) {
                this.cfn.removeView(this.cfm);
            }
            this.cfn.addView(this.cfm, layoutParams);
            this.cfq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cfm != null) {
            if (this.cfm.getParent() != null && this.cfm.getParent() == this.cfn) {
                this.cfn.removeView(this.cfm);
            }
            this.cfq = false;
        }
    }

    public void setCanShowPreview(boolean z) {
        this.cfr = z;
        if (!this.cfr) {
            stopPreview();
        }
    }

    public void setLoadProcType(int i) {
        this.cft = i;
    }

    public int getLoadProcType() {
        return this.cft;
    }
}

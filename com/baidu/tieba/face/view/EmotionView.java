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
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float bve;
    private EmotionImageData dre;
    private EmotionPreview drf;
    private FrameLayout drg;
    private long drh;
    private boolean dri;
    private boolean drj;
    private float drk;
    private int drl;
    private a drm;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean avX();

        void awa();

        void awb();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.drl = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drl = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drl = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), e.C0210e.ds240);
        this.mPreviewHeight = l.h(getContext(), e.C0210e.ds260);
        this.drk = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.dre;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.dre = emotionImageData;
            setTag(this.dre.getThumbUrl());
            if (this.drl == 20) {
                b(this.dre);
            } else {
                startLoad(this.dre.getThumbUrl(), this.drl, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.dre = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.jA().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void avW() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.dri = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bve = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bve;
                        EmotionView.this.drh = System.currentTimeMillis();
                        if (EmotionView.this.avX()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.drh), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.dri = false;
                        if (EmotionView.this.drj) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.dri = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.drm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avX() {
        return this.drm == null || this.drm.avX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.drm == null || this.drm.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long dro;

        public b(long j) {
            this.dro = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.dri && this.dro == EmotionView.this.drh && EmotionView.this.avY()) {
                EmotionView.this.avZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avY() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.drk && Math.abs(this.mCurrentY - this.bve) < this.drk;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avZ() {
        if (!this.drj && avX() && this.dre != null && !TextUtils.isEmpty(this.dre.getPicUrl())) {
            if (this.drm != null) {
                this.drm.awa();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.drf == null) {
                this.drf = new EmotionPreview(getContext());
            }
            this.drf.a(this.dre.getPicUrl(), this.dre.getThumbUrl(), this.mIsGif, this.drl);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.drg == null) {
                this.drg = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.drf.getParent() != null && this.drf.getParent() == this.drg) {
                this.drg.removeView(this.drf);
            }
            this.drg.addView(this.drf, layoutParams);
            this.drj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.drf != null && this.drj) {
            if (this.drm != null) {
                this.drm.awb();
            }
            if (this.drf.getParent() != null && this.drf.getParent() == this.drg) {
                this.drg.removeView(this.drf);
            }
            this.drj = false;
        }
    }

    public void setLoadProcType(int i) {
        this.drl = i;
    }

    public int getLoadProcType() {
        return this.drl;
    }
}

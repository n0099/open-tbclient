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
    private float cHg;
    private EmotionImageData eHC;
    private EmotionPreview eHD;
    private FrameLayout eHE;
    private long eHF;
    private boolean eHG;
    private boolean eHH;
    private float eHI;
    private int eHJ;
    private a eHK;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean aXJ();

        void aXM();

        void aXN();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.eHJ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHJ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHJ = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), d.e.ds240);
        this.mPreviewHeight = l.h(getContext(), d.e.ds260);
        this.eHI = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.eHC;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.eHC = emotionImageData;
            setTag(this.eHC.getThumbUrl());
            if (this.eHJ == 20) {
                b(this.eHC);
            } else {
                startLoad(this.eHC.getThumbUrl(), this.eHJ, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.eHC = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.jB().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void aXI() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.eHG = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cHg = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cHg;
                        EmotionView.this.eHF = System.currentTimeMillis();
                        if (EmotionView.this.aXJ()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.eHF), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.eHG = false;
                        if (EmotionView.this.eHH) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.eHG = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.eHK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXJ() {
        return this.eHK == null || this.eHK.aXJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.eHK == null || this.eHK.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long eHM;

        public b(long j) {
            this.eHM = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.eHG && this.eHM == EmotionView.this.eHF && EmotionView.this.aXK()) {
                EmotionView.this.aXL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXK() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.eHI && Math.abs(this.mCurrentY - this.cHg) < this.eHI;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXL() {
        if (!this.eHH && aXJ() && this.eHC != null && !TextUtils.isEmpty(this.eHC.getPicUrl())) {
            if (this.eHK != null) {
                this.eHK.aXM();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.eHD == null) {
                this.eHD = new EmotionPreview(getContext());
            }
            this.eHD.a(this.eHC.getPicUrl(), this.eHC.getThumbUrl(), this.mIsGif, this.eHJ);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.eHE == null) {
                this.eHE = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.eHD.getParent() != null && this.eHD.getParent() == this.eHE) {
                this.eHE.removeView(this.eHD);
            }
            this.eHE.addView(this.eHD, layoutParams);
            this.eHH = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.eHD != null && this.eHH) {
            if (this.eHK != null) {
                this.eHK.aXN();
            }
            if (this.eHD.getParent() != null && this.eHD.getParent() == this.eHE) {
                this.eHE.removeView(this.eHD);
            }
            this.eHH = false;
        }
    }

    public void setLoadProcType(int i) {
        this.eHJ = i;
    }

    public int getLoadProcType() {
        return this.eHJ;
    }
}

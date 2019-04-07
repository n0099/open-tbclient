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
    private float cHf;
    private EmotionImageData eHB;
    private EmotionPreview eHC;
    private FrameLayout eHD;
    private long eHE;
    private boolean eHF;
    private boolean eHG;
    private float eHH;
    private int eHI;
    private a eHJ;
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
        this.eHI = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHI = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHI = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), d.e.ds240);
        this.mPreviewHeight = l.h(getContext(), d.e.ds260);
        this.eHH = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.eHB;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.eHB = emotionImageData;
            setTag(this.eHB.getThumbUrl());
            if (this.eHI == 20) {
                b(this.eHB);
            } else {
                startLoad(this.eHB.getThumbUrl(), this.eHI, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.eHB = null;
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
                        EmotionView.this.eHF = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cHf = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cHf;
                        EmotionView.this.eHE = System.currentTimeMillis();
                        if (EmotionView.this.aXJ()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.eHE), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.eHF = false;
                        if (EmotionView.this.eHG) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.eHF = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.eHJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXJ() {
        return this.eHJ == null || this.eHJ.aXJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.eHJ == null || this.eHJ.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long eHL;

        public b(long j) {
            this.eHL = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.eHF && this.eHL == EmotionView.this.eHE && EmotionView.this.aXK()) {
                EmotionView.this.aXL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXK() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.eHH && Math.abs(this.mCurrentY - this.cHf) < this.eHH;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXL() {
        if (!this.eHG && aXJ() && this.eHB != null && !TextUtils.isEmpty(this.eHB.getPicUrl())) {
            if (this.eHJ != null) {
                this.eHJ.aXM();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.eHC == null) {
                this.eHC = new EmotionPreview(getContext());
            }
            this.eHC.a(this.eHB.getPicUrl(), this.eHB.getThumbUrl(), this.mIsGif, this.eHI);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.eHD == null) {
                this.eHD = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.eHC.getParent() != null && this.eHC.getParent() == this.eHD) {
                this.eHD.removeView(this.eHC);
            }
            this.eHD.addView(this.eHC, layoutParams);
            this.eHG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.eHC != null && this.eHG) {
            if (this.eHJ != null) {
                this.eHJ.aXN();
            }
            if (this.eHC.getParent() != null && this.eHC.getParent() == this.eHD) {
                this.eHD.removeView(this.eHC);
            }
            this.eHG = false;
        }
    }

    public void setLoadProcType(int i) {
        this.eHI = i;
    }

    public int getLoadProcType() {
        return this.eHI;
    }
}

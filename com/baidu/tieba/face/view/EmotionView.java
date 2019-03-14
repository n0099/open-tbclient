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
    private float cHd;
    private EmotionImageData eHP;
    private EmotionPreview eHQ;
    private FrameLayout eHR;
    private long eHS;
    private boolean eHT;
    private boolean eHU;
    private float eHV;
    private int eHW;
    private a eHX;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean aXM();

        void aXP();

        void aXQ();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.eHW = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHW = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHW = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), d.e.ds240);
        this.mPreviewHeight = l.h(getContext(), d.e.ds260);
        this.eHV = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.eHP;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.eHP = emotionImageData;
            setTag(this.eHP.getThumbUrl());
            if (this.eHW == 20) {
                b(this.eHP);
            } else {
                startLoad(this.eHP.getThumbUrl(), this.eHW, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.eHP = null;
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

    public void aXL() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.eHT = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cHd = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cHd;
                        EmotionView.this.eHS = System.currentTimeMillis();
                        if (EmotionView.this.aXM()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.eHS), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.eHT = false;
                        if (EmotionView.this.eHU) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.eHT = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.eHX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXM() {
        return this.eHX == null || this.eHX.aXM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.eHX == null || this.eHX.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long eHZ;

        public b(long j) {
            this.eHZ = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.eHT && this.eHZ == EmotionView.this.eHS && EmotionView.this.aXN()) {
                EmotionView.this.aXO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXN() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.eHV && Math.abs(this.mCurrentY - this.cHd) < this.eHV;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXO() {
        if (!this.eHU && aXM() && this.eHP != null && !TextUtils.isEmpty(this.eHP.getPicUrl())) {
            if (this.eHX != null) {
                this.eHX.aXP();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.eHQ == null) {
                this.eHQ = new EmotionPreview(getContext());
            }
            this.eHQ.a(this.eHP.getPicUrl(), this.eHP.getThumbUrl(), this.mIsGif, this.eHW);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.eHR == null) {
                this.eHR = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.eHQ.getParent() != null && this.eHQ.getParent() == this.eHR) {
                this.eHR.removeView(this.eHQ);
            }
            this.eHR.addView(this.eHQ, layoutParams);
            this.eHU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.eHQ != null && this.eHU) {
            if (this.eHX != null) {
                this.eHX.aXQ();
            }
            if (this.eHQ.getParent() != null && this.eHQ.getParent() == this.eHR) {
                this.eHR.removeView(this.eHQ);
            }
            this.eHU = false;
        }
    }

    public void setLoadProcType(int i) {
        this.eHW = i;
    }

    public int getLoadProcType() {
        return this.eHW;
    }
}

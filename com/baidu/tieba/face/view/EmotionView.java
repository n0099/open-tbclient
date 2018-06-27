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
    private EmotionImageData cSL;
    private EmotionPreview cSM;
    private FrameLayout cSN;
    private long cSO;
    private boolean cSP;
    private boolean cSQ;
    private float cSR;
    private int cSS;
    private a cST;
    private float ceo;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean apc();

        void apf();

        void apg();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cSS = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSS = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cSS = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.e(getContext(), d.e.ds240);
        this.mPreviewHeight = l.e(getContext(), d.e.ds260);
        this.cSR = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cSL;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cSL = emotionImageData;
            setTag(this.cSL.getThumbUrl());
            if (this.cSS == 20) {
                b(this.cSL);
            } else {
                startLoad(this.cSL.getThumbUrl(), this.cSS, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cSL = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.ig().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void apb() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cSP = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.ceo = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.ceo;
                        EmotionView.this.cSO = System.currentTimeMillis();
                        if (EmotionView.this.apc()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cSO), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cSP = false;
                        if (EmotionView.this.cSQ) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cSP = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cST = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apc() {
        return this.cST == null || this.cST.apc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cST == null || this.cST.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cSV;

        public b(long j) {
            this.cSV = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cSP && this.cSV == EmotionView.this.cSO && EmotionView.this.apd()) {
                EmotionView.this.ape();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apd() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.cSR && Math.abs(this.mCurrentY - this.ceo) < this.cSR;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ape() {
        if (!this.cSQ && apc() && this.cSL != null && !TextUtils.isEmpty(this.cSL.getPicUrl())) {
            if (this.cST != null) {
                this.cST.apf();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cSM == null) {
                this.cSM = new EmotionPreview(getContext());
            }
            this.cSM.a(this.cSL.getPicUrl(), this.cSL.getThumbUrl(), this.mIsGif, this.cSS);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ah(getContext())) {
                layoutParams.leftMargin = l.ah(getContext()) - this.mPreviewWidth;
            }
            if (this.cSN == null) {
                this.cSN = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cSM.getParent() != null && this.cSM.getParent() == this.cSN) {
                this.cSN.removeView(this.cSM);
            }
            this.cSN.addView(this.cSM, layoutParams);
            this.cSQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cSM != null && this.cSQ) {
            if (this.cST != null) {
                this.cST.apg();
            }
            if (this.cSM.getParent() != null && this.cSM.getParent() == this.cSN) {
                this.cSN.removeView(this.cSM);
            }
            this.cSQ = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cSS = i;
    }

    public int getLoadProcType() {
        return this.cSS;
    }
}

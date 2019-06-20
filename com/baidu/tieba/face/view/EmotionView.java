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
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float cPq;
    private EmotionImageData eXM;
    private EmotionPreview eXN;
    private FrameLayout eXO;
    private long eXP;
    private boolean eXQ;
    private boolean eXR;
    private float eXS;
    private int eXT;
    private a eXU;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bfg();

        void bfj();

        void bfk();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.eXT = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXT = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eXT = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.g(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.g(getContext(), R.dimen.ds260);
        this.eXS = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.eXM;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.eXM = emotionImageData;
            setTag(this.eXM.getThumbUrl());
            if (this.eXT == 20) {
                b(this.eXM);
            } else {
                startLoad(this.eXM.getThumbUrl(), this.eXT, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.eXM = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.iv().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bff() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.eXQ = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cPq = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cPq;
                        EmotionView.this.eXP = System.currentTimeMillis();
                        if (EmotionView.this.bfg()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.eXP), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.eXQ = false;
                        if (EmotionView.this.eXR) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.eXQ = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.eXU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfg() {
        return this.eXU == null || this.eXU.bfg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.eXU == null || this.eXU.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long eXW;

        public b(long j) {
            this.eXW = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.eXQ && this.eXW == EmotionView.this.eXP && EmotionView.this.bfh()) {
                EmotionView.this.bfi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfh() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.eXS && Math.abs(this.mCurrentY - this.cPq) < this.eXS;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfi() {
        if (!this.eXR && bfg() && this.eXM != null && !TextUtils.isEmpty(this.eXM.getPicUrl())) {
            if (this.eXU != null) {
                this.eXU.bfj();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.eXN == null) {
                this.eXN = new EmotionPreview(getContext());
            }
            this.eXN.a(this.eXM.getPicUrl(), this.eXM.getThumbUrl(), this.mIsGif, this.eXT);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.af(getContext())) {
                layoutParams.leftMargin = l.af(getContext()) - this.mPreviewWidth;
            }
            if (this.eXO == null) {
                this.eXO = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.eXN.getParent() != null && this.eXN.getParent() == this.eXO) {
                this.eXO.removeView(this.eXN);
            }
            this.eXO.addView(this.eXN, layoutParams);
            this.eXR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.eXN != null && this.eXR) {
            if (this.eXU != null) {
                this.eXU.bfk();
            }
            if (this.eXN.getParent() != null && this.eXN.getParent() == this.eXO) {
                this.eXO.removeView(this.eXN);
            }
            this.eXR = false;
        }
    }

    public void setLoadProcType(int i) {
        this.eXT = i;
    }

    public int getLoadProcType() {
        return this.eXT;
    }
}

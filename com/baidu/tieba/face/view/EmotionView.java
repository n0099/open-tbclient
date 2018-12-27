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
    private float bvh;
    private EmotionImageData dtS;
    private EmotionPreview dtT;
    private FrameLayout dtU;
    private long dtV;
    private boolean dtW;
    private boolean dtX;
    private float dtY;
    private int dtZ;
    private a dua;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean awM();

        void awP();

        void awQ();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.dtZ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dtZ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dtZ = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), e.C0210e.ds240);
        this.mPreviewHeight = l.h(getContext(), e.C0210e.ds260);
        this.dtY = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.dtS;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.dtS = emotionImageData;
            setTag(this.dtS.getThumbUrl());
            if (this.dtZ == 20) {
                b(this.dtS);
            } else {
                startLoad(this.dtS.getThumbUrl(), this.dtZ, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.dtS = null;
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

    public void awL() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.dtW = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bvh = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bvh;
                        EmotionView.this.dtV = System.currentTimeMillis();
                        if (EmotionView.this.awM()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.dtV), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.dtW = false;
                        if (EmotionView.this.dtX) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.dtW = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.dua = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awM() {
        return this.dua == null || this.dua.awM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.dua == null || this.dua.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long duc;

        public b(long j) {
            this.duc = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.dtW && this.duc == EmotionView.this.dtV && EmotionView.this.awN()) {
                EmotionView.this.awO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awN() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.dtY && Math.abs(this.mCurrentY - this.bvh) < this.dtY;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awO() {
        if (!this.dtX && awM() && this.dtS != null && !TextUtils.isEmpty(this.dtS.getPicUrl())) {
            if (this.dua != null) {
                this.dua.awP();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.dtT == null) {
                this.dtT = new EmotionPreview(getContext());
            }
            this.dtT.a(this.dtS.getPicUrl(), this.dtS.getThumbUrl(), this.mIsGif, this.dtZ);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.dtU == null) {
                this.dtU = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.dtT.getParent() != null && this.dtT.getParent() == this.dtU) {
                this.dtU.removeView(this.dtT);
            }
            this.dtU.addView(this.dtT, layoutParams);
            this.dtX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.dtT != null && this.dtX) {
            if (this.dua != null) {
                this.dua.awQ();
            }
            if (this.dtT.getParent() != null && this.dtT.getParent() == this.dtU) {
                this.dtU.removeView(this.dtT);
            }
            this.dtX = false;
        }
    }

    public void setLoadProcType(int i) {
        this.dtZ = i;
    }

    public int getLoadProcType() {
        return this.dtZ;
    }
}

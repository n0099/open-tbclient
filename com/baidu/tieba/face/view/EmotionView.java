package com.baidu.tieba.face.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private EmotionImageData gKN;
    private EmotionPreview gKO;
    private FrameLayout gKP;
    private long gKQ;
    private boolean gKR;
    private boolean gKS;
    private float gKT;
    private float gKU;
    private float gKV;
    private int gKW;
    private a gKX;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private float mDownY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bKA();

        void bKD();

        void bKE();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.gKW = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gKW = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gKW = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.gKV = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.gKN;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.gKN = emotionImageData;
            setTag(this.gKN.getThumbUrl());
            if (this.gKW == 20) {
                b(this.gKN);
            } else {
                startLoad(this.gKN.getThumbUrl(), this.gKW, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.gKN = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.kV().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                if (aVar != null) {
                    EmotionView.this.mIsGif = aVar.isGif();
                    View findViewWithTag = EmotionView.this.findViewWithTag(str);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                        TbImageView tbImageView = (TbImageView) findViewWithTag;
                        aVar.drawImageTo(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
            }
        }, 0, 0, null, null, emotionImageData.getThumbUrl(), false, null);
        com.baidu.adp.widget.ImageView.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.ImageView.a)) ? null : (com.baidu.adp.widget.ImageView.a) a2;
        if (aVar != null) {
            aVar.drawImageTo(this);
            setTag(null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void bKz() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.gKR = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.gKT = EmotionView.this.mDownX;
                        EmotionView.this.gKU = EmotionView.this.mDownY;
                        EmotionView.this.gKQ = System.currentTimeMillis();
                        if (EmotionView.this.bKA()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.gKQ), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.gKR = false;
                        if (EmotionView.this.gKS) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.gKR = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.gKX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKA() {
        return this.gKX == null || this.gKX.bKA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.gKX == null || this.gKX.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long gKZ;

        public b(long j) {
            this.gKZ = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.gKR && this.gKZ == EmotionView.this.gKQ && EmotionView.this.bKB()) {
                EmotionView.this.bKC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKB() {
        return Math.abs(this.gKT - this.mDownX) < this.gKV && Math.abs(this.gKU - this.mDownY) < this.gKV;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKC() {
        if (!this.gKS && bKA() && this.gKN != null && !TextUtils.isEmpty(this.gKN.getPicUrl())) {
            if (this.gKX != null) {
                this.gKX.bKD();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.gKO == null) {
                this.gKO = new EmotionPreview(getContext());
            }
            this.gKO.a(this.gKN.getPicUrl(), this.gKN.getThumbUrl(), this.mIsGif, this.gKW);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.gKP == null) {
                this.gKP = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.gKO.getParent() != null && this.gKO.getParent() == this.gKP) {
                this.gKP.removeView(this.gKO);
            }
            this.gKP.addView(this.gKO, layoutParams);
            this.gKS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.gKO != null && this.gKS) {
            if (this.gKX != null) {
                this.gKX.bKE();
            }
            if (this.gKO.getParent() != null && this.gKO.getParent() == this.gKP) {
                this.gKP.removeView(this.gKO);
            }
            this.gKS = false;
        }
    }

    public void setLoadProcType(int i) {
        this.gKW = i;
    }

    public int getLoadProcType() {
        return this.gKW;
    }
}

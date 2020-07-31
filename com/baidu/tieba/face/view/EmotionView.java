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
    private EmotionImageData hrO;
    private EmotionPreview hrP;
    private FrameLayout hrQ;
    private long hrR;
    private boolean hrS;
    private boolean hrT;
    private float hrU;
    private float hrV;
    private float hrW;
    private int hrX;
    private a hrY;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private float mDownY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bXm();

        void bXp();

        void bXq();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.hrX = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hrX = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hrX = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.hrW = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.hrO;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.hrO = emotionImageData;
            setTag(this.hrO.getThumbUrl());
            if (this.hrX == 20) {
                b(this.hrO);
            } else {
                startLoad(this.hrO.getThumbUrl(), this.hrX, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.hrO = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.ln().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bXl() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.hrS = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.hrU = EmotionView.this.mDownX;
                        EmotionView.this.hrV = EmotionView.this.mDownY;
                        EmotionView.this.hrR = System.currentTimeMillis();
                        if (EmotionView.this.bXm()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.hrR), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.hrS = false;
                        if (EmotionView.this.hrT) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.hrS = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.hrY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bXm() {
        return this.hrY == null || this.hrY.bXm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.hrY == null || this.hrY.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long hsa;

        public b(long j) {
            this.hsa = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.hrS && this.hsa == EmotionView.this.hrR && EmotionView.this.bXn()) {
                EmotionView.this.bXo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bXn() {
        return Math.abs(this.hrU - this.mDownX) < this.hrW && Math.abs(this.hrV - this.mDownY) < this.hrW;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXo() {
        if (!this.hrT && bXm() && this.hrO != null && !TextUtils.isEmpty(this.hrO.getPicUrl())) {
            if (this.hrY != null) {
                this.hrY.bXp();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.hrP == null) {
                this.hrP = new EmotionPreview(getContext());
            }
            this.hrP.a(this.hrO.getPicUrl(), this.hrO.getThumbUrl(), this.mIsGif, this.hrX);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.hrQ == null) {
                this.hrQ = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.hrP.getParent() != null && this.hrP.getParent() == this.hrQ) {
                this.hrQ.removeView(this.hrP);
            }
            this.hrQ.addView(this.hrP, layoutParams);
            this.hrT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.hrP != null && this.hrT) {
            if (this.hrY != null) {
                this.hrY.bXq();
            }
            if (this.hrP.getParent() != null && this.hrP.getParent() == this.hrQ) {
                this.hrQ.removeView(this.hrP);
            }
            this.hrT = false;
        }
    }

    public void setLoadProcType(int i) {
        this.hrX = i;
    }

    public int getLoadProcType() {
        return this.hrX;
    }
}

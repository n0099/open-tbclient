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
    private EmotionImageData gZF;
    private EmotionPreview gZG;
    private FrameLayout gZH;
    private long gZI;
    private boolean gZJ;
    private boolean gZK;
    private float gZL;
    private float gZM;
    private float gZN;
    private int gZO;
    private a gZP;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private float mDownY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bQU();

        void bQX();

        void bQY();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.gZO = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZO = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gZO = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.gZN = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.gZF;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.gZF = emotionImageData;
            setTag(this.gZF.getThumbUrl());
            if (this.gZO == 20) {
                b(this.gZF);
            } else {
                startLoad(this.gZF.getThumbUrl(), this.gZO, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.gZF = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.kX().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bQT() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.gZJ = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.gZL = EmotionView.this.mDownX;
                        EmotionView.this.gZM = EmotionView.this.mDownY;
                        EmotionView.this.gZI = System.currentTimeMillis();
                        if (EmotionView.this.bQU()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.gZI), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.gZJ = false;
                        if (EmotionView.this.gZK) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.gZJ = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.gZP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQU() {
        return this.gZP == null || this.gZP.bQU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.gZP == null || this.gZP.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long gZR;

        public b(long j) {
            this.gZR = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.gZJ && this.gZR == EmotionView.this.gZI && EmotionView.this.bQV()) {
                EmotionView.this.bQW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQV() {
        return Math.abs(this.gZL - this.mDownX) < this.gZN && Math.abs(this.gZM - this.mDownY) < this.gZN;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQW() {
        if (!this.gZK && bQU() && this.gZF != null && !TextUtils.isEmpty(this.gZF.getPicUrl())) {
            if (this.gZP != null) {
                this.gZP.bQX();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.gZG == null) {
                this.gZG = new EmotionPreview(getContext());
            }
            this.gZG.a(this.gZF.getPicUrl(), this.gZF.getThumbUrl(), this.mIsGif, this.gZO);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.gZH == null) {
                this.gZH = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.gZG.getParent() != null && this.gZG.getParent() == this.gZH) {
                this.gZH.removeView(this.gZG);
            }
            this.gZH.addView(this.gZG, layoutParams);
            this.gZK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.gZG != null && this.gZK) {
            if (this.gZP != null) {
                this.gZP.bQY();
            }
            if (this.gZG.getParent() != null && this.gZG.getParent() == this.gZH) {
                this.gZH.removeView(this.gZG);
            }
            this.gZK = false;
        }
    }

    public void setLoadProcType(int i) {
        this.gZO = i;
    }

    public int getLoadProcType() {
        return this.gZO;
    }
}

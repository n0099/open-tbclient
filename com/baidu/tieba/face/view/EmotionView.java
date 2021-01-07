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
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float cGB;
    private EmotionPreview iRA;
    private FrameLayout iRB;
    private long iRC;
    private boolean iRD;
    private boolean iRE;
    private float iRF;
    private float iRG;
    private float iRH;
    private int iRI;
    private a iRJ;
    private EmotionImageData iRz;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean cAP();

        void cAS();

        void cAT();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.iRI = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iRI = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iRI = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.iRH = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.iRz;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.iRz = emotionImageData;
            setTag(this.iRz.getThumbUrl());
            if (this.iRI == 20) {
                b(this.iRz);
            } else {
                startLoad(this.iRz.getThumbUrl(), this.iRI, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.iRz = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = d.mx().a(emotionImageData.getThumbUrl(), 20, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
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

    public void cAO() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.iRD = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cGB = motionEvent.getRawY();
                        EmotionView.this.iRF = EmotionView.this.mDownX;
                        EmotionView.this.iRG = EmotionView.this.cGB;
                        EmotionView.this.iRC = System.currentTimeMillis();
                        if (EmotionView.this.cAP()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.iRC), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.iRD = false;
                        if (EmotionView.this.iRE) {
                            EmotionView.this.UR();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.iRD = false;
                        EmotionView.this.UR();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.iRJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cAP() {
        return this.iRJ == null || this.iRJ.cAP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.iRJ == null || this.iRJ.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long iRL;

        public b(long j) {
            this.iRL = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.iRD && this.iRL == EmotionView.this.iRC && EmotionView.this.cAQ()) {
                EmotionView.this.cAR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cAQ() {
        return Math.abs(this.iRF - this.mDownX) < this.iRH && Math.abs(this.iRG - this.cGB) < this.iRH;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAR() {
        if (!this.iRE && cAP() && this.iRz != null && !TextUtils.isEmpty(this.iRz.getPicUrl())) {
            if (this.iRJ != null) {
                this.iRJ.cAS();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.iRA == null) {
                this.iRA = new EmotionPreview(getContext());
            }
            this.iRA.a(this.iRz.getPicUrl(), this.iRz.getThumbUrl(), this.mIsGif, this.iRI);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.iRB == null) {
                this.iRB = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.iRA.getParent() != null && this.iRA.getParent() == this.iRB) {
                this.iRB.removeView(this.iRA);
            }
            this.iRB.addView(this.iRA, layoutParams);
            this.iRE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UR() {
        if (this.iRA != null && this.iRE) {
            if (this.iRJ != null) {
                this.iRJ.cAT();
            }
            if (this.iRA.getParent() != null && this.iRA.getParent() == this.iRB) {
                this.iRB.removeView(this.iRA);
            }
            this.iRE = false;
        }
    }

    public void setLoadProcType(int i) {
        this.iRI = i;
    }

    public int getLoadProcType() {
        return this.iRI;
    }
}

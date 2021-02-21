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
    private float cEl;
    private EmotionImageData iSN;
    private EmotionPreview iSO;
    private FrameLayout iSP;
    private long iSQ;
    private boolean iSR;
    private boolean iSS;
    private float iST;
    private float iSU;
    private float iSV;
    private int iSW;
    private a iSX;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean cyp();

        void cys();

        void cyt();
    }

    public EmotionView(Context context) {
        super(context);
        this.iSW = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iSW = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iSW = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.iSV = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.iSN;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.iSN = emotionImageData;
            setTag(this.iSN.getThumbUrl());
            if (this.iSW == 20) {
                b(this.iSN);
            } else {
                startLoad(this.iSN.getThumbUrl(), this.iSW, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.iSN = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = d.mw().a(emotionImageData.getThumbUrl(), 20, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void cyo() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.iSR = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cEl = motionEvent.getRawY();
                        EmotionView.this.iST = EmotionView.this.mDownX;
                        EmotionView.this.iSU = EmotionView.this.cEl;
                        EmotionView.this.iSQ = System.currentTimeMillis();
                        if (EmotionView.this.cyp()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.iSQ), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.iSR = false;
                        if (EmotionView.this.iSS) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.iSR = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.iSX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyp() {
        return this.iSX == null || this.iSX.cyp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.iSX == null || this.iSX.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long iSZ;

        public b(long j) {
            this.iSZ = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.iSR && this.iSZ == EmotionView.this.iSQ && EmotionView.this.cyq()) {
                EmotionView.this.cyr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyq() {
        return Math.abs(this.iST - this.mDownX) < this.iSV && Math.abs(this.iSU - this.cEl) < this.iSV;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyr() {
        if (!this.iSS && cyp() && this.iSN != null && !TextUtils.isEmpty(this.iSN.getPicUrl())) {
            if (this.iSX != null) {
                this.iSX.cys();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.iSO == null) {
                this.iSO = new EmotionPreview(getContext());
            }
            this.iSO.a(this.iSN.getPicUrl(), this.iSN.getThumbUrl(), this.mIsGif, this.iSW);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.iSP == null) {
                this.iSP = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.iSO.getParent() != null && this.iSO.getParent() == this.iSP) {
                this.iSP.removeView(this.iSO);
            }
            this.iSP.addView(this.iSO, layoutParams);
            this.iSS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.iSO != null && this.iSS) {
            if (this.iSX != null) {
                this.iSX.cyt();
            }
            if (this.iSO.getParent() != null && this.iSO.getParent() == this.iSP) {
                this.iSP.removeView(this.iSO);
            }
            this.iSS = false;
        }
    }

    public void setLoadProcType(int i) {
        this.iSW = i;
    }

    public int getLoadProcType() {
        return this.iSW;
    }
}

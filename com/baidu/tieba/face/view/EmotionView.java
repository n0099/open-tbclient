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
    private float cHg;
    private EmotionImageData eHT;
    private EmotionPreview eHU;
    private FrameLayout eHV;
    private long eHW;
    private boolean eHX;
    private boolean eHY;
    private float eHZ;
    private int eIa;
    private a eIb;
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
        this.eIa = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eIa = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eIa = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), d.e.ds240);
        this.mPreviewHeight = l.h(getContext(), d.e.ds260);
        this.eHZ = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.eHT;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.eHT = emotionImageData;
            setTag(this.eHT.getThumbUrl());
            if (this.eIa == 20) {
                b(this.eHT);
            } else {
                startLoad(this.eHT.getThumbUrl(), this.eIa, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.eHT = null;
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
                        EmotionView.this.eHX = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cHg = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cHg;
                        EmotionView.this.eHW = System.currentTimeMillis();
                        if (EmotionView.this.aXM()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.eHW), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.eHX = false;
                        if (EmotionView.this.eHY) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.eHX = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.eIb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXM() {
        return this.eIb == null || this.eIb.aXM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.eIb == null || this.eIb.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long eId;

        public b(long j) {
            this.eId = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.eHX && this.eId == EmotionView.this.eHW && EmotionView.this.aXN()) {
                EmotionView.this.aXO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXN() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.eHZ && Math.abs(this.mCurrentY - this.cHg) < this.eHZ;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXO() {
        if (!this.eHY && aXM() && this.eHT != null && !TextUtils.isEmpty(this.eHT.getPicUrl())) {
            if (this.eIb != null) {
                this.eIb.aXP();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.eHU == null) {
                this.eHU = new EmotionPreview(getContext());
            }
            this.eHU.a(this.eHT.getPicUrl(), this.eHT.getThumbUrl(), this.mIsGif, this.eIa);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.eHV == null) {
                this.eHV = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.eHU.getParent() != null && this.eHU.getParent() == this.eHV) {
                this.eHV.removeView(this.eHU);
            }
            this.eHV.addView(this.eHU, layoutParams);
            this.eHY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.eHU != null && this.eHY) {
            if (this.eIb != null) {
                this.eIb.aXQ();
            }
            if (this.eHU.getParent() != null && this.eHU.getParent() == this.eHV) {
                this.eHV.removeView(this.eHU);
            }
            this.eHY = false;
        }
    }

    public void setLoadProcType(int i) {
        this.eIa = i;
    }

    public int getLoadProcType() {
        return this.eIa;
    }
}

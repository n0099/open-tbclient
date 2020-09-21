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
    private float bVQ;
    private EmotionImageData hMl;
    private EmotionPreview hMm;
    private FrameLayout hMn;
    private long hMo;
    private boolean hMp;
    private boolean hMq;
    private float hMr;
    private float hMs;
    private float hMt;
    private int hMu;
    private a hMv;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean ckW();

        void ckZ();

        void cla();
    }

    public EmotionView(Context context) {
        super(context);
        this.hMu = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hMu = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hMu = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.hMt = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.hMl;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.hMl = emotionImageData;
            setTag(this.hMl.getThumbUrl());
            if (this.hMu == 20) {
                b(this.hMl);
            } else {
                startLoad(this.hMl.getThumbUrl(), this.hMu, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.hMl = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.mR().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void ckV() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.hMp = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bVQ = motionEvent.getRawY();
                        EmotionView.this.hMr = EmotionView.this.mDownX;
                        EmotionView.this.hMs = EmotionView.this.bVQ;
                        EmotionView.this.hMo = System.currentTimeMillis();
                        if (EmotionView.this.ckW()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.hMo), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.hMp = false;
                        if (EmotionView.this.hMq) {
                            EmotionView.this.cen();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.hMp = false;
                        EmotionView.this.cen();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.hMv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ckW() {
        return this.hMv == null || this.hMv.ckW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.hMv == null || this.hMv.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long hMx;

        public b(long j) {
            this.hMx = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.hMp && this.hMx == EmotionView.this.hMo && EmotionView.this.ckX()) {
                EmotionView.this.ckY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ckX() {
        return Math.abs(this.hMr - this.mDownX) < this.hMt && Math.abs(this.hMs - this.bVQ) < this.hMt;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckY() {
        if (!this.hMq && ckW() && this.hMl != null && !TextUtils.isEmpty(this.hMl.getPicUrl())) {
            if (this.hMv != null) {
                this.hMv.ckZ();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.hMm == null) {
                this.hMm = new EmotionPreview(getContext());
            }
            this.hMm.a(this.hMl.getPicUrl(), this.hMl.getThumbUrl(), this.mIsGif, this.hMu);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.hMn == null) {
                this.hMn = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.hMm.getParent() != null && this.hMm.getParent() == this.hMn) {
                this.hMn.removeView(this.hMm);
            }
            this.hMn.addView(this.hMm, layoutParams);
            this.hMq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cen() {
        if (this.hMm != null && this.hMq) {
            if (this.hMv != null) {
                this.hMv.cla();
            }
            if (this.hMm.getParent() != null && this.hMm.getParent() == this.hMn) {
                this.hMn.removeView(this.hMm);
            }
            this.hMq = false;
        }
    }

    public void setLoadProcType(int i) {
        this.hMu = i;
    }

    public int getLoadProcType() {
        return this.hMu;
    }
}

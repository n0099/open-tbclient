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
    private float czp;
    private EmotionImageData doD;
    private com.baidu.tieba.face.view.a doE;
    private FrameLayout doF;
    private long doG;
    private boolean doH;
    private boolean doI;
    private float doJ;
    private int doK;
    private a doL;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean aqr();

        void aqu();

        void aqv();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.doK = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.doK = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.doK = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.s(getContext(), d.e.ds240);
        this.mPreviewHeight = l.s(getContext(), d.e.ds260);
        this.doJ = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.doD;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.doD = emotionImageData;
            setTag(this.doD.getThumbUrl());
            if (this.doK == 20) {
                b(this.doD);
            } else {
                startLoad(this.doD.getThumbUrl(), this.doK, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.doD = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.nl().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
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
        com.baidu.adp.widget.a.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a2;
        if (aVar != null) {
            aVar.a(this);
            setTag(null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void aqq() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.doH = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.czp = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.czp;
                        EmotionView.this.doG = System.currentTimeMillis();
                        if (EmotionView.this.aqr()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.doG), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.doH = false;
                        if (EmotionView.this.doI) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.doH = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.doL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqr() {
        return this.doL == null || this.doL.aqr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.doL == null || this.doL.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long doN;

        public b(long j) {
            this.doN = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.doH && this.doN == EmotionView.this.doG && EmotionView.this.aqs()) {
                EmotionView.this.aqt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqs() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.doJ && Math.abs(this.mCurrentY - this.czp) < this.doJ;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqt() {
        if (!this.doI && aqr() && this.doD != null && !TextUtils.isEmpty(this.doD.getPicUrl())) {
            if (this.doL != null) {
                this.doL.aqu();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.doE == null) {
                this.doE = new com.baidu.tieba.face.view.a(getContext());
            }
            this.doE.a(this.doD.getPicUrl(), this.doD.getThumbUrl(), this.mIsGif, this.doK);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ao(getContext())) {
                layoutParams.leftMargin = l.ao(getContext()) - this.mPreviewWidth;
            }
            if (this.doF == null) {
                this.doF = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.doE.getParent() != null && this.doE.getParent() == this.doF) {
                this.doF.removeView(this.doE);
            }
            this.doF.addView(this.doE, layoutParams);
            this.doI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.doE != null && this.doI) {
            if (this.doL != null) {
                this.doL.aqv();
            }
            if (this.doE.getParent() != null && this.doE.getParent() == this.doF) {
                this.doF.removeView(this.doE);
            }
            this.doI = false;
        }
    }

    public void setLoadProcType(int i) {
        this.doK = i;
    }

    public int getLoadProcType() {
        return this.doK;
    }
}

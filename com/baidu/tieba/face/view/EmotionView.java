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
    private float cDi;
    private EmotionImageData drF;
    private com.baidu.tieba.face.view.a drG;
    private FrameLayout drH;
    private long drI;
    private boolean drJ;
    private boolean drK;
    private float drL;
    private int drM;
    private a drN;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean arl();

        void aro();

        void arp();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.drM = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drM = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drM = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.t(getContext(), d.e.ds240);
        this.mPreviewHeight = l.t(getContext(), d.e.ds260);
        this.drL = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.drF;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.drF = emotionImageData;
            setTag(this.drF.getThumbUrl());
            if (this.drM == 20) {
                b(this.drF);
            } else {
                startLoad(this.drF.getThumbUrl(), this.drM, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.drF = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.nm().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void ark() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.drJ = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cDi = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cDi;
                        EmotionView.this.drI = System.currentTimeMillis();
                        if (EmotionView.this.arl()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.drI), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.drJ = false;
                        if (EmotionView.this.drK) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.drJ = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.drN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arl() {
        return this.drN == null || this.drN.arl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.drN == null || this.drN.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long drP;

        public b(long j) {
            this.drP = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.drJ && this.drP == EmotionView.this.drI && EmotionView.this.arm()) {
                EmotionView.this.arn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arm() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.drL && Math.abs(this.mCurrentY - this.cDi) < this.drL;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arn() {
        if (!this.drK && arl() && this.drF != null && !TextUtils.isEmpty(this.drF.getPicUrl())) {
            if (this.drN != null) {
                this.drN.aro();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.drG == null) {
                this.drG = new com.baidu.tieba.face.view.a(getContext());
            }
            this.drG.a(this.drF.getPicUrl(), this.drF.getThumbUrl(), this.mIsGif, this.drM);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ao(getContext())) {
                layoutParams.leftMargin = l.ao(getContext()) - this.mPreviewWidth;
            }
            if (this.drH == null) {
                this.drH = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.drG.getParent() != null && this.drG.getParent() == this.drH) {
                this.drH.removeView(this.drG);
            }
            this.drH.addView(this.drG, layoutParams);
            this.drK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.drG != null && this.drK) {
            if (this.drN != null) {
                this.drN.arp();
            }
            if (this.drG.getParent() != null && this.drG.getParent() == this.drH) {
                this.drH.removeView(this.drG);
            }
            this.drK = false;
        }
    }

    public void setLoadProcType(int i) {
        this.drM = i;
    }

    public int getLoadProcType() {
        return this.drM;
    }
}

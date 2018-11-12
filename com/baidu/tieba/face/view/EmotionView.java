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
    private float brF;
    private EmotionImageData dkC;
    private EmotionPreview dkD;
    private FrameLayout dkE;
    private long dkF;
    private boolean dkG;
    private boolean dkH;
    private float dkI;
    private int dkJ;
    private a dkK;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean aum();

        void aup();

        void auq();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.dkJ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkJ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dkJ = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), e.C0200e.ds240);
        this.mPreviewHeight = l.h(getContext(), e.C0200e.ds260);
        this.dkI = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.dkC;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.dkC = emotionImageData;
            setTag(this.dkC.getThumbUrl());
            if (this.dkJ == 20) {
                b(this.dkC);
            } else {
                startLoad(this.dkC.getThumbUrl(), this.dkJ, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.dkC = null;
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

    public void aul() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.dkG = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.brF = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.brF;
                        EmotionView.this.dkF = System.currentTimeMillis();
                        if (EmotionView.this.aum()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.dkF), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.dkG = false;
                        if (EmotionView.this.dkH) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.dkG = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.dkK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aum() {
        return this.dkK == null || this.dkK.aum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.dkK == null || this.dkK.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long dkM;

        public b(long j) {
            this.dkM = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.dkG && this.dkM == EmotionView.this.dkF && EmotionView.this.aun()) {
                EmotionView.this.auo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aun() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.dkI && Math.abs(this.mCurrentY - this.brF) < this.dkI;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auo() {
        if (!this.dkH && aum() && this.dkC != null && !TextUtils.isEmpty(this.dkC.getPicUrl())) {
            if (this.dkK != null) {
                this.dkK.aup();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.dkD == null) {
                this.dkD = new EmotionPreview(getContext());
            }
            this.dkD.a(this.dkC.getPicUrl(), this.dkC.getThumbUrl(), this.mIsGif, this.dkJ);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.dkE == null) {
                this.dkE = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.dkD.getParent() != null && this.dkD.getParent() == this.dkE) {
                this.dkE.removeView(this.dkD);
            }
            this.dkE.addView(this.dkD, layoutParams);
            this.dkH = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.dkD != null && this.dkH) {
            if (this.dkK != null) {
                this.dkK.auq();
            }
            if (this.dkD.getParent() != null && this.dkD.getParent() == this.dkE) {
                this.dkE.removeView(this.dkD);
            }
            this.dkH = false;
        }
    }

    public void setLoadProcType(int i) {
        this.dkJ = i;
    }

    public int getLoadProcType() {
        return this.dkJ;
    }
}

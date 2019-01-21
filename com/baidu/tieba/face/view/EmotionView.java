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
    private float bvW;
    private EmotionImageData duC;
    private EmotionPreview duD;
    private FrameLayout duE;
    private long duF;
    private boolean duG;
    private boolean duH;
    private float duI;
    private int duJ;
    private a duK;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean axj();

        void axm();

        void axn();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.duJ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duJ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.duJ = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), e.C0210e.ds240);
        this.mPreviewHeight = l.h(getContext(), e.C0210e.ds260);
        this.duI = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.duC;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.duC = emotionImageData;
            setTag(this.duC.getThumbUrl());
            if (this.duJ == 20) {
                b(this.duC);
            } else {
                startLoad(this.duC.getThumbUrl(), this.duJ, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.duC = null;
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

    public void axi() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.duG = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bvW = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bvW;
                        EmotionView.this.duF = System.currentTimeMillis();
                        if (EmotionView.this.axj()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.duF), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.duG = false;
                        if (EmotionView.this.duH) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.duG = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.duK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axj() {
        return this.duK == null || this.duK.axj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.duK == null || this.duK.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long duM;

        public b(long j) {
            this.duM = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.duG && this.duM == EmotionView.this.duF && EmotionView.this.axk()) {
                EmotionView.this.axl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axk() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.duI && Math.abs(this.mCurrentY - this.bvW) < this.duI;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axl() {
        if (!this.duH && axj() && this.duC != null && !TextUtils.isEmpty(this.duC.getPicUrl())) {
            if (this.duK != null) {
                this.duK.axm();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.duD == null) {
                this.duD = new EmotionPreview(getContext());
            }
            this.duD.a(this.duC.getPicUrl(), this.duC.getThumbUrl(), this.mIsGif, this.duJ);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.duE == null) {
                this.duE = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.duD.getParent() != null && this.duD.getParent() == this.duE) {
                this.duE.removeView(this.duD);
            }
            this.duE.addView(this.duD, layoutParams);
            this.duH = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.duD != null && this.duH) {
            if (this.duK != null) {
                this.duK.axn();
            }
            if (this.duD.getParent() != null && this.duD.getParent() == this.duE) {
                this.duE.removeView(this.duD);
            }
            this.duH = false;
        }
    }

    public void setLoadProcType(int i) {
        this.duJ = i;
    }

    public int getLoadProcType() {
        return this.duJ;
    }
}

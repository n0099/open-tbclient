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
    private float bvV;
    private EmotionImageData duB;
    private EmotionPreview duC;
    private FrameLayout duD;
    private long duE;
    private boolean duF;
    private boolean duG;
    private float duH;
    private int duI;
    private a duJ;
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
        this.duI = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duI = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.duI = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), e.C0210e.ds240);
        this.mPreviewHeight = l.h(getContext(), e.C0210e.ds260);
        this.duH = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.duB;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.duB = emotionImageData;
            setTag(this.duB.getThumbUrl());
            if (this.duI == 20) {
                b(this.duB);
            } else {
                startLoad(this.duB.getThumbUrl(), this.duI, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.duB = null;
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
                        EmotionView.this.duF = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bvV = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bvV;
                        EmotionView.this.duE = System.currentTimeMillis();
                        if (EmotionView.this.axj()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.duE), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.duF = false;
                        if (EmotionView.this.duG) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.duF = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.duJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axj() {
        return this.duJ == null || this.duJ.axj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.duJ == null || this.duJ.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long duL;

        public b(long j) {
            this.duL = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.duF && this.duL == EmotionView.this.duE && EmotionView.this.axk()) {
                EmotionView.this.axl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axk() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.duH && Math.abs(this.mCurrentY - this.bvV) < this.duH;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axl() {
        if (!this.duG && axj() && this.duB != null && !TextUtils.isEmpty(this.duB.getPicUrl())) {
            if (this.duJ != null) {
                this.duJ.axm();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.duC == null) {
                this.duC = new EmotionPreview(getContext());
            }
            this.duC.a(this.duB.getPicUrl(), this.duB.getThumbUrl(), this.mIsGif, this.duI);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.duD == null) {
                this.duD = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.duC.getParent() != null && this.duC.getParent() == this.duD) {
                this.duD.removeView(this.duC);
            }
            this.duD.addView(this.duC, layoutParams);
            this.duG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.duC != null && this.duG) {
            if (this.duJ != null) {
                this.duJ.axn();
            }
            if (this.duC.getParent() != null && this.duC.getParent() == this.duD) {
                this.duD.removeView(this.duC);
            }
            this.duG = false;
        }
    }

    public void setLoadProcType(int i) {
        this.duI = i;
    }

    public int getLoadProcType() {
        return this.duI;
    }
}

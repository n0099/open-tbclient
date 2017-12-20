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
    private float EO;
    private float bKv;
    private EmotionImageData cvC;
    private com.baidu.tieba.face.view.a cvD;
    private FrameLayout cvE;
    private long cvF;
    private boolean cvG;
    private boolean cvH;
    private float cvI;
    private int cvJ;
    private a cvK;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean ahO();

        void ahR();

        void ahS();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cvJ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvJ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvJ = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.f(getContext(), d.e.ds240);
        this.mPreviewHeight = l.f(getContext(), d.e.ds260);
        this.cvI = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cvC;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cvC = emotionImageData;
            setTag(this.cvC.getThumbUrl());
            if (this.cvJ == 20) {
                b(this.cvC);
            } else {
                startLoad(this.cvC.getThumbUrl(), this.cvJ, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cvC = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.fJ().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void ahN() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cvG = true;
                        EmotionView.this.EO = motionEvent.getRawX();
                        EmotionView.this.bKv = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.EO;
                        EmotionView.this.mCurrentY = EmotionView.this.bKv;
                        EmotionView.this.cvF = System.currentTimeMillis();
                        if (EmotionView.this.ahO()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cvF), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cvG = false;
                        if (EmotionView.this.cvH) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cvG = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cvK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahO() {
        return this.cvK == null || this.cvK.ahO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cvK == null || this.cvK.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cvM;

        public b(long j) {
            this.cvM = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cvG && this.cvM == EmotionView.this.cvF && EmotionView.this.ahP()) {
                EmotionView.this.ahQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahP() {
        return Math.abs(this.mCurrentX - this.EO) < this.cvI && Math.abs(this.mCurrentY - this.bKv) < this.cvI;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahQ() {
        if (!this.cvH && ahO() && this.cvC != null && !TextUtils.isEmpty(this.cvC.getPicUrl())) {
            if (this.cvK != null) {
                this.cvK.ahR();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cvD == null) {
                this.cvD = new com.baidu.tieba.face.view.a(getContext());
            }
            this.cvD.a(this.cvC.getPicUrl(), this.cvC.getThumbUrl(), this.mIsGif, this.cvJ);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ac(getContext())) {
                layoutParams.leftMargin = l.ac(getContext()) - this.mPreviewWidth;
            }
            if (this.cvE == null) {
                this.cvE = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cvD.getParent() != null && this.cvD.getParent() == this.cvE) {
                this.cvE.removeView(this.cvD);
            }
            this.cvE.addView(this.cvD, layoutParams);
            this.cvH = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cvD != null && this.cvH) {
            if (this.cvK != null) {
                this.cvK.ahS();
            }
            if (this.cvD.getParent() != null && this.cvD.getParent() == this.cvE) {
                this.cvE.removeView(this.cvD);
            }
            this.cvH = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cvJ = i;
    }

    public int getLoadProcType() {
        return this.cvJ;
    }
}

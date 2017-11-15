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
    private float EP;
    private float bCr;
    private EmotionImageData cmG;
    private com.baidu.tieba.face.view.a cmH;
    private FrameLayout cmI;
    private long cmJ;
    private boolean cmK;
    private boolean cmL;
    private float cmM;
    private int cmN;
    private a cmO;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean afW();

        void afZ();

        void aga();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cmN = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmN = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmN = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.f(getContext(), d.e.ds240);
        this.mPreviewHeight = l.f(getContext(), d.e.ds260);
        this.cmM = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cmG;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cmG = emotionImageData;
            setTag(this.cmG.getThumbUrl());
            if (this.cmN == 20) {
                b(this.cmG);
            } else {
                startLoad(this.cmG.getThumbUrl(), this.cmN, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cmG = null;
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

    public void afV() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cmK = true;
                        EmotionView.this.EP = motionEvent.getRawX();
                        EmotionView.this.bCr = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.EP;
                        EmotionView.this.mCurrentY = EmotionView.this.bCr;
                        EmotionView.this.cmJ = System.currentTimeMillis();
                        if (EmotionView.this.afW()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cmJ), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cmK = false;
                        if (EmotionView.this.cmL) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cmK = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cmO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afW() {
        return this.cmO == null || this.cmO.afW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cmO == null || this.cmO.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cmQ;

        public b(long j) {
            this.cmQ = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cmK && this.cmQ == EmotionView.this.cmJ && EmotionView.this.afX()) {
                EmotionView.this.afY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afX() {
        return Math.abs(this.mCurrentX - this.EP) < this.cmM && Math.abs(this.mCurrentY - this.bCr) < this.cmM;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afY() {
        if (!this.cmL && afW() && this.cmG != null && !TextUtils.isEmpty(this.cmG.getPicUrl())) {
            if (this.cmO != null) {
                this.cmO.afZ();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cmH == null) {
                this.cmH = new com.baidu.tieba.face.view.a(getContext());
            }
            this.cmH.a(this.cmG.getPicUrl(), this.cmG.getThumbUrl(), this.mIsGif, this.cmN);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ac(getContext())) {
                layoutParams.leftMargin = l.ac(getContext()) - this.mPreviewWidth;
            }
            if (this.cmI == null) {
                this.cmI = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cmH.getParent() != null && this.cmH.getParent() == this.cmI) {
                this.cmI.removeView(this.cmH);
            }
            this.cmI.addView(this.cmH, layoutParams);
            this.cmL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cmH != null && this.cmL) {
            if (this.cmO != null) {
                this.cmO.aga();
            }
            if (this.cmH.getParent() != null && this.cmH.getParent() == this.cmI) {
                this.cmI.removeView(this.cmH);
            }
            this.cmL = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cmN = i;
    }

    public int getLoadProcType() {
        return this.cmN;
    }
}

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
    private float cqF;
    private EmotionImageData inI;
    private EmotionPreview inJ;
    private FrameLayout inK;
    private long inL;
    private boolean inM;
    private boolean inN;
    private float inO;
    private float inP;
    private float inQ;
    private int inR;
    private a inS;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean crB();

        void crE();

        void crF();
    }

    public EmotionView(Context context) {
        super(context);
        this.inR = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inR = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inR = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.inQ = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.inI;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.inI = emotionImageData;
            setTag(this.inI.getThumbUrl());
            if (this.inR == 20) {
                b(this.inI);
            } else {
                startLoad(this.inI.getThumbUrl(), this.inR, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.inI = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.mS().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void crA() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.inM = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cqF = motionEvent.getRawY();
                        EmotionView.this.inO = EmotionView.this.mDownX;
                        EmotionView.this.inP = EmotionView.this.cqF;
                        EmotionView.this.inL = System.currentTimeMillis();
                        if (EmotionView.this.crB()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.inL), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.inM = false;
                        if (EmotionView.this.inN) {
                            EmotionView.this.ckQ();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.inM = false;
                        EmotionView.this.ckQ();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.inS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crB() {
        return this.inS == null || this.inS.crB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.inS == null || this.inS.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long inU;

        public b(long j) {
            this.inU = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.inM && this.inU == EmotionView.this.inL && EmotionView.this.crC()) {
                EmotionView.this.crD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crC() {
        return Math.abs(this.inO - this.mDownX) < this.inQ && Math.abs(this.inP - this.cqF) < this.inQ;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crD() {
        if (!this.inN && crB() && this.inI != null && !TextUtils.isEmpty(this.inI.getPicUrl())) {
            if (this.inS != null) {
                this.inS.crE();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.inJ == null) {
                this.inJ = new EmotionPreview(getContext());
            }
            this.inJ.a(this.inI.getPicUrl(), this.inI.getThumbUrl(), this.mIsGif, this.inR);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.inK == null) {
                this.inK = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.inJ.getParent() != null && this.inJ.getParent() == this.inK) {
                this.inK.removeView(this.inJ);
            }
            this.inK.addView(this.inJ, layoutParams);
            this.inN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckQ() {
        if (this.inJ != null && this.inN) {
            if (this.inS != null) {
                this.inS.crF();
            }
            if (this.inJ.getParent() != null && this.inJ.getParent() == this.inK) {
                this.inK.removeView(this.inJ);
            }
            this.inN = false;
        }
    }

    public void setLoadProcType(int i) {
        this.inR = i;
    }

    public int getLoadProcType() {
        return this.inR;
    }
}

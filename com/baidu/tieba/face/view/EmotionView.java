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
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float cQM;
    private EmotionImageData fcN;
    private EmotionPreview fcO;
    private FrameLayout fcP;
    private long fcQ;
    private boolean fcR;
    private boolean fcS;
    private float fcT;
    private int fcU;
    private a fcV;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bhj();

        void bhm();

        void bhn();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.fcU = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fcU = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fcU = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.g(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.g(getContext(), R.dimen.ds260);
        this.fcT = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.fcN;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.fcN = emotionImageData;
            setTag(this.fcN.getThumbUrl());
            if (this.fcU == 20) {
                b(this.fcN);
            } else {
                startLoad(this.fcN.getThumbUrl(), this.fcU, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.fcN = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.iE().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bhi() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.fcR = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cQM = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cQM;
                        EmotionView.this.fcQ = System.currentTimeMillis();
                        if (EmotionView.this.bhj()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.fcQ), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.fcR = false;
                        if (EmotionView.this.fcS) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.fcR = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.fcV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhj() {
        return this.fcV == null || this.fcV.bhj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.fcV == null || this.fcV.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long fcX;

        public b(long j) {
            this.fcX = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.fcR && this.fcX == EmotionView.this.fcQ && EmotionView.this.bhk()) {
                EmotionView.this.bhl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhk() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.fcT && Math.abs(this.mCurrentY - this.cQM) < this.fcT;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhl() {
        if (!this.fcS && bhj() && this.fcN != null && !TextUtils.isEmpty(this.fcN.getPicUrl())) {
            if (this.fcV != null) {
                this.fcV.bhm();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.fcO == null) {
                this.fcO = new EmotionPreview(getContext());
            }
            this.fcO.a(this.fcN.getPicUrl(), this.fcN.getThumbUrl(), this.mIsGif, this.fcU);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.af(getContext())) {
                layoutParams.leftMargin = l.af(getContext()) - this.mPreviewWidth;
            }
            if (this.fcP == null) {
                this.fcP = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.fcO.getParent() != null && this.fcO.getParent() == this.fcP) {
                this.fcP.removeView(this.fcO);
            }
            this.fcP.addView(this.fcO, layoutParams);
            this.fcS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.fcO != null && this.fcS) {
            if (this.fcV != null) {
                this.fcV.bhn();
            }
            if (this.fcO.getParent() != null && this.fcO.getParent() == this.fcP) {
                this.fcP.removeView(this.fcO);
            }
            this.fcS = false;
        }
    }

    public void setLoadProcType(int i) {
        this.fcU = i;
    }

    public int getLoadProcType() {
        return this.fcU;
    }
}

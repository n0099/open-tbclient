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
    private float bqT;
    private long djA;
    private boolean djB;
    private boolean djC;
    private float djD;
    private int djE;
    private a djF;
    private EmotionImageData djx;
    private EmotionPreview djy;
    private FrameLayout djz;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean auN();

        void auQ();

        void auR();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.djE = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.djE = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.djE = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), e.C0175e.ds240);
        this.mPreviewHeight = l.h(getContext(), e.C0175e.ds260);
        this.djD = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.djx;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.djx = emotionImageData;
            setTag(this.djx.getThumbUrl());
            if (this.djE == 20) {
                b(this.djx);
            } else {
                startLoad(this.djx.getThumbUrl(), this.djE, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.djx = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.jC().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void auM() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.djB = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bqT = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bqT;
                        EmotionView.this.djA = System.currentTimeMillis();
                        if (EmotionView.this.auN()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.djA), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.djB = false;
                        if (EmotionView.this.djC) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.djB = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.djF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auN() {
        return this.djF == null || this.djF.auN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.djF == null || this.djF.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long djH;

        public b(long j) {
            this.djH = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.djB && this.djH == EmotionView.this.djA && EmotionView.this.auO()) {
                EmotionView.this.auP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auO() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.djD && Math.abs(this.mCurrentY - this.bqT) < this.djD;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auP() {
        if (!this.djC && auN() && this.djx != null && !TextUtils.isEmpty(this.djx.getPicUrl())) {
            if (this.djF != null) {
                this.djF.auQ();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.djy == null) {
                this.djy = new EmotionPreview(getContext());
            }
            this.djy.a(this.djx.getPicUrl(), this.djx.getThumbUrl(), this.mIsGif, this.djE);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.djz == null) {
                this.djz = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.djy.getParent() != null && this.djy.getParent() == this.djz) {
                this.djz.removeView(this.djy);
            }
            this.djz.addView(this.djy, layoutParams);
            this.djC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.djy != null && this.djC) {
            if (this.djF != null) {
                this.djF.auR();
            }
            if (this.djy.getParent() != null && this.djy.getParent() == this.djz) {
                this.djz.removeView(this.djy);
            }
            this.djC = false;
        }
    }

    public void setLoadProcType(int i) {
        this.djE = i;
    }

    public int getLoadProcType() {
        return this.djE;
    }
}

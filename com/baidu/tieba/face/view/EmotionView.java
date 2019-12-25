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
    private EmotionPreview fVA;
    private long fVB;
    private boolean fVC;
    private float fVD;
    private float fVE;
    private int fVF;
    private a fVG;
    private EmotionImageData fVz;
    private View.OnClickListener mClickListener;
    private FrameLayout mDecorView;
    private float mDownX;
    private float mDownY;
    private boolean mIsTouching;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private float mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        boolean bxm();

        void bxp();

        void bxq();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.fVF = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fVF = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fVF = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.fVz;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.fVz = emotionImageData;
            setTag(this.fVz.getThumbUrl());
            if (this.fVF == 20) {
                b(this.fVz);
            } else {
                startLoad(this.fVz.getThumbUrl(), this.fVF, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.fVz = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.gs().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bxl() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.mIsTouching = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.fVD = EmotionView.this.mDownX;
                        EmotionView.this.fVE = EmotionView.this.mDownY;
                        EmotionView.this.fVB = System.currentTimeMillis();
                        if (EmotionView.this.bxm()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.fVB), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.mIsTouching = false;
                        if (EmotionView.this.fVC) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.mIsTouching = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.fVG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxm() {
        return this.fVG == null || this.fVG.bxm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.fVG == null || this.fVG.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long fVI;

        public b(long j) {
            this.fVI = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.mIsTouching && this.fVI == EmotionView.this.fVB && EmotionView.this.bxn()) {
                EmotionView.this.bxo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxn() {
        return Math.abs(this.fVD - this.mDownX) < this.mTouchSlop && Math.abs(this.fVE - this.mDownY) < this.mTouchSlop;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxo() {
        if (!this.fVC && bxm() && this.fVz != null && !TextUtils.isEmpty(this.fVz.getPicUrl())) {
            if (this.fVG != null) {
                this.fVG.bxp();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.fVA == null) {
                this.fVA = new EmotionPreview(getContext());
            }
            this.fVA.a(this.fVz.getPicUrl(), this.fVz.getThumbUrl(), this.mIsGif, this.fVF);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.mDecorView == null) {
                this.mDecorView = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.fVA.getParent() != null && this.fVA.getParent() == this.mDecorView) {
                this.mDecorView.removeView(this.fVA);
            }
            this.mDecorView.addView(this.fVA, layoutParams);
            this.fVC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.fVA != null && this.fVC) {
            if (this.fVG != null) {
                this.fVG.bxq();
            }
            if (this.fVA.getParent() != null && this.fVA.getParent() == this.mDecorView) {
                this.mDecorView.removeView(this.fVA);
            }
            this.fVC = false;
        }
    }

    public void setLoadProcType(int i) {
        this.fVF = i;
    }

    public int getLoadProcType() {
        return this.fVF;
    }
}

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
    private EmotionImageData gaK;
    private EmotionPreview gaL;
    private long gaM;
    private boolean gaN;
    private float gaO;
    private float gaP;
    private int gaQ;
    private a gaR;
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
        boolean bzS();

        void bzV();

        void bzW();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.gaQ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaQ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaQ = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.gaK;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.gaK = emotionImageData;
            setTag(this.gaK.getThumbUrl());
            if (this.gaQ == 20) {
                b(this.gaK);
            } else {
                startLoad(this.gaK.getThumbUrl(), this.gaQ, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.gaK = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.gr().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bzR() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.mIsTouching = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.gaO = EmotionView.this.mDownX;
                        EmotionView.this.gaP = EmotionView.this.mDownY;
                        EmotionView.this.gaM = System.currentTimeMillis();
                        if (EmotionView.this.bzS()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.gaM), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.mIsTouching = false;
                        if (EmotionView.this.gaN) {
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
        this.gaR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzS() {
        return this.gaR == null || this.gaR.bzS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.gaR == null || this.gaR.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long gaT;

        public b(long j) {
            this.gaT = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.mIsTouching && this.gaT == EmotionView.this.gaM && EmotionView.this.bzT()) {
                EmotionView.this.bzU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzT() {
        return Math.abs(this.gaO - this.mDownX) < this.mTouchSlop && Math.abs(this.gaP - this.mDownY) < this.mTouchSlop;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzU() {
        if (!this.gaN && bzS() && this.gaK != null && !TextUtils.isEmpty(this.gaK.getPicUrl())) {
            if (this.gaR != null) {
                this.gaR.bzV();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.gaL == null) {
                this.gaL = new EmotionPreview(getContext());
            }
            this.gaL.a(this.gaK.getPicUrl(), this.gaK.getThumbUrl(), this.mIsGif, this.gaQ);
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
            if (this.gaL.getParent() != null && this.gaL.getParent() == this.mDecorView) {
                this.mDecorView.removeView(this.gaL);
            }
            this.mDecorView.addView(this.gaL, layoutParams);
            this.gaN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.gaL != null && this.gaN) {
            if (this.gaR != null) {
                this.gaR.bzW();
            }
            if (this.gaL.getParent() != null && this.gaL.getParent() == this.mDecorView) {
                this.mDecorView.removeView(this.gaL);
            }
            this.gaN = false;
        }
    }

    public void setLoadProcType(int i) {
        this.gaQ = i;
    }

    public int getLoadProcType() {
        return this.gaQ;
    }
}

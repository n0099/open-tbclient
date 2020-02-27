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
    private EmotionImageData gaI;
    private EmotionPreview gaJ;
    private long gaK;
    private boolean gaL;
    private float gaM;
    private float gaN;
    private int gaO;
    private a gaP;
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
        boolean bzQ();

        void bzT();

        void bzU();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.gaO = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaO = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaO = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.gaI;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.gaI = emotionImageData;
            setTag(this.gaI.getThumbUrl());
            if (this.gaO == 20) {
                b(this.gaI);
            } else {
                startLoad(this.gaI.getThumbUrl(), this.gaO, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.gaI = null;
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

    public void bzP() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.mIsTouching = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.gaM = EmotionView.this.mDownX;
                        EmotionView.this.gaN = EmotionView.this.mDownY;
                        EmotionView.this.gaK = System.currentTimeMillis();
                        if (EmotionView.this.bzQ()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.gaK), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.mIsTouching = false;
                        if (EmotionView.this.gaL) {
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
        this.gaP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzQ() {
        return this.gaP == null || this.gaP.bzQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.gaP == null || this.gaP.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long gaR;

        public b(long j) {
            this.gaR = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.mIsTouching && this.gaR == EmotionView.this.gaK && EmotionView.this.bzR()) {
                EmotionView.this.bzS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzR() {
        return Math.abs(this.gaM - this.mDownX) < this.mTouchSlop && Math.abs(this.gaN - this.mDownY) < this.mTouchSlop;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzS() {
        if (!this.gaL && bzQ() && this.gaI != null && !TextUtils.isEmpty(this.gaI.getPicUrl())) {
            if (this.gaP != null) {
                this.gaP.bzT();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.gaJ == null) {
                this.gaJ = new EmotionPreview(getContext());
            }
            this.gaJ.a(this.gaI.getPicUrl(), this.gaI.getThumbUrl(), this.mIsGif, this.gaO);
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
            if (this.gaJ.getParent() != null && this.gaJ.getParent() == this.mDecorView) {
                this.mDecorView.removeView(this.gaJ);
            }
            this.mDecorView.addView(this.gaJ, layoutParams);
            this.gaL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.gaJ != null && this.gaL) {
            if (this.gaP != null) {
                this.gaP.bzU();
            }
            if (this.gaJ.getParent() != null && this.gaJ.getParent() == this.mDecorView) {
                this.mDecorView.removeView(this.gaJ);
            }
            this.gaL = false;
        }
    }

    public void setLoadProcType(int i) {
        this.gaO = i;
    }

    public int getLoadProcType() {
        return this.gaO;
    }
}

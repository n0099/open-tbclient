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
    private EmotionImageData gbF;
    private EmotionPreview gbG;
    private long gbH;
    private boolean gbI;
    private float gbJ;
    private float gbK;
    private int gbL;
    private a gbM;
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
        void bAc();

        void bAd();

        boolean bzZ();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.gbL = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbL = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbL = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.gbF;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.gbF = emotionImageData;
            setTag(this.gbF.getThumbUrl());
            if (this.gbL == 20) {
                b(this.gbF);
            } else {
                startLoad(this.gbF.getThumbUrl(), this.gbL, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.gbF = null;
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

    public void bzY() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.mIsTouching = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.gbJ = EmotionView.this.mDownX;
                        EmotionView.this.gbK = EmotionView.this.mDownY;
                        EmotionView.this.gbH = System.currentTimeMillis();
                        if (EmotionView.this.bzZ()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.gbH), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.mIsTouching = false;
                        if (EmotionView.this.gbI) {
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
        this.gbM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzZ() {
        return this.gbM == null || this.gbM.bzZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.gbM == null || this.gbM.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long gbO;

        public b(long j) {
            this.gbO = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.mIsTouching && this.gbO == EmotionView.this.gbH && EmotionView.this.bAa()) {
                EmotionView.this.bAb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAa() {
        return Math.abs(this.gbJ - this.mDownX) < this.mTouchSlop && Math.abs(this.gbK - this.mDownY) < this.mTouchSlop;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAb() {
        if (!this.gbI && bzZ() && this.gbF != null && !TextUtils.isEmpty(this.gbF.getPicUrl())) {
            if (this.gbM != null) {
                this.gbM.bAc();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.gbG == null) {
                this.gbG = new EmotionPreview(getContext());
            }
            this.gbG.a(this.gbF.getPicUrl(), this.gbF.getThumbUrl(), this.mIsGif, this.gbL);
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
            if (this.gbG.getParent() != null && this.gbG.getParent() == this.mDecorView) {
                this.mDecorView.removeView(this.gbG);
            }
            this.mDecorView.addView(this.gbG, layoutParams);
            this.gbI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.gbG != null && this.gbI) {
            if (this.gbM != null) {
                this.gbM.bAd();
            }
            if (this.gbG.getParent() != null && this.gbG.getParent() == this.mDecorView) {
                this.mDecorView.removeView(this.gbG);
            }
            this.gbI = false;
        }
    }

    public void setLoadProcType(int i) {
        this.gbL = i;
    }

    public int getLoadProcType() {
        return this.gbL;
    }
}

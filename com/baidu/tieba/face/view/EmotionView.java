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
    private EmotionImageData gaX;
    private EmotionPreview gaY;
    private long gaZ;
    private boolean gba;
    private float gbb;
    private float gbc;
    private int gbd;
    private a gbe;
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
        boolean bzT();

        void bzW();

        void bzX();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.gbd = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbd = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbd = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.gaX;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.gaX = emotionImageData;
            setTag(this.gaX.getThumbUrl());
            if (this.gbd == 20) {
                b(this.gaX);
            } else {
                startLoad(this.gaX.getThumbUrl(), this.gbd, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.gaX = null;
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

    public void bzS() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.mIsTouching = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.gbb = EmotionView.this.mDownX;
                        EmotionView.this.gbc = EmotionView.this.mDownY;
                        EmotionView.this.gaZ = System.currentTimeMillis();
                        if (EmotionView.this.bzT()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.gaZ), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.mIsTouching = false;
                        if (EmotionView.this.gba) {
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
        this.gbe = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzT() {
        return this.gbe == null || this.gbe.bzT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.gbe == null || this.gbe.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long gbg;

        public b(long j) {
            this.gbg = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.mIsTouching && this.gbg == EmotionView.this.gaZ && EmotionView.this.bzU()) {
                EmotionView.this.bzV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzU() {
        return Math.abs(this.gbb - this.mDownX) < this.mTouchSlop && Math.abs(this.gbc - this.mDownY) < this.mTouchSlop;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzV() {
        if (!this.gba && bzT() && this.gaX != null && !TextUtils.isEmpty(this.gaX.getPicUrl())) {
            if (this.gbe != null) {
                this.gbe.bzW();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.gaY == null) {
                this.gaY = new EmotionPreview(getContext());
            }
            this.gaY.a(this.gaX.getPicUrl(), this.gaX.getThumbUrl(), this.mIsGif, this.gbd);
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
            if (this.gaY.getParent() != null && this.gaY.getParent() == this.mDecorView) {
                this.mDecorView.removeView(this.gaY);
            }
            this.mDecorView.addView(this.gaY, layoutParams);
            this.gba = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.gaY != null && this.gba) {
            if (this.gbe != null) {
                this.gbe.bzX();
            }
            if (this.gaY.getParent() != null && this.gaY.getParent() == this.mDecorView) {
                this.mDecorView.removeView(this.gaY);
            }
            this.gba = false;
        }
    }

    public void setLoadProcType(int i) {
        this.gbd = i;
    }

    public int getLoadProcType() {
        return this.gbd;
    }
}

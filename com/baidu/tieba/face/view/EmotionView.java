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
    private float bUb;
    private EmotionImageData cLD;
    private EmotionPreview cLE;
    private FrameLayout cLF;
    private long cLG;
    private boolean cLH;
    private boolean cLI;
    private float cLJ;
    private int cLK;
    private a cLL;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean alC();

        void alF();

        void alG();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cLK = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cLK = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cLK = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.e(getContext(), d.e.ds240);
        this.mPreviewHeight = l.e(getContext(), d.e.ds260);
        this.cLJ = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cLD;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cLD = emotionImageData;
            setTag(this.cLD.getThumbUrl());
            if (this.cLK == 20) {
                b(this.cLD);
            } else {
                startLoad(this.cLD.getThumbUrl(), this.cLK, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cLD = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.fp().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void alB() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cLH = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bUb = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bUb;
                        EmotionView.this.cLG = System.currentTimeMillis();
                        if (EmotionView.this.alC()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cLG), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cLH = false;
                        if (EmotionView.this.cLI) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cLH = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cLL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alC() {
        return this.cLL == null || this.cLL.alC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cLL == null || this.cLL.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cLN;

        public b(long j) {
            this.cLN = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cLH && this.cLN == EmotionView.this.cLG && EmotionView.this.alD()) {
                EmotionView.this.alE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alD() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.cLJ && Math.abs(this.mCurrentY - this.bUb) < this.cLJ;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alE() {
        if (!this.cLI && alC() && this.cLD != null && !TextUtils.isEmpty(this.cLD.getPicUrl())) {
            if (this.cLL != null) {
                this.cLL.alF();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cLE == null) {
                this.cLE = new EmotionPreview(getContext());
            }
            this.cLE.a(this.cLD.getPicUrl(), this.cLD.getThumbUrl(), this.mIsGif, this.cLK);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.af(getContext())) {
                layoutParams.leftMargin = l.af(getContext()) - this.mPreviewWidth;
            }
            if (this.cLF == null) {
                this.cLF = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cLE.getParent() != null && this.cLE.getParent() == this.cLF) {
                this.cLF.removeView(this.cLE);
            }
            this.cLF.addView(this.cLE, layoutParams);
            this.cLI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cLE != null && this.cLI) {
            if (this.cLL != null) {
                this.cLL.alG();
            }
            if (this.cLE.getParent() != null && this.cLE.getParent() == this.cLF) {
                this.cLF.removeView(this.cLE);
            }
            this.cLI = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cLK = i;
    }

    public int getLoadProcType() {
        return this.cLK;
    }
}

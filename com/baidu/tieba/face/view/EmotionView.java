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
    private float bgY;
    private FrameLayout cVA;
    private long cVB;
    private boolean cVC;
    private boolean cVD;
    private float cVE;
    private int cVF;
    private a cVG;
    private EmotionImageData cVy;
    private EmotionPreview cVz;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean apD();

        void apG();

        void apH();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cVF = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVF = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVF = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.f(getContext(), d.e.ds240);
        this.mPreviewHeight = l.f(getContext(), d.e.ds260);
        this.cVE = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cVy;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cVy = emotionImageData;
            setTag(this.cVy.getThumbUrl());
            if (this.cVF == 20) {
                b(this.cVy);
            } else {
                startLoad(this.cVy.getThumbUrl(), this.cVF, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cVy = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.ih().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void apC() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cVC = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bgY = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bgY;
                        EmotionView.this.cVB = System.currentTimeMillis();
                        if (EmotionView.this.apD()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cVB), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cVC = false;
                        if (EmotionView.this.cVD) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cVC = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cVG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apD() {
        return this.cVG == null || this.cVG.apD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cVG == null || this.cVG.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cVI;

        public b(long j) {
            this.cVI = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cVC && this.cVI == EmotionView.this.cVB && EmotionView.this.apE()) {
                EmotionView.this.apF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apE() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.cVE && Math.abs(this.mCurrentY - this.bgY) < this.cVE;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apF() {
        if (!this.cVD && apD() && this.cVy != null && !TextUtils.isEmpty(this.cVy.getPicUrl())) {
            if (this.cVG != null) {
                this.cVG.apG();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cVz == null) {
                this.cVz = new EmotionPreview(getContext());
            }
            this.cVz.a(this.cVy.getPicUrl(), this.cVy.getThumbUrl(), this.mIsGif, this.cVF);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ah(getContext())) {
                layoutParams.leftMargin = l.ah(getContext()) - this.mPreviewWidth;
            }
            if (this.cVA == null) {
                this.cVA = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cVz.getParent() != null && this.cVz.getParent() == this.cVA) {
                this.cVA.removeView(this.cVz);
            }
            this.cVA.addView(this.cVz, layoutParams);
            this.cVD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cVz != null && this.cVD) {
            if (this.cVG != null) {
                this.cVG.apH();
            }
            if (this.cVz.getParent() != null && this.cVz.getParent() == this.cVA) {
                this.cVA.removeView(this.cVz);
            }
            this.cVD = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cVF = i;
    }

    public int getLoadProcType() {
        return this.cVF;
    }
}

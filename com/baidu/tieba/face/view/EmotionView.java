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
    private float cPp;
    private EmotionImageData eXL;
    private EmotionPreview eXM;
    private FrameLayout eXN;
    private long eXO;
    private boolean eXP;
    private boolean eXQ;
    private float eXR;
    private int eXS;
    private a eXT;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bfd();

        void bfg();

        void bfh();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.eXS = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXS = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eXS = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.g(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.g(getContext(), R.dimen.ds260);
        this.eXR = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.eXL;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.eXL = emotionImageData;
            setTag(this.eXL.getThumbUrl());
            if (this.eXS == 20) {
                b(this.eXL);
            } else {
                startLoad(this.eXL.getThumbUrl(), this.eXS, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.eXL = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.iv().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bfc() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.eXP = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cPp = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cPp;
                        EmotionView.this.eXO = System.currentTimeMillis();
                        if (EmotionView.this.bfd()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.eXO), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.eXP = false;
                        if (EmotionView.this.eXQ) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.eXP = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.eXT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfd() {
        return this.eXT == null || this.eXT.bfd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.eXT == null || this.eXT.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long eXV;

        public b(long j) {
            this.eXV = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.eXP && this.eXV == EmotionView.this.eXO && EmotionView.this.bfe()) {
                EmotionView.this.bff();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfe() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.eXR && Math.abs(this.mCurrentY - this.cPp) < this.eXR;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bff() {
        if (!this.eXQ && bfd() && this.eXL != null && !TextUtils.isEmpty(this.eXL.getPicUrl())) {
            if (this.eXT != null) {
                this.eXT.bfg();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.eXM == null) {
                this.eXM = new EmotionPreview(getContext());
            }
            this.eXM.a(this.eXL.getPicUrl(), this.eXL.getThumbUrl(), this.mIsGif, this.eXS);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.af(getContext())) {
                layoutParams.leftMargin = l.af(getContext()) - this.mPreviewWidth;
            }
            if (this.eXN == null) {
                this.eXN = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.eXM.getParent() != null && this.eXM.getParent() == this.eXN) {
                this.eXN.removeView(this.eXM);
            }
            this.eXN.addView(this.eXM, layoutParams);
            this.eXQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.eXM != null && this.eXQ) {
            if (this.eXT != null) {
                this.eXT.bfh();
            }
            if (this.eXM.getParent() != null && this.eXM.getParent() == this.eXN) {
                this.eXN.removeView(this.eXM);
            }
            this.eXQ = false;
        }
    }

    public void setLoadProcType(int i) {
        this.eXS = i;
    }

    public int getLoadProcType() {
        return this.eXS;
    }
}

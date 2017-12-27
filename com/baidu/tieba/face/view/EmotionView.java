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
    private float czf;
    private EmotionImageData dkc;
    private com.baidu.tieba.face.view.a dkd;
    private FrameLayout dke;
    private long dkf;
    private boolean dkg;
    private boolean dkh;
    private float dki;
    private int dkj;
    private a dkk;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean apo();

        void apr();

        void aps();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.dkj = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkj = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dkj = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.s(getContext(), d.e.ds240);
        this.mPreviewHeight = l.s(getContext(), d.e.ds260);
        this.dki = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.dkc;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.dkc = emotionImageData;
            setTag(this.dkc.getThumbUrl());
            if (this.dkj == 20) {
                b(this.dkc);
            } else {
                startLoad(this.dkc.getThumbUrl(), this.dkj, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.dkc = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.nl().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
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
        com.baidu.adp.widget.a.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a2;
        if (aVar != null) {
            aVar.a(this);
            setTag(null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void apn() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.dkg = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.czf = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.czf;
                        EmotionView.this.dkf = System.currentTimeMillis();
                        if (EmotionView.this.apo()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.dkf), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.dkg = false;
                        if (EmotionView.this.dkh) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.dkg = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.dkk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apo() {
        return this.dkk == null || this.dkk.apo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.dkk == null || this.dkk.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long dkm;

        public b(long j) {
            this.dkm = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.dkg && this.dkm == EmotionView.this.dkf && EmotionView.this.app()) {
                EmotionView.this.apq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean app() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.dki && Math.abs(this.mCurrentY - this.czf) < this.dki;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apq() {
        if (!this.dkh && apo() && this.dkc != null && !TextUtils.isEmpty(this.dkc.getPicUrl())) {
            if (this.dkk != null) {
                this.dkk.apr();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.dkd == null) {
                this.dkd = new com.baidu.tieba.face.view.a(getContext());
            }
            this.dkd.a(this.dkc.getPicUrl(), this.dkc.getThumbUrl(), this.mIsGif, this.dkj);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ao(getContext())) {
                layoutParams.leftMargin = l.ao(getContext()) - this.mPreviewWidth;
            }
            if (this.dke == null) {
                this.dke = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.dkd.getParent() != null && this.dkd.getParent() == this.dke) {
                this.dke.removeView(this.dkd);
            }
            this.dke.addView(this.dkd, layoutParams);
            this.dkh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.dkd != null && this.dkh) {
            if (this.dkk != null) {
                this.dkk.aps();
            }
            if (this.dkd.getParent() != null && this.dkd.getParent() == this.dke) {
                this.dke.removeView(this.dkd);
            }
            this.dkh = false;
        }
    }

    public void setLoadProcType(int i) {
        this.dkj = i;
    }

    public int getLoadProcType() {
        return this.dkj;
    }
}

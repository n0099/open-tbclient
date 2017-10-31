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
    private float EP;
    private float bCe;
    private EmotionImageData cmn;
    private com.baidu.tieba.face.view.a cmo;
    private FrameLayout cmp;
    private long cmq;
    private boolean cmr;
    private boolean cms;
    private float cmt;
    private int cmu;
    private a cmv;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean afI();

        void afL();

        void afM();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cmu = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmu = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmu = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.f(getContext(), d.e.ds240);
        this.mPreviewHeight = l.f(getContext(), d.e.ds260);
        this.cmt = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cmn;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cmn = emotionImageData;
            setTag(this.cmn.getThumbUrl());
            if (this.cmu == 20) {
                b(this.cmn);
            } else {
                startLoad(this.cmn.getThumbUrl(), this.cmu, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cmn = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.fJ().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void afH() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cmr = true;
                        EmotionView.this.EP = motionEvent.getRawX();
                        EmotionView.this.bCe = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.EP;
                        EmotionView.this.mCurrentY = EmotionView.this.bCe;
                        EmotionView.this.cmq = System.currentTimeMillis();
                        if (EmotionView.this.afI()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cmq), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cmr = false;
                        if (EmotionView.this.cms) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cmr = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cmv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afI() {
        return this.cmv == null || this.cmv.afI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cmv == null || this.cmv.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cmx;

        public b(long j) {
            this.cmx = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cmr && this.cmx == EmotionView.this.cmq && EmotionView.this.afJ()) {
                EmotionView.this.afK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afJ() {
        return Math.abs(this.mCurrentX - this.EP) < this.cmt && Math.abs(this.mCurrentY - this.bCe) < this.cmt;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afK() {
        if (!this.cms && afI() && this.cmn != null && !TextUtils.isEmpty(this.cmn.getPicUrl())) {
            if (this.cmv != null) {
                this.cmv.afL();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cmo == null) {
                this.cmo = new com.baidu.tieba.face.view.a(getContext());
            }
            this.cmo.a(this.cmn.getPicUrl(), this.cmn.getThumbUrl(), this.mIsGif, this.cmu);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ac(getContext())) {
                layoutParams.leftMargin = l.ac(getContext()) - this.mPreviewWidth;
            }
            if (this.cmp == null) {
                this.cmp = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cmo.getParent() != null && this.cmo.getParent() == this.cmp) {
                this.cmp.removeView(this.cmo);
            }
            this.cmp.addView(this.cmo, layoutParams);
            this.cms = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cmo != null && this.cms) {
            if (this.cmv != null) {
                this.cmv.afM();
            }
            if (this.cmo.getParent() != null && this.cmo.getParent() == this.cmp) {
                this.cmp.removeView(this.cmo);
            }
            this.cms = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cmu = i;
    }

    public int getLoadProcType() {
        return this.cmu;
    }
}

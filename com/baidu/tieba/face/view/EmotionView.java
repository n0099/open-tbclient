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
    private EmotionImageData cUJ;
    private EmotionPreview cUK;
    private FrameLayout cUL;
    private long cUM;
    private boolean cUN;
    private boolean cUO;
    private float cUP;
    private int cUQ;
    private a cUR;
    private float ccd;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean apI();

        void apL();

        void apM();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cUQ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUQ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cUQ = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.e(getContext(), d.e.ds240);
        this.mPreviewHeight = l.e(getContext(), d.e.ds260);
        this.cUP = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cUJ;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cUJ = emotionImageData;
            setTag(this.cUJ.getThumbUrl());
            if (this.cUQ == 20) {
                b(this.cUJ);
            } else {
                startLoad(this.cUJ.getThumbUrl(), this.cUQ, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cUJ = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.ig().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void apH() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cUN = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.ccd = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.ccd;
                        EmotionView.this.cUM = System.currentTimeMillis();
                        if (EmotionView.this.apI()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cUM), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cUN = false;
                        if (EmotionView.this.cUO) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cUN = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cUR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apI() {
        return this.cUR == null || this.cUR.apI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cUR == null || this.cUR.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cUT;

        public b(long j) {
            this.cUT = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cUN && this.cUT == EmotionView.this.cUM && EmotionView.this.apJ()) {
                EmotionView.this.apK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apJ() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.cUP && Math.abs(this.mCurrentY - this.ccd) < this.cUP;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apK() {
        if (!this.cUO && apI() && this.cUJ != null && !TextUtils.isEmpty(this.cUJ.getPicUrl())) {
            if (this.cUR != null) {
                this.cUR.apL();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cUK == null) {
                this.cUK = new EmotionPreview(getContext());
            }
            this.cUK.a(this.cUJ.getPicUrl(), this.cUJ.getThumbUrl(), this.mIsGif, this.cUQ);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ah(getContext())) {
                layoutParams.leftMargin = l.ah(getContext()) - this.mPreviewWidth;
            }
            if (this.cUL == null) {
                this.cUL = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cUK.getParent() != null && this.cUK.getParent() == this.cUL) {
                this.cUL.removeView(this.cUK);
            }
            this.cUL.addView(this.cUK, layoutParams);
            this.cUO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cUK != null && this.cUO) {
            if (this.cUR != null) {
                this.cUR.apM();
            }
            if (this.cUK.getParent() != null && this.cUK.getParent() == this.cUL) {
                this.cUL.removeView(this.cUK);
            }
            this.cUO = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cUQ = i;
    }

    public int getLoadProcType() {
        return this.cUQ;
    }
}

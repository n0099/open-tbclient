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
    private float cRJ;
    private EmotionImageData ffa;
    private EmotionPreview ffb;
    private FrameLayout ffc;
    private long ffd;
    private boolean ffe;
    private boolean fff;
    private float ffg;
    private int ffh;
    private a ffi;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bib();

        void bie();

        void bif();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.ffh = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ffh = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ffh = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.g(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.g(getContext(), R.dimen.ds260);
        this.ffg = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.ffa;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.ffa = emotionImageData;
            setTag(this.ffa.getThumbUrl());
            if (this.ffh == 20) {
                b(this.ffa);
            } else {
                startLoad(this.ffa.getThumbUrl(), this.ffh, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.ffa = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.iE().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bia() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.ffe = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cRJ = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cRJ;
                        EmotionView.this.ffd = System.currentTimeMillis();
                        if (EmotionView.this.bib()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.ffd), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.ffe = false;
                        if (EmotionView.this.fff) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.ffe = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.ffi = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bib() {
        return this.ffi == null || this.ffi.bib();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.ffi == null || this.ffi.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long ffk;

        public b(long j) {
            this.ffk = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.ffe && this.ffk == EmotionView.this.ffd && EmotionView.this.bic()) {
                EmotionView.this.bid();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bic() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.ffg && Math.abs(this.mCurrentY - this.cRJ) < this.ffg;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bid() {
        if (!this.fff && bib() && this.ffa != null && !TextUtils.isEmpty(this.ffa.getPicUrl())) {
            if (this.ffi != null) {
                this.ffi.bie();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.ffb == null) {
                this.ffb = new EmotionPreview(getContext());
            }
            this.ffb.a(this.ffa.getPicUrl(), this.ffa.getThumbUrl(), this.mIsGif, this.ffh);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.af(getContext())) {
                layoutParams.leftMargin = l.af(getContext()) - this.mPreviewWidth;
            }
            if (this.ffc == null) {
                this.ffc = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.ffb.getParent() != null && this.ffb.getParent() == this.ffc) {
                this.ffc.removeView(this.ffb);
            }
            this.ffc.addView(this.ffb, layoutParams);
            this.fff = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.ffb != null && this.fff) {
            if (this.ffi != null) {
                this.ffi.bif();
            }
            if (this.ffb.getParent() != null && this.ffb.getParent() == this.ffc) {
                this.ffc.removeView(this.ffb);
            }
            this.fff = false;
        }
    }

    public void setLoadProcType(int i) {
        this.ffh = i;
    }

    public int getLoadProcType() {
        return this.ffh;
    }
}

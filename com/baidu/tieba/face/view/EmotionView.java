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
    private float czA;
    private EmotionImageData doY;
    private com.baidu.tieba.face.view.a doZ;
    private FrameLayout dpa;
    private long dpb;
    private boolean dpc;
    private boolean dpd;
    private float dpe;
    private int dpf;
    private a dpg;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        void aqA();

        boolean aqw();

        void aqz();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.dpf = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dpf = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dpf = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.s(getContext(), d.e.ds240);
        this.mPreviewHeight = l.s(getContext(), d.e.ds260);
        this.dpe = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.doY;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.doY = emotionImageData;
            setTag(this.doY.getThumbUrl());
            if (this.dpf == 20) {
                b(this.doY);
            } else {
                startLoad(this.doY.getThumbUrl(), this.dpf, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.doY = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.nm().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void aqv() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.dpc = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.czA = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.czA;
                        EmotionView.this.dpb = System.currentTimeMillis();
                        if (EmotionView.this.aqw()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.dpb), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.dpc = false;
                        if (EmotionView.this.dpd) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.dpc = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.dpg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqw() {
        return this.dpg == null || this.dpg.aqw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.dpg == null || this.dpg.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long dpi;

        public b(long j) {
            this.dpi = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.dpc && this.dpi == EmotionView.this.dpb && EmotionView.this.aqx()) {
                EmotionView.this.aqy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqx() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.dpe && Math.abs(this.mCurrentY - this.czA) < this.dpe;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
        if (!this.dpd && aqw() && this.doY != null && !TextUtils.isEmpty(this.doY.getPicUrl())) {
            if (this.dpg != null) {
                this.dpg.aqz();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.doZ == null) {
                this.doZ = new com.baidu.tieba.face.view.a(getContext());
            }
            this.doZ.a(this.doY.getPicUrl(), this.doY.getThumbUrl(), this.mIsGif, this.dpf);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ao(getContext())) {
                layoutParams.leftMargin = l.ao(getContext()) - this.mPreviewWidth;
            }
            if (this.dpa == null) {
                this.dpa = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.doZ.getParent() != null && this.doZ.getParent() == this.dpa) {
                this.dpa.removeView(this.doZ);
            }
            this.dpa.addView(this.doZ, layoutParams);
            this.dpd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.doZ != null && this.dpd) {
            if (this.dpg != null) {
                this.dpg.aqA();
            }
            if (this.doZ.getParent() != null && this.doZ.getParent() == this.dpa) {
                this.dpa.removeView(this.doZ);
            }
            this.dpd = false;
        }
    }

    public void setLoadProcType(int i) {
        this.dpf = i;
    }

    public int getLoadProcType() {
        return this.dpf;
    }
}

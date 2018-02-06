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
    private float cDu;
    private EmotionImageData drR;
    private com.baidu.tieba.face.view.a drS;
    private FrameLayout drT;
    private long drU;
    private boolean drV;
    private boolean drW;
    private float drX;
    private int drY;
    private a drZ;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean arm();

        void arp();

        void arq();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.drY = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drY = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drY = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.t(getContext(), d.e.ds240);
        this.mPreviewHeight = l.t(getContext(), d.e.ds260);
        this.drX = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.drR;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.drR = emotionImageData;
            setTag(this.drR.getThumbUrl());
            if (this.drY == 20) {
                b(this.drR);
            } else {
                startLoad(this.drR.getThumbUrl(), this.drY, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.drR = null;
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

    public void arl() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.drV = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cDu = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cDu;
                        EmotionView.this.drU = System.currentTimeMillis();
                        if (EmotionView.this.arm()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.drU), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.drV = false;
                        if (EmotionView.this.drW) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.drV = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.drZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arm() {
        return this.drZ == null || this.drZ.arm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.drZ == null || this.drZ.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long dsb;

        public b(long j) {
            this.dsb = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.drV && this.dsb == EmotionView.this.drU && EmotionView.this.arn()) {
                EmotionView.this.aro();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arn() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.drX && Math.abs(this.mCurrentY - this.cDu) < this.drX;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aro() {
        if (!this.drW && arm() && this.drR != null && !TextUtils.isEmpty(this.drR.getPicUrl())) {
            if (this.drZ != null) {
                this.drZ.arp();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.drS == null) {
                this.drS = new com.baidu.tieba.face.view.a(getContext());
            }
            this.drS.a(this.drR.getPicUrl(), this.drR.getThumbUrl(), this.mIsGif, this.drY);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ao(getContext())) {
                layoutParams.leftMargin = l.ao(getContext()) - this.mPreviewWidth;
            }
            if (this.drT == null) {
                this.drT = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.drS.getParent() != null && this.drS.getParent() == this.drT) {
                this.drT.removeView(this.drS);
            }
            this.drT.addView(this.drS, layoutParams);
            this.drW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.drS != null && this.drW) {
            if (this.drZ != null) {
                this.drZ.arq();
            }
            if (this.drS.getParent() != null && this.drS.getParent() == this.drT) {
                this.drT.removeView(this.drS);
            }
            this.drW = false;
        }
    }

    public void setLoadProcType(int i) {
        this.drY = i;
    }

    public int getLoadProcType() {
        return this.drY;
    }
}

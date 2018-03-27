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
    private float cDl;
    private EmotionImageData drI;
    private com.baidu.tieba.face.view.a drJ;
    private FrameLayout drK;
    private long drL;
    private boolean drM;
    private boolean drN;
    private float drO;
    private int drP;
    private a drQ;
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
        this.drP = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drP = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drP = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.t(getContext(), d.e.ds240);
        this.mPreviewHeight = l.t(getContext(), d.e.ds260);
        this.drO = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.drI;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.drI = emotionImageData;
            setTag(this.drI.getThumbUrl());
            if (this.drP == 20) {
                b(this.drI);
            } else {
                startLoad(this.drI.getThumbUrl(), this.drP, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.drI = null;
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
                        EmotionView.this.drM = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cDl = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cDl;
                        EmotionView.this.drL = System.currentTimeMillis();
                        if (EmotionView.this.arm()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.drL), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.drM = false;
                        if (EmotionView.this.drN) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.drM = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.drQ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arm() {
        return this.drQ == null || this.drQ.arm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.drQ == null || this.drQ.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long drS;

        public b(long j) {
            this.drS = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.drM && this.drS == EmotionView.this.drL && EmotionView.this.arn()) {
                EmotionView.this.aro();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arn() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.drO && Math.abs(this.mCurrentY - this.cDl) < this.drO;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aro() {
        if (!this.drN && arm() && this.drI != null && !TextUtils.isEmpty(this.drI.getPicUrl())) {
            if (this.drQ != null) {
                this.drQ.arp();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.drJ == null) {
                this.drJ = new com.baidu.tieba.face.view.a(getContext());
            }
            this.drJ.a(this.drI.getPicUrl(), this.drI.getThumbUrl(), this.mIsGif, this.drP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ao(getContext())) {
                layoutParams.leftMargin = l.ao(getContext()) - this.mPreviewWidth;
            }
            if (this.drK == null) {
                this.drK = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.drJ.getParent() != null && this.drJ.getParent() == this.drK) {
                this.drK.removeView(this.drJ);
            }
            this.drK.addView(this.drJ, layoutParams);
            this.drN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.drJ != null && this.drN) {
            if (this.drQ != null) {
                this.drQ.arq();
            }
            if (this.drJ.getParent() != null && this.drJ.getParent() == this.drK) {
                this.drK.removeView(this.drJ);
            }
            this.drN = false;
        }
    }

    public void setLoadProcType(int i) {
        this.drP = i;
    }

    public int getLoadProcType() {
        return this.drP;
    }
}

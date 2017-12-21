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
    private float bKz;
    private EmotionImageData cvG;
    private com.baidu.tieba.face.view.a cvH;
    private FrameLayout cvI;
    private long cvJ;
    private boolean cvK;
    private boolean cvL;
    private float cvM;
    private int cvN;
    private a cvO;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean ahO();

        void ahR();

        void ahS();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cvN = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvN = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvN = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.f(getContext(), d.e.ds240);
        this.mPreviewHeight = l.f(getContext(), d.e.ds260);
        this.cvM = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cvG;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cvG = emotionImageData;
            setTag(this.cvG.getThumbUrl());
            if (this.cvN == 20) {
                b(this.cvG);
            } else {
                startLoad(this.cvG.getThumbUrl(), this.cvN, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cvG = null;
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

    public void ahN() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cvK = true;
                        EmotionView.this.EP = motionEvent.getRawX();
                        EmotionView.this.bKz = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.EP;
                        EmotionView.this.mCurrentY = EmotionView.this.bKz;
                        EmotionView.this.cvJ = System.currentTimeMillis();
                        if (EmotionView.this.ahO()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cvJ), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cvK = false;
                        if (EmotionView.this.cvL) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cvK = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cvO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahO() {
        return this.cvO == null || this.cvO.ahO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cvO == null || this.cvO.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cvQ;

        public b(long j) {
            this.cvQ = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cvK && this.cvQ == EmotionView.this.cvJ && EmotionView.this.ahP()) {
                EmotionView.this.ahQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahP() {
        return Math.abs(this.mCurrentX - this.EP) < this.cvM && Math.abs(this.mCurrentY - this.bKz) < this.cvM;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahQ() {
        if (!this.cvL && ahO() && this.cvG != null && !TextUtils.isEmpty(this.cvG.getPicUrl())) {
            if (this.cvO != null) {
                this.cvO.ahR();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cvH == null) {
                this.cvH = new com.baidu.tieba.face.view.a(getContext());
            }
            this.cvH.a(this.cvG.getPicUrl(), this.cvG.getThumbUrl(), this.mIsGif, this.cvN);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ac(getContext())) {
                layoutParams.leftMargin = l.ac(getContext()) - this.mPreviewWidth;
            }
            if (this.cvI == null) {
                this.cvI = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cvH.getParent() != null && this.cvH.getParent() == this.cvI) {
                this.cvI.removeView(this.cvH);
            }
            this.cvI.addView(this.cvH, layoutParams);
            this.cvL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cvH != null && this.cvL) {
            if (this.cvO != null) {
                this.cvO.ahS();
            }
            if (this.cvH.getParent() != null && this.cvH.getParent() == this.cvI) {
                this.cvI.removeView(this.cvH);
            }
            this.cvL = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cvN = i;
    }

    public int getLoadProcType() {
        return this.cvN;
    }
}

package com.baidu.tieba.face.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float cEl;
    private EmotionPreview iSA;
    private FrameLayout iSB;
    private long iSC;
    private boolean iSD;
    private boolean iSE;
    private float iSF;
    private float iSG;
    private float iSH;
    private int iSI;
    private a iSJ;
    private EmotionImageData iSz;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean cyi();

        void cyl();

        void cym();
    }

    public EmotionView(Context context) {
        super(context);
        this.iSI = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iSI = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iSI = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.iSH = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.iSz;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.iSz = emotionImageData;
            setTag(this.iSz.getThumbUrl());
            if (this.iSI == 20) {
                b(this.iSz);
            } else {
                startLoad(this.iSz.getThumbUrl(), this.iSI, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.iSz = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = d.mw().a(emotionImageData.getThumbUrl(), 20, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                if (aVar != null) {
                    EmotionView.this.mIsGif = aVar.isGif();
                    View findViewWithTag = EmotionView.this.findViewWithTag(str);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                        TbImageView tbImageView = (TbImageView) findViewWithTag;
                        aVar.drawImageTo(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
            }
        }, 0, 0, null, null, emotionImageData.getThumbUrl(), false, null);
        com.baidu.adp.widget.ImageView.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.ImageView.a)) ? null : (com.baidu.adp.widget.ImageView.a) a2;
        if (aVar != null) {
            aVar.drawImageTo(this);
            setTag(null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void cyh() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.iSD = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cEl = motionEvent.getRawY();
                        EmotionView.this.iSF = EmotionView.this.mDownX;
                        EmotionView.this.iSG = EmotionView.this.cEl;
                        EmotionView.this.iSC = System.currentTimeMillis();
                        if (EmotionView.this.cyi()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.iSC), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.iSD = false;
                        if (EmotionView.this.iSE) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.iSD = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.iSJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyi() {
        return this.iSJ == null || this.iSJ.cyi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.iSJ == null || this.iSJ.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long iSL;

        public b(long j) {
            this.iSL = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.iSD && this.iSL == EmotionView.this.iSC && EmotionView.this.cyj()) {
                EmotionView.this.cyk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyj() {
        return Math.abs(this.iSF - this.mDownX) < this.iSH && Math.abs(this.iSG - this.cEl) < this.iSH;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyk() {
        if (!this.iSE && cyi() && this.iSz != null && !TextUtils.isEmpty(this.iSz.getPicUrl())) {
            if (this.iSJ != null) {
                this.iSJ.cyl();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.iSA == null) {
                this.iSA = new EmotionPreview(getContext());
            }
            this.iSA.a(this.iSz.getPicUrl(), this.iSz.getThumbUrl(), this.mIsGif, this.iSI);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.iSB == null) {
                this.iSB = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.iSA.getParent() != null && this.iSA.getParent() == this.iSB) {
                this.iSB.removeView(this.iSA);
            }
            this.iSB.addView(this.iSA, layoutParams);
            this.iSE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.iSA != null && this.iSE) {
            if (this.iSJ != null) {
                this.iSJ.cym();
            }
            if (this.iSA.getParent() != null && this.iSA.getParent() == this.iSB) {
                this.iSB.removeView(this.iSA);
            }
            this.iSE = false;
        }
    }

    public void setLoadProcType(int i) {
        this.iSI = i;
    }

    public int getLoadProcType() {
        return this.iSI;
    }
}

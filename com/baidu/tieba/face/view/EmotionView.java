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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float cwD;
    private EmotionImageData itF;
    private EmotionPreview itG;
    private FrameLayout itH;
    private long itI;
    private boolean itJ;
    private boolean itK;
    private float itL;
    private float itM;
    private float itN;
    private int itO;
    private a itP;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean cuc();

        void cuf();

        void cug();
    }

    public EmotionView(Context context) {
        super(context);
        this.itO = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itO = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itO = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.itN = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.itF;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.itF = emotionImageData;
            setTag(this.itF.getThumbUrl());
            if (this.itO == 20) {
                b(this.itF);
            } else {
                startLoad(this.itF.getThumbUrl(), this.itO, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.itF = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.mS().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
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

    public void cub() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.itJ = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cwD = motionEvent.getRawY();
                        EmotionView.this.itL = EmotionView.this.mDownX;
                        EmotionView.this.itM = EmotionView.this.cwD;
                        EmotionView.this.itI = System.currentTimeMillis();
                        if (EmotionView.this.cuc()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.itI), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.itJ = false;
                        if (EmotionView.this.itK) {
                            EmotionView.this.RX();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.itJ = false;
                        EmotionView.this.RX();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.itP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cuc() {
        return this.itP == null || this.itP.cuc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.itP == null || this.itP.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long itR;

        public b(long j) {
            this.itR = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.itJ && this.itR == EmotionView.this.itI && EmotionView.this.cud()) {
                EmotionView.this.cue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cud() {
        return Math.abs(this.itL - this.mDownX) < this.itN && Math.abs(this.itM - this.cwD) < this.itN;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cue() {
        if (!this.itK && cuc() && this.itF != null && !TextUtils.isEmpty(this.itF.getPicUrl())) {
            if (this.itP != null) {
                this.itP.cuf();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.itG == null) {
                this.itG = new EmotionPreview(getContext());
            }
            this.itG.a(this.itF.getPicUrl(), this.itF.getThumbUrl(), this.mIsGif, this.itO);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.itH == null) {
                this.itH = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.itG.getParent() != null && this.itG.getParent() == this.itH) {
                this.itH.removeView(this.itG);
            }
            this.itH.addView(this.itG, layoutParams);
            this.itK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RX() {
        if (this.itG != null && this.itK) {
            if (this.itP != null) {
                this.itP.cug();
            }
            if (this.itG.getParent() != null && this.itG.getParent() == this.itH) {
                this.itH.removeView(this.itG);
            }
            this.itK = false;
        }
    }

    public void setLoadProcType(int i) {
        this.itO = i;
    }

    public int getLoadProcType() {
        return this.itO;
    }
}

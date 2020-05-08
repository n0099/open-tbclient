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
    private EmotionImageData gKT;
    private EmotionPreview gKU;
    private FrameLayout gKV;
    private long gKW;
    private boolean gKX;
    private boolean gKY;
    private float gKZ;
    private float gLa;
    private float gLb;
    private int gLc;
    private a gLd;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private float mDownY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        void bKB();

        void bKC();

        boolean bKy();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.gLc = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLc = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLc = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.gLb = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.gKT;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.gKT = emotionImageData;
            setTag(this.gKT.getThumbUrl());
            if (this.gLc == 20) {
                b(this.gKT);
            } else {
                startLoad(this.gKT.getThumbUrl(), this.gLc, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.gKT = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.kV().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bKx() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.gKX = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.gKZ = EmotionView.this.mDownX;
                        EmotionView.this.gLa = EmotionView.this.mDownY;
                        EmotionView.this.gKW = System.currentTimeMillis();
                        if (EmotionView.this.bKy()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.gKW), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.gKX = false;
                        if (EmotionView.this.gKY) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.gKX = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.gLd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKy() {
        return this.gLd == null || this.gLd.bKy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.gLd == null || this.gLd.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long gLf;

        public b(long j) {
            this.gLf = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.gKX && this.gLf == EmotionView.this.gKW && EmotionView.this.bKz()) {
                EmotionView.this.bKA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKz() {
        return Math.abs(this.gKZ - this.mDownX) < this.gLb && Math.abs(this.gLa - this.mDownY) < this.gLb;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKA() {
        if (!this.gKY && bKy() && this.gKT != null && !TextUtils.isEmpty(this.gKT.getPicUrl())) {
            if (this.gLd != null) {
                this.gLd.bKB();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.gKU == null) {
                this.gKU = new EmotionPreview(getContext());
            }
            this.gKU.a(this.gKT.getPicUrl(), this.gKT.getThumbUrl(), this.mIsGif, this.gLc);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.gKV == null) {
                this.gKV = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.gKU.getParent() != null && this.gKU.getParent() == this.gKV) {
                this.gKV.removeView(this.gKU);
            }
            this.gKV.addView(this.gKU, layoutParams);
            this.gKY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.gKU != null && this.gKY) {
            if (this.gLd != null) {
                this.gLd.bKC();
            }
            if (this.gKU.getParent() != null && this.gKU.getParent() == this.gKV) {
                this.gKV.removeView(this.gKU);
            }
            this.gKY = false;
        }
    }

    public void setLoadProcType(int i) {
        this.gLc = i;
    }

    public int getLoadProcType() {
        return this.gLc;
    }
}

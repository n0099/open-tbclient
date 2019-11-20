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
    private float dak;
    private EmotionImageData fgU;
    private EmotionPreview fgV;
    private FrameLayout fgW;
    private long fgX;
    private boolean fgY;
    private boolean fgZ;
    private float fha;
    private float fhb;
    private float fhc;
    private int fhd;
    private a fhe;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bfR();

        void bfU();

        void bfV();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.fhd = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhd = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fhd = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.fhc = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.fgU;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.fgU = emotionImageData;
            setTag(this.fgU.getThumbUrl());
            if (this.fhd == 20) {
                b(this.fgU);
            } else {
                startLoad(this.fgU.getThumbUrl(), this.fhd, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.fgU = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.fT().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
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

    public void bfQ() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.fgY = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.dak = motionEvent.getRawY();
                        EmotionView.this.fha = EmotionView.this.mDownX;
                        EmotionView.this.fhb = EmotionView.this.dak;
                        EmotionView.this.fgX = System.currentTimeMillis();
                        if (EmotionView.this.bfR()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.fgX), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.fgY = false;
                        if (EmotionView.this.fgZ) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.fgY = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.fhe = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfR() {
        return this.fhe == null || this.fhe.bfR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.fhe == null || this.fhe.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long fhg;

        public b(long j) {
            this.fhg = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.fgY && this.fhg == EmotionView.this.fgX && EmotionView.this.bfS()) {
                EmotionView.this.bfT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfS() {
        return Math.abs(this.fha - this.mDownX) < this.fhc && Math.abs(this.fhb - this.dak) < this.fhc;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfT() {
        if (!this.fgZ && bfR() && this.fgU != null && !TextUtils.isEmpty(this.fgU.getPicUrl())) {
            if (this.fhe != null) {
                this.fhe.bfU();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.fgV == null) {
                this.fgV = new EmotionPreview(getContext());
            }
            this.fgV.a(this.fgU.getPicUrl(), this.fgU.getThumbUrl(), this.mIsGif, this.fhd);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.fgW == null) {
                this.fgW = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.fgV.getParent() != null && this.fgV.getParent() == this.fgW) {
                this.fgW.removeView(this.fgV);
            }
            this.fgW.addView(this.fgV, layoutParams);
            this.fgZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.fgV != null && this.fgZ) {
            if (this.fhe != null) {
                this.fhe.bfV();
            }
            if (this.fgV.getParent() != null && this.fgV.getParent() == this.fgW) {
                this.fgW.removeView(this.fgV);
            }
            this.fgZ = false;
        }
    }

    public void setLoadProcType(int i) {
        this.fhd = i;
    }

    public int getLoadProcType() {
        return this.fhd;
    }
}

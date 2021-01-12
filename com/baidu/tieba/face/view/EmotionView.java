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
    private float cBP;
    private EmotionImageData iMS;
    private EmotionPreview iMT;
    private FrameLayout iMU;
    private long iMV;
    private boolean iMW;
    private boolean iMX;
    private float iMY;
    private float iMZ;
    private float iNa;
    private int iNb;
    private a iNc;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean cwX();

        void cxa();

        void cxb();
    }

    public EmotionView(Context context) {
        super(context);
        this.iNb = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iNb = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iNb = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.iNa = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.iMS;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.iMS = emotionImageData;
            setTag(this.iMS.getThumbUrl());
            if (this.iNb == 20) {
                b(this.iMS);
            } else {
                startLoad(this.iMS.getThumbUrl(), this.iNb, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.iMS = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = d.mx().a(emotionImageData.getThumbUrl(), 20, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void cwW() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.iMW = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cBP = motionEvent.getRawY();
                        EmotionView.this.iMY = EmotionView.this.mDownX;
                        EmotionView.this.iMZ = EmotionView.this.cBP;
                        EmotionView.this.iMV = System.currentTimeMillis();
                        if (EmotionView.this.cwX()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.iMV), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.iMW = false;
                        if (EmotionView.this.iMX) {
                            EmotionView.this.QW();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.iMW = false;
                        EmotionView.this.QW();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.iNc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cwX() {
        return this.iNc == null || this.iNc.cwX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.iNc == null || this.iNc.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long iNe;

        public b(long j) {
            this.iNe = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.iMW && this.iNe == EmotionView.this.iMV && EmotionView.this.cwY()) {
                EmotionView.this.cwZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cwY() {
        return Math.abs(this.iMY - this.mDownX) < this.iNa && Math.abs(this.iMZ - this.cBP) < this.iNa;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwZ() {
        if (!this.iMX && cwX() && this.iMS != null && !TextUtils.isEmpty(this.iMS.getPicUrl())) {
            if (this.iNc != null) {
                this.iNc.cxa();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.iMT == null) {
                this.iMT = new EmotionPreview(getContext());
            }
            this.iMT.a(this.iMS.getPicUrl(), this.iMS.getThumbUrl(), this.mIsGif, this.iNb);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.iMU == null) {
                this.iMU = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.iMT.getParent() != null && this.iMT.getParent() == this.iMU) {
                this.iMU.removeView(this.iMT);
            }
            this.iMU.addView(this.iMT, layoutParams);
            this.iMX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QW() {
        if (this.iMT != null && this.iMX) {
            if (this.iNc != null) {
                this.iNc.cxb();
            }
            if (this.iMT.getParent() != null && this.iMT.getParent() == this.iMU) {
                this.iMU.removeView(this.iMT);
            }
            this.iMX = false;
        }
    }

    public void setLoadProcType(int i) {
        this.iNb = i;
    }

    public int getLoadProcType() {
        return this.iNb;
    }
}

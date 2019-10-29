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
    private float dbc;
    private EmotionImageData fhL;
    private EmotionPreview fhM;
    private FrameLayout fhN;
    private long fhO;
    private boolean fhP;
    private boolean fhQ;
    private float fhR;
    private float fhS;
    private float fhT;
    private int fhU;
    private a fhV;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bfT();

        void bfW();

        void bfX();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.fhU = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhU = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fhU = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.fhT = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.fhL;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.fhL = emotionImageData;
            setTag(this.fhL.getThumbUrl());
            if (this.fhU == 20) {
                b(this.fhL);
            } else {
                startLoad(this.fhL.getThumbUrl(), this.fhU, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.fhL = null;
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

    public void bfS() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.fhP = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.dbc = motionEvent.getRawY();
                        EmotionView.this.fhR = EmotionView.this.mDownX;
                        EmotionView.this.fhS = EmotionView.this.dbc;
                        EmotionView.this.fhO = System.currentTimeMillis();
                        if (EmotionView.this.bfT()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.fhO), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.fhP = false;
                        if (EmotionView.this.fhQ) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.fhP = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.fhV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfT() {
        return this.fhV == null || this.fhV.bfT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.fhV == null || this.fhV.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long fhX;

        public b(long j) {
            this.fhX = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.fhP && this.fhX == EmotionView.this.fhO && EmotionView.this.bfU()) {
                EmotionView.this.bfV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfU() {
        return Math.abs(this.fhR - this.mDownX) < this.fhT && Math.abs(this.fhS - this.dbc) < this.fhT;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfV() {
        if (!this.fhQ && bfT() && this.fhL != null && !TextUtils.isEmpty(this.fhL.getPicUrl())) {
            if (this.fhV != null) {
                this.fhV.bfW();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.fhM == null) {
                this.fhM = new EmotionPreview(getContext());
            }
            this.fhM.a(this.fhL.getPicUrl(), this.fhL.getThumbUrl(), this.mIsGif, this.fhU);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.fhN == null) {
                this.fhN = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.fhM.getParent() != null && this.fhM.getParent() == this.fhN) {
                this.fhN.removeView(this.fhM);
            }
            this.fhN.addView(this.fhM, layoutParams);
            this.fhQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.fhM != null && this.fhQ) {
            if (this.fhV != null) {
                this.fhV.bfX();
            }
            if (this.fhM.getParent() != null && this.fhM.getParent() == this.fhN) {
                this.fhN.removeView(this.fhM);
            }
            this.fhQ = false;
        }
    }

    public void setLoadProcType(int i) {
        this.fhU = i;
    }

    public int getLoadProcType() {
        return this.fhU;
    }
}

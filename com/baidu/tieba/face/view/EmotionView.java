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
    private float cBL;
    private EmotionImageData iFl;
    private EmotionPreview iFm;
    private FrameLayout iFn;
    private long iFo;
    private boolean iFp;
    private boolean iFq;
    private float iFr;
    private float iFs;
    private float iFt;
    private int iFu;
    private a iFv;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean cxU();

        void cxX();

        void cxY();
    }

    public EmotionView(Context context) {
        super(context);
        this.iFu = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iFu = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iFu = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.iFt = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.iFl;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.iFl = emotionImageData;
            setTag(this.iFl.getThumbUrl());
            if (this.iFu == 20) {
                b(this.iFl);
            } else {
                startLoad(this.iFl.getThumbUrl(), this.iFu, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.iFl = null;
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

    public void cxT() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.iFp = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cBL = motionEvent.getRawY();
                        EmotionView.this.iFr = EmotionView.this.mDownX;
                        EmotionView.this.iFs = EmotionView.this.cBL;
                        EmotionView.this.iFo = System.currentTimeMillis();
                        if (EmotionView.this.cxU()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.iFo), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.iFp = false;
                        if (EmotionView.this.iFq) {
                            EmotionView.this.TM();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.iFp = false;
                        EmotionView.this.TM();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.iFv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxU() {
        return this.iFv == null || this.iFv.cxU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.iFv == null || this.iFv.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long iFx;

        public b(long j) {
            this.iFx = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.iFp && this.iFx == EmotionView.this.iFo && EmotionView.this.cxV()) {
                EmotionView.this.cxW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxV() {
        return Math.abs(this.iFr - this.mDownX) < this.iFt && Math.abs(this.iFs - this.cBL) < this.iFt;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxW() {
        if (!this.iFq && cxU() && this.iFl != null && !TextUtils.isEmpty(this.iFl.getPicUrl())) {
            if (this.iFv != null) {
                this.iFv.cxX();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.iFm == null) {
                this.iFm = new EmotionPreview(getContext());
            }
            this.iFm.a(this.iFl.getPicUrl(), this.iFl.getThumbUrl(), this.mIsGif, this.iFu);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.iFn == null) {
                this.iFn = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.iFm.getParent() != null && this.iFm.getParent() == this.iFn) {
                this.iFn.removeView(this.iFm);
            }
            this.iFn.addView(this.iFm, layoutParams);
            this.iFq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TM() {
        if (this.iFm != null && this.iFq) {
            if (this.iFv != null) {
                this.iFv.cxY();
            }
            if (this.iFm.getParent() != null && this.iFm.getParent() == this.iFn) {
                this.iFn.removeView(this.iFm);
            }
            this.iFq = false;
        }
    }

    public void setLoadProcType(int i) {
        this.iFu = i;
    }

    public int getLoadProcType() {
        return this.iFu;
    }
}

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
    private EmotionImageData iFn;
    private EmotionPreview iFo;
    private FrameLayout iFp;
    private long iFq;
    private boolean iFr;
    private boolean iFs;
    private float iFt;
    private float iFu;
    private float iFv;
    private int iFw;
    private a iFx;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean cxV();

        void cxY();

        void cxZ();
    }

    public EmotionView(Context context) {
        super(context);
        this.iFw = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iFw = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iFw = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.iFv = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.iFn;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.iFn = emotionImageData;
            setTag(this.iFn.getThumbUrl());
            if (this.iFw == 20) {
                b(this.iFn);
            } else {
                startLoad(this.iFn.getThumbUrl(), this.iFw, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.iFn = null;
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

    public void cxU() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.iFr = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cBL = motionEvent.getRawY();
                        EmotionView.this.iFt = EmotionView.this.mDownX;
                        EmotionView.this.iFu = EmotionView.this.cBL;
                        EmotionView.this.iFq = System.currentTimeMillis();
                        if (EmotionView.this.cxV()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.iFq), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.iFr = false;
                        if (EmotionView.this.iFs) {
                            EmotionView.this.TM();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.iFr = false;
                        EmotionView.this.TM();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.iFx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxV() {
        return this.iFx == null || this.iFx.cxV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.iFx == null || this.iFx.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long iFz;

        public b(long j) {
            this.iFz = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.iFr && this.iFz == EmotionView.this.iFq && EmotionView.this.cxW()) {
                EmotionView.this.cxX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cxW() {
        return Math.abs(this.iFt - this.mDownX) < this.iFv && Math.abs(this.iFu - this.cBL) < this.iFv;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxX() {
        if (!this.iFs && cxV() && this.iFn != null && !TextUtils.isEmpty(this.iFn.getPicUrl())) {
            if (this.iFx != null) {
                this.iFx.cxY();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.iFo == null) {
                this.iFo = new EmotionPreview(getContext());
            }
            this.iFo.a(this.iFn.getPicUrl(), this.iFn.getThumbUrl(), this.mIsGif, this.iFw);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.iFp == null) {
                this.iFp = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.iFo.getParent() != null && this.iFo.getParent() == this.iFp) {
                this.iFp.removeView(this.iFo);
            }
            this.iFp.addView(this.iFo, layoutParams);
            this.iFs = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TM() {
        if (this.iFo != null && this.iFs) {
            if (this.iFx != null) {
                this.iFx.cxZ();
            }
            if (this.iFo.getParent() != null && this.iFo.getParent() == this.iFp) {
                this.iFp.removeView(this.iFo);
            }
            this.iFs = false;
        }
    }

    public void setLoadProcType(int i) {
        this.iFw = i;
    }

    public int getLoadProcType() {
        return this.iFw;
    }
}

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
    private EmotionImageData hmc;
    private EmotionPreview hmd;
    private FrameLayout hme;
    private long hmf;
    private boolean hmg;
    private boolean hmh;
    private float hmi;
    private float hmj;
    private float hmk;
    private int hml;
    private a hmm;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private float mDownY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bTS();

        void bTV();

        void bTW();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.hml = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hml = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hml = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.hmk = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.hmc;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.hmc = emotionImageData;
            setTag(this.hmc.getThumbUrl());
            if (this.hml == 20) {
                b(this.hmc);
            } else {
                startLoad(this.hmc.getThumbUrl(), this.hml, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.hmc = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.ln().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bTR() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.hmg = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.hmi = EmotionView.this.mDownX;
                        EmotionView.this.hmj = EmotionView.this.mDownY;
                        EmotionView.this.hmf = System.currentTimeMillis();
                        if (EmotionView.this.bTS()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.hmf), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.hmg = false;
                        if (EmotionView.this.hmh) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.hmg = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.hmm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTS() {
        return this.hmm == null || this.hmm.bTS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.hmm == null || this.hmm.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long hmo;

        public b(long j) {
            this.hmo = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.hmg && this.hmo == EmotionView.this.hmf && EmotionView.this.bTT()) {
                EmotionView.this.bTU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTT() {
        return Math.abs(this.hmi - this.mDownX) < this.hmk && Math.abs(this.hmj - this.mDownY) < this.hmk;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTU() {
        if (!this.hmh && bTS() && this.hmc != null && !TextUtils.isEmpty(this.hmc.getPicUrl())) {
            if (this.hmm != null) {
                this.hmm.bTV();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.hmd == null) {
                this.hmd = new EmotionPreview(getContext());
            }
            this.hmd.a(this.hmc.getPicUrl(), this.hmc.getThumbUrl(), this.mIsGif, this.hml);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.hme == null) {
                this.hme = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.hmd.getParent() != null && this.hmd.getParent() == this.hme) {
                this.hme.removeView(this.hmd);
            }
            this.hme.addView(this.hmd, layoutParams);
            this.hmh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.hmd != null && this.hmh) {
            if (this.hmm != null) {
                this.hmm.bTW();
            }
            if (this.hmd.getParent() != null && this.hmd.getParent() == this.hme) {
                this.hme.removeView(this.hmd);
            }
            this.hmh = false;
        }
    }

    public void setLoadProcType(int i) {
        this.hml = i;
    }

    public int getLoadProcType() {
        return this.hml;
    }
}

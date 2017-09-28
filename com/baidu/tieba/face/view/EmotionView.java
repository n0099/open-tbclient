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
    private float Fd;
    private View.OnClickListener aPe;
    private float bxE;
    private EmotionImageData cff;
    private com.baidu.tieba.face.view.a cfg;
    private FrameLayout cfh;
    private long cfi;
    private boolean cfj;
    private boolean cfk;
    private float cfl;
    private int cfm;
    private a cfn;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean adF();

        boolean adG();

        void adJ();

        void adK();
    }

    public EmotionView(Context context) {
        super(context);
        this.cfm = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cfm = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cfm = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.f(getContext(), d.f.ds240);
        this.mPreviewHeight = l.f(getContext(), d.f.ds260);
        this.cfl = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cff;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cff = emotionImageData;
            setTag(this.cff.getThumbUrl());
            if (this.cfm == 20) {
                b(this.cff);
            } else {
                c(this.cff.getThumbUrl(), this.cfm, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cff = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.fJ().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                if (aVar != null) {
                    EmotionView.this.rx = aVar.isGif();
                    View findViewWithTag = EmotionView.this.findViewWithTag(str);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                        TbImageView tbImageView = (TbImageView) findViewWithTag;
                        aVar.a(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
            }
        }, 0, 0, null, null, emotionImageData.getThumbUrl(), false, null);
        com.baidu.adp.widget.ImageView.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.ImageView.a)) ? null : (com.baidu.adp.widget.ImageView.a) a2;
        if (aVar != null) {
            aVar.a(this);
            setTag(null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aPe = onClickListener;
    }

    public void adE() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cfj = true;
                        EmotionView.this.Fd = motionEvent.getRawX();
                        EmotionView.this.bxE = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.Fd;
                        EmotionView.this.mCurrentY = EmotionView.this.bxE;
                        EmotionView.this.cfi = System.currentTimeMillis();
                        if (EmotionView.this.adF()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cfi), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cfj = false;
                        if (EmotionView.this.cfk) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.aPe != null && EmotionView.this.adG()) {
                            EmotionView.this.aPe.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cfj = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cfn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adF() {
        return this.cfn == null || this.cfn.adF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adG() {
        return this.cfn == null || this.cfn.adG();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cfp;

        public b(long j) {
            this.cfp = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cfj && this.cfp == EmotionView.this.cfi && EmotionView.this.adH()) {
                EmotionView.this.adI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adH() {
        return Math.abs(this.mCurrentX - this.Fd) < this.cfl && Math.abs(this.mCurrentY - this.bxE) < this.cfl;
    }

    public boolean getIsGif() {
        return this.rx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adI() {
        if (!this.cfk && adF() && this.cff != null && !TextUtils.isEmpty(this.cff.getPicUrl())) {
            if (this.cfn != null) {
                this.cfn.adJ();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cfg == null) {
                this.cfg = new com.baidu.tieba.face.view.a(getContext());
            }
            this.cfg.a(this.cff.getPicUrl(), this.cff.getThumbUrl(), this.rx, this.cfm);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ad(getContext())) {
                layoutParams.leftMargin = l.ad(getContext()) - this.mPreviewWidth;
            }
            if (this.cfh == null) {
                this.cfh = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cfg.getParent() != null && this.cfg.getParent() == this.cfh) {
                this.cfh.removeView(this.cfg);
            }
            this.cfh.addView(this.cfg, layoutParams);
            this.cfk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cfg != null && this.cfk) {
            if (this.cfn != null) {
                this.cfn.adK();
            }
            if (this.cfg.getParent() != null && this.cfg.getParent() == this.cfh) {
                this.cfh.removeView(this.cfg);
            }
            this.cfk = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cfm = i;
    }

    public int getLoadProcType() {
        return this.cfm;
    }
}

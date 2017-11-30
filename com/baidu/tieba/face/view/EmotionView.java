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
    private float EP;
    private float bKr;
    private int cvA;
    private a cvB;
    private EmotionImageData cvt;
    private com.baidu.tieba.face.view.a cvu;
    private FrameLayout cvv;
    private long cvw;
    private boolean cvx;
    private boolean cvy;
    private float cvz;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean ahH();

        void ahK();

        void ahL();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cvA = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvA = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvA = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.f(getContext(), d.e.ds240);
        this.mPreviewHeight = l.f(getContext(), d.e.ds260);
        this.cvz = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cvt;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cvt = emotionImageData;
            setTag(this.cvt.getThumbUrl());
            if (this.cvA == 20) {
                b(this.cvt);
            } else {
                startLoad(this.cvt.getThumbUrl(), this.cvA, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cvt = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.fJ().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                if (aVar != null) {
                    EmotionView.this.mIsGif = aVar.isGif();
                    View findViewWithTag = EmotionView.this.findViewWithTag(str);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                        TbImageView tbImageView = (TbImageView) findViewWithTag;
                        aVar.a(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
            }
        }, 0, 0, null, null, emotionImageData.getThumbUrl(), false, null);
        com.baidu.adp.widget.a.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a2;
        if (aVar != null) {
            aVar.a(this);
            setTag(null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void ahG() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cvx = true;
                        EmotionView.this.EP = motionEvent.getRawX();
                        EmotionView.this.bKr = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.EP;
                        EmotionView.this.mCurrentY = EmotionView.this.bKr;
                        EmotionView.this.cvw = System.currentTimeMillis();
                        if (EmotionView.this.ahH()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cvw), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cvx = false;
                        if (EmotionView.this.cvy) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cvx = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cvB = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahH() {
        return this.cvB == null || this.cvB.ahH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cvB == null || this.cvB.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cvD;

        public b(long j) {
            this.cvD = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cvx && this.cvD == EmotionView.this.cvw && EmotionView.this.ahI()) {
                EmotionView.this.ahJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahI() {
        return Math.abs(this.mCurrentX - this.EP) < this.cvz && Math.abs(this.mCurrentY - this.bKr) < this.cvz;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahJ() {
        if (!this.cvy && ahH() && this.cvt != null && !TextUtils.isEmpty(this.cvt.getPicUrl())) {
            if (this.cvB != null) {
                this.cvB.ahK();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cvu == null) {
                this.cvu = new com.baidu.tieba.face.view.a(getContext());
            }
            this.cvu.a(this.cvt.getPicUrl(), this.cvt.getThumbUrl(), this.mIsGif, this.cvA);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ac(getContext())) {
                layoutParams.leftMargin = l.ac(getContext()) - this.mPreviewWidth;
            }
            if (this.cvv == null) {
                this.cvv = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cvu.getParent() != null && this.cvu.getParent() == this.cvv) {
                this.cvv.removeView(this.cvu);
            }
            this.cvv.addView(this.cvu, layoutParams);
            this.cvy = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cvu != null && this.cvy) {
            if (this.cvB != null) {
                this.cvB.ahL();
            }
            if (this.cvu.getParent() != null && this.cvu.getParent() == this.cvv) {
                this.cvv.removeView(this.cvu);
            }
            this.cvy = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cvA = i;
    }

    public int getLoadProcType() {
        return this.cvA;
    }
}

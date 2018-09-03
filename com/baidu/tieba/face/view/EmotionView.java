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
import com.baidu.tieba.f;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float bgZ;
    private float cVA;
    private int cVB;
    private a cVC;
    private EmotionImageData cVu;
    private EmotionPreview cVv;
    private FrameLayout cVw;
    private long cVx;
    private boolean cVy;
    private boolean cVz;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean apD();

        void apG();

        void apH();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cVB = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVB = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVB = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.f(getContext(), f.e.ds240);
        this.mPreviewHeight = l.f(getContext(), f.e.ds260);
        this.cVA = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.cVu;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.cVu = emotionImageData;
            setTag(this.cVu.getThumbUrl());
            if (this.cVB == 20) {
                b(this.cVu);
            } else {
                startLoad(this.cVu.getThumbUrl(), this.cVB, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.cVu = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.ih().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
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
        com.baidu.adp.widget.ImageView.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.ImageView.a)) ? null : (com.baidu.adp.widget.ImageView.a) a2;
        if (aVar != null) {
            aVar.a(this);
            setTag(null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void apC() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.cVy = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bgZ = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bgZ;
                        EmotionView.this.cVx = System.currentTimeMillis();
                        if (EmotionView.this.apD()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.cVx), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.cVy = false;
                        if (EmotionView.this.cVz) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.cVy = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cVC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apD() {
        return this.cVC == null || this.cVC.apD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cVC == null || this.cVC.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cVE;

        public b(long j) {
            this.cVE = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.cVy && this.cVE == EmotionView.this.cVx && EmotionView.this.apE()) {
                EmotionView.this.apF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apE() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.cVA && Math.abs(this.mCurrentY - this.bgZ) < this.cVA;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apF() {
        if (!this.cVz && apD() && this.cVu != null && !TextUtils.isEmpty(this.cVu.getPicUrl())) {
            if (this.cVC != null) {
                this.cVC.apG();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.cVv == null) {
                this.cVv = new EmotionPreview(getContext());
            }
            this.cVv.a(this.cVu.getPicUrl(), this.cVu.getThumbUrl(), this.mIsGif, this.cVB);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ah(getContext())) {
                layoutParams.leftMargin = l.ah(getContext()) - this.mPreviewWidth;
            }
            if (this.cVw == null) {
                this.cVw = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.cVv.getParent() != null && this.cVv.getParent() == this.cVw) {
                this.cVw.removeView(this.cVv);
            }
            this.cVw.addView(this.cVv, layoutParams);
            this.cVz = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.cVv != null && this.cVz) {
            if (this.cVC != null) {
                this.cVC.apH();
            }
            if (this.cVv.getParent() != null && this.cVv.getParent() == this.cVw) {
                this.cVw.removeView(this.cVv);
            }
            this.cVz = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cVB = i;
    }

    public int getLoadProcType() {
        return this.cVB;
    }
}

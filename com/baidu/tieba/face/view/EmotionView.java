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
    private float cuT;
    private float iuA;
    private float iuB;
    private int iuC;
    private a iuD;
    private EmotionImageData iut;
    private EmotionPreview iuu;
    private FrameLayout iuv;
    private long iuw;
    private boolean iux;
    private boolean iuy;
    private float iuz;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean ctF();

        void ctI();

        void ctJ();
    }

    public EmotionView(Context context) {
        super(context);
        this.iuC = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iuC = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iuC = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.iuB = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.iut;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.iut = emotionImageData;
            setTag(this.iut.getThumbUrl());
            if (this.iuC == 20) {
                b(this.iut);
            } else {
                startLoad(this.iut.getThumbUrl(), this.iuC, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.iut = null;
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

    public void ctE() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.iux = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cuT = motionEvent.getRawY();
                        EmotionView.this.iuz = EmotionView.this.mDownX;
                        EmotionView.this.iuA = EmotionView.this.cuT;
                        EmotionView.this.iuw = System.currentTimeMillis();
                        if (EmotionView.this.ctF()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.iuw), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.iux = false;
                        if (EmotionView.this.iuy) {
                            EmotionView.this.Ro();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.iux = false;
                        EmotionView.this.Ro();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.iuD = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ctF() {
        return this.iuD == null || this.iuD.ctF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.iuD == null || this.iuD.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long iuF;

        public b(long j) {
            this.iuF = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.iux && this.iuF == EmotionView.this.iuw && EmotionView.this.ctG()) {
                EmotionView.this.ctH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ctG() {
        return Math.abs(this.iuz - this.mDownX) < this.iuB && Math.abs(this.iuA - this.cuT) < this.iuB;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctH() {
        if (!this.iuy && ctF() && this.iut != null && !TextUtils.isEmpty(this.iut.getPicUrl())) {
            if (this.iuD != null) {
                this.iuD.ctI();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.iuu == null) {
                this.iuu = new EmotionPreview(getContext());
            }
            this.iuu.a(this.iut.getPicUrl(), this.iut.getThumbUrl(), this.mIsGif, this.iuC);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.iuv == null) {
                this.iuv = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.iuu.getParent() != null && this.iuu.getParent() == this.iuv) {
                this.iuv.removeView(this.iuu);
            }
            this.iuv.addView(this.iuu, layoutParams);
            this.iuy = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ro() {
        if (this.iuu != null && this.iuy) {
            if (this.iuD != null) {
                this.iuD.ctJ();
            }
            if (this.iuu.getParent() != null && this.iuu.getParent() == this.iuv) {
                this.iuv.removeView(this.iuu);
            }
            this.iuy = false;
        }
    }

    public void setLoadProcType(int i) {
        this.iuC = i;
    }

    public int getLoadProcType() {
        return this.iuC;
    }
}

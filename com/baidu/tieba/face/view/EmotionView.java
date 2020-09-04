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
    private EmotionImageData hFk;
    private EmotionPreview hFl;
    private FrameLayout hFm;
    private long hFn;
    private boolean hFo;
    private boolean hFp;
    private float hFq;
    private float hFr;
    private float hFs;
    private int hFt;
    private a hFu;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private float mDownY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean chJ();

        void chM();

        void chN();
    }

    public EmotionView(Context context) {
        super(context);
        this.hFt = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFt = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hFt = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.hFs = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.hFk;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.hFk = emotionImageData;
            setTag(this.hFk.getThumbUrl());
            if (this.hFt == 20) {
                b(this.hFk);
            } else {
                startLoad(this.hFk.getThumbUrl(), this.hFt, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.hFk = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.mM().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void chI() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.hFo = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.hFq = EmotionView.this.mDownX;
                        EmotionView.this.hFr = EmotionView.this.mDownY;
                        EmotionView.this.hFn = System.currentTimeMillis();
                        if (EmotionView.this.chJ()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.hFn), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.hFo = false;
                        if (EmotionView.this.hFp) {
                            EmotionView.this.caY();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.hFo = false;
                        EmotionView.this.caY();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.hFu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chJ() {
        return this.hFu == null || this.hFu.chJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.hFu == null || this.hFu.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long hFw;

        public b(long j) {
            this.hFw = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.hFo && this.hFw == EmotionView.this.hFn && EmotionView.this.chK()) {
                EmotionView.this.chL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chK() {
        return Math.abs(this.hFq - this.mDownX) < this.hFs && Math.abs(this.hFr - this.mDownY) < this.hFs;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chL() {
        if (!this.hFp && chJ() && this.hFk != null && !TextUtils.isEmpty(this.hFk.getPicUrl())) {
            if (this.hFu != null) {
                this.hFu.chM();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.hFl == null) {
                this.hFl = new EmotionPreview(getContext());
            }
            this.hFl.a(this.hFk.getPicUrl(), this.hFk.getThumbUrl(), this.mIsGif, this.hFt);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.hFm == null) {
                this.hFm = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.hFl.getParent() != null && this.hFl.getParent() == this.hFm) {
                this.hFm.removeView(this.hFl);
            }
            this.hFm.addView(this.hFl, layoutParams);
            this.hFp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caY() {
        if (this.hFl != null && this.hFp) {
            if (this.hFu != null) {
                this.hFu.chN();
            }
            if (this.hFl.getParent() != null && this.hFl.getParent() == this.hFm) {
                this.hFm.removeView(this.hFl);
            }
            this.hFp = false;
        }
    }

    public void setLoadProcType(int i) {
        this.hFt = i;
    }

    public int getLoadProcType() {
        return this.hFt;
    }
}

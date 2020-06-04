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
    private EmotionImageData gZQ;
    private EmotionPreview gZR;
    private FrameLayout gZS;
    private long gZT;
    private boolean gZU;
    private boolean gZV;
    private float gZW;
    private float gZX;
    private float gZY;
    private int gZZ;
    private a haa;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private float mDownY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bQW();

        void bQZ();

        void bRa();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.gZZ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZZ = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gZZ = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.gZY = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.gZQ;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.gZQ = emotionImageData;
            setTag(this.gZQ.getThumbUrl());
            if (this.gZZ == 20) {
                b(this.gZQ);
            } else {
                startLoad(this.gZQ.getThumbUrl(), this.gZZ, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.gZQ = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.kX().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bQV() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.gZU = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.mDownY = motionEvent.getRawY();
                        EmotionView.this.gZW = EmotionView.this.mDownX;
                        EmotionView.this.gZX = EmotionView.this.mDownY;
                        EmotionView.this.gZT = System.currentTimeMillis();
                        if (EmotionView.this.bQW()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.gZT), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.gZU = false;
                        if (EmotionView.this.gZV) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.gZU = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.haa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQW() {
        return this.haa == null || this.haa.bQW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.haa == null || this.haa.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long hac;

        public b(long j) {
            this.hac = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.gZU && this.hac == EmotionView.this.gZT && EmotionView.this.bQX()) {
                EmotionView.this.bQY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQX() {
        return Math.abs(this.gZW - this.mDownX) < this.gZY && Math.abs(this.gZX - this.mDownY) < this.gZY;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQY() {
        if (!this.gZV && bQW() && this.gZQ != null && !TextUtils.isEmpty(this.gZQ.getPicUrl())) {
            if (this.haa != null) {
                this.haa.bQZ();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.gZR == null) {
                this.gZR = new EmotionPreview(getContext());
            }
            this.gZR.a(this.gZQ.getPicUrl(), this.gZQ.getThumbUrl(), this.mIsGif, this.gZZ);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.gZS == null) {
                this.gZS = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.gZR.getParent() != null && this.gZR.getParent() == this.gZS) {
                this.gZS.removeView(this.gZR);
            }
            this.gZS.addView(this.gZR, layoutParams);
            this.gZV = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.gZR != null && this.gZV) {
            if (this.haa != null) {
                this.haa.bRa();
            }
            if (this.gZR.getParent() != null && this.gZR.getParent() == this.gZS) {
                this.gZS.removeView(this.gZR);
            }
            this.gZV = false;
        }
    }

    public void setLoadProcType(int i) {
        this.gZZ = i;
    }

    public int getLoadProcType() {
        return this.gZZ;
    }
}

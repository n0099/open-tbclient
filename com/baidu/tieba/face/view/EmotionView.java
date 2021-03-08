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
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float cFL;
    private boolean iUA;
    private boolean iUB;
    private float iUC;
    private float iUD;
    private float iUE;
    private int iUF;
    private a iUG;
    private EmotionImageData iUw;
    private EmotionPreview iUx;
    private FrameLayout iUy;
    private long iUz;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean cyv();

        void cyy();

        void cyz();
    }

    public EmotionView(Context context) {
        super(context);
        this.iUF = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iUF = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUF = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.iUE = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.iUw;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.iUw = emotionImageData;
            setTag(this.iUw.getThumbUrl());
            if (this.iUF == 20) {
                b(this.iUw);
            } else {
                startLoad(this.iUw.getThumbUrl(), this.iUF, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.iUw = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = d.mw().a(emotionImageData.getThumbUrl(), 20, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
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

    public void cyu() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.iUA = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cFL = motionEvent.getRawY();
                        EmotionView.this.iUC = EmotionView.this.mDownX;
                        EmotionView.this.iUD = EmotionView.this.cFL;
                        EmotionView.this.iUz = System.currentTimeMillis();
                        if (EmotionView.this.cyv()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.iUz), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.iUA = false;
                        if (EmotionView.this.iUB) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.iUA = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.iUG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyv() {
        return this.iUG == null || this.iUG.cyv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.iUG == null || this.iUG.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long iUI;

        public b(long j) {
            this.iUI = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.iUA && this.iUI == EmotionView.this.iUz && EmotionView.this.cyw()) {
                EmotionView.this.cyx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyw() {
        return Math.abs(this.iUC - this.mDownX) < this.iUE && Math.abs(this.iUD - this.cFL) < this.iUE;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyx() {
        if (!this.iUB && cyv() && this.iUw != null && !TextUtils.isEmpty(this.iUw.getPicUrl())) {
            if (this.iUG != null) {
                this.iUG.cyy();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.iUx == null) {
                this.iUx = new EmotionPreview(getContext());
            }
            this.iUx.a(this.iUw.getPicUrl(), this.iUw.getThumbUrl(), this.mIsGif, this.iUF);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.iUy == null) {
                this.iUy = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.iUx.getParent() != null && this.iUx.getParent() == this.iUy) {
                this.iUy.removeView(this.iUx);
            }
            this.iUy.addView(this.iUx, layoutParams);
            this.iUB = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.iUx != null && this.iUB) {
            if (this.iUG != null) {
                this.iUG.cyz();
            }
            if (this.iUx.getParent() != null && this.iUx.getParent() == this.iUy) {
                this.iUy.removeView(this.iUx);
            }
            this.iUB = false;
        }
    }

    public void setLoadProcType(int i) {
        this.iUF = i;
    }

    public int getLoadProcType() {
        return this.iUF;
    }
}

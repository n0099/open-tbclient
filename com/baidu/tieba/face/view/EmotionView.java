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
    private float Fe;
    private View.OnClickListener aOR;
    private float bxs;
    private EmotionImageData ceT;
    private com.baidu.tieba.face.view.a ceU;
    private FrameLayout ceV;
    private long ceW;
    private boolean ceX;
    private boolean ceY;
    private float ceZ;
    private int cfa;
    private a cfb;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean adB();

        void adE();

        void adF();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.cfa = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cfa = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cfa = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.f(getContext(), d.f.ds240);
        this.mPreviewHeight = l.f(getContext(), d.f.ds260);
        this.ceZ = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.ceT;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.ceT = emotionImageData;
            setTag(this.ceT.getThumbUrl());
            if (this.cfa == 20) {
                b(this.ceT);
            } else {
                c(this.ceT.getThumbUrl(), this.cfa, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.ceT = null;
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
                    EmotionView.this.ry = aVar.isGif();
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
        this.aOR = onClickListener;
    }

    public void adA() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.ceX = true;
                        EmotionView.this.Fe = motionEvent.getRawX();
                        EmotionView.this.bxs = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.Fe;
                        EmotionView.this.mCurrentY = EmotionView.this.bxs;
                        EmotionView.this.ceW = System.currentTimeMillis();
                        if (EmotionView.this.adB()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.ceW), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.ceX = false;
                        if (EmotionView.this.ceY) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.aOR != null && EmotionView.this.canClick()) {
                            EmotionView.this.aOR.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.ceX = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.cfb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adB() {
        return this.cfb == null || this.cfb.adB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.cfb == null || this.cfb.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long cfd;

        public b(long j) {
            this.cfd = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.ceX && this.cfd == EmotionView.this.ceW && EmotionView.this.adC()) {
                EmotionView.this.adD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adC() {
        return Math.abs(this.mCurrentX - this.Fe) < this.ceZ && Math.abs(this.mCurrentY - this.bxs) < this.ceZ;
    }

    public boolean getIsGif() {
        return this.ry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adD() {
        if (!this.ceY && adB() && this.ceT != null && !TextUtils.isEmpty(this.ceT.getPicUrl())) {
            if (this.cfb != null) {
                this.cfb.adE();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.ceU == null) {
                this.ceU = new com.baidu.tieba.face.view.a(getContext());
            }
            this.ceU.a(this.ceT.getPicUrl(), this.ceT.getThumbUrl(), this.ry, this.cfa);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.ad(getContext())) {
                layoutParams.leftMargin = l.ad(getContext()) - this.mPreviewWidth;
            }
            if (this.ceV == null) {
                this.ceV = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.ceU.getParent() != null && this.ceU.getParent() == this.ceV) {
                this.ceV.removeView(this.ceU);
            }
            this.ceV.addView(this.ceU, layoutParams);
            this.ceY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.ceU != null && this.ceY) {
            if (this.cfb != null) {
                this.cfb.adF();
            }
            if (this.ceU.getParent() != null && this.ceU.getParent() == this.ceV) {
                this.ceV.removeView(this.ceU);
            }
            this.ceY = false;
        }
    }

    public void setLoadProcType(int i) {
        this.cfa = i;
    }

    public int getLoadProcType() {
        return this.cfa;
    }
}

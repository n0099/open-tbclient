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
    private float cif;
    private EmotionImageData ibg;
    private EmotionPreview ibh;
    private FrameLayout ibi;
    private long ibj;
    private boolean ibk;
    private boolean ibl;
    private float ibm;
    private float ibn;
    private float ibo;
    private int ibp;
    private a ibq;
    private View.OnClickListener mClickListener;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean canClick();

        boolean cou();

        void cox();

        void coy();
    }

    public EmotionView(Context context) {
        super(context);
        this.ibp = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ibp = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ibp = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.getDimens(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.getDimens(getContext(), R.dimen.ds260);
        this.ibo = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.ibg;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.ibg = emotionImageData;
            setTag(this.ibg.getThumbUrl());
            if (this.ibp == 20) {
                b(this.ibg);
            } else {
                startLoad(this.ibg.getThumbUrl(), this.ibp, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.ibg = null;
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

    public void cot() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.ibk = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cif = motionEvent.getRawY();
                        EmotionView.this.ibm = EmotionView.this.mDownX;
                        EmotionView.this.ibn = EmotionView.this.cif;
                        EmotionView.this.ibj = System.currentTimeMillis();
                        if (EmotionView.this.cou()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.ibj), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.ibk = false;
                        if (EmotionView.this.ibl) {
                            EmotionView.this.chJ();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.ibk = false;
                        EmotionView.this.chJ();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.ibq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cou() {
        return this.ibq == null || this.ibq.cou();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.ibq == null || this.ibq.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long ibs;

        public b(long j) {
            this.ibs = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.ibk && this.ibs == EmotionView.this.ibj && EmotionView.this.cov()) {
                EmotionView.this.cow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cov() {
        return Math.abs(this.ibm - this.mDownX) < this.ibo && Math.abs(this.ibn - this.cif) < this.ibo;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cow() {
        if (!this.ibl && cou() && this.ibg != null && !TextUtils.isEmpty(this.ibg.getPicUrl())) {
            if (this.ibq != null) {
                this.ibq.cox();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.ibh == null) {
                this.ibh = new EmotionPreview(getContext());
            }
            this.ibh.a(this.ibg.getPicUrl(), this.ibg.getThumbUrl(), this.mIsGif, this.ibp);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = l.getEquipmentWidth(getContext()) - this.mPreviewWidth;
            }
            if (this.ibi == null) {
                this.ibi = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.ibh.getParent() != null && this.ibh.getParent() == this.ibi) {
                this.ibi.removeView(this.ibh);
            }
            this.ibi.addView(this.ibh, layoutParams);
            this.ibl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chJ() {
        if (this.ibh != null && this.ibl) {
            if (this.ibq != null) {
                this.ibq.coy();
            }
            if (this.ibh.getParent() != null && this.ibh.getParent() == this.ibi) {
                this.ibi.removeView(this.ibh);
            }
            this.ibl = false;
        }
    }

    public void setLoadProcType(int i) {
        this.ibp = i;
    }

    public int getLoadProcType() {
        return this.ibp;
    }
}

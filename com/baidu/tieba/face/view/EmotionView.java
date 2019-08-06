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
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float cQT;
    private EmotionImageData fdn;
    private EmotionPreview fdo;
    private FrameLayout fdp;
    private long fdq;
    private boolean fdr;
    private boolean fds;
    private float fdt;
    private int fdu;
    private a fdv;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean bhq();

        void bht();

        void bhu();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.fdu = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdu = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdu = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.g(getContext(), R.dimen.ds240);
        this.mPreviewHeight = l.g(getContext(), R.dimen.ds260);
        this.fdt = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.fdn;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.fdn = emotionImageData;
            setTag(this.fdn.getThumbUrl());
            if (this.fdu == 20) {
                b(this.fdn);
            } else {
                startLoad(this.fdn.getThumbUrl(), this.fdu, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.fdn = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.iE().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void bhp() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.fdr = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.cQT = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.cQT;
                        EmotionView.this.fdq = System.currentTimeMillis();
                        if (EmotionView.this.bhq()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.fdq), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.fdr = false;
                        if (EmotionView.this.fds) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.fdr = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.fdv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhq() {
        return this.fdv == null || this.fdv.bhq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.fdv == null || this.fdv.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long fdx;

        public b(long j) {
            this.fdx = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.fdr && this.fdx == EmotionView.this.fdq && EmotionView.this.bhr()) {
                EmotionView.this.bhs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhr() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.fdt && Math.abs(this.mCurrentY - this.cQT) < this.fdt;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhs() {
        if (!this.fds && bhq() && this.fdn != null && !TextUtils.isEmpty(this.fdn.getPicUrl())) {
            if (this.fdv != null) {
                this.fdv.bht();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.fdo == null) {
                this.fdo = new EmotionPreview(getContext());
            }
            this.fdo.a(this.fdn.getPicUrl(), this.fdn.getThumbUrl(), this.mIsGif, this.fdu);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.af(getContext())) {
                layoutParams.leftMargin = l.af(getContext()) - this.mPreviewWidth;
            }
            if (this.fdp == null) {
                this.fdp = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.fdo.getParent() != null && this.fdo.getParent() == this.fdp) {
                this.fdp.removeView(this.fdo);
            }
            this.fdp.addView(this.fdo, layoutParams);
            this.fds = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.fdo != null && this.fds) {
            if (this.fdv != null) {
                this.fdv.bhu();
            }
            if (this.fdo.getParent() != null && this.fdo.getParent() == this.fdp) {
                this.fdp.removeView(this.fdo);
            }
            this.fds = false;
        }
    }

    public void setLoadProcType(int i) {
        this.fdu = i;
    }

    public int getLoadProcType() {
        return this.fdu;
    }
}

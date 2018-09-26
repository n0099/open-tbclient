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
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
/* loaded from: classes.dex */
public class EmotionView extends TbImageView {
    private float bmR;
    private EmotionImageData dbn;
    private EmotionPreview dbo;
    private FrameLayout dbp;
    private long dbq;
    private boolean dbr;
    private boolean dbs;
    private float dbt;
    private int dbu;
    private a dbv;
    private View.OnClickListener mClickListener;
    private float mCurrentX;
    private float mCurrentY;
    private float mDownX;
    private int mPreviewHeight;
    private int mPreviewWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean arr();

        void aru();

        void arv();

        boolean canClick();
    }

    public EmotionView(Context context) {
        super(context);
        this.dbu = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dbu = 10;
        init();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dbu = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = l.h(getContext(), e.C0141e.ds240);
        this.mPreviewHeight = l.h(getContext(), e.C0141e.ds260);
        this.dbt = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public EmotionImageData getData() {
        return this.dbn;
    }

    public void a(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.dbn = emotionImageData;
            setTag(this.dbn.getThumbUrl());
            if (this.dbu == 20) {
                b(this.dbn);
            } else {
                startLoad(this.dbn.getThumbUrl(), this.dbu, false);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        this.dbn = null;
        setImageResource(0);
        super.reset();
    }

    private void b(EmotionImageData emotionImageData) {
        Object a2 = c.jn().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.EmotionView.1
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

    public void arq() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.face.view.EmotionView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionView.this.dbr = true;
                        EmotionView.this.mDownX = motionEvent.getRawX();
                        EmotionView.this.bmR = motionEvent.getRawY();
                        EmotionView.this.mCurrentX = EmotionView.this.mDownX;
                        EmotionView.this.mCurrentY = EmotionView.this.bmR;
                        EmotionView.this.dbq = System.currentTimeMillis();
                        if (EmotionView.this.arr()) {
                            EmotionView.this.postDelayed(new b(EmotionView.this.dbq), 500L);
                            break;
                        }
                        break;
                    case 1:
                        EmotionView.this.dbr = false;
                        if (EmotionView.this.dbs) {
                            EmotionView.this.stopPreview();
                            break;
                        } else if (EmotionView.this.mClickListener != null && EmotionView.this.canClick()) {
                            EmotionView.this.mClickListener.onClick(EmotionView.this);
                            break;
                        }
                        break;
                    case 3:
                        EmotionView.this.dbr = false;
                        EmotionView.this.stopPreview();
                        break;
                }
                return true;
            }
        });
    }

    public void setController(a aVar) {
        this.dbv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arr() {
        return this.dbv == null || this.dbv.arr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canClick() {
        return this.dbv == null || this.dbv.canClick();
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        private long dbx;

        public b(long j) {
            this.dbx = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.dbr && this.dbx == EmotionView.this.dbq && EmotionView.this.ars()) {
                EmotionView.this.art();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ars() {
        return Math.abs(this.mCurrentX - this.mDownX) < this.dbt && Math.abs(this.mCurrentY - this.bmR) < this.dbt;
    }

    public boolean getIsGif() {
        return this.mIsGif;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void art() {
        if (!this.dbs && arr() && this.dbn != null && !TextUtils.isEmpty(this.dbn.getPicUrl())) {
            if (this.dbv != null) {
                this.dbv.aru();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.dbo == null) {
                this.dbo = new EmotionPreview(getContext());
            }
            this.dbo.a(this.dbn.getPicUrl(), this.dbn.getThumbUrl(), this.mIsGif, this.dbu);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > l.aO(getContext())) {
                layoutParams.leftMargin = l.aO(getContext()) - this.mPreviewWidth;
            }
            if (this.dbp == null) {
                this.dbp = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.dbo.getParent() != null && this.dbo.getParent() == this.dbp) {
                this.dbp.removeView(this.dbo);
            }
            this.dbp.addView(this.dbo, layoutParams);
            this.dbs = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.dbo != null && this.dbs) {
            if (this.dbv != null) {
                this.dbv.arv();
            }
            if (this.dbo.getParent() != null && this.dbo.getParent() == this.dbp) {
                this.dbp.removeView(this.dbo);
            }
            this.dbs = false;
        }
    }

    public void setLoadProcType(int i) {
        this.dbu = i;
    }

    public int getLoadProcType() {
        return this.dbu;
    }
}

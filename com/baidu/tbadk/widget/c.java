package com.baidu.tbadk.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
public class c extends ImageView implements View.OnClickListener {
    private com.baidu.adp.gif.b Gu;
    private int aDT;
    private boolean aEo;
    private TbRichTextView.d aNB;
    private com.baidu.adp.widget.ImageView.a aNT;
    private Drawable aNU;
    private Drawable aNV;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aNW;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private String mUrl;

    public void setDispatchTouchListener(TbRichTextView.d dVar) {
        this.aNB = dVar;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.Gu == null) {
            return null;
        }
        return this.Gu;
    }

    public void setSupportNoImage(boolean z) {
        this.aEo = z;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.aNU != null || this.aNV != null)) {
            int intrinsicWidth = this.aNU.getIntrinsicWidth();
            int intrinsicHeight = this.aNU.getIntrinsicHeight();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (intrinsicWidth > measuredWidth) {
                intrinsicWidth = measuredWidth;
            }
            if (intrinsicHeight > measuredHeight) {
                intrinsicHeight = measuredHeight;
            }
            int paddingLeft = ((measuredWidth - intrinsicWidth) / 2) + getPaddingLeft();
            int paddingTop = ((measuredHeight - intrinsicHeight) / 2) + getPaddingTop();
            this.aNU.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.aNT;
    }

    public void play() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.aDT != 0) {
                this.aDT = 0;
            }
            gif.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aDT));
        }
    }

    public void stop() {
        if (getGif() != null) {
            this.mHandler.removeMessages(1);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aNB != null) {
            this.aNB.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aNT == null && this.aEo) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 33, this.aNW, 0, 0, false, null, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!isClickable()) {
            setClickable(true);
        }
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        if (this.Gu != null) {
            this.Gu.close();
            this.Gu = null;
        }
        if (this.aNT != null) {
            this.aNT = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.aDT = 0;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        if (this.Gu != null) {
            this.Gu.close();
            this.Gu = null;
        }
        if (this.aNT != null) {
            this.aNT = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.aDT = 0;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.Gu != null) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }
}

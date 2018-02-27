package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.gif.NSGif;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends ImageView implements View.OnClickListener {
    private com.baidu.adp.gif.b atW;
    private com.baidu.adp.widget.a.a bEK;
    private Drawable bEL;
    private Drawable bEM;
    private Drawable bEN;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> bEO;
    private final Rect bvR;
    private Bitmap mBitmap;
    private int mCurrentFrame;
    private TbRichTextView.f mDispatchTouchListener;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private boolean mSupportNoImage;
    private String mUrl;

    public d(Context context) {
        super(context);
        this.mSupportNoImage = true;
        this.bEL = aj.getDrawable(d.C0141d.common_color_10220);
        this.bEM = aj.getDrawable(d.f.icon_click);
        this.bEN = aj.getDrawable(d.f.img_default_100);
        this.bvR = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.d.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = d.this.getGif();
                if (gif != null && message.what == 1) {
                    d.this.mCurrentFrame++;
                    if (d.this.mCurrentFrame >= gif.getFrameCount()) {
                        d.this.mCurrentFrame = 0;
                    }
                    gif.cM(d.this.mCurrentFrame);
                    gif.a(d.this.mBitmap, null);
                    d.this.invalidate();
                    d.this.mHandler.removeMessages(1);
                    d.this.mHandler.sendEmptyMessageDelayed(1, gif.cN(d.this.mCurrentFrame));
                }
            }
        };
        this.bEO = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                if (aVar != null) {
                    d.this.e(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                com.baidu.adp.lib.f.c.nm().f(str, 33);
            }
        };
        init();
    }

    private void init() {
        setBackgroundDrawable(this.bEL);
        setOnClickListener(null);
    }

    public void setDispatchTouchListener(TbRichTextView.f fVar) {
        this.mDispatchTouchListener = fVar;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.atW == null) {
            return null;
        }
        return this.atW;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.bEL != null || this.bEM != null)) {
            int intrinsicWidth = this.bEL.getIntrinsicWidth();
            int intrinsicHeight = this.bEL.getIntrinsicHeight();
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
            this.bEL.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    public com.baidu.adp.widget.a.a getBdImage() {
        return this.bEK;
    }

    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            this.bEK = aVar;
            if (aVar.isGif() && aVar.sm() != null && aVar.sm().length > 0) {
                NSGif h = NSGif.h(aVar.sm(), 0, aVar.sm().length);
                if (h != null) {
                    this.atW = h;
                    this.atW.cM(0);
                    if (this.mBitmap == null || (this.mBitmap.getWidth() != this.atW.getWidth() && this.mBitmap.getHeight() != this.atW.getHeight())) {
                        this.mBitmap = Bitmap.createBitmap(this.atW.getWidth(), this.atW.getHeight(), Bitmap.Config.ARGB_4444);
                    }
                    this.atW.a(this.mBitmap, null);
                    setImageBitmap(this.mBitmap);
                    play();
                }
            } else if (aVar.sh() != null) {
                setImageBitmap(aVar.sh());
            }
        }
    }

    public void play() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.mCurrentFrame != 0) {
                this.mCurrentFrame = 0;
            }
            gif.cM(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.cN(this.mCurrentFrame));
        }
    }

    public void stop() {
        if (getGif() != null) {
            this.mHandler.removeMessages(1);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mDispatchTouchListener != null) {
            this.mDispatchTouchListener.F(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bEK == null && this.mSupportNoImage) {
            com.baidu.adp.lib.f.c.nm().a(this.mUrl, 33, this.bEO, 0, 0, false, null, new Object[0]);
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
        if (this.atW != null) {
            this.atW.close();
            this.atW = null;
        }
        if (this.bEK != null) {
            this.bEK = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.mCurrentFrame = 0;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        if (this.atW != null) {
            this.atW.close();
            this.atW = null;
        }
        if (this.bEK != null) {
            this.bEK = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.mCurrentFrame = 0;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.atW != null) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }
}

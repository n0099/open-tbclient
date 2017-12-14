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
public class c extends ImageView implements View.OnClickListener {
    private com.baidu.adp.gif.b Gf;
    private final Rect aFE;
    private com.baidu.adp.widget.a.a aOK;
    private Drawable aOL;
    private Drawable aOM;
    private Drawable aON;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aOO;
    private Bitmap mBitmap;
    private int mCurrentFrame;
    private TbRichTextView.e mDispatchTouchListener;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private boolean mSupportNoImage;
    private String mUrl;

    public c(Context context) {
        super(context);
        this.mSupportNoImage = true;
        this.aOL = aj.getDrawable(d.C0096d.common_color_10220);
        this.aOM = aj.getDrawable(d.f.icon_click);
        this.aON = aj.getDrawable(d.f.img_default_100);
        this.aFE = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = c.this.getGif();
                if (gif != null && message.what == 1) {
                    c.this.mCurrentFrame++;
                    if (c.this.mCurrentFrame >= gif.getFrameCount()) {
                        c.this.mCurrentFrame = 0;
                    }
                    gif.S(c.this.mCurrentFrame);
                    gif.a(c.this.mBitmap, null);
                    c.this.invalidate();
                    c.this.mHandler.removeMessages(1);
                    c.this.mHandler.sendEmptyMessageDelayed(1, gif.T(c.this.mCurrentFrame));
                }
            }
        };
        this.aOO = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                if (aVar != null) {
                    c.this.e(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                com.baidu.adp.lib.f.c.fJ().e(str, 33);
            }
        };
        init();
    }

    private void init() {
        setBackgroundDrawable(this.aOL);
        setOnClickListener(null);
    }

    public void setDispatchTouchListener(TbRichTextView.e eVar) {
        this.mDispatchTouchListener = eVar;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.Gf == null) {
            return null;
        }
        return this.Gf;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.aOL != null || this.aOM != null)) {
            int intrinsicWidth = this.aOL.getIntrinsicWidth();
            int intrinsicHeight = this.aOL.getIntrinsicHeight();
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
            this.aOL.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    public com.baidu.adp.widget.a.a getBdImage() {
        return this.aOK;
    }

    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            this.aOK = aVar;
            if (aVar.isGif() && aVar.kP() != null && aVar.kP().length > 0) {
                NSGif h = NSGif.h(aVar.kP(), 0, aVar.kP().length);
                if (h != null) {
                    this.Gf = h;
                    this.Gf.S(0);
                    if (this.mBitmap == null || (this.mBitmap.getWidth() != this.Gf.getWidth() && this.mBitmap.getHeight() != this.Gf.getHeight())) {
                        this.mBitmap = Bitmap.createBitmap(this.Gf.getWidth(), this.Gf.getHeight(), Bitmap.Config.ARGB_4444);
                    }
                    this.Gf.a(this.mBitmap, null);
                    setImageBitmap(this.mBitmap);
                    play();
                }
            } else if (aVar.kK() != null) {
                setImageBitmap(aVar.kK());
            }
        }
    }

    public void play() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.mCurrentFrame != 0) {
                this.mCurrentFrame = 0;
            }
            gif.S(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.T(this.mCurrentFrame));
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
            this.mDispatchTouchListener.s(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aOK == null && this.mSupportNoImage) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 33, this.aOO, 0, 0, false, null, new Object[0]);
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
        if (this.Gf != null) {
            this.Gf.close();
            this.Gf = null;
        }
        if (this.aOK != null) {
            this.aOK = null;
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
        if (this.Gf != null) {
            this.Gf.close();
            this.Gf = null;
        }
        if (this.aOK != null) {
            this.aOK = null;
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
        if (this.Gf != null) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }
}

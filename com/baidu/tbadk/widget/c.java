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
    private com.baidu.adp.gif.b Gg;
    private final Rect aFH;
    private com.baidu.adp.widget.a.a aON;
    private Drawable aOO;
    private Drawable aOP;
    private Drawable aOQ;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aOR;
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
        this.aOO = aj.getDrawable(d.C0095d.common_color_10220);
        this.aOP = aj.getDrawable(d.f.icon_click);
        this.aOQ = aj.getDrawable(d.f.img_default_100);
        this.aFH = new Rect();
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
        this.aOR = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.c.2
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
        setBackgroundDrawable(this.aOO);
        setOnClickListener(null);
    }

    public void setDispatchTouchListener(TbRichTextView.e eVar) {
        this.mDispatchTouchListener = eVar;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.Gg == null) {
            return null;
        }
        return this.Gg;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.aOO != null || this.aOP != null)) {
            int intrinsicWidth = this.aOO.getIntrinsicWidth();
            int intrinsicHeight = this.aOO.getIntrinsicHeight();
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
            this.aOO.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    public com.baidu.adp.widget.a.a getBdImage() {
        return this.aON;
    }

    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            this.aON = aVar;
            if (aVar.isGif() && aVar.kP() != null && aVar.kP().length > 0) {
                NSGif h = NSGif.h(aVar.kP(), 0, aVar.kP().length);
                if (h != null) {
                    this.Gg = h;
                    this.Gg.S(0);
                    if (this.mBitmap == null || (this.mBitmap.getWidth() != this.Gg.getWidth() && this.mBitmap.getHeight() != this.Gg.getHeight())) {
                        this.mBitmap = Bitmap.createBitmap(this.Gg.getWidth(), this.Gg.getHeight(), Bitmap.Config.ARGB_4444);
                    }
                    this.Gg.a(this.mBitmap, null);
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
        if (this.aON == null && this.mSupportNoImage) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 33, this.aOR, 0, 0, false, null, new Object[0]);
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
        if (this.Gg != null) {
            this.Gg.close();
            this.Gg = null;
        }
        if (this.aON != null) {
            this.aON = null;
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
        if (this.Gg != null) {
            this.Gg.close();
            this.Gg = null;
        }
        if (this.aON != null) {
            this.aON = null;
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
        if (this.Gg != null) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }
}

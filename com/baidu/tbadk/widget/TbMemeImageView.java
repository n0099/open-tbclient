package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.gif.NSGif;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {
    private com.baidu.adp.gif.b KI;
    private final Rect aPJ;
    private com.baidu.adp.widget.ImageView.a aYe;
    private Drawable aYf;
    private Drawable aYg;
    private Drawable aYh;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aYi;
    private Bitmap mBitmap;
    private int mCurrentFrame;
    private TbRichTextView.f mDispatchTouchListener;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private boolean mSupportNoImage;
    private String mUrl;

    public TbMemeImageView(Context context) {
        super(context);
        this.mSupportNoImage = true;
        this.aYf = am.getDrawable(d.C0142d.common_color_10220);
        this.aYg = am.getDrawable(d.f.icon_click);
        this.aYh = am.getDrawable(d.f.img_default_100);
        this.aPJ = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.mCurrentFrame++;
                    if (TbMemeImageView.this.mCurrentFrame >= gif.getFrameCount()) {
                        TbMemeImageView.this.mCurrentFrame = 0;
                    }
                    gif.N(TbMemeImageView.this.mCurrentFrame);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.O(TbMemeImageView.this.mCurrentFrame));
                }
            }
        };
        this.aYi = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                if (aVar != null) {
                    TbMemeImageView.this.e(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                com.baidu.adp.lib.f.c.ig().e(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSupportNoImage = true;
        this.aYf = am.getDrawable(d.C0142d.common_color_10220);
        this.aYg = am.getDrawable(d.f.icon_click);
        this.aYh = am.getDrawable(d.f.img_default_100);
        this.aPJ = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.mCurrentFrame++;
                    if (TbMemeImageView.this.mCurrentFrame >= gif.getFrameCount()) {
                        TbMemeImageView.this.mCurrentFrame = 0;
                    }
                    gif.N(TbMemeImageView.this.mCurrentFrame);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.O(TbMemeImageView.this.mCurrentFrame));
                }
            }
        };
        this.aYi = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (aVar != null) {
                    TbMemeImageView.this.e(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                com.baidu.adp.lib.f.c.ig().e(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSupportNoImage = true;
        this.aYf = am.getDrawable(d.C0142d.common_color_10220);
        this.aYg = am.getDrawable(d.f.icon_click);
        this.aYh = am.getDrawable(d.f.img_default_100);
        this.aPJ = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.mCurrentFrame++;
                    if (TbMemeImageView.this.mCurrentFrame >= gif.getFrameCount()) {
                        TbMemeImageView.this.mCurrentFrame = 0;
                    }
                    gif.N(TbMemeImageView.this.mCurrentFrame);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.O(TbMemeImageView.this.mCurrentFrame));
                }
            }
        };
        this.aYi = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (aVar != null) {
                    TbMemeImageView.this.e(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                com.baidu.adp.lib.f.c.ig().e(str, 33);
            }
        };
        init();
    }

    private void init() {
        setBackgroundDrawable(this.aYf);
        setOnClickListener(null);
    }

    public void setDispatchTouchListener(TbRichTextView.f fVar) {
        this.mDispatchTouchListener = fVar;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.KI == null) {
            return null;
        }
        return this.KI;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.aYf != null || this.aYg != null)) {
            int intrinsicWidth = this.aYf.getIntrinsicWidth();
            int intrinsicHeight = this.aYf.getIntrinsicHeight();
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
            this.aYf.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.aYe;
    }

    public void e(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.aYe = aVar;
            if (aVar.isGif() && aVar.ne() != null && aVar.ne().length > 0) {
                NSGif h = NSGif.h(aVar.ne(), 0, aVar.ne().length);
                if (h != null) {
                    this.KI = h;
                    this.KI.N(0);
                    if (this.mBitmap == null || (this.mBitmap.getWidth() != this.KI.getWidth() && this.mBitmap.getHeight() != this.KI.getHeight())) {
                        this.mBitmap = Bitmap.createBitmap(this.KI.getWidth(), this.KI.getHeight(), Bitmap.Config.ARGB_4444);
                    }
                    this.KI.a(this.mBitmap, null);
                    setImageBitmap(this.mBitmap);
                    play();
                }
            } else if (aVar.mZ() != null) {
                setImageBitmap(aVar.mZ());
            }
        }
    }

    public void play() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.mCurrentFrame != 0) {
                this.mCurrentFrame = 0;
            }
            gif.N(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.O(this.mCurrentFrame));
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
            this.mDispatchTouchListener.y(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aYe == null && this.mSupportNoImage) {
            com.baidu.adp.lib.f.c.ig().a(this.mUrl, 33, this.aYi, 0, 0, false, null, new Object[0]);
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
        if (this.KI != null) {
            this.KI.close();
            this.KI = null;
        }
        if (this.aYe != null) {
            this.aYe = null;
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
        if (this.KI != null) {
            this.KI.close();
            this.KI = null;
        }
        if (this.aYe != null) {
            this.aYe = null;
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
        if (this.KI != null) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }
}

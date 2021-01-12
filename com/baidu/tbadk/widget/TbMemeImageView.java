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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {
    private com.baidu.adp.gif.b Wi;
    private int baw;
    private TbRichTextView.g fDH;
    private final Rect fDy;
    private com.baidu.adp.widget.ImageView.a fNl;
    private Drawable fNm;
    private Drawable fNn;
    private Drawable fNo;
    private com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fNp;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private boolean mSupportNoImage;
    private String mUrl;

    public TbMemeImageView(Context context) {
        super(context);
        this.mSupportNoImage = true;
        this.fNm = ao.getDrawable(R.color.common_color_10220);
        this.fNn = ao.getDrawable(R.drawable.icon_click);
        this.fNo = ao.getDrawable(R.drawable.img_default_100);
        this.fDy = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.baw++;
                    if (TbMemeImageView.this.baw >= gif.getFrameCount()) {
                        TbMemeImageView.this.baw = 0;
                    }
                    gif.af(TbMemeImageView.this.baw);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.ag(TbMemeImageView.this.baw));
                }
            }
        };
        this.fNp = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                if (aVar != null) {
                    TbMemeImageView.this.f(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                com.baidu.adp.lib.e.d.mx().l(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSupportNoImage = true;
        this.fNm = ao.getDrawable(R.color.common_color_10220);
        this.fNn = ao.getDrawable(R.drawable.icon_click);
        this.fNo = ao.getDrawable(R.drawable.img_default_100);
        this.fDy = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.baw++;
                    if (TbMemeImageView.this.baw >= gif.getFrameCount()) {
                        TbMemeImageView.this.baw = 0;
                    }
                    gif.af(TbMemeImageView.this.baw);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.ag(TbMemeImageView.this.baw));
                }
            }
        };
        this.fNp = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (aVar != null) {
                    TbMemeImageView.this.f(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                com.baidu.adp.lib.e.d.mx().l(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSupportNoImage = true;
        this.fNm = ao.getDrawable(R.color.common_color_10220);
        this.fNn = ao.getDrawable(R.drawable.icon_click);
        this.fNo = ao.getDrawable(R.drawable.img_default_100);
        this.fDy = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.baw++;
                    if (TbMemeImageView.this.baw >= gif.getFrameCount()) {
                        TbMemeImageView.this.baw = 0;
                    }
                    gif.af(TbMemeImageView.this.baw);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.ag(TbMemeImageView.this.baw));
                }
            }
        };
        this.fNp = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (aVar != null) {
                    TbMemeImageView.this.f(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                com.baidu.adp.lib.e.d.mx().l(str, 33);
            }
        };
        init();
    }

    private void init() {
        setBackgroundDrawable(this.fNm);
        setOnClickListener(null);
    }

    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.fDH = gVar;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.Wi == null) {
            return null;
        }
        return this.Wi;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.fNm != null || this.fNn != null)) {
            int intrinsicWidth = this.fNm.getIntrinsicWidth();
            int intrinsicHeight = this.fNm.getIntrinsicHeight();
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
            this.fNm.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.fNl;
    }

    public void f(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.fNl = aVar;
            if (aVar.isGif() && aVar.getByteData() != null && aVar.getByteData().length > 0) {
                NSGif g = NSGif.g(aVar.getByteData(), 0, aVar.getByteData().length);
                if (g != null) {
                    this.Wi = g;
                    this.Wi.af(0);
                    if (this.mBitmap == null || (this.mBitmap.getWidth() != this.Wi.getWidth() && this.mBitmap.getHeight() != this.Wi.getHeight())) {
                        this.mBitmap = Bitmap.createBitmap(this.Wi.getWidth(), this.Wi.getHeight(), Bitmap.Config.ARGB_4444);
                    }
                    this.Wi.a(this.mBitmap, null);
                    setImageBitmap(this.mBitmap);
                    play();
                }
            } else if (aVar.getRawBitmap() != null) {
                setImageBitmap(aVar.getRawBitmap());
            }
        }
    }

    public void play() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.baw != 0) {
                this.baw = 0;
            }
            gif.af(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.ag(this.baw));
        }
    }

    public void stop() {
        if (getGif() != null) {
            this.mHandler.removeMessages(1);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fDH != null) {
            this.fDH.L(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fNl == null && this.mSupportNoImage) {
            com.baidu.adp.lib.e.d.mx().a(this.mUrl, 33, this.fNp, 0, 0, false, null, new Object[0]);
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
        if (this.Wi != null) {
            this.Wi.close();
            this.Wi = null;
        }
        if (this.fNl != null) {
            this.fNl = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.baw = 0;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        if (this.Wi != null) {
            this.Wi.close();
            this.Wi = null;
        }
        if (this.fNl != null) {
            this.fNl = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.baw = 0;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.Wi != null) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }
}

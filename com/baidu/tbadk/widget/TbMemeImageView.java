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
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {
    private com.baidu.adp.gif.b Tz;
    private int aKf;
    private TbRichTextView.g eoK;
    private com.baidu.adp.widget.ImageView.a exh;
    private Drawable exi;
    private Drawable exj;
    private Drawable exk;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> exl;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private boolean mSupportNoImage;
    private String mUrl;
    private final Rect srcRect;

    public TbMemeImageView(Context context) {
        super(context);
        this.mSupportNoImage = true;
        this.exi = am.getDrawable(R.color.common_color_10220);
        this.exj = am.getDrawable(R.drawable.icon_click);
        this.exk = am.getDrawable(R.drawable.img_default_100);
        this.srcRect = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.aKf++;
                    if (TbMemeImageView.this.aKf >= gif.getFrameCount()) {
                        TbMemeImageView.this.aKf = 0;
                    }
                    gif.R(TbMemeImageView.this.aKf);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.S(TbMemeImageView.this.aKf));
                }
            }
        };
        this.exl = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                if (aVar != null) {
                    TbMemeImageView.this.g(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                com.baidu.adp.lib.e.c.kX().k(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSupportNoImage = true;
        this.exi = am.getDrawable(R.color.common_color_10220);
        this.exj = am.getDrawable(R.drawable.icon_click);
        this.exk = am.getDrawable(R.drawable.img_default_100);
        this.srcRect = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.aKf++;
                    if (TbMemeImageView.this.aKf >= gif.getFrameCount()) {
                        TbMemeImageView.this.aKf = 0;
                    }
                    gif.R(TbMemeImageView.this.aKf);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.S(TbMemeImageView.this.aKf));
                }
            }
        };
        this.exl = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (aVar != null) {
                    TbMemeImageView.this.g(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                com.baidu.adp.lib.e.c.kX().k(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSupportNoImage = true;
        this.exi = am.getDrawable(R.color.common_color_10220);
        this.exj = am.getDrawable(R.drawable.icon_click);
        this.exk = am.getDrawable(R.drawable.img_default_100);
        this.srcRect = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.aKf++;
                    if (TbMemeImageView.this.aKf >= gif.getFrameCount()) {
                        TbMemeImageView.this.aKf = 0;
                    }
                    gif.R(TbMemeImageView.this.aKf);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.S(TbMemeImageView.this.aKf));
                }
            }
        };
        this.exl = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (aVar != null) {
                    TbMemeImageView.this.g(aVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                com.baidu.adp.lib.e.c.kX().k(str, 33);
            }
        };
        init();
    }

    private void init() {
        setBackgroundDrawable(this.exi);
        setOnClickListener(null);
    }

    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.eoK = gVar;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.Tz == null) {
            return null;
        }
        return this.Tz;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.exi != null || this.exj != null)) {
            int intrinsicWidth = this.exi.getIntrinsicWidth();
            int intrinsicHeight = this.exi.getIntrinsicHeight();
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
            this.exi.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.exh;
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.exh = aVar;
            if (aVar.isGif() && aVar.getByteData() != null && aVar.getByteData().length > 0) {
                NSGif g = NSGif.g(aVar.getByteData(), 0, aVar.getByteData().length);
                if (g != null) {
                    this.Tz = g;
                    this.Tz.R(0);
                    if (this.mBitmap == null || (this.mBitmap.getWidth() != this.Tz.getWidth() && this.mBitmap.getHeight() != this.Tz.getHeight())) {
                        this.mBitmap = Bitmap.createBitmap(this.Tz.getWidth(), this.Tz.getHeight(), Bitmap.Config.ARGB_4444);
                    }
                    this.Tz.a(this.mBitmap, null);
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
            if (this.aKf != 0) {
                this.aKf = 0;
            }
            gif.R(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.S(this.aKf));
        }
    }

    public void stop() {
        if (getGif() != null) {
            this.mHandler.removeMessages(1);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eoK != null) {
            this.eoK.w(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.exh == null && this.mSupportNoImage) {
            com.baidu.adp.lib.e.c.kX().a(this.mUrl, 33, this.exl, 0, 0, false, null, new Object[0]);
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
        if (this.Tz != null) {
            this.Tz.close();
            this.Tz = null;
        }
        if (this.exh != null) {
            this.exh = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.aKf = 0;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        if (this.Tz != null) {
            this.Tz.close();
            this.Tz = null;
        }
        if (this.exh != null) {
            this.exh = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.aKf = 0;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.Tz != null) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }
}

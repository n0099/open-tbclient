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
/* loaded from: classes6.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {
    private int ajO;
    private com.baidu.adp.widget.ImageView.a dEk;
    private Drawable dEl;
    private Drawable dEm;
    private Drawable dEn;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dEo;
    private TbRichTextView.g dwd;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private boolean mSupportNoImage;
    private String mUrl;
    private final Rect srcRect;
    private com.baidu.adp.gif.b zE;

    public TbMemeImageView(Context context) {
        super(context);
        this.mSupportNoImage = true;
        this.dEl = am.getDrawable(R.color.common_color_10220);
        this.dEm = am.getDrawable(R.drawable.icon_click);
        this.dEn = am.getDrawable(R.drawable.img_default_100);
        this.srcRect = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.ajO++;
                    if (TbMemeImageView.this.ajO >= gif.getFrameCount()) {
                        TbMemeImageView.this.ajO = 0;
                    }
                    gif.B(TbMemeImageView.this.ajO);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.C(TbMemeImageView.this.ajO));
                }
            }
        };
        this.dEo = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
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
                com.baidu.adp.lib.e.c.gr().g(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSupportNoImage = true;
        this.dEl = am.getDrawable(R.color.common_color_10220);
        this.dEm = am.getDrawable(R.drawable.icon_click);
        this.dEn = am.getDrawable(R.drawable.img_default_100);
        this.srcRect = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.ajO++;
                    if (TbMemeImageView.this.ajO >= gif.getFrameCount()) {
                        TbMemeImageView.this.ajO = 0;
                    }
                    gif.B(TbMemeImageView.this.ajO);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.C(TbMemeImageView.this.ajO));
                }
            }
        };
        this.dEo = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
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
                com.baidu.adp.lib.e.c.gr().g(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSupportNoImage = true;
        this.dEl = am.getDrawable(R.color.common_color_10220);
        this.dEm = am.getDrawable(R.drawable.icon_click);
        this.dEn = am.getDrawable(R.drawable.img_default_100);
        this.srcRect = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.ajO++;
                    if (TbMemeImageView.this.ajO >= gif.getFrameCount()) {
                        TbMemeImageView.this.ajO = 0;
                    }
                    gif.B(TbMemeImageView.this.ajO);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.C(TbMemeImageView.this.ajO));
                }
            }
        };
        this.dEo = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
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
                com.baidu.adp.lib.e.c.gr().g(str, 33);
            }
        };
        init();
    }

    private void init() {
        setBackgroundDrawable(this.dEl);
        setOnClickListener(null);
    }

    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.dwd = gVar;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.zE == null) {
            return null;
        }
        return this.zE;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.dEl != null || this.dEm != null)) {
            int intrinsicWidth = this.dEl.getIntrinsicWidth();
            int intrinsicHeight = this.dEl.getIntrinsicHeight();
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
            this.dEl.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.dEk;
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.dEk = aVar;
            if (aVar.isGif() && aVar.getByteData() != null && aVar.getByteData().length > 0) {
                NSGif e = NSGif.e(aVar.getByteData(), 0, aVar.getByteData().length);
                if (e != null) {
                    this.zE = e;
                    this.zE.B(0);
                    if (this.mBitmap == null || (this.mBitmap.getWidth() != this.zE.getWidth() && this.mBitmap.getHeight() != this.zE.getHeight())) {
                        this.mBitmap = Bitmap.createBitmap(this.zE.getWidth(), this.zE.getHeight(), Bitmap.Config.ARGB_4444);
                    }
                    this.zE.a(this.mBitmap, null);
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
            if (this.ajO != 0) {
                this.ajO = 0;
            }
            gif.B(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.C(this.ajO));
        }
    }

    public void stop() {
        if (getGif() != null) {
            this.mHandler.removeMessages(1);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dwd != null) {
            this.dwd.x(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dEk == null && this.mSupportNoImage) {
            com.baidu.adp.lib.e.c.gr().a(this.mUrl, 33, this.dEo, 0, 0, false, null, new Object[0]);
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
        if (this.zE != null) {
            this.zE.close();
            this.zE = null;
        }
        if (this.dEk != null) {
            this.dEk = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.ajO = 0;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        if (this.zE != null) {
            this.zE.close();
            this.zE = null;
        }
        if (this.dEk != null) {
            this.dEk = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.ajO = 0;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.zE != null) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }
}

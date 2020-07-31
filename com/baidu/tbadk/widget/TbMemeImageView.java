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
/* loaded from: classes15.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {
    private com.baidu.adp.gif.b TX;
    private int aOg;
    private TbRichTextView.g eDR;
    private com.baidu.adp.widget.ImageView.a eMW;
    private Drawable eMX;
    private Drawable eMY;
    private Drawable eMZ;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eNa;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private boolean mSupportNoImage;
    private String mUrl;
    private final Rect srcRect;

    public TbMemeImageView(Context context) {
        super(context);
        this.mSupportNoImage = true;
        this.eMX = ao.getDrawable(R.color.common_color_10220);
        this.eMY = ao.getDrawable(R.drawable.icon_click);
        this.eMZ = ao.getDrawable(R.drawable.img_default_100);
        this.srcRect = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.aOg++;
                    if (TbMemeImageView.this.aOg >= gif.getFrameCount()) {
                        TbMemeImageView.this.aOg = 0;
                    }
                    gif.Z(TbMemeImageView.this.aOg);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.aa(TbMemeImageView.this.aOg));
                }
            }
        };
        this.eNa = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
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
                com.baidu.adp.lib.e.c.ln().k(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSupportNoImage = true;
        this.eMX = ao.getDrawable(R.color.common_color_10220);
        this.eMY = ao.getDrawable(R.drawable.icon_click);
        this.eMZ = ao.getDrawable(R.drawable.img_default_100);
        this.srcRect = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.aOg++;
                    if (TbMemeImageView.this.aOg >= gif.getFrameCount()) {
                        TbMemeImageView.this.aOg = 0;
                    }
                    gif.Z(TbMemeImageView.this.aOg);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.aa(TbMemeImageView.this.aOg));
                }
            }
        };
        this.eNa = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
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
                com.baidu.adp.lib.e.c.ln().k(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSupportNoImage = true;
        this.eMX = ao.getDrawable(R.color.common_color_10220);
        this.eMY = ao.getDrawable(R.drawable.icon_click);
        this.eMZ = ao.getDrawable(R.drawable.img_default_100);
        this.srcRect = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.aOg++;
                    if (TbMemeImageView.this.aOg >= gif.getFrameCount()) {
                        TbMemeImageView.this.aOg = 0;
                    }
                    gif.Z(TbMemeImageView.this.aOg);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.aa(TbMemeImageView.this.aOg));
                }
            }
        };
        this.eNa = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
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
                com.baidu.adp.lib.e.c.ln().k(str, 33);
            }
        };
        init();
    }

    private void init() {
        setBackgroundDrawable(this.eMX);
        setOnClickListener(null);
    }

    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.eDR = gVar;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.TX == null) {
            return null;
        }
        return this.TX;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.eMX != null || this.eMY != null)) {
            int intrinsicWidth = this.eMX.getIntrinsicWidth();
            int intrinsicHeight = this.eMX.getIntrinsicHeight();
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
            this.eMX.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.eMW;
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.eMW = aVar;
            if (aVar.isGif() && aVar.getByteData() != null && aVar.getByteData().length > 0) {
                NSGif g = NSGif.g(aVar.getByteData(), 0, aVar.getByteData().length);
                if (g != null) {
                    this.TX = g;
                    this.TX.Z(0);
                    if (this.mBitmap == null || (this.mBitmap.getWidth() != this.TX.getWidth() && this.mBitmap.getHeight() != this.TX.getHeight())) {
                        this.mBitmap = Bitmap.createBitmap(this.TX.getWidth(), this.TX.getHeight(), Bitmap.Config.ARGB_4444);
                    }
                    this.TX.a(this.mBitmap, null);
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
            if (this.aOg != 0) {
                this.aOg = 0;
            }
            gif.Z(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.aa(this.aOg));
        }
    }

    public void stop() {
        if (getGif() != null) {
            this.mHandler.removeMessages(1);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eDR != null) {
            this.eDR.w(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eMW == null && this.mSupportNoImage) {
            com.baidu.adp.lib.e.c.ln().a(this.mUrl, 33, this.eNa, 0, 0, false, null, new Object[0]);
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
        if (this.TX != null) {
            this.TX.close();
            this.TX = null;
        }
        if (this.eMW != null) {
            this.eMW = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.aOg = 0;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        if (this.TX != null) {
            this.TX.close();
            this.TX = null;
        }
        if (this.eMW != null) {
            this.eMW = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.aOg = 0;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.TX != null) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }
}

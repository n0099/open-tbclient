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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {
    private com.baidu.adp.gif.b Vm;
    private int bbL;
    private com.baidu.adp.widget.ImageView.a fBb;
    private Drawable fBc;
    private Drawable fBd;
    private Drawable fBe;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> fBf;
    private final Rect frE;
    private TbRichTextView.g frN;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private boolean mSupportNoImage;
    private String mUrl;

    public TbMemeImageView(Context context) {
        super(context);
        this.mSupportNoImage = true;
        this.fBc = ap.getDrawable(R.color.common_color_10220);
        this.fBd = ap.getDrawable(R.drawable.icon_click);
        this.fBe = ap.getDrawable(R.drawable.img_default_100);
        this.frE = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.bbL++;
                    if (TbMemeImageView.this.bbL >= gif.getFrameCount()) {
                        TbMemeImageView.this.bbL = 0;
                    }
                    gif.ac(TbMemeImageView.this.bbL);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.ad(TbMemeImageView.this.bbL));
                }
            }
        };
        this.fBf = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
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
                com.baidu.adp.lib.e.c.mS().l(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSupportNoImage = true;
        this.fBc = ap.getDrawable(R.color.common_color_10220);
        this.fBd = ap.getDrawable(R.drawable.icon_click);
        this.fBe = ap.getDrawable(R.drawable.img_default_100);
        this.frE = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.bbL++;
                    if (TbMemeImageView.this.bbL >= gif.getFrameCount()) {
                        TbMemeImageView.this.bbL = 0;
                    }
                    gif.ac(TbMemeImageView.this.bbL);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.ad(TbMemeImageView.this.bbL));
                }
            }
        };
        this.fBf = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
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
                com.baidu.adp.lib.e.c.mS().l(str, 33);
            }
        };
        init();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSupportNoImage = true;
        this.fBc = ap.getDrawable(R.color.common_color_10220);
        this.fBd = ap.getDrawable(R.drawable.icon_click);
        this.fBe = ap.getDrawable(R.drawable.img_default_100);
        this.frE = new Rect();
        this.mHandler = new Handler() { // from class: com.baidu.tbadk.widget.TbMemeImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b gif = TbMemeImageView.this.getGif();
                if (gif != null && message.what == 1) {
                    TbMemeImageView.this.bbL++;
                    if (TbMemeImageView.this.bbL >= gif.getFrameCount()) {
                        TbMemeImageView.this.bbL = 0;
                    }
                    gif.ac(TbMemeImageView.this.bbL);
                    gif.a(TbMemeImageView.this.mBitmap, null);
                    TbMemeImageView.this.invalidate();
                    TbMemeImageView.this.mHandler.removeMessages(1);
                    TbMemeImageView.this.mHandler.sendEmptyMessageDelayed(1, gif.ad(TbMemeImageView.this.bbL));
                }
            }
        };
        this.fBf = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbMemeImageView.2
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
                com.baidu.adp.lib.e.c.mS().l(str, 33);
            }
        };
        init();
    }

    private void init() {
        setBackgroundDrawable(this.fBc);
        setOnClickListener(null);
    }

    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.frN = gVar;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.Vm == null) {
            return null;
        }
        return this.Vm;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.fBc != null || this.fBd != null)) {
            int intrinsicWidth = this.fBc.getIntrinsicWidth();
            int intrinsicHeight = this.fBc.getIntrinsicHeight();
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
            this.fBc.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.fBb;
    }

    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.fBb = aVar;
            if (aVar.isGif() && aVar.getByteData() != null && aVar.getByteData().length > 0) {
                NSGif g = NSGif.g(aVar.getByteData(), 0, aVar.getByteData().length);
                if (g != null) {
                    this.Vm = g;
                    this.Vm.ac(0);
                    if (this.mBitmap == null || (this.mBitmap.getWidth() != this.Vm.getWidth() && this.mBitmap.getHeight() != this.Vm.getHeight())) {
                        this.mBitmap = Bitmap.createBitmap(this.Vm.getWidth(), this.Vm.getHeight(), Bitmap.Config.ARGB_4444);
                    }
                    this.Vm.a(this.mBitmap, null);
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
            if (this.bbL != 0) {
                this.bbL = 0;
            }
            gif.ac(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.ad(this.bbL));
        }
    }

    public void stop() {
        if (getGif() != null) {
            this.mHandler.removeMessages(1);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.frN != null) {
            this.frN.L(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fBb == null && this.mSupportNoImage) {
            com.baidu.adp.lib.e.c.mS().a(this.mUrl, 33, this.fBf, 0, 0, false, null, new Object[0]);
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
        if (this.Vm != null) {
            this.Vm.close();
            this.Vm = null;
        }
        if (this.fBb != null) {
            this.fBb = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.bbL = 0;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        if (this.Vm != null) {
            this.Vm.close();
            this.Vm = null;
        }
        if (this.fBb != null) {
            this.fBb = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.bbL = 0;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.Vm != null) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }
}

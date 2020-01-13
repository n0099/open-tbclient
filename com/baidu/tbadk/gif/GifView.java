package com.baidu.tbadk.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.newwidget.ImageView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.h.d;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends TbImageView implements View.OnClickListener, h, Runnable {
    public static Bitmap dvQ;
    private int Nu;
    private int ajO;
    private boolean bwx;
    private final Rect destRect;
    private d dmN;
    private int dvL;
    private a dvM;
    private boolean dvN;
    private boolean dvO;
    private BitmapDrawable dvP;
    private float dvR;
    private boolean dvS;
    private Drawable dvT;
    private int dvU;
    private boolean dvV;
    private boolean dvW;
    private boolean dvX;
    private com.baidu.adp.widget.ImageView.a dvY;
    private String dvZ;
    private int dwa;
    private boolean dwb;
    private b<com.baidu.adp.widget.ImageView.a> dwc;
    private TbRichTextView.g dwd;
    private boolean loadFailed;
    private Bitmap mBitmap;
    private float mCurrentDegrees;
    private GifInfo mGifInfo;
    private Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private boolean mSupportNoImage;
    private int mType;
    private final Rect srcRect;
    private com.baidu.adp.gif.b zE;

    /* loaded from: classes.dex */
    public interface a {
        void onStop();
    }

    public void setErrorResid(int i) {
        this.dwa = i;
    }

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        BitmapDrawable bitmapDrawable;
        this.dvL = R.drawable.pic_expression_upload_selector;
        this.dvN = false;
        this.dvO = true;
        this.destRect = new Rect();
        this.srcRect = new Rect();
        this.bwx = true;
        this.dvV = false;
        this.dvW = false;
        this.dvX = false;
        this.dwa = R.drawable.image_group_load_f;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                com.baidu.adp.gif.b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.ajO++;
                    if (GifView.this.ajO >= gif.getFrameCount()) {
                        if (GifView.this.dwb) {
                            if (!GifView.this.dvV) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.dwb = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.dvV) {
                            GifView.this.ajO = 0;
                        } else {
                            GifView.this.ajO = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.B(GifView.this.ajO);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (!z) {
                        sendEmptyMessageDelayed(1, gif.C(GifView.this.ajO));
                    } else {
                        GifView.this.onStop();
                    }
                }
            }
        };
        this.mType = 20;
        this.mSupportNoImage = true;
        this.dwc = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                super.onLoaded((AnonymousClass2) aVar, str, i2);
                GifView.this.stopLoading();
                GifView.this.setGif(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }
        };
        this.dvP = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.dvP.setBounds(0, 0, this.dvP.getIntrinsicWidth(), this.dvP.getIntrinsicHeight());
        this.dvR = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            dvQ = a(this);
            this.srcRect.set(0, 0, dvQ.getWidth(), dvQ.getHeight());
        }
        this.Nu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i2 - (getPaddingBottom() + paddingTop);
            int i5 = i - (paddingRight + paddingLeft);
            if (a(this) != null) {
                int width = dvQ.getWidth();
                int height = dvQ.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.destRect.set(i6, i7, width + i6, height + i7);
            }
            if (this.dvT != null) {
                int intrinsicWidth = this.dvT.getIntrinsicWidth();
                int intrinsicHeight = this.dvT.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.dvT.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    public void release() {
        stopLoad();
        reset();
        if (this.dvW && this.zE != null && this.zE != null) {
            this.zE.close();
            this.zE = null;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        super.reset();
        this.zE = null;
        this.mBitmap = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.loadFailed = false;
        this.ajO = 0;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
    }

    private void aNo() {
        am.setImageResource(this, this.dwa);
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        setBackgroundDrawable(null);
        this.dvY = aVar;
        this.loadFailed = false;
        this.mIsLoading = false;
        this.dvS = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.loadFailed = true;
            this.dvN = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            aNo();
            if (this.zE != null) {
                this.zE.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.isEmotionGif()) {
                this.dvN = true;
                aVar.drawImageTo(this);
                this.mIsLoading = false;
            }
            if (this.zE != null) {
                this.zE.close();
            }
        } else if (this.zE == null || !aVar.getGif().equals(this.zE)) {
            this.dvN = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.zE = aVar.getGif();
                aVar.getGif().B(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.bwx) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().B(this.ajO);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.bwx) {
                resume();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [372=4, 373=4, 374=4] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGifRaw(int i) {
        int i2;
        InputStream openRawResource = getContext().getResources().openRawResource(i);
        byte[] bArr = null;
        try {
            try {
                i2 = openRawResource.available();
            } finally {
                try {
                    openRawResource.close();
                } catch (IOException e) {
                    BdLog.e(e.getMessage());
                }
            }
        } catch (IOException e2) {
            e = e2;
            i2 = 0;
        } catch (OutOfMemoryError e3) {
            e = e3;
            i2 = 0;
        }
        try {
            bArr = new byte[i2];
            openRawResource.read(bArr);
        } catch (IOException e4) {
            e = e4;
            BdLog.e(e.getMessage());
            try {
                openRawResource.close();
            } catch (IOException e5) {
                BdLog.e(e5.getMessage());
            }
            if (bArr == null) {
                return;
            }
            return;
        } catch (OutOfMemoryError e6) {
            e = e6;
            BdLog.e(e.getMessage());
            try {
                openRawResource.close();
            } catch (IOException e7) {
                BdLog.e(e7.getMessage());
            }
            if (bArr == null) {
            }
        }
        if (bArr == null || bArr.length < i2) {
            return;
        }
        com.baidu.adp.widget.ImageView.a d = a.C0014a.fg().d(bArr, 0, i2);
        this.dvW = true;
        setGif(d);
    }

    public boolean getAutoPlay() {
        return this.bwx;
    }

    public void setAutoPlay(boolean z) {
        this.bwx = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.dvX = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.C(this.ajO));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.B(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.dvX = false;
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

    public void onDestroy() {
        this.dvY = null;
        if (this.zE != null) {
            this.zE.close();
        }
        if (this.mGifInfo != null) {
            this.mGifInfo = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        stopLoad();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        stopLoad();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            stopLoad();
        }
        if (!this.dvN) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    private boolean aNp() {
        return this.loadFailed || (this.mGifInfo != null && this.mGifInfo.mLoadFailed);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if ((!this.mIsLoading && !this.loadFailed && !this.dvS) || aNp()) {
                super.onDraw(canvas);
            }
            canvas.save();
            if (this.zE != null && !this.mIsLoading && !this.loadFailed && !this.dvS) {
                this.zE.a(null, canvas);
            }
            canvas.restore();
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        if (this.dvN && this.dvO) {
            canvas.save();
            this.dvP.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.srcRect, this.destRect, (Paint) null);
            canvas.restore();
        } else if (this.dvS) {
            canvas.save();
            this.dvT.draw(canvas);
            canvas.restore();
        }
    }

    public void setIsLoading(boolean z) {
        if (z) {
            startLoading();
        } else {
            stopLoading();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLoading() {
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            nextLoadingFrame();
        }
    }

    public void setHasNoImage(boolean z, int i) {
        this.dvS = z;
        if (z) {
            this.mIsLoading = false;
            this.loadFailed = false;
            if (this.dvT == null || this.dvU != i) {
                this.dvU = i;
                this.dvT = am.getDrawable(i);
                int intrinsicWidth = this.dvT.getIntrinsicWidth();
                int intrinsicHeight = this.dvT.getIntrinsicHeight();
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
                this.dvT.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        } else {
            this.dvT = null;
        }
        invalidate();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void nextLoadingFrame() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        this.mCurrentDegrees += this.dvR;
        if (this.mCurrentDegrees > 360.0f - this.dvR) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.dvM = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.dvT != null && this.dvT.isStateful()) {
            this.dvT.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = 20;
        if (gifInfo == null) {
            this.mGifInfo = null;
            aNo();
            return;
        }
        boolean aPH = m.aPH();
        com.baidu.adp.base.h Z = i.Z(getContext());
        if (Z != null) {
            bdUniqueId = Z.getUniqueId();
            z = Z.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(this.mGifInfo != null && gifInfo.mDynamicUrl != null && aq.equals(gifInfo.mDynamicUrl, this.mGifInfo.mDynamicUrl) && aq.equals(gifInfo.mSharpText, this.mGifInfo.mSharpText) && aq.equals(gifInfo.mStaticUrl, this.mGifInfo.mStaticUrl) && this.mPageId == bdUniqueId)) {
            stopLoad();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        this.dvZ = null;
        reset();
        String str = aPH ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.gr().loadResourceFromMemery(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(aPH), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
            aNo();
        } else if (!c.gr().Q(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.dvL);
        } else if (!z) {
            startLoading();
            c.gr().a(this.mGifInfo.mSharpText, this.mType, this.dwc, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(aPH), str);
        }
    }

    public void ag(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = i;
        this.mGifInfo = null;
        if (TextUtils.isEmpty(str)) {
            this.dvZ = null;
            aNo();
            return;
        }
        com.baidu.adp.base.h Z = i.Z(getContext());
        if (Z != null) {
            bdUniqueId = Z.getUniqueId();
            z = Z.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.dvZ) && i == this.mType && bdUniqueId == this.mPageId)) {
            stopLoad();
        }
        this.mPageId = bdUniqueId;
        reset();
        this.dvZ = str;
        this.mGifInfo = null;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.gr().loadResourceFromMemery(str, i, new Object[0]);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (!c.gr().Q(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.dvL);
        } else if (!z) {
            c.gr().a(this.dvZ, i, this.dwc, this.mPageId);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoad() {
        stopLoading();
        this.loadFailed = false;
        this.dvS = false;
        if (this.mGifInfo != null) {
            c.gr().a(this.mGifInfo.mSharpText, this.mType, this.dwc);
        }
        if (!TextUtils.isEmpty(this.dvZ)) {
            c.gr().a(this.dvZ, this.mType, this.dwc);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        if (this.mGifInfo != null) {
            a(this.mGifInfo);
        }
        if (!TextUtils.isEmpty(this.dvZ)) {
            ag(this.dvZ, this.mType);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        super.setSupportNoImage(z);
        this.mSupportNoImage = z;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    public void setOnInterceptClickListener(d dVar) {
        super.setOnClickListener(this);
        this.dmN = dVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dmN == null || !this.dmN.onClickEvent(view)) {
            if (this.mGifInfo != null) {
                boolean aPH = m.aPH();
                String str = aPH ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.gr().loadResourceFromMemery(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(aPH), str);
                if (aVar != null) {
                    this.mGifInfo.mLoadFailed = false;
                    setGif(aVar);
                } else {
                    startLoading();
                    c.gr().a(this.mGifInfo.mSharpText, this.mType, this.dwc, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(aPH), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.dvZ)) {
                com.baidu.adp.widget.ImageView.a aVar2 = (com.baidu.adp.widget.ImageView.a) c.gr().loadResourceFromMemery(this.dvZ, this.mType, new Object[0]);
                if (aVar2 != null) {
                    this.loadFailed = false;
                    setGif(aVar2);
                } else {
                    startLoading();
                    c.gr().a(this.dvZ, this.mType, this.dwc, this.mPageId);
                    return;
                }
            }
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(view);
            }
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.dvV = z;
    }

    public static Bitmap a(GifView gifView) {
        if (dvQ != null && !dvQ.isRecycled()) {
            return dvQ;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
        if (bitmapDrawable != null) {
            dvQ = bitmapDrawable.getBitmap();
        }
        return dvQ;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.zE == null) {
            onStop();
            return null;
        }
        return this.zE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.dvM != null && !this.dvX) {
            this.dvM.onStop();
            this.dvX = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.dvO = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.dvY = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.dvY;
    }

    public void setType(int i) {
        this.mType = i;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.dvZ;
    }

    public void setDefaultNoImageDay(int i) {
        this.dvL = i;
    }

    public void aNq() {
        this.dvL = R.drawable.pic_expression_upload_selector;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.dwd = gVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dwd != null) {
            this.dwd.x(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        if (this.dvY == null) {
            return 0;
        }
        return this.dvY.getWidth();
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        if (this.dvY == null) {
            return 0;
        }
        return this.dvY.getHeight();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float getRadius() {
        return this.Nu;
    }
}

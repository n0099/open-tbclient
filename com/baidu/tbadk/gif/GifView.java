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
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.gif.a;
import com.baidu.adp.gif.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.newwidget.ImageView.h;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.i;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, h, Runnable {
    public static Bitmap aPD;
    private b KI;
    private com.baidu.tbadk.e.b aGH;
    private boolean aPA;
    private BitmapDrawable aPB;
    private boolean aPC;
    private float aPE;
    private boolean aPF;
    private Drawable aPG;
    private int aPH;
    private final Rect aPI;
    private final Rect aPJ;
    private boolean aPK;
    private boolean aPL;
    private boolean aPM;
    private boolean aPN;
    private com.baidu.adp.widget.ImageView.a aPO;
    private int aPP;
    private boolean aPQ;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aPR;
    private int aPx;
    private a aPy;
    private boolean aPz;
    private Bitmap mBitmap;
    private float mCurrentDegrees;
    private int mCurrentFrame;
    private TbRichTextView.f mDispatchTouchListener;
    private GifInfo mGifInfo;
    private Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private boolean mSupportNoImage;
    private int mType;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface a {
        void onStop();
    }

    public void setErrorResid(int i) {
        this.aPP = i;
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
        this.aPx = d.f.pic_expression_upload_selector;
        this.aPz = false;
        this.aPA = true;
        this.aPI = new Rect();
        this.aPJ = new Rect();
        this.aPK = true;
        this.aPL = false;
        this.aPM = false;
        this.aPN = false;
        this.aPP = d.f.image_group_load_f;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.mCurrentFrame++;
                    if (GifView.this.mCurrentFrame >= gif.getFrameCount()) {
                        if (GifView.this.aPQ) {
                            if (!GifView.this.aPL) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.aPQ = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.aPL) {
                            GifView.this.mCurrentFrame = 0;
                        } else {
                            GifView.this.mCurrentFrame = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.N(GifView.this.mCurrentFrame);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (!z) {
                        sendEmptyMessageDelayed(1, gif.O(GifView.this.mCurrentFrame));
                    } else {
                        GifView.this.onStop();
                    }
                }
            }
        };
        this.mType = 20;
        this.mSupportNoImage = true;
        this.aPR = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                super.onLoaded((AnonymousClass2) aVar, str, i2);
                GifView.this.stopLoading();
                GifView.this.setGif(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }
        };
        this.aPB = (BitmapDrawable) getResources().getDrawable(d.f.icon_content_animation);
        this.aPB.setBounds(0, 0, this.aPB.getIntrinsicWidth(), this.aPB.getIntrinsicHeight());
        this.aPE = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(d.f.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            aPD = a(this);
            this.aPJ.set(0, 0, aPD.getWidth(), aPD.getHeight());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i2 - (getPaddingBottom() + paddingTop);
            int i5 = i - (paddingRight + paddingLeft);
            if (a(this) != null) {
                int width = aPD.getWidth();
                int height = aPD.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.aPI.set(i6, i7, width + i6, height + i7);
            }
            if (this.aPG != null) {
                int intrinsicWidth = this.aPG.getIntrinsicWidth();
                int intrinsicHeight = this.aPG.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.aPG.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    public void release() {
        stopLoad();
        reset();
        if (this.aPM && this.KI != null && this.KI != null) {
            this.KI.close();
            this.KI = null;
        }
    }

    private void reset() {
        this.KI = null;
        this.mBitmap = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.aPC = false;
        this.mCurrentFrame = 0;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
    }

    private void IP() {
        am.c(this, this.aPP);
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        setBackgroundDrawable(null);
        this.aPO = aVar;
        this.aPC = false;
        this.mIsLoading = false;
        this.aPF = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aPC = true;
            this.aPz = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            IP();
            if (this.KI != null) {
                this.KI.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mX()) {
                this.aPz = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.KI != null) {
                this.KI.close();
            }
        } else if (this.KI == null || !aVar.getGif().equals(this.KI)) {
            this.aPz = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.KI = aVar.getGif();
                aVar.getGif().N(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aPK) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().N(this.mCurrentFrame);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aPK) {
                resume();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [368=4, 369=4, 370=4] */
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
        com.baidu.adp.widget.ImageView.a g = a.C0012a.ga().g(bArr, 0, i2);
        this.aPM = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.aPK;
    }

    public void setAutoPlay(boolean z) {
        this.aPK = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.aPN = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.O(this.mCurrentFrame));
        }
    }

    public void stop() {
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.N(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.aPN = false;
        b gif = getGif();
        if (gif != null) {
            if (this.mCurrentFrame != 0) {
                this.mCurrentFrame = 0;
            }
            gif.N(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.O(this.mCurrentFrame));
        }
    }

    public void IQ() {
        this.aPQ = true;
        play();
    }

    public void onDestroy() {
        this.aPO = null;
        if (this.KI != null) {
            this.KI.close();
        }
        if (this.mGifInfo != null) {
            this.mGifInfo = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        stopLoad();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        stopLoad();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            stopLoad();
        }
        if (!this.aPz) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    private boolean IR() {
        return this.aPC || (this.mGifInfo != null && this.mGifInfo.mLoadFailed);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            if ((!this.mIsLoading && !this.aPC && !this.aPF) || IR()) {
                super.onDraw(canvas);
            }
            canvas.save();
            if (this.KI != null && !this.mIsLoading && !this.aPC && !this.aPF) {
                this.KI.a(null, canvas);
            }
            canvas.restore();
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        if (this.aPz && this.aPA) {
            canvas.save();
            this.aPB.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aPJ, this.aPI, (Paint) null);
            canvas.restore();
        } else if (this.aPF) {
            canvas.save();
            this.aPG.draw(canvas);
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

    public void startLoading() {
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            nextLoadingFrame();
        }
    }

    public void setHasNoImage(boolean z, int i) {
        this.aPF = z;
        if (z) {
            this.mIsLoading = false;
            this.aPC = false;
            if (this.aPG == null || this.aPH != i) {
                this.aPH = i;
                this.aPG = am.getDrawable(i);
                int intrinsicWidth = this.aPG.getIntrinsicWidth();
                int intrinsicHeight = this.aPG.getIntrinsicHeight();
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
                this.aPG.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        } else {
            this.aPG = null;
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void nextLoadingFrame() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mCurrentDegrees += this.aPE;
        if (this.mCurrentDegrees > 360.0f - this.aPE) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.aPy = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aPG != null && this.aPG.isStateful()) {
            this.aPG.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = 20;
        if (gifInfo == null) {
            this.mGifInfo = null;
            IP();
            return;
        }
        boolean Ln = i.Ln();
        com.baidu.adp.base.h ab = com.baidu.adp.base.i.ab(getContext());
        if (ab != null) {
            BdUniqueId uniqueId = ab.getUniqueId();
            z = ab.isScroll();
            bdUniqueId = uniqueId;
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo != null && this.mGifInfo != null && gifInfo.mDynamicUrl != null && ap.equals(gifInfo.mDynamicUrl, this.mGifInfo.mDynamicUrl) && gifInfo.mSharpText.equals(this.mGifInfo.mSharpText) && gifInfo.mStaticUrl.equals(this.mGifInfo.mStaticUrl) && this.mPageId == bdUniqueId)) {
            stopLoad();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        this.mUrl = null;
        reset();
        String str = Ln ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ig().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Ln), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
            IP();
        } else if (!c.ig().ai(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.aPx);
        } else if (!z) {
            startLoading();
            c.ig().a(this.mGifInfo.mSharpText, this.mType, this.aPR, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Ln), str);
        }
    }

    public void E(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = i;
        this.mGifInfo = null;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = null;
            IP();
            return;
        }
        com.baidu.adp.base.h ab = com.baidu.adp.base.i.ab(getContext());
        if (ab != null) {
            bdUniqueId = ab.getUniqueId();
            z = ab.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId)) {
            stopLoad();
        }
        this.mPageId = bdUniqueId;
        reset();
        this.mUrl = str;
        this.mGifInfo = null;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ig().a(str, i, new Object[0]);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (!c.ig().ai(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.aPx);
        } else if (!z) {
            c.ig().a(this.mUrl, i, this.aPR, this.mPageId);
        }
    }

    public void stopLoad() {
        stopLoading();
        this.aPC = false;
        this.aPF = false;
        if (this.mGifInfo != null) {
            c.ig().a(this.mGifInfo.mSharpText, this.mType, this.aPR);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            c.ig().a(this.mUrl, this.mType, this.aPR);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        if (this.mGifInfo != null) {
            a(this.mGifInfo);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            E(this.mUrl, this.mType);
        }
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    public void setOnInterceptClickListener(com.baidu.tbadk.e.b bVar) {
        super.setOnClickListener(this);
        this.aGH = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aGH == null || !this.aGH.v(view)) {
            if (this.mGifInfo != null) {
                boolean Ln = i.Ln();
                String str = Ln ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ig().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Ln), str);
                if (aVar != null) {
                    this.mGifInfo.mLoadFailed = false;
                    setGif(aVar);
                } else {
                    startLoading();
                    c.ig().a(this.mGifInfo.mSharpText, this.mType, this.aPR, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Ln), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.mUrl)) {
                com.baidu.adp.widget.ImageView.a aVar2 = (com.baidu.adp.widget.ImageView.a) c.ig().a(this.mUrl, this.mType, new Object[0]);
                if (aVar2 != null) {
                    this.aPC = false;
                    setGif(aVar2);
                } else {
                    startLoading();
                    c.ig().a(this.mUrl, this.mType, this.aPR, this.mPageId);
                    return;
                }
            }
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(view);
            }
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aPL = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aPD != null && !aPD.isRecycled()) {
            return aPD;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(d.f.img_loading);
        if (bitmapDrawable != null) {
            aPD = bitmapDrawable.getBitmap();
        }
        return aPD;
    }

    public b getGif() {
        if (this.KI == null) {
            onStop();
            return null;
        }
        return this.KI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aPy != null && !this.aPN) {
            this.aPy.onStop();
            this.aPN = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.aPA = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.aPO = aVar;
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.aPO;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setDefaultNoImageDay(int i) {
        this.aPx = i;
    }

    public void IS() {
        this.aPx = d.f.pic_expression_upload_selector;
    }

    public void setDispatchTouchListener(TbRichTextView.f fVar) {
        this.mDispatchTouchListener = fVar;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mDispatchTouchListener != null) {
            this.mDispatchTouchListener.y(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}

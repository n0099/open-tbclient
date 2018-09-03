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
import com.baidu.adp.base.i;
import com.baidu.adp.gif.a;
import com.baidu.adp.gif.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.newwidget.ImageView.h;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.f;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, h, Runnable {
    public static Bitmap aPA;
    private b KE;
    private com.baidu.tbadk.f.b aGG;
    private float aPB;
    private boolean aPC;
    private Drawable aPD;
    private int aPE;
    private final Rect aPF;
    private final Rect aPG;
    private boolean aPH;
    private boolean aPI;
    private boolean aPJ;
    private boolean aPK;
    private com.baidu.adp.widget.ImageView.a aPL;
    private int aPM;
    private boolean aPN;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aPO;
    private int aPu;
    private a aPv;
    private boolean aPw;
    private boolean aPx;
    private BitmapDrawable aPy;
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
        this.aPM = i;
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
        this.aPu = f.C0146f.pic_expression_upload_selector;
        this.aPw = false;
        this.aPx = true;
        this.aPF = new Rect();
        this.aPG = new Rect();
        this.aPH = true;
        this.aPI = false;
        this.aPJ = false;
        this.aPK = false;
        this.aPM = f.C0146f.image_group_load_f;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.mCurrentFrame++;
                    if (GifView.this.mCurrentFrame >= gif.getFrameCount()) {
                        if (GifView.this.aPN) {
                            if (!GifView.this.aPI) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.aPN = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.aPI) {
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
        this.aPO = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.aPy = (BitmapDrawable) getResources().getDrawable(f.C0146f.icon_content_animation);
        this.aPy.setBounds(0, 0, this.aPy.getIntrinsicWidth(), this.aPy.getIntrinsicHeight());
        this.aPB = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(f.C0146f.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            aPA = a(this);
            this.aPG.set(0, 0, aPA.getWidth(), aPA.getHeight());
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
                int width = aPA.getWidth();
                int height = aPA.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.aPF.set(i6, i7, width + i6, height + i7);
            }
            if (this.aPD != null) {
                int intrinsicWidth = this.aPD.getIntrinsicWidth();
                int intrinsicHeight = this.aPD.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.aPD.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    public void release() {
        stopLoad();
        reset();
        if (this.aPJ && this.KE != null && this.KE != null) {
            this.KE.close();
            this.KE = null;
        }
    }

    private void reset() {
        this.KE = null;
        this.mBitmap = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.aPz = false;
        this.mCurrentFrame = 0;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
    }

    private void IK() {
        am.c(this, this.aPM);
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        setBackgroundDrawable(null);
        this.aPL = aVar;
        this.aPz = false;
        this.mIsLoading = false;
        this.aPC = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aPz = true;
            this.aPw = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            IK();
            if (this.KE != null) {
                this.KE.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mZ()) {
                this.aPw = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.KE != null) {
                this.KE.close();
            }
        } else if (this.KE == null || !aVar.getGif().equals(this.KE)) {
            this.aPw = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.KE = aVar.getGif();
                aVar.getGif().N(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aPH) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().N(this.mCurrentFrame);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aPH) {
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
        com.baidu.adp.widget.ImageView.a g = a.C0012a.fZ().g(bArr, 0, i2);
        this.aPJ = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.aPH;
    }

    public void setAutoPlay(boolean z) {
        this.aPH = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.aPK = false;
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
        this.aPK = false;
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

    public void IL() {
        this.aPN = true;
        play();
    }

    public void onDestroy() {
        this.aPL = null;
        if (this.KE != null) {
            this.KE.close();
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
        if (!this.aPw) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    private boolean IM() {
        return this.aPz || (this.mGifInfo != null && this.mGifInfo.mLoadFailed);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            if ((!this.mIsLoading && !this.aPz && !this.aPC) || IM()) {
                super.onDraw(canvas);
            }
            canvas.save();
            if (this.KE != null && !this.mIsLoading && !this.aPz && !this.aPC) {
                this.KE.a(null, canvas);
            }
            canvas.restore();
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        if (this.aPw && this.aPx) {
            canvas.save();
            this.aPy.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aPG, this.aPF, (Paint) null);
            canvas.restore();
        } else if (this.aPC) {
            canvas.save();
            this.aPD.draw(canvas);
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
        this.aPC = z;
        if (z) {
            this.mIsLoading = false;
            this.aPz = false;
            if (this.aPD == null || this.aPE != i) {
                this.aPE = i;
                this.aPD = am.getDrawable(i);
                int intrinsicWidth = this.aPD.getIntrinsicWidth();
                int intrinsicHeight = this.aPD.getIntrinsicHeight();
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
                this.aPD.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        } else {
            this.aPD = null;
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
        this.mCurrentDegrees += this.aPB;
        if (this.mCurrentDegrees > 360.0f - this.aPB) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.aPv = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aPD != null && this.aPD.isStateful()) {
            this.aPD.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = 20;
        if (gifInfo == null) {
            this.mGifInfo = null;
            IK();
            return;
        }
        boolean Lm = com.baidu.tbadk.util.h.Lm();
        com.baidu.adp.base.h ab = i.ab(getContext());
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
        String str = Lm ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ih().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Lm), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
            IK();
        } else if (!c.ih().aj(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.aPu);
        } else if (!z) {
            startLoading();
            c.ih().a(this.mGifInfo.mSharpText, this.mType, this.aPO, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Lm), str);
        }
    }

    public void A(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = i;
        this.mGifInfo = null;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = null;
            IK();
            return;
        }
        com.baidu.adp.base.h ab = i.ab(getContext());
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ih().a(str, i, new Object[0]);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (!c.ih().aj(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.aPu);
        } else if (!z) {
            c.ih().a(this.mUrl, i, this.aPO, this.mPageId);
        }
    }

    public void stopLoad() {
        stopLoading();
        this.aPz = false;
        this.aPC = false;
        if (this.mGifInfo != null) {
            c.ih().a(this.mGifInfo.mSharpText, this.mType, this.aPO);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            c.ih().a(this.mUrl, this.mType, this.aPO);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        if (this.mGifInfo != null) {
            a(this.mGifInfo);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            A(this.mUrl, this.mType);
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

    public void setOnInterceptClickListener(com.baidu.tbadk.f.b bVar) {
        super.setOnClickListener(this);
        this.aGG = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aGG == null || !this.aGG.v(view)) {
            if (this.mGifInfo != null) {
                boolean Lm = com.baidu.tbadk.util.h.Lm();
                String str = Lm ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ih().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Lm), str);
                if (aVar != null) {
                    this.mGifInfo.mLoadFailed = false;
                    setGif(aVar);
                } else {
                    startLoading();
                    c.ih().a(this.mGifInfo.mSharpText, this.mType, this.aPO, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Lm), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.mUrl)) {
                com.baidu.adp.widget.ImageView.a aVar2 = (com.baidu.adp.widget.ImageView.a) c.ih().a(this.mUrl, this.mType, new Object[0]);
                if (aVar2 != null) {
                    this.aPz = false;
                    setGif(aVar2);
                } else {
                    startLoading();
                    c.ih().a(this.mUrl, this.mType, this.aPO, this.mPageId);
                    return;
                }
            }
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(view);
            }
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aPI = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aPA != null && !aPA.isRecycled()) {
            return aPA;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(f.C0146f.img_loading);
        if (bitmapDrawable != null) {
            aPA = bitmapDrawable.getBitmap();
        }
        return aPA;
    }

    public b getGif() {
        if (this.KE == null) {
            onStop();
            return null;
        }
        return this.KE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aPv != null && !this.aPK) {
            this.aPv.onStop();
            this.aPK = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.aPx = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.aPL = aVar;
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.aPL;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setDefaultNoImageDay(int i) {
        this.aPu = i;
    }

    public void IN() {
        this.aPu = f.C0146f.pic_expression_upload_selector;
    }

    public void setDispatchTouchListener(TbRichTextView.f fVar) {
        this.mDispatchTouchListener = fVar;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mDispatchTouchListener != null) {
            this.mDispatchTouchListener.z(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}

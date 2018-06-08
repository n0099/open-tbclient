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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.i;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, h, Runnable {
    public static Bitmap aOH;
    private b KG;
    private com.baidu.tbadk.e.b aFP;
    private int aOB;
    private a aOC;
    private boolean aOD;
    private boolean aOE;
    private BitmapDrawable aOF;
    private boolean aOG;
    private float aOI;
    private boolean aOJ;
    private Drawable aOK;
    private int aOL;
    private final Rect aOM;
    private final Rect aON;
    private boolean aOO;
    private boolean aOP;
    private boolean aOQ;
    private boolean aOR;
    private com.baidu.adp.widget.ImageView.a aOS;
    private int aOT;
    private boolean aOU;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aOV;
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
        this.aOT = i;
    }

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOB = d.f.pic_expression_upload_selector;
        this.aOD = false;
        this.aOE = true;
        this.aOM = new Rect();
        this.aON = new Rect();
        this.aOO = true;
        this.aOP = false;
        this.aOQ = false;
        this.aOR = false;
        this.aOT = d.f.image_group_load_f;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.mCurrentFrame++;
                    if (GifView.this.mCurrentFrame >= gif.getFrameCount()) {
                        if (GifView.this.aOU) {
                            if (!GifView.this.aOP) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.aOU = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.aOP) {
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
        this.aOV = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.aOF = (BitmapDrawable) getResources().getDrawable(d.f.icon_content_animation);
        this.aOF.setBounds(0, 0, this.aOF.getIntrinsicWidth(), this.aOF.getIntrinsicHeight());
        this.aOI = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(d.f.img_loading)) != null) {
            aOH = a(this);
            this.aON.set(0, 0, aOH.getWidth(), aOH.getHeight());
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
                int width = aOH.getWidth();
                int height = aOH.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.aOM.set(i6, i7, width + i6, height + i7);
            }
            if (this.aOK != null) {
                int intrinsicWidth = this.aOK.getIntrinsicWidth();
                int intrinsicHeight = this.aOK.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.aOK.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    public void release() {
        stopLoad();
        reset();
        if (this.aOQ && this.KG != null && this.KG != null) {
            this.KG.close();
            this.KG = null;
        }
    }

    private void reset() {
        this.KG = null;
        this.mBitmap = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.aOG = false;
        this.mCurrentFrame = 0;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
    }

    private void Ix() {
        al.c(this, this.aOT);
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        setBackgroundDrawable(null);
        this.aOS = aVar;
        this.aOG = false;
        this.mIsLoading = false;
        this.aOJ = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aOG = true;
            this.aOD = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            Ix();
            if (this.KG != null) {
                this.KG.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mX()) {
                this.aOD = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.KG != null) {
                this.KG.close();
            }
        } else if (this.KG == null || !aVar.getGif().equals(this.KG)) {
            this.aOD = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.KG = aVar.getGif();
                aVar.getGif().N(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aOO) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().N(this.mCurrentFrame);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aOO) {
                resume();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [362=4, 363=4, 364=4] */
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
        this.aOQ = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.aOO;
    }

    public void setAutoPlay(boolean z) {
        this.aOO = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.aOR = false;
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
        this.aOR = false;
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

    public void Iy() {
        this.aOU = true;
        play();
    }

    public void onDestroy() {
        this.aOS = null;
        if (this.KG != null) {
            this.KG.close();
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
        if (!this.aOD) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    private boolean Iz() {
        return this.aOG || (this.mGifInfo != null && this.mGifInfo.mLoadFailed);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            if ((!this.mIsLoading && !this.aOG && !this.aOJ) || Iz()) {
                super.onDraw(canvas);
            }
            canvas.save();
            if (this.KG != null && !this.mIsLoading && !this.aOG && !this.aOJ) {
                this.KG.a(null, canvas);
            }
            canvas.restore();
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        if (this.aOD && this.aOE) {
            canvas.save();
            this.aOF.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aON, this.aOM, (Paint) null);
            canvas.restore();
        } else if (this.aOJ) {
            canvas.save();
            this.aOK.draw(canvas);
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
        this.aOJ = z;
        if (z) {
            this.mIsLoading = false;
            this.aOG = false;
            if (this.aOK == null || this.aOL != i) {
                this.aOL = i;
                this.aOK = al.getDrawable(i);
                int intrinsicWidth = this.aOK.getIntrinsicWidth();
                int intrinsicHeight = this.aOK.getIntrinsicHeight();
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
                this.aOK.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        } else {
            this.aOK = null;
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
        this.mCurrentDegrees += this.aOI;
        if (this.mCurrentDegrees > 360.0f - this.aOI) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.aOC = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aOK != null && this.aOK.isStateful()) {
            this.aOK.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = 20;
        if (gifInfo == null) {
            this.mGifInfo = null;
            Ix();
            return;
        }
        boolean KV = i.KV();
        com.baidu.adp.base.h ab = com.baidu.adp.base.i.ab(getContext());
        if (ab != null) {
            BdUniqueId uniqueId = ab.getUniqueId();
            z = ab.isScroll();
            bdUniqueId = uniqueId;
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo != null && this.mGifInfo != null && gifInfo.mDynamicUrl != null && ao.equals(gifInfo.mDynamicUrl, this.mGifInfo.mDynamicUrl) && gifInfo.mSharpText.equals(this.mGifInfo.mSharpText) && gifInfo.mStaticUrl.equals(this.mGifInfo.mStaticUrl) && this.mPageId == bdUniqueId)) {
            stopLoad();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        this.mUrl = null;
        reset();
        String str = KV ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ig().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(KV), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
            Ix();
        } else if (!c.ig().ai(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.aOB);
        } else if (!z) {
            startLoading();
            c.ig().a(this.mGifInfo.mSharpText, this.mType, this.aOV, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(KV), str);
        }
    }

    public void E(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = i;
        this.mGifInfo = null;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = null;
            Ix();
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
            setHasNoImage(true, this.aOB);
        } else if (!z) {
            c.ig().a(this.mUrl, i, this.aOV, this.mPageId);
        }
    }

    public void stopLoad() {
        stopLoading();
        this.aOG = false;
        this.aOJ = false;
        if (this.mGifInfo != null) {
            c.ig().a(this.mGifInfo.mSharpText, this.mType, this.aOV);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            c.ig().a(this.mUrl, this.mType, this.aOV);
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
        this.aFP = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aFP == null || !this.aFP.v(view)) {
            if (this.mGifInfo != null) {
                boolean KV = i.KV();
                String str = KV ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ig().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(KV), str);
                if (aVar != null) {
                    this.mGifInfo.mLoadFailed = false;
                    setGif(aVar);
                } else {
                    startLoading();
                    c.ig().a(this.mGifInfo.mSharpText, this.mType, this.aOV, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(KV), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.mUrl)) {
                com.baidu.adp.widget.ImageView.a aVar2 = (com.baidu.adp.widget.ImageView.a) c.ig().a(this.mUrl, this.mType, new Object[0]);
                if (aVar2 != null) {
                    this.aOG = false;
                    setGif(aVar2);
                } else {
                    startLoading();
                    c.ig().a(this.mUrl, this.mType, this.aOV, this.mPageId);
                    return;
                }
            }
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(view);
            }
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aOP = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aOH != null && !aOH.isRecycled()) {
            return aOH;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(d.f.img_loading);
        if (bitmapDrawable != null) {
            aOH = bitmapDrawable.getBitmap();
        }
        return aOH;
    }

    public b getGif() {
        if (this.KG == null) {
            onStop();
            return null;
        }
        return this.KG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aOC != null && !this.aOR) {
            this.aOC.onStop();
            this.aOR = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.aOE = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.aOS = aVar;
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.aOS;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setDefaultNoImageDay(int i) {
        this.aOB = i;
    }

    public void IA() {
        this.aOB = d.f.pic_expression_upload_selector;
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

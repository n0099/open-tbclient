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
import com.baidu.tieba.e;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, h, Runnable {
    public static Bitmap bbE;
    private b ND;
    private com.baidu.tbadk.f.b aSL;
    private boolean bbA;
    private boolean bbB;
    private BitmapDrawable bbC;
    private boolean bbD;
    private float bbF;
    private boolean bbG;
    private Drawable bbH;
    private int bbI;
    private final Rect bbJ;
    private final Rect bbK;
    private boolean bbL;
    private boolean bbM;
    private boolean bbN;
    private com.baidu.adp.widget.ImageView.a bbO;
    private int bbP;
    private boolean bbQ;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> bbR;
    private int bby;
    private a bbz;
    private boolean mAutoPlay;
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
        this.bbP = i;
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
        this.bby = e.f.pic_expression_upload_selector;
        this.bbA = false;
        this.bbB = true;
        this.bbJ = new Rect();
        this.bbK = new Rect();
        this.mAutoPlay = true;
        this.bbL = false;
        this.bbM = false;
        this.bbN = false;
        this.bbP = e.f.image_group_load_f;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.mCurrentFrame++;
                    if (GifView.this.mCurrentFrame >= gif.getFrameCount()) {
                        if (GifView.this.bbQ) {
                            if (!GifView.this.bbL) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.bbQ = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.bbL) {
                            GifView.this.mCurrentFrame = 0;
                        } else {
                            GifView.this.mCurrentFrame = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.am(GifView.this.mCurrentFrame);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (!z) {
                        sendEmptyMessageDelayed(1, gif.an(GifView.this.mCurrentFrame));
                    } else {
                        GifView.this.onStop();
                    }
                }
            }
        };
        this.mType = 20;
        this.mSupportNoImage = true;
        this.bbR = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.bbC = (BitmapDrawable) getResources().getDrawable(e.f.icon_content_animation);
        this.bbC.setBounds(0, 0, this.bbC.getIntrinsicWidth(), this.bbC.getIntrinsicHeight());
        this.bbF = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(e.f.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            bbE = a(this);
            this.bbK.set(0, 0, bbE.getWidth(), bbE.getHeight());
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
                int width = bbE.getWidth();
                int height = bbE.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.bbJ.set(i6, i7, width + i6, height + i7);
            }
            if (this.bbH != null) {
                int intrinsicWidth = this.bbH.getIntrinsicWidth();
                int intrinsicHeight = this.bbH.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.bbH.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    public void release() {
        stopLoad();
        reset();
        if (this.bbM && this.ND != null && this.ND != null) {
            this.ND.close();
            this.ND = null;
        }
    }

    private void reset() {
        this.ND = null;
        this.mBitmap = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.bbD = false;
        this.mCurrentFrame = 0;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
    }

    private void No() {
        al.c(this, this.bbP);
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        setBackgroundDrawable(null);
        this.bbO = aVar;
        this.bbD = false;
        this.mIsLoading = false;
        this.bbG = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.bbD = true;
            this.bbA = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            No();
            if (this.ND != null) {
                this.ND.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.on()) {
                this.bbA = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.ND != null) {
                this.ND.close();
            }
        } else if (this.ND == null || !aVar.getGif().equals(this.ND)) {
            this.bbA = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.ND = aVar.getGif();
                aVar.getGif().am(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.mAutoPlay) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().am(this.mCurrentFrame);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.mAutoPlay) {
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
        com.baidu.adp.widget.ImageView.a g = a.C0015a.hx().g(bArr, 0, i2);
        this.bbM = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.mAutoPlay;
    }

    public void setAutoPlay(boolean z) {
        this.mAutoPlay = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.bbN = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.an(this.mCurrentFrame));
        }
    }

    public void stop() {
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.am(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.bbN = false;
        b gif = getGif();
        if (gif != null) {
            if (this.mCurrentFrame != 0) {
                this.mCurrentFrame = 0;
            }
            gif.am(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.an(this.mCurrentFrame));
        }
    }

    public void Np() {
        this.bbQ = true;
        play();
    }

    public void onDestroy() {
        this.bbO = null;
        if (this.ND != null) {
            this.ND.close();
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
        if (!this.bbA) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    private boolean Nq() {
        return this.bbD || (this.mGifInfo != null && this.mGifInfo.mLoadFailed);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            if ((!this.mIsLoading && !this.bbD && !this.bbG) || Nq()) {
                super.onDraw(canvas);
            }
            canvas.save();
            if (this.ND != null && !this.mIsLoading && !this.bbD && !this.bbG) {
                this.ND.a(null, canvas);
            }
            canvas.restore();
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        if (this.bbA && this.bbB) {
            canvas.save();
            this.bbC.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.bbK, this.bbJ, (Paint) null);
            canvas.restore();
        } else if (this.bbG) {
            canvas.save();
            this.bbH.draw(canvas);
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
        this.bbG = z;
        if (z) {
            this.mIsLoading = false;
            this.bbD = false;
            if (this.bbH == null || this.bbI != i) {
                this.bbI = i;
                this.bbH = al.getDrawable(i);
                int intrinsicWidth = this.bbH.getIntrinsicWidth();
                int intrinsicHeight = this.bbH.getIntrinsicHeight();
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
                this.bbH.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        } else {
            this.bbH = null;
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
        this.mCurrentDegrees += this.bbF;
        if (this.mCurrentDegrees > 360.0f - this.bbF) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.bbz = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.bbH != null && this.bbH.isStateful()) {
            this.bbH.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = 20;
        if (gifInfo == null) {
            this.mGifInfo = null;
            No();
            return;
        }
        boolean PQ = i.PQ();
        com.baidu.adp.base.h aI = com.baidu.adp.base.i.aI(getContext());
        if (aI != null) {
            BdUniqueId uniqueId = aI.getUniqueId();
            z = aI.isScroll();
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
        String str = PQ ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jA().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(PQ), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
            No();
        } else if (!c.jA().aI(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.bby);
        } else if (!z) {
            startLoading();
            c.jA().a(this.mGifInfo.mSharpText, this.mType, this.bbR, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(PQ), str);
        }
    }

    public void G(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = i;
        this.mGifInfo = null;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = null;
            No();
            return;
        }
        com.baidu.adp.base.h aI = com.baidu.adp.base.i.aI(getContext());
        if (aI != null) {
            bdUniqueId = aI.getUniqueId();
            z = aI.isScroll();
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jA().a(str, i, new Object[0]);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (!c.jA().aI(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.bby);
        } else if (!z) {
            c.jA().a(this.mUrl, i, this.bbR, this.mPageId);
        }
    }

    public void stopLoad() {
        stopLoading();
        this.bbD = false;
        this.bbG = false;
        if (this.mGifInfo != null) {
            c.jA().a(this.mGifInfo.mSharpText, this.mType, this.bbR);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            c.jA().a(this.mUrl, this.mType, this.bbR);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        if (this.mGifInfo != null) {
            a(this.mGifInfo);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            G(this.mUrl, this.mType);
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
        this.aSL = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aSL == null || !this.aSL.F(view)) {
            if (this.mGifInfo != null) {
                boolean PQ = i.PQ();
                String str = PQ ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jA().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(PQ), str);
                if (aVar != null) {
                    this.mGifInfo.mLoadFailed = false;
                    setGif(aVar);
                } else {
                    startLoading();
                    c.jA().a(this.mGifInfo.mSharpText, this.mType, this.bbR, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(PQ), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.mUrl)) {
                com.baidu.adp.widget.ImageView.a aVar2 = (com.baidu.adp.widget.ImageView.a) c.jA().a(this.mUrl, this.mType, new Object[0]);
                if (aVar2 != null) {
                    this.bbD = false;
                    setGif(aVar2);
                } else {
                    startLoading();
                    c.jA().a(this.mUrl, this.mType, this.bbR, this.mPageId);
                    return;
                }
            }
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(view);
            }
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.bbL = z;
    }

    public static Bitmap a(GifView gifView) {
        if (bbE != null && !bbE.isRecycled()) {
            return bbE;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(e.f.img_loading);
        if (bitmapDrawable != null) {
            bbE = bitmapDrawable.getBitmap();
        }
        return bbE;
    }

    public b getGif() {
        if (this.ND == null) {
            onStop();
            return null;
        }
        return this.ND;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.bbz != null && !this.bbN) {
            this.bbz.onStop();
            this.bbN = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.bbB = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.bbO = aVar;
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.bbO;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setDefaultNoImageDay(int i) {
        this.bby = i;
    }

    public void Nr() {
        this.bby = e.f.pic_expression_upload_selector;
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

    public int getImageWidth() {
        if (this.bbO == null) {
            return 0;
        }
        return this.bbO.getWidth();
    }

    public int getImageHeight() {
        if (this.bbO == null) {
            return 0;
        }
        return this.bbO.getHeight();
    }
}

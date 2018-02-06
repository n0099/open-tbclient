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
import com.baidu.adp.b.a.i;
import com.baidu.adp.base.h;
import com.baidu.adp.gif.a;
import com.baidu.adp.gif.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap bvY;
    private b auf;
    private int bvR;
    private a bvS;
    private boolean bvT;
    private boolean bvU;
    private BitmapDrawable bvV;
    private boolean bvW;
    private Drawable bvX;
    private float bvZ;
    private boolean bwa;
    private Drawable bwb;
    private int bwc;
    private final Rect bwd;
    private final Rect bwe;
    private boolean bwf;
    private boolean bwg;
    private boolean bwh;
    private boolean bwi;
    private com.baidu.adp.widget.a.a bwj;
    private boolean bwk;
    private com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> bwl;
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

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvR = d.f.pic_expression_upload_selector;
        this.bvT = false;
        this.bvU = true;
        this.bwd = new Rect();
        this.bwe = new Rect();
        this.bwf = true;
        this.bwg = false;
        this.bwh = false;
        this.bwi = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.mCurrentFrame++;
                    if (GifView.this.mCurrentFrame >= gif.getFrameCount()) {
                        if (GifView.this.bwk) {
                            if (!GifView.this.bwg) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.bwk = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.bwg) {
                            GifView.this.mCurrentFrame = 0;
                        } else {
                            GifView.this.mCurrentFrame = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.cM(GifView.this.mCurrentFrame);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (z) {
                        GifView.this.onStop();
                    } else {
                        sendEmptyMessageDelayed(1, gif.cN(GifView.this.mCurrentFrame));
                    }
                }
            }
        };
        this.mType = 20;
        this.mSupportNoImage = true;
        this.bwl = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.gif.GifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
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
        this.bvV = (BitmapDrawable) getResources().getDrawable(d.f.icon_content_animation);
        this.bvV.setBounds(0, 0, this.bvV.getIntrinsicWidth(), this.bvV.getIntrinsicHeight());
        this.bvZ = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(d.f.img_loading)) != null) {
            bvY = a(this);
            this.bwe.set(0, 0, bvY.getWidth(), bvY.getHeight());
        }
        this.bvX = getResources().getDrawable(d.f.image_group_load_f);
        j(this.bvX);
    }

    private void j(Drawable drawable) {
        if (drawable != null) {
            drawable.setFilterBitmap(true);
            if (drawable instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable).setAntiAlias(true);
            }
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
                int width = bvY.getWidth();
                int height = bvY.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.bwd.set(i6, i7, width + i6, height + i7);
            }
            int intrinsicWidth = this.bvX.getIntrinsicWidth();
            int intrinsicHeight = this.bvX.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.bvX.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            if (this.bwb != null) {
                int intrinsicWidth2 = this.bwb.getIntrinsicWidth();
                int intrinsicHeight2 = this.bwb.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i10 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i11 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.bwb.setBounds(i10, i11, intrinsicWidth2 + i10, intrinsicHeight2 + i11);
            }
        }
    }

    public void release() {
        stopLoad();
        reset();
        if (this.bwh && this.auf != null && this.auf != null) {
            this.auf.close();
            this.auf = null;
        }
    }

    private void reset() {
        this.auf = null;
        this.mBitmap = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.bvW = false;
        this.mCurrentFrame = 0;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        setBackgroundDrawable(null);
        this.bwj = aVar;
        this.bvW = false;
        this.mIsLoading = false;
        this.bwa = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.bvW = true;
            this.bvT = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.auf != null) {
                this.auf.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.sf()) {
                this.bvT = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.auf != null) {
                this.auf.close();
            }
        } else if (this.auf == null || !aVar.getGif().equals(this.auf)) {
            this.bvT = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.auf = aVar.getGif();
                aVar.getGif().cM(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.bwf) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().cM(this.mCurrentFrame);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.bwf) {
                resume();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [402=4, 403=4, 404=4] */
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
        com.baidu.adp.widget.a.a g = a.C0015a.lh().g(bArr, 0, i2);
        this.bwh = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.bwf;
    }

    public void setAutoPlay(boolean z) {
        this.bwf = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.bwi = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.cN(this.mCurrentFrame));
        }
    }

    public void stop() {
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.cM(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.bwi = false;
        b gif = getGif();
        if (gif != null) {
            if (this.mCurrentFrame != 0) {
                this.mCurrentFrame = 0;
            }
            gif.cM(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.cN(this.mCurrentFrame));
        }
    }

    public void Ms() {
        this.bwk = true;
        play();
    }

    public void onDestroy() {
        this.bwj = null;
        if (this.auf != null) {
            this.auf.close();
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
        reset();
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
        if (!this.bvT) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.bvW && !this.bwa) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.auf != null && !this.mIsLoading && !this.bvW && !this.bwa) {
                this.auf.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.bvT && this.bvU) {
            canvas.save();
            this.bvV.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.bwe, this.bwd, (Paint) null);
            canvas.restore();
        } else if (this.bvW || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.bvX.draw(canvas);
            canvas.restore();
        } else if (this.bwa) {
            canvas.save();
            this.bwb.draw(canvas);
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

    public void h(boolean z, int i) {
        this.bwa = z;
        if (z) {
            this.mIsLoading = false;
            this.bvW = false;
            if (this.bwb == null || this.bwc != i) {
                this.bwc = i;
                this.bwb = aj.getDrawable(i);
                int intrinsicWidth = this.bwb.getIntrinsicWidth();
                int intrinsicHeight = this.bwb.getIntrinsicHeight();
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
                this.bwb.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
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
        this.mCurrentDegrees += this.bvZ;
        if (this.mCurrentDegrees > 360.0f - this.bvZ) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.bvS = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.bwb != null && this.bwb.isStateful()) {
            this.bwb.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = 20;
        if (gifInfo == null) {
            this.mGifInfo = null;
            return;
        }
        boolean Pa = com.baidu.tbadk.util.i.Pa();
        h ai = com.baidu.adp.base.i.ai(getContext());
        if (ai != null) {
            BdUniqueId uniqueId = ai.getUniqueId();
            z = ai.isScroll();
            bdUniqueId = uniqueId;
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo != null && this.mGifInfo != null && gifInfo.mDynamicUrl != null && am.equals(gifInfo.mDynamicUrl, this.mGifInfo.mDynamicUrl) && gifInfo.mSharpText.equals(this.mGifInfo.mSharpText) && gifInfo.mStaticUrl.equals(this.mGifInfo.mStaticUrl) && this.mPageId == bdUniqueId)) {
            stopLoad();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        this.mUrl = null;
        reset();
        String str = Pa ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.nm().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Pa), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else if (!c.nm().dh(this.mType) && this.mSupportNoImage) {
            h(true, this.bvR);
        } else if (!z) {
            startLoading();
            c.nm().a(this.mGifInfo.mSharpText, this.mType, this.bwl, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Pa), str);
        }
    }

    public void E(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = i;
        this.mGifInfo = null;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = null;
            return;
        }
        h ai = com.baidu.adp.base.i.ai(getContext());
        if (ai != null) {
            bdUniqueId = ai.getUniqueId();
            z = ai.isScroll();
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
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.nm().a(str, i, new Object[0]);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (!c.nm().dh(this.mType) && this.mSupportNoImage) {
            h(true, this.bvR);
        } else if (!z) {
            c.nm().a(this.mUrl, i, this.bwl, this.mPageId);
        }
    }

    public void stopLoad() {
        stopLoading();
        this.bvW = false;
        this.bwa = false;
        if (this.mGifInfo != null) {
            c.nm().a(this.mGifInfo.mSharpText, this.mType, this.bwl);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            c.nm().a(this.mUrl, this.mType, this.bwl);
        }
    }

    @Override // com.baidu.adp.b.a.i
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean Pa = com.baidu.tbadk.util.i.Pa();
            String str = Pa ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.nm().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Pa), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.nm().a(this.mGifInfo.mSharpText, this.mType, this.bwl, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Pa), str);
                return;
            }
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) c.nm().a(this.mUrl, this.mType, new Object[0]);
            if (aVar2 != null) {
                this.bvW = false;
                setGif(aVar2);
            } else {
                startLoading();
                c.nm().a(this.mUrl, this.mType, this.bwl, this.mPageId);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.bwg = z;
    }

    public static Bitmap a(GifView gifView) {
        if (bvY != null && !bvY.isRecycled()) {
            return bvY;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(d.f.img_loading);
        if (bitmapDrawable != null) {
            bvY = bitmapDrawable.getBitmap();
        }
        return bvY;
    }

    public b getGif() {
        if (this.auf == null) {
            onStop();
            return null;
        }
        return this.auf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.bvS != null && !this.bwi) {
            this.bvS.onStop();
            this.bwi = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.bvU = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.a.a aVar) {
        this.bwj = aVar;
    }

    public com.baidu.adp.widget.a.a getBdImage() {
        return this.bwj;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setDefaultNoImageDay(int i) {
        this.bvR = i;
    }

    public void Mt() {
        this.bvR = d.f.pic_expression_upload_selector;
    }

    public void setDispatchTouchListener(TbRichTextView.f fVar) {
        this.mDispatchTouchListener = fVar;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mDispatchTouchListener != null) {
            this.mDispatchTouchListener.F(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}

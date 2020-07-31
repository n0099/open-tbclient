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
import com.baidu.adp.base.h;
import com.baidu.adp.gif.a;
import com.baidu.adp.gif.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.newwidget.ImageView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.h.d;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends TbImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap eDE;
    private b TX;
    private int aOg;
    private int aev;
    private boolean cqD;
    private final Rect destRect;
    private boolean eDA;
    private boolean eDB;
    private BitmapDrawable eDC;
    private boolean eDD;
    private float eDF;
    private boolean eDG;
    private Drawable eDH;
    private int eDI;
    private boolean eDJ;
    private boolean eDK;
    private boolean eDL;
    private com.baidu.adp.widget.ImageView.a eDM;
    private String eDN;
    private int eDO;
    private boolean eDP;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eDQ;
    private TbRichTextView.g eDR;
    private int eDy;
    private a eDz;
    private d euS;
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

    /* loaded from: classes.dex */
    public interface a {
        void onStop();
    }

    public void setErrorResid(int i) {
        this.eDO = i;
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
        this.eDy = R.drawable.pic_expression_upload_selector;
        this.eDA = false;
        this.eDB = true;
        this.destRect = new Rect();
        this.srcRect = new Rect();
        this.cqD = true;
        this.eDJ = false;
        this.eDK = false;
        this.eDL = false;
        this.eDO = R.drawable.image_group_load_f;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.aOg++;
                    if (GifView.this.aOg >= gif.getFrameCount()) {
                        if (GifView.this.eDP) {
                            if (!GifView.this.eDJ) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.eDP = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.eDJ) {
                            GifView.this.aOg = 0;
                        } else {
                            GifView.this.aOg = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.Z(GifView.this.aOg);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (!z) {
                        sendEmptyMessageDelayed(1, gif.aa(GifView.this.aOg));
                    } else {
                        GifView.this.onStop();
                    }
                }
            }
        };
        this.mType = 20;
        this.mSupportNoImage = true;
        this.eDQ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.eDC = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.eDC.setBounds(0, 0, this.eDC.getIntrinsicWidth(), this.eDC.getIntrinsicHeight());
        this.eDF = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            eDE = a(this);
            this.srcRect.set(0, 0, eDE.getWidth(), eDE.getHeight());
        }
        this.aev = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
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
                int width = eDE.getWidth();
                int height = eDE.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.destRect.set(i6, i7, width + i6, height + i7);
            }
            if (this.eDH != null) {
                int intrinsicWidth = this.eDH.getIntrinsicWidth();
                int intrinsicHeight = this.eDH.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.eDH.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    public void release() {
        stopLoad();
        reset();
        if (this.eDK && this.TX != null && this.TX != null) {
            this.TX.close();
            this.TX = null;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        super.reset();
        this.TX = null;
        this.mBitmap = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eDD = false;
        this.aOg = 0;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
    }

    private void bkg() {
        ao.setImageResource(this, this.eDO);
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        setBackgroundDrawable(null);
        this.eDM = aVar;
        this.eDD = false;
        this.mIsLoading = false;
        this.eDG = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.eDD = true;
            this.eDA = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            bkg();
            if (this.TX != null) {
                this.TX.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.isEmotionGif()) {
                this.eDA = true;
                aVar.drawImageTo(this);
                this.mIsLoading = false;
            }
            if (this.TX != null) {
                this.TX.close();
            }
        } else if (this.TX == null || !aVar.getGif().equals(this.TX)) {
            this.eDA = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.TX = aVar.getGif();
                aVar.getGif().Z(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.cqD) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            if (this.aOg >= aVar.getGif().getFrameCount()) {
                this.aOg = 0;
            }
            aVar.getGif().Z(this.aOg);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.cqD) {
                resume();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [375=4, 376=4, 377=4] */
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
        com.baidu.adp.widget.ImageView.a f = a.C0019a.ke().f(bArr, 0, i2);
        this.eDK = true;
        setGif(f);
    }

    public boolean getAutoPlay() {
        return this.cqD;
    }

    public void setAutoPlay(boolean z) {
        this.cqD = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.eDL = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.aa(this.aOg));
        }
    }

    public void stop() {
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.Z(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.eDL = false;
        b gif = getGif();
        if (gif != null) {
            if (this.aOg != 0) {
                this.aOg = 0;
            }
            gif.Z(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.aa(this.aOg));
        }
    }

    public void onDestroy() {
        this.eDM = null;
        if (this.TX != null) {
            this.TX.close();
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
        if (!this.eDA) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    private boolean bkh() {
        return this.eDD || (this.mGifInfo != null && this.mGifInfo.mLoadFailed);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if ((!this.mIsLoading && !this.eDD && !this.eDG) || bkh()) {
                super.onDraw(canvas);
            }
            canvas.save();
            if (this.TX != null && !this.mIsLoading && !this.eDD && !this.eDG) {
                this.TX.a(null, canvas);
            }
            canvas.restore();
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        if (this.eDA && this.eDB) {
            canvas.save();
            this.eDC.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.srcRect, this.destRect, (Paint) null);
            canvas.restore();
        } else if (this.eDG) {
            canvas.save();
            this.eDH.draw(canvas);
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
        this.eDG = z;
        if (z) {
            this.mIsLoading = false;
            this.eDD = false;
            if (this.eDH == null || this.eDI != i) {
                this.eDI = i;
                this.eDH = ao.getDrawable(i);
                int intrinsicWidth = this.eDH.getIntrinsicWidth();
                int intrinsicHeight = this.eDH.getIntrinsicHeight();
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
                this.eDH.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        } else {
            this.eDH = null;
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
        this.mCurrentDegrees += this.eDF;
        if (this.mCurrentDegrees > 360.0f - this.eDF) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.eDz = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.eDH != null && this.eDH.isStateful()) {
            this.eDH.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = 20;
        if (gifInfo == null) {
            this.mGifInfo = null;
            bkg();
            return;
        }
        boolean bmE = m.bmE();
        h E = com.baidu.adp.base.i.E(getContext());
        if (E != null) {
            bdUniqueId = E.getUniqueId();
            z = E.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(this.mGifInfo != null && gifInfo.mDynamicUrl != null && as.equals(gifInfo.mDynamicUrl, this.mGifInfo.mDynamicUrl) && as.equals(gifInfo.mSharpText, this.mGifInfo.mSharpText) && as.equals(gifInfo.mStaticUrl, this.mGifInfo.mStaticUrl) && this.mPageId == bdUniqueId)) {
            stopLoad();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        this.eDN = null;
        reset();
        String str = bmE ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ln().loadResourceFromMemery(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bmE), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
            bkg();
        } else if (!c.ln().ao(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.eDy);
        } else if (!z) {
            startLoading();
            c.ln().a(this.mGifInfo.mSharpText, this.mType, this.eDQ, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bmE), str);
        }
    }

    public void ap(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = i;
        this.mGifInfo = null;
        if (TextUtils.isEmpty(str)) {
            this.eDN = null;
            bkg();
            return;
        }
        h E = com.baidu.adp.base.i.E(getContext());
        if (E != null) {
            bdUniqueId = E.getUniqueId();
            z = E.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.eDN) && i == this.mType && bdUniqueId == this.mPageId)) {
            stopLoad();
        }
        this.mPageId = bdUniqueId;
        reset();
        this.eDN = str;
        this.mGifInfo = null;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ln().loadResourceFromMemery(str, i, new Object[0]);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (!c.ln().ao(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.eDy);
        } else if (!z) {
            c.ln().a(this.eDN, i, this.eDQ, this.mPageId);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoad() {
        stopLoading();
        this.eDD = false;
        this.eDG = false;
        if (this.mGifInfo != null) {
            c.ln().a(this.mGifInfo.mSharpText, this.mType, this.eDQ);
        }
        if (!TextUtils.isEmpty(this.eDN)) {
            c.ln().a(this.eDN, this.mType, this.eDQ);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.i
    public void refresh() {
        if (this.mGifInfo != null) {
            a(this.mGifInfo);
        }
        if (!TextUtils.isEmpty(this.eDN)) {
            ap(this.eDN, this.mType);
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
        this.euS = dVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.euS == null || !this.euS.onClickEvent(view)) {
            if (this.mGifInfo != null) {
                boolean bmE = m.bmE();
                String str = bmE ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ln().loadResourceFromMemery(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bmE), str);
                if (aVar != null) {
                    this.mGifInfo.mLoadFailed = false;
                    setGif(aVar);
                } else {
                    startLoading();
                    c.ln().a(this.mGifInfo.mSharpText, this.mType, this.eDQ, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bmE), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.eDN)) {
                com.baidu.adp.widget.ImageView.a aVar2 = (com.baidu.adp.widget.ImageView.a) c.ln().loadResourceFromMemery(this.eDN, this.mType, new Object[0]);
                if (aVar2 != null) {
                    this.eDD = false;
                    setGif(aVar2);
                } else {
                    startLoading();
                    c.ln().a(this.eDN, this.mType, this.eDQ, this.mPageId);
                    return;
                }
            }
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(view);
            }
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.eDJ = z;
    }

    public static Bitmap a(GifView gifView) {
        if (eDE != null && !eDE.isRecycled()) {
            return eDE;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
        if (bitmapDrawable != null) {
            eDE = bitmapDrawable.getBitmap();
        }
        return eDE;
    }

    public b getGif() {
        if (this.TX == null) {
            onStop();
            return null;
        }
        return this.TX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.eDz != null && !this.eDL) {
            this.eDz.onStop();
            this.eDL = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.eDB = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.eDM = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.eDM;
    }

    public void setType(int i) {
        this.mType = i;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.eDN;
    }

    public void setDefaultNoImageDay(int i) {
        this.eDy = i;
    }

    public void bki() {
        this.eDy = R.drawable.pic_expression_upload_selector;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.eDR = gVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eDR != null) {
            this.eDR.w(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        if (this.eDM == null) {
            return 0;
        }
        return this.eDM.getWidth();
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        if (this.eDM == null) {
            return 0;
        }
        return this.eDM.getHeight();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float getRadius() {
        return this.aev;
    }
}

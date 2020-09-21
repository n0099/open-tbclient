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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.h.d;
import com.baidu.tbadk.util.n;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends TbImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap eQY;
    private b UV;
    private int aVK;
    private int afY;
    private boolean cAy;
    private d eHB;
    private int eQS;
    private a eQT;
    private boolean eQU;
    private boolean eQV;
    private BitmapDrawable eQW;
    private boolean eQX;
    private float eQZ;
    private boolean eRa;
    private Drawable eRb;
    private int eRc;
    private final Rect eRd;
    private final Rect eRe;
    private boolean eRf;
    private boolean eRg;
    private boolean eRh;
    private com.baidu.adp.widget.ImageView.a eRi;
    private String eRj;
    private int eRk;
    private boolean eRl;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eRm;
    private TbRichTextView.g eRn;
    private Bitmap mBitmap;
    private float mCurrentDegrees;
    private GifInfo mGifInfo;
    private Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private boolean mSupportNoImage;
    private int mType;

    /* loaded from: classes.dex */
    public interface a {
        void onStop();
    }

    public void setErrorResid(int i) {
        this.eRk = i;
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
        this.eQS = R.drawable.pic_expression_upload_selector;
        this.eQU = false;
        this.eQV = true;
        this.eRd = new Rect();
        this.eRe = new Rect();
        this.cAy = true;
        this.eRf = false;
        this.eRg = false;
        this.eRh = false;
        this.eRk = R.drawable.image_group_load_f;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.aVK++;
                    if (GifView.this.aVK >= gif.getFrameCount()) {
                        if (GifView.this.eRl) {
                            if (!GifView.this.eRf) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.eRl = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.eRf) {
                            GifView.this.aVK = 0;
                        } else {
                            GifView.this.aVK = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.ac(GifView.this.aVK);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (!z) {
                        sendEmptyMessageDelayed(1, gif.ad(GifView.this.aVK));
                    } else {
                        GifView.this.onStop();
                    }
                }
            }
        };
        this.mType = 20;
        this.mSupportNoImage = true;
        this.eRm = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.eQW = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.eQW.setBounds(0, 0, this.eQW.getIntrinsicWidth(), this.eQW.getIntrinsicHeight());
        this.eQZ = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            eQY = a(this);
            this.eRe.set(0, 0, eQY.getWidth(), eQY.getHeight());
        }
        this.afY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
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
                int width = eQY.getWidth();
                int height = eQY.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.eRd.set(i6, i7, width + i6, height + i7);
            }
            if (this.eRb != null) {
                int intrinsicWidth = this.eRb.getIntrinsicWidth();
                int intrinsicHeight = this.eRb.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.eRb.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    public void release() {
        stopLoad();
        reset();
        if (this.eRg && this.UV != null && this.UV != null) {
            this.UV.close();
            this.UV = null;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        super.reset();
        this.UV = null;
        this.mBitmap = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eQX = false;
        this.aVK = 0;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
    }

    private void btX() {
        ap.setImageResource(this, this.eRk);
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        setBackgroundDrawable(null);
        this.eRi = aVar;
        this.eQX = false;
        this.mIsLoading = false;
        this.eRa = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.eQX = true;
            this.eQU = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            btX();
            if (this.UV != null) {
                this.UV.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.isEmotionGif()) {
                this.eQU = true;
                aVar.drawImageTo(this);
                this.mIsLoading = false;
            }
            if (this.UV != null) {
                this.UV.close();
            }
        } else if (this.UV == null || !aVar.getGif().equals(this.UV)) {
            this.eQU = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.UV = aVar.getGif();
                aVar.getGif().ac(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.cAy) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            if (this.aVK >= aVar.getGif().getFrameCount()) {
                this.aVK = 0;
            }
            aVar.getGif().ac(this.aVK);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.cAy) {
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
        com.baidu.adp.widget.ImageView.a f = a.C0017a.lH().f(bArr, 0, i2);
        this.eRg = true;
        setGif(f);
    }

    public boolean getAutoPlay() {
        return this.cAy;
    }

    public void setAutoPlay(boolean z) {
        this.cAy = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.eRh = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.ad(this.aVK));
        }
    }

    public void stop() {
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.ac(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.eRh = false;
        b gif = getGif();
        if (gif != null) {
            if (this.aVK != 0) {
                this.aVK = 0;
            }
            gif.ac(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.ad(this.aVK));
        }
    }

    public void onDestroy() {
        this.eRi = null;
        if (this.UV != null) {
            this.UV.close();
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
        if (!this.eQU) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    private boolean btY() {
        return this.eQX || (this.mGifInfo != null && this.mGifInfo.mLoadFailed);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if ((!this.mIsLoading && !this.eQX && !this.eRa) || btY()) {
                super.onDraw(canvas);
            }
            canvas.save();
            if (this.UV != null && !this.mIsLoading && !this.eQX && !this.eRa) {
                this.UV.a(null, canvas);
            }
            canvas.restore();
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        if (this.eQU && this.eQV) {
            canvas.save();
            this.eQW.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.eRe, this.eRd, (Paint) null);
            canvas.restore();
        } else if (this.eRa) {
            canvas.save();
            this.eRb.draw(canvas);
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
        this.eRa = z;
        if (z) {
            this.mIsLoading = false;
            this.eQX = false;
            if (this.eRb == null || this.eRc != i) {
                this.eRc = i;
                this.eRb = ap.getDrawable(i);
                int intrinsicWidth = this.eRb.getIntrinsicWidth();
                int intrinsicHeight = this.eRb.getIntrinsicHeight();
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
                this.eRb.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        } else {
            this.eRb = null;
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
        this.mCurrentDegrees += this.eQZ;
        if (this.mCurrentDegrees > 360.0f - this.eQZ) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.eQT = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.eRb != null && this.eRb.isStateful()) {
            this.eRb.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = 20;
        if (gifInfo == null) {
            this.mGifInfo = null;
            btX();
            return;
        }
        boolean bwB = n.bwB();
        h G = com.baidu.adp.base.i.G(getContext());
        if (G != null) {
            bdUniqueId = G.getUniqueId();
            z = G.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(this.mGifInfo != null && gifInfo.mDynamicUrl != null && at.equals(gifInfo.mDynamicUrl, this.mGifInfo.mDynamicUrl) && at.equals(gifInfo.mSharpText, this.mGifInfo.mSharpText) && at.equals(gifInfo.mStaticUrl, this.mGifInfo.mStaticUrl) && this.mPageId == bdUniqueId)) {
            stopLoad();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        this.eRj = null;
        reset();
        String str = bwB ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mR().loadResourceFromMemery(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bwB), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
            btX();
        } else if (!c.mR().at(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.eQS);
        } else if (!z) {
            startLoading();
            c.mR().a(this.mGifInfo.mSharpText, this.mType, this.eRm, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bwB), str);
        }
    }

    public void as(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = i;
        this.mGifInfo = null;
        if (TextUtils.isEmpty(str)) {
            this.eRj = null;
            btX();
            return;
        }
        h G = com.baidu.adp.base.i.G(getContext());
        if (G != null) {
            bdUniqueId = G.getUniqueId();
            z = G.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.eRj) && i == this.mType && bdUniqueId == this.mPageId)) {
            stopLoad();
        }
        this.mPageId = bdUniqueId;
        reset();
        this.eRj = str;
        this.mGifInfo = null;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mR().loadResourceFromMemery(str, i, new Object[0]);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (!c.mR().at(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.eQS);
        } else if (!z) {
            c.mR().a(this.eRj, i, this.eRm, this.mPageId);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoad() {
        stopLoading();
        this.eQX = false;
        this.eRa = false;
        if (this.mGifInfo != null) {
            c.mR().a(this.mGifInfo.mSharpText, this.mType, this.eRm);
        }
        if (!TextUtils.isEmpty(this.eRj)) {
            c.mR().a(this.eRj, this.mType, this.eRm);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.i
    public void refresh() {
        if (this.mGifInfo != null) {
            a(this.mGifInfo);
        }
        if (!TextUtils.isEmpty(this.eRj)) {
            as(this.eRj, this.mType);
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
        this.eHB = dVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eHB == null || !this.eHB.onClickEvent(view)) {
            if (this.mGifInfo != null) {
                boolean bwB = n.bwB();
                String str = bwB ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mR().loadResourceFromMemery(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bwB), str);
                if (aVar != null) {
                    this.mGifInfo.mLoadFailed = false;
                    setGif(aVar);
                } else {
                    startLoading();
                    c.mR().a(this.mGifInfo.mSharpText, this.mType, this.eRm, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bwB), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.eRj)) {
                com.baidu.adp.widget.ImageView.a aVar2 = (com.baidu.adp.widget.ImageView.a) c.mR().loadResourceFromMemery(this.eRj, this.mType, new Object[0]);
                if (aVar2 != null) {
                    this.eQX = false;
                    setGif(aVar2);
                } else {
                    startLoading();
                    c.mR().a(this.eRj, this.mType, this.eRm, this.mPageId);
                    return;
                }
            }
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(view);
            }
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.eRf = z;
    }

    public static Bitmap a(GifView gifView) {
        if (eQY != null && !eQY.isRecycled()) {
            return eQY;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
        if (bitmapDrawable != null) {
            eQY = bitmapDrawable.getBitmap();
        }
        return eQY;
    }

    public b getGif() {
        if (this.UV == null) {
            onStop();
            return null;
        }
        return this.UV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.eQT != null && !this.eRh) {
            this.eQT.onStop();
            this.eRh = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.eQV = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.eRi = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.eRi;
    }

    public void setType(int i) {
        this.mType = i;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.eRj;
    }

    public void setDefaultNoImageDay(int i) {
        this.eQS = i;
    }

    public void btZ() {
        this.eQS = R.drawable.pic_expression_upload_selector;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.eRn = gVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eRn != null) {
            this.eRn.L(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        if (this.eRi == null) {
            return 0;
        }
        return this.eRi.getWidth();
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        if (this.eRi == null) {
            return 0;
        }
        return this.eRi.getHeight();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float getRadius() {
        return this.afY;
    }
}

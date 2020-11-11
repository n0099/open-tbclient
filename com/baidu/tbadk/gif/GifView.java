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
    public static Bitmap fry;
    private b Vm;
    private int agr;
    private int bbL;
    private boolean daT;
    private d fhV;
    private boolean frA;
    private Drawable frB;
    private int frC;
    private final Rect frD;
    private final Rect frE;
    private boolean frF;
    private boolean frG;
    private boolean frH;
    private com.baidu.adp.widget.ImageView.a frI;
    private String frJ;
    private int frK;
    private boolean frL;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> frM;
    private TbRichTextView.g frN;
    private int frr;
    private a frt;
    private boolean fru;
    private boolean frv;
    private BitmapDrawable frw;
    private boolean frx;
    private float frz;
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
        this.frK = i;
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
        this.frr = R.drawable.pic_expression_upload_selector;
        this.fru = false;
        this.frv = true;
        this.frD = new Rect();
        this.frE = new Rect();
        this.daT = true;
        this.frF = false;
        this.frG = false;
        this.frH = false;
        this.frK = R.drawable.image_group_load_f;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.bbL++;
                    if (GifView.this.bbL >= gif.getFrameCount()) {
                        if (GifView.this.frL) {
                            if (!GifView.this.frF) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.frL = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.frF) {
                            GifView.this.bbL = 0;
                        } else {
                            GifView.this.bbL = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.ac(GifView.this.bbL);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (!z) {
                        sendEmptyMessageDelayed(1, gif.ad(GifView.this.bbL));
                    } else {
                        GifView.this.onStop();
                    }
                }
            }
        };
        this.mType = 20;
        this.mSupportNoImage = true;
        this.frM = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.frw = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.frw.setBounds(0, 0, this.frw.getIntrinsicWidth(), this.frw.getIntrinsicHeight());
        this.frz = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            fry = a(this);
            this.frE.set(0, 0, fry.getWidth(), fry.getHeight());
        }
        this.agr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
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
                int width = fry.getWidth();
                int height = fry.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.frD.set(i6, i7, width + i6, height + i7);
            }
            if (this.frB != null) {
                int intrinsicWidth = this.frB.getIntrinsicWidth();
                int intrinsicHeight = this.frB.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.frB.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    public void release() {
        stopLoad();
        reset();
        if (this.frG && this.Vm != null && this.Vm != null) {
            this.Vm.close();
            this.Vm = null;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        super.reset();
        this.Vm = null;
        this.mBitmap = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.frx = false;
        this.bbL = 0;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
    }

    private void bAZ() {
        ap.setImageResource(this, this.frK);
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        setBackgroundDrawable(null);
        this.frI = aVar;
        this.frx = false;
        this.mIsLoading = false;
        this.frA = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.frx = true;
            this.fru = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            bAZ();
            if (this.Vm != null) {
                this.Vm.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.isEmotionGif()) {
                this.fru = true;
                aVar.drawImageTo(this);
                this.mIsLoading = false;
            }
            if (this.Vm != null) {
                this.Vm.close();
            }
        } else if (this.Vm == null || !aVar.getGif().equals(this.Vm)) {
            this.fru = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Vm = aVar.getGif();
                aVar.getGif().ac(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.daT) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            if (this.bbL >= aVar.getGif().getFrameCount()) {
                this.bbL = 0;
            }
            aVar.getGif().ac(this.bbL);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.daT) {
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
        com.baidu.adp.widget.ImageView.a f = a.C0018a.lI().f(bArr, 0, i2);
        this.frG = true;
        setGif(f);
    }

    public boolean getAutoPlay() {
        return this.daT;
    }

    public void setAutoPlay(boolean z) {
        this.daT = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.frH = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.ad(this.bbL));
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
        this.frH = false;
        b gif = getGif();
        if (gif != null) {
            if (this.bbL != 0) {
                this.bbL = 0;
            }
            gif.ac(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.ad(this.bbL));
        }
    }

    public void onDestroy() {
        this.frI = null;
        if (this.Vm != null) {
            this.Vm.close();
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
        if (!this.fru) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    private boolean bBa() {
        return this.frx || (this.mGifInfo != null && this.mGifInfo.mLoadFailed);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if ((!this.mIsLoading && !this.frx && !this.frA) || bBa()) {
                super.onDraw(canvas);
            }
            canvas.save();
            if (this.Vm != null && !this.mIsLoading && !this.frx && !this.frA) {
                this.Vm.a(null, canvas);
            }
            canvas.restore();
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        if (this.fru && this.frv) {
            canvas.save();
            this.frw.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.frE, this.frD, (Paint) null);
            canvas.restore();
        } else if (this.frA) {
            canvas.save();
            this.frB.draw(canvas);
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
        this.frA = z;
        if (z) {
            this.mIsLoading = false;
            this.frx = false;
            if (this.frB == null || this.frC != i) {
                this.frC = i;
                this.frB = ap.getDrawable(i);
                int intrinsicWidth = this.frB.getIntrinsicWidth();
                int intrinsicHeight = this.frB.getIntrinsicHeight();
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
                this.frB.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        } else {
            this.frB = null;
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
        this.mCurrentDegrees += this.frz;
        if (this.mCurrentDegrees > 360.0f - this.frz) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.frt = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.frB != null && this.frB.isStateful()) {
            this.frB.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = 20;
        if (gifInfo == null) {
            this.mGifInfo = null;
            bAZ();
            return;
        }
        boolean bDD = n.bDD();
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
        this.frJ = null;
        reset();
        String str = bDD ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mS().loadResourceFromMemery(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bDD), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
            bAZ();
        } else if (!c.mS().at(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.frr);
        } else if (!z) {
            startLoading();
            c.mS().a(this.mGifInfo.mSharpText, this.mType, this.frM, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bDD), str);
        }
    }

    public void av(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = i;
        this.mGifInfo = null;
        if (TextUtils.isEmpty(str)) {
            this.frJ = null;
            bAZ();
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
        if (!(str.equals(this.frJ) && i == this.mType && bdUniqueId == this.mPageId)) {
            stopLoad();
        }
        this.mPageId = bdUniqueId;
        reset();
        this.frJ = str;
        this.mGifInfo = null;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mS().loadResourceFromMemery(str, i, new Object[0]);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (!c.mS().at(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.frr);
        } else if (!z) {
            c.mS().a(this.frJ, i, this.frM, this.mPageId);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoad() {
        stopLoading();
        this.frx = false;
        this.frA = false;
        if (this.mGifInfo != null) {
            c.mS().a(this.mGifInfo.mSharpText, this.mType, this.frM);
        }
        if (!TextUtils.isEmpty(this.frJ)) {
            c.mS().a(this.frJ, this.mType, this.frM);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.i
    public void refresh() {
        if (this.mGifInfo != null) {
            a(this.mGifInfo);
        }
        if (!TextUtils.isEmpty(this.frJ)) {
            av(this.frJ, this.mType);
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
        this.fhV = dVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fhV == null || !this.fhV.onClickEvent(view)) {
            if (this.mGifInfo != null) {
                boolean bDD = n.bDD();
                String str = bDD ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mS().loadResourceFromMemery(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bDD), str);
                if (aVar != null) {
                    this.mGifInfo.mLoadFailed = false;
                    setGif(aVar);
                } else {
                    startLoading();
                    c.mS().a(this.mGifInfo.mSharpText, this.mType, this.frM, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bDD), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.frJ)) {
                com.baidu.adp.widget.ImageView.a aVar2 = (com.baidu.adp.widget.ImageView.a) c.mS().loadResourceFromMemery(this.frJ, this.mType, new Object[0]);
                if (aVar2 != null) {
                    this.frx = false;
                    setGif(aVar2);
                } else {
                    startLoading();
                    c.mS().a(this.frJ, this.mType, this.frM, this.mPageId);
                    return;
                }
            }
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(view);
            }
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.frF = z;
    }

    public static Bitmap a(GifView gifView) {
        if (fry != null && !fry.isRecycled()) {
            return fry;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
        if (bitmapDrawable != null) {
            fry = bitmapDrawable.getBitmap();
        }
        return fry;
    }

    public b getGif() {
        if (this.Vm == null) {
            onStop();
            return null;
        }
        return this.Vm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.frt != null && !this.frH) {
            this.frt.onStop();
            this.frH = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.frv = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.frI = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.frI;
    }

    public void setType(int i) {
        this.mType = i;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.frJ;
    }

    public void setDefaultNoImageDay(int i) {
        this.frr = i;
    }

    public void bBb() {
        this.frr = R.drawable.pic_expression_upload_selector;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.frN = gVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.frN != null) {
            this.frN.L(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        if (this.frI == null) {
            return 0;
        }
        return this.frI.getWidth();
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        if (this.frI == null) {
            return 0;
        }
        return this.frI.getHeight();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float getRadius() {
        return this.agr;
    }
}

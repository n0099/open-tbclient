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
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class GifView extends TbImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap eOd;
    private b Uz;
    private int aTt;
    private int afE;
    private boolean cyt;
    private d eFq;
    private int eNX;
    private a eNY;
    private boolean eNZ;
    private boolean eOa;
    private BitmapDrawable eOb;
    private boolean eOc;
    private float eOe;
    private boolean eOf;
    private Drawable eOg;
    private int eOh;
    private final Rect eOi;
    private final Rect eOj;
    private boolean eOk;
    private boolean eOl;
    private boolean eOm;
    private com.baidu.adp.widget.ImageView.a eOn;
    private String eOo;
    private int eOp;
    private boolean eOq;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eOr;
    private TbRichTextView.g eOs;
    private Bitmap mBitmap;
    private float mCurrentDegrees;
    private GifInfo mGifInfo;
    private Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private boolean mSupportNoImage;
    private int mType;

    /* loaded from: classes2.dex */
    public interface a {
        void onStop();
    }

    public void setErrorResid(int i) {
        this.eOp = i;
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
        this.eNX = R.drawable.pic_expression_upload_selector;
        this.eNZ = false;
        this.eOa = true;
        this.eOi = new Rect();
        this.eOj = new Rect();
        this.cyt = true;
        this.eOk = false;
        this.eOl = false;
        this.eOm = false;
        this.eOp = R.drawable.image_group_load_f;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.aTt++;
                    if (GifView.this.aTt >= gif.getFrameCount()) {
                        if (GifView.this.eOq) {
                            if (!GifView.this.eOk) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.eOq = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.eOk) {
                            GifView.this.aTt = 0;
                        } else {
                            GifView.this.aTt = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.ab(GifView.this.aTt);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (!z) {
                        sendEmptyMessageDelayed(1, gif.ac(GifView.this.aTt));
                    } else {
                        GifView.this.onStop();
                    }
                }
            }
        };
        this.mType = 20;
        this.mSupportNoImage = true;
        this.eOr = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.eOb = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.eOb.setBounds(0, 0, this.eOb.getIntrinsicWidth(), this.eOb.getIntrinsicHeight());
        this.eOe = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            eOd = a(this);
            this.eOj.set(0, 0, eOd.getWidth(), eOd.getHeight());
        }
        this.afE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
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
                int width = eOd.getWidth();
                int height = eOd.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.eOi.set(i6, i7, width + i6, height + i7);
            }
            if (this.eOg != null) {
                int intrinsicWidth = this.eOg.getIntrinsicWidth();
                int intrinsicHeight = this.eOg.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.eOg.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    public void release() {
        stopLoad();
        reset();
        if (this.eOl && this.Uz != null && this.Uz != null) {
            this.Uz.close();
            this.Uz = null;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        super.reset();
        this.Uz = null;
        this.mBitmap = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.eOc = false;
        this.aTt = 0;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
    }

    private void bsS() {
        ap.setImageResource(this, this.eOp);
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        setBackgroundDrawable(null);
        this.eOn = aVar;
        this.eOc = false;
        this.mIsLoading = false;
        this.eOf = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.eOc = true;
            this.eNZ = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            bsS();
            if (this.Uz != null) {
                this.Uz.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.isEmotionGif()) {
                this.eNZ = true;
                aVar.drawImageTo(this);
                this.mIsLoading = false;
            }
            if (this.Uz != null) {
                this.Uz.close();
            }
        } else if (this.Uz == null || !aVar.getGif().equals(this.Uz)) {
            this.eNZ = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Uz = aVar.getGif();
                aVar.getGif().ab(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.cyt) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            if (this.aTt >= aVar.getGif().getFrameCount()) {
                this.aTt = 0;
            }
            aVar.getGif().ab(this.aTt);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.cyt) {
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
        com.baidu.adp.widget.ImageView.a f = a.C0016a.lD().f(bArr, 0, i2);
        this.eOl = true;
        setGif(f);
    }

    public boolean getAutoPlay() {
        return this.cyt;
    }

    public void setAutoPlay(boolean z) {
        this.cyt = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.eOm = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.ac(this.aTt));
        }
    }

    public void stop() {
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.ab(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.eOm = false;
        b gif = getGif();
        if (gif != null) {
            if (this.aTt != 0) {
                this.aTt = 0;
            }
            gif.ab(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.ac(this.aTt));
        }
    }

    public void onDestroy() {
        this.eOn = null;
        if (this.Uz != null) {
            this.Uz.close();
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
        if (!this.eNZ) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    private boolean bsT() {
        return this.eOc || (this.mGifInfo != null && this.mGifInfo.mLoadFailed);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if ((!this.mIsLoading && !this.eOc && !this.eOf) || bsT()) {
                super.onDraw(canvas);
            }
            canvas.save();
            if (this.Uz != null && !this.mIsLoading && !this.eOc && !this.eOf) {
                this.Uz.a(null, canvas);
            }
            canvas.restore();
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        if (this.eNZ && this.eOa) {
            canvas.save();
            this.eOb.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.eOj, this.eOi, (Paint) null);
            canvas.restore();
        } else if (this.eOf) {
            canvas.save();
            this.eOg.draw(canvas);
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
        this.eOf = z;
        if (z) {
            this.mIsLoading = false;
            this.eOc = false;
            if (this.eOg == null || this.eOh != i) {
                this.eOh = i;
                this.eOg = ap.getDrawable(i);
                int intrinsicWidth = this.eOg.getIntrinsicWidth();
                int intrinsicHeight = this.eOg.getIntrinsicHeight();
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
                this.eOg.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        } else {
            this.eOg = null;
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
        this.mCurrentDegrees += this.eOe;
        if (this.mCurrentDegrees > 360.0f - this.eOe) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.eNY = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.eOg != null && this.eOg.isStateful()) {
            this.eOg.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = 20;
        if (gifInfo == null) {
            this.mGifInfo = null;
            bsS();
            return;
        }
        boolean bvr = m.bvr();
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
        this.eOo = null;
        reset();
        String str = bvr ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mM().loadResourceFromMemery(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bvr), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
            bsS();
        } else if (!c.mM().aq(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.eNX);
        } else if (!z) {
            startLoading();
            c.mM().a(this.mGifInfo.mSharpText, this.mType, this.eOr, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bvr), str);
        }
    }

    public void as(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.mType = i;
        this.mGifInfo = null;
        if (TextUtils.isEmpty(str)) {
            this.eOo = null;
            bsS();
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
        if (!(str.equals(this.eOo) && i == this.mType && bdUniqueId == this.mPageId)) {
            stopLoad();
        }
        this.mPageId = bdUniqueId;
        reset();
        this.eOo = str;
        this.mGifInfo = null;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mM().loadResourceFromMemery(str, i, new Object[0]);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (!c.mM().aq(this.mType) && this.mSupportNoImage) {
            setHasNoImage(true, this.eNX);
        } else if (!z) {
            c.mM().a(this.eOo, i, this.eOr, this.mPageId);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoad() {
        stopLoading();
        this.eOc = false;
        this.eOf = false;
        if (this.mGifInfo != null) {
            c.mM().a(this.mGifInfo.mSharpText, this.mType, this.eOr);
        }
        if (!TextUtils.isEmpty(this.eOo)) {
            c.mM().a(this.eOo, this.mType, this.eOr);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.i
    public void refresh() {
        if (this.mGifInfo != null) {
            a(this.mGifInfo);
        }
        if (!TextUtils.isEmpty(this.eOo)) {
            as(this.eOo, this.mType);
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
        this.eFq = dVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eFq == null || !this.eFq.onClickEvent(view)) {
            if (this.mGifInfo != null) {
                boolean bvr = m.bvr();
                String str = bvr ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
                com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.mM().loadResourceFromMemery(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bvr), str);
                if (aVar != null) {
                    this.mGifInfo.mLoadFailed = false;
                    setGif(aVar);
                } else {
                    startLoading();
                    c.mM().a(this.mGifInfo.mSharpText, this.mType, this.eOr, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(bvr), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.eOo)) {
                com.baidu.adp.widget.ImageView.a aVar2 = (com.baidu.adp.widget.ImageView.a) c.mM().loadResourceFromMemery(this.eOo, this.mType, new Object[0]);
                if (aVar2 != null) {
                    this.eOc = false;
                    setGif(aVar2);
                } else {
                    startLoading();
                    c.mM().a(this.eOo, this.mType, this.eOr, this.mPageId);
                    return;
                }
            }
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(view);
            }
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.eOk = z;
    }

    public static Bitmap a(GifView gifView) {
        if (eOd != null && !eOd.isRecycled()) {
            return eOd;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
        if (bitmapDrawable != null) {
            eOd = bitmapDrawable.getBitmap();
        }
        return eOd;
    }

    public b getGif() {
        if (this.Uz == null) {
            onStop();
            return null;
        }
        return this.Uz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.eNY != null && !this.eOm) {
            this.eNY.onStop();
            this.eOm = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.eOa = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.eOn = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.eOn;
    }

    public void setType(int i) {
        this.mType = i;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.eOo;
    }

    public void setDefaultNoImageDay(int i) {
        this.eNX = i;
    }

    public void bsU() {
        this.eNX = R.drawable.pic_expression_upload_selector;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.eOs = gVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eOs != null) {
            this.eOs.L(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        if (this.eOn == null) {
            return 0;
        }
        return this.eOn.getWidth();
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        if (this.eOn == null) {
            return 0;
        }
        return this.eOn.getHeight();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float getRadius() {
        return this.afE;
    }
}

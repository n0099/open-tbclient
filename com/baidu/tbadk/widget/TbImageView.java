package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.f;
import com.baidu.adp.base.i;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.adp.newwidget.ImageView.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class TbImageView extends BDImageView implements View.OnClickListener, Runnable {
    private static Method mClearDisplayListMethod;
    private static Method mDestroyLayerMethod;
    private static Method mDestroyLayerWithParamMethod;
    private static Method mResetDisplayListMethod;
    private static HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.a>> sDefaultBdImageCache;
    protected c alY;
    private TbRichTextView.g fIo;
    protected HashMap<String, a> fRA;
    protected HashMap<String, a> fRB;
    protected boolean fRC;
    protected boolean fRD;
    protected boolean fRE;
    protected float fRF;
    protected float fRG;
    protected b fRH;
    private com.baidu.tieba.pb.a.c fRI;
    private RectF fRJ;
    private Path fRK;
    private RectF fRL;
    private com.baidu.tbadk.widget.c fRM;
    protected int fRN;
    private boolean fRO;
    private final com.baidu.tieba.pb.a.c fRP;
    a.InterfaceC0020a fRQ;
    private boolean fRz;
    protected final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fba;
    private CustomMessageListener fmh;
    protected boolean isLongPic;
    private boolean mAutoChangeStyle;
    private int mCurrentDefaultId;
    private float mCurrentDegrees;
    private int mDefaultBgId;
    protected int mDefaultId;
    protected int mHeight;
    private boolean mInterceptOnClick;
    protected boolean mIsGif;
    int mLoadedHeight;
    int mLoadedWidth;
    private final int mLoadingDefaultId;
    private float mLoadingFrameIncrement;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected BdUniqueId mPageId;
    private boolean mShowLoading;
    private int mSkinType;
    protected boolean mSupportNoImage;
    private String mTagStr;
    protected int mType;
    protected String mUrl;
    protected int mWidth;

    /* loaded from: classes.dex */
    public interface b {
        void onCancel();

        void onComplete(String str, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(TbImageView tbImageView, Canvas canvas);

        void b(TbImageView tbImageView, Canvas canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        long startTime;
        int type;
        String url;

        a() {
        }
    }

    public TbImageView(Context context) {
        super(context);
        this.fRz = false;
        this.mType = 10;
        this.mLoadingDefaultId = R.drawable.img_loading;
        this.mDefaultId = R.color.transparent;
        this.mDefaultBgId = R.color.CAM_X0205;
        this.fRC = false;
        this.mIsGif = false;
        this.isLongPic = false;
        this.fRD = false;
        this.fRE = false;
        this.mSupportNoImage = false;
        this.mAutoChangeStyle = true;
        this.mSkinType = 3;
        this.fRJ = new RectF();
        this.fRK = new Path();
        this.fRL = new RectF();
        this.mMatrix = new Matrix();
        this.fRO = false;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.fRP = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbImageView.this.fRI != null) {
                    TbImageView.this.fRI.ad(view);
                    return TbImageView.this.fRI.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.mInterceptOnClick) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.fRI != null) {
                        TbImageView.this.fRI.ad(view);
                        return TbImageView.this.fRI.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.e.d.mx().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.fba, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.fba = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                if (aVar != null) {
                    TbImageView.this.mLoadedWidth = aVar.getWidth();
                    TbImageView.this.mLoadedHeight = aVar.getHeight();
                    String genCacheKey = com.baidu.adp.lib.e.d.mx().genCacheKey(TbImageView.this.mUrl, TbImageView.this.mType);
                    a aVar2 = TbImageView.this.fRB.get(genCacheKey);
                    if (aVar2 != null) {
                        com.baidu.adp.lib.e.a.b(i == 1, i == 2, i == 3);
                        if (i == 3) {
                            com.baidu.adp.lib.e.a.h(true, System.currentTimeMillis() - aVar2.startTime);
                        }
                        TbImageView.this.fRB.remove(genCacheKey);
                    }
                }
                TbImageView.this.stopLoading();
                TbImageView.this.e(aVar);
                if (TbImageView.this.fRH != null) {
                    TbImageView.this.fRH.onComplete(str, aVar != null);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                TbImageView.this.stopLoading();
                if (TbImageView.this.fRH != null) {
                    TbImageView.this.fRH.onCancel();
                }
            }
        };
        this.fRQ = new a.InterfaceC0020a() { // from class: com.baidu.tbadk.widget.TbImageView.3
            @Override // com.baidu.adp.newwidget.ImageView.a.InterfaceC0020a
            public boolean a(Canvas canvas, Drawable drawable) {
                if (TbImageView.this.getBdImage() == null && TbImageView.this.fRO) {
                    TbImageView.this.b(canvas, drawable);
                    return true;
                }
                return false;
            }
        };
        this.fmh = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String genCacheKey = com.baidu.adp.lib.e.d.mx().genCacheKey(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (genCacheKey != null && genCacheKey.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        bJS();
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mDestroyLayerMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodParam(TbImageView.mDestroyLayerWithParamMethod, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mClearDisplayListMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mResetDisplayListMethod, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void bJS() {
                if (TbImageView.mDestroyLayerMethod == null) {
                    Method unused = TbImageView.mDestroyLayerMethod = com.baidu.adp.lib.OrmObject.a.a.findMethod(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.mDestroyLayerWithParamMethod == null) {
                    Method unused2 = TbImageView.mDestroyLayerWithParamMethod = com.baidu.adp.lib.OrmObject.a.a.findMethod(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.mClearDisplayListMethod == null) {
                    Method unused3 = TbImageView.mClearDisplayListMethod = com.baidu.adp.lib.OrmObject.a.a.findMethod(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.mResetDisplayListMethod == null) {
                    Method unused4 = TbImageView.mResetDisplayListMethod = com.baidu.adp.lib.OrmObject.a.a.findMethod(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init();
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fRz = false;
        this.mType = 10;
        this.mLoadingDefaultId = R.drawable.img_loading;
        this.mDefaultId = R.color.transparent;
        this.mDefaultBgId = R.color.CAM_X0205;
        this.fRC = false;
        this.mIsGif = false;
        this.isLongPic = false;
        this.fRD = false;
        this.fRE = false;
        this.mSupportNoImage = false;
        this.mAutoChangeStyle = true;
        this.mSkinType = 3;
        this.fRJ = new RectF();
        this.fRK = new Path();
        this.fRL = new RectF();
        this.mMatrix = new Matrix();
        this.fRO = false;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.fRP = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbImageView.this.fRI != null) {
                    TbImageView.this.fRI.ad(view);
                    return TbImageView.this.fRI.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.mInterceptOnClick) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.fRI != null) {
                        TbImageView.this.fRI.ad(view);
                        return TbImageView.this.fRI.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.e.d.mx().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.fba, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.fba = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (aVar != null) {
                    TbImageView.this.mLoadedWidth = aVar.getWidth();
                    TbImageView.this.mLoadedHeight = aVar.getHeight();
                    String genCacheKey = com.baidu.adp.lib.e.d.mx().genCacheKey(TbImageView.this.mUrl, TbImageView.this.mType);
                    a aVar2 = TbImageView.this.fRB.get(genCacheKey);
                    if (aVar2 != null) {
                        com.baidu.adp.lib.e.a.b(i2 == 1, i2 == 2, i2 == 3);
                        if (i2 == 3) {
                            com.baidu.adp.lib.e.a.h(true, System.currentTimeMillis() - aVar2.startTime);
                        }
                        TbImageView.this.fRB.remove(genCacheKey);
                    }
                }
                TbImageView.this.stopLoading();
                TbImageView.this.e(aVar);
                if (TbImageView.this.fRH != null) {
                    TbImageView.this.fRH.onComplete(str, aVar != null);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                TbImageView.this.stopLoading();
                if (TbImageView.this.fRH != null) {
                    TbImageView.this.fRH.onCancel();
                }
            }
        };
        this.fRQ = new a.InterfaceC0020a() { // from class: com.baidu.tbadk.widget.TbImageView.3
            @Override // com.baidu.adp.newwidget.ImageView.a.InterfaceC0020a
            public boolean a(Canvas canvas, Drawable drawable) {
                if (TbImageView.this.getBdImage() == null && TbImageView.this.fRO) {
                    TbImageView.this.b(canvas, drawable);
                    return true;
                }
                return false;
            }
        };
        this.fmh = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String genCacheKey = com.baidu.adp.lib.e.d.mx().genCacheKey(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (genCacheKey != null && genCacheKey.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        bJS();
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mDestroyLayerMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodParam(TbImageView.mDestroyLayerWithParamMethod, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mClearDisplayListMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mResetDisplayListMethod, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void bJS() {
                if (TbImageView.mDestroyLayerMethod == null) {
                    Method unused = TbImageView.mDestroyLayerMethod = com.baidu.adp.lib.OrmObject.a.a.findMethod(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.mDestroyLayerWithParamMethod == null) {
                    Method unused2 = TbImageView.mDestroyLayerWithParamMethod = com.baidu.adp.lib.OrmObject.a.a.findMethod(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.mClearDisplayListMethod == null) {
                    Method unused3 = TbImageView.mClearDisplayListMethod = com.baidu.adp.lib.OrmObject.a.a.findMethod(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.mResetDisplayListMethod == null) {
                    Method unused4 = TbImageView.mResetDisplayListMethod = com.baidu.adp.lib.OrmObject.a.a.findMethod(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init();
    }

    private void init() {
        this.fRA = new HashMap<>();
        this.fRB = new HashMap<>();
        this.fRM = new com.baidu.tbadk.widget.c(this);
        updateNight();
        this.mLoadingFrameIncrement = 30.0f;
        setConrers(0);
        if (this.Sx != null) {
            this.Sx.a(this.fRQ);
        }
    }

    public void setEvent(b bVar) {
        this.fRH = bVar;
    }

    public void setOnDrawListener(c cVar) {
        this.alY = cVar;
    }

    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.fIo = gVar;
    }

    @Deprecated
    public int getLoadedWidth() {
        return this.mLoadedWidth;
    }

    @Deprecated
    public int getLoadedHeight() {
        return this.mLoadedHeight;
    }

    public void setPlaceHolder(int i) {
        setDefaultResource(ao.getColor(R.color.CAM_X0202));
        switch (i) {
            case 0:
                setDefaultBgResource(ao.qc(R.drawable.transparent_bg));
                return;
            case 1:
                setDefaultBgResource(ao.qc(R.drawable.pic_use_header_28_n));
                return;
            default:
                setDefaultBgResource(ao.qc(R.drawable.pic_use_header_40_n));
                return;
        }
    }

    public void setPlaceHolderAutoChangeSkinType(int i) {
        setDefaultResource(ao.getColor(R.color.CAM_X0202));
        switch (i) {
            case 0:
                setDefaultBgResource(R.drawable.transparent_bg);
                return;
            case 1:
                setDefaultBgResource(R.drawable.pic_use_header_28_n);
                return;
            default:
                setDefaultBgResource(R.drawable.pic_use_header_40_n);
                return;
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.mNeedRecomputeMatrix = true;
                requestLayout();
            }
        } else if (!obj.equals(tag)) {
            this.mNeedRecomputeMatrix = true;
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fIo != null) {
            this.fIo.L(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.mInterceptOnClick) {
            startLoading();
            com.baidu.adp.lib.e.d.mx().a(this.mUrl, this.mType, this.fba, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.mIsGif = aVar.isGif();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.a getBdImage() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (TextUtils.isEmpty(this.mUrl)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                aVar = null;
            } else {
                String str = (String) tag;
                com.baidu.adp.widget.ImageView.a Ee = com.baidu.tbadk.imageManager.c.bGq().Ee(str);
                aVar = Ee == null ? com.baidu.tbadk.imageManager.c.bGq().Ed(str) : Ee;
            }
        } else {
            aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mx().loadResourceFromMemery(this.mUrl, this.mType, new Object[0]);
        }
        if (aVar != null) {
            e(aVar);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a getDefaultBdImage() {
        String str;
        SoftReference<com.baidu.adp.widget.ImageView.a> softReference;
        com.baidu.adp.widget.ImageView.a aVar;
        if (sDefaultBdImageCache == null) {
            sDefaultBdImageCache = new HashMap<>();
        }
        String valueOf = String.valueOf(this.mCurrentDefaultId);
        if (this.mAutoChangeStyle) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = valueOf + "_1";
            } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                str = valueOf + "_2";
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mNeedRecomputeMatrix = true;
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            }
            if (sDefaultBdImageCache.containsKey(str) || (softReference = sDefaultBdImageCache.get(str)) == null || (aVar = softReference.get()) == null || !aVar.isValidNow()) {
                Bitmap bitmap = null;
                if (this.mCurrentDefaultId > 0) {
                    if (this.mAutoChangeStyle) {
                        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                            bitmap = ao.getBitmap(this.mCurrentDefaultId);
                            if (bitmap == null) {
                                bitmap = BitmapHelper.getCashBitmap(this.mCurrentDefaultId);
                            }
                        } else {
                            bitmap = BitmapHelper.getCashBitmap(this.mCurrentDefaultId);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.mCurrentDefaultId);
                    }
                }
                com.baidu.adp.widget.ImageView.a aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, false, String.valueOf(this.mCurrentDefaultId));
                sDefaultBdImageCache.put(str, new SoftReference<>(aVar2));
                return aVar2;
            }
            return aVar;
        }
        str = valueOf;
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
        }
        if (sDefaultBdImageCache.containsKey(str)) {
        }
        Bitmap bitmap2 = null;
        if (this.mCurrentDefaultId > 0) {
        }
        com.baidu.adp.widget.ImageView.a aVar22 = new com.baidu.adp.widget.ImageView.a(bitmap2, false, String.valueOf(this.mCurrentDefaultId));
        sDefaultBdImageCache.put(str, new SoftReference<>(aVar22));
        return aVar22;
    }

    public void startLoad(String str, int i, boolean z) {
        a(str, i, 0, 0, z);
    }

    public void startLoad(String str, int i, boolean z, boolean z2) {
        a(str, i, 0, 0, z, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId = null;
        boolean z2 = false;
        i I = j.I(getContext());
        if (I != null) {
            BdUniqueId uniqueId = this.mPageId != null ? this.mPageId : I.getUniqueId();
            z2 = I.isScroll();
            bdUniqueId = uniqueId;
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        i I = j.I(getContext());
        if (I != null) {
            bdUniqueId = this.mPageId != null ? this.mPageId : I.getUniqueId();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            if (this.mSkinType != 3 && this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                invalidate();
                return;
            }
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            bJN();
            this.mNeedRecomputeMatrix = true;
            this.mIsGif = false;
            requestLayout();
        } else if (getBdImage() != null) {
            invalidate();
            if (this.fRH != null) {
                this.fRH.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mNeedRecomputeMatrix = true;
        if (!TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
            this.mWidth = i2;
            this.mHeight = i3;
        }
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.e.d.mx().ax(this.mType) && this.mSupportNoImage) {
            invalidate();
        } else if (z3 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            invalidate();
            if (this.fRH != null) {
                this.fRH.onComplete(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            String genCacheKey = com.baidu.adp.lib.e.d.mx().genCacheKey(str, i);
            a aVar = new a();
            aVar.url = str;
            aVar.type = i;
            aVar.startTime = System.currentTimeMillis();
            this.fRB.put(genCacheKey, aVar);
            if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                String genCacheKey2 = com.baidu.adp.lib.e.d.mx().genCacheKey(str, i);
                if (!this.fRA.containsKey(genCacheKey2)) {
                    a aVar2 = new a();
                    aVar2.url = str;
                    aVar2.type = i;
                    this.fRA.put(genCacheKey2, aVar2);
                    return;
                }
                return;
            }
            com.baidu.adp.lib.e.d.mx().a(this.mUrl, this.mType, this.fba, i2, i3, this.mPageId, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f<?> K = j.K(getContext());
        if (this.mPageId != null) {
            this.fRz = true;
        }
        if (K != null) {
            this.fmh.setTag(this.mPageId != null ? this.mPageId : K.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.fmh);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
            this.mWidth = getMeasuredWidth();
            this.mHeight = getMeasuredHeight();
            Iterator<Map.Entry<String, a>> it = this.fRA.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, a> next = it.next();
                next.getKey();
                a value = next.getValue();
                it.remove();
                com.baidu.adp.lib.e.d.mx().a(value.url, value.type, this.fba, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.fRz = false;
        stopLoad();
        MessageManager.getInstance().unRegisterListener(this.fmh);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        stopLoad();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            stopLoad();
        } else {
            refresh();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i) {
        super.setDrawerType(i);
        if (this.Sx != null) {
            this.Sx.a(this.fRQ);
        }
    }

    protected void b(Canvas canvas, Drawable drawable) {
        canvas.save();
        this.fRK.reset();
        this.fRJ.right = getWidth();
        this.fRJ.bottom = getHeight();
        this.fRK.addRoundRect(this.fRJ, this.Sw.mRadius, Path.Direction.CW);
        int i = this.fRN ^ 15;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        if ((i & 1) != 0) {
            this.fRK.addRect(0.0f, 0.0f, this.Sw.mRadius[0], this.Sw.mRadius[1], Path.Direction.CW);
        }
        if ((i & 2) != 0) {
            this.fRK.addRect(rectF.right - this.Sw.mRadius[2], 0.0f, rectF.right, this.Sw.mRadius[3], Path.Direction.CW);
        }
        if ((i & 4) != 0) {
            this.fRK.addRect(0.0f, rectF.bottom - this.Sw.mRadius[5], this.Sw.mRadius[4], rectF.bottom, Path.Direction.CW);
        }
        if ((i & 8) != 0) {
            this.fRK.addRect(rectF.right - this.Sw.mRadius[6], rectF.bottom - this.Sw.mRadius[7], rectF.right, rectF.bottom, Path.Direction.CW);
        }
        if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
            canvas.clipPath(this.fRK);
        }
        drawable.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        updateNight();
        notifiyOnDrawListener(true, canvas);
        super.onDraw(canvas);
        S(canvas);
        T(canvas);
        notifiyOnDrawListener(false, canvas);
    }

    private void notifiyOnDrawListener(boolean z, Canvas canvas) {
        if (this.alY != null) {
            if (z) {
                this.alY.a(this, canvas);
            } else {
                this.alY.b(this, canvas);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void drawContentTag(Canvas canvas, ImageView imageView) {
        super.drawContentTag(canvas, imageView);
        if (this.fRM != null && this.Sw != null) {
            if (this.Sw.mIsShowGifIcon && (this.fRC || isGif())) {
                this.fRM.a(canvas, getContext().getString(R.string.icon_tag_gif), true);
            } else if (this.Sw.mIsShowLongIcon && isLongPic()) {
                this.fRM.a(canvas, getContext().getString(R.string.icon_tag_long), true);
            } else if (this.mTagStr != null) {
                this.fRM.a(canvas, this.mTagStr, false);
            }
            if (this.Sw.SC == com.baidu.adp.newwidget.ImageView.b.SA) {
                this.fRM.a(canvas, getContext().getString(R.string.wonderful_comment), R.color.CAM_X0305);
            } else if (this.Sw.SC == com.baidu.adp.newwidget.ImageView.b.Sz) {
                this.fRM.a(canvas, getContext().getString(R.string.god_level_comment), R.color.CAM_X0310);
            }
        }
    }

    public boolean isGif() {
        return this.mIsGif;
    }

    public boolean isLongPic() {
        return this.isLongPic;
    }

    public void setIsLongPic(boolean z) {
        this.isLongPic = z;
    }

    public void setIsGifPic(boolean z) {
        this.fRC = z;
    }

    public void setIsBitmapPic(boolean z) {
        this.fRD = z;
    }

    public boolean isSmartCrop() {
        return this.fRE;
    }

    public void setIsSmartCrop(boolean z) {
        this.fRE = z;
    }

    public float getSmartCropCenterPointWidthRatio() {
        return this.fRF;
    }

    public void setSmartCropCenterPointWidthRatio(float f) {
        this.fRF = f;
    }

    public float getSmartCropCenterPointHeightRatio() {
        return this.fRG;
    }

    public void setSmartCropCenterPointHeightRatio(float f) {
        this.fRG = f;
    }

    public boolean bJL() {
        return this.mShowLoading;
    }

    public void startLoading() {
        this.mShowLoading = true;
        nextLoadingFrame();
    }

    public void stopLoading() {
        this.mShowLoading = false;
        removeCallbacks(this);
        this.mCurrentDegrees = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
        invalidate();
    }

    private void nextLoadingFrame() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    public void run() {
        if (this.mShowLoading) {
            this.mCurrentDegrees += this.mLoadingFrameIncrement;
            if (this.mCurrentDegrees > 360.0f - this.mLoadingFrameIncrement) {
                this.mCurrentDegrees = 0.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.postRotate(this.mCurrentDegrees, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.mMatrix);
            invalidate();
            nextLoadingFrame();
        }
    }

    private void updateNight() {
        boolean z = false;
        if (this.mAutoChangeStyle) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            }
            this.Sw.mIsNight = z;
        } else {
            this.Sw.mIsNight = false;
        }
        int i = this.mShowLoading ? this.mLoadingDefaultId : this.mDefaultId;
        if (i != this.mCurrentDefaultId) {
            this.mCurrentDefaultId = i;
            this.mNeedRecomputeMatrix = true;
        }
        if (this.mDefaultBgId > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(ao.getDrawable(this.mDefaultBgId));
            } else {
                setDefaultBg(getResources().getDrawable(this.mDefaultBgId));
            }
        } else {
            setDefaultBg(null);
        }
        if (this.mAutoChangeStyle) {
            this.fRM.tk(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setDefaultResource(int i) {
        if (this.mDefaultId != i) {
            this.mDefaultId = i;
            invalidate();
        }
    }

    public void setDefaultBgResource(int i) {
        if (this.mDefaultBgId != i) {
            this.mDefaultBgId = i;
            invalidate();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (!this.fRz && this.mPageId != null) {
            this.fmh.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.fmh);
            this.fRz = true;
        }
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void refresh() {
        a(this.mUrl, this.mType, this.mWidth, this.mHeight, false);
        invalidate();
    }

    public void reset() {
        setTag(null);
        this.mUrl = null;
        this.mIsGif = false;
        this.isLongPic = false;
        this.fRC = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnTouchListener(this.fRP);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.fRP);
        this.fRI = cVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.mInterceptOnClick = z;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public int getGifIconWidth() {
        if (this.fRM != null) {
            return (int) this.fRM.getTagWidth(getContext().getString(R.string.icon_tag_gif));
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.fRM != null) {
            return (int) this.fRM.getTagHeight(getContext().getString(R.string.icon_tag_gif));
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawBorder(boolean z) {
        super.setDrawBorder(z);
    }

    public void setTagPaddingDis(int i, int i2) {
        if (this.fRM != null) {
            this.fRM.setTagPaddingDis(i, i2);
        }
    }

    public void setTagTextSize(int i) {
        if (this.fRM != null) {
            this.fRM.setTagTextSize(i);
        }
    }

    public void setTagStr(String str) {
        this.mTagStr = str;
    }

    public void setTagColor(int i) {
        if (this.fRM != null) {
            this.fRM.setTagTextColor(i);
        }
    }

    public void setConrers(int i) {
        this.fRN = i;
    }

    public void tj(int i) {
        this.fRN |= i;
    }

    public void bJM() {
        this.fRN = 0;
    }

    public void setDrawCorner(boolean z) {
        this.fRO = z;
    }

    public boolean getDrawCorner() {
        return this.fRO;
    }

    private void S(Canvas canvas) {
        if (this.fRD || getBdImage() != null) {
            if (this.fRN != 0 || getDrawCorner()) {
                setDrawerType(1);
                int i = this.fRN ^ 15;
                this.fRL.set(0.0f, 0.0f, getWidth(), getHeight());
                if ((i & 1) != 0) {
                    canvas.drawRect(0.0f, 0.0f, this.Sw.mRadius[0], this.Sw.mRadius[1], this.Sx.mPaint);
                }
                if ((i & 2) != 0) {
                    canvas.drawRect(this.fRL.right - this.Sw.mRadius[2], 0.0f, this.fRL.right, this.Sw.mRadius[3], this.Sx.mPaint);
                }
                if ((i & 4) != 0) {
                    canvas.drawRect(0.0f, this.fRL.bottom - this.Sw.mRadius[5], this.Sw.mRadius[4], this.fRL.bottom, this.Sx.mPaint);
                }
                if ((i & 8) != 0) {
                    canvas.drawRect(this.fRL.right - this.Sw.mRadius[6], this.fRL.bottom - this.Sw.mRadius[7], this.fRL.right, this.fRL.bottom, this.Sx.mPaint);
                }
            }
        }
    }

    public float[] getRadius() {
        return this.Sw == null ? m(0.0f) : this.Sw.mRadius;
    }

    private void T(Canvas canvas) {
        if (this.fRD || getBdImage() != null) {
            if (this.fRN != 0 || getDrawBorder()) {
                setDrawerType(1);
                int i = this.fRN ^ 15;
                this.fRL.set(0.0f, 0.0f, getWidth(), getHeight());
                this.Sx.mBorderPaint.setStrokeWidth(this.Sx.mBorderPaint.getStrokeWidth());
                if ((i & 1) != 0) {
                    canvas.drawLine(0.0f, 0.0f, this.Sw.mRadius[0], 0.0f, this.Sx.mBorderPaint);
                    canvas.drawLine(0.0f, 0.0f, 0.0f, this.Sw.mRadius[1], this.Sx.mBorderPaint);
                }
                if ((i & 2) != 0) {
                    canvas.drawLine(this.fRL.right - this.Sw.mRadius[2], 0.0f, this.fRL.right, 0.0f, this.Sx.mBorderPaint);
                    canvas.drawLine(this.fRL.right, 0.0f, this.fRL.right, this.Sw.mRadius[3], this.Sx.mBorderPaint);
                }
                if ((i & 4) != 0) {
                    canvas.drawLine(0.0f, this.fRL.bottom - this.Sw.mRadius[5], 0.0f, this.fRL.bottom, this.Sx.mBorderPaint);
                    canvas.drawLine(0.0f, this.fRL.bottom, this.Sw.mRadius[4], this.fRL.bottom, this.Sx.mBorderPaint);
                }
                if ((i & 8) != 0) {
                    canvas.drawLine(this.fRL.right - this.Sw.mRadius[6], this.fRL.bottom, this.fRL.right, this.fRL.bottom, this.Sx.mBorderPaint);
                    canvas.drawLine(this.fRL.right, this.fRL.bottom, this.fRL.right, this.fRL.bottom - this.Sw.mRadius[7], this.Sx.mBorderPaint);
                }
            }
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.d.mx().a(this.mUrl, this.mType, this.fba);
            this.fRB.remove(com.baidu.adp.lib.e.d.mx().genCacheKey(this.mUrl, this.mType));
            stopLoading();
        }
    }

    public void bJN() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.d.mx().a(this.mUrl, this.mType, this.fba);
            if (TextUtils.isEmpty(this.mUrl) || bJL()) {
                stopLoading();
            }
        }
    }
}

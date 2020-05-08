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
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.adp.newwidget.ImageView.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends BDImageView implements View.OnClickListener, Runnable {
    private static Method mClearDisplayListMethod;
    private static Method mDestroyLayerMethod;
    private static Method mDestroyLayerWithParamMethod;
    private static Method mResetDisplayListMethod;
    private static HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.a>> sDefaultBdImageCache;
    protected c agE;
    protected boolean canLogPerf;
    private CustomMessageListener dHz;
    protected final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dyb;
    private TbRichTextView.g eay;
    protected boolean eiA;
    protected float eiB;
    protected float eiC;
    private com.baidu.tieba.pb.a.c eiD;
    protected h eiE;
    private boolean eiF;
    private Path eiG;
    private RectF eiH;
    private com.baidu.tbadk.widget.c eiI;
    protected int eiJ;
    private boolean eiK;
    private b eiL;
    private final com.baidu.tieba.pb.a.c eiM;
    a.InterfaceC0024a eiN;
    protected a eix;
    protected boolean eiy;
    protected boolean eiz;
    protected boolean isLongPic;
    private boolean isPageIdRegisterMessage;
    private int lastSkinType;
    private boolean mAutoChangeStyle;
    private RectF mClipRect;
    private int mCurrentDefaultBgId;
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
    protected boolean mSupportNoImage;
    private String mTagStr;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    protected long requestTime;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();

        void onComplete(String str, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bbl();
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(TbImageView tbImageView, Canvas canvas);

        void b(TbImageView tbImageView, Canvas canvas);
    }

    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.eay = gVar;
    }

    public void setEvent(a aVar) {
        this.eix = aVar;
    }

    public void setOnDrawListener(c cVar) {
        this.agE = cVar;
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
        setDefaultResource(am.getColor(R.color.cp_bg_line_j));
        switch (i) {
            case 1:
                setDefaultBgResource(am.kB(R.drawable.pic_use_header_28_n));
                return;
            case 2:
                setDefaultBgResource(am.kB(R.drawable.pic_use_header_40_n));
                return;
            case 3:
                setDefaultBgResource(am.kB(R.drawable.pic_use_header_60_n));
                return;
            case 4:
                setDefaultBgResource(am.kB(R.drawable.pic_use_header_big_n));
                return;
            default:
                return;
        }
    }

    public void setLoadImageErrorListener(b bVar) {
        this.eiL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.mIsGif = aVar.isGif();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.ImageView.a aVar) {
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eay != null) {
            this.eay.w(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.eix = null;
        this.mDefaultId = R.color.transparent;
        this.mLoadingDefaultId = R.drawable.img_loading;
        this.mDefaultBgId = R.color.cp_bg_line_e;
        this.eiy = false;
        this.mIsGif = false;
        this.isLongPic = false;
        this.eiz = false;
        this.eiA = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.mSupportNoImage = false;
        this.eiE = null;
        this.eiF = false;
        this.mClipRect = new RectF();
        this.eiG = new Path();
        this.eiH = new RectF();
        this.lastSkinType = 3;
        this.requestTime = 0L;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPageIdRegisterMessage = false;
        this.eiK = false;
        this.eiM = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbImageView.this.eiD != null) {
                    TbImageView.this.eiD.S(view);
                    return TbImageView.this.eiD.onDoubleTap(motionEvent);
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
                    } else if (TbImageView.this.eiD != null) {
                        TbImageView.this.eiD.S(view);
                        return TbImageView.this.eiD.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.e.c.kV().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.dyb, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.dyb = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                if (aVar != null) {
                    TbImageView.this.mLoadedWidth = aVar.getWidth();
                    TbImageView.this.mLoadedHeight = aVar.getHeight();
                }
                TbImageView.this.stopLoading();
                if (aVar == null) {
                    if (TbImageView.this.eiL != null) {
                        TbImageView.this.eiL.bbl();
                    }
                } else {
                    TbImageView.this.e(aVar);
                    TbImageView.this.f(aVar);
                }
                if (TbImageView.this.eix != null) {
                    TbImageView.this.eix.onComplete(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Tq != null) {
                        TbImageView.this.eiE.resourceFromType = aVar.Tq.resourceFromType;
                        TbImageView.this.eiE.isSuccess = aVar.Tq.isScuess;
                        TbImageView.this.eiE.costTime = aVar.Tq.costTime;
                    }
                } else {
                    TbImageView.this.eiE.resourceFromType = "net";
                    TbImageView.this.eiE.isSuccess = false;
                    TbImageView.this.eiE.costTime = System.currentTimeMillis() - TbImageView.this.requestTime;
                }
                TbImageView.this.startLogPerf();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                TbImageView.this.stopLoading();
                if (TbImageView.this.eix != null) {
                    TbImageView.this.eix.onCancel();
                }
            }
        };
        this.eiN = new a.InterfaceC0024a() { // from class: com.baidu.tbadk.widget.TbImageView.3
            @Override // com.baidu.adp.newwidget.ImageView.a.InterfaceC0024a
            public boolean a(Canvas canvas, Drawable drawable) {
                if (TbImageView.this.getBdImage() == null && TbImageView.this.eiK) {
                    TbImageView.this.c(canvas, drawable);
                    return true;
                }
                return false;
            }
        };
        this.dHz = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String genCacheKey = com.baidu.adp.lib.e.c.kV().genCacheKey(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (genCacheKey != null && genCacheKey.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        bbk();
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mDestroyLayerMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodParam(TbImageView.mDestroyLayerWithParamMethod, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mClearDisplayListMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mResetDisplayListMethod, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void bbk() {
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
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eix = null;
        this.mDefaultId = R.color.transparent;
        this.mLoadingDefaultId = R.drawable.img_loading;
        this.mDefaultBgId = R.color.cp_bg_line_e;
        this.eiy = false;
        this.mIsGif = false;
        this.isLongPic = false;
        this.eiz = false;
        this.eiA = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.mSupportNoImage = false;
        this.eiE = null;
        this.eiF = false;
        this.mClipRect = new RectF();
        this.eiG = new Path();
        this.eiH = new RectF();
        this.lastSkinType = 3;
        this.requestTime = 0L;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPageIdRegisterMessage = false;
        this.eiK = false;
        this.eiM = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbImageView.this.eiD != null) {
                    TbImageView.this.eiD.S(view);
                    return TbImageView.this.eiD.onDoubleTap(motionEvent);
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
                    } else if (TbImageView.this.eiD != null) {
                        TbImageView.this.eiD.S(view);
                        return TbImageView.this.eiD.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.e.c.kV().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.dyb, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.dyb = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (aVar != null) {
                    TbImageView.this.mLoadedWidth = aVar.getWidth();
                    TbImageView.this.mLoadedHeight = aVar.getHeight();
                }
                TbImageView.this.stopLoading();
                if (aVar == null) {
                    if (TbImageView.this.eiL != null) {
                        TbImageView.this.eiL.bbl();
                    }
                } else {
                    TbImageView.this.e(aVar);
                    TbImageView.this.f(aVar);
                }
                if (TbImageView.this.eix != null) {
                    TbImageView.this.eix.onComplete(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Tq != null) {
                        TbImageView.this.eiE.resourceFromType = aVar.Tq.resourceFromType;
                        TbImageView.this.eiE.isSuccess = aVar.Tq.isScuess;
                        TbImageView.this.eiE.costTime = aVar.Tq.costTime;
                    }
                } else {
                    TbImageView.this.eiE.resourceFromType = "net";
                    TbImageView.this.eiE.isSuccess = false;
                    TbImageView.this.eiE.costTime = System.currentTimeMillis() - TbImageView.this.requestTime;
                }
                TbImageView.this.startLogPerf();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                TbImageView.this.stopLoading();
                if (TbImageView.this.eix != null) {
                    TbImageView.this.eix.onCancel();
                }
            }
        };
        this.eiN = new a.InterfaceC0024a() { // from class: com.baidu.tbadk.widget.TbImageView.3
            @Override // com.baidu.adp.newwidget.ImageView.a.InterfaceC0024a
            public boolean a(Canvas canvas, Drawable drawable) {
                if (TbImageView.this.getBdImage() == null && TbImageView.this.eiK) {
                    TbImageView.this.c(canvas, drawable);
                    return true;
                }
                return false;
            }
        };
        this.dHz = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String genCacheKey = com.baidu.adp.lib.e.c.kV().genCacheKey(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (genCacheKey != null && genCacheKey.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        bbk();
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mDestroyLayerMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodParam(TbImageView.mDestroyLayerWithParamMethod, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mClearDisplayListMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mResetDisplayListMethod, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void bbk() {
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
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.eiI = new com.baidu.tbadk.widget.c(this);
        updateNight();
        this.mLoadingFrameIncrement = 30.0f;
        this.eiE = new h();
        setConrers(0);
        if (this.Px != null) {
            this.Px.a(this.eiN);
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

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.a getBdImage() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (TextUtils.isEmpty(this.mUrl)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                aVar = null;
            } else {
                String str = (String) tag;
                com.baidu.adp.widget.ImageView.a wP = com.baidu.tbadk.imageManager.c.aYk().wP(str);
                aVar = wP == null ? com.baidu.tbadk.imageManager.c.aYk().wO(str) : wP;
            }
        } else {
            aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.kV().loadResourceFromMemery(this.mUrl, this.mType, new Object[0]);
        }
        if (aVar != null) {
            e(aVar);
            f(aVar);
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
            if (this.lastSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mNeedRecomputeMatrix = true;
                this.lastSkinType = TbadkCoreApplication.getInst().getSkinType();
            }
            if (sDefaultBdImageCache.containsKey(str) || (softReference = sDefaultBdImageCache.get(str)) == null || (aVar = softReference.get()) == null || !aVar.isValidNow()) {
                Bitmap bitmap = null;
                if (this.mCurrentDefaultId > 0) {
                    if (this.mAutoChangeStyle) {
                        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                            bitmap = am.getBitmap(this.mCurrentDefaultId);
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
        if (this.lastSkinType != TbadkCoreApplication.getInst().getSkinType()) {
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
        com.baidu.adp.base.h E = i.E(getContext());
        if (E != null) {
            BdUniqueId uniqueId = this.mPageId != null ? this.mPageId : E.getUniqueId();
            z2 = E.isScroll();
            bdUniqueId = uniqueId;
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        com.baidu.adp.base.h E = i.E(getContext());
        if (E != null) {
            bdUniqueId = this.mPageId != null ? this.mPageId : E.getUniqueId();
        }
        a(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void a(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            if (this.lastSkinType != 3 && this.lastSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                invalidate();
                return;
            }
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            bbd();
            this.mNeedRecomputeMatrix = true;
            this.mIsGif = false;
            requestLayout();
        } else if (getBdImage() != null) {
            this.eiE.resourceFromType = "memory";
            this.eiE.isSuccess = true;
            this.eiE.costTime = 0L;
            invalidate();
            if (this.eix != null) {
                this.eix.onComplete(str, true);
                return;
            }
            return;
        }
        this.mUrl = str;
        this.mType = i;
        this.mPageId = bdUniqueId;
        this.mWidth = i2;
        this.mHeight = i3;
        this.mNeedRecomputeMatrix = true;
        if (z2) {
            invalidate();
        } else if (!com.baidu.adp.lib.e.c.kV().af(this.mType) && this.mSupportNoImage) {
            invalidate();
        } else if (z3 && !j.isNetWorkAvailable()) {
            this.eiE.resourceFromType = "memory";
            this.eiE.isSuccess = false;
            this.eiE.costTime = 0L;
            invalidate();
            if (this.eix != null) {
                this.eix.onComplete(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.requestTime = System.currentTimeMillis();
            com.baidu.adp.lib.e.c.kV().a(this.mUrl, this.mType, this.dyb, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.c.kV().a(this.mUrl, this.mType, this.dyb);
            stopLoading();
        }
    }

    public void bbd() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.c.kV().a(this.mUrl, this.mType, this.dyb);
            if (TextUtils.isEmpty(this.mUrl) || bbe()) {
                stopLoading();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e<?> G = i.G(getContext());
        if (this.mPageId != null) {
            this.isPageIdRegisterMessage = true;
        }
        if (G != null) {
            this.dHz.setTag(this.mPageId != null ? this.mPageId : G.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.dHz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isPageIdRegisterMessage = false;
        stopLoad();
        MessageManager.getInstance().unRegisterListener(this.dHz);
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
        if (this.Px != null) {
            this.Px.a(this.eiN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Canvas canvas, Drawable drawable) {
        canvas.save();
        this.eiG.reset();
        this.mClipRect.right = getWidth();
        this.mClipRect.bottom = getHeight();
        this.eiG.addRoundRect(this.mClipRect, this.Pw.mRadius, this.Pw.mRadius, Path.Direction.CW);
        int i = this.eiJ ^ 15;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        if ((i & 1) != 0) {
            this.eiG.addRect(0.0f, 0.0f, this.Pw.mRadius, this.Pw.mRadius, Path.Direction.CW);
        }
        if ((i & 2) != 0) {
            this.eiG.addRect(rectF.right - this.Pw.mRadius, 0.0f, rectF.right, this.Pw.mRadius, Path.Direction.CW);
        }
        if ((i & 4) != 0) {
            this.eiG.addRect(0.0f, rectF.bottom - this.Pw.mRadius, this.Pw.mRadius, rectF.bottom, Path.Direction.CW);
        }
        if ((i & 8) != 0) {
            this.eiG.addRect(rectF.right - this.Pw.mRadius, rectF.bottom - this.Pw.mRadius, rectF.right, rectF.bottom, Path.Direction.CW);
        }
        if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
            canvas.clipPath(this.eiG);
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
        C(canvas);
        D(canvas);
        notifiyOnDrawListener(false, canvas);
    }

    private void notifiyOnDrawListener(boolean z, Canvas canvas) {
        if (this.agE != null) {
            if (z) {
                this.agE.a(this, canvas);
            } else {
                this.agE.b(this, canvas);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void drawContentTag(Canvas canvas, ImageView imageView) {
        super.drawContentTag(canvas, imageView);
        if (this.eiI != null && this.Pw != null) {
            if (this.Pw.mIsShowGifIcon && (this.eiy || isGif())) {
                this.eiI.drawBottomRightTag(canvas, getContext().getString(R.string.icon_tag_gif));
            } else if (this.Pw.mIsShowLongIcon && isLongPic()) {
                this.eiI.drawBottomRightTag(canvas, getContext().getString(R.string.icon_tag_long));
            } else if (this.mTagStr != null) {
                this.eiI.drawBottomRightTag(canvas, this.mTagStr);
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
        this.eiy = z;
    }

    public void setIsBitmapPic(boolean z) {
        this.eiz = z;
    }

    public boolean isSmartCrop() {
        return this.eiA;
    }

    public void setIsSmartCrop(boolean z) {
        this.eiA = z;
    }

    public float getSmartCropCenterPointWidthRatio() {
        return this.eiB;
    }

    public void setSmartCropCenterPointWidthRatio(float f) {
        this.eiB = f;
    }

    public float getSmartCropCenterPointHeightRatio() {
        return this.eiC;
    }

    public void setSmartCropCenterPointHeightRatio(float f) {
        this.eiC = f;
    }

    public boolean bbe() {
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
            this.Pw.mIsNight = z;
        } else {
            this.Pw.mIsNight = false;
        }
        int i = this.mCurrentDefaultId;
        int i2 = this.mShowLoading ? R.drawable.img_loading : this.mDefaultId;
        if (i2 != this.mCurrentDefaultId) {
            this.mCurrentDefaultId = i2;
            this.mNeedRecomputeMatrix = true;
        }
        this.mCurrentDefaultBgId = this.mDefaultBgId;
        if (this.mCurrentDefaultBgId > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(am.getDrawable(this.mCurrentDefaultBgId));
                return;
            } else {
                setDefaultBg(getResources().getDrawable(this.mCurrentDefaultBgId));
                return;
            }
        }
        setDefaultBg(null);
    }

    public void setDefaultResource(int i) {
        if (this.mDefaultId != i) {
            this.mDefaultId = i;
            invalidate();
        }
    }

    public int getDefaultBgResource() {
        return this.mDefaultBgId;
    }

    @Deprecated
    public void setDefaultErrorResource(int i) {
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
        if (!this.isPageIdRegisterMessage && this.mPageId != null) {
            this.dHz.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.dHz);
            this.isPageIdRegisterMessage = true;
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
        this.eiy = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnTouchListener(this.eiM);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.eiM);
        this.eiD = cVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.mInterceptOnClick = z;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.mInterceptOnClick) {
            startLoading();
            com.baidu.adp.lib.e.c.kV().a(this.mUrl, this.mType, this.dyb, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.eiI != null) {
            return (int) this.eiI.getTagWidth(getContext().getString(R.string.icon_tag_gif));
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.eiI != null) {
            return (int) this.eiI.getTagHeight(getContext().getString(R.string.icon_tag_gif));
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public h getPerfLog() {
        return this.eiE;
    }

    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.eiE != null && this.eiE.edI) {
            this.eiE.aZu();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawBorder(boolean z) {
        super.setDrawBorder(z);
    }

    public void setTagPaddingDis(int i, int i2) {
        if (this.eiI != null) {
            this.eiI.setTagPaddingDis(i, i2);
        }
    }

    public void setTagTextSize(int i) {
        if (this.eiI != null) {
            this.eiI.setTagTextSize(i);
        }
    }

    public void setTagStr(String str) {
        this.mTagStr = str;
    }

    public void setTagColor(int i) {
        if (this.eiI != null) {
            this.eiI.setTagTextColor(i);
        }
    }

    public void setConrers(int i) {
        this.eiJ = i;
    }

    public void ni(int i) {
        this.eiJ |= i;
    }

    public void bbf() {
        this.eiJ = 0;
    }

    public void setDrawCorner(boolean z) {
        this.eiK = z;
    }

    public boolean getDrawCorner() {
        return this.eiK;
    }

    private void C(Canvas canvas) {
        if (this.eiz || getBdImage() != null) {
            if (this.eiJ != 0 || getDrawCorner()) {
                setDrawerType(1);
                int i = this.eiJ ^ 15;
                this.eiH.set(0.0f, 0.0f, getWidth(), getHeight());
                if ((i & 1) != 0) {
                    canvas.drawRect(0.0f, 0.0f, this.Pw.mRadius, this.Pw.mRadius, this.Px.mPaint);
                }
                if ((i & 2) != 0) {
                    canvas.drawRect(this.eiH.right - this.Pw.mRadius, 0.0f, this.eiH.right, this.Pw.mRadius, this.Px.mPaint);
                }
                if ((i & 4) != 0) {
                    canvas.drawRect(0.0f, this.eiH.bottom - this.Pw.mRadius, this.Pw.mRadius, this.eiH.bottom, this.Px.mPaint);
                }
                if ((i & 8) != 0) {
                    canvas.drawRect(this.eiH.right - this.Pw.mRadius, this.eiH.bottom - this.Pw.mRadius, this.eiH.right, this.eiH.bottom, this.Px.mPaint);
                }
            }
        }
    }

    public float getRadius() {
        if (this.Pw == null) {
            return 0.0f;
        }
        return this.Pw.mRadius;
    }

    private void D(Canvas canvas) {
        if (this.eiz || getBdImage() != null) {
            if (this.eiJ != 0 || getDrawBorder()) {
                setDrawerType(1);
                int i = this.eiJ ^ 15;
                this.eiH.set(0.0f, 0.0f, getWidth(), getHeight());
                this.Px.mBorderPaint.setStrokeWidth(this.Px.mBorderPaint.getStrokeWidth());
                if ((i & 1) != 0) {
                    canvas.drawLine(0.0f, 0.0f, this.Pw.mRadius, 0.0f, this.Px.mBorderPaint);
                    canvas.drawLine(0.0f, 0.0f, 0.0f, this.Pw.mRadius, this.Px.mBorderPaint);
                }
                if ((i & 2) != 0) {
                    canvas.drawLine(this.eiH.right - this.Pw.mRadius, 0.0f, this.eiH.right, 0.0f, this.Px.mBorderPaint);
                    canvas.drawLine(this.eiH.right, 0.0f, this.eiH.right, this.eiH.right + this.Pw.mRadius, this.Px.mBorderPaint);
                }
                if ((i & 4) != 0) {
                    canvas.drawLine(0.0f, this.eiH.bottom - this.Pw.mRadius, 0.0f, this.eiH.bottom, this.Px.mBorderPaint);
                    canvas.drawLine(0.0f, this.eiH.bottom, this.Pw.mRadius, this.eiH.bottom, this.Px.mBorderPaint);
                }
                if ((i & 8) != 0) {
                    canvas.drawLine(this.eiH.right - this.Pw.mRadius, this.eiH.bottom, this.eiH.right, this.eiH.bottom, this.Px.mBorderPaint);
                    canvas.drawLine(this.eiH.right, this.eiH.bottom, this.eiH.right, this.eiH.bottom - this.Pw.mRadius, this.Px.mBorderPaint);
                }
            }
        }
    }
}

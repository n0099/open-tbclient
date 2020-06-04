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
    protected c ahi;
    protected boolean canLogPerf;
    protected final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dLn;
    private CustomMessageListener dVL;
    private TbRichTextView.g eoK;
    protected a exa;
    protected boolean exb;
    protected boolean exc;
    protected boolean exd;
    protected float exe;
    protected float exf;
    private com.baidu.tieba.pb.a.c exg;
    protected h exh;
    private boolean exi;
    private Path exj;
    private RectF exk;
    private com.baidu.tbadk.widget.c exl;
    protected int exm;
    private boolean exn;
    private b exo;
    private final com.baidu.tieba.pb.a.c exp;
    a.InterfaceC0026a exq;
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
        void bhy();
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(TbImageView tbImageView, Canvas canvas);

        void b(TbImageView tbImageView, Canvas canvas);
    }

    public void setDispatchTouchListener(TbRichTextView.g gVar) {
        this.eoK = gVar;
    }

    public void setEvent(a aVar) {
        this.exa = aVar;
    }

    public void setOnDrawListener(c cVar) {
        this.ahi = cVar;
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
                setDefaultBgResource(am.ld(R.drawable.pic_use_header_28_n));
                return;
            case 2:
                setDefaultBgResource(am.ld(R.drawable.pic_use_header_40_n));
                return;
            case 3:
                setDefaultBgResource(am.ld(R.drawable.pic_use_header_60_n));
                return;
            case 4:
                setDefaultBgResource(am.ld(R.drawable.pic_use_header_big_n));
                return;
            default:
                return;
        }
    }

    public void setPlaceHolderAutoChangeSkinType(int i) {
        setDefaultResource(R.color.cp_bg_line_j);
        switch (i) {
            case 1:
                setDefaultBgResource(R.drawable.pic_use_header_28_n);
                return;
            case 2:
                setDefaultBgResource(R.drawable.pic_use_header_40_n);
                return;
            case 3:
                setDefaultBgResource(R.drawable.pic_use_header_60_n);
                return;
            case 4:
                setDefaultBgResource(R.drawable.pic_use_header_big_n);
                return;
            default:
                return;
        }
    }

    public void setLoadImageErrorListener(b bVar) {
        this.exo = bVar;
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
        if (this.eoK != null) {
            this.eoK.w(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.exa = null;
        this.mDefaultId = R.color.transparent;
        this.mLoadingDefaultId = R.drawable.img_loading;
        this.mDefaultBgId = R.color.cp_bg_line_e;
        this.exb = false;
        this.mIsGif = false;
        this.isLongPic = false;
        this.exc = false;
        this.exd = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.mSupportNoImage = false;
        this.exh = null;
        this.exi = false;
        this.mClipRect = new RectF();
        this.exj = new Path();
        this.exk = new RectF();
        this.lastSkinType = 3;
        this.requestTime = 0L;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPageIdRegisterMessage = false;
        this.exn = false;
        this.exp = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbImageView.this.exg != null) {
                    TbImageView.this.exg.R(view);
                    return TbImageView.this.exg.onDoubleTap(motionEvent);
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
                    } else if (TbImageView.this.exg != null) {
                        TbImageView.this.exg.R(view);
                        return TbImageView.this.exg.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.e.c.kX().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.dLn, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.dLn = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
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
                    if (TbImageView.this.exo != null) {
                        TbImageView.this.exo.bhy();
                    }
                } else {
                    TbImageView.this.e(aVar);
                    TbImageView.this.f(aVar);
                }
                if (TbImageView.this.exa != null) {
                    TbImageView.this.exa.onComplete(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.TA != null) {
                        TbImageView.this.exh.resourceFromType = aVar.TA.resourceFromType;
                        TbImageView.this.exh.isSuccess = aVar.TA.isScuess;
                        TbImageView.this.exh.costTime = aVar.TA.costTime;
                    }
                } else {
                    TbImageView.this.exh.resourceFromType = "net";
                    TbImageView.this.exh.isSuccess = false;
                    TbImageView.this.exh.costTime = System.currentTimeMillis() - TbImageView.this.requestTime;
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
                if (TbImageView.this.exa != null) {
                    TbImageView.this.exa.onCancel();
                }
            }
        };
        this.exq = new a.InterfaceC0026a() { // from class: com.baidu.tbadk.widget.TbImageView.3
            @Override // com.baidu.adp.newwidget.ImageView.a.InterfaceC0026a
            public boolean a(Canvas canvas, Drawable drawable) {
                if (TbImageView.this.getBdImage() == null && TbImageView.this.exn) {
                    TbImageView.this.c(canvas, drawable);
                    return true;
                }
                return false;
            }
        };
        this.dVL = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String genCacheKey = com.baidu.adp.lib.e.c.kX().genCacheKey(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (genCacheKey != null && genCacheKey.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        bhx();
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mDestroyLayerMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodParam(TbImageView.mDestroyLayerWithParamMethod, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mClearDisplayListMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mResetDisplayListMethod, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void bhx() {
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
        this.exa = null;
        this.mDefaultId = R.color.transparent;
        this.mLoadingDefaultId = R.drawable.img_loading;
        this.mDefaultBgId = R.color.cp_bg_line_e;
        this.exb = false;
        this.mIsGif = false;
        this.isLongPic = false;
        this.exc = false;
        this.exd = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.mSupportNoImage = false;
        this.exh = null;
        this.exi = false;
        this.mClipRect = new RectF();
        this.exj = new Path();
        this.exk = new RectF();
        this.lastSkinType = 3;
        this.requestTime = 0L;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPageIdRegisterMessage = false;
        this.exn = false;
        this.exp = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbImageView.this.exg != null) {
                    TbImageView.this.exg.R(view);
                    return TbImageView.this.exg.onDoubleTap(motionEvent);
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
                    } else if (TbImageView.this.exg != null) {
                        TbImageView.this.exg.R(view);
                        return TbImageView.this.exg.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.e.c.kX().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.dLn, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.dLn = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
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
                    if (TbImageView.this.exo != null) {
                        TbImageView.this.exo.bhy();
                    }
                } else {
                    TbImageView.this.e(aVar);
                    TbImageView.this.f(aVar);
                }
                if (TbImageView.this.exa != null) {
                    TbImageView.this.exa.onComplete(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.TA != null) {
                        TbImageView.this.exh.resourceFromType = aVar.TA.resourceFromType;
                        TbImageView.this.exh.isSuccess = aVar.TA.isScuess;
                        TbImageView.this.exh.costTime = aVar.TA.costTime;
                    }
                } else {
                    TbImageView.this.exh.resourceFromType = "net";
                    TbImageView.this.exh.isSuccess = false;
                    TbImageView.this.exh.costTime = System.currentTimeMillis() - TbImageView.this.requestTime;
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
                if (TbImageView.this.exa != null) {
                    TbImageView.this.exa.onCancel();
                }
            }
        };
        this.exq = new a.InterfaceC0026a() { // from class: com.baidu.tbadk.widget.TbImageView.3
            @Override // com.baidu.adp.newwidget.ImageView.a.InterfaceC0026a
            public boolean a(Canvas canvas, Drawable drawable) {
                if (TbImageView.this.getBdImage() == null && TbImageView.this.exn) {
                    TbImageView.this.c(canvas, drawable);
                    return true;
                }
                return false;
            }
        };
        this.dVL = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String genCacheKey = com.baidu.adp.lib.e.c.kX().genCacheKey(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (genCacheKey != null && genCacheKey.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        bhx();
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mDestroyLayerMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodParam(TbImageView.mDestroyLayerWithParamMethod, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mClearDisplayListMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.invokeMethodNoParam(TbImageView.mResetDisplayListMethod, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void bhx() {
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
        this.exl = new com.baidu.tbadk.widget.c(this);
        updateNight();
        this.mLoadingFrameIncrement = 30.0f;
        this.exh = new h();
        setConrers(0);
        if (this.PG != null) {
            this.PG.a(this.exq);
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
                com.baidu.adp.widget.ImageView.a yv = com.baidu.tbadk.imageManager.c.beu().yv(str);
                aVar = yv == null ? com.baidu.tbadk.imageManager.c.beu().yu(str) : yv;
            }
        } else {
            aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.kX().loadResourceFromMemery(this.mUrl, this.mType, new Object[0]);
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
            bhq();
            this.mNeedRecomputeMatrix = true;
            this.mIsGif = false;
            requestLayout();
        } else if (getBdImage() != null) {
            this.exh.resourceFromType = "memory";
            this.exh.isSuccess = true;
            this.exh.costTime = 0L;
            invalidate();
            if (this.exa != null) {
                this.exa.onComplete(str, true);
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
        } else if (!com.baidu.adp.lib.e.c.kX().ag(this.mType) && this.mSupportNoImage) {
            invalidate();
        } else if (z3 && !j.isNetWorkAvailable()) {
            this.exh.resourceFromType = "memory";
            this.exh.isSuccess = false;
            this.exh.costTime = 0L;
            invalidate();
            if (this.exa != null) {
                this.exa.onComplete(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.requestTime = System.currentTimeMillis();
            com.baidu.adp.lib.e.c.kX().a(this.mUrl, this.mType, this.dLn, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.c.kX().a(this.mUrl, this.mType, this.dLn);
            stopLoading();
        }
    }

    public void bhq() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.c.kX().a(this.mUrl, this.mType, this.dLn);
            if (TextUtils.isEmpty(this.mUrl) || bhr()) {
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
            this.dVL.setTag(this.mPageId != null ? this.mPageId : G.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.dVL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isPageIdRegisterMessage = false;
        stopLoad();
        MessageManager.getInstance().unRegisterListener(this.dVL);
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
        if (this.PG != null) {
            this.PG.a(this.exq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Canvas canvas, Drawable drawable) {
        canvas.save();
        this.exj.reset();
        this.mClipRect.right = getWidth();
        this.mClipRect.bottom = getHeight();
        this.exj.addRoundRect(this.mClipRect, this.PF.mRadius, this.PF.mRadius, Path.Direction.CW);
        int i = this.exm ^ 15;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        if ((i & 1) != 0) {
            this.exj.addRect(0.0f, 0.0f, this.PF.mRadius, this.PF.mRadius, Path.Direction.CW);
        }
        if ((i & 2) != 0) {
            this.exj.addRect(rectF.right - this.PF.mRadius, 0.0f, rectF.right, this.PF.mRadius, Path.Direction.CW);
        }
        if ((i & 4) != 0) {
            this.exj.addRect(0.0f, rectF.bottom - this.PF.mRadius, this.PF.mRadius, rectF.bottom, Path.Direction.CW);
        }
        if ((i & 8) != 0) {
            this.exj.addRect(rectF.right - this.PF.mRadius, rectF.bottom - this.PF.mRadius, rectF.right, rectF.bottom, Path.Direction.CW);
        }
        if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
            canvas.clipPath(this.exj);
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
        D(canvas);
        E(canvas);
        notifiyOnDrawListener(false, canvas);
    }

    private void notifiyOnDrawListener(boolean z, Canvas canvas) {
        if (this.ahi != null) {
            if (z) {
                this.ahi.a(this, canvas);
            } else {
                this.ahi.b(this, canvas);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void drawContentTag(Canvas canvas, ImageView imageView) {
        super.drawContentTag(canvas, imageView);
        if (this.exl != null && this.PF != null) {
            if (this.PF.mIsShowGifIcon && (this.exb || isGif())) {
                this.exl.drawBottomRightTag(canvas, getContext().getString(R.string.icon_tag_gif));
            } else if (this.PF.mIsShowLongIcon && isLongPic()) {
                this.exl.drawBottomRightTag(canvas, getContext().getString(R.string.icon_tag_long));
            } else if (this.mTagStr != null) {
                this.exl.drawBottomRightTag(canvas, this.mTagStr);
            }
            if (this.PF.PN == com.baidu.adp.newwidget.ImageView.b.PJ) {
                this.exl.a(canvas, getContext().getString(R.string.wonderful_comment), R.color.cp_link_tip_d);
            } else if (this.PF.PN == com.baidu.adp.newwidget.ImageView.b.PI) {
                this.exl.a(canvas, getContext().getString(R.string.god_level_comment), R.color.cp_other_d);
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
        this.exb = z;
    }

    public void setIsBitmapPic(boolean z) {
        this.exc = z;
    }

    public boolean isSmartCrop() {
        return this.exd;
    }

    public void setIsSmartCrop(boolean z) {
        this.exd = z;
    }

    public float getSmartCropCenterPointWidthRatio() {
        return this.exe;
    }

    public void setSmartCropCenterPointWidthRatio(float f) {
        this.exe = f;
    }

    public float getSmartCropCenterPointHeightRatio() {
        return this.exf;
    }

    public void setSmartCropCenterPointHeightRatio(float f) {
        this.exf = f;
    }

    public boolean bhr() {
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
            this.PF.mIsNight = z;
        } else {
            this.PF.mIsNight = false;
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
            } else {
                setDefaultBg(getResources().getDrawable(this.mCurrentDefaultBgId));
            }
        } else {
            setDefaultBg(null);
        }
        if (this.mAutoChangeStyle) {
            this.exl.nN(TbadkCoreApplication.getInst().getSkinType());
        }
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
            this.dVL.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.dVL);
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
        this.exb = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnTouchListener(this.exp);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.exp);
        this.exg = cVar;
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
            com.baidu.adp.lib.e.c.kX().a(this.mUrl, this.mType, this.dLn, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.exl != null) {
            return (int) this.exl.getTagWidth(getContext().getString(R.string.icon_tag_gif));
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.exl != null) {
            return (int) this.exl.getTagHeight(getContext().getString(R.string.icon_tag_gif));
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public h getPerfLog() {
        return this.exh;
    }

    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.exh != null && this.exh.erV) {
            this.exh.bfF();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawBorder(boolean z) {
        super.setDrawBorder(z);
    }

    public void setTagPaddingDis(int i, int i2) {
        if (this.exl != null) {
            this.exl.setTagPaddingDis(i, i2);
        }
    }

    public void setTagTextSize(int i) {
        if (this.exl != null) {
            this.exl.setTagTextSize(i);
        }
    }

    public void setTagStr(String str) {
        this.mTagStr = str;
    }

    public void setTagColor(int i) {
        if (this.exl != null) {
            this.exl.setTagTextColor(i);
        }
    }

    public void setConrers(int i) {
        this.exm = i;
    }

    public void nM(int i) {
        this.exm |= i;
    }

    public void bhs() {
        this.exm = 0;
    }

    public void setDrawCorner(boolean z) {
        this.exn = z;
    }

    public boolean getDrawCorner() {
        return this.exn;
    }

    private void D(Canvas canvas) {
        if (this.exc || getBdImage() != null) {
            if (this.exm != 0 || getDrawCorner()) {
                setDrawerType(1);
                int i = this.exm ^ 15;
                this.exk.set(0.0f, 0.0f, getWidth(), getHeight());
                if ((i & 1) != 0) {
                    canvas.drawRect(0.0f, 0.0f, this.PF.mRadius, this.PF.mRadius, this.PG.mPaint);
                }
                if ((i & 2) != 0) {
                    canvas.drawRect(this.exk.right - this.PF.mRadius, 0.0f, this.exk.right, this.PF.mRadius, this.PG.mPaint);
                }
                if ((i & 4) != 0) {
                    canvas.drawRect(0.0f, this.exk.bottom - this.PF.mRadius, this.PF.mRadius, this.exk.bottom, this.PG.mPaint);
                }
                if ((i & 8) != 0) {
                    canvas.drawRect(this.exk.right - this.PF.mRadius, this.exk.bottom - this.PF.mRadius, this.exk.right, this.exk.bottom, this.PG.mPaint);
                }
            }
        }
    }

    public float getRadius() {
        if (this.PF == null) {
            return 0.0f;
        }
        return this.PF.mRadius;
    }

    private void E(Canvas canvas) {
        if (this.exc || getBdImage() != null) {
            if (this.exm != 0 || getDrawBorder()) {
                setDrawerType(1);
                int i = this.exm ^ 15;
                this.exk.set(0.0f, 0.0f, getWidth(), getHeight());
                this.PG.mBorderPaint.setStrokeWidth(this.PG.mBorderPaint.getStrokeWidth());
                if ((i & 1) != 0) {
                    canvas.drawLine(0.0f, 0.0f, this.PF.mRadius, 0.0f, this.PG.mBorderPaint);
                    canvas.drawLine(0.0f, 0.0f, 0.0f, this.PF.mRadius, this.PG.mBorderPaint);
                }
                if ((i & 2) != 0) {
                    canvas.drawLine(this.exk.right - this.PF.mRadius, 0.0f, this.exk.right, 0.0f, this.PG.mBorderPaint);
                    canvas.drawLine(this.exk.right, 0.0f, this.exk.right, this.exk.right + this.PF.mRadius, this.PG.mBorderPaint);
                }
                if ((i & 4) != 0) {
                    canvas.drawLine(0.0f, this.exk.bottom - this.PF.mRadius, 0.0f, this.exk.bottom, this.PG.mBorderPaint);
                    canvas.drawLine(0.0f, this.exk.bottom, this.PF.mRadius, this.exk.bottom, this.PG.mBorderPaint);
                }
                if ((i & 8) != 0) {
                    canvas.drawLine(this.exk.right - this.PF.mRadius, this.exk.bottom, this.exk.right, this.exk.bottom, this.PG.mBorderPaint);
                    canvas.drawLine(this.exk.right, this.exk.bottom, this.exk.right, this.exk.bottom - this.PF.mRadius, this.PG.mBorderPaint);
                }
            }
        }
    }
}

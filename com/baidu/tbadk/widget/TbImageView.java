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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.o.h;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends BDImageView implements View.OnClickListener, Runnable {
    public static final int CORNER_ALL = 15;
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_NONE = 0;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    private static final int LOADING_FRAMES_COUNT = 12;
    private static final int LOADING_FRAMES_DURATION = 150;
    private static Method mClearDisplayListMethod;
    private static Method mDestroyLayerMethod;
    private static Method mDestroyLayerWithParamMethod;
    private static Method mResetDisplayListMethod;
    private static HashMap<String, SoftReference<com.baidu.adp.widget.ImageView.a>> sDefaultBdImageCache;
    protected boolean canLogPerf;
    protected boolean isBitmapPic;
    protected boolean isLongPic;
    private boolean isPageIdRegisterMessage;
    protected boolean isSmartCrop;
    private int lastSkinType;
    private CustomMessageListener listener;
    private boolean mAutoChangeStyle;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback;
    private Path mClipPath;
    private RectF mClipRect;
    protected int mConrers;
    private int mCurrentDefaultBgId;
    private int mCurrentDefaultId;
    private float mCurrentDegrees;
    private int mDefaultBgId;
    protected int mDefaultId;
    private TbRichTextView.f mDispatchTouchListener;
    private boolean mDrawCorner;
    protected a mEvent;
    private com.baidu.tieba.pb.a.c mGestureDetector;
    protected int mHeight;
    private boolean mInterceptOnClick;
    private final com.baidu.tieba.pb.a.c mInternalGestureDetector;
    protected boolean mIsGif;
    int mLoadedHeight;
    int mLoadedWidth;
    private final int mLoadingDefaultId;
    private float mLoadingFrameIncrement;
    private final Matrix mMatrix;
    private View.OnClickListener mOnClickListener;
    protected b mOnDrawListener;
    protected BdUniqueId mPageId;
    protected h mPerfLog;
    private RectF mRoundRect;
    private boolean mShowAnimation;
    private boolean mShowLoading;
    protected float mSmartCropCenterPointHeightRatio;
    protected float mSmartCropCenterPointWidthRatio;
    protected boolean mSupportNoImage;
    private com.baidu.tbadk.widget.b mTagDrawer;
    private String mTagStr;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    a.InterfaceC0020a onInterceptDrawBackgoundListener;
    protected long requestTime;

    /* loaded from: classes.dex */
    public interface a {
        void L(String str, boolean z);

        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(TbImageView tbImageView, Canvas canvas);

        void b(TbImageView tbImageView, Canvas canvas);
    }

    public void setDispatchTouchListener(TbRichTextView.f fVar) {
        this.mDispatchTouchListener = fVar;
    }

    public void setEvent(a aVar) {
        this.mEvent = aVar;
    }

    public void setOnDrawListener(b bVar) {
        this.mOnDrawListener = bVar;
    }

    @Deprecated
    public int getLoadedWidth() {
        return this.mLoadedWidth;
    }

    @Deprecated
    public int getLoadedHeight() {
        return this.mLoadedHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processIsGifPic(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            this.mIsGif = aVar.isGif();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processIsLongPic(com.baidu.adp.widget.ImageView.a aVar) {
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mDispatchTouchListener != null) {
            this.mDispatchTouchListener.D(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.mEvent = null;
        this.mDefaultId = d.C0277d.transparent;
        this.mLoadingDefaultId = d.f.img_loading;
        this.mDefaultBgId = d.C0277d.cp_bg_line_e;
        this.mIsGif = false;
        this.isLongPic = false;
        this.isBitmapPic = false;
        this.isSmartCrop = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.mSupportNoImage = false;
        this.mPerfLog = null;
        this.mShowAnimation = false;
        this.mClipRect = new RectF();
        this.mClipPath = new Path();
        this.mRoundRect = new RectF();
        this.lastSkinType = 3;
        this.requestTime = 0L;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPageIdRegisterMessage = false;
        this.mDrawCorner = false;
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (TbImageView.this.mGestureDetector != null) {
                    TbImageView.this.mGestureDetector.ci(view);
                    return TbImageView.this.mGestureDetector.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.mInterceptOnClick) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.mGestureDetector != null) {
                        TbImageView.this.mGestureDetector.ci(view);
                        return TbImageView.this.mGestureDetector.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.jB().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.mCallback, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                if (aVar != null) {
                    TbImageView.this.mLoadedWidth = aVar.getWidth();
                    TbImageView.this.mLoadedHeight = aVar.getHeight();
                }
                TbImageView.this.stopLoading();
                if (aVar != null) {
                    TbImageView.this.processIsGifPic(aVar);
                    TbImageView.this.processIsLongPic(aVar);
                }
                if (TbImageView.this.mEvent != null) {
                    TbImageView.this.mEvent.L(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Of != null) {
                        TbImageView.this.mPerfLog.Oh = aVar.Of.Oh;
                        TbImageView.this.mPerfLog.isSuccess = aVar.Of.Oj;
                        TbImageView.this.mPerfLog.Oi = aVar.Of.Oi;
                    }
                } else {
                    TbImageView.this.mPerfLog.Oh = "net";
                    TbImageView.this.mPerfLog.isSuccess = false;
                    TbImageView.this.mPerfLog.Oi = System.currentTimeMillis() - TbImageView.this.requestTime;
                }
                TbImageView.this.startLogPerf();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                TbImageView.this.stopLoading();
                if (TbImageView.this.mEvent != null) {
                    TbImageView.this.mEvent.onCancel();
                }
            }
        };
        this.onInterceptDrawBackgoundListener = new a.InterfaceC0020a() { // from class: com.baidu.tbadk.widget.TbImageView.3
            @Override // com.baidu.adp.newwidget.ImageView.a.InterfaceC0020a
            public boolean b(Canvas canvas, Drawable drawable) {
                if (TbImageView.this.getBdImage() == null && TbImageView.this.mDrawCorner) {
                    TbImageView.this.drawBackground(canvas, drawable);
                    return true;
                }
                return false;
            }
        };
        this.listener = new CustomMessageListener(2016308) { // from class: com.baidu.tbadk.widget.TbImageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String k = com.baidu.adp.lib.f.c.jB().k(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (k != null && k.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        aqY();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mDestroyLayerMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mDestroyLayerWithParamMethod, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mClearDisplayListMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mResetDisplayListMethod, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void aqY() {
                if (TbImageView.mDestroyLayerMethod == null) {
                    Method unused = TbImageView.mDestroyLayerMethod = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.mDestroyLayerWithParamMethod == null) {
                    Method unused2 = TbImageView.mDestroyLayerWithParamMethod = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.mClearDisplayListMethod == null) {
                    Method unused3 = TbImageView.mClearDisplayListMethod = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.mResetDisplayListMethod == null) {
                    Method unused4 = TbImageView.mResetDisplayListMethod = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, null);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEvent = null;
        this.mDefaultId = d.C0277d.transparent;
        this.mLoadingDefaultId = d.f.img_loading;
        this.mDefaultBgId = d.C0277d.cp_bg_line_e;
        this.mIsGif = false;
        this.isLongPic = false;
        this.isBitmapPic = false;
        this.isSmartCrop = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.mSupportNoImage = false;
        this.mPerfLog = null;
        this.mShowAnimation = false;
        this.mClipRect = new RectF();
        this.mClipPath = new Path();
        this.mRoundRect = new RectF();
        this.lastSkinType = 3;
        this.requestTime = 0L;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPageIdRegisterMessage = false;
        this.mDrawCorner = false;
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (TbImageView.this.mGestureDetector != null) {
                    TbImageView.this.mGestureDetector.ci(view);
                    return TbImageView.this.mGestureDetector.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.mInterceptOnClick) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.mGestureDetector != null) {
                        TbImageView.this.mGestureDetector.ci(view);
                        return TbImageView.this.mGestureDetector.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.jB().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.mCallback, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                if (aVar != null) {
                    TbImageView.this.mLoadedWidth = aVar.getWidth();
                    TbImageView.this.mLoadedHeight = aVar.getHeight();
                }
                TbImageView.this.stopLoading();
                if (aVar != null) {
                    TbImageView.this.processIsGifPic(aVar);
                    TbImageView.this.processIsLongPic(aVar);
                }
                if (TbImageView.this.mEvent != null) {
                    TbImageView.this.mEvent.L(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Of != null) {
                        TbImageView.this.mPerfLog.Oh = aVar.Of.Oh;
                        TbImageView.this.mPerfLog.isSuccess = aVar.Of.Oj;
                        TbImageView.this.mPerfLog.Oi = aVar.Of.Oi;
                    }
                } else {
                    TbImageView.this.mPerfLog.Oh = "net";
                    TbImageView.this.mPerfLog.isSuccess = false;
                    TbImageView.this.mPerfLog.Oi = System.currentTimeMillis() - TbImageView.this.requestTime;
                }
                TbImageView.this.startLogPerf();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                TbImageView.this.stopLoading();
                if (TbImageView.this.mEvent != null) {
                    TbImageView.this.mEvent.onCancel();
                }
            }
        };
        this.onInterceptDrawBackgoundListener = new a.InterfaceC0020a() { // from class: com.baidu.tbadk.widget.TbImageView.3
            @Override // com.baidu.adp.newwidget.ImageView.a.InterfaceC0020a
            public boolean b(Canvas canvas, Drawable drawable) {
                if (TbImageView.this.getBdImage() == null && TbImageView.this.mDrawCorner) {
                    TbImageView.this.drawBackground(canvas, drawable);
                    return true;
                }
                return false;
            }
        };
        this.listener = new CustomMessageListener(2016308) { // from class: com.baidu.tbadk.widget.TbImageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String k = com.baidu.adp.lib.f.c.jB().k(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (k != null && k.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        aqY();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mDestroyLayerMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mDestroyLayerWithParamMethod, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mClearDisplayListMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mResetDisplayListMethod, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void aqY() {
                if (TbImageView.mDestroyLayerMethod == null) {
                    Method unused = TbImageView.mDestroyLayerMethod = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
                }
                if (TbImageView.mDestroyLayerWithParamMethod == null) {
                    Method unused2 = TbImageView.mDestroyLayerWithParamMethod = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
                }
                if (TbImageView.mClearDisplayListMethod == null) {
                    Method unused3 = TbImageView.mClearDisplayListMethod = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
                }
                if (TbImageView.mResetDisplayListMethod == null) {
                    Method unused4 = TbImageView.mResetDisplayListMethod = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
                }
            }
        };
        init(context, attributeSet);
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTagDrawer = new com.baidu.tbadk.widget.b(this);
        updateNight();
        this.mLoadingFrameIncrement = 30.0f;
        this.mPerfLog = new h();
        setConrers(0);
        if (this.mDrawer != null) {
            this.mDrawer.a(this.onInterceptDrawBackgoundListener);
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
                com.baidu.adp.widget.ImageView.a pj = com.baidu.tbadk.imageManager.c.anm().pj(str);
                aVar = pj == null ? com.baidu.tbadk.imageManager.c.anm().pi(str) : pj;
            }
        } else {
            aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jB().a(this.mUrl, this.mType, new Object[0]);
        }
        if (aVar != null) {
            processIsGifPic(aVar);
            processIsLongPic(aVar);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.ImageView.a> softReference;
        com.baidu.adp.widget.ImageView.a aVar;
        if (sDefaultBdImageCache == null) {
            sDefaultBdImageCache = new HashMap<>();
        }
        String valueOf = String.valueOf(this.mCurrentDefaultId);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.lastSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mNeedRecomputeMatrix = true;
            this.lastSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!sDefaultBdImageCache.containsKey(str) || (softReference = sDefaultBdImageCache.get(str)) == null || (aVar = softReference.get()) == null || !aVar.oz()) {
            Bitmap bitmap = null;
            if (this.mCurrentDefaultId > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = al.hp(this.mCurrentDefaultId);
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

    public void startLoad(String str, int i, boolean z) {
        startLoad(str, i, 0, 0, z);
    }

    public void startLoad(String str, int i, boolean z, boolean z2) {
        startLoad(str, i, 0, 0, z, z2);
    }

    public void startLoad(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId = null;
        boolean z2 = false;
        com.baidu.adp.base.h aI = i.aI(getContext());
        if (aI != null) {
            BdUniqueId uniqueId = this.mPageId != null ? this.mPageId : aI.getUniqueId();
            z2 = aI.isScroll();
            bdUniqueId = uniqueId;
        }
        startLoad(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void startLoad(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        com.baidu.adp.base.h aI = i.aI(getContext());
        if (aI != null) {
            bdUniqueId = this.mPageId != null ? this.mPageId : aI.getUniqueId();
        }
        startLoad(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void startLoadWithoutScroll(String str, int i, boolean z) {
        startLoadWithoutScroll(str, i, 0, 0, z);
    }

    public void startLoadWithoutScroll(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId = null;
        com.baidu.adp.base.h aI = i.aI(getContext());
        if (aI != null) {
            bdUniqueId = aI.getUniqueId();
        }
        startLoad(str, i, i2, i3, z, bdUniqueId, false);
    }

    public void startLoad(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        boolean z3 = str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId;
        if (!z3) {
            stopLoad();
            this.mNeedRecomputeMatrix = true;
            this.mIsGif = false;
            requestLayout();
        } else if (getBdImage() != null) {
            this.mPerfLog.Oh = "memory";
            this.mPerfLog.isSuccess = true;
            this.mPerfLog.Oi = 0L;
            invalidate();
            if (this.mEvent != null) {
                this.mEvent.L(str, true);
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
        } else if (!com.baidu.adp.lib.f.c.jB().aq(this.mType) && this.mSupportNoImage) {
            invalidate();
        } else if (z3 && !j.kY()) {
            this.mPerfLog.Oh = "memory";
            this.mPerfLog.isSuccess = false;
            this.mPerfLog.Oi = 0L;
            invalidate();
            if (this.mEvent != null) {
                this.mEvent.L(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.requestTime = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.jB().a(this.mUrl, this.mType, this.mCallback, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.jB().a(this.mUrl, this.mType, this.mCallback);
            stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e<?> aK = i.aK(getContext());
        if (this.mPageId != null) {
            this.isPageIdRegisterMessage = true;
        }
        if (aK != null) {
            this.listener.setTag(this.mPageId != null ? this.mPageId : aK.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isPageIdRegisterMessage = false;
        stopLoad();
        MessageManager.getInstance().unRegisterListener(this.listener);
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
        if (this.mDrawer != null) {
            this.mDrawer.a(this.onInterceptDrawBackgoundListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawBackground(Canvas canvas, Drawable drawable) {
        canvas.save();
        this.mClipPath.reset();
        this.mClipRect.right = getWidth();
        this.mClipRect.bottom = getHeight();
        this.mClipPath.addRoundRect(this.mClipRect, this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CW);
        int i = this.mConrers ^ 15;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        if ((i & 1) != 0) {
            this.mClipPath.addRect(0.0f, 0.0f, this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CW);
        }
        if ((i & 2) != 0) {
            this.mClipPath.addRect(rectF.right - this.mArgs.mRadius, 0.0f, rectF.right, this.mArgs.mRadius, Path.Direction.CW);
        }
        if ((i & 4) != 0) {
            this.mClipPath.addRect(0.0f, rectF.bottom - this.mArgs.mRadius, this.mArgs.mRadius, rectF.bottom, Path.Direction.CW);
        }
        if ((i & 8) != 0) {
            this.mClipPath.addRect(rectF.right - this.mArgs.mRadius, rectF.bottom - this.mArgs.mRadius, rectF.right, rectF.bottom, Path.Direction.CW);
        }
        canvas.clipPath(this.mClipPath);
        drawable.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        updateNight();
        notifiyOnDrawListener(true, canvas);
        super.onDraw(canvas);
        onDrawNoConrer(canvas);
        onDrawNoConrerBorder(canvas);
        notifiyOnDrawListener(false, canvas);
    }

    private void notifiyOnDrawListener(boolean z, Canvas canvas) {
        if (this.mOnDrawListener != null) {
            if (z) {
                this.mOnDrawListener.a(this, canvas);
            } else {
                this.mOnDrawListener.b(this, canvas);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void drawContentTag(Canvas canvas, ImageView imageView) {
        super.drawContentTag(canvas, imageView);
        if (this.mTagDrawer != null && this.mArgs != null) {
            if (this.mArgs.Jg && isGif()) {
                this.mTagDrawer.c(canvas, getContext().getString(d.j.icon_tag_gif));
            } else if (this.mArgs.Jf && isLongPic()) {
                this.mTagDrawer.c(canvas, getContext().getString(d.j.icon_tag_long));
            } else if (this.mTagStr != null) {
                this.mTagDrawer.c(canvas, this.mTagStr);
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

    public boolean isBitmapPic() {
        return isBitmapPic();
    }

    public void setIsBitmapPic(boolean z) {
        this.isBitmapPic = z;
    }

    public boolean isSmartCrop() {
        return this.isSmartCrop;
    }

    public void setIsSmartCrop(boolean z) {
        this.isSmartCrop = z;
    }

    public float getSmartCropCenterPointWidthRatio() {
        return this.mSmartCropCenterPointWidthRatio;
    }

    public void setSmartCropCenterPointWidthRatio(float f) {
        this.mSmartCropCenterPointWidthRatio = f;
    }

    public float getSmartCropCenterPointHeightRatio() {
        return this.mSmartCropCenterPointHeightRatio;
    }

    public void setSmartCropCenterPointHeightRatio(float f) {
        this.mSmartCropCenterPointHeightRatio = f;
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
        if (this.mAutoChangeStyle) {
            this.mArgs.mIsNight = TbadkCoreApplication.getInst().getSkinType() == 1;
        } else {
            this.mArgs.mIsNight = false;
        }
        int i = this.mCurrentDefaultId;
        int i2 = this.mShowLoading ? this.mLoadingDefaultId : this.mDefaultId;
        if (i2 != this.mCurrentDefaultId) {
            this.mCurrentDefaultId = i2;
            this.mNeedRecomputeMatrix = true;
        }
        this.mCurrentDefaultBgId = this.mDefaultBgId;
        if (this.mCurrentDefaultBgId > 0) {
            if (this.mAutoChangeStyle) {
                setDefaultBg(al.getDrawable(this.mCurrentDefaultBgId));
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
            this.listener.setTag(this.mPageId);
            MessageManager.getInstance().registerListener(this.listener);
            this.isPageIdRegisterMessage = true;
        }
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void refresh() {
        startLoad(this.mUrl, this.mType, this.mWidth, this.mHeight, false);
        invalidate();
    }

    public void reset() {
        setTag(null);
        this.mUrl = null;
        this.mIsGif = false;
        this.isLongPic = false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnTouchListener(this.mInternalGestureDetector);
        if (!isClickable()) {
            setClickable(true);
        }
        this.mOnClickListener = onClickListener;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        super.setOnTouchListener(this.mInternalGestureDetector);
        this.mGestureDetector = cVar;
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
            com.baidu.adp.lib.f.c.jB().a(this.mUrl, this.mType, this.mCallback, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.mTagDrawer != null) {
            return (int) this.mTagDrawer.pW(getContext().getString(d.j.icon_tag_gif));
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.mTagDrawer != null) {
            return (int) this.mTagDrawer.pV(getContext().getString(d.j.icon_tag_gif));
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public h getPerfLog() {
        return this.mPerfLog;
    }

    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.mPerfLog != null && this.mPerfLog.cqo) {
            this.mPerfLog.apc();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawBorder(boolean z) {
        super.setDrawBorder(z);
    }

    public void setTagPaddingDis(int i, int i2) {
        if (this.mTagDrawer != null) {
            this.mTagDrawer.setTagPaddingDis(i, i2);
        }
    }

    public void setTagTextSize(int i) {
        if (this.mTagDrawer != null) {
            this.mTagDrawer.setTagTextSize(i);
        }
    }

    public void setTagStr(String str) {
        this.mTagStr = str;
    }

    public void setTagColor(int i) {
        if (this.mTagDrawer != null) {
            this.mTagDrawer.kf(i);
        }
    }

    public void setConrers(int i) {
        this.mConrers = i;
    }

    public void addCornerFlags(int i) {
        this.mConrers |= i;
    }

    public void clearCornerFlag() {
        this.mConrers = 0;
    }

    public void setDrawCorner(boolean z) {
        this.mDrawCorner = z;
    }

    public boolean getDrawCorner() {
        return this.mDrawCorner;
    }

    private void onDrawNoConrer(Canvas canvas) {
        if (this.isBitmapPic || getBdImage() != null) {
            if (this.mConrers != 0 || getDrawCorner()) {
                setDrawerType(1);
                int i = this.mConrers ^ 15;
                this.mRoundRect.set(0.0f, 0.0f, getWidth(), getHeight());
                if ((i & 1) != 0) {
                    canvas.drawRect(0.0f, 0.0f, this.mArgs.mRadius, this.mArgs.mRadius, this.mDrawer.mPaint);
                }
                if ((i & 2) != 0) {
                    canvas.drawRect(this.mRoundRect.right - this.mArgs.mRadius, 0.0f, this.mRoundRect.right, this.mArgs.mRadius, this.mDrawer.mPaint);
                }
                if ((i & 4) != 0) {
                    canvas.drawRect(0.0f, this.mRoundRect.bottom - this.mArgs.mRadius, this.mArgs.mRadius, this.mRoundRect.bottom, this.mDrawer.mPaint);
                }
                if ((i & 8) != 0) {
                    canvas.drawRect(this.mRoundRect.right - this.mArgs.mRadius, this.mRoundRect.bottom - this.mArgs.mRadius, this.mRoundRect.right, this.mRoundRect.bottom, this.mDrawer.mPaint);
                }
            }
        }
    }

    public float getRadius() {
        if (this.mArgs == null) {
            return 0.0f;
        }
        return this.mArgs.mRadius;
    }

    private void onDrawNoConrerBorder(Canvas canvas) {
        if (this.isBitmapPic || getBdImage() != null) {
            if (this.mConrers != 0 || getDrawBorder()) {
                setDrawerType(1);
                int i = this.mConrers ^ 15;
                this.mRoundRect.set(0.0f, 0.0f, getWidth(), getHeight());
                this.mDrawer.mBorderPaint.setStrokeWidth(this.mDrawer.mBorderPaint.getStrokeWidth() * 2.0f);
                if ((i & 1) != 0) {
                    canvas.drawLine(0.0f, 0.0f, this.mArgs.mRadius, 0.0f, this.mDrawer.mBorderPaint);
                    canvas.drawLine(0.0f, 0.0f, 0.0f, this.mArgs.mRadius, this.mDrawer.mBorderPaint);
                }
                if ((i & 2) != 0) {
                    canvas.drawLine(this.mRoundRect.right - this.mArgs.mRadius, 0.0f, this.mRoundRect.right, 0.0f, this.mDrawer.mBorderPaint);
                    canvas.drawLine(this.mRoundRect.right, 0.0f, this.mRoundRect.right, this.mRoundRect.right + this.mArgs.mRadius, this.mDrawer.mBorderPaint);
                }
                if ((i & 4) != 0) {
                    canvas.drawLine(0.0f, this.mRoundRect.bottom - this.mArgs.mRadius, 0.0f, this.mRoundRect.bottom, this.mDrawer.mBorderPaint);
                    canvas.drawLine(0.0f, this.mRoundRect.bottom, this.mArgs.mRadius, this.mRoundRect.bottom, this.mDrawer.mBorderPaint);
                }
                if ((i & 8) != 0) {
                    canvas.drawLine(this.mRoundRect.right - this.mArgs.mRadius, this.mRoundRect.bottom, this.mRoundRect.right, this.mRoundRect.bottom, this.mDrawer.mBorderPaint);
                    canvas.drawLine(this.mRoundRect.right, this.mRoundRect.bottom, this.mRoundRect.right, this.mRoundRect.bottom - this.mArgs.mRadius, this.mDrawer.mBorderPaint);
                }
            }
        }
    }
}

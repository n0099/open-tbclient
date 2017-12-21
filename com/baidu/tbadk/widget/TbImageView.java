package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.k.l;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbImageView extends com.baidu.adp.b.a.b implements View.OnClickListener, Runnable {
    private static final int LOADING_FRAMES_COUNT = 12;
    private static final int LOADING_FRAMES_DURATION = 150;
    private static Method mClearDisplayListMethod;
    private static Method mDestroyLayerMethod;
    private static Method mDestroyLayerWithParamMethod;
    private static Method mResetDisplayListMethod;
    private static HashMap<String, SoftReference<com.baidu.adp.widget.a.a>> sDefaultBdImageCache;
    protected boolean canLogPerf;
    protected boolean isLongPic;
    private boolean isPageIdRegisterMessage;
    private int lastSkinType;
    private CustomMessageListener listener;
    private boolean mAutoChangeStyle;
    protected final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback;
    private int mCurrentDefaultBgId;
    private int mCurrentDefaultId;
    private float mCurrentDegrees;
    private int mDefaultBgId;
    protected int mDefaultErrorId;
    protected int mDefaultId;
    protected int mDefaultIdInUse;
    private TbRichTextView.e mDispatchTouchListener;
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
    protected l mPerfLog;
    private boolean mShowLoading;
    protected boolean mSupportNoImage;
    private d mTagDrawer;
    private String mTagStr;
    protected int mType;
    protected String mUrl;
    protected int mWidth;
    protected long requestTime;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();

        void r(String str, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(TbImageView tbImageView, Canvas canvas);

        void b(TbImageView tbImageView, Canvas canvas);
    }

    public void setDispatchTouchListener(TbRichTextView.e eVar) {
        this.mDispatchTouchListener = eVar;
    }

    public void setEvent(a aVar) {
        this.mEvent = aVar;
    }

    public void setOnDrawListener(b bVar) {
        this.mOnDrawListener = bVar;
    }

    public int getLoadedWidth() {
        return this.mLoadedWidth;
    }

    public int getLoadedHeight() {
        return this.mLoadedHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processIsGifPic(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            this.mIsGif = aVar.isGif();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processIsLongPic(com.baidu.adp.widget.a.a aVar) {
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mDispatchTouchListener != null) {
            this.mDispatchTouchListener.s(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TbImageView(Context context) {
        super(context);
        this.mEvent = null;
        this.mDefaultId = d.C0095d.transparent;
        this.mDefaultErrorId = d.f.img_default_100;
        this.mDefaultIdInUse = this.mDefaultId;
        this.mLoadingDefaultId = d.f.img_loading;
        this.mDefaultBgId = d.C0095d.cp_bg_line_e;
        this.mIsGif = false;
        this.isLongPic = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.mSupportNoImage = false;
        this.mPerfLog = null;
        this.lastSkinType = 3;
        this.requestTime = 0L;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPageIdRegisterMessage = false;
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.mGestureDetector != null) {
                    TbImageView.this.mGestureDetector.bb(view);
                    return TbImageView.this.mGestureDetector.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.mInterceptOnClick) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.mGestureDetector != null) {
                        TbImageView.this.mGestureDetector.bb(view);
                        return TbImageView.this.mGestureDetector.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fJ().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.mCallback, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                if (aVar != null) {
                    TbImageView.this.mLoadedWidth = aVar.getWidth();
                    TbImageView.this.mLoadedHeight = aVar.getHeight();
                }
                TbImageView.this.stopLoading();
                if (aVar != null) {
                    TbImageView.this.processIsGifPic(aVar);
                    TbImageView.this.processIsLongPic(aVar);
                } else {
                    TbImageView.this.mDefaultIdInUse = TbImageView.this.mDefaultErrorId;
                }
                if (TbImageView.this.mEvent != null) {
                    TbImageView.this.mEvent.r(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Gl != null) {
                        TbImageView.this.mPerfLog.Gn = aVar.Gl.Gn;
                        TbImageView.this.mPerfLog.isSuccess = aVar.Gl.Gp;
                        TbImageView.this.mPerfLog.Go = aVar.Gl.Go;
                    }
                } else {
                    TbImageView.this.mPerfLog.Gn = "net";
                    TbImageView.this.mPerfLog.isSuccess = false;
                    TbImageView.this.mPerfLog.Go = System.currentTimeMillis() - TbImageView.this.requestTime;
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
        this.listener = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fJ().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HY();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mDestroyLayerMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mDestroyLayerWithParamMethod, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mClearDisplayListMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mResetDisplayListMethod, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HY() {
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
        this.mDefaultId = d.C0095d.transparent;
        this.mDefaultErrorId = d.f.img_default_100;
        this.mDefaultIdInUse = this.mDefaultId;
        this.mLoadingDefaultId = d.f.img_loading;
        this.mDefaultBgId = d.C0095d.cp_bg_line_e;
        this.mIsGif = false;
        this.isLongPic = false;
        this.mType = 10;
        this.mAutoChangeStyle = true;
        this.mMatrix = new Matrix();
        this.mSupportNoImage = false;
        this.mPerfLog = null;
        this.lastSkinType = 3;
        this.requestTime = 0L;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPageIdRegisterMessage = false;
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.TbImageView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbImageView.this.mGestureDetector != null) {
                    TbImageView.this.mGestureDetector.bb(view);
                    return TbImageView.this.mGestureDetector.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.mInterceptOnClick) {
                    if (TbImageView.this.mOnClickListener != null) {
                        TbImageView.this.mOnClickListener.onClick(view);
                        return true;
                    } else if (TbImageView.this.mGestureDetector != null) {
                        TbImageView.this.mGestureDetector.bb(view);
                        return TbImageView.this.mGestureDetector.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                TbImageView.this.startLoading();
                com.baidu.adp.lib.f.c.fJ().a(TbImageView.this.mUrl, TbImageView.this.mType, TbImageView.this.mCallback, TbImageView.this.mWidth, TbImageView.this.mHeight, TbImageView.this.mPageId, new Object[0]);
                return true;
            }
        });
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.TbImageView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                if (aVar != null) {
                    TbImageView.this.mLoadedWidth = aVar.getWidth();
                    TbImageView.this.mLoadedHeight = aVar.getHeight();
                }
                TbImageView.this.stopLoading();
                if (aVar != null) {
                    TbImageView.this.processIsGifPic(aVar);
                    TbImageView.this.processIsLongPic(aVar);
                } else {
                    TbImageView.this.mDefaultIdInUse = TbImageView.this.mDefaultErrorId;
                }
                if (TbImageView.this.mEvent != null) {
                    TbImageView.this.mEvent.r(str, aVar != null);
                }
                if (aVar != null) {
                    if (aVar.Gl != null) {
                        TbImageView.this.mPerfLog.Gn = aVar.Gl.Gn;
                        TbImageView.this.mPerfLog.isSuccess = aVar.Gl.Gp;
                        TbImageView.this.mPerfLog.Go = aVar.Gl.Go;
                    }
                } else {
                    TbImageView.this.mPerfLog.Gn = "net";
                    TbImageView.this.mPerfLog.isSuccess = false;
                    TbImageView.this.mPerfLog.Go = System.currentTimeMillis() - TbImageView.this.requestTime;
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
        this.listener = new CustomMessageListener(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE) { // from class: com.baidu.tbadk.widget.TbImageView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    String f = com.baidu.adp.lib.f.c.fJ().f(TbImageView.this.mUrl, TbImageView.this.mType);
                    if (f != null && f.equals(str)) {
                        TbImageView.this.destroyDrawingCache();
                        HY();
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mDestroyLayerMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mDestroyLayerWithParamMethod, TbImageView.this, TbImageView.class, false);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mClearDisplayListMethod, TbImageView.this, TbImageView.class);
                        com.baidu.adp.lib.OrmObject.a.a.a(TbImageView.mResetDisplayListMethod, TbImageView.this, TbImageView.class);
                        TbImageView.this.invalidate();
                    }
                }
            }

            private void HY() {
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
        this.mTagDrawer = new d(this);
        updateNight();
        this.mLoadingFrameIncrement = 30.0f;
        this.mPerfLog = new l();
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

    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getBdImage() {
        com.baidu.adp.widget.a.a aVar;
        if (TextUtils.isEmpty(this.mUrl)) {
            Object tag = getTag();
            if (!(tag instanceof String)) {
                aVar = null;
            } else {
                String str = (String) tag;
                com.baidu.adp.widget.a.a gr = com.baidu.tbadk.imageManager.c.EA().gr(str);
                aVar = gr == null ? com.baidu.tbadk.imageManager.c.EA().gq(str) : gr;
            }
        } else {
            aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, new Object[0]);
        }
        if (aVar != null) {
            processIsGifPic(aVar);
            processIsLongPic(aVar);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b
    public com.baidu.adp.widget.a.a getDefaultBdImage() {
        SoftReference<com.baidu.adp.widget.a.a> softReference;
        com.baidu.adp.widget.a.a aVar;
        if (sDefaultBdImageCache == null) {
            sDefaultBdImageCache = new HashMap<>();
        }
        String valueOf = String.valueOf(this.mCurrentDefaultId);
        String str = (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 1) ? valueOf + "_1" : valueOf;
        if (this.lastSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mNeedRecomputeMatrix = true;
            this.lastSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!sDefaultBdImageCache.containsKey(str) || (softReference = sDefaultBdImageCache.get(str)) == null || (aVar = softReference.get()) == null || !aVar.kL()) {
            Bitmap bitmap = null;
            if (this.mCurrentDefaultId > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        bitmap = aj.cR(this.mCurrentDefaultId);
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
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(bitmap, false, String.valueOf(this.mCurrentDefaultId));
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
        h W = i.W(getContext());
        if (W != null) {
            BdUniqueId uniqueId = this.mPageId != null ? this.mPageId : W.getUniqueId();
            z2 = W.isScroll();
            bdUniqueId = uniqueId;
        }
        startLoad(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void startLoad(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId = null;
        h W = i.W(getContext());
        if (W != null) {
            bdUniqueId = this.mPageId != null ? this.mPageId : W.getUniqueId();
        }
        startLoad(str, i, i2, i3, z, bdUniqueId, z2);
    }

    public void startLoadWithoutScroll(String str, int i, boolean z) {
        startLoadWithoutScroll(str, i, 0, 0, z);
    }

    public void startLoadWithoutScroll(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId = null;
        h W = i.W(getContext());
        if (W != null) {
            bdUniqueId = W.getUniqueId();
        }
        startLoad(str, i, i2, i3, z, bdUniqueId, false);
    }

    public void startLoad(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        this.mDefaultIdInUse = this.mDefaultId;
        if (TextUtils.isEmpty(str)) {
            this.mDefaultIdInUse = this.mDefaultErrorId;
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
            this.mPerfLog.Gn = "memory";
            this.mPerfLog.isSuccess = true;
            this.mPerfLog.Go = 0L;
            invalidate();
            if (this.mEvent != null) {
                this.mEvent.r(str, true);
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
        } else if (!com.baidu.adp.lib.f.c.fJ().an(this.mType) && this.mSupportNoImage) {
            invalidate();
        } else if (z3 && !j.hh()) {
            this.mPerfLog.Gn = "memory";
            this.mPerfLog.isSuccess = false;
            this.mPerfLog.Go = 0L;
            this.mDefaultIdInUse = this.mDefaultErrorId;
            invalidate();
            if (this.mEvent != null) {
                this.mEvent.r(str, false);
            }
        } else {
            if (z) {
                startLoading();
            }
            this.requestTime = System.currentTimeMillis();
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.mCallback, i2, i3, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.mCallback);
            stopLoading();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.base.e<?> Y = i.Y(getContext());
        if (this.mPageId != null) {
            this.isPageIdRegisterMessage = true;
        }
        if (Y != null) {
            this.listener.setTag(this.mPageId != null ? this.mPageId : Y.getUniqueId());
        }
        MessageManager.getInstance().registerListener(this.listener);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        updateNight();
        notifiyOnDrawListener(true, canvas);
        super.onDraw(canvas);
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

    @Override // com.baidu.adp.b.a.b
    public void drawContentTag(Canvas canvas, ImageView imageView) {
        super.drawContentTag(canvas, imageView);
        if (this.mTagDrawer != null && this.mArgs != null) {
            if (this.mArgs.Bq && isGif()) {
                this.mTagDrawer.c(canvas, getContext().getString(d.j.icon_tag_gif));
            } else if (this.mArgs.Bp && isLongPic()) {
                this.mTagDrawer.c(canvas, getContext().getString(d.j.icon_tag_long));
            } else if (this.mTagStr != null) {
                this.mTagDrawer.c(canvas, this.mTagStr);
            }
        }
    }

    public void setTagDrawerExtraWH(int i, int i2) {
        if (this.mTagDrawer != null) {
            this.mTagDrawer.O(i, i2);
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

    @Override // java.lang.Runnable
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
            this.mArgs.Bn = TbadkCoreApplication.getInst().getSkinType() == 1;
        } else {
            this.mArgs.Bn = false;
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
                setDefaultBg(aj.getDrawable(this.mCurrentDefaultBgId));
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
            this.mDefaultIdInUse = i;
            invalidate();
        }
    }

    public void setDefaultErrorResource(int i) {
        this.mDefaultErrorId = i;
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

    @Override // com.baidu.adp.b.a.i
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.mInterceptOnClick) {
            startLoading();
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, this.mType, this.mCallback, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
        } else if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public int getGifIconWidth() {
        if (this.mTagDrawer != null) {
            return (int) this.mTagDrawer.he(getContext().getString(d.j.icon_tag_gif));
        }
        return -1;
    }

    public int getGifIconHeight() {
        if (this.mTagDrawer != null) {
            return (int) this.mTagDrawer.hd(getContext().getString(d.j.icon_tag_gif));
        }
        return -1;
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    public l getPerfLog() {
        return this.mPerfLog;
    }

    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.mPerfLog != null && this.mPerfLog.aKq) {
            this.mPerfLog.Gv();
        }
    }

    @Override // com.baidu.adp.b.a.b
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
            this.mTagDrawer.fz(i);
        }
    }
}

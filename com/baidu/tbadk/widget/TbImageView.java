package com.baidu.tbadk.widget;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.base.BdPageContextSupport;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.switchs.PicReqSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.gu9;
import com.baidu.tieba.gv5;
import com.baidu.tieba.qb;
import com.baidu.tieba.qf;
import com.baidu.tieba.rf;
import com.baidu.tieba.yt9;
import com.baidu.tieba.z4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public class TbImageView extends BDImageView implements Runnable, View.OnClickListener, gu9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CORNER_ALL = 15;
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_NONE = 0;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    public static final int LOADING_FRAMES_COUNT = 12;
    public static final int LOADING_FRAMES_DURATION = 150;
    public static final int PLACE_HOLDER_HUAJI_BIG = 3;
    public static final int PLACE_HOLDER_HUAJI_MIDDLE = 2;
    public static final int PLACE_HOLDER_HUAJI_NONE = 0;
    public static final int PLACE_HOLDER_HUAJI_SMALL = 1;
    public static HashMap<String, SoftReference<BdImage>> sDefaultBdImageCache;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isBitmapPic;
    public boolean isLongPic;
    public boolean isPicReq;
    public boolean isSmartCrop;
    public CustomMessageListener listener;
    public boolean mAutoChangeStyle;
    public final BdResourceCallback<BdImage> mCallback;
    public Path mClipPath;
    public RectF mClipRect;
    public int mConrers;
    public int mCurrentDefaultId;
    public float mCurrentDegrees;
    public int mDefaultBgId;
    public int mDefaultId;
    public TbRichTextView.x mDispatchTouchListener;
    public boolean mDrawCorner;
    public f mEvent;
    public yt9 mGestureDetector;
    public int mHeight;
    public boolean mInterceptOnClick;
    public yt9 mInternalGestureDetector;
    public boolean mIsGif;
    public boolean mIsGifPic;
    public boolean mIsPageIdRegisterMessage;
    public int mLoadedHeight;
    public int mLoadedWidth;
    public final int mLoadingDefaultId;
    public float mLoadingFrameIncrement;
    public HashMap<String, e> mLogMap;
    public final Matrix mMatrix;
    public View.OnClickListener mOnClickListener;
    public h mOnDrawListener;
    public BdUniqueId mPageId;
    public HashMap<String, e> mRequestMap;
    public RectF mRoundRect;
    public boolean mShowLoading;
    public int mSkinType;
    public float mSmartCropCenterPointHeightRatio;
    public float mSmartCropCenterPointWidthRatio;
    public boolean mSupportNoImage;
    public gv5 mTagDrawer;
    public String mTagStr;
    public int mType;
    public String mUrl;
    public boolean mUseNightOrDarkMask;
    public int mWidth;
    public qf.b onInterceptDrawBackgoundListener;

    /* loaded from: classes5.dex */
    public interface f {
        void a(String str, boolean z);

        void onCancel();
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(TbImageView tbImageView, Canvas canvas);

        void b(TbImageView tbImageView, Canvas canvas);
    }

    /* loaded from: classes5.dex */
    public class a extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        public a(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                this.a.stopLoading();
                f fVar = this.a.mEvent;
                if (fVar != null) {
                    fVar.onCancel();
                }
            }
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdImage, str, i) == null) {
                boolean z4 = false;
                if (bdImage != null) {
                    this.a.mLoadedWidth = bdImage.getWidth();
                    this.a.mLoadedHeight = bdImage.getHeight();
                    BdResourceLoader bdResourceLoader = BdResourceLoader.getInstance();
                    TbImageView tbImageView = this.a;
                    String genCacheKey = bdResourceLoader.genCacheKey(tbImageView.mUrl, tbImageView.mType);
                    e eVar = this.a.mLogMap.get(genCacheKey);
                    if (eVar != null) {
                        if (i == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (i == 2) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (i == 3) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        qb.d(z, z2, z3);
                        if (i == 3) {
                            qb.e(true, System.currentTimeMillis() - eVar.c);
                        }
                        this.a.mLogMap.remove(genCacheKey);
                    }
                }
                this.a.stopLoading();
                this.a.invalidate();
                if (this.a.getWidth() * this.a.getHeight() == 0) {
                    this.a.requestLayout();
                }
                this.a.processIsGifPic(bdImage);
                f fVar = this.a.mEvent;
                if (fVar != null) {
                    if (bdImage != null) {
                        z4 = true;
                    }
                    fVar.a(str, z4);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qf.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        public b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        @Override // com.baidu.tieba.qf.b
        public boolean a(Canvas canvas, Drawable drawable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, canvas, drawable)) == null) {
                if (this.a.getBdImage() != null || !this.a.mDrawCorner) {
                    return false;
                }
                this.a.drawBackground(canvas, drawable);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements yt9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        @Override // com.baidu.tieba.yt9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public c(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        @Override // com.baidu.tieba.yt9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.getBdImage() == null && this.a.getDrawable() == null && this.a.mInterceptOnClick) {
                    this.a.startLoading();
                    BdResourceLoader bdResourceLoader = BdResourceLoader.getInstance();
                    TbImageView tbImageView = this.a;
                    bdResourceLoader.loadResource(tbImageView.mUrl, tbImageView.mType, tbImageView.mCallback, tbImageView.mWidth, tbImageView.mHeight, tbImageView.mPageId, new Object[0]);
                    return true;
                } else if (this.a.mOnClickListener != null) {
                    this.a.mOnClickListener.onClick(view2);
                    return true;
                } else if (this.a.mGestureDetector == null) {
                    return false;
                } else {
                    this.a.mGestureDetector.a(view2);
                    return this.a.mGestureDetector.onSingleTapConfirmed(motionEvent);
                }
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.yt9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.mGestureDetector != null) {
                    this.a.mGestureDetector.a(view2);
                    return this.a.mGestureDetector.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements yt9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        @Override // com.baidu.tieba.yt9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public d(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        @Override // com.baidu.tieba.yt9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.getBdImage() == null && this.a.getDrawable() == null && this.a.mInterceptOnClick) {
                    this.a.startLoading();
                    BdResourceLoader bdResourceLoader = BdResourceLoader.getInstance();
                    TbImageView tbImageView = this.a;
                    bdResourceLoader.loadResource(tbImageView.mUrl, tbImageView.mType, tbImageView.mCallback, tbImageView.mWidth, tbImageView.mHeight, tbImageView.mPageId, new Object[0]);
                    return true;
                } else if (this.a.mOnClickListener != null) {
                    this.a.mOnClickListener.onClick(view2);
                    return true;
                } else if (this.a.mGestureDetector == null) {
                    return false;
                } else {
                    this.a.mGestureDetector.a(view2);
                    return this.a.mGestureDetector.onSingleTapConfirmed(motionEvent);
                }
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.yt9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.mGestureDetector != null) {
                    this.a.mGestureDetector.a(view2);
                    return this.a.mGestureDetector.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public long c;
        public final /* synthetic */ TbImageView d;

        public e(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = tbImageView;
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TbImageView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TbImageView tbImageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(tbImageView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (tbImageView = this.a.get()) == null) {
                return;
            }
            String str = tbImageView.mUrl;
            int i = tbImageView.mType;
            String str2 = (String) customResponsedMessage.getData();
            String genCacheKey = BdResourceLoader.getInstance().genCacheKey(str, i);
            if (genCacheKey != null && genCacheKey.equals(str2)) {
                tbImageView.destroyDrawingCache();
                tbImageView.invalidate();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsPageIdRegisterMessage = false;
        this.mType = 10;
        this.mLoadingDefaultId = R.drawable.img_loading;
        this.mDefaultId = R.color.transparent;
        this.mDefaultBgId = R.color.CAM_X0205;
        this.mIsGifPic = false;
        this.mIsGif = false;
        this.isLongPic = false;
        this.isBitmapPic = false;
        this.isSmartCrop = false;
        this.mSupportNoImage = false;
        this.mAutoChangeStyle = true;
        this.mUseNightOrDarkMask = true;
        this.mSkinType = 3;
        this.mClipRect = new RectF();
        this.mClipPath = new Path();
        this.mRoundRect = new RectF();
        this.mMatrix = new Matrix();
        this.mDrawCorner = false;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPicReq = false;
        this.mCallback = new a(this);
        this.onInterceptDrawBackgoundListener = new b(this);
        this.listener = new g(this, 2016308);
        init();
    }

    private void onDrawNoConrer(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, canvas) == null) {
            if (!this.isBitmapPic && getBdImage() == null) {
                return;
            }
            if (this.mConrers == 0 && !getDrawCorner()) {
                return;
            }
            setDrawerType(1);
            int i = this.mConrers ^ 15;
            this.mRoundRect.set(0.0f, 0.0f, getWidth(), getHeight());
            if ((i & 1) != 0) {
                float[] fArr = this.mArgs.a;
                canvas.drawRect(0.0f, 0.0f, fArr[0], fArr[1], this.mDrawer.c);
            }
            if ((i & 2) != 0) {
                float f2 = this.mRoundRect.right;
                float[] fArr2 = this.mArgs.a;
                canvas.drawRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], this.mDrawer.c);
            }
            if ((i & 4) != 0) {
                float f3 = this.mRoundRect.bottom;
                float[] fArr3 = this.mArgs.a;
                canvas.drawRect(0.0f, f3 - fArr3[5], fArr3[4], f3, this.mDrawer.c);
            }
            if ((i & 8) != 0) {
                RectF rectF = this.mRoundRect;
                float f4 = rectF.right;
                float[] fArr4 = this.mArgs.a;
                float f5 = rectF.bottom;
                canvas.drawRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, this.mDrawer.c);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIsPageIdRegisterMessage = false;
        this.mType = 10;
        this.mLoadingDefaultId = R.drawable.img_loading;
        this.mDefaultId = R.color.transparent;
        this.mDefaultBgId = R.color.CAM_X0205;
        this.mIsGifPic = false;
        this.mIsGif = false;
        this.isLongPic = false;
        this.isBitmapPic = false;
        this.isSmartCrop = false;
        this.mSupportNoImage = false;
        this.mAutoChangeStyle = true;
        this.mUseNightOrDarkMask = true;
        this.mSkinType = 3;
        this.mClipRect = new RectF();
        this.mClipPath = new Path();
        this.mRoundRect = new RectF();
        this.mMatrix = new Matrix();
        this.mDrawCorner = false;
        this.mLoadedWidth = 0;
        this.mLoadedHeight = 0;
        this.isPicReq = false;
        this.mCallback = new a(this);
        this.onInterceptDrawBackgoundListener = new b(this);
        this.listener = new g(this, 2016308);
        init();
    }

    private void notifiyOnDrawListener(boolean z, Canvas canvas) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(65547, this, z, canvas) != null) || (hVar = this.mOnDrawListener) == null) {
            return;
        }
        if (z) {
            hVar.b(this, canvas);
        } else {
            hVar.a(this, canvas);
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        gv5 gv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048634, this, i, i2) == null) && (gv5Var = this.mTagDrawer) != null) {
            gv5Var.g(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processIsGifPic(BdImage bdImage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65550, this, bdImage) != null) || bdImage == null) {
            return;
        }
        this.mIsGif = bdImage.isGif();
    }

    public void addCornerFlags(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.mConrers = i | this.mConrers;
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            TbRichTextView.x xVar = this.mDispatchTouchListener;
            if (xVar != null) {
                xVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, canvas) == null) {
            updateSkinType();
            notifiyOnDrawListener(true, canvas);
            super.onDraw(canvas);
            onDrawNoConrer(canvas);
            onDrawNoConrerBorder(canvas);
            notifiyOnDrawListener(false, canvas);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (i != 8 && i != 4) {
                refresh();
            } else {
                stopLoad();
            }
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.mAutoChangeStyle = z;
        }
    }

    public void setConrers(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.mConrers = i;
        }
    }

    public void setContentColorFilter(ColorFilter colorFilter) {
        qf qfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, colorFilter) == null) && (qfVar = this.mDrawer) != null) {
            qfVar.n(colorFilter);
        }
    }

    public void setDefaultBgResource(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && this.mDefaultBgId != i) {
            this.mDefaultBgId = i;
            invalidate();
        }
    }

    public void setDefaultResource(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i) == null) && this.mDefaultId != i) {
            this.mDefaultId = i;
            invalidate();
        }
    }

    public void setDispatchTouchListener(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, xVar) == null) {
            this.mDispatchTouchListener = xVar;
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            super.setDrawBorder(z);
        }
    }

    public void setDrawCorner(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.mDrawCorner = z;
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            super.setDrawerType(i);
            qf qfVar = this.mDrawer;
            if (qfVar == null) {
                return;
            }
            qfVar.q(this.onInterceptDrawBackgoundListener);
        }
    }

    public void setEvent(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, fVar) == null) {
            this.mEvent = fVar;
        }
    }

    public void setInterceptOnClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.mInterceptOnClick = z;
        }
    }

    public void setIsBitmapPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.isBitmapPic = z;
        }
    }

    public void setIsGifPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.mIsGifPic = z;
        }
    }

    public void setIsLongPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.isLongPic = z;
        }
    }

    public void setIsSmartCrop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.isSmartCrop = z;
        }
    }

    public void setNeedNightShade(boolean z) {
        qf qfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z) == null) && (qfVar = this.mDrawer) != null) {
            qfVar.p(z);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onClickListener) == null) {
            if (this.mInternalGestureDetector == null) {
                this.mInternalGestureDetector = new yt9(new c(this));
            }
            super.setOnTouchListener(this.mInternalGestureDetector);
            if (!isClickable()) {
                setClickable(true);
            }
            this.mOnClickListener = onClickListener;
        }
    }

    public void setOnDrawListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, hVar) == null) {
            this.mOnDrawListener = hVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, bdUniqueId) == null) {
            this.mPageId = bdUniqueId;
            if (!this.mIsPageIdRegisterMessage && bdUniqueId != null) {
                this.listener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.listener);
                this.mIsPageIdRegisterMessage = true;
            }
        }
    }

    public void setSmartCropCenterPointHeightRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048629, this, f2) == null) {
            this.mSmartCropCenterPointHeightRatio = f2;
        }
    }

    public void setSmartCropCenterPointWidthRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048630, this, f2) == null) {
            this.mSmartCropCenterPointWidthRatio = f2;
        }
    }

    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.mSupportNoImage = z;
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, obj) == null) {
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
    }

    public void setTagColor(int i) {
        gv5 gv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048633, this, i) == null) && (gv5Var = this.mTagDrawer) != null) {
            gv5Var.h(i);
        }
    }

    public void setTagStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.mTagStr = str;
        }
    }

    public void setTagTextSize(int i) {
        gv5 gv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048636, this, i) == null) && (gv5Var = this.mTagDrawer) != null) {
            gv5Var.i(i);
        }
    }

    public void setTbGestureDetector(yt9 yt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, yt9Var) == null) {
            if (this.mInternalGestureDetector == null) {
                this.mInternalGestureDetector = new yt9(new d(this));
            }
            super.setOnTouchListener(this.mInternalGestureDetector);
            this.mGestureDetector = yt9Var;
        }
    }

    public void setUseNightOrDarkMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.mUseNightOrDarkMask = z;
        }
    }

    @Override // com.baidu.tieba.gu9
    public void startLoad(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            startLoad(str, 10, 0, 0, false);
        }
    }

    public static BdPageContext<?> getBbPageContext4TbImageView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof MutableContextWrapper) {
                context = ((MutableContextWrapper) context).getBaseContext();
            }
            if (context instanceof BdPageContext) {
                return (BdPageContext) context;
            }
            if (context instanceof BdPageContextSupport) {
                return ((BdPageContextSupport) context).getPageContext();
            }
            if (!(context instanceof TbPageContextSupport)) {
                return null;
            }
            return ((TbPageContextSupport) context).getPageContext();
        }
        return (BdPageContext) invokeL.objValue;
    }

    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            if (getBdImage() == null && getDrawable() == null && this.mInterceptOnClick) {
                startLoading();
                BdResourceLoader.getInstance().loadResource(this.mUrl, this.mType, this.mCallback, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.mOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public void setPlaceHolder(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
            if (i != 0) {
                if (i != 1) {
                    setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
                    return;
                } else {
                    setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_28_n));
                    return;
                }
            }
            setDefaultBgResource(SkinManager.getResourceId(R.drawable.transparent_bg));
        }
    }

    public void setPlaceHolderAutoChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
            if (i != 0) {
                if (i != 1) {
                    setDefaultBgResource(R.drawable.pic_use_header_40_n);
                    return;
                } else {
                    setDefaultBgResource(R.drawable.pic_use_header_28_n);
                    return;
                }
            }
            setDefaultBgResource(R.drawable.transparent_bg);
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65545, this) != null) || isInEditMode()) {
            return;
        }
        this.mRequestMap = new HashMap<>();
        this.mLogMap = new HashMap<>();
        this.mTagDrawer = new gv5(this);
        updateSkinType();
        this.mLoadingFrameIncrement = 30.0f;
        setConrers(0);
        if (this.mDrawer == null) {
            return;
        }
        this.isPicReq = PicReqSwitch.isOn();
        this.mDrawer.q(this.onInterceptDrawBackgoundListener);
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public BdImage getBdImage() {
        InterceptResult invokeV;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.isEmpty(this.mUrl)) {
                Object tag = getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    bdImage = TbImageMemoryCache.B().D(str);
                    if (bdImage == null) {
                        bdImage = TbImageMemoryCache.B().C(str);
                    }
                } else {
                    bdImage = null;
                }
            } else {
                bdImage = (BdImage) BdResourceLoader.getInstance().loadResourceFromMemery(this.mUrl, this.mType, new Object[0]);
            }
            if (bdImage != null) {
                processIsGifPic(bdImage);
            }
            return bdImage;
        }
        return (BdImage) invokeV.objValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onAttachedToWindow();
            if (isInEditMode()) {
                return;
            }
            BdPageContext<?> bbPageContext4TbImageView = getBbPageContext4TbImageView(getContext());
            if (this.mPageId != null) {
                this.mIsPageIdRegisterMessage = true;
            }
            if (bbPageContext4TbImageView != null) {
                CustomMessageListener customMessageListener = this.listener;
                BdUniqueId bdUniqueId = this.mPageId;
                if (bdUniqueId == null) {
                    bdUniqueId = bbPageContext4TbImageView.getUniqueId();
                }
                customMessageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.listener);
            getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.isPicReq) {
                this.mWidth = getMeasuredWidth();
                this.mHeight = getMeasuredHeight();
                Iterator<Map.Entry<String, e>> it = this.mRequestMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, e> next = it.next();
                    next.getKey();
                    e value = next.getValue();
                    it.remove();
                    BdResourceLoader.getInstance().loadResource(value.a, value.b, this.mCallback, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void run() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || !this.mShowLoading) {
            return;
        }
        float f2 = this.mCurrentDegrees;
        float f3 = this.mLoadingFrameIncrement;
        float f4 = f2 + f3;
        this.mCurrentDegrees = f4;
        if (f4 > 360.0f - f3) {
            this.mCurrentDegrees = 0.0f;
        }
        this.mMatrix.reset();
        this.mMatrix.postRotate(this.mCurrentDegrees, getWidth() / 2.0f, getHeight() / 2.0f);
        setExtraMatrix(this.mMatrix);
        invalidate();
        nextLoadingFrame();
    }

    private void nextLoadingFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    public void clearCornerFlag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mConrers = 0;
        }
    }

    public boolean getDrawCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mDrawCorner;
        }
        return invokeV.booleanValue;
    }

    public int getGifIconHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            gv5 gv5Var = this.mTagDrawer;
            if (gv5Var != null) {
                return (int) gv5Var.d(getContext().getString(R.string.icon_tag_gif));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getGifIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            gv5 gv5Var = this.mTagDrawer;
            if (gv5Var != null) {
                return (int) gv5Var.e(getContext().getString(R.string.icon_tag_gif));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getLoadedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mLoadedHeight;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getLoadedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mLoadedWidth;
        }
        return invokeV.intValue;
    }

    public View.OnClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mOnClickListener;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            if (drawerArgs == null) {
                return BDImageView.parseCornerRadii(0.0f);
            }
            return drawerArgs.a;
        }
        return (float[]) invokeV.objValue;
    }

    public float getSmartCropCenterPointHeightRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mSmartCropCenterPointHeightRatio;
        }
        return invokeV.floatValue;
    }

    public float getSmartCropCenterPointWidthRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mSmartCropCenterPointWidthRatio;
        }
        return invokeV.floatValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mUrl;
        }
        return (String) invokeV.objValue;
    }

    public boolean isGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mIsGif;
        }
        return invokeV.booleanValue;
    }

    public boolean isLongPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.isLongPic;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mShowLoading;
        }
        return invokeV.booleanValue;
    }

    public boolean isSmartCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.isSmartCrop;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDetachedFromWindow();
            getViewTreeObserver().removeOnPreDrawListener(this);
            this.mIsPageIdRegisterMessage = false;
            stopLoad();
            MessageManager.getInstance().unRegisterListener(this.listener);
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onStartTemporaryDetach();
            stopLoad();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            startLoad(this.mUrl, this.mType, this.mWidth, this.mHeight, false);
            invalidate();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            setTag(null);
            this.mUrl = null;
            this.mIsGif = false;
            this.isLongPic = false;
            this.mIsGifPic = false;
        }
    }

    public void startLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.mShowLoading = true;
            nextLoadingFrame();
        }
    }

    public void stopLoading() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048647, this) != null) || !this.mShowLoading) {
            return;
        }
        this.mShowLoading = false;
        removeCallbacks(this);
        this.mCurrentDegrees = 0.0f;
        this.mMatrix.reset();
        setExtraMatrix(this.mMatrix);
    }

    private void onDrawNoConrerBorder(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, canvas) == null) {
            if (!this.isBitmapPic && getBdImage() == null) {
                return;
            }
            if (this.mConrers == 0 && !getDrawBorder()) {
                return;
            }
            setDrawerType(1);
            int i = this.mConrers ^ 15;
            this.mRoundRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.mDrawer.d.setStrokeWidth(this.mDrawer.d.getStrokeWidth());
            if ((i & 1) != 0) {
                canvas.drawLine(0.0f, 0.0f, this.mArgs.a[0], 0.0f, this.mDrawer.d);
                canvas.drawLine(0.0f, 0.0f, 0.0f, this.mArgs.a[1], this.mDrawer.d);
            }
            if ((i & 2) != 0) {
                float f2 = this.mRoundRect.right;
                canvas.drawLine(f2 - this.mArgs.a[2], 0.0f, f2, 0.0f, this.mDrawer.d);
                float f3 = this.mRoundRect.right;
                canvas.drawLine(f3, 0.0f, f3, this.mArgs.a[3], this.mDrawer.d);
            }
            if ((i & 4) != 0) {
                float f4 = this.mRoundRect.bottom;
                canvas.drawLine(0.0f, f4 - this.mArgs.a[5], 0.0f, f4, this.mDrawer.d);
                float f5 = this.mRoundRect.bottom;
                canvas.drawLine(0.0f, f5, this.mArgs.a[4], f5, this.mDrawer.d);
            }
            if ((i & 8) != 0) {
                RectF rectF = this.mRoundRect;
                float f6 = rectF.right;
                float f7 = rectF.bottom;
                canvas.drawLine(f6 - this.mArgs.a[6], f7, f6, f7, this.mDrawer.d);
                RectF rectF2 = this.mRoundRect;
                float f8 = rectF2.right;
                float f9 = rectF2.bottom;
                canvas.drawLine(f8, f9, f8, f9 - this.mArgs.a[7], this.mDrawer.d);
            }
        }
    }

    private void updateSkinType() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (this.mAutoChangeStyle && this.mUseNightOrDarkMask) {
                if (TbadkCoreApplication.getInst().getSkinType() != 4) {
                    this.mArgs.f = DrawerArgs.SkinType.DAY;
                } else {
                    this.mArgs.f = DrawerArgs.SkinType.DARK;
                }
            } else {
                this.mArgs.f = DrawerArgs.SkinType.DAY;
            }
            if (this.mShowLoading) {
                i = this.mLoadingDefaultId;
            } else {
                i = this.mDefaultId;
            }
            if (i != this.mCurrentDefaultId) {
                this.mCurrentDefaultId = i;
                this.mNeedRecomputeMatrix = true;
            }
            int i2 = this.mDefaultBgId;
            if (i2 > 0) {
                if (this.mAutoChangeStyle) {
                    setDefaultBg(SkinManager.getDrawable(i2));
                } else {
                    setDefaultBg(getResources().getDrawable(this.mDefaultBgId));
                }
            } else {
                setDefaultBg(null);
            }
            if (this.mAutoChangeStyle) {
                this.mTagDrawer.j(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void clearLoadingAnimation() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        BdResourceLoader.getInstance().cancelLoad(this.mUrl, this.mType, this.mCallback);
        if (TextUtils.isEmpty(this.mUrl) || isShowLoading()) {
            stopLoading();
        }
    }

    public void stopLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048646, this) != null) || TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        BdResourceLoader.getInstance().cancelLoad(this.mUrl, this.mType, this.mCallback);
        this.mLogMap.remove(BdResourceLoader.getInstance().genCacheKey(this.mUrl, this.mType));
        stopLoading();
    }

    public void drawBackground(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, canvas, drawable) == null) {
            canvas.save();
            this.mClipPath.reset();
            this.mClipRect.right = getWidth();
            this.mClipRect.bottom = getHeight();
            this.mClipPath.addRoundRect(this.mClipRect, this.mArgs.a, Path.Direction.CW);
            int i = this.mConrers ^ 15;
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            if ((i & 1) != 0) {
                Path path = this.mClipPath;
                float[] fArr = this.mArgs.a;
                path.addRect(0.0f, 0.0f, fArr[0], fArr[1], Path.Direction.CW);
            }
            if ((i & 2) != 0) {
                Path path2 = this.mClipPath;
                float f2 = rectF.right;
                float[] fArr2 = this.mArgs.a;
                path2.addRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], Path.Direction.CW);
            }
            if ((i & 4) != 0) {
                Path path3 = this.mClipPath;
                float f3 = rectF.bottom;
                float[] fArr3 = this.mArgs.a;
                path3.addRect(0.0f, f3 - fArr3[5], fArr3[4], f3, Path.Direction.CW);
            }
            if ((i & 8) != 0) {
                Path path4 = this.mClipPath;
                float f4 = rectF.right;
                float[] fArr4 = this.mArgs.a;
                float f5 = rectF.bottom;
                path4.addRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, Path.Direction.CW);
            }
            if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
                canvas.clipPath(this.mClipPath);
            }
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void drawContentTag(Canvas canvas, ImageView imageView) {
        DrawerArgs drawerArgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, canvas, imageView) == null) {
            super.drawContentTag(canvas, imageView);
            if (this.mTagDrawer != null && (drawerArgs = this.mArgs) != null) {
                if (drawerArgs.i && (this.mIsGifPic || isGif())) {
                    this.mTagDrawer.a(canvas, getContext().getString(R.string.icon_tag_gif), true);
                } else if (this.mArgs.h && isLongPic()) {
                    this.mTagDrawer.a(canvas, getContext().getString(R.string.icon_tag_long), true);
                } else {
                    String str = this.mTagStr;
                    if (str != null) {
                        this.mTagDrawer.a(canvas, str, false);
                    }
                }
                int i = this.mArgs.j;
                if (i == rf.c) {
                    this.mTagDrawer.b(canvas, getContext().getString(R.string.wonderful_comment), R.color.CAM_X0305);
                } else if (i == rf.b) {
                    this.mTagDrawer.b(canvas, getContext().getString(R.string.god_level_comment), R.color.CAM_X0310);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public BdImage getDefaultBdImage() {
        InterceptResult invokeV;
        SoftReference<BdImage> softReference;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (sDefaultBdImageCache == null) {
                sDefaultBdImageCache = new HashMap<>();
            }
            String valueOf = String.valueOf(this.mCurrentDefaultId);
            if (this.mAutoChangeStyle && TbadkCoreApplication.getInst().getSkinType() == 4) {
                valueOf = valueOf + "_2";
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mNeedRecomputeMatrix = true;
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            }
            if (sDefaultBdImageCache.containsKey(valueOf) && (softReference = sDefaultBdImageCache.get(valueOf)) != null && (bdImage = softReference.get()) != null && bdImage.isValidNow()) {
                return bdImage;
            }
            Bitmap bitmap = null;
            int i = this.mCurrentDefaultId;
            if (i > 0) {
                if (this.mAutoChangeStyle) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                        int i2 = this.mCurrentDefaultId;
                        if (i2 == R.color.transparent) {
                            bitmap = SkinManager.getTbDefaultBitmap();
                        } else {
                            bitmap = SkinManager.getBitmap(i2);
                        }
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.mCurrentDefaultId);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.mCurrentDefaultId);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(i);
                }
            }
            BdImage bdImage2 = new BdImage(bitmap, false, String.valueOf(this.mCurrentDefaultId));
            sDefaultBdImageCache.put(valueOf, new SoftReference<>(bdImage2));
            return bdImage2;
        }
        return (BdImage) invokeV.objValue;
    }

    public void startLoad(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            z4 c2 = a5.c(getContext());
            if (c2 != null) {
                BdUniqueId bdUniqueId2 = this.mPageId;
                if (bdUniqueId2 == null) {
                    bdUniqueId2 = c2.getUniqueId();
                }
                z2 = c2.isScroll();
                bdUniqueId = bdUniqueId2;
            } else {
                bdUniqueId = null;
                z2 = false;
            }
            startLoad(str, i, i2, i3, z, bdUniqueId, z2);
        }
    }

    public void startLoad(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), bdUniqueId, Boolean.valueOf(z2)}) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mUrl = str;
                int i4 = this.mSkinType;
                if (i4 != 3 && i4 != TbadkCoreApplication.getInst().getSkinType()) {
                    invalidate();
                    return;
                }
                return;
            }
            if (str.equals(this.mUrl) && i == this.mType && bdUniqueId == this.mPageId) {
                z3 = true;
            } else {
                z3 = false;
            }
            BdImage bdImage = getBdImage();
            if (!z3) {
                clearLoadingAnimation();
                this.mNeedRecomputeMatrix = true;
                this.mIsGif = false;
                requestLayout();
            } else if (bdImage != null) {
                invalidate();
                this.mLoadedWidth = bdImage.getWidth();
                this.mLoadedHeight = bdImage.getHeight();
                f fVar = this.mEvent;
                if (fVar != null) {
                    fVar.a(str, true);
                    return;
                }
                return;
            }
            this.mUrl = str;
            this.mType = i;
            this.mPageId = bdUniqueId;
            this.mNeedRecomputeMatrix = true;
            if (!this.isPicReq) {
                this.mWidth = i2;
                this.mHeight = i3;
            }
            if (z2) {
                invalidate();
            } else if (!BdResourceLoader.getInstance().isNeedLoad(this.mType) && this.mSupportNoImage) {
                invalidate();
            } else {
                if (z) {
                    startLoading();
                }
                String genCacheKey = BdResourceLoader.getInstance().genCacheKey(str, i);
                e eVar = new e(this);
                eVar.a = str;
                eVar.b = i;
                eVar.c = System.currentTimeMillis();
                this.mLogMap.put(genCacheKey, eVar);
                if (this.isPicReq) {
                    String genCacheKey2 = BdResourceLoader.getInstance().genCacheKey(str, i);
                    if (!this.mRequestMap.containsKey(genCacheKey2)) {
                        e eVar2 = new e(this);
                        eVar2.a = str;
                        eVar2.b = i;
                        this.mRequestMap.put(genCacheKey2, eVar2);
                        return;
                    }
                    return;
                }
                BdResourceLoader.getInstance().loadResource(this.mUrl, this.mType, this.mCallback, i2, i3, this.mPageId, new Object[0]);
            }
        }
    }

    public void startLoad(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            z4 c2 = a5.c(getContext());
            if (c2 != null) {
                BdUniqueId bdUniqueId2 = this.mPageId;
                if (bdUniqueId2 == null) {
                    bdUniqueId2 = c2.getUniqueId();
                }
                bdUniqueId = bdUniqueId2;
            } else {
                bdUniqueId = null;
            }
            startLoad(str, i, i2, i3, z, bdUniqueId, z2);
        }
    }

    @Override // com.baidu.tieba.gu9
    public void startLoad(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            startLoad(str, i, 0, 0, z);
        }
    }

    public void startLoad(String str, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            startLoad(str, i, 0, 0, z, z2);
        }
    }
}

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
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.i;
import c.a.e.a.j;
import c.a.e.f.a.a;
import c.a.p0.i2.i.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class TbImageView extends BDImageView implements Runnable, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CORNER_ALL = 15;
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_NONE = 0;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    public static HashMap<String, SoftReference<c.a.e.k.d.a>> N = null;
    public static final int PLACE_HOLDER_HUAJI_BIG = 3;
    public static final int PLACE_HOLDER_HUAJI_MIDDLE = 2;
    public static final int PLACE_HOLDER_HUAJI_NONE = 0;
    public static final int PLACE_HOLDER_HUAJI_SMALL = 1;
    public static final int PLACE_HOLDER_HUAJI_SUPER_BIG = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public RectF B;
    public Path C;
    public RectF D;
    public final Matrix E;
    public c.a.o0.d1.c F;
    public String G;
    public boolean H;
    public int I;
    public int J;
    public final c.a.p0.i2.i.c K;
    public a.InterfaceC0051a L;
    public CustomMessageListener M;
    public boolean isBitmapPic;
    public boolean isLongPic;
    public boolean isSmartCrop;
    public final c.a.e.e.l.c<c.a.e.k.d.a> mCallback;
    public int mConrers;
    public int mDefaultId;
    public f mEvent;
    public int mHeight;
    public boolean mIsGif;
    public boolean mIsGifPic;
    public HashMap<String, e> mLogMap;
    public g mOnDrawListener;
    public BdUniqueId mPageId;
    public HashMap<String, e> mRequestMap;
    public float mSmartCropCenterPointHeightRatio;
    public float mSmartCropCenterPointWidthRatio;
    public boolean mSupportNoImage;
    public int mType;
    public String mUrl;
    public int mWidth;
    public boolean o;
    public boolean p;
    public float q;
    public float r;
    public final int s;
    public int t;
    public int u;
    public boolean v;
    public int w;
    public View.OnClickListener x;
    public c.a.p0.i2.i.c y;
    public TbRichTextView.x z;

    /* loaded from: classes6.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f48368a;

        public a(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48368a = tbImageView;
        }

        @Override // c.a.p0.i2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.i2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f48368a.getBdImage() != null || this.f48368a.getDrawable() != null || !this.f48368a.A) {
                    if (this.f48368a.x != null) {
                        this.f48368a.x.onClick(view);
                        return true;
                    } else if (this.f48368a.y != null) {
                        this.f48368a.y.a(view);
                        return this.f48368a.y.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                this.f48368a.startLoading();
                c.a.e.e.l.d h2 = c.a.e.e.l.d.h();
                TbImageView tbImageView = this.f48368a;
                h2.k(tbImageView.mUrl, tbImageView.mType, tbImageView.mCallback, tbImageView.mWidth, tbImageView.mHeight, tbImageView.mPageId, new Object[0]);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.i2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.f48368a.y != null) {
                    this.f48368a.y.a(view);
                    return this.f48368a.y.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.e.e.l.c<c.a.e.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f48369a;

        public b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48369a = tbImageView;
        }

        @Override // c.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                this.f48369a.stopLoading();
                f fVar = this.f48369a.mEvent;
                if (fVar != null) {
                    fVar.onCancel();
                }
            }
        }

        @Override // c.a.e.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                if (aVar != null) {
                    this.f48369a.I = aVar.r();
                    this.f48369a.J = aVar.m();
                    c.a.e.e.l.d h2 = c.a.e.e.l.d.h();
                    TbImageView tbImageView = this.f48369a;
                    String g2 = h2.g(tbImageView.mUrl, tbImageView.mType);
                    e eVar = this.f48369a.mLogMap.get(g2);
                    if (eVar != null) {
                        c.a.e.e.l.a.d(i2 == 1, i2 == 2, i2 == 3);
                        if (i2 == 3) {
                            c.a.e.e.l.a.e(true, System.currentTimeMillis() - eVar.f48374c);
                        }
                        this.f48369a.mLogMap.remove(g2);
                    }
                }
                this.f48369a.stopLoading();
                this.f48369a.q(aVar);
                f fVar = this.f48369a.mEvent;
                if (fVar != null) {
                    fVar.a(str, aVar != null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.InterfaceC0051a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f48370a;

        public c(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48370a = tbImageView;
        }

        @Override // c.a.e.f.a.a.InterfaceC0051a
        public boolean a(Canvas canvas, Drawable drawable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, canvas, drawable)) == null) {
                if (this.f48370a.getBdImage() == null && this.f48370a.H) {
                    this.f48370a.drawBackground(canvas, drawable);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f48371a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TbImageView tbImageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48371a = tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                c.a.e.e.l.d h2 = c.a.e.e.l.d.h();
                TbImageView tbImageView = this.f48371a;
                String g2 = h2.g(tbImageView.mUrl, tbImageView.mType);
                if (g2 == null || !g2.equals(str)) {
                    return;
                }
                this.f48371a.destroyDrawingCache();
                this.f48371a.invalidate();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f48372a;

        /* renamed from: b  reason: collision with root package name */
        public int f48373b;

        /* renamed from: c  reason: collision with root package name */
        public long f48374c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TbImageView f48375d;

        public e(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48375d = tbImageView;
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(String str, boolean z);

        void onCancel();
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a(TbImageView tbImageView, Canvas canvas);

        void b(TbImageView tbImageView, Canvas canvas);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.mType = 10;
        this.s = R.drawable.img_loading;
        this.mDefaultId = R.color.transparent;
        this.t = R.color.CAM_X0205;
        this.mIsGifPic = false;
        this.mIsGif = false;
        this.isLongPic = false;
        this.isBitmapPic = false;
        this.isSmartCrop = false;
        this.mSupportNoImage = false;
        this.v = true;
        this.w = 3;
        this.B = new RectF();
        this.C = new Path();
        this.D = new RectF();
        this.E = new Matrix();
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = new c.a.p0.i2.i.c(new a(this));
        this.mCallback = new b(this);
        this.L = new c(this);
        this.M = new d(this, 2016308);
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.mRequestMap = new HashMap<>();
            this.mLogMap = new HashMap<>();
            this.F = new c.a.o0.d1.c(this);
            r();
            this.q = 30.0f;
            setConrers(0);
            c.a.e.f.a.a aVar = this.mDrawer;
            if (aVar == null) {
                return;
            }
            aVar.o(this.L);
        }
    }

    public void addCornerFlags(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.mConrers = i2 | this.mConrers;
        }
    }

    public void clearCornerFlag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mConrers = 0;
        }
    }

    public void clearLoadingAnimation() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        c.a.e.e.l.d.h().d(this.mUrl, this.mType, this.mCallback);
        if (TextUtils.isEmpty(this.mUrl) || isShowLoading()) {
            stopLoading();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            TbRichTextView.x xVar = this.z;
            if (xVar != null) {
                xVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void drawBackground(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, canvas, drawable) == null) {
            canvas.save();
            this.C.reset();
            this.B.right = getWidth();
            this.B.bottom = getHeight();
            this.C.addRoundRect(this.B, this.mArgs.f2662a, Path.Direction.CW);
            int i2 = this.mConrers ^ 15;
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            if ((i2 & 1) != 0) {
                Path path = this.C;
                float[] fArr = this.mArgs.f2662a;
                path.addRect(0.0f, 0.0f, fArr[0], fArr[1], Path.Direction.CW);
            }
            if ((i2 & 2) != 0) {
                Path path2 = this.C;
                float f2 = rectF.right;
                float[] fArr2 = this.mArgs.f2662a;
                path2.addRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], Path.Direction.CW);
            }
            if ((i2 & 4) != 0) {
                Path path3 = this.C;
                float f3 = rectF.bottom;
                float[] fArr3 = this.mArgs.f2662a;
                path3.addRect(0.0f, f3 - fArr3[5], fArr3[4], f3, Path.Direction.CW);
            }
            if ((i2 & 8) != 0) {
                Path path4 = this.C;
                float f4 = rectF.right;
                float[] fArr4 = this.mArgs.f2662a;
                float f5 = rectF.bottom;
                path4.addRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, Path.Direction.CW);
            }
            if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
                canvas.clipPath(this.C);
            }
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void drawContentTag(Canvas canvas, ImageView imageView) {
        c.a.e.f.a.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, canvas, imageView) == null) {
            super.drawContentTag(canvas, imageView);
            if (this.F == null || (eVar = this.mArgs) == null) {
                return;
            }
            if (eVar.f2670i && (this.mIsGifPic || isGif())) {
                this.F.a(canvas, getContext().getString(R.string.icon_tag_gif), true);
            } else if (this.mArgs.f2669h && isLongPic()) {
                this.F.a(canvas, getContext().getString(R.string.icon_tag_long), true);
            } else {
                String str = this.G;
                if (str != null) {
                    this.F.a(canvas, str, false);
                }
            }
            int i2 = this.mArgs.f2671j;
            if (i2 == c.a.e.f.a.b.f2658c) {
                this.F.b(canvas, getContext().getString(R.string.wonderful_comment), R.color.CAM_X0305);
            } else if (i2 == c.a.e.f.a.b.f2657b) {
                this.F.b(canvas, getContext().getString(R.string.god_level_comment), R.color.CAM_X0310);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public c.a.e.k.d.a getBdImage() {
        InterceptResult invokeV;
        c.a.e.k.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.isEmpty(this.mUrl)) {
                Object tag = getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    aVar = c.a.o0.b0.c.k().m(str);
                    if (aVar == null) {
                        aVar = c.a.o0.b0.c.k().l(str);
                    }
                } else {
                    aVar = null;
                }
            } else {
                aVar = (c.a.e.k.d.a) c.a.e.e.l.d.h().n(this.mUrl, this.mType, new Object[0]);
            }
            if (aVar != null) {
                q(aVar);
            }
            return aVar;
        }
        return (c.a.e.k.d.a) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public c.a.e.k.d.a getDefaultBdImage() {
        InterceptResult invokeV;
        SoftReference<c.a.e.k.d.a> softReference;
        c.a.e.k.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (N == null) {
                N = new HashMap<>();
            }
            String valueOf = String.valueOf(this.u);
            if (this.v) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    valueOf = valueOf + SkinManager.nightSufix;
                } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    valueOf = valueOf + SkinManager.darkSuffix;
                }
            }
            if (this.w != TbadkCoreApplication.getInst().getSkinType()) {
                this.mNeedRecomputeMatrix = true;
                this.w = TbadkCoreApplication.getInst().getSkinType();
            }
            if (!N.containsKey(valueOf) || (softReference = N.get(valueOf)) == null || (aVar = softReference.get()) == null || !aVar.w()) {
                Bitmap bitmap = null;
                int i2 = this.u;
                if (i2 > 0) {
                    if (this.v) {
                        if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                            bitmap = BitmapHelper.getCashBitmap(this.u);
                        } else {
                            bitmap = SkinManager.getBitmap(this.u);
                            if (bitmap == null) {
                                bitmap = BitmapHelper.getCashBitmap(this.u);
                            }
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(i2);
                    }
                }
                c.a.e.k.d.a aVar2 = new c.a.e.k.d.a(bitmap, false, String.valueOf(this.u));
                N.put(valueOf, new SoftReference<>(aVar2));
                return aVar2;
            }
            return aVar;
        }
        return (c.a.e.k.d.a) invokeV.objValue;
    }

    public boolean getDrawCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public int getGifIconHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.o0.d1.c cVar = this.F;
            if (cVar != null) {
                return (int) cVar.d(getContext().getString(R.string.icon_tag_gif));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getGifIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.o0.d1.c cVar = this.F;
            if (cVar != null) {
                return (int) cVar.e(getContext().getString(R.string.icon_tag_gif));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getLoadedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.J : invokeV.intValue;
    }

    @Deprecated
    public int getLoadedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.I : invokeV.intValue;
    }

    public View.OnClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.x : (View.OnClickListener) invokeV.objValue;
    }

    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.e.f.a.e eVar = this.mArgs;
            return eVar == null ? BDImageView.parseCornerRadii(0.0f) : eVar.f2662a;
        }
        return (float[]) invokeV.objValue;
    }

    public float getSmartCropCenterPointHeightRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mSmartCropCenterPointHeightRatio : invokeV.floatValue;
    }

    public float getSmartCropCenterPointWidthRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mSmartCropCenterPointWidthRatio : invokeV.floatValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    public boolean isGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mIsGif : invokeV.booleanValue;
    }

    public boolean isLongPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.isLongPic : invokeV.booleanValue;
    }

    public boolean isShowLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean isSmartCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.isSmartCrop : invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    public final void n(boolean z, Canvas canvas) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048599, this, z, canvas) == null) || (gVar = this.mOnDrawListener) == null) {
            return;
        }
        if (z) {
            gVar.b(this, canvas);
        } else {
            gVar.a(this, canvas);
        }
    }

    public final void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, canvas) == null) {
            if (this.isBitmapPic || getBdImage() != null) {
                if (this.mConrers != 0 || getDrawCorner()) {
                    setDrawerType(1);
                    int i2 = this.mConrers ^ 15;
                    this.D.set(0.0f, 0.0f, getWidth(), getHeight());
                    if ((i2 & 1) != 0) {
                        float[] fArr = this.mArgs.f2662a;
                        canvas.drawRect(0.0f, 0.0f, fArr[0], fArr[1], this.mDrawer.f2647b);
                    }
                    if ((i2 & 2) != 0) {
                        float f2 = this.D.right;
                        float[] fArr2 = this.mArgs.f2662a;
                        canvas.drawRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], this.mDrawer.f2647b);
                    }
                    if ((i2 & 4) != 0) {
                        float f3 = this.D.bottom;
                        float[] fArr3 = this.mArgs.f2662a;
                        canvas.drawRect(0.0f, f3 - fArr3[5], fArr3[4], f3, this.mDrawer.f2647b);
                    }
                    if ((i2 & 8) != 0) {
                        RectF rectF = this.D;
                        float f4 = rectF.right;
                        float[] fArr4 = this.mArgs.f2662a;
                        float f5 = rectF.bottom;
                        canvas.drawRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, this.mDrawer.f2647b);
                    }
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onAttachedToWindow();
            c.a.e.a.f<?> a2 = j.a(getContext());
            if (this.mPageId != null) {
                this.o = true;
            }
            if (a2 != null) {
                CustomMessageListener customMessageListener = this.M;
                BdUniqueId bdUniqueId = this.mPageId;
                if (bdUniqueId == null) {
                    bdUniqueId = a2.getUniqueId();
                }
                customMessageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.M);
            getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view) == null) {
            if (getBdImage() == null && getDrawable() == null && this.A) {
                startLoading();
                c.a.e.e.l.d.h().k(this.mUrl, this.mType, this.mCallback, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.x;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDetachedFromWindow();
            getViewTreeObserver().removeOnPreDrawListener(this);
            this.o = false;
            stopLoad();
            MessageManager.getInstance().unRegisterListener(this.M);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, canvas) == null) {
            r();
            n(true, canvas);
            super.onDraw(canvas);
            o(canvas);
            p(canvas);
            n(false, canvas);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                this.mWidth = getMeasuredWidth();
                this.mHeight = getMeasuredHeight();
                Iterator<Map.Entry<String, e>> it = this.mRequestMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, e> next = it.next();
                    next.getKey();
                    e value = next.getValue();
                    it.remove();
                    c.a.e.e.l.d.h().k(value.f48372a, value.f48373b, this.mCallback, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onStartTemporaryDetach();
            stopLoad();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 != 8 && i2 != 4) {
                refresh();
            } else {
                stopLoad();
            }
        }
    }

    public final void p(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, canvas) == null) {
            if (this.isBitmapPic || getBdImage() != null) {
                if (this.mConrers != 0 || getDrawBorder()) {
                    setDrawerType(1);
                    int i2 = this.mConrers ^ 15;
                    this.D.set(0.0f, 0.0f, getWidth(), getHeight());
                    this.mDrawer.f2648c.setStrokeWidth(this.mDrawer.f2648c.getStrokeWidth());
                    if ((i2 & 1) != 0) {
                        canvas.drawLine(0.0f, 0.0f, this.mArgs.f2662a[0], 0.0f, this.mDrawer.f2648c);
                        canvas.drawLine(0.0f, 0.0f, 0.0f, this.mArgs.f2662a[1], this.mDrawer.f2648c);
                    }
                    if ((i2 & 2) != 0) {
                        float f2 = this.D.right;
                        canvas.drawLine(f2 - this.mArgs.f2662a[2], 0.0f, f2, 0.0f, this.mDrawer.f2648c);
                        float f3 = this.D.right;
                        canvas.drawLine(f3, 0.0f, f3, this.mArgs.f2662a[3], this.mDrawer.f2648c);
                    }
                    if ((i2 & 4) != 0) {
                        float f4 = this.D.bottom;
                        canvas.drawLine(0.0f, f4 - this.mArgs.f2662a[5], 0.0f, f4, this.mDrawer.f2648c);
                        float f5 = this.D.bottom;
                        canvas.drawLine(0.0f, f5, this.mArgs.f2662a[4], f5, this.mDrawer.f2648c);
                    }
                    if ((i2 & 8) != 0) {
                        RectF rectF = this.D;
                        float f6 = rectF.right;
                        float f7 = rectF.bottom;
                        canvas.drawLine(f6 - this.mArgs.f2662a[6], f7, f6, f7, this.mDrawer.f2648c);
                        RectF rectF2 = this.D;
                        float f8 = rectF2.right;
                        float f9 = rectF2.bottom;
                        canvas.drawLine(f8, f9, f8, f9 - this.mArgs.f2662a[7], this.mDrawer.f2648c);
                    }
                }
            }
        }
    }

    public final void q(c.a.e.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, aVar) == null) || aVar == null) {
            return;
        }
        this.mIsGif = aVar.t();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            boolean z = false;
            if (this.v) {
                this.mArgs.f2667f = (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true;
            } else {
                this.mArgs.f2667f = false;
            }
            int i2 = this.p ? this.s : this.mDefaultId;
            if (i2 != this.u) {
                this.u = i2;
                this.mNeedRecomputeMatrix = true;
            }
            int i3 = this.t;
            if (i3 > 0) {
                if (this.v) {
                    setDefaultBg(SkinManager.getDrawable(i3));
                } else {
                    setDefaultBg(getResources().getDrawable(this.t));
                }
            } else {
                setDefaultBg(null);
            }
            if (this.v) {
                this.F.j(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, c.a.e.f.a.i
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            startLoad(this.mUrl, this.mType, this.mWidth, this.mHeight, false);
            invalidate();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            setTag(null);
            this.mUrl = null;
            this.mIsGif = false;
            this.isLongPic = false;
            this.mIsGifPic = false;
        }
    }

    public void run() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.p) {
            float f2 = this.r;
            float f3 = this.q;
            float f4 = f2 + f3;
            this.r = f4;
            if (f4 > 360.0f - f3) {
                this.r = 0.0f;
            }
            this.E.reset();
            this.E.postRotate(this.r, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.E);
            invalidate();
            m();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.v = z;
        }
    }

    public void setConrers(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.mConrers = i2;
        }
    }

    public void setDefaultBgResource(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i2) == null) || this.t == i2) {
            return;
        }
        this.t = i2;
        invalidate();
    }

    public void setDefaultResource(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048617, this, i2) == null) || this.mDefaultId == i2) {
            return;
        }
        this.mDefaultId = i2;
        invalidate();
    }

    public void setDispatchTouchListener(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, xVar) == null) {
            this.z = xVar;
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            super.setDrawBorder(z);
        }
    }

    public void setDrawCorner(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.H = z;
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            super.setDrawerType(i2);
            c.a.e.f.a.a aVar = this.mDrawer;
            if (aVar == null) {
                return;
            }
            aVar.o(this.L);
        }
    }

    public void setEvent(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, fVar) == null) {
            this.mEvent = fVar;
        }
    }

    public void setInterceptOnClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.A = z;
        }
    }

    public void setIsBitmapPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.isBitmapPic = z;
        }
    }

    public void setIsGifPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.mIsGifPic = z;
        }
    }

    public void setIsLongPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.isLongPic = z;
        }
    }

    public void setIsSmartCrop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.isSmartCrop = z;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, onClickListener) == null) {
            super.setOnTouchListener(this.K);
            if (!isClickable()) {
                setClickable(true);
            }
            this.x = onClickListener;
        }
    }

    public void setOnDrawListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, gVar) == null) {
            this.mOnDrawListener = gVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, bdUniqueId) == null) {
            this.mPageId = bdUniqueId;
            if (this.o || bdUniqueId == null) {
                return;
            }
            this.M.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.M);
            this.o = true;
        }
    }

    public void setPlaceHolder(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
            if (i2 == 0) {
                setDefaultBgResource(SkinManager.getResourceId(R.drawable.transparent_bg));
            } else if (i2 != 1) {
                setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
            } else {
                setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_28_n));
            }
        }
    }

    public void setPlaceHolderAutoChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
            if (i2 == 0) {
                setDefaultBgResource(R.drawable.transparent_bg);
            } else if (i2 != 1) {
                setDefaultBgResource(R.drawable.pic_use_header_40_n);
            } else {
                setDefaultBgResource(R.drawable.pic_use_header_28_n);
            }
        }
    }

    public void setSmartCropCenterPointHeightRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048633, this, f2) == null) {
            this.mSmartCropCenterPointHeightRatio = f2;
        }
    }

    public void setSmartCropCenterPointWidthRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048634, this, f2) == null) {
            this.mSmartCropCenterPointWidthRatio = f2;
        }
    }

    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.mSupportNoImage = z;
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, obj) == null) {
            Object tag = getTag();
            super.setTag(obj);
            if (obj == null) {
                if (tag != null) {
                    this.mNeedRecomputeMatrix = true;
                    requestLayout();
                }
            } else if (obj.equals(tag)) {
            } else {
                this.mNeedRecomputeMatrix = true;
                requestLayout();
            }
        }
    }

    public void setTagColor(int i2) {
        c.a.o0.d1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048637, this, i2) == null) || (cVar = this.F) == null) {
            return;
        }
        cVar.h(i2);
    }

    public void setTagPaddingDis(int i2, int i3) {
        c.a.o0.d1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048638, this, i2, i3) == null) || (cVar = this.F) == null) {
            return;
        }
        cVar.g(i2, i3);
    }

    public void setTagStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.G = str;
        }
    }

    public void setTagTextSize(int i2) {
        c.a.o0.d1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048640, this, i2) == null) || (cVar = this.F) == null) {
            return;
        }
        cVar.i(i2);
    }

    public void setTbGestureDetector(c.a.p0.i2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, cVar) == null) {
            super.setOnTouchListener(this.K);
            this.y = cVar;
        }
    }

    public void startLoad(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            startLoad(str, i2, 0, 0, z);
        }
    }

    public void startLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.p = true;
            m();
        }
    }

    public void stopLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        c.a.e.e.l.d.h().d(this.mUrl, this.mType, this.mCallback);
        this.mLogMap.remove(c.a.e.e.l.d.h().g(this.mUrl, this.mType));
        stopLoading();
    }

    public void stopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.p = false;
            removeCallbacks(this);
            this.r = 0.0f;
            this.E.reset();
            setExtraMatrix(this.E);
            invalidate();
        }
    }

    public void startLoad(String str, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            startLoad(str, i2, 0, 0, z, z2);
        }
    }

    public void startLoad(String str, int i2, int i3, int i4, boolean z) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            i c2 = j.c(getContext());
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
            startLoad(str, i2, i3, i4, z, bdUniqueId, z2);
        }
    }

    public void startLoad(String str, int i2, int i3, int i4, boolean z, boolean z2) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            i c2 = j.c(getContext());
            if (c2 != null) {
                BdUniqueId bdUniqueId2 = this.mPageId;
                if (bdUniqueId2 == null) {
                    bdUniqueId2 = c2.getUniqueId();
                }
                bdUniqueId = bdUniqueId2;
            } else {
                bdUniqueId = null;
            }
            startLoad(str, i2, i3, i4, z, bdUniqueId, z2);
        }
    }

    public void startLoad(String str, int i2, int i3, int i4, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), bdUniqueId, Boolean.valueOf(z2)}) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mUrl = str;
                int i5 = this.w;
                if (i5 == 3 || i5 == TbadkCoreApplication.getInst().getSkinType()) {
                    return;
                }
                invalidate();
                return;
            }
            boolean z3 = str.equals(this.mUrl) && i2 == this.mType && bdUniqueId == this.mPageId;
            c.a.e.k.d.a bdImage = getBdImage();
            if (!z3) {
                clearLoadingAnimation();
                this.mNeedRecomputeMatrix = true;
                this.mIsGif = false;
                requestLayout();
            } else if (bdImage != null) {
                invalidate();
                this.I = bdImage.r();
                this.J = bdImage.m();
                f fVar = this.mEvent;
                if (fVar != null) {
                    fVar.a(str, true);
                    return;
                }
                return;
            }
            this.mUrl = str;
            this.mType = i2;
            this.mPageId = bdUniqueId;
            this.mNeedRecomputeMatrix = true;
            if (!TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                this.mWidth = i3;
                this.mHeight = i4;
            }
            if (z2) {
                invalidate();
            } else if (!c.a.e.e.l.d.h().j(this.mType) && this.mSupportNoImage) {
                invalidate();
            } else if (z3 && !c.a.e.e.p.j.z()) {
                invalidate();
                f fVar2 = this.mEvent;
                if (fVar2 != null) {
                    fVar2.a(str, false);
                }
            } else {
                if (z) {
                    startLoading();
                }
                String g2 = c.a.e.e.l.d.h().g(str, i2);
                e eVar = new e(this);
                eVar.f48372a = str;
                eVar.f48373b = i2;
                eVar.f48374c = System.currentTimeMillis();
                this.mLogMap.put(g2, eVar);
                if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                    String g3 = c.a.e.e.l.d.h().g(str, i2);
                    if (this.mRequestMap.containsKey(g3)) {
                        return;
                    }
                    e eVar2 = new e(this);
                    eVar2.f48372a = str;
                    eVar2.f48373b = i2;
                    this.mRequestMap.put(g3, eVar2);
                    return;
                }
                c.a.e.e.l.d.h().k(this.mUrl, this.mType, this.mCallback, i3, i4, this.mPageId, new Object[0]);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = false;
        this.mType = 10;
        this.s = R.drawable.img_loading;
        this.mDefaultId = R.color.transparent;
        this.t = R.color.CAM_X0205;
        this.mIsGifPic = false;
        this.mIsGif = false;
        this.isLongPic = false;
        this.isBitmapPic = false;
        this.isSmartCrop = false;
        this.mSupportNoImage = false;
        this.v = true;
        this.w = 3;
        this.B = new RectF();
        this.C = new Path();
        this.D = new RectF();
        this.E = new Matrix();
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = new c.a.p0.i2.i.c(new a(this));
        this.mCallback = new b(this);
        this.L = new c(this);
        this.M = new d(this, 2016308);
        init();
    }
}

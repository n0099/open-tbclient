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
import c.a.d.a.i;
import c.a.d.a.j;
import c.a.d.f.p.l;
import c.a.d.g.a.a;
import c.a.t0.s2.s.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes11.dex */
public class TbImageView extends BDImageView implements Runnable, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CORNER_ALL = 15;
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_NONE = 0;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    public static HashMap<String, SoftReference<c.a.d.n.d.a>> O = null;
    public static final int PLACE_HOLDER_HUAJI_BIG = 3;
    public static final int PLACE_HOLDER_HUAJI_MIDDLE = 2;
    public static final int PLACE_HOLDER_HUAJI_NONE = 0;
    public static final int PLACE_HOLDER_HUAJI_SMALL = 1;
    public static final int PLACE_HOLDER_HUAJI_SUPER_BIG = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.w A;
    public boolean B;
    public RectF C;
    public Path D;
    public RectF E;
    public final Matrix F;
    public c.a.s0.g1.c G;
    public String H;
    public boolean I;
    public int J;
    public int K;
    public c.a.t0.s2.s.c L;
    public a.b M;
    public CustomMessageListener N;
    public boolean isBitmapPic;
    public boolean isLongPic;
    public boolean isSmartCrop;
    public final c.a.d.f.l.c<c.a.d.n.d.a> mCallback;
    public int mConrers;
    public int mDefaultId;
    public g mEvent;
    public int mHeight;
    public boolean mIsGif;
    public boolean mIsGifPic;
    public HashMap<String, f> mLogMap;
    public h mOnDrawListener;
    public BdUniqueId mPageId;
    public HashMap<String, f> mRequestMap;
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
    public boolean w;
    public int x;
    public View.OnClickListener y;
    public c.a.t0.s2.s.c z;

    /* loaded from: classes11.dex */
    public class a extends c.a.d.f.l.c<c.a.d.n.d.a> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        @Override // c.a.d.f.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                this.a.stopLoading();
                g gVar = this.a.mEvent;
                if (gVar != null) {
                    gVar.onCancel();
                }
            }
        }

        @Override // c.a.d.f.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                if (aVar != null) {
                    this.a.J = aVar.r();
                    this.a.K = aVar.m();
                    c.a.d.f.l.d h2 = c.a.d.f.l.d.h();
                    TbImageView tbImageView = this.a;
                    String g2 = h2.g(tbImageView.mUrl, tbImageView.mType);
                    f fVar = this.a.mLogMap.get(g2);
                    if (fVar != null) {
                        c.a.d.f.l.a.d(i2 == 1, i2 == 2, i2 == 3);
                        if (i2 == 3) {
                            c.a.d.f.l.a.e(true, System.currentTimeMillis() - fVar.f42753c);
                        }
                        this.a.mLogMap.remove(g2);
                    }
                }
                this.a.stopLoading();
                this.a.q(aVar);
                g gVar = this.a.mEvent;
                if (gVar != null) {
                    gVar.a(str, aVar != null);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements a.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        @Override // c.a.d.g.a.a.b
        public boolean a(Canvas canvas, Drawable drawable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, canvas, drawable)) == null) {
                if (this.a.getBdImage() == null && this.a.I) {
                    this.a.drawBackground(canvas, drawable);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbImageView tbImageView, int i2) {
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
            this.a = tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                c.a.d.f.l.d h2 = c.a.d.f.l.d.h();
                TbImageView tbImageView = this.a;
                String g2 = h2.g(tbImageView.mUrl, tbImageView.mType);
                if (g2 == null || !g2.equals(str)) {
                    return;
                }
                this.a.destroyDrawingCache();
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        public d(TbImageView tbImageView) {
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
            this.a = tbImageView;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.getBdImage() != null || this.a.getDrawable() != null || !this.a.B) {
                    if (this.a.y != null) {
                        this.a.y.onClick(view);
                        return true;
                    } else if (this.a.z != null) {
                        this.a.z.a(view);
                        return this.a.z.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                this.a.startLoading();
                c.a.d.f.l.d h2 = c.a.d.f.l.d.h();
                TbImageView tbImageView = this.a;
                h2.k(tbImageView.mUrl, tbImageView.mType, tbImageView.mCallback, tbImageView.mWidth, tbImageView.mHeight, tbImageView.mPageId, new Object[0]);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.a.z != null) {
                    this.a.z.a(view);
                    return this.a.z.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class e implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

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
            this.a = tbImageView;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.getBdImage() != null || this.a.getDrawable() != null || !this.a.B) {
                    if (this.a.y != null) {
                        this.a.y.onClick(view);
                        return true;
                    } else if (this.a.z != null) {
                        this.a.z.a(view);
                        return this.a.z.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                this.a.startLoading();
                c.a.d.f.l.d h2 = c.a.d.f.l.d.h();
                TbImageView tbImageView = this.a;
                h2.k(tbImageView.mUrl, tbImageView.mType, tbImageView.mCallback, tbImageView.mWidth, tbImageView.mHeight, tbImageView.mPageId, new Object[0]);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.a.z != null) {
                    this.a.z.a(view);
                    return this.a.z.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f42752b;

        /* renamed from: c  reason: collision with root package name */
        public long f42753c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TbImageView f42754d;

        public f(TbImageView tbImageView) {
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
            this.f42754d = tbImageView;
        }
    }

    /* loaded from: classes11.dex */
    public interface g {
        void a(String str, boolean z);

        void onCancel();
    }

    /* loaded from: classes11.dex */
    public interface h {
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
        this.w = true;
        this.x = 3;
        this.C = new RectF();
        this.D = new Path();
        this.E = new RectF();
        this.F = new Matrix();
        this.I = false;
        this.J = 0;
        this.K = 0;
        this.mCallback = new a(this);
        this.M = new b(this);
        this.N = new c(this, 2016308);
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mRequestMap = new HashMap<>();
            this.mLogMap = new HashMap<>();
            this.G = new c.a.s0.g1.c(this);
            r();
            this.q = 30.0f;
            setConrers(0);
            c.a.d.g.a.a aVar = this.mDrawer;
            if (aVar == null) {
                return;
            }
            aVar.o(this.M);
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
        c.a.d.f.l.d.h().d(this.mUrl, this.mType, this.mCallback);
        if (TextUtils.isEmpty(this.mUrl) || isShowLoading()) {
            stopLoading();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            TbRichTextView.w wVar = this.A;
            if (wVar != null) {
                wVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void drawBackground(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, canvas, drawable) == null) {
            canvas.save();
            this.D.reset();
            this.C.right = getWidth();
            this.C.bottom = getHeight();
            this.D.addRoundRect(this.C, this.mArgs.a, Path.Direction.CW);
            int i2 = this.mConrers ^ 15;
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            if ((i2 & 1) != 0) {
                Path path = this.D;
                float[] fArr = this.mArgs.a;
                path.addRect(0.0f, 0.0f, fArr[0], fArr[1], Path.Direction.CW);
            }
            if ((i2 & 2) != 0) {
                Path path2 = this.D;
                float f2 = rectF.right;
                float[] fArr2 = this.mArgs.a;
                path2.addRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], Path.Direction.CW);
            }
            if ((i2 & 4) != 0) {
                Path path3 = this.D;
                float f3 = rectF.bottom;
                float[] fArr3 = this.mArgs.a;
                path3.addRect(0.0f, f3 - fArr3[5], fArr3[4], f3, Path.Direction.CW);
            }
            if ((i2 & 8) != 0) {
                Path path4 = this.D;
                float f4 = rectF.right;
                float[] fArr4 = this.mArgs.a;
                float f5 = rectF.bottom;
                path4.addRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, Path.Direction.CW);
            }
            if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
                canvas.clipPath(this.D);
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
            if (this.G == null || (drawerArgs = this.mArgs) == null) {
                return;
            }
            if (drawerArgs.f32221i && (this.mIsGifPic || isGif())) {
                this.G.a(canvas, getContext().getString(R.string.icon_tag_gif), true);
            } else if (this.mArgs.f32220h && isLongPic()) {
                this.G.a(canvas, getContext().getString(R.string.icon_tag_long), true);
            } else {
                String str = this.H;
                if (str != null) {
                    this.G.a(canvas, str, false);
                }
            }
            int i2 = this.mArgs.f32222j;
            if (i2 == c.a.d.g.a.b.f3148c) {
                this.G.b(canvas, getContext().getString(R.string.wonderful_comment), R.color.CAM_X0305);
            } else if (i2 == c.a.d.g.a.b.f3147b) {
                this.G.b(canvas, getContext().getString(R.string.god_level_comment), R.color.CAM_X0310);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public c.a.d.n.d.a getBdImage() {
        InterceptResult invokeV;
        c.a.d.n.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.isEmpty(this.mUrl)) {
                Object tag = getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    aVar = c.a.s0.c0.c.k().m(str);
                    if (aVar == null) {
                        aVar = c.a.s0.c0.c.k().l(str);
                    }
                } else {
                    aVar = null;
                }
            } else {
                aVar = (c.a.d.n.d.a) c.a.d.f.l.d.h().n(this.mUrl, this.mType, new Object[0]);
            }
            if (aVar != null) {
                q(aVar);
            }
            return aVar;
        }
        return (c.a.d.n.d.a) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public c.a.d.n.d.a getDefaultBdImage() {
        InterceptResult invokeV;
        SoftReference<c.a.d.n.d.a> softReference;
        c.a.d.n.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (O == null) {
                O = new HashMap<>();
            }
            String valueOf = String.valueOf(this.u);
            if (this.v) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    valueOf = valueOf + SkinManager.nightSufix;
                } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    valueOf = valueOf + SkinManager.darkSuffix;
                }
            }
            if (this.x != TbadkCoreApplication.getInst().getSkinType()) {
                this.mNeedRecomputeMatrix = true;
                this.x = TbadkCoreApplication.getInst().getSkinType();
            }
            if (!O.containsKey(valueOf) || (softReference = O.get(valueOf)) == null || (aVar = softReference.get()) == null || !aVar.w()) {
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
                c.a.d.n.d.a aVar2 = new c.a.d.n.d.a(bitmap, false, String.valueOf(this.u));
                O.put(valueOf, new SoftReference<>(aVar2));
                return aVar2;
            }
            return aVar;
        }
        return (c.a.d.n.d.a) invokeV.objValue;
    }

    public boolean getDrawCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public int getGifIconHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.s0.g1.c cVar = this.G;
            if (cVar != null) {
                return (int) cVar.c(getContext().getString(R.string.icon_tag_gif));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getGifIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.s0.g1.c cVar = this.G;
            if (cVar != null) {
                return (int) cVar.d(getContext().getString(R.string.icon_tag_gif));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getLoadedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.K : invokeV.intValue;
    }

    @Deprecated
    public int getLoadedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.J : invokeV.intValue;
    }

    public View.OnClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.y : (View.OnClickListener) invokeV.objValue;
    }

    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            DrawerArgs drawerArgs = this.mArgs;
            return drawerArgs == null ? BDImageView.parseCornerRadii(0.0f) : drawerArgs.a;
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
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048599, this, z, canvas) == null) || (hVar = this.mOnDrawListener) == null) {
            return;
        }
        if (z) {
            hVar.b(this, canvas);
        } else {
            hVar.a(this, canvas);
        }
    }

    public final void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, canvas) == null) {
            if (this.isBitmapPic || getBdImage() != null) {
                if (this.mConrers != 0 || getDrawCorner()) {
                    setDrawerType(1);
                    int i2 = this.mConrers ^ 15;
                    this.E.set(0.0f, 0.0f, getWidth(), getHeight());
                    if ((i2 & 1) != 0) {
                        float[] fArr = this.mArgs.a;
                        canvas.drawRect(0.0f, 0.0f, fArr[0], fArr[1], this.mDrawer.f3137b);
                    }
                    if ((i2 & 2) != 0) {
                        float f2 = this.E.right;
                        float[] fArr2 = this.mArgs.a;
                        canvas.drawRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], this.mDrawer.f3137b);
                    }
                    if ((i2 & 4) != 0) {
                        float f3 = this.E.bottom;
                        float[] fArr3 = this.mArgs.a;
                        canvas.drawRect(0.0f, f3 - fArr3[5], fArr3[4], f3, this.mDrawer.f3137b);
                    }
                    if ((i2 & 8) != 0) {
                        RectF rectF = this.E;
                        float f4 = rectF.right;
                        float[] fArr4 = this.mArgs.a;
                        float f5 = rectF.bottom;
                        canvas.drawRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, this.mDrawer.f3137b);
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
            c.a.d.a.f<?> a2 = j.a(getContext());
            if (this.mPageId != null) {
                this.o = true;
            }
            if (a2 != null) {
                CustomMessageListener customMessageListener = this.N;
                BdUniqueId bdUniqueId = this.mPageId;
                if (bdUniqueId == null) {
                    bdUniqueId = a2.getUniqueId();
                }
                customMessageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.N);
            getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view) == null) {
            if (getBdImage() == null && getDrawable() == null && this.B) {
                startLoading();
                c.a.d.f.l.d.h().k(this.mUrl, this.mType, this.mCallback, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.y;
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
            MessageManager.getInstance().unRegisterListener(this.N);
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
                Iterator<Map.Entry<String, f>> it = this.mRequestMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, f> next = it.next();
                    next.getKey();
                    f value = next.getValue();
                    it.remove();
                    c.a.d.f.l.d.h().k(value.a, value.f42752b, this.mCallback, this.mWidth, this.mHeight, this.mPageId, new Object[0]);
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
                    this.E.set(0.0f, 0.0f, getWidth(), getHeight());
                    this.mDrawer.f3138c.setStrokeWidth(this.mDrawer.f3138c.getStrokeWidth());
                    if ((i2 & 1) != 0) {
                        canvas.drawLine(0.0f, 0.0f, this.mArgs.a[0], 0.0f, this.mDrawer.f3138c);
                        canvas.drawLine(0.0f, 0.0f, 0.0f, this.mArgs.a[1], this.mDrawer.f3138c);
                    }
                    if ((i2 & 2) != 0) {
                        float f2 = this.E.right;
                        canvas.drawLine(f2 - this.mArgs.a[2], 0.0f, f2, 0.0f, this.mDrawer.f3138c);
                        float f3 = this.E.right;
                        canvas.drawLine(f3, 0.0f, f3, this.mArgs.a[3], this.mDrawer.f3138c);
                    }
                    if ((i2 & 4) != 0) {
                        float f4 = this.E.bottom;
                        canvas.drawLine(0.0f, f4 - this.mArgs.a[5], 0.0f, f4, this.mDrawer.f3138c);
                        float f5 = this.E.bottom;
                        canvas.drawLine(0.0f, f5, this.mArgs.a[4], f5, this.mDrawer.f3138c);
                    }
                    if ((i2 & 8) != 0) {
                        RectF rectF = this.E;
                        float f6 = rectF.right;
                        float f7 = rectF.bottom;
                        canvas.drawLine(f6 - this.mArgs.a[6], f7, f6, f7, this.mDrawer.f3138c);
                        RectF rectF2 = this.E;
                        float f8 = rectF2.right;
                        float f9 = rectF2.bottom;
                        canvas.drawLine(f8, f9, f8, f9 - this.mArgs.a[7], this.mDrawer.f3138c);
                    }
                }
            }
        }
    }

    public final void q(c.a.d.n.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, aVar) == null) || aVar == null) {
            return;
        }
        this.mIsGif = aVar.t();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.v && this.w) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 1) {
                    this.mArgs.f32218f = DrawerArgs.SkinType.NIGHT;
                } else if (skinType != 4) {
                    this.mArgs.f32218f = DrawerArgs.SkinType.DAY;
                } else {
                    this.mArgs.f32218f = DrawerArgs.SkinType.DARK;
                }
            } else {
                this.mArgs.f32218f = DrawerArgs.SkinType.DAY;
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
                this.G.i(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, c.a.d.g.a.h
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
            this.F.reset();
            this.F.postRotate(this.r, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.F);
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

    public void setDispatchTouchListener(TbRichTextView.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, wVar) == null) {
            this.A = wVar;
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
            this.I = z;
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            super.setDrawerType(i2);
            c.a.d.g.a.a aVar = this.mDrawer;
            if (aVar == null) {
                return;
            }
            aVar.o(this.M);
        }
    }

    public void setEvent(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, gVar) == null) {
            this.mEvent = gVar;
        }
    }

    public void setInterceptOnClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.B = z;
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
            if (this.L == null) {
                this.L = new c.a.t0.s2.s.c(new d(this));
            }
            super.setOnTouchListener(this.L);
            if (!isClickable()) {
                setClickable(true);
            }
            this.y = onClickListener;
        }
    }

    public void setOnDrawListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, hVar) == null) {
            this.mOnDrawListener = hVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, bdUniqueId) == null) {
            this.mPageId = bdUniqueId;
            if (this.o || bdUniqueId == null) {
                return;
            }
            this.N.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.N);
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
        c.a.s0.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048637, this, i2) == null) || (cVar = this.G) == null) {
            return;
        }
        cVar.g(i2);
    }

    public void setTagPaddingDis(int i2, int i3) {
        c.a.s0.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048638, this, i2, i3) == null) || (cVar = this.G) == null) {
            return;
        }
        cVar.f(i2, i3);
    }

    public void setTagStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.H = str;
        }
    }

    public void setTagTextSize(int i2) {
        c.a.s0.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048640, this, i2) == null) || (cVar = this.G) == null) {
            return;
        }
        cVar.h(i2);
    }

    public void setTbGestureDetector(c.a.t0.s2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, cVar) == null) {
            if (this.L == null) {
                this.L = new c.a.t0.s2.s.c(new e(this));
            }
            super.setOnTouchListener(this.L);
            this.z = cVar;
        }
    }

    public void setUseNightOrDarkMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.w = z;
        }
    }

    public void startLoad(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            startLoad(str, i2, 0, 0, z);
        }
    }

    public void startLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.p = true;
            m();
        }
    }

    public void stopLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048649, this) == null) || TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        c.a.d.f.l.d.h().d(this.mUrl, this.mType, this.mCallback);
        this.mLogMap.remove(c.a.d.f.l.d.h().g(this.mUrl, this.mType));
        stopLoading();
    }

    public void stopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.p = false;
            removeCallbacks(this);
            this.r = 0.0f;
            this.F.reset();
            setExtraMatrix(this.F);
            invalidate();
        }
    }

    public void startLoad(String str, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            startLoad(str, i2, 0, 0, z, z2);
        }
    }

    public void startLoad(String str, int i2, int i3, int i4, boolean z) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), bdUniqueId, Boolean.valueOf(z2)}) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mUrl = str;
                int i5 = this.x;
                if (i5 == 3 || i5 == TbadkCoreApplication.getInst().getSkinType()) {
                    return;
                }
                invalidate();
                return;
            }
            boolean z3 = str.equals(this.mUrl) && i2 == this.mType && bdUniqueId == this.mPageId;
            c.a.d.n.d.a bdImage = getBdImage();
            if (!z3) {
                clearLoadingAnimation();
                this.mNeedRecomputeMatrix = true;
                this.mIsGif = false;
                requestLayout();
            } else if (bdImage != null) {
                invalidate();
                this.J = bdImage.r();
                this.K = bdImage.m();
                g gVar = this.mEvent;
                if (gVar != null) {
                    gVar.a(str, true);
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
            } else if (!c.a.d.f.l.d.h().j(this.mType) && this.mSupportNoImage) {
                invalidate();
            } else if (z3 && !l.z()) {
                invalidate();
                g gVar2 = this.mEvent;
                if (gVar2 != null) {
                    gVar2.a(str, false);
                }
            } else {
                if (z) {
                    startLoading();
                }
                String g2 = c.a.d.f.l.d.h().g(str, i2);
                f fVar = new f(this);
                fVar.a = str;
                fVar.f42752b = i2;
                fVar.f42753c = System.currentTimeMillis();
                this.mLogMap.put(g2, fVar);
                if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                    String g3 = c.a.d.f.l.d.h().g(str, i2);
                    if (this.mRequestMap.containsKey(g3)) {
                        return;
                    }
                    f fVar2 = new f(this);
                    fVar2.a = str;
                    fVar2.f42752b = i2;
                    this.mRequestMap.put(g3, fVar2);
                    return;
                }
                c.a.d.f.l.d.h().k(this.mUrl, this.mType, this.mCallback, i3, i4, this.mPageId, new Object[0]);
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
        this.w = true;
        this.x = 3;
        this.C = new RectF();
        this.D = new Path();
        this.E = new RectF();
        this.F = new Matrix();
        this.I = false;
        this.J = 0;
        this.K = 0;
        this.mCallback = new a(this);
        this.M = new b(this);
        this.N = new c(this, 2016308);
        init();
    }
}

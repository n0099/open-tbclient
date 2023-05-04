package com.baidu.tieba.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.bg;
import com.baidu.tieba.cg;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.dj8;
import com.baidu.tieba.e65;
import com.baidu.tieba.g35;
import com.baidu.tieba.hi;
import com.baidu.tieba.ii;
import com.baidu.tieba.mq6;
import com.baidu.tieba.tm;
import com.baidu.tieba.un9;
import com.baidu.tieba.uq5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0006012345B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010%\u001a\u00020 J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0010J\u0006\u0010(\u001a\u00020\u0010J\u000e\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0018J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u001aH\u0002J\b\u0010/\u001a\u00020 H\u0002R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcom/baidu/tieba/core/widget/SpriteBottomTipView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/edgefloat/IChangeSkinType;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animationHandler", "Lcom/baidu/tieba/core/widget/SpriteBottomTipView$ShowAnimationHandler;", "isVisibility", "", "mBtn", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "mContentContainer", "mDesc", "Landroid/widget/TextView;", "mIconClose", "Landroid/widget/ImageView;", "mIconImg", "Lcom/baidu/tbadk/widget/image/TbImage;", "mRoot", "Landroid/view/View;", "mSkinType", "", "mTipVieParams", "Lcom/baidu/tieba/core/widget/SpriteBottomTipView$TipViewParams;", "mTitle", "onVisibilityChangedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnVisibilityChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "dismiss", "getContentView", "getDescView", "getTitleView", "onChangeSkin", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "type", "setData", "params", "show", "Builder", "Companion", "OnClickCallback", "OnDismissCallback", "ShowAnimationHandler", "TipViewParams", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SpriteBottomTipView extends LinearLayout implements mq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public TextView c;
    public TBSpecificationBtn d;
    public TbImage e;
    public ImageView f;
    public LinearLayout g;
    public e h;
    public final d i;
    public Function1<? super Boolean, Unit> j;
    public boolean k;
    public int l;

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();

        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onDismiss();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1767765556, "Lcom/baidu/tieba/core/widget/SpriteBottomTipView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1767765556, "Lcom/baidu/tieba/core/widget/SpriteBottomTipView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteBottomTipView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public e b;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
            this.b = new e();
        }

        public final SpriteBottomTipView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                SpriteBottomTipView spriteBottomTipView = new SpriteBottomTipView(this.a, null, 2, null);
                spriteBottomTipView.setData(this.b);
                return spriteBottomTipView;
            }
            return (SpriteBottomTipView) invokeV.objValue;
        }

        public final Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.a;
            }
            return (Context) invokeV.objValue;
        }

        public final a b(@DrawableRes Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num)) == null) {
                this.b.A(num);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.b.B(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.b.C(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a e(@DrawableRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.b.G(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.b.D(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a g(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
                this.b.E(bVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a h(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.b.H(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.b.K(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a j(@ColorRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                this.b.I(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a k(@DimenRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                this.b.J(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a l(@StringRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.b.L(i);
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public final class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<SpriteBottomTipView> a;
        public final /* synthetic */ SpriteBottomTipView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SpriteBottomTipView spriteBottomTipView, SpriteBottomTipView spriteBottomTipView2) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteBottomTipView, spriteBottomTipView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = spriteBottomTipView;
            this.a = new WeakReference<>(spriteBottomTipView2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SpriteBottomTipView spriteBottomTipView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i != 1) {
                    if (i == 2 && (spriteBottomTipView = this.a.get()) != null) {
                        spriteBottomTipView.h();
                        return;
                    }
                    return;
                }
                SpriteBottomTipView spriteBottomTipView2 = this.a.get();
                if (spriteBottomTipView2 == null) {
                    return;
                }
                spriteBottomTipView2.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public int c;
        public Integer d;
        public int e;
        public String f;
        public int g;
        public int h;
        public Integer i;
        public int j;
        public String k;
        public int l;
        public int m;
        public Integer n;
        public int o;
        public String p;
        public int q;
        public long r;
        public int s;
        public boolean t;
        public String u;
        public Integer v;
        public Drawable w;
        public Integer x;
        public b y;
        public c z;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = R.dimen.T_X06;
            this.c = R.color.CAM_X0610;
            this.e = R.string.F_X02;
            this.g = R.dimen.T_X08;
            this.h = R.color.CAM_X0608;
            this.j = R.string.F_X01;
            UtilHelper.getDimenPixelSize(R.dimen.T_X08);
            this.l = R.dimen.T_X08;
            this.m = R.color.CAM_X0101;
            this.o = un9.f("#CC7F47");
            this.s = R.drawable.pic_use_header_28_n;
        }

        public final void A(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.v = num;
            }
        }

        public final void B(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.k = str;
            }
        }

        public final void C(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f = str;
            }
        }

        public final void D(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.p = str;
            }
        }

        public final void E(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
                this.y = bVar;
            }
        }

        public final void F(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                this.z = cVar;
            }
        }

        public final void G(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.s = i;
            }
        }

        public final void H(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.t = z;
            }
        }

        public final void I(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.c = i;
            }
        }

        public final void J(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.b = i;
            }
        }

        public final void K(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.a = str;
            }
        }

        public final void L(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                this.e = i;
            }
        }

        public final Integer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.x;
            }
            return (Integer) invokeV.objValue;
        }

        public final Drawable b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.w;
            }
            return (Drawable) invokeV.objValue;
        }

        public final Integer c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.v;
            }
            return (Integer) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.u;
            }
            return (String) invokeV.objValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.m;
            }
            return invokeV.intValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.o;
            }
            return invokeV.intValue;
        }

        public final Integer g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.n;
            }
            return (Integer) invokeV.objValue;
        }

        public final int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.l;
            }
            return invokeV.intValue;
        }

        public final String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.k;
            }
            return (String) invokeV.objValue;
        }

        public final Integer j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.i;
            }
            return (Integer) invokeV.objValue;
        }

        public final int k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.h;
            }
            return invokeV.intValue;
        }

        public final int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.g;
            }
            return invokeV.intValue;
        }

        public final String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.f;
            }
            return (String) invokeV.objValue;
        }

        public final int n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.j;
            }
            return invokeV.intValue;
        }

        public final int o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                return this.q;
            }
            return invokeV.intValue;
        }

        public final String p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return this.p;
            }
            return (String) invokeV.objValue;
        }

        public final b q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                return this.y;
            }
            return (b) invokeV.objValue;
        }

        public final c r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                return this.z;
            }
            return (c) invokeV.objValue;
        }

        public final int s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                return this.s;
            }
            return invokeV.intValue;
        }

        public final long t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                return this.r;
            }
            return invokeV.longValue;
        }

        public final Integer u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                return this.d;
            }
            return (Integer) invokeV.objValue;
        }

        public final int v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public final int w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public final String x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public final int y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
                return this.e;
            }
            return invokeV.intValue;
        }

        public final boolean z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
                return this.t;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class f extends bg<tm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpriteBottomTipView a;

        public f(SpriteBottomTipView spriteBottomTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteBottomTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spriteBottomTipView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(tm tmVar, String key, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, tmVar, key, i) == null) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (tmVar != null) {
                    this.a.a.setBackgroundDrawable(new NinePatchDrawable(this.a.getResources(), tmVar.p(), tmVar.p().getNinePatchChunk(), tmVar.o(), null));
                    return;
                }
                e eVar = this.a.h;
                e eVar2 = null;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    eVar = null;
                }
                if (eVar.a() == null) {
                    return;
                }
                View view2 = this.a.a;
                e eVar3 = this.a.h;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                } else {
                    eVar2 = eVar3;
                }
                Integer a = eVar2.a();
                Intrinsics.checkNotNull(a);
                SkinManager.setBackgroundResource(view2, a.intValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteBottomTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.l = 3;
        LayoutInflater.from(context).inflate(R.layout.funny_sprite_bottom_tip_layout, this);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091e30);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.root)");
        this.a = findViewById;
        View findViewById2 = findViewById(R.id.tip_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tip_icon)");
        this.e = (TbImage) findViewById2;
        View findViewById3 = findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.content_container)");
        this.g = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.tip_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tip_title)");
        this.b = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.tip_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tip_desc)");
        this.c = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.tip_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tip_btn)");
        this.d = (TBSpecificationBtn) findViewById6;
        View findViewById7 = findViewById(R.id.tip_close);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tip_close)");
        this.f = (ImageView) findViewById7;
        this.e.setBorder(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds1), SkinManager.getColor(R.color.CAM_X0602));
        this.e.setRadiusById(R.string.J_X06);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.i = new d(this, this);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.om6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    SpriteBottomTipView.a(SpriteBottomTipView.this, view2);
                }
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mm6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    SpriteBottomTipView.b(SpriteBottomTipView.this, view2);
                }
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.nm6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    SpriteBottomTipView.c(SpriteBottomTipView.this, view2);
                }
            }
        });
    }

    public /* synthetic */ SpriteBottomTipView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void a(SpriteBottomTipView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            e eVar = this$0.h;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar = null;
            }
            b q = eVar.q();
            if (q != null) {
                q.a();
            }
        }
    }

    public static final void b(SpriteBottomTipView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            e eVar = this$0.h;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar = null;
            }
            b q = eVar.q();
            if (q != null) {
                q.b();
            }
        }
    }

    public static final void c(SpriteBottomTipView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (uq5.a()) {
                return;
            }
            e eVar = this$0.h;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar = null;
            }
            b q = eVar.q();
            if (q != null) {
                q.onClick();
            }
        }
    }

    @Override // com.baidu.tieba.mq6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            i(i);
        }
    }

    public final void setOnVisibilityChangedListener(Function1<? super Boolean, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, function1) == null) {
            this.j = function1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData(e eVar) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, this, eVar) != null) || eVar == null) {
            return;
        }
        this.h = eVar;
        TextView textView = this.b;
        e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar = null;
        }
        int i4 = 0;
        if (!hi.isEmpty(eVar.x())) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        TextView textView2 = this.c;
        e eVar3 = this.h;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar3 = null;
        }
        if (!hi.isEmpty(eVar3.m())) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView2.setVisibility(i2);
        TBSpecificationBtn tBSpecificationBtn = this.d;
        e eVar4 = this.h;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar4 = null;
        }
        if (!hi.isEmpty(eVar4.i())) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        tBSpecificationBtn.setVisibility(i3);
        ImageView imageView = this.f;
        e eVar5 = this.h;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar5 = null;
        }
        if (!eVar5.z()) {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        TextView textView3 = this.b;
        e eVar6 = this.h;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar6 = null;
        }
        textView3.setText(eVar6.x());
        TextView textView4 = this.c;
        e eVar7 = this.h;
        if (eVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar7 = null;
        }
        textView4.setText(eVar7.m());
        TBSpecificationBtn tBSpecificationBtn2 = this.d;
        e eVar8 = this.h;
        if (eVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar8 = null;
        }
        tBSpecificationBtn2.setText(eVar8.i());
        this.i.removeMessages(1);
        this.i.removeMessages(2);
        this.i.sendEmptyMessage(1);
        e eVar9 = this.h;
        if (eVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar9 = null;
        }
        if (eVar9.t() > 0) {
            d dVar = this.i;
            e eVar10 = this.h;
            if (eVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar10 = null;
            }
            dVar.sendEmptyMessageDelayed(2, eVar10.t());
        }
        i(TbadkCoreApplication.getInst().getSkinType());
        dj8 defaultLog = DefaultLog.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("showTip:");
        e eVar11 = this.h;
        if (eVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar11 = null;
        }
        sb.append(eVar11.x());
        sb.append(',');
        e eVar12 = this.h;
        if (eVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar12 = null;
        }
        sb.append(eVar12.m());
        sb.append(',');
        e eVar13 = this.h;
        if (eVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
        } else {
            eVar2 = eVar13;
        }
        sb.append(eVar2.i());
        defaultLog.c("SpriteTip", sb.toString());
    }

    public final View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public final TextView getDescView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (TextView) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    public final Function1<Boolean, Unit> getOnVisibilityChangedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (Function1) invokeV.objValue;
    }

    public final TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.k) {
            return;
        }
        this.k = true;
        Function1<? super Boolean, Unit> function1 = this.j;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !this.k) {
            return;
        }
        this.k = false;
        e eVar = this.h;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar = null;
        }
        c r = eVar.r();
        if (r != null) {
            r.onDismiss();
        }
        e eVar2 = this.h;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar2 = null;
        }
        eVar2.F(null);
        Function1<? super Boolean, Unit> function1 = this.j;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public final void i(int i) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.l == i) {
            return;
        }
        e eVar = this.h;
        e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar = null;
        }
        if (eVar.p() != null) {
            TbImage tbImage = this.e;
            e eVar3 = this.h;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar3 = null;
            }
            tbImage.setPlaceHolderDrawable(SkinManager.getDrawable(eVar3.s()));
            TbImage tbImage2 = this.e;
            e eVar4 = this.h;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar4 = null;
            }
            String p = eVar4.p();
            Intrinsics.checkNotNull(p);
            tbImage2.k(p);
        } else {
            e eVar5 = this.h;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar5 = null;
            }
            if (eVar5.o() != 0) {
                TbImage tbImage3 = this.e;
                e eVar6 = this.h;
                if (eVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    eVar6 = null;
                }
                tbImage3.setPlaceHolderDrawable(SkinManager.getDrawable(eVar6.o()));
                this.e.k("");
            } else {
                this.e.setVisibility(8);
            }
        }
        e eVar7 = this.h;
        if (eVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar7 = null;
        }
        if (!hi.isEmpty(eVar7.d())) {
            TbPageContext currentPageContext = TbadkApplication.getInst().getCurrentPageContext(getContext());
            if (currentPageContext != null) {
                bdUniqueId = currentPageContext.getUniqueId();
            } else {
                bdUniqueId = null;
            }
            cg h = cg.h();
            e eVar8 = this.h;
            if (eVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar8 = null;
            }
            h.m(eVar8.d(), 19, new f(this), bdUniqueId);
        } else {
            e eVar9 = this.h;
            if (eVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar9 = null;
            }
            if (eVar9.c() != null) {
                View view2 = this.a;
                e eVar10 = this.h;
                if (eVar10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    eVar10 = null;
                }
                Integer c2 = eVar10.c();
                Intrinsics.checkNotNull(c2);
                SkinManager.setBackgroundResource(view2, c2.intValue());
            } else {
                e eVar11 = this.h;
                if (eVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    eVar11 = null;
                }
                if (eVar11.b() != null) {
                    View view3 = this.a;
                    e eVar12 = this.h;
                    if (eVar12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                        eVar12 = null;
                    }
                    view3.setBackgroundDrawable(eVar12.b());
                } else {
                    e eVar13 = this.h;
                    if (eVar13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                        eVar13 = null;
                    }
                    if (eVar13.a() != null) {
                        View view4 = this.a;
                        e eVar14 = this.h;
                        if (eVar14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                            eVar14 = null;
                        }
                        Integer a2 = eVar14.a();
                        Intrinsics.checkNotNull(a2);
                        SkinManager.setBackgroundResource(view4, a2.intValue());
                    }
                }
            }
        }
        this.f.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.funny_sprite_tip_close, WebPManager.ResourceStateType.NORMAL));
        g35 d2 = g35.d(this.d);
        e eVar15 = this.h;
        if (eVar15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar15 = null;
        }
        d2.B(eVar15.h());
        e65 e65Var = new e65();
        e eVar16 = this.h;
        if (eVar16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar16 = null;
        }
        if (eVar16.g() != null) {
            e eVar17 = this.h;
            if (eVar17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar17 = null;
            }
            int e2 = eVar17.e();
            e eVar18 = this.h;
            if (eVar18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar18 = null;
            }
            Integer g = eVar18.g();
            Intrinsics.checkNotNull(g);
            e65Var.r(e2, g.intValue());
        } else {
            e eVar19 = this.h;
            if (eVar19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar19 = null;
            }
            int f2 = eVar19.f();
            e eVar20 = this.h;
            if (eVar20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar20 = null;
            }
            e65Var.q(f2, SkinManager.getColor(eVar20.e()));
        }
        this.d.setConfig(e65Var);
        g35 d3 = g35.d(this.b);
        e eVar21 = this.h;
        if (eVar21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar21 = null;
        }
        d3.B(eVar21.w());
        e eVar22 = this.h;
        if (eVar22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar22 = null;
        }
        d3.w(eVar22.v());
        e eVar23 = this.h;
        if (eVar23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar23 = null;
        }
        d3.C(eVar23.y());
        e eVar24 = this.h;
        if (eVar24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar24 = null;
        }
        Integer u = eVar24.u();
        if (u != null) {
            this.b.setTextColor(u.intValue());
        }
        g35 d4 = g35.d(this.c);
        e eVar25 = this.h;
        if (eVar25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar25 = null;
        }
        d4.B(eVar25.l());
        e eVar26 = this.h;
        if (eVar26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar26 = null;
        }
        d4.w(eVar26.k());
        e eVar27 = this.h;
        if (eVar27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar27 = null;
        }
        d4.C(eVar27.n());
        e eVar28 = this.h;
        if (eVar28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
        } else {
            eVar2 = eVar28;
        }
        Integer j = eVar2.j();
        if (j != null) {
            this.c.setTextColor(j.intValue());
        }
        this.l = i;
    }
}

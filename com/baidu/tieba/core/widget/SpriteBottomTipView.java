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
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.b65;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.jt5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.nw6;
import com.baidu.tieba.rd;
import com.baidu.tieba.uua;
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
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\u0018\u0000 42\u00020\u00012\u00020\u0002:\u0006345678B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010%\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0006\u0010)\u001a\u00020 J\u0006\u0010*\u001a\u00020\u0017J\u0006\u0010+\u001a\u00020\u0011J\u0006\u0010,\u001a\u00020\u0011J\u000e\u0010-\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0004J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0004H\u0016J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u001aH\u0002J\b\u00102\u001a\u00020 H\u0002R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020 \u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00069"}, d2 = {"Lcom/baidu/tieba/core/widget/SpriteBottomTipView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/edgefloat/IChangeSkinType;", "layoutId", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(ILandroid/content/Context;Landroid/util/AttributeSet;)V", "animationHandler", "Lcom/baidu/tieba/core/widget/SpriteBottomTipView$ShowAnimationHandler;", "isVisibility", "", "mBtn", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "mDesc", "Landroid/widget/TextView;", "mIconClose", "Landroid/widget/ImageView;", "mIconImg", "Lcom/baidu/tbadk/widget/image/TbImage;", "mRoot", "Landroid/view/View;", "mSkinType", "mTipVieParams", "Lcom/baidu/tieba/core/widget/SpriteBottomTipView$TipViewParams;", "mTitle", "onVisibilityChangedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnVisibilityChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "changeBtnSkin", "changeDescSkin", WriteMulitImageActivityConfig.SKIN_TYPE, "changeTitleSkin", "dismiss", "getContentView", "getDescView", "getTitleView", "onChangeSkin", "onChangeSkinType", "type", "setData", "params", "show", "Builder", "Companion", "OnClickCallback", "OnDismissCallback", "ShowAnimationHandler", "TipViewParams", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpriteBottomTipView extends LinearLayout implements nw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public TextView c;
    public TBSpecificationBtn d;
    public TbImage e;
    public ImageView f;
    public e g;
    public final d h;
    public Function1<? super Boolean, Unit> i;
    public boolean j;
    public int k;

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void onBtnClick();

        void onClick();
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                SpriteBottomTipView spriteBottomTipView = new SpriteBottomTipView(this.b.r(), this.a, null, 4, null);
                spriteBottomTipView.setData(this.b);
                return spriteBottomTipView;
            }
            return (SpriteBottomTipView) invokeV.objValue;
        }

        public final a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.b.G(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.b.H(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a d(TBSpecificationButtonConfig config) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, config)) == null) {
                Intrinsics.checkNotNullParameter(config, "config");
                this.b.I(config);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.b.K(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.b.J(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.b.P(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a h(@ColorInt Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, num)) == null) {
                this.b.L(num);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a i(@ColorRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.b.M(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a j(@ColorInt Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, num)) == null) {
                this.b.N(num);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a k(@DimenRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                this.b.O(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.b.Q(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a m(@DrawableRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.b.X(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a n(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.b.R(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a o(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
                this.b.S(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a p(@DrawableRes Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, num)) == null) {
                this.b.T(num);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a q(@DrawableRes Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, num)) == null) {
                this.b.U(num);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a r(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bVar)) == null) {
                this.b.V(bVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a s(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
                this.b.Y(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a t(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
                this.b.d0(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a u(@ColorInt Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, num)) == null) {
                this.b.Z(num);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a v(@ColorRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
                this.b.a0(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a w(@ColorInt Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, num)) == null) {
                this.b.b0(num);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a x(@DimenRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
                this.b.c0(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a y(@StringRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
                this.b.e0(i);
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
                        spriteBottomTipView.i();
                        return;
                    }
                    return;
                }
                SpriteBottomTipView spriteBottomTipView2 = this.a.get();
                if (spriteBottomTipView2 == null) {
                    return;
                }
                spriteBottomTipView2.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer A;
        public Drawable B;
        public Integer C;
        public b D;
        public c E;
        public int F;
        public String a;
        public int b;
        public int c;
        public Integer d;
        public Integer e;
        public int f;
        public String g;
        public int h;
        public int i;
        public Integer j;
        public Integer k;
        public int l;
        public String m;
        public int n;
        public int o;
        public Integer p;
        public int q;
        public TBSpecificationButtonConfig r;
        public String s;
        public String t;
        public int u;
        public long v;
        public int w;
        public boolean x;
        public String y;
        public String z;

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
            this.f = R.string.F_X02;
            this.h = R.dimen.T_X08;
            this.i = R.color.CAM_X0608;
            this.l = R.string.F_X01;
            UtilHelper.getDimenPixelSize(R.dimen.T_X08);
            this.n = R.dimen.T_X08;
            this.o = R.color.CAM_X0101;
            this.q = uua.f("#CC7F47");
            this.w = R.drawable.pic_use_header_28_n;
            this.F = R.layout.funny_sprite_bottom_tip_layout;
        }

        public final int A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public final Integer B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.e;
            }
            return (Integer) invokeV.objValue;
        }

        public final int C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public final String D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public final int E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.f;
            }
            return invokeV.intValue;
        }

        public final boolean F() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.x;
            }
            return invokeV.booleanValue;
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                return this.z;
            }
            return (String) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                return this.y;
            }
            return (String) invokeV.objValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                return this.o;
            }
            return invokeV.intValue;
        }

        public final TBSpecificationButtonConfig d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                return this.r;
            }
            return (TBSpecificationButtonConfig) invokeV.objValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
                return this.q;
            }
            return invokeV.intValue;
        }

        public final Integer f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
                return this.p;
            }
            return (Integer) invokeV.objValue;
        }

        public final int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
                return this.n;
            }
            return invokeV.intValue;
        }

        public final String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
                return this.m;
            }
            return (String) invokeV.objValue;
        }

        public final Integer i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
                return this.j;
            }
            return (Integer) invokeV.objValue;
        }

        public final int j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
                return this.i;
            }
            return invokeV.intValue;
        }

        public final Integer k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
                return this.k;
            }
            return (Integer) invokeV.objValue;
        }

        public final int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
                return this.h;
            }
            return invokeV.intValue;
        }

        public final String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
                return this.g;
            }
            return (String) invokeV.objValue;
        }

        public final int n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
                return this.l;
            }
            return invokeV.intValue;
        }

        public final String o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
                return this.t;
            }
            return (String) invokeV.objValue;
        }

        public final int p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
                return this.u;
            }
            return invokeV.intValue;
        }

        public final String q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
                return this.s;
            }
            return (String) invokeV.objValue;
        }

        public final int r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
                return this.F;
            }
            return invokeV.intValue;
        }

        public final Drawable s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
                return this.B;
            }
            return (Drawable) invokeV.objValue;
        }

        public final Integer t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
                return this.A;
            }
            return (Integer) invokeV.objValue;
        }

        public final Integer u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
                return this.C;
            }
            return (Integer) invokeV.objValue;
        }

        public final b v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
                return this.D;
            }
            return (b) invokeV.objValue;
        }

        public final c w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
                return this.E;
            }
            return (c) invokeV.objValue;
        }

        public final int x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
                return this.w;
            }
            return invokeV.intValue;
        }

        public final long y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
                return this.v;
            }
            return invokeV.longValue;
        }

        public final Integer z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
                return this.d;
            }
            return (Integer) invokeV.objValue;
        }

        public final void G(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.z = str;
            }
        }

        public final void H(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.y = str;
            }
        }

        public final void I(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tBSpecificationButtonConfig) == null) {
                this.r = tBSpecificationButtonConfig;
            }
        }

        public final void J(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.n = i;
            }
        }

        public final void K(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.m = str;
            }
        }

        public final void L(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, num) == null) {
                this.j = num;
            }
        }

        public final void M(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                this.i = i;
            }
        }

        public final void N(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, num) == null) {
                this.k = num;
            }
        }

        public final void O(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
                this.h = i;
            }
        }

        public final void P(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.g = str;
            }
        }

        public final void Q(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
                this.t = str;
            }
        }

        public final void R(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
                this.s = str;
            }
        }

        public final void S(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
                this.F = i;
            }
        }

        public final void T(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, num) == null) {
                this.A = num;
            }
        }

        public final void U(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, num) == null) {
                this.C = num;
            }
        }

        public final void V(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
                this.D = bVar;
            }
        }

        public final void W(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) {
                this.E = cVar;
            }
        }

        public final void X(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
                this.w = i;
            }
        }

        public final void Y(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
                this.x = z;
            }
        }

        public final void Z(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, num) == null) {
                this.d = num;
            }
        }

        public final void a0(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
                this.c = i;
            }
        }

        public final void b0(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048605, this, num) == null) {
                this.e = num;
            }
        }

        public final void c0(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
                this.b = i;
            }
        }

        public final void d0(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
                this.a = str;
            }
        }

        public final void e0(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
                this.f = i;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteBottomTipView(int i, Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.k = 3;
        LayoutInflater.from(context).inflate(i, this);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f092069);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.root)");
        this.a = findViewById;
        View findViewById2 = findViewById(R.id.tip_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tip_icon)");
        this.e = (TbImage) findViewById2;
        View findViewById3 = findViewById(R.id.tip_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tip_title)");
        this.b = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.tip_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tip_desc)");
        this.c = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.tip_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tip_btn)");
        this.d = (TBSpecificationBtn) findViewById5;
        View findViewById6 = findViewById(R.id.tip_close);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tip_close)");
        this.f = (ImageView) findViewById6;
        this.e.setBorder(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1), SkinManager.getColor(R.color.CAM_X0602));
        this.e.setRadiusById(R.string.J_X06);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.h = new d(this, this);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pr6
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
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.nr6
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
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.or6
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

    public /* synthetic */ SpriteBottomTipView(int i, Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, context, (i2 & 4) != 0 ? null : attributeSet);
    }

    public static final void a(SpriteBottomTipView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            e eVar = this$0.g;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar = null;
            }
            b v = eVar.v();
            if (v != null) {
                v.onBtnClick();
            }
        }
    }

    public static final void b(SpriteBottomTipView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            e eVar = this$0.g;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar = null;
            }
            b v = eVar.v();
            if (v != null) {
                v.a();
            }
        }
    }

    public static final void c(SpriteBottomTipView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (jt5.a()) {
                return;
            }
            e eVar = this$0.g;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar = null;
            }
            b v = eVar.v();
            if (v != null) {
                v.onClick();
            }
        }
    }

    @Override // com.baidu.tieba.nw6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            j(i);
        }
    }

    public final void setOnVisibilityChangedListener(Function1<? super Boolean, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, function1) == null) {
            this.i = function1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData(e eVar) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, this, eVar) != null) || eVar == null) {
            return;
        }
        this.g = eVar;
        TextView textView = this.b;
        e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar = null;
        }
        int i4 = 0;
        if (!rd.isEmpty(eVar.D())) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        TextView textView2 = this.c;
        e eVar3 = this.g;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar3 = null;
        }
        if (!rd.isEmpty(eVar3.m())) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView2.setVisibility(i2);
        TBSpecificationBtn tBSpecificationBtn = this.d;
        e eVar4 = this.g;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar4 = null;
        }
        if (!rd.isEmpty(eVar4.h())) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        tBSpecificationBtn.setVisibility(i3);
        ImageView imageView = this.f;
        e eVar5 = this.g;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar5 = null;
        }
        if (!eVar5.F()) {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        TextView textView3 = this.b;
        e eVar6 = this.g;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar6 = null;
        }
        textView3.setText(eVar6.D());
        TextView textView4 = this.c;
        e eVar7 = this.g;
        if (eVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar7 = null;
        }
        textView4.setText(eVar7.m());
        TBSpecificationBtn tBSpecificationBtn2 = this.d;
        e eVar8 = this.g;
        if (eVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar8 = null;
        }
        tBSpecificationBtn2.setText(eVar8.h());
        this.h.removeMessages(1);
        this.h.removeMessages(2);
        this.h.sendEmptyMessage(1);
        e eVar9 = this.g;
        if (eVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar9 = null;
        }
        if (eVar9.y() > 0) {
            d dVar = this.h;
            e eVar10 = this.g;
            if (eVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar10 = null;
            }
            dVar.sendEmptyMessageDelayed(2, eVar10.y());
        }
        j(TbadkCoreApplication.getInst().getSkinType());
        TbLog defaultLog = DefaultLog.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("showTip:");
        e eVar11 = this.g;
        if (eVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar11 = null;
        }
        sb.append(eVar11.D());
        sb.append(',');
        e eVar12 = this.g;
        if (eVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar12 = null;
        }
        sb.append(eVar12.m());
        sb.append(',');
        e eVar13 = this.g;
        if (eVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
        } else {
            eVar2 = eVar13;
        }
        sb.append(eVar2.h());
        defaultLog.i("SpriteTip", sb.toString());
    }

    public final void j(int i) {
        String q;
        String b2;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || this.k == i) {
            return;
        }
        e eVar = null;
        if (i == 4) {
            e eVar2 = this.g;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar2 = null;
            }
            q = eVar2.o();
        } else {
            e eVar3 = this.g;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar3 = null;
            }
            q = eVar3.q();
        }
        if (q != null) {
            TbImage tbImage = this.e;
            e eVar4 = this.g;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar4 = null;
            }
            tbImage.setPlaceHolderDrawable(SkinManager.getDrawable(eVar4.x()));
            this.e.l(q);
        } else {
            e eVar5 = this.g;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar5 = null;
            }
            if (eVar5.p() != 0) {
                TbImage tbImage2 = this.e;
                e eVar6 = this.g;
                if (eVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    eVar6 = null;
                }
                tbImage2.setPlaceHolderDrawable(SkinManager.getDrawable(eVar6.p()));
                this.e.l("");
            } else {
                this.e.setVisibility(8);
            }
        }
        if (i == 4) {
            e eVar7 = this.g;
            if (eVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar7 = null;
            }
            b2 = eVar7.a();
        } else {
            e eVar8 = this.g;
            if (eVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar8 = null;
            }
            b2 = eVar8.b();
        }
        if (!rd.isEmpty(b2)) {
            Object loadResourceFromMemery = BdResourceLoader.getInstance().loadResourceFromMemery(b2, 59, new Object[0]);
            if (loadResourceFromMemery instanceof BdImage) {
                bdImage = (BdImage) loadResourceFromMemery;
            } else {
                bdImage = null;
            }
            if (bdImage != null) {
                this.a.setBackgroundDrawable(new NinePatchDrawable(getResources(), bdImage.getRawBitmap(), bdImage.getRawBitmap().getNinePatchChunk(), null, null));
            } else {
                e eVar9 = this.g;
                if (eVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    eVar9 = null;
                }
                if (eVar9.u() != null) {
                    View view2 = this.a;
                    e eVar10 = this.g;
                    if (eVar10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                        eVar10 = null;
                    }
                    Integer u = eVar10.u();
                    Intrinsics.checkNotNull(u);
                    SkinManager.setBackgroundResource(view2, u.intValue());
                }
                BdResourceLoader.getInstance().loadResource(b2, 59, null, null);
            }
        } else {
            e eVar11 = this.g;
            if (eVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar11 = null;
            }
            if (eVar11.t() != null) {
                View view3 = this.a;
                e eVar12 = this.g;
                if (eVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                } else {
                    eVar = eVar12;
                }
                Integer t = eVar.t();
                Intrinsics.checkNotNull(t);
                SkinManager.setBackgroundResource(view3, t.intValue());
            } else {
                e eVar13 = this.g;
                if (eVar13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    eVar13 = null;
                }
                if (eVar13.s() != null) {
                    View view4 = this.a;
                    e eVar14 = this.g;
                    if (eVar14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    } else {
                        eVar = eVar14;
                    }
                    view4.setBackgroundDrawable(eVar.s());
                }
            }
        }
        this.f.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.funny_sprite_tip_close, WebPManager.ResourceStateType.NORMAL));
        f();
        h(i);
        g(i);
        this.k = i;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.d;
            e eVar = this.g;
            e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar = null;
            }
            tBSpecificationBtn.setTextSize(eVar.g());
            e eVar3 = this.g;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar3 = null;
            }
            if (eVar3.d() != null) {
                TBSpecificationBtn tBSpecificationBtn2 = this.d;
                e eVar4 = this.g;
                if (eVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                } else {
                    eVar2 = eVar4;
                }
                tBSpecificationBtn2.setConfig(eVar2.d());
                this.d.k();
                return;
            }
            b65 b65Var = new b65();
            e eVar5 = this.g;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar5 = null;
            }
            if (eVar5.f() != null) {
                e eVar6 = this.g;
                if (eVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    eVar6 = null;
                }
                int c2 = eVar6.c();
                e eVar7 = this.g;
                if (eVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                } else {
                    eVar2 = eVar7;
                }
                Integer f = eVar2.f();
                Intrinsics.checkNotNull(f);
                b65Var.s(c2, f.intValue());
            } else {
                e eVar8 = this.g;
                if (eVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    eVar8 = null;
                }
                int e2 = eVar8.e();
                e eVar9 = this.g;
                if (eVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                } else {
                    eVar2 = eVar9;
                }
                b65Var.r(e2, SkinManager.getColor(eVar2.c()));
            }
            this.d.setConfig(b65Var);
            this.d.k();
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            EMManager from = EMManager.from(this.c);
            e eVar = this.g;
            e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar = null;
            }
            EMManager textSize = from.setTextSize(eVar.l());
            e eVar3 = this.g;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar3 = null;
            }
            EMManager textColor = textSize.setTextColor(eVar3.j());
            e eVar4 = this.g;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar4 = null;
            }
            textColor.setTextStyle(eVar4.n());
            if (i != 0) {
                if (i == 4) {
                    e eVar5 = this.g;
                    if (eVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    } else {
                        eVar2 = eVar5;
                    }
                    Integer k = eVar2.k();
                    if (k != null) {
                        this.c.setTextColor(k.intValue());
                        return;
                    }
                    return;
                }
                return;
            }
            e eVar6 = this.g;
            if (eVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            } else {
                eVar2 = eVar6;
            }
            Integer i2 = eVar2.i();
            if (i2 != null) {
                this.c.setTextColor(i2.intValue());
            }
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            EMManager from = EMManager.from(this.b);
            e eVar = this.g;
            e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar = null;
            }
            EMManager textSize = from.setTextSize(eVar.C());
            e eVar3 = this.g;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar3 = null;
            }
            EMManager textColor = textSize.setTextColor(eVar3.A());
            e eVar4 = this.g;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                eVar4 = null;
            }
            textColor.setTextStyle(eVar4.E());
            if (i != 0) {
                if (i == 4) {
                    e eVar5 = this.g;
                    if (eVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
                    } else {
                        eVar2 = eVar5;
                    }
                    Integer B = eVar2.B();
                    if (B != null) {
                        this.b.setTextColor(B.intValue());
                        return;
                    }
                    return;
                }
                return;
            }
            e eVar6 = this.g;
            if (eVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            } else {
                eVar2 = eVar6;
            }
            Integer z = eVar2.z();
            if (z != null) {
                this.b.setTextColor(z.intValue());
            }
        }
    }

    public final View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public final TextView getDescView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (TextView) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    public final Function1<Boolean, Unit> getOnVisibilityChangedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (Function1) invokeV.objValue;
    }

    public final TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.j) {
            return;
        }
        this.j = true;
        Function1<? super Boolean, Unit> function1 = this.i;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.j) {
            return;
        }
        this.j = false;
        e eVar = this.g;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar = null;
        }
        c w = eVar.w();
        if (w != null) {
            w.onDismiss();
        }
        e eVar2 = this.g;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipVieParams");
            eVar2 = null;
        }
        eVar2.W(null);
        Function1<? super Boolean, Unit> function1 = this.i;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }
}

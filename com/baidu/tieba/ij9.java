package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.dimen.TbDimenUtil;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.write.write.NewWriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class ij9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewWriteActivity a;
    public View b;
    public View c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947855569, "Lcom/baidu/tieba/ij9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947855569, "Lcom/baidu/tieba/ij9;");
        }
    }

    public ij9(NewWriteActivity mActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        this.a = mActivity;
    }

    public static final void g(ij9 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view3 = this$0.c;
            Intrinsics.checkNotNull(view3);
            view3.setVisibility(8);
            g15.u("writeSpringFestivalBless");
        }
    }

    public static final void j(ij9 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view3 = this$0.b;
            Intrinsics.checkNotNull(view3);
            view3.setVisibility(8);
            g15.u("writeVirtualGuide");
        }
    }

    public static final void k(ij9 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.a.q1("5");
        }
    }

    public static final void h(ij9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view2 = this$0.c;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            g15.u("writeSpringFestivalBless");
        }
    }

    public static final void l(ij9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view2 = this$0.b;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            g15.u("writeVirtualGuide");
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!c() && !b()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.c;
            if (view2 != null) {
                Intrinsics.checkNotNull(view2);
                if (view2.getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View view2 = this.b;
            if (view2 != null) {
                Intrinsics.checkNotNull(view2);
                if (view2.getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.a.getIntent() != null && md5.a() && f()) {
                return;
            }
            i();
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view2 = this.b;
            if (view2 != null) {
                Intrinsics.checkNotNull(view2);
                if (view2.getVisibility() == 0) {
                    View view3 = this.b;
                    Intrinsics.checkNotNull(view3);
                    view3.setVisibility(8);
                    g15.u("writeVirtualGuide");
                    return true;
                }
            }
            View view4 = this.c;
            if (view4 != null) {
                Intrinsics.checkNotNull(view4);
                if (view4.getVisibility() == 0) {
                    View view5 = this.c;
                    Intrinsics.checkNotNull(view5);
                    view5.setVisibility(8);
                    g15.u("writeSpringFestivalBless");
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (p35.m().i("key_write_spring_festival_bless_guide_has_show", false)) {
                return false;
            }
            p35.m().w("key_write_spring_festival_bless_guide_has_show", true);
            ((ViewStub) this.a.findViewById(R.id.obfuscated_res_0x7f092082)).inflate();
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f092081);
            this.c = findViewById;
            Intrinsics.checkNotNull(findViewById);
            findViewById.setVisibility(0);
            View view2 = this.c;
            Intrinsics.checkNotNull(view2);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.fj9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        ij9.g(ij9.this, view3);
                    }
                }
            });
            g15.o("writeSpringFestivalBless");
            p15 d = p15.d(this.c);
            d.e(R.string.A_X05);
            d.f(R.color.CAM_X0611);
            View view3 = this.c;
            Intrinsics.checkNotNull(view3);
            p15 d2 = p15.d(view3.findViewById(R.id.obfuscated_res_0x7f092080));
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            View view4 = this.c;
            Intrinsics.checkNotNull(view4);
            p15 d3 = p15.d((TextView) view4.findViewById(R.id.obfuscated_res_0x7f092083));
            d3.v(R.color.CAM_X0105);
            d3.A(R.string.F_X02);
            View view5 = this.c;
            Intrinsics.checkNotNull(view5);
            p15.d((TextView) view5.findViewById(R.id.obfuscated_res_0x7f09207d)).v(R.color.CAM_X0107);
            View view6 = this.c;
            Intrinsics.checkNotNull(view6);
            p15 d4 = p15.d(view6.findViewById(R.id.obfuscated_res_0x7f092085));
            d4.n(R.string.J_X07);
            d4.e(R.string.A_X10);
            d4.f(R.color.CAM_X0319);
            View view7 = this.c;
            Intrinsics.checkNotNull(view7);
            p15 d5 = p15.d((TextView) view7.findViewById(R.id.obfuscated_res_0x7f092086));
            d5.v(R.color.CAM_X0301);
            d5.A(R.string.F_X02);
            View view8 = this.c;
            Intrinsics.checkNotNull(view8);
            View findViewById2 = view8.findViewById(R.id.obfuscated_res_0x7f09207e);
            if (this.a.k instanceof nm9) {
                ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
                if (layoutParams != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.setMarginStart(TbDimenUtil.dp2px(this.a.getApplicationContext(), 12.0f));
                    layoutParams2.setMargins(0, TbDimenUtil.dp2px(this.a.getApplicationContext(), 20.0f), 0, TbDimenUtil.dp2px(this.a.getApplicationContext(), 8.0f));
                    findViewById2.setLayoutParams(layoutParams2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
            p15 d6 = p15.d(findViewById2);
            d6.n(R.string.J_X07);
            d6.f(R.color.CAM_X0205);
            View view9 = this.c;
            Intrinsics.checkNotNull(view9);
            p15.d((TextView) view9.findViewById(R.id.obfuscated_res_0x7f09207f)).v(R.color.CAM_X0105);
            View view10 = this.c;
            Intrinsics.checkNotNull(view10);
            WebPManager.setPureDrawable((ImageView) view10.findViewById(R.id.obfuscated_res_0x7f092087), R.drawable.icon_pure_post_chosen12, R.color.CAM_X0301, null);
            View view11 = this.c;
            Intrinsics.checkNotNull(view11);
            view11.postDelayed(new Runnable() { // from class: com.baidu.tieba.dj9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ij9.h(ij9.this);
                    }
                }
            }, 4000L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            boolean i = p35.m().i("key_virtual_image_setting_guide_has_show", false);
            if (b() || i) {
                return false;
            }
            p35.m().w("key_virtual_image_setting_guide_has_show", true);
            ((ViewStub) this.a.findViewById(R.id.obfuscated_res_0x7f09275f)).inflate();
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f09275e);
            this.b = findViewById;
            Intrinsics.checkNotNull(findViewById);
            findViewById.setVisibility(0);
            View view2 = this.b;
            Intrinsics.checkNotNull(view2);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ej9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        ij9.j(ij9.this, view3);
                    }
                }
            });
            g15.o("writeVirtualGuide");
            p15 d = p15.d(this.b);
            d.e(R.string.A_X05);
            d.f(R.color.CAM_X0611);
            View view3 = this.b;
            Intrinsics.checkNotNull(view3);
            p15 d2 = p15.d(view3.findViewById(R.id.obfuscated_res_0x7f09275b));
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            View view4 = this.b;
            Intrinsics.checkNotNull(view4);
            View findViewById2 = view4.findViewById(R.id.obfuscated_res_0x7f09275a);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mVirtualImageGuideView!!…_image_setting_guide_img)");
            ((GifView) findViewById2).setGifRaw(R.raw.obfuscated_res_0x7f110079);
            View view5 = this.b;
            Intrinsics.checkNotNull(view5);
            View findViewById3 = view5.findViewById(R.id.obfuscated_res_0x7f092758);
            if (this.a.k instanceof nm9) {
                ViewGroup.LayoutParams layoutParams = findViewById3.getLayoutParams();
                if (layoutParams != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.setMarginStart(TbDimenUtil.dp2px(this.a.getApplicationContext(), 100.0f));
                    layoutParams2.setMargins(0, TbDimenUtil.dp2px(this.a.getApplicationContext(), 20.0f), 0, TbDimenUtil.dp2px(this.a.getApplicationContext(), 8.0f));
                    findViewById3.setLayoutParams(layoutParams2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
            p15 d3 = p15.d(findViewById3);
            d3.n(R.string.J_X07);
            d3.f(R.color.CAM_X0205);
            ProfileVirtualImageInfo profileVirtualImageInfo = ProfileVirtualImageInfo.getInstance();
            View view6 = this.b;
            Intrinsics.checkNotNull(view6);
            p15.d((TextView) view6.findViewById(R.id.obfuscated_res_0x7f09275c)).v(R.color.CAM_X0105);
            View view7 = this.b;
            Intrinsics.checkNotNull(view7);
            p15.d((TextView) view7.findViewById(R.id.obfuscated_res_0x7f092759)).v(R.color.CAM_X0105);
            View view8 = this.b;
            Intrinsics.checkNotNull(view8);
            TextView textView = (TextView) view8.findViewById(R.id.obfuscated_res_0x7f092756);
            if (profileVirtualImageInfo != null && profileVirtualImageInfo.getIsSetVirtualImage() == 1) {
                textView.setVisibility(8);
            } else {
                p15 d4 = p15.d(textView);
                d4.A(R.string.F_X01);
                d4.z(R.dimen.T_X07);
                d4.v(R.color.CAM_X0304);
                d4.n(R.string.J_X07);
                d4.l(R.dimen.L_X02);
                d4.k(R.color.CAM_X0304);
                d4.j(R.string.A_X07);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.bj9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view9) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view9) == null) {
                            ij9.k(ij9.this, view9);
                        }
                    }
                });
            }
            View view9 = this.b;
            Intrinsics.checkNotNull(view9);
            view9.postDelayed(new Runnable() { // from class: com.baidu.tieba.cj9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ij9.l(ij9.this);
                    }
                }
            }, 4000L);
            return true;
        }
        return invokeV.booleanValue;
    }
}

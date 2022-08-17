package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.funad.view.FunAdAgreeView;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunNativeAd2;
import com.repackage.cv4;
import com.repackage.e25;
import com.repackage.et6;
import com.repackage.f47;
import com.repackage.fj8;
import com.repackage.g25;
import com.repackage.hs7;
import com.repackage.ms4;
import com.repackage.qi;
import com.repackage.rs6;
import com.repackage.zk8;
import com.repackage.zs6;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class FunAdNativeFrsView extends FunAdNativePbView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View B;
    public ImageView C;
    public TextView D;
    public ViewGroup E;
    public ImageView F;
    public String G;
    public LinearLayout t;
    public RoundTbImageView u;
    public TextView v;
    public TextView w;
    public FunAdAgreeView x;
    public View y;
    public ImageView z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk8 a;
        public final /* synthetic */ FunAdNativeFrsView b;

        public a(FunAdNativeFrsView funAdNativeFrsView, zk8 zk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeFrsView, zk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = funAdNativeFrsView;
            this.a = zk8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.x.q()) {
                return;
            }
            this.b.p(this.a, view2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements FunAdAgreeView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ et6 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ FunAdNativeFrsView c;

        /* loaded from: classes3.dex */
        public class a implements e25 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.repackage.e25
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.c.x.setAgreeNumViewIsShow(false);
                    Rect rect = new Rect();
                    this.a.c.x.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.i(false);
                    b bVar = this.a;
                    bVar.a.j(bVar.b.findViewById(16908290), list, rect);
                }
            }
        }

        public b(FunAdNativeFrsView funAdNativeFrsView, et6 et6Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeFrsView, et6Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = funAdNativeFrsView;
            this.a = et6Var;
            this.b = activity;
        }

        @Override // com.baidu.tieba.funad.view.FunAdAgreeView.h
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k(this.c.t, this.c.x);
                g25.g().c(new a(this));
            }
        }

        @Override // com.baidu.tieba.funad.view.FunAdAgreeView.h
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.x.setAgreeNumViewIsShow(true);
                this.a.h(this.c.x);
                this.a.l();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativeFrsView(Context context) {
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
    }

    private void setTextGrayAndUnClickable(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, textView) == null) {
            textView.setTextColor(fj8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public ViewGroup c(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, funNativeAd2)) == null) ? this.t : (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.t.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            super.e(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull zk8 zk8Var, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, zk8Var, activity) == null) {
            super.f(zk8Var, activity);
            if (zk8Var.e() == null) {
                return;
            }
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) zk8Var.e();
            if (zk8Var.b() == null) {
                AgreeData agreeData = new AgreeData();
                agreeData.agreeNum = f47.a(25, 1000);
                zk8Var.k(agreeData);
            }
            this.w.setText(this.c);
            AgreeData b2 = zk8Var.b();
            this.x.setAgreeAlone(true);
            this.x.setData(b2);
            this.x.setAfterClickListener(new a(this, zk8Var));
            this.x.setUseDynamicLikeRes(zk8Var.d(), "/feed", "frs".equals(this.G));
            this.x.setAgreeLongClickListener(new b(this, new et6(activity), activity));
            this.u.K(zs6.j(funNativeAd2), 10, false);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            super.g(context);
            this.t = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c1f);
            this.u = (RoundTbImageView) findViewById(R.id.obfuscated_res_0x7f09222d);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f09222e);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f09222c);
            this.x = (FunAdAgreeView) findViewById(R.id.obfuscated_res_0x7f090084);
            this.y = findViewById(R.id.obfuscated_res_0x7f091e43);
            this.B = findViewById(R.id.obfuscated_res_0x7f09213e);
            this.C = (ImageView) findViewById(R.id.obfuscated_res_0x7f092140);
            this.D = (TextView) findViewById(R.id.obfuscated_res_0x7f092141);
            this.z = (ImageView) findViewById(R.id.obfuscated_res_0x7f091e44);
            this.A = (TextView) findViewById(R.id.obfuscated_res_0x7f091e42);
            this.E = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09125b);
            this.F = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c1d);
            this.s = (VipAdFreeGuideLayout) findViewById(R.id.obfuscated_res_0x7f090c31);
            this.e.setVisibility(8);
            q(this.u);
            o();
            RelativeLayout relativeLayout = this.d;
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), this.d.getPaddingTop(), this.d.getPaddingRight(), 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Arrays.asList(this, this.d, this.i, this.l, this.q, this.E) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.F : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.layout.obfuscated_res_0x7f0d0357 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public rs6.g getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return rs6.b("frs", UbsABTestHelper.isFrsFunAdSdkTest() ? "1" : "0");
        }
        return (rs6.g) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public VipAdFreeGuideLayout getVipAdFreeGuideLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : (VipAdFreeGuideLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.h();
            ms4.d(this).f(R.color.CAM_X0205);
            ms4 d = ms4.d(this);
            d.n(R.string.J_X06);
            d.i(R.color.CAM_X0205, R.color.CAM_X0206);
            ms4.d(this.v).v(R.color.CAM_X0109);
            ms4.d(this.w).v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.F, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            cv4.a(this.z, R.drawable.obfuscated_res_0x7f080918);
            cv4.a(this.C, R.drawable.obfuscated_res_0x7f080914);
            cv4.e(this.A);
            cv4.e(this.D);
            r(this.z, R.drawable.obfuscated_res_0x7f080918);
            r(this.C, R.drawable.obfuscated_res_0x7f080914);
            setTextGrayAndUnClickable(this.A);
            setTextGrayAndUnClickable(this.D);
            this.u.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.x.t(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView
    public void i(@NonNull FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, funNativeAd2) == null) {
            super.i(funNativeAd2);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.x.getLayoutParams();
            int i = layoutParams.width;
            if (layoutParams.weight != 1.0f || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.x.setLayoutParams(layoutParams);
            }
            this.x.r(true);
        }
    }

    public final void p(zk8 zk8Var, View view2) {
        Activity currentActivity;
        int width;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, zk8Var, view2) == null) || this.x.getData() == null || !this.x.getData().hasAgree || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || currentActivity.isFinishing()) {
            return;
        }
        hs7 hs7Var = new hs7(getContext());
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int f = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds600);
        int f2 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
        int i3 = (int) ((f2 * 1) / 1.45d);
        if (i > i3) {
            width = ((i - i3) + (this.x.getImgAgree().getWidth() / 2)) - 10;
        } else {
            width = (i - i3) + (this.x.getImgAgree().getWidth() / 2);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f);
        layoutParams.leftMargin = width;
        layoutParams.topMargin = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
        hs7Var.k(f);
        hs7Var.j(layoutParams);
        hs7Var.i(false);
        hs7Var.n("frs".equals(this.G), TbadkCoreApplication.getInst().getCurrentActivity().findViewById(16908290), 0, i2 - 10, zk8Var.g(), zk8Var.d());
    }

    public final void q(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tbImageView) == null) {
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f080709);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setIsLongPic(false);
            tbImageView.setIsSmartCrop(false);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
        }
    }

    public final void r(ImageView imageView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, imageView, i) == null) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(i, fj8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_DISABLE));
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setCurpage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.G = str;
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdMaskViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (linearLayout = this.t) == null) {
            return;
        }
        linearLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativeFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativeFrsView(Context context, AttributeSet attributeSet, int i) {
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
    }
}

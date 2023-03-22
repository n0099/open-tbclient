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
import com.baidu.tieba.ga7;
import com.baidu.tieba.ga9;
import com.baidu.tieba.hi;
import com.baidu.tieba.ib5;
import com.baidu.tieba.kb5;
import com.baidu.tieba.mh8;
import com.baidu.tieba.n15;
import com.baidu.tieba.oa7;
import com.baidu.tieba.ta7;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.vl7;
import com.baidu.tieba.x35;
import com.baidu.tieba.zb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunNativeAd2;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
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

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.layout.obfuscated_res_0x7f0d037c : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdMaskViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements FunAdAgreeView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta7 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ FunAdNativeFrsView c;

        /* loaded from: classes4.dex */
        public class a implements ib5 {
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

            @Override // com.baidu.tieba.ib5
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

        public b(FunAdNativeFrsView funAdNativeFrsView, ta7 ta7Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeFrsView, ta7Var, activity};
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
            this.a = ta7Var;
            this.b = activity;
        }

        @Override // com.baidu.tieba.funad.view.FunAdAgreeView.h
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k(this.c.t, this.c.x);
                kb5.g().c(new a(this));
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zb9 a;
        public final /* synthetic */ FunAdNativeFrsView b;

        public a(FunAdNativeFrsView funAdNativeFrsView, zb9 zb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeFrsView, zb9Var};
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
            this.a = zb9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.x.q()) {
                return;
            }
            this.b.p(this.a, view2);
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

    public final void q(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tbImageView) == null) {
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f080770);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setIsLongPic(false);
            tbImageView.setIsSmartCrop(false);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
        }
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

    private void setTextGrayAndUnClickable(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, textView) == null) {
            textView.setTextColor(ga9.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public ViewGroup c(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, funNativeAd2)) == null) {
            return this.t;
        }
        return (ViewGroup) invokeL.objValue;
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

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView
    public void i(@NonNull FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, funNativeAd2) == null) {
            super.i(funNativeAd2);
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
    public void setFunAdViewVisible(boolean z) {
        LinearLayout linearLayout;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (linearLayout = this.t) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull zb9 zb9Var, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, zb9Var, activity) == null) {
            super.f(zb9Var, activity);
            if (zb9Var.e() == null) {
                return;
            }
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) zb9Var.e();
            if (zb9Var.b() == null) {
                AgreeData agreeData = new AgreeData();
                agreeData.agreeNum = vl7.a(25, 1000);
                zb9Var.k(agreeData);
            }
            this.w.setText(this.c);
            AgreeData b2 = zb9Var.b();
            this.x.setAgreeAlone(true);
            this.x.setData(b2);
            this.x.setAfterClickListener(new a(this, zb9Var));
            this.x.setUseDynamicLikeRes(zb9Var.d(), "/feed", "frs".equals(this.G));
            this.x.setAgreeLongClickListener(new b(this, new ta7(activity), activity));
            this.u.M(oa7.j(funNativeAd2), 10, false);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            super.g(context);
            this.t = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090d42);
            this.u = (RoundTbImageView) findViewById(R.id.obfuscated_res_0x7f092473);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f092474);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f092472);
            this.x = (FunAdAgreeView) findViewById(R.id.obfuscated_res_0x7f090088);
            this.y = findViewById(R.id.share_num_container);
            this.B = findViewById(R.id.thread_info_commont_container);
            this.C = (ImageView) findViewById(R.id.thread_info_commont_img);
            this.D = (TextView) findViewById(R.id.thread_info_commont_num);
            this.z = (ImageView) findViewById(R.id.share_num_img);
            this.A = (TextView) findViewById(R.id.share_num);
            this.E = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0913e3);
            this.F = (ImageView) findViewById(R.id.obfuscated_res_0x7f090d40);
            this.s = (VipAdFreeGuideLayout) findViewById(R.id.obfuscated_res_0x7f090d54);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return Arrays.asList(this, this.d, this.i, this.l, this.q, this.E);
        }
        return (List) invokeV.objValue;
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

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.F;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public ga7.g getLogItem() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (UbsABTestHelper.isFrsFunAdSdkTest()) {
                str = "1";
            } else {
                str = "0";
            }
            return ga7.b("frs", str);
        }
        return (ga7.g) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public VipAdFreeGuideLayout getVipAdFreeGuideLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.s;
        }
        return (VipAdFreeGuideLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.h();
            n15.d(this).f(R.color.CAM_X0205);
            n15 d = n15.d(this);
            d.o(R.string.J_X06);
            d.j(R.color.CAM_X0205, R.color.CAM_X0206);
            n15.d(this.v).w(R.color.CAM_X0109);
            n15.d(this.w).w(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.F, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            x35.a(this.z, R.drawable.icon_pure_card_share20);
            x35.a(this.C, R.drawable.icon_pure_card_comment20);
            x35.e(this.A);
            x35.e(this.D);
            r(this.z, R.drawable.icon_pure_card_share20);
            r(this.C, R.drawable.icon_pure_card_comment20);
            setTextGrayAndUnClickable(this.A);
            setTextGrayAndUnClickable(this.D);
            this.u.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.x.t(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void p(zb9 zb9Var, View view2) {
        Activity currentActivity;
        int width;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, zb9Var, view2) == null) && this.x.getData() != null && this.x.getData().hasAgree && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !currentActivity.isFinishing()) {
            mh8 mh8Var = new mh8(getContext());
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int g = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds600);
            int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            int i3 = (int) ((g2 * 1) / 1.45d);
            if (i > i3) {
                width = ((i - i3) + (this.x.getImgAgree().getWidth() / 2)) - 10;
            } else {
                width = (i - i3) + (this.x.getImgAgree().getWidth() / 2);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g);
            layoutParams.leftMargin = width;
            layoutParams.topMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
            mh8Var.k(g);
            mh8Var.j(layoutParams);
            mh8Var.i(false);
            mh8Var.n("frs".equals(this.G), TbadkCoreApplication.getInst().getCurrentActivity().findViewById(16908290), 0, i2 - 10, zb9Var.g(), zb9Var.d());
        }
    }

    public final void r(ImageView imageView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, imageView, i) == null) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(i, ga9.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_DISABLE));
        }
    }
}

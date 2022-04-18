package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunNativeAd;
import com.repackage.bl8;
import com.repackage.es6;
import com.repackage.eu4;
import com.repackage.fr7;
import com.repackage.gj8;
import com.repackage.k37;
import com.repackage.oi;
import com.repackage.vr4;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class FunAdNativeFrsView extends FunAdNativePbView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public ImageView B;
    public TextView C;
    public ViewGroup D;
    public ImageView E;
    public String F;
    public LinearLayout s;
    public RoundTbImageView t;
    public TextView u;
    public TextView v;
    public FunAdAgreeView w;
    public View x;
    public ImageView y;
    public TextView z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bl8 a;
        public final /* synthetic */ FunAdNativeFrsView b;

        public a(FunAdNativeFrsView funAdNativeFrsView, bl8 bl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeFrsView, bl8Var};
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
            this.a = bl8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && UbsABTestHelper.isLikeModifyTestA()) {
                this.b.n(this.a, view2);
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, textView) == null) {
            textView.setTextColor(gj8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.s.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            super.e(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull bl8 bl8Var, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bl8Var, activity) == null) {
            super.f(bl8Var, activity);
            if (bl8Var.d() == null) {
                return;
            }
            FunNativeAd funNativeAd = (FunNativeAd) bl8Var.d();
            if (bl8Var.a() == null) {
                AgreeData agreeData = new AgreeData();
                agreeData.agreeNum = k37.a(25, 1000);
                bl8Var.h(agreeData);
            }
            this.v.setText(this.c);
            AgreeData a2 = bl8Var.a();
            this.w.setAgreeAlone(true);
            this.w.setData(a2);
            this.w.setAfterClickListener(new a(this, bl8Var));
            if (UbsABTestHelper.isLikeModifyTestA()) {
                this.w.setUseDynamicLikeRes(bl8Var.c(), "/feed", "frs".equals(this.F));
            }
            this.t.K(funNativeAd.getIconUrl(), 10, false);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            super.g(context);
            this.s = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c1f);
            this.t = (RoundTbImageView) findViewById(R.id.obfuscated_res_0x7f092087);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f092088);
            this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f092086);
            this.w = (FunAdAgreeView) findViewById(R.id.obfuscated_res_0x7f090081);
            this.x = findViewById(R.id.obfuscated_res_0x7f091cba);
            this.A = findViewById(R.id.obfuscated_res_0x7f091f99);
            this.B = (ImageView) findViewById(R.id.obfuscated_res_0x7f091f9b);
            this.C = (TextView) findViewById(R.id.obfuscated_res_0x7f091f9c);
            this.y = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cbb);
            this.z = (TextView) findViewById(R.id.obfuscated_res_0x7f091cb9);
            this.D = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0911bf);
            this.E = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c1d);
            this.e.setVisibility(8);
            o(this.t);
            m();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Arrays.asList(this, this.d, this.i, this.l, this.q, this.D) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.E : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.layout.obfuscated_res_0x7f0d0364 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public es6.g getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return es6.b("frs", UbsABTestHelper.isFrsFunAdSdkTest() ? "1" : "0");
        }
        return (es6.g) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.h();
            vr4.d(this).f(R.color.CAM_X0205);
            vr4 d = vr4.d(this);
            d.n(R.string.J_X06);
            d.i(R.color.CAM_X0205, R.color.CAM_X0206);
            vr4.d(this.u).v(R.color.CAM_X0109);
            vr4.d(this.v).v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.E, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            eu4.a(this.y, R.drawable.obfuscated_res_0x7f0808f5);
            eu4.a(this.B, R.drawable.obfuscated_res_0x7f0808f1);
            eu4.e(this.z);
            eu4.e(this.C);
            p(this.y, R.drawable.obfuscated_res_0x7f0808f5);
            p(this.B, R.drawable.obfuscated_res_0x7f0808f1);
            setTextGrayAndUnClickable(this.z);
            setTextGrayAndUnClickable(this.C);
            this.t.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.w.n(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView
    public void i(@NonNull FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, funNativeAd) == null) {
            super.i(funNativeAd);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.w.getLayoutParams();
            int i = layoutParams.width;
            if (layoutParams.weight != 1.0f || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.w.setLayoutParams(layoutParams);
            }
            this.w.m(true);
        }
    }

    public final void n(bl8 bl8Var, View view2) {
        Activity currentActivity;
        int width;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, bl8Var, view2) == null) || this.w.getData() == null || !this.w.getData().hasAgree || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || currentActivity.isFinishing()) {
            return;
        }
        fr7 fr7Var = new fr7(getContext());
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int f = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds600);
        int f2 = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
        int i3 = (int) ((f2 * 1) / 1.45d);
        if (i > i3) {
            width = ((i - i3) + (this.w.getImgAgree().getWidth() / 2)) - 10;
        } else {
            width = (i - i3) + (this.w.getImgAgree().getWidth() / 2);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f);
        layoutParams.leftMargin = width;
        layoutParams.topMargin = oi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
        fr7Var.j(f);
        fr7Var.i(layoutParams);
        fr7Var.h(false);
        fr7Var.l("frs".equals(this.F), TbadkCoreApplication.getInst().getCurrentActivity().findViewById(16908290), 0, i2 - 10, bl8Var.e(), bl8Var.c());
    }

    public final void o(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tbImageView) == null) {
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f08071b);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setIsLongPic(false);
            tbImageView.setIsSmartCrop(false);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
        }
    }

    public final void p(ImageView imageView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, imageView, i) == null) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(i, gj8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_DISABLE));
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setCurpage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.F = str;
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (linearLayout = this.s) == null) {
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

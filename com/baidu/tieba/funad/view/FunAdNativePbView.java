package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunNativeAd2;
import com.kwad.sdk.api.KsNativeAd;
import com.repackage.hr6;
import com.repackage.mi8;
import com.repackage.mr6;
import com.repackage.ur4;
import com.repackage.zq6;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class FunAdNativePbView extends FunAbsAdView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout d;
    public View e;
    public ViewGroup f;
    public FunAdSmallPicView g;
    public ViewGroup h;
    public CardView i;
    public FunAdNativePicView j;
    public EMTextView k;
    public TextView l;
    public LinearLayout m;
    public ImageView n;
    public TextView o;
    public ImageView p;
    public FunAdButton q;
    public FunAdButton r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativePbView(Context context) {
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

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q.h();
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public ViewGroup c(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funNativeAd2)) == null) ? this.d : (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.d.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            if (bdUniqueId != AdvertAppInfo.E && bdUniqueId != AdvertAppInfo.F) {
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull mi8 mi8Var, @NonNull Activity activity) {
        List<String> list;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, mi8Var, activity) == null) || mi8Var.d() == null) {
            return;
        }
        FunNativeAd2 funNativeAd2 = (FunNativeAd2) mi8Var.d();
        hr6.C(funNativeAd2);
        if (funNativeAd2 == null || funNativeAd2.getNativeInfo() == null) {
            list = null;
            str = "";
        } else {
            this.c = funNativeAd2.getNativeInfo().getTitle();
            str = funNativeAd2.getNativeInfo().getDescription();
            list = funNativeAd2.getNativeInfo().getImageUrls();
        }
        if (StringUtils.isNull(this.c) || this.c.equals(activity.getString(R.string.obfuscated_res_0x7f0f077e))) {
            this.c = activity.getString(R.string.obfuscated_res_0x7f0f0781);
        }
        this.l.setText(this.c);
        this.k.setText(str);
        this.i.removeAllViews();
        if (hr6.z(funNativeAd2, list)) {
            this.f.setVisibility(8);
            this.g.setVisibility(0);
            this.g.setData(funNativeAd2, (String) ListUtils.getItem(list, 0));
            return;
        }
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        if (hr6.m(funNativeAd2) != null) {
            hr6.J(this.h, hr6.B(funNativeAd2));
            this.i.addView(hr6.m(funNativeAd2), new ViewGroup.LayoutParams(-1, -1));
            this.i.setVisibility(0);
            this.j.setVisibility(8);
        } else {
            hr6.H(this.h, hr6.A(funNativeAd2, list), list);
            this.i.setVisibility(8);
            this.j.setFunNativeAd(list);
        }
        i(funNativeAd2);
        if (StringUtils.isNull(mi8Var.b())) {
            mi8Var.i(hr6.o(funNativeAd2, activity));
        }
        this.q.setText(mi8Var.b());
        j(hr6.y(funNativeAd2));
        k(funNativeAd2, mi8Var);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090bf7);
            this.e = findViewById(R.id.obfuscated_res_0x7f0907e1);
            this.k = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090bf6);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090be6);
            this.h = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09142b);
            this.i = (CardView) findViewById(R.id.obfuscated_res_0x7f091433);
            this.j = (FunAdNativePicView) findViewById(R.id.obfuscated_res_0x7f091434);
            this.g = (FunAdSmallPicView) findViewById(R.id.obfuscated_res_0x7f091432);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090bf5);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090bf2);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f090bef);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090bf1);
            this.q = (FunAdButton) findViewById(R.id.obfuscated_res_0x7f090be3);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f090be8);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Arrays.asList(this, this.d, this.i, this.l, this.q) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getCreativeViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Collections.singletonList(this.q) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.obfuscated_res_0x7f0d0357 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public zq6.g getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return zq6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0");
        }
        return (zq6.g) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            WebPManager.setPureDrawable(this.p, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            ur4.d(this.k).v(R.color.CAM_X0105);
            ur4.d(this.l).v(R.color.CAM_X0109);
            ur4.d(this.o).v(R.color.CAM_X0101);
            ur4 d = ur4.d(this.m);
            d.n(R.string.J_X01);
            d.f(R.color.CAM_X0606);
            this.q.g();
            this.j.d();
            this.g.c();
        }
    }

    public void i(@NonNull FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, funNativeAd2) == null) {
            hr6.L(this.n, funNativeAd2);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.q.setVisibility(0);
            this.r = this.q;
        }
    }

    public final void k(@NonNull FunNativeAd2 funNativeAd2, mi8 mi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, funNativeAd2, mi8Var) == null) {
            ChannelNativeAds d = hr6.d(funNativeAd2);
            this.r.setTag(mi8Var);
            mr6 mr6Var = new mr6(this.r, mi8Var, d);
            if (d != null) {
                Object obj = d.ksNative;
                if (obj instanceof KsNativeAd) {
                    ((KsNativeAd) obj).setDownloadListener(mr6Var);
                    return;
                }
            }
            if (d != null) {
                Object obj2 = d.csjNative;
                if (obj2 instanceof TTNativeAd) {
                    ((TTNativeAd) obj2).setDownloadListener(mr6Var);
                    return;
                }
            }
            if (d == null || d.gdtNative == null) {
                return;
            }
            d.setGdtADStatusChangeListener(mr6Var);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setCurpage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFeedBackListener(View.OnClickListener onClickListener) {
        FunAdSmallPicView funAdSmallPicView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) || (funAdSmallPicView = this.g) == null) {
            return;
        }
        funAdSmallPicView.setFeedBackListener(onClickListener);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (relativeLayout = this.d) == null) {
            return;
        }
        relativeLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativePbView(Context context, AttributeSet attributeSet) {
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
    public FunAdNativePbView(Context context, AttributeSet attributeSet, int i) {
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

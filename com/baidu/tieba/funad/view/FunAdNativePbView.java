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
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
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
import com.repackage.dt6;
import com.repackage.ms4;
import com.repackage.rs6;
import com.repackage.zk8;
import com.repackage.zs6;
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
    public VipAdFreeGuideLayout s;

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
            if (bdUniqueId != AdvertAppInfo.H && bdUniqueId != AdvertAppInfo.I) {
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull zk8 zk8Var, @NonNull Activity activity) {
        List<String> list;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, zk8Var, activity) == null) || zk8Var.e() == null) {
            return;
        }
        FunNativeAd2 funNativeAd2 = (FunNativeAd2) zk8Var.e();
        zs6.C(funNativeAd2);
        if (funNativeAd2 == null || funNativeAd2.getNativeInfo() == null) {
            list = null;
            str = "";
        } else {
            this.c = funNativeAd2.getNativeInfo().getTitle();
            str = funNativeAd2.getNativeInfo().getDescription();
            list = funNativeAd2.getNativeInfo().getImageUrls();
        }
        if (StringUtils.isNull(this.c) || this.c.equals(activity.getString(R.string.obfuscated_res_0x7f0f0789))) {
            this.c = activity.getString(R.string.obfuscated_res_0x7f0f078c);
        }
        this.l.setText(this.c);
        this.k.setText(str);
        this.i.removeAllViews();
        if (zs6.z(funNativeAd2, list)) {
            this.f.setVisibility(8);
            this.g.setVisibility(0);
            this.g.setData(funNativeAd2, (String) ListUtils.getItem(list, 0));
            return;
        }
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        if (zs6.m(funNativeAd2) != null) {
            zs6.J(this.h, zs6.B(funNativeAd2));
            this.i.addView(zs6.m(funNativeAd2), new ViewGroup.LayoutParams(-1, -1));
            this.i.setVisibility(0);
            this.j.setVisibility(8);
        } else {
            zs6.H(this.h, zs6.A(funNativeAd2, list), list);
            this.i.setVisibility(8);
            this.j.setFunNativeAd(list);
        }
        i(funNativeAd2);
        if (StringUtils.isNull(zk8Var.c())) {
            zk8Var.l(zs6.o(funNativeAd2, activity));
        }
        this.q.setText(zk8Var.c());
        j(zs6.y(funNativeAd2));
        k(funNativeAd2, zk8Var);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090c2e);
            this.e = findViewById(R.id.obfuscated_res_0x7f09080d);
            this.k = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090c2d);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090c1c);
            this.h = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914ae);
            this.i = (CardView) findViewById(R.id.obfuscated_res_0x7f0914b6);
            this.j = (FunAdNativePicView) findViewById(R.id.obfuscated_res_0x7f0914b7);
            this.g = (FunAdSmallPicView) findViewById(R.id.obfuscated_res_0x7f0914b5);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090c2c);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c28);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c25);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090c27);
            this.q = (FunAdButton) findViewById(R.id.obfuscated_res_0x7f090c18);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c1e);
            this.s = (VipAdFreeGuideLayout) findViewById(R.id.obfuscated_res_0x7f090c32);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.obfuscated_res_0x7f0d0359 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public rs6.g getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return rs6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0");
        }
        return (rs6.g) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public VipAdFreeGuideLayout getVipAdFreeGuideLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.s : (VipAdFreeGuideLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            WebPManager.setPureDrawable(this.p, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            ms4.d(this.k).v(R.color.CAM_X0105);
            ms4.d(this.l).v(R.color.CAM_X0109);
            ms4.d(this.o).v(R.color.CAM_X0101);
            ms4 d = ms4.d(this.m);
            d.n(R.string.J_X01);
            d.f(R.color.CAM_X0606);
            this.q.g();
            this.j.d();
            this.g.c();
        }
    }

    public void i(@NonNull FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, funNativeAd2) == null) {
            zs6.L(this.n, funNativeAd2);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.q.setVisibility(0);
            this.r = this.q;
        }
    }

    public final void k(@NonNull FunNativeAd2 funNativeAd2, zk8 zk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, funNativeAd2, zk8Var) == null) {
            ChannelNativeAds d = zs6.d(funNativeAd2);
            this.r.setTag(zk8Var);
            dt6 dt6Var = new dt6(this.r, zk8Var, d);
            if (d != null) {
                Object obj = d.ksNative;
                if (obj instanceof KsNativeAd) {
                    ((KsNativeAd) obj).setDownloadListener(dt6Var);
                    return;
                }
            }
            if (d != null) {
                Object obj2 = d.csjNative;
                if (obj2 instanceof TTNativeAd) {
                    ((TTNativeAd) obj2).setDownloadListener(dt6Var);
                    return;
                }
            }
            if (d == null || d.gdtNative == null) {
                return;
            }
            d.setGdtADStatusChangeListener(dt6Var);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setCurpage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFeedBackListener(View.OnClickListener onClickListener) {
        FunAdSmallPicView funAdSmallPicView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) || (funAdSmallPicView = this.g) == null) {
            return;
        }
        funAdSmallPicView.setFeedBackListener(onClickListener);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdMaskViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (relativeLayout = this.d) == null) {
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

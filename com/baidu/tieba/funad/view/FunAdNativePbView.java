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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.gx7;
import com.baidu.tieba.kx7;
import com.baidu.tieba.xfa;
import com.baidu.tieba.yw7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunNativeAd2;
import com.kwad.sdk.api.KsNativeAd;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
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

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.obfuscated_res_0x7f0d03b5 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setCurpage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdMaskViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

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

    public final void k(@NonNull FunNativeAd2 funNativeAd2, xfa xfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, funNativeAd2, xfaVar) == null) {
            ChannelNativeAds d = gx7.d(funNativeAd2);
            this.r.setTag(xfaVar);
            kx7 kx7Var = new kx7(this.r, xfaVar, d);
            if (d != null) {
                Object obj = d.ksNative;
                if (obj instanceof KsNativeAd) {
                    ((KsNativeAd) obj).setDownloadListener(kx7Var);
                    return;
                }
            }
            if (d != null) {
                Object obj2 = d.csjNative;
                if (obj2 instanceof TTNativeAd) {
                    ((TTNativeAd) obj2).setDownloadListener(kx7Var);
                    return;
                }
            }
            if (d != null && d.gdtNative != null) {
                d.setGdtADStatusChangeListener(kx7Var);
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

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q.h();
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return Arrays.asList(this, this.d, this.i, this.l, this.q);
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getCreativeViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return Collections.singletonList(this.q);
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public yw7.f getLogItem() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                str = "1";
            } else {
                str = "0";
            }
            return yw7.b("pb", str);
        }
        return (yw7.f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public VipAdFreeGuideLayout getVipAdFreeGuideLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.s;
        }
        return (VipAdFreeGuideLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public ViewGroup c(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funNativeAd2)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeL.objValue;
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
            if (bdUniqueId != AdvertAppInfo.I && bdUniqueId != AdvertAppInfo.J) {
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
        }
    }

    public void i(@NonNull FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, funNativeAd2) == null) {
            gx7.L(this.n, funNativeAd2);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.q.setVisibility(0);
            this.r = this.q;
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFeedBackListener(View.OnClickListener onClickListener) {
        FunAdSmallPicView funAdSmallPicView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) && (funAdSmallPicView = this.g) != null) {
            funAdSmallPicView.setFeedBackListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        RelativeLayout relativeLayout;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (relativeLayout = this.d) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            relativeLayout.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull xfa xfaVar, @NonNull Activity activity) {
        List<String> list;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, xfaVar, activity) != null) || xfaVar.e() == null) {
            return;
        }
        FunNativeAd2 funNativeAd2 = (FunNativeAd2) xfaVar.e();
        gx7.C(funNativeAd2);
        if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
            this.c = funNativeAd2.getNativeInfo().getTitle();
            str = funNativeAd2.getNativeInfo().getDescription();
            list = funNativeAd2.getNativeInfo().getImageUrls();
        } else {
            list = null;
            str = "";
        }
        if (StringUtils.isNull(this.c) || this.c.equals(activity.getString(R.string.obfuscated_res_0x7f0f08b2))) {
            this.c = activity.getString(R.string.obfuscated_res_0x7f0f08b5);
        }
        this.l.setText(this.c);
        this.k.setText(str);
        this.i.removeAllViews();
        if (gx7.z(funNativeAd2, list)) {
            this.f.setVisibility(8);
            this.g.setVisibility(0);
            this.g.setData(funNativeAd2, (String) ListUtils.getItem(list, 0));
            return;
        }
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        if (gx7.m(funNativeAd2) != null) {
            gx7.J(this.h, gx7.B(funNativeAd2));
            View m = gx7.m(funNativeAd2);
            if (m.getParent() != null && (m.getParent() instanceof ViewGroup)) {
                ((ViewGroup) m.getParent()).removeView(m);
            }
            this.i.addView(m, new ViewGroup.LayoutParams(-1, -1));
            this.i.setVisibility(0);
            this.j.setVisibility(8);
        } else {
            gx7.H(this.h, gx7.A(funNativeAd2, list), list);
            this.i.setVisibility(8);
            this.j.setFunNativeAd(list);
        }
        i(funNativeAd2);
        if (StringUtils.isNull(xfaVar.c())) {
            xfaVar.l(gx7.o(funNativeAd2, activity));
        }
        this.q.setText(xfaVar.c());
        j(gx7.y(funNativeAd2));
        k(funNativeAd2, xfaVar);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090dca);
            this.e = findViewById(R.id.obfuscated_res_0x7f090925);
            this.k = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090dc9);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090db7);
            this.h = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091713);
            this.i = (CardView) findViewById(R.id.obfuscated_res_0x7f09171b);
            this.j = (FunAdNativePicView) findViewById(R.id.obfuscated_res_0x7f09171c);
            this.g = (FunAdSmallPicView) findViewById(R.id.obfuscated_res_0x7f09171a);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090dc8);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090dc3);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f090dc0);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090dc2);
            this.q = (FunAdButton) findViewById(R.id.obfuscated_res_0x7f090db3);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f090db9);
            this.s = (VipAdFreeGuideLayout) findViewById(R.id.obfuscated_res_0x7f090dce);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            WebPManager.setPureDrawable(this.p, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            EMManager.from(this.k).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.l).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.o).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.m).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0606);
            this.q.g();
            this.j.d();
            this.g.c();
        }
    }
}

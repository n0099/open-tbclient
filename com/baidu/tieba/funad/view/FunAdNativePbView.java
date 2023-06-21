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
import com.baidu.tieba.at7;
import com.baidu.tieba.it7;
import com.baidu.tieba.mt7;
import com.baidu.tieba.p75;
import com.baidu.tieba.zz9;
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
/* loaded from: classes5.dex */
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.obfuscated_res_0x7f0d03a3 : invokeV.intValue;
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

    public final void k(@NonNull FunNativeAd2 funNativeAd2, zz9 zz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, funNativeAd2, zz9Var) == null) {
            ChannelNativeAds d = it7.d(funNativeAd2);
            this.r.setTag(zz9Var);
            mt7 mt7Var = new mt7(this.r, zz9Var, d);
            if (d != null) {
                Object obj = d.ksNative;
                if (obj instanceof KsNativeAd) {
                    ((KsNativeAd) obj).setDownloadListener(mt7Var);
                    return;
                }
            }
            if (d != null) {
                Object obj2 = d.csjNative;
                if (obj2 instanceof TTNativeAd) {
                    ((TTNativeAd) obj2).setDownloadListener(mt7Var);
                    return;
                }
            }
            if (d != null && d.gdtNative != null) {
                d.setGdtADStatusChangeListener(mt7Var);
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
    public at7.f getLogItem() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest()) {
                str = "1";
            } else {
                str = "0";
            }
            return at7.b("pb", str);
        }
        return (at7.f) invokeV.objValue;
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
            if (bdUniqueId != AdvertAppInfo.H && bdUniqueId != AdvertAppInfo.I) {
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
        }
    }

    public void i(@NonNull FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, funNativeAd2) == null) {
            it7.L(this.n, funNativeAd2);
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
    public void f(@NonNull zz9 zz9Var, @NonNull Activity activity) {
        List<String> list;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, zz9Var, activity) != null) || zz9Var.e() == null) {
            return;
        }
        FunNativeAd2 funNativeAd2 = (FunNativeAd2) zz9Var.e();
        it7.C(funNativeAd2);
        if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
            this.c = funNativeAd2.getNativeInfo().getTitle();
            str = funNativeAd2.getNativeInfo().getDescription();
            list = funNativeAd2.getNativeInfo().getImageUrls();
        } else {
            list = null;
            str = "";
        }
        if (StringUtils.isNull(this.c) || this.c.equals(activity.getString(R.string.obfuscated_res_0x7f0f089c))) {
            this.c = activity.getString(R.string.obfuscated_res_0x7f0f089f);
        }
        this.l.setText(this.c);
        this.k.setText(str);
        this.i.removeAllViews();
        if (it7.z(funNativeAd2, list)) {
            this.f.setVisibility(8);
            this.g.setVisibility(0);
            this.g.setData(funNativeAd2, (String) ListUtils.getItem(list, 0));
            return;
        }
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        if (it7.m(funNativeAd2) != null) {
            it7.J(this.h, it7.B(funNativeAd2));
            View m = it7.m(funNativeAd2);
            if (m.getParent() != null && (m.getParent() instanceof ViewGroup)) {
                ((ViewGroup) m.getParent()).removeView(m);
            }
            this.i.addView(m, new ViewGroup.LayoutParams(-1, -1));
            this.i.setVisibility(0);
            this.j.setVisibility(8);
        } else {
            it7.H(this.h, it7.A(funNativeAd2, list), list);
            this.i.setVisibility(8);
            this.j.setFunNativeAd(list);
        }
        i(funNativeAd2);
        if (StringUtils.isNull(zz9Var.c())) {
            zz9Var.l(it7.o(funNativeAd2, activity));
        }
        this.q.setText(zz9Var.c());
        j(it7.y(funNativeAd2));
        k(funNativeAd2, zz9Var);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090d94);
            this.e = findViewById(R.id.obfuscated_res_0x7f090909);
            this.k = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090d93);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090d82);
            this.h = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0916c7);
            this.i = (CardView) findViewById(R.id.obfuscated_res_0x7f0916cf);
            this.j = (FunAdNativePicView) findViewById(R.id.obfuscated_res_0x7f0916d0);
            this.g = (FunAdSmallPicView) findViewById(R.id.obfuscated_res_0x7f0916ce);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090d92);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090d8e);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f090d8b);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090d8d);
            this.q = (FunAdButton) findViewById(R.id.obfuscated_res_0x7f090d7e);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f090d84);
            this.s = (VipAdFreeGuideLayout) findViewById(R.id.obfuscated_res_0x7f090d98);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            WebPManager.setPureDrawable(this.p, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            p75.d(this.k).x(R.color.CAM_X0105);
            p75.d(this.l).x(R.color.CAM_X0109);
            p75.d(this.o).x(R.color.CAM_X0101);
            p75 d = p75.d(this.m);
            d.o(R.string.J_X01);
            d.f(R.color.CAM_X0606);
            this.q.g();
            this.j.d();
            this.g.c();
        }
    }
}

package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.repackage.er6;
import com.repackage.gs4;
import com.repackage.mr6;
import com.repackage.rr6;
import com.repackage.yj8;
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
    public FrameLayout c(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funNativeAd)) == null) ? this : (FrameLayout) invokeL.objValue;
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
    public void f(@NonNull yj8 yj8Var, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, yj8Var, activity) == null) || yj8Var.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) yj8Var.d();
        mr6.s(funNativeAd);
        String title = funNativeAd.getTitle();
        this.c = title;
        if (StringUtils.isNull(title) || this.c.equals(activity.getString(R.string.obfuscated_res_0x7f0f0779))) {
            this.c = activity.getString(R.string.obfuscated_res_0x7f0f077c);
        }
        this.l.setText(this.c);
        this.k.setText(funNativeAd.getDescription());
        List<String> imageUrls = funNativeAd.getImageUrls();
        this.i.removeAllViews();
        if (mr6.p(funNativeAd, imageUrls)) {
            this.f.setVisibility(8);
            this.g.setVisibility(0);
            this.g.setData(funNativeAd, (String) ListUtils.getItem(imageUrls, 0));
            return;
        }
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        if (funNativeAd.getVideoView() != null) {
            mr6.z(this.h, mr6.r(funNativeAd));
            this.i.addView(funNativeAd.getVideoView(), new ViewGroup.LayoutParams(-1, -1));
            this.i.setVisibility(0);
            this.j.setVisibility(8);
        } else {
            mr6.x(this.h, mr6.q(funNativeAd, imageUrls), imageUrls);
            this.i.setVisibility(8);
            this.j.setFunNativeAd(imageUrls);
        }
        i(funNativeAd);
        if (StringUtils.isNull(yj8Var.b())) {
            yj8Var.i(mr6.e(funNativeAd, activity));
        }
        this.q.setText(yj8Var.b());
        j(mr6.o(funNativeAd));
        k(funNativeAd, yj8Var);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090c1b);
            this.e = findViewById(R.id.obfuscated_res_0x7f09080b);
            this.k = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090c1a);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090c0a);
            this.h = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0913cd);
            this.i = (CardView) findViewById(R.id.obfuscated_res_0x7f0913d4);
            this.j = (FunAdNativePicView) findViewById(R.id.obfuscated_res_0x7f0913d5);
            this.g = (FunAdSmallPicView) findViewById(R.id.obfuscated_res_0x7f0913d3);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090c19);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c16);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c13);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090c15);
            this.q = (FunAdButton) findViewById(R.id.obfuscated_res_0x7f090c07);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f090c0c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.obfuscated_res_0x7f0d035d : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public er6.g getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return er6.b("pb", UbsABTestHelper.isPbPageBannerFunAdSdkTest() ? "1" : "0");
        }
        return (er6.g) invokeV.objValue;
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
            gs4.d(this.k).v(R.color.CAM_X0105);
            gs4.d(this.l).v(R.color.CAM_X0109);
            gs4.d(this.o).v(R.color.CAM_X0101);
            gs4 d = gs4.d(this.m);
            d.n(R.string.J_X01);
            d.f(R.color.CAM_X0606);
            this.q.g();
            this.j.d();
            this.g.c();
        }
    }

    public void i(@NonNull FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, funNativeAd) == null) {
            mr6.B(this.n, funNativeAd);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.q.setVisibility(0);
            this.r = this.q;
        }
    }

    public final void k(@NonNull FunNativeAd funNativeAd, yj8 yj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, funNativeAd, yj8Var) == null) {
            ChannelNativeAds channelNativeAds = funNativeAd.getChannelNativeAds();
            this.r.setTag(yj8Var);
            rr6 rr6Var = new rr6(this.r, yj8Var);
            if (channelNativeAds != null) {
                Object obj = channelNativeAds.ksNative;
                if (obj instanceof KsNativeAd) {
                    ((KsNativeAd) obj).setDownloadListener(rr6Var);
                    return;
                }
            }
            if (channelNativeAds != null) {
                Object obj2 = channelNativeAds.csjNative;
                if (obj2 instanceof TTNativeAd) {
                    ((TTNativeAd) obj2).setDownloadListener(rr6Var);
                    return;
                }
            }
            if (channelNativeAds == null || channelNativeAds.gdtNative == null) {
                return;
            }
            channelNativeAds.setGdtADStatusChangeListener(rr6Var);
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

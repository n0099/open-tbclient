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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import d.a.o0.b.d;
import d.a.o0.r.u.c;
import d.a.p0.h3.h0.n;
import d.a.p0.v0.a;
import d.a.p0.w0.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class FunAdNativePbView extends FunAbsAdView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f16295f;

    /* renamed from: g  reason: collision with root package name */
    public View f16296g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f16297h;

    /* renamed from: i  reason: collision with root package name */
    public FunAdSmallPicView f16298i;
    public ViewGroup j;
    public CardView k;
    public FunAdNativePicView l;
    public EMTextView m;
    public TextView n;
    public LinearLayout o;
    public ImageView p;
    public TextView q;
    public ImageView r;
    public FunAdButton s;
    public FunAdDownloadView t;
    public FunAdButton u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativePbView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.s.h();
            this.t.getDownloadButton().h();
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public FrameLayout c(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funNativeAd)) == null) ? this : (FrameLayout) invokeL.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f16295f.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            if (bdUniqueId == AdvertAppInfo.q4) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull n nVar, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, nVar, activity) == null) || nVar.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) nVar.d();
        b.f(funNativeAd);
        String title = funNativeAd.getTitle();
        this.f16263e = title;
        if (StringUtils.isNull(title) || this.f16263e.equals(activity.getString(R.string.fun_ad_label))) {
            this.f16263e = activity.getString(R.string.fun_ad_title_promotion);
        }
        this.n.setText(this.f16263e);
        this.m.setText(funNativeAd.getDescription());
        List<String> imageUrls = funNativeAd.getImageUrls();
        this.k.removeAllViews();
        if (b.k(funNativeAd, imageUrls)) {
            this.f16297h.setVisibility(8);
            this.f16298i.setVisibility(0);
            this.f16298i.setData(funNativeAd, (String) ListUtils.getItem(imageUrls, 0));
            return;
        }
        this.f16297h.setVisibility(0);
        this.f16298i.setVisibility(8);
        if (funNativeAd.getVideoView() != null) {
            b.p(this.j, b.m(funNativeAd));
            this.k.addView(funNativeAd.getVideoView(), new ViewGroup.LayoutParams(-1, -1));
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        } else {
            b.o(this.j, b.l(funNativeAd, imageUrls), imageUrls);
            this.k.setVisibility(8);
            this.l.setFunNativeAd(imageUrls);
        }
        i(funNativeAd);
        this.t.setViewData(funNativeAd, activity, getPageType());
        if (StringUtils.isNull(nVar.b())) {
            nVar.i(b.b(funNativeAd, activity));
        }
        this.t.getDownloadButton().setText(nVar.b());
        this.s.setText(nVar.b());
        j(b.j(funNativeAd));
        k(funNativeAd, nVar);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
            this.f16295f = (RelativeLayout) findViewById(R.id.fun_card_layout);
            this.f16296g = findViewById(R.id.divider_with_reply_title);
            this.m = (EMTextView) findViewById(R.id.fun_card_description);
            this.f16297h = (ViewGroup) findViewById(R.id.fun_ad_container);
            this.j = (ViewGroup) findViewById(R.id.media_container);
            this.k = (CardView) findViewById(R.id.media_video);
            this.l = (FunAdNativePicView) findViewById(R.id.medig_image);
            this.f16298i = (FunAdSmallPicView) findViewById(R.id.media_small);
            this.n = (TextView) findViewById(R.id.fun_ad_title);
            this.o = (LinearLayout) findViewById(R.id.fun_ad_lable_pb_layout);
            this.p = (ImageView) findViewById(R.id.fun_ad_lable_icon);
            this.q = (TextView) findViewById(R.id.fun_ad_lable_pb);
            this.s = (FunAdButton) findViewById(R.id.fun_ad_button);
            this.r = (ImageView) findViewById(R.id.fun_ad_feedback_pb);
            this.t = (FunAdDownloadView) findViewById(R.id.fun_ad_download_container);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Arrays.asList(this, this.f16295f, this.k, this.n, this.t, this.s) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getCreativeViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Collections.singletonList(this.s) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.fun_ad_pb_native : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public a.e getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return a.a("pb", d.L() ? "1" : "0");
        }
        return (a.e) invokeV.objValue;
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
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            SkinManager.setBackgroundColor(this.f16296g, R.color.CAM_X0204);
            c.d(this.m).t(R.color.CAM_X0105);
            c.d(this.n).t(R.color.CAM_X0109);
            c.d(this.q).t(R.color.CAM_X0101);
            c d2 = c.d(this.o);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0606);
            this.s.g();
            this.t.d(TbadkCoreApplication.getInst().getSkinType());
            this.l.d();
            this.f16298i.c();
        }
    }

    public void i(@NonNull FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, funNativeAd) == null) {
            b.q(this.p, funNativeAd);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (FunAdSdkSwitch.isOn() && z) {
                this.t.setVisibility(0);
                this.s.setVisibility(8);
                this.u = this.t.getDownloadButton();
                return;
            }
            this.t.setVisibility(8);
            this.s.setVisibility(0);
            this.u = this.s;
        }
    }

    public final void k(@NonNull FunNativeAd funNativeAd, n nVar) {
        TTNativeAd tTNativeAd;
        KsNativeAd ksNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, funNativeAd, nVar) == null) {
            ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
            this.u.setTag(nVar);
            d.a.p0.w0.f.a aVar = new d.a.p0.w0.f.a(this.u, nVar);
            if (channelNativeAds_6 != null && (ksNativeAd = channelNativeAds_6.ksNative) != null) {
                ksNativeAd.setDownloadListener(aVar);
            } else if (channelNativeAds_6 != null && (tTNativeAd = channelNativeAds_6.csjNative) != null) {
                tTNativeAd.setDownloadListener(aVar);
            } else if (channelNativeAds_6 == null || channelNativeAds_6.gdtNative == null) {
            } else {
                channelNativeAds_6.setGdtADStatusChangeListener(aVar);
            }
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFeedBackListener(View.OnClickListener onClickListener) {
        FunAdSmallPicView funAdSmallPicView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) || (funAdSmallPicView = this.f16298i) == null) {
            return;
        }
        funAdSmallPicView.setFeedBackListener(onClickListener);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (relativeLayout = this.f16295f) == null) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativePbView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}

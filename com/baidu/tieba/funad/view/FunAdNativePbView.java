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
import c.a.q0.b.d;
import c.a.q0.s.u.c;
import c.a.r0.k3.i0.o;
import c.a.r0.y0.a;
import c.a.r0.z0.b;
import c.a.r0.z0.f.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class FunAdNativePbView extends FunAbsAdView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FunAdButton adButton;
    public TextView adLabel;
    public ImageView adLabelIcon;
    public LinearLayout adLabelLayout;
    public TextView adTitleView;
    public EMTextView descriptionView;
    public View dividerView;

    /* renamed from: e  reason: collision with root package name */
    public FunAdButton f51907e;
    public ViewGroup funAdContainer;
    public ViewGroup mediaContainer;
    public FunAdNativePicView mediaImageView;
    public CardView mediaVideoView;
    public ImageView pbFeedBackView;
    public FunAdSmallPicView smallAdView;
    public RelativeLayout viewLayout;

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

    public final void a(@NonNull FunNativeAd funNativeAd, o oVar) {
        TTNativeAd tTNativeAd;
        KsNativeAd ksNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, funNativeAd, oVar) == null) {
            ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
            this.f51907e.setTag(oVar);
            a aVar = new a(this.f51907e, oVar);
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
    public void destroyDownloadButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.adButton.onDestroy();
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Arrays.asList(this, this.viewLayout, this.mediaVideoView, this.adTitleView, this.adButton) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getCreativeViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Collections.singletonList(this.adButton) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.pbFeedBackView : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public FrameLayout getGdtAdContainer(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, funNativeAd)) == null) ? this : (FrameLayout) invokeL.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.layout.fun_ad_pb_native : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public a.g getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return c.a.r0.y0.a.b("pb", d.H() ? "1" : "0");
        }
        return (a.g) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void hideOrShowView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.viewLayout.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void hideShowByType(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            if (bdUniqueId != AdvertAppInfo.C4 && bdUniqueId != AdvertAppInfo.D4) {
                this.pbFeedBackView.setVisibility(0);
            } else {
                this.pbFeedBackView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void inflateFunAd(@NonNull o oVar, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, oVar, activity) == null) || oVar.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) oVar.d();
        b.s(funNativeAd);
        String title = funNativeAd.getTitle();
        this.funAdTitle = title;
        if (StringUtils.isNull(title) || this.funAdTitle.equals(activity.getString(R.string.fun_ad_label))) {
            this.funAdTitle = activity.getString(R.string.fun_ad_title_promotion);
        }
        this.adTitleView.setText(this.funAdTitle);
        this.descriptionView.setText(funNativeAd.getDescription());
        List<String> imageUrls = funNativeAd.getImageUrls();
        this.mediaVideoView.removeAllViews();
        if (b.p(funNativeAd, imageUrls)) {
            this.funAdContainer.setVisibility(8);
            this.smallAdView.setVisibility(0);
            this.smallAdView.setData(funNativeAd, (String) ListUtils.getItem(imageUrls, 0));
            return;
        }
        this.funAdContainer.setVisibility(0);
        this.smallAdView.setVisibility(8);
        if (funNativeAd.getVideoView() != null) {
            b.z(this.mediaContainer, b.r(funNativeAd));
            this.mediaVideoView.addView(funNativeAd.getVideoView(), new ViewGroup.LayoutParams(-1, -1));
            this.mediaVideoView.setVisibility(0);
            this.mediaImageView.setVisibility(8);
        } else {
            b.x(this.mediaContainer, b.q(funNativeAd, imageUrls), imageUrls);
            this.mediaVideoView.setVisibility(8);
            this.mediaImageView.setFunNativeAd(imageUrls);
        }
        resetAdLaybleState(funNativeAd);
        if (StringUtils.isNull(oVar.b())) {
            oVar.i(b.e(funNativeAd, activity));
        }
        this.adButton.setText(oVar.b());
        resetCreativeBtn(b.o(funNativeAd));
        a(funNativeAd, oVar);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void initView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
            this.viewLayout = (RelativeLayout) findViewById(R.id.fun_card_layout);
            this.dividerView = findViewById(R.id.divider_with_reply_title);
            this.descriptionView = (EMTextView) findViewById(R.id.fun_card_description);
            this.funAdContainer = (ViewGroup) findViewById(R.id.fun_ad_container);
            this.mediaContainer = (ViewGroup) findViewById(R.id.media_container);
            this.mediaVideoView = (CardView) findViewById(R.id.media_video);
            this.mediaImageView = (FunAdNativePicView) findViewById(R.id.medig_image);
            this.smallAdView = (FunAdSmallPicView) findViewById(R.id.media_small);
            this.adTitleView = (TextView) findViewById(R.id.fun_ad_title);
            this.adLabelLayout = (LinearLayout) findViewById(R.id.fun_ad_lable_pb_layout);
            this.adLabelIcon = (ImageView) findViewById(R.id.fun_ad_lable_icon);
            this.adLabel = (TextView) findViewById(R.id.fun_ad_lable_pb);
            this.adButton = (FunAdButton) findViewById(R.id.fun_ad_button);
            this.pbFeedBackView = (ImageView) findViewById(R.id.fun_ad_feedback_pb);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void onChangedSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            WebPManager.setPureDrawable(this.pbFeedBackView, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            SkinManager.setBackgroundColor(this.dividerView, R.color.CAM_X0204);
            c.d(this.descriptionView).v(R.color.CAM_X0105);
            c.d(this.adTitleView).v(R.color.CAM_X0109);
            c.d(this.adLabel).v(R.color.CAM_X0101);
            c d2 = c.d(this.adLabelLayout);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0606);
            this.adButton.onChangeSkinType();
            this.mediaImageView.onChangedSkinType();
            this.smallAdView.onChangedSkinType();
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void resetAdLaybleState(@NonNull FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, funNativeAd) == null) {
            b.B(this.adLabelIcon, funNativeAd);
        }
    }

    public void resetCreativeBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.adButton.setVisibility(0);
            this.f51907e = this.adButton;
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFeedBackListener(View.OnClickListener onClickListener) {
        FunAdSmallPicView funAdSmallPicView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) || (funAdSmallPicView = this.smallAdView) == null) {
            return;
        }
        funAdSmallPicView.setFeedBackListener(onClickListener);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (relativeLayout = this.viewLayout) == null) {
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

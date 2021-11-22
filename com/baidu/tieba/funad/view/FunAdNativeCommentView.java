package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.b.d;
import b.a.q0.s.u.c;
import b.a.r0.m3.j0.o;
import b.a.r0.y0.a;
import b.a.r0.z0.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunNativeAd;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class FunAdNativeCommentView extends FunAdNativePbView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f50131f;

    /* renamed from: g  reason: collision with root package name */
    public RoundTbImageView f50132g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50133h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50134i;
    public ViewGroup j;
    public ImageView k;
    public View l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativeCommentView(Context context) {
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

    public final void b(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbImageView) == null) {
            tbImageView.setDefaultResource(R.drawable.icon_frs_default_header);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setIsLongPic(false);
            tbImageView.setIsSmartCrop(false);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Arrays.asList(this, this.viewLayout, this.mediaVideoView, this.adTitleView, this.adButton, this.j) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.fun_ad_comment_native : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public a.g getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return a.b("pb", d.J() ? "1" : "0");
        }
        return (a.g) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "a005" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void hideOrShowView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f50131f.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void hideShowByType(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            super.hideShowByType(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void inflateFunAd(@NonNull o oVar, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oVar, activity) == null) {
            super.inflateFunAd(oVar, activity);
            if (oVar.d() == null) {
                return;
            }
            FunNativeAd funNativeAd = (FunNativeAd) oVar.d();
            this.f50134i.setText(this.funAdTitle);
            this.f50132g.startLoad(funNativeAd.getIconUrl(), 10, false);
            if (funNativeAd.getVideoView() != null) {
                boolean r = b.r(funNativeAd);
                b.y(this.descriptionView, r);
                b.w(this.mediaContainer, r);
                return;
            }
            boolean q = b.q(funNativeAd, funNativeAd.getImageUrls());
            b.y(this.descriptionView, q);
            b.w(this.mediaContainer, q);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void initView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            super.initView(context);
            this.f50131f = (LinearLayout) findViewById(R.id.fun_ad_frs_view_layout);
            this.f50132g = (RoundTbImageView) findViewById(R.id.top_ad_logo);
            this.f50134i = (TextView) findViewById(R.id.top_ad_name);
            this.f50133h = (TextView) findViewById(R.id.top_ad_justnow);
            this.j = (ViewGroup) findViewById(R.id.layout_card_top);
            this.k = (ImageView) findViewById(R.id.fun_ad_feedback);
            this.l = findViewById(R.id.fun_ad_bottom_line);
            this.dividerView.setVisibility(8);
            b(this.f50132g);
            RelativeLayout relativeLayout = this.viewLayout;
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), this.viewLayout.getPaddingTop(), this.viewLayout.getPaddingRight(), 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void onChangedSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onChangedSkinType();
            c.d(this).f(R.color.CAM_X0205);
            c d2 = c.d(this);
            d2.n(R.string.J_X06);
            d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
            c.d(this.f50133h).v(R.color.CAM_X0109);
            c.d(this.f50134i).v(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            this.f50132g.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0203);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void resetAdLaybleState(@NonNull FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, funNativeAd) == null) {
            super.resetAdLaybleState(funNativeAd);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (linearLayout = this.f50131f) == null) {
            return;
        }
        linearLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativeCommentView(Context context, AttributeSet attributeSet) {
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
    public FunAdNativeCommentView(Context context, AttributeSet attributeSet, int i2) {
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

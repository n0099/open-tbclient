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
import c.a.p0.b.d;
import c.a.p0.s.f0.h;
import c.a.p0.s.u.c;
import c.a.q0.i3.i0.o;
import c.a.q0.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class FunAdNativeFrsView extends FunAdNativePbView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f51715f;

    /* renamed from: g  reason: collision with root package name */
    public RoundTbImageView f51716g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51717h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51718i;

    /* renamed from: j  reason: collision with root package name */
    public FunAdAgreeView f51719j;
    public View k;
    public ImageView l;
    public TextView m;
    public View n;
    public ImageView o;
    public TextView p;
    public ViewGroup q;
    public ImageView r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativeFrsView(Context context) {
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f51719j.getLayoutParams();
            int i2 = layoutParams.width;
            if (layoutParams.weight != 1.0f || i2 != 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.f51719j.setLayoutParams(layoutParams);
            }
            this.f51719j.isUseHomePageStyleAb(true);
        }
    }

    public final void c(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Arrays.asList(this, this.viewLayout, this.mediaVideoView, this.adTitleView, this.downloadView, this.adButton, this.q) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.fun_ad_frs_native : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public a.g getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return a.b("frs", d.y() ? "1" : "0");
        }
        return (a.g) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void hideOrShowView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f51715f.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void hideShowByType(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            super.hideShowByType(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void inflateFunAd(@NonNull o oVar, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, oVar, activity) == null) {
            super.inflateFunAd(oVar, activity);
            if (oVar.d() == null) {
                return;
            }
            FunNativeAd funNativeAd = (FunNativeAd) oVar.d();
            if (oVar.a() == null) {
                AgreeData agreeData = new AgreeData();
                agreeData.agreeNum = c.a.q0.g1.a.a.a(25, 1000);
                oVar.h(agreeData);
            }
            this.f51718i.setText(this.funAdTitle);
            AgreeData a2 = oVar.a();
            this.f51719j.setAgreeAlone(true);
            this.f51719j.setData(a2);
            this.f51716g.startLoad(funNativeAd.getIconUrl(), 10, false);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void initView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            super.initView(context);
            this.f51715f = (LinearLayout) findViewById(R.id.fun_ad_frs_view_layout);
            this.f51716g = (RoundTbImageView) findViewById(R.id.top_ad_logo);
            this.f51718i = (TextView) findViewById(R.id.top_ad_name);
            this.f51717h = (TextView) findViewById(R.id.top_ad_justnow);
            this.f51719j = (FunAdAgreeView) findViewById(R.id.ad_agree_view);
            this.k = findViewById(R.id.share_num_container);
            this.n = findViewById(R.id.thread_info_commont_container);
            this.o = (ImageView) findViewById(R.id.thread_info_commont_img);
            this.p = (TextView) findViewById(R.id.thread_info_commont_num);
            this.l = (ImageView) findViewById(R.id.share_num_img);
            this.m = (TextView) findViewById(R.id.share_num);
            this.q = (ViewGroup) findViewById(R.id.layout_card_top);
            this.r = (ImageView) findViewById(R.id.fun_ad_feedback);
            this.dividerView.setVisibility(8);
            c(this.f51716g);
            b();
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
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onChangedSkinType();
            c.d(this).f(R.color.CAM_X0205);
            c d2 = c.d(this);
            d2.n(R.string.J_X06);
            d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
            c.d(this.f51717h).u(R.color.CAM_X0109);
            c.d(this.f51718i).u(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            this.l.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_share22, c.a.q0.i3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.o.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_comment22, c.a.q0.i3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.m.setTextColor(c.a.q0.i3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.p.setTextColor(c.a.q0.i3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.f51716g.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f51719j.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            h.a(this.l, R.drawable.icon_pure_card_share20);
            h.e(this.m);
            h.a(this.o, R.drawable.icon_pure_card_comment20);
            h.e(this.p);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void resetAdLaybleState(@NonNull FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, funNativeAd) == null) {
            super.resetAdLaybleState(funNativeAd);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (linearLayout = this.f51715f) == null) {
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
    public FunAdNativeFrsView(Context context, AttributeSet attributeSet, int i2) {
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

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
import b.a.q0.s.g0.h;
import b.a.r0.l3.c;
import b.a.r0.l3.j0.o;
import b.a.r0.y0.a;
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
/* loaded from: classes9.dex */
public class FunAdNativeFrsView extends FunAdNativePbView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f49225f;

    /* renamed from: g  reason: collision with root package name */
    public RoundTbImageView f49226g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49227h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49228i;
    public FunAdAgreeView j;
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

    private void setTextGrayAndUnClickable(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, textView) == null) {
            textView.setTextColor(c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            int i2 = layoutParams.width;
            if (layoutParams.weight != 1.0f || i2 != 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.j.setLayoutParams(layoutParams);
            }
            this.j.isUseHomePageStyleAb(true);
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

    public final void d(ImageView imageView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, imageView, i2) == null) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(i2, c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_DISABLE));
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Arrays.asList(this, this.viewLayout, this.mediaVideoView, this.adTitleView, this.adButton, this.q) : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.fun_ad_frs_native : invokeV.intValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public a.g getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return a.b("frs", d.p() ? "1" : "0");
        }
        return (a.g) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void hideOrShowView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f49225f.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void hideShowByType(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            super.hideShowByType(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void inflateFunAd(@NonNull o oVar, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, oVar, activity) == null) {
            super.inflateFunAd(oVar, activity);
            if (oVar.d() == null) {
                return;
            }
            FunNativeAd funNativeAd = (FunNativeAd) oVar.d();
            if (oVar.a() == null) {
                AgreeData agreeData = new AgreeData();
                agreeData.agreeNum = b.a.r0.i1.a.a.a(25, 1000);
                oVar.h(agreeData);
            }
            this.f49228i.setText(this.funAdTitle);
            AgreeData a2 = oVar.a();
            this.j.setAgreeAlone(true);
            this.j.setData(a2);
            this.f49226g.startLoad(funNativeAd.getIconUrl(), 10, false);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void initView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            super.initView(context);
            this.f49225f = (LinearLayout) findViewById(R.id.fun_ad_frs_view_layout);
            this.f49226g = (RoundTbImageView) findViewById(R.id.top_ad_logo);
            this.f49228i = (TextView) findViewById(R.id.top_ad_name);
            this.f49227h = (TextView) findViewById(R.id.top_ad_justnow);
            this.j = (FunAdAgreeView) findViewById(R.id.ad_agree_view);
            this.k = findViewById(R.id.share_num_container);
            this.n = findViewById(R.id.thread_info_commont_container);
            this.o = (ImageView) findViewById(R.id.thread_info_commont_img);
            this.p = (TextView) findViewById(R.id.thread_info_commont_num);
            this.l = (ImageView) findViewById(R.id.share_num_img);
            this.m = (TextView) findViewById(R.id.share_num);
            this.q = (ViewGroup) findViewById(R.id.layout_card_top);
            this.r = (ImageView) findViewById(R.id.fun_ad_feedback);
            this.dividerView.setVisibility(8);
            c(this.f49226g);
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onChangedSkinType();
            b.a.q0.s.u.c.d(this).f(R.color.CAM_X0205);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this);
            d2.n(R.string.J_X06);
            d2.i(R.color.CAM_X0205, R.color.CAM_X0206);
            b.a.q0.s.u.c.d(this.f49227h).v(R.color.CAM_X0109);
            b.a.q0.s.u.c.d(this.f49228i).v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            if (d.m()) {
                h.a(this.l, R.drawable.icon_pure_card_share20);
                h.a(this.o, R.drawable.icon_pure_card_comment20);
                h.e(this.m);
                h.e(this.p);
                d(this.l, R.drawable.icon_pure_card_share20);
                d(this.o, R.drawable.icon_pure_card_comment20);
            } else {
                d(this.l, R.drawable.icon_pure_card_share22);
                d(this.o, R.drawable.icon_pure_card_comment22);
            }
            setTextGrayAndUnClickable(this.m);
            setTextGrayAndUnClickable(this.p);
            this.f49226g.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.j.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void resetAdLaybleState(@NonNull FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, funNativeAd) == null) {
            super.resetAdLaybleState(funNativeAd);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (linearLayout = this.f49225f) == null) {
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

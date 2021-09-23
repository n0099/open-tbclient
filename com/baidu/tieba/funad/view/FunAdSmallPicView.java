package com.baidu.tieba.funad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.q0.s.u.c;
import c.a.r0.y0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunNativeAd;
/* loaded from: classes7.dex */
public class FunAdSmallPicView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f51986e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f51987f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f51988g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51989h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51990i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f51991j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAdSmallPicView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbImageView) == null) {
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setIsLongPic(false);
            tbImageView.setIsSmartCrop(false);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setPlaceHolder(2);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fun_ad_small_pic, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f51986e = (TbImageView) inflate.findViewById(R.id.ad_small_image);
            this.f51990i = (TextView) inflate.findViewById(R.id.ad_small_desc);
            this.f51991j = (TextView) inflate.findViewById(R.id.ad_small_source);
            this.f51989h = (TextView) inflate.findViewById(R.id.ad_small_title);
            this.f51987f = (ImageView) inflate.findViewById(R.id.ad_small_labelIcon);
            this.f51988g = (ImageView) inflate.findViewById(R.id.ad_small_dislike);
            this.f51986e.setRadiusById(R.string.J_X05);
            this.f51986e.setConrers(15);
            a(this.f51986e);
        }
    }

    public void onChangedSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WebPManager.setPureDrawable(this.f51988g, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            c.d(this.f51990i).w(R.color.CAM_X0105);
            c.d(this.f51989h).w(R.color.CAM_X0109);
            c.d(this.f51991j).w(R.color.CAM_X0109);
            this.f51986e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
    }

    public void setData(FunNativeAd funNativeAd, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, funNativeAd, str) == null) || funNativeAd == null) {
            return;
        }
        this.f51989h.setText(funNativeAd.getTitle());
        this.f51990i.setText(funNativeAd.getDescription());
        b.v(this.f51987f, funNativeAd);
        if (!StringHelper.equals(str, this.f51986e.getUrl())) {
            this.f51986e.reset();
        }
        this.f51986e.startLoad(str, 10, false);
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f51988g.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdSmallPicView(Context context, @Nullable AttributeSet attributeSet) {
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
        b();
    }
}

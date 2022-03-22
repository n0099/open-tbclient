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
import c.a.o0.r.v.c;
import c.a.p0.h1.b;
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
/* loaded from: classes5.dex */
public class FunAdSmallPicView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33097b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f33098c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33099d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33100e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33101f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAdSmallPicView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0365, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.a = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e6);
            this.f33100e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e4);
            this.f33101f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e8);
            this.f33099d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e9);
            this.f33097b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e7);
            this.f33098c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e5);
            this.a.setRadiusById(R.string.J_X05);
            this.a.setConrers(15);
            a(this.a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WebPManager.setPureDrawable(this.f33098c, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            c.d(this.f33100e).v(R.color.CAM_X0105);
            c.d(this.f33099d).v(R.color.CAM_X0109);
            c.d(this.f33101f).v(R.color.CAM_X0109);
            this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
    }

    public void setData(FunNativeAd funNativeAd, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, funNativeAd, str) == null) || funNativeAd == null) {
            return;
        }
        this.f33099d.setText(funNativeAd.getTitle());
        this.f33100e.setText(funNativeAd.getDescription());
        b.v(this.f33097b, funNativeAd);
        if (!StringHelper.equals(str, this.a.getUrl())) {
            this.a.F();
        }
        this.a.J(str, 10, false);
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f33098c.setOnClickListener(onClickListener);
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
        b();
    }
}

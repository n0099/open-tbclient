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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.qy7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunNativeAd2;
/* loaded from: classes5.dex */
public class FunAdSmallPicView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;

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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03bc, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.a = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090104);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090102);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090106);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090107);
            this.b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090105);
            this.c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090103);
            this.a.setRadiusById(R.string.J_X05);
            this.a.setConrers(15);
            a(this.a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WebPManager.setPureDrawable(this.c, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            EMManager.from(this.e).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.d).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.f).setTextColor(R.color.CAM_X0109);
            this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
    }

    public void setData(FunNativeAd2 funNativeAd2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, funNativeAd2, str) != null) || funNativeAd2 == null) {
            return;
        }
        if (funNativeAd2.getNativeInfo() != null) {
            this.d.setText(funNativeAd2.getNativeInfo().getTitle());
            this.e.setText(funNativeAd2.getNativeInfo().getDescription());
        }
        qy7.F(this.b, funNativeAd2);
        if (!StringHelper.equals(str, this.a.getUrl())) {
            this.a.reset();
        }
        this.a.startLoad(str, 10, false);
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.c.setOnClickListener(onClickListener);
        }
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d25 implements b25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.b25
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public d25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.b25
    public e25 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e25 e25Var = new e25();
            e25Var.c(R.drawable.icon_banner_n);
            e25Var.g(R.drawable.icon_banner_s);
            e25Var.h(R.dimen.obfuscated_res_0x7f070399);
            e25Var.d(81);
            e25Var.e(R.dimen.obfuscated_res_0x7f070399);
            return e25Var;
        }
        return (e25) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b25
    public h25 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h25 h25Var = new h25();
            Resources resources = TbadkCoreApplication.getInst().getResources();
            if (resources != null) {
                h25Var.a(resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c0));
            }
            return h25Var;
        }
        return (h25) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b25
    public TbImageView d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setGifIconSupport(false);
            return tbImageView;
        }
        return (TbImageView) invokeL.objValue;
    }
}

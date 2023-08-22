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
/* loaded from: classes6.dex */
public class i75 implements g75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.g75
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public i75() {
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

    @Override // com.baidu.tieba.g75
    public j75 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j75 j75Var = new j75();
            j75Var.c(R.drawable.icon_banner_n);
            j75Var.g(R.drawable.icon_banner_s);
            j75Var.h(R.dimen.obfuscated_res_0x7f070399);
            j75Var.d(81);
            j75Var.e(R.dimen.obfuscated_res_0x7f070399);
            return j75Var;
        }
        return (j75) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g75
    public m75 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            m75 m75Var = new m75();
            Resources resources = TbadkCoreApplication.getInst().getResources();
            if (resources != null) {
                m75Var.a(resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c0));
            }
            return m75Var;
        }
        return (m75) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g75
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

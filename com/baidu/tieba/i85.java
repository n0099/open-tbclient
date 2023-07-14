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
public class i85 implements g85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.g85
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public i85() {
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

    @Override // com.baidu.tieba.g85
    public j85 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j85 j85Var = new j85();
            j85Var.c(R.drawable.icon_banner_n);
            j85Var.g(R.drawable.icon_banner_s);
            j85Var.h(R.dimen.obfuscated_res_0x7f070399);
            j85Var.d(81);
            j85Var.e(R.dimen.obfuscated_res_0x7f070399);
            return j85Var;
        }
        return (j85) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g85
    public m85 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            m85 m85Var = new m85();
            Resources resources = TbadkCoreApplication.getInst().getResources();
            if (resources != null) {
                m85Var.a(resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c0));
            }
            return m85Var;
        }
        return (m85) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g85
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

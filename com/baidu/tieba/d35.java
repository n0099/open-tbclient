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
public class d35 implements b35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.b35
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public d35() {
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

    @Override // com.baidu.tieba.b35
    public e35 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e35 e35Var = new e35();
            e35Var.c(R.drawable.icon_banner_n);
            e35Var.g(R.drawable.icon_banner_s);
            e35Var.h(R.dimen.obfuscated_res_0x7f07039a);
            e35Var.d(81);
            e35Var.e(R.dimen.obfuscated_res_0x7f07039a);
            return e35Var;
        }
        return (e35) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b35
    public h35 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h35 h35Var = new h35();
            Resources resources = TbadkCoreApplication.getInst().getResources();
            if (resources != null) {
                h35Var.a(resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c1));
            }
            return h35Var;
        }
        return (h35) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b35
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

package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ih0 extends p71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseModel a;
    public View b;
    public View.OnClickListener c;

    public ih0(AdBaseModel adBaseModel, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adBaseModel, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adBaseModel;
        this.b = view2;
    }

    @Override // com.baidu.tieba.p71
    public void a(String str) {
        AdBaseModel adBaseModel;
        po0 po0Var;
        ko0 ko0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (adBaseModel = this.a) == null || (po0Var = adBaseModel.f) == null || TextUtils.isEmpty(po0Var.d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.FREE_CLICK);
        clogBuilder.j(str);
        lo0 lo0Var = adBaseModel.m;
        if (lo0Var != null && (ko0Var = lo0Var.f) != null) {
            clogBuilder.v(ko0Var.a);
        }
        clogBuilder.p(adBaseModel.f.d);
        uz0.b(clogBuilder);
    }

    @Override // com.baidu.tieba.p71
    public void b(@NonNull vo0 vo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vo0Var) == null) {
            if (vo0Var.c) {
                vh0.b(vo0Var.a);
                g(ClogBuilder.LogType.CLICK, "detailbtn", this.a);
            }
            View.OnClickListener onClickListener = this.c;
            if (onClickListener != null) {
                onClickListener.onClick(this.b);
            }
        }
    }

    public final void g(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        po0 po0Var;
        ko0 ko0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, logType, str, adBaseModel) == null) || adBaseModel == null || (po0Var = adBaseModel.f) == null || TextUtils.isEmpty(po0Var.d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType);
        clogBuilder.j(str);
        lo0 lo0Var = adBaseModel.m;
        if (lo0Var != null && (ko0Var = lo0Var.f) != null) {
            clogBuilder.v(ko0Var.a);
        }
        clogBuilder.p(adBaseModel.f.d);
        uz0.b(clogBuilder);
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }
}

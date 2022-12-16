package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.gi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ei5 extends ci5<la5, gi5.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> e;

    public ei5(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci5
    /* renamed from: h */
    public la5 f(ViewType viewType, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewType, viewGroup)) == null) {
            return new la5(this.e.getPageActivity(), null);
        }
        return (la5) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci5
    /* renamed from: g */
    public void d(ViewType viewType, la5 la5Var, gi5.b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, la5Var, bVar) == null) {
            if (bVar.b && !TextUtils.isEmpty(bVar.a)) {
                str = bVar.a;
            } else {
                str = bVar.g;
            }
            la5Var.m(str);
            la5Var.k(bVar.d);
            la5Var.i(bVar.c);
            la5Var.n(bVar.f);
            la5Var.g(bVar.e);
            la5Var.p();
            la5Var.onChangeSkinType();
            la5Var.c().setOnClickListener(bVar.h);
        }
    }
}

package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class ee8<T, V extends TypeAdapter.ViewHolder> extends ci<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public TbPageContext<?> b;
    public vi c;
    public av4 d;

    @Override // com.baidu.tieba.ci
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) ? view2 : (View) invokeCommon.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ee8(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        BdUniqueId uniqueId;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
        TbPageContext pageContext = ((TbPageContextSupport) context).getPageContext();
        this.b = pageContext;
        if (pageContext == null) {
            uniqueId = null;
        } else {
            uniqueId = pageContext.getUniqueId();
        }
        n(pageContext, uniqueId);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ee8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(r1, bdUniqueId);
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (tbPageContext == null) {
            pageActivity = null;
        } else {
            pageActivity = tbPageContext.getPageActivity();
        }
        this.a = true;
        n(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public void n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, bdUniqueId) == null) && tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.b = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    public void t(View view2, ThreadData threadData) {
        av4 av4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view2, threadData) == null) && (av4Var = this.d) != null) {
            int i = threadData.position;
            av4Var.b(view2, threadData, i, i);
        }
    }

    @Override // com.baidu.tieba.ci
    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.mPageId = bdUniqueId;
        }
    }

    public void x(av4 av4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, av4Var) == null) {
            this.d = av4Var;
        }
    }

    public void y(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viVar) == null) {
            this.c = viVar;
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public void z(View view2, ThreadData threadData, int i, long j) {
        av4 av4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view2, threadData, Integer.valueOf(i), Long.valueOf(j)}) == null) && (av4Var = this.d) != null) {
            av4Var.d(view2, threadData, i, j);
        }
    }
}

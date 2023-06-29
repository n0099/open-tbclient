package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.TbLabelWidget;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fz extends dy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbLabelWidget h;
    public ThreadData i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fz(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int g = xi.g(context, R.dimen.M_H_X003);
        int g2 = xi.g(context, R.dimen.tbds0);
        x(g);
        u(g2);
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().s instanceof TbLabelWidget) && TbadkCoreApplication.getInst().getPersonalizeViewData().s.getParent() == null) {
            this.h = (TbLabelWidget) TbadkCoreApplication.getInst().getPersonalizeViewData().s;
        } else {
            this.h = new TbLabelWidget(context);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qy
    /* renamed from: A */
    public void a(l15 l15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l15Var) == null) {
            if (l15Var != null) {
                this.i = l15Var.getThreadData();
            }
            this.h.setData(l15Var);
        }
    }

    public void B(TbLabelWidget.b bVar) {
        TbLabelWidget tbLabelWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && (tbLabelWidget = this.h) != null) {
            tbLabelWidget.setEventCallback(bVar);
        }
    }

    public void C(TbPageContext tbPageContext) {
        TbLabelWidget tbLabelWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext) == null) && (tbLabelWidget = this.h) != null) {
            tbLabelWidget.setPageContext(tbPageContext);
        }
    }

    @Override // com.baidu.tieba.wx
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int g = xi.g(this.b, R.dimen.M_H_X003);
            int g2 = xi.g(this.b, R.dimen.tbds0);
            x(g);
            u(g2);
        }
    }

    public ThreadData z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ry
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            this.h.k();
        }
    }
}

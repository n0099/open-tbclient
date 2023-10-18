package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.itemtab.FrsItemTabHttpResponseMessage;
import com.baidu.tieba.frs.itemtab.FrsItemTabNetModel;
import com.baidu.tieba.frs.itemtab.FrsItemTabRequestData;
import com.baidu.tieba.frs.itemtab.FrsItemTabSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class gl7 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public hl7 b;
    public FrsItemTabNetModel c;
    public int d;
    public String e;

    public gl7(FrsItemTabFragment frsItemTabFragment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (frsItemTabFragment == null) {
            return;
        }
        this.a = frsItemTabFragment;
        FrsItemTabRequestData frsItemTabRequestData = new FrsItemTabRequestData();
        frsItemTabRequestData.itemId = i;
        FrsItemTabNetModel frsItemTabNetModel = new FrsItemTabNetModel(frsItemTabFragment.getPageContext(), frsItemTabRequestData);
        this.c = frsItemTabNetModel;
        frsItemTabNetModel.p0(this);
        this.c.setUniqueId(frsItemTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void H(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        hl7 hl7Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof FrsItemTabHttpResponseMessage)) {
            hl7Var = (hl7) ((FrsItemTabHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (hl7Var != null && c(hl7Var)) {
            return;
        }
        this.d = mvcHttpResponsedMessage.getError();
        this.e = mvcHttpResponsedMessage.getErrorString();
        b();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void v(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        hl7 hl7Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof FrsItemTabSocketResponseMessage)) {
            hl7Var = ((FrsItemTabSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (hl7Var != null && c(hl7Var)) {
            return;
        }
        this.d = mvcSocketResponsedMessage.getError();
        this.e = mvcSocketResponsedMessage.getErrorString();
        b();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            hl7 hl7Var = this.b;
            if (hl7Var != null && hl7Var.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.d);
            errorData.setError_msg(this.e);
            if (this.d != 0) {
                this.a.f(errorData);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.c.h0()) {
            return;
        }
        this.c.loadData();
        xs7.a();
    }

    public final boolean c(hl7 hl7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hl7Var)) == null) {
            if (hl7Var == null) {
                return false;
            }
            this.b = hl7Var;
            hl7Var.c = e(hl7Var.c);
            this.a.g2(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<yh> e(ArrayList<yh> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, arrayList)) == null) {
            ArrayList<yh> arrayList2 = new ArrayList<>();
            Iterator<yh> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                yh next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        py4 py4Var = new py4();
                        py4Var.t = threadData;
                        py4Var.position = i;
                        py4Var.a = true;
                        py4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var);
                        py4 py4Var2 = new py4();
                        py4Var2.t = threadData;
                        py4Var2.position = i;
                        if (threadData.picCount() == 1) {
                            py4Var2.d = true;
                            py4Var2.u = imageWidthAndHeight[0];
                            py4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            py4Var2.e = true;
                        } else {
                            py4Var2.b = true;
                        }
                        py4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var2);
                        py4 py4Var3 = new py4();
                        py4Var3.g = true;
                        py4Var3.t = threadData;
                        py4Var3.position = i;
                        py4Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var3);
                        i++;
                    }
                    threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                } else {
                    if (next instanceof BaseCardInfo) {
                        ((BaseCardInfo) next).position = i;
                    }
                    arrayList2.add(next);
                    i++;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}

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
/* loaded from: classes5.dex */
public class aq7 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public bq7 b;
    public FrsItemTabNetModel c;
    public int d;
    public String e;

    public aq7(FrsItemTabFragment frsItemTabFragment, int i) {
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
        frsItemTabNetModel.x0(this);
        this.c.setUniqueId(frsItemTabFragment.getUniqueId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void A(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        bq7 bq7Var = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof FrsItemTabSocketResponseMessage)) {
            bq7Var = ((FrsItemTabSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (bq7Var != null && c(bq7Var)) {
            return;
        }
        this.d = mvcSocketResponsedMessage.getError();
        this.e = mvcSocketResponsedMessage.getErrorString();
        b();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void M(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        bq7 bq7Var = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof FrsItemTabHttpResponseMessage)) {
            bq7Var = (bq7) ((FrsItemTabHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (bq7Var != null && c(bq7Var)) {
            return;
        }
        this.d = mvcHttpResponsedMessage.getError();
        this.e = mvcHttpResponsedMessage.getErrorString();
        b();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            bq7 bq7Var = this.b;
            if (bq7Var != null && bq7Var.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.c.p0()) {
            return;
        }
        this.c.loadData();
        wx7.a();
    }

    public final boolean c(bq7 bq7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bq7Var)) == null) {
            if (bq7Var == null) {
                return false;
            }
            this.b = bq7Var;
            bq7Var.c = e(bq7Var.c);
            this.a.L1(this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<yn> e(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, arrayList)) == null) {
            ArrayList<yn> arrayList2 = new ArrayList<>();
            Iterator<yn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                yn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        z45 z45Var = new z45();
                        z45Var.t = threadData;
                        z45Var.position = i;
                        z45Var.a = true;
                        z45Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(z45Var);
                        z45 z45Var2 = new z45();
                        z45Var2.t = threadData;
                        z45Var2.position = i;
                        if (threadData.picCount() == 1) {
                            z45Var2.d = true;
                            z45Var2.u = imageWidthAndHeight[0];
                            z45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            z45Var2.e = true;
                        } else {
                            z45Var2.b = true;
                        }
                        z45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(z45Var2);
                        z45 z45Var3 = new z45();
                        z45Var3.g = true;
                        z45Var3.t = threadData;
                        z45Var3.position = i;
                        z45Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(z45Var3);
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

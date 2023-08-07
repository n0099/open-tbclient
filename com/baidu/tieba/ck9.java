package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ck9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements pz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ bi9 b;

        public a(PbModel pbModel, bi9 bi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, bi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbModel;
            this.b = bi9Var;
        }

        @Override // com.baidu.tieba.pz5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.S4(false);
            }
        }

        @Override // com.baidu.tieba.pz5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.r1() == null) {
                return;
            }
            ArrayList<qba> F = this.a.r1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<qba> it = F.iterator();
                while (it.hasNext()) {
                    qba next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.S())) {
                            it.remove();
                            if (this.a.r1().O() != null) {
                                this.a.r1().O().setReply_num(this.a.r1().O().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.d2(this.a.r1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            oz5.b().a();
        }
    }

    public static rz5 b(PbModel pbModel, bi9 bi9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, bi9Var)) == null) {
            if (pbModel != null && bi9Var != null) {
                rz5 rz5Var = new rz5();
                if (pbModel.r1() != null && pbModel.r1().k() != null) {
                    if (pbModel.r1().k().getDeletedReasonInfo() != null) {
                        rz5Var.p(pbModel.r1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        rz5Var.o(pbModel.r1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    rz5Var.l(pbModel.r1().k().getId());
                    rz5Var.m(pbModel.r1().k().getName());
                    rz5Var.k(pbModel.r1().k().getImage_url());
                    rz5Var.t(pbModel.r1().k().getUser_level());
                }
                if (pbModel.r1() != null && pbModel.r1().n() != null) {
                    rz5Var.n(pbModel.r1().n().has_forum_rule.intValue());
                }
                if (pbModel.r1() != null && pbModel.r1().V() != null) {
                    rz5Var.s(pbModel.r1().V());
                }
                rz5Var.q(new a(pbModel, bi9Var));
                if (pbModel.r1() != null) {
                    AntiData c = pbModel.r1().c();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (c != null && c.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    rz5Var.r(sparseArray);
                }
                return rz5Var;
            }
            return null;
        }
        return (rz5) invokeLL.objValue;
    }

    public static boolean c(sd9 sd9Var, qba qbaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, sd9Var, qbaVar)) == null) {
            if (sd9Var != null && qbaVar != null) {
                tz5 tz5Var = new tz5();
                tz5Var.d(qbaVar.O() + "");
                if (sd9Var.O() != null) {
                    tz5Var.f(sd9Var.O().getId());
                }
                tz5Var.e(qbaVar.S());
                return oz5.b().c(tz5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, bi9 bi9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, bi9Var) == null) && tbPageContext != null && pbModel != null && bi9Var != null) {
            oz5.b().e(tbPageContext, bi9Var.E1(), b(pbModel, bi9Var));
            oz5.b().d(1);
        }
    }

    public static boolean e(qba qbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, qbaVar)) == null) {
            if (qbaVar == null) {
                return false;
            }
            return oz5.b().f(qbaVar.S());
        }
        return invokeL.booleanValue;
    }
}

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
public class dk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements qz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ ci9 b;

        public a(PbModel pbModel, ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, ci9Var};
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
            this.b = ci9Var;
        }

        @Override // com.baidu.tieba.qz5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.S4(false);
            }
        }

        @Override // com.baidu.tieba.qz5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.s1() == null) {
                return;
            }
            ArrayList<rba> F = this.a.s1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<rba> it = F.iterator();
                while (it.hasNext()) {
                    rba next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.S())) {
                            it.remove();
                            if (this.a.s1().O() != null) {
                                this.a.s1().O().setReply_num(this.a.s1().O().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.d2(this.a.s1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            pz5.b().a();
        }
    }

    public static sz5 b(PbModel pbModel, ci9 ci9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, ci9Var)) == null) {
            if (pbModel != null && ci9Var != null) {
                sz5 sz5Var = new sz5();
                if (pbModel.s1() != null && pbModel.s1().k() != null) {
                    if (pbModel.s1().k().getDeletedReasonInfo() != null) {
                        sz5Var.p(pbModel.s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        sz5Var.o(pbModel.s1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    sz5Var.l(pbModel.s1().k().getId());
                    sz5Var.m(pbModel.s1().k().getName());
                    sz5Var.k(pbModel.s1().k().getImage_url());
                    sz5Var.t(pbModel.s1().k().getUser_level());
                }
                if (pbModel.s1() != null && pbModel.s1().n() != null) {
                    sz5Var.n(pbModel.s1().n().has_forum_rule.intValue());
                }
                if (pbModel.s1() != null && pbModel.s1().V() != null) {
                    sz5Var.s(pbModel.s1().V());
                }
                sz5Var.q(new a(pbModel, ci9Var));
                if (pbModel.s1() != null) {
                    AntiData c = pbModel.s1().c();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (c != null && c.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    sz5Var.r(sparseArray);
                }
                return sz5Var;
            }
            return null;
        }
        return (sz5) invokeLL.objValue;
    }

    public static boolean c(td9 td9Var, rba rbaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, td9Var, rbaVar)) == null) {
            if (td9Var != null && rbaVar != null) {
                uz5 uz5Var = new uz5();
                uz5Var.d(rbaVar.O() + "");
                if (td9Var.O() != null) {
                    uz5Var.f(td9Var.O().getId());
                }
                uz5Var.e(rbaVar.S());
                return pz5.b().c(uz5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, ci9 ci9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, ci9Var) == null) && tbPageContext != null && pbModel != null && ci9Var != null) {
            pz5.b().e(tbPageContext, ci9Var.E1(), b(pbModel, ci9Var));
            pz5.b().d(1);
        }
    }

    public static boolean e(rba rbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rbaVar)) == null) {
            if (rbaVar == null) {
                return false;
            }
            return pz5.b().f(rbaVar.S());
        }
        return invokeL.booleanValue;
    }
}

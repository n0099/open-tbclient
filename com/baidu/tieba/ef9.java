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
public class ef9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements c16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ dd9 b;

        public a(PbModel pbModel, dd9 dd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, dd9Var};
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
            this.b = dd9Var;
        }

        @Override // com.baidu.tieba.c16
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.u4(false);
            }
        }

        @Override // com.baidu.tieba.c16
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.y1() == null) {
                return;
            }
            ArrayList<n4a> F = this.a.y1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<n4a> it = F.iterator();
                while (it.hasNext()) {
                    n4a next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.S())) {
                            it.remove();
                            if (this.a.y1().N() != null) {
                                this.a.y1().N().setReply_num(this.a.y1().N().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.N1(this.a.y1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            b16.b().a();
        }
    }

    public static e16 b(PbModel pbModel, dd9 dd9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, dd9Var)) == null) {
            if (pbModel != null && dd9Var != null) {
                e16 e16Var = new e16();
                if (pbModel.y1() != null && pbModel.y1().k() != null) {
                    if (pbModel.y1().k().getDeletedReasonInfo() != null) {
                        e16Var.p(pbModel.y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        e16Var.o(pbModel.y1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    e16Var.l(pbModel.y1().k().getId());
                    e16Var.m(pbModel.y1().k().getName());
                    e16Var.k(pbModel.y1().k().getImage_url());
                    e16Var.t(pbModel.y1().k().getUser_level());
                }
                if (pbModel.y1() != null && pbModel.y1().n() != null) {
                    e16Var.n(pbModel.y1().n().has_forum_rule.intValue());
                }
                if (pbModel.y1() != null && pbModel.y1().U() != null) {
                    e16Var.s(pbModel.y1().U());
                }
                e16Var.q(new a(pbModel, dd9Var));
                if (pbModel.y1() != null) {
                    AntiData c = pbModel.y1().c();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (c != null && c.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    e16Var.r(sparseArray);
                }
                return e16Var;
            }
            return null;
        }
        return (e16) invokeLL.objValue;
    }

    public static boolean c(u89 u89Var, n4a n4aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, u89Var, n4aVar)) == null) {
            if (u89Var != null && n4aVar != null) {
                g16 g16Var = new g16();
                g16Var.d(n4aVar.O() + "");
                if (u89Var.N() != null) {
                    g16Var.f(u89Var.N().getId());
                }
                g16Var.e(n4aVar.S());
                return b16.b().c(g16Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, dd9 dd9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, dd9Var) == null) && tbPageContext != null && pbModel != null && dd9Var != null) {
            b16.b().e(tbPageContext, dd9Var.p1(), b(pbModel, dd9Var));
            b16.b().d(1);
        }
    }

    public static boolean e(n4a n4aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, n4aVar)) == null) {
            if (n4aVar == null) {
                return false;
            }
            return b16.b().f(n4aVar.S());
        }
        return invokeL.booleanValue;
    }
}

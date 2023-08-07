package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ik9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements pz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk9 a;
        public final /* synthetic */ SubPbModel b;

        public a(yk9 yk9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yk9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.pz5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.pz5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<ym> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<ym> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    ym next = it.next();
                    if (next instanceof qba) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((qba) next).S())) {
                                it.remove();
                                if (this.b.y0() != null) {
                                    this.b.y0().A(this.b.y0().k() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof hl9) {
                        ((hl9) data.get(i)).b(this.b.y0().k());
                    }
                    i++;
                }
                ((BdTypeListView) this.a.B()).setData(data);
                this.a.T();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            oz5.b().a();
        }
    }

    public static rz5 b(SubPbModel subPbModel, yk9 yk9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, yk9Var)) == null) {
            if (subPbModel != null && yk9Var != null) {
                rz5 rz5Var = new rz5();
                rz5Var.p(subPbModel.A0());
                rz5Var.o(subPbModel.z0());
                rz5Var.n(subPbModel.D0());
                if (subPbModel.y0() != null && subPbModel.y0().d() != null) {
                    rz5Var.l(subPbModel.y0().d().getId());
                    rz5Var.m(subPbModel.y0().d().getName());
                    rz5Var.k(subPbModel.y0().d().getImage_url());
                    rz5Var.t(subPbModel.y0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.F0());
                rz5Var.s(userData);
                rz5Var.q(new a(yk9Var, subPbModel));
                AntiData w0 = subPbModel.w0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (w0 != null && w0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = w0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                rz5Var.r(sparseArray);
                return rz5Var;
            }
            return null;
        }
        return (rz5) invokeLL.objValue;
    }

    public static boolean c(je9 je9Var, qba qbaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, je9Var, qbaVar)) == null) {
            if (je9Var != null && qbaVar != null && je9Var.d() != null && je9Var.j() != null) {
                tz5 tz5Var = new tz5();
                tz5Var.d(je9Var.d().getId());
                tz5Var.f(je9Var.j().getId());
                tz5Var.e(qbaVar.S());
                return oz5.b().c(tz5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, yk9 yk9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, yk9Var) == null) && tbPageContext != null && yk9Var != null && yk9Var.u() != null && subPbModel != null) {
            oz5.b().e(tbPageContext, (ViewGroup) yk9Var.u(), b(subPbModel, yk9Var));
            oz5.b().d(3);
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

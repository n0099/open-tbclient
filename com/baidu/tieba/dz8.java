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
/* loaded from: classes4.dex */
public class dz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements du5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz8 a;
        public final /* synthetic */ SubPbModel b;

        public a(kz8 kz8Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz8Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz8Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.du5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.du5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<in> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<in> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    in next = it.next();
                    if (next instanceof am9) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((am9) next).O())) {
                                it.remove();
                                if (this.b.B0() != null) {
                                    this.b.B0().A(this.b.B0().k() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof tz8) {
                        ((tz8) data.get(i)).b(this.b.B0().k());
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
            cu5.b().a();
        }
    }

    public static fu5 b(SubPbModel subPbModel, kz8 kz8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, kz8Var)) == null) {
            if (subPbModel != null && kz8Var != null) {
                fu5 fu5Var = new fu5();
                fu5Var.p(subPbModel.D0());
                fu5Var.o(subPbModel.C0());
                fu5Var.n(subPbModel.G0());
                if (subPbModel.B0() != null && subPbModel.B0().d() != null) {
                    fu5Var.l(subPbModel.B0().d().getId());
                    fu5Var.m(subPbModel.B0().d().getName());
                    fu5Var.k(subPbModel.B0().d().getImage_url());
                    fu5Var.t(subPbModel.B0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.I0());
                fu5Var.s(userData);
                fu5Var.q(new a(kz8Var, subPbModel));
                AntiData z0 = subPbModel.z0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (z0 != null && z0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = z0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                fu5Var.r(sparseArray);
                return fu5Var;
            }
            return null;
        }
        return (fu5) invokeLL.objValue;
    }

    public static boolean c(wt8 wt8Var, am9 am9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, wt8Var, am9Var)) == null) {
            if (wt8Var != null && am9Var != null && wt8Var.d() != null && wt8Var.j() != null) {
                hu5 hu5Var = new hu5();
                hu5Var.d(wt8Var.d().getId());
                hu5Var.f(wt8Var.j().getId());
                hu5Var.e(am9Var.O());
                return cu5.b().c(hu5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, kz8 kz8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, kz8Var) == null) && tbPageContext != null && kz8Var != null && kz8Var.u() != null && subPbModel != null) {
            cu5.b().e(tbPageContext, (ViewGroup) kz8Var.u(), b(subPbModel, kz8Var));
            cu5.b().d(3);
        }
    }

    public static boolean e(am9 am9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, am9Var)) == null) {
            if (am9Var == null) {
                return false;
            }
            return cu5.b().f(am9Var.O());
        }
        return invokeL.booleanValue;
    }
}

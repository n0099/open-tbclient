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
/* loaded from: classes5.dex */
public class fq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements f16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq9 a;
        public final /* synthetic */ SubPbModel b;

        public a(vq9 vq9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.f16
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.f16
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<cn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<cn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    cn next = it.next();
                    if (next instanceof tha) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((tha) next).U())) {
                                it.remove();
                                if (this.b.x0() != null) {
                                    this.b.x0().A(this.b.x0().k() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof er9) {
                        ((er9) data.get(i)).b(this.b.x0().k());
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
            e16.b().a();
        }
    }

    public static h16 b(SubPbModel subPbModel, vq9 vq9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, vq9Var)) == null) {
            if (subPbModel != null && vq9Var != null) {
                h16 h16Var = new h16();
                h16Var.p(subPbModel.z0());
                h16Var.o(subPbModel.y0());
                h16Var.n(subPbModel.C0());
                if (subPbModel.x0() != null && subPbModel.x0().d() != null) {
                    h16Var.l(subPbModel.x0().d().getId());
                    h16Var.m(subPbModel.x0().d().getName());
                    h16Var.k(subPbModel.x0().d().getImage_url());
                    h16Var.t(subPbModel.x0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.E0());
                h16Var.s(userData);
                h16Var.q(new a(vq9Var, subPbModel));
                AntiData v0 = subPbModel.v0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (v0 != null && v0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = v0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                h16Var.r(sparseArray);
                return h16Var;
            }
            return null;
        }
        return (h16) invokeLL.objValue;
    }

    public static boolean c(rj9 rj9Var, tha thaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, rj9Var, thaVar)) == null) {
            if (rj9Var != null && thaVar != null && rj9Var.d() != null && rj9Var.j() != null) {
                j16 j16Var = new j16();
                j16Var.d(rj9Var.d().getId());
                j16Var.f(rj9Var.j().getId());
                j16Var.e(thaVar.U());
                return e16.b().c(j16Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, vq9 vq9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, vq9Var) == null) && tbPageContext != null && vq9Var != null && vq9Var.u() != null && subPbModel != null) {
            e16.b().e(tbPageContext, (ViewGroup) vq9Var.u(), b(subPbModel, vq9Var));
            e16.b().d(3);
        }
    }

    public static boolean e(tha thaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, thaVar)) == null) {
            if (thaVar == null) {
                return false;
            }
            return e16.b().f(thaVar.U());
        }
        return invokeL.booleanValue;
    }
}

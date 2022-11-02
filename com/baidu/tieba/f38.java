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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements ol5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m38 a;
        public final /* synthetic */ SubPbModel b;

        public a(m38 m38Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m38Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m38Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.ol5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.ol5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<wn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<wn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    wn next = it.next();
                    if (next instanceof PostData) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((PostData) next).M())) {
                                it.remove();
                                if (this.b.m0() != null) {
                                    this.b.m0().F(this.b.m0().m() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof v38) {
                        ((v38) data.get(i)).b(this.b.m0().m());
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
            nl5.b().a();
        }
    }

    public static ql5 b(SubPbModel subPbModel, m38 m38Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, m38Var)) == null) {
            if (subPbModel != null && m38Var != null) {
                ql5 ql5Var = new ql5();
                ql5Var.p(subPbModel.o0());
                ql5Var.o(subPbModel.n0());
                ql5Var.n(subPbModel.r0());
                if (subPbModel.m0() != null && subPbModel.m0().d() != null) {
                    ql5Var.l(subPbModel.m0().d().getId());
                    ql5Var.m(subPbModel.m0().d().getName());
                    ql5Var.k(subPbModel.m0().d().getImage_url());
                    ql5Var.t(subPbModel.m0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.t0());
                ql5Var.s(userData);
                ql5Var.q(new a(m38Var, subPbModel));
                AntiData k0 = subPbModel.k0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (k0 != null && k0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = k0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                ql5Var.r(sparseArray);
                return ql5Var;
            }
            return null;
        }
        return (ql5) invokeLL.objValue;
    }

    public static boolean c(tx7 tx7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tx7Var, postData)) == null) {
            if (tx7Var != null && postData != null && tx7Var.d() != null && tx7Var.l() != null) {
                sl5 sl5Var = new sl5();
                sl5Var.d(tx7Var.d().getId());
                sl5Var.f(tx7Var.l().getId());
                sl5Var.e(postData.M());
                return nl5.b().c(sl5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, m38 m38Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, m38Var) == null) && tbPageContext != null && m38Var != null && m38Var.u() != null && subPbModel != null) {
            nl5.b().e(tbPageContext, (ViewGroup) m38Var.u(), b(subPbModel, m38Var));
            nl5.b().d(3);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return nl5.b().f(postData.M());
        }
        return invokeL.booleanValue;
    }
}

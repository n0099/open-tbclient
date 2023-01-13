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
/* loaded from: classes3.dex */
public class bb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements on5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib8 a;
        public final /* synthetic */ SubPbModel b;

        public a(ib8 ib8Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib8Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ib8Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.on5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.on5
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<yn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<yn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    yn next = it.next();
                    if (next instanceof PostData) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((PostData) next).O())) {
                                it.remove();
                                if (this.b.t0() != null) {
                                    this.b.t0().F(this.b.t0().m() - 1);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                while (i < data.size()) {
                    if (data.get(i) instanceof rb8) {
                        ((rb8) data.get(i)).b(this.b.t0().m());
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
            nn5.b().a();
        }
    }

    public static qn5 b(SubPbModel subPbModel, ib8 ib8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, ib8Var)) == null) {
            if (subPbModel != null && ib8Var != null) {
                qn5 qn5Var = new qn5();
                qn5Var.p(subPbModel.v0());
                qn5Var.o(subPbModel.u0());
                qn5Var.n(subPbModel.y0());
                if (subPbModel.t0() != null && subPbModel.t0().d() != null) {
                    qn5Var.l(subPbModel.t0().d().getId());
                    qn5Var.m(subPbModel.t0().d().getName());
                    qn5Var.k(subPbModel.t0().d().getImage_url());
                    qn5Var.t(subPbModel.t0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.A0());
                qn5Var.s(userData);
                qn5Var.q(new a(ib8Var, subPbModel));
                AntiData r0 = subPbModel.r0();
                SparseArray<String> sparseArray = new SparseArray<>();
                if (r0 != null && r0.getDelThreadInfoList() != null) {
                    List<DeleteThreadInfo> delThreadInfoList = r0.getDelThreadInfoList();
                    for (int i = 0; i < delThreadInfoList.size(); i++) {
                        if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                            sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                        }
                    }
                }
                qn5Var.r(sparseArray);
                return qn5Var;
            }
            return null;
        }
        return (qn5) invokeLL.objValue;
    }

    public static boolean c(o58 o58Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, o58Var, postData)) == null) {
            if (o58Var != null && postData != null && o58Var.d() != null && o58Var.l() != null) {
                sn5 sn5Var = new sn5();
                sn5Var.d(o58Var.d().getId());
                sn5Var.f(o58Var.l().getId());
                sn5Var.e(postData.O());
                return nn5.b().c(sn5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, ib8 ib8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, ib8Var) == null) && tbPageContext != null && ib8Var != null && ib8Var.u() != null && subPbModel != null) {
            nn5.b().e(tbPageContext, (ViewGroup) ib8Var.u(), b(subPbModel, ib8Var));
            nn5.b().d(3);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return nn5.b().f(postData.O());
        }
        return invokeL.booleanValue;
    }
}

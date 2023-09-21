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
public class cs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements g16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ss9 a;
        public final /* synthetic */ SubPbModel b;

        public a(ss9 ss9Var, SubPbModel subPbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss9Var, subPbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ss9Var;
            this.b = subPbModel;
        }

        @Override // com.baidu.tieba.g16
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0(false);
            }
        }

        @Override // com.baidu.tieba.g16
        public void b(List<String> list) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || !(this.a.B() instanceof BdTypeListView)) {
                return;
            }
            List<bn> data = ((BdTypeListView) this.a.B()).getData();
            if (!ListUtils.isEmpty(data) && !ListUtils.isEmpty(list)) {
                Iterator<bn> it = data.iterator();
                while (true) {
                    i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    bn next = it.next();
                    if (next instanceof zja) {
                        while (true) {
                            if (i >= list.size()) {
                                break;
                            } else if (TextUtils.equals(list.get(i), ((zja) next).U())) {
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
                    if (data.get(i) instanceof bt9) {
                        ((bt9) data.get(i)).b(this.b.x0().k());
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
            f16.b().a();
        }
    }

    public static i16 b(SubPbModel subPbModel, ss9 ss9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, subPbModel, ss9Var)) == null) {
            if (subPbModel != null && ss9Var != null) {
                i16 i16Var = new i16();
                i16Var.p(subPbModel.z0());
                i16Var.o(subPbModel.y0());
                i16Var.n(subPbModel.C0());
                if (subPbModel.x0() != null && subPbModel.x0().d() != null) {
                    i16Var.l(subPbModel.x0().d().getId());
                    i16Var.m(subPbModel.x0().d().getName());
                    i16Var.k(subPbModel.x0().d().getImage_url());
                    i16Var.t(subPbModel.x0().d().getUser_level());
                }
                UserData userData = new UserData();
                userData.setIsManager(subPbModel.E0());
                i16Var.s(userData);
                i16Var.q(new a(ss9Var, subPbModel));
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
                i16Var.r(sparseArray);
                return i16Var;
            }
            return null;
        }
        return (i16) invokeLL.objValue;
    }

    public static boolean c(cl9 cl9Var, zja zjaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cl9Var, zjaVar)) == null) {
            if (cl9Var != null && zjaVar != null && cl9Var.d() != null && cl9Var.j() != null) {
                k16 k16Var = new k16();
                k16Var.d(cl9Var.d().getId());
                k16Var.f(cl9Var.j().getId());
                k16Var.e(zjaVar.U());
                return f16.b().c(k16Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext tbPageContext, SubPbModel subPbModel, ss9 ss9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, subPbModel, ss9Var) == null) && tbPageContext != null && ss9Var != null && ss9Var.u() != null && subPbModel != null) {
            f16.b().e(tbPageContext, (ViewGroup) ss9Var.u(), b(subPbModel, ss9Var));
            f16.b().d(3);
        }
    }

    public static boolean e(zja zjaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zjaVar)) == null) {
            if (zjaVar == null) {
                return false;
            }
            return f16.b().f(zjaVar.U());
        }
        return invokeL.booleanValue;
    }
}

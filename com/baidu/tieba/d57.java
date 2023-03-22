package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdMixFloor;
/* loaded from: classes4.dex */
public class d57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;
    public final FrsLoadMoreModel b;
    public final FrsSmartLoadMoreModel c;
    public final FrsModelController d;
    public final kw6 e;
    public final b f;

    /* loaded from: classes4.dex */
    public interface b {
        void removeItem(int i);
    }

    /* loaded from: classes4.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d57 a;

        public a(d57 d57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d57Var;
        }

        @Override // com.baidu.tieba.d57.b
        public void removeItem(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.e != null && this.a.e.g0() != null) {
                List<gn> data = this.a.e.g0().getData();
                if (!ListUtils.isEmpty(data) && this.a.e.g0().getAdapter() != null && ((gn) ListUtils.remove(data, i)) != null) {
                    this.a.e.g0().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    }

    public d57(FrsFragment frsFragment, l57 l57Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, l57Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        if (frsFragment != null) {
            this.a = frsFragment;
            this.b = new FrsLoadMoreModel(frsFragment, l57Var);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, l57Var);
            this.c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.h0(this.f);
            this.b.n0(this.f);
            this.e = frsFragment.v1();
            FrsModelController Q0 = frsFragment.Q0();
            this.d = Q0;
            this.c.setSortType(Q0.w0());
            this.b.setSortType(this.d.w0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null || frsModelController.P0()) {
                return false;
            }
            return this.b.V(list);
        }
        return invokeL.booleanValue;
    }

    public void j(gn gnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gnVar) != null) || gnVar == null) {
            return;
        }
        if (this.d.P0()) {
            this.c.b0(gnVar);
        } else {
            this.b.g0(gnVar);
        }
    }

    public void k(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.d.P0()) {
                this.c.c0(str);
            } else {
                this.b.h0(str);
            }
        }
    }

    public void m(na7 na7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, na7Var) == null) {
            this.b.l0(na7Var);
            this.c.g0(na7Var);
        }
    }

    public void n(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.P0()) {
            this.c.setHasMore(i);
        } else {
            this.b.setHasMore(i);
        }
    }

    public void o(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i) != null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.P0()) {
            this.c.setPn(i);
        } else {
            this.b.setPn(i);
        }
    }

    public ArrayList<gn> c(boolean z, boolean z2, ArrayList<gn> arrayList, sb9 sb9Var, boolean z3, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, sb9Var, Boolean.valueOf(z3), Integer.valueOf(i), list})) == null) {
            return d(z, z2, arrayList, sb9Var, false, z3, i, list);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<gn> d(boolean z, boolean z2, ArrayList<gn> arrayList, sb9 sb9Var, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, sb9Var, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (this.d == null) {
                return arrayList;
            }
            boolean O0 = this.a.Q0().O0();
            if (this.d.P0()) {
                return this.c.T(z, O0, arrayList, z3, z4, i, list);
            }
            return this.b.Y(z, O0, z2, arrayList, sb9Var, list, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<gn> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d.P0()) {
                return this.c.U();
            }
            return this.d.s0();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.P0()) {
                return this.c.getPn();
            }
            return this.b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.P0()) {
                return this.c.V();
            }
            return this.b.a0();
        }
        return invokeV.intValue;
    }

    public void l() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.P0()) {
            this.c.d0();
        } else {
            this.b.k0();
        }
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.d != null && this.e != null && frsViewData != null) {
                this.a.H = System.currentTimeMillis();
                if (this.d.P0()) {
                    if (this.c.V() == 1 && !this.d.N0()) {
                        this.c.setSortType(this.d.w0());
                        this.c.S();
                        int pn = this.c.getPn();
                        this.c.setPn(pn);
                        this.d.S0(pn + 1);
                    }
                } else if (this.d.x0() == 1) {
                    if (!this.b.isLoading && !this.d.N0()) {
                        int pn2 = this.b.getPn();
                        if (this.b.V(frsViewData.getThreadListIds())) {
                            this.b.W();
                            this.b.setSortType(this.d.w0());
                            long g = gg.g(str2, 0L);
                            if (this.d.z0() != null) {
                                str3 = j09.e(this.d.z0().getThreadList(), false);
                            } else {
                                str3 = "";
                            }
                            this.b.j0(g, frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, str3);
                        } else if (this.b.a0() == 1) {
                            this.b.W();
                            this.b.setPn(pn2);
                            this.d.S0(pn2 + 1);
                            FrsLoadMoreModel frsLoadMoreModel = this.b;
                            frsLoadMoreModel.loadingDone = false;
                            frsLoadMoreModel.loadIndex = 0;
                        }
                    }
                } else if (this.d.Q0()) {
                } else {
                    this.d.R0();
                }
            }
        }
    }
}

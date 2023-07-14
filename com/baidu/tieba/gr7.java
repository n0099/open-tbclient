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
/* loaded from: classes6.dex */
public class gr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;
    public final FrsLoadMoreModel b;
    public final FrsSmartLoadMoreModel c;
    public final FrsModelController d;
    public final ei7 e;
    public final b f;

    /* loaded from: classes6.dex */
    public interface b {
        void removeItem(int i);
    }

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gr7 a;

        public a(gr7 gr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gr7Var;
        }

        @Override // com.baidu.tieba.gr7.b
        public void removeItem(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.e != null && this.a.e.g0() != null) {
                List<yn> data = this.a.e.g0().getData();
                if (!ListUtils.isEmpty(data) && this.a.e.g0().getAdapter() != null && ((yn) ListUtils.remove(data, i)) != null) {
                    this.a.e.g0().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    }

    public gr7(FrsFragment frsFragment, or7 or7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, or7Var};
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
            this.b = new FrsLoadMoreModel(frsFragment, or7Var);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, or7Var);
            this.c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.l0(this.f);
            this.b.r0(this.f);
            this.e = frsFragment.y1();
            FrsModelController V0 = frsFragment.V0();
            this.d = V0;
            this.c.setSortType(V0.A0());
            this.b.setSortType(this.d.A0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null || frsModelController.T0()) {
                return false;
            }
            return this.b.Z(list);
        }
        return invokeL.booleanValue;
    }

    public void j(yn ynVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ynVar) != null) || ynVar == null) {
            return;
        }
        if (this.d.T0()) {
            this.c.f0(ynVar);
        } else {
            this.b.k0(ynVar);
        }
    }

    public void k(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.d.T0()) {
                this.c.g0(str);
            } else {
                this.b.l0(str);
            }
        }
    }

    public void m(by7 by7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, by7Var) == null) {
            this.b.p0(by7Var);
            this.c.k0(by7Var);
        }
    }

    public void n(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.T0()) {
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
        if (frsModelController.T0()) {
            this.c.setPn(i);
        } else {
            this.b.setPn(i);
        }
    }

    public ArrayList<yn> c(boolean z, boolean z2, ArrayList<yn> arrayList, pca pcaVar, boolean z3, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, pcaVar, Boolean.valueOf(z3), Integer.valueOf(i), list})) == null) {
            return d(z, z2, arrayList, pcaVar, false, z3, i, list);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<yn> d(boolean z, boolean z2, ArrayList<yn> arrayList, pca pcaVar, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, pcaVar, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (this.d == null) {
                return arrayList;
            }
            boolean S0 = this.a.V0().S0();
            if (this.d.T0()) {
                return this.c.X(z, S0, arrayList, z3, z4, i, list);
            }
            return this.b.c0(z, S0, z2, arrayList, pcaVar, list, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<yn> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d.T0()) {
                return this.c.Y();
            }
            return this.d.w0();
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
            if (frsModelController.T0()) {
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
            if (frsModelController.T0()) {
                return this.c.Z();
            }
            return this.b.e0();
        }
        return invokeV.intValue;
    }

    public void l() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.T0()) {
            this.c.h0();
        } else {
            this.b.o0();
        }
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.d != null && this.e != null && frsViewData != null) {
                this.a.I = System.currentTimeMillis();
                if (this.d.T0()) {
                    if (this.c.Z() == 1 && !this.d.R0()) {
                        this.c.setSortType(this.d.A0());
                        this.c.W();
                        int pn = this.c.getPn();
                        this.c.setPn(pn);
                        this.d.W0(pn + 1);
                    }
                } else if (this.d.B0() == 1) {
                    if (!this.b.isLoading && !this.d.R0()) {
                        int pn2 = this.b.getPn();
                        if (this.b.Z(frsViewData.getThreadListIds())) {
                            this.b.a0();
                            this.b.setSortType(this.d.A0());
                            long g = wg.g(str2, 0L);
                            if (this.d.D0() != null) {
                                str3 = xx9.e(this.d.D0().getThreadList(), false);
                            } else {
                                str3 = "";
                            }
                            this.b.n0(g, frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, str3);
                        } else if (this.b.e0() == 1) {
                            this.b.a0();
                            this.b.setPn(pn2);
                            this.d.W0(pn2 + 1);
                            FrsLoadMoreModel frsLoadMoreModel = this.b;
                            frsLoadMoreModel.loadingDone = false;
                            frsLoadMoreModel.loadIndex = 0;
                        }
                    }
                } else if (this.d.U0()) {
                } else {
                    this.d.V0();
                }
            }
        }
    }
}

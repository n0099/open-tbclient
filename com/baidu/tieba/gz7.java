package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
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
public class gz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;
    public final FrsLoadMoreModel b;
    public final FrsSmartLoadMoreModel c;
    public final FrsModelController d;
    public final vp7 e;
    public final b f;

    /* loaded from: classes6.dex */
    public interface b {
        void removeItem(int i);
    }

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz7 a;

        public a(gz7 gz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz7Var;
        }

        @Override // com.baidu.tieba.gz7.b
        public void removeItem(int i) {
            int itemCount;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.e == null) {
                return;
            }
            try {
                if (this.a.e.g0() != null) {
                    List<oi> data = this.a.e.g0().getData();
                    if (!ListUtils.isEmpty(data) && this.a.e.g0().getAdapter() != null && ((oi) ListUtils.remove(data, i)) != null) {
                        this.a.e.g0().getAdapter().notifyItemRemoved(i);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
                if (this.a.e.g0().getAdapter() == null) {
                    itemCount = 0;
                } else {
                    itemCount = this.a.e.g0().getAdapter().getItemCount();
                }
                a48.f("frsLoadMoreController-removeItem()", i, itemCount, e);
                throw null;
            }
        }
    }

    public gz7(FrsFragment frsFragment, oz7 oz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, oz7Var};
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
            this.b = new FrsLoadMoreModel(frsFragment, oz7Var);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, oz7Var);
            this.c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.e0(this.f);
            this.b.k0(this.f);
            this.e = frsFragment.i2();
            FrsModelController y1 = frsFragment.y1();
            this.d = y1;
            this.c.setSortType(y1.t0());
            this.b.setSortType(this.d.t0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null || frsModelController.M0()) {
                return false;
            }
            return this.b.S(list);
        }
        return invokeL.booleanValue;
    }

    public void j(oi oiVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oiVar) != null) || oiVar == null) {
            return;
        }
        if (this.d.M0()) {
            this.c.Y(oiVar);
        } else {
            this.b.d0(oiVar);
        }
    }

    public void k(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.d.M0()) {
                this.c.Z(str);
            } else {
                this.b.e0(str);
            }
        }
    }

    public void m(x58 x58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, x58Var) == null) {
            this.b.i0(x58Var);
            this.c.d0(x58Var);
        }
    }

    public void n(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.M0()) {
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
        if (frsModelController.M0()) {
            this.c.setPn(i);
        } else {
            this.b.setPn(i);
        }
    }

    public ArrayList<oi> c(boolean z, boolean z2, ArrayList<oi> arrayList, kra kraVar, boolean z3, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, kraVar, Boolean.valueOf(z3), Integer.valueOf(i), list})) == null) {
            return d(z, z2, arrayList, kraVar, false, z3, i, list);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<oi> d(boolean z, boolean z2, ArrayList<oi> arrayList, kra kraVar, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, kraVar, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (this.d == null) {
                return arrayList;
            }
            boolean L0 = this.a.y1().L0();
            if (this.d.M0()) {
                return this.c.Q(z, L0, arrayList, z3, z4, i, list);
            }
            return this.b.V(z, L0, z2, arrayList, kraVar, list, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<oi> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d.M0()) {
                return this.c.R();
            }
            return this.d.p0();
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
            if (frsModelController.M0()) {
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
            if (frsModelController.M0()) {
                return this.c.S();
            }
            return this.b.X();
        }
        return invokeV.intValue;
    }

    public void l() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.M0()) {
            this.c.a0();
        } else {
            this.b.h0();
        }
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.d != null && this.e != null && frsViewData != null) {
                this.a.I = System.currentTimeMillis();
                if (this.d.M0()) {
                    if (this.c.S() == 1 && !this.d.K0()) {
                        this.c.setSortType(this.d.t0());
                        this.c.P();
                        int pn = this.c.getPn();
                        this.c.setPn(pn);
                        this.d.P0(pn + 1);
                    }
                } else if (this.d.u0() == 1) {
                    if (!this.b.isLoading && !this.d.K0()) {
                        int pn2 = this.b.getPn();
                        if (this.b.S(frsViewData.getThreadListIds())) {
                            this.b.T();
                            this.b.setSortType(this.d.t0());
                            long j = JavaTypesHelper.toLong(str2, 0L);
                            if (this.d.w0() != null) {
                                str3 = bca.e(this.d.w0().getThreadList(), false);
                            } else {
                                str3 = "";
                            }
                            this.b.g0(j, frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, str3);
                        } else if (this.b.X() == 1) {
                            this.b.T();
                            this.b.setPn(pn2);
                            this.d.P0(pn2 + 1);
                            FrsLoadMoreModel frsLoadMoreModel = this.b;
                            frsLoadMoreModel.loadingDone = false;
                            frsLoadMoreModel.loadIndex = 0;
                        }
                    }
                } else if (this.d.N0()) {
                } else {
                    this.d.O0();
                }
            }
        }
    }
}

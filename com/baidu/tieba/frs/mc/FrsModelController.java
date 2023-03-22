package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tieba.a9;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.aq5;
import com.baidu.tieba.ax6;
import com.baidu.tieba.ay6;
import com.baidu.tieba.b35;
import com.baidu.tieba.cl5;
import com.baidu.tieba.d97;
import com.baidu.tieba.ed9;
import com.baidu.tieba.f19;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.gg;
import com.baidu.tieba.gi;
import com.baidu.tieba.gn;
import com.baidu.tieba.gy4;
import com.baidu.tieba.ha9;
import com.baidu.tieba.hi;
import com.baidu.tieba.ia7;
import com.baidu.tieba.ia9;
import com.baidu.tieba.j09;
import com.baidu.tieba.ky5;
import com.baidu.tieba.lx6;
import com.baidu.tieba.mw6;
import com.baidu.tieba.mz4;
import com.baidu.tieba.n57;
import com.baidu.tieba.o39;
import com.baidu.tieba.o57;
import com.baidu.tieba.px6;
import com.baidu.tieba.qa9;
import com.baidu.tieba.r87;
import com.baidu.tieba.s87;
import com.baidu.tieba.sp5;
import com.baidu.tieba.sx5;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.vx6;
import com.baidu.tieba.wp5;
import com.baidu.tieba.ww6;
import com.baidu.tieba.x67;
import com.baidu.tieba.xa9;
import com.baidu.tieba.yw6;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements lx6, NetModel.k<FrsRequestData, qa9> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public boolean B;
    public String C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public ia9 H;
    public String I;
    public final SparseArray<Boolean> J;
    public boolean K;
    public o57 L;
    public n57 M;
    public px6 N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public final FrsFragment a;
    public FrsViewData b;
    public ArrayList<gn> c;
    public FrsRequestData d;
    public FrsNetModel e;
    public final xa9 f;
    public String g;
    public int h;
    public int i;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    public String j;
    public int k;
    public String l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public long q;
    public int r;
    public int s;
    public int t;
    public vx6 u;
    public boolean v;
    public SparseArray<vx6> w;
    public ax6 x;
    public px6 y;
    public ArrayList<gn> z;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int u0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048650, this, i, i2)) == null) ? (i * 10) + i2 : invokeII.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements px6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsModelController a;

        public a(FrsModelController frsModelController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsModelController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsModelController;
        }

        @Override // com.baidu.tieba.px6
        public void a(int i, int i2, ay6 ay6Var, ArrayList<gn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ay6Var, arrayList}) == null) {
                this.a.v = false;
                if (i == this.a.r && this.a.y != null) {
                    this.a.u = ay6Var;
                    this.a.p1(i, i2, ay6Var);
                    ArrayList<gn> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    this.a.b.setThreadList(arrayList2);
                    this.a.y.a(i, i2, ay6Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends wp5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ FrsModelController b;

        public b(FrsModelController frsModelController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsModelController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsModelController;
            this.a = str;
        }

        @Override // com.baidu.tieba.wp5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ha9.i().c(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends wp5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ FrsModelController b;

        public c(FrsModelController frsModelController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsModelController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsModelController;
            this.a = str;
        }

        @Override // com.baidu.tieba.wp5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ha9.i().d(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends wp5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ FrsModelController b;

        public d(FrsModelController frsModelController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsModelController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsModelController;
            this.a = str;
        }

        @Override // com.baidu.tieba.wp5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ha9.i().b(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends BdAsyncTask<Object, qa9, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public FrsModelController b;
        public boolean c;

        public e(FrsModelController frsModelController, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsModelController, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.a = str;
            this.b = frsModelController;
            this.c = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            int e;
            CustomResponsedMessage runTask;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                if (this.c && ha9.i().e(this.a)) {
                    if (!ha9.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        ha9.i().j().getForum().getSignData().is_signed = 0;
                    }
                    qa9 j = ha9.i().j();
                    j.setIsShowRedTip(false);
                    if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (e = gg.e(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e))) != null) {
                        j.setMangaReadRecordChapterId(Integer.valueOf(((Integer) runTask.getData()).intValue()));
                    }
                    publishProgress(j);
                } else {
                    publishProgress(null);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(qa9... qa9VarArr) {
            qa9 qa9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qa9VarArr) == null) {
                super.onProgressUpdate(qa9VarArr);
                FrsModelController frsModelController = this.b;
                if (frsModelController != null && qa9VarArr != null) {
                    if (qa9VarArr.length > 0) {
                        qa9Var = qa9VarArr[0];
                    } else {
                        qa9Var = null;
                    }
                    frsModelController.Z0(qa9Var);
                    FrsModelController frsModelController2 = this.b;
                    frsModelController2.h1(frsModelController2.D, true);
                    return;
                }
                FrsModelController frsModelController3 = this.b;
                if (frsModelController3 != null && !frsModelController3.e.x0()) {
                    if (this.b.e.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                        FrsModelController frsModelController4 = this.b;
                        frsModelController4.F((MvcHttpResponsedMessage) frsModelController4.e.getResponsedMessage(), (MvcHttpMessage) this.b.e.u0(), this.b.e.v0());
                    }
                    if (this.b.e.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                        FrsModelController frsModelController5 = this.b;
                        frsModelController5.u((MvcSocketResponsedMessage) frsModelController5.e.getResponsedMessage(), (MvcSocketMessage) this.b.e.u0(), this.b.e.v0());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, xa9 xa9Var) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, xa9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.h = 3;
        this.i = 1;
        this.j = null;
        this.k = 0;
        this.l = "normal_page";
        this.n = "";
        this.o = null;
        this.p = null;
        this.q = 0L;
        this.r = 1;
        this.s = 0;
        this.t = 0;
        this.v = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.w = new SparseArray<>();
        this.A = 0L;
        this.B = false;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.I = null;
        this.J = new SparseArray<>();
        this.L = new o57();
        this.M = new n57();
        this.N = new a(this);
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        if (xa9Var != null) {
            this.a = frsFragment;
            this.f = xa9Var;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.e = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.a.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.e;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.e.t0(this);
                }
                this.d = this.e.w0();
            }
            J0(this.a);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public void h1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.J.put(i, Boolean.valueOf(z));
        }
    }

    public final void i0(int i, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048624, this, i, frsRequestData) != null) || frsRequestData == null) {
            return;
        }
        if (i != 3) {
            if (i == 4) {
                frsRequestData.m0(2);
                return;
            }
            return;
        }
        frsRequestData.m0(1);
    }

    public final int j0(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048627, this, i, frsRequestData)) == null) {
            if (i == 1 && this.a.v3() != null) {
                return this.a.v3().d(this.D, frsRequestData);
            }
            return i;
        }
        return invokeIL.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, za zaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048645, this, i, zaVar) == null) {
            super.registerListener(i, zaVar);
        }
    }

    public vx6 t0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048648, this, i, i2)) == null) {
            return this.w.get(u0(i, i2));
        }
        return (vx6) invokeII.objValue;
    }

    public boolean E0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return this.J.get(i, Boolean.FALSE).booleanValue();
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.lx6
    public void O(px6 px6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, px6Var) == null) {
            this.y = px6Var;
            this.x.e(this.N);
        }
    }

    public void a1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            bundle.putString("name", this.g);
            bundle.putString("from", this.j);
            bundle.putInt("flag", this.k);
        }
    }

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            aq5.b(new d(this, str), null);
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            aq5.b(new b(this, str), null);
        }
    }

    public void f0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            aq5.b(new c(this, str), null);
        }
    }

    public void i1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.G = z;
        }
    }

    public void j1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.K = z;
        }
    }

    public void k1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.E = i;
        }
    }

    public void m1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.n = str;
        }
    }

    @NonNull
    public final ErrorData n0(ResponsedMessage responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, responsedMessage)) == null) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = responsedMessage.getError();
            this.mErrorString = responsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            return errorData;
        }
        return (ErrorData) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, messageListener) == null) {
            super.registerListener(messageListener);
        }
    }

    public long A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.R;
        }
        return invokeV.longValue;
    }

    public long B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.O;
        }
        return invokeV.longValue;
    }

    public long C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.Q;
        }
        return invokeV.longValue;
    }

    public long D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.P;
        }
        return invokeV.longValue;
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.z.size() == 0) {
                this.z.add(new ww6());
            }
        }
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                int i = frsFragment.N0;
                if (i == -1 || i == this.r) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.D == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.e.l0();
        }
        return invokeV.booleanValue;
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            FrsRequestData frsRequestData = this.d;
            if (frsRequestData != null && frsRequestData.W() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.D != 7 && (this.e.x0() || this.F != 7)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.e.cancelLoadData();
        }
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            vx6 vx6Var = this.u;
            if (!(vx6Var instanceof ay6) || ((ay6) vx6Var).e != 0) {
                return true;
            }
            return ((ay6) vx6Var).g;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lx6
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.x.d();
        }
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lx6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.x.b();
            this.x.clear();
        }
    }

    public int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public final boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            this.O = System.currentTimeMillis();
            ia7.a();
            return this.e.loadData();
        }
        return invokeV.booleanValue;
    }

    public ia9 o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.H;
        }
        return (ia9) invokeV.objValue;
    }

    public FrsRequestData p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.d;
        }
        return (FrsRequestData) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (1 == this.r) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public ArrayList<gn> s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return r87.d(this.D);
        }
        return invokeV.intValue;
    }

    public int x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public FrsViewData z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.b;
        }
        return (FrsViewData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void F(MvcHttpResponsedMessage<qa9> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, qa9> mvcHttpMessage, MvcNetMessage<FrsRequestData, qa9> mvcNetMessage) {
        qa9 qa9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.M.a(this);
        this.M.e(mvcHttpResponsedMessage);
        this.M.c(mvcHttpMessage);
        this.M.d(mvcNetMessage);
        this.M.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.M);
        this.H = ia9.a(mvcHttpResponsedMessage);
        FrsRequestData frsRequestData = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            qa9Var = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                frsRequestData = mvcHttpMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                frsRequestData = mvcNetMessage.getRequestData();
            }
        } else {
            qa9Var = null;
        }
        if (frsRequestData != null && qa9Var != null && b1(frsRequestData, qa9Var)) {
            return;
        }
        this.a.g(n0(mvcHttpResponsedMessage));
    }

    public void X0(MvcSocketResponsedMessage<qa9, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, qa9> mvcSocketMessage, MvcNetMessage<FrsRequestData, qa9> mvcNetMessage) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (!this.B) {
                this.B = true;
                U0(1000, false, mvcSocketResponsedMessage);
            } else {
                W0(false, mvcSocketResponsedMessage);
            }
            long j = 0;
            String str = null;
            if (mvcSocketMessage != null) {
                j = mvcSocketMessage.getClientLogID();
                frsRequestData = mvcSocketMessage.getRequestData();
            } else {
                frsRequestData = null;
            }
            if (mvcNetMessage != null) {
                j = mvcNetMessage.getLogID();
                frsRequestData = mvcNetMessage.getRequestData();
            }
            long j2 = j;
            int error = mvcSocketResponsedMessage.getError();
            String errorString = mvcSocketResponsedMessage.getErrorString();
            if (error != 0) {
                int cmd = mvcSocketResponsedMessage.getCmd();
                Object[] objArr = new Object[4];
                objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
                if (frsRequestData != null) {
                    str = frsRequestData.V();
                }
                objArr[1] = str;
                objArr[2] = PushConstants.SEQ_ID;
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                b35.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void u(MvcSocketResponsedMessage<qa9, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, qa9> mvcSocketMessage, MvcNetMessage<FrsRequestData, qa9> mvcNetMessage) {
        qa9 data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048649, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.L.a(this);
        this.L.e(mvcSocketResponsedMessage);
        this.L.c(mvcSocketMessage);
        this.L.d(mvcNetMessage);
        this.L.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.L);
        this.H = ia9.a(mvcSocketResponsedMessage);
        FrsRequestData frsRequestData = null;
        if (mvcSocketResponsedMessage.hasError() && 340001 != mvcSocketResponsedMessage.getError()) {
            data = null;
        } else {
            data = mvcSocketResponsedMessage.getData();
            if (mvcSocketMessage != null) {
                frsRequestData = mvcSocketMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                frsRequestData = mvcNetMessage.getRequestData();
            }
        }
        if (frsRequestData != null && data != null && b1(frsRequestData, data)) {
            return;
        }
        this.a.g(n0(mvcSocketResponsedMessage));
    }

    public void F0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            if (bundle != null) {
                this.g = bundle.getString("name");
                this.j = bundle.getString("from");
                this.k = bundle.getInt("flag", 0);
                this.C = bundle.getString("yuelaou_locate");
                this.m = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
                this.a.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            }
            if (TextUtils.isEmpty(this.g)) {
                this.g = "";
            }
            if (TextUtils.isEmpty(this.j)) {
                this.j = "";
            }
            if (TextUtils.isEmpty(this.C)) {
                this.C = "";
            }
            this.o = this.j;
            I0();
            if (this.b == null) {
                this.b = new FrsViewData();
            }
            if (this.e == null || (frsRequestData = this.d) == null || frsRequestData.P() == null || this.d.P().isEmpty() || this.d.P().containsKey(null) || this.d.P().containsValue(null)) {
                G0(bundle);
            }
            String str = this.g;
            if (str != null && str.length() > 0) {
                String str2 = this.j;
                if (str2 == null || str2.length() <= 0) {
                    this.j = "tb_forumlist";
                }
            }
        }
    }

    @Override // com.baidu.tieba.lx6
    public void G(int i, int i2, vx6 vx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, vx6Var) == null) {
            this.r = j0(i, null);
            if (vx6Var == null && (vx6Var = t0(i, i2)) == null) {
                if (i != 1 && hi.F() && this.y != null) {
                    ay6 ay6Var = new ay6();
                    ay6Var.g = false;
                    ay6Var.c = 1;
                    ay6Var.a = this.g;
                    ay6Var.i = false;
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        ay6Var.b = this.b.getForum().getId();
                    }
                    H0();
                    this.b.setThreadList(this.z);
                    this.y.a(i, i2, ay6Var, this.z);
                }
                vx6Var = new vx6();
                vx6Var.c = -1;
            }
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                vx6Var.b = this.b.getForum().getId();
            }
            vx6Var.a = this.g;
            if (yw6.a().b(1) != null && this.r == 1) {
                this.d.Z(i2);
            }
            this.s = i2;
            this.u = vx6Var;
            p1(i, i2, vx6Var);
            T0(5);
        }
    }

    public final void U0(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 4).param(TiebaStatic.Params.OBJ_PARAM2, System.currentTimeMillis() - this.a.A));
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.a;
            this.A = currentTimeMillis - frsFragment.A;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.a;
            frsFragment.C = currentTimeMillis2 - frsFragment2.B;
            cl5 cl5Var = new cl5(i, z, responsedMessage, frsFragment2.D, frsFragment2.E, frsFragment2.C, false, frsFragment2.F, frsFragment2.G, this.A);
            FrsFragment frsFragment3 = this.a;
            frsFragment3.E = 0L;
            frsFragment3.D = 0L;
            s87.f(this, frsFragment3.A);
            this.a.A = -1L;
            cl5Var.c();
        }
    }

    public final void G0(Bundle bundle) {
        int i;
        ArrayList<gn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.d = frsRequestData;
            frsRequestData.setSortType(r87.d(this.D));
            if (this.D == 5) {
                this.d.g0(1);
            } else {
                this.d.g0(0);
            }
            this.d.R("forum_name", gi.getUrlEncode(this.g));
            this.d.R("client_type", "2");
            this.d.setPn(1);
            if (bundle != null) {
                this.d.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.d.e0(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.d.o0("2");
            this.d.p0("-2");
            this.d.i0(this.g);
            this.d.w0(1);
            this.d.a0(0);
            this.d.v0(hi.l(TbadkCoreApplication.getInst()));
            this.d.u0(hi.j(TbadkCoreApplication.getInst()));
            this.d.t0(hi.i(TbadkCoreApplication.getInst()));
            FrsRequestData frsRequestData2 = this.d;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            frsRequestData2.y0(i);
            this.d.s0(this.n);
            this.d.k0(null);
            this.d.x0(this.C);
            this.d.j0(gg.g(sp5.a(), 0L));
            this.d.setStType(this.j);
            this.d.f0(1);
            this.d.setNeedCache(true);
            this.d.setUpdateType(3);
            FrsRequestData frsRequestData3 = this.d;
            FrsViewData frsViewData = this.b;
            if (frsViewData == null) {
                threadList = null;
            } else {
                threadList = frsViewData.getThreadList();
            }
            frsRequestData3.Y(j09.e(threadList, true));
            r87.e(this.D, this.d);
            this.d.m0(1);
            if (ThreadData.isRecAppLoaded.get() && f19.l().b() != null) {
                int d2 = f19.l().b().d(this.g, false);
                int e2 = f19.l().b().e(this.g, false);
                if (this.d.W() == 1) {
                    d2++;
                } else if (this.d.W() == 2) {
                    e2++;
                }
                this.d.q0(d2);
                this.d.l0(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.d);
            this.e = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.a.getActivity()).getUniqueId());
            this.e.t0(this);
            this.e.loadData();
            ia7.a();
        }
    }

    public final void I0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
                g1(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
                g1(6);
            } else {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                this.F = r87.h("1~" + str + this.g);
                g1(this.D);
            }
        }
    }

    public final void J0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, frsFragment) == null) {
            ax6 ax6Var = new ax6();
            this.x = ax6Var;
            ax6Var.a = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.x));
            this.x.e(this.N);
        }
    }

    public void S0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            if (this.r != 1) {
                T0(4);
            } else if (this.e.l0()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(i);
                frsRequestData.setSortType(w0());
                g0(frsRequestData, 4, false);
            }
        }
    }

    public final void Z0(qa9 qa9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, qa9Var) == null) {
            this.isCacheFirstLoad = false;
            this.b.receiveData(qa9Var);
            e1(this.b);
            this.c = new ArrayList<>();
            if (this.b.getThreadList() != null) {
                this.c.addAll(this.b.getThreadList());
            }
            this.f.c(qa9Var);
        }
    }

    public final void e1(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, frsViewData) == null) {
            if (d97.O(frsViewData)) {
                this.l = "book_page";
            } else if (frsViewData.getIsBrandForum()) {
                this.l = "brand_page";
            } else if (d97.P(frsViewData)) {
                this.l = "frs_page";
            } else {
                this.l = "normal_page";
            }
        }
    }

    public final void f1(qa9 qa9Var) {
        FrsFragment frsFragment;
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, qa9Var) != null) || qa9Var == null || (frsFragment = this.a) == null || frsFragment.getActivity() == null || (intent = this.a.getActivity().getIntent()) == null) {
            return;
        }
        o39.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), qa9Var.getForum().getId());
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.r != 1) {
                T0(1);
                return true;
            } else if (this.e.l0()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(w0());
                g0(frsRequestData, 1, false);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0010, code lost:
        if (r5 != 4) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.h = i;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        vx6 vx6Var = this.u;
                        if (vx6Var != null) {
                            vx6Var.c = -1;
                        }
                    }
                } else {
                    vx6 vx6Var2 = this.u;
                    if (vx6Var2 != null) {
                        vx6Var2.c--;
                    }
                }
                i2 = this.r;
                if (i2 != 1) {
                    if (this.t == this.s) {
                        ArrayList<gn> arrayList = new ArrayList<>();
                        ArrayList<gn> arrayList2 = this.c;
                        if (arrayList2 != null) {
                            arrayList.addAll(arrayList2);
                        }
                        this.b.setThreadList(arrayList);
                        px6 px6Var = this.y;
                        if (px6Var != null) {
                            px6Var.a(this.r, this.s, null, arrayList);
                        }
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                    }
                    this.t = this.s;
                    return;
                }
                lx6 c2 = this.x.c(i2);
                if (c2 != null) {
                    this.v = true;
                    c2.G(this.r, this.s, this.u);
                    return;
                }
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getThreadList() != null) {
                    this.b.getThreadList().clear();
                }
                this.y.a(this.r, this.s, null, null);
                return;
            }
            vx6 vx6Var3 = this.u;
            if (vx6Var3 != null) {
                vx6Var3.c++;
            }
            i2 = this.r;
            if (i2 != 1) {
            }
        }
    }

    public void V0(MvcHttpResponsedMessage<qa9> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, qa9> mvcHttpMessage, MvcNetMessage<FrsRequestData, qa9> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048600, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            String str = null;
            if (mvcHttpMessage != null) {
                j = mvcHttpMessage.getClientLogID();
                frsRequestData = mvcHttpMessage.getRequestData();
            } else {
                j = 0;
                frsRequestData = null;
            }
            if (mvcNetMessage != null) {
                j = mvcNetMessage.getLogID();
                frsRequestData = mvcNetMessage.getRequestData();
            }
            long j2 = j;
            int error = mvcHttpResponsedMessage.getError();
            String errorString = mvcHttpResponsedMessage.getErrorString();
            if (error != 0) {
                int cmd = mvcHttpResponsedMessage.getCmd();
                Object[] objArr = new Object[2];
                objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
                if (frsRequestData != null) {
                    str = frsRequestData.V();
                }
                objArr[1] = str;
                b35.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
            }
            if (!this.B) {
                this.B = true;
                U0(1000, true, mvcHttpResponsedMessage);
                return;
            }
            W0(true, mvcHttpResponsedMessage);
        }
    }

    public final void W0(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048601, this, z, responsedMessage) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FrsFragment frsFragment = this.a;
        this.A = currentTimeMillis - frsFragment.H;
        long currentTimeMillis2 = System.currentTimeMillis();
        FrsFragment frsFragment2 = this.a;
        frsFragment.C = currentTimeMillis2 - frsFragment2.B;
        cl5 cl5Var = new cl5(1000, z, responsedMessage, frsFragment2.D, frsFragment2.E, frsFragment2.C, false, frsFragment2.F, frsFragment2.G, this.A);
        int i = this.h;
        if (i == 4) {
            cl5Var.B = this.A;
            cl5Var.e(true);
        } else if (i == 3) {
            cl5Var.C = this.A;
            cl5Var.e(false);
        }
    }

    public void k0(int i, boolean z) {
        ArrayList<gn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.a.H = System.currentTimeMillis();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.b.getLikeFeedForumDataList().clear();
            }
            this.r = j0(this.r, this.d);
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 == null) {
                threadList = null;
            } else {
                threadList = frsViewData2.getThreadList();
            }
            frsRequestData.Y(j09.e(threadList, true));
            if (this.r == 1) {
                h0(this.d, i, !z);
                return;
            }
            if (this.u == null) {
                vx6 vx6Var = new vx6();
                this.u = vx6Var;
                vx6Var.c = 1;
                vx6Var.a = this.g;
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.u.b = this.b.getForum().getId();
                }
            }
            T0(i);
        }
    }

    public void b0(gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, gy4Var) == null) && gy4Var != null && !StringUtils.isNull(gy4Var.getId()) && !ListUtils.isEmpty(this.c)) {
            if (this.r == 1) {
                this.b.addMyNewThread(gy4Var);
            }
            int y0 = y0();
            Iterator<gn> it = this.c.iterator();
            while (it.hasNext()) {
                gn next = it.next();
                if ((next instanceof mz4) && gy4Var.getId().equals(((mz4) next).t.getId())) {
                    return;
                }
            }
            this.c.add(y0, gy4Var);
        }
    }

    public void g1(int i) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.D = i;
            if (i != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                r87.i("1~" + str + this.g, this.D);
            }
            if (7 == i) {
                ed9.b();
            } else {
                ed9.a();
            }
        }
    }

    public boolean b1(FrsRequestData frsRequestData, qa9 qa9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, frsRequestData, qa9Var)) == null) {
            if (qa9Var == null || qa9Var.getForum() == null || (gi.isEmpty(qa9Var.getForum().getName()) && 340001 != qa9Var.mErrorNo)) {
                return false;
            }
            if (qa9Var.getDataParseTime() > 0) {
                this.a.G = qa9Var.getDataParseTime();
            }
            if (qa9Var.getEntelechyTabInfo() != null && !ListUtils.isEmpty(qa9Var.getEntelechyTabInfo().a)) {
                int intValue = qa9Var.getEntelechyTabInfo().a.get(0).tab_type.intValue();
                AbsDataRecorder.Scene scene = AbsDataRecorder.Scene.FRS_HOT;
                this.a.C4(13);
                if (intValue == 14) {
                    scene = AbsDataRecorder.Scene.FRS_NEW;
                    this.a.C4(14);
                }
                if (sx5.k().l(scene)) {
                    sx5.k().g(scene).b();
                }
                if (ky5.i().o(scene)) {
                    ky5.i().g(scene).b();
                }
            }
            g1(r87.f(qa9Var.getSortType()));
            h1(r87.f(qa9Var.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.r = qa9Var.getFrsDefaultTabId();
            }
            this.b.receiveData(qa9Var);
            e1(this.b);
            this.c = new ArrayList<>();
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.i = frsRequestData.getPn();
                String V = this.d.V();
                this.g = V;
                this.a.E4(V);
                this.a.setFrom(this.j);
                this.a.R4(this.i);
                this.a.D4(this.k);
            }
            if (this.b.getThreadList() != null) {
                this.c.addAll(this.b.getThreadList());
            }
            if (this.r != 1 && this.isNetFirstLoad) {
                this.f.d(7, false, this.H);
            } else {
                this.f.d(this.h, false, this.H);
            }
            this.o = null;
            if (x67.b(this.d)) {
                d1();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.V3();
                }
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.b.getForum()));
            }
            this.isNetFirstLoad = false;
            if (qa9Var.getForum() != null && !TextUtils.isEmpty(qa9Var.getForum().getName()) && frsRequestData != null && f19.l().b() != null) {
                f19.l().b().g(qa9Var.getForum().getName(), frsRequestData.W(), false);
            }
            if (this.a != null && !StringUtils.isNull(qa9Var.getUserData().getAppealThreadPopover())) {
                this.a.a5(TbadkCoreApplication.getCurrentAccount(), qa9Var.getForum().getId(), qa9Var.getUserData().getAppealThreadPopover());
            }
            f1(qa9Var);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void c0(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048608, this, str, frsRequestData) != null) || !ThreadData.isRecAppLoaded.get() || f19.l().b() == null) {
            return;
        }
        int d2 = f19.l().b().d(str, false);
        int e2 = f19.l().b().e(str, false);
        if (frsRequestData.W() == 1) {
            d2++;
        } else if (frsRequestData.W() == 2) {
            e2++;
        }
        frsRequestData.q0(d2);
        frsRequestData.l0(e2);
    }

    public void c1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == null) {
            return;
        }
        this.a.H = System.currentTimeMillis();
        FrsViewData frsViewData = this.b;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.b.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(1);
        int j0 = j0(this.r, frsRequestData);
        this.r = j0;
        if (j0 == 1) {
            if (this.e.l0()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            g0(frsRequestData, i, !z);
            return;
        }
        if (this.u == null) {
            vx6 vx6Var = new vx6();
            this.u = vx6Var;
            vx6Var.c = 1;
            vx6Var.a = this.g;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.u.b = this.b.getForum().getId();
            }
        }
        T0(i);
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(gg.g(this.b.getForum().getId(), 0L));
            }
            this.a.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            mw6 mw6Var = new mw6();
            if (this.t == 0) {
                mw6Var.b(this.D);
            }
            if (this.b.getThreadList() != null) {
                this.b.getThreadList().clear();
                this.b.getThreadList().add(mw6Var);
            }
            ArrayList<gn> arrayList = this.c;
            if (arrayList != null) {
                arrayList.clear();
                this.c.add(mw6Var);
            }
        }
    }

    public void o1() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048640, this) != null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    public int y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            ArrayList<gn> arrayList = this.c;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<gn> it = this.c.iterator();
                while (it.hasNext()) {
                    gn next = it.next();
                    if (next instanceof mz4) {
                        if (((mz4) next).t.getIs_top() == 0) {
                            break;
                        }
                        i++;
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void g0(FrsRequestData frsRequestData, int i, boolean z) {
        String str;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.y4(z);
            this.f.a(i);
            this.e.y0(frsRequestData);
            if (this.a.c4()) {
                str = "1";
            } else {
                str = "2";
            }
            frsRequestData.o0(str);
            if (this.G) {
                frsRequestData.p0(String.valueOf(r87.d(this.E)));
            } else {
                frsRequestData.p0("-2");
            }
            this.G = false;
            frsRequestData.i0(this.g);
            frsRequestData.w0(1);
            frsRequestData.a0(0);
            int l = hi.l(TbadkCoreApplication.getInst());
            int j = hi.j(TbadkCoreApplication.getInst());
            float i3 = hi.i(TbadkCoreApplication.getInst());
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            frsRequestData.v0(l);
            frsRequestData.u0(j);
            frsRequestData.t0(i3);
            frsRequestData.y0(i2);
            frsRequestData.s0(this.n);
            frsRequestData.k0(this.p);
            frsRequestData.x0(this.C);
            frsRequestData.j0(gg.g(sp5.a(), 0L));
            String str2 = this.o;
            ArrayList<gn> arrayList = null;
            if (str2 != null) {
                frsRequestData.setStType(str2);
                if ("sidebar".equalsIgnoreCase(this.o)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.f0(L0());
            if (FrsFragment.s2 != 0) {
                frsRequestData.b0((int) FrsFragment.s2);
            }
            if (FrsFragment.t2 != 0) {
                frsRequestData.c0((int) FrsFragment.t2);
            }
            if (FrsFragment.u2 != 0) {
                frsRequestData.n0(FrsFragment.u2);
            }
            if (frsRequestData.getPn() != 1 && this.h != 3) {
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    arrayList = frsViewData.getThreadList();
                }
                frsRequestData.Y(j09.e(arrayList, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    arrayList = frsViewData2.getThreadList();
                }
                frsRequestData.Y(j09.e(arrayList, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.h);
            frsRequestData.e0(this.q);
            r87.e(this.D, frsRequestData);
            int d2 = r87.d(this.F);
            i0(i, frsRequestData);
            c0(this.g, frsRequestData);
            if (!E0(this.F) && !this.a.i && !this.K) {
                ha9 i4 = ha9.i();
                String g = i4.g("1~" + this.g, d2, frsRequestData.U(), this.d.S());
                this.I = g;
                new e(this, true, g).execute(new Object[0]);
            }
            n1();
            this.K = false;
        }
    }

    public final void h0(FrsRequestData frsRequestData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.y4(z);
            this.f.a(i);
            if (this.e.x0() && (this.e.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                F((MvcHttpResponsedMessage) this.e.getResponsedMessage(), (MvcHttpMessage) this.e.u0(), this.e.v0());
            } else if (this.e.x0() && (this.e.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                u((MvcSocketResponsedMessage) this.e.getResponsedMessage(), (MvcSocketMessage) this.e.u0(), this.e.v0());
            } else {
                int d2 = r87.d(this.F);
                if (!E0(this.F) && !this.a.i && !this.K) {
                    ha9 i2 = ha9.i();
                    String g = i2.g("1~" + this.g, d2, frsRequestData.U(), this.d.S());
                    this.I = g;
                    new e(this, true, g).execute(new Object[0]);
                }
                this.K = false;
            }
            this.e.t0(this);
        }
    }

    public final void p1(int i, int i2, vx6 vx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048642, this, i, i2, vx6Var) == null) {
            this.w.put(u0(i, i2), vx6Var);
        }
    }
}

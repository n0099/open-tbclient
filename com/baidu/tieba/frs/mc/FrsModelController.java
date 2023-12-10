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
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.log.Logger;
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
import com.baidu.tieba.a78;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.au7;
import com.baidu.tieba.bt7;
import com.baidu.tieba.dt7;
import com.baidu.tieba.eu7;
import com.baidu.tieba.eva;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.g36;
import com.baidu.tieba.gy4;
import com.baidu.tieba.h28;
import com.baidu.tieba.i28;
import com.baidu.tieba.ju5;
import com.baidu.tieba.lva;
import com.baidu.tieba.m78;
import com.baidu.tieba.mz4;
import com.baidu.tieba.n26;
import com.baidu.tieba.nu5;
import com.baidu.tieba.ot7;
import com.baidu.tieba.pi;
import com.baidu.tieba.ps7;
import com.baidu.tieba.q38;
import com.baidu.tieba.rd;
import com.baidu.tieba.ru5;
import com.baidu.tieba.s88;
import com.baidu.tieba.st7;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tp5;
import com.baidu.tieba.txa;
import com.baidu.tieba.vua;
import com.baidu.tieba.wha;
import com.baidu.tieba.wua;
import com.baidu.tieba.yma;
import com.baidu.tieba.z68;
import com.baidu.tieba.zga;
import com.baidu.tieba.zs7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements ot7, NetModel.k<FrsRequestData, eva> {
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
    public wua H;
    public String I;
    public final SparseArray<Boolean> J;
    public boolean K;
    public i28 L;
    public h28 M;
    public st7 N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public final FrsFragment a;
    public FrsViewData b;
    public ArrayList<pi> c;
    public FrsRequestData d;
    public FrsNetModel e;
    public final lva f;
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
    public au7 u;
    public boolean v;
    public SparseArray<au7> w;
    public dt7 x;
    public st7 y;
    public ArrayList<pi> z;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int r0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048644, this, i, i2)) == null) ? (i * 10) + i2 : invokeII.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements st7 {
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

        @Override // com.baidu.tieba.st7
        public void a(int i, int i2, eu7 eu7Var, ArrayList<pi> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), eu7Var, arrayList}) == null) {
                this.a.v = false;
                if (i == this.a.r && this.a.y != null) {
                    this.a.u = eu7Var;
                    this.a.m1(i, i2, eu7Var);
                    ArrayList<pi> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    this.a.b.setThreadList(arrayList2);
                    this.a.y.a(i, i2, eu7Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends nu5<Object> {
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

        @Override // com.baidu.tieba.nu5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                vua.i().c(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends nu5<Object> {
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

        @Override // com.baidu.tieba.nu5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                vua.i().d(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends nu5<Object> {
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

        @Override // com.baidu.tieba.nu5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                vua.i().b(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends BdAsyncTask<Object, eva, Void> {
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
            int i;
            CustomResponsedMessage runTask;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                if (this.c && vua.i().e(this.a)) {
                    if (!vua.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        vua.i().j().getForum().getSignData().is_signed = 0;
                    }
                    eva j = vua.i().j();
                    j.setIsShowRedTip(false);
                    if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (i = JavaTypesHelper.toInt(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(i))) != null) {
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
        public void onProgressUpdate(eva... evaVarArr) {
            eva evaVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, evaVarArr) == null) {
                super.onProgressUpdate(evaVarArr);
                FrsModelController frsModelController = this.b;
                if (frsModelController != null && evaVarArr != null) {
                    if (evaVarArr.length > 0) {
                        evaVar = evaVarArr[0];
                    } else {
                        evaVar = null;
                    }
                    frsModelController.W0(evaVar);
                    FrsModelController frsModelController2 = this.b;
                    frsModelController2.e1(frsModelController2.D, true);
                    return;
                }
                FrsModelController frsModelController3 = this.b;
                if (frsModelController3 != null && !frsModelController3.e.u0()) {
                    if (this.b.e.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                        FrsModelController frsModelController4 = this.b;
                        frsModelController4.I((MvcHttpResponsedMessage) frsModelController4.e.getResponsedMessage(), (MvcHttpMessage) this.b.e.r0(), this.b.e.s0());
                    }
                    if (this.b.e.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                        FrsModelController frsModelController5 = this.b;
                        frsModelController5.u((MvcSocketResponsedMessage) frsModelController5.e.getResponsedMessage(), (MvcSocketMessage) this.b.e.r0(), this.b.e.s0());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, lva lvaVar) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, lvaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
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
        this.L = new i28();
        this.M = new h28();
        this.N = new a(this);
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        if (lvaVar != null) {
            this.a = frsFragment;
            this.f = lvaVar;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.e = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.a.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.e;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.e.q0(this);
                }
                this.d = this.e.t0();
            }
            G0(this.a);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public void e1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.J.put(i, Boolean.valueOf(z));
        }
    }

    public final void f0(int i, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048618, this, i, frsRequestData) != null) || frsRequestData == null) {
            return;
        }
        if (i != 3) {
            if (i == 4) {
                frsRequestData.j0(2);
                return;
            }
            return;
        }
        frsRequestData.j0(1);
    }

    public final int g0(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048620, this, i, frsRequestData)) == null) {
            if (i == 1 && this.a.B4() != null) {
                return this.a.B4().d(this.D, frsRequestData);
            }
            return i;
        }
        return invokeIL.intValue;
    }

    public au7 q0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048643, this, i, i2)) == null) {
            return this.w.get(r0(i, i2));
        }
        return (au7) invokeII.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, NetMessageListener netMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048645, this, i, netMessageListener) == null) {
            super.registerListener(i, netMessageListener);
        }
    }

    public boolean B0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.J.get(i, Boolean.FALSE).booleanValue();
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.ot7
    public void N(st7 st7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, st7Var) == null) {
            this.y = st7Var;
            this.x.e(this.N);
        }
    }

    public void X0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            bundle.putString("name", this.g);
            bundle.putString("from", this.j);
            bundle.putInt("flag", this.k);
        }
    }

    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            ru5.b(new d(this, str), null);
        }
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            ru5.b(new b(this, str), null);
        }
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            ru5.b(new c(this, str), null);
        }
    }

    public void f1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.G = z;
        }
    }

    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.K = z;
        }
    }

    public void h1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.E = i;
        }
    }

    public void j1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.n = str;
        }
    }

    @NonNull
    public final ErrorData k0(ResponsedMessage responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, responsedMessage)) == null) {
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
            return this.P;
        }
        return invokeV.longValue;
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.z.size() == 0) {
                this.z.add(new zs7());
            }
        }
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final int I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                int i = frsFragment.Q0;
                if (i == -1 || i == this.r) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.D == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e.i0();
        }
        return invokeV.booleanValue;
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            FrsRequestData frsRequestData = this.d;
            if (frsRequestData != null && frsRequestData.T() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.D != 7 && (this.e.u0() || this.F != 7)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.e.cancelLoadData();
        }
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            au7 au7Var = this.u;
            if (!(au7Var instanceof eu7) || ((eu7) au7Var).e != 0) {
                return true;
            }
            return ((eu7) au7Var).g;
        }
        return invokeV.booleanValue;
    }

    public int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ot7
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.x.d();
        }
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public final boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            this.O = System.currentTimeMillis();
            s88.a();
            return this.e.loadData();
        }
        return invokeV.booleanValue;
    }

    public wua l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.H;
        }
        return (wua) invokeV.objValue;
    }

    public FrsRequestData m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.d;
        }
        return (FrsRequestData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ot7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.x.b();
            this.x.clear();
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (1 == this.r) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public ArrayList<pi> p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public int t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return z68.d(this.D);
        }
        return invokeV.intValue;
    }

    public int u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public FrsViewData w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.b;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public long x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.R;
        }
        return invokeV.longValue;
    }

    public long y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.O;
        }
        return invokeV.longValue;
    }

    public long z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.Q;
        }
        return invokeV.longValue;
    }

    public void C0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
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
            F0();
            if (this.b == null) {
                this.b = new FrsViewData();
            }
            if (this.e == null || (frsRequestData = this.d) == null || frsRequestData.getHttpHeader() == null || this.d.getHttpHeader().isEmpty() || this.d.getHttpHeader().containsKey(null) || this.d.getHttpHeader().containsValue(null)) {
                D0(bundle);
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

    public final void D0(Bundle bundle) {
        int i;
        ArrayList<pi> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.d = frsRequestData;
            frsRequestData.setSortType(z68.d(this.D));
            if (this.D == 5) {
                this.d.d0(1);
            } else {
                this.d.d0(0);
            }
            this.d.O("forum_name", rd.getUrlEncode(this.g));
            this.d.O("client_type", "2");
            this.d.setPn(1);
            if (bundle != null) {
                this.d.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.d.b0(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.d.l0("2");
            this.d.m0("-2");
            this.d.f0(this.g);
            this.d.t0(1);
            this.d.X(0);
            this.d.s0(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            this.d.r0(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            this.d.q0(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst()));
            FrsRequestData frsRequestData2 = this.d;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            frsRequestData2.v0(i);
            this.d.p0(this.n);
            this.d.h0(null);
            this.d.u0(this.C);
            this.d.g0(JavaTypesHelper.toLong(ju5.a(), 0L));
            this.d.setStType(this.j);
            this.d.c0(1);
            this.d.setNeedCache(true);
            this.d.setUpdateType(3);
            FrsRequestData frsRequestData3 = this.d;
            FrsViewData frsViewData = this.b;
            if (frsViewData == null) {
                threadList = null;
            } else {
                threadList = frsViewData.getThreadList();
            }
            frsRequestData3.V(zga.e(threadList, true));
            z68.e(this.D, this.d);
            this.d.j0(1);
            if (ThreadData.isRecAppLoaded.get() && wha.m().b() != null) {
                int d2 = wha.m().b().d(this.g, false);
                int e2 = wha.m().b().e(this.g, false);
                if (this.d.T() == 1) {
                    d2++;
                } else if (this.d.T() == 2) {
                    e2++;
                }
                this.d.n0(d2);
                this.d.i0(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.d);
            this.e = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.a.getActivity()).getUniqueId());
            this.e.q0(this);
            this.e.loadData();
            s88.a();
        }
    }

    public final void F0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
                d1(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
                d1(6);
            } else {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                this.F = z68.h("1~" + str + this.g);
                d1(this.D);
            }
        }
    }

    public final void G0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, frsFragment) == null) {
            dt7 dt7Var = new dt7();
            this.x = dt7Var;
            dt7Var.a = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.x));
            this.x.e(this.N);
        }
    }

    public void P0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (this.r != 1) {
                Q0(4);
            } else if (this.e.i0()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(i);
                frsRequestData.setSortType(t0());
                d0(frsRequestData, 4, false);
            }
        }
    }

    public final void W0(eva evaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, evaVar) == null) {
            this.isCacheFirstLoad = false;
            this.b.receiveData(evaVar);
            b1(this.b);
            this.c = new ArrayList<>();
            if (this.b.getThreadList() != null) {
                this.c.addAll(this.b.getThreadList());
            }
            this.f.c(evaVar);
        }
    }

    public final void b1(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, frsViewData) == null) {
            if (m78.d0(frsViewData)) {
                this.l = "book_page";
            } else if (frsViewData.getIsBrandForum()) {
                this.l = "brand_page";
            } else if (m78.e0(frsViewData)) {
                this.l = "frs_page";
            } else {
                this.l = "normal_page";
            }
        }
    }

    public final void c1(eva evaVar) {
        FrsFragment frsFragment;
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, evaVar) != null) || evaVar == null || (frsFragment = this.a) == null || frsFragment.getActivity() == null || (intent = this.a.getActivity().getIntent()) == null) {
            return;
        }
        yma.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), evaVar.getForum().getId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void I(MvcHttpResponsedMessage<eva> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, eva> mvcHttpMessage, MvcNetMessage<FrsRequestData, eva> mvcNetMessage) {
        eva evaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.M.a(this);
        this.M.e(mvcHttpResponsedMessage);
        this.M.c(mvcHttpMessage);
        this.M.d(mvcNetMessage);
        this.M.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.M);
        this.H = wua.a(mvcHttpResponsedMessage);
        FrsRequestData frsRequestData = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            evaVar = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                frsRequestData = mvcHttpMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                frsRequestData = mvcNetMessage.getRequestData();
            }
        } else {
            evaVar = null;
        }
        if (frsRequestData != null && evaVar != null && Y0(frsRequestData, evaVar)) {
            return;
        }
        this.a.i(k0(mvcHttpResponsedMessage));
    }

    public void U0(MvcSocketResponsedMessage<eva, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, eva> mvcSocketMessage, MvcNetMessage<FrsRequestData, eva> mvcNetMessage) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (!this.B) {
                this.B = true;
                R0(1000, false, mvcSocketResponsedMessage);
            } else {
                T0(false, mvcSocketResponsedMessage);
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
                    str = frsRequestData.S();
                }
                objArr[1] = str;
                objArr[2] = PushConstants.SEQ_ID;
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                Logger.addLog("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void u(MvcSocketResponsedMessage<eva, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, eva> mvcSocketMessage, MvcNetMessage<FrsRequestData, eva> mvcNetMessage) {
        eva data;
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
        this.H = wua.a(mvcSocketResponsedMessage);
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
        if (frsRequestData != null && data != null && Y0(frsRequestData, data)) {
            return;
        }
        this.a.i(k0(mvcSocketResponsedMessage));
    }

    @Override // com.baidu.tieba.ot7
    public void J(int i, int i2, au7 au7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, au7Var) == null) {
            this.r = g0(i, null);
            if (au7Var == null && (au7Var = q0(i, i2)) == null) {
                if (i != 1 && BdUtilHelper.isNetOk() && this.y != null) {
                    eu7 eu7Var = new eu7();
                    eu7Var.g = false;
                    eu7Var.c = 1;
                    eu7Var.a = this.g;
                    eu7Var.i = false;
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        eu7Var.b = this.b.getForum().getId();
                    }
                    E0();
                    this.b.setThreadList(this.z);
                    this.y.a(i, i2, eu7Var, this.z);
                }
                au7Var = new au7();
                au7Var.c = -1;
            }
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                au7Var.b = this.b.getForum().getId();
            }
            au7Var.a = this.g;
            if (bt7.a().b(1) != null && this.r == 1) {
                this.d.W(i2);
            }
            this.s = i2;
            this.u = au7Var;
            m1(i, i2, au7Var);
            Q0(5);
        }
    }

    public final void R0(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 4).param(TiebaStatic.Params.OBJ_PARAM2, System.currentTimeMillis() - this.a.B));
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.a;
            this.A = currentTimeMillis - frsFragment.B;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.a;
            frsFragment.D = currentTimeMillis2 - frsFragment2.C;
            tp5 tp5Var = new tp5(i, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
            FrsFragment frsFragment3 = this.a;
            frsFragment3.F = 0L;
            frsFragment3.E = 0L;
            a78.g(this, frsFragment3.B);
            this.a.B = -1L;
            tp5Var.c();
        }
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.r != 1) {
                Q0(1);
                return true;
            } else if (this.e.i0()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(t0());
                d0(frsRequestData, 1, false);
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
    public final void Q0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.h = i;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        au7 au7Var = this.u;
                        if (au7Var != null) {
                            au7Var.c = -1;
                        }
                    }
                } else {
                    au7 au7Var2 = this.u;
                    if (au7Var2 != null) {
                        au7Var2.c--;
                    }
                }
                i2 = this.r;
                if (i2 != 1) {
                    if (this.t == this.s) {
                        ArrayList<pi> arrayList = new ArrayList<>();
                        ArrayList<pi> arrayList2 = this.c;
                        if (arrayList2 != null) {
                            arrayList.addAll(arrayList2);
                        }
                        this.b.setThreadList(arrayList);
                        st7 st7Var = this.y;
                        if (st7Var != null) {
                            st7Var.a(this.r, this.s, null, arrayList);
                        }
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                    }
                    this.t = this.s;
                    return;
                }
                ot7 c2 = this.x.c(i2);
                if (c2 != null) {
                    this.v = true;
                    c2.J(this.r, this.s, this.u);
                    return;
                }
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getThreadList() != null) {
                    this.b.getThreadList().clear();
                }
                this.y.a(this.r, this.s, null, null);
                return;
            }
            au7 au7Var3 = this.u;
            if (au7Var3 != null) {
                au7Var3.c++;
            }
            i2 = this.r;
            if (i2 != 1) {
            }
        }
    }

    public void S0(MvcHttpResponsedMessage<eva> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, eva> mvcHttpMessage, MvcNetMessage<FrsRequestData, eva> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                    str = frsRequestData.S();
                }
                objArr[1] = str;
                Logger.addLog("frs", j2, cmd, "http_resp", error, errorString, objArr);
            }
            if (!this.B) {
                this.B = true;
                R0(1000, true, mvcHttpResponsedMessage);
                return;
            }
            T0(true, mvcHttpResponsedMessage);
        }
    }

    public final void T0(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048598, this, z, responsedMessage) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FrsFragment frsFragment = this.a;
        this.A = currentTimeMillis - frsFragment.I;
        long currentTimeMillis2 = System.currentTimeMillis();
        FrsFragment frsFragment2 = this.a;
        frsFragment.D = currentTimeMillis2 - frsFragment2.C;
        tp5 tp5Var = new tp5(1000, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
        int i = this.h;
        if (i == 4) {
            tp5Var.B = this.A;
            tp5Var.e(true);
        } else if (i == 3) {
            tp5Var.C = this.A;
            tp5Var.e(false);
        }
    }

    public void h0(int i, boolean z) {
        ArrayList<pi> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.a.I = System.currentTimeMillis();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.b.getLikeFeedForumDataList().clear();
            }
            this.r = g0(this.r, this.d);
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 == null) {
                threadList = null;
            } else {
                threadList = frsViewData2.getThreadList();
            }
            frsRequestData.V(zga.e(threadList, true));
            if (this.r == 1) {
                e0(this.d, i, !z);
                return;
            }
            if (this.u == null) {
                au7 au7Var = new au7();
                this.u = au7Var;
                au7Var.c = 1;
                au7Var.a = this.g;
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.u.b = this.b.getForum().getId();
                }
            }
            Q0(i);
        }
    }

    public void Y(gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, gy4Var) == null) && gy4Var != null && !StringUtils.isNull(gy4Var.getId()) && !ListUtils.isEmpty(this.c)) {
            if (this.r == 1) {
                this.b.addMyNewThread(gy4Var);
            }
            int v0 = v0();
            Iterator<pi> it = this.c.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if ((next instanceof mz4) && gy4Var.getId().equals(((mz4) next).t.getId())) {
                    return;
                }
            }
            this.c.add(v0, gy4Var);
        }
    }

    public void d1(int i) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.D = i;
            if (i != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                z68.i("1~" + str + this.g, this.D);
            }
            if (7 == i) {
                txa.b();
            } else {
                txa.a();
            }
        }
    }

    public boolean Y0(FrsRequestData frsRequestData, eva evaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, frsRequestData, evaVar)) == null) {
            if (evaVar == null || evaVar.getForum() == null || (rd.isEmpty(evaVar.getForum().getName()) && 340001 != evaVar.mErrorNo)) {
                return false;
            }
            if (evaVar.getDataParseTime() > 0) {
                this.a.H = evaVar.getDataParseTime();
            }
            if (evaVar.getEntelechyTabInfo() != null && !ListUtils.isEmpty(evaVar.getEntelechyTabInfo().a)) {
                int intValue = evaVar.getEntelechyTabInfo().a.get(0).tab_type.intValue();
                AbsDataRecorder.Scene scene = AbsDataRecorder.Scene.FRS_HOT;
                this.a.M5(13);
                if (intValue == 14) {
                    scene = AbsDataRecorder.Scene.FRS_NEW;
                    this.a.M5(14);
                }
                if (n26.k().l(scene)) {
                    n26.k().g(scene).b();
                }
                if (g36.i().o(scene)) {
                    g36.i().g(scene).b();
                }
            }
            d1(z68.f(evaVar.getSortType()));
            e1(z68.f(evaVar.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.r = evaVar.getFrsDefaultTabId();
            }
            this.b.receiveData(evaVar);
            b1(this.b);
            this.c = new ArrayList<>();
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.i = frsRequestData.getPn();
                String S = this.d.S();
                this.g = S;
                this.a.O5(S);
                this.a.setFrom(this.j);
                this.a.Y5(this.i);
                this.a.N5(this.k);
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
            if (q38.b(this.d)) {
                a1();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.b5();
                }
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.b.getForum()));
            }
            this.isNetFirstLoad = false;
            if (evaVar.getForum() != null && !TextUtils.isEmpty(evaVar.getForum().getName()) && frsRequestData != null && wha.m().b() != null) {
                wha.m().b().g(evaVar.getForum().getName(), frsRequestData.T(), false);
            }
            if (this.a != null && !StringUtils.isNull(evaVar.getUserData().getAppealThreadPopover())) {
                this.a.h6(TbadkCoreApplication.getCurrentAccount(), evaVar.getForum().getId(), evaVar.getUserData().getAppealThreadPopover());
            }
            c1(evaVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void Z(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048605, this, str, frsRequestData) != null) || !ThreadData.isRecAppLoaded.get() || wha.m().b() == null) {
            return;
        }
        int d2 = wha.m().b().d(str, false);
        int e2 = wha.m().b().e(str, false);
        if (frsRequestData.T() == 1) {
            d2++;
        } else if (frsRequestData.T() == 2) {
            e2++;
        }
        frsRequestData.n0(d2);
        frsRequestData.i0(e2);
    }

    public void Z0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == null) {
            return;
        }
        this.a.I = System.currentTimeMillis();
        FrsViewData frsViewData = this.b;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.b.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(1);
        int g0 = g0(this.r, frsRequestData);
        this.r = g0;
        if (g0 == 1) {
            if (this.e.i0()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            d0(frsRequestData, i, !z);
            return;
        }
        if (this.u == null) {
            au7 au7Var = new au7();
            this.u = au7Var;
            au7Var.c = 1;
            au7Var.a = this.g;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.u.b = this.b.getForum().getId();
            }
        }
        Q0(i);
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(JavaTypesHelper.toLong(this.b.getForum().getId(), 0L));
            }
            this.a.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            ps7 ps7Var = new ps7();
            if (this.t == 0) {
                ps7Var.b(this.D);
            }
            if (this.b.getThreadList() != null) {
                this.b.getThreadList().clear();
                this.b.getThreadList().add(ps7Var);
            }
            ArrayList<pi> arrayList = this.c;
            if (arrayList != null) {
                arrayList.clear();
                this.c.add(ps7Var);
            }
        }
    }

    public void l1() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048635, this) != null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    public int v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            ArrayList<pi> arrayList = this.c;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<pi> it = this.c.iterator();
                while (it.hasNext()) {
                    pi next = it.next();
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

    public final void d0(FrsRequestData frsRequestData, int i, boolean z) {
        String str;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.H5(z);
            this.f.a(i);
            this.e.v0(frsRequestData);
            if (this.a.j5()) {
                str = "1";
            } else {
                str = "2";
            }
            frsRequestData.l0(str);
            if (this.G) {
                frsRequestData.m0(String.valueOf(z68.d(this.E)));
            } else {
                frsRequestData.m0("-2");
            }
            this.G = false;
            frsRequestData.f0(this.g);
            frsRequestData.t0(1);
            frsRequestData.X(0);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            float equipmentDensity = BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            frsRequestData.s0(equipmentWidth);
            frsRequestData.r0(equipmentHeight);
            frsRequestData.q0(equipmentDensity);
            frsRequestData.v0(i2);
            frsRequestData.p0(this.n);
            frsRequestData.h0(this.p);
            frsRequestData.u0(this.C);
            frsRequestData.g0(JavaTypesHelper.toLong(ju5.a(), 0L));
            String str2 = this.o;
            ArrayList<pi> arrayList = null;
            if (str2 != null) {
                frsRequestData.setStType(str2);
                if ("sidebar".equalsIgnoreCase(this.o)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.c0(I0());
            if (FrsFragment.y2 != 0) {
                frsRequestData.Y((int) FrsFragment.y2);
            }
            if (FrsFragment.z2 != 0) {
                frsRequestData.Z((int) FrsFragment.z2);
            }
            if (FrsFragment.A2 != 0) {
                frsRequestData.k0(FrsFragment.A2);
            }
            if (frsRequestData.getPn() != 1 && this.h != 3) {
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    arrayList = frsViewData.getThreadList();
                }
                frsRequestData.V(zga.e(arrayList, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    arrayList = frsViewData2.getThreadList();
                }
                frsRequestData.V(zga.e(arrayList, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.h);
            frsRequestData.b0(this.q);
            z68.e(this.D, frsRequestData);
            int d2 = z68.d(this.F);
            f0(i, frsRequestData);
            Z(this.g, frsRequestData);
            if (!B0(this.F) && !this.a.i && !this.K) {
                vua i3 = vua.i();
                String g = i3.g("1~" + this.g, d2, frsRequestData.R(), this.d.P());
                this.I = g;
                new e(this, true, g).execute(new Object[0]);
            }
            k1();
            this.K = false;
        }
    }

    public final void e0(FrsRequestData frsRequestData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.H5(z);
            this.f.a(i);
            if (this.e.u0() && (this.e.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                I((MvcHttpResponsedMessage) this.e.getResponsedMessage(), (MvcHttpMessage) this.e.r0(), this.e.s0());
            } else if (this.e.u0() && (this.e.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                u((MvcSocketResponsedMessage) this.e.getResponsedMessage(), (MvcSocketMessage) this.e.r0(), this.e.s0());
            } else {
                int d2 = z68.d(this.F);
                if (!B0(this.F) && !this.a.i && !this.K) {
                    vua i2 = vua.i();
                    String g = i2.g("1~" + this.g, d2, frsRequestData.R(), this.d.P());
                    this.I = g;
                    new e(this, true, g).execute(new Object[0]);
                }
                this.K = false;
            }
            this.e.q0(this);
        }
    }

    public final void m1(int i, int i2, au7 au7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048638, this, i, i2, au7Var) == null) {
            this.w.put(r0(i, i2), au7Var);
        }
    }
}

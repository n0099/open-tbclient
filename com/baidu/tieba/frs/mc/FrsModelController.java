package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.o0.c1.h0;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.o0.r.r.a2;
import c.a.o0.r.r.w0;
import c.a.o0.r0.h;
import c.a.p0.a4.f;
import c.a.p0.a4.n;
import c.a.p0.a4.u;
import c.a.p0.f1.b0;
import c.a.p0.f1.c1;
import c.a.p0.f1.d0;
import c.a.p0.f1.f0;
import c.a.p0.f1.h2.m;
import c.a.p0.f1.p0;
import c.a.p0.f1.r2.p;
import c.a.p0.f1.r2.q;
import c.a.p0.f1.s;
import c.a.p0.f1.t0;
import c.a.p0.f1.z0;
import c.a.p0.l3.z;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements p0, NetModel.k<FrsRequestData, n> {
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
    public f H;
    public String I;
    public final SparseArray<Boolean> J;
    public boolean K;
    public c.a.p0.f1.h2.n L;
    public m M;
    public t0 N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public final FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public FrsViewData f32779b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c.a.d.o.e.n> f32780c;

    /* renamed from: d  reason: collision with root package name */
    public FrsRequestData f32781d;

    /* renamed from: e  reason: collision with root package name */
    public FrsNetModel f32782e;

    /* renamed from: f  reason: collision with root package name */
    public final u f32783f;

    /* renamed from: g  reason: collision with root package name */
    public String f32784g;

    /* renamed from: h  reason: collision with root package name */
    public int f32785h;
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
    public z0 u;
    public boolean v;
    public SparseArray<z0> w;
    public f0 x;
    public t0 y;
    public ArrayList<c.a.d.o.e.n> z;

    /* loaded from: classes5.dex */
    public class a implements t0 {
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

        @Override // c.a.p0.f1.t0
        public void a(int i, int i2, c1 c1Var, ArrayList<c.a.d.o.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), c1Var, arrayList}) == null) {
                this.a.v = false;
                if (i != this.a.r || this.a.y == null) {
                    return;
                }
                this.a.u = c1Var;
                this.a.V0(i, i2, c1Var);
                ArrayList<c.a.d.o.e.n> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                this.a.f32779b.setThreadList(arrayList2);
                this.a.y.a(i, i2, c1Var, arrayList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends k0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f32786b;

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
            this.f32786b = frsModelController;
            this.a = str;
        }

        @Override // c.a.o0.c1.k0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.a4.e.i().c(this.f32786b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends k0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f32787b;

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
            this.f32787b = frsModelController;
            this.a = str;
        }

        @Override // c.a.o0.c1.k0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.a4.e.i().d(this.f32787b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends k0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f32788b;

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
            this.f32788b = frsModelController;
            this.a = str;
        }

        @Override // c.a.o0.c1.k0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.a4.e.i().b(this.f32788b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends BdAsyncTask<Object, n, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public FrsModelController f32789b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f32790c;

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
            this.f32789b = frsModelController;
            this.f32790c = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            int e2;
            CustomResponsedMessage runTask;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                if (this.f32790c && c.a.p0.a4.e.i().e(this.a)) {
                    if (!c.a.p0.a4.e.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        c.a.p0.a4.e.i().j().getForum().getSignData().is_signed = 0;
                    }
                    n j = c.a.p0.a4.e.i().j();
                    j.setIsShowRedTip(false);
                    if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (e2 = c.a.d.f.m.b.e(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e2))) != null) {
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
        public void onProgressUpdate(n... nVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVarArr) == null) {
                super.onProgressUpdate(nVarArr);
                FrsModelController frsModelController = this.f32789b;
                if (frsModelController != null && nVarArr != null) {
                    frsModelController.F0(nVarArr.length > 0 ? nVarArr[0] : null);
                    FrsModelController frsModelController2 = this.f32789b;
                    frsModelController2.N0(frsModelController2.D, true);
                    return;
                }
                FrsModelController frsModelController3 = this.f32789b;
                if (frsModelController3 == null || frsModelController3.f32782e.e0()) {
                    return;
                }
                if (this.f32789b.f32782e.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    FrsModelController frsModelController4 = this.f32789b;
                    frsModelController4.r((MvcHttpResponsedMessage) frsModelController4.f32782e.getResponsedMessage(), (MvcHttpMessage) this.f32789b.f32782e.b0(), this.f32789b.f32782e.c0());
                }
                if (this.f32789b.f32782e.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    FrsModelController frsModelController5 = this.f32789b;
                    frsModelController5.m((MvcSocketResponsedMessage) frsModelController5.f32782e.getResponsedMessage(), (MvcSocketMessage) this.f32789b.f32782e.b0(), this.f32789b.f32782e.c0());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, u uVar) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, uVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32784g = null;
        this.f32785h = 3;
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
        this.L = new c.a.p0.f1.h2.n();
        this.M = new m();
        this.N = new a(this);
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        if (uVar != null) {
            this.a = frsFragment;
            this.f32783f = uVar;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.f32782e = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.a.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.f32782e;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.f32782e.a0(this);
                }
                this.f32781d = this.f32782e.d0();
            }
            p0(this.a);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public final void A0(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.a;
            this.A = currentTimeMillis - frsFragment.B;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.a;
            frsFragment.D = currentTimeMillis2 - frsFragment2.C;
            h hVar = new h(i, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
            FrsFragment frsFragment3 = this.a;
            frsFragment3.F = 0L;
            frsFragment3.E = 0L;
            q.f(this, frsFragment3.B);
            this.a.B = -1L;
            hVar.c();
        }
    }

    public void B0(MvcHttpResponsedMessage<n> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, n> mvcHttpMessage, MvcNetMessage<FrsRequestData, n> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                objArr[1] = frsRequestData != null ? frsRequestData.B() : null;
                c.a.o0.r.d0.a.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
            }
            if (!this.B) {
                this.B = true;
                A0(1000, true, mvcHttpResponsedMessage);
                return;
            }
            C0(true, mvcHttpResponsedMessage);
        }
    }

    public final void C0(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.a;
            this.A = currentTimeMillis - frsFragment.I;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.a;
            frsFragment.D = currentTimeMillis2 - frsFragment2.C;
            h hVar = new h(1000, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
            int i = this.f32785h;
            if (i == 4) {
                hVar.B = this.A;
                hVar.e(true);
            } else if (i == 3) {
                hVar.C = this.A;
                hVar.e(false);
            }
        }
    }

    public void D0(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, n> mvcSocketMessage, MvcNetMessage<FrsRequestData, n> mvcNetMessage) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (!this.B) {
                this.B = true;
                A0(1000, false, mvcSocketResponsedMessage);
            } else {
                C0(false, mvcSocketResponsedMessage);
            }
            long j = 0;
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
                objArr[1] = frsRequestData != null ? frsRequestData.B() : null;
                objArr[2] = "seq_id";
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                c.a.o0.r.d0.a.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.f32782e.cancelLoadData();
        }
    }

    public final void F0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nVar) == null) {
            this.isCacheFirstLoad = false;
            this.f32779b.receiveData(nVar);
            K0(this.f32779b);
            this.f32780c = new ArrayList<>();
            if (this.f32779b.getThreadList() != null) {
                this.f32780c.addAll(this.f32779b.getThreadList());
            }
            this.f32783f.c(nVar);
        }
    }

    public void G0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            bundle.putString("name", this.f32784g);
            bundle.putString("from", this.j);
            bundle.putInt("flag", this.k);
        }
    }

    public boolean H0(FrsRequestData frsRequestData, n nVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, frsRequestData, nVar)) == null) {
            if (nVar == null || nVar.getForum() == null || (c.a.d.f.p.m.isEmpty(nVar.getForum().getName()) && 340001 != nVar.mErrorNo)) {
                return false;
            }
            if (nVar.getDataParseTime() > 0) {
                this.a.H = nVar.getDataParseTime();
            }
            M0(p.f(nVar.getSortType()));
            N0(p.f(nVar.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.r = nVar.getFrsDefaultTabId();
            }
            this.f32779b.receiveData(nVar);
            K0(this.f32779b);
            this.f32780c = new ArrayList<>();
            if (frsRequestData != null) {
                this.f32781d = frsRequestData;
                this.i = frsRequestData.getPn();
                String B = this.f32781d.B();
                this.f32784g = B;
                this.a.u3(B);
                this.a.setFrom(this.j);
                this.a.C3(this.i);
                this.a.t3(this.k);
            }
            if (this.f32779b.getThreadList() != null) {
                this.f32780c.addAll(this.f32779b.getThreadList());
            }
            if (this.r != 1 && this.isNetFirstLoad) {
                this.f32783f.d(7, false, this.H);
            } else {
                this.f32783f.d(this.f32785h, false, this.H);
            }
            this.o = null;
            if (c.a.p0.f1.m2.b.b(this.f32781d)) {
                J0();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.P2();
                }
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.f32779b.getForum()));
            }
            this.isNetFirstLoad = false;
            if (nVar.getForum() != null && !TextUtils.isEmpty(nVar.getForum().getName()) && frsRequestData != null && z.q().b() != null) {
                z.q().b().g(nVar.getForum().getName(), frsRequestData.C(), false);
            }
            if (!StringUtils.isNull(nVar.getUserData().getAppealThreadPopover())) {
                this.a.Q3(TbadkCoreApplication.getCurrentAccount(), nVar.getForum().getId(), nVar.getUserData().getAppealThreadPopover());
            }
            L0(nVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void I(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, w0Var) == null) || w0Var == null || StringUtils.isNull(w0Var.getId()) || ListUtils.isEmpty(this.f32780c)) {
            return;
        }
        if (this.r == 1) {
            this.f32779b.addMyNewThread(w0Var);
        }
        int e0 = e0();
        Iterator<c.a.d.o.e.n> it = this.f32780c.iterator();
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            if ((next instanceof a2) && w0Var.getId().equals(((a2) next).s.getId())) {
                return;
            }
        }
        this.f32780c.add(e0, w0Var);
    }

    public void I0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || this.f32781d == null) {
            return;
        }
        this.a.I = System.currentTimeMillis();
        FrsViewData frsViewData = this.f32779b;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.f32779b.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f32781d), FrsRequestData.class);
        frsRequestData.setPn(1);
        int Q = Q(this.r, frsRequestData);
        this.r = Q;
        if (Q == 1) {
            if (this.f32782e.S()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            N(frsRequestData, i, !z);
            return;
        }
        if (this.u == null) {
            z0 z0Var = new z0();
            this.u = z0Var;
            z0Var.f14893c = 1;
            z0Var.a = this.f32784g;
            FrsViewData frsViewData2 = this.f32779b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.u.f14892b = this.f32779b.getForum().getId();
            }
        }
        z0(i);
    }

    public final void J(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, frsRequestData) == null) && ThreadData.isRecAppLoaded.get() && z.q().b() != null) {
            int d2 = z.q().b().d(str, false);
            int e2 = z.q().b().e(str, false);
            if (frsRequestData.C() == 1) {
                d2++;
            } else if (frsRequestData.C() == 2) {
                e2++;
            }
            frsRequestData.W(d2);
            frsRequestData.R(e2);
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.f32779b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(c.a.d.f.m.b.g(this.f32779b.getForum().getId(), 0L));
            }
            this.a.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            n0.b(new d(this, str), null);
        }
    }

    public final void K0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) {
            if (c.a.p0.f1.s2.h.E(frsViewData)) {
                this.l = "book_page";
            } else if (frsViewData.getIsBrandForum()) {
                this.l = "brand_page";
            } else if (c.a.p0.f1.s2.h.F(frsViewData)) {
                this.l = "frs_page";
            } else {
                this.l = "normal_page";
            }
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            n0.b(new b(this, str), null);
        }
    }

    public final void L0(n nVar) {
        FrsFragment frsFragment;
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, nVar) == null) || nVar == null || (frsFragment = this.a) == null || frsFragment.getActivity() == null || (intent = this.a.getActivity().getIntent()) == null) {
            return;
        }
        c.a.p0.o3.a.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), nVar.getForum().getId());
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            n0.b(new c(this, str), null);
        }
    }

    public void M0(int i) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.D = i;
            if (i != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                p.i("1~" + str + this.f32784g, this.D);
            }
            if (7 == i) {
                c.a.p0.a4.q0.e.b();
            } else {
                c.a.p0.a4.q0.e.a();
            }
        }
    }

    public final void N(FrsRequestData frsRequestData, int i, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.f32785h = i;
            this.a.q3(z);
            this.f32783f.a(i);
            this.f32782e.f0(frsRequestData);
            frsRequestData.U(this.a.V2() ? "1" : "2");
            if (this.G) {
                frsRequestData.V(String.valueOf(p.d(this.E)));
            } else {
                frsRequestData.V("-2");
            }
            this.G = false;
            frsRequestData.O(this.f32784g);
            frsRequestData.b0(1);
            frsRequestData.G(0);
            int k = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
            int i2 = c.a.d.f.p.n.i(TbadkCoreApplication.getInst());
            float h2 = c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            frsRequestData.a0(k);
            frsRequestData.Z(i2);
            frsRequestData.Y(h2);
            frsRequestData.d0(i3);
            frsRequestData.X(this.n);
            frsRequestData.Q(this.p);
            frsRequestData.c0(this.C);
            frsRequestData.P(c.a.d.f.m.b.g(h0.a(), 0L));
            String str = this.o;
            if (str != null) {
                frsRequestData.setStType(str);
                if ("sidebar".equalsIgnoreCase(this.o)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.L(r0());
            if (FrsFragment.c2 != 0) {
                frsRequestData.H((int) FrsFragment.c2);
            }
            if (FrsFragment.d2 != 0) {
                frsRequestData.I((int) FrsFragment.d2);
            }
            if (FrsFragment.e2 != 0) {
                frsRequestData.T(FrsFragment.e2);
            }
            if (frsRequestData.getPn() != 1 && this.f32785h != 3) {
                FrsViewData frsViewData = this.f32779b;
                frsRequestData.E(c.a.p0.l3.a.e(frsViewData != null ? frsViewData.getThreadList() : null, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.f32779b;
                frsRequestData.E(c.a.p0.l3.a.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.f32785h);
            frsRequestData.K(this.q);
            p.e(this.D, frsRequestData);
            int d2 = p.d(this.F);
            P(i, frsRequestData);
            J(this.f32784g, frsRequestData);
            if (!k0(this.F) && !this.a.i && !this.K) {
                c.a.p0.a4.e i4 = c.a.p0.a4.e.i();
                String g2 = i4.g("1~" + this.f32784g, d2, frsRequestData.A(), this.f32781d.z());
                this.I = g2;
                new e(this, true, g2).execute(new Object[0]);
            }
            T0();
            this.K = false;
        }
    }

    public void N0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.J.put(i, Boolean.valueOf(z));
        }
    }

    public final void O(FrsRequestData frsRequestData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.f32785h = i;
            this.a.q3(z);
            this.f32783f.a(i);
            if (this.f32782e.e0() && (this.f32782e.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                r((MvcHttpResponsedMessage) this.f32782e.getResponsedMessage(), (MvcHttpMessage) this.f32782e.b0(), this.f32782e.c0());
            } else if (this.f32782e.e0() && (this.f32782e.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                m((MvcSocketResponsedMessage) this.f32782e.getResponsedMessage(), (MvcSocketMessage) this.f32782e.b0(), this.f32782e.c0());
            } else {
                int d2 = p.d(this.F);
                if (!k0(this.F) && !this.a.i && !this.K) {
                    c.a.p0.a4.e i2 = c.a.p0.a4.e.i();
                    String g2 = i2.g("1~" + this.f32784g, d2, frsRequestData.A(), this.f32781d.z());
                    this.I = g2;
                    new e(this, true, g2).execute(new Object[0]);
                }
                this.K = false;
            }
            this.f32782e.a0(this);
        }
    }

    public void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.G = z;
        }
    }

    public final void P(int i, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048598, this, i, frsRequestData) == null) || frsRequestData == null) {
            return;
        }
        if (i == 3) {
            frsRequestData.S(1);
        } else if (i != 4) {
        } else {
            frsRequestData.S(2);
        }
    }

    public void P0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.K = z;
        }
    }

    public final int Q(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i, frsRequestData)) == null) ? (i != 1 || this.a.v2() == null) ? i : this.a.v2().d(this.D, frsRequestData) : invokeIL.intValue;
    }

    public void Q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.E = i;
        }
    }

    public void R(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.a.I = System.currentTimeMillis();
            FrsViewData frsViewData = this.f32779b;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.f32779b.getLikeFeedForumDataList().clear();
            }
            this.r = Q(this.r, this.f32781d);
            FrsRequestData frsRequestData = this.f32781d;
            FrsViewData frsViewData2 = this.f32779b;
            frsRequestData.E(c.a.p0.l3.a.e(frsViewData2 == null ? null : frsViewData2.getThreadList(), true));
            if (this.r == 1) {
                O(this.f32781d, i, !z);
                return;
            }
            if (this.u == null) {
                z0 z0Var = new z0();
                this.u = z0Var;
                z0Var.f14893c = 1;
                z0Var.a = this.f32784g;
                FrsViewData frsViewData3 = this.f32779b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.u.f14892b = this.f32779b.getForum().getId();
                }
            }
            z0(i);
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            s sVar = new s();
            if (this.t == 0) {
                sVar.b(this.D);
            }
            if (this.f32779b.getThreadList() != null) {
                this.f32779b.getThreadList().clear();
                this.f32779b.getThreadList().add(sVar);
            }
            ArrayList<c.a.d.o.e.n> arrayList = this.f32780c;
            if (arrayList != null) {
                arrayList.clear();
                this.f32780c.add(sVar);
            }
        }
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.F : invokeV.intValue;
    }

    public void S0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.n = str;
        }
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.D : invokeV.intValue;
    }

    public final boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            this.O = System.currentTimeMillis();
            c.a.p0.g1.d.a();
            return this.f32782e.loadData();
        }
        return invokeV.booleanValue;
    }

    public f U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.H : (f) invokeV.objValue;
    }

    public void U0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (frsViewData = this.f32779b) == null || frsViewData.getForum() == null || this.f32779b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f32779b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    public FrsRequestData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f32781d : (FrsRequestData) invokeV.objValue;
    }

    public final void V0(int i, int i2, z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i, i2, z0Var) == null) {
            this.w.put(a0(i, i2), z0Var);
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? 1 == this.r : invokeV.booleanValue;
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.t : invokeV.intValue;
    }

    public ArrayList<c.a.d.o.e.n> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f32780c : (ArrayList) invokeV.objValue;
    }

    public z0 Z(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048615, this, i, i2)) == null) ? this.w.get(a0(i, i2)) : (z0) invokeII.objValue;
    }

    public final int a0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048616, this, i, i2)) == null) ? (i * 10) + i2 : invokeII.intValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? p.d(this.D) : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.r : invokeV.intValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            ArrayList<c.a.d.o.e.n> arrayList = this.f32780c;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<c.a.d.o.e.n> it = this.f32780c.iterator();
                while (it.hasNext()) {
                    c.a.d.o.e.n next = it.next();
                    if (next instanceof a2) {
                        if (((a2) next).s.getIs_top() == 0) {
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

    public FrsViewData f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f32779b : (FrsViewData) invokeV.objValue;
    }

    public long g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.R : invokeV.longValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.i : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f32785h : invokeV.intValue;
    }

    public long h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.O : invokeV.longValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            z0 z0Var = this.u;
            if ((z0Var instanceof c1) && ((c1) z0Var).f13864e == 0) {
                return ((c1) z0Var).f13866g;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f1.p0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.x.b();
            this.x.clear();
        }
    }

    public long i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.Q : invokeV.longValue;
    }

    @Override // c.a.p0.f1.p0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.x.d();
        }
    }

    public long j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.P : invokeV.longValue;
    }

    public boolean k0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i)) == null) ? this.J.get(i, Boolean.FALSE).booleanValue() : invokeI.booleanValue;
    }

    public void l0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bundle) == null) {
            if (bundle != null) {
                this.f32784g = bundle.getString("name");
                this.j = bundle.getString("from");
                this.k = bundle.getInt("flag", 0);
                this.C = bundle.getString("yuelaou_locate");
                this.m = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
                this.a.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            }
            if (TextUtils.isEmpty(this.f32784g)) {
                this.f32784g = "";
            }
            if (TextUtils.isEmpty(this.j)) {
                this.j = "";
            }
            if (TextUtils.isEmpty(this.C)) {
                this.C = "";
            }
            this.o = this.j;
            o0();
            if (this.f32779b == null) {
                this.f32779b = new FrsViewData();
            }
            if (this.f32782e == null || (frsRequestData = this.f32781d) == null || frsRequestData.w() == null || this.f32781d.w().isEmpty() || this.f32781d.w().containsKey(null) || this.f32781d.w().containsValue(null)) {
                m0(bundle);
            }
            String str = this.f32784g;
            if (str == null || str.length() <= 0) {
                return;
            }
            String str2 = this.j;
            if (str2 == null || str2.length() <= 0) {
                this.j = "tb_forumlist";
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, n> mvcSocketMessage, MvcNetMessage<FrsRequestData, n> mvcNetMessage) {
        n data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048635, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.L.a(this);
        this.L.e(mvcSocketResponsedMessage);
        this.L.c(mvcSocketMessage);
        this.L.d(mvcNetMessage);
        this.L.b(this.f32783f);
        Looper.myQueue().addIdleHandler(this.L);
        f fVar = new f();
        fVar.a = l.z() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        fVar.f12188b = !mvcSocketResponsedMessage.hasError();
        fVar.f12189c = mvcSocketResponsedMessage.getError();
        fVar.f12190d = mvcSocketResponsedMessage.getErrorString();
        fVar.f12191e = mvcSocketResponsedMessage.getDownSize();
        this.H = fVar;
        if (!mvcSocketResponsedMessage.hasError() || 340001 == mvcSocketResponsedMessage.getError()) {
            data = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            data = null;
        }
        if (r1 == null || data == null || !H0(r1, data)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.a.onServerError(errorData);
        }
    }

    public final void m0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.f32781d = frsRequestData;
            frsRequestData.setSortType(p.d(this.D));
            if (this.D == 5) {
                this.f32781d.M(1);
            } else {
                this.f32781d.M(0);
            }
            this.f32781d.y("forum_name", c.a.d.f.p.m.getUrlEncode(this.f32784g));
            this.f32781d.y("client_type", "2");
            this.f32781d.setPn(1);
            if (bundle != null) {
                this.f32781d.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.f32781d.K(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.f32781d.U("2");
            this.f32781d.V("-2");
            this.f32781d.O(this.f32784g);
            this.f32781d.b0(1);
            this.f32781d.G(0);
            this.f32781d.a0(c.a.d.f.p.n.k(TbadkCoreApplication.getInst()));
            this.f32781d.Z(c.a.d.f.p.n.i(TbadkCoreApplication.getInst()));
            this.f32781d.Y(c.a.d.f.p.n.h(TbadkCoreApplication.getInst()));
            this.f32781d.d0(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
            this.f32781d.X(this.n);
            this.f32781d.Q(null);
            this.f32781d.c0(this.C);
            this.f32781d.P(c.a.d.f.m.b.g(h0.a(), 0L));
            this.f32781d.setStType(this.j);
            this.f32781d.L(1);
            this.f32781d.setNeedCache(true);
            this.f32781d.setUpdateType(3);
            FrsRequestData frsRequestData2 = this.f32781d;
            FrsViewData frsViewData = this.f32779b;
            frsRequestData2.E(c.a.p0.l3.a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            p.e(this.D, this.f32781d);
            this.f32781d.S(1);
            if (ThreadData.isRecAppLoaded.get() && z.q().b() != null) {
                int d2 = z.q().b().d(this.f32784g, false);
                int e2 = z.q().b().e(this.f32784g, false);
                if (this.f32781d.C() == 1) {
                    d2++;
                } else if (this.f32781d.C() == 2) {
                    e2++;
                }
                this.f32781d.W(d2);
                this.f32781d.R(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.f32781d);
            this.f32782e = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.a.getActivity()).getUniqueId());
            this.f32782e.a0(this);
            this.f32782e.loadData();
            c.a.p0.g1.d.a();
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.z.size() == 0) {
                this.z.add(new b0());
            }
        }
    }

    public final void o0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
                M0(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
                M0(6);
            } else {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                this.F = p.h("1~" + str + this.f32784g);
                M0(this.D);
            }
        }
    }

    public final void p0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, frsFragment) == null) {
            f0 f0Var = new f0();
            this.x = f0Var;
            f0Var.a = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.x));
            this.x.e(this.N);
        }
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.m : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage<n> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, n> mvcHttpMessage, MvcNetMessage<FrsRequestData, n> mvcNetMessage) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048641, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.M.a(this);
        this.M.e(mvcHttpResponsedMessage);
        this.M.c(mvcHttpMessage);
        this.M.d(mvcNetMessage);
        this.M.b(this.f32783f);
        Looper.myQueue().addIdleHandler(this.M);
        f fVar = new f();
        fVar.a = l.z() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        fVar.f12188b = !mvcHttpResponsedMessage.hasError();
        fVar.f12189c = mvcHttpResponsedMessage.getError();
        fVar.f12190d = mvcHttpResponsedMessage.getErrorString();
        fVar.f12191e = mvcHttpResponsedMessage.getDownSize();
        this.H = fVar;
        if (mvcHttpResponsedMessage.hasError()) {
            nVar = null;
        } else {
            nVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || nVar == null || !H0(r1, nVar)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.a.onServerError(errorData);
        }
    }

    public final int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                int i = frsFragment.M0;
                return (i == -1 || i == this.r) ? 1 : 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, c.a.d.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i, aVar) == null) {
            super.registerListener(i, aVar);
        }
    }

    @Override // c.a.p0.f1.p0
    public void s(int i, int i2, z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048645, this, i, i2, z0Var) == null) {
            this.r = Q(i, null);
            if (z0Var == null && (z0Var = Z(i, i2)) == null) {
                if (i != 1 && c.a.d.f.p.n.C() && this.y != null) {
                    c1 c1Var = new c1();
                    c1Var.f13866g = false;
                    c1Var.f14893c = 1;
                    c1Var.a = this.f32784g;
                    c1Var.i = false;
                    FrsViewData frsViewData = this.f32779b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        c1Var.f14892b = this.f32779b.getForum().getId();
                    }
                    n0();
                    this.f32779b.setThreadList(this.z);
                    this.y.a(i, i2, c1Var, this.z);
                }
                z0Var = new z0();
                z0Var.f14893c = -1;
            }
            FrsViewData frsViewData2 = this.f32779b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                z0Var.f14892b = this.f32779b.getForum().getId();
            }
            z0Var.a = this.f32784g;
            if (d0.a().b(1) != null && this.r == 1) {
                this.f32781d.F(i2);
            }
            this.s = i2;
            this.u = z0Var;
            V0(i, i2, z0Var);
            z0(5);
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.D == 5 : invokeV.booleanValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.f32782e.S() : invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            FrsRequestData frsRequestData = this.f32781d;
            return frsRequestData != null && frsRequestData.C() == 1;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f1.p0
    public void v(t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, t0Var) == null) {
            this.y = t0Var;
            this.x.e(this.N);
        }
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.D == 7 || (!this.f32782e.e0() && this.F == 7) : invokeV.booleanValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            if (this.r != 1) {
                z0(1);
                return true;
            } else if (this.f32782e.S()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f32781d), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(c0());
                N(frsRequestData, 1, false);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void y0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i) == null) {
            if (this.r != 1) {
                z0(4);
            } else if (this.f32782e.S()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f32781d), FrsRequestData.class);
                frsRequestData.setPn(i);
                frsRequestData.setSortType(c0());
                N(frsRequestData, 4, false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0010, code lost:
        if (r5 != 4) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void z0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048654, this, i) != null) {
            return;
        }
        this.f32785h = i;
        if (i != 1) {
            if (i == 2) {
                z0 z0Var = this.u;
                if (z0Var != null) {
                    z0Var.f14893c--;
                }
            } else if (i == 3) {
                z0 z0Var2 = this.u;
                if (z0Var2 != null) {
                    z0Var2.f14893c = -1;
                }
            }
            i2 = this.r;
            if (i2 != 1) {
                if (this.t == this.s) {
                    ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>();
                    ArrayList<c.a.d.o.e.n> arrayList2 = this.f32780c;
                    if (arrayList2 != null) {
                        arrayList.addAll(arrayList2);
                    }
                    this.f32779b.setThreadList(arrayList);
                    t0 t0Var = this.y;
                    if (t0Var != null) {
                        t0Var.a(this.r, this.s, null, arrayList);
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                }
                this.t = this.s;
                return;
            }
            p0 c2 = this.x.c(i2);
            if (c2 != null) {
                this.v = true;
                c2.s(this.r, this.s, this.u);
                return;
            }
            FrsViewData frsViewData = this.f32779b;
            if (frsViewData != null && frsViewData.getThreadList() != null) {
                this.f32779b.getThreadList().clear();
            }
            this.y.a(this.r, this.s, null, null);
            return;
        }
        z0 z0Var3 = this.u;
        if (z0Var3 != null) {
            z0Var3.f14893c++;
        }
        i2 = this.r;
        if (i2 != 1) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, messageListener) == null) {
            super.registerListener(messageListener);
        }
    }
}

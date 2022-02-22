package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.t0.d1.i0;
import c.a.t0.d1.l0;
import c.a.t0.d1.o0;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.y0;
import c.a.t0.s0.h;
import c.a.t0.s0.k;
import c.a.u0.e1.b0;
import c.a.u0.e1.b3.p;
import c.a.u0.e1.b3.q;
import c.a.u0.e1.d0;
import c.a.u0.e1.f0;
import c.a.u0.e1.m1;
import c.a.u0.e1.p0;
import c.a.u0.e1.r2.m;
import c.a.u0.e1.s;
import c.a.u0.e1.t0;
import c.a.u0.e1.z0;
import c.a.u0.l3.y;
import c.a.u0.z3.f;
import c.a.u0.z3.n;
import c.a.u0.z3.u;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
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
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes12.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements p0, NetModel.k<FrsRequestData, n> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<z0> A;
    public f0 B;
    public t0 C;
    public ArrayList<c.a.d.o.e.n> D;
    public long E;
    public boolean F;
    public String G;
    public int H;
    public int I;
    public int J;
    public boolean K;
    public f L;
    public String M;
    public final SparseArray<Boolean> N;
    public boolean O;
    public c.a.u0.e1.r2.n P;
    public m Q;
    public t0 R;
    public long S;
    public long T;
    public long U;
    public long V;

    /* renamed from: e  reason: collision with root package name */
    public final FrsFragment f43906e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f43907f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.d.o.e.n> f43908g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f43909h;

    /* renamed from: i  reason: collision with root package name */
    public FrsNetModel f43910i;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;

    /* renamed from: j  reason: collision with root package name */
    public final u f43911j;
    public String k;
    public int l;
    public int m;
    public String n;
    public int o;
    public String p;
    public boolean q;
    public String r;
    public String s;
    public String t;
    public long u;
    public int v;
    public int w;
    public int x;
    public z0 y;
    public boolean z;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsModelController;
        }

        @Override // c.a.u0.e1.t0
        public void a(int i2, int i3, m1 m1Var, ArrayList<c.a.d.o.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), m1Var, arrayList}) == null) {
                this.a.z = false;
                if (i2 != this.a.v || this.a.C == null) {
                    return;
                }
                this.a.y = m1Var;
                this.a.R0(i2, i3, m1Var);
                ArrayList<c.a.d.o.e.n> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                this.a.f43907f.setThreadList(arrayList2);
                this.a.C.a(i2, i3, m1Var, arrayList);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends l0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f43912b;

        public b(FrsModelController frsModelController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsModelController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43912b = frsModelController;
            this.a = str;
        }

        @Override // c.a.t0.d1.l0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.u0.z3.e.i().c(this.f43912b.M, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class c extends l0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f43913b;

        public c(FrsModelController frsModelController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsModelController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43913b = frsModelController;
            this.a = str;
        }

        @Override // c.a.t0.d1.l0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.u0.z3.e.i().d(this.f43913b.M, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class d extends l0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f43914b;

        public d(FrsModelController frsModelController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsModelController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43914b = frsModelController;
            this.a = str;
        }

        @Override // c.a.t0.d1.l0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.u0.z3.e.i().b(this.f43914b.M, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class e extends BdAsyncTask<Object, n, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public FrsModelController f43915b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43916c;

        public e(FrsModelController frsModelController, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsModelController, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.a = str;
            this.f43915b = frsModelController;
            this.f43916c = z;
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
                if (this.f43916c && c.a.u0.z3.e.i().e(this.a)) {
                    if (!c.a.u0.z3.e.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        c.a.u0.z3.e.i().j().getForum().getSignData().is_signed = 0;
                    }
                    n j2 = c.a.u0.z3.e.i().j();
                    j2.setIsShowRedTip(false);
                    if (j2.getBookInfo() != null && !StringUtils.isNull(j2.getBookInfo().a(), true) && !j2.getBookInfo().a().equals("0") && j2.getBookInfo().b() == 3 && (e2 = c.a.d.f.m.b.e(j2.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e2))) != null) {
                        j2.setMangaReadRecordChapterId(Integer.valueOf(((Integer) runTask.getData()).intValue()));
                    }
                    publishProgress(j2);
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
                FrsModelController frsModelController = this.f43915b;
                if (frsModelController != null && nVarArr != null) {
                    frsModelController.D0(nVarArr.length > 0 ? nVarArr[0] : null);
                    FrsModelController frsModelController2 = this.f43915b;
                    frsModelController2.J0(frsModelController2.H, true);
                    return;
                }
                FrsModelController frsModelController3 = this.f43915b;
                if (frsModelController3 == null || frsModelController3.f43910i.c0()) {
                    return;
                }
                if (this.f43915b.f43910i.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    FrsModelController frsModelController4 = this.f43915b;
                    frsModelController4.p((MvcHttpResponsedMessage) frsModelController4.f43910i.getResponsedMessage(), (MvcHttpMessage) this.f43915b.f43910i.Z(), this.f43915b.f43910i.a0());
                }
                if (this.f43915b.f43910i.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    FrsModelController frsModelController5 = this.f43915b;
                    frsModelController5.k((MvcSocketResponsedMessage) frsModelController5.f43910i.getResponsedMessage(), (MvcSocketMessage) this.f43915b.f43910i.Z(), this.f43915b.f43910i.a0());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = 3;
        this.m = 1;
        this.n = null;
        this.o = 0;
        this.p = FrsFragment.NORMAL_FRS;
        this.r = "";
        this.s = null;
        this.t = null;
        this.u = 0L;
        this.v = 1;
        this.w = 0;
        this.x = 0;
        this.z = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.A = new SparseArray<>();
        this.E = 0L;
        this.F = false;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.M = null;
        this.N = new SparseArray<>();
        this.P = new c.a.u0.e1.r2.n();
        this.Q = new m();
        this.R = new a(this);
        this.S = 0L;
        this.T = 0L;
        this.U = 0L;
        this.V = 0L;
        if (uVar != null) {
            this.f43906e = frsFragment;
            this.f43911j = uVar;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.f43910i = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.f43906e.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.f43910i;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.f43910i.Y(this);
                }
                this.f43909h = this.f43910i.b0();
            }
            n0(this.f43906e);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public final void A0(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048576, this, z, responsedMessage) == null) && k.d().g()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.f43906e;
            this.E = currentTimeMillis - frsFragment.pullBeginTime;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.f43906e;
            frsFragment.drawTime = currentTimeMillis2 - frsFragment2.drawStartTime;
            h hVar = new h(1000, z, responsedMessage, frsFragment2.sysCreateTime, frsFragment2.createTime, frsFragment2.drawTime, false, frsFragment2.layoutTime, frsFragment2.dataParseTime, this.E);
            int i2 = this.l;
            if (i2 == 4) {
                hVar.B = this.E;
                hVar.e(true);
            } else if (i2 == 3) {
                hVar.C = this.E;
                hVar.e(false);
            }
        }
    }

    public void B0(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, n> mvcSocketMessage, MvcNetMessage<FrsRequestData, n> mvcNetMessage) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (!this.F) {
                this.F = true;
                y0(1000, false, mvcSocketResponsedMessage);
            } else {
                A0(false, mvcSocketResponsedMessage);
            }
            long j2 = 0;
            if (mvcSocketMessage != null) {
                j2 = mvcSocketMessage.getClientLogID();
                frsRequestData = mvcSocketMessage.getRequestData();
            } else {
                frsRequestData = null;
            }
            if (mvcNetMessage != null) {
                j2 = mvcNetMessage.getLogID();
                frsRequestData = mvcNetMessage.getRequestData();
            }
            long j3 = j2;
            int error = mvcSocketResponsedMessage.getError();
            String errorString = mvcSocketResponsedMessage.getErrorString();
            if (error != 0) {
                int cmd = mvcSocketResponsedMessage.getCmd();
                Object[] objArr = new Object[4];
                objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
                objArr[1] = frsRequestData != null ? frsRequestData.z() : null;
                objArr[2] = "seq_id";
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                c.a.t0.s.d0.a.a("frs", j3, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Looper.myQueue().removeIdleHandler(this.P);
            Looper.myQueue().removeIdleHandler(this.Q);
            this.f43910i.cancelLoadData();
        }
    }

    public final void D0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nVar) == null) {
            this.isCacheFirstLoad = false;
            this.f43907f.receiveData(nVar);
            H0(this.f43907f);
            this.f43908g = new ArrayList<>();
            if (this.f43907f.getThreadList() != null) {
                this.f43908g.addAll(this.f43907f.getThreadList());
            }
            this.f43911j.c(nVar);
        }
    }

    public boolean E0(FrsRequestData frsRequestData, n nVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, frsRequestData, nVar)) == null) {
            if (nVar == null || nVar.getForum() == null || (c.a.d.f.p.m.isEmpty(nVar.getForum().getName()) && 340001 != nVar.mErrorNo)) {
                return false;
            }
            if (nVar.getDataParseTime() > 0) {
                this.f43906e.dataParseTime = nVar.getDataParseTime();
            }
            I0(p.f(nVar.getSortType()));
            J0(p.f(nVar.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.v = nVar.getFrsDefaultTabId();
            }
            this.f43907f.receiveData(nVar);
            H0(this.f43907f);
            this.f43908g = new ArrayList<>();
            if (frsRequestData != null) {
                this.f43909h = frsRequestData;
                this.m = frsRequestData.getPn();
                String z = this.f43909h.z();
                this.k = z;
                this.f43906e.setForumName(z);
                this.f43906e.setFrom(this.n);
                this.f43906e.setPn(this.m);
                this.f43906e.setFlag(this.o);
            }
            if (this.f43907f.getThreadList() != null) {
                this.f43908g.addAll(this.f43907f.getThreadList());
            }
            if (this.v != 1 && this.isNetFirstLoad) {
                this.f43911j.d(7, false, this.L);
            } else {
                this.f43911j.d(this.l, false, this.L);
            }
            this.s = null;
            if (c.a.u0.e1.w2.b.b(this.f43909h)) {
                G0();
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.f43907f.getForum()));
            }
            this.isNetFirstLoad = false;
            if (nVar.getForum() != null && !TextUtils.isEmpty(nVar.getForum().getName()) && frsRequestData != null && y.q().b() != null) {
                y.q().b().g(nVar.getForum().getName(), frsRequestData.A(), false);
            }
            if (!StringUtils.isNull(nVar.getUserData().getAppealThreadPopover())) {
                this.f43906e.showFrsDeleteThreadTip(TbadkCoreApplication.getCurrentAccount(), nVar.getForum().getId(), nVar.getUserData().getAppealThreadPopover());
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void F0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f43909h == null) {
            return;
        }
        this.f43906e.pullBeginTime = System.currentTimeMillis();
        FrsViewData frsViewData = this.f43907f;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.f43907f.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f43909h), FrsRequestData.class);
        frsRequestData.setPn(1);
        int O = O(this.v, frsRequestData);
        this.v = O;
        if (O == 1) {
            if (this.f43910i.Q()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            L(frsRequestData, i2, !z);
            return;
        }
        if (this.y == null) {
            z0 z0Var = new z0();
            this.y = z0Var;
            z0Var.f17359c = 1;
            z0Var.a = this.k;
            FrsViewData frsViewData2 = this.f43907f;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.y.f17358b = this.f43907f.getForum().getId();
            }
        }
        x0(i2);
    }

    public void G(y0 y0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, y0Var) == null) || y0Var == null || StringUtils.isNull(y0Var.h0()) || ListUtils.isEmpty(this.f43908g)) {
            return;
        }
        if (this.v == 1) {
            this.f43907f.addMyNewThread(y0Var);
        }
        int c0 = c0();
        Iterator<c.a.d.o.e.n> it = this.f43908g.iterator();
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            if ((next instanceof d2) && y0Var.h0().equals(((d2) next).w.h0())) {
                return;
            }
        }
        this.f43908g.add(c0, y0Var);
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.f43907f;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(c.a.d.f.m.b.g(this.f43907f.getForum().getId(), 0L));
            }
            this.f43906e.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public final void H(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, frsRequestData) == null) && e2.X3.get() && y.q().b() != null) {
            int d2 = y.q().b().d(str, false);
            int e2 = y.q().b().e(str, false);
            if (frsRequestData.A() == 1) {
                d2++;
            } else if (frsRequestData.A() == 2) {
                e2++;
            }
            frsRequestData.U(d2);
            frsRequestData.P(e2);
        }
    }

    public final void H0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, frsViewData) == null) {
            if (c.a.u0.e1.c3.h.B(frsViewData)) {
                this.p = FrsFragment.BOOK_FRS;
            } else if (frsViewData.getIsBrandForum()) {
                this.p = FrsFragment.BRAND_FRS;
            } else if (c.a.u0.e1.c3.h.C(frsViewData)) {
                this.p = FrsFragment.STAR_FRS;
            } else {
                this.p = FrsFragment.NORMAL_FRS;
            }
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            o0.b(new d(this, str), null);
        }
    }

    public void I0(int i2) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.H = i2;
            if (i2 != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                p.i("1~" + str + this.k, this.H);
            }
            if (7 == i2) {
                c.a.u0.z3.q0.e.b();
            } else {
                c.a.u0.z3.q0.e.a();
            }
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            o0.b(new b(this, str), null);
        }
    }

    public void J0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.N.put(i2, Boolean.valueOf(z));
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            o0.b(new c(this, str), null);
        }
    }

    public void K0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.K = z;
        }
    }

    public final void L(FrsRequestData frsRequestData, int i2, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{frsRequestData, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.l = i2;
            this.f43906e.resetTabViewControllerRefreshTab(z);
            this.f43911j.a(i2);
            this.f43910i.d0(frsRequestData);
            frsRequestData.S(this.f43906e.isFromMainTab() ? "1" : "2");
            if (this.K) {
                frsRequestData.T(String.valueOf(p.d(this.I)));
            } else {
                frsRequestData.T(StatHelper.SENSOR_ERR_2);
            }
            this.K = false;
            frsRequestData.M(this.k);
            frsRequestData.Z(1);
            frsRequestData.E(0);
            int k = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
            int i3 = c.a.d.f.p.n.i(TbadkCoreApplication.getInst());
            float h2 = c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
            int i4 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            frsRequestData.Y(k);
            frsRequestData.X(i3);
            frsRequestData.W(h2);
            frsRequestData.b0(i4);
            frsRequestData.V(this.r);
            frsRequestData.O(this.t);
            frsRequestData.a0(this.G);
            frsRequestData.N(c.a.d.f.m.b.g(i0.a(), 0L));
            String str = this.s;
            if (str != null) {
                frsRequestData.setStType(str);
                if ("sidebar".equalsIgnoreCase(this.s)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.J(p0());
            if (FrsFragment.mPbLoadTime != 0) {
                frsRequestData.F((int) FrsFragment.mPbLoadTime);
            }
            if (FrsFragment.mPbLoadDataSize != 0) {
                frsRequestData.G((int) FrsFragment.mPbLoadDataSize);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.R(FrsFragment.mNetError);
            }
            if (frsRequestData.getPn() != 1 && this.l != 3) {
                FrsViewData frsViewData = this.f43907f;
                frsRequestData.C(c.a.u0.l3.a.e(frsViewData != null ? frsViewData.getThreadList() : null, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.f43907f;
                frsRequestData.C(c.a.u0.l3.a.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.l);
            frsRequestData.I(this.u);
            p.e(this.H, frsRequestData);
            int d2 = p.d(this.J);
            N(i2, frsRequestData);
            H(this.k, frsRequestData);
            if (!i0(this.J) && !this.f43906e.createWithGame && !this.O) {
                c.a.u0.z3.e i5 = c.a.u0.z3.e.i();
                String g2 = i5.g("1~" + this.k, d2, frsRequestData.y(), this.f43909h.x());
                this.M = g2;
                new e(this, true, g2).execute(new Object[0]);
            }
            P0();
            this.O = false;
        }
    }

    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.O = z;
        }
    }

    public final void M(FrsRequestData frsRequestData, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{frsRequestData, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.l = i2;
            this.f43906e.resetTabViewControllerRefreshTab(z);
            this.f43911j.a(i2);
            if (this.f43910i.c0() && (this.f43910i.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                p((MvcHttpResponsedMessage) this.f43910i.getResponsedMessage(), (MvcHttpMessage) this.f43910i.Z(), this.f43910i.a0());
            } else if (this.f43910i.c0() && (this.f43910i.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                k((MvcSocketResponsedMessage) this.f43910i.getResponsedMessage(), (MvcSocketMessage) this.f43910i.Z(), this.f43910i.a0());
            } else {
                int d2 = p.d(this.J);
                if (!i0(this.J) && !this.f43906e.createWithGame && !this.O) {
                    c.a.u0.z3.e i3 = c.a.u0.z3.e.i();
                    String g2 = i3.g("1~" + this.k, d2, frsRequestData.y(), this.f43909h.x());
                    this.M = g2;
                    new e(this, true, g2).execute(new Object[0]);
                }
                this.O = false;
            }
            this.f43910i.Y(this);
        }
    }

    public void M0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.I = i2;
        }
    }

    public final void N(int i2, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048596, this, i2, frsRequestData) == null) || frsRequestData == null) {
            return;
        }
        if (i2 == 3) {
            frsRequestData.Q(1);
        } else if (i2 != 4) {
        } else {
            frsRequestData.Q(2);
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            s sVar = new s();
            if (this.x == 0) {
                sVar.d(this.H);
            }
            if (this.f43907f.getThreadList() != null) {
                this.f43907f.getThreadList().clear();
                this.f43907f.getThreadList().add(sVar);
            }
            ArrayList<c.a.d.o.e.n> arrayList = this.f43908g;
            if (arrayList != null) {
                arrayList.clear();
                this.f43908g.add(sVar);
            }
        }
    }

    public final int O(int i2, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, frsRequestData)) == null) ? (i2 != 1 || this.f43906e.getEntelechyProcessor() == null) ? i2 : this.f43906e.getEntelechyProcessor().d(this.H, frsRequestData) : invokeIL.intValue;
    }

    public void O0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.r = str;
        }
    }

    public void P(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f43906e.pullBeginTime = System.currentTimeMillis();
            FrsViewData frsViewData = this.f43907f;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.f43907f.getLikeFeedForumDataList().clear();
            }
            this.v = O(this.v, this.f43909h);
            FrsRequestData frsRequestData = this.f43909h;
            FrsViewData frsViewData2 = this.f43907f;
            frsRequestData.C(c.a.u0.l3.a.e(frsViewData2 == null ? null : frsViewData2.getThreadList(), true));
            if (this.v == 1) {
                M(this.f43909h, i2, !z);
                return;
            }
            if (this.y == null) {
                z0 z0Var = new z0();
                this.y = z0Var;
                z0Var.f17359c = 1;
                z0Var.a = this.k;
                FrsViewData frsViewData3 = this.f43907f;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.y.f17358b = this.f43907f.getForum().getId();
                }
            }
            x0(i2);
        }
    }

    public final boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            this.S = System.currentTimeMillis();
            return this.f43910i.loadData();
        }
        return invokeV.booleanValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.J : invokeV.intValue;
    }

    public void Q0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (frsViewData = this.f43907f) == null || frsViewData.getForum() == null || this.f43907f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f43907f.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.t = lastIds;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.H : invokeV.intValue;
    }

    public final void R0(int i2, int i3, z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048605, this, i2, i3, z0Var) == null) {
            this.A.put(Y(i2, i3), z0Var);
        }
    }

    public f S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.L : (f) invokeV.objValue;
    }

    public FrsRequestData T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f43909h : (FrsRequestData) invokeV.objValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? 1 == this.v : invokeV.booleanValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.x : invokeV.intValue;
    }

    public ArrayList<c.a.d.o.e.n> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f43908g : (ArrayList) invokeV.objValue;
    }

    public z0 X(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048611, this, i2, i3)) == null) ? this.A.get(Y(i2, i3)) : (z0) invokeII.objValue;
    }

    public final int Y(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048612, this, i2, i3)) == null) ? (i2 * 10) + i3 : invokeII.intValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? p.d(this.H) : invokeV.intValue;
    }

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.v : invokeV.intValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ArrayList<c.a.d.o.e.n> arrayList = this.f43908g;
            int i2 = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<c.a.d.o.e.n> it = this.f43908g.iterator();
                while (it.hasNext()) {
                    c.a.d.o.e.n next = it.next();
                    if (next instanceof d2) {
                        if (((d2) next).w.t0() == 0) {
                            break;
                        }
                        i2++;
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public FrsViewData d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f43907f : (FrsViewData) invokeV.objValue;
    }

    public long e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.V : invokeV.longValue;
    }

    public long f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.S : invokeV.longValue;
    }

    @Override // c.a.u0.e1.p0
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.B.b();
            this.B.clear();
        }
    }

    public long g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.U : invokeV.longValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.m : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.l : invokeV.intValue;
    }

    public long h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.T : invokeV.longValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            z0 z0Var = this.y;
            if ((z0Var instanceof m1) && ((m1) z0Var).f16767e == 0) {
                return ((m1) z0Var).f16769g;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean i0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) ? this.N.get(i2, Boolean.FALSE).booleanValue() : invokeI.booleanValue;
    }

    @Override // c.a.u0.e1.p0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.B.e();
        }
    }

    public void j0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bundle) == null) {
            if (bundle != null) {
                this.k = bundle.getString("name");
                this.n = bundle.getString("from");
                this.o = bundle.getInt("flag", 0);
                this.G = bundle.getString("yuelaou_locate");
                this.q = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
                this.f43906e.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            }
            if (TextUtils.isEmpty(this.k)) {
                this.k = "";
            }
            if (TextUtils.isEmpty(this.n)) {
                this.n = "";
            }
            if (TextUtils.isEmpty(this.G)) {
                this.G = "";
            }
            this.s = this.n;
            m0();
            if (this.f43907f == null) {
                this.f43907f = new FrsViewData();
            }
            if (this.f43910i == null || (frsRequestData = this.f43909h) == null || frsRequestData.u() == null || this.f43909h.u().isEmpty() || this.f43909h.u().containsKey(null) || this.f43909h.u().containsValue(null)) {
                k0(bundle);
            }
            String str = this.k;
            if (str == null || str.length() <= 0) {
                return;
            }
            String str2 = this.n;
            if (str2 == null || str2.length() <= 0) {
                this.n = FrsFragment.FRS_FROM_LIKE;
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, n> mvcSocketMessage, MvcNetMessage<FrsRequestData, n> mvcNetMessage) {
        n data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048630, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.P.a(this);
        this.P.e(mvcSocketResponsedMessage);
        this.P.c(mvcSocketMessage);
        this.P.d(mvcNetMessage);
        this.P.b(this.f43911j);
        Looper.myQueue().addIdleHandler(this.P);
        f fVar = new f();
        fVar.a = l.z() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        fVar.f26160b = !mvcSocketResponsedMessage.hasError();
        fVar.f26161c = mvcSocketResponsedMessage.getError();
        fVar.f26162d = mvcSocketResponsedMessage.getErrorString();
        fVar.f26163e = mvcSocketResponsedMessage.getDownSize();
        this.L = fVar;
        if (!mvcSocketResponsedMessage.hasError() || 340001 == mvcSocketResponsedMessage.getError()) {
            data = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            data = null;
        }
        if (r1 == null || data == null || !E0(r1, data)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f43906e.onServerError(errorData);
        }
    }

    public final void k0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.f43909h = frsRequestData;
            frsRequestData.setSortType(p.d(this.H));
            if (this.H == 5) {
                this.f43909h.K(1);
            } else {
                this.f43909h.K(0);
            }
            this.f43909h.w("forum_name", c.a.d.f.p.m.getUrlEncode(this.k));
            this.f43909h.w("client_type", "2");
            this.f43909h.setPn(1);
            if (bundle != null) {
                this.f43909h.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.f43909h.I(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.f43909h.S("2");
            this.f43909h.T(StatHelper.SENSOR_ERR_2);
            this.f43909h.M(this.k);
            this.f43909h.Z(1);
            this.f43909h.E(0);
            this.f43909h.Y(c.a.d.f.p.n.k(TbadkCoreApplication.getInst()));
            this.f43909h.X(c.a.d.f.p.n.i(TbadkCoreApplication.getInst()));
            this.f43909h.W(c.a.d.f.p.n.h(TbadkCoreApplication.getInst()));
            this.f43909h.b0(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
            this.f43909h.V(this.r);
            this.f43909h.O(null);
            this.f43909h.a0(this.G);
            this.f43909h.N(c.a.d.f.m.b.g(i0.a(), 0L));
            this.f43909h.setStType(this.n);
            this.f43909h.J(1);
            this.f43909h.setNeedCache(true);
            this.f43909h.setUpdateType(3);
            FrsRequestData frsRequestData2 = this.f43909h;
            FrsViewData frsViewData = this.f43907f;
            frsRequestData2.C(c.a.u0.l3.a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            p.e(this.H, this.f43909h);
            this.f43909h.Q(1);
            if (e2.X3.get() && y.q().b() != null) {
                int d2 = y.q().b().d(this.k, false);
                int e2 = y.q().b().e(this.k, false);
                if (this.f43909h.A() == 1) {
                    d2++;
                } else if (this.f43909h.A() == 2) {
                    e2++;
                }
                this.f43909h.U(d2);
                this.f43909h.P(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.f43909h);
            this.f43910i = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.f43906e.getActivity()).getUniqueId());
            this.f43910i.Y(this);
            this.f43910i.loadData();
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (this.D == null) {
                this.D = new ArrayList<>();
            }
            if (this.D.size() == 0) {
                this.D.add(new b0());
            }
        }
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

    public final void m0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.s)) {
                I0(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.s)) {
                I0(6);
            } else {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                this.J = p.h("1~" + str + this.k);
                I0(this.H);
            }
        }
    }

    public final void n0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, frsFragment) == null) {
            f0 f0Var = new f0();
            this.B = f0Var;
            f0Var.f16530e = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.B));
            this.B.f(this.R);
        }
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, bundle) == null) {
            bundle.putString("name", this.k);
            bundle.putString("from", this.n);
            bundle.putInt("flag", this.o);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<n> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, n> mvcHttpMessage, MvcNetMessage<FrsRequestData, n> mvcNetMessage) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048638, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.Q.a(this);
        this.Q.e(mvcHttpResponsedMessage);
        this.Q.c(mvcHttpMessage);
        this.Q.d(mvcNetMessage);
        this.Q.b(this.f43911j);
        Looper.myQueue().addIdleHandler(this.Q);
        f fVar = new f();
        fVar.a = l.z() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        fVar.f26160b = !mvcHttpResponsedMessage.hasError();
        fVar.f26161c = mvcHttpResponsedMessage.getError();
        fVar.f26162d = mvcHttpResponsedMessage.getErrorString();
        fVar.f26163e = mvcHttpResponsedMessage.getDownSize();
        this.L = fVar;
        if (mvcHttpResponsedMessage.hasError()) {
            nVar = null;
        } else {
            nVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || nVar == null || !E0(r1, nVar)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f43906e.onServerError(errorData);
        }
    }

    public final int p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            FrsFragment frsFragment = this.f43906e;
            if (frsFragment != null) {
                int i2 = frsFragment.mHeadLineDefaultNavTabId;
                return (i2 == -1 || i2 == this.v) ? 1 : 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.u0.e1.p0
    public void q(int i2, int i3, z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048640, this, i2, i3, z0Var) == null) {
            this.v = O(i2, null);
            if (z0Var == null && (z0Var = X(i2, i3)) == null) {
                if (i2 != 1 && c.a.d.f.p.n.C() && this.C != null) {
                    m1 m1Var = new m1();
                    m1Var.f16769g = false;
                    m1Var.f17359c = 1;
                    m1Var.a = this.k;
                    m1Var.f16771i = false;
                    FrsViewData frsViewData = this.f43907f;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        m1Var.f17358b = this.f43907f.getForum().getId();
                    }
                    l0();
                    this.f43907f.setThreadList(this.D);
                    this.C.a(i2, i3, m1Var, this.D);
                }
                z0Var = new z0();
                z0Var.f17359c = -1;
            }
            FrsViewData frsViewData2 = this.f43907f;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                z0Var.f17358b = this.f43907f.getForum().getId();
            }
            z0Var.a = this.k;
            if (d0.a().b(1) != null && this.v == 1) {
                this.f43909h.D(i3);
            }
            this.w = i3;
            this.y = z0Var;
            R0(i2, i3, z0Var);
            x0(5);
        }
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.H == 5 : invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.f43910i.Q() : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i2, c.a.d.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i2, aVar) == null) {
            super.registerListener(i2, aVar);
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            FrsRequestData frsRequestData = this.f43909h;
            return frsRequestData != null && frsRequestData.A() == 1;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.u0.e1.p0
    public void t(t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, t0Var) == null) {
            this.C = t0Var;
            this.B.f(this.R);
        }
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.H == 7 || (!this.f43910i.c0() && this.J == 7) : invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            if (this.v != 1) {
                x0(1);
                return true;
            } else if (this.f43910i.Q()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f43909h), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(a0());
                L(frsRequestData, 1, false);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            if (this.v != 1) {
                x0(4);
            } else if (this.f43910i.Q()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f43909h), FrsRequestData.class);
                frsRequestData.setPn(i2);
                frsRequestData.setSortType(a0());
                L(frsRequestData, 4, false);
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
    public final void x0(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048651, this, i2) != null) {
            return;
        }
        this.l = i2;
        if (i2 != 1) {
            if (i2 == 2) {
                z0 z0Var = this.y;
                if (z0Var != null) {
                    z0Var.f17359c--;
                }
            } else if (i2 == 3) {
                z0 z0Var2 = this.y;
                if (z0Var2 != null) {
                    z0Var2.f17359c = -1;
                }
            }
            i3 = this.v;
            if (i3 != 1) {
                if (this.x == this.w) {
                    ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>();
                    ArrayList<c.a.d.o.e.n> arrayList2 = this.f43908g;
                    if (arrayList2 != null) {
                        arrayList.addAll(arrayList2);
                    }
                    this.f43907f.setThreadList(arrayList);
                    t0 t0Var = this.C;
                    if (t0Var != null) {
                        t0Var.a(this.v, this.w, null, arrayList);
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                }
                this.x = this.w;
                return;
            }
            p0 c2 = this.B.c(i3);
            if (c2 != null) {
                this.z = true;
                c2.q(this.v, this.w, this.y);
                return;
            }
            FrsViewData frsViewData = this.f43907f;
            if (frsViewData != null && frsViewData.getThreadList() != null) {
                this.f43907f.getThreadList().clear();
            }
            this.C.a(this.v, this.w, null, null);
            return;
        }
        z0 z0Var3 = this.y;
        if (z0Var3 != null) {
            z0Var3.f17359c++;
        }
        i3 = this.v;
        if (i3 != 1) {
        }
    }

    public final void y0(int i2, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048652, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage}) == null) && k.d().g()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.f43906e;
            this.E = currentTimeMillis - frsFragment.initTime;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.f43906e;
            frsFragment.drawTime = currentTimeMillis2 - frsFragment2.drawStartTime;
            h hVar = new h(i2, z, responsedMessage, frsFragment2.sysCreateTime, frsFragment2.createTime, frsFragment2.drawTime, false, frsFragment2.layoutTime, frsFragment2.dataParseTime, this.E);
            FrsFragment frsFragment3 = this.f43906e;
            frsFragment3.createTime = 0L;
            frsFragment3.sysCreateTime = 0L;
            q.f(this, frsFragment3.initTime);
            this.f43906e.initTime = -1L;
            hVar.c();
        }
    }

    public void z0(MvcHttpResponsedMessage<n> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, n> mvcHttpMessage, MvcNetMessage<FrsRequestData, n> mvcNetMessage) {
        long j2;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048653, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            if (mvcHttpMessage != null) {
                j2 = mvcHttpMessage.getClientLogID();
                frsRequestData = mvcHttpMessage.getRequestData();
            } else {
                j2 = 0;
                frsRequestData = null;
            }
            if (mvcNetMessage != null) {
                j2 = mvcNetMessage.getLogID();
                frsRequestData = mvcNetMessage.getRequestData();
            }
            long j3 = j2;
            int error = mvcHttpResponsedMessage.getError();
            String errorString = mvcHttpResponsedMessage.getErrorString();
            if (error != 0) {
                int cmd = mvcHttpResponsedMessage.getCmd();
                Object[] objArr = new Object[2];
                objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
                objArr[1] = frsRequestData != null ? frsRequestData.z() : null;
                c.a.t0.s.d0.a.a("frs", j3, cmd, "http_resp", error, errorString, objArr);
            }
            if (!this.F) {
                this.F = true;
                y0(1000, true, mvcHttpResponsedMessage);
                return;
            }
            A0(true, mvcHttpResponsedMessage);
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

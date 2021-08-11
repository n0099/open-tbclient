package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.k.e.n;
import c.a.o0.b1.h0;
import c.a.o0.b1.k0;
import c.a.o0.o0.h;
import c.a.o0.o0.k;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
import c.a.p0.i3.f;
import c.a.p0.i3.m;
import c.a.p0.i3.s;
import c.a.p0.v0.a0;
import c.a.p0.v0.b1;
import c.a.p0.v0.c0;
import c.a.p0.v0.e0;
import c.a.p0.v0.o0;
import c.a.p0.v0.s0;
import c.a.p0.v0.y0;
import c.a.p0.x2.y;
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
/* loaded from: classes7.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements o0, NetModel.k<FrsRequestData, m> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<y0> A;
    public e0 B;
    public s0 C;
    public ArrayList<n> D;
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
    public c.a.p0.v0.e2.n P;
    public c.a.p0.v0.e2.m Q;
    public s0 R;
    public long S;
    public long T;
    public long U;
    public long V;

    /* renamed from: e  reason: collision with root package name */
    public final FrsFragment f51194e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f51195f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f51196g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f51197h;

    /* renamed from: i  reason: collision with root package name */
    public FrsNetModel f51198i;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;

    /* renamed from: j  reason: collision with root package name */
    public final s f51199j;
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
    public y0 y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f51200a;

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
            this.f51200a = frsModelController;
        }

        @Override // c.a.p0.v0.s0
        public void a(int i2, int i3, b1 b1Var, ArrayList<n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), b1Var, arrayList}) == null) {
                this.f51200a.z = false;
                if (i2 != this.f51200a.v || this.f51200a.C == null) {
                    return;
                }
                this.f51200a.y = b1Var;
                this.f51200a.S0(i2, i3, b1Var);
                ArrayList<n> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                this.f51200a.f51195f.setThreadList(arrayList2);
                this.f51200a.C.a(i2, i3, b1Var, arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends h0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51201a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f51202b;

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
            this.f51202b = frsModelController;
            this.f51201a = str;
        }

        @Override // c.a.o0.b1.h0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.i3.e.i().c(this.f51202b.M, this.f51201a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends h0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51203a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f51204b;

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
            this.f51204b = frsModelController;
            this.f51203a = str;
        }

        @Override // c.a.o0.b1.h0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.i3.e.i().d(this.f51204b.M, this.f51203a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends h0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51205a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f51206b;

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
            this.f51206b = frsModelController;
            this.f51205a = str;
        }

        @Override // c.a.o0.b1.h0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.i3.e.i().b(this.f51206b.M, this.f51205a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends BdAsyncTask<Object, m, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f51207a;

        /* renamed from: b  reason: collision with root package name */
        public FrsModelController f51208b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f51209c;

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
            this.f51207a = null;
            this.f51207a = str;
            this.f51208b = frsModelController;
            this.f51209c = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            int d2;
            CustomResponsedMessage runTask;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                if (this.f51209c && c.a.p0.i3.e.i().e(this.f51207a)) {
                    if (!c.a.p0.i3.e.i().l(TbadkCoreApplication.getCurrentAccount() + this.f51207a)) {
                        c.a.p0.i3.e.i().j().getForum().getSignData().is_signed = 0;
                    }
                    m j2 = c.a.p0.i3.e.i().j();
                    j2.setIsShowRedTip(false);
                    if (j2.getBookInfo() != null && !StringUtils.isNull(j2.getBookInfo().a(), true) && !j2.getBookInfo().a().equals("0") && j2.getBookInfo().b() == 3 && (d2 = c.a.e.e.m.b.d(j2.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(d2))) != null) {
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
        public void onProgressUpdate(m... mVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVarArr) == null) {
                super.onProgressUpdate(mVarArr);
                FrsModelController frsModelController = this.f51208b;
                if (frsModelController != null && mVarArr != null) {
                    frsModelController.E0(mVarArr.length > 0 ? mVarArr[0] : null);
                    FrsModelController frsModelController2 = this.f51208b;
                    frsModelController2.K0(frsModelController2.H, true);
                    return;
                }
                FrsModelController frsModelController3 = this.f51208b;
                if (frsModelController3 == null || frsModelController3.f51198i.d0()) {
                    return;
                }
                if (this.f51208b.f51198i.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    FrsModelController frsModelController4 = this.f51208b;
                    frsModelController4.p((MvcHttpResponsedMessage) frsModelController4.f51198i.getResponsedMessage(), (MvcHttpMessage) this.f51208b.f51198i.a0(), this.f51208b.f51198i.b0());
                }
                if (this.f51208b.f51198i.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    FrsModelController frsModelController5 = this.f51208b;
                    frsModelController5.k((MvcSocketResponsedMessage) frsModelController5.f51198i.getResponsedMessage(), (MvcSocketMessage) this.f51208b.f51198i.a0(), this.f51208b.f51198i.b0());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, s sVar) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.e.a.f) newInitContext.callArgs[0]);
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
        this.P = new c.a.p0.v0.e2.n();
        this.Q = new c.a.p0.v0.e2.m();
        this.R = new a(this);
        this.S = 0L;
        this.T = 0L;
        this.U = 0L;
        this.V = 0L;
        if (sVar != null) {
            this.f51194e = frsFragment;
            this.f51199j = sVar;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.f51198i = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.f51194e.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.f51198i;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.f51198i.Z(this);
                }
                this.f51197h = this.f51198i.c0();
            }
            o0(this.f51194e);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public void A0(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        long j2;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                c.a.o0.s.z.a.a("frs", j3, cmd, "http_resp", error, errorString, objArr);
            }
            if (!this.F) {
                this.F = true;
                z0(1000, true, mvcHttpResponsedMessage);
                return;
            }
            B0(true, mvcHttpResponsedMessage);
        }
    }

    public final void B0(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, responsedMessage) == null) && k.d().g()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.f51194e;
            this.E = currentTimeMillis - frsFragment.pullBeginTime;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.f51194e;
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

    public void C0(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (!this.F) {
                this.F = true;
                z0(1000, false, mvcSocketResponsedMessage);
            } else {
                B0(false, mvcSocketResponsedMessage);
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
                c.a.o0.s.z.a.a("frs", j3, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Looper.myQueue().removeIdleHandler(this.P);
            Looper.myQueue().removeIdleHandler(this.Q);
            this.f51198i.cancelLoadData();
        }
    }

    public final void E0(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mVar) == null) {
            this.isCacheFirstLoad = false;
            this.f51195f.receiveData(mVar);
            I0(this.f51195f);
            this.f51196g = new ArrayList<>();
            if (this.f51195f.getThreadList() != null) {
                this.f51196g.addAll(this.f51195f.getThreadList());
            }
            this.f51199j.c(mVar);
        }
    }

    public boolean F0(FrsRequestData frsRequestData, m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, frsRequestData, mVar)) == null) {
            if (mVar == null || mVar.getForum() == null || (c.a.e.e.p.k.isEmpty(mVar.getForum().getName()) && 340001 != mVar.mErrorNo)) {
                return false;
            }
            if (mVar.getDataParseTime() > 0) {
                this.f51194e.dataParseTime = mVar.getDataParseTime();
            }
            J0(c.a.p0.v0.n2.k.f(mVar.getSortType()));
            K0(c.a.p0.v0.n2.k.f(mVar.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.v = mVar.getFrsDefaultTabId();
            }
            this.f51195f.receiveData(mVar);
            I0(this.f51195f);
            this.f51196g = new ArrayList<>();
            if (frsRequestData != null) {
                this.f51197h = frsRequestData;
                this.m = frsRequestData.getPn();
                String z = this.f51197h.z();
                this.k = z;
                this.f51194e.setForumName(z);
                this.f51194e.setFrom(this.n);
                this.f51194e.setPn(this.m);
                this.f51194e.setFlag(this.o);
            }
            if (this.f51195f.getThreadList() != null) {
                this.f51196g.addAll(this.f51195f.getThreadList());
            }
            if (this.v != 1 && this.isNetFirstLoad) {
                this.f51199j.d(7, false, this.L);
            } else {
                this.f51199j.d(this.l, false, this.L);
            }
            this.s = null;
            if (c.a.p0.v0.h2.b.b(this.f51197h)) {
                H0();
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.f51195f.getForum()));
            }
            this.isNetFirstLoad = false;
            if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && y.o().b() != null) {
                y.o().b().g(mVar.getForum().getName(), frsRequestData.A(), false);
            }
            if (!StringUtils.isNull(mVar.getUserData().getAppealThreadPopover())) {
                this.f51194e.showFrsDeleteThreadTip(TbadkCoreApplication.getCurrentAccount(), mVar.getForum().getId(), mVar.getUserData().getAppealThreadPopover());
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void G(c.a.o0.s.q.y0 y0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, y0Var) == null) || y0Var == null || StringUtils.isNull(y0Var.f0()) || ListUtils.isEmpty(this.f51196g)) {
            return;
        }
        if (this.v == 1) {
            this.f51195f.addMyNewThread(y0Var);
        }
        int c0 = c0();
        Iterator<n> it = this.f51196g.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof b2) && y0Var.f0().equals(((b2) next).w.f0())) {
                return;
            }
        }
        this.f51196g.add(c0, y0Var);
    }

    public void G0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f51197h == null) {
            return;
        }
        this.f51194e.pullBeginTime = System.currentTimeMillis();
        FrsViewData frsViewData = this.f51195f;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.f51195f.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f51197h), FrsRequestData.class);
        frsRequestData.setPn(1);
        int O = O(this.v, frsRequestData);
        this.v = O;
        if (O == 1) {
            if (this.f51198i.Q()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            L(frsRequestData, i2, !z);
            return;
        }
        if (this.y == null) {
            y0 y0Var = new y0();
            this.y = y0Var;
            y0Var.f27038c = 1;
            y0Var.f27036a = this.k;
            FrsViewData frsViewData2 = this.f51195f;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.y.f27037b = this.f51195f.getForum().getId();
            }
        }
        y0(i2);
    }

    public final void H(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, frsRequestData) == null) && c2.J3.get() && y.o().b() != null) {
            int d2 = y.o().b().d(str, false);
            int e2 = y.o().b().e(str, false);
            if (frsRequestData.A() == 1) {
                d2++;
            } else if (frsRequestData.A() == 2) {
                e2++;
            }
            frsRequestData.U(d2);
            frsRequestData.P(e2);
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.f51195f;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(c.a.e.e.m.b.f(this.f51195f.getForum().getId(), 0L));
            }
            this.f51194e.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            k0.b(new d(this, str), null);
        }
    }

    public final void I0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, frsViewData) == null) {
            if (c.a.p0.v0.o2.h.A(frsViewData)) {
                this.p = FrsFragment.BOOK_FRS;
            } else if (frsViewData.getIsBrandForum()) {
                this.p = FrsFragment.BRAND_FRS;
            } else if (c.a.p0.v0.o2.h.B(frsViewData)) {
                this.p = FrsFragment.STAR_FRS;
            } else {
                this.p = FrsFragment.NORMAL_FRS;
            }
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            k0.b(new b(this, str), null);
        }
    }

    public void J0(int i2) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.H = i2;
            if (i2 != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                c.a.p0.v0.n2.k.i("1~" + str + this.k, this.H);
            }
            if (7 == i2) {
                c.a.p0.i3.n0.e.b();
            } else {
                c.a.p0.i3.n0.e.a();
            }
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            k0.b(new c(this, str), null);
        }
    }

    public void K0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.N.put(i2, Boolean.valueOf(z));
        }
    }

    public final void L(FrsRequestData frsRequestData, int i2, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{frsRequestData, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.l = i2;
            this.f51194e.resetTabViewControllerRefreshTab(z);
            this.f51199j.a(i2);
            this.f51198i.e0(frsRequestData);
            frsRequestData.S(this.f51194e.isFromMainTab() ? "1" : "2");
            if (this.K) {
                frsRequestData.T(String.valueOf(c.a.p0.v0.n2.k.d(this.I)));
            } else {
                frsRequestData.T(StatHelper.SENSOR_ERR_2);
            }
            this.K = false;
            frsRequestData.M(this.k);
            frsRequestData.Z(1);
            frsRequestData.E(0);
            int k = l.k(TbadkCoreApplication.getInst());
            int i3 = l.i(TbadkCoreApplication.getInst());
            float h2 = l.h(TbadkCoreApplication.getInst());
            int i4 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            frsRequestData.Y(k);
            frsRequestData.X(i3);
            frsRequestData.W(h2);
            frsRequestData.b0(i4);
            frsRequestData.V(this.r);
            frsRequestData.O(this.t);
            frsRequestData.a0(this.G);
            frsRequestData.N(c.a.e.e.m.b.f(c.a.o0.b1.e0.a(), 0L));
            String str = this.s;
            if (str != null) {
                frsRequestData.setStType(str);
                if ("sidebar".equalsIgnoreCase(this.s)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.J(q0());
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
                FrsViewData frsViewData = this.f51195f;
                frsRequestData.C(c.a.p0.x2.a.e(frsViewData != null ? frsViewData.getThreadList() : null, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.f51195f;
                frsRequestData.C(c.a.p0.x2.a.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.l);
            frsRequestData.I(this.u);
            c.a.p0.v0.n2.k.e(this.H, frsRequestData);
            int d2 = c.a.p0.v0.n2.k.d(this.J);
            N(i2, frsRequestData);
            H(this.k, frsRequestData);
            if (!j0(this.J) && !this.f51194e.createWithGame && !this.O) {
                c.a.p0.i3.e i5 = c.a.p0.i3.e.i();
                String g2 = i5.g("1~" + this.k, d2, frsRequestData.y(), this.f51197h.x());
                this.M = g2;
                new e(this, true, g2).execute(new Object[0]);
            }
            Q0();
            this.O = false;
        }
    }

    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.K = z;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M(FrsRequestData frsRequestData, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{frsRequestData, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.l = i2;
            this.f51194e.resetTabViewControllerRefreshTab(z);
            this.f51199j.a(i2);
            if (this.f51198i.d0() && (this.f51198i.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                p((MvcHttpResponsedMessage) this.f51198i.getResponsedMessage(), (MvcHttpMessage) this.f51198i.a0(), this.f51198i.b0());
            } else if (this.f51198i.d0() && (this.f51198i.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                k((MvcSocketResponsedMessage) this.f51198i.getResponsedMessage(), (MvcSocketMessage) this.f51198i.a0(), this.f51198i.b0());
            } else {
                int d2 = c.a.p0.v0.n2.k.d(this.J);
                if (!j0(this.J) && !this.f51194e.createWithGame && !this.O) {
                    c.a.p0.i3.e i3 = c.a.p0.i3.e.i();
                    String g2 = i3.g("1~" + this.k, d2, frsRequestData.y(), this.f51197h.x());
                    this.M = g2;
                    new e(this, true, g2).execute(new Object[0]);
                }
                this.O = false;
            }
            this.f51198i.Z(this);
        }
    }

    public void M0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.O = z;
        }
    }

    public final void N(int i2, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048597, this, i2, frsRequestData) == null) || frsRequestData == null) {
            return;
        }
        if (i2 == 3) {
            frsRequestData.Q(1);
        } else if (i2 != 4) {
        } else {
            frsRequestData.Q(2);
        }
    }

    public void N0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.I = i2;
        }
    }

    public final int O(int i2, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048599, this, i2, frsRequestData)) == null) ? (i2 != 1 || this.f51194e.getEntelechyProcessor() == null) ? i2 : this.f51194e.getEntelechyProcessor().d(this.H, frsRequestData) : invokeIL.intValue;
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c.a.p0.v0.s sVar = new c.a.p0.v0.s();
            if (this.x == 0) {
                sVar.c(this.H);
            }
            if (this.f51195f.getThreadList() != null) {
                this.f51195f.getThreadList().clear();
                this.f51195f.getThreadList().add(sVar);
            }
            ArrayList<n> arrayList = this.f51196g;
            if (arrayList != null) {
                arrayList.clear();
                this.f51196g.add(sVar);
            }
        }
    }

    public void P(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f51194e.pullBeginTime = System.currentTimeMillis();
            FrsViewData frsViewData = this.f51195f;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.f51195f.getLikeFeedForumDataList().clear();
            }
            this.v = O(this.v, this.f51197h);
            FrsRequestData frsRequestData = this.f51197h;
            FrsViewData frsViewData2 = this.f51195f;
            frsRequestData.C(c.a.p0.x2.a.e(frsViewData2 == null ? null : frsViewData2.getThreadList(), true));
            if (this.v == 1) {
                M(this.f51197h, i2, !z);
                return;
            }
            if (this.y == null) {
                y0 y0Var = new y0();
                this.y = y0Var;
                y0Var.f27038c = 1;
                y0Var.f27036a = this.k;
                FrsViewData frsViewData3 = this.f51195f;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.y.f27037b = this.f51195f.getForum().getId();
                }
            }
            y0(i2);
        }
    }

    public void P0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.r = str;
        }
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.J : invokeV.intValue;
    }

    public final boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            this.S = System.currentTimeMillis();
            return this.f51198i.R();
        }
        return invokeV.booleanValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.H : invokeV.intValue;
    }

    public void R0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (frsViewData = this.f51195f) == null || frsViewData.getForum() == null || this.f51195f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f51195f.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.t = lastIds;
    }

    public f S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.L : (f) invokeV.objValue;
    }

    public final void S0(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048608, this, i2, i3, y0Var) == null) {
            this.A.put(Y(i2, i3), y0Var);
        }
    }

    public FrsRequestData T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f51197h : (FrsRequestData) invokeV.objValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? 1 == this.v : invokeV.booleanValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.x : invokeV.intValue;
    }

    public ArrayList<n> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f51196g : (ArrayList) invokeV.objValue;
    }

    public y0 X(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048613, this, i2, i3)) == null) ? this.A.get(Y(i2, i3)) : (y0) invokeII.objValue;
    }

    public final int Y(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048614, this, i2, i3)) == null) ? (i2 * 10) + i3 : invokeII.intValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? c.a.p0.v0.n2.k.d(this.H) : invokeV.intValue;
    }

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.v : invokeV.intValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            ArrayList<n> arrayList = this.f51196g;
            int i2 = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<n> it = this.f51196g.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof b2) {
                        if (((b2) next).w.p0() == 0) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public FrsViewData d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f51195f : (FrsViewData) invokeV.objValue;
    }

    public long e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.V : invokeV.longValue;
    }

    public long f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.S : invokeV.longValue;
    }

    @Override // c.a.p0.v0.o0
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.B.d();
            this.B.clear();
        }
    }

    public long g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.U : invokeV.longValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.m : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.l : invokeV.intValue;
    }

    public long h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.T : invokeV.longValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            y0 y0Var = this.y;
            if ((y0Var instanceof b1) && ((b1) y0Var).f25532e == 0) {
                return ((b1) y0Var).f25534g;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.v0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.B.f();
        }
    }

    public boolean j0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) ? this.N.get(i2, Boolean.FALSE).booleanValue() : invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        m data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048631, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.P.a(this);
        this.P.e(mvcSocketResponsedMessage);
        this.P.c(mvcSocketMessage);
        this.P.d(mvcNetMessage);
        this.P.b(this.f51199j);
        Looper.myQueue().addIdleHandler(this.P);
        f fVar = new f();
        fVar.f19899a = j.z() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        fVar.f19900b = !mvcSocketResponsedMessage.hasError();
        fVar.f19901c = mvcSocketResponsedMessage.getError();
        fVar.f19902d = mvcSocketResponsedMessage.getErrorString();
        fVar.f19903e = mvcSocketResponsedMessage.getDownSize();
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
        if (r1 == null || data == null || !F0(r1, data)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f51194e.onServerError(errorData);
        }
    }

    public void k0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bundle) == null) {
            if (bundle != null) {
                this.k = bundle.getString("name");
                this.n = bundle.getString("from");
                this.o = bundle.getInt("flag", 0);
                this.G = bundle.getString("yuelaou_locate");
                this.q = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
                this.f51194e.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
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
            n0();
            if (this.f51195f == null) {
                this.f51195f = new FrsViewData();
            }
            if (this.f51198i == null || (frsRequestData = this.f51197h) == null || frsRequestData.u() == null || this.f51197h.u().isEmpty() || this.f51197h.u().containsKey(null) || this.f51197h.u().containsValue(null)) {
                l0(bundle);
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

    public final void l0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.f51197h = frsRequestData;
            frsRequestData.setSortType(c.a.p0.v0.n2.k.d(this.H));
            if (this.H == 5) {
                this.f51197h.K(1);
            } else {
                this.f51197h.K(0);
            }
            this.f51197h.w("forum_name", c.a.e.e.p.k.getUrlEncode(this.k));
            this.f51197h.w("client_type", "2");
            this.f51197h.setPn(1);
            if (bundle != null) {
                this.f51197h.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.f51197h.I(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.f51197h.S("2");
            this.f51197h.T(StatHelper.SENSOR_ERR_2);
            this.f51197h.M(this.k);
            this.f51197h.Z(1);
            this.f51197h.E(0);
            this.f51197h.Y(l.k(TbadkCoreApplication.getInst()));
            this.f51197h.X(l.i(TbadkCoreApplication.getInst()));
            this.f51197h.W(l.h(TbadkCoreApplication.getInst()));
            this.f51197h.b0(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
            this.f51197h.V(this.r);
            this.f51197h.O(null);
            this.f51197h.a0(this.G);
            this.f51197h.N(c.a.e.e.m.b.f(c.a.o0.b1.e0.a(), 0L));
            this.f51197h.setStType(this.n);
            this.f51197h.J(1);
            this.f51197h.setNeedCache(true);
            this.f51197h.setUpdateType(3);
            FrsRequestData frsRequestData2 = this.f51197h;
            FrsViewData frsViewData = this.f51195f;
            frsRequestData2.C(c.a.p0.x2.a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            c.a.p0.v0.n2.k.e(this.H, this.f51197h);
            this.f51197h.Q(1);
            if (c2.J3.get() && y.o().b() != null) {
                int d2 = y.o().b().d(this.k, false);
                int e2 = y.o().b().e(this.k, false);
                if (this.f51197h.A() == 1) {
                    d2++;
                } else if (this.f51197h.A() == 2) {
                    e2++;
                }
                this.f51197h.U(d2);
                this.f51197h.P(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.f51197h);
            this.f51198i = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.f51194e.getActivity()).getUniqueId());
            this.f51198i.Z(this);
            this.f51198i.R();
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.D == null) {
                this.D = new ArrayList<>();
            }
            if (this.D.size() == 0) {
                this.D.add(new a0());
            }
        }
    }

    public final void n0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.s)) {
                J0(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.s)) {
                J0(6);
            } else {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                this.J = c.a.p0.v0.n2.k.h("1~" + str + this.k);
                J0(this.H);
            }
        }
    }

    public final void o0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, frsFragment) == null) {
            e0 e0Var = new e0();
            this.B = e0Var;
            e0Var.f25580e = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.B));
            this.B.g(this.R);
        }
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
    public void p(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048638, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.Q.a(this);
        this.Q.e(mvcHttpResponsedMessage);
        this.Q.c(mvcHttpMessage);
        this.Q.d(mvcNetMessage);
        this.Q.b(this.f51199j);
        Looper.myQueue().addIdleHandler(this.Q);
        f fVar = new f();
        fVar.f19899a = j.z() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        fVar.f19900b = !mvcHttpResponsedMessage.hasError();
        fVar.f19901c = mvcHttpResponsedMessage.getError();
        fVar.f19902d = mvcHttpResponsedMessage.getErrorString();
        fVar.f19903e = mvcHttpResponsedMessage.getDownSize();
        this.L = fVar;
        if (mvcHttpResponsedMessage.hasError()) {
            mVar = null;
        } else {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || mVar == null || !F0(r1, mVar)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f51194e.onServerError(errorData);
        }
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.q : invokeV.booleanValue;
    }

    @Override // c.a.p0.v0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048640, this, i2, i3, y0Var) == null) {
            this.v = O(i2, null);
            if (y0Var == null && (y0Var = X(i2, i3)) == null) {
                if (i2 != 1 && l.D() && this.C != null) {
                    b1 b1Var = new b1();
                    b1Var.f25534g = false;
                    b1Var.f27038c = 1;
                    b1Var.f27036a = this.k;
                    b1Var.f25536i = false;
                    FrsViewData frsViewData = this.f51195f;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        b1Var.f27037b = this.f51195f.getForum().getId();
                    }
                    m0();
                    this.f51195f.setThreadList(this.D);
                    this.C.a(i2, i3, b1Var, this.D);
                }
                y0Var = new y0();
                y0Var.f27038c = -1;
            }
            FrsViewData frsViewData2 = this.f51195f;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                y0Var.f27037b = this.f51195f.getForum().getId();
            }
            y0Var.f27036a = this.k;
            if (c0.a().b(1) != null && this.v == 1) {
                this.f51197h.D(i3);
            }
            this.w = i3;
            this.y = y0Var;
            S0(i2, i3, y0Var);
            y0(5);
        }
    }

    public final int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            FrsFragment frsFragment = this.f51194e;
            if (frsFragment != null) {
                int i2 = frsFragment.mHeadLineDefaultNavTabId;
                return (i2 == -1 || i2 == this.v) ? 1 : 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.H == 5 : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i2, c.a.e.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i2, aVar) == null) {
            super.registerListener(i2, aVar);
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.f51198i.Q() : invokeV.booleanValue;
    }

    @Override // c.a.p0.v0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, s0Var) == null) {
            this.C = s0Var;
            this.B.g(this.R);
        }
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            FrsRequestData frsRequestData = this.f51197h;
            return frsRequestData != null && frsRequestData.A() == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.H == 7 || (!this.f51198i.d0() && this.J == 7) : invokeV.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            if (this.v != 1) {
                y0(1);
                return true;
            } else if (this.f51198i.Q()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f51197h), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(a0());
                L(frsRequestData, 1, false);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void x0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            if (this.v != 1) {
                y0(4);
            } else if (this.f51198i.Q()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f51197h), FrsRequestData.class);
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
    public final void y0(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048652, this, i2) != null) {
            return;
        }
        this.l = i2;
        if (i2 != 1) {
            if (i2 == 2) {
                y0 y0Var = this.y;
                if (y0Var != null) {
                    y0Var.f27038c--;
                }
            } else if (i2 == 3) {
                y0 y0Var2 = this.y;
                if (y0Var2 != null) {
                    y0Var2.f27038c = -1;
                }
            }
            i3 = this.v;
            if (i3 != 1) {
                if (this.x == this.w) {
                    ArrayList<n> arrayList = new ArrayList<>();
                    ArrayList<n> arrayList2 = this.f51196g;
                    if (arrayList2 != null) {
                        arrayList.addAll(arrayList2);
                    }
                    this.f51195f.setThreadList(arrayList);
                    s0 s0Var = this.C;
                    if (s0Var != null) {
                        s0Var.a(this.v, this.w, null, arrayList);
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                }
                this.x = this.w;
                return;
            }
            o0 e2 = this.B.e(i3);
            if (e2 != null) {
                this.z = true;
                e2.q(this.v, this.w, this.y);
                return;
            }
            FrsViewData frsViewData = this.f51195f;
            if (frsViewData != null && frsViewData.getThreadList() != null) {
                this.f51195f.getThreadList().clear();
            }
            this.C.a(this.v, this.w, null, null);
            return;
        }
        y0 y0Var3 = this.y;
        if (y0Var3 != null) {
            y0Var3.f27038c++;
        }
        i3 = this.v;
        if (i3 != 1) {
        }
    }

    public final void z0(int i2, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage}) == null) && k.d().g()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.f51194e;
            this.E = currentTimeMillis - frsFragment.initTime;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.f51194e;
            frsFragment.drawTime = currentTimeMillis2 - frsFragment2.drawStartTime;
            h hVar = new h(i2, z, responsedMessage, frsFragment2.sysCreateTime, frsFragment2.createTime, frsFragment2.drawTime, false, frsFragment2.layoutTime, frsFragment2.dataParseTime, this.E);
            FrsFragment frsFragment3 = this.f51194e;
            frsFragment3.createTime = 0L;
            frsFragment3.sysCreateTime = 0L;
            c.a.p0.v0.n2.l.f(this, frsFragment3.initTime);
            this.f51194e.initTime = -1L;
            hVar.c();
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

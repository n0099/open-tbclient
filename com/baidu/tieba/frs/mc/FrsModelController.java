package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.q0.d1.f0;
import b.a.q0.d1.i0;
import b.a.q0.d1.l0;
import b.a.q0.q0.h;
import b.a.q0.q0.k;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.l3.f;
import b.a.r0.l3.m;
import b.a.r0.l3.t;
import b.a.r0.x0.a0;
import b.a.r0.x0.c0;
import b.a.r0.x0.e0;
import b.a.r0.x0.l1;
import b.a.r0.x0.o0;
import b.a.r0.x0.s;
import b.a.r0.x0.s0;
import b.a.r0.x0.y0;
import b.a.r0.z2.y;
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
/* loaded from: classes9.dex */
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
    public b.a.r0.x0.p2.n P;
    public b.a.r0.x0.p2.m Q;
    public s0 R;
    public long S;
    public long T;
    public long U;
    public long V;

    /* renamed from: e  reason: collision with root package name */
    public final FrsFragment f48902e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f48903f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f48904g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f48905h;

    /* renamed from: i  reason: collision with root package name */
    public FrsNetModel f48906i;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    public final t j;
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

    /* loaded from: classes9.dex */
    public class a implements s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f48907a;

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
            this.f48907a = frsModelController;
        }

        @Override // b.a.r0.x0.s0
        public void a(int i2, int i3, l1 l1Var, ArrayList<n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), l1Var, arrayList}) == null) {
                this.f48907a.z = false;
                if (i2 != this.f48907a.v || this.f48907a.C == null) {
                    return;
                }
                this.f48907a.y = l1Var;
                this.f48907a.S0(i2, i3, l1Var);
                ArrayList<n> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                this.f48907a.f48903f.setThreadList(arrayList2);
                this.f48907a.C.a(i2, i3, l1Var, arrayList);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48908a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f48909b;

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
            this.f48909b = frsModelController;
            this.f48908a = str;
        }

        @Override // b.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.r0.l3.e.i().c(this.f48909b.M, this.f48908a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48910a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f48911b;

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
            this.f48911b = frsModelController;
            this.f48910a = str;
        }

        @Override // b.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.r0.l3.e.i().d(this.f48911b.M, this.f48910a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48912a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsModelController f48913b;

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
            this.f48913b = frsModelController;
            this.f48912a = str;
        }

        @Override // b.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.r0.l3.e.i().b(this.f48913b.M, this.f48912a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class e extends BdAsyncTask<Object, m, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f48914a;

        /* renamed from: b  reason: collision with root package name */
        public FrsModelController f48915b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48916c;

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
            this.f48914a = null;
            this.f48914a = str;
            this.f48915b = frsModelController;
            this.f48916c = z;
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
                if (this.f48916c && b.a.r0.l3.e.i().e(this.f48914a)) {
                    if (!b.a.r0.l3.e.i().l(TbadkCoreApplication.getCurrentAccount() + this.f48914a)) {
                        b.a.r0.l3.e.i().j().getForum().getSignData().is_signed = 0;
                    }
                    m j = b.a.r0.l3.e.i().j();
                    j.setIsShowRedTip(false);
                    if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (e2 = b.a.e.e.m.b.e(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e2))) != null) {
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
        public void onProgressUpdate(m... mVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVarArr) == null) {
                super.onProgressUpdate(mVarArr);
                FrsModelController frsModelController = this.f48915b;
                if (frsModelController != null && mVarArr != null) {
                    frsModelController.E0(mVarArr.length > 0 ? mVarArr[0] : null);
                    FrsModelController frsModelController2 = this.f48915b;
                    frsModelController2.K0(frsModelController2.H, true);
                    return;
                }
                FrsModelController frsModelController3 = this.f48915b;
                if (frsModelController3 == null || frsModelController3.f48906i.c0()) {
                    return;
                }
                if (this.f48915b.f48906i.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    FrsModelController frsModelController4 = this.f48915b;
                    frsModelController4.p((MvcHttpResponsedMessage) frsModelController4.f48906i.getResponsedMessage(), (MvcHttpMessage) this.f48915b.f48906i.Z(), this.f48915b.f48906i.a0());
                }
                if (this.f48915b.f48906i.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    FrsModelController frsModelController5 = this.f48915b;
                    frsModelController5.k((MvcSocketResponsedMessage) frsModelController5.f48906i.getResponsedMessage(), (MvcSocketMessage) this.f48915b.f48906i.Z(), this.f48915b.f48906i.a0());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, t tVar) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, tVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.e.a.f) newInitContext.callArgs[0]);
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
        this.P = new b.a.r0.x0.p2.n();
        this.Q = new b.a.r0.x0.p2.m();
        this.R = new a(this);
        this.S = 0L;
        this.T = 0L;
        this.U = 0L;
        this.V = 0L;
        if (tVar != null) {
            this.f48902e = frsFragment;
            this.j = tVar;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.f48906i = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.f48902e.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.f48906i;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.f48906i.Y(this);
                }
                this.f48905h = this.f48906i.b0();
            }
            o0(this.f48902e);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public void A0(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                objArr[1] = frsRequestData != null ? frsRequestData.z() : null;
                b.a.q0.s.a0.a.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
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
            FrsFragment frsFragment = this.f48902e;
            this.E = currentTimeMillis - frsFragment.pullBeginTime;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.f48902e;
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
                objArr[1] = frsRequestData != null ? frsRequestData.z() : null;
                objArr[2] = "seq_id";
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                b.a.q0.s.a0.a.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Looper.myQueue().removeIdleHandler(this.P);
            Looper.myQueue().removeIdleHandler(this.Q);
            this.f48906i.cancelLoadData();
        }
    }

    public final void E0(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mVar) == null) {
            this.isCacheFirstLoad = false;
            this.f48903f.receiveData(mVar);
            I0(this.f48903f);
            this.f48904g = new ArrayList<>();
            if (this.f48903f.getThreadList() != null) {
                this.f48904g.addAll(this.f48903f.getThreadList());
            }
            this.j.c(mVar);
        }
    }

    public boolean F0(FrsRequestData frsRequestData, m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, frsRequestData, mVar)) == null) {
            if (mVar == null || mVar.getForum() == null || (b.a.e.e.p.k.isEmpty(mVar.getForum().getName()) && 340001 != mVar.mErrorNo)) {
                return false;
            }
            if (mVar.getDataParseTime() > 0) {
                this.f48902e.dataParseTime = mVar.getDataParseTime();
            }
            J0(b.a.r0.x0.x2.k.f(mVar.getSortType()));
            K0(b.a.r0.x0.x2.k.f(mVar.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.v = mVar.getFrsDefaultTabId();
            }
            this.f48903f.receiveData(mVar);
            I0(this.f48903f);
            this.f48904g = new ArrayList<>();
            if (frsRequestData != null) {
                this.f48905h = frsRequestData;
                this.m = frsRequestData.getPn();
                String z = this.f48905h.z();
                this.k = z;
                this.f48902e.setForumName(z);
                this.f48902e.setFrom(this.n);
                this.f48902e.setPn(this.m);
                this.f48902e.setFlag(this.o);
            }
            if (this.f48903f.getThreadList() != null) {
                this.f48904g.addAll(this.f48903f.getThreadList());
            }
            if (this.v != 1 && this.isNetFirstLoad) {
                this.j.d(7, false, this.L);
            } else {
                this.j.d(this.l, false, this.L);
            }
            this.s = null;
            if (b.a.r0.x0.s2.b.b(this.f48905h)) {
                H0();
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.f48903f.getForum()));
            }
            this.isNetFirstLoad = false;
            if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && y.o().b() != null) {
                y.o().b().g(mVar.getForum().getName(), frsRequestData.A(), false);
            }
            if (!StringUtils.isNull(mVar.getUserData().getAppealThreadPopover())) {
                this.f48902e.showFrsDeleteThreadTip(TbadkCoreApplication.getCurrentAccount(), mVar.getForum().getId(), mVar.getUserData().getAppealThreadPopover());
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void G(b.a.q0.s.q.y0 y0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, y0Var) == null) || y0Var == null || StringUtils.isNull(y0Var.f0()) || ListUtils.isEmpty(this.f48904g)) {
            return;
        }
        if (this.v == 1) {
            this.f48903f.addMyNewThread(y0Var);
        }
        int c0 = c0();
        Iterator<n> it = this.f48904g.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof c2) && y0Var.f0().equals(((c2) next).w.f0())) {
                return;
            }
        }
        this.f48904g.add(c0, y0Var);
    }

    public void G0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f48905h == null) {
            return;
        }
        this.f48902e.pullBeginTime = System.currentTimeMillis();
        FrsViewData frsViewData = this.f48903f;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.f48903f.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f48905h), FrsRequestData.class);
        frsRequestData.setPn(1);
        int O = O(this.v, frsRequestData);
        this.v = O;
        if (O == 1) {
            if (this.f48906i.Q()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            L(frsRequestData, i2, !z);
            return;
        }
        if (this.y == null) {
            y0 y0Var = new y0();
            this.y = y0Var;
            y0Var.f26789c = 1;
            y0Var.f26787a = this.k;
            FrsViewData frsViewData2 = this.f48903f;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.y.f26788b = this.f48903f.getForum().getId();
            }
        }
        y0(i2);
    }

    public final void H(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, frsRequestData) == null) && d2.N3.get() && y.o().b() != null) {
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
            FrsViewData frsViewData = this.f48903f;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(b.a.e.e.m.b.g(this.f48903f.getForum().getId(), 0L));
            }
            this.f48902e.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            l0.b(new d(this, str), null);
        }
    }

    public final void I0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, frsViewData) == null) {
            if (b.a.r0.x0.y2.h.A(frsViewData)) {
                this.p = FrsFragment.BOOK_FRS;
            } else if (frsViewData.getIsBrandForum()) {
                this.p = FrsFragment.BRAND_FRS;
            } else if (b.a.r0.x0.y2.h.B(frsViewData)) {
                this.p = FrsFragment.STAR_FRS;
            } else {
                this.p = FrsFragment.NORMAL_FRS;
            }
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            l0.b(new b(this, str), null);
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
                b.a.r0.x0.x2.k.i("1~" + str + this.k, this.H);
            }
            if (7 == i2) {
                b.a.r0.l3.p0.e.b();
            } else {
                b.a.r0.l3.p0.e.a();
            }
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            l0.b(new c(this, str), null);
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
            this.f48902e.resetTabViewControllerRefreshTab(z);
            this.j.a(i2);
            this.f48906i.d0(frsRequestData);
            frsRequestData.S(this.f48902e.isFromMainTab() ? "1" : "2");
            if (this.K) {
                frsRequestData.T(String.valueOf(b.a.r0.x0.x2.k.d(this.I)));
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
            frsRequestData.N(b.a.e.e.m.b.g(f0.a(), 0L));
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
                FrsViewData frsViewData = this.f48903f;
                frsRequestData.C(b.a.r0.z2.a.e(frsViewData != null ? frsViewData.getThreadList() : null, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.f48903f;
                frsRequestData.C(b.a.r0.z2.a.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.l);
            frsRequestData.I(this.u);
            b.a.r0.x0.x2.k.e(this.H, frsRequestData);
            int d2 = b.a.r0.x0.x2.k.d(this.J);
            N(i2, frsRequestData);
            H(this.k, frsRequestData);
            if (!j0(this.J) && !this.f48902e.createWithGame && !this.O) {
                b.a.r0.l3.e i5 = b.a.r0.l3.e.i();
                String g2 = i5.g("1~" + this.k, d2, frsRequestData.y(), this.f48905h.x());
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

    public final void M(FrsRequestData frsRequestData, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{frsRequestData, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.l = i2;
            this.f48902e.resetTabViewControllerRefreshTab(z);
            this.j.a(i2);
            if (this.f48906i.c0() && (this.f48906i.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                p((MvcHttpResponsedMessage) this.f48906i.getResponsedMessage(), (MvcHttpMessage) this.f48906i.Z(), this.f48906i.a0());
            } else if (this.f48906i.c0() && (this.f48906i.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                k((MvcSocketResponsedMessage) this.f48906i.getResponsedMessage(), (MvcSocketMessage) this.f48906i.Z(), this.f48906i.a0());
            } else {
                int d2 = b.a.r0.x0.x2.k.d(this.J);
                if (!j0(this.J) && !this.f48902e.createWithGame && !this.O) {
                    b.a.r0.l3.e i3 = b.a.r0.l3.e.i();
                    String g2 = i3.g("1~" + this.k, d2, frsRequestData.y(), this.f48905h.x());
                    this.M = g2;
                    new e(this, true, g2).execute(new Object[0]);
                }
                this.O = false;
            }
            this.f48906i.Y(this);
        }
    }

    public void M0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.O = z;
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

    public void N0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.I = i2;
        }
    }

    public final int O(int i2, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, frsRequestData)) == null) ? (i2 != 1 || this.f48902e.getEntelechyProcessor() == null) ? i2 : this.f48902e.getEntelechyProcessor().d(this.H, frsRequestData) : invokeIL.intValue;
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            s sVar = new s();
            if (this.x == 0) {
                sVar.d(this.H);
            }
            if (this.f48903f.getThreadList() != null) {
                this.f48903f.getThreadList().clear();
                this.f48903f.getThreadList().add(sVar);
            }
            ArrayList<n> arrayList = this.f48904g;
            if (arrayList != null) {
                arrayList.clear();
                this.f48904g.add(sVar);
            }
        }
    }

    public void P(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f48902e.pullBeginTime = System.currentTimeMillis();
            FrsViewData frsViewData = this.f48903f;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.f48903f.getLikeFeedForumDataList().clear();
            }
            this.v = O(this.v, this.f48905h);
            FrsRequestData frsRequestData = this.f48905h;
            FrsViewData frsViewData2 = this.f48903f;
            frsRequestData.C(b.a.r0.z2.a.e(frsViewData2 == null ? null : frsViewData2.getThreadList(), true));
            if (this.v == 1) {
                M(this.f48905h, i2, !z);
                return;
            }
            if (this.y == null) {
                y0 y0Var = new y0();
                this.y = y0Var;
                y0Var.f26789c = 1;
                y0Var.f26787a = this.k;
                FrsViewData frsViewData3 = this.f48903f;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.y.f26788b = this.f48903f.getForum().getId();
                }
            }
            y0(i2);
        }
    }

    public void P0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.r = str;
        }
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.J : invokeV.intValue;
    }

    public final boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            this.S = System.currentTimeMillis();
            return this.f48906i.loadData();
        }
        return invokeV.booleanValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.H : invokeV.intValue;
    }

    public void R0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (frsViewData = this.f48903f) == null || frsViewData.getForum() == null || this.f48903f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f48903f.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.t = lastIds;
    }

    public f S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.L : (f) invokeV.objValue;
    }

    public final void S0(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048607, this, i2, i3, y0Var) == null) {
            this.A.put(Y(i2, i3), y0Var);
        }
    }

    public FrsRequestData T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f48905h : (FrsRequestData) invokeV.objValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? 1 == this.v : invokeV.booleanValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.x : invokeV.intValue;
    }

    public ArrayList<n> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f48904g : (ArrayList) invokeV.objValue;
    }

    public y0 X(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048612, this, i2, i3)) == null) ? this.A.get(Y(i2, i3)) : (y0) invokeII.objValue;
    }

    public final int Y(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048613, this, i2, i3)) == null) ? (i2 * 10) + i3 : invokeII.intValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? b.a.r0.x0.x2.k.d(this.H) : invokeV.intValue;
    }

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.v : invokeV.intValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            ArrayList<n> arrayList = this.f48904g;
            int i2 = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<n> it = this.f48904g.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof c2) {
                        if (((c2) next).w.r0() == 0) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public FrsViewData d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f48903f : (FrsViewData) invokeV.objValue;
    }

    public long e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.V : invokeV.longValue;
    }

    public long f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.S : invokeV.longValue;
    }

    @Override // b.a.r0.x0.o0
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.B.b();
            this.B.clear();
        }
    }

    public long g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.U : invokeV.longValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.m : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.l : invokeV.intValue;
    }

    public long h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.T : invokeV.longValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            y0 y0Var = this.y;
            if ((y0Var instanceof l1) && ((l1) y0Var).f25911e == 0) {
                return ((l1) y0Var).f25913g;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.x0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.B.e();
        }
    }

    public boolean j0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) ? this.N.get(i2, Boolean.FALSE).booleanValue() : invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        m data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048630, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.P.a(this);
        this.P.e(mvcSocketResponsedMessage);
        this.P.c(mvcSocketMessage);
        this.P.d(mvcNetMessage);
        this.P.b(this.j);
        Looper.myQueue().addIdleHandler(this.P);
        f fVar = new f();
        fVar.f20550a = j.z() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        fVar.f20551b = !mvcSocketResponsedMessage.hasError();
        fVar.f20552c = mvcSocketResponsedMessage.getError();
        fVar.f20553d = mvcSocketResponsedMessage.getErrorString();
        fVar.f20554e = mvcSocketResponsedMessage.getDownSize();
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
            this.f48902e.onServerError(errorData);
        }
    }

    public void k0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bundle) == null) {
            if (bundle != null) {
                this.k = bundle.getString("name");
                this.n = bundle.getString("from");
                this.o = bundle.getInt("flag", 0);
                this.G = bundle.getString("yuelaou_locate");
                this.q = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
                this.f48902e.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
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
            if (this.f48903f == null) {
                this.f48903f = new FrsViewData();
            }
            if (this.f48906i == null || (frsRequestData = this.f48905h) == null || frsRequestData.u() == null || this.f48905h.u().isEmpty() || this.f48905h.u().containsKey(null) || this.f48905h.u().containsValue(null)) {
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
        if (interceptable == null || interceptable.invokeL(1048632, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.f48905h = frsRequestData;
            frsRequestData.setSortType(b.a.r0.x0.x2.k.d(this.H));
            if (this.H == 5) {
                this.f48905h.K(1);
            } else {
                this.f48905h.K(0);
            }
            this.f48905h.w("forum_name", b.a.e.e.p.k.getUrlEncode(this.k));
            this.f48905h.w("client_type", "2");
            this.f48905h.setPn(1);
            if (bundle != null) {
                this.f48905h.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.f48905h.I(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.f48905h.S("2");
            this.f48905h.T(StatHelper.SENSOR_ERR_2);
            this.f48905h.M(this.k);
            this.f48905h.Z(1);
            this.f48905h.E(0);
            this.f48905h.Y(l.k(TbadkCoreApplication.getInst()));
            this.f48905h.X(l.i(TbadkCoreApplication.getInst()));
            this.f48905h.W(l.h(TbadkCoreApplication.getInst()));
            this.f48905h.b0(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
            this.f48905h.V(this.r);
            this.f48905h.O(null);
            this.f48905h.a0(this.G);
            this.f48905h.N(b.a.e.e.m.b.g(f0.a(), 0L));
            this.f48905h.setStType(this.n);
            this.f48905h.J(1);
            this.f48905h.setNeedCache(true);
            this.f48905h.setUpdateType(3);
            FrsRequestData frsRequestData2 = this.f48905h;
            FrsViewData frsViewData = this.f48903f;
            frsRequestData2.C(b.a.r0.z2.a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            b.a.r0.x0.x2.k.e(this.H, this.f48905h);
            this.f48905h.Q(1);
            if (d2.N3.get() && y.o().b() != null) {
                int d2 = y.o().b().d(this.k, false);
                int e2 = y.o().b().e(this.k, false);
                if (this.f48905h.A() == 1) {
                    d2++;
                } else if (this.f48905h.A() == 2) {
                    e2++;
                }
                this.f48905h.U(d2);
                this.f48905h.P(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.f48905h);
            this.f48906i = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.f48902e.getActivity()).getUniqueId());
            this.f48906i.Y(this);
            this.f48906i.loadData();
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
                this.J = b.a.r0.x0.x2.k.h("1~" + str + this.k);
                J0(this.H);
            }
        }
    }

    public final void o0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, frsFragment) == null) {
            e0 e0Var = new e0();
            this.B = e0Var;
            e0Var.f25687e = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.B));
            this.B.f(this.R);
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
        this.Q.b(this.j);
        Looper.myQueue().addIdleHandler(this.Q);
        f fVar = new f();
        fVar.f20550a = j.z() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        fVar.f20551b = !mvcHttpResponsedMessage.hasError();
        fVar.f20552c = mvcHttpResponsedMessage.getError();
        fVar.f20553d = mvcHttpResponsedMessage.getErrorString();
        fVar.f20554e = mvcHttpResponsedMessage.getDownSize();
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
            this.f48902e.onServerError(errorData);
        }
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.q : invokeV.booleanValue;
    }

    @Override // b.a.r0.x0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048640, this, i2, i3, y0Var) == null) {
            this.v = O(i2, null);
            if (y0Var == null && (y0Var = X(i2, i3)) == null) {
                if (i2 != 1 && l.D() && this.C != null) {
                    l1 l1Var = new l1();
                    l1Var.f25913g = false;
                    l1Var.f26789c = 1;
                    l1Var.f26787a = this.k;
                    l1Var.f25915i = false;
                    FrsViewData frsViewData = this.f48903f;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        l1Var.f26788b = this.f48903f.getForum().getId();
                    }
                    m0();
                    this.f48903f.setThreadList(this.D);
                    this.C.a(i2, i3, l1Var, this.D);
                }
                y0Var = new y0();
                y0Var.f26789c = -1;
            }
            FrsViewData frsViewData2 = this.f48903f;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                y0Var.f26788b = this.f48903f.getForum().getId();
            }
            y0Var.f26787a = this.k;
            if (c0.a().b(1) != null && this.v == 1) {
                this.f48905h.D(i3);
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
            FrsFragment frsFragment = this.f48902e;
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
    public void registerListener(int i2, b.a.e.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i2, aVar) == null) {
            super.registerListener(i2, aVar);
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.f48906i.Q() : invokeV.booleanValue;
    }

    @Override // b.a.r0.x0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, s0Var) == null) {
            this.C = s0Var;
            this.B.f(this.R);
        }
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            FrsRequestData frsRequestData = this.f48905h;
            return frsRequestData != null && frsRequestData.A() == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.H == 7 || (!this.f48906i.c0() && this.J == 7) : invokeV.booleanValue;
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
            } else if (this.f48906i.Q()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f48905h), FrsRequestData.class);
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
            } else if (this.f48906i.Q()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f48905h), FrsRequestData.class);
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
                    y0Var.f26789c--;
                }
            } else if (i2 == 3) {
                y0 y0Var2 = this.y;
                if (y0Var2 != null) {
                    y0Var2.f26789c = -1;
                }
            }
            i3 = this.v;
            if (i3 != 1) {
                if (this.x == this.w) {
                    ArrayList<n> arrayList = new ArrayList<>();
                    ArrayList<n> arrayList2 = this.f48904g;
                    if (arrayList2 != null) {
                        arrayList.addAll(arrayList2);
                    }
                    this.f48903f.setThreadList(arrayList);
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
            o0 c2 = this.B.c(i3);
            if (c2 != null) {
                this.z = true;
                c2.q(this.v, this.w, this.y);
                return;
            }
            FrsViewData frsViewData = this.f48903f;
            if (frsViewData != null && frsViewData.getThreadList() != null) {
                this.f48903f.getThreadList().clear();
            }
            this.C.a(this.v, this.w, null, null);
            return;
        }
        y0 y0Var3 = this.y;
        if (y0Var3 != null) {
            y0Var3.f26789c++;
        }
        i3 = this.v;
        if (i3 != 1) {
        }
    }

    public final void z0(int i2, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage}) == null) && k.d().g()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.f48902e;
            this.E = currentTimeMillis - frsFragment.initTime;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.f48902e;
            frsFragment.drawTime = currentTimeMillis2 - frsFragment2.drawStartTime;
            h hVar = new h(i2, z, responsedMessage, frsFragment2.sysCreateTime, frsFragment2.createTime, frsFragment2.drawTime, false, frsFragment2.layoutTime, frsFragment2.dataParseTime, this.E);
            FrsFragment frsFragment3 = this.f48902e;
            frsFragment3.createTime = 0L;
            frsFragment3.sysCreateTime = 0L;
            b.a.r0.x0.x2.l.f(this, frsFragment3.initTime);
            this.f48902e.initTime = -1L;
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

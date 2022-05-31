package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
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
import com.repackage.a85;
import com.repackage.ac6;
import com.repackage.b9;
import com.repackage.ei8;
import com.repackage.gf8;
import com.repackage.hf8;
import com.repackage.im6;
import com.repackage.jc5;
import com.repackage.jg;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.jo6;
import com.repackage.kc6;
import com.repackage.ki;
import com.repackage.li;
import com.repackage.mc5;
import com.repackage.mo4;
import com.repackage.mp6;
import com.repackage.nb6;
import com.repackage.ns4;
import com.repackage.oc6;
import com.repackage.pc5;
import com.repackage.pf8;
import com.repackage.q78;
import com.repackage.rp4;
import com.repackage.s98;
import com.repackage.tk6;
import com.repackage.u68;
import com.repackage.uc6;
import com.repackage.uk6;
import com.repackage.wa;
import com.repackage.wb6;
import com.repackage.wf8;
import com.repackage.xn6;
import com.repackage.yb6;
import com.repackage.yc6;
import com.repackage.yn6;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements kc6, NetModel.k<FrsRequestData, pf8> {
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
    public hf8 H;
    public String I;
    public final SparseArray<Boolean> J;
    public boolean K;
    public uk6 L;
    public tk6 M;
    public oc6 N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public final FrsFragment a;
    public FrsViewData b;
    public ArrayList<jn> c;
    public FrsRequestData d;
    public FrsNetModel e;
    public final wf8 f;
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
    public uc6 u;
    public boolean v;
    public SparseArray<uc6> w;
    public ac6 x;
    public oc6 y;
    public ArrayList<jn> z;

    /* loaded from: classes3.dex */
    public class a implements oc6 {
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

        @Override // com.repackage.oc6
        public void a(int i, int i2, yc6 yc6Var, ArrayList<jn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), yc6Var, arrayList}) == null) {
                this.a.v = false;
                if (i != this.a.r || this.a.y == null) {
                    return;
                }
                this.a.u = yc6Var;
                this.a.V0(i, i2, yc6Var);
                ArrayList<jn> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                this.a.b.setThreadList(arrayList2);
                this.a.y.a(i, i2, yc6Var, arrayList);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends mc5<Object> {
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

        @Override // com.repackage.mc5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                gf8.i().c(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends mc5<Object> {
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

        @Override // com.repackage.mc5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                gf8.i().d(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends mc5<Object> {
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

        @Override // com.repackage.mc5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                gf8.i().b(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends BdAsyncTask<Object, pf8, Void> {
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
                if (this.c && gf8.i().e(this.a)) {
                    if (!gf8.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        gf8.i().j().getForum().getSignData().is_signed = 0;
                    }
                    pf8 j = gf8.i().j();
                    j.setIsShowRedTip(false);
                    if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (e = jg.e(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e))) != null) {
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
        public void onProgressUpdate(pf8... pf8VarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pf8VarArr) == null) {
                super.onProgressUpdate(pf8VarArr);
                FrsModelController frsModelController = this.b;
                if (frsModelController != null && pf8VarArr != null) {
                    frsModelController.F0(pf8VarArr.length > 0 ? pf8VarArr[0] : null);
                    FrsModelController frsModelController2 = this.b;
                    frsModelController2.N0(frsModelController2.D, true);
                    return;
                }
                FrsModelController frsModelController3 = this.b;
                if (frsModelController3 == null || frsModelController3.e.e0()) {
                    return;
                }
                if (this.b.e.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    FrsModelController frsModelController4 = this.b;
                    frsModelController4.r((MvcHttpResponsedMessage) frsModelController4.e.getResponsedMessage(), (MvcHttpMessage) this.b.e.b0(), this.b.e.c0());
                }
                if (this.b.e.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    FrsModelController frsModelController5 = this.b;
                    frsModelController5.m((MvcSocketResponsedMessage) frsModelController5.e.getResponsedMessage(), (MvcSocketMessage) this.b.e.b0(), this.b.e.c0());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, wf8 wf8Var) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, wf8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
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
        this.L = new uk6();
        this.M = new tk6();
        this.N = new a(this);
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        if (wf8Var != null) {
            this.a = frsFragment;
            this.f = wf8Var;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.e = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.a.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.e;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.e.a0(this);
                }
                this.d = this.e.d0();
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
            a85 a85Var = new a85(i, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
            FrsFragment frsFragment3 = this.a;
            frsFragment3.F = 0L;
            frsFragment3.E = 0L;
            yn6.f(this, frsFragment3.B);
            this.a.B = -1L;
            a85Var.c();
        }
    }

    public void B0(MvcHttpResponsedMessage<pf8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, pf8> mvcHttpMessage, MvcNetMessage<FrsRequestData, pf8> mvcNetMessage) {
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
                objArr[1] = frsRequestData != null ? frsRequestData.C() : null;
                ns4.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
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
            a85 a85Var = new a85(1000, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
            int i = this.h;
            if (i == 4) {
                a85Var.B = this.A;
                a85Var.e(true);
            } else if (i == 3) {
                a85Var.C = this.A;
                a85Var.e(false);
            }
        }
    }

    public void D0(MvcSocketResponsedMessage<pf8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, pf8> mvcSocketMessage, MvcNetMessage<FrsRequestData, pf8> mvcNetMessage) {
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
                objArr[1] = frsRequestData != null ? frsRequestData.C() : null;
                objArr[2] = "seq_id";
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                ns4.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.e.cancelLoadData();
        }
    }

    public final void F0(pf8 pf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pf8Var) == null) {
            this.isCacheFirstLoad = false;
            this.b.receiveData(pf8Var);
            K0(this.b);
            this.c = new ArrayList<>();
            if (this.b.getThreadList() != null) {
                this.c.addAll(this.b.getThreadList());
            }
            this.f.c(pf8Var);
        }
    }

    public void G0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            bundle.putString("name", this.g);
            bundle.putString("from", this.j);
            bundle.putInt("flag", this.k);
        }
    }

    public boolean H0(FrsRequestData frsRequestData, pf8 pf8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, frsRequestData, pf8Var)) == null) {
            if (pf8Var == null || pf8Var.getForum() == null || (ki.isEmpty(pf8Var.getForum().getName()) && 340001 != pf8Var.mErrorNo)) {
                return false;
            }
            if (pf8Var.getDataParseTime() > 0) {
                this.a.H = pf8Var.getDataParseTime();
            }
            M0(xn6.f(pf8Var.getSortType()));
            N0(xn6.f(pf8Var.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.r = pf8Var.getFrsDefaultTabId();
            }
            this.b.receiveData(pf8Var);
            K0(this.b);
            this.c = new ArrayList<>();
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.i = frsRequestData.getPn();
                String C = this.d.C();
                this.g = C;
                this.a.C3(C);
                this.a.setFrom(this.j);
                this.a.M3(this.i);
                this.a.B3(this.k);
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
            if (im6.b(this.d)) {
                J0();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.T2();
                }
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.b.getForum()));
            }
            this.isNetFirstLoad = false;
            if (pf8Var.getForum() != null && !TextUtils.isEmpty(pf8Var.getForum().getName()) && frsRequestData != null && q78.l().b() != null) {
                q78.l().b().g(pf8Var.getForum().getName(), frsRequestData.D(), false);
            }
            if (!StringUtils.isNull(pf8Var.getUserData().getAppealThreadPopover())) {
                this.a.Z3(TbadkCoreApplication.getCurrentAccount(), pf8Var.getForum().getId(), pf8Var.getUserData().getAppealThreadPopover());
            }
            L0(pf8Var);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void I(mo4 mo4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mo4Var) == null) || mo4Var == null || StringUtils.isNull(mo4Var.getId()) || ListUtils.isEmpty(this.c)) {
            return;
        }
        if (this.r == 1) {
            this.b.addMyNewThread(mo4Var);
        }
        int e0 = e0();
        Iterator<jn> it = this.c.iterator();
        while (it.hasNext()) {
            jn next = it.next();
            if ((next instanceof rp4) && mo4Var.getId().equals(((rp4) next).s.getId())) {
                return;
            }
        }
        this.c.add(e0, mo4Var);
    }

    public void I0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || this.d == null) {
            return;
        }
        this.a.I = System.currentTimeMillis();
        FrsViewData frsViewData = this.b;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.b.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(1);
        int Q = Q(this.r, frsRequestData);
        this.r = Q;
        if (Q == 1) {
            if (this.e.S()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            N(frsRequestData, i, !z);
            return;
        }
        if (this.u == null) {
            uc6 uc6Var = new uc6();
            this.u = uc6Var;
            uc6Var.c = 1;
            uc6Var.a = this.g;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.u.b = this.b.getForum().getId();
            }
        }
        z0(i);
    }

    public final void J(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, frsRequestData) == null) && ThreadData.isRecAppLoaded.get() && q78.l().b() != null) {
            int d2 = q78.l().b().d(str, false);
            int e2 = q78.l().b().e(str, false);
            if (frsRequestData.D() == 1) {
                d2++;
            } else if (frsRequestData.D() == 2) {
                e2++;
            }
            frsRequestData.X(d2);
            frsRequestData.S(e2);
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(jg.g(this.b.getForum().getId(), 0L));
            }
            this.a.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            pc5.b(new d(this, str), null);
        }
    }

    public final void K0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) {
            if (jo6.F(frsViewData)) {
                this.l = "book_page";
            } else if (frsViewData.getIsBrandForum()) {
                this.l = "brand_page";
            } else if (jo6.G(frsViewData)) {
                this.l = "frs_page";
            } else {
                this.l = "normal_page";
            }
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            pc5.b(new b(this, str), null);
        }
    }

    public final void L0(pf8 pf8Var) {
        FrsFragment frsFragment;
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, pf8Var) == null) || pf8Var == null || (frsFragment = this.a) == null || frsFragment.getActivity() == null || (intent = this.a.getActivity().getIntent()) == null) {
            return;
        }
        s98.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), pf8Var.getForum().getId());
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            pc5.b(new c(this, str), null);
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
                xn6.i("1~" + str + this.g, this.D);
            }
            if (7 == i) {
                ei8.b();
            } else {
                ei8.a();
            }
        }
    }

    public final void N(FrsRequestData frsRequestData, int i, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.y3(z);
            this.f.a(i);
            this.e.f0(frsRequestData);
            frsRequestData.V(this.a.a3() ? "1" : "2");
            if (this.G) {
                frsRequestData.W(String.valueOf(xn6.d(this.E)));
            } else {
                frsRequestData.W("-2");
            }
            this.G = false;
            frsRequestData.P(this.g);
            frsRequestData.c0(1);
            frsRequestData.H(0);
            int k = li.k(TbadkCoreApplication.getInst());
            int i2 = li.i(TbadkCoreApplication.getInst());
            float h = li.h(TbadkCoreApplication.getInst());
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            frsRequestData.b0(k);
            frsRequestData.a0(i2);
            frsRequestData.Z(h);
            frsRequestData.e0(i3);
            frsRequestData.Y(this.n);
            frsRequestData.R(this.p);
            frsRequestData.d0(this.C);
            frsRequestData.Q(jg.g(jc5.a(), 0L));
            String str = this.o;
            if (str != null) {
                frsRequestData.setStType(str);
                if ("sidebar".equalsIgnoreCase(this.o)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.M(r0());
            if (FrsFragment.g2 != 0) {
                frsRequestData.I((int) FrsFragment.g2);
            }
            if (FrsFragment.h2 != 0) {
                frsRequestData.J((int) FrsFragment.h2);
            }
            if (FrsFragment.i2 != 0) {
                frsRequestData.U(FrsFragment.i2);
            }
            if (frsRequestData.getPn() != 1 && this.h != 3) {
                FrsViewData frsViewData = this.b;
                frsRequestData.F(u68.e(frsViewData != null ? frsViewData.getThreadList() : null, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.b;
                frsRequestData.F(u68.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.h);
            frsRequestData.L(this.q);
            xn6.e(this.D, frsRequestData);
            int d2 = xn6.d(this.F);
            P(i, frsRequestData);
            J(this.g, frsRequestData);
            if (!k0(this.F) && !this.a.i && !this.K) {
                gf8 i4 = gf8.i();
                String g = i4.g("1~" + this.g, d2, frsRequestData.B(), this.d.z());
                this.I = g;
                new e(this, true, g).execute(new Object[0]);
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
            this.h = i;
            this.a.y3(z);
            this.f.a(i);
            if (this.e.e0() && (this.e.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                r((MvcHttpResponsedMessage) this.e.getResponsedMessage(), (MvcHttpMessage) this.e.b0(), this.e.c0());
            } else if (this.e.e0() && (this.e.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                m((MvcSocketResponsedMessage) this.e.getResponsedMessage(), (MvcSocketMessage) this.e.b0(), this.e.c0());
            } else {
                int d2 = xn6.d(this.F);
                if (!k0(this.F) && !this.a.i && !this.K) {
                    gf8 i2 = gf8.i();
                    String g = i2.g("1~" + this.g, d2, frsRequestData.B(), this.d.z());
                    this.I = g;
                    new e(this, true, g).execute(new Object[0]);
                }
                this.K = false;
            }
            this.e.a0(this);
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
            frsRequestData.T(1);
        } else if (i != 4) {
        } else {
            frsRequestData.T(2);
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
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.b.getLikeFeedForumDataList().clear();
            }
            this.r = Q(this.r, this.d);
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData2 = this.b;
            frsRequestData.F(u68.e(frsViewData2 == null ? null : frsViewData2.getThreadList(), true));
            if (this.r == 1) {
                O(this.d, i, !z);
                return;
            }
            if (this.u == null) {
                uc6 uc6Var = new uc6();
                this.u = uc6Var;
                uc6Var.c = 1;
                uc6Var.a = this.g;
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.u.b = this.b.getForum().getId();
                }
            }
            z0(i);
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            nb6 nb6Var = new nb6();
            if (this.t == 0) {
                nb6Var.b(this.D);
            }
            if (this.b.getThreadList() != null) {
                this.b.getThreadList().clear();
                this.b.getThreadList().add(nb6Var);
            }
            ArrayList<jn> arrayList = this.c;
            if (arrayList != null) {
                arrayList.clear();
                this.c.add(nb6Var);
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
            mp6.a();
            return this.e.loadData();
        }
        return invokeV.booleanValue;
    }

    public hf8 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.H : (hf8) invokeV.objValue;
    }

    public void U0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    public FrsRequestData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.d : (FrsRequestData) invokeV.objValue;
    }

    public final void V0(int i, int i2, uc6 uc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i, i2, uc6Var) == null) {
            this.w.put(a0(i, i2), uc6Var);
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

    public ArrayList<jn> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.c : (ArrayList) invokeV.objValue;
    }

    public uc6 Z(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048615, this, i, i2)) == null) ? this.w.get(a0(i, i2)) : (uc6) invokeII.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? xn6.d(this.D) : invokeV.intValue;
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
            ArrayList<jn> arrayList = this.c;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<jn> it = this.c.iterator();
                while (it.hasNext()) {
                    jn next = it.next();
                    if (next instanceof rp4) {
                        if (((rp4) next).s.getIs_top() == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.b : (FrsViewData) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.h : invokeV.intValue;
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
            uc6 uc6Var = this.u;
            if ((uc6Var instanceof yc6) && ((yc6) uc6Var).e == 0) {
                return ((yc6) uc6Var).g;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.kc6
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

    @Override // com.repackage.kc6
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
            o0();
            if (this.b == null) {
                this.b = new FrsViewData();
            }
            if (this.e == null || (frsRequestData = this.d) == null || frsRequestData.w() == null || this.d.w().isEmpty() || this.d.w().containsKey(null) || this.d.w().containsValue(null)) {
                m0(bundle);
            }
            String str = this.g;
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
    public void m(MvcSocketResponsedMessage<pf8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, pf8> mvcSocketMessage, MvcNetMessage<FrsRequestData, pf8> mvcNetMessage) {
        pf8 data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048635, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.L.a(this);
        this.L.e(mvcSocketResponsedMessage);
        this.L.c(mvcSocketMessage);
        this.L.d(mvcNetMessage);
        this.L.b(this.f);
        Looper.myQueue().addIdleHandler(this.L);
        hf8 hf8Var = new hf8();
        hf8Var.a = ji.z() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        hf8Var.b = !mvcSocketResponsedMessage.hasError();
        hf8Var.c = mvcSocketResponsedMessage.getError();
        hf8Var.d = mvcSocketResponsedMessage.getErrorString();
        hf8Var.e = mvcSocketResponsedMessage.getDownSize();
        this.H = hf8Var;
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
            this.d = frsRequestData;
            frsRequestData.setSortType(xn6.d(this.D));
            if (this.D == 5) {
                this.d.N(1);
            } else {
                this.d.N(0);
            }
            this.d.y("forum_name", ki.getUrlEncode(this.g));
            this.d.y("client_type", "2");
            this.d.setPn(1);
            if (bundle != null) {
                this.d.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.d.L(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.d.V("2");
            this.d.W("-2");
            this.d.P(this.g);
            this.d.c0(1);
            this.d.H(0);
            this.d.b0(li.k(TbadkCoreApplication.getInst()));
            this.d.a0(li.i(TbadkCoreApplication.getInst()));
            this.d.Z(li.h(TbadkCoreApplication.getInst()));
            this.d.e0(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
            this.d.Y(this.n);
            this.d.R(null);
            this.d.d0(this.C);
            this.d.Q(jg.g(jc5.a(), 0L));
            this.d.setStType(this.j);
            this.d.M(1);
            this.d.setNeedCache(true);
            this.d.setUpdateType(3);
            FrsRequestData frsRequestData2 = this.d;
            FrsViewData frsViewData = this.b;
            frsRequestData2.F(u68.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            xn6.e(this.D, this.d);
            this.d.T(1);
            if (ThreadData.isRecAppLoaded.get() && q78.l().b() != null) {
                int d2 = q78.l().b().d(this.g, false);
                int e2 = q78.l().b().e(this.g, false);
                if (this.d.D() == 1) {
                    d2++;
                } else if (this.d.D() == 2) {
                    e2++;
                }
                this.d.X(d2);
                this.d.S(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.d);
            this.e = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.a.getActivity()).getUniqueId());
            this.e.a0(this);
            this.e.loadData();
            mp6.a();
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.z.size() == 0) {
                this.z.add(new wb6());
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
                this.F = xn6.h("1~" + str + this.g);
                M0(this.D);
            }
        }
    }

    public final void p0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, frsFragment) == null) {
            ac6 ac6Var = new ac6();
            this.x = ac6Var;
            ac6Var.a = frsFragment.getUniqueId();
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
    public void r(MvcHttpResponsedMessage<pf8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, pf8> mvcHttpMessage, MvcNetMessage<FrsRequestData, pf8> mvcNetMessage) {
        pf8 pf8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048641, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.M.a(this);
        this.M.e(mvcHttpResponsedMessage);
        this.M.c(mvcHttpMessage);
        this.M.d(mvcNetMessage);
        this.M.b(this.f);
        Looper.myQueue().addIdleHandler(this.M);
        hf8 hf8Var = new hf8();
        hf8Var.a = ji.z() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        hf8Var.b = !mvcHttpResponsedMessage.hasError();
        hf8Var.c = mvcHttpResponsedMessage.getError();
        hf8Var.d = mvcHttpResponsedMessage.getErrorString();
        hf8Var.e = mvcHttpResponsedMessage.getDownSize();
        this.H = hf8Var;
        if (mvcHttpResponsedMessage.hasError()) {
            pf8Var = null;
        } else {
            pf8Var = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || pf8Var == null || !H0(r1, pf8Var)) {
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
    public void registerListener(int i, wa waVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i, waVar) == null) {
            super.registerListener(i, waVar);
        }
    }

    @Override // com.repackage.kc6
    public void s(int i, int i2, uc6 uc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048645, this, i, i2, uc6Var) == null) {
            this.r = Q(i, null);
            if (uc6Var == null && (uc6Var = Z(i, i2)) == null) {
                if (i != 1 && li.D() && this.y != null) {
                    yc6 yc6Var = new yc6();
                    yc6Var.g = false;
                    yc6Var.c = 1;
                    yc6Var.a = this.g;
                    yc6Var.i = false;
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        yc6Var.b = this.b.getForum().getId();
                    }
                    n0();
                    this.b.setThreadList(this.z);
                    this.y.a(i, i2, yc6Var, this.z);
                }
                uc6Var = new uc6();
                uc6Var.c = -1;
            }
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                uc6Var.b = this.b.getForum().getId();
            }
            uc6Var.a = this.g;
            if (yb6.a().b(1) != null && this.r == 1) {
                this.d.G(i2);
            }
            this.s = i2;
            this.u = uc6Var;
            V0(i, i2, uc6Var);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.e.S() : invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            FrsRequestData frsRequestData = this.d;
            return frsRequestData != null && frsRequestData.D() == 1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.kc6
    public void v(oc6 oc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, oc6Var) == null) {
            this.y = oc6Var;
            this.x.e(this.N);
        }
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.D == 7 || (!this.e.e0() && this.F == 7) : invokeV.booleanValue;
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
            } else if (this.e.S()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
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
            } else if (this.e.S()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
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
        this.h = i;
        if (i != 1) {
            if (i == 2) {
                uc6 uc6Var = this.u;
                if (uc6Var != null) {
                    uc6Var.c--;
                }
            } else if (i == 3) {
                uc6 uc6Var2 = this.u;
                if (uc6Var2 != null) {
                    uc6Var2.c = -1;
                }
            }
            i2 = this.r;
            if (i2 != 1) {
                if (this.t == this.s) {
                    ArrayList<jn> arrayList = new ArrayList<>();
                    ArrayList<jn> arrayList2 = this.c;
                    if (arrayList2 != null) {
                        arrayList.addAll(arrayList2);
                    }
                    this.b.setThreadList(arrayList);
                    oc6 oc6Var = this.y;
                    if (oc6Var != null) {
                        oc6Var.a(this.r, this.s, null, arrayList);
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                }
                this.t = this.s;
                return;
            }
            kc6 c2 = this.x.c(i2);
            if (c2 != null) {
                this.v = true;
                c2.s(this.r, this.s, this.u);
                return;
            }
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getThreadList() != null) {
                this.b.getThreadList().clear();
            }
            this.y.a(this.r, this.s, null, null);
            return;
        }
        uc6 uc6Var3 = this.u;
        if (uc6Var3 != null) {
            uc6Var3.c++;
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

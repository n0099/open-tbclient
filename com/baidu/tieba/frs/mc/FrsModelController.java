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
import com.repackage.ae5;
import com.repackage.aq6;
import com.repackage.br6;
import com.repackage.d9;
import com.repackage.de5;
import com.repackage.dh8;
import com.repackage.he5;
import com.repackage.he6;
import com.repackage.kd6;
import com.repackage.kh8;
import com.repackage.le6;
import com.repackage.lp4;
import com.repackage.mt4;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.oi;
import com.repackage.op6;
import com.repackage.p95;
import com.repackage.pi;
import com.repackage.pp6;
import com.repackage.qq4;
import com.repackage.re6;
import com.repackage.s98;
import com.repackage.sj8;
import com.repackage.td6;
import com.repackage.tm6;
import com.repackage.ub8;
import com.repackage.ug8;
import com.repackage.um6;
import com.repackage.vd6;
import com.repackage.ve6;
import com.repackage.vg8;
import com.repackage.w88;
import com.repackage.xd6;
import com.repackage.za;
import com.repackage.zn6;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements he6, NetModel.k<FrsRequestData, dh8> {
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
    public vg8 H;
    public String I;
    public final SparseArray<Boolean> J;
    public boolean K;
    public um6 L;
    public tm6 M;
    public le6 N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public final FrsFragment a;
    public FrsViewData b;
    public ArrayList<nn> c;
    public FrsRequestData d;
    public FrsNetModel e;
    public final kh8 f;
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
    public re6 u;
    public boolean v;
    public SparseArray<re6> w;
    public xd6 x;
    public le6 y;
    public ArrayList<nn> z;

    /* loaded from: classes3.dex */
    public class a implements le6 {
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

        @Override // com.repackage.le6
        public void a(int i, int i2, ve6 ve6Var, ArrayList<nn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ve6Var, arrayList}) == null) {
                this.a.v = false;
                if (i != this.a.r || this.a.y == null) {
                    return;
                }
                this.a.u = ve6Var;
                this.a.X0(i, i2, ve6Var);
                ArrayList<nn> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                this.a.b.setThreadList(arrayList2);
                this.a.y.a(i, i2, ve6Var, arrayList);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends de5<Object> {
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

        @Override // com.repackage.de5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ug8.i().c(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends de5<Object> {
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

        @Override // com.repackage.de5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ug8.i().d(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends de5<Object> {
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

        @Override // com.repackage.de5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ug8.i().b(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends BdAsyncTask<Object, dh8, Void> {
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
                if (this.c && ug8.i().e(this.a)) {
                    if (!ug8.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        ug8.i().j().getForum().getSignData().is_signed = 0;
                    }
                    dh8 j = ug8.i().j();
                    j.setIsShowRedTip(false);
                    if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (e = ng.e(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e))) != null) {
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
        public void onProgressUpdate(dh8... dh8VarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dh8VarArr) == null) {
                super.onProgressUpdate(dh8VarArr);
                FrsModelController frsModelController = this.b;
                if (frsModelController != null && dh8VarArr != null) {
                    frsModelController.H0(dh8VarArr.length > 0 ? dh8VarArr[0] : null);
                    FrsModelController frsModelController2 = this.b;
                    frsModelController2.P0(frsModelController2.D, true);
                    return;
                }
                FrsModelController frsModelController3 = this.b;
                if (frsModelController3 == null || frsModelController3.e.g0()) {
                    return;
                }
                if (this.b.e.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    FrsModelController frsModelController4 = this.b;
                    frsModelController4.t((MvcHttpResponsedMessage) frsModelController4.e.getResponsedMessage(), (MvcHttpMessage) this.b.e.d0(), this.b.e.e0());
                }
                if (this.b.e.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    FrsModelController frsModelController5 = this.b;
                    frsModelController5.o((MvcSocketResponsedMessage) frsModelController5.e.getResponsedMessage(), (MvcSocketMessage) this.b.e.d0(), this.b.e.e0());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, kh8 kh8Var) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, kh8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
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
        this.L = new um6();
        this.M = new tm6();
        this.N = new a(this);
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        if (kh8Var != null) {
            this.a = frsFragment;
            this.f = kh8Var;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.e = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.a.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.e;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.e.c0(this);
                }
                this.d = this.e.f0();
            }
            r0(this.a);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public void A0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (this.r != 1) {
                B0(4);
            } else if (this.e.U()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(i);
                frsRequestData.setSortType(e0());
                P(frsRequestData, 4, false);
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
    public final void B0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) {
            return;
        }
        this.h = i;
        if (i != 1) {
            if (i == 2) {
                re6 re6Var = this.u;
                if (re6Var != null) {
                    re6Var.c--;
                }
            } else if (i == 3) {
                re6 re6Var2 = this.u;
                if (re6Var2 != null) {
                    re6Var2.c = -1;
                }
            }
            i2 = this.r;
            if (i2 != 1) {
                if (this.t == this.s) {
                    ArrayList<nn> arrayList = new ArrayList<>();
                    ArrayList<nn> arrayList2 = this.c;
                    if (arrayList2 != null) {
                        arrayList.addAll(arrayList2);
                    }
                    this.b.setThreadList(arrayList);
                    le6 le6Var = this.y;
                    if (le6Var != null) {
                        le6Var.a(this.r, this.s, null, arrayList);
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                }
                this.t = this.s;
                return;
            }
            he6 c2 = this.x.c(i2);
            if (c2 != null) {
                this.v = true;
                c2.u(this.r, this.s, this.u);
                return;
            }
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getThreadList() != null) {
                this.b.getThreadList().clear();
            }
            this.y.a(this.r, this.s, null, null);
            return;
        }
        re6 re6Var3 = this.u;
        if (re6Var3 != null) {
            re6Var3.c++;
        }
        i2 = this.r;
        if (i2 != 1) {
        }
    }

    public final void C0(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 4).param(TiebaStatic.Params.OBJ_PARAM2, System.currentTimeMillis() - this.a.B));
            if (PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                long currentTimeMillis = System.currentTimeMillis();
                FrsFragment frsFragment = this.a;
                this.A = currentTimeMillis - frsFragment.B;
                long currentTimeMillis2 = System.currentTimeMillis();
                FrsFragment frsFragment2 = this.a;
                frsFragment.D = currentTimeMillis2 - frsFragment2.C;
                p95 p95Var = new p95(i, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
                FrsFragment frsFragment3 = this.a;
                frsFragment3.F = 0L;
                frsFragment3.E = 0L;
                pp6.f(this, frsFragment3.B);
                this.a.B = -1L;
                p95Var.c();
            }
        }
    }

    public void D0(MvcHttpResponsedMessage<dh8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, dh8> mvcHttpMessage, MvcNetMessage<FrsRequestData, dh8> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                objArr[1] = frsRequestData != null ? frsRequestData.E() : null;
                mt4.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
            }
            if (!this.B) {
                this.B = true;
                C0(1000, true, mvcHttpResponsedMessage);
                return;
            }
            E0(true, mvcHttpResponsedMessage);
        }
    }

    public final void E0(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048580, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.a;
            this.A = currentTimeMillis - frsFragment.I;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.a;
            frsFragment.D = currentTimeMillis2 - frsFragment2.C;
            p95 p95Var = new p95(1000, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
            int i = this.h;
            if (i == 4) {
                p95Var.B = this.A;
                p95Var.e(true);
            } else if (i == 3) {
                p95Var.C = this.A;
                p95Var.e(false);
            }
        }
    }

    public void F0(MvcSocketResponsedMessage<dh8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, dh8> mvcSocketMessage, MvcNetMessage<FrsRequestData, dh8> mvcNetMessage) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (!this.B) {
                this.B = true;
                C0(1000, false, mvcSocketResponsedMessage);
            } else {
                E0(false, mvcSocketResponsedMessage);
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
                objArr[1] = frsRequestData != null ? frsRequestData.E() : null;
                objArr[2] = "seq_id";
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                mt4.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.e.cancelLoadData();
        }
    }

    public final void H0(dh8 dh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dh8Var) == null) {
            this.isCacheFirstLoad = false;
            this.b.receiveData(dh8Var);
            M0(this.b);
            this.c = new ArrayList<>();
            if (this.b.getThreadList() != null) {
                this.c.addAll(this.b.getThreadList());
            }
            this.f.c(dh8Var);
        }
    }

    public void I0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            bundle.putString("name", this.g);
            bundle.putString("from", this.j);
            bundle.putInt("flag", this.k);
        }
    }

    public boolean J0(FrsRequestData frsRequestData, dh8 dh8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, frsRequestData, dh8Var)) == null) {
            if (dh8Var == null || dh8Var.getForum() == null || (oi.isEmpty(dh8Var.getForum().getName()) && 340001 != dh8Var.mErrorNo)) {
                return false;
            }
            if (dh8Var.getDataParseTime() > 0) {
                this.a.H = dh8Var.getDataParseTime();
            }
            O0(op6.f(dh8Var.getSortType()));
            P0(op6.f(dh8Var.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.r = dh8Var.getFrsDefaultTabId();
            }
            this.b.receiveData(dh8Var);
            M0(this.b);
            this.c = new ArrayList<>();
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.i = frsRequestData.getPn();
                String E = this.d.E();
                this.g = E;
                this.a.s4(E);
                this.a.setFrom(this.j);
                this.a.C4(this.i);
                this.a.r4(this.k);
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
            if (zn6.b(this.d)) {
                L0();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.K3();
                }
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.b.getForum()));
            }
            this.isNetFirstLoad = false;
            if (dh8Var.getForum() != null && !TextUtils.isEmpty(dh8Var.getForum().getName()) && frsRequestData != null && s98.l().b() != null) {
                s98.l().b().g(dh8Var.getForum().getName(), frsRequestData.F(), false);
            }
            if (!StringUtils.isNull(dh8Var.getUserData().getAppealThreadPopover())) {
                this.a.P4(TbadkCoreApplication.getCurrentAccount(), dh8Var.getForum().getId(), dh8Var.getUserData().getAppealThreadPopover());
            }
            N0(dh8Var);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void K(lp4 lp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, lp4Var) == null) || lp4Var == null || StringUtils.isNull(lp4Var.getId()) || ListUtils.isEmpty(this.c)) {
            return;
        }
        if (this.r == 1) {
            this.b.addMyNewThread(lp4Var);
        }
        int g0 = g0();
        Iterator<nn> it = this.c.iterator();
        while (it.hasNext()) {
            nn next = it.next();
            if ((next instanceof qq4) && lp4Var.getId().equals(((qq4) next).s.getId())) {
                return;
            }
        }
        this.c.add(g0, lp4Var);
    }

    public void K0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || this.d == null) {
            return;
        }
        this.a.I = System.currentTimeMillis();
        FrsViewData frsViewData = this.b;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.b.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(1);
        int S = S(this.r, frsRequestData);
        this.r = S;
        if (S == 1) {
            if (this.e.U()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            P(frsRequestData, i, !z);
            return;
        }
        if (this.u == null) {
            re6 re6Var = new re6();
            this.u = re6Var;
            re6Var.c = 1;
            re6Var.a = this.g;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.u.b = this.b.getForum().getId();
            }
        }
        B0(i);
    }

    public final void L(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, str, frsRequestData) == null) && ThreadData.isRecAppLoaded.get() && s98.l().b() != null) {
            int d2 = s98.l().b().d(str, false);
            int e2 = s98.l().b().e(str, false);
            if (frsRequestData.F() == 1) {
                d2++;
            } else if (frsRequestData.F() == 2) {
                e2++;
            }
            frsRequestData.Z(d2);
            frsRequestData.U(e2);
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(ng.g(this.b.getForum().getId(), 0L));
            }
            this.a.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            he5.b(new d(this, str), null);
        }
    }

    public final void M0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, frsViewData) == null) {
            if (aq6.G(frsViewData)) {
                this.l = "book_page";
            } else if (frsViewData.getIsBrandForum()) {
                this.l = "brand_page";
            } else if (aq6.H(frsViewData)) {
                this.l = "frs_page";
            } else {
                this.l = "normal_page";
            }
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            he5.b(new b(this, str), null);
        }
    }

    public final void N0(dh8 dh8Var) {
        FrsFragment frsFragment;
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, dh8Var) == null) || dh8Var == null || (frsFragment = this.a) == null || frsFragment.getActivity() == null || (intent = this.a.getActivity().getIntent()) == null) {
            return;
        }
        ub8.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), dh8Var.getForum().getId());
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            he5.b(new c(this, str), null);
        }
    }

    public void O0(int i) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.D = i;
            if (i != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                op6.i("1~" + str + this.g, this.D);
            }
            if (7 == i) {
                sj8.b();
            } else {
                sj8.a();
            }
        }
    }

    public final void P(FrsRequestData frsRequestData, int i, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.o4(z);
            this.f.a(i);
            this.e.h0(frsRequestData);
            frsRequestData.X(this.a.R3() ? "1" : "2");
            if (this.G) {
                frsRequestData.Y(String.valueOf(op6.d(this.E)));
            } else {
                frsRequestData.Y("-2");
            }
            this.G = false;
            frsRequestData.R(this.g);
            frsRequestData.e0(1);
            frsRequestData.J(0);
            int k = pi.k(TbadkCoreApplication.getInst());
            int i2 = pi.i(TbadkCoreApplication.getInst());
            float h = pi.h(TbadkCoreApplication.getInst());
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            frsRequestData.d0(k);
            frsRequestData.c0(i2);
            frsRequestData.b0(h);
            frsRequestData.g0(i3);
            frsRequestData.a0(this.n);
            frsRequestData.T(this.p);
            frsRequestData.f0(this.C);
            frsRequestData.S(ng.g(ae5.a(), 0L));
            String str = this.o;
            if (str != null) {
                frsRequestData.setStType(str);
                if ("sidebar".equalsIgnoreCase(this.o)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.O(t0());
            if (FrsFragment.h2 != 0) {
                frsRequestData.K((int) FrsFragment.h2);
            }
            if (FrsFragment.i2 != 0) {
                frsRequestData.L((int) FrsFragment.i2);
            }
            if (FrsFragment.j2 != 0) {
                frsRequestData.W(FrsFragment.j2);
            }
            if (frsRequestData.getPn() != 1 && this.h != 3) {
                FrsViewData frsViewData = this.b;
                frsRequestData.H(w88.e(frsViewData != null ? frsViewData.getThreadList() : null, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.b;
                frsRequestData.H(w88.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.h);
            frsRequestData.N(this.q);
            op6.e(this.D, frsRequestData);
            int d2 = op6.d(this.F);
            R(i, frsRequestData);
            L(this.g, frsRequestData);
            if (!m0(this.F) && !this.a.i && !this.K) {
                ug8 i4 = ug8.i();
                String g = i4.g("1~" + this.g, d2, frsRequestData.D(), this.d.B());
                this.I = g;
                new e(this, true, g).execute(new Object[0]);
            }
            V0();
            this.K = false;
        }
    }

    public void P0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.J.put(i, Boolean.valueOf(z));
        }
    }

    public final void Q(FrsRequestData frsRequestData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.o4(z);
            this.f.a(i);
            if (this.e.g0() && (this.e.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                t((MvcHttpResponsedMessage) this.e.getResponsedMessage(), (MvcHttpMessage) this.e.d0(), this.e.e0());
            } else if (this.e.g0() && (this.e.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                o((MvcSocketResponsedMessage) this.e.getResponsedMessage(), (MvcSocketMessage) this.e.d0(), this.e.e0());
            } else {
                int d2 = op6.d(this.F);
                if (!m0(this.F) && !this.a.i && !this.K) {
                    ug8 i2 = ug8.i();
                    String g = i2.g("1~" + this.g, d2, frsRequestData.D(), this.d.B());
                    this.I = g;
                    new e(this, true, g).execute(new Object[0]);
                }
                this.K = false;
            }
            this.e.c0(this);
        }
    }

    public void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.G = z;
        }
    }

    public final void R(int i, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048600, this, i, frsRequestData) == null) || frsRequestData == null) {
            return;
        }
        if (i == 3) {
            frsRequestData.V(1);
        } else if (i != 4) {
        } else {
            frsRequestData.V(2);
        }
    }

    public void R0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.K = z;
        }
    }

    public final int S(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, frsRequestData)) == null) ? (i != 1 || this.a.m3() == null) ? i : this.a.m3().d(this.D, frsRequestData) : invokeIL.intValue;
    }

    public void S0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.E = i;
        }
    }

    public void T(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.a.I = System.currentTimeMillis();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.b.getLikeFeedForumDataList().clear();
            }
            this.r = S(this.r, this.d);
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData2 = this.b;
            frsRequestData.H(w88.e(frsViewData2 == null ? null : frsViewData2.getThreadList(), true));
            if (this.r == 1) {
                Q(this.d, i, !z);
                return;
            }
            if (this.u == null) {
                re6 re6Var = new re6();
                this.u = re6Var;
                re6Var.c = 1;
                re6Var.a = this.g;
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.u.b = this.b.getForum().getId();
                }
            }
            B0(i);
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            kd6 kd6Var = new kd6();
            if (this.t == 0) {
                kd6Var.b(this.D);
            }
            if (this.b.getThreadList() != null) {
                this.b.getThreadList().clear();
                this.b.getThreadList().add(kd6Var);
            }
            ArrayList<nn> arrayList = this.c;
            if (arrayList != null) {
                arrayList.clear();
                this.c.add(kd6Var);
            }
        }
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.F : invokeV.intValue;
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.n = str;
        }
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.D : invokeV.intValue;
    }

    public final boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            this.O = System.currentTimeMillis();
            br6.a();
            return this.e.loadData();
        }
        return invokeV.booleanValue;
    }

    public vg8 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.H : (vg8) invokeV.objValue;
    }

    public void W0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    public FrsRequestData X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.d : (FrsRequestData) invokeV.objValue;
    }

    public final void X0(int i, int i2, re6 re6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048613, this, i, i2, re6Var) == null) {
            this.w.put(c0(i, i2), re6Var);
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? 1 == this.r : invokeV.booleanValue;
    }

    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.t : invokeV.intValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            re6 re6Var = this.u;
            if ((re6Var instanceof ve6) && ((ve6) re6Var).e == 0) {
                return ((ve6) re6Var).g;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<nn> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.c : (ArrayList) invokeV.objValue;
    }

    public re6 b0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048618, this, i, i2)) == null) ? this.w.get(c0(i, i2)) : (re6) invokeII.objValue;
    }

    public final int c0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048619, this, i, i2)) == null) ? (i * 10) + i2 : invokeII.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? op6.d(this.D) : invokeV.intValue;
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.r : invokeV.intValue;
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            ArrayList<nn> arrayList = this.c;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<nn> it = this.c.iterator();
                while (it.hasNext()) {
                    nn next = it.next();
                    if (next instanceof qq4) {
                        if (((qq4) next).s.getIs_top() == 0) {
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

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.i : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.h : invokeV.intValue;
    }

    public FrsViewData h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.b : (FrsViewData) invokeV.objValue;
    }

    public long i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.R : invokeV.longValue;
    }

    @Override // com.repackage.he6
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.x.d();
        }
    }

    public long j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.O : invokeV.longValue;
    }

    @Override // com.repackage.he6
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.x.b();
            this.x.clear();
        }
    }

    public long k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.Q : invokeV.longValue;
    }

    public long l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.P : invokeV.longValue;
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

    public boolean m0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i)) == null) ? this.J.get(i, Boolean.FALSE).booleanValue() : invokeI.booleanValue;
    }

    public void n0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bundle) == null) {
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
            q0();
            if (this.b == null) {
                this.b = new FrsViewData();
            }
            if (this.e == null || (frsRequestData = this.d) == null || frsRequestData.y() == null || this.d.y().isEmpty() || this.d.y().containsKey(null) || this.d.y().containsValue(null)) {
                o0(bundle);
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void o(MvcSocketResponsedMessage<dh8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, dh8> mvcSocketMessage, MvcNetMessage<FrsRequestData, dh8> mvcNetMessage) {
        dh8 data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048637, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.L.a(this);
        this.L.e(mvcSocketResponsedMessage);
        this.L.c(mvcSocketMessage);
        this.L.d(mvcNetMessage);
        this.L.b(this.f);
        Looper.myQueue().addIdleHandler(this.L);
        vg8 vg8Var = new vg8();
        vg8Var.a = ni.z() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        vg8Var.b = !mvcSocketResponsedMessage.hasError();
        vg8Var.c = mvcSocketResponsedMessage.getError();
        vg8Var.d = mvcSocketResponsedMessage.getErrorString();
        vg8Var.e = mvcSocketResponsedMessage.getDownSize();
        this.H = vg8Var;
        if (!mvcSocketResponsedMessage.hasError() || 340001 == mvcSocketResponsedMessage.getError()) {
            data = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            data = null;
        }
        if (r1 == null || data == null || !J0(r1, data)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.a.f(errorData);
        }
    }

    public final void o0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.d = frsRequestData;
            frsRequestData.setSortType(op6.d(this.D));
            if (this.D == 5) {
                this.d.P(1);
            } else {
                this.d.P(0);
            }
            this.d.A("forum_name", oi.getUrlEncode(this.g));
            this.d.A("client_type", "2");
            this.d.setPn(1);
            if (bundle != null) {
                this.d.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.d.N(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.d.X("2");
            this.d.Y("-2");
            this.d.R(this.g);
            this.d.e0(1);
            this.d.J(0);
            this.d.d0(pi.k(TbadkCoreApplication.getInst()));
            this.d.c0(pi.i(TbadkCoreApplication.getInst()));
            this.d.b0(pi.h(TbadkCoreApplication.getInst()));
            this.d.g0(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
            this.d.a0(this.n);
            this.d.T(null);
            this.d.f0(this.C);
            this.d.S(ng.g(ae5.a(), 0L));
            this.d.setStType(this.j);
            this.d.O(1);
            this.d.setNeedCache(true);
            this.d.setUpdateType(3);
            FrsRequestData frsRequestData2 = this.d;
            FrsViewData frsViewData = this.b;
            frsRequestData2.H(w88.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            op6.e(this.D, this.d);
            this.d.V(1);
            if (ThreadData.isRecAppLoaded.get() && s98.l().b() != null) {
                int d2 = s98.l().b().d(this.g, false);
                int e2 = s98.l().b().e(this.g, false);
                if (this.d.F() == 1) {
                    d2++;
                } else if (this.d.F() == 2) {
                    e2++;
                }
                this.d.Z(d2);
                this.d.U(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.d);
            this.e = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.a.getActivity()).getUniqueId());
            this.e.c0(this);
            this.e.loadData();
            br6.a();
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.z.size() == 0) {
                this.z.add(new td6());
            }
        }
    }

    public final void q0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
                O0(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
                O0(6);
            } else {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                this.F = op6.h("1~" + str + this.g);
                O0(this.D);
            }
        }
    }

    public final void r0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, frsFragment) == null) {
            xd6 xd6Var = new xd6();
            this.x = xd6Var;
            xd6Var.a = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.x));
            this.x.e(this.N);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, za zaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048642, this, i, zaVar) == null) {
            super.registerListener(i, zaVar);
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.m : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void t(MvcHttpResponsedMessage<dh8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, dh8> mvcHttpMessage, MvcNetMessage<FrsRequestData, dh8> mvcNetMessage) {
        dh8 dh8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048645, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.M.a(this);
        this.M.e(mvcHttpResponsedMessage);
        this.M.c(mvcHttpMessage);
        this.M.d(mvcNetMessage);
        this.M.b(this.f);
        Looper.myQueue().addIdleHandler(this.M);
        vg8 vg8Var = new vg8();
        vg8Var.a = ni.z() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        vg8Var.b = !mvcHttpResponsedMessage.hasError();
        vg8Var.c = mvcHttpResponsedMessage.getError();
        vg8Var.d = mvcHttpResponsedMessage.getErrorString();
        vg8Var.e = mvcHttpResponsedMessage.getDownSize();
        this.H = vg8Var;
        if (mvcHttpResponsedMessage.hasError()) {
            dh8Var = null;
        } else {
            dh8Var = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || dh8Var == null || !J0(r1, dh8Var)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.a.f(errorData);
        }
    }

    public final int t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                int i = frsFragment.M0;
                return (i == -1 || i == this.r) ? 1 : 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.he6
    public void u(int i, int i2, re6 re6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048647, this, i, i2, re6Var) == null) {
            this.r = S(i, null);
            if (re6Var == null && (re6Var = b0(i, i2)) == null) {
                if (i != 1 && pi.D() && this.y != null) {
                    ve6 ve6Var = new ve6();
                    ve6Var.g = false;
                    ve6Var.c = 1;
                    ve6Var.a = this.g;
                    ve6Var.i = false;
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        ve6Var.b = this.b.getForum().getId();
                    }
                    p0();
                    this.b.setThreadList(this.z);
                    this.y.a(i, i2, ve6Var, this.z);
                }
                re6Var = new re6();
                re6Var.c = -1;
            }
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                re6Var.b = this.b.getForum().getId();
            }
            re6Var.a = this.g;
            if (vd6.a().b(1) != null && this.r == 1) {
                this.d.I(i2);
            }
            this.s = i2;
            this.u = re6Var;
            X0(i, i2, re6Var);
            B0(5);
        }
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.D == 5 : invokeV.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.e.U() : invokeV.booleanValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            FrsRequestData frsRequestData = this.d;
            return frsRequestData != null && frsRequestData.F() == 1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.he6
    public void x(le6 le6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, le6Var) == null) {
            this.y = le6Var;
            this.x.e(this.N);
        }
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.D == 7 || (!this.e.g0() && this.F == 7) : invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (this.r != 1) {
                B0(1);
                return true;
            } else if (this.e.U()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(e0());
                P(frsRequestData, 1, false);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, messageListener) == null) {
            super.registerListener(messageListener);
        }
    }
}

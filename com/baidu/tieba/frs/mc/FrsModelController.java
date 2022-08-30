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
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.aq6;
import com.baidu.tieba.as6;
import com.baidu.tieba.bb;
import com.baidu.tieba.bt6;
import com.baidu.tieba.d9;
import com.baidu.tieba.fk8;
import com.baidu.tieba.fm5;
import com.baidu.tieba.fq4;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.gc8;
import com.baidu.tieba.gf5;
import com.baidu.tieba.hg6;
import com.baidu.tieba.iu4;
import com.baidu.tieba.jf5;
import com.baidu.tieba.kb8;
import com.baidu.tieba.kf6;
import com.baidu.tieba.kr4;
import com.baidu.tieba.le8;
import com.baidu.tieba.lg6;
import com.baidu.tieba.lm8;
import com.baidu.tieba.nf5;
import com.baidu.tieba.or6;
import com.baidu.tieba.pg;
import com.baidu.tieba.pi;
import com.baidu.tieba.pj8;
import com.baidu.tieba.pn;
import com.baidu.tieba.pr6;
import com.baidu.tieba.qi;
import com.baidu.tieba.qj8;
import com.baidu.tieba.rg6;
import com.baidu.tieba.ri;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tf6;
import com.baidu.tieba.uo6;
import com.baidu.tieba.va5;
import com.baidu.tieba.vf6;
import com.baidu.tieba.vg6;
import com.baidu.tieba.vo6;
import com.baidu.tieba.xf6;
import com.baidu.tieba.yj8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements hg6, NetModel.k<FrsRequestData, yj8> {
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
    public qj8 H;
    public String I;
    public final SparseArray<Boolean> J;
    public boolean K;
    public vo6 L;
    public uo6 M;
    public lg6 N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public final FrsFragment a;
    public FrsViewData b;
    public ArrayList<pn> c;
    public FrsRequestData d;
    public FrsNetModel e;
    public final fk8 f;
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
    public rg6 u;
    public boolean v;
    public SparseArray<rg6> w;
    public xf6 x;
    public lg6 y;
    public ArrayList<pn> z;

    /* loaded from: classes4.dex */
    public class a implements lg6 {
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

        @Override // com.baidu.tieba.lg6
        public void a(int i, int i2, vg6 vg6Var, ArrayList<pn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), vg6Var, arrayList}) == null) {
                this.a.v = false;
                if (i != this.a.r || this.a.y == null) {
                    return;
                }
                this.a.u = vg6Var;
                this.a.W0(i, i2, vg6Var);
                ArrayList<pn> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                this.a.b.setThreadList(arrayList2);
                this.a.y.a(i, i2, vg6Var, arrayList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends jf5<Object> {
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

        @Override // com.baidu.tieba.jf5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                pj8.i().c(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends jf5<Object> {
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

        @Override // com.baidu.tieba.jf5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                pj8.i().d(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends jf5<Object> {
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

        @Override // com.baidu.tieba.jf5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                pj8.i().b(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends BdAsyncTask<Object, yj8, Void> {
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
                if (this.c && pj8.i().e(this.a)) {
                    if (!pj8.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        pj8.i().j().getForum().getSignData().is_signed = 0;
                    }
                    yj8 j = pj8.i().j();
                    j.setIsShowRedTip(false);
                    if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (e = pg.e(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e))) != null) {
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
        public void onProgressUpdate(yj8... yj8VarArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yj8VarArr) == null) {
                super.onProgressUpdate(yj8VarArr);
                FrsModelController frsModelController = this.b;
                if (frsModelController != null && yj8VarArr != null) {
                    frsModelController.G0(yj8VarArr.length > 0 ? yj8VarArr[0] : null);
                    FrsModelController frsModelController2 = this.b;
                    frsModelController2.O0(frsModelController2.D, true);
                    return;
                }
                FrsModelController frsModelController3 = this.b;
                if (frsModelController3 == null || frsModelController3.e.f0()) {
                    return;
                }
                if (this.b.e.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    FrsModelController frsModelController4 = this.b;
                    frsModelController4.s((MvcHttpResponsedMessage) frsModelController4.e.getResponsedMessage(), (MvcHttpMessage) this.b.e.c0(), this.b.e.d0());
                }
                if (this.b.e.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    FrsModelController frsModelController5 = this.b;
                    frsModelController5.n((MvcSocketResponsedMessage) frsModelController5.e.getResponsedMessage(), (MvcSocketMessage) this.b.e.c0(), this.b.e.d0());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, fk8 fk8Var) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, fk8Var};
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
        this.L = new vo6();
        this.M = new uo6();
        this.N = new a(this);
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        if (fk8Var != null) {
            this.a = frsFragment;
            this.f = fk8Var;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.e = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.a.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.e;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.e.b0(this);
                }
                this.d = this.e.e0();
            }
            q0(this.a);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0010, code lost:
        if (r5 != 4) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
            return;
        }
        this.h = i;
        if (i != 1) {
            if (i == 2) {
                rg6 rg6Var = this.u;
                if (rg6Var != null) {
                    rg6Var.c--;
                }
            } else if (i == 3) {
                rg6 rg6Var2 = this.u;
                if (rg6Var2 != null) {
                    rg6Var2.c = -1;
                }
            }
            i2 = this.r;
            if (i2 != 1) {
                if (this.t == this.s) {
                    ArrayList<pn> arrayList = new ArrayList<>();
                    ArrayList<pn> arrayList2 = this.c;
                    if (arrayList2 != null) {
                        arrayList.addAll(arrayList2);
                    }
                    this.b.setThreadList(arrayList);
                    lg6 lg6Var = this.y;
                    if (lg6Var != null) {
                        lg6Var.a(this.r, this.s, null, arrayList);
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                }
                this.t = this.s;
                return;
            }
            hg6 c2 = this.x.c(i2);
            if (c2 != null) {
                this.v = true;
                c2.t(this.r, this.s, this.u);
                return;
            }
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getThreadList() != null) {
                this.b.getThreadList().clear();
            }
            this.y.a(this.r, this.s, null, null);
            return;
        }
        rg6 rg6Var3 = this.u;
        if (rg6Var3 != null) {
            rg6Var3.c++;
        }
        i2 = this.r;
        if (i2 != 1) {
        }
    }

    public final void B0(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 4).param(TiebaStatic.Params.OBJ_PARAM2, System.currentTimeMillis() - this.a.B));
            if (PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                long currentTimeMillis = System.currentTimeMillis();
                FrsFragment frsFragment = this.a;
                this.A = currentTimeMillis - frsFragment.B;
                long currentTimeMillis2 = System.currentTimeMillis();
                FrsFragment frsFragment2 = this.a;
                frsFragment.D = currentTimeMillis2 - frsFragment2.C;
                va5 va5Var = new va5(i, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
                FrsFragment frsFragment3 = this.a;
                frsFragment3.F = 0L;
                frsFragment3.E = 0L;
                pr6.f(this, frsFragment3.B);
                this.a.B = -1L;
                va5Var.c();
            }
        }
    }

    public void C0(MvcHttpResponsedMessage<yj8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, yj8> mvcHttpMessage, MvcNetMessage<FrsRequestData, yj8> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                objArr[1] = frsRequestData != null ? frsRequestData.D() : null;
                iu4.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
            }
            if (!this.B) {
                this.B = true;
                B0(1000, true, mvcHttpResponsedMessage);
                return;
            }
            D0(true, mvcHttpResponsedMessage);
        }
    }

    public final void D0(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048579, this, z, responsedMessage) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.a;
            this.A = currentTimeMillis - frsFragment.I;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.a;
            frsFragment.D = currentTimeMillis2 - frsFragment2.C;
            va5 va5Var = new va5(1000, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
            int i = this.h;
            if (i == 4) {
                va5Var.B = this.A;
                va5Var.e(true);
            } else if (i == 3) {
                va5Var.C = this.A;
                va5Var.e(false);
            }
        }
    }

    public void E0(MvcSocketResponsedMessage<yj8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, yj8> mvcSocketMessage, MvcNetMessage<FrsRequestData, yj8> mvcNetMessage) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (!this.B) {
                this.B = true;
                B0(1000, false, mvcSocketResponsedMessage);
            } else {
                D0(false, mvcSocketResponsedMessage);
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
                objArr[1] = frsRequestData != null ? frsRequestData.D() : null;
                objArr[2] = "seq_id";
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                iu4.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.e.cancelLoadData();
        }
    }

    public final void G0(yj8 yj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yj8Var) == null) {
            this.isCacheFirstLoad = false;
            this.b.receiveData(yj8Var);
            L0(this.b);
            this.c = new ArrayList<>();
            if (this.b.getThreadList() != null) {
                this.c.addAll(this.b.getThreadList());
            }
            this.f.c(yj8Var);
        }
    }

    public void H0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            bundle.putString("name", this.g);
            bundle.putString("from", this.j);
            bundle.putInt("flag", this.k);
        }
    }

    public boolean I0(FrsRequestData frsRequestData, yj8 yj8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsRequestData, yj8Var)) == null) {
            if (yj8Var == null || yj8Var.getForum() == null || (qi.isEmpty(yj8Var.getForum().getName()) && 340001 != yj8Var.mErrorNo)) {
                return false;
            }
            if (yj8Var.getDataParseTime() > 0) {
                this.a.H = yj8Var.getDataParseTime();
            }
            if (yj8Var.getEntelechyTabInfo() != null && !ListUtils.isEmpty(yj8Var.getEntelechyTabInfo().a)) {
                int intValue = yj8Var.getEntelechyTabInfo().a.get(0).tab_type.intValue();
                AbsDataRecorder.Scene scene = AbsDataRecorder.Scene.FRS_HOT;
                this.a.t4(13);
                if (intValue == 14) {
                    scene = AbsDataRecorder.Scene.FRS_NEW;
                    this.a.t4(14);
                }
                if (fm5.k().l(scene)) {
                    fm5.k().g(scene).b();
                }
            }
            N0(or6.f(yj8Var.getSortType()));
            O0(or6.f(yj8Var.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.r = yj8Var.getFrsDefaultTabId();
            }
            this.b.receiveData(yj8Var);
            L0(this.b);
            this.c = new ArrayList<>();
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.i = frsRequestData.getPn();
                String D = this.d.D();
                this.g = D;
                this.a.v4(D);
                this.a.setFrom(this.j);
                this.a.F4(this.i);
                this.a.u4(this.k);
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
            if (aq6.b(this.d)) {
                K0();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.M3();
                }
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.b.getForum()));
            }
            this.isNetFirstLoad = false;
            if (yj8Var.getForum() != null && !TextUtils.isEmpty(yj8Var.getForum().getName()) && frsRequestData != null && gc8.l().b() != null) {
                gc8.l().b().g(yj8Var.getForum().getName(), frsRequestData.E(), false);
            }
            if (!StringUtils.isNull(yj8Var.getUserData().getAppealThreadPopover())) {
                this.a.S4(TbadkCoreApplication.getCurrentAccount(), yj8Var.getForum().getId(), yj8Var.getUserData().getAppealThreadPopover());
            }
            M0(yj8Var);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void J(fq4 fq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fq4Var) == null) || fq4Var == null || StringUtils.isNull(fq4Var.getId()) || ListUtils.isEmpty(this.c)) {
            return;
        }
        if (this.r == 1) {
            this.b.addMyNewThread(fq4Var);
        }
        int f0 = f0();
        Iterator<pn> it = this.c.iterator();
        while (it.hasNext()) {
            pn next = it.next();
            if ((next instanceof kr4) && fq4Var.getId().equals(((kr4) next).t.getId())) {
                return;
            }
        }
        this.c.add(f0, fq4Var);
    }

    public void J0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || this.d == null) {
            return;
        }
        this.a.I = System.currentTimeMillis();
        FrsViewData frsViewData = this.b;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.b.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(1);
        int R = R(this.r, frsRequestData);
        this.r = R;
        if (R == 1) {
            if (this.e.T()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            O(frsRequestData, i, !z);
            return;
        }
        if (this.u == null) {
            rg6 rg6Var = new rg6();
            this.u = rg6Var;
            rg6Var.c = 1;
            rg6Var.a = this.g;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.u.b = this.b.getForum().getId();
            }
        }
        A0(i);
    }

    public final void K(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, frsRequestData) == null) && ThreadData.isRecAppLoaded.get() && gc8.l().b() != null) {
            int d2 = gc8.l().b().d(str, false);
            int e2 = gc8.l().b().e(str, false);
            if (frsRequestData.E() == 1) {
                d2++;
            } else if (frsRequestData.E() == 2) {
                e2++;
            }
            frsRequestData.Y(d2);
            frsRequestData.T(e2);
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(pg.g(this.b.getForum().getId(), 0L));
            }
            this.a.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            nf5.b(new d(this, str), null);
        }
    }

    public final void L0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) {
            if (as6.J(frsViewData)) {
                this.l = "book_page";
            } else if (frsViewData.getIsBrandForum()) {
                this.l = "brand_page";
            } else if (as6.K(frsViewData)) {
                this.l = "frs_page";
            } else {
                this.l = "normal_page";
            }
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            nf5.b(new b(this, str), null);
        }
    }

    public final void M0(yj8 yj8Var) {
        FrsFragment frsFragment;
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, yj8Var) == null) || yj8Var == null || (frsFragment = this.a) == null || frsFragment.getActivity() == null || (intent = this.a.getActivity().getIntent()) == null) {
            return;
        }
        le8.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), yj8Var.getForum().getId());
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            nf5.b(new c(this, str), null);
        }
    }

    public void N0(int i) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.D = i;
            if (i != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                or6.i("1~" + str + this.g, this.D);
            }
            if (7 == i) {
                lm8.b();
            } else {
                lm8.a();
            }
        }
    }

    public final void O(FrsRequestData frsRequestData, int i, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.q4(z);
            this.f.a(i);
            this.e.g0(frsRequestData);
            frsRequestData.W(this.a.T3() ? "1" : "2");
            if (this.G) {
                frsRequestData.X(String.valueOf(or6.d(this.E)));
            } else {
                frsRequestData.X("-2");
            }
            this.G = false;
            frsRequestData.Q(this.g);
            frsRequestData.e0(1);
            frsRequestData.I(0);
            int k = ri.k(TbadkCoreApplication.getInst());
            int i2 = ri.i(TbadkCoreApplication.getInst());
            float h = ri.h(TbadkCoreApplication.getInst());
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            frsRequestData.d0(k);
            frsRequestData.c0(i2);
            frsRequestData.b0(h);
            frsRequestData.g0(i3);
            frsRequestData.a0(this.n);
            frsRequestData.S(this.p);
            frsRequestData.f0(this.C);
            frsRequestData.R(pg.g(gf5.a(), 0L));
            String str = this.o;
            if (str != null) {
                frsRequestData.setStType(str);
                if ("sidebar".equalsIgnoreCase(this.o)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.N(s0());
            if (FrsFragment.k2 != 0) {
                frsRequestData.J((int) FrsFragment.k2);
            }
            if (FrsFragment.l2 != 0) {
                frsRequestData.K((int) FrsFragment.l2);
            }
            if (FrsFragment.m2 != 0) {
                frsRequestData.V(FrsFragment.m2);
            }
            if (frsRequestData.getPn() != 1 && this.h != 3) {
                FrsViewData frsViewData = this.b;
                frsRequestData.G(kb8.e(frsViewData != null ? frsViewData.getThreadList() : null, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.b;
                frsRequestData.G(kb8.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.h);
            frsRequestData.M(this.q);
            or6.e(this.D, frsRequestData);
            int d2 = or6.d(this.F);
            Q(i, frsRequestData);
            K(this.g, frsRequestData);
            if (!l0(this.F) && !this.a.i && !this.K) {
                pj8 i4 = pj8.i();
                String g = i4.g("1~" + this.g, d2, frsRequestData.C(), this.d.A());
                this.I = g;
                new e(this, true, g).execute(new Object[0]);
            }
            U0();
            this.K = false;
        }
    }

    public void O0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.J.put(i, Boolean.valueOf(z));
        }
    }

    public final void P(FrsRequestData frsRequestData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.q4(z);
            this.f.a(i);
            if (this.e.f0() && (this.e.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                s((MvcHttpResponsedMessage) this.e.getResponsedMessage(), (MvcHttpMessage) this.e.c0(), this.e.d0());
            } else if (this.e.f0() && (this.e.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                n((MvcSocketResponsedMessage) this.e.getResponsedMessage(), (MvcSocketMessage) this.e.c0(), this.e.d0());
            } else {
                int d2 = or6.d(this.F);
                if (!l0(this.F) && !this.a.i && !this.K) {
                    pj8 i2 = pj8.i();
                    String g = i2.g("1~" + this.g, d2, frsRequestData.C(), this.d.A());
                    this.I = g;
                    new e(this, true, g).execute(new Object[0]);
                }
                this.K = false;
            }
            this.e.b0(this);
        }
    }

    public void P0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.G = z;
        }
    }

    public final void Q(int i, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048599, this, i, frsRequestData) == null) || frsRequestData == null) {
            return;
        }
        if (i == 3) {
            frsRequestData.U(1);
        } else if (i != 4) {
        } else {
            frsRequestData.U(2);
        }
    }

    public void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.K = z;
        }
    }

    public final int R(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i, frsRequestData)) == null) ? (i != 1 || this.a.m3() == null) ? i : this.a.m3().d(this.D, frsRequestData) : invokeIL.intValue;
    }

    public void R0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.E = i;
        }
    }

    public void S(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.a.I = System.currentTimeMillis();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.b.getLikeFeedForumDataList().clear();
            }
            this.r = R(this.r, this.d);
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData2 = this.b;
            frsRequestData.G(kb8.e(frsViewData2 == null ? null : frsViewData2.getThreadList(), true));
            if (this.r == 1) {
                P(this.d, i, !z);
                return;
            }
            if (this.u == null) {
                rg6 rg6Var = new rg6();
                this.u = rg6Var;
                rg6Var.c = 1;
                rg6Var.a = this.g;
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.u.b = this.b.getForum().getId();
                }
            }
            A0(i);
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            kf6 kf6Var = new kf6();
            if (this.t == 0) {
                kf6Var.b(this.D);
            }
            if (this.b.getThreadList() != null) {
                this.b.getThreadList().clear();
                this.b.getThreadList().add(kf6Var);
            }
            ArrayList<pn> arrayList = this.c;
            if (arrayList != null) {
                arrayList.clear();
                this.c.add(kf6Var);
            }
        }
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.F : invokeV.intValue;
    }

    public void T0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.n = str;
        }
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.D : invokeV.intValue;
    }

    public final boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            this.O = System.currentTimeMillis();
            bt6.a();
            return this.e.loadData();
        }
        return invokeV.booleanValue;
    }

    public qj8 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.H : (qj8) invokeV.objValue;
    }

    public void V0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    public FrsRequestData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.d : (FrsRequestData) invokeV.objValue;
    }

    public final void W0(int i, int i2, rg6 rg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i, i2, rg6Var) == null) {
            this.w.put(b0(i, i2), rg6Var);
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? 1 == this.r : invokeV.booleanValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.t : invokeV.intValue;
    }

    public ArrayList<pn> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.c : (ArrayList) invokeV.objValue;
    }

    public rg6 a0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048616, this, i, i2)) == null) ? this.w.get(b0(i, i2)) : (rg6) invokeII.objValue;
    }

    public final int b0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048617, this, i, i2)) == null) ? (i * 10) + i2 : invokeII.intValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.l : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? or6.d(this.D) : invokeV.intValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.r : invokeV.intValue;
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            ArrayList<pn> arrayList = this.c;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<pn> it = this.c.iterator();
                while (it.hasNext()) {
                    pn next = it.next();
                    if (next instanceof kr4) {
                        if (((kr4) next).t.getIs_top() == 0) {
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

    public FrsViewData g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.b : (FrsViewData) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.R : invokeV.longValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            rg6 rg6Var = this.u;
            if ((rg6Var instanceof vg6) && ((vg6) rg6Var).e == 0) {
                return ((vg6) rg6Var).g;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public long i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.O : invokeV.longValue;
    }

    @Override // com.baidu.tieba.hg6
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.x.d();
        }
    }

    @Override // com.baidu.tieba.hg6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.x.b();
            this.x.clear();
        }
    }

    public long j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.Q : invokeV.longValue;
    }

    public long k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.P : invokeV.longValue;
    }

    public boolean l0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i)) == null) ? this.J.get(i, Boolean.FALSE).booleanValue() : invokeI.booleanValue;
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

    public void m0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, bundle) == null) {
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
            p0();
            if (this.b == null) {
                this.b = new FrsViewData();
            }
            if (this.e == null || (frsRequestData = this.d) == null || frsRequestData.x() == null || this.d.x().isEmpty() || this.d.x().containsKey(null) || this.d.x().containsValue(null)) {
                n0(bundle);
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
    public void n(MvcSocketResponsedMessage<yj8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, yj8> mvcSocketMessage, MvcNetMessage<FrsRequestData, yj8> mvcNetMessage) {
        yj8 data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048636, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.L.a(this);
        this.L.e(mvcSocketResponsedMessage);
        this.L.c(mvcSocketMessage);
        this.L.d(mvcNetMessage);
        this.L.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.L);
        qj8 qj8Var = new qj8();
        qj8Var.a = pi.z() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        qj8Var.b = !mvcSocketResponsedMessage.hasError();
        qj8Var.c = mvcSocketResponsedMessage.getError();
        qj8Var.d = mvcSocketResponsedMessage.getErrorString();
        qj8Var.e = mvcSocketResponsedMessage.getDownSize();
        this.H = qj8Var;
        if (!mvcSocketResponsedMessage.hasError() || 340001 == mvcSocketResponsedMessage.getError()) {
            data = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            data = null;
        }
        if (r1 == null || data == null || !I0(r1, data)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.a.f(errorData);
        }
    }

    public final void n0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.d = frsRequestData;
            frsRequestData.setSortType(or6.d(this.D));
            if (this.D == 5) {
                this.d.O(1);
            } else {
                this.d.O(0);
            }
            this.d.z("forum_name", qi.getUrlEncode(this.g));
            this.d.z("client_type", "2");
            this.d.setPn(1);
            if (bundle != null) {
                this.d.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.d.M(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.d.W("2");
            this.d.X("-2");
            this.d.Q(this.g);
            this.d.e0(1);
            this.d.I(0);
            this.d.d0(ri.k(TbadkCoreApplication.getInst()));
            this.d.c0(ri.i(TbadkCoreApplication.getInst()));
            this.d.b0(ri.h(TbadkCoreApplication.getInst()));
            this.d.g0(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
            this.d.a0(this.n);
            this.d.S(null);
            this.d.f0(this.C);
            this.d.R(pg.g(gf5.a(), 0L));
            this.d.setStType(this.j);
            this.d.N(1);
            this.d.setNeedCache(true);
            this.d.setUpdateType(3);
            FrsRequestData frsRequestData2 = this.d;
            FrsViewData frsViewData = this.b;
            frsRequestData2.G(kb8.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            or6.e(this.D, this.d);
            this.d.U(1);
            if (ThreadData.isRecAppLoaded.get() && gc8.l().b() != null) {
                int d2 = gc8.l().b().d(this.g, false);
                int e2 = gc8.l().b().e(this.g, false);
                if (this.d.E() == 1) {
                    d2++;
                } else if (this.d.E() == 2) {
                    e2++;
                }
                this.d.Y(d2);
                this.d.T(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.d);
            this.e = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.a.getActivity()).getUniqueId());
            this.e.b0(this);
            this.e.loadData();
            bt6.a();
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.z.size() == 0) {
                this.z.add(new tf6());
            }
        }
    }

    public final void p0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
                N0(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
                N0(6);
            } else {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                this.F = or6.h("1~" + str + this.g);
                N0(this.D);
            }
        }
    }

    public final void q0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, frsFragment) == null) {
            xf6 xf6Var = new xf6();
            this.x = xf6Var;
            xf6Var.a = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.x));
            this.x.e(this.N);
        }
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.m : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, bb bbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048642, this, i, bbVar) == null) {
            super.registerListener(i, bbVar);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage<yj8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, yj8> mvcHttpMessage, MvcNetMessage<FrsRequestData, yj8> mvcNetMessage) {
        yj8 yj8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048644, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.M.a(this);
        this.M.e(mvcHttpResponsedMessage);
        this.M.c(mvcHttpMessage);
        this.M.d(mvcNetMessage);
        this.M.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.M);
        qj8 qj8Var = new qj8();
        qj8Var.a = pi.z() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        qj8Var.b = !mvcHttpResponsedMessage.hasError();
        qj8Var.c = mvcHttpResponsedMessage.getError();
        qj8Var.d = mvcHttpResponsedMessage.getErrorString();
        qj8Var.e = mvcHttpResponsedMessage.getDownSize();
        this.H = qj8Var;
        if (mvcHttpResponsedMessage.hasError()) {
            yj8Var = null;
        } else {
            yj8Var = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || yj8Var == null || !I0(r1, yj8Var)) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.a.f(errorData);
        }
    }

    public final int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                int i = frsFragment.M0;
                return (i == -1 || i == this.r) ? 1 : 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hg6
    public void t(int i, int i2, rg6 rg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048646, this, i, i2, rg6Var) == null) {
            this.r = R(i, null);
            if (rg6Var == null && (rg6Var = a0(i, i2)) == null) {
                if (i != 1 && ri.D() && this.y != null) {
                    vg6 vg6Var = new vg6();
                    vg6Var.g = false;
                    vg6Var.c = 1;
                    vg6Var.a = this.g;
                    vg6Var.i = false;
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        vg6Var.b = this.b.getForum().getId();
                    }
                    o0();
                    this.b.setThreadList(this.z);
                    this.y.a(i, i2, vg6Var, this.z);
                }
                rg6Var = new rg6();
                rg6Var.c = -1;
            }
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                rg6Var.b = this.b.getForum().getId();
            }
            rg6Var.a = this.g;
            if (vf6.a().b(1) != null && this.r == 1) {
                this.d.H(i2);
            }
            this.s = i2;
            this.u = rg6Var;
            W0(i, i2, rg6Var);
            A0(5);
        }
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.D == 5 : invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.e.T() : invokeV.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            FrsRequestData frsRequestData = this.d;
            return frsRequestData != null && frsRequestData.E() == 1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hg6
    public void w(lg6 lg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, lg6Var) == null) {
            this.y = lg6Var;
            this.x.e(this.N);
        }
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.D == 7 || (!this.e.f0() && this.F == 7) : invokeV.booleanValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this.r != 1) {
                A0(1);
                return true;
            } else if (this.e.T()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(d0());
                O(frsRequestData, 1, false);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void z0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i) == null) {
            if (this.r != 1) {
                A0(4);
            } else if (this.e.T()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(i);
                frsRequestData.setSortType(d0());
                O(frsRequestData, 4, false);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, messageListener) == null) {
            super.registerListener(messageListener);
        }
    }
}

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
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.az5;
import com.baidu.tieba.bea;
import com.baidu.tieba.c76;
import com.baidu.tieba.dt7;
import com.baidu.tieba.du5;
import com.baidu.tieba.eba;
import com.baidu.tieba.ew7;
import com.baidu.tieba.fba;
import com.baidu.tieba.fj7;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.fw7;
import com.baidu.tieba.g3a;
import com.baidu.tieba.gi7;
import com.baidu.tieba.jj7;
import com.baidu.tieba.kb;
import com.baidu.tieba.l9;
import com.baidu.tieba.nba;
import com.baidu.tieba.pj7;
import com.baidu.tieba.qi7;
import com.baidu.tieba.qr7;
import com.baidu.tieba.rr7;
import com.baidu.tieba.rw7;
import com.baidu.tieba.s95;
import com.baidu.tieba.si7;
import com.baidu.tieba.sy5;
import com.baidu.tieba.t35;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.uba;
import com.baidu.tieba.ui7;
import com.baidu.tieba.uj7;
import com.baidu.tieba.uy9;
import com.baidu.tieba.v76;
import com.baidu.tieba.wg;
import com.baidu.tieba.wx7;
import com.baidu.tieba.wy5;
import com.baidu.tieba.xi;
import com.baidu.tieba.xx9;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
import com.baidu.tieba.z45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements fj7, NetModel.k<FrsRequestData, nba> {
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
    public fba H;
    public String I;
    public final SparseArray<Boolean> J;
    public boolean K;
    public rr7 L;
    public qr7 M;
    public jj7 N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public final FrsFragment a;
    public FrsViewData b;
    public ArrayList<yn> c;
    public FrsRequestData d;
    public FrsNetModel e;
    public final uba f;
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
    public pj7 u;
    public boolean v;
    public SparseArray<pj7> w;
    public ui7 x;
    public jj7 y;
    public ArrayList<yn> z;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int y0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048654, this, i, i2)) == null) ? (i * 10) + i2 : invokeII.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements jj7 {
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

        @Override // com.baidu.tieba.jj7
        public void a(int i, int i2, uj7 uj7Var, ArrayList<yn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), uj7Var, arrayList}) == null) {
                this.a.v = false;
                if (i == this.a.r && this.a.y != null) {
                    this.a.u = uj7Var;
                    this.a.t1(i, i2, uj7Var);
                    ArrayList<yn> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    this.a.b.setThreadList(arrayList2);
                    this.a.y.a(i, i2, uj7Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends wy5<Object> {
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

        @Override // com.baidu.tieba.wy5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                eba.i().c(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends wy5<Object> {
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

        @Override // com.baidu.tieba.wy5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                eba.i().d(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends wy5<Object> {
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

        @Override // com.baidu.tieba.wy5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                eba.i().b(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends BdAsyncTask<Object, nba, Void> {
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
                if (this.c && eba.i().e(this.a)) {
                    if (!eba.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        eba.i().j().getForum().getSignData().is_signed = 0;
                    }
                    nba j = eba.i().j();
                    j.setIsShowRedTip(false);
                    if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (e = wg.e(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e))) != null) {
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
        public void onProgressUpdate(nba... nbaVarArr) {
            nba nbaVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nbaVarArr) == null) {
                super.onProgressUpdate(nbaVarArr);
                FrsModelController frsModelController = this.b;
                if (frsModelController != null && nbaVarArr != null) {
                    if (nbaVarArr.length > 0) {
                        nbaVar = nbaVarArr[0];
                    } else {
                        nbaVar = null;
                    }
                    frsModelController.d1(nbaVar);
                    FrsModelController frsModelController2 = this.b;
                    frsModelController2.l1(frsModelController2.D, true);
                    return;
                }
                FrsModelController frsModelController3 = this.b;
                if (frsModelController3 != null && !frsModelController3.e.B0()) {
                    if (this.b.e.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                        FrsModelController frsModelController4 = this.b;
                        frsModelController4.M((MvcHttpResponsedMessage) frsModelController4.e.getResponsedMessage(), (MvcHttpMessage) this.b.e.y0(), this.b.e.z0());
                    }
                    if (this.b.e.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                        FrsModelController frsModelController5 = this.b;
                        frsModelController5.A((MvcSocketResponsedMessage) frsModelController5.e.getResponsedMessage(), (MvcSocketMessage) this.b.e.y0(), this.b.e.z0());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, uba ubaVar) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, ubaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
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
        this.L = new rr7();
        this.M = new qr7();
        this.N = new a(this);
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        if (ubaVar != null) {
            this.a = frsFragment;
            this.f = ubaVar;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.e = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.a.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.e;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.e.x0(this);
                }
                this.d = this.e.A0();
            }
            N0(this.a);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public void l1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.J.put(i, Boolean.valueOf(z));
        }
    }

    public final void m0(int i, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048631, this, i, frsRequestData) != null) || frsRequestData == null) {
            return;
        }
        if (i != 3) {
            if (i == 4) {
                frsRequestData.q0(2);
                return;
            }
            return;
        }
        frsRequestData.q0(1);
    }

    public final int n0(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048633, this, i, frsRequestData)) == null) {
            if (i == 1 && this.a.C3() != null) {
                return this.a.C3().d(this.D, frsRequestData);
            }
            return i;
        }
        return invokeIL.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, kb kbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i, kbVar) == null) {
            super.registerListener(i, kbVar);
        }
    }

    public pj7 x0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048653, this, i, i2)) == null) {
            return this.w.get(y0(i, i2));
        }
        return (pj7) invokeII.objValue;
    }

    public boolean I0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return this.J.get(i, Boolean.FALSE).booleanValue();
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.fj7
    public void S(jj7 jj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, jj7Var) == null) {
            this.y = jj7Var;
            this.x.e(this.N);
        }
    }

    public void e1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            bundle.putString("name", this.g);
            bundle.putString("from", this.j);
            bundle.putInt("flag", this.k);
        }
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            az5.b(new d(this, str), null);
        }
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            az5.b(new b(this, str), null);
        }
    }

    public void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            az5.b(new c(this, str), null);
        }
    }

    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.G = z;
        }
    }

    public void n1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.K = z;
        }
    }

    public void o1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.E = i;
        }
    }

    public void q1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.n = str;
        }
    }

    @NonNull
    public final ErrorData r0(ResponsedMessage responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, responsedMessage)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048644, this, messageListener) == null) {
            super.registerListener(messageListener);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void A(MvcSocketResponsedMessage<nba, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, nba> mvcSocketMessage, MvcNetMessage<FrsRequestData, nba> mvcNetMessage) {
        nba data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.L.a(this);
        this.L.e(mvcSocketResponsedMessage);
        this.L.c(mvcSocketMessage);
        this.L.d(mvcNetMessage);
        this.L.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.L);
        this.H = fba.a(mvcSocketResponsedMessage);
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
        if (frsRequestData != null && data != null && f1(frsRequestData, data)) {
            return;
        }
        this.a.f(r0(mvcSocketResponsedMessage));
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void M(MvcHttpResponsedMessage<nba> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, nba> mvcHttpMessage, MvcNetMessage<FrsRequestData, nba> mvcNetMessage) {
        nba nbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048589, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.M.a(this);
        this.M.e(mvcHttpResponsedMessage);
        this.M.c(mvcHttpMessage);
        this.M.d(mvcNetMessage);
        this.M.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.M);
        this.H = fba.a(mvcHttpResponsedMessage);
        FrsRequestData frsRequestData = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            nbaVar = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                frsRequestData = mvcHttpMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                frsRequestData = mvcNetMessage.getRequestData();
            }
        } else {
            nbaVar = null;
        }
        if (frsRequestData != null && nbaVar != null && f1(frsRequestData, nbaVar)) {
            return;
        }
        this.a.f(r0(mvcHttpResponsedMessage));
    }

    public void b1(MvcSocketResponsedMessage<nba, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, nba> mvcSocketMessage, MvcNetMessage<FrsRequestData, nba> mvcNetMessage) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048607, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (!this.B) {
                this.B = true;
                Y0(1000, false, mvcSocketResponsedMessage);
            } else {
                a1(false, mvcSocketResponsedMessage);
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
                    str = frsRequestData.Z();
                }
                objArr[1] = str;
                objArr[2] = PushConstants.SEQ_ID;
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                s95.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    public int A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ew7.d(this.D);
        }
        return invokeV.intValue;
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public FrsViewData D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public long E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.R;
        }
        return invokeV.longValue;
    }

    public long F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.O;
        }
        return invokeV.longValue;
    }

    public long G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.Q;
        }
        return invokeV.longValue;
    }

    public long H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.P;
        }
        return invokeV.longValue;
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.z.size() == 0) {
                this.z.add(new qi7());
            }
        }
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                int i = frsFragment.O0;
                if (i == -1 || i == this.r) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.D == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.e.p0();
        }
        return invokeV.booleanValue;
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            FrsRequestData frsRequestData = this.d;
            if (frsRequestData != null && frsRequestData.a0() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.D != 7 && (this.e.B0() || this.F != 7)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.e.cancelLoadData();
        }
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            pj7 pj7Var = this.u;
            if (!(pj7Var instanceof uj7) || ((uj7) pj7Var).e != 0) {
                return true;
            }
            return ((uj7) pj7Var).g;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fj7
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.x.d();
        }
    }

    public int p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public final boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            this.O = System.currentTimeMillis();
            wx7.a();
            return this.e.loadData();
        }
        return invokeV.booleanValue;
    }

    public fba s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.H;
        }
        return (fba) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fj7
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.x.b();
            this.x.clear();
        }
    }

    public FrsRequestData t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.d;
        }
        return (FrsRequestData) invokeV.objValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            if (1 == this.r) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public ArrayList<yn> w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<yn> arrayList = this.c;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<yn> it = this.c.iterator();
                while (it.hasNext()) {
                    yn next = it.next();
                    if (next instanceof z45) {
                        if (((z45) next).t.getIs_top() == 0) {
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

    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(wg.g(this.b.getForum().getId(), 0L));
            }
            this.a.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            gi7 gi7Var = new gi7();
            if (this.t == 0) {
                gi7Var.b(this.D);
            }
            if (this.b.getThreadList() != null) {
                this.b.getThreadList().clear();
                this.b.getThreadList().add(gi7Var);
            }
            ArrayList<yn> arrayList = this.c;
            if (arrayList != null) {
                arrayList.clear();
                this.c.add(gi7Var);
            }
        }
    }

    public void s1() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048646, this) != null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    public void J0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
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
            M0();
            if (this.b == null) {
                this.b = new FrsViewData();
            }
            if (this.e == null || (frsRequestData = this.d) == null || frsRequestData.T() == null || this.d.T().isEmpty() || this.d.T().containsKey(null) || this.d.T().containsValue(null)) {
                K0(bundle);
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

    public final void K0(Bundle bundle) {
        int i;
        ArrayList<yn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.d = frsRequestData;
            frsRequestData.setSortType(ew7.d(this.D));
            if (this.D == 5) {
                this.d.k0(1);
            } else {
                this.d.k0(0);
            }
            this.d.V("forum_name", xi.getUrlEncode(this.g));
            this.d.V("client_type", "2");
            this.d.setPn(1);
            if (bundle != null) {
                this.d.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.d.i0(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.d.s0("2");
            this.d.t0("-2");
            this.d.m0(this.g);
            this.d.A0(1);
            this.d.e0(0);
            this.d.z0(yi.l(TbadkCoreApplication.getInst()));
            this.d.y0(yi.j(TbadkCoreApplication.getInst()));
            this.d.x0(yi.i(TbadkCoreApplication.getInst()));
            FrsRequestData frsRequestData2 = this.d;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            frsRequestData2.C0(i);
            this.d.w0(this.n);
            this.d.o0(null);
            this.d.B0(this.C);
            this.d.n0(wg.g(sy5.a(), 0L));
            this.d.setStType(this.j);
            this.d.j0(1);
            this.d.setNeedCache(true);
            this.d.setUpdateType(3);
            FrsRequestData frsRequestData3 = this.d;
            FrsViewData frsViewData = this.b;
            if (frsViewData == null) {
                threadList = null;
            } else {
                threadList = frsViewData.getThreadList();
            }
            frsRequestData3.c0(xx9.e(threadList, true));
            ew7.e(this.D, this.d);
            this.d.q0(1);
            if (ThreadData.isRecAppLoaded.get() && uy9.m().b() != null) {
                int d2 = uy9.m().b().d(this.g, false);
                int e2 = uy9.m().b().e(this.g, false);
                if (this.d.a0() == 1) {
                    d2++;
                } else if (this.d.a0() == 2) {
                    e2++;
                }
                this.d.u0(d2);
                this.d.p0(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.d);
            this.e = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.a.getActivity()).getUniqueId());
            this.e.x0(this);
            this.e.loadData();
            wx7.a();
        }
    }

    public final void M0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
                k1(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
                k1(6);
            } else {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                this.F = ew7.h("1~" + str + this.g);
                k1(this.D);
            }
        }
    }

    @Override // com.baidu.tieba.fj7
    public void N(int i, int i2, pj7 pj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048591, this, i, i2, pj7Var) == null) {
            this.r = n0(i, null);
            if (pj7Var == null && (pj7Var = x0(i, i2)) == null) {
                if (i != 1 && yi.G() && this.y != null) {
                    uj7 uj7Var = new uj7();
                    uj7Var.g = false;
                    uj7Var.c = 1;
                    uj7Var.a = this.g;
                    uj7Var.i = false;
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        uj7Var.b = this.b.getForum().getId();
                    }
                    L0();
                    this.b.setThreadList(this.z);
                    this.y.a(i, i2, uj7Var, this.z);
                }
                pj7Var = new pj7();
                pj7Var.c = -1;
            }
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                pj7Var.b = this.b.getForum().getId();
            }
            pj7Var.a = this.g;
            if (si7.a().b(1) != null && this.r == 1) {
                this.d.d0(i2);
            }
            this.s = i2;
            this.u = pj7Var;
            t1(i, i2, pj7Var);
            X0(5);
        }
    }

    public final void Y0(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) {
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
            du5 du5Var = new du5(i, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
            FrsFragment frsFragment3 = this.a;
            frsFragment3.F = 0L;
            frsFragment3.E = 0L;
            fw7.f(this, frsFragment3.B);
            this.a.B = -1L;
            du5Var.c();
        }
    }

    public final void N0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, frsFragment) == null) {
            ui7 ui7Var = new ui7();
            this.x = ui7Var;
            ui7Var.a = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.x));
            this.x.e(this.N);
        }
    }

    public void W0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            if (this.r != 1) {
                X0(4);
            } else if (this.e.p0()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(i);
                frsRequestData.setSortType(A0());
                k0(frsRequestData, 4, false);
            }
        }
    }

    public final void d1(nba nbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, nbaVar) == null) {
            this.isCacheFirstLoad = false;
            this.b.receiveData(nbaVar);
            i1(this.b);
            this.c = new ArrayList<>();
            if (this.b.getThreadList() != null) {
                this.c.addAll(this.b.getThreadList());
            }
            this.f.c(nbaVar);
        }
    }

    public final void i1(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, frsViewData) == null) {
            if (rw7.c0(frsViewData)) {
                this.l = "book_page";
            } else if (frsViewData.getIsBrandForum()) {
                this.l = "brand_page";
            } else if (rw7.d0(frsViewData)) {
                this.l = "frs_page";
            } else {
                this.l = "normal_page";
            }
        }
    }

    public final void j1(nba nbaVar) {
        FrsFragment frsFragment;
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048625, this, nbaVar) != null) || nbaVar == null || (frsFragment = this.a) == null || frsFragment.getActivity() == null || (intent = this.a.getActivity().getIntent()) == null) {
            return;
        }
        g3a.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), nbaVar.getForum().getId());
    }

    public boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.r != 1) {
                X0(1);
                return true;
            } else if (this.e.p0()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(A0());
                k0(frsRequestData, 1, false);
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
    public final void X0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.h = i;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        pj7 pj7Var = this.u;
                        if (pj7Var != null) {
                            pj7Var.c = -1;
                        }
                    }
                } else {
                    pj7 pj7Var2 = this.u;
                    if (pj7Var2 != null) {
                        pj7Var2.c--;
                    }
                }
                i2 = this.r;
                if (i2 != 1) {
                    if (this.t == this.s) {
                        ArrayList<yn> arrayList = new ArrayList<>();
                        ArrayList<yn> arrayList2 = this.c;
                        if (arrayList2 != null) {
                            arrayList.addAll(arrayList2);
                        }
                        this.b.setThreadList(arrayList);
                        jj7 jj7Var = this.y;
                        if (jj7Var != null) {
                            jj7Var.a(this.r, this.s, null, arrayList);
                        }
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                    }
                    this.t = this.s;
                    return;
                }
                fj7 c2 = this.x.c(i2);
                if (c2 != null) {
                    this.v = true;
                    c2.N(this.r, this.s, this.u);
                    return;
                }
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getThreadList() != null) {
                    this.b.getThreadList().clear();
                }
                this.y.a(this.r, this.s, null, null);
                return;
            }
            pj7 pj7Var3 = this.u;
            if (pj7Var3 != null) {
                pj7Var3.c++;
            }
            i2 = this.r;
            if (i2 != 1) {
            }
        }
    }

    public void Z0(MvcHttpResponsedMessage<nba> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, nba> mvcHttpMessage, MvcNetMessage<FrsRequestData, nba> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                    str = frsRequestData.Z();
                }
                objArr[1] = str;
                s95.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
            }
            if (!this.B) {
                this.B = true;
                Y0(1000, true, mvcHttpResponsedMessage);
                return;
            }
            a1(true, mvcHttpResponsedMessage);
        }
    }

    public final void a1(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048606, this, z, responsedMessage) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FrsFragment frsFragment = this.a;
        this.A = currentTimeMillis - frsFragment.I;
        long currentTimeMillis2 = System.currentTimeMillis();
        FrsFragment frsFragment2 = this.a;
        frsFragment.D = currentTimeMillis2 - frsFragment2.C;
        du5 du5Var = new du5(1000, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
        int i = this.h;
        if (i == 4) {
            du5Var.B = this.A;
            du5Var.e(true);
        } else if (i == 3) {
            du5Var.C = this.A;
            du5Var.e(false);
        }
    }

    public void o0(int i, boolean z) {
        ArrayList<yn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.a.I = System.currentTimeMillis();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.b.getLikeFeedForumDataList().clear();
            }
            this.r = n0(this.r, this.d);
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 == null) {
                threadList = null;
            } else {
                threadList = frsViewData2.getThreadList();
            }
            frsRequestData.c0(xx9.e(threadList, true));
            if (this.r == 1) {
                l0(this.d, i, !z);
                return;
            }
            if (this.u == null) {
                pj7 pj7Var = new pj7();
                this.u = pj7Var;
                pj7Var.c = 1;
                pj7Var.a = this.g;
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.u.b = this.b.getForum().getId();
                }
            }
            X0(i);
        }
    }

    public void f0(t35 t35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, t35Var) == null) && t35Var != null && !StringUtils.isNull(t35Var.getId()) && !ListUtils.isEmpty(this.c)) {
            if (this.r == 1) {
                this.b.addMyNewThread(t35Var);
            }
            int C0 = C0();
            Iterator<yn> it = this.c.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if ((next instanceof z45) && t35Var.getId().equals(((z45) next).t.getId())) {
                    return;
                }
            }
            this.c.add(C0, t35Var);
        }
    }

    public void k1(int i) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            this.D = i;
            if (i != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                ew7.i("1~" + str + this.g, this.D);
            }
            if (7 == i) {
                bea.b();
            } else {
                bea.a();
            }
        }
    }

    public boolean f1(FrsRequestData frsRequestData, nba nbaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, frsRequestData, nbaVar)) == null) {
            if (nbaVar == null || nbaVar.getForum() == null || (xi.isEmpty(nbaVar.getForum().getName()) && 340001 != nbaVar.mErrorNo)) {
                return false;
            }
            if (nbaVar.getDataParseTime() > 0) {
                this.a.H = nbaVar.getDataParseTime();
            }
            if (nbaVar.getEntelechyTabInfo() != null && !ListUtils.isEmpty(nbaVar.getEntelechyTabInfo().a)) {
                int intValue = nbaVar.getEntelechyTabInfo().a.get(0).tab_type.intValue();
                AbsDataRecorder.Scene scene = AbsDataRecorder.Scene.FRS_HOT;
                this.a.M4(13);
                if (intValue == 14) {
                    scene = AbsDataRecorder.Scene.FRS_NEW;
                    this.a.M4(14);
                }
                if (c76.k().l(scene)) {
                    c76.k().g(scene).b();
                }
                if (v76.i().o(scene)) {
                    v76.i().g(scene).b();
                }
            }
            k1(ew7.f(nbaVar.getSortType()));
            l1(ew7.f(nbaVar.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.r = nbaVar.getFrsDefaultTabId();
            }
            this.b.receiveData(nbaVar);
            i1(this.b);
            this.c = new ArrayList<>();
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.i = frsRequestData.getPn();
                String Z = this.d.Z();
                this.g = Z;
                this.a.O4(Z);
                this.a.setFrom(this.j);
                this.a.b5(this.i);
                this.a.N4(this.k);
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
            if (dt7.b(this.d)) {
                h1();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.c4();
                }
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.b.getForum()));
            }
            this.isNetFirstLoad = false;
            if (nbaVar.getForum() != null && !TextUtils.isEmpty(nbaVar.getForum().getName()) && frsRequestData != null && uy9.m().b() != null) {
                uy9.m().b().g(nbaVar.getForum().getName(), frsRequestData.a0(), false);
            }
            if (this.a != null && !StringUtils.isNull(nbaVar.getUserData().getAppealThreadPopover())) {
                this.a.k5(TbadkCoreApplication.getCurrentAccount(), nbaVar.getForum().getId(), nbaVar.getUserData().getAppealThreadPopover());
            }
            j1(nbaVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void g0(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048614, this, str, frsRequestData) != null) || !ThreadData.isRecAppLoaded.get() || uy9.m().b() == null) {
            return;
        }
        int d2 = uy9.m().b().d(str, false);
        int e2 = uy9.m().b().e(str, false);
        if (frsRequestData.a0() == 1) {
            d2++;
        } else if (frsRequestData.a0() == 2) {
            e2++;
        }
        frsRequestData.u0(d2);
        frsRequestData.p0(e2);
    }

    public void g1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == null) {
            return;
        }
        this.a.I = System.currentTimeMillis();
        FrsViewData frsViewData = this.b;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.b.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(1);
        int n0 = n0(this.r, frsRequestData);
        this.r = n0;
        if (n0 == 1) {
            if (this.e.p0()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            k0(frsRequestData, i, !z);
            return;
        }
        if (this.u == null) {
            pj7 pj7Var = new pj7();
            this.u = pj7Var;
            pj7Var.c = 1;
            pj7Var.a = this.g;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.u.b = this.b.getForum().getId();
            }
        }
        X0(i);
    }

    public final void k0(FrsRequestData frsRequestData, int i, boolean z) {
        String str;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.H4(z);
            this.f.a(i);
            this.e.C0(frsRequestData);
            if (this.a.k4()) {
                str = "1";
            } else {
                str = "2";
            }
            frsRequestData.s0(str);
            if (this.G) {
                frsRequestData.t0(String.valueOf(ew7.d(this.E)));
            } else {
                frsRequestData.t0("-2");
            }
            this.G = false;
            frsRequestData.m0(this.g);
            frsRequestData.A0(1);
            frsRequestData.e0(0);
            int l = yi.l(TbadkCoreApplication.getInst());
            int j = yi.j(TbadkCoreApplication.getInst());
            float i3 = yi.i(TbadkCoreApplication.getInst());
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            frsRequestData.z0(l);
            frsRequestData.y0(j);
            frsRequestData.x0(i3);
            frsRequestData.C0(i2);
            frsRequestData.w0(this.n);
            frsRequestData.o0(this.p);
            frsRequestData.B0(this.C);
            frsRequestData.n0(wg.g(sy5.a(), 0L));
            String str2 = this.o;
            ArrayList<yn> arrayList = null;
            if (str2 != null) {
                frsRequestData.setStType(str2);
                if ("sidebar".equalsIgnoreCase(this.o)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.j0(P0());
            if (FrsFragment.v2 != 0) {
                frsRequestData.f0((int) FrsFragment.v2);
            }
            if (FrsFragment.w2 != 0) {
                frsRequestData.g0((int) FrsFragment.w2);
            }
            if (FrsFragment.x2 != 0) {
                frsRequestData.r0(FrsFragment.x2);
            }
            if (frsRequestData.getPn() != 1 && this.h != 3) {
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    arrayList = frsViewData.getThreadList();
                }
                frsRequestData.c0(xx9.e(arrayList, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    arrayList = frsViewData2.getThreadList();
                }
                frsRequestData.c0(xx9.e(arrayList, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.h);
            frsRequestData.i0(this.q);
            ew7.e(this.D, frsRequestData);
            int d2 = ew7.d(this.F);
            m0(i, frsRequestData);
            g0(this.g, frsRequestData);
            if (!I0(this.F) && !this.a.i && !this.K) {
                eba i4 = eba.i();
                String g = i4.g("1~" + this.g, d2, frsRequestData.Y(), this.d.W());
                this.I = g;
                new e(this, true, g).execute(new Object[0]);
            }
            r1();
            this.K = false;
        }
    }

    public final void l0(FrsRequestData frsRequestData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.H4(z);
            this.f.a(i);
            if (this.e.B0() && (this.e.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                M((MvcHttpResponsedMessage) this.e.getResponsedMessage(), (MvcHttpMessage) this.e.y0(), this.e.z0());
            } else if (this.e.B0() && (this.e.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                A((MvcSocketResponsedMessage) this.e.getResponsedMessage(), (MvcSocketMessage) this.e.y0(), this.e.z0());
            } else {
                int d2 = ew7.d(this.F);
                if (!I0(this.F) && !this.a.i && !this.K) {
                    eba i2 = eba.i();
                    String g = i2.g("1~" + this.g, d2, frsRequestData.Y(), this.d.W());
                    this.I = g;
                    new e(this, true, g).execute(new Object[0]);
                }
                this.K = false;
            }
            this.e.x0(this);
        }
    }

    public final void t1(int i, int i2, pj7 pj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048649, this, i, i2, pj7Var) == null) {
            this.w.put(y0(i, i2), pj7Var);
        }
    }
}

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
import com.baidu.tieba.a8a;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.aga;
import com.baidu.tieba.b35;
import com.baidu.tieba.bga;
import com.baidu.tieba.bj7;
import com.baidu.tieba.bk7;
import com.baidu.tieba.by5;
import com.baidu.tieba.cn;
import com.baidu.tieba.ds7;
import com.baidu.tieba.ei;
import com.baidu.tieba.es7;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.ft5;
import com.baidu.tieba.fx7;
import com.baidu.tieba.h45;
import com.baidu.tieba.i3a;
import com.baidu.tieba.jga;
import com.baidu.tieba.ky7;
import com.baidu.tieba.l2a;
import com.baidu.tieba.mj7;
import com.baidu.tieba.ni7;
import com.baidu.tieba.q66;
import com.baidu.tieba.qga;
import com.baidu.tieba.qj7;
import com.baidu.tieba.qt7;
import com.baidu.tieba.sw7;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tw7;
import com.baidu.tieba.tx5;
import com.baidu.tieba.wj7;
import com.baidu.tieba.x56;
import com.baidu.tieba.xi7;
import com.baidu.tieba.xx5;
import com.baidu.tieba.yia;
import com.baidu.tieba.zi7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements mj7, NetModel.k<FrsRequestData, jga> {
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
    public bga H;
    public String I;
    public final SparseArray<Boolean> J;
    public boolean K;
    public es7 L;
    public ds7 M;
    public qj7 N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public final FrsFragment a;
    public FrsViewData b;
    public ArrayList<cn> c;
    public FrsRequestData d;
    public FrsNetModel e;
    public final qga f;
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
    public wj7 u;
    public boolean v;
    public SparseArray<wj7> w;
    public bj7 x;
    public qj7 y;
    public ArrayList<cn> z;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int p0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048642, this, i, i2)) == null) ? (i * 10) + i2 : invokeII.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements qj7 {
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

        @Override // com.baidu.tieba.qj7
        public void a(int i, int i2, bk7 bk7Var, ArrayList<cn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), bk7Var, arrayList}) == null) {
                this.a.v = false;
                if (i == this.a.r && this.a.y != null) {
                    this.a.u = bk7Var;
                    this.a.k1(i, i2, bk7Var);
                    ArrayList<cn> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    this.a.b.setThreadList(arrayList2);
                    this.a.y.a(i, i2, bk7Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends xx5<Object> {
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

        @Override // com.baidu.tieba.xx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                aga.i().c(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends xx5<Object> {
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

        @Override // com.baidu.tieba.xx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                aga.i().d(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends xx5<Object> {
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

        @Override // com.baidu.tieba.xx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                aga.i().b(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends BdAsyncTask<Object, jga, Void> {
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
                if (this.c && aga.i().e(this.a)) {
                    if (!aga.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        aga.i().j().getForum().getSignData().is_signed = 0;
                    }
                    jga j = aga.i().j();
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
        public void onProgressUpdate(jga... jgaVarArr) {
            jga jgaVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jgaVarArr) == null) {
                super.onProgressUpdate(jgaVarArr);
                FrsModelController frsModelController = this.b;
                if (frsModelController != null && jgaVarArr != null) {
                    if (jgaVarArr.length > 0) {
                        jgaVar = jgaVarArr[0];
                    } else {
                        jgaVar = null;
                    }
                    frsModelController.U0(jgaVar);
                    FrsModelController frsModelController2 = this.b;
                    frsModelController2.c1(frsModelController2.D, true);
                    return;
                }
                FrsModelController frsModelController3 = this.b;
                if (frsModelController3 != null && !frsModelController3.e.s0()) {
                    if (this.b.e.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                        FrsModelController frsModelController4 = this.b;
                        frsModelController4.G((MvcHttpResponsedMessage) frsModelController4.e.getResponsedMessage(), (MvcHttpMessage) this.b.e.p0(), this.b.e.q0());
                    }
                    if (this.b.e.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                        FrsModelController frsModelController5 = this.b;
                        frsModelController5.v((MvcSocketResponsedMessage) frsModelController5.e.getResponsedMessage(), (MvcSocketMessage) this.b.e.p0(), this.b.e.q0());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, qga qgaVar) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, qgaVar};
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
        this.L = new es7();
        this.M = new ds7();
        this.N = new a(this);
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        if (qgaVar != null) {
            this.a = frsFragment;
            this.f = qgaVar;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.e = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.a.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.e;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.e.o0(this);
                }
                this.d = this.e.r0();
            }
            E0(this.a);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public void c1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.J.put(i, Boolean.valueOf(z));
        }
    }

    public final void d0(int i, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048616, this, i, frsRequestData) != null) || frsRequestData == null) {
            return;
        }
        if (i != 3) {
            if (i == 4) {
                frsRequestData.h0(2);
                return;
            }
            return;
        }
        frsRequestData.h0(1);
    }

    public final int e0(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048618, this, i, frsRequestData)) == null) {
            if (i == 1 && this.a.R3() != null) {
                return this.a.R3().d(this.D, frsRequestData);
            }
            return i;
        }
        return invokeIL.intValue;
    }

    public wj7 o0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048640, this, i, i2)) == null) {
            return this.w.get(p0(i, i2));
        }
        return (wj7) invokeII.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, NetMessageListener netMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048645, this, i, netMessageListener) == null) {
            super.registerListener(i, netMessageListener);
        }
    }

    @Override // com.baidu.tieba.mj7
    public void L(qj7 qj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, qj7Var) == null) {
            this.y = qj7Var;
            this.x.e(this.N);
        }
    }

    public void V0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            bundle.putString("name", this.g);
            bundle.putString("from", this.j);
            bundle.putInt("flag", this.k);
        }
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            by5.b(new d(this, str), null);
        }
    }

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            by5.b(new b(this, str), null);
        }
    }

    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            by5.b(new c(this, str), null);
        }
    }

    public void d1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.G = z;
        }
    }

    public void e1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.K = z;
        }
    }

    public void f1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.E = i;
        }
    }

    public void h1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.n = str;
        }
    }

    @NonNull
    public final ErrorData i0(ResponsedMessage responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, responsedMessage)) == null) {
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

    public boolean z0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048655, this, i)) == null) {
            return this.J.get(i, Boolean.FALSE).booleanValue();
        }
        return invokeI.booleanValue;
    }

    public void A0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
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
            D0();
            if (this.b == null) {
                this.b = new FrsViewData();
            }
            if (this.e == null || (frsRequestData = this.d) == null || frsRequestData.getHttpHeader() == null || this.d.getHttpHeader().isEmpty() || this.d.getHttpHeader().containsKey(null) || this.d.getHttpHeader().containsValue(null)) {
                B0(bundle);
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

    public final void B0(Bundle bundle) {
        int i;
        ArrayList<cn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.d = frsRequestData;
            frsRequestData.setSortType(sw7.d(this.D));
            if (this.D == 5) {
                this.d.b0(1);
            } else {
                this.d.b0(0);
            }
            this.d.M("forum_name", ei.getUrlEncode(this.g));
            this.d.M("client_type", "2");
            this.d.setPn(1);
            if (bundle != null) {
                this.d.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.d.Z(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.d.j0("2");
            this.d.k0("-2");
            this.d.d0(this.g);
            this.d.r0(1);
            this.d.V(0);
            this.d.q0(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            this.d.p0(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            this.d.o0(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst()));
            FrsRequestData frsRequestData2 = this.d;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            frsRequestData2.t0(i);
            this.d.n0(this.n);
            this.d.f0(null);
            this.d.s0(this.C);
            this.d.e0(JavaTypesHelper.toLong(tx5.a(), 0L));
            this.d.setStType(this.j);
            this.d.a0(1);
            this.d.setNeedCache(true);
            this.d.setUpdateType(3);
            FrsRequestData frsRequestData3 = this.d;
            FrsViewData frsViewData = this.b;
            if (frsViewData == null) {
                threadList = null;
            } else {
                threadList = frsViewData.getThreadList();
            }
            frsRequestData3.T(l2a.e(threadList, true));
            sw7.e(this.D, this.d);
            this.d.h0(1);
            if (ThreadData.isRecAppLoaded.get() && i3a.m().b() != null) {
                int d2 = i3a.m().b().d(this.g, false);
                int e2 = i3a.m().b().e(this.g, false);
                if (this.d.R() == 1) {
                    d2++;
                } else if (this.d.R() == 2) {
                    e2++;
                }
                this.d.l0(d2);
                this.d.g0(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.d);
            this.e = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.a.getActivity()).getUniqueId());
            this.e.o0(this);
            this.e.loadData();
            ky7.a();
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.z.size() == 0) {
                this.z.add(new xi7());
            }
        }
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.D == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e.g0();
        }
        return invokeV.booleanValue;
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            FrsRequestData frsRequestData = this.d;
            if (frsRequestData != null && frsRequestData.R() == 1) {
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
            if (this.D != 7 && (this.e.s0() || this.F != 7)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.e.cancelLoadData();
        }
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            wj7 wj7Var = this.u;
            if (!(wj7Var instanceof bk7) || ((bk7) wj7Var).e != 0) {
                return true;
            }
            return ((bk7) wj7Var).g;
        }
        return invokeV.booleanValue;
    }

    public final boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            this.O = System.currentTimeMillis();
            ky7.a();
            return this.e.loadData();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mj7
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.x.d();
        }
    }

    public bga j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.H;
        }
        return (bga) invokeV.objValue;
    }

    public FrsRequestData k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.d;
        }
        return (FrsRequestData) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (1 == this.r) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public ArrayList<cn> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mj7
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.x.b();
            this.x.clear();
        }
    }

    public String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return sw7.d(this.D);
        }
        return invokeV.intValue;
    }

    public int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public FrsViewData u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.b;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public long v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.R;
        }
        return invokeV.longValue;
    }

    public long w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.O;
        }
        return invokeV.longValue;
    }

    public long x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.Q;
        }
        return invokeV.longValue;
    }

    public long y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.P;
        }
        return invokeV.longValue;
    }

    public final void D0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
                b1(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
                b1(6);
            } else {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                this.F = sw7.h("1~" + str + this.g);
                b1(this.D);
            }
        }
    }

    public final void E0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, frsFragment) == null) {
            bj7 bj7Var = new bj7();
            this.x = bj7Var;
            bj7Var.a = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.x));
            this.x.e(this.N);
        }
    }

    public void N0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (this.r != 1) {
                O0(4);
            } else if (this.e.g0()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(i);
                frsRequestData.setSortType(r0());
                b0(frsRequestData, 4, false);
            }
        }
    }

    public final void U0(jga jgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, jgaVar) == null) {
            this.isCacheFirstLoad = false;
            this.b.receiveData(jgaVar);
            Z0(this.b);
            this.c = new ArrayList<>();
            if (this.b.getThreadList() != null) {
                this.c.addAll(this.b.getThreadList());
            }
            this.f.c(jgaVar);
        }
    }

    public final void Z0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, frsViewData) == null) {
            if (fx7.b0(frsViewData)) {
                this.l = "book_page";
            } else if (frsViewData.getIsBrandForum()) {
                this.l = "brand_page";
            } else if (fx7.c0(frsViewData)) {
                this.l = "frs_page";
            } else {
                this.l = "normal_page";
            }
        }
    }

    public final void a1(jga jgaVar) {
        FrsFragment frsFragment;
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, jgaVar) != null) || jgaVar == null || (frsFragment = this.a) == null || frsFragment.getActivity() == null || (intent = this.a.getActivity().getIntent()) == null) {
            return;
        }
        a8a.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), jgaVar.getForum().getId());
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void G(MvcHttpResponsedMessage<jga> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, jga> mvcHttpMessage, MvcNetMessage<FrsRequestData, jga> mvcNetMessage) {
        jga jgaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.M.a(this);
        this.M.e(mvcHttpResponsedMessage);
        this.M.c(mvcHttpMessage);
        this.M.d(mvcNetMessage);
        this.M.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.M);
        this.H = bga.a(mvcHttpResponsedMessage);
        FrsRequestData frsRequestData = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            jgaVar = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                frsRequestData = mvcHttpMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                frsRequestData = mvcNetMessage.getRequestData();
            }
        } else {
            jgaVar = null;
        }
        if (frsRequestData != null && jgaVar != null && W0(frsRequestData, jgaVar)) {
            return;
        }
        this.a.f(i0(mvcHttpResponsedMessage));
    }

    public void S0(MvcSocketResponsedMessage<jga, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, jga> mvcSocketMessage, MvcNetMessage<FrsRequestData, jga> mvcNetMessage) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (!this.B) {
                this.B = true;
                P0(1000, false, mvcSocketResponsedMessage);
            } else {
                R0(false, mvcSocketResponsedMessage);
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
                    str = frsRequestData.Q();
                }
                objArr[1] = str;
                objArr[2] = PushConstants.SEQ_ID;
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                Logger.addLog("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void v(MvcSocketResponsedMessage<jga, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, jga> mvcSocketMessage, MvcNetMessage<FrsRequestData, jga> mvcNetMessage) {
        jga data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048650, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.L.a(this);
        this.L.e(mvcSocketResponsedMessage);
        this.L.c(mvcSocketMessage);
        this.L.d(mvcNetMessage);
        this.L.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.L);
        this.H = bga.a(mvcSocketResponsedMessage);
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
        if (frsRequestData != null && data != null && W0(frsRequestData, data)) {
            return;
        }
        this.a.f(i0(mvcSocketResponsedMessage));
    }

    @Override // com.baidu.tieba.mj7
    public void H(int i, int i2, wj7 wj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, wj7Var) == null) {
            this.r = e0(i, null);
            if (wj7Var == null && (wj7Var = o0(i, i2)) == null) {
                if (i != 1 && BdUtilHelper.isNetOk() && this.y != null) {
                    bk7 bk7Var = new bk7();
                    bk7Var.g = false;
                    bk7Var.c = 1;
                    bk7Var.a = this.g;
                    bk7Var.i = false;
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        bk7Var.b = this.b.getForum().getId();
                    }
                    C0();
                    this.b.setThreadList(this.z);
                    this.y.a(i, i2, bk7Var, this.z);
                }
                wj7Var = new wj7();
                wj7Var.c = -1;
            }
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                wj7Var.b = this.b.getForum().getId();
            }
            wj7Var.a = this.g;
            if (zi7.a().b(1) != null && this.r == 1) {
                this.d.U(i2);
            }
            this.s = i2;
            this.u = wj7Var;
            k1(i, i2, wj7Var);
            O0(5);
        }
    }

    public final void P0(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) {
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
            ft5 ft5Var = new ft5(i, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
            FrsFragment frsFragment3 = this.a;
            frsFragment3.F = 0L;
            frsFragment3.E = 0L;
            tw7.g(this, frsFragment3.B);
            this.a.B = -1L;
            ft5Var.c();
        }
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.r != 1) {
                O0(1);
                return true;
            } else if (this.e.g0()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(r0());
                b0(frsRequestData, 1, false);
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
    public final void O0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.h = i;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        wj7 wj7Var = this.u;
                        if (wj7Var != null) {
                            wj7Var.c = -1;
                        }
                    }
                } else {
                    wj7 wj7Var2 = this.u;
                    if (wj7Var2 != null) {
                        wj7Var2.c--;
                    }
                }
                i2 = this.r;
                if (i2 != 1) {
                    if (this.t == this.s) {
                        ArrayList<cn> arrayList = new ArrayList<>();
                        ArrayList<cn> arrayList2 = this.c;
                        if (arrayList2 != null) {
                            arrayList.addAll(arrayList2);
                        }
                        this.b.setThreadList(arrayList);
                        qj7 qj7Var = this.y;
                        if (qj7Var != null) {
                            qj7Var.a(this.r, this.s, null, arrayList);
                        }
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                    }
                    this.t = this.s;
                    return;
                }
                mj7 c2 = this.x.c(i2);
                if (c2 != null) {
                    this.v = true;
                    c2.H(this.r, this.s, this.u);
                    return;
                }
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getThreadList() != null) {
                    this.b.getThreadList().clear();
                }
                this.y.a(this.r, this.s, null, null);
                return;
            }
            wj7 wj7Var3 = this.u;
            if (wj7Var3 != null) {
                wj7Var3.c++;
            }
            i2 = this.r;
            if (i2 != 1) {
            }
        }
    }

    public void Q0(MvcHttpResponsedMessage<jga> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, jga> mvcHttpMessage, MvcNetMessage<FrsRequestData, jga> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                    str = frsRequestData.Q();
                }
                objArr[1] = str;
                Logger.addLog("frs", j2, cmd, "http_resp", error, errorString, objArr);
            }
            if (!this.B) {
                this.B = true;
                P0(1000, true, mvcHttpResponsedMessage);
                return;
            }
            R0(true, mvcHttpResponsedMessage);
        }
    }

    public final void R0(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048596, this, z, responsedMessage) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FrsFragment frsFragment = this.a;
        this.A = currentTimeMillis - frsFragment.I;
        long currentTimeMillis2 = System.currentTimeMillis();
        FrsFragment frsFragment2 = this.a;
        frsFragment.D = currentTimeMillis2 - frsFragment2.C;
        ft5 ft5Var = new ft5(1000, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
        int i = this.h;
        if (i == 4) {
            ft5Var.B = this.A;
            ft5Var.e(true);
        } else if (i == 3) {
            ft5Var.C = this.A;
            ft5Var.e(false);
        }
    }

    public void f0(int i, boolean z) {
        ArrayList<cn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.a.I = System.currentTimeMillis();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.b.getLikeFeedForumDataList().clear();
            }
            this.r = e0(this.r, this.d);
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 == null) {
                threadList = null;
            } else {
                threadList = frsViewData2.getThreadList();
            }
            frsRequestData.T(l2a.e(threadList, true));
            if (this.r == 1) {
                c0(this.d, i, !z);
                return;
            }
            if (this.u == null) {
                wj7 wj7Var = new wj7();
                this.u = wj7Var;
                wj7Var.c = 1;
                wj7Var.a = this.g;
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.u.b = this.b.getForum().getId();
                }
            }
            O0(i);
        }
    }

    public void W(b35 b35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, b35Var) == null) && b35Var != null && !StringUtils.isNull(b35Var.getId()) && !ListUtils.isEmpty(this.c)) {
            if (this.r == 1) {
                this.b.addMyNewThread(b35Var);
            }
            int t0 = t0();
            Iterator<cn> it = this.c.iterator();
            while (it.hasNext()) {
                cn next = it.next();
                if ((next instanceof h45) && b35Var.getId().equals(((h45) next).t.getId())) {
                    return;
                }
            }
            this.c.add(t0, b35Var);
        }
    }

    public void b1(int i) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.D = i;
            if (i != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                sw7.i("1~" + str + this.g, this.D);
            }
            if (7 == i) {
                yia.b();
            } else {
                yia.a();
            }
        }
    }

    public boolean W0(FrsRequestData frsRequestData, jga jgaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, frsRequestData, jgaVar)) == null) {
            if (jgaVar == null || jgaVar.getForum() == null || (ei.isEmpty(jgaVar.getForum().getName()) && 340001 != jgaVar.mErrorNo)) {
                return false;
            }
            if (jgaVar.getDataParseTime() > 0) {
                this.a.H = jgaVar.getDataParseTime();
            }
            if (jgaVar.getEntelechyTabInfo() != null && !ListUtils.isEmpty(jgaVar.getEntelechyTabInfo().a)) {
                int intValue = jgaVar.getEntelechyTabInfo().a.get(0).tab_type.intValue();
                AbsDataRecorder.Scene scene = AbsDataRecorder.Scene.FRS_HOT;
                this.a.d5(13);
                if (intValue == 14) {
                    scene = AbsDataRecorder.Scene.FRS_NEW;
                    this.a.d5(14);
                }
                if (x56.k().l(scene)) {
                    x56.k().g(scene).b();
                }
                if (q66.i().o(scene)) {
                    q66.i().g(scene).b();
                }
            }
            b1(sw7.f(jgaVar.getSortType()));
            c1(sw7.f(jgaVar.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.r = jgaVar.getFrsDefaultTabId();
            }
            this.b.receiveData(jgaVar);
            Z0(this.b);
            this.c = new ArrayList<>();
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.i = frsRequestData.getPn();
                String Q = this.d.Q();
                this.g = Q;
                this.a.f5(Q);
                this.a.setFrom(this.j);
                this.a.s5(this.i);
                this.a.e5(this.k);
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
            if (qt7.b(this.d)) {
                Y0();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.s4();
                }
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.b.getForum()));
            }
            this.isNetFirstLoad = false;
            if (jgaVar.getForum() != null && !TextUtils.isEmpty(jgaVar.getForum().getName()) && frsRequestData != null && i3a.m().b() != null) {
                i3a.m().b().g(jgaVar.getForum().getName(), frsRequestData.R(), false);
            }
            if (this.a != null && !StringUtils.isNull(jgaVar.getUserData().getAppealThreadPopover())) {
                this.a.B5(TbadkCoreApplication.getCurrentAccount(), jgaVar.getForum().getId(), jgaVar.getUserData().getAppealThreadPopover());
            }
            a1(jgaVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void X(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048603, this, str, frsRequestData) != null) || !ThreadData.isRecAppLoaded.get() || i3a.m().b() == null) {
            return;
        }
        int d2 = i3a.m().b().d(str, false);
        int e2 = i3a.m().b().e(str, false);
        if (frsRequestData.R() == 1) {
            d2++;
        } else if (frsRequestData.R() == 2) {
            e2++;
        }
        frsRequestData.l0(d2);
        frsRequestData.g0(e2);
    }

    public void X0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == null) {
            return;
        }
        this.a.I = System.currentTimeMillis();
        FrsViewData frsViewData = this.b;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.b.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(1);
        int e0 = e0(this.r, frsRequestData);
        this.r = e0;
        if (e0 == 1) {
            if (this.e.g0()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            b0(frsRequestData, i, !z);
            return;
        }
        if (this.u == null) {
            wj7 wj7Var = new wj7();
            this.u = wj7Var;
            wj7Var.c = 1;
            wj7Var.a = this.g;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.u.b = this.b.getForum().getId();
            }
        }
        O0(i);
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(JavaTypesHelper.toLong(this.b.getForum().getId(), 0L));
            }
            this.a.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            ni7 ni7Var = new ni7();
            if (this.t == 0) {
                ni7Var.b(this.D);
            }
            if (this.b.getThreadList() != null) {
                this.b.getThreadList().clear();
                this.b.getThreadList().add(ni7Var);
            }
            ArrayList<cn> arrayList = this.c;
            if (arrayList != null) {
                arrayList.clear();
                this.c.add(ni7Var);
            }
        }
    }

    public void j1() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048633, this) != null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    public int t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            ArrayList<cn> arrayList = this.c;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<cn> it = this.c.iterator();
                while (it.hasNext()) {
                    cn next = it.next();
                    if (next instanceof h45) {
                        if (((h45) next).t.getIs_top() == 0) {
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

    public final void b0(FrsRequestData frsRequestData, int i, boolean z) {
        String str;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.Y4(z);
            this.f.a(i);
            this.e.t0(frsRequestData);
            if (this.a.A4()) {
                str = "1";
            } else {
                str = "2";
            }
            frsRequestData.j0(str);
            if (this.G) {
                frsRequestData.k0(String.valueOf(sw7.d(this.E)));
            } else {
                frsRequestData.k0("-2");
            }
            this.G = false;
            frsRequestData.d0(this.g);
            frsRequestData.r0(1);
            frsRequestData.V(0);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            float equipmentDensity = BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            frsRequestData.q0(equipmentWidth);
            frsRequestData.p0(equipmentHeight);
            frsRequestData.o0(equipmentDensity);
            frsRequestData.t0(i2);
            frsRequestData.n0(this.n);
            frsRequestData.f0(this.p);
            frsRequestData.s0(this.C);
            frsRequestData.e0(JavaTypesHelper.toLong(tx5.a(), 0L));
            String str2 = this.o;
            ArrayList<cn> arrayList = null;
            if (str2 != null) {
                frsRequestData.setStType(str2);
                if ("sidebar".equalsIgnoreCase(this.o)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.a0(G0());
            if (FrsFragment.v2 != 0) {
                frsRequestData.W((int) FrsFragment.v2);
            }
            if (FrsFragment.w2 != 0) {
                frsRequestData.X((int) FrsFragment.w2);
            }
            if (FrsFragment.x2 != 0) {
                frsRequestData.i0(FrsFragment.x2);
            }
            if (frsRequestData.getPn() != 1 && this.h != 3) {
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    arrayList = frsViewData.getThreadList();
                }
                frsRequestData.T(l2a.e(arrayList, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    arrayList = frsViewData2.getThreadList();
                }
                frsRequestData.T(l2a.e(arrayList, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.h);
            frsRequestData.Z(this.q);
            sw7.e(this.D, frsRequestData);
            int d2 = sw7.d(this.F);
            d0(i, frsRequestData);
            X(this.g, frsRequestData);
            if (!z0(this.F) && !this.a.i && !this.K) {
                aga i3 = aga.i();
                String g = i3.g("1~" + this.g, d2, frsRequestData.P(), this.d.N());
                this.I = g;
                new e(this, true, g).execute(new Object[0]);
            }
            i1();
            this.K = false;
        }
    }

    public final void c0(FrsRequestData frsRequestData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.Y4(z);
            this.f.a(i);
            if (this.e.s0() && (this.e.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                G((MvcHttpResponsedMessage) this.e.getResponsedMessage(), (MvcHttpMessage) this.e.p0(), this.e.q0());
            } else if (this.e.s0() && (this.e.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                v((MvcSocketResponsedMessage) this.e.getResponsedMessage(), (MvcSocketMessage) this.e.p0(), this.e.q0());
            } else {
                int d2 = sw7.d(this.F);
                if (!z0(this.F) && !this.a.i && !this.K) {
                    aga i2 = aga.i();
                    String g = i2.g("1~" + this.g, d2, frsRequestData.P(), this.d.N());
                    this.I = g;
                    new e(this, true, g).execute(new Object[0]);
                }
                this.K = false;
            }
            this.e.o0(this);
        }
    }

    public final void k1(int i, int i2, wj7 wj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048635, this, i, i2, wj7Var) == null) {
            this.w.put(p0(i, i2), wj7Var);
        }
    }
}

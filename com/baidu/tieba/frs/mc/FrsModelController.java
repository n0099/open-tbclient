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
import com.baidu.tieba.ak6;
import com.baidu.tieba.ao8;
import com.baidu.tieba.bl6;
import com.baidu.tieba.ck6;
import com.baidu.tieba.ey4;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.gg8;
import com.baidu.tieba.ho8;
import com.baidu.tieba.jj5;
import com.baidu.tieba.kf8;
import com.baidu.tieba.lr5;
import com.baidu.tieba.mi8;
import com.baidu.tieba.mk6;
import com.baidu.tieba.ms6;
import com.baidu.tieba.mv6;
import com.baidu.tieba.nj5;
import com.baidu.tieba.nq8;
import com.baidu.tieba.ns6;
import com.baidu.tieba.nv6;
import com.baidu.tieba.oj6;
import com.baidu.tieba.qb;
import com.baidu.tieba.qk6;
import com.baidu.tieba.qt4;
import com.baidu.tieba.r9;
import com.baidu.tieba.rj5;
import com.baidu.tieba.rn8;
import com.baidu.tieba.sn8;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tq5;
import com.baidu.tieba.wk6;
import com.baidu.tieba.wu4;
import com.baidu.tieba.xg;
import com.baidu.tieba.xi;
import com.baidu.tieba.xn;
import com.baidu.tieba.xt6;
import com.baidu.tieba.ye5;
import com.baidu.tieba.yi;
import com.baidu.tieba.yj6;
import com.baidu.tieba.yv6;
import com.baidu.tieba.zw6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements mk6, NetModel.k<FrsRequestData, ao8> {
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
    public sn8 H;
    public String I;
    public final SparseArray<Boolean> J;
    public boolean K;
    public ns6 L;
    public ms6 M;
    public qk6 N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public final FrsFragment a;
    public FrsViewData b;
    public ArrayList<xn> c;
    public FrsRequestData d;
    public FrsNetModel e;
    public final ho8 f;
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
    public wk6 u;
    public boolean v;
    public SparseArray<wk6> w;
    public ck6 x;
    public qk6 y;
    public ArrayList<xn> z;

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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a implements qk6 {
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

        @Override // com.baidu.tieba.qk6
        public void a(int i, int i2, bl6 bl6Var, ArrayList<xn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), bl6Var, arrayList}) != null) {
                return;
            }
            this.a.v = false;
            if (i != this.a.r || this.a.y == null) {
                return;
            }
            this.a.u = bl6Var;
            this.a.X0(i, i2, bl6Var);
            ArrayList<xn> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            this.a.b.setThreadList(arrayList2);
            this.a.y.a(i, i2, bl6Var, arrayList);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends nj5<Object> {
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

        @Override // com.baidu.tieba.nj5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                rn8.i().c(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends nj5<Object> {
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

        @Override // com.baidu.tieba.nj5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                rn8.i().d(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends nj5<Object> {
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

        @Override // com.baidu.tieba.nj5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                rn8.i().b(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends BdAsyncTask<Object, ao8, Void> {
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
                if (this.c && rn8.i().e(this.a)) {
                    if (!rn8.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        rn8.i().j().getForum().getSignData().is_signed = 0;
                    }
                    ao8 j = rn8.i().j();
                    j.setIsShowRedTip(false);
                    if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (e = xg.e(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e))) != null) {
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
        public void onProgressUpdate(ao8... ao8VarArr) {
            ao8 ao8Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ao8VarArr) == null) {
                super.onProgressUpdate(ao8VarArr);
                FrsModelController frsModelController = this.b;
                if (frsModelController != null && ao8VarArr != null) {
                    if (ao8VarArr.length > 0) {
                        ao8Var = ao8VarArr[0];
                    } else {
                        ao8Var = null;
                    }
                    frsModelController.H0(ao8Var);
                    FrsModelController frsModelController2 = this.b;
                    frsModelController2.P0(frsModelController2.D, true);
                    return;
                }
                FrsModelController frsModelController3 = this.b;
                if (frsModelController3 != null && !frsModelController3.e.f0()) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, ho8 ho8Var) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, ho8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
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
        this.L = new ns6();
        this.M = new ms6();
        this.N = new a(this);
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        if (ho8Var != null) {
            this.a = frsFragment;
            this.f = ho8Var;
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
            r0(this.a);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public void I0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            bundle.putString("name", this.g);
            bundle.putString("from", this.j);
            bundle.putInt("flag", this.k);
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            rj5.b(new d(this, str), null);
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            rj5.b(new b(this, str), null);
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            rj5.b(new c(this, str), null);
        }
    }

    public void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.G = z;
        }
    }

    public void R0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.K = z;
        }
    }

    public void S0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.E = i;
        }
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.n = str;
        }
    }

    @NonNull
    public final ErrorData V(ResponsedMessage responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, responsedMessage)) == null) {
            ErrorData errorData = new ErrorData();
            this.mErrorCode = responsedMessage.getError();
            this.mErrorString = responsedMessage.getErrorString();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            return errorData;
        }
        return (ErrorData) invokeL.objValue;
    }

    public boolean m0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i)) == null) {
            return this.J.get(i, Boolean.FALSE).booleanValue();
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, messageListener) == null) {
            super.registerListener(messageListener);
        }
    }

    @Override // com.baidu.tieba.mk6
    public void w(qk6 qk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, qk6Var) == null) {
            this.y = qk6Var;
            this.x.e(this.N);
        }
    }

    public void P0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.J.put(i, Boolean.valueOf(z));
        }
    }

    public final void Q(int i, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048599, this, i, frsRequestData) != null) || frsRequestData == null) {
            return;
        }
        if (i != 3) {
            if (i == 4) {
                frsRequestData.U(2);
                return;
            }
            return;
        }
        frsRequestData.U(1);
    }

    public final int R(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i, frsRequestData)) == null) {
            if (i == 1 && this.a.l3() != null) {
                return this.a.l3().d(this.D, frsRequestData);
            }
            return i;
        }
        return invokeIL.intValue;
    }

    public wk6 b0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048618, this, i, i2)) == null) {
            return this.w.get(c0(i, i2));
        }
        return (wk6) invokeII.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, qb qbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i, qbVar) == null) {
            super.registerListener(i, qbVar);
        }
    }

    public void A0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (this.r != 1) {
                B0(4);
            } else if (this.e.T()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(i);
                frsRequestData.setSortType(e0());
                O(frsRequestData, 4, false);
            }
        }
    }

    public final void H0(ao8 ao8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ao8Var) == null) {
            this.isCacheFirstLoad = false;
            this.b.receiveData(ao8Var);
            M0(this.b);
            this.c = new ArrayList<>();
            if (this.b.getThreadList() != null) {
                this.c.addAll(this.b.getThreadList());
            }
            this.f.c(ao8Var);
        }
    }

    public final void M0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, frsViewData) == null) {
            if (yv6.I(frsViewData)) {
                this.l = "book_page";
            } else if (frsViewData.getIsBrandForum()) {
                this.l = "brand_page";
            } else if (yv6.K(frsViewData)) {
                this.l = "frs_page";
            } else {
                this.l = "normal_page";
            }
        }
    }

    public final void N0(ao8 ao8Var) {
        FrsFragment frsFragment;
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, ao8Var) != null) || ao8Var == null || (frsFragment = this.a) == null || frsFragment.getActivity() == null || (intent = this.a.getActivity().getIntent()) == null) {
            return;
        }
        mi8.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), ao8Var.getForum().getId());
    }

    public final void r0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, frsFragment) == null) {
            ck6 ck6Var = new ck6();
            this.x = ck6Var;
            ck6Var.a = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.x));
            this.x.e(this.N);
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
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.h = i;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        wk6 wk6Var = this.u;
                        if (wk6Var != null) {
                            wk6Var.c = -1;
                        }
                    }
                } else {
                    wk6 wk6Var2 = this.u;
                    if (wk6Var2 != null) {
                        wk6Var2.c--;
                    }
                }
                i2 = this.r;
                if (i2 != 1) {
                    if (this.t == this.s) {
                        ArrayList<xn> arrayList = new ArrayList<>();
                        ArrayList<xn> arrayList2 = this.c;
                        if (arrayList2 != null) {
                            arrayList.addAll(arrayList2);
                        }
                        this.b.setThreadList(arrayList);
                        qk6 qk6Var = this.y;
                        if (qk6Var != null) {
                            qk6Var.a(this.r, this.s, null, arrayList);
                        }
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                    }
                    this.t = this.s;
                    return;
                }
                mk6 c2 = this.x.c(i2);
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
            wk6 wk6Var3 = this.u;
            if (wk6Var3 != null) {
                wk6Var3.c++;
            }
            i2 = this.r;
            if (i2 != 1) {
            }
        }
    }

    public final void C0(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 4).param(TiebaStatic.Params.OBJ_PARAM2, System.currentTimeMillis() - this.a.A));
            if (!PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            FrsFragment frsFragment = this.a;
            this.A = currentTimeMillis - frsFragment.A;
            long currentTimeMillis2 = System.currentTimeMillis();
            FrsFragment frsFragment2 = this.a;
            frsFragment.C = currentTimeMillis2 - frsFragment2.B;
            ye5 ye5Var = new ye5(i, z, responsedMessage, frsFragment2.D, frsFragment2.E, frsFragment2.C, false, frsFragment2.F, frsFragment2.G, this.A);
            FrsFragment frsFragment3 = this.a;
            frsFragment3.E = 0L;
            frsFragment3.D = 0L;
            nv6.f(this, frsFragment3.A);
            this.a.A = -1L;
            ye5Var.c();
        }
    }

    @Override // com.baidu.tieba.mk6
    public void t(int i, int i2, wk6 wk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048647, this, i, i2, wk6Var) == null) {
            this.r = R(i, null);
            if (wk6Var == null && (wk6Var = b0(i, i2)) == null) {
                if (i != 1 && yi.F() && this.y != null) {
                    bl6 bl6Var = new bl6();
                    bl6Var.g = false;
                    bl6Var.c = 1;
                    bl6Var.a = this.g;
                    bl6Var.i = false;
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        bl6Var.b = this.b.getForum().getId();
                    }
                    p0();
                    this.b.setThreadList(this.z);
                    this.y.a(i, i2, bl6Var, this.z);
                }
                wk6Var = new wk6();
                wk6Var.c = -1;
            }
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                wk6Var.b = this.b.getForum().getId();
            }
            wk6Var.a = this.g;
            if (ak6.a().b(1) != null && this.r == 1) {
                this.d.H(i2);
            }
            this.s = i2;
            this.u = wk6Var;
            X0(i, i2, wk6Var);
            B0(5);
        }
    }

    public void D0(MvcHttpResponsedMessage<ao8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, ao8> mvcHttpMessage, MvcNetMessage<FrsRequestData, ao8> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                    str = frsRequestData.D();
                }
                objArr[1] = str;
                ey4.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
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
        if ((interceptable != null && interceptable.invokeZL(1048580, this, z, responsedMessage) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FrsFragment frsFragment = this.a;
        this.A = currentTimeMillis - frsFragment.H;
        long currentTimeMillis2 = System.currentTimeMillis();
        FrsFragment frsFragment2 = this.a;
        frsFragment.C = currentTimeMillis2 - frsFragment2.B;
        ye5 ye5Var = new ye5(1000, z, responsedMessage, frsFragment2.D, frsFragment2.E, frsFragment2.C, false, frsFragment2.F, frsFragment2.G, this.A);
        int i = this.h;
        if (i == 4) {
            ye5Var.B = this.A;
            ye5Var.e(true);
        } else if (i == 3) {
            ye5Var.C = this.A;
            ye5Var.e(false);
        }
    }

    public void S(int i, boolean z) {
        ArrayList<xn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.a.H = System.currentTimeMillis();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.b.getLikeFeedForumDataList().clear();
            }
            this.r = R(this.r, this.d);
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 == null) {
                threadList = null;
            } else {
                threadList = frsViewData2.getThreadList();
            }
            frsRequestData.G(kf8.e(threadList, true));
            if (this.r == 1) {
                P(this.d, i, !z);
                return;
            }
            if (this.u == null) {
                wk6 wk6Var = new wk6();
                this.u = wk6Var;
                wk6Var.c = 1;
                wk6Var.a = this.g;
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.u.b = this.b.getForum().getId();
                }
            }
            B0(i);
        }
    }

    public void F0(MvcSocketResponsedMessage<ao8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, ao8> mvcSocketMessage, MvcNetMessage<FrsRequestData, ao8> mvcNetMessage) {
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
                    str = frsRequestData.D();
                }
                objArr[1] = str;
                objArr[2] = "seq_id";
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                ey4.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage<ao8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, ao8> mvcSocketMessage, MvcNetMessage<FrsRequestData, ao8> mvcNetMessage) {
        ao8 data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048637, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.L.a(this);
        this.L.e(mvcSocketResponsedMessage);
        this.L.c(mvcSocketMessage);
        this.L.d(mvcNetMessage);
        this.L.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.L);
        this.H = sn8.a(mvcSocketResponsedMessage);
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
        if (frsRequestData != null && data != null && J0(frsRequestData, data)) {
            return;
        }
        this.a.f(V(mvcSocketResponsedMessage));
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage<ao8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, ao8> mvcHttpMessage, MvcNetMessage<FrsRequestData, ao8> mvcNetMessage) {
        ao8 ao8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048645, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.M.a(this);
        this.M.e(mvcHttpResponsedMessage);
        this.M.c(mvcHttpMessage);
        this.M.d(mvcNetMessage);
        this.M.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.M);
        this.H = sn8.a(mvcHttpResponsedMessage);
        FrsRequestData frsRequestData = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            ao8Var = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                frsRequestData = mvcHttpMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                frsRequestData = mvcNetMessage.getRequestData();
            }
        } else {
            ao8Var = null;
        }
        if (frsRequestData != null && ao8Var != null && J0(frsRequestData, ao8Var)) {
            return;
        }
        this.a.f(V(mvcHttpResponsedMessage));
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.e.cancelLoadData();
        }
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public final boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            this.O = System.currentTimeMillis();
            zw6.a();
            return this.e.loadData();
        }
        return invokeV.booleanValue;
    }

    public sn8 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.H;
        }
        return (sn8) invokeV.objValue;
    }

    public FrsRequestData X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.d;
        }
        return (FrsRequestData) invokeV.objValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (1 == this.r) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public ArrayList<xn> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return mv6.d(this.D);
        }
        return invokeV.intValue;
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public FrsViewData h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.b;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            wk6 wk6Var = this.u;
            if (!(wk6Var instanceof bl6) || ((bl6) wk6Var).e != 0) {
                return true;
            }
            return ((bl6) wk6Var).g;
        }
        return invokeV.booleanValue;
    }

    public long i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.R;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.mk6
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.x.d();
        }
    }

    @Override // com.baidu.tieba.mk6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.x.b();
            this.x.clear();
        }
    }

    public long j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.O;
        }
        return invokeV.longValue;
    }

    public long k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.Q;
        }
        return invokeV.longValue;
    }

    public long l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.P;
        }
        return invokeV.longValue;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.z.size() == 0) {
                this.z.add(new yj6());
            }
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final int t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                int i = frsFragment.L0;
                if (i == -1 || i == this.r) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            if (this.D == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.e.T();
        }
        return invokeV.booleanValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            FrsRequestData frsRequestData = this.d;
            if (frsRequestData != null && frsRequestData.E() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this.D != 7 && (this.e.f0() || this.F != 7)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public void J(qt4 qt4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, qt4Var) == null) && qt4Var != null && !StringUtils.isNull(qt4Var.getId()) && !ListUtils.isEmpty(this.c)) {
            if (this.r == 1) {
                this.b.addMyNewThread(qt4Var);
            }
            int g0 = g0();
            Iterator<xn> it = this.c.iterator();
            while (it.hasNext()) {
                xn next = it.next();
                if ((next instanceof wu4) && qt4Var.getId().equals(((wu4) next).t.getId())) {
                    return;
                }
            }
            this.c.add(g0, qt4Var);
        }
    }

    public void O0(int i) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.D = i;
            if (i != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                mv6.i("1~" + str + this.g, this.D);
            }
            if (7 == i) {
                nq8.b();
            } else {
                nq8.a();
            }
        }
    }

    public boolean J0(FrsRequestData frsRequestData, ao8 ao8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, frsRequestData, ao8Var)) == null) {
            if (ao8Var == null || ao8Var.getForum() == null || (xi.isEmpty(ao8Var.getForum().getName()) && 340001 != ao8Var.mErrorNo)) {
                return false;
            }
            if (ao8Var.getDataParseTime() > 0) {
                this.a.G = ao8Var.getDataParseTime();
            }
            if (ao8Var.getEntelechyTabInfo() != null && !ListUtils.isEmpty(ao8Var.getEntelechyTabInfo().a)) {
                int intValue = ao8Var.getEntelechyTabInfo().a.get(0).tab_type.intValue();
                AbsDataRecorder.Scene scene = AbsDataRecorder.Scene.FRS_HOT;
                this.a.q4(13);
                if (intValue == 14) {
                    scene = AbsDataRecorder.Scene.FRS_NEW;
                    this.a.q4(14);
                }
                if (tq5.k().l(scene)) {
                    tq5.k().g(scene).b();
                }
                if (lr5.i().o(scene)) {
                    lr5.i().g(scene).b();
                }
            }
            O0(mv6.f(ao8Var.getSortType()));
            P0(mv6.f(ao8Var.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.r = ao8Var.getFrsDefaultTabId();
            }
            this.b.receiveData(ao8Var);
            M0(this.b);
            this.c = new ArrayList<>();
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.i = frsRequestData.getPn();
                String D = this.d.D();
                this.g = D;
                this.a.s4(D);
                this.a.setFrom(this.j);
                this.a.E4(this.i);
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
            if (xt6.b(this.d)) {
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
            if (ao8Var.getForum() != null && !TextUtils.isEmpty(ao8Var.getForum().getName()) && frsRequestData != null && gg8.l().b() != null) {
                gg8.l().b().g(ao8Var.getForum().getName(), frsRequestData.E(), false);
            }
            if (this.a != null && !StringUtils.isNull(ao8Var.getUserData().getAppealThreadPopover())) {
                this.a.R4(TbadkCoreApplication.getCurrentAccount(), ao8Var.getForum().getId(), ao8Var.getUserData().getAppealThreadPopover());
            }
            N0(ao8Var);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void K(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, str, frsRequestData) != null) || !ThreadData.isRecAppLoaded.get() || gg8.l().b() == null) {
            return;
        }
        int d2 = gg8.l().b().d(str, false);
        int e2 = gg8.l().b().e(str, false);
        if (frsRequestData.E() == 1) {
            d2++;
        } else if (frsRequestData.E() == 2) {
            e2++;
        }
        frsRequestData.Y(d2);
        frsRequestData.T(e2);
    }

    public void K0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == null) {
            return;
        }
        this.a.H = System.currentTimeMillis();
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
            wk6 wk6Var = new wk6();
            this.u = wk6Var;
            wk6Var.c = 1;
            wk6Var.a = this.g;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.u.b = this.b.getForum().getId();
            }
        }
        B0(i);
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(xg.g(this.b.getForum().getId(), 0L));
            }
            this.a.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            oj6 oj6Var = new oj6();
            if (this.t == 0) {
                oj6Var.b(this.D);
            }
            if (this.b.getThreadList() != null) {
                this.b.getThreadList().clear();
                this.b.getThreadList().add(oj6Var);
            }
            ArrayList<xn> arrayList = this.c;
            if (arrayList != null) {
                arrayList.clear();
                this.c.add(oj6Var);
            }
        }
    }

    public void W0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            ArrayList<xn> arrayList = this.c;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<xn> it = this.c.iterator();
                while (it.hasNext()) {
                    xn next = it.next();
                    if (next instanceof wu4) {
                        if (((wu4) next).t.getIs_top() == 0) {
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

    public final void O(FrsRequestData frsRequestData, int i, boolean z) {
        String str;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.n4(z);
            this.f.a(i);
            this.e.g0(frsRequestData);
            if (this.a.Q3()) {
                str = "1";
            } else {
                str = "2";
            }
            frsRequestData.W(str);
            if (this.G) {
                frsRequestData.X(String.valueOf(mv6.d(this.E)));
            } else {
                frsRequestData.X("-2");
            }
            this.G = false;
            frsRequestData.Q(this.g);
            frsRequestData.e0(1);
            frsRequestData.I(0);
            int l = yi.l(TbadkCoreApplication.getInst());
            int j = yi.j(TbadkCoreApplication.getInst());
            float i3 = yi.i(TbadkCoreApplication.getInst());
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            frsRequestData.d0(l);
            frsRequestData.c0(j);
            frsRequestData.b0(i3);
            frsRequestData.g0(i2);
            frsRequestData.a0(this.n);
            frsRequestData.S(this.p);
            frsRequestData.f0(this.C);
            frsRequestData.R(xg.g(jj5.a(), 0L));
            String str2 = this.o;
            ArrayList<xn> arrayList = null;
            if (str2 != null) {
                frsRequestData.setStType(str2);
                if ("sidebar".equalsIgnoreCase(this.o)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.N(t0());
            if (FrsFragment.m2 != 0) {
                frsRequestData.J((int) FrsFragment.m2);
            }
            if (FrsFragment.n2 != 0) {
                frsRequestData.K((int) FrsFragment.n2);
            }
            if (FrsFragment.o2 != 0) {
                frsRequestData.V(FrsFragment.o2);
            }
            if (frsRequestData.getPn() != 1 && this.h != 3) {
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    arrayList = frsViewData.getThreadList();
                }
                frsRequestData.G(kf8.e(arrayList, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    arrayList = frsViewData2.getThreadList();
                }
                frsRequestData.G(kf8.e(arrayList, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.h);
            frsRequestData.M(this.q);
            mv6.e(this.D, frsRequestData);
            int d2 = mv6.d(this.F);
            Q(i, frsRequestData);
            K(this.g, frsRequestData);
            if (!m0(this.F) && !this.a.i && !this.K) {
                rn8 i4 = rn8.i();
                String g = i4.g("1~" + this.g, d2, frsRequestData.C(), this.d.A());
                this.I = g;
                new e(this, true, g).execute(new Object[0]);
            }
            V0();
            this.K = false;
        }
    }

    public final void P(FrsRequestData frsRequestData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.n4(z);
            this.f.a(i);
            if (this.e.f0() && (this.e.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                s((MvcHttpResponsedMessage) this.e.getResponsedMessage(), (MvcHttpMessage) this.e.c0(), this.e.d0());
            } else if (this.e.f0() && (this.e.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                n((MvcSocketResponsedMessage) this.e.getResponsedMessage(), (MvcSocketMessage) this.e.c0(), this.e.d0());
            } else {
                int d2 = mv6.d(this.F);
                if (!m0(this.F) && !this.a.i && !this.K) {
                    rn8 i2 = rn8.i();
                    String g = i2.g("1~" + this.g, d2, frsRequestData.C(), this.d.A());
                    this.I = g;
                    new e(this, true, g).execute(new Object[0]);
                }
                this.K = false;
            }
            this.e.b0(this);
        }
    }

    public final void X0(int i, int i2, wk6 wk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048614, this, i, i2, wk6Var) == null) {
            this.w.put(c0(i, i2), wk6Var);
        }
    }

    public void n0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
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
            if (this.e == null || (frsRequestData = this.d) == null || frsRequestData.x() == null || this.d.x().isEmpty() || this.d.x().containsKey(null) || this.d.x().containsValue(null)) {
                o0(bundle);
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

    public final void o0(Bundle bundle) {
        int i;
        ArrayList<xn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.d = frsRequestData;
            frsRequestData.setSortType(mv6.d(this.D));
            if (this.D == 5) {
                this.d.O(1);
            } else {
                this.d.O(0);
            }
            this.d.z("forum_name", xi.getUrlEncode(this.g));
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
            this.d.d0(yi.l(TbadkCoreApplication.getInst()));
            this.d.c0(yi.j(TbadkCoreApplication.getInst()));
            this.d.b0(yi.i(TbadkCoreApplication.getInst()));
            FrsRequestData frsRequestData2 = this.d;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            frsRequestData2.g0(i);
            this.d.a0(this.n);
            this.d.S(null);
            this.d.f0(this.C);
            this.d.R(xg.g(jj5.a(), 0L));
            this.d.setStType(this.j);
            this.d.N(1);
            this.d.setNeedCache(true);
            this.d.setUpdateType(3);
            FrsRequestData frsRequestData3 = this.d;
            FrsViewData frsViewData = this.b;
            if (frsViewData == null) {
                threadList = null;
            } else {
                threadList = frsViewData.getThreadList();
            }
            frsRequestData3.G(kf8.e(threadList, true));
            mv6.e(this.D, this.d);
            this.d.U(1);
            if (ThreadData.isRecAppLoaded.get() && gg8.l().b() != null) {
                int d2 = gg8.l().b().d(this.g, false);
                int e2 = gg8.l().b().e(this.g, false);
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
            zw6.a();
        }
    }

    public final void q0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
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
                this.F = mv6.h("1~" + str + this.g);
                O0(this.D);
            }
        }
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            if (this.r != 1) {
                B0(1);
                return true;
            } else if (this.e.T()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(e0());
                O(frsRequestData, 1, false);
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}

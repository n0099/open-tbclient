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
import com.baidu.tieba.ae7;
import com.baidu.tieba.c3a;
import com.baidu.tieba.cs7;
import com.baidu.tieba.df7;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.fv9;
import com.baidu.tieba.g95;
import com.baidu.tieba.hn7;
import com.baidu.tieba.ht7;
import com.baidu.tieba.in7;
import com.baidu.tieba.j3a;
import com.baidu.tieba.jf7;
import com.baidu.tieba.kb;
import com.baidu.tieba.ke7;
import com.baidu.tieba.l35;
import com.baidu.tieba.l9;
import com.baidu.tieba.me7;
import com.baidu.tieba.ns9;
import com.baidu.tieba.oe7;
import com.baidu.tieba.of7;
import com.baidu.tieba.ox5;
import com.baidu.tieba.q5a;
import com.baidu.tieba.qr7;
import com.baidu.tieba.qr9;
import com.baidu.tieba.r45;
import com.baidu.tieba.r66;
import com.baidu.tieba.rr7;
import com.baidu.tieba.sx5;
import com.baidu.tieba.t2a;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.u2a;
import com.baidu.tieba.uo7;
import com.baidu.tieba.vg;
import com.baidu.tieba.wi;
import com.baidu.tieba.wx5;
import com.baidu.tieba.xi;
import com.baidu.tieba.xn;
import com.baidu.tieba.y56;
import com.baidu.tieba.ze7;
import com.baidu.tieba.zs5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements ze7, NetModel.k<FrsRequestData, c3a> {
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
    public u2a H;
    public String I;
    public final SparseArray<Boolean> J;
    public boolean K;
    public in7 L;
    public hn7 M;
    public df7 N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public final FrsFragment a;
    public FrsViewData b;
    public ArrayList<xn> c;
    public FrsRequestData d;
    public FrsNetModel e;
    public final j3a f;
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
    public jf7 u;
    public boolean v;
    public SparseArray<jf7> w;
    public oe7 x;
    public df7 y;
    public ArrayList<xn> z;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
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

    public final int x0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048653, this, i, i2)) == null) ? (i * 10) + i2 : invokeII.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements df7 {
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

        @Override // com.baidu.tieba.df7
        public void a(int i, int i2, of7 of7Var, ArrayList<xn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), of7Var, arrayList}) == null) {
                this.a.v = false;
                if (i == this.a.r && this.a.y != null) {
                    this.a.u = of7Var;
                    this.a.s1(i, i2, of7Var);
                    ArrayList<xn> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    this.a.b.setThreadList(arrayList2);
                    this.a.y.a(i, i2, of7Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends sx5<Object> {
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

        @Override // com.baidu.tieba.sx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                t2a.i().c(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends sx5<Object> {
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

        @Override // com.baidu.tieba.sx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                t2a.i().d(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends sx5<Object> {
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

        @Override // com.baidu.tieba.sx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                t2a.i().b(this.b.I, this.a);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends BdAsyncTask<Object, c3a, Void> {
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
                if (this.c && t2a.i().e(this.a)) {
                    if (!t2a.i().l(TbadkCoreApplication.getCurrentAccount() + this.a)) {
                        t2a.i().j().getForum().getSignData().is_signed = 0;
                    }
                    c3a j = t2a.i().j();
                    j.setIsShowRedTip(false);
                    if (j.getBookInfo() != null && !StringUtils.isNull(j.getBookInfo().a(), true) && !j.getBookInfo().a().equals("0") && j.getBookInfo().b() == 3 && (e = vg.e(j.getBookInfo().a(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(e))) != null) {
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
        public void onProgressUpdate(c3a... c3aVarArr) {
            c3a c3aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c3aVarArr) == null) {
                super.onProgressUpdate(c3aVarArr);
                FrsModelController frsModelController = this.b;
                if (frsModelController != null && c3aVarArr != null) {
                    if (c3aVarArr.length > 0) {
                        c3aVar = c3aVarArr[0];
                    } else {
                        c3aVar = null;
                    }
                    frsModelController.c1(c3aVar);
                    FrsModelController frsModelController2 = this.b;
                    frsModelController2.k1(frsModelController2.D, true);
                    return;
                }
                FrsModelController frsModelController3 = this.b;
                if (frsModelController3 != null && !frsModelController3.e.A0()) {
                    if (this.b.e.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                        FrsModelController frsModelController4 = this.b;
                        frsModelController4.L((MvcHttpResponsedMessage) frsModelController4.e.getResponsedMessage(), (MvcHttpMessage) this.b.e.x0(), this.b.e.y0());
                    }
                    if (this.b.e.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                        FrsModelController frsModelController5 = this.b;
                        frsModelController5.w((MvcSocketResponsedMessage) frsModelController5.e.getResponsedMessage(), (MvcSocketMessage) this.b.e.x0(), this.b.e.y0());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsModelController(FrsFragment frsFragment, j3a j3aVar) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, j3aVar};
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
        this.L = new in7();
        this.M = new hn7();
        this.N = new a(this);
        this.O = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        if (j3aVar != null) {
            this.a = frsFragment;
            this.f = j3aVar;
            if (frsFragment.getActivity() instanceof FrsActivity) {
                this.e = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.a.getActivity()).getUniqueId().getId());
            }
            FrsNetModel frsNetModel = this.e;
            if (frsNetModel != null) {
                if (frsNetModel.getResponsedMessage() == null) {
                    this.e.w0(this);
                }
                this.d = this.e.z0();
            }
            M0(this.a);
            return;
        }
        throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
    }

    public void k1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.J.put(i, Boolean.valueOf(z));
        }
    }

    public final void l0(int i, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048628, this, i, frsRequestData) != null) || frsRequestData == null) {
            return;
        }
        if (i != 3) {
            if (i == 4) {
                frsRequestData.p0(2);
                return;
            }
            return;
        }
        frsRequestData.p0(1);
    }

    public final int m0(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048631, this, i, frsRequestData)) == null) {
            if (i == 1 && this.a.A3() != null) {
                return this.a.A3().d(this.D, frsRequestData);
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

    public jf7 w0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048652, this, i, i2)) == null) {
            return this.w.get(x0(i, i2));
        }
        return (jf7) invokeII.objValue;
    }

    public boolean H0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return this.J.get(i, Boolean.FALSE).booleanValue();
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.ze7
    public void R(df7 df7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, df7Var) == null) {
            this.y = df7Var;
            this.x.e(this.N);
        }
    }

    public void d1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            bundle.putString("name", this.g);
            bundle.putString("from", this.j);
            bundle.putInt("flag", this.k);
        }
    }

    public void g0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            wx5.b(new d(this, str), null);
        }
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            wx5.b(new b(this, str), null);
        }
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            wx5.b(new c(this, str), null);
        }
    }

    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.G = z;
        }
    }

    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.K = z;
        }
    }

    public void n1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
            this.E = i;
        }
    }

    public void p1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.n = str;
        }
    }

    @NonNull
    public final ErrorData q0(ResponsedMessage responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, responsedMessage)) == null) {
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

    public int A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public FrsViewData C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public long D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.R;
        }
        return invokeV.longValue;
    }

    public long E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.O;
        }
        return invokeV.longValue;
    }

    public long F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.Q;
        }
        return invokeV.longValue;
    }

    public long G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.P;
        }
        return invokeV.longValue;
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.z.size() == 0) {
                this.z.add(new ke7());
            }
        }
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final int O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.D == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.e.o0();
        }
        return invokeV.booleanValue;
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            FrsRequestData frsRequestData = this.d;
            if (frsRequestData != null && frsRequestData.Z() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.D != 7 && (this.e.A0() || this.F != 7)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
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
            jf7 jf7Var = this.u;
            if (!(jf7Var instanceof of7) || ((of7) jf7Var).e != 0) {
                return true;
            }
            return ((of7) jf7Var).g;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ze7
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.x.d();
        }
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public int p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public final boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            this.O = System.currentTimeMillis();
            ht7.a();
            return this.e.loadData();
        }
        return invokeV.booleanValue;
    }

    public u2a r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.H;
        }
        return (u2a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ze7
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            Looper.myQueue().removeIdleHandler(this.L);
            Looper.myQueue().removeIdleHandler(this.M);
            this.x.b();
            this.x.clear();
        }
    }

    public FrsRequestData s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.d;
        }
        return (FrsRequestData) invokeV.objValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (1 == this.r) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public ArrayList<xn> v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public int z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return qr7.d(this.D);
        }
        return invokeV.intValue;
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<xn> arrayList = this.c;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<xn> it = this.c.iterator();
                while (it.hasNext()) {
                    xn next = it.next();
                    if (next instanceof r45) {
                        if (((r45) next).t.getIs_top() == 0) {
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

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null) {
                requestIncrForumAccessCountNetMessage.setForumId(vg.g(this.b.getForum().getId(), 0L));
            }
            this.a.sendMessage(requestIncrForumAccessCountNetMessage);
        }
    }

    public void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            ae7 ae7Var = new ae7();
            if (this.t == 0) {
                ae7Var.b(this.D);
            }
            if (this.b.getThreadList() != null) {
                this.b.getThreadList().clear();
                this.b.getThreadList().add(ae7Var);
            }
            ArrayList<xn> arrayList = this.c;
            if (arrayList != null) {
                arrayList.clear();
                this.c.add(ae7Var);
            }
        }
    }

    public void r1() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048642, this) != null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    public void I0(Bundle bundle) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
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
            L0();
            if (this.b == null) {
                this.b = new FrsViewData();
            }
            if (this.e == null || (frsRequestData = this.d) == null || frsRequestData.S() == null || this.d.S().isEmpty() || this.d.S().containsKey(null) || this.d.S().containsValue(null)) {
                J0(bundle);
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

    public final void J0(Bundle bundle) {
        int i;
        ArrayList<xn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            FrsRequestData frsRequestData = new FrsRequestData();
            this.d = frsRequestData;
            frsRequestData.setSortType(qr7.d(this.D));
            if (this.D == 5) {
                this.d.j0(1);
            } else {
                this.d.j0(0);
            }
            this.d.U("forum_name", wi.getUrlEncode(this.g));
            this.d.U("client_type", "2");
            this.d.setPn(1);
            if (bundle != null) {
                this.d.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
                this.d.h0(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
            }
            this.d.r0("2");
            this.d.s0("-2");
            this.d.l0(this.g);
            this.d.z0(1);
            this.d.d0(0);
            this.d.y0(xi.l(TbadkCoreApplication.getInst()));
            this.d.x0(xi.j(TbadkCoreApplication.getInst()));
            this.d.w0(xi.i(TbadkCoreApplication.getInst()));
            FrsRequestData frsRequestData2 = this.d;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            frsRequestData2.B0(i);
            this.d.v0(this.n);
            this.d.n0(null);
            this.d.A0(this.C);
            this.d.m0(vg.g(ox5.a(), 0L));
            this.d.setStType(this.j);
            this.d.i0(1);
            this.d.setNeedCache(true);
            this.d.setUpdateType(3);
            FrsRequestData frsRequestData3 = this.d;
            FrsViewData frsViewData = this.b;
            if (frsViewData == null) {
                threadList = null;
            } else {
                threadList = frsViewData.getThreadList();
            }
            frsRequestData3.b0(qr9.e(threadList, true));
            qr7.e(this.D, this.d);
            this.d.p0(1);
            if (ThreadData.isRecAppLoaded.get() && ns9.l().b() != null) {
                int d2 = ns9.l().b().d(this.g, false);
                int e2 = ns9.l().b().e(this.g, false);
                if (this.d.Z() == 1) {
                    d2++;
                } else if (this.d.Z() == 2) {
                    e2++;
                }
                this.d.t0(d2);
                this.d.o0(e2);
            }
            FrsNetModel frsNetModel = new FrsNetModel(null, this.d);
            this.e = frsNetModel;
            frsNetModel.setUniqueId(((FrsActivity) this.a.getActivity()).getUniqueId());
            this.e.w0(this);
            this.e.loadData();
            ht7.a();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void L(MvcHttpResponsedMessage<c3a> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, c3a> mvcHttpMessage, MvcNetMessage<FrsRequestData, c3a> mvcNetMessage) {
        c3a c3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048587, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        this.M.a(this);
        this.M.e(mvcHttpResponsedMessage);
        this.M.c(mvcHttpMessage);
        this.M.d(mvcNetMessage);
        this.M.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.M);
        this.H = u2a.a(mvcHttpResponsedMessage);
        FrsRequestData frsRequestData = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            c3aVar = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                frsRequestData = mvcHttpMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                frsRequestData = mvcNetMessage.getRequestData();
            }
        } else {
            c3aVar = null;
        }
        if (frsRequestData != null && c3aVar != null && e1(frsRequestData, c3aVar)) {
            return;
        }
        this.a.g(q0(mvcHttpResponsedMessage));
    }

    public void a1(MvcSocketResponsedMessage<c3a, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, c3a> mvcSocketMessage, MvcNetMessage<FrsRequestData, c3a> mvcNetMessage) {
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (!this.B) {
                this.B = true;
                X0(1000, false, mvcSocketResponsedMessage);
            } else {
                Z0(false, mvcSocketResponsedMessage);
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
                    str = frsRequestData.Y();
                }
                objArr[1] = str;
                objArr[2] = PushConstants.SEQ_ID;
                objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
                g95.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void w(MvcSocketResponsedMessage<c3a, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, c3a> mvcSocketMessage, MvcNetMessage<FrsRequestData, c3a> mvcNetMessage) {
        c3a data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048651, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        this.L.a(this);
        this.L.e(mvcSocketResponsedMessage);
        this.L.c(mvcSocketMessage);
        this.L.d(mvcNetMessage);
        this.L.b(this.f);
        this.f.b();
        Looper.myQueue().addIdleHandler(this.L);
        this.H = u2a.a(mvcSocketResponsedMessage);
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
        if (frsRequestData != null && data != null && e1(frsRequestData, data)) {
            return;
        }
        this.a.g(q0(mvcSocketResponsedMessage));
    }

    public final void L0() {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
                j1(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
                j1(6);
            } else {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                this.F = qr7.h("1~" + str + this.g);
                j1(this.D);
            }
        }
    }

    @Override // com.baidu.tieba.ze7
    public void M(int i, int i2, jf7 jf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, jf7Var) == null) {
            this.r = m0(i, null);
            if (jf7Var == null && (jf7Var = w0(i, i2)) == null) {
                if (i != 1 && xi.F() && this.y != null) {
                    of7 of7Var = new of7();
                    of7Var.g = false;
                    of7Var.c = 1;
                    of7Var.a = this.g;
                    of7Var.i = false;
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        of7Var.b = this.b.getForum().getId();
                    }
                    K0();
                    this.b.setThreadList(this.z);
                    this.y.a(i, i2, of7Var, this.z);
                }
                jf7Var = new jf7();
                jf7Var.c = -1;
            }
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                jf7Var.b = this.b.getForum().getId();
            }
            jf7Var.a = this.g;
            if (me7.a().b(1) != null && this.r == 1) {
                this.d.c0(i2);
            }
            this.s = i2;
            this.u = jf7Var;
            s1(i, i2, jf7Var);
            W0(5);
        }
    }

    public final void X0(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage}) == null) {
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
            zs5 zs5Var = new zs5(i, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
            FrsFragment frsFragment3 = this.a;
            frsFragment3.F = 0L;
            frsFragment3.E = 0L;
            rr7.f(this, frsFragment3.B);
            this.a.B = -1L;
            zs5Var.c();
        }
    }

    public final void M0(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frsFragment) == null) {
            oe7 oe7Var = new oe7();
            this.x = oe7Var;
            oe7Var.a = frsFragment.getUniqueId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.x));
            this.x.e(this.N);
        }
    }

    public void V0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            if (this.r != 1) {
                W0(4);
            } else if (this.e.o0()) {
            } else {
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(i);
                frsRequestData.setSortType(z0());
                j0(frsRequestData, 4, false);
            }
        }
    }

    public final void c1(c3a c3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, c3aVar) == null) {
            this.isCacheFirstLoad = false;
            this.b.receiveData(c3aVar);
            h1(this.b);
            this.c = new ArrayList<>();
            if (this.b.getThreadList() != null) {
                this.c.addAll(this.b.getThreadList());
            }
            this.f.c(c3aVar);
        }
    }

    public final void h1(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, frsViewData) == null) {
            if (cs7.a0(frsViewData)) {
                this.l = "book_page";
            } else if (frsViewData.getIsBrandForum()) {
                this.l = "brand_page";
            } else if (cs7.b0(frsViewData)) {
                this.l = "frs_page";
            } else {
                this.l = "normal_page";
            }
        }
    }

    public final void i1(c3a c3aVar) {
        FrsFragment frsFragment;
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, c3aVar) != null) || c3aVar == null || (frsFragment = this.a) == null || frsFragment.getActivity() == null || (intent = this.a.getActivity().getIntent()) == null) {
            return;
        }
        fv9.d().g((Uri) intent.getParcelableExtra(IntentConfig.KEY_URI), c3aVar.getForum().getId());
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.r != 1) {
                W0(1);
                return true;
            } else if (this.e.o0()) {
                return false;
            } else {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
                FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
                frsRequestData.setPn(frsRequestData.getPn() + 1);
                frsRequestData.setSortType(z0());
                j0(frsRequestData, 1, false);
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
    public final void W0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.h = i;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        jf7 jf7Var = this.u;
                        if (jf7Var != null) {
                            jf7Var.c = -1;
                        }
                    }
                } else {
                    jf7 jf7Var2 = this.u;
                    if (jf7Var2 != null) {
                        jf7Var2.c--;
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
                        df7 df7Var = this.y;
                        if (df7Var != null) {
                            df7Var.a(this.r, this.s, null, arrayList);
                        }
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
                    }
                    this.t = this.s;
                    return;
                }
                ze7 c2 = this.x.c(i2);
                if (c2 != null) {
                    this.v = true;
                    c2.M(this.r, this.s, this.u);
                    return;
                }
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getThreadList() != null) {
                    this.b.getThreadList().clear();
                }
                this.y.a(this.r, this.s, null, null);
                return;
            }
            jf7 jf7Var3 = this.u;
            if (jf7Var3 != null) {
                jf7Var3.c++;
            }
            i2 = this.r;
            if (i2 != 1) {
            }
        }
    }

    public void Y0(MvcHttpResponsedMessage<c3a> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, c3a> mvcHttpMessage, MvcNetMessage<FrsRequestData, c3a> mvcNetMessage) {
        long j;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                    str = frsRequestData.Y();
                }
                objArr[1] = str;
                g95.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
            }
            if (!this.B) {
                this.B = true;
                X0(1000, true, mvcHttpResponsedMessage);
                return;
            }
            Z0(true, mvcHttpResponsedMessage);
        }
    }

    public final void Z0(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048604, this, z, responsedMessage) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FrsFragment frsFragment = this.a;
        this.A = currentTimeMillis - frsFragment.I;
        long currentTimeMillis2 = System.currentTimeMillis();
        FrsFragment frsFragment2 = this.a;
        frsFragment.D = currentTimeMillis2 - frsFragment2.C;
        zs5 zs5Var = new zs5(1000, z, responsedMessage, frsFragment2.E, frsFragment2.F, frsFragment2.D, false, frsFragment2.G, frsFragment2.H, this.A);
        int i = this.h;
        if (i == 4) {
            zs5Var.B = this.A;
            zs5Var.e(true);
        } else if (i == 3) {
            zs5Var.C = this.A;
            zs5Var.e(false);
        }
    }

    public void n0(int i, boolean z) {
        ArrayList<xn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.a.I = System.currentTimeMillis();
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
                this.b.getLikeFeedForumDataList().clear();
            }
            this.r = m0(this.r, this.d);
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 == null) {
                threadList = null;
            } else {
                threadList = frsViewData2.getThreadList();
            }
            frsRequestData.b0(qr9.e(threadList, true));
            if (this.r == 1) {
                k0(this.d, i, !z);
                return;
            }
            if (this.u == null) {
                jf7 jf7Var = new jf7();
                this.u = jf7Var;
                jf7Var.c = 1;
                jf7Var.a = this.g;
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.u.b = this.b.getForum().getId();
                }
            }
            W0(i);
        }
    }

    public void e0(l35 l35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, l35Var) == null) && l35Var != null && !StringUtils.isNull(l35Var.getId()) && !ListUtils.isEmpty(this.c)) {
            if (this.r == 1) {
                this.b.addMyNewThread(l35Var);
            }
            int B0 = B0();
            Iterator<xn> it = this.c.iterator();
            while (it.hasNext()) {
                xn next = it.next();
                if ((next instanceof r45) && l35Var.getId().equals(((r45) next).t.getId())) {
                    return;
                }
            }
            this.c.add(B0, l35Var);
        }
    }

    public void j1(int i) {
        AccountData currentAccountObj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.D = i;
            if (i != -1) {
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = currentAccountObj.getID() + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else {
                    str = "";
                }
                qr7.i("1~" + str + this.g, this.D);
            }
            if (7 == i) {
                q5a.b();
            } else {
                q5a.a();
            }
        }
    }

    public boolean e1(FrsRequestData frsRequestData, c3a c3aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, frsRequestData, c3aVar)) == null) {
            if (c3aVar == null || c3aVar.getForum() == null || (wi.isEmpty(c3aVar.getForum().getName()) && 340001 != c3aVar.mErrorNo)) {
                return false;
            }
            if (c3aVar.getDataParseTime() > 0) {
                this.a.H = c3aVar.getDataParseTime();
            }
            if (c3aVar.getEntelechyTabInfo() != null && !ListUtils.isEmpty(c3aVar.getEntelechyTabInfo().a)) {
                int intValue = c3aVar.getEntelechyTabInfo().a.get(0).tab_type.intValue();
                AbsDataRecorder.Scene scene = AbsDataRecorder.Scene.FRS_HOT;
                this.a.H4(13);
                if (intValue == 14) {
                    scene = AbsDataRecorder.Scene.FRS_NEW;
                    this.a.H4(14);
                }
                if (y56.k().l(scene)) {
                    y56.k().g(scene).b();
                }
                if (r66.i().o(scene)) {
                    r66.i().g(scene).b();
                }
            }
            j1(qr7.f(c3aVar.getSortType()));
            k1(qr7.f(c3aVar.getSortType()), true);
            if (this.isNetFirstLoad) {
                this.r = c3aVar.getFrsDefaultTabId();
            }
            this.b.receiveData(c3aVar);
            h1(this.b);
            this.c = new ArrayList<>();
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.i = frsRequestData.getPn();
                String Y = this.d.Y();
                this.g = Y;
                this.a.J4(Y);
                this.a.setFrom(this.j);
                this.a.W4(this.i);
                this.a.I4(this.k);
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
            if (uo7.b(this.d)) {
                g1();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null) {
                    frsFragment.Z3();
                }
            }
            if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.b.getForum()));
            }
            this.isNetFirstLoad = false;
            if (c3aVar.getForum() != null && !TextUtils.isEmpty(c3aVar.getForum().getName()) && frsRequestData != null && ns9.l().b() != null) {
                ns9.l().b().g(c3aVar.getForum().getName(), frsRequestData.Z(), false);
            }
            if (this.a != null && !StringUtils.isNull(c3aVar.getUserData().getAppealThreadPopover())) {
                this.a.f5(TbadkCoreApplication.getCurrentAccount(), c3aVar.getForum().getId(), c3aVar.getUserData().getAppealThreadPopover());
            }
            i1(c3aVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void f0(String str, FrsRequestData frsRequestData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048612, this, str, frsRequestData) != null) || !ThreadData.isRecAppLoaded.get() || ns9.l().b() == null) {
            return;
        }
        int d2 = ns9.l().b().d(str, false);
        int e2 = ns9.l().b().e(str, false);
        if (frsRequestData.Z() == 1) {
            d2++;
        } else if (frsRequestData.Z() == 2) {
            e2++;
        }
        frsRequestData.t0(d2);
        frsRequestData.o0(e2);
    }

    public void f1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == null) {
            return;
        }
        this.a.I = System.currentTimeMillis();
        FrsViewData frsViewData = this.b;
        if (frsViewData != null && frsViewData.getLikeFeedForumDataList() != null) {
            this.b.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(1);
        int m0 = m0(this.r, frsRequestData);
        this.r = m0;
        if (m0 == 1) {
            if (this.e.o0()) {
                return;
            }
            frsRequestData.setCallFrom(0);
            j0(frsRequestData, i, !z);
            return;
        }
        if (this.u == null) {
            jf7 jf7Var = new jf7();
            this.u = jf7Var;
            jf7Var.c = 1;
            jf7Var.a = this.g;
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                this.u.b = this.b.getForum().getId();
            }
        }
        W0(i);
    }

    public final void j0(FrsRequestData frsRequestData, int i, boolean z) {
        String str;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.D4(z);
            this.f.a(i);
            this.e.B0(frsRequestData);
            if (this.a.h4()) {
                str = "1";
            } else {
                str = "2";
            }
            frsRequestData.r0(str);
            if (this.G) {
                frsRequestData.s0(String.valueOf(qr7.d(this.E)));
            } else {
                frsRequestData.s0("-2");
            }
            this.G = false;
            frsRequestData.l0(this.g);
            frsRequestData.z0(1);
            frsRequestData.d0(0);
            int l = xi.l(TbadkCoreApplication.getInst());
            int j = xi.j(TbadkCoreApplication.getInst());
            float i3 = xi.i(TbadkCoreApplication.getInst());
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            frsRequestData.y0(l);
            frsRequestData.x0(j);
            frsRequestData.w0(i3);
            frsRequestData.B0(i2);
            frsRequestData.v0(this.n);
            frsRequestData.n0(this.p);
            frsRequestData.A0(this.C);
            frsRequestData.m0(vg.g(ox5.a(), 0L));
            String str2 = this.o;
            ArrayList<xn> arrayList = null;
            if (str2 != null) {
                frsRequestData.setStType(str2);
                if ("sidebar".equalsIgnoreCase(this.o)) {
                    frsRequestData.setStType(null);
                }
            }
            frsRequestData.i0(O0());
            if (FrsFragment.u2 != 0) {
                frsRequestData.e0((int) FrsFragment.u2);
            }
            if (FrsFragment.v2 != 0) {
                frsRequestData.f0((int) FrsFragment.v2);
            }
            if (FrsFragment.w2 != 0) {
                frsRequestData.q0(FrsFragment.w2);
            }
            if (frsRequestData.getPn() != 1 && this.h != 3) {
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    arrayList = frsViewData.getThreadList();
                }
                frsRequestData.b0(qr9.e(arrayList, false));
                z2 = false;
            } else {
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    arrayList = frsViewData2.getThreadList();
                }
                frsRequestData.b0(qr9.e(arrayList, true));
                z2 = true;
            }
            frsRequestData.setNeedCache(z2);
            frsRequestData.setUpdateType(this.h);
            frsRequestData.h0(this.q);
            qr7.e(this.D, frsRequestData);
            int d2 = qr7.d(this.F);
            l0(i, frsRequestData);
            f0(this.g, frsRequestData);
            if (!H0(this.F) && !this.a.i && !this.K) {
                t2a i4 = t2a.i();
                String g = i4.g("1~" + this.g, d2, frsRequestData.X(), this.d.V());
                this.I = g;
                new e(this, true, g).execute(new Object[0]);
            }
            q1();
            this.K = false;
        }
    }

    public final void k0(FrsRequestData frsRequestData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{frsRequestData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = i;
            this.a.D4(z);
            this.f.a(i);
            if (this.e.A0() && (this.e.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
                L((MvcHttpResponsedMessage) this.e.getResponsedMessage(), (MvcHttpMessage) this.e.x0(), this.e.y0());
            } else if (this.e.A0() && (this.e.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
                w((MvcSocketResponsedMessage) this.e.getResponsedMessage(), (MvcSocketMessage) this.e.x0(), this.e.y0());
            } else {
                int d2 = qr7.d(this.F);
                if (!H0(this.F) && !this.a.i && !this.K) {
                    t2a i2 = t2a.i();
                    String g = i2.g("1~" + this.g, d2, frsRequestData.X(), this.d.V());
                    this.I = g;
                    new e(this, true, g).execute(new Object[0]);
                }
                this.K = false;
            }
            this.e.w0(this);
        }
    }

    public final void s1(int i, int i2, jf7 jf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048647, this, i, i2, jf7Var) == null) {
            this.w.put(x0(i, i2), jf7Var);
        }
    }
}

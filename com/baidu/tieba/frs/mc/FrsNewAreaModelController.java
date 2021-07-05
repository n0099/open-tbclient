package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.b.d;
import d.a.r0.r.q.b2;
import d.a.s0.h3.f;
import d.a.s0.h3.m;
import d.a.s0.h3.n0.e;
import d.a.s0.w2.a;
/* loaded from: classes5.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.k<FrsRequestData, m> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsNewAreaFragment f15951e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f15952f;

    /* renamed from: g  reason: collision with root package name */
    public FrsNetModel<FrsNewAreaFragment> f15953g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f15954h;

    /* renamed from: i  reason: collision with root package name */
    public f f15955i;
    public String j;
    public int k;
    public int l;
    public String m;
    public int n;
    public String o;
    public String p;
    public int q;
    public long r;
    public long s;
    public long t;
    public long u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = 3;
        this.l = 1;
        this.m = null;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = -1;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.f15951e = frsNewAreaFragment;
    }

    public long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.u : invokeV.longValue;
    }

    public long B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : invokeV.longValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : invokeV.longValue;
    }

    public long D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : invokeV.longValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void F(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            if (bundle != null) {
                this.j = bundle.getString("name");
                this.m = bundle.getString("from");
                this.n = bundle.getInt("flag", 0);
            }
            if (TextUtils.isEmpty(this.j)) {
                this.j = "";
            }
            if (TextUtils.isEmpty(this.m)) {
                this.m = "";
            }
            this.o = this.m;
            this.f15954h = new FrsRequestData();
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
                M(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
                M(6);
            } else {
                M(2);
            }
            this.f15952f = new FrsViewData();
            this.f15954h.w("forum_name", k.getUrlEncode(this.j));
            this.f15954h.w("client_type", "2");
            FrsRequestData frsRequestData = this.f15954h;
            FrsViewData frsViewData = this.f15952f;
            frsRequestData.C(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            FrsNetModel<FrsNewAreaFragment> frsNetModel = new FrsNetModel<>(this.f15951e.getPageContext(), this.f15954h);
            this.f15953g = frsNetModel;
            frsNetModel.Z(this);
            this.f15953g.setUniqueId(this.f15951e.getUniqueId());
            String str = this.j;
            if (str == null || str.length() <= 0) {
                return;
            }
            String str2 = this.m;
            if (str2 == null || str2.length() <= 0) {
                this.m = "tb_forumlist";
            }
        }
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f15953g.Q() : invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            L();
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f15953g.Q()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f15954h), FrsRequestData.class);
        frsRequestData.setPn(i2);
        FrsRequestData frsRequestData2 = this.f15954h;
        FrsViewData frsViewData = this.f15952f;
        frsRequestData2.C(a.e(frsViewData == null ? null : frsViewData.getThreadList(), false));
        x(frsRequestData, 4);
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f15953g.cancelLoadData();
        }
    }

    public final boolean K(FrsRequestData frsRequestData, m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, frsRequestData, mVar)) == null) {
            this.f15952f.receiveData(mVar);
            this.f15952f.frsCurrentTabId = 503;
            if (frsRequestData != null) {
                this.f15954h = frsRequestData;
                this.l = frsRequestData.getPn();
                String z = this.f15954h.z();
                this.j = z;
                this.f15951e.C1(z);
                this.f15951e.setFrom(this.m);
                this.f15951e.D1(this.l);
                this.f15951e.B1(this.n);
            }
            this.f15951e.F.d(this.k, false, this.f15955i);
            this.o = null;
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f15954h), FrsRequestData.class);
            frsRequestData.setPn(1);
            FrsRequestData frsRequestData2 = this.f15954h;
            FrsViewData frsViewData = this.f15952f;
            frsRequestData2.C(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            x(frsRequestData, 3);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.q = i2;
            if (7 == i2) {
                e.b();
            } else {
                e.a();
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.r = System.currentTimeMillis();
            this.f15953g.R();
        }
    }

    public void O() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (frsViewData = this.f15952f) == null || frsViewData.getForum() == null || this.f15952f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f15952f.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void c(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048592, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f61177a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        fVar.f61178b = !mvcSocketResponsedMessage.hasError();
        fVar.f61179c = mvcSocketResponsedMessage.getError();
        fVar.f61180d = mvcSocketResponsedMessage.getErrorString();
        fVar.f61181e = mvcSocketResponsedMessage.getDownSize();
        this.f15955i = fVar;
        m data = mvcSocketResponsedMessage.getData();
        FrsRequestData requestData = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        K(requestData, data);
        this.mErrorCode = mvcSocketResponsedMessage.getError();
        this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            requestData = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            requestData = mvcNetMessage.getRequestData();
        }
        long j2 = j;
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[4];
        objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
        objArr[1] = requestData != null ? requestData.z() : null;
        objArr[2] = "seq_id";
        objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
        d.a.r0.r.z.a.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k : invokeV.intValue;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            bundle.putString("name", this.j);
            bundle.putString("from", this.m);
            bundle.putInt("flag", this.n);
            bundle.putBoolean(FrsActivityConfig.GOOD, true);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048596, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f61177a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        fVar.f61178b = !mvcHttpResponsedMessage.hasError();
        fVar.f61179c = mvcHttpResponsedMessage.getError();
        fVar.f61180d = mvcHttpResponsedMessage.getErrorString();
        fVar.f61181e = mvcHttpResponsedMessage.getDownSize();
        this.f15955i = fVar;
        m data = mvcHttpResponsedMessage.getData();
        FrsRequestData requestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        K(requestData, data);
        this.mErrorCode = mvcHttpResponsedMessage.getError();
        this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            requestData = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            requestData = mvcNetMessage.getRequestData();
        }
        long j2 = j;
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
        objArr[1] = requestData != null ? requestData.z() : null;
        d.a.r0.r.z.a.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }

    public void w(b2 b2Var) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, b2Var) == null) || b2Var == null || (frsViewData = this.f15952f) == null || frsViewData.getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.f15952f.getThreadList())) {
            this.f15952f.getThreadList().add(b2Var);
        } else {
            this.f15952f.getThreadList().add(0, b2Var);
        }
        this.f15951e.v1(this.f15952f);
    }

    public final void x(FrsRequestData frsRequestData, int i2) {
        FrsNewAreaFragment frsNewAreaFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048598, this, frsRequestData, i2) == null) || (frsNewAreaFragment = this.f15951e) == null || !frsNewAreaFragment.isAdded() || this.f15951e.getPageContext() == null) {
            return;
        }
        this.f15951e.F.a(i2);
        this.f15953g.e0(frsRequestData);
        this.k = i2;
        frsRequestData.M(this.j);
        frsRequestData.Z(1);
        frsRequestData.K(0);
        frsRequestData.E(0);
        d.a.s0.u0.n2.k.e(this.q, frsRequestData);
        if (d.n()) {
            d.a.s0.u0.n2.k.e(d.a.r0.b.g.a.d(), frsRequestData);
            frsRequestData.H(d.a.s0.u0.n2.k.d(d.a.r0.b.g.a.d()));
        }
        int k = l.k(this.f15951e.getPageContext().getPageActivity());
        int i3 = l.i(this.f15951e.getPageContext().getPageActivity());
        float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        frsRequestData.Y(k);
        frsRequestData.X(i3);
        frsRequestData.W(f2);
        frsRequestData.b0(i4);
        frsRequestData.O(this.p);
        String str = this.o;
        if (str != null) {
            frsRequestData.setStType(str);
        }
        if (FrsFragment.c2 != 0) {
            frsRequestData.F((int) FrsFragment.c2);
        }
        if (FrsFragment.d2 != 0) {
            frsRequestData.G((int) FrsFragment.d2);
        }
        if (FrsFragment.e2 != 0) {
            frsRequestData.R(FrsFragment.e2);
        }
        frsRequestData.setUpdateType(this.k);
        frsRequestData.setNeedCache(false);
        N();
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.q : invokeV.intValue;
    }

    public FrsViewData z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f15952f : (FrsViewData) invokeV.objValue;
    }
}

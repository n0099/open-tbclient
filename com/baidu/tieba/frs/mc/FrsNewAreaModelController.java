package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.b.d;
import c.a.q0.s.q.d2;
import c.a.r0.j3.f;
import c.a.r0.j3.m;
import c.a.r0.j3.o0.e;
import c.a.r0.y2.a;
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
/* loaded from: classes7.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.k<FrsRequestData, m> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsNewAreaFragment f51544e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f51545f;

    /* renamed from: g  reason: collision with root package name */
    public FrsNetModel<FrsNewAreaFragment> f51546g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f51547h;

    /* renamed from: i  reason: collision with root package name */
    public f f51548i;

    /* renamed from: j  reason: collision with root package name */
    public String f51549j;
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51549j = null;
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
        this.f51544e = frsNewAreaFragment;
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
                this.f51549j = bundle.getString("name");
                this.m = bundle.getString("from");
                this.n = bundle.getInt("flag", 0);
            }
            if (TextUtils.isEmpty(this.f51549j)) {
                this.f51549j = "";
            }
            if (TextUtils.isEmpty(this.m)) {
                this.m = "";
            }
            this.o = this.m;
            this.f51547h = new FrsRequestData();
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.o)) {
                M(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.o)) {
                M(6);
            } else {
                M(2);
            }
            this.f51545f = new FrsViewData();
            this.f51547h.w("forum_name", k.getUrlEncode(this.f51549j));
            this.f51547h.w("client_type", "2");
            FrsRequestData frsRequestData = this.f51547h;
            FrsViewData frsViewData = this.f51545f;
            frsRequestData.C(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            FrsNetModel<FrsNewAreaFragment> frsNetModel = new FrsNetModel<>(this.f51544e.getPageContext(), this.f51547h);
            this.f51546g = frsNetModel;
            frsNetModel.Z(this);
            this.f51546g.setUniqueId(this.f51544e.getUniqueId());
            String str = this.f51549j;
            if (str == null || str.length() <= 0) {
                return;
            }
            String str2 = this.m;
            if (str2 == null || str2.length() <= 0) {
                this.m = FrsFragment.FRS_FROM_LIKE;
            }
        }
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f51546g.Q() : invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            L();
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f51546g.Q()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f51547h), FrsRequestData.class);
        frsRequestData.setPn(i2);
        FrsRequestData frsRequestData2 = this.f51547h;
        FrsViewData frsViewData = this.f51545f;
        frsRequestData2.C(a.e(frsViewData == null ? null : frsViewData.getThreadList(), false));
        x(frsRequestData, 4);
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f51546g.cancelLoadData();
        }
    }

    public final boolean K(FrsRequestData frsRequestData, m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, frsRequestData, mVar)) == null) {
            this.f51545f.receiveData(mVar);
            this.f51545f.frsCurrentTabId = 503;
            if (frsRequestData != null) {
                this.f51547h = frsRequestData;
                this.l = frsRequestData.getPn();
                String z = this.f51547h.z();
                this.f51549j = z;
                this.f51544e.setForum(z);
                this.f51544e.setFrom(this.m);
                this.f51544e.setPn(this.l);
                this.f51544e.setFlag(this.n);
            }
            this.f51544e.mForumModelCallback.d(this.k, false, this.f51548i);
            this.o = null;
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f51547h), FrsRequestData.class);
            frsRequestData.setPn(1);
            FrsRequestData frsRequestData2 = this.f51547h;
            FrsViewData frsViewData = this.f51545f;
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
            this.f51546g.R();
        }
    }

    public void O() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (frsViewData = this.f51545f) == null || frsViewData.getForum() == null || this.f51545f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f51545f.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f20792a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        fVar.f20793b = !mvcSocketResponsedMessage.hasError();
        fVar.f20794c = mvcSocketResponsedMessage.getError();
        fVar.f20795d = mvcSocketResponsedMessage.getErrorString();
        fVar.f20796e = mvcSocketResponsedMessage.getDownSize();
        this.f51548i = fVar;
        m data = mvcSocketResponsedMessage.getData();
        FrsRequestData requestData = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        K(requestData, data);
        this.mErrorCode = mvcSocketResponsedMessage.getError();
        this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        long j2 = 0;
        if (mvcSocketMessage != null) {
            j2 = mvcSocketMessage.getClientLogID();
            requestData = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j2 = mvcNetMessage.getLogID();
            requestData = mvcNetMessage.getRequestData();
        }
        long j3 = j2;
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[4];
        objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
        objArr[1] = requestData != null ? requestData.z() : null;
        objArr[2] = "seq_id";
        objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
        c.a.q0.s.z.a.a("frs", j3, cmd, "socket_resp", error, errorString, objArr);
    }

    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            bundle.putString("name", this.f51549j);
            bundle.putString("from", this.m);
            bundle.putInt("flag", this.n);
            bundle.putBoolean("good", true);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048596, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f20792a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        fVar.f20793b = !mvcHttpResponsedMessage.hasError();
        fVar.f20794c = mvcHttpResponsedMessage.getError();
        fVar.f20795d = mvcHttpResponsedMessage.getErrorString();
        fVar.f20796e = mvcHttpResponsedMessage.getDownSize();
        this.f51548i = fVar;
        m data = mvcHttpResponsedMessage.getData();
        FrsRequestData requestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        K(requestData, data);
        this.mErrorCode = mvcHttpResponsedMessage.getError();
        this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        long j2 = 0;
        if (mvcHttpMessage != null) {
            j2 = mvcHttpMessage.getClientLogID();
            requestData = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j2 = mvcNetMessage.getLogID();
            requestData = mvcNetMessage.getRequestData();
        }
        long j3 = j2;
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
        objArr[1] = requestData != null ? requestData.z() : null;
        c.a.q0.s.z.a.a("frs", j3, cmd, "http_resp", error, errorString, objArr);
    }

    public void w(d2 d2Var) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, d2Var) == null) || d2Var == null || (frsViewData = this.f51545f) == null || frsViewData.getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.f51545f.getThreadList())) {
            this.f51545f.getThreadList().add(d2Var);
        } else {
            this.f51545f.getThreadList().add(0, d2Var);
        }
        this.f51544e.onViewDataChange(this.f51545f);
    }

    public final void x(FrsRequestData frsRequestData, int i2) {
        FrsNewAreaFragment frsNewAreaFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048598, this, frsRequestData, i2) == null) || (frsNewAreaFragment = this.f51544e) == null || !frsNewAreaFragment.isAdded() || this.f51544e.getPageContext() == null) {
            return;
        }
        this.f51544e.mForumModelCallback.a(i2);
        this.f51546g.e0(frsRequestData);
        this.k = i2;
        frsRequestData.M(this.f51549j);
        frsRequestData.Z(1);
        frsRequestData.K(0);
        frsRequestData.E(0);
        c.a.r0.w0.n2.k.e(this.q, frsRequestData);
        if (d.q()) {
            c.a.r0.w0.n2.k.e(c.a.q0.b.g.a.d(), frsRequestData);
            frsRequestData.H(c.a.r0.w0.n2.k.d(c.a.q0.b.g.a.d()));
        }
        int k = l.k(this.f51544e.getPageContext().getPageActivity());
        int i3 = l.i(this.f51544e.getPageContext().getPageActivity());
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
        if (FrsFragment.mPbLoadTime != 0) {
            frsRequestData.F((int) FrsFragment.mPbLoadTime);
        }
        if (FrsFragment.mPbLoadDataSize != 0) {
            frsRequestData.G((int) FrsFragment.mPbLoadDataSize);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.R(FrsFragment.mNetError);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f51545f : (FrsViewData) invokeV.objValue;
    }
}

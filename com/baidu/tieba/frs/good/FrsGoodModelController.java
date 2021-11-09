package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.r0.l3.f;
import b.a.r0.l3.m;
import b.a.r0.z2.a;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.k<FrsRequestData, m> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsGoodFragment f48753e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f48754f;

    /* renamed from: g  reason: collision with root package name */
    public FrsNetModel<FrsGoodFragment> f48755g;

    /* renamed from: h  reason: collision with root package name */
    public FrsRequestData f48756h;

    /* renamed from: i  reason: collision with root package name */
    public f f48757i;
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
    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment};
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
        this.j = null;
        this.k = 3;
        this.l = 1;
        this.m = null;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.f48753e = frsGoodFragment;
    }

    public long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.t : invokeV.longValue;
    }

    public long B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : invokeV.longValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q < 100 : invokeV.booleanValue;
    }

    public void D(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
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
            this.f48756h = new FrsRequestData();
            this.f48754f = new FrsViewData();
            this.f48756h.w("forum_name", k.getUrlEncode(this.j));
            this.f48756h.w("client_type", "2");
            FrsNetModel<FrsGoodFragment> frsNetModel = new FrsNetModel<>(this.f48753e.getPageContext(), this.f48756h);
            this.f48755g = frsNetModel;
            frsNetModel.Y(this);
            this.f48755g.setUniqueId(this.f48753e.getUniqueId());
            String str = this.j;
            if (str == null || str.length() <= 0) {
                return;
            }
            String str2 = this.m;
            if (str2 == null || str2.length() <= 0) {
                this.m = FrsFragment.FRS_FROM_LIKE;
            }
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48755g.Q() : invokeV.booleanValue;
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.q = i2;
            J();
        }
    }

    public void G(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) || this.f48755g.Q()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f48756h), FrsRequestData.class);
        frsRequestData.setPn(i2);
        frsRequestData.C(str);
        w(frsRequestData, 4);
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f48755g.cancelLoadData();
        }
    }

    public final boolean I(FrsRequestData frsRequestData, m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsRequestData, mVar)) == null) {
            if (frsRequestData == null || frsRequestData.getCid() == this.q) {
                this.f48754f.receiveData(mVar);
                this.f48754f.frsCurrentTabId = 301;
                if (frsRequestData != null) {
                    this.f48756h = frsRequestData;
                    this.l = frsRequestData.getPn();
                    String z = this.f48756h.z();
                    this.j = z;
                    this.f48753e.setForum(z);
                    this.f48753e.setFrom(this.m);
                    this.f48753e.setPn(this.l);
                    this.f48753e.setFlag(this.n);
                }
                this.f48753e.mForumModelCallback.d(this.k, false, this.f48757i);
                this.o = null;
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.f48756h), FrsRequestData.class);
            frsRequestData.setPn(1);
            FrsViewData frsViewData = this.f48754f;
            frsRequestData.C(a.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            w(frsRequestData, 3);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.r = System.currentTimeMillis();
            this.f48755g.loadData();
        }
    }

    public void L() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (frsViewData = this.f48754f) == null || frsViewData.getForum() == null || this.f48754f.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.f48754f.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.p = lastIds;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f20550a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        fVar.f20551b = !mvcSocketResponsedMessage.hasError();
        fVar.f20552c = mvcSocketResponsedMessage.getError();
        fVar.f20553d = mvcSocketResponsedMessage.getErrorString();
        fVar.f20554e = mvcSocketResponsedMessage.getDownSize();
        this.f48757i = fVar;
        m data = mvcSocketResponsedMessage.getData();
        FrsRequestData requestData = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        I(requestData, data);
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
        b.a.q0.s.a0.a.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            bundle.putString("name", this.j);
            bundle.putString("from", this.m);
            bundle.putInt("flag", this.n);
            bundle.putBoolean("good", true);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048593, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        f fVar = new f();
        fVar.f20550a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        fVar.f20551b = !mvcHttpResponsedMessage.hasError();
        fVar.f20552c = mvcHttpResponsedMessage.getError();
        fVar.f20553d = mvcHttpResponsedMessage.getErrorString();
        fVar.f20554e = mvcHttpResponsedMessage.getDownSize();
        this.f48757i = fVar;
        m data = mvcHttpResponsedMessage.getData();
        FrsRequestData requestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        I(requestData, data);
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
        b.a.q0.s.a0.a.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }

    public final void w(FrsRequestData frsRequestData, int i2) {
        FrsGoodFragment frsGoodFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, frsRequestData, i2) == null) || (frsGoodFragment = this.f48753e) == null || !frsGoodFragment.isAdded() || this.f48753e.getPageContext() == null) {
            return;
        }
        this.f48753e.mForumModelCallback.a(i2);
        this.f48755g.d0(frsRequestData);
        this.k = i2;
        frsRequestData.M(this.j);
        frsRequestData.Z(1);
        frsRequestData.K(1);
        frsRequestData.L(0);
        frsRequestData.E(this.q);
        int k = l.k(this.f48753e.getPageContext().getPageActivity());
        int i3 = l.i(this.f48753e.getPageContext().getPageActivity());
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
        K();
    }

    public FrsViewData x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f48754f : (FrsViewData) invokeV.objValue;
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.u : invokeV.longValue;
    }

    public long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.r : invokeV.longValue;
    }
}

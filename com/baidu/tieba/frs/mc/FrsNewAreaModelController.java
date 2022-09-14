package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.cl8;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.kl8;
import com.baidu.tieba.ku6;
import com.baidu.tieba.oo5;
import com.baidu.tieba.qc8;
import com.baidu.tieba.qw4;
import com.baidu.tieba.r9;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.xn8;
import com.baidu.tieba.xs6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.k<FrsRequestData, kl8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public FrsViewData b;
    public FrsNetModel<FrsNewAreaFragment> c;
    public FrsRequestData d;
    public cl8 e;
    public String f;
    public int g;
    public int h;
    public String i;
    public int j;
    public String k;
    public String l;
    public int m;
    public long n;
    public long o;
    public long p;
    public long q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment};
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
        this.f = null;
        this.g = 3;
        this.h = 1;
        this.i = null;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = 0L;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.a = frsNewAreaFragment;
    }

    public final void A(FrsRequestData frsRequestData, int i) {
        FrsNewAreaFragment frsNewAreaFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, frsRequestData, i) == null) || (frsNewAreaFragment = this.a) == null || !frsNewAreaFragment.isAdded() || this.a.getPageContext() == null) {
            return;
        }
        this.a.B.a(i);
        this.c.g0(frsRequestData);
        this.g = i;
        frsRequestData.Q(this.f);
        frsRequestData.e0(1);
        frsRequestData.O(0);
        frsRequestData.I(0);
        xs6.e(this.m, frsRequestData);
        if (UbsABTestHelper.isFrsNewAreaTabSortTestA()) {
            xs6.e(FrsTabTestHelper.getFrsNewAreaTabSort(), frsRequestData);
            frsRequestData.L(xs6.d(FrsTabTestHelper.getFrsNewAreaTabSort()));
        }
        int k = ej.k(this.a.getPageContext().getPageActivity());
        int i2 = ej.i(this.a.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        frsRequestData.d0(k);
        frsRequestData.c0(i2);
        frsRequestData.b0(f);
        frsRequestData.g0(i3);
        frsRequestData.S(this.l);
        String str = this.k;
        if (str != null) {
            frsRequestData.setStType(str);
        }
        if (FrsFragment.m2 != 0) {
            frsRequestData.J((int) FrsFragment.m2);
        }
        if (FrsFragment.n2 != 0) {
            frsRequestData.K((int) FrsFragment.n2);
        }
        if (FrsFragment.o2 != 0) {
            frsRequestData.V(FrsFragment.o2);
        }
        frsRequestData.setUpdateType(this.g);
        frsRequestData.setNeedCache(false);
        Q();
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : invokeV.intValue;
    }

    public FrsViewData C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (FrsViewData) invokeV.objValue;
    }

    public long D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : invokeV.longValue;
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.longValue;
    }

    public long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : invokeV.longValue;
    }

    public long G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : invokeV.longValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void I(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            if (bundle != null) {
                this.f = bundle.getString("name");
                this.i = bundle.getString("from");
                this.j = bundle.getInt("flag", 0);
            }
            if (TextUtils.isEmpty(this.f)) {
                this.f = "";
            }
            if (TextUtils.isEmpty(this.i)) {
                this.i = "";
            }
            this.k = this.i;
            this.d = new FrsRequestData();
            if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.k)) {
                P(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.k)) {
                P(6);
            } else {
                P(2);
            }
            this.b = new FrsViewData();
            this.d.z("forum_name", dj.getUrlEncode(this.f));
            this.d.z("client_type", "2");
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData = this.b;
            frsRequestData.G(qc8.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            FrsNetModel<FrsNewAreaFragment> frsNetModel = new FrsNetModel<>(this.a.getPageContext(), this.d);
            this.c = frsNetModel;
            frsNetModel.b0(this);
            this.c.setUniqueId(this.a.getUniqueId());
            String str = this.f;
            if (str == null || str.length() <= 0) {
                return;
            }
            String str2 = this.i;
            if (str2 == null || str2.length() <= 0) {
                this.i = "tb_forumlist";
            }
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c.T() : invokeV.booleanValue;
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || this.c.T()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(i);
        FrsRequestData frsRequestData2 = this.d;
        FrsViewData frsViewData = this.b;
        frsRequestData2.G(qc8.e(frsViewData == null ? null : frsViewData.getThreadList(), false));
        A(frsRequestData, 4);
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.c.cancelLoadData();
        }
    }

    public void M(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            bundle.putString("name", this.f);
            bundle.putString("from", this.i);
            bundle.putInt("flag", this.j);
            bundle.putBoolean(FrsActivityConfig.GOOD, true);
        }
    }

    public final boolean N(FrsRequestData frsRequestData, kl8 kl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, frsRequestData, kl8Var)) == null) {
            if (oo5.k().l(AbsDataRecorder.Scene.FRS_NEW)) {
                oo5.k().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            this.b.receiveData(kl8Var);
            this.b.frsCurrentTabId = 503;
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.h = frsRequestData.getPn();
                String D = this.d.D();
                this.f = D;
                this.a.n2(D);
                this.a.setFrom(this.i);
                this.a.o2(this.h);
                this.a.m2(this.j);
            }
            this.a.B.d(this.g, false, this.e);
            this.k = null;
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
            frsRequestData.setPn(1);
            FrsRequestData frsRequestData2 = this.d;
            FrsViewData frsViewData = this.b;
            frsRequestData2.G(qc8.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            A(frsRequestData, 3);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.m = i;
            if (7 == i) {
                xn8.b();
            } else {
                xn8.a();
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.n = System.currentTimeMillis();
            this.c.loadData();
            ku6.a();
        }
    }

    public void R() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.l = lastIds;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.g : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            O();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage<kl8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, kl8> mvcSocketMessage, MvcNetMessage<FrsRequestData, kl8> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048597, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        cl8 cl8Var = new cl8();
        cl8Var.a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        cl8Var.b = !mvcSocketResponsedMessage.hasError();
        cl8Var.c = mvcSocketResponsedMessage.getError();
        cl8Var.d = mvcSocketResponsedMessage.getErrorString();
        cl8Var.e = mvcSocketResponsedMessage.getDownSize();
        this.e = cl8Var;
        kl8 data = mvcSocketResponsedMessage.getData();
        FrsRequestData requestData = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        N(requestData, data);
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
        objArr[1] = requestData != null ? requestData.D() : null;
        objArr[2] = "seq_id";
        objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
        qw4.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage<kl8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, kl8> mvcHttpMessage, MvcNetMessage<FrsRequestData, kl8> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048598, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        cl8 cl8Var = new cl8();
        cl8Var.a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        cl8Var.b = !mvcHttpResponsedMessage.hasError();
        cl8Var.c = mvcHttpResponsedMessage.getError();
        cl8Var.d = mvcHttpResponsedMessage.getErrorString();
        cl8Var.e = mvcHttpResponsedMessage.getDownSize();
        this.e = cl8Var;
        kl8 data = mvcHttpResponsedMessage.getData();
        FrsRequestData requestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        N(requestData, data);
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
        objArr[1] = requestData != null ? requestData.D() : null;
        qw4.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }

    public void z(ThreadData threadData) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, threadData) == null) || threadData == null || (frsViewData = this.b) == null || frsViewData.getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.b.getThreadList())) {
            this.b.getThreadList().add(threadData);
        } else {
            this.b.getThreadList().add(0, threadData);
        }
        this.a.g2(this.b);
    }
}

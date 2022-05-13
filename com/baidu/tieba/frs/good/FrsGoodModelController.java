package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
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
import com.repackage.b9;
import com.repackage.gi8;
import com.repackage.gr6;
import com.repackage.li;
import com.repackage.mi;
import com.repackage.n98;
import com.repackage.oi8;
import com.repackage.xt4;
/* loaded from: classes3.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.k<FrsRequestData, oi8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public FrsViewData b;
    public FrsNetModel<FrsGoodFragment> c;
    public FrsRequestData d;
    public gi8 e;
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
    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
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
        this.m = 0;
        this.n = 0L;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.a = frsGoodFragment;
    }

    public long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : invokeV.longValue;
    }

    public long B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : invokeV.longValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : invokeV.longValue;
    }

    public long D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o : invokeV.longValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m < 100 : invokeV.booleanValue;
    }

    public void F(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
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
            this.b = new FrsViewData();
            this.d.y("forum_name", li.getUrlEncode(this.f));
            this.d.y("client_type", "2");
            FrsNetModel<FrsGoodFragment> frsNetModel = new FrsNetModel<>(this.a.getPageContext(), this.d);
            this.c = frsNetModel;
            frsNetModel.a0(this);
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

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c.S() : invokeV.booleanValue;
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
            M();
        }
    }

    public void I(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str) == null) || this.c.S()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(i);
        frsRequestData.F(str);
        y(frsRequestData, 4);
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c.cancelLoadData();
        }
    }

    public void K(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            bundle.putString("name", this.f);
            bundle.putString("from", this.i);
            bundle.putInt("flag", this.j);
            bundle.putBoolean(FrsActivityConfig.GOOD, true);
        }
    }

    public final boolean L(FrsRequestData frsRequestData, oi8 oi8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, frsRequestData, oi8Var)) == null) {
            if (frsRequestData == null || frsRequestData.A() == this.m) {
                this.b.receiveData(oi8Var);
                this.b.frsCurrentTabId = 301;
                if (frsRequestData != null) {
                    this.d = frsRequestData;
                    this.h = frsRequestData.getPn();
                    String C = this.d.C();
                    this.f = C;
                    this.a.t1(C);
                    this.a.setFrom(this.i);
                    this.a.u1(this.h);
                    this.a.s1(this.j);
                }
                this.a.F.d(this.g, false, this.e);
                this.k = null;
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
            frsRequestData.setPn(1);
            FrsViewData frsViewData = this.b;
            frsRequestData.F(n98.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            y(frsRequestData, 3);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.n = System.currentTimeMillis();
            this.c.loadData();
            gr6.a();
        }
    }

    public void O() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.g : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage<oi8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, oi8> mvcSocketMessage, MvcNetMessage<FrsRequestData, oi8> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        gi8 gi8Var = new gi8();
        gi8Var.a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        gi8Var.b = !mvcSocketResponsedMessage.hasError();
        gi8Var.c = mvcSocketResponsedMessage.getError();
        gi8Var.d = mvcSocketResponsedMessage.getErrorString();
        gi8Var.e = mvcSocketResponsedMessage.getDownSize();
        this.e = gi8Var;
        oi8 data = mvcSocketResponsedMessage.getData();
        FrsRequestData requestData = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        L(requestData, data);
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
        objArr[1] = requestData != null ? requestData.C() : null;
        objArr[2] = "seq_id";
        objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
        xt4.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage<oi8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, oi8> mvcHttpMessage, MvcNetMessage<FrsRequestData, oi8> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048595, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        gi8 gi8Var = new gi8();
        gi8Var.a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        gi8Var.b = !mvcHttpResponsedMessage.hasError();
        gi8Var.c = mvcHttpResponsedMessage.getError();
        gi8Var.d = mvcHttpResponsedMessage.getErrorString();
        gi8Var.e = mvcHttpResponsedMessage.getDownSize();
        this.e = gi8Var;
        oi8 data = mvcHttpResponsedMessage.getData();
        FrsRequestData requestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        if (mvcNetMessage != null) {
            requestData = mvcNetMessage.getRequestData();
        }
        L(requestData, data);
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
        objArr[1] = requestData != null ? requestData.C() : null;
        xt4.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }

    public final void y(FrsRequestData frsRequestData, int i) {
        FrsGoodFragment frsGoodFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048596, this, frsRequestData, i) == null) || (frsGoodFragment = this.a) == null || !frsGoodFragment.isAdded() || this.a.getPageContext() == null) {
            return;
        }
        this.a.F.a(i);
        this.c.f0(frsRequestData);
        this.g = i;
        frsRequestData.P(this.f);
        frsRequestData.c0(1);
        frsRequestData.N(1);
        frsRequestData.O(0);
        frsRequestData.H(this.m);
        int k = mi.k(this.a.getPageContext().getPageActivity());
        int i2 = mi.i(this.a.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        frsRequestData.b0(k);
        frsRequestData.a0(i2);
        frsRequestData.Z(f);
        frsRequestData.e0(i3);
        frsRequestData.R(this.l);
        String str = this.k;
        if (str != null) {
            frsRequestData.setStType(str);
        }
        if (FrsFragment.f2 != 0) {
            frsRequestData.I((int) FrsFragment.f2);
        }
        if (FrsFragment.g2 != 0) {
            frsRequestData.J((int) FrsFragment.g2);
        }
        if (FrsFragment.h2 != 0) {
            frsRequestData.U(FrsFragment.h2);
        }
        frsRequestData.setUpdateType(this.g);
        frsRequestData.setNeedCache(false);
        N();
    }

    public FrsViewData z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.b : (FrsViewData) invokeV.objValue;
    }
}

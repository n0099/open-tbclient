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
import com.repackage.br6;
import com.repackage.d9;
import com.repackage.dh8;
import com.repackage.mt4;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.vg8;
import com.repackage.w88;
/* loaded from: classes3.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.k<FrsRequestData, dh8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public FrsViewData b;
    public FrsNetModel<FrsGoodFragment> c;
    public FrsRequestData d;
    public vg8 e;
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
                super((d9) newInitContext.callArgs[0]);
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

    public final void A(FrsRequestData frsRequestData, int i) {
        FrsGoodFragment frsGoodFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, frsRequestData, i) == null) || (frsGoodFragment = this.a) == null || !frsGoodFragment.isAdded() || this.a.getPageContext() == null) {
            return;
        }
        this.a.F.a(i);
        this.c.h0(frsRequestData);
        this.g = i;
        frsRequestData.R(this.f);
        frsRequestData.e0(1);
        frsRequestData.P(1);
        frsRequestData.Q(0);
        frsRequestData.J(this.m);
        int k = pi.k(this.a.getPageContext().getPageActivity());
        int i2 = pi.i(this.a.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        frsRequestData.d0(k);
        frsRequestData.c0(i2);
        frsRequestData.b0(f);
        frsRequestData.g0(i3);
        frsRequestData.T(this.l);
        String str = this.k;
        if (str != null) {
            frsRequestData.setStType(str);
        }
        if (FrsFragment.h2 != 0) {
            frsRequestData.K((int) FrsFragment.h2);
        }
        if (FrsFragment.i2 != 0) {
            frsRequestData.L((int) FrsFragment.i2);
        }
        if (FrsFragment.j2 != 0) {
            frsRequestData.W(FrsFragment.j2);
        }
        frsRequestData.setUpdateType(this.g);
        frsRequestData.setNeedCache(false);
        P();
    }

    public FrsViewData B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (FrsViewData) invokeV.objValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : invokeV.longValue;
    }

    public long D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.longValue;
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.longValue;
    }

    public long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : invokeV.longValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m < 100 : invokeV.booleanValue;
    }

    public void H(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
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
            this.d.A("forum_name", oi.getUrlEncode(this.f));
            this.d.A("client_type", "2");
            FrsNetModel<FrsGoodFragment> frsNetModel = new FrsNetModel<>(this.a.getPageContext(), this.d);
            this.c = frsNetModel;
            frsNetModel.c0(this);
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

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c.U() : invokeV.booleanValue;
    }

    public void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.m = i;
            O();
        }
    }

    public void K(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) || this.c.U()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(i);
        frsRequestData.H(str);
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

    public final boolean N(FrsRequestData frsRequestData, dh8 dh8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, frsRequestData, dh8Var)) == null) {
            if (frsRequestData == null || frsRequestData.C() == this.m) {
                this.b.receiveData(dh8Var);
                this.b.frsCurrentTabId = 301;
                if (frsRequestData != null) {
                    this.d = frsRequestData;
                    this.h = frsRequestData.getPn();
                    String E = this.d.E();
                    this.f = E;
                    this.a.k2(E);
                    this.a.setFrom(this.i);
                    this.a.l2(this.h);
                    this.a.j2(this.j);
                }
                this.a.F.d(this.g, false, this.e);
                this.k = null;
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
            frsRequestData.setPn(1);
            FrsViewData frsViewData = this.b;
            frsRequestData.H(w88.e(frsViewData == null ? null : frsViewData.getThreadList(), true));
            A(frsRequestData, 3);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.n = System.currentTimeMillis();
            this.c.loadData();
            br6.a();
        }
    }

    public void Q() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.g : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void o(MvcSocketResponsedMessage<dh8, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, dh8> mvcSocketMessage, MvcNetMessage<FrsRequestData, dh8> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048596, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        vg8 vg8Var = new vg8();
        vg8Var.a = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        vg8Var.b = !mvcSocketResponsedMessage.hasError();
        vg8Var.c = mvcSocketResponsedMessage.getError();
        vg8Var.d = mvcSocketResponsedMessage.getErrorString();
        vg8Var.e = mvcSocketResponsedMessage.getDownSize();
        this.e = vg8Var;
        dh8 data = mvcSocketResponsedMessage.getData();
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
        objArr[1] = requestData != null ? requestData.E() : null;
        objArr[2] = "seq_id";
        objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
        mt4.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void t(MvcHttpResponsedMessage<dh8> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, dh8> mvcHttpMessage, MvcNetMessage<FrsRequestData, dh8> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048597, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        vg8 vg8Var = new vg8();
        vg8Var.a = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        vg8Var.b = !mvcHttpResponsedMessage.hasError();
        vg8Var.c = mvcHttpResponsedMessage.getError();
        vg8Var.d = mvcHttpResponsedMessage.getErrorString();
        vg8Var.e = mvcHttpResponsedMessage.getDownSize();
        this.e = vg8Var;
        dh8 data = mvcHttpResponsedMessage.getData();
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
        objArr[1] = requestData != null ? requestData.E() : null;
        mt4.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }
}

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
import com.baidu.tieba.c95;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.k9;
import com.baidu.tieba.ml9;
import com.baidu.tieba.qw9;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.ui;
import com.baidu.tieba.us7;
import com.baidu.tieba.vi;
import com.baidu.tieba.vn;
import com.baidu.tieba.yw9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.k<FrsRequestData, yw9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public FrsViewData b;
    public FrsNetModel<FrsGoodFragment> c;
    public FrsRequestData d;
    public qw9 e;
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

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
                super((k9) newInitContext.callArgs[0]);
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void L(MvcHttpResponsedMessage<yw9> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, yw9> mvcHttpMessage, MvcNetMessage<FrsRequestData, yw9> mvcNetMessage) {
        boolean z;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        qw9 qw9Var = new qw9();
        if (mvcHttpResponsedMessage.getError() >= -13 && mvcHttpResponsedMessage.getError() <= -10) {
            z = false;
        } else {
            z = true;
        }
        qw9Var.a = z;
        qw9Var.b = !mvcHttpResponsedMessage.hasError();
        qw9Var.c = mvcHttpResponsedMessage.getError();
        qw9Var.d = mvcHttpResponsedMessage.getErrorString();
        qw9Var.e = mvcHttpResponsedMessage.getDownSize();
        this.e = qw9Var;
        yw9 data = mvcHttpResponsedMessage.getData();
        String str = null;
        if (mvcHttpMessage != null) {
            frsRequestData = mvcHttpMessage.getRequestData();
        } else {
            frsRequestData = null;
        }
        if (mvcNetMessage != null) {
            frsRequestData = mvcNetMessage.getRequestData();
        }
        h0(frsRequestData, data);
        this.mErrorCode = mvcHttpResponsedMessage.getError();
        this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            frsRequestData = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        }
        long j2 = j;
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
        if (frsRequestData != null) {
            str = frsRequestData.Y();
        }
        objArr[1] = str;
        c95.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void z(MvcSocketResponsedMessage<yw9, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, yw9> mvcSocketMessage, MvcNetMessage<FrsRequestData, yw9> mvcNetMessage) {
        boolean z;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048597, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        qw9 qw9Var = new qw9();
        if (mvcSocketResponsedMessage.getError() >= -13 && mvcSocketResponsedMessage.getError() <= -10) {
            z = false;
        } else {
            z = true;
        }
        qw9Var.a = z;
        qw9Var.b = !mvcSocketResponsedMessage.hasError();
        qw9Var.c = mvcSocketResponsedMessage.getError();
        qw9Var.d = mvcSocketResponsedMessage.getErrorString();
        qw9Var.e = mvcSocketResponsedMessage.getDownSize();
        this.e = qw9Var;
        yw9 data = mvcSocketResponsedMessage.getData();
        String str = null;
        if (mvcSocketMessage != null) {
            frsRequestData = mvcSocketMessage.getRequestData();
        } else {
            frsRequestData = null;
        }
        if (mvcNetMessage != null) {
            frsRequestData = mvcNetMessage.getRequestData();
        }
        h0(frsRequestData, data);
        this.mErrorCode = mvcSocketResponsedMessage.getError();
        this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            frsRequestData = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        }
        long j2 = j;
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[4];
        objArr[0] = TiebaStatic.Params.H5_FORUM_NAME;
        if (frsRequestData != null) {
            str = frsRequestData.Y();
        }
        objArr[1] = str;
        objArr[2] = PushConstants.SEQ_ID;
        objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
        c95.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
    }

    public final void U(FrsRequestData frsRequestData, int i) {
        FrsGoodFragment frsGoodFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsRequestData, i) == null) && (frsGoodFragment = this.a) != null && frsGoodFragment.isAdded() && this.a.getPageContext() != null) {
            this.a.F.a(i);
            this.c.B0(frsRequestData);
            this.g = i;
            frsRequestData.l0(this.f);
            int i2 = 1;
            frsRequestData.z0(1);
            frsRequestData.j0(1);
            frsRequestData.k0(0);
            frsRequestData.d0(this.m);
            int l = vi.l(this.a.getPageContext().getPageActivity());
            int j = vi.j(this.a.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            }
            frsRequestData.y0(l);
            frsRequestData.x0(j);
            frsRequestData.w0(f);
            frsRequestData.B0(i2);
            frsRequestData.n0(this.l);
            String str = this.k;
            if (str != null) {
                frsRequestData.setStType(str);
            }
            if (FrsFragment.u2 != 0) {
                frsRequestData.e0((int) FrsFragment.u2);
            }
            if (FrsFragment.v2 != 0) {
                frsRequestData.f0((int) FrsFragment.v2);
            }
            if (FrsFragment.w2 != 0) {
                frsRequestData.q0(FrsFragment.w2);
            }
            frsRequestData.setUpdateType(this.g);
            frsRequestData.setNeedCache(false);
            j0();
        }
    }

    public FrsViewData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public long W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    public long X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return invokeV.longValue;
    }

    public long Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.p;
        }
        return invokeV.longValue;
    }

    public long Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.o;
        }
        return invokeV.longValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.m >= 100) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c.o0();
        }
        return invokeV.booleanValue;
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.c.cancelLoadData();
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.n = System.currentTimeMillis();
            this.c.loadData();
            us7.a();
        }
    }

    public void b0(Bundle bundle) {
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
            this.b = new FrsViewData();
            this.d.U("forum_name", ui.getUrlEncode(this.f));
            this.d.U("client_type", "2");
            FrsNetModel<FrsGoodFragment> frsNetModel = new FrsNetModel<>(this.a.getPageContext(), this.d);
            this.c = frsNetModel;
            frsNetModel.w0(this);
            this.c.setUniqueId(this.a.getUniqueId());
            String str = this.f;
            if (str != null && str.length() > 0) {
                String str2 = this.i;
                if (str2 == null || str2.length() <= 0) {
                    this.i = "tb_forumlist";
                }
            }
        }
    }

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.m = i;
            i0();
        }
    }

    public void g0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            bundle.putString("name", this.f);
            bundle.putString("from", this.i);
            bundle.putInt("flag", this.j);
            bundle.putBoolean(FrsActivityConfig.GOOD, true);
        }
    }

    public void e0(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048588, this, i, str) != null) || this.c.o0()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(i);
        frsRequestData.b0(str);
        U(frsRequestData, 4);
    }

    public final boolean h0(FrsRequestData frsRequestData, yw9 yw9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, frsRequestData, yw9Var)) == null) {
            if (frsRequestData != null && frsRequestData.W() != this.m) {
                return false;
            }
            this.b.receiveData(yw9Var);
            this.b.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.h = frsRequestData.getPn();
                String Y = this.d.Y();
                this.f = Y;
                this.a.y2(Y);
                this.a.setFrom(this.i);
                this.a.z2(this.h);
                this.a.x2(this.j);
            }
            this.a.F.d(this.g, false, this.e);
            this.k = null;
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        ArrayList<vn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
            frsRequestData.setPn(1);
            FrsViewData frsViewData = this.b;
            if (frsViewData == null) {
                threadList = null;
            } else {
                threadList = frsViewData.getThreadList();
            }
            frsRequestData.b0(ml9.e(threadList, true));
            U(frsRequestData, 3);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.l = lastIds;
    }
}

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
import com.baidu.tieba.a9;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.b35;
import com.baidu.tieba.ed9;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.gi;
import com.baidu.tieba.gn;
import com.baidu.tieba.hi;
import com.baidu.tieba.ia7;
import com.baidu.tieba.ia9;
import com.baidu.tieba.j09;
import com.baidu.tieba.ky5;
import com.baidu.tieba.qa9;
import com.baidu.tieba.r87;
import com.baidu.tieba.sx5;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.k<FrsRequestData, qa9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public FrsViewData b;
    public FrsNetModel<FrsNewAreaFragment> c;
    public FrsRequestData d;
    public ia9 e;
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

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

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
                super((a9) newInitContext.callArgs[0]);
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void F(MvcHttpResponsedMessage<qa9> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, qa9> mvcHttpMessage, MvcNetMessage<FrsRequestData, qa9> mvcNetMessage) {
        boolean z;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) != null) || mvcHttpResponsedMessage == null) {
            return;
        }
        ia9 ia9Var = new ia9();
        if (mvcHttpResponsedMessage.getError() >= -13 && mvcHttpResponsedMessage.getError() <= -10) {
            z = false;
        } else {
            z = true;
        }
        ia9Var.a = z;
        ia9Var.b = !mvcHttpResponsedMessage.hasError();
        ia9Var.c = mvcHttpResponsedMessage.getError();
        ia9Var.d = mvcHttpResponsedMessage.getErrorString();
        ia9Var.e = mvcHttpResponsedMessage.getDownSize();
        this.e = ia9Var;
        qa9 data = mvcHttpResponsedMessage.getData();
        String str = null;
        if (mvcHttpMessage != null) {
            frsRequestData = mvcHttpMessage.getRequestData();
        } else {
            frsRequestData = null;
        }
        if (mvcNetMessage != null) {
            frsRequestData = mvcNetMessage.getRequestData();
        }
        f0(frsRequestData, data);
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
            str = frsRequestData.V();
        }
        objArr[1] = str;
        b35.a("frs", j2, cmd, "http_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void u(MvcSocketResponsedMessage<qa9, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, qa9> mvcSocketMessage, MvcNetMessage<FrsRequestData, qa9> mvcNetMessage) {
        boolean z;
        FrsRequestData frsRequestData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048599, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) != null) || mvcSocketResponsedMessage == null) {
            return;
        }
        ia9 ia9Var = new ia9();
        if (mvcSocketResponsedMessage.getError() >= -13 && mvcSocketResponsedMessage.getError() <= -10) {
            z = false;
        } else {
            z = true;
        }
        ia9Var.a = z;
        ia9Var.b = !mvcSocketResponsedMessage.hasError();
        ia9Var.c = mvcSocketResponsedMessage.getError();
        ia9Var.d = mvcSocketResponsedMessage.getErrorString();
        ia9Var.e = mvcSocketResponsedMessage.getDownSize();
        this.e = ia9Var;
        qa9 data = mvcSocketResponsedMessage.getData();
        String str = null;
        if (mvcSocketMessage != null) {
            frsRequestData = mvcSocketMessage.getRequestData();
        } else {
            frsRequestData = null;
        }
        if (mvcNetMessage != null) {
            frsRequestData = mvcNetMessage.getRequestData();
        }
        f0(frsRequestData, data);
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
            str = frsRequestData.V();
        }
        objArr[1] = str;
        objArr[2] = PushConstants.SEQ_ID;
        objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
        b35.a("frs", j2, cmd, "socket_resp", error, errorString, objArr);
    }

    public void R(ThreadData threadData) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && threadData != null && (frsViewData = this.b) != null && frsViewData.getThreadList() != null) {
            if (ListUtils.isEmpty(this.b.getThreadList())) {
                this.b.getThreadList().add(threadData);
            } else {
                this.b.getThreadList().add(0, threadData);
            }
            this.a.u2(this.b);
        }
    }

    public void c0(int i) {
        ArrayList<gn> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || this.c.l0()) {
            return;
        }
        FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
        frsRequestData.setPn(i);
        FrsRequestData frsRequestData2 = this.d;
        FrsViewData frsViewData = this.b;
        if (frsViewData == null) {
            threadList = null;
        } else {
            threadList = frsViewData.getThreadList();
        }
        frsRequestData2.Y(j09.e(threadList, false));
        S(frsRequestData, 4);
    }

    public final void S(FrsRequestData frsRequestData, int i) {
        FrsNewAreaFragment frsNewAreaFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, frsRequestData, i) == null) && (frsNewAreaFragment = this.a) != null && frsNewAreaFragment.isAdded() && this.a.getPageContext() != null) {
            this.a.B.a(i);
            this.c.y0(frsRequestData);
            this.g = i;
            frsRequestData.i0(this.f);
            int i2 = 1;
            frsRequestData.w0(1);
            frsRequestData.g0(0);
            frsRequestData.a0(0);
            r87.e(this.m, frsRequestData);
            if (UbsABTestHelper.isFrsNewAreaTabSortTestA()) {
                r87.e(FrsTabTestHelper.getFrsNewAreaTabSort(), frsRequestData);
                frsRequestData.d0(r87.d(FrsTabTestHelper.getFrsNewAreaTabSort()));
            }
            int l = hi.l(this.a.getPageContext().getPageActivity());
            int j = hi.j(this.a.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            }
            frsRequestData.v0(l);
            frsRequestData.u0(j);
            frsRequestData.t0(f);
            frsRequestData.y0(i2);
            frsRequestData.k0(this.l);
            String str = this.k;
            if (str != null) {
                frsRequestData.setStType(str);
            }
            if (FrsFragment.s2 != 0) {
                frsRequestData.b0((int) FrsFragment.s2);
            }
            if (FrsFragment.t2 != 0) {
                frsRequestData.c0((int) FrsFragment.t2);
            }
            if (FrsFragment.u2 != 0) {
                frsRequestData.n0(FrsFragment.u2);
            }
            frsRequestData.setUpdateType(this.g);
            frsRequestData.setNeedCache(false);
            i0();
        }
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public FrsViewData U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public long V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    public long W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n;
        }
        return invokeV.longValue;
    }

    public long X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.p;
        }
        return invokeV.longValue;
    }

    public long Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.o;
        }
        return invokeV.longValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c.l0();
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c.cancelLoadData();
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.n = System.currentTimeMillis();
            this.c.loadData();
            ia7.a();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            g0();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a0(Bundle bundle) {
        ArrayList<gn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
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
                h0(3);
            } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.k)) {
                h0(6);
            } else {
                h0(2);
            }
            this.b = new FrsViewData();
            this.d.R("forum_name", gi.getUrlEncode(this.f));
            this.d.R("client_type", "2");
            FrsRequestData frsRequestData = this.d;
            FrsViewData frsViewData = this.b;
            if (frsViewData == null) {
                threadList = null;
            } else {
                threadList = frsViewData.getThreadList();
            }
            frsRequestData.Y(j09.e(threadList, true));
            FrsNetModel<FrsNewAreaFragment> frsNetModel = new FrsNetModel<>(this.a.getPageContext(), this.d);
            this.c = frsNetModel;
            frsNetModel.t0(this);
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

    public void e0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            bundle.putString("name", this.f);
            bundle.putString("from", this.i);
            bundle.putInt("flag", this.j);
            bundle.putBoolean(FrsActivityConfig.GOOD, true);
        }
    }

    public void h0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.m = i;
            if (7 == i) {
                ed9.b();
            } else {
                ed9.a();
            }
        }
    }

    public final boolean f0(FrsRequestData frsRequestData, qa9 qa9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, frsRequestData, qa9Var)) == null) {
            if (sx5.k().l(AbsDataRecorder.Scene.FRS_NEW)) {
                sx5.k().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (ky5.i().o(AbsDataRecorder.Scene.FRS_NEW)) {
                ky5.i().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            this.b.receiveData(qa9Var);
            this.b.frsCurrentTabId = 503;
            if (frsRequestData != null) {
                this.d = frsRequestData;
                this.h = frsRequestData.getPn();
                String V = this.d.V();
                this.f = V;
                this.a.B2(V);
                this.a.setFrom(this.i);
                this.a.C2(this.h);
                this.a.A2(this.j);
            }
            this.a.B.d(this.g, false, this.e);
            this.k = null;
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        ArrayList<gn> threadList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            FrsRequestData frsRequestData = (FrsRequestData) OrmObject.objectWithJson(OrmObject.jsonWithObject(this.d), FrsRequestData.class);
            frsRequestData.setPn(1);
            FrsRequestData frsRequestData2 = this.d;
            FrsViewData frsViewData = this.b;
            if (frsViewData == null) {
                threadList = null;
            } else {
                threadList = frsViewData.getThreadList();
            }
            frsRequestData2.Y(j09.e(threadList, true));
            S(frsRequestData, 3);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void j0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (frsViewData = this.b) == null || frsViewData.getForum() == null || this.b.getForum().getBannerListData() == null) {
            return;
        }
        String lastIds = this.b.getForum().getBannerListData().getLastIds();
        if (TextUtils.isEmpty(lastIds)) {
            return;
        }
        this.l = lastIds;
    }
}

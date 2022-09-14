package com.baidu.tieba.gift.myGiftList;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.dm8;
import com.baidu.tieba.hv6;
import com.baidu.tieba.pb;
import com.baidu.tieba.r9;
import com.baidu.tieba.wr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public long f;
    public String g;
    public hv6 h;
    public b i;
    public pb j;
    public int mUserType;

    /* loaded from: classes4.dex */
    public class a extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyGiftListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MyGiftListModel myGiftListModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myGiftListModel;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetPersonalGiftListHttpResponseMessage;
            if (z || (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        this.a.I(((GetPersonalGiftListHttpResponseMessage) responsedMessage).getGiftListData());
                    } else if (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage) {
                        this.a.I(((GetPersonalGiftListSocketResponseMessage) responsedMessage).getGiftListData());
                    }
                }
                if (this.a.i != null) {
                    this.a.i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.e, this.a.h);
                }
                this.a.e = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, boolean z, hv6 hv6Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGiftListModel(r9<MyGiftListActivity> r9Var, String str) {
        super(r9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var, str};
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
        this.c = false;
        this.e = true;
        this.f = 0L;
        a aVar = new a(this, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
        this.j = aVar;
        this.d = true;
        this.g = str;
        aVar.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
        registerListener(this.j);
        dm8.h(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        dm8.c(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public final GetPersonalGiftListRequest E(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            GetPersonalGiftListRequest getPersonalGiftListRequest = new GetPersonalGiftListRequest();
            if (i < 1) {
                i = 1;
            }
            getPersonalGiftListRequest.setPageNumber(i);
            getPersonalGiftListRequest.setUserId(j);
            getPersonalGiftListRequest.setType(this.g);
            getPersonalGiftListRequest.userType = this.mUserType;
            this.b = i;
            return getPersonalGiftListRequest;
        }
        return (GetPersonalGiftListRequest) invokeCommon.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public final void G() {
        GetPersonalGiftListRequest E;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.c) {
                E = E(1, this.f);
            } else {
                E = E(this.b + 1, this.f);
            }
            sendMessage(E);
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public final void I(hv6 hv6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hv6Var) == null) || hv6Var == null) {
            return;
        }
        if (this.h == null) {
            this.h = new hv6();
        }
        if (this.h.c() == null) {
            this.h.i(new hv6.b());
        }
        if (this.h.d() == null) {
            this.h.j(new hv6.c());
        }
        if (this.h.a() == null) {
            this.h.g(new ArrayList<>());
        }
        this.h.h(hv6Var.b());
        this.h.k(hv6Var.e());
        this.h.i(hv6Var.c());
        this.h.j(hv6Var.d());
        hv6 hv6Var2 = this.h;
        hv6Var2.h = hv6Var.h;
        hv6Var2.f = hv6Var.f;
        if (hv6Var.g != null) {
            hv6Var2.g = new wr4();
            wr4 wr4Var = this.h.g;
            wr4 wr4Var2 = hv6Var.g;
            wr4Var.a = wr4Var2.a;
            wr4Var.b = wr4Var2.b;
        }
        if (this.h.c() != null) {
            this.b = this.h.c().a;
            this.a = this.h.c().b == 1;
        }
        if (hv6Var.a() == null || hv6Var.a().size() <= 0) {
            return;
        }
        if (this.c) {
            ArrayList<hv6.a> a2 = hv6Var.a();
            int size = this.h.a().size() + 1;
            for (int i = 0; i < a2.size(); i++) {
                hv6.a aVar = a2.get(i);
                if (aVar != null) {
                    aVar.h = size;
                    size++;
                }
            }
            this.h.a().addAll(a2);
            return;
        }
        this.h.a().clear();
        this.h.a().addAll(hv6Var.a());
    }

    public void J(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || str == null || str.length() <= 0 || str.equals("0") || str.startsWith("-")) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str)) {
            M(true);
        } else {
            M(false);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.d = z;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f : invokeV.longValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            G();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.f = j;
            K(String.valueOf(j));
        }
    }
}

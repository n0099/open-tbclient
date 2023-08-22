package com.baidu.tieba.gift.myGiftList;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hy7;
import com.baidu.tieba.ifa;
import com.baidu.tieba.k25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
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
    public hy7 h;
    public b i;
    public NetMessageListener j;
    public int mUserType;

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i, String str, boolean z, hy7 hy7Var);
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

    /* loaded from: classes6.dex */
    public class a extends NetMessageListener {
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetPersonalGiftListHttpResponseMessage;
            if (!z && !(responsedMessage instanceof GetPersonalGiftListSocketResponseMessage)) {
                return;
            }
            if (responsedMessage.getError() == 0) {
                if (z) {
                    this.a.W(((GetPersonalGiftListHttpResponseMessage) responsedMessage).getGiftListData());
                } else if (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage) {
                    this.a.W(((GetPersonalGiftListSocketResponseMessage) responsedMessage).getGiftListData());
                }
            }
            if (this.a.i != null) {
                this.a.i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.e, this.a.h);
            }
            this.a.e = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGiftListModel(BdPageContext<MyGiftListActivity> bdPageContext, String str) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
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
        ifa.h(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        ifa.c(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public void X(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.d = z;
        }
    }

    public void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.f = j;
            Y(String.valueOf(j));
        }
    }

    public final GetPersonalGiftListRequest S(int i, long j) {
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

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final void U() {
        GetPersonalGiftListRequest S;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.c) {
                S = S(1, this.f);
            } else {
                S = S(this.b + 1, this.f);
            }
            sendMessage(S);
        }
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            U();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W(hy7 hy7Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, hy7Var) != null) || hy7Var == null) {
            return;
        }
        if (this.h == null) {
            this.h = new hy7();
        }
        if (this.h.c() == null) {
            this.h.i(new hy7.b());
        }
        if (this.h.d() == null) {
            this.h.j(new hy7.c());
        }
        if (this.h.a() == null) {
            this.h.g(new ArrayList<>());
        }
        this.h.h(hy7Var.b());
        this.h.k(hy7Var.e());
        this.h.i(hy7Var.c());
        this.h.j(hy7Var.d());
        hy7 hy7Var2 = this.h;
        hy7Var2.h = hy7Var.h;
        hy7Var2.f = hy7Var.f;
        if (hy7Var.g != null) {
            hy7Var2.g = new k25();
            k25 k25Var = this.h.g;
            k25 k25Var2 = hy7Var.g;
            k25Var.a = k25Var2.a;
            k25Var.b = k25Var2.b;
        }
        if (this.h.c() != null) {
            this.b = this.h.c().a;
            if (this.h.c().b == 1) {
                z = true;
            } else {
                z = false;
            }
            this.a = z;
        }
        if (hy7Var.a() != null && hy7Var.a().size() > 0) {
            if (this.c) {
                ArrayList<hy7.a> a2 = hy7Var.a();
                int size = this.h.a().size() + 1;
                for (int i = 0; i < a2.size(); i++) {
                    hy7.a aVar = a2.get(i);
                    if (aVar != null) {
                        aVar.h = size;
                        size++;
                    }
                }
                this.h.a().addAll(a2);
                return;
            }
            this.h.a().clear();
            this.h.a().addAll(hy7Var.a());
        }
    }

    public final void Y(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && str != null && str.length() > 0 && !str.equals("0") && !str.startsWith("-")) {
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str)) {
                a0(true);
            } else {
                a0(false);
            }
        }
    }
}

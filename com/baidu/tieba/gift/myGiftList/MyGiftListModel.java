package com.baidu.tieba.gift.myGiftList;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.a9;
import com.baidu.tieba.al9;
import com.baidu.tieba.cl7;
import com.baidu.tieba.vx4;
import com.baidu.tieba.za;
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
    public cl7 h;
    public b i;
    public za j;
    public int mUserType;

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, boolean z, cl7 cl7Var);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends za {
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

        @Override // com.baidu.tieba.za
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
                    this.a.Z(((GetPersonalGiftListHttpResponseMessage) responsedMessage).getGiftListData());
                } else if (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage) {
                    this.a.Z(((GetPersonalGiftListSocketResponseMessage) responsedMessage).getGiftListData());
                }
            }
            if (this.a.i != null) {
                this.a.i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.e, this.a.h);
            }
            this.a.e = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGiftListModel(a9<MyGiftListActivity> a9Var, String str) {
        super(a9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var, str};
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
        al9.h(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        al9.c(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public void a0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.d = z;
        }
    }

    public void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.f = j;
            b0(String.valueOf(j));
        }
    }

    public final GetPersonalGiftListRequest V(int i, long j) {
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

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final void X() {
        GetPersonalGiftListRequest V;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.c) {
                V = V(1, this.f);
            } else {
                V = V(this.b + 1, this.f);
            }
            sendMessage(V);
        }
    }

    public boolean Y() {
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
            X();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Z(cl7 cl7Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, cl7Var) != null) || cl7Var == null) {
            return;
        }
        if (this.h == null) {
            this.h = new cl7();
        }
        if (this.h.c() == null) {
            this.h.i(new cl7.b());
        }
        if (this.h.d() == null) {
            this.h.j(new cl7.c());
        }
        if (this.h.a() == null) {
            this.h.g(new ArrayList<>());
        }
        this.h.h(cl7Var.b());
        this.h.k(cl7Var.e());
        this.h.i(cl7Var.c());
        this.h.j(cl7Var.d());
        cl7 cl7Var2 = this.h;
        cl7Var2.h = cl7Var.h;
        cl7Var2.f = cl7Var.f;
        if (cl7Var.g != null) {
            cl7Var2.g = new vx4();
            vx4 vx4Var = this.h.g;
            vx4 vx4Var2 = cl7Var.g;
            vx4Var.a = vx4Var2.a;
            vx4Var.b = vx4Var2.b;
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
        if (cl7Var.a() != null && cl7Var.a().size() > 0) {
            if (this.c) {
                ArrayList<cl7.a> a2 = cl7Var.a();
                int size = this.h.a().size() + 1;
                for (int i = 0; i < a2.size(); i++) {
                    cl7.a aVar = a2.get(i);
                    if (aVar != null) {
                        aVar.h = size;
                        size++;
                    }
                }
                this.h.a().addAll(a2);
                return;
            }
            this.h.a().clear();
            this.h.a().addAll(cl7Var.a());
        }
    }

    public final void b0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && str != null && str.length() > 0 && !str.equals("0") && !str.startsWith("-")) {
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str)) {
                d0(true);
            } else {
                d0(false);
            }
        }
    }
}

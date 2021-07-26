package com.baidu.tieba.gift.myGiftList;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.p0.s.q.k0;
import d.a.q0.y0.c.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16449e;

    /* renamed from: f  reason: collision with root package name */
    public int f16450f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16451g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16452h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16453i;
    public long j;
    public String k;
    public d.a.q0.y0.c.a l;
    public b m;
    public int mUserType;
    public d.a.d.c.g.a n;

    /* loaded from: classes4.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyGiftListModel f16454a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MyGiftListModel myGiftListModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGiftListModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16454a = myGiftListModel;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetPersonalGiftListHttpResponseMessage;
            if (z || (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        this.f16454a.F(((GetPersonalGiftListHttpResponseMessage) responsedMessage).getGiftListData());
                    } else if (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage) {
                        this.f16454a.F(((GetPersonalGiftListSocketResponseMessage) responsedMessage).getGiftListData());
                    }
                }
                if (this.f16454a.m != null) {
                    this.f16454a.m.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f16454a.f16453i, this.f16454a.l);
                }
                this.f16454a.f16453i = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, boolean z, d.a.q0.y0.c.a aVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGiftListModel(f<MyGiftListActivity> fVar, String str) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16451g = false;
        this.f16453i = true;
        this.j = 0L;
        a aVar = new a(this, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
        this.n = aVar;
        this.f16452h = true;
        this.k = str;
        aVar.getHttpMessageListener().setSelfListener(true);
        this.n.getSocketMessageListener().setSelfListener(true);
        registerListener(this.n);
        d.a.q0.h3.d0.a.h(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        d.a.q0.h3.d0.a.c(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public final GetPersonalGiftListRequest B(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            GetPersonalGiftListRequest getPersonalGiftListRequest = new GetPersonalGiftListRequest();
            if (i2 < 1) {
                i2 = 1;
            }
            getPersonalGiftListRequest.setPageNumber(i2);
            getPersonalGiftListRequest.setUserId(j);
            getPersonalGiftListRequest.setType(this.k);
            getPersonalGiftListRequest.userType = this.mUserType;
            this.f16450f = i2;
            return getPersonalGiftListRequest;
        }
        return (GetPersonalGiftListRequest) invokeCommon.objValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16452h : invokeV.booleanValue;
    }

    public final void D() {
        GetPersonalGiftListRequest B;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.f16451g) {
                B = B(1, this.j);
            } else {
                B = B(this.f16450f + 1, this.j);
            }
            sendMessage(B);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16449e : invokeV.booleanValue;
    }

    public final void F(d.a.q0.y0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.q0.y0.c.a();
        }
        if (this.l.c() == null) {
            this.l.i(new a.b());
        }
        if (this.l.d() == null) {
            this.l.j(new a.c());
        }
        if (this.l.a() == null) {
            this.l.g(new ArrayList<>());
        }
        this.l.h(aVar.b());
        this.l.k(aVar.e());
        this.l.i(aVar.c());
        this.l.j(aVar.d());
        d.a.q0.y0.c.a aVar2 = this.l;
        aVar2.f67027h = aVar.f67027h;
        aVar2.f67025f = aVar.f67025f;
        if (aVar.f67026g != null) {
            aVar2.f67026g = new k0();
            k0 k0Var = this.l.f67026g;
            k0 k0Var2 = aVar.f67026g;
            k0Var.f53374a = k0Var2.f53374a;
            k0Var.f53375b = k0Var2.f53375b;
        }
        if (this.l.c() != null) {
            this.f16450f = this.l.c().f67037a;
            this.f16449e = this.l.c().f67038b == 1;
        }
        if (aVar.a() == null || aVar.a().size() <= 0) {
            return;
        }
        if (this.f16451g) {
            ArrayList<a.C1856a> a2 = aVar.a();
            int size = this.l.a().size() + 1;
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a.C1856a c1856a = a2.get(i2);
                if (c1856a != null) {
                    c1856a.j = size;
                    size++;
                }
            }
            this.l.a().addAll(a2);
            return;
        }
        this.l.a().clear();
        this.l.a().addAll(aVar.a());
    }

    public void G(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public final void H(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || str == null || str.length() <= 0 || str.equals("0") || str.startsWith("-")) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str)) {
            J(true);
        } else {
            J(false);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f16451g = z;
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f16452h = z;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            D();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : invokeV.longValue;
    }

    public void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.j = j;
            H(String.valueOf(j));
        }
    }
}

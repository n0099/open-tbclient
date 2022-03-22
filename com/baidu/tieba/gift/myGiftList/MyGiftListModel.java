package com.baidu.tieba.gift.myGiftList;

import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.o0.r.r.k0;
import c.a.p0.j1.c.a;
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
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f33128b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33129c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33130d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33131e;

    /* renamed from: f  reason: collision with root package name */
    public long f33132f;

    /* renamed from: g  reason: collision with root package name */
    public String f33133g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.j1.c.a f33134h;
    public b i;
    public c.a.d.c.g.a j;
    public int mUserType;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
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

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetPersonalGiftListHttpResponseMessage;
            if (z || (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        this.a.H(((GetPersonalGiftListHttpResponseMessage) responsedMessage).getGiftListData());
                    } else if (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage) {
                        this.a.H(((GetPersonalGiftListSocketResponseMessage) responsedMessage).getGiftListData());
                    }
                }
                if (this.a.i != null) {
                    this.a.i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.f33131e, this.a.f33134h);
                }
                this.a.f33131e = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, boolean z, c.a.p0.j1.c.a aVar);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33129c = false;
        this.f33131e = true;
        this.f33132f = 0L;
        a aVar = new a(this, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
        this.j = aVar;
        this.f33130d = true;
        this.f33133g = str;
        aVar.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
        registerListener(this.j);
        c.a.p0.a4.g0.a.h(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        c.a.p0.a4.g0.a.c(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    public final GetPersonalGiftListRequest D(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            GetPersonalGiftListRequest getPersonalGiftListRequest = new GetPersonalGiftListRequest();
            if (i < 1) {
                i = 1;
            }
            getPersonalGiftListRequest.setPageNumber(i);
            getPersonalGiftListRequest.setUserId(j);
            getPersonalGiftListRequest.setType(this.f33133g);
            getPersonalGiftListRequest.userType = this.mUserType;
            this.f33128b = i;
            return getPersonalGiftListRequest;
        }
        return (GetPersonalGiftListRequest) invokeCommon.objValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33130d : invokeV.booleanValue;
    }

    public final void F() {
        GetPersonalGiftListRequest D;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.f33129c) {
                D = D(1, this.f33132f);
            } else {
                D = D(this.f33128b + 1, this.f33132f);
            }
            sendMessage(D);
        }
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public final void H(c.a.p0.j1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f33134h == null) {
            this.f33134h = new c.a.p0.j1.c.a();
        }
        if (this.f33134h.c() == null) {
            this.f33134h.i(new a.b());
        }
        if (this.f33134h.d() == null) {
            this.f33134h.j(new a.c());
        }
        if (this.f33134h.a() == null) {
            this.f33134h.g(new ArrayList<>());
        }
        this.f33134h.h(aVar.b());
        this.f33134h.k(aVar.e());
        this.f33134h.i(aVar.c());
        this.f33134h.j(aVar.d());
        c.a.p0.j1.c.a aVar2 = this.f33134h;
        aVar2.f15599h = aVar.f15599h;
        aVar2.f15597f = aVar.f15597f;
        if (aVar.f15598g != null) {
            aVar2.f15598g = new k0();
            k0 k0Var = this.f33134h.f15598g;
            k0 k0Var2 = aVar.f15598g;
            k0Var.a = k0Var2.a;
            k0Var.f10900b = k0Var2.f10900b;
        }
        if (this.f33134h.c() != null) {
            this.f33128b = this.f33134h.c().a;
            this.a = this.f33134h.c().f15607b == 1;
        }
        if (aVar.a() == null || aVar.a().size() <= 0) {
            return;
        }
        if (this.f33129c) {
            ArrayList<a.C1174a> a2 = aVar.a();
            int size = this.f33134h.a().size() + 1;
            for (int i = 0; i < a2.size(); i++) {
                a.C1174a c1174a = a2.get(i);
                if (c1174a != null) {
                    c1174a.f15606h = size;
                    size++;
                }
            }
            this.f33134h.a().addAll(a2);
            return;
        }
        this.f33134h.a().clear();
        this.f33134h.a().addAll(aVar.a());
    }

    public void I(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || str == null || str.length() <= 0 || str.equals("0") || str.startsWith("-")) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str)) {
            L(true);
        } else {
            L(false);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f33129c = z;
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f33130d = z;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f33132f : invokeV.longValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            F();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.f33132f = j;
            J(String.valueOf(j));
        }
    }
}

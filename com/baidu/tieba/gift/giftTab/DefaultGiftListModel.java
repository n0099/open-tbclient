package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.r0.r.q.j0;
import d.a.r0.r.q.k0;
import d.a.s0.y0.b.e;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class DefaultGiftListModel extends BdBaseModel<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.s0.y0.b.a> f16296e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<j0> f16297f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<e> f16298g;

    /* renamed from: h  reason: collision with root package name */
    public String f16299h;

    /* renamed from: i  reason: collision with root package name */
    public int f16300i;
    public b j;
    public d.a.c.c.g.a k;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DefaultGiftListModel f16301a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DefaultGiftListModel defaultGiftListModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultGiftListModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f16301a = defaultGiftListModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            k0 k0Var;
            int i2;
            int i3;
            k0 k0Var2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof DefaultGiftListHttpResponseMessage;
            if (!z && !(responsedMessage instanceof DefaultGiftListSocketResponseMessage)) {
                return;
            }
            if (z) {
                DefaultGiftListHttpResponseMessage defaultGiftListHttpResponseMessage = (DefaultGiftListHttpResponseMessage) responsedMessage;
                this.f16301a.f16296e = defaultGiftListHttpResponseMessage.getCategoryList();
                this.f16301a.f16297f = defaultGiftListHttpResponseMessage.getGiftList();
                this.f16301a.f16298g = defaultGiftListHttpResponseMessage.getGiftNumberList();
                this.f16301a.f16299h = defaultGiftListHttpResponseMessage.getAddFreeUrl();
                this.f16301a.f16300i = defaultGiftListHttpResponseMessage.getFreeChance();
                i3 = defaultGiftListHttpResponseMessage.currencyType;
                k0Var2 = defaultGiftListHttpResponseMessage.urlTitleData;
            } else if (!(responsedMessage instanceof DefaultGiftListSocketResponseMessage)) {
                k0Var = null;
                i2 = 0;
                if (this.f16301a.j == null) {
                    this.f16301a.j.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f16301a.f16300i, this.f16301a.f16299h, i2, k0Var, this.f16301a.f16296e, this.f16301a.f16297f, this.f16301a.f16298g);
                    return;
                }
                return;
            } else {
                DefaultGiftListSocketResponseMessage defaultGiftListSocketResponseMessage = (DefaultGiftListSocketResponseMessage) responsedMessage;
                this.f16301a.f16296e = defaultGiftListSocketResponseMessage.getCategoryList();
                this.f16301a.f16297f = defaultGiftListSocketResponseMessage.getGiftList();
                this.f16301a.f16298g = defaultGiftListSocketResponseMessage.getGiftNumberList();
                this.f16301a.f16299h = defaultGiftListSocketResponseMessage.getAddFreeUrl();
                this.f16301a.f16300i = defaultGiftListSocketResponseMessage.getFreeChance();
                i3 = defaultGiftListSocketResponseMessage.currencyType;
                k0Var2 = defaultGiftListSocketResponseMessage.urlTitleData;
            }
            i2 = i3;
            k0Var = k0Var2;
            if (this.f16301a.j == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, int i3, String str2, int i4, k0 k0Var, ArrayList<d.a.s0.y0.b.a> arrayList, ArrayList<j0> arrayList2, ArrayList<e> arrayList3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultGiftListModel(f<GiftTabActivity> fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
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
        this.k = new a(this, CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, 309054);
        registerTask();
        registerListener();
    }

    public void H(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            DefaultGiftListRequest defaultGiftListRequest = new DefaultGiftListRequest();
            defaultGiftListRequest.setFrom(str);
            defaultGiftListRequest.setToUserId(j);
            sendMessage(defaultGiftListRequest);
        }
    }

    public void I(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.j = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(this.k);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.s0.h3.d0.a.h(309054, DefaultGiftListSocketResponseMessage.class, false, false);
            d.a.s0.h3.d0.a.c(309054, CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, TbConfig.GET_DEFAULT_GIFT_LIST, DefaultGiftListHttpResponseMessage.class, false, false, false, false);
        }
    }
}

package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.jb;
import com.baidu.tieba.k9;
import com.baidu.tieba.rx9;
import com.baidu.tieba.t25;
import com.baidu.tieba.tt7;
import com.baidu.tieba.u25;
import com.baidu.tieba.xt7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class DefaultGiftListModel extends BdBaseModel<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<tt7> a;
    public ArrayList<t25> b;
    public ArrayList<xt7> c;
    public String d;
    public int e;
    public b f;
    public jb g;

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, int i2, String str2, int i3, u25 u25Var, ArrayList<tt7> arrayList, ArrayList<t25> arrayList2, ArrayList<xt7> arrayList3);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultGiftListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DefaultGiftListModel defaultGiftListModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultGiftListModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = defaultGiftListModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.jb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            u25 u25Var;
            int i;
            int i2;
            u25 u25Var2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof DefaultGiftListHttpResponseMessage;
            if (!z && !(responsedMessage instanceof DefaultGiftListSocketResponseMessage)) {
                return;
            }
            if (z) {
                DefaultGiftListHttpResponseMessage defaultGiftListHttpResponseMessage = (DefaultGiftListHttpResponseMessage) responsedMessage;
                this.a.a = defaultGiftListHttpResponseMessage.getCategoryList();
                this.a.b = defaultGiftListHttpResponseMessage.getGiftList();
                this.a.c = defaultGiftListHttpResponseMessage.getGiftNumberList();
                this.a.d = defaultGiftListHttpResponseMessage.getAddFreeUrl();
                this.a.e = defaultGiftListHttpResponseMessage.getFreeChance();
                i2 = defaultGiftListHttpResponseMessage.currencyType;
                u25Var2 = defaultGiftListHttpResponseMessage.urlTitleData;
            } else if (responsedMessage instanceof DefaultGiftListSocketResponseMessage) {
                DefaultGiftListSocketResponseMessage defaultGiftListSocketResponseMessage = (DefaultGiftListSocketResponseMessage) responsedMessage;
                this.a.a = defaultGiftListSocketResponseMessage.getCategoryList();
                this.a.b = defaultGiftListSocketResponseMessage.getGiftList();
                this.a.c = defaultGiftListSocketResponseMessage.getGiftNumberList();
                this.a.d = defaultGiftListSocketResponseMessage.getAddFreeUrl();
                this.a.e = defaultGiftListSocketResponseMessage.getFreeChance();
                i2 = defaultGiftListSocketResponseMessage.currencyType;
                u25Var2 = defaultGiftListSocketResponseMessage.urlTitleData;
            } else {
                u25Var = null;
                i = 0;
                if (this.a.f == null) {
                    this.a.f.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.e, this.a.d, i, u25Var, this.a.a, this.a.b, this.a.c);
                    return;
                }
                return;
            }
            i = i2;
            u25Var = u25Var2;
            if (this.a.f == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultGiftListModel(k9<GiftTabActivity> k9Var) {
        super(k9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k9Var};
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
        this.g = new a(this, CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, 309054);
        registerTask();
        registerListener();
    }

    public void g0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void f0(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            DefaultGiftListRequest defaultGiftListRequest = new DefaultGiftListRequest();
            defaultGiftListRequest.setFrom(str);
            defaultGiftListRequest.setToUserId(j);
            sendMessage(defaultGiftListRequest);
        }
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(this.g);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            rx9.h(309054, DefaultGiftListSocketResponseMessage.class, false, false);
            rx9.c(309054, CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, TbConfig.GET_DEFAULT_GIFT_LIST, DefaultGiftListHttpResponseMessage.class, false, false, false, false);
        }
    }
}

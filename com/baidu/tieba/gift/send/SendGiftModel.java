package com.baidu.tieba.gift.send;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.a9;
import com.baidu.tieba.al9;
import com.baidu.tieba.fl7;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
import com.baidu.tieba.ux4;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SendGiftModel extends BdBaseModel<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public za b;
    public za c;

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i, String str, fl7 fl7Var);

        void b();

        void c(int i, String str, int i2);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    /* loaded from: classes4.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendGiftModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SendGiftModel sendGiftModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendGiftModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = sendGiftModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof SendFreeGiftHttpResponse;
            if (!z && !(responsedMessage instanceof SendFreeGiftSocketResponse)) {
                return;
            }
            int i = 0;
            if (z) {
                i = ((SendFreeGiftHttpResponse) responsedMessage).getFreeChance();
            } else if (responsedMessage instanceof SendFreeGiftSocketResponse) {
                i = ((SendFreeGiftSocketResponse) responsedMessage).getFreeChance();
            }
            if (this.a.a != null) {
                this.a.a.c(responsedMessage.getError(), responsedMessage.getErrorString(), i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendGiftModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SendGiftModel sendGiftModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendGiftModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = sendGiftModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PlaceOrderHttpResponse;
            if (!z && !(responsedMessage instanceof PlaceOrderSocketResponse)) {
                return;
            }
            fl7 fl7Var = null;
            if (z) {
                fl7Var = ((PlaceOrderHttpResponse) responsedMessage).getOrderInfo();
            } else if (responsedMessage instanceof PlaceOrderSocketResponse) {
                fl7Var = ((PlaceOrderSocketResponse) responsedMessage).getOrderInfo();
            }
            if (this.a.a != null) {
                this.a.a.a(responsedMessage.getError(), responsedMessage.getErrorString(), fl7Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftModel(a9<GiftTabActivity> a9Var) {
        super(a9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var};
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
        this.b = new a(this, CmdConfigHttp.CMD_SEND_FREE_GIFT, 309050);
        this.c = new b(this, CmdConfigHttp.CMD_GIFT_PALCE_ORDER, 309051);
        al9.h(309050, SendFreeGiftSocketResponse.class, false, false);
        al9.c(309050, CmdConfigHttp.CMD_SEND_FREE_GIFT, TbConfig.SEND_FREE_GIFT, SendFreeGiftHttpResponse.class, false, false, false, false);
        al9.h(309051, PlaceOrderSocketResponse.class, false, false);
        al9.c(309051, CmdConfigHttp.CMD_GIFT_PALCE_ORDER, TbConfig.GIFT_PLACE_ORDER, PlaceOrderHttpResponse.class, false, false, false, false);
        registerListener(this.b);
        registerListener(this.c);
    }

    public void S(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.a = cVar;
        }
    }

    public void R(ux4 ux4Var, int i, String str, long j, String str2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{ux4Var, Integer.valueOf(i), str, Long.valueOf(j), str2, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (i > 0 && ux4Var != null && j > 0) {
                if (ux4Var.f == 5) {
                    SendFreeGiftRequest sendFreeGiftRequest = new SendFreeGiftRequest();
                    sendFreeGiftRequest.setGiftId(ux4Var.a);
                    sendFreeGiftRequest.setToUserId(j);
                    sendFreeGiftRequest.setToUserName(str2);
                    sendFreeGiftRequest.setSceneFrom(str);
                    sendFreeGiftRequest.setSendCount(i);
                    sendFreeGiftRequest.setThreadId(j2);
                    sendFreeGiftRequest.setPostId(j3);
                    sendMessage(sendFreeGiftRequest);
                    return;
                }
                PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
                placeOrderRequest.setGiftId(ux4Var.a);
                placeOrderRequest.setToUserId(j);
                placeOrderRequest.setToUserName(str2);
                placeOrderRequest.setSceneFrom(str);
                placeOrderRequest.setSendCount(i);
                placeOrderRequest.setThreadId(j2);
                placeOrderRequest.setPostId(j3);
                placeOrderRequest.accountId = j;
                placeOrderRequest.accountType = ux4Var.r;
                placeOrderRequest.currency = ux4Var.s;
                sendMessage(placeOrderRequest);
                return;
            }
            c cVar = this.a;
            if (cVar != null) {
                cVar.b();
            }
        }
    }
}

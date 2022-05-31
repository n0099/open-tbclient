package com.baidu.tieba.gift.send;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.ig8;
import com.repackage.kq6;
import com.repackage.wa;
import com.repackage.yn4;
/* loaded from: classes3.dex */
public class SendGiftModel extends BdBaseModel<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public wa b;
    public wa c;

    /* loaded from: classes3.dex */
    public class a extends wa {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof SendFreeGiftHttpResponse;
            if (z || (responsedMessage instanceof SendFreeGiftSocketResponse)) {
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
    }

    /* loaded from: classes3.dex */
    public class b extends wa {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PlaceOrderHttpResponse;
            if (z || (responsedMessage instanceof PlaceOrderSocketResponse)) {
                kq6 kq6Var = null;
                if (z) {
                    kq6Var = ((PlaceOrderHttpResponse) responsedMessage).getOrderInfo();
                } else if (responsedMessage instanceof PlaceOrderSocketResponse) {
                    kq6Var = ((PlaceOrderSocketResponse) responsedMessage).getOrderInfo();
                }
                if (this.a.a != null) {
                    this.a.a.a(responsedMessage.getError(), responsedMessage.getErrorString(), kq6Var);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i, String str, kq6 kq6Var);

        void b();

        void c(int i, String str, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftModel(b9<GiftTabActivity> b9Var) {
        super(b9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this, CmdConfigHttp.CMD_SEND_FREE_GIFT, 309050);
        this.c = new b(this, CmdConfigHttp.CMD_GIFT_PALCE_ORDER, 309051);
        ig8.h(309050, SendFreeGiftSocketResponse.class, false, false);
        ig8.c(309050, CmdConfigHttp.CMD_SEND_FREE_GIFT, TbConfig.SEND_FREE_GIFT, SendFreeGiftHttpResponse.class, false, false, false, false);
        ig8.h(309051, PlaceOrderSocketResponse.class, false, false);
        ig8.c(309051, CmdConfigHttp.CMD_GIFT_PALCE_ORDER, TbConfig.GIFT_PLACE_ORDER, PlaceOrderHttpResponse.class, false, false, false, false);
        registerListener(this.b);
        registerListener(this.c);
    }

    public void A(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.a = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z(yn4 yn4Var, int i, String str, long j, String str2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{yn4Var, Integer.valueOf(i), str, Long.valueOf(j), str2, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (i > 0 && yn4Var != null && j > 0) {
                if (yn4Var.f == 5) {
                    SendFreeGiftRequest sendFreeGiftRequest = new SendFreeGiftRequest();
                    sendFreeGiftRequest.setGiftId(yn4Var.a);
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
                placeOrderRequest.setGiftId(yn4Var.a);
                placeOrderRequest.setToUserId(j);
                placeOrderRequest.setToUserName(str2);
                placeOrderRequest.setSceneFrom(str);
                placeOrderRequest.setSendCount(i);
                placeOrderRequest.setThreadId(j2);
                placeOrderRequest.setPostId(j3);
                placeOrderRequest.accountId = j;
                placeOrderRequest.accountType = yn4Var.r;
                placeOrderRequest.currency = yn4Var.s;
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

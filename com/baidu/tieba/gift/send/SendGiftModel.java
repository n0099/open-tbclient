package com.baidu.tieba.gift.send;

import c.a.e.a.f;
import c.a.p0.s.q.j0;
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
/* loaded from: classes7.dex */
public class SendGiftModel extends BdBaseModel<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f51825e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.c.g.a f51826f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.c.g.a f51827g;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SendGiftModel f51828a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SendGiftModel sendGiftModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendGiftModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f51828a = sendGiftModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof SendFreeGiftHttpResponse;
            if (z || (responsedMessage instanceof SendFreeGiftSocketResponse)) {
                int i2 = 0;
                if (z) {
                    i2 = ((SendFreeGiftHttpResponse) responsedMessage).getFreeChance();
                } else if (responsedMessage instanceof SendFreeGiftSocketResponse) {
                    i2 = ((SendFreeGiftSocketResponse) responsedMessage).getFreeChance();
                }
                if (this.f51828a.f51825e != null) {
                    this.f51828a.f51825e.c(responsedMessage.getError(), responsedMessage.getErrorString(), i2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SendGiftModel f51829a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SendGiftModel sendGiftModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendGiftModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f51829a = sendGiftModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PlaceOrderHttpResponse;
            if (z || (responsedMessage instanceof PlaceOrderSocketResponse)) {
                c.a.q0.z0.d.a aVar = null;
                if (z) {
                    aVar = ((PlaceOrderHttpResponse) responsedMessage).getOrderInfo();
                } else if (responsedMessage instanceof PlaceOrderSocketResponse) {
                    aVar = ((PlaceOrderSocketResponse) responsedMessage).getOrderInfo();
                }
                if (this.f51829a.f51825e != null) {
                    this.f51829a.f51825e.a(responsedMessage.getError(), responsedMessage.getErrorString(), aVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(int i2, String str, c.a.q0.z0.d.a aVar);

        void b();

        void c(int i2, String str, int i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftModel(f<GiftTabActivity> fVar) {
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
        this.f51826f = new a(this, CmdConfigHttp.CMD_SEND_FREE_GIFT, 309050);
        this.f51827g = new b(this, CmdConfigHttp.CMD_GIFT_PALCE_ORDER, 309051);
        c.a.q0.i3.d0.a.h(309050, SendFreeGiftSocketResponse.class, false, false);
        c.a.q0.i3.d0.a.c(309050, CmdConfigHttp.CMD_SEND_FREE_GIFT, TbConfig.SEND_FREE_GIFT, SendFreeGiftHttpResponse.class, false, false, false, false);
        c.a.q0.i3.d0.a.h(309051, PlaceOrderSocketResponse.class, false, false);
        c.a.q0.i3.d0.a.c(309051, CmdConfigHttp.CMD_GIFT_PALCE_ORDER, TbConfig.GIFT_PLACE_ORDER, PlaceOrderHttpResponse.class, false, false, false, false);
        registerListener(this.f51826f);
        registerListener(this.f51827g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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

    public void x(j0 j0Var, int i2, String str, long j2, String str2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{j0Var, Integer.valueOf(i2), str, Long.valueOf(j2), str2, Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if (i2 > 0 && j0Var != null && j2 > 0) {
                if (j0Var.f14273f == 5) {
                    SendFreeGiftRequest sendFreeGiftRequest = new SendFreeGiftRequest();
                    sendFreeGiftRequest.setGiftId(j0Var.f14268a);
                    sendFreeGiftRequest.setToUserId(j2);
                    sendFreeGiftRequest.setToUserName(str2);
                    sendFreeGiftRequest.setSceneFrom(str);
                    sendFreeGiftRequest.setSendCount(i2);
                    sendFreeGiftRequest.setThreadId(j3);
                    sendFreeGiftRequest.setPostId(j4);
                    sendMessage(sendFreeGiftRequest);
                    return;
                }
                PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
                placeOrderRequest.setGiftId(j0Var.f14268a);
                placeOrderRequest.setToUserId(j2);
                placeOrderRequest.setToUserName(str2);
                placeOrderRequest.setSceneFrom(str);
                placeOrderRequest.setSendCount(i2);
                placeOrderRequest.setThreadId(j3);
                placeOrderRequest.setPostId(j4);
                placeOrderRequest.accountId = j2;
                placeOrderRequest.accountType = j0Var.r;
                placeOrderRequest.currency = j0Var.s;
                sendMessage(placeOrderRequest);
                return;
            }
            c cVar = this.f51825e;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public void y(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f51825e = cVar;
        }
    }
}

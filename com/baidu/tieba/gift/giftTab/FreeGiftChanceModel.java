package com.baidu.tieba.gift.giftTab;

import c.a.d.a.f;
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
/* loaded from: classes5.dex */
public class FreeGiftChanceModel extends BdBaseModel<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public b f33111b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.c.g.a f33112c;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FreeGiftChanceModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FreeGiftChanceModel freeGiftChanceModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {freeGiftChanceModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = freeGiftChanceModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof FreeGiftChanceHttpResponseMessage;
            if (z || (responsedMessage instanceof FreeGiftChanceSocketResponseMessage)) {
                if (z) {
                    this.a.a = ((FreeGiftChanceHttpResponseMessage) responsedMessage).getFreeChance();
                } else if (responsedMessage instanceof FreeGiftChanceSocketResponseMessage) {
                    this.a.a = ((FreeGiftChanceSocketResponseMessage) responsedMessage).getFreeChance();
                }
                if (this.a.f33111b != null) {
                    this.a.f33111b.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FreeGiftChanceModel(f<GiftTabActivity> fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
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
        this.f33112c = new a(this, CmdConfigHttp.CMD_USER_FREE_CHANCE, 309060);
        registerListener();
        registerTask();
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            FreeGiftChanceRequest freeGiftChanceRequest = new FreeGiftChanceRequest();
            freeGiftChanceRequest.setFrom(str);
            sendMessage(freeGiftChanceRequest);
        }
    }

    public void C(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f33111b = bVar;
        }
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

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(this.f33112c);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.a4.g0.a.h(309060, FreeGiftChanceSocketResponseMessage.class, false, false);
            c.a.p0.a4.g0.a.c(309060, CmdConfigHttp.CMD_USER_FREE_CHANCE, TbConfig.GET_USER_FREE_CHANCE, FreeGiftChanceHttpResponseMessage.class, false, false, false, false);
        }
    }
}

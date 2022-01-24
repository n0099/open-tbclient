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
/* loaded from: classes12.dex */
public class FreeGiftChanceModel extends BdBaseModel<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f44027e;

    /* renamed from: f  reason: collision with root package name */
    public b f44028f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.c.g.a f44029g;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FreeGiftChanceModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FreeGiftChanceModel freeGiftChanceModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {freeGiftChanceModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
                    this.a.f44027e = ((FreeGiftChanceHttpResponseMessage) responsedMessage).getFreeChance();
                } else if (responsedMessage instanceof FreeGiftChanceSocketResponseMessage) {
                    this.a.f44027e = ((FreeGiftChanceSocketResponseMessage) responsedMessage).getFreeChance();
                }
                if (this.a.f44028f != null) {
                    this.a.f44028f.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.f44027e);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(int i2, String str, int i3);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44029g = new a(this, CmdConfigHttp.CMD_USER_FREE_CHANCE, 309060);
        registerListener();
        registerTask();
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f44028f = bVar;
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

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            registerListener(this.f44029g);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.t0.x3.f0.a.h(309060, FreeGiftChanceSocketResponseMessage.class, false, false);
            c.a.t0.x3.f0.a.c(309060, CmdConfigHttp.CMD_USER_FREE_CHANCE, TbConfig.GET_USER_FREE_CHANCE, FreeGiftChanceHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            FreeGiftChanceRequest freeGiftChanceRequest = new FreeGiftChanceRequest();
            freeGiftChanceRequest.setFrom(str);
            sendMessage(freeGiftChanceRequest);
        }
    }
}

package com.baidu.tbadk.pay;

import c.a.d.a.f;
import c.a.q0.q0.d;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigNetMessage;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetClientConfig.CPayType;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes9.dex */
public class PayConfigModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.q0.a f41897e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.d.c.g.a f41898f;

    /* loaded from: classes9.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayConfigModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PayConfigModel payConfigModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payConfigModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = payConfigModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && this.a.z(responsedMessage)) {
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                        this.a.A(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                        return;
                    } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                        this.a.A(((ClientConfigSocketResponse) responsedMessage).getData());
                        return;
                    } else {
                        return;
                    }
                }
                String errorString = responsedMessage.getErrorString();
                String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
                if (StringUtils.isNull(errorString)) {
                    errorString = string;
                }
                if (this.a.f41897e != null) {
                    this.a.f41897e.onError(errorString);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayConfigModel(BaseActivity<?> baseActivity, c.a.q0.q0.a aVar) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, aVar};
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
        a aVar2 = new a(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.f41898f = aVar2;
        this.f41897e = aVar;
        registerListener(aVar2);
    }

    public final void A(DataRes dataRes) {
        CPayType cPayType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
            if (dataRes != null && (cPayType = dataRes.payType) != null) {
                if (cPayType.pay_type.intValue() == 1) {
                    c.a.q0.q0.a aVar = this.f41897e;
                    if (aVar != null) {
                        aVar.b();
                    }
                } else if (dataRes.payType.pay_type.intValue() == 2) {
                    c.a.q0.q0.a aVar2 = this.f41897e;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                } else {
                    c.a.q0.q0.a aVar3 = this.f41897e;
                    if (aVar3 != null) {
                        aVar3.onError("");
                    }
                }
            } else if (this.f41897e != null) {
                this.f41897e.onError(TbadkCoreApplication.getInst().getString(R.string.data_load_error));
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!d.c().g()) {
                c.a.q0.q0.a aVar = this.f41897e;
                if (aVar != null) {
                    aVar.a();
                }
            } else if (TbadkCoreApplication.getInst().checkInterrupt()) {
                c.a.q0.q0.a aVar2 = this.f41897e;
                if (aVar2 != null) {
                    aVar2.b();
                }
            } else {
                ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
                clientConfigNetMessage.setType("payType");
                sendMessage(clientConfigNetMessage);
            }
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

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f41898f);
        }
    }

    public final boolean z(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, responsedMessage)) == null) ? (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true : invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayConfigModel(TbPageContext tbPageContext, c.a.q0.q0.a aVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar2 = new a(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.f41898f = aVar2;
        this.f41897e = aVar;
        registerListener(aVar2);
    }
}

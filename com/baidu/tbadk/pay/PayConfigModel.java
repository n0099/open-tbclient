package com.baidu.tbadk.pay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigNetMessage;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.nk5;
import com.baidu.tieba.qk5;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetClientConfig.CPayType;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes3.dex */
public class PayConfigModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nk5 a;
    public final za b;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayConfigModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PayConfigModel payConfigModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payConfigModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = payConfigModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || !this.a.U(responsedMessage)) {
                return;
            }
            if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                    this.a.V(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                    return;
                } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                    this.a.V(((ClientConfigSocketResponse) responsedMessage).getData());
                    return;
                } else {
                    return;
                }
            }
            String errorString = responsedMessage.getErrorString();
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d1f);
            if (StringUtils.isNull(errorString)) {
                errorString = string;
            }
            if (this.a.a != null) {
                this.a.a.onError(errorString);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayConfigModel(TbPageContext tbPageContext, nk5 nk5Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, nk5Var};
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
        a aVar = new a(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.b = aVar;
        this.a = nk5Var;
        registerListener(aVar);
    }

    public final boolean U(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, responsedMessage)) == null) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void V(DataRes dataRes) {
        CPayType cPayType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            if (dataRes != null && (cPayType = dataRes.payType) != null) {
                if (cPayType.pay_type.intValue() == 1) {
                    nk5 nk5Var = this.a;
                    if (nk5Var != null) {
                        nk5Var.b();
                    }
                } else if (dataRes.payType.pay_type.intValue() == 2) {
                    nk5 nk5Var2 = this.a;
                    if (nk5Var2 != null) {
                        nk5Var2.a();
                    }
                } else {
                    nk5 nk5Var3 = this.a;
                    if (nk5Var3 != null) {
                        nk5Var3.onError("");
                    }
                }
            } else if (this.a != null) {
                this.a.onError(TbadkCoreApplication.getInst().getString(R.string.data_load_error));
            }
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!qk5.c().d()) {
                nk5 nk5Var = this.a;
                if (nk5Var != null) {
                    nk5Var.a();
                }
            } else if (TbadkCoreApplication.getInst().checkInterrupt()) {
                nk5 nk5Var2 = this.a;
                if (nk5Var2 != null) {
                    nk5Var2.b();
                }
            } else {
                ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
                clientConfigNetMessage.setType("payType");
                sendMessage(clientConfigNetMessage);
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }
}

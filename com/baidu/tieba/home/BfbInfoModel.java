package com.baidu.tieba.home;

import c.a.e.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UserBfbInfo;
/* loaded from: classes7.dex */
public class BfbInfoModel extends BdBaseModel<CreateBarGuideActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f52022e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.c.g.a f52023f;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BfbInfoModel f52024a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BfbInfoModel bfbInfoModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bfbInfoModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f52024a = bfbInfoModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BfbInfoHttpResponseMessage;
            if (z || (responsedMessage instanceof BfbInfoSocketResponseMessage)) {
                UserBfbInfo userBfbInfo = null;
                if (responsedMessage.getError() != 0) {
                    if (this.f52024a.f52022e != null) {
                        this.f52024a.f52022e.a(responsedMessage.getError(), responsedMessage.getErrorString(), null);
                        return;
                    }
                    return;
                }
                if (z) {
                    userBfbInfo = ((BfbInfoHttpResponseMessage) responsedMessage).getBfbInfo();
                } else if (responsedMessage instanceof BfbInfoSocketResponseMessage) {
                    userBfbInfo = ((BfbInfoSocketResponseMessage) responsedMessage).getBfbInfo();
                }
                if (this.f52024a.f52022e != null) {
                    this.f52024a.f52022e.a(responsedMessage.getError(), responsedMessage.getErrorString(), userBfbInfo);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i2, String str, UserBfbInfo userBfbInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BfbInfoModel(CreateBarGuideActivity createBarGuideActivity) {
        super(createBarGuideActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {createBarGuideActivity};
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
        this.f52023f = new a(this, CmdConfigHttp.CMD_GET_BFB_INFO, 309366);
        z();
        y();
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f52022e = bVar;
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
            sendMessage(new BfbInfoRequestMessage());
            return false;
        }
        return invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f52023f);
            MessageManager.getInstance().unRegisterTask(309366);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_BFB_INFO);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(this.f52023f);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.k3.e0.a.h(309366, BfbInfoSocketResponseMessage.class, false, false);
            c.a.r0.k3.e0.a.c(309366, CmdConfigHttp.CMD_GET_BFB_INFO, TbConfig.GET_BFB_INFO, BfbInfoHttpResponseMessage.class, false, false, false, false);
        }
    }
}

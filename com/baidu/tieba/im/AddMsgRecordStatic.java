package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.message.RequestAddMsgRecordMessage;
import com.baidu.tieba.im.message.ResponseClearTaskIdMessage;
import com.baidu.tieba.im.model.AddMsgRecordHttpProtoResponse;
import com.baidu.tieba.im.model.AddMsgRecordSocketResponse;
import com.baidu.tieba.jb;
import com.baidu.tieba.rx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AddMsgRecordStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
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
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
        @Override // com.baidu.tieba.jb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof AddMsgRecordHttpProtoResponse;
                if (!z2 && !(responsedMessage instanceof AddMsgRecordSocketResponse)) {
                    return;
                }
                boolean z3 = false;
                if (z2) {
                    AddMsgRecordHttpProtoResponse addMsgRecordHttpProtoResponse = (AddMsgRecordHttpProtoResponse) responsedMessage;
                    if (addMsgRecordHttpProtoResponse.getData() != null && addMsgRecordHttpProtoResponse.getData().status.intValue() == 1) {
                        z = true;
                        if (responsedMessage instanceof AddMsgRecordSocketResponse) {
                            AddMsgRecordSocketResponse addMsgRecordSocketResponse = (AddMsgRecordSocketResponse) responsedMessage;
                            if (addMsgRecordSocketResponse.getData() != null) {
                                if (addMsgRecordSocketResponse.getData().status.intValue() == 1) {
                                    z3 = true;
                                }
                                z = z3;
                            }
                        }
                        BdLog.e("success " + z);
                        if (responsedMessage.getOrginalMessage() == null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestAddMsgRecordMessage) && ((RequestAddMsgRecordMessage) responsedMessage.getOrginalMessage().getExtra()).isList()) {
                            BdLog.e("isList");
                            if (z) {
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponseClearTaskIdMessage());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                z = false;
                if (responsedMessage instanceof AddMsgRecordSocketResponse) {
                }
                BdLog.e("success " + z);
                if (responsedMessage.getOrginalMessage() == null) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1857205375, "Lcom/baidu/tieba/im/AddMsgRecordStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1857205375, "Lcom/baidu/tieba/im/AddMsgRecordStatic;");
                return;
            }
        }
        rx9.f(309265, AddMsgRecordSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_MSG_RECORD, rx9.a(TbConfig.ADD_MSG_RECORD, 309265));
        tbHttpMessageTask.setResponsedClass(AddMsgRecordHttpProtoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(new a(CmdConfigHttp.CMD_ADD_MSG_RECORD, 309265));
    }

    public AddMsgRecordStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}

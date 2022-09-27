package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.cloudcontrol.processor.DataProcessors;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.cloudcontrol.runtime.ICloudControlRegister;
import com.baidu.searchbox.pms.init.ApsCloudControlProcessor;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
@Singleton
@Service
/* loaded from: classes3.dex */
public class ei8 implements ICloudControlRegister {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ei8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.cloudcontrol.runtime.ICloudControlRegister
    public void registerAllProcessors(DataProcessors dataProcessors) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dataProcessors) == null) {
            dataProcessors.addProcessor("aps", new ApsCloudControlProcessor());
            dataProcessors.addProcessor(UBCCloudControlProcessor.UBC_KEY, new UBCCloudControlProcessor());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921656, ICloudControlProcessor.class, MiPushClient.COMMAND_REGISTER);
            if (runTask != null) {
                dataProcessors.addProcessor("config", (ICloudControlProcessor) runTask.getData());
            }
        }
    }
}

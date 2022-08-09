package com.baidu.tieba.homepage.lowFlows.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.id8;
import com.repackage.te5;
import tbclient.MoreTreasureTrove.DataReq;
import tbclient.MoreTreasureTrove.MoreTreasureTroveReqIdl;
/* loaded from: classes3.dex */
public class MoreTreasureTroveReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String lfUser;
    public String tabCode;
    public String taskId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreTreasureTroveReqMsg() {
        super(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.tab_code = this.tabCode;
                builder.lf_user = this.lfUser;
                builder.lf_user_taskid = this.taskId;
                builder.app_pos = id8.e().a();
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    te5.c(builder, true, true, false);
                }
                MoreTreasureTroveReqIdl.Builder builder2 = new MoreTreasureTroveReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public String getLfUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.lfUser : (String) invokeV.objValue;
    }

    public String getTabCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.tabCode : (String) invokeV.objValue;
    }

    public String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.taskId : (String) invokeV.objValue;
    }

    public void setLfUser(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.lfUser = str;
        }
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.tabCode = str;
        }
    }

    public void setTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.taskId = str;
        }
    }
}

package com.baidu.tieba.im.message;

import c.a.t0.d1.c0;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AddMsgRecord.AddMsgRecordReqIdl;
import tbclient.AddMsgRecord.DataReq;
import tbclient.AddMsgRecord.MsgRecord;
/* loaded from: classes12.dex */
public class RequestAddMsgRecordMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLICK = 3;
    public static final int LIST = 1;
    public static final int VIEW = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MsgRecord> msgRecords;
    public int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestAddMsgRecordMessage() {
        super(CmdConfigHttp.CMD_ADD_MSG_RECORD, 309265);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = 1;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.records = this.msgRecords;
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                c0.a(builder, true);
            }
            AddMsgRecordReqIdl.Builder builder2 = new AddMsgRecordReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public boolean isList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdLog.e("type " + this.type);
            return this.type == 1;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestAddMsgRecordMessage(List<MsgRecord> list) {
        super(CmdConfigHttp.CMD_ADD_MSG_RECORD, 309265);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = 1;
        this.msgRecords = list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.type = list.get(0).type.intValue();
    }
}

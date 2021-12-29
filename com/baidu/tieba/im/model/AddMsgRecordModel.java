package com.baidu.tieba.im.model;

import c.a.t0.s1.k.b;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestAddMsgRecordMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.AddMsgRecord.MsgRecord;
/* loaded from: classes12.dex */
public class AddMsgRecordModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AddMsgRecordModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private MsgRecord generateMsgRecord(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, this, i2, str)) == null) {
            if ((i2 != 1 && i2 != 2 && i2 != 3) || str == null || str.length() == 0) {
                return null;
            }
            MsgRecord.Builder builder = new MsgRecord.Builder();
            builder.type = Integer.valueOf(i2);
            builder.task_ids = str;
            BdLog.e("type is " + i2 + ", taskId is " + str);
            return builder.build(false);
        }
        return (MsgRecord) invokeIL.objValue;
    }

    private List<MsgRecord> getMsgRecords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            List<ImMessageCenterPojo> l = b.o().l();
            ArrayList arrayList = null;
            if (l != null && l.size() != 0) {
                for (ImMessageCenterPojo imMessageCenterPojo : l) {
                    String taskId = imMessageCenterPojo.getTaskId();
                    if (taskId != null && taskId.length() != 0 && !"0".equals(taskId)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        MsgRecord generateMsgRecord = generateMsgRecord(1, taskId);
                        if (generateMsgRecord != null) {
                            arrayList.add(generateMsgRecord);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void req() {
        List<MsgRecord> msgRecords;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (msgRecords = getMsgRecords()) == null || msgRecords.size() == 0) {
            return;
        }
        sendMessage(new RequestAddMsgRecordMessage(msgRecords));
    }

    public void reqViewAndClick(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            MsgRecord generateMsgRecord = generateMsgRecord(2, str);
            MsgRecord generateMsgRecord2 = generateMsgRecord(3, str2);
            if (generateMsgRecord == null && generateMsgRecord2 == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (generateMsgRecord != null) {
                arrayList.add(generateMsgRecord);
            }
            if (generateMsgRecord2 != null) {
                arrayList.add(generateMsgRecord2);
            }
            sendMessage(new RequestAddMsgRecordMessage(arrayList));
        }
    }
}

package com.baidu.tieba.im.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.b;
import com.baidu.tieba.im.message.RequestAddMsgRecordMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.AddMsgRecord.MsgRecord;
/* loaded from: classes.dex */
public class AddMsgRecordModel extends BdBaseModel {
    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void req() {
        List<MsgRecord> msgRecords = getMsgRecords();
        if (msgRecords != null && msgRecords.size() != 0) {
            sendMessage(new RequestAddMsgRecordMessage(msgRecords));
        }
    }

    public void reqViewAndClick(String str, String str2) {
        MsgRecord generateMsgRecord = generateMsgRecord(2, str);
        MsgRecord generateMsgRecord2 = generateMsgRecord(3, str2);
        if (generateMsgRecord != null || generateMsgRecord2 != null) {
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

    private List<MsgRecord> getMsgRecords() {
        ArrayList arrayList = null;
        List<ImMessageCenterPojo> are = b.aqX().are();
        if (are != null && are.size() != 0) {
            for (ImMessageCenterPojo imMessageCenterPojo : are) {
                String taskId = imMessageCenterPojo.getTaskId();
                if (taskId != null && taskId.length() != 0 && !"0".equals(taskId)) {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    MsgRecord generateMsgRecord = generateMsgRecord(1, taskId);
                    if (generateMsgRecord != null) {
                        arrayList2.add(generateMsgRecord);
                    }
                    arrayList = arrayList2;
                }
            }
        }
        return arrayList;
    }

    private MsgRecord generateMsgRecord(int i, String str) {
        if ((i != 1 && i != 2 && i != 3) || str == null || str.length() == 0) {
            return null;
        }
        MsgRecord.Builder builder = new MsgRecord.Builder();
        builder.type = Integer.valueOf(i);
        builder.task_ids = str;
        BdLog.e("type is " + i + ", taskId is " + str);
        return builder.build(false);
    }
}

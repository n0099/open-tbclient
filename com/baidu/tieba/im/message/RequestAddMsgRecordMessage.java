package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import java.util.List;
import tbclient.AddMsgRecord.AddMsgRecordReqIdl;
import tbclient.AddMsgRecord.DataReq;
import tbclient.AddMsgRecord.MsgRecord;
/* loaded from: classes4.dex */
public class RequestAddMsgRecordMessage extends NetMessage {
    public static final int CLICK = 3;
    public static final int LIST = 1;
    public static final int VIEW = 2;
    public List<MsgRecord> msgRecords;
    public int type;

    public RequestAddMsgRecordMessage() {
        super(CmdConfigHttp.CMD_ADD_MSG_RECORD, 309265);
        this.type = 1;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.records = this.msgRecords;
        if (z) {
            w.a(builder, true);
        }
        AddMsgRecordReqIdl.Builder builder2 = new AddMsgRecordReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public boolean isList() {
        BdLog.e("type " + this.type);
        return this.type == 1;
    }

    public RequestAddMsgRecordMessage(List<MsgRecord> list) {
        super(CmdConfigHttp.CMD_ADD_MSG_RECORD, 309265);
        this.type = 1;
        this.msgRecords = list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.type = list.get(0).type.intValue();
    }
}

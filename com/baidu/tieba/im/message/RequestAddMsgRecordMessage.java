package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.n;
import java.util.List;
import tbclient.AddMsgRecord.AddMsgRecordReqIdl;
import tbclient.AddMsgRecord.DataReq;
import tbclient.AddMsgRecord.MsgRecord;
/* loaded from: classes.dex */
public class RequestAddMsgRecordMessage extends NetMessage {
    public static final int CLICK = 3;
    public static final int LIST = 1;
    public static final int VIEW = 2;
    private List<MsgRecord> msgRecords;
    private int type;

    private RequestAddMsgRecordMessage() {
        super(CmdConfigHttp.CMD_ADD_MSG_RECORD, 309265);
        this.type = 1;
    }

    public boolean isList() {
        BdLog.e("type " + this.type);
        return this.type == 1;
    }

    public RequestAddMsgRecordMessage(List<MsgRecord> list) {
        super(CmdConfigHttp.CMD_ADD_MSG_RECORD, 309265);
        this.type = 1;
        this.msgRecords = list;
        if (list != null && list.size() > 0) {
            this.type = list.get(0).type.intValue();
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.records = this.msgRecords;
        if (z) {
            n.a(builder, true);
        }
        AddMsgRecordReqIdl.Builder builder2 = new AddMsgRecordReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

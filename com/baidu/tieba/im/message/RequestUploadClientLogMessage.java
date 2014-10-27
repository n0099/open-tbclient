package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import java.util.List;
import protobuf.UploadClientLog.ClientLog;
import protobuf.UploadClientLog.DataReq;
import protobuf.UploadClientLog.UploadClientLogReqIdl;
/* loaded from: classes.dex */
public class RequestUploadClientLogMessage extends TbSocketMessage {
    private List<ClientLog> client_log;

    public RequestUploadClientLogMessage() {
        super(202005);
    }

    public List<ClientLog> get_client_log() {
        return this.client_log;
    }

    public void set_client_log(List<ClientLog> list) {
        this.client_log = list;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.client_log = get_client_log();
            UploadClientLogReqIdl.Builder builder2 = new UploadClientLogReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}

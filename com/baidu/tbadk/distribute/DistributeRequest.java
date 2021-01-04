package com.baidu.tbadk.distribute;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.LogTogether.AdReq;
import tbclient.LogTogether.DataReq;
import tbclient.LogTogether.LogTogetherReqIdl;
/* loaded from: classes.dex */
public class DistributeRequest extends NetMessage {
    private List<AdReq> adReqList;

    public DistributeRequest(List<AdReq> list) {
        super(1003000, CmdConfigSocket.CMD_UPLOAD_ACTUAL_LOG);
        this.adReqList = list;
    }

    public DistributeRequest(AdReq adReq) {
        super(1003000, CmdConfigSocket.CMD_UPLOAD_ACTUAL_LOG);
        this.adReqList = new ArrayList();
        this.adReqList.add(adReq);
    }

    public List<AdReq> getAdReqList() {
        return this.adReqList;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        if (this.adReqList == null || this.adReqList.size() <= 0) {
            return null;
        }
        DataReq.Builder builder = new DataReq.Builder();
        LogTogetherReqIdl.Builder builder2 = new LogTogetherReqIdl.Builder();
        builder.Ad = this.adReqList;
        t.b(builder, false);
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

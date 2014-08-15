package com.baidu.tbadk.distribute;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.LogTogether.AdReq;
import tbclient.LogTogether.DataReq;
import tbclient.LogTogether.LogTogetherReqIdl;
/* loaded from: classes.dex */
public class RequestDistributeMessage extends TbSocketMessage {
    private List<AdReq> adReqList;

    public RequestDistributeMessage(List<AdReq> list) {
        super(303101);
        this.adReqList = list;
    }

    public RequestDistributeMessage(AdReq adReq) {
        super(303101);
        this.adReqList = new ArrayList();
        this.adReqList.add(adReq);
    }

    public List<AdReq> getAdReqList() {
        return this.adReqList;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        if (this.adReqList == null || this.adReqList.size() <= 0) {
            return null;
        }
        DataReq.Builder builder = new DataReq.Builder();
        LogTogetherReqIdl.Builder builder2 = new LogTogetherReqIdl.Builder();
        builder.Ad = this.adReqList;
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

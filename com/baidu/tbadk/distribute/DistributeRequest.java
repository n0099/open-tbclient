package com.baidu.tbadk.distribute;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.LogTogether.AdReq;
import tbclient.LogTogether.DataReq;
import tbclient.LogTogether.LogTogetherReqIdl;
/* loaded from: classes.dex */
public class DistributeRequest extends NetMessage {
    private List<AdReq> adReqList;

    public DistributeRequest(List<AdReq> list) {
        super(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
        this.adReqList = list;
    }

    public DistributeRequest(AdReq adReq) {
        super(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
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
        p.bindCommonParamsToProtobufData(builder, false);
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

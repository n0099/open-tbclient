package com.baidu.tbadk.distribute;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.LogTogether.AdReq;
import tbclient.LogTogether.DataReq;
import tbclient.LogTogether.LogTogetherReqIdl;
/* loaded from: classes3.dex */
public class DistributeRequest extends NetMessage {
    public List<AdReq> adReqList;

    public DistributeRequest(List<AdReq> list) {
        super(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
        this.adReqList = list;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        List<AdReq> list = this.adReqList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        DataReq.Builder builder = new DataReq.Builder();
        LogTogetherReqIdl.Builder builder2 = new LogTogetherReqIdl.Builder();
        builder.Ad = this.adReqList;
        w.a(builder, false);
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public List<AdReq> getAdReqList() {
        return this.adReqList;
    }

    public DistributeRequest(AdReq adReq) {
        super(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
        ArrayList arrayList = new ArrayList();
        this.adReqList = arrayList;
        arrayList.add(adReq);
    }
}

package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.CommonReq;
import tbclient.TopicList.DataReq;
import tbclient.TopicList.TopicListReqIdl;
/* loaded from: classes8.dex */
public class RequestHotRanklistMessage extends NetMessage {
    private String call_from;

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f5619common;
    private long fid;
    private String list_type;
    private String need_tab_list;

    public RequestHotRanklistMessage() {
        super(1003078, CmdConfigSocket.CMD_HOT_TOPIC_RANKLIST);
    }

    public void setCommon(CommonReq commonReq) {
        this.f5619common = commonReq;
    }

    public CommonReq getCommon() {
        return this.f5619common;
    }

    public String getCallFrom() {
        return this.call_from;
    }

    public void setCallFrom(String str) {
        this.call_from = str;
    }

    public String getListType() {
        return this.list_type;
    }

    public void setListType(String str) {
        this.list_type = str;
    }

    public String getNeedTabList() {
        return this.need_tab_list;
    }

    public void setNeedTabList(String str) {
        this.need_tab_list = str;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.f14936common = getCommon();
            builder.call_from = getCallFrom();
            builder.list_type = getListType();
            builder.need_tab_list = getNeedTabList();
            builder.fid = Long.valueOf(this.fid);
            if (z) {
                t.b(builder, true);
            }
            TopicListReqIdl.Builder builder2 = new TopicListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}

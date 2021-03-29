package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.CommonReq;
import tbclient.TopicList.DataReq;
import tbclient.TopicList.TopicListReqIdl;
/* loaded from: classes3.dex */
public class RequestHotRanklistMessage extends NetMessage {
    public String call_from;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f17619common;
    public long fid;
    public String list_type;
    public String need_tab_list;

    public RequestHotRanklistMessage() {
        super(CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, 309289);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.f68643common = getCommon();
            builder.call_from = getCallFrom();
            builder.list_type = getListType();
            builder.need_tab_list = getNeedTabList();
            builder.fid = Long.valueOf(this.fid);
            if (z) {
                w.a(builder, true);
            }
            TopicListReqIdl.Builder builder2 = new TopicListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getCallFrom() {
        return this.call_from;
    }

    public CommonReq getCommon() {
        return this.f17619common;
    }

    public String getListType() {
        return this.list_type;
    }

    public String getNeedTabList() {
        return this.need_tab_list;
    }

    public void setCallFrom(String str) {
        this.call_from = str;
    }

    public void setCommon(CommonReq commonReq) {
        this.f17619common = commonReq;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setListType(String str) {
        this.list_type = str;
    }

    public void setNeedTabList(String str) {
        this.need_tab_list = str;
    }
}

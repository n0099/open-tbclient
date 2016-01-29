package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.i;
import tbclient.CommonReq;
import tbclient.HottopicRanklist.DataReq;
import tbclient.HottopicRanklist.TopicListReqIdl;
/* loaded from: classes.dex */
public class RequestHotRanklistMessage extends NetMessage {
    private String call_from;
    private CommonReq common;
    private String list_type;

    public RequestHotRanklistMessage() {
        super(CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, 309289);
    }

    public void setCommon(CommonReq commonReq) {
        this.common = commonReq;
    }

    public CommonReq getCommon() {
        return this.common;
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

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.common = getCommon();
            builder.call_from = getCallFrom();
            builder.list_type = getListType();
            if (z) {
                i.a(builder, true);
            }
            TopicListReqIdl.Builder builder2 = new TopicListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}

package com.baidu.tieba.hottopicselect;

import GetSugTopic.DataReq;
import GetSugTopic.GetSugTopicReqIdl;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.CommonReq;
/* loaded from: classes15.dex */
public class HotTopicSelectNetMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f985common;
    private long fid;
    private String firstDir;
    private String prefix;
    private String secondDir;

    public HotTopicSelectNetMessage() {
        super(1003186, CmdConfigSocket.CMD_GET_HOTTOPIC_SELECT);
        this.firstDir = "";
        this.secondDir = "";
        this.fid = 0L;
    }

    public long getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public String getFirstDir() {
        return this.firstDir;
    }

    public void setFirstDir(String str) {
        this.firstDir = str;
    }

    public String getSecondDir() {
        return this.secondDir;
    }

    public void setSecondDir(String str) {
        this.secondDir = str;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public CommonReq getCommon() {
        return this.f985common;
    }

    public void setCommon(CommonReq commonReq) {
        this.f985common = commonReq;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f949common = getCommon();
        builder.fid = Long.valueOf(this.fid);
        if (this.prefix != null) {
            builder.prefix = this.prefix;
        }
        if (this.firstDir != null) {
            builder.first_dir = this.firstDir;
        }
        if (this.secondDir != null) {
            builder.second_dir = this.secondDir;
        }
        if (z) {
            t.a(builder, true);
        }
        GetSugTopicReqIdl.Builder builder2 = new GetSugTopicReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

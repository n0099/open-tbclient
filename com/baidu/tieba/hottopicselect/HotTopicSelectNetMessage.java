package com.baidu.tieba.hottopicselect;

import GetSugTopic.DataReq;
import GetSugTopic.GetSugTopicReqIdl;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.CommonReq;
/* loaded from: classes4.dex */
public class HotTopicSelectNetMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f17412common;
    public long fid;
    public String firstDir;
    public String prefix;
    public String secondDir;

    public HotTopicSelectNetMessage() {
        super(CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, 309416);
        this.firstDir = "";
        this.secondDir = "";
        this.fid = 0L;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f995common = getCommon();
        builder.fid = Long.valueOf(this.fid);
        String str = this.prefix;
        if (str != null) {
            builder.prefix = str;
        }
        String str2 = this.firstDir;
        if (str2 != null) {
            builder.first_dir = str2;
        }
        String str3 = this.secondDir;
        if (str3 != null) {
            builder.second_dir = str3;
        }
        if (z) {
            w.a(builder, true);
        }
        GetSugTopicReqIdl.Builder builder2 = new GetSugTopicReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public CommonReq getCommon() {
        return this.f17412common;
    }

    public long getFid() {
        return this.fid;
    }

    public String getFirstDir() {
        return this.firstDir;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getSecondDir() {
        return this.secondDir;
    }

    public void setCommon(CommonReq commonReq) {
        this.f17412common = commonReq;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setFirstDir(String str) {
        this.firstDir = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setSecondDir(String str) {
        this.secondDir = str;
    }
}

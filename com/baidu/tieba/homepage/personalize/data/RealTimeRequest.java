package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.Realtime.DataReq;
import tbclient.Realtime.RealtimeReqIdl;
/* loaded from: classes4.dex */
public class RealTimeRequest extends NetMessage {
    public String abtest_tag;
    public int location;
    public String ori_ugc_nid;
    public String ori_ugc_tid;
    public String ori_ugc_type;
    public String ori_ugc_vid;
    public String page;
    public String source;
    public long tid;
    public int type;
    public String weight;

    public RealTimeRequest() {
        super(CmdConfigHttp.CMD_REPORT_HOME_PIC_CLICK, 309277);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.tid = Long.valueOf(this.tid);
        builder.weight = this.weight;
        builder.source = this.source;
        builder.location = Integer.valueOf(this.location);
        builder.abtest_tag = this.abtest_tag;
        builder.type = Integer.valueOf(this.type);
        builder.page = this.page;
        builder.ori_ugc_nid = this.ori_ugc_nid;
        builder.ori_ugc_tid = this.ori_ugc_tid;
        builder.ori_ugc_type = this.ori_ugc_type;
        builder.ori_ugc_vid = this.ori_ugc_vid;
        if (z) {
            w.a(builder, true);
        }
        RealtimeReqIdl.Builder builder2 = new RealtimeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getAbtest_tag() {
        return this.abtest_tag;
    }

    public int getLocation() {
        return this.location;
    }

    public String getPage() {
        return this.page;
    }

    public String getSource() {
        return this.source;
    }

    public long getTid() {
        return this.tid;
    }

    public int getType() {
        return this.type;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setAbtest_tag(String str) {
        this.abtest_tag = str;
    }

    public void setLocation(int i2) {
        this.location = i2;
    }

    public void setOriUgcNid(String str) {
        this.ori_ugc_nid = str;
    }

    public void setOriUgcTid(String str) {
        this.ori_ugc_tid = str;
    }

    public void setOriUgcType(String str) {
        this.ori_ugc_type = str;
    }

    public void setOriUgcVid(String str) {
        this.ori_ugc_vid = str;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTid(long j) {
        this.tid = j;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setWeight(String str) {
        this.weight = str;
    }
}

package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.Realtime.DataReq;
import tbclient.Realtime.RealtimeReqIdl;
/* loaded from: classes2.dex */
public class RealTimeRequest extends NetMessage {
    private String abtest_tag;
    private int location;
    private String ori_ugc_nid;
    private String ori_ugc_tid;
    private String ori_ugc_type;
    private String ori_ugc_vid;
    private String page;
    private String source;
    private long tid;
    private int type;
    private String weight;

    public RealTimeRequest() {
        super(1003072, CmdConfigSocket.CMD_REPORT_HOME_PIC_CLICK);
    }

    public long getTid() {
        return this.tid;
    }

    public void setTid(long j) {
        this.tid = j;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String str) {
        this.weight = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public int getLocation() {
        return this.location;
    }

    public void setLocation(int i) {
        this.location = i;
    }

    public String getAbtest_tag() {
        return this.abtest_tag;
    }

    public void setAbtest_tag(String str) {
        this.abtest_tag = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String str) {
        this.page = str;
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

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
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
            t.b(builder, true);
        }
        RealtimeReqIdl.Builder builder2 = new RealtimeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

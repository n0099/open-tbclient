package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.o;
import tbclient.Realtime.DataReq;
import tbclient.Realtime.RealtimeReqIdl;
/* loaded from: classes.dex */
public class RealTimeRequest extends NetMessage {
    private String abtest_tag;
    private int location;
    private String source;
    private long tid;
    private int type;
    private String weight;

    public RealTimeRequest() {
        super(CmdConfigHttp.CMD_REPORT_HOME_PIC_CLICK, 309277);
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

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.tid = Long.valueOf(this.tid);
        builder.weight = this.weight;
        builder.source = this.source;
        builder.location = Integer.valueOf(this.location);
        builder.abtest_tag = this.abtest_tag;
        builder.type = Integer.valueOf(this.type);
        if (z) {
            o.bindCommonParamsToProtobufData(builder, true);
        }
        RealtimeReqIdl.Builder builder2 = new RealtimeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

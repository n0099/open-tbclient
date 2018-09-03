package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.o;
import java.util.HashMap;
import tbclient.VideoTopicList.DataReq;
import tbclient.VideoTopicList.VideoTopicListReqIdl;
/* loaded from: classes3.dex */
public class VideoTopicRequestData extends OrmObject implements e, h {
    private Integer dML;
    private Integer dMM;
    private String dMN;
    private String dMO;
    private Integer dMP;
    private Integer dMQ;
    private Long pn;
    private Integer rn = 10;

    @Override // com.baidu.tbadk.mvc.b.e
    public String Jx() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Jy() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> JA() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object bQ(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.topic_id = this.dMP;
        builder.pn = this.pn;
        builder.rn = this.rn;
        builder.q_type = this.dMO;
        builder.scr_dip = this.dMN;
        builder.scr_h = this.dMM;
        builder.scr_w = this.dML;
        o.bindCommonParamsToProtobufData(builder, true, false, true);
        VideoTopicListReqIdl.Builder builder2 = new VideoTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setScrW(Integer num) {
        this.dML = num;
    }

    public void setScrH(Integer num) {
        this.dMM = num;
    }

    public void nj(String str) {
        this.dMN = str;
    }

    public void nk(String str) {
        this.dMO = str;
    }

    public void l(Integer num) {
        this.dMP = num;
    }

    public void bM(long j) {
        this.pn = Long.valueOf(j);
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public int getRequestType() {
        return this.dMQ.intValue();
    }

    public void m(Integer num) {
        this.dMQ = num;
    }
}

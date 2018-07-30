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
    private Integer dMP;
    private Integer dMQ;
    private String dMR;
    private String dMS;
    private Integer dMT;
    private Integer dMU;
    private Long pn;
    private Integer rn = 10;

    @Override // com.baidu.tbadk.mvc.b.e
    public String Jt() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Ju() {
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
    public HashMap<String, Object> Jw() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object bP(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.topic_id = this.dMT;
        builder.pn = this.pn;
        builder.rn = this.rn;
        builder.q_type = this.dMS;
        builder.scr_dip = this.dMR;
        builder.scr_h = this.dMQ;
        builder.scr_w = this.dMP;
        o.bindCommonParamsToProtobufData(builder, true, false, true);
        VideoTopicListReqIdl.Builder builder2 = new VideoTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setScrW(Integer num) {
        this.dMP = num;
    }

    public void setScrH(Integer num) {
        this.dMQ = num;
    }

    public void nh(String str) {
        this.dMR = str;
    }

    public void ni(String str) {
        this.dMS = str;
    }

    public void l(Integer num) {
        this.dMT = num;
    }

    public void bM(long j) {
        this.pn = Long.valueOf(j);
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public int getRequestType() {
        return this.dMU.intValue();
    }

    public void m(Integer num) {
        this.dMU = num;
    }
}

package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.p;
import java.util.HashMap;
import tbclient.VideoTopicList.DataReq;
import tbclient.VideoTopicList.VideoTopicListReqIdl;
/* loaded from: classes3.dex */
public class VideoTopicRequestData extends OrmObject implements e, h {
    private Integer edr;
    private Integer eds;
    private String edt;
    private String edu;
    private Integer edv;
    private Integer edw;
    private Long pn;
    private Integer rn = 10;

    @Override // com.baidu.tbadk.mvc.b.e
    public String MU() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean MV() {
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
    public HashMap<String, Object> MX() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object cC(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.topic_id = this.edv;
        builder.pn = this.pn;
        builder.rn = this.rn;
        builder.q_type = this.edu;
        builder.scr_dip = this.edt;
        builder.scr_h = this.eds;
        builder.scr_w = this.edr;
        p.bindCommonParamsToProtobufData(builder, true, false, true);
        VideoTopicListReqIdl.Builder builder2 = new VideoTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setScrW(Integer num) {
        this.edr = num;
    }

    public void setScrH(Integer num) {
        this.eds = num;
    }

    public void ot(String str) {
        this.edt = str;
    }

    public void ou(String str) {
        this.edu = str;
    }

    public void l(Integer num) {
        this.edv = num;
    }

    public void bS(long j) {
        this.pn = Long.valueOf(j);
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public int getRequestType() {
        return this.edw.intValue();
    }

    public void m(Integer num) {
        this.edw = num;
    }
}

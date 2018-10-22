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
    private Integer ebX;
    private Integer ebY;
    private String ebZ;
    private String eca;
    private Integer ecb;
    private Integer ecc;
    private Long pn;
    private Integer rn = 10;

    @Override // com.baidu.tbadk.mvc.b.e
    public String ML() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean MM() {
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
    public HashMap<String, Object> MO() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object cl(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.topic_id = this.ecb;
        builder.pn = this.pn;
        builder.rn = this.rn;
        builder.q_type = this.eca;
        builder.scr_dip = this.ebZ;
        builder.scr_h = this.ebY;
        builder.scr_w = this.ebX;
        p.bindCommonParamsToProtobufData(builder, true, false, true);
        VideoTopicListReqIdl.Builder builder2 = new VideoTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setScrW(Integer num) {
        this.ebX = num;
    }

    public void setScrH(Integer num) {
        this.ebY = num;
    }

    public void os(String str) {
        this.ebZ = str;
    }

    public void ot(String str) {
        this.eca = str;
    }

    public void l(Integer num) {
        this.ecb = num;
    }

    public void bX(long j) {
        this.pn = Long.valueOf(j);
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public int getRequestType() {
        return this.ecc.intValue();
    }

    public void m(Integer num) {
        this.ecc = num;
    }
}

package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.p;
import java.util.HashMap;
import tbclient.VideoTopicList.DataReq;
import tbclient.VideoTopicList.VideoTopicListReqIdl;
/* loaded from: classes2.dex */
public class VideoTopicRequestData extends OrmObject implements e, h {
    private Integer dJZ;
    private Integer dKa;
    private String dKb;
    private String dKc;
    private Integer dKd;
    private Integer dKe;
    private Long pn;
    private Integer rn = 10;

    @Override // com.baidu.tbadk.mvc.b.e
    public String Jy() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Jz() {
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
    public HashMap<String, Object> JB() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object bR(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.topic_id = this.dKd;
        builder.pn = this.pn;
        builder.rn = this.rn;
        builder.q_type = this.dKc;
        builder.scr_dip = this.dKb;
        builder.scr_h = this.dKa;
        builder.scr_w = this.dJZ;
        p.bindCommonParamsToProtobufData(builder, true, false, true);
        VideoTopicListReqIdl.Builder builder2 = new VideoTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setScrW(Integer num) {
        this.dJZ = num;
    }

    public void setScrH(Integer num) {
        this.dKa = num;
    }

    public void ni(String str) {
        this.dKb = str;
    }

    public void nj(String str) {
        this.dKc = str;
    }

    public void l(Integer num) {
        this.dKd = num;
    }

    public void bH(long j) {
        this.pn = Long.valueOf(j);
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public int getRequestType() {
        return this.dKe.intValue();
    }

    public void m(Integer num) {
        this.dKe = num;
    }
}

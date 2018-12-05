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
    private Integer ejU;
    private Integer ejV;
    private String ejW;
    private String ejX;
    private Integer ejY;
    private Integer ejZ;
    private Long pn;
    private Integer rn = 10;

    @Override // com.baidu.tbadk.mvc.b.e
    public String NY() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean NZ() {
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
    public HashMap<String, Object> Ob() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object cD(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.topic_id = this.ejY;
        builder.pn = this.pn;
        builder.rn = this.rn;
        builder.q_type = this.ejX;
        builder.scr_dip = this.ejW;
        builder.scr_h = this.ejV;
        builder.scr_w = this.ejU;
        p.bindCommonParamsToProtobufData(builder, true, false, true);
        VideoTopicListReqIdl.Builder builder2 = new VideoTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setScrW(Integer num) {
        this.ejU = num;
    }

    public void setScrH(Integer num) {
        this.ejV = num;
    }

    public void oS(String str) {
        this.ejW = str;
    }

    public void oT(String str) {
        this.ejX = str;
    }

    public void l(Integer num) {
        this.ejY = num;
    }

    public void bZ(long j) {
        this.pn = Long.valueOf(j);
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public int getRequestType() {
        return this.ejZ.intValue();
    }

    public void m(Integer num) {
        this.ejZ = num;
    }
}

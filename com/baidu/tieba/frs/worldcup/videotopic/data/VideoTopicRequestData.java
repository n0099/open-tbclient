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
    private Integer dUd;
    private Integer dUe;
    private String dUf;
    private String dUg;
    private Integer dUh;
    private Integer dUi;
    private Long pn;
    private Integer rn = 10;

    @Override // com.baidu.tbadk.mvc.b.e
    public String KN() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean KO() {
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
    public HashMap<String, Object> KQ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object cc(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.topic_id = this.dUh;
        builder.pn = this.pn;
        builder.rn = this.rn;
        builder.q_type = this.dUg;
        builder.scr_dip = this.dUf;
        builder.scr_h = this.dUe;
        builder.scr_w = this.dUd;
        p.bindCommonParamsToProtobufData(builder, true, false, true);
        VideoTopicListReqIdl.Builder builder2 = new VideoTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setScrW(Integer num) {
        this.dUd = num;
    }

    public void setScrH(Integer num) {
        this.dUe = num;
    }

    public void nO(String str) {
        this.dUf = str;
    }

    public void nP(String str) {
        this.dUg = str;
    }

    public void l(Integer num) {
        this.dUh = num;
    }

    public void bQ(long j) {
        this.pn = Long.valueOf(j);
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public int getRequestType() {
        return this.dUi.intValue();
    }

    public void m(Integer num) {
        this.dUi = num;
    }
}

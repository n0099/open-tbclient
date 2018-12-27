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
    private Integer emK;
    private Integer emL;
    private String emM;
    private String emN;
    private Integer emO;
    private Integer emP;
    private Long pn;
    private Integer rn = 10;

    @Override // com.baidu.tbadk.mvc.b.e
    public String NZ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Oa() {
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
    public HashMap<String, Object> Oc() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object cD(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.topic_id = this.emO;
        builder.pn = this.pn;
        builder.rn = this.rn;
        builder.q_type = this.emN;
        builder.scr_dip = this.emM;
        builder.scr_h = this.emL;
        builder.scr_w = this.emK;
        p.bindCommonParamsToProtobufData(builder, true, false, true);
        VideoTopicListReqIdl.Builder builder2 = new VideoTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setScrW(Integer num) {
        this.emK = num;
    }

    public void setScrH(Integer num) {
        this.emL = num;
    }

    public void oV(String str) {
        this.emM = str;
    }

    public void oW(String str) {
        this.emN = str;
    }

    public void l(Integer num) {
        this.emO = num;
    }

    public void ce(long j) {
        this.pn = Long.valueOf(j);
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public int getRequestType() {
        return this.emP.intValue();
    }

    public void m(Integer num) {
        this.emP = num;
    }
}

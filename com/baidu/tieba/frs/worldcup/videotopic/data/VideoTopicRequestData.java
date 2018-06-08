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
    private Integer dGG;
    private Integer dGH;
    private String dGI;
    private String dGJ;
    private Integer dGK;
    private Integer dGL;
    private Long pn;
    private Integer rn = 10;

    @Override // com.baidu.tbadk.mvc.b.e
    public String Jg() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Jh() {
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
    public HashMap<String, Object> Jj() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object bO(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.topic_id = this.dGK;
        builder.pn = this.pn;
        builder.rn = this.rn;
        builder.q_type = this.dGJ;
        builder.scr_dip = this.dGI;
        builder.scr_h = this.dGH;
        builder.scr_w = this.dGG;
        p.bindCommonParamsToProtobufData(builder, true, false, true);
        VideoTopicListReqIdl.Builder builder2 = new VideoTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setScrW(Integer num) {
        this.dGG = num;
    }

    public void setScrH(Integer num) {
        this.dGH = num;
    }

    public void nh(String str) {
        this.dGI = str;
    }

    public void ni(String str) {
        this.dGJ = str;
    }

    public void l(Integer num) {
        this.dGK = num;
    }

    public void bL(long j) {
        this.pn = Long.valueOf(j);
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public int getRequestType() {
        return this.dGL.intValue();
    }

    public void m(Integer num) {
        this.dGL = num;
    }
}

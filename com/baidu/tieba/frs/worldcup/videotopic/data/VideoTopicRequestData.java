package com.baidu.tieba.frs.worldcup.videotopic.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.q;
import java.util.HashMap;
import tbclient.VideoTopicList.DataReq;
import tbclient.VideoTopicList.VideoTopicListReqIdl;
/* loaded from: classes3.dex */
public class VideoTopicRequestData extends OrmObject implements e, h {
    private Integer enr;
    private Integer ens;
    private String ent;
    private String enu;
    private Integer env;
    private Integer enw;
    private Long pn;
    private Integer rn = 10;

    @Override // com.baidu.tbadk.mvc.b.e
    public String Oq() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Or() {
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
    public HashMap<String, Object> Ot() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> Ou() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object cG(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.topic_id = this.env;
        builder.pn = this.pn;
        builder.rn = this.rn;
        builder.q_type = this.enu;
        builder.scr_dip = this.ent;
        builder.scr_h = this.ens;
        builder.scr_w = this.enr;
        q.bindCommonParamsToProtobufData(builder, true, false, true);
        VideoTopicListReqIdl.Builder builder2 = new VideoTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setScrW(Integer num) {
        this.enr = num;
    }

    public void setScrH(Integer num) {
        this.ens = num;
    }

    public void pl(String str) {
        this.ent = str;
    }

    public void pm(String str) {
        this.enu = str;
    }

    public void l(Integer num) {
        this.env = num;
    }

    public void ce(long j) {
        this.pn = Long.valueOf(j);
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public int getRequestType() {
        return this.enw.intValue();
    }

    public void m(Integer num) {
        this.enw = num;
    }
}

package com.baidu.tieba.frs.worldcup.talkball.model;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.mvc.b.e;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.p;
import java.util.HashMap;
import tbclient.TalkBall.DataReq;
import tbclient.TalkBall.TalkBallReqIdl;
/* loaded from: classes2.dex */
public class TalkBallRequestData extends OrmObject implements e, h {
    private String forum_name;
    private Long last_thread_id;
    private Integer pn;
    private Integer q_type;
    private int requestType;
    private Integer rn;
    private Double scr_dip;
    private Integer scr_h;
    private Integer scr_w;

    @Override // com.baidu.tbadk.mvc.b.k
    public Object bR(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.scr_w = this.scr_w;
        builder.scr_h = this.scr_h;
        builder.scr_dip = this.scr_dip;
        builder.q_type = this.q_type;
        builder.forum_name = this.forum_name;
        builder.last_thread_id = this.last_thread_id;
        builder.rn = this.rn;
        builder.pn = this.pn;
        p.bindCommonParamsToProtobufData(builder, true, false, true);
        TalkBallReqIdl.Builder builder2 = new TalkBallReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void h(Integer num) {
        this.scr_w = num;
    }

    public void i(Integer num) {
        this.scr_h = num;
    }

    public void a(Double d) {
        this.scr_dip = d;
    }

    public void j(Integer num) {
        this.q_type = num;
    }

    public void dp(String str) {
        this.forum_name = str;
    }

    public void e(Long l) {
        this.last_thread_id = l;
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public void k(Integer num) {
        this.pn = num;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public void lW(int i) {
        this.requestType = i;
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

    @Override // com.baidu.tbadk.mvc.b.e
    public String Jy() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> JB() {
        return null;
    }
}

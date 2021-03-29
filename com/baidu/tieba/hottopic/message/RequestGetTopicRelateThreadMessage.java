package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.CommonReq;
import tbclient.GetTopicRelateThread.DataReq;
import tbclient.GetTopicRelateThread.GetTopicRelateThreadReqIdl;
/* loaded from: classes3.dex */
public class RequestGetTopicRelateThreadMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f17618common;
    public Long last_id;
    public Integer page_no;
    public Integer pmy_source;
    public Long pmy_topic_id;
    public Integer q_type;
    public Integer rn;
    public Double scr_dip;
    public Integer scr_h;
    public Integer scr_w;
    public Integer sort_type;
    public Long topic_id;
    public String topic_name;

    public RequestGetTopicRelateThreadMessage() {
        super(CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.f68501common = getCommon();
            builder.topic_id = getTopicId();
            builder.topic_name = getTopicName();
            builder.rn = getRn();
            builder.page_no = getPageNo();
            builder.last_id = getLastId();
            builder.scr_w = getScrW();
            builder.scr_h = getScrH();
            builder.scr_dip = getScrDip();
            builder.q_type = getQType();
            builder.pmy_topic_id = getPmy_topic_id();
            builder.pmy_source = getPmy_source();
            builder.sort_type = getSort_type();
            if (z) {
                w.a(builder, true);
            }
            GetTopicRelateThreadReqIdl.Builder builder2 = new GetTopicRelateThreadReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public CommonReq getCommon() {
        return this.f17618common;
    }

    public Long getLastId() {
        return this.last_id;
    }

    public Integer getPageNo() {
        return this.page_no;
    }

    public Integer getPmy_source() {
        return this.pmy_source;
    }

    public Long getPmy_topic_id() {
        return this.pmy_topic_id;
    }

    public Integer getQType() {
        return this.q_type;
    }

    public Integer getRn() {
        return this.rn;
    }

    public Double getScrDip() {
        return this.scr_dip;
    }

    public Integer getScrH() {
        return this.scr_h;
    }

    public Integer getScrW() {
        return this.scr_w;
    }

    public Integer getSort_type() {
        return this.sort_type;
    }

    public Long getTopicId() {
        return this.topic_id;
    }

    public String getTopicName() {
        return this.topic_name;
    }

    public void setCommon(CommonReq commonReq) {
        this.f17618common = commonReq;
    }

    public void setLastId(Long l) {
        this.last_id = l;
    }

    public void setPageNo(Integer num) {
        this.page_no = num;
    }

    public void setPmy_source(Integer num) {
        this.pmy_source = num;
    }

    public void setPmy_topic_id(Long l) {
        this.pmy_topic_id = l;
    }

    public void setQType(Integer num) {
        this.q_type = num;
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public void setScrDip(Double d2) {
        this.scr_dip = d2;
    }

    public void setScrH(Integer num) {
        this.scr_h = num;
    }

    public void setScrW(Integer num) {
        this.scr_w = num;
    }

    public void setSort_type(Integer num) {
        this.sort_type = num;
    }

    public void setTopicId(Long l) {
        this.topic_id = l;
    }

    public void setTopicName(String str) {
        this.topic_name = str;
    }
}

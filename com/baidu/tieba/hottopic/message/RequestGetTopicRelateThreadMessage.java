package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.u;
import tbclient.CommonReq;
import tbclient.GetTopicRelateThread.DataReq;
import tbclient.GetTopicRelateThread.GetTopicRelateThreadReqIdl;
/* loaded from: classes21.dex */
public class RequestGetTopicRelateThreadMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f3687common;
    private Long last_id;
    private Integer page_no;
    private Integer pmy_source;
    private Long pmy_topic_id;
    private Integer q_type;
    private Integer rn;
    private Double scr_dip;
    private Integer scr_h;
    private Integer scr_w;
    public Integer sort_type;
    private Long topic_id;
    private String topic_name;

    public RequestGetTopicRelateThreadMessage() {
        super(1003042, CmdConfigSocket.CMD_TOPIC_RELATE_THREAD);
    }

    public CommonReq getCommon() {
        return this.f3687common;
    }

    public void setCommon(CommonReq commonReq) {
        this.f3687common = commonReq;
    }

    public Long getTopicId() {
        return this.topic_id;
    }

    public void setTopicId(Long l) {
        this.topic_id = l;
    }

    public String getTopicName() {
        return this.topic_name;
    }

    public void setTopicName(String str) {
        this.topic_name = str;
    }

    public Integer getRn() {
        return this.rn;
    }

    public void setRn(Integer num) {
        this.rn = num;
    }

    public Integer getPageNo() {
        return this.page_no;
    }

    public void setPageNo(Integer num) {
        this.page_no = num;
    }

    public Long getLastId() {
        return this.last_id;
    }

    public void setLastId(Long l) {
        this.last_id = l;
    }

    public Integer getScrW() {
        return this.scr_w;
    }

    public void setScrW(Integer num) {
        this.scr_w = num;
    }

    public Integer getScrH() {
        return this.scr_h;
    }

    public void setScrH(Integer num) {
        this.scr_h = num;
    }

    public Double getScrDip() {
        return this.scr_dip;
    }

    public void setScrDip(Double d) {
        this.scr_dip = d;
    }

    public Integer getQType() {
        return this.q_type;
    }

    public void setQType(Integer num) {
        this.q_type = num;
    }

    public void setPmy_topic_id(Long l) {
        this.pmy_topic_id = l;
    }

    public Long getPmy_topic_id() {
        return this.pmy_topic_id;
    }

    public void setPmy_source(Integer num) {
        this.pmy_source = num;
    }

    public Integer getPmy_source() {
        return this.pmy_source;
    }

    public Integer getSort_type() {
        return this.sort_type;
    }

    public void setSort_type(Integer num) {
        this.sort_type = num;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.f5265common = getCommon();
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
                u.a(builder, true);
            }
            GetTopicRelateThreadReqIdl.Builder builder2 = new GetTopicRelateThreadReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}

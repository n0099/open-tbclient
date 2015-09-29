package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.h;
import tbclient.CommonReq;
import tbclient.GetTopicRelateThread.DataReq;
import tbclient.GetTopicRelateThread.GetTopicRelateThreadReqIdl;
/* loaded from: classes.dex */
public class RequestGetTopicRelateThreadMessage extends NetMessage {
    private CommonReq common;
    private Long last_id;
    private Integer page_no;
    private Integer q_type;
    private Integer rn;
    private Double scr_dip;
    private Integer scr_h;
    private Integer scr_w;
    private Long topic_id;
    private String topic_name;

    public RequestGetTopicRelateThreadMessage() {
        super(CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005);
    }

    public CommonReq getCommon() {
        return this.common;
    }

    public void setCommon(CommonReq commonReq) {
        this.common = commonReq;
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

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.common = getCommon();
            builder.topic_id = getTopicId();
            builder.topic_name = getTopicName();
            builder.rn = getRn();
            builder.page_no = getPageNo();
            builder.last_id = getLastId();
            builder.scr_w = getScrW();
            builder.scr_h = getScrH();
            builder.scr_dip = getScrDip();
            builder.q_type = getQType();
            if (z) {
                h.a(builder, true);
            }
            GetTopicRelateThreadReqIdl.Builder builder2 = new GetTopicRelateThreadReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}

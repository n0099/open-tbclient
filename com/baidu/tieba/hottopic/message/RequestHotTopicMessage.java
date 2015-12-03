package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.i;
import tbclient.CommonReq;
import tbclient.Hottopic.DataReq;
import tbclient.Hottopic.HottopicReqIdl;
/* loaded from: classes.dex */
public class RequestHotTopicMessage extends NetMessage {
    private CommonReq common;
    private Integer q_type;
    private Double scr_dip;
    private Integer scr_h;
    private Integer scr_w;
    private Long topic_id;
    private String topic_name;

    public RequestHotTopicMessage() {
        super(CmdConfigHttp.CMD_HOT_TOPIC, 303050);
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

    public Integer getScrW() {
        return this.scr_w;
    }

    public void setScrW(Integer num) {
        this.scr_w = num;
    }

    public Integer getSrcH() {
        return this.scr_h;
    }

    public void setScrH(Integer num) {
        this.scr_h = num;
    }

    public Double getSrcDip() {
        return this.scr_dip;
    }

    public void setSrcDip(Double d) {
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
            builder.scr_w = getScrW();
            builder.scr_h = getSrcH();
            builder.scr_dip = getSrcDip();
            builder.q_type = getQType();
            if (z) {
                i.a(builder, true);
            }
            HottopicReqIdl.Builder builder2 = new HottopicReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}

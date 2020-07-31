package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.CommonReq;
import tbclient.Hottopic.DataReq;
import tbclient.Hottopic.HottopicReqIdl;
/* loaded from: classes15.dex */
public class RequestHotTopicMessage extends NetMessage {
    private int call_from;

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f982common;
    private Long fid;
    private String first_dir;
    private Integer q_type;
    private Double scr_dip;
    private Integer scr_h;
    private Integer scr_w;
    private String second_dir;
    private Integer sort_type;
    private Long topic_id;
    private String topic_name;
    private long topic_tid;

    public RequestHotTopicMessage() {
        super(1003041, CmdConfigSocket.CMD_HOT_TOPIC);
    }

    public int getCall_from() {
        return this.call_from;
    }

    public void setCall_from(int i) {
        this.call_from = i;
    }

    public long getTopic_tid() {
        return this.topic_tid;
    }

    public void setTopic_tid(long j) {
        this.topic_tid = j;
    }

    public CommonReq getCommon() {
        return this.f982common;
    }

    public void setCommon(CommonReq commonReq) {
        this.f982common = commonReq;
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
            builder.f1144common = getCommon();
            builder.topic_id = getTopicId();
            builder.topic_name = getTopicName();
            builder.scr_w = getScrW();
            builder.scr_h = getSrcH();
            builder.scr_dip = getSrcDip();
            builder.q_type = getQType();
            builder.sort_type = getSort_type();
            builder.fid = getFid();
            builder.first_dir = getFirst_dir();
            builder.second_dir = getSecond_dir();
            builder.call_from = Integer.valueOf(getCall_from());
            builder.topic_tid = Long.valueOf(getTopic_tid());
            if (z) {
                t.a(builder, true);
            }
            HottopicReqIdl.Builder builder2 = new HottopicReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }

    public String getFirst_dir() {
        return this.first_dir;
    }

    public void setFirst_dir(String str) {
        this.first_dir = str;
    }

    public String getSecond_dir() {
        return this.second_dir;
    }

    public void setSecond_dir(String str) {
        this.second_dir = str;
    }

    public Long getFid() {
        return this.fid;
    }

    public void setFid(Long l) {
        this.fid = l;
    }
}

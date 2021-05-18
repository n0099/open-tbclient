package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.CommonReq;
import tbclient.Hottopic.DataReq;
import tbclient.Hottopic.HottopicReqIdl;
/* loaded from: classes4.dex */
public class RequestHotTopicMessage extends NetMessage {
    public int call_from;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f16918common;
    public Long fid;
    public String first_dir;
    public Integer q_type;
    public Double scr_dip;
    public Integer scr_h;
    public Integer scr_w;
    public String second_dir;
    public Integer sort_type;
    public Long topic_id;
    public String topic_name;
    public long topic_tid;

    public RequestHotTopicMessage() {
        super(CmdConfigHttp.CMD_HOT_TOPIC, 303050);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.f69415common = getCommon();
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
                w.a(builder, true);
            }
            HottopicReqIdl.Builder builder2 = new HottopicReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public int getCall_from() {
        return this.call_from;
    }

    public CommonReq getCommon() {
        return this.f16918common;
    }

    public Long getFid() {
        return this.fid;
    }

    public String getFirst_dir() {
        return this.first_dir;
    }

    public Integer getQType() {
        return this.q_type;
    }

    public Integer getScrW() {
        return this.scr_w;
    }

    public String getSecond_dir() {
        return this.second_dir;
    }

    public Integer getSort_type() {
        return this.sort_type;
    }

    public Double getSrcDip() {
        return this.scr_dip;
    }

    public Integer getSrcH() {
        return this.scr_h;
    }

    public Long getTopicId() {
        return this.topic_id;
    }

    public String getTopicName() {
        return this.topic_name;
    }

    public long getTopic_tid() {
        return this.topic_tid;
    }

    public void setCall_from(int i2) {
        this.call_from = i2;
    }

    public void setCommon(CommonReq commonReq) {
        this.f16918common = commonReq;
    }

    public void setFid(Long l) {
        this.fid = l;
    }

    public void setFirst_dir(String str) {
        this.first_dir = str;
    }

    public void setQType(Integer num) {
        this.q_type = num;
    }

    public void setScrH(Integer num) {
        this.scr_h = num;
    }

    public void setScrW(Integer num) {
        this.scr_w = num;
    }

    public void setSecond_dir(String str) {
        this.second_dir = str;
    }

    public void setSort_type(Integer num) {
        this.sort_type = num;
    }

    public void setSrcDip(Double d2) {
        this.scr_dip = d2;
    }

    public void setTopicId(Long l) {
        this.topic_id = l;
    }

    public void setTopicName(String str) {
        this.topic_name = str;
    }

    public void setTopic_tid(long j) {
        this.topic_tid = j;
    }
}

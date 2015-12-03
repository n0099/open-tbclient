package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.i;
import tbclient.CommonReq;
import tbclient.UserPk.DataReq;
import tbclient.UserPk.UserPkReqIdl;
/* loaded from: classes.dex */
public class RequestBlessMessage extends NetMessage {
    private int click_type;
    private CommonReq common;
    private Long pk_id;
    private int pk_index;
    private int pk_type;
    private Long topic_id;
    private long user_pk_id;

    public RequestBlessMessage() {
        super(CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
    }

    public CommonReq getCommon() {
        return this.common;
    }

    public void setCommon(CommonReq commonReq) {
        this.common = commonReq;
    }

    public Long getPkId() {
        return this.pk_id;
    }

    public void setPkId(Long l) {
        this.pk_id = l;
    }

    public Long getTopicId() {
        return this.topic_id;
    }

    public void setTopicId(Long l) {
        this.topic_id = l;
    }

    public int getPkIndex() {
        return this.pk_index;
    }

    public void setPkIndex(int i) {
        this.pk_index = i;
    }

    public int getClickType() {
        return this.click_type;
    }

    public void setClickType(int i) {
        this.click_type = i;
    }

    public int getPkType() {
        return this.pk_type;
    }

    public void setPkType(int i) {
        this.pk_type = i;
    }

    public long getUserPkId() {
        return this.user_pk_id;
    }

    public void setUserPkId(long j) {
        this.user_pk_id = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.common = getCommon();
            builder.pk_id = getPkId();
            builder.topic_id = getTopicId();
            builder.pk_index = Integer.valueOf(getPkIndex());
            builder.click_type = Integer.valueOf(getClickType());
            builder.pk_type = Integer.valueOf(getPkType());
            builder.user_pk_id = Long.valueOf(getUserPkId());
            if (z) {
                i.a(builder, true);
            }
            UserPkReqIdl.Builder builder2 = new UserPkReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}

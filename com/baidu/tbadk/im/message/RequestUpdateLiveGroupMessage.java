package com.baidu.tbadk.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.UpdateLiveGroup.DataReq;
import protobuf.UpdateLiveGroup.UpdateLiveGroupReqIdl;
/* loaded from: classes.dex */
public class RequestUpdateLiveGroupMessage extends TbSocketMessage {
    private int gid;
    private String intro;
    private String name;
    private String portrait;

    public RequestUpdateLiveGroupMessage() {
        super(107102);
    }

    public String getPid() {
        return this.portrait;
    }

    public void setPid(String str) {
        this.portrait = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public int getGid() {
        return this.gid;
    }

    public void setGid(int i) {
        this.gid = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(this.gid);
        builder.intro = this.intro;
        builder.name = this.name;
        builder.portrait = this.portrait;
        UpdateLiveGroupReqIdl.Builder builder2 = new UpdateLiveGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

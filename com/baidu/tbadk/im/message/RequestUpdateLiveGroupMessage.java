package com.baidu.tbadk.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import java.util.ArrayList;
import java.util.List;
import protobuf.UpdateLiveGroup.DataReq;
import protobuf.UpdateLiveGroup.UpdateLiveGroupReqIdl;
/* loaded from: classes.dex */
public class RequestUpdateLiveGroupMessage extends TbSocketMessage {
    private String announce;
    private List<String> backgroundIds;
    private int gid;
    private int labelId;
    private String liveIntro;
    private String liveName;
    private String portraitId;

    public RequestUpdateLiveGroupMessage() {
        super(107102);
        this.backgroundIds = new ArrayList();
    }

    public void setPid(String str) {
        this.portraitId = str;
    }

    public void setName(String str) {
        this.liveName = str;
    }

    public void setAnnoucement(String str) {
        this.announce = str;
    }

    public void setGid(int i) {
        this.gid = i;
    }

    public void setBackgroundIds(List<String> list) {
        this.backgroundIds = list;
    }

    public void setLabel(int i) {
        this.labelId = i;
    }

    public void setLiveIntro(String str) {
        this.liveIntro = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(this.gid);
        builder.intro = this.announce;
        builder.name = this.liveName;
        builder.portrait = this.portraitId;
        builder.backgrounds = this.backgroundIds;
        builder.labelId = Integer.valueOf(this.labelId);
        builder.signature = this.liveIntro;
        UpdateLiveGroupReqIdl.Builder builder2 = new UpdateLiveGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

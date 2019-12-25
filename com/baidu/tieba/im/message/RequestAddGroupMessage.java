package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.AddGroup.AddGroupReqIdl;
import protobuf.AddGroup.DataReq;
/* loaded from: classes5.dex */
public class RequestAddGroupMessage extends TbSocketMessage {
    private String business;
    private int flag;
    private int forumId;
    private int groupType;
    private String intro;
    private String lat;
    private String lng;
    private String name;
    private String page_from_dim;
    private String portrait;
    private String position;

    public RequestAddGroupMessage() {
        super(CmdConfigSocket.CMD_ADD_GROUP);
        this.page_from_dim = "";
    }

    public int getForumId() {
        return this.forumId;
    }

    public void setForumId(int i) {
        this.forumId = i;
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

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getBusiness() {
        return this.business;
    }

    public void setBusiness(String str) {
        this.business = str;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public void setGroupType(int i) {
        this.groupType = i;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public String getPage_from_dim() {
        return this.page_from_dim;
    }

    public void setPage_from_dim(String str) {
        this.page_from_dim = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.name = getName();
        builder.intro = getIntro();
        builder.portrait = getPortrait();
        builder.position = getPosition();
        builder.lng = Double.valueOf(com.baidu.adp.lib.f.b.toDouble(getLng(), 0.0d));
        builder.groupType = Integer.valueOf(getGroupType());
        builder.flag = Integer.valueOf(getFlag());
        builder.lat = Double.valueOf(com.baidu.adp.lib.f.b.toDouble(getLat(), 0.0d));
        builder.forumId = Integer.valueOf(getForumId());
        AddGroupReqIdl.Builder builder2 = new AddGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

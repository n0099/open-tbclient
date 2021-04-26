package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import d.a.c.e.m.b;
import protobuf.AddGroup.AddGroupReqIdl;
import protobuf.AddGroup.DataReq;
/* loaded from: classes4.dex */
public class RequestAddGroupMessage extends TbSocketMessage {
    public String business;
    public int flag;
    public int forumId;
    public int groupType;
    public String intro;
    public String lat;
    public String lng;
    public String name;
    public String page_from_dim;
    public String portrait;
    public String position;

    public RequestAddGroupMessage() {
        super(103101);
        this.page_from_dim = "";
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.name = getName();
        builder.intro = getIntro();
        builder.portrait = getPortrait();
        builder.position = getPosition();
        builder.lng = Double.valueOf(b.b(getLng(), 0.0d));
        builder.groupType = Integer.valueOf(getGroupType());
        builder.flag = Integer.valueOf(getFlag());
        builder.lat = Double.valueOf(b.b(getLat(), 0.0d));
        builder.forumId = Integer.valueOf(getForumId());
        AddGroupReqIdl.Builder builder2 = new AddGroupReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getBusiness() {
        return this.business;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getForumId() {
        return this.forumId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public String getName() {
        return this.name;
    }

    public String getPage_from_dim() {
        return this.page_from_dim;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getPosition() {
        return this.position;
    }

    public void setBusiness(String str) {
        this.business = str;
    }

    public void setFlag(int i2) {
        this.flag = i2;
    }

    public void setForumId(int i2) {
        this.forumId = i2;
    }

    public void setGroupType(int i2) {
        this.groupType = i2;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPage_from_dim(String str) {
        this.page_from_dim = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPosition(String str) {
        this.position = str;
    }
}

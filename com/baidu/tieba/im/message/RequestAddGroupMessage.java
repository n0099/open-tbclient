package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestAddGroupMessage extends Message {
    private static final long serialVersionUID = 5970126981799423191L;
    private String business;
    private int flag;
    private int forumId;
    private int groupType;
    private String intro;
    private String lat;
    private String lng;
    private String name;
    private String page_from_dim = "";
    private String portrait;
    private String position;

    public RequestAddGroupMessage() {
        setCmd(103101);
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
}

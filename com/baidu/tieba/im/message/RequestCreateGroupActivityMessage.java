package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.AddGroupActivity.AddGroupActivityReqIdl;
import protobuf.AddGroupActivity.DataReq;
/* loaded from: classes.dex */
public class RequestCreateGroupActivityMessage extends TbSocketMessage {
    private int activityId;
    private int commitType;
    private String gActivityArea;
    private String gActivityContent;
    private long gActivityTime;
    private String gActivityTitle;
    private int groupId;

    public RequestCreateGroupActivityMessage() {
        super(103120);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public int getActivityId() {
        return this.activityId;
    }

    public void setActivityId(int i) {
        this.activityId = i;
    }

    public String getgActivityTitle() {
        return this.gActivityTitle;
    }

    public void setgActivityTitle(String str) {
        this.gActivityTitle = str;
    }

    public String getgActivityContent() {
        return this.gActivityContent;
    }

    public void setgActivityContent(String str) {
        this.gActivityContent = str;
    }

    public String getgActivityArea() {
        return this.gActivityArea;
    }

    public void setgActivityArea(String str) {
        this.gActivityArea = str;
    }

    public long getgActivityTime() {
        return this.gActivityTime;
    }

    public void setgActivityTime(long j) {
        this.gActivityTime = j;
    }

    public int getCommitType() {
        return this.commitType;
    }

    public void setCommitType(int i) {
        this.commitType = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.activityId = Integer.valueOf(getActivityId());
        builder.commitType = Integer.valueOf(getCommitType());
        builder.gActivityArea = getgActivityArea();
        builder.gActivityContent = getgActivityContent();
        builder.gActivityTime = Long.valueOf(getgActivityTime());
        builder.gActivityTitle = getgActivityTitle();
        builder.groupId = Integer.valueOf(getGroupId());
        AddGroupActivityReqIdl.Builder builder2 = new AddGroupActivityReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}

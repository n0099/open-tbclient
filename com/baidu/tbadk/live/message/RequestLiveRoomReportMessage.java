package com.baidu.tbadk.live.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.LiveReport.DataReq;
import protobuf.LiveReport.LiveReportReqIdl;
/* loaded from: classes.dex */
public class RequestLiveRoomReportMessage extends TbSocketMessage {
    private String background;
    private int create_time;
    private long create_uid;
    private String create_uname;
    private long forum_id;
    private String forum_name;
    private int group_id;
    private String group_name;
    private int group_type;
    private String intro;
    private String play_url;
    private String portrait;
    private int report_type;
    private long thread_id;

    public RequestLiveRoomReportMessage() {
        super(107111);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.report_type = Integer.valueOf(this.report_type);
        builder.group_id = Integer.valueOf(this.group_id);
        builder.group_name = this.group_name;
        builder.forum_id = Long.valueOf(this.forum_id);
        builder.forum_name = this.forum_name;
        builder.group_type = Integer.valueOf(this.group_type);
        builder.thread_id = Long.valueOf(this.thread_id);
        builder.create_uid = Long.valueOf(this.create_uid);
        builder.create_uname = this.create_uname;
        builder.create_time = Integer.valueOf(this.create_time);
        builder.intro = this.intro;
        builder.portrait = this.portrait;
        builder.background = this.background;
        builder.play_url = this.play_url;
        LiveReportReqIdl.Builder builder2 = new LiveReportReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getReport_type() {
        return this.report_type;
    }

    public void setReportType(int i) {
        this.report_type = i;
    }

    public int getGroupId() {
        return this.group_id;
    }

    public void setGroupId(int i) {
        this.group_id = i;
    }

    public String getGroupName() {
        return this.group_name;
    }

    public void setGroupName(String str) {
        this.group_name = str;
    }

    public String getForumName() {
        return this.forum_name;
    }

    public void setForumName(String str) {
        this.forum_name = str;
    }

    public long getForumId() {
        return this.forum_id;
    }

    public void setForumId(long j) {
        this.forum_id = j;
    }

    public int getGroupType() {
        return this.group_type;
    }

    public void setGroupType(int i) {
        this.group_type = i;
    }

    public long getThreadId() {
        return this.thread_id;
    }

    public void setThreadId(long j) {
        this.thread_id = j;
    }

    public long getCreateId() {
        return this.create_uid;
    }

    public void setCreateId(long j) {
        this.create_uid = j;
    }

    public String getCreateUname() {
        return this.create_uname;
    }

    public void setCreateUname(String str) {
        this.create_uname = str;
    }

    public int getCreateTime() {
        return this.create_time;
    }

    public void setCreateTime(int i) {
        this.create_time = i;
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

    public String getBackground() {
        return this.background;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public String getPlayUrl() {
        return this.play_url;
    }

    public void setPlayUrl(String str) {
        this.play_url = str;
    }
}

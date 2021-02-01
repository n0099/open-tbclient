package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    private String content;
    private String ctr;
    private int jvj;
    private long kFE;
    private int kFF;
    private long kFG;
    private RecommendForumInfo kFH;
    private ThreadInfo kFI;
    private String picUrl;
    private int pv;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public long cVV() {
        return this.kFE;
    }

    public int cVW() {
        return this.kFF;
    }

    public int cVX() {
        return this.pv;
    }

    public String cVY() {
        return this.ctr;
    }

    public long cVZ() {
        return this.kFG;
    }

    public int cHa() {
        return this.jvj;
    }

    public RecommendForumInfo cWa() {
        return this.kFH;
    }

    public ThreadInfo cWb() {
        return this.kFI;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.kFG = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.kFE = broadcastInfo.publish_time.intValue();
            this.kFF = broadcastInfo.pushuser_cnt.intValue();
            this.kFH = broadcastInfo.forum_info;
            this.kFI = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.pv = broadcastInfo.pv.intValue();
            this.jvj = broadcastInfo.audit_status.intValue();
        }
    }
}

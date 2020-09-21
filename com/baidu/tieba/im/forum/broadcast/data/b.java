package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes25.dex */
public class b {
    private String content;
    private String ctr;
    private long jvH;
    private int jvI;
    private long jvJ;
    private int jvK;
    private int jvL;
    private RecommendForumInfo jvM;
    private ThreadInfo jvN;
    private String picUrl;
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

    public long cIg() {
        return this.jvH;
    }

    public int cIh() {
        return this.jvI;
    }

    public int cIi() {
        return this.jvK;
    }

    public String cIj() {
        return this.ctr;
    }

    public long cIk() {
        return this.jvJ;
    }

    public int cIl() {
        return this.jvL;
    }

    public RecommendForumInfo cIm() {
        return this.jvM;
    }

    public ThreadInfo cIn() {
        return this.jvN;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.jvJ = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.jvH = broadcastInfo.publish_time.intValue();
            this.jvI = broadcastInfo.pushuser_cnt.intValue();
            this.jvM = broadcastInfo.forum_info;
            this.jvN = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.jvK = broadcastInfo.pv.intValue();
            this.jvL = broadcastInfo.audit_status.intValue();
        }
    }
}

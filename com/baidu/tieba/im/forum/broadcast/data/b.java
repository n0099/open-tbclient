package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    private String content;
    private String ctr;
    private int jvx;
    private long kFS;
    private int kFT;
    private long kFU;
    private RecommendForumInfo kFV;
    private ThreadInfo kFW;
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

    public long cWc() {
        return this.kFS;
    }

    public int cWd() {
        return this.kFT;
    }

    public int cWe() {
        return this.pv;
    }

    public String cWf() {
        return this.ctr;
    }

    public long cWg() {
        return this.kFU;
    }

    public int cHh() {
        return this.jvx;
    }

    public RecommendForumInfo cWh() {
        return this.kFV;
    }

    public ThreadInfo cWi() {
        return this.kFW;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.kFU = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.kFS = broadcastInfo.publish_time.intValue();
            this.kFT = broadcastInfo.pushuser_cnt.intValue();
            this.kFV = broadcastInfo.forum_info;
            this.kFW = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.pv = broadcastInfo.pv.intValue();
            this.jvx = broadcastInfo.audit_status.intValue();
        }
    }
}

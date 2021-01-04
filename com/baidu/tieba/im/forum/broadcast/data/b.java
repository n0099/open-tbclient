package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    private String content;
    private String ctr;
    private int juj;
    private long kCd;
    private int kCe;
    private long kCf;
    private RecommendForumInfo kCg;
    private ThreadInfo kCh;
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

    public long cXO() {
        return this.kCd;
    }

    public int cXP() {
        return this.kCe;
    }

    public int cXQ() {
        return this.pv;
    }

    public String cXR() {
        return this.ctr;
    }

    public long cXS() {
        return this.kCf;
    }

    public int cJE() {
        return this.juj;
    }

    public RecommendForumInfo cXT() {
        return this.kCg;
    }

    public ThreadInfo cXU() {
        return this.kCh;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.kCf = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.kCd = broadcastInfo.publish_time.intValue();
            this.kCe = broadcastInfo.pushuser_cnt.intValue();
            this.kCg = broadcastInfo.forum_info;
            this.kCh = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.pv = broadcastInfo.pv.intValue();
            this.juj = broadcastInfo.audit_status.intValue();
        }
    }
}

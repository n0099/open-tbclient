package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes26.dex */
public class b {
    private String content;
    private String ctr;
    private long kcZ;
    private int kda;
    private long kdb;
    private int kdc;
    private int kdd;
    private RecommendForumInfo kde;
    private ThreadInfo kdf;
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

    public long cRx() {
        return this.kcZ;
    }

    public int cRy() {
        return this.kda;
    }

    public int cRz() {
        return this.kdc;
    }

    public String cRA() {
        return this.ctr;
    }

    public long cRB() {
        return this.kdb;
    }

    public int cRC() {
        return this.kdd;
    }

    public RecommendForumInfo cRD() {
        return this.kde;
    }

    public ThreadInfo cRE() {
        return this.kdf;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.kdb = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.kcZ = broadcastInfo.publish_time.intValue();
            this.kda = broadcastInfo.pushuser_cnt.intValue();
            this.kde = broadcastInfo.forum_info;
            this.kdf = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.kdc = broadcastInfo.pv.intValue();
            this.kdd = broadcastInfo.audit_status.intValue();
        }
    }
}

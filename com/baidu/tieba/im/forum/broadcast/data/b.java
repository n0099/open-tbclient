package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes26.dex */
public class b {
    private String content;
    private String ctr;
    private int jhJ;
    private long kro;
    private int krp;
    private long krq;
    private RecommendForumInfo krr;
    private ThreadInfo krs;
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

    public long cWs() {
        return this.kro;
    }

    public int cWt() {
        return this.krp;
    }

    public int cWu() {
        return this.pv;
    }

    public String cWv() {
        return this.ctr;
    }

    public long cWw() {
        return this.krq;
    }

    public int cGF() {
        return this.jhJ;
    }

    public RecommendForumInfo cWx() {
        return this.krr;
    }

    public ThreadInfo cWy() {
        return this.krs;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.krq = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.kro = broadcastInfo.publish_time.intValue();
            this.krp = broadcastInfo.pushuser_cnt.intValue();
            this.krr = broadcastInfo.forum_info;
            this.krs = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.pv = broadcastInfo.pv.intValue();
            this.jhJ = broadcastInfo.audit_status.intValue();
        }
    }
}

package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes20.dex */
public class b {
    private String content;
    private String ctr;
    private long jmY;
    private int jmZ;
    private long jna;
    private int jnb;
    private int jnc;
    private RecommendForumInfo jnd;
    private ThreadInfo jne;
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

    public long cEz() {
        return this.jmY;
    }

    public int cEA() {
        return this.jmZ;
    }

    public int cEB() {
        return this.jnb;
    }

    public String cEC() {
        return this.ctr;
    }

    public long cED() {
        return this.jna;
    }

    public int cEE() {
        return this.jnc;
    }

    public RecommendForumInfo cEF() {
        return this.jnd;
    }

    public ThreadInfo cEG() {
        return this.jne;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.jna = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.jmY = broadcastInfo.publish_time.intValue();
            this.jmZ = broadcastInfo.pushuser_cnt.intValue();
            this.jnd = broadcastInfo.forum_info;
            this.jne = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.jnb = broadcastInfo.pv.intValue();
            this.jnc = broadcastInfo.audit_status.intValue();
        }
    }
}

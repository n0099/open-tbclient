package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes20.dex */
public class b {
    private String content;
    private String ctr;
    private long jne;
    private int jnf;
    private long jng;
    private int jnh;
    private int jni;
    private RecommendForumInfo jnj;
    private ThreadInfo jnk;
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

    public long cEA() {
        return this.jne;
    }

    public int cEB() {
        return this.jnf;
    }

    public int cEC() {
        return this.jnh;
    }

    public String cED() {
        return this.ctr;
    }

    public long cEE() {
        return this.jng;
    }

    public int cEF() {
        return this.jni;
    }

    public RecommendForumInfo cEG() {
        return this.jnj;
    }

    public ThreadInfo cEH() {
        return this.jnk;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.jng = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.jne = broadcastInfo.publish_time.intValue();
            this.jnf = broadcastInfo.pushuser_cnt.intValue();
            this.jnj = broadcastInfo.forum_info;
            this.jnk = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.jnh = broadcastInfo.pv.intValue();
            this.jni = broadcastInfo.audit_status.intValue();
        }
    }
}

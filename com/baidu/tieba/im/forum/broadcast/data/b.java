package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes26.dex */
public class b {
    private String content;
    private String ctr;
    private int jhH;
    private long krm;
    private int krn;
    private long kro;
    private RecommendForumInfo krp;
    private ThreadInfo krq;
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

    public long cWr() {
        return this.krm;
    }

    public int cWs() {
        return this.krn;
    }

    public int cWt() {
        return this.pv;
    }

    public String cWu() {
        return this.ctr;
    }

    public long cWv() {
        return this.kro;
    }

    public int cGE() {
        return this.jhH;
    }

    public RecommendForumInfo cWw() {
        return this.krp;
    }

    public ThreadInfo cWx() {
        return this.krq;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.kro = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.krm = broadcastInfo.publish_time.intValue();
            this.krn = broadcastInfo.pushuser_cnt.intValue();
            this.krp = broadcastInfo.forum_info;
            this.krq = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.pv = broadcastInfo.pv.intValue();
            this.jhH = broadcastInfo.audit_status.intValue();
        }
    }
}

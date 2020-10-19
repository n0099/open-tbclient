package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes26.dex */
public class b {
    private String content;
    private String ctr;
    private long jKE;
    private int jKF;
    private long jKG;
    private int jKH;
    private int jKI;
    private RecommendForumInfo jKJ;
    private ThreadInfo jKK;
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

    public long cLP() {
        return this.jKE;
    }

    public int cLQ() {
        return this.jKF;
    }

    public int cLR() {
        return this.jKH;
    }

    public String cLS() {
        return this.ctr;
    }

    public long cLT() {
        return this.jKG;
    }

    public int cLU() {
        return this.jKI;
    }

    public RecommendForumInfo cLV() {
        return this.jKJ;
    }

    public ThreadInfo cLW() {
        return this.jKK;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.jKG = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.jKE = broadcastInfo.publish_time.intValue();
            this.jKF = broadcastInfo.pushuser_cnt.intValue();
            this.jKJ = broadcastInfo.forum_info;
            this.jKK = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.jKH = broadcastInfo.pv.intValue();
            this.jKI = broadcastInfo.audit_status.intValue();
        }
    }
}

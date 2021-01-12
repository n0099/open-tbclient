package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class b {
    private String content;
    private String ctr;
    private int jpD;
    private long kxA;
    private RecommendForumInfo kxB;
    private ThreadInfo kxC;
    private long kxy;
    private int kxz;
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

    public long cTX() {
        return this.kxy;
    }

    public int cTY() {
        return this.kxz;
    }

    public int cTZ() {
        return this.pv;
    }

    public String cUa() {
        return this.ctr;
    }

    public long cUb() {
        return this.kxA;
    }

    public int cFN() {
        return this.jpD;
    }

    public RecommendForumInfo cUc() {
        return this.kxB;
    }

    public ThreadInfo cUd() {
        return this.kxC;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.kxA = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.kxy = broadcastInfo.publish_time.intValue();
            this.kxz = broadcastInfo.pushuser_cnt.intValue();
            this.kxB = broadcastInfo.forum_info;
            this.kxC = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.pv = broadcastInfo.pv.intValue();
            this.jpD = broadcastInfo.audit_status.intValue();
        }
    }
}

package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes20.dex */
public class b {
    private String content;
    private String ctr;
    private long iXZ;
    private int iYa;
    private long iYb;
    private int iYc;
    private RecommendForumInfo iYd;
    private ThreadInfo iYe;
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

    public long ctI() {
        return this.iXZ;
    }

    public int ctJ() {
        return this.iYa;
    }

    public int ctK() {
        return this.pv;
    }

    public String ctL() {
        return this.ctr;
    }

    public long ctM() {
        return this.iYb;
    }

    public int ctN() {
        return this.iYc;
    }

    public RecommendForumInfo ctO() {
        return this.iYd;
    }

    public ThreadInfo ctP() {
        return this.iYe;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.iYb = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.iXZ = broadcastInfo.publish_time.intValue();
            this.iYa = broadcastInfo.pushuser_cnt.intValue();
            this.iYd = broadcastInfo.forum_info;
            this.iYe = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.pv = broadcastInfo.pv.intValue();
            this.iYc = broadcastInfo.audit_status.intValue();
        }
    }
}

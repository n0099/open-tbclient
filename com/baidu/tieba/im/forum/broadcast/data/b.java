package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes20.dex */
public class b {
    private String content;
    private String ctr;
    private long iXX;
    private int iXY;
    private long iXZ;
    private int iYa;
    private RecommendForumInfo iYb;
    private ThreadInfo iYc;
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
        return this.iXX;
    }

    public int ctJ() {
        return this.iXY;
    }

    public int ctK() {
        return this.pv;
    }

    public String ctL() {
        return this.ctr;
    }

    public long ctM() {
        return this.iXZ;
    }

    public int ctN() {
        return this.iYa;
    }

    public RecommendForumInfo ctO() {
        return this.iYb;
    }

    public ThreadInfo ctP() {
        return this.iYc;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.iXZ = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.iXX = broadcastInfo.publish_time.intValue();
            this.iXY = broadcastInfo.pushuser_cnt.intValue();
            this.iYb = broadcastInfo.forum_info;
            this.iYc = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.pv = broadcastInfo.pv.intValue();
            this.iYa = broadcastInfo.audit_status.intValue();
        }
    }
}

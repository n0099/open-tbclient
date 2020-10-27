package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes26.dex */
public class b {
    private String content;
    private String ctr;
    private long jXc;
    private int jXd;
    private long jXe;
    private int jXf;
    private int jXg;
    private RecommendForumInfo jXh;
    private ThreadInfo jXi;
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

    public long cOW() {
        return this.jXc;
    }

    public int cOX() {
        return this.jXd;
    }

    public int cOY() {
        return this.jXf;
    }

    public String cOZ() {
        return this.ctr;
    }

    public long cPa() {
        return this.jXe;
    }

    public int cPb() {
        return this.jXg;
    }

    public RecommendForumInfo cPc() {
        return this.jXh;
    }

    public ThreadInfo cPd() {
        return this.jXi;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.jXe = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.jXc = broadcastInfo.publish_time.intValue();
            this.jXd = broadcastInfo.pushuser_cnt.intValue();
            this.jXh = broadcastInfo.forum_info;
            this.jXi = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.jXf = broadcastInfo.pv.intValue();
            this.jXg = broadcastInfo.audit_status.intValue();
        }
    }
}

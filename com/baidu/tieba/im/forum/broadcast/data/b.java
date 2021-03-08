package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class b {
    private String content;
    private String ctr;
    private int jxg;
    private long kHU;
    private int kHV;
    private long kHW;
    private RecommendForumInfo kHX;
    private ThreadInfo kHY;
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

    public long cWj() {
        return this.kHU;
    }

    public int cWk() {
        return this.kHV;
    }

    public int cWl() {
        return this.pv;
    }

    public String cWm() {
        return this.ctr;
    }

    public long cWn() {
        return this.kHW;
    }

    public int cHn() {
        return this.jxg;
    }

    public RecommendForumInfo cWo() {
        return this.kHX;
    }

    public ThreadInfo cWp() {
        return this.kHY;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.kHW = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.kHU = broadcastInfo.publish_time.intValue();
            this.kHV = broadcastInfo.pushuser_cnt.intValue();
            this.kHX = broadcastInfo.forum_info;
            this.kHY = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.pv = broadcastInfo.pv.intValue();
            this.jxg = broadcastInfo.audit_status.intValue();
        }
    }
}

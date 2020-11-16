package com.baidu.tieba.im.forum.broadcast.data;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes25.dex */
public class b {
    private String content;
    private String ctr;
    private long kdJ;
    private int kdK;
    private long kdL;
    private int kdM;
    private int kdN;
    private RecommendForumInfo kdO;
    private ThreadInfo kdP;
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

    public long cRd() {
        return this.kdJ;
    }

    public int cRe() {
        return this.kdK;
    }

    public int cRf() {
        return this.kdM;
    }

    public String cRg() {
        return this.ctr;
    }

    public long cRh() {
        return this.kdL;
    }

    public int cRi() {
        return this.kdN;
    }

    public RecommendForumInfo cRj() {
        return this.kdO;
    }

    public ThreadInfo cRk() {
        return this.kdP;
    }

    public void a(BroadcastInfo broadcastInfo) {
        if (broadcastInfo != null) {
            this.kdL = broadcastInfo.bcast_id.longValue();
            this.title = broadcastInfo.title;
            this.content = broadcastInfo.content;
            this.picUrl = broadcastInfo.pic_url;
            this.kdJ = broadcastInfo.publish_time.intValue();
            this.kdK = broadcastInfo.pushuser_cnt.intValue();
            this.kdO = broadcastInfo.forum_info;
            this.kdP = broadcastInfo.thread_infos;
            this.ctr = broadcastInfo.ctr;
            this.kdM = broadcastInfo.pv.intValue();
            this.kdN = broadcastInfo.audit_status.intValue();
        }
    }
}

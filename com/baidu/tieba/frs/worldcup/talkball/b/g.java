package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes2.dex */
public class g {
    private String dFT;
    private String dFU;
    private String dFV;
    private String dFW;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.dFT = videoCard.cover_image;
            this.dFU = videoCard.video_duration;
            this.dFV = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.dFW = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aAv() {
        return this.dFT;
    }

    public String aAw() {
        return this.dFU;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aAx() {
        return this.dFW;
    }
}

package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class g {
    private String ejh;
    private String eji;
    private String ejj;
    private String ejk;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.ejh = videoCard.cover_image;
            this.eji = videoCard.video_duration;
            this.ejj = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.ejk = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aIx() {
        return this.ejh;
    }

    public String aIy() {
        return this.eji;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aIz() {
        return this.ejk;
    }
}

package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class g {
    private String ebj;
    private String ebk;
    private String ebl;
    private String ebm;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.ebj = videoCard.cover_image;
            this.ebk = videoCard.video_duration;
            this.ebl = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.ebm = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aHn() {
        return this.ebj;
    }

    public String aHo() {
        return this.ebk;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aHp() {
        return this.ebm;
    }
}

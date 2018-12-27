package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class g {
    private String elX;
    private String elY;
    private String elZ;
    private String ema;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.elX = videoCard.cover_image;
            this.elY = videoCard.video_duration;
            this.elZ = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.ema = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aJm() {
        return this.elX;
    }

    public String aJn() {
        return this.elY;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aJo() {
        return this.ema;
    }
}

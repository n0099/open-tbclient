package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class g {
    private String ecE;
    private String ecF;
    private String ecG;
    private String ecH;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.ecE = videoCard.cover_image;
            this.ecF = videoCard.video_duration;
            this.ecG = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.ecH = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aGL() {
        return this.ecE;
    }

    public String aGM() {
        return this.ecF;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aGN() {
        return this.ecH;
    }
}

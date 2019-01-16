package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class g {
    private String emD;
    private String emE;
    private String emF;
    private String emG;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.emD = videoCard.cover_image;
            this.emE = videoCard.video_duration;
            this.emF = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.emG = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aJK() {
        return this.emD;
    }

    public String aJL() {
        return this.emE;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aJM() {
        return this.emG;
    }
}

package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class g {
    private String emE;
    private String emF;
    private String emG;
    private String emH;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.emE = videoCard.cover_image;
            this.emF = videoCard.video_duration;
            this.emG = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.emH = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aJK() {
        return this.emE;
    }

    public String aJL() {
        return this.emF;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aJM() {
        return this.emH;
    }
}

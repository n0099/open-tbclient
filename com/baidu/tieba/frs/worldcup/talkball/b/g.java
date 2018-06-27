package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes2.dex */
public class g {
    private String dJm;
    private String dJn;
    private String dJo;
    private String dJp;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.dJm = videoCard.cover_image;
            this.dJn = videoCard.video_duration;
            this.dJo = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.dJp = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aBc() {
        return this.dJm;
    }

    public String aBd() {
        return this.dJn;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aBe() {
        return this.dJp;
    }
}

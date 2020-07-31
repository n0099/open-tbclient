package com.baidu.tieba.enterForum.b.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes16.dex */
public class a {
    private long hhP;
    private long hhQ;
    private List<String> hhR;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.hhP = forumPopupInfo.mem_count_static.intValue();
            this.hhQ = forumPopupInfo.thread_count_static.intValue();
            this.hhR = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> bUP() {
        return this.hhR;
    }

    public long bUQ() {
        return this.hhP;
    }

    public int bUR() {
        return this.mForumId;
    }

    public long bUS() {
        return this.hhQ;
    }

    public String bUT() {
        return this.mForumName;
    }
}

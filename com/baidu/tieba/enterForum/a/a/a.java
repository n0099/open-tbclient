package com.baidu.tieba.enterForum.a.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes2.dex */
public class a {
    private long iHi;
    private long iHj;
    private List<String> iHk;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.iHi = forumPopupInfo.mem_count_static.intValue();
            this.iHj = forumPopupInfo.thread_count_static.intValue();
            this.iHk = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> cyc() {
        return this.iHk;
    }

    public long cyd() {
        return this.iHi;
    }

    public int cye() {
        return this.mForumId;
    }

    public long cyf() {
        return this.iHj;
    }

    public String cyg() {
        return this.mForumName;
    }
}

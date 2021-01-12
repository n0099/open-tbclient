package com.baidu.tieba.enterForum.a.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes2.dex */
public class a {
    private long iCB;
    private long iCC;
    private List<String> iCD;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.iCB = forumPopupInfo.mem_count_static.intValue();
            this.iCC = forumPopupInfo.thread_count_static.intValue();
            this.iCD = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> cul() {
        return this.iCD;
    }

    public long cum() {
        return this.iCB;
    }

    public int cun() {
        return this.mForumId;
    }

    public long cuo() {
        return this.iCC;
    }

    public String cup() {
        return this.mForumName;
    }
}

package com.baidu.tieba.enterForum.a.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes2.dex */
public class a {
    private long iIl;
    private long iIm;
    private List<String> iIn;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.iIl = forumPopupInfo.mem_count_static.intValue();
            this.iIm = forumPopupInfo.thread_count_static.intValue();
            this.iIn = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> cvx() {
        return this.iIn;
    }

    public long cvy() {
        return this.iIl;
    }

    public int cvz() {
        return this.mForumId;
    }

    public long cvA() {
        return this.iIm;
    }

    public String cvB() {
        return this.mForumName;
    }
}

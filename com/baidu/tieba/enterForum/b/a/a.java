package com.baidu.tieba.enterForum.b.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes22.dex */
public class a {
    private long iuV;
    private long iuW;
    private List<String> iuX;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.iuV = forumPopupInfo.mem_count_static.intValue();
            this.iuW = forumPopupInfo.thread_count_static.intValue();
            this.iuX = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> cvj() {
        return this.iuX;
    }

    public long cvk() {
        return this.iuV;
    }

    public int cvl() {
        return this.mForumId;
    }

    public long cvm() {
        return this.iuW;
    }

    public String cvn() {
        return this.mForumName;
    }
}

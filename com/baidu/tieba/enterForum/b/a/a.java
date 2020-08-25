package com.baidu.tieba.enterForum.b.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes16.dex */
public class a {
    private long huI;
    private long huJ;
    private List<String> huK;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.huI = forumPopupInfo.mem_count_static.intValue();
            this.huJ = forumPopupInfo.thread_count_static.intValue();
            this.huK = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> ceX() {
        return this.huK;
    }

    public long ceY() {
        return this.huI;
    }

    public int ceZ() {
        return this.mForumId;
    }

    public long cfa() {
        return this.huJ;
    }

    public String cfb() {
        return this.mForumName;
    }
}

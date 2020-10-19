package com.baidu.tieba.enterForum.b.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes22.dex */
public class a {
    private long hQO;
    private long hQP;
    private List<String> hQQ;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.hQO = forumPopupInfo.mem_count_static.intValue();
            this.hQP = forumPopupInfo.thread_count_static.intValue();
            this.hQQ = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> clJ() {
        return this.hQQ;
    }

    public long clK() {
        return this.hQO;
    }

    public int clL() {
        return this.mForumId;
    }

    public long clM() {
        return this.hQP;
    }

    public String clN() {
        return this.mForumName;
    }
}

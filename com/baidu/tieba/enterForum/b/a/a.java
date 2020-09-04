package com.baidu.tieba.enterForum.b.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes16.dex */
public class a {
    private long huO;
    private long huP;
    private List<String> huQ;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.huO = forumPopupInfo.mem_count_static.intValue();
            this.huP = forumPopupInfo.thread_count_static.intValue();
            this.huQ = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> ceY() {
        return this.huQ;
    }

    public long ceZ() {
        return this.huO;
    }

    public int cfa() {
        return this.mForumId;
    }

    public long cfb() {
        return this.huP;
    }

    public String cfc() {
        return this.mForumName;
    }
}

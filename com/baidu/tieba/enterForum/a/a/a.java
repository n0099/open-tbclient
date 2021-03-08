package com.baidu.tieba.enterForum.a.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes2.dex */
public class a {
    private long iKi;
    private long iKj;
    private List<String> iKk;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.iKi = forumPopupInfo.mem_count_static.intValue();
            this.iKj = forumPopupInfo.thread_count_static.intValue();
            this.iKk = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> cvK() {
        return this.iKk;
    }

    public long cvL() {
        return this.iKi;
    }

    public int cvM() {
        return this.mForumId;
    }

    public long cvN() {
        return this.iKj;
    }

    public String cvO() {
        return this.mForumName;
    }
}

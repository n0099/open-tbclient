package com.baidu.tieba.enterForum.b.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes21.dex */
public class a {
    private long ika;
    private long ikb;
    private List<String> ikc;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.ika = forumPopupInfo.mem_count_static.intValue();
            this.ikb = forumPopupInfo.thread_count_static.intValue();
            this.ikc = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> cqU() {
        return this.ikc;
    }

    public long cqV() {
        return this.ika;
    }

    public int cqW() {
        return this.mForumId;
    }

    public long cqX() {
        return this.ikb;
    }

    public String cqY() {
        return this.mForumName;
    }
}

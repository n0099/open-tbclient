package com.baidu.tieba.enterForum.b.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes22.dex */
public class a {
    private long ijm;
    private long ijn;
    private List<String> ijo;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.ijm = forumPopupInfo.mem_count_static.intValue();
            this.ijn = forumPopupInfo.thread_count_static.intValue();
            this.ijo = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> crr() {
        return this.ijo;
    }

    public long crs() {
        return this.ijm;
    }

    public int crt() {
        return this.mForumId;
    }

    public long cru() {
        return this.ijn;
    }

    public String crv() {
        return this.mForumName;
    }
}

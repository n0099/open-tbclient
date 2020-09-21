package com.baidu.tieba.enterForum.b.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes21.dex */
public class a {
    private long hBT;
    private long hBU;
    private List<String> hBV;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.hBT = forumPopupInfo.mem_count_static.intValue();
            this.hBU = forumPopupInfo.thread_count_static.intValue();
            this.hBV = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> cin() {
        return this.hBV;
    }

    public long cio() {
        return this.hBT;
    }

    public int cip() {
        return this.mForumId;
    }

    public long ciq() {
        return this.hBU;
    }

    public String cir() {
        return this.mForumName;
    }
}

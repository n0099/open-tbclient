package com.baidu.tieba.enterForum.b.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes22.dex */
public class a {
    private long iuT;
    private long iuU;
    private List<String> iuV;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.iuT = forumPopupInfo.mem_count_static.intValue();
            this.iuU = forumPopupInfo.thread_count_static.intValue();
            this.iuV = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> cvi() {
        return this.iuV;
    }

    public long cvj() {
        return this.iuT;
    }

    public int cvk() {
        return this.mForumId;
    }

    public long cvl() {
        return this.iuU;
    }

    public String cvm() {
        return this.mForumName;
    }
}

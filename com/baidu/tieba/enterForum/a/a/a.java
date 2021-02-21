package com.baidu.tieba.enterForum.a.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes2.dex */
public class a {
    private long iIA;
    private List<String> iIB;
    private long iIz;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.iIz = forumPopupInfo.mem_count_static.intValue();
            this.iIA = forumPopupInfo.thread_count_static.intValue();
            this.iIB = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> cvE() {
        return this.iIB;
    }

    public long cvF() {
        return this.iIz;
    }

    public int cvG() {
        return this.mForumId;
    }

    public long cvH() {
        return this.iIA;
    }

    public String cvI() {
        return this.mForumName;
    }
}

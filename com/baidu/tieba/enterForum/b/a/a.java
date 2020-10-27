package com.baidu.tieba.enterForum.b.a;

import java.util.List;
import tbclient.ForumPopupInfo;
/* loaded from: classes22.dex */
public class a {
    private long idm;
    private long idn;
    private List<String> ido;
    private int mForumId;
    private String mForumName;

    public void a(ForumPopupInfo forumPopupInfo) {
        if (forumPopupInfo != null) {
            this.mForumId = forumPopupInfo.forum_id.intValue();
            this.idm = forumPopupInfo.mem_count_static.intValue();
            this.idn = forumPopupInfo.thread_count_static.intValue();
            this.ido = forumPopupInfo.forum_names;
            this.mForumName = forumPopupInfo.forum_name;
        }
    }

    public List<String> coQ() {
        return this.ido;
    }

    public long coR() {
        return this.idm;
    }

    public int coS() {
        return this.mForumId;
    }

    public long coT() {
        return this.idn;
    }

    public String coU() {
        return this.mForumName;
    }
}

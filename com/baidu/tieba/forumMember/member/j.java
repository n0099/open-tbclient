package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes10.dex */
public class j implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hjS = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private u hjT;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hjS;
    }

    public u bTA() {
        return this.hjT;
    }

    public void a(u uVar) {
        this.hjT = uVar;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}

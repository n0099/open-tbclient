package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes10.dex */
public class j implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hjH = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private u hjI;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hjH;
    }

    public u bTy() {
        return this.hjI;
    }

    public void a(u uVar) {
        this.hjI = uVar;
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

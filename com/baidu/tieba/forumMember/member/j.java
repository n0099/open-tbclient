package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes10.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gUP = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private u gUQ;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gUP;
    }

    public u bNe() {
        return this.gUQ;
    }

    public void a(u uVar) {
        this.gUQ = uVar;
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

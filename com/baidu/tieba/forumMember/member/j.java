package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes5.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fsJ = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private com.baidu.tieba.tbadkCore.t fsK;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fsJ;
    }

    public com.baidu.tieba.tbadkCore.t bls() {
        return this.fsK;
    }

    public void a(com.baidu.tieba.tbadkCore.t tVar) {
        this.fsK = tVar;
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

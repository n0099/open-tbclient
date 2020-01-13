package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes8.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId giL = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private com.baidu.tieba.tbadkCore.t giM;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return giL;
    }

    public com.baidu.tieba.tbadkCore.t bAT() {
        return this.giM;
    }

    public void a(com.baidu.tieba.tbadkCore.t tVar) {
        this.giM = tVar;
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

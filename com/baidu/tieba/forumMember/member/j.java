package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes5.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fre = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private com.baidu.tieba.tbadkCore.t frf;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fre;
    }

    public com.baidu.tieba.tbadkCore.t biw() {
        return this.frf;
    }

    public void a(com.baidu.tieba.tbadkCore.t tVar) {
        this.frf = tVar;
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

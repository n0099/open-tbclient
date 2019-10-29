package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes5.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId frW = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private com.baidu.tieba.tbadkCore.t frX;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return frW;
    }

    public com.baidu.tieba.tbadkCore.t biy() {
        return this.frX;
    }

    public void a(com.baidu.tieba.tbadkCore.t tVar) {
        this.frX = tVar;
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

package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes5.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eVn = BdUniqueId.gen();
    private com.baidu.tieba.tbadkCore.r eVo;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVn;
    }

    public com.baidu.tieba.tbadkCore.r bbc() {
        return this.eVo;
    }

    public void a(com.baidu.tieba.tbadkCore.r rVar) {
        this.eVo = rVar;
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

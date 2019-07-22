package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes5.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fqw = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private com.baidu.tieba.tbadkCore.r fqx;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fqw;
    }

    public com.baidu.tieba.tbadkCore.r bkA() {
        return this.fqx;
    }

    public void a(com.baidu.tieba.tbadkCore.r rVar) {
        this.fqx = rVar;
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

package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes5.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fly = BdUniqueId.gen();
    private com.baidu.tieba.tbadkCore.r flz;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fly;
    }

    public com.baidu.tieba.tbadkCore.r biy() {
        return this.flz;
    }

    public void a(com.baidu.tieba.tbadkCore.r rVar) {
        this.flz = rVar;
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

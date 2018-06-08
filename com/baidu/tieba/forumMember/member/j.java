package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes3.dex */
public class j implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dex = BdUniqueId.gen();
    private r dey;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dex;
    }

    public r asn() {
        return this.dey;
    }

    public void a(r rVar) {
        this.dey = rVar;
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

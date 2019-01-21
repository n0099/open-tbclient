package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes3.dex */
public class j implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dIm = BdUniqueId.gen();
    private r dIn;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dIm;
    }

    public r aAF() {
        return this.dIn;
    }

    public void a(r rVar) {
        this.dIn = rVar;
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

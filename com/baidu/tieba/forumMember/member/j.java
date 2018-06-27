package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes3.dex */
public class j implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dgo = BdUniqueId.gen();
    private r dgp;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dgo;
    }

    public r asy() {
        return this.dgp;
    }

    public void a(r rVar) {
        this.dgp = rVar;
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

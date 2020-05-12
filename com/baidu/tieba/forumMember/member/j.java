package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes10.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gUV = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private u gUW;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gUV;
    }

    public u bNd() {
        return this.gUW;
    }

    public void a(u uVar) {
        this.gUW = uVar;
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

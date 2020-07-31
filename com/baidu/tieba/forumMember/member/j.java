package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes17.dex */
public class j implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hBM = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private u hBN;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hBM;
    }

    public u bZQ() {
        return this.hBN;
    }

    public void a(u uVar) {
        this.hBN = uVar;
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

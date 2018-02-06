package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes3.dex */
public class j implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dBE = BdUniqueId.gen();
    private r dBF;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dBE;
    }

    public r atU() {
        return this.dBF;
    }

    public void a(r rVar) {
        this.dBF = rVar;
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

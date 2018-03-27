package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes3.dex */
public class j implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dBv = BdUniqueId.gen();
    private s dBw;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dBv;
    }

    public s atU() {
        return this.dBw;
    }

    public void a(s sVar) {
        this.dBw = sVar;
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

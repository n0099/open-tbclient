package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes3.dex */
public class j implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dBs = BdUniqueId.gen();
    private r dBt;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dBs;
    }

    public r atT() {
        return this.dBt;
    }

    public void a(r rVar) {
        this.dBt = rVar;
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

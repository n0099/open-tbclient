package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dgC = BdUniqueId.gen();
    private boolean dfl = false;
    private MemberGroupInfo dgD;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dgC;
    }

    public MemberGroupInfo asz() {
        return this.dgD;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dgD = memberGroupInfo;
    }

    public void fp(boolean z) {
        this.dfl = z;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}

package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId deL = BdUniqueId.gen();
    private boolean dds = false;
    private MemberGroupInfo deM;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return deL;
    }

    public MemberGroupInfo aso() {
        return this.deM;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.deM = memberGroupInfo;
    }

    public void fo(boolean z) {
        this.dds = z;
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

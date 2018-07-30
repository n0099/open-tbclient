package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId djs = BdUniqueId.gen();
    private boolean dib = false;
    private MemberGroupInfo djt;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return djs;
    }

    public MemberGroupInfo atd() {
        return this.djt;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.djt = memberGroupInfo;
    }

    public void fq(boolean z) {
        this.dib = z;
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

package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId djq = BdUniqueId.gen();
    private boolean dhZ = false;
    private MemberGroupInfo djr;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return djq;
    }

    public MemberGroupInfo atc() {
        return this.djr;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.djr = memberGroupInfo;
    }

    public void fq(boolean z) {
        this.dhZ = z;
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

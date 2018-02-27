package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dBG = BdUniqueId.gen();
    private boolean dAr = false;
    private MemberGroupInfo dBH;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dBG;
    }

    public MemberGroupInfo atU() {
        return this.dBH;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dBH = memberGroupInfo;
    }

    public void fE(boolean z) {
        this.dAr = z;
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

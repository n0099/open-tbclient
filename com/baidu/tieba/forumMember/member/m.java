package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dBS = BdUniqueId.gen();
    private boolean dAD = false;
    private MemberGroupInfo dBT;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dBS;
    }

    public MemberGroupInfo atV() {
        return this.dBT;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dBT = memberGroupInfo;
    }

    public void fE(boolean z) {
        this.dAD = z;
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

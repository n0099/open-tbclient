package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes10.dex */
public class ForumMemberReadCacheRequestMessage extends CustomMessage<Object> {
    private String forumName;

    public ForumMemberReadCacheRequestMessage() {
        super(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE);
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}

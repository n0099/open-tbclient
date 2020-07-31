package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes17.dex */
public class FrsGroupReadCacheRequestMessage extends CustomMessage<Object> {
    private String forumName;
    private int type;

    public FrsGroupReadCacheRequestMessage() {
        super(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}

package com.baidu.tieba.ala.livecard.models;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class FrsPageAlaTabRequestMessage extends HttpMessage {
    public String mForumId;
    public String mForumName;

    public FrsPageAlaTabRequestMessage(int i, String str, String str2, int i2) {
        super(i);
        this.mForumName = null;
        this.mForumId = null;
        this.mForumName = str;
        this.mForumId = str2;
        addParam("forum_name", str);
        addParam("forum_id", str2);
        addParam(Config.PACKAGE_NAME, i2);
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }
}

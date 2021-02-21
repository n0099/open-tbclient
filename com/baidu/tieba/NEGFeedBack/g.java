package com.baidu.tieba.NEGFeedBack;

import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
public class g {
    private cb akU;
    private ForumManageModel gev;
    private int type;

    public g(int i, ForumManageModel forumManageModel, cb cbVar) {
        this.type = i;
        this.gev = forumManageModel;
        this.akU = cbVar;
    }

    public int getType() {
        return this.type;
    }

    public cb bKw() {
        return this.akU;
    }

    public ForumManageModel bKx() {
        return this.gev;
    }
}

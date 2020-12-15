package com.baidu.tieba.NEGFeedBack;

import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes21.dex */
public class g {
    private by alu;
    private ForumManageModel fXd;
    private int type;

    public g(int i, ForumManageModel forumManageModel, by byVar) {
        this.type = i;
        this.fXd = forumManageModel;
        this.alu = byVar;
    }

    public int getType() {
        return this.type;
    }

    public by bLw() {
        return this.alu;
    }

    public ForumManageModel bLx() {
        return this.fXd;
    }
}

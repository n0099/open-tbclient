package com.baidu.tieba.NEGFeedBack;

import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
public class g {
    private bz ale;
    private ForumManageModel gca;
    private int type;

    public g(int i, ForumManageModel forumManageModel, bz bzVar) {
        this.type = i;
        this.gca = forumManageModel;
        this.ale = bzVar;
    }

    public int getType() {
        return this.type;
    }

    public bz bJX() {
        return this.ale;
    }

    public ForumManageModel bJY() {
        return this.gca;
    }
}

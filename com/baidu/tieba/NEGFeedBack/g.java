package com.baidu.tieba.NEGFeedBack;

import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
public class g {
    private bz alW;
    private ForumManageModel ggJ;
    private int type;

    public g(int i, ForumManageModel forumManageModel, bz bzVar) {
        this.type = i;
        this.ggJ = forumManageModel;
        this.alW = bzVar;
    }

    public int getType() {
        return this.type;
    }

    public bz bNP() {
        return this.alW;
    }

    public ForumManageModel bNQ() {
        return this.ggJ;
    }
}

package com.baidu.tieba.NEGFeedBack;

import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
public class g {
    private cb amn;
    private ForumManageModel gfY;
    private int type;

    public g(int i, ForumManageModel forumManageModel, cb cbVar) {
        this.type = i;
        this.gfY = forumManageModel;
        this.amn = cbVar;
    }

    public int getType() {
        return this.type;
    }

    public cb bKA() {
        return this.amn;
    }

    public ForumManageModel bKB() {
        return this.gfY;
    }
}

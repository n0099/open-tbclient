package com.baidu.tieba.data;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class c {
    private int ajr = 0;
    private int ajs = 0;

    public int yr() {
        return this.ajr;
    }

    public int ys() {
        return this.ajs;
    }

    public void a(Group group) {
        if (group != null) {
            this.ajr = group.group_count.intValue();
            this.ajs = group.hide_recommend_group.intValue();
        }
    }
}

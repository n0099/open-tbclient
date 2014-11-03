package com.baidu.tieba.data;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class c {
    private int ajA = 0;
    private int ajB = 0;

    public int yt() {
        return this.ajA;
    }

    public int yu() {
        return this.ajB;
    }

    public void a(Group group) {
        if (group != null) {
            this.ajA = group.group_count.intValue();
            this.ajB = group.hide_recommend_group.intValue();
        }
    }
}

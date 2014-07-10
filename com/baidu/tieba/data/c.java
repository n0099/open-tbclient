package com.baidu.tieba.data;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class c {
    private int a = 0;
    private int b = 0;

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public void a(Group group) {
        if (group != null) {
            this.a = group.group_count.intValue();
            this.b = group.hide_recommend_group.intValue();
        }
    }
}

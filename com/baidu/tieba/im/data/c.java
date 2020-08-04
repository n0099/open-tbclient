package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class c {
    private int iWT;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean csZ() {
        return this.iWT == 1;
    }

    public void yE(int i) {
        this.iWT = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cta() {
        return this.parent_menu;
    }

    public void dt(List<b> list) {
        this.parent_menu = list;
    }
}

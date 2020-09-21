package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class c {
    private int juC;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cHx() {
        return this.juC == 1;
    }

    public void Bz(int i) {
        this.juC = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cHy() {
        return this.parent_menu;
    }

    public void dI(List<b> list) {
        this.parent_menu = list;
    }
}

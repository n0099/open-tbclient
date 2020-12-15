package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class c {
    private int kql;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cVJ() {
        return this.kql == 1;
    }

    public void DY(int i) {
        this.kql = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cVK() {
        return this.parent_menu;
    }

    public void en(List<b> list) {
        this.parent_menu = list;
    }
}

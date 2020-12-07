package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class c {
    private int kqj;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cVI() {
        return this.kqj == 1;
    }

    public void DY(int i) {
        this.kqj = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cVJ() {
        return this.parent_menu;
    }

    public void en(List<b> list) {
        this.parent_menu = list;
    }
}

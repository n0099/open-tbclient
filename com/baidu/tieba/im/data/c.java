package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    private int kBa;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cXg() {
        return this.kBa == 1;
    }

    public void Ei(int i) {
        this.kBa = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cXh() {
        return this.parent_menu;
    }

    public void eu(List<b> list) {
        this.parent_menu = list;
    }
}

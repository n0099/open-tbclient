package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class c {
    private int jJz;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cLg() {
        return this.jJz == 1;
    }

    public void Cf(int i) {
        this.jJz = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cLh() {
        return this.parent_menu;
    }

    public void dL(List<b> list) {
        this.parent_menu = list;
    }
}

package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class c {
    private int kbV;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cQO() {
        return this.kbV == 1;
    }

    public void CL(int i) {
        this.kbV = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cQP() {
        return this.parent_menu;
    }

    public void ec(List<b> list) {
        this.parent_menu = list;
    }
}

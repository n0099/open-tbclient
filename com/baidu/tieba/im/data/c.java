package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    private int kEB;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cVm() {
        return this.kEB == 1;
    }

    public void CT(int i) {
        this.kEB = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cVn() {
        return this.parent_menu;
    }

    public void es(List<b> list) {
        this.parent_menu = list;
    }
}

package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int emk;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aIs() {
        return this.emk == 1;
    }

    public void nJ(int i) {
        this.emk = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aIt() {
        return this.parent_menu;
    }

    public void cf(List<b> list) {
        this.parent_menu = list;
    }
}

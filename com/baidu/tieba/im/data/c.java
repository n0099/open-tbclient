package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int eGA;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aOr() {
        return this.eGA == 1;
    }

    public void ps(int i) {
        this.eGA = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aOs() {
        return this.parent_menu;
    }

    public void ct(List<b> list) {
        this.parent_menu = list;
    }
}

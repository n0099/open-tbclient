package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class c {
    private int hxI;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bUf() {
        return this.hxI == 1;
    }

    public void wl(int i) {
        this.hxI = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bUg() {
        return this.parent_menu;
    }

    public void cP(List<b> list) {
        this.parent_menu = list;
    }
}

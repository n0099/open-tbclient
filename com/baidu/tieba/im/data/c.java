package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class c {
    private int hxU;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bUg() {
        return this.hxU == 1;
    }

    public void wl(int i) {
        this.hxU = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bUh() {
        return this.parent_menu;
    }

    public void cP(List<b> list) {
        this.parent_menu = list;
    }
}

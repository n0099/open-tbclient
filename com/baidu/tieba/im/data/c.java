package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class c {
    private int hxG;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bUd() {
        return this.hxG == 1;
    }

    public void wl(int i) {
        this.hxG = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bUe() {
        return this.parent_menu;
    }

    public void cP(List<b> list) {
        this.parent_menu = list;
    }
}

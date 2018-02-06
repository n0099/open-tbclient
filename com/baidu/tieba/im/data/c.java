package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int eBs;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aHT() {
        return this.eBs == 1;
    }

    public void pT(int i) {
        this.eBs = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aHU() {
        return this.parent_menu;
    }

    public void ca(List<b> list) {
        this.parent_menu = list;
    }
}

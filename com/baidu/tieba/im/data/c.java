package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int eQg;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aQW() {
        return this.eQg == 1;
    }

    public void pZ(int i) {
        this.eQg = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aQX() {
        return this.parent_menu;
    }

    public void cy(List<b> list) {
        this.parent_menu = list;
    }
}

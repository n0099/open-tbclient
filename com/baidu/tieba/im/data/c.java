package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int dXe;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aCQ() {
        return this.dXe == 1;
    }

    public void nq(int i) {
        this.dXe = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aCR() {
        return this.parent_menu;
    }

    public void bW(List<b> list) {
        this.parent_menu = list;
    }
}

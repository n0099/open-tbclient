package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int eir;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aHL() {
        return this.eir == 1;
    }

    public void nC(int i) {
        this.eir = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aHM() {
        return this.parent_menu;
    }

    public void cb(List<b> list) {
        this.parent_menu = list;
    }
}

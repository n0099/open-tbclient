package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int dWa;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aCS() {
        return this.dWa == 1;
    }

    public void nr(int i) {
        this.dWa = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aCT() {
        return this.parent_menu;
    }

    public void bT(List<b> list) {
        this.parent_menu = list;
    }
}

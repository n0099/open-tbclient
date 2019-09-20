package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int gGU;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bDv() {
        return this.gGU == 1;
    }

    public void vu(int i) {
        this.gGU = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bDw() {
        return this.parent_menu;
    }

    public void cR(List<b> list) {
        this.parent_menu = list;
    }
}

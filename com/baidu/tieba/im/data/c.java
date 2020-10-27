package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class c {
    private int jVY;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cOn() {
        return this.jVY == 1;
    }

    public void Cy(int i) {
        this.jVY = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cOo() {
        return this.parent_menu;
    }

    public void dU(List<b> list) {
        this.parent_menu = list;
    }
}

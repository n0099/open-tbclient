package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int gxX;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bzN() {
        return this.gxX == 1;
    }

    public void uN(int i) {
        this.gxX = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bzO() {
        return this.parent_menu;
    }

    public void cQ(List<b> list) {
        this.parent_menu = list;
    }
}

package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class c {
    private int ijo;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean ceY() {
        return this.ijo == 1;
    }

    public void wR(int i) {
        this.ijo = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> ceZ() {
        return this.parent_menu;
    }

    public void da(List<b> list) {
        this.parent_menu = list;
    }
}

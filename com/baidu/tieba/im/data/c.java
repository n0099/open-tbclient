package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private int kwv;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cTo() {
        return this.kwv == 1;
    }

    public void CC(int i) {
        this.kwv = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cTp() {
        return this.parent_menu;
    }

    public void eu(List<b> list) {
        this.parent_menu = list;
    }
}

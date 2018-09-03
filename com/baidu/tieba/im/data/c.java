package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int epZ;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aJq() {
        return this.epZ == 1;
    }

    public void nX(int i) {
        this.epZ = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aJr() {
        return this.parent_menu;
    }

    public void cf(List<b> list) {
        this.parent_menu = list;
    }
}

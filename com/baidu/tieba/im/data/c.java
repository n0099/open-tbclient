package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int eqd;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aJt() {
        return this.eqd == 1;
    }

    public void nX(int i) {
        this.eqd = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aJu() {
        return this.parent_menu;
    }

    public void cf(List<b> list) {
        this.parent_menu = list;
    }
}

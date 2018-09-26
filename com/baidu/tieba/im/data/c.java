package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int exs;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aLF() {
        return this.exs == 1;
    }

    public void oB(int i) {
        this.exs = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aLG() {
        return this.parent_menu;
    }

    public void cg(List<b> list) {
        this.parent_menu = list;
    }
}

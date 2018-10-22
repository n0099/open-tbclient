package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int eFh;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aOU() {
        return this.eFh == 1;
    }

    public void oZ(int i) {
        this.eFh = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aOV() {
        return this.parent_menu;
    }

    public void cv(List<b> list) {
        this.parent_menu = list;
    }
}

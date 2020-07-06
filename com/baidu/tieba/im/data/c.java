package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class c {
    private int iPO;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cpu() {
        return this.iPO == 1;
    }

    public void yj(int i) {
        this.iPO = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cpv() {
        return this.parent_menu;
    }

    public void dn(List<b> list) {
        this.parent_menu = list;
    }
}

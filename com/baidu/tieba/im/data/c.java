package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private int kGR;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cVA() {
        return this.kGR == 1;
    }

    public void CW(int i) {
        this.kGR = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cVB() {
        return this.parent_menu;
    }

    public void es(List<b> list) {
        this.parent_menu = list;
    }
}

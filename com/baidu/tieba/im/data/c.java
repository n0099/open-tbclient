package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class c {
    private int iyJ;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean clE() {
        return this.iyJ == 1;
    }

    public void xz(int i) {
        this.iyJ = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> clF() {
        return this.parent_menu;
    }

    public void cZ(List<b> list) {
        this.parent_menu = list;
    }
}

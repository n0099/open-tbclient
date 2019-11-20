package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int gEb;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bAd() {
        return this.gEb == 1;
    }

    public void tY(int i) {
        this.gEb = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bAe() {
        return this.parent_menu;
    }

    public void de(List<b> list) {
        this.parent_menu = list;
    }
}

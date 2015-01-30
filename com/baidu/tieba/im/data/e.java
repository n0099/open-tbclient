package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private long aXV;
    private int aXW;
    private List<d> parent_menu = new ArrayList();

    public boolean MJ() {
        return this.aXW == 1;
    }

    public void fH(int i) {
        this.aXW = i;
    }

    public long MK() {
        return this.aXV;
    }

    public void T(long j) {
        this.aXV = j;
    }

    public List<d> ML() {
        return this.parent_menu;
    }

    public void ao(List<d> list) {
        this.parent_menu = list;
    }
}

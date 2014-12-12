package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private long aWB;
    private int aWC;
    private List<c> parent_menu = new ArrayList();

    public boolean Mn() {
        return this.aWC == 1;
    }

    public void fC(int i) {
        this.aWC = i;
    }

    public long Mo() {
        return this.aWB;
    }

    public void T(long j) {
        this.aWB = j;
    }

    public List<c> Mp() {
        return this.parent_menu;
    }

    public void am(List<c> list) {
        this.parent_menu = list;
    }
}

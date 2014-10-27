package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private long aUV;
    private int aUW;
    private List<f> parent_menu = new ArrayList();

    public boolean Mq() {
        return this.aUW == 1;
    }

    public void fz(int i) {
        this.aUW = i;
    }

    public long Mr() {
        return this.aUV;
    }

    public void M(long j) {
        this.aUV = j;
    }

    public List<f> Ms() {
        return this.parent_menu;
    }

    public void R(List<f> list) {
        this.parent_menu = list;
    }
}

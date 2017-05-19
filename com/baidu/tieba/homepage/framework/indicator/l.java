package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.v;
/* loaded from: classes.dex */
public class l {
    private int cub = -1;
    private boolean cuc = false;
    private boolean cud = false;

    public void a(v vVar) {
        this.cuc = true;
        if (this.cub != -1 && this.cud) {
            vVar.jF(this.cub);
        }
    }

    public void a(int i, v vVar) {
        this.cub = i;
        if (this.cuc && this.cud) {
            vVar.jF(this.cub);
        }
    }

    public void b(v vVar) {
        this.cud = true;
        if (this.cub != -1 && this.cuc) {
            vVar.jF(this.cub);
        }
    }
}
